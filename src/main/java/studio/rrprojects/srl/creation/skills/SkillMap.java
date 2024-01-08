package studio.rrprojects.srl.creation.skills;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SkillMap {
    private final String skillType;
    private final ArrayList<SkillObject> listSkillsMaster;
    private final HashMap<String, ArrayList<SkillObject>> mapSkillsByCategory;

    public SkillMap(JSONObject jsonObject, String skillType) {
        this.skillType = skillType;

        listSkillsMaster = new ArrayList<>();
        mapSkillsByCategory = new LinkedHashMap<>();

        for (String skillName: jsonObject.keySet()) {
            JSONObject skill = jsonObject.getJSONObject(skillName);

            SkillObject skillObject = new SkillObject(skillName, skillType);
            skillObject.processJSONObject(skill);

            String category = skillObject.getCategory();

            if (!mapSkillsByCategory.containsKey(category)) {
                mapSkillsByCategory.put(category, new ArrayList<>());
            }

            mapSkillsByCategory.get(category).add(skillObject);

            listSkillsMaster.add(skillObject);
        }

        SortEverything(); //Finish up by sorting the lists
    }

    private void SortEverything() {
        Comparator<SkillObject> compareBySkillName = Comparator.comparing(SkillObject::getSkillName);

        listSkillsMaster.sort(compareBySkillName);

        for (String skillCategory: mapSkillsByCategory.keySet()) {
            ArrayList<SkillObject> categoryList = mapSkillsByCategory.get(skillCategory);
            categoryList.sort(compareBySkillName);
        }

    }

    public String getSkillType() {
        return skillType;
    }

    public ArrayList<SkillObject> getListSkillsMaster() {
        return listSkillsMaster;
    }

    public HashMap<String, ArrayList<SkillObject>> getMapSkillsByCategory() {
        return mapSkillsByCategory;
    }

}
