package studio.rrprojects.srl.creation.metatype;

public class AttributeModifiers {
    private int body;
    private int strength;
    private int willpower;

    public AttributeModifiers(int body, int strength, int willpower) {
        this.body = body;
        this.strength = strength;
        this.willpower = willpower;
    }

    public int getBody() {
        return body;
    }

    public int getStrength() {
        return strength;
    }

    public int getWillpower() {
        return willpower;
    }
}
