package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;
import studio.rrprojects.srl.creation.metatype.Metatype;

public class AttributeModule extends CharacterModule {
    private int creationBaseAttributePoints;
    private String[] creationAvailableRaceOptions;

    private Metatype selectedMetaType = null;

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

    public Metatype getSelectedMetaType() {
        return selectedMetaType;
    }

    public void setSelectedMetaType(Metatype selectedMetaType) {
        this.selectedMetaType = selectedMetaType;
    }
}
