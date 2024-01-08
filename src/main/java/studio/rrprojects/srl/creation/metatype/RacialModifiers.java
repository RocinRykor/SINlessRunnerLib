package studio.rrprojects.srl.creation.metatype;

public class RacialModifiers {
    private BasicAttributeCollection attributes;
    private BiowareModifiers bioware;

    public RacialModifiers(BasicAttributeCollection attributes, BiowareModifiers bioware) {
        this.attributes = attributes;
        this.bioware = bioware;
    }

    public BasicAttributeCollection getAttributes() {
        return attributes;
    }

    public BiowareModifiers getBioware() {
        return bioware;
    }
}
