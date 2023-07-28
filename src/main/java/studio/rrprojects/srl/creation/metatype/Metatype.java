package studio.rrprojects.srl.creation.metatype;

import org.json.JSONObject;
import studio.rrprojects.util_library.DebugUtils;

public class Metatype {
    private String name;
    private JSONObject rawJSON;
    private AttributeCollection naturalAttributeLimit;
    private AttributeCollection racialModifiedLimit;
    private RacialModifiers racialModifiers;

    // Constructors, getters, and setters can be added here.
    public Metatype(String metatypeName, JSONObject rawJSON) {
        this.name = metatypeName;
        DebugUtils.ErrorMsg("Metatype Name: " + metatypeName);
        this.rawJSON = rawJSON;
        this.naturalAttributeLimit = createAttributeCollection(rawJSON.getJSONObject("natural_attribute_limit"));
        this.racialModifiedLimit = createAttributeCollection(rawJSON.getJSONObject("racial_modified_limit"));
        this.racialModifiers = createRacialModifiersCollections(rawJSON.optJSONObject("racial_modifiers"));
    }

    private AttributeCollection createAttributeCollection(JSONObject jsonObject) {
        DebugUtils.VariableMsg(String.valueOf(jsonObject));
        int body = jsonObject.optInt("body", 0);
        int quickness = jsonObject.optInt("quickness", 0);
        int strength = jsonObject.optInt("strength", 0);
        int willpower = jsonObject.optInt("willpower", 0);
        int intelligence = jsonObject.optInt("intelligence", 0);
        int charisma = jsonObject.optInt("charisma", 0);

        return new AttributeCollection(body, quickness, strength, willpower, intelligence, charisma);
    }

    private RacialModifiers createRacialModifiersCollections(JSONObject jsonObject) {


        AttributeCollection attributeModifiers = createAttributeCollection(jsonObject.optJSONObject("attributes"));
        BiowareModifiers biowareModifiers = createBiowareModifiers(jsonObject.optJSONObject("bioware"));

        return new RacialModifiers(attributeModifiers, biowareModifiers);
    }

    private BiowareModifiers createBiowareModifiers(JSONObject jsonObject) {
        String eyes = jsonObject.optString("eyes", "no bioware");
        String torso = jsonObject.optString("torso", "no bioware");
        String limbs = jsonObject.optString("limbs", "no bioware");

        return new BiowareModifiers(eyes, torso, limbs);
    }

    // Getters and setters for name, rawJSON, naturalAttributeLimit, racialModifiedLimit, and racialModifiers can be added here.
}

class AttributeCollection {
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
}

class RacialModifiers {
    private AttributeCollection attributes;
    private BiowareModifiers bioware;

    public RacialModifiers(AttributeCollection attributes, BiowareModifiers bioware) {
        this.attributes = attributes;
        this.bioware = bioware;
    }

    public AttributeCollection getAttributes() {
        return attributes;
    }

    public BiowareModifiers getBioware() {
        return bioware;
    }
}

class AttributeModifiers {
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

class BiowareModifiers {
    private String eyes;
    private String torso;
    private String limbs;

    public BiowareModifiers(String eyes, String torso, String limbs) {
        this.eyes = eyes;
        this.torso = torso;
        this.limbs = limbs;
    }

    public String getEyes() {
        return eyes;
    }

    public String getTorso() {
        return torso;
    }

    public String getLimbs() {
        return limbs;
    }
}
