package studio.rrprojects.srl.creation.skills;

import org.json.JSONObject;
import studio.rrprojects.srl.keywords.AttributeKeywords;
import studio.rrprojects.util_library.JSONUtil;
import studio.rrprojects.util_library.TextUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

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

    public SkillObject(String skillName, String skillType) {
        this.skillName = TextUtils.titleCase(skillName);
        this.skillType = TextUtils.titleCase(skillType);
    }

    public void cloneFromExistingSkill(SkillObject skillObject) {
        this.skillName = skillObject.getSkillName();
        this.skillType = skillObject.getSkillType();
        this.baseAttribute = skillObject.getBaseAttribute();
        this.linkedAttribute = skillObject.getLinkedAttribute();
        this.isBuildRepairAvailable = skillObject.isBuildRepairAvailable();
        this.defaults = skillObject.getDefaults();
        this.description = skillObject.getDescription();
        this.source = skillObject.getSource();
        this.availableSpecializations = skillObject.getAvailableSpecializations();
        this.category = skillObject.getCategory();
    }

    public void processJSONObject(JSONObject skill) {
        baseAttribute = TextUtils.titleCase(JSONUtil.getString(skill, "attribute", AttributeKeywords.INTELLIGENCE));
        linkedAttribute = baseAttribute;

        isBuildRepairAvailable = JSONUtil.getBool(skill, "build_repair", false);

        defaults = TextUtils.titleCase(JSONUtil.getString(skill, "defaults", "None"));
        description = skill.getString("description");
        source = skill.getString("source");

        String specializationString = TextUtils.titleCase(JSONUtil.getString(skill, "specialization", ""));
        availableSpecializations = processSpecializationString(specializationString);

        category = TextUtils.titleCase(skill.getString("category"));
    }

    private ArrayList<String> processSpecializationString(String string) {
        ArrayList<String> tmp = new ArrayList<>();

        String[] splitString = string.split(", ");

        if (splitString[0].length() > 0) {
            Collections.addAll(tmp, splitString);
        }

        tmp.add("-> Custom");
        return tmp;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getSkillType() {
        return skillType;
    }

    public String getBaseAttribute() {
        return baseAttribute;
    }

    public String getLinkedAttribute() {
        return linkedAttribute;
    }

    public void setLinkedAttribute(String linkedAttribute) {
        this.linkedAttribute = linkedAttribute;
    }

    public boolean isBuildRepairAvailable() {
        return isBuildRepairAvailable;
    }

    public String getDefaults() {
        return defaults;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public ArrayList<String> getAvailableSpecializations() {
        return availableSpecializations;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return skillName;
    }

    public String debugString() {
        return "SkillObject{" +
                "skillName='" + skillName + '\'' +
                ", skillType='" + skillType + '\'' +
                '}';
    }

    public String getTextAreaDisplay() {
        return "Skill Name: " + skillName + ", " +
                "Category: " + category +"\n" +
                "Linked Attribute: " + linkedAttribute +", " +
                "B/R: " + TextUtils.titleCase(String.valueOf(isBuildRepairAvailable)) + "\n" +
                "Defaults: " + defaults +"\n\n" +
                "Description: " + description + "\n\n" +
                "Source: " + source;
    }
}
