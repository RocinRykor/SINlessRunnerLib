package studio.rrprojects.srl.creation.skills;

import studio.rrprojects.srl.keywords.AttributeKeywords;

import java.util.ArrayList;

public class OwnedSkill extends SkillObject {
    private Boolean isBuildRepair = false;
    private ArrayList<SpecializationObject> specializationList = new ArrayList<>();
    int skillLevel = 1;
    int creationBaseLevel = 1;


    public OwnedSkill(SkillObject originalSkill) {

        // Clone the SkillObject and assign it
        super(originalSkill.getSkillName(), originalSkill.getSkillType());
        super.cloneFromExistingSkill(originalSkill);
    }

    public void processSkill(int creationBaseLevel, Boolean isBuildRepair, boolean isSpecialized, String specialization) {
        // As of right now, this is a creation specific function
        this.creationBaseLevel = creationBaseLevel;

        this.isBuildRepair = isBuildRepair;
        if (isBuildRepair) {
            super.setLinkedAttribute(AttributeKeywords.INTELLIGENCE);
        }

        if (isSpecialized) {
            skillLevel = creationBaseLevel-1;
            specializationList.clear();
            specializationList.add(new SpecializationObject(specialization, creationBaseLevel+1));
        } else {
            skillLevel = creationBaseLevel;
        }
    }

    @Override
    public String toString() {
        String output = "";
        if (isBuildRepair) {
            output += "B/R ";
        }

        output += super.getSkillName() + " (" + skillLevel + ")";

        if (specializationList.size() > 0) {
            output += ", ";
            for (SpecializationObject specializationObject : specializationList) {
                output += specializationObject;
            }

        }

        return output;
    }

    public Boolean getBuildRepair() {
        return isBuildRepair;
    }

    public ArrayList<SpecializationObject> getSpecializationList() {
        return specializationList;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public int getCreationBaseLevel() {
        return creationBaseLevel;
    }

    public int calculateCreationCost(int attributeScore) {
        int baseValue = creationBaseLevel;
        if (baseValue <= attributeScore) {
            return baseValue;
        } else {
            int remainder = baseValue - attributeScore;
            return attributeScore + (remainder * 2);
        }
    }
}
