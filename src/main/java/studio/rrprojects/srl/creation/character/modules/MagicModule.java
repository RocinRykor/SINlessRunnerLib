package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;

public class MagicModule extends CharacterModule {
    private String[] creationAvailableMagicOptions;

    public void processPriorityOption(Object magicOptions) {
        creationAvailableMagicOptions = (String[]) magicOptions;
    }
}
