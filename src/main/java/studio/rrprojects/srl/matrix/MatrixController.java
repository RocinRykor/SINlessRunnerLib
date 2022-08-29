package studio.rrprojects.srl.matrix;

import org.json.JSONObject;
import studio.rrprojects.srl.constants.FileConstants;
import studio.rrprojects.srl.matrix.utilities.*;
import studio.rrprojects.util_library.FileUtil;
import studio.rrprojects.util_library.JSONUtil;

import java.util.ArrayList;
import java.util.List;

public class MatrixController {
    public enum DECK_MODELS {
        ALLEGIANCE_SIGMA("Allegiance Sigma"),
        SONY_CTY("Sony CTY-360–D"),
        NOVATECH_HYPERDECK("Novatech Hyperdeck–6"),
        CMT_AVATAR("CMT Avatar"),
        RENRAKU_KRAFTWERK("Renraku Kraftwerk-8"),
        TRANSYS_HIGHLANDER("Transys Highlander"),
        NOVATECH_SLIMCASE("Novatech Slimcase-10"),
        FAIRLIGHT_EXCALIBUR("Fairlight Excalibur");

        private final String text;
        DECK_MODELS(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }

        public static int getValue(String string) {
            for (DECK_MODELS deck_model: DECK_MODELS.values()) {
                if (deck_model.toString().equalsIgnoreCase(string)) {
                    return deck_model.ordinal();
                }
            }

            return -1;
        }
    }

    private final JSONObject jsonCyberdecks = FileUtil.getJsonFromResource(FileConstants.CYBERDECK_JSON);;
    private final JSONObject jsonCyberdeckUtils = FileUtil.getJsonFromResource(FileConstants.CYBERDECK_UTILITIES);
    private List<String> listDeckNameOfficial = new ArrayList<>();
    private List<CyberDeckUtility> masterListCyberdeckUtilities = new ArrayList<>();

    public MatrixController() {
        PopulateCyberdeckList();
        PopulateCyberdeckUtilities();
    }

    private void PopulateCyberdeckUtilities() {
        jsonCyberdeckUtils.keySet().forEach(key -> {
            JSONObject jsonOnj = jsonCyberdeckUtils.getJSONObject(key);
            masterListCyberdeckUtilities.add(processCyberdeckUtility(key, jsonOnj));
        });
    }

    private CyberDeckUtility processCyberdeckUtility(String name, JSONObject jsonObject) {
        String utilityType = jsonObject.getString("type");

        if (utilityType.equalsIgnoreCase(CyberDeckUtility.TYPE_OPERATIONAL)) {
            return new OperationalUtility(name, jsonObject);
        } else if (utilityType.equalsIgnoreCase(CyberDeckUtility.TYPE_SPECIAL)) {
            return new SpecialUtility(name, jsonObject);
        } else if (utilityType.equalsIgnoreCase(CyberDeckUtility.TYPE_OFFENSIVE)) {
            return new OffensiveUtility(name, jsonObject);
        } else if (utilityType.equalsIgnoreCase(CyberDeckUtility.TYPE_DEFENSIVE)) {
            return new DefensiveUtility(name, jsonObject);
        } else {
            return new CyberDeckUtility(name, jsonObject);
        }

    }

    private void PopulateCyberdeckList() {
        for (DECK_MODELS deck_model: DECK_MODELS.values()) {
            listDeckNameOfficial.add(deck_model.toString());
        }
    }

    public List<String> getListDeckNameOfficial() {
        return listDeckNameOfficial;
    }

    public CyberDeck getCyberDeckFromModel(String model) {
        JSONObject tmpJSON = JSONUtil.getJSONObject(jsonCyberdecks, model, null);
        if (tmpJSON == null) {
            return null;
        }
        return CyberDeck.NewDeckFromJSON(model, tmpJSON);
    }

    public List<CyberDeckUtility> getMasterListCyberdeckUtilities() {
        return masterListCyberdeckUtilities;
    }
}
