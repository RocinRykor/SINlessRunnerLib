package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;
import studio.rrprojects.srl.keywords.MagicKeywords;

public class MagicModule extends CharacterModule {
    private String[] creationAvailableMagicOptions;
    private Boolean isAwakened = true;

    public void processPriorityOption(Object magicOptions) {
        creationAvailableMagicOptions = (String[]) magicOptions;


        for (String option : creationAvailableMagicOptions) {
            if (option.equalsIgnoreCase(MagicKeywords.MUNDANE)) {
                isAwakened = false;
            }
        }
    }

    public Boolean getAwakened() {
        return isAwakened;
    }
}
