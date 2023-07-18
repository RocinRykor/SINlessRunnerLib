package studio.rrprojects.srl.creation.priority.element;

import studio.rrprojects.srl.creation.priority.PriorityConstants;
import studio.rrprojects.util_library.TextUtils;

import java.util.HashMap;

public class IntPriorityElement extends PriorityElement {
    String prettyString;
    int rawInt;

    /**
     * @param levelKey
     * @param categoryKey
     */
    public IntPriorityElement(String levelKey, String categoryKey, Object rawValue) {
        super(levelKey, categoryKey);
        rawInt = (Integer) rawValue;

        if (categoryKey.equalsIgnoreCase(PriorityConstants.RESOURCES)) {
            prettyString = TextUtils.IntToNuyen(rawInt);
        } else {
            prettyString = rawInt + " Points";
        }
    }

    public String getPrettyString() {
        return prettyString;
    }

    public int getRawInt() {
        return rawInt;
    }

    @Override
    public String toString() {
        return prettyString;
    }

    @Override
    public String getDisplayString() {
        return TextUtils.titleCase(super.getCategoryKey()) + ": " + prettyString;
    }

    @Override
    public HashMap<String, Object> getAsHashMap() {
        HashMap<String, Object> tmp = new HashMap<>();
        tmp.put(getCategoryKey(), getRawInt());
        return tmp;
    }
}
