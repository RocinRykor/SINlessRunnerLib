package studio.rrprojects.srl.matrix.utilities;

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

    public CyberDeckUtility(String name, String type, int multiplier, String description) {
        this.name = name;
        this.type = type;
        this.multiplier = multiplier;
        this.description = description;
    }
}
