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
        this.creationBaseLevel = creationBaseLevel;

        this.isBuildRepair = isBuildRepair;
        if (isBuildRepair) {
            super.setLinkedAttribute(AttributeKeywords.INTELLIGENCE);
        }

        if (isSpecialized) {
            skillLevel = creationBaseLevel-1;
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

    private class SpecializationObject {
        private String specializationName;
        private int specializationLevel;

        public SpecializationObject(String specializationName, int specializationLevel) {
            this.specializationName = specializationName;
            this.specializationLevel = specializationLevel;
        }

        public String getSpecializationName() {
            return specializationName;
        }

        public int getSpecializationLevel() {
            return specializationLevel;
        }

        @Override
        public String toString() {
            return specializationName + " (" + specializationLevel + ")";
        }
    }
}
