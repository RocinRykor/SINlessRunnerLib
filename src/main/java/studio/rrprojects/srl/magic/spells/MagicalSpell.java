package studio.rrprojects.srl.magic.spells;

public class MagicalSpell {
    // Constants
    private final static String TYPE_MANA = "Mana";
    private final static String TYPE_PHYSICAL = "Physical";
    private final static String DURATION_INSTANT = "Instant";
    private final static String DURATION_SUSTAINED = "Sustained";
    private final static String DURATION_PERMANENT = "Permanent";

    // Spell details
    private String spellName;
    private String spellType;
    private String target;
    private String duration;
    private String drain;
    private String description;

    // Constructor
    public MagicalSpell(String spellName, String spellType, String target, String duration, String drain, String description) {
        this.spellName = spellName;
        this.spellType = spellType;
        this.target = target;
        this.duration = duration;
        this.drain = drain;
        this.description = description;
    }

    // Getters
    public String getSpellName() {
        return spellName;
    }

    public String getSpellType() {
        return spellType;
    }

    public String getTarget() {
        return target;
    }

    public String getDuration() {
        return duration;
    }

    public String getDrain() {
        return drain;
    }

    public String getDescription() {
        return description;
    }

    // Roll method
    public void rollSpell(int force) {
        int durationInHours = force * 24;
        System.out.println("Healthy Glow spell cast with force " + force + ". Duration: " + durationInHours + " hours.");
    }

    // Main method for testing
    public static void main(String[] args) {
        MagicalSpell healthyGlow = new MagicalSpell(
                "Healthy Glow",
                TYPE_MANA,
                "4",
                DURATION_PERMANENT,
                "L",
                "This spell brightens eyes and hair, sloughs off dead skin cells, improves circulation and promotes general well-being. "+
                        "A cosmetic spell, the rich use Healthy Glow as a status symbol and pick-me-up. "+
                        "Though “permanent” in the sense that it does not require sustaining, the spell wears off in Force x 24 hours"
        );

        // Roll the spell with force 5
        healthyGlow.rollSpell(5);
    }
}