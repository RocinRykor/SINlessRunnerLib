package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterContainer;
import studio.rrprojects.srl.creation.character.CharacterModule;
import studio.rrprojects.srl.creation.skills.OwnedSkill;

import java.util.ArrayList;

public class SkillsModule extends CharacterModule {
    private int creationBaseSkillPoints;
    private ArrayList<OwnedSkill> ownedSkillsList = new ArrayList<>();

    public void processPriorityOption(Object skillPointValue) {
        creationBaseSkillPoints = (int) skillPointValue;
    }

    public int getCreationSkillCost(CharacterContainer characterContainer, String skillType) {
        int tmp = 0;

        for (OwnedSkill ownedSkill : ownedSkillsList) {
            if (ownedSkill.getSkillType().equalsIgnoreCase(skillType)) {
                int attributeScore = characterContainer.getAttributeModule().getSelectedAttributeValueByName(ownedSkill.getLinkedAttribute());
                tmp += ownedSkill.calculateCreationCost(attributeScore);
            }
        }


        return tmp;
    }

    public Boolean addOwnedSkillToCharacter(OwnedSkill ownedSkill) {
        if (canBeAdded(ownedSkill)) {
            if (ownedSkillsList.add(ownedSkill)) {
                return true;
            }

            return false;
        }

        return false;
    }

    private boolean canBeAdded(OwnedSkill ownedSkill) {

        for (OwnedSkill skill : ownedSkillsList) {
            if (ownedSkill.getSkillName().equalsIgnoreCase(skill.getSkillName()) && ownedSkill.getBuildRepair() == skill.getBuildRepair()) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<OwnedSkill> getOwnedSkillsList() {
        return ownedSkillsList;
    }

    public int getCreationBaseSkillPoints() {
        return creationBaseSkillPoints;
    }
}
