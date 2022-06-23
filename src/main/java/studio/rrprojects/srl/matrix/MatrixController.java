package studio.rrprojects.srl.matrix;

import org.json.JSONObject;
import studio.rrprojects.util_library.FileUtil;
import studio.rrprojects.util_library.JSONUtil;

import java.io.File;
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

    private final JSONObject jsonCyberDecks;
    private List<String> listDeckNameOfficial = new ArrayList<>();

    public MatrixController() {
        jsonCyberDecks = FileUtil.getJsonFromResource(File.separator + "JSON" + File.separator + "Matrix" + File.separator + "Cyberdeck.json");
        PopulateCyberDeckList();
    }

    private void PopulateCyberDeckList() {
        for (DECK_MODELS deck_model: DECK_MODELS.values()) {
            listDeckNameOfficial.add(deck_model.toString());
        }
    }

    public List<String> getListDeckNameOfficial() {
        return listDeckNameOfficial;
    }

    public CyberDeck getCyberDeckFromModel(String model) {
        JSONObject tmpJSON = JSONUtil.getJSONObject(jsonCyberDecks, model, null);
        if (tmpJSON == null) {
            return null;
        }
        return CyberDeck.NewDeckFromJSON(model, tmpJSON);
    }
}
