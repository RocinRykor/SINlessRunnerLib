package studio.rrprojects.srl.creation.metatype;

public class BiowareModifiers {
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

    public String getAsTextAreaDisplayString() {
        return "Eyes: " + eyes +"\n" +
                "Torso: " + torso +"\n" +
                "limbs:" + limbs +"\n";
    }

    @Override
    public String toString() {
        return "BiowareModifiers{" +
                "eyes='" + eyes + '\'' +
                ", torso='" + torso + '\'' +
                ", limbs='" + limbs + '\'' +
                '}';
    }
}
