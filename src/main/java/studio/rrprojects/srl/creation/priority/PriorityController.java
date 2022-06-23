package studio.rrprojects.srl.creation.priority;

import org.json.JSONArray;
import org.json.JSONObject;
import studio.rrprojects.srl.constants.FileConstants;
import studio.rrprojects.util_library.DebugUtils;
import studio.rrprojects.util_library.FileUtil;

import java.util.HashMap;

public class PriorityController {
    private JSONObject priorityJson;
    private final HashMap<String, PriorityLevelGroup> masterPriorityMap = new HashMap<>();

    public PriorityController() {
        LoadPriorityFile();
        PopulatePriorityMap();
    }

    private void PopulatePriorityMap() {
        priorityJson.keySet().forEach(priorityLevelKey -> {
            String Key = priorityLevelKey.toUpperCase();

            PriorityLevelGroup priorityLevelGroup = new PriorityLevelGroup(Key, priorityJson.getJSONObject(priorityLevelKey));

            masterPriorityMap.put(Key, priorityLevelGroup);
        });
    }

    private void LoadPriorityFile() {
        String filePath =  FileConstants.PRIORITY_TABLE_JSON;
        DebugUtils.ProgressNormalMsg("Loading Priority Table");

        try {
            priorityJson = FileUtil.getJsonFromResource(filePath);
            DebugUtils.ProgressNormalMsg("Loaded Priority Table");
        } catch (NullPointerException e) {
            DebugUtils.ErrorMsg("FAILURE! - " + e);
        }

    }

}


