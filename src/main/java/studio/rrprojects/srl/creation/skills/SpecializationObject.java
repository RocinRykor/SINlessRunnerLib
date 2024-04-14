package studio.rrprojects.srl.creation.skills;

public class SpecializationObject {
    private String specializationName;
    private int specializationLevel;

    public SpecializationObject(String specializationName, int specializationLevel) {
        this.specializationName = specializationName;
        this.specializationLevel = specializationLevel;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public int getSpecializationLevel() {
        return specializationLevel;
    }

    @Override
    public String toString() {
        return specializationName + " (" + specializationLevel + ")";
    }
}
