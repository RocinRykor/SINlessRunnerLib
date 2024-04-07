package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;
import studio.rrprojects.srl.creation.skills.OwnedSkill;

import java.util.ArrayList;

public class SkillsModule extends CharacterModule {
    private int creationBaseSkillPoints;
    private ArrayList<OwnedSkill> ownedSkillsList = new ArrayList<>();

    public void processPriorityOption(Object skillPointValue) {
        creationBaseSkillPoints = (int) skillPointValue;


    }

    public Boolean addOwnedSkillToCharacter(OwnedSkill ownedSkill) {
        if (ownedSkillsList.add(ownedSkill)) {
            return true;
        }

        return false;
    }

    public ArrayList<OwnedSkill> getOwnedSkillsList() {
        return ownedSkillsList;
    }
}
