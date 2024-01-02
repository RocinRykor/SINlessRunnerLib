package studio.rrprojects.srl.creation.metatype;

import org.json.JSONObject;
import studio.rrprojects.util_library.DebugUtils;

public class Metatype {
    private String name;
    private JSONObject rawJSON;
    private AttributeCollection naturalAttributeLimit;
    private AttributeCollection racialModifiedLimit;
    private RacialModifiers racialModifiers;


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

    public String getName() {
        return name;
    }

    public JSONObject getRawJSON() {
        return rawJSON;
    }

    public AttributeCollection getNaturalAttributeLimit() {
        return naturalAttributeLimit;
    }

    public AttributeCollection getRacialModifiedLimit() {
        return racialModifiedLimit;
    }

    public RacialModifiers getRacialModifiers() {
        return racialModifiers;
    }
}
