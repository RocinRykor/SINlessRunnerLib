package studio.rrprojects.srl.creation.metatype;

import org.json.JSONObject;
import studio.rrprojects.srl.constants.FileConstants;
import studio.rrprojects.util_library.DebugUtils;
import studio.rrprojects.util_library.FileUtil;

import java.util.HashMap;

public class MetatypeController {

    public enum CONST {
        HUMAN("Human"),
        DWARF("Dwarf"),
        ORK("Ork"),
        ELF("Elf"),
        TROLL("Troll");

        private final String text;
        CONST(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    //Constants from JSON DATA
    private final static String HUMAN = "human";
    private final static String DWARF = "dwarf";
    private final static String ORK = "ork";
    private final static String ELF = "elf";
    private final static String TROLL = "troll";

    private HashMap<String, Object> metatypeElementMap = new HashMap<>();
    private JSONObject metatypesJSON;


    public MetatypeController() {
        LoadMetatypesFile();

        for (String metatypeName : metatypesJSON.keySet()) {
            JSONObject jsonObject = metatypesJSON.getJSONObject(metatypeName);
            Metatype metatype = new Metatype(metatypeName, jsonObject);

            DebugUtils.ProgressNormalMsg(metatype.toString());
        }

    }

    private void LoadMetatypesFile() {
        String filePath =  FileConstants.METATYPES_JSON;
        DebugUtils.ProgressNormalMsg("Loading MetaTypes");

        try {
            metatypesJSON = FileUtil.getJsonFromResource(filePath);
//            DebugUtils.ProgressNormalMsg("Loaded Priority Table");
        } catch (NullPointerException e) {
//            DebugUtils.ErrorMsg("FAILURE! - " + e);
        }

    }
}
