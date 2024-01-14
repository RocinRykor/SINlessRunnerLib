package studio.rrprojects.srl.creation.skills;

import org.json.JSONObject;
import studio.rrprojects.srl.constants.FileConstants;
import studio.rrprojects.srl.keywords.SkillsKeywords;
import studio.rrprojects.util_library.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class SkillsController {

    /*
    Used to create a list of available skills for adding to a character.
    A character's actual selected skills will be managed from the SkillsModule
     */

    private JSONObject activeSkillsJSON;
    private JSONObject knowledgeSkillsJSON;
    private JSONObject languageSkillsJSON;
    private ArrayList<Object> skillGroupList = new ArrayList<>();
    private LinkedHashMap<String, SkillMap> masterSkillMap = new LinkedHashMap<>();

    public SkillsController() {
        loadSkillsFile();

        createSkillGroups();

        createSkillMap();
    }

    private void loadSkillsFile() {
        //Create JSONObjects from each associated resource file
        activeSkillsJSON = FileUtil.getJsonFromResource(FileConstants.SKILLS_ACTIVE_JSON);
        knowledgeSkillsJSON = FileUtil.getJsonFromResource(FileConstants.SKILLS_KNOWLEDGE_JSON);
        languageSkillsJSON = FileUtil.getJsonFromResource(FileConstants.SKILLS_LANGUAGE_JSON);
    }

    private void createSkillGroups() {
        // Skill Groups will determine what categories belong to each type of skill,
        // ie Active Skills have Combat, Technical, Physical, etc.
        // Does not contain actual skills, used to cross-reference
        skillGroupList.add(new SkillGroup(SkillsKeywords.ACTIVE, SkillsKeywords.ACTIVE_SUBCATEGORIES));
        skillGroupList.add(new SkillGroup(SkillsKeywords.KNOWLEDGE, SkillsKeywords.KNOWLEDGE_SUBCATEGORIES));
        skillGroupList.add(new SkillGroup(SkillsKeywords.LANGUAGE));
    }

    private void createSkillMap() {
        masterSkillMap.put(SkillsKeywords.ACTIVE, new SkillMap(activeSkillsJSON, SkillsKeywords.ACTIVE));
        masterSkillMap.put(SkillsKeywords.KNOWLEDGE, new SkillMap(knowledgeSkillsJSON, SkillsKeywords.KNOWLEDGE));
        masterSkillMap.put(SkillsKeywords.LANGUAGE, new SkillMap(languageSkillsJSON, SkillsKeywords.LANGUAGE));
    }

    private class SkillGroup {
        private final String skillType;
        private final String[] categories;
        private final boolean hasCategories;

        private SkillGroup(String skillType, String[] categories) {
            this.skillType = skillType;
            this.categories = categories;
            this.hasCategories = true;
        }

        private SkillGroup (String skillType) {
            this.skillType = skillType;
            this.categories = null;
            hasCategories = false;
        }

        public String getSkillType() {
            return skillType;
        }

        public String[] getCategories() {
            return categories;
        }

        public boolean isHasCategories() {
            return hasCategories;
        }

        @Override
        public String toString() {
            return "SkillGroup{" +
                    "skillType='" + skillType + '\'' +
                    ", categories=" + Arrays.toString(categories) +
                    ", hasCategories=" + hasCategories +
                    '}';
        }
    }

    public JSONObject getActiveSkillsJSON() {
        return activeSkillsJSON;
    }

    public JSONObject getKnowledgeSkillsJSON() {
        return knowledgeSkillsJSON;
    }

    public JSONObject getLanguageSkillsJSON() {
        return languageSkillsJSON;
    }

    public ArrayList<Object> getSkillGroupList() {
        return skillGroupList;
    }

    public LinkedHashMap<String, SkillMap> getMasterSkillMap() {
        return masterSkillMap;
    }
}
