package studio.rrprojects.srl.creation.character.modules;

import studio.rrprojects.srl.creation.character.CharacterModule;
import studio.rrprojects.srl.creation.metatype.Metatype;
import studio.rrprojects.srl.keywords.AttributeKeywords;

import java.util.HashMap;
import java.util.Map;

public class AttributeModule extends CharacterModule {
    private int creationBaseAttributePoints;
    private String[] creationAvailableRaceOptions;

    private Metatype selectedMetaType = null;

    private Map<String, Integer> selectedAttributeCollection;

    public AttributeModule() {
        selectedAttributeCollection = new HashMap<>();
        selectedAttributeCollection.put(AttributeKeywords.BODY, 1);
        selectedAttributeCollection.put(AttributeKeywords.QUICKNESS, 1);
        selectedAttributeCollection.put(AttributeKeywords.STRENGTH, 1);
        selectedAttributeCollection.put(AttributeKeywords.WILLPOWER, 1);
        selectedAttributeCollection.put(AttributeKeywords.INTELLIGENCE, 1);
        selectedAttributeCollection.put(AttributeKeywords.CHARISMA, 1);
        selectedAttributeCollection.put((AttributeKeywords.ESSENCE), 6);
        selectedAttributeCollection.put((AttributeKeywords.MAGIC), 0);
        selectedAttributeCollection.put((AttributeKeywords.REACTION), 1);
    }

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

    public int getSelectedAttributeValueByName(String attributeKeyword) {
        return selectedAttributeCollection.get(attributeKeyword);
    }

    public void updateSelectedAttributeByName(String attributeKeyword, int newValue) {
        selectedAttributeCollection.replace(attributeKeyword, newValue);
    }
}
