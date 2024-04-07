package studio.rrprojects.srl.creation.character;

import studio.rrprojects.srl.creation.character.modules.*;

import java.util.ArrayList;
import java.util.HashMap;

public class CharacterContainer {
    private final ArrayList<CharacterModule> moduleList = new ArrayList<>();
    private AttributeModule attributeModule;
    private InformationModule informationModule;
    private SkillsModule skillsModule;
    private InventoryModule inventoryModule;
    private ResourcesModule resourcesModule;
    private CybergearModule cybergearModule;
    private VehicleModule vehicleModule;
    private CyberdeckModule cyberdeckModule;
    private MagicModule magicModule;

    /**
     * A CharacterContainer contains all the information for a character
     * Comprised of various Character Modules, each one contains information for things like skills, attributes, gear, etc
     * Create a new instance of the CharacterContainer, then pass it information to populate
     *
     * New Character: generateFromPriority(HashMap<Object, Object> priorityMap)
     * Existing Character: generateFromJSON(JSONObject characterJSON)
     */
    public CharacterContainer() {
        CharacterModule[] modules = {
                informationModule = new InformationModule(),
                attributeModule = new AttributeModule(),
                skillsModule = new SkillsModule(),
                inventoryModule = new InventoryModule(),
                resourcesModule = new ResourcesModule(),
                cybergearModule = new CybergearModule(),
                vehicleModule = new VehicleModule(),
                cyberdeckModule = new CyberdeckModule(),
                magicModule = new MagicModule()
        };

        // Add all modules to the moduleList
        for (CharacterModule module : modules) {
            moduleList.add(module);

            // Pass an instance of this class to allow for callbacks and communication between modules
            module.setCharacterContainer(this);
        }
    }

    /**
     * Populate the CharacterContainer with information needed in creating a new character starting with the priority selection
     * @param priorityMap - Priority selection for new character
     */
    public void generateFromPriority(HashMap<String, Object> priorityMap) {
        skillsModule.processPriorityOption(priorityMap.get("skills"));
        System.out.println("SKILLS PROCESSED");
        attributeModule.processAttributesPriorityOption(priorityMap.get("attributes"));
        System.out.println("ATTRIBUTES PROCESSED");
        attributeModule.processRacePriorityOption(priorityMap.get("race"));
        System.out.println("RACE PROCESSED");
        resourcesModule.processPriorityOption(priorityMap.get("resources"));
        System.out.println("RESOURCES PROCESSED");
        magicModule.processPriorityOption(priorityMap.get("magic"));
        System.out.println("MAGIC PROCESSED");
    }

    public AttributeModule getAttributeModule() {
        return attributeModule;
    }

    public InformationModule getInformationModule() {
        return informationModule;
    }

    public SkillsModule getSkillsModule() {
        return skillsModule;
    }

    public InventoryModule getInventoryModule() {
        return inventoryModule;
    }

    public ResourcesModule getResourcesModule() {
        return resourcesModule;
    }

    public CybergearModule getCybergearModule() {
        return cybergearModule;
    }

    public VehicleModule getVehicleModule() {
        return vehicleModule;
    }

    public CyberdeckModule getCyberdeckModule() {
        return cyberdeckModule;
    }

    public MagicModule getMagicModule() {
        return magicModule;
    }
}
