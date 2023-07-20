package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;

public class AttributeModule extends CharacterModule {
    private int creationBaseAttributePoints;
    private String[] creationAvailableRaceOptions;

    @Override
    public void UpdateEvent() {
        super.UpdateEvent();
    }

    public void processAttributesPriorityOption(Object attributePointValue) {
        creationBaseAttributePoints = (int) attributePointValue;
    }

    public void processRacePriorityOption(Object raceOptions) {
        creationAvailableRaceOptions = (String[]) raceOptions;
    }

    public int getCreationBaseAttributePoints() {
        return creationBaseAttributePoints;
    }

    public String[] getCreationAvailableRaceOptions() {
        return creationAvailableRaceOptions;
    }
}
