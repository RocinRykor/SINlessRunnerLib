package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;

public class ResourcesModule extends CharacterModule {
    private int creationBaseResources;
    public void processPriorityOption(Object resourceValue) {
        creationBaseResources = (int) resourceValue;
    }
}
