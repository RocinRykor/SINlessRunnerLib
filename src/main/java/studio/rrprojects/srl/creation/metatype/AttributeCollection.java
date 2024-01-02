package studio.rrprojects.srl.creation.metatype;

public class AttributeCollection {
    private int body;
    private int quickness;
    private int strength;
    private int willpower;
    private int intelligence;
    private int charisma;

    public AttributeCollection(int body, int quickness, int strength, int willpower, int intelligence, int charisma) {
        this.body = body;
        this.quickness = quickness;
        this.strength = strength;
        this.willpower = willpower;
        this.intelligence = intelligence;
        this.charisma = charisma;
    }

    public int getBody() {
        return body;
    }

    public int getQuickness() {
        return quickness;
    }

    public int getStrength() {
        return strength;
    }

    public int getWillpower() {
        return willpower;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getCharisma() {
        return charisma;
    }

    public String getAsTextAreaDisplayString() {
        return "Body: " + body +"\n" +
                "Quickness: " + quickness +"\n" +
                "Strength:" + strength +"\n" +
                "Willpower:" + willpower +"\n" +
                "Intelligence:" + intelligence +"\n" +
                "Charisma:" + charisma;
    }

    @Override
    public String toString() {
        return "AttributeCollection{" +
                "body=" + body +
                ", quickness=" + quickness +
                ", strength=" + strength +
                ", willpower=" + willpower +
                ", intelligence=" + intelligence +
                ", charisma=" + charisma +
                '}';
    }
}