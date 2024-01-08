package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;

public class SkillsModule extends CharacterModule {
    private int creationBaseSkillPoints;

    public void processPriorityOption(Object skillPointValue) {
        creationBaseSkillPoints = (int) skillPointValue;


    }
}
