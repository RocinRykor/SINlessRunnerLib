package studio.rrprojects.srl.creation.priority;

import org.json.JSONObject;
import studio.rrprojects.srl.constants.FileConstants;
import studio.rrprojects.srl.creation.priority.element.PriorityElement;
import studio.rrprojects.util_library.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class PriorityController {
    private JSONObject priorityJson;
    private final HashMap<String, PriorityLevelGroup> levelPriorityMap = new HashMap<>();
    private final HashMap<String, ArrayList<PriorityElement>> categoryPriorityMap = new HashMap<>();

    public PriorityController() {
        LoadPriorityFile();
        PopulatePriorityMap();

        for (String key: levelPriorityMap.keySet()) {
            HashMap<String, PriorityElement> elementMap = levelPriorityMap.get(key).getPriorityElementTable();
            for (String elementKey : elementMap.keySet()) {
                if (!categoryPriorityMap.containsKey(elementKey)) {
                    categoryPriorityMap.put(elementKey, new ArrayList<>());
                }

                categoryPriorityMap.get(elementKey).add(elementMap.get(elementKey));
            }
        }

        System.out.println(categoryPriorityMap);
    }

    private void PopulatePriorityMap() {
        priorityJson.keySet().forEach(priorityLevelKey -> {
            String Key = priorityLevelKey.toUpperCase();

            PriorityLevelGroup priorityLevelGroup = new PriorityLevelGroup(Key, priorityJson.getJSONObject(priorityLevelKey));

            levelPriorityMap.put(Key, priorityLevelGroup);
        });
    }

    private void LoadPriorityFile() {
        String filePath =  FileConstants.PRIORITY_TABLE_JSON;
//        DebugUtils.ProgressNormalMsg("Loading Priority Table");

        try {
            priorityJson = FileUtil.getJsonFromResource(filePath);
//            DebugUtils.ProgressNormalMsg("Loaded Priority Table");
        } catch (NullPointerException e) {
//            DebugUtils.ErrorMsg("FAILURE! - " + e);
        }

    }

    /**
     * Returns a priority map using the priority levels (A-E) as the key, map value is PriorityLevelGroup
     * @return HashMap
     */
    public HashMap<String, PriorityLevelGroup> getLevelPriorityMap() {
        return levelPriorityMap;
    }

    /**
     * Returns a priority map using the priority category (Magic, Race, Skills, Attributes, Resources) as the key, map value is an ArrayList containing the appropriate PriorityElements
     * @return HashMap
     */
    public HashMap<String, ArrayList<PriorityElement>> getCategoryPriorityMap() {
        return categoryPriorityMap;
    }
}


