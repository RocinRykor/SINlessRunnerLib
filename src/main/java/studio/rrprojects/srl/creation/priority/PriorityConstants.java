package studio.rrprojects.srl.creation.priority;

import studio.rrprojects.srl.FileConstants;

public class PriorityConstants {
    //Priority Terms
    public static final String RACE = "Race";
    public static final String MAGIC = "Magic";
    public static final String ATTRIBUTES = "Attributes";
    public static final String SKILLS = "Skills";
    public static final String RESOURCES = "Resources";

    //Combos
    public static final String[] PRIORITIES = {RACE, MAGIC, ATTRIBUTES, SKILLS, RESOURCES};

    //Resource Files
    //public static final String METATYPE_TABLE = "metatype_differences.json";
    public static final String PRIORITY_TABLE_FILE = FileConstants.RESOURCE_MISC + "CORE_Priority_Table.json";
}
