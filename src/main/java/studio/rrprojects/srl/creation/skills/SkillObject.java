package studio.rrprojects.srl.creation.skills;

import org.json.JSONObject;
import studio.rrprojects.srl.keywords.AttributeKeywords;
import studio.rrprojects.util_library.JSONUtil;
import studio.rrprojects.util_library.TextUtils;

import java.util.ArrayList;

public class SkillObject {
    private String skillType;
    private String skillName;
    private String baseAttribute;
    private String linkedAttribute;
    private boolean isBuildRepairAvailable;
    private String defaults;
    private String description;
    private String source;
    private ArrayList<String> availableSpecializations;
    private String category;
    private int baseLevel;
    private int actualLevel;
//    private ArrayList<SpecializationContainer> selectedSpecializations;

    public SkillObject(String skillName, String skillType) {
        this.skillName = TextUtils.titleCase(skillName);
        this.skillType = TextUtils.titleCase(skillType);
    }

    public void processJSONObject(JSONObject skill) {
        baseAttribute = TextUtils.titleCase(JSONUtil.getString(skill, "attribute", AttributeKeywords.INTELLIGENCE));
        linkedAttribute = baseAttribute;

        isBuildRepairAvailable = JSONUtil.getBool(skill, "build_repair", false);

        defaults = TextUtils.titleCase(JSONUtil.getString(skill, "defaults", "None"));
        description = skill.getString("description");
        source = skill.getString("source");

        String specializationString = TextUtils.titleCase(JSONUtil.getString(skill, "specialization", ""));
//        availableSpecializations = processSpecializationString(specializationString);

        category = TextUtils.titleCase(skill.getString("category"));

//        selectedSpecializations = new ArrayList<>();

        baseLevel = JSONUtil.getInt(skill, "value", 1);
    }

    public String getCategory() {
        //TODO IMPLEMENT
        return null;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    @Override
    public String toString() {
        return "SkillObject{" +
                "skillName='" + skillName + '\'' +
                ", skillType='" + skillType + '\'' +
                '}';
    }
}
