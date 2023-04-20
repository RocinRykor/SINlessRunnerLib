package studio.rrprojects.srl.creation.priority.element;

import studio.rrprojects.srl.creation.priority.PriorityConstants;
import studio.rrprojects.util_library.TextUtils;

public class IntPriorityElement extends PriorityElement {
    String displayString;
    int rawInt;

    /**
     * @param levelKey
     * @param categoryKey
     */
    public IntPriorityElement(String levelKey, String categoryKey, Object rawValue) {
        super(levelKey, categoryKey);
        rawInt = (Integer) rawValue;

        if (categoryKey.equalsIgnoreCase(PriorityConstants.RESOURCES)) {
            displayString = TextUtils.IntToNuyen(rawInt);
        } else {
            displayString = rawInt + " Points";
        }
    }

    public String getDisplayString() {
        return displayString;
    }

    public int getRawInt() {
        return rawInt;
    }

    @Override
    public String toString() {
        return displayString;
    }
}
