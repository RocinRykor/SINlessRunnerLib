package studio.rrprojects.srl.keywords;

import java.util.Arrays;

public class AttributeKeywords {

    //ATTRIBUTES
    public static final String BODY = "Body";
    public static final String QUICKNESS = "Quickness";
    public static final String STRENGTH = "Strength";
    public static final String CHARISMA = "Charisma";
    public static final String INTELLIGENCE = "Intelligence";
    public static final String WILLPOWER = "Willpower";
    public static final String ESSENCE = "Essence";
    public static final String MAGIC = "Magic";
    public static final String REACTION = "Reaction";

    public static final String[] PHYSICAL_ATTRIBUTES = {BODY,QUICKNESS, STRENGTH};
    public static final String[] MENTAL_ATTRIBUTES = {CHARISMA, INTELLIGENCE, WILLPOWER};
    public static final String[] SPECIAL_ATTRIBUTES = {ESSENCE, MAGIC, REACTION};

    public static final String[] BASE_ATTRIBUTES = concatenateArrays(PHYSICAL_ATTRIBUTES, MENTAL_ATTRIBUTES);
    public static final String[] ALL_ATTRIBUTES = concatenateArrays(BASE_ATTRIBUTES, SPECIAL_ATTRIBUTES);

    private static String[] concatenateArrays(String[] array1, String[] array2) {
        String[] result = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
}