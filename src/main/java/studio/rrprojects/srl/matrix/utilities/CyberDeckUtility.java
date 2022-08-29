package studio.rrprojects.srl.matrix.utilities;

import org.json.JSONObject;

public class CyberDeckUtility {
    public enum CONST {
        NAME("Name"),
        TYPE("Type"),
        PROGRAM_RATING("Program Rating"),
        MULTIPLIER("Multiplier"),
        TARGET("Target"),
        SYSTEM_OPERATIONS("System Operations"),
        DESCRIPTION("Description"),
        COST("Cost");

        private final String text;
        CONST(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private final String name;
    private final String type;
    private final int multiplier;
    private final String description;
    private int rating;
    private int cost;

    //Utility Type Constants
    public final static String TYPE_OPERATIONAL = "Operational";
    public final static String TYPE_SPECIAL = "Special";
    public final static String TYPE_OFFENSIVE = "Offensive";
    public final static String TYPE_DEFENSIVE = "Defensive";

    public CyberDeckUtility(String name, JSONObject jsonObject) {
        this.name = name;
        this.type = jsonObject.getString(CONST.TYPE.toString().toLowerCase());
        this.multiplier = jsonObject.getInt(CONST.MULTIPLIER.toString().toLowerCase());
        this.description = jsonObject.getString(CONST.DESCRIPTION.toString().toLowerCase());
    }

    public CyberDeckUtility(String name, String type, int multiplier, String description) {
        this.name = name;
        this.type = type;
        this.multiplier = multiplier;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " - " + type + " Utility\n" +
                "Multiplier: " + multiplier +"\n" +
                "Description: " + description;
    }
}
