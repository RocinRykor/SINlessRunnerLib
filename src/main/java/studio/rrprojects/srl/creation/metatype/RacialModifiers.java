package studio.rrprojects.srl.creation.metatype;

public class RacialModifiers {
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
