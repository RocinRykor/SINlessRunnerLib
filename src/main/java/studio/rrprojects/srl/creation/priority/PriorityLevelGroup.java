package studio.rrprojects.srl.creation.priority;

import org.json.JSONObject;
import studio.rrprojects.util_library.DebugUtils;

public class PriorityLevelGroup {
    public PriorityLevelGroup(String key, JSONObject jsonObject) {


        //DEBUG
        DebugUtils.ProgressNormalMsg(getClass().getSimpleName() + " - Key: " + key + " | JSON: " + jsonObject.toString());
    }
}
