package studio.rrprojects.srl.creation.priority.element;

import org.json.JSONArray;
import studio.rrprojects.util_library.JSONUtil;
import studio.rrprojects.util_library.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class StringPriorityElement extends PriorityElement{
    ArrayList<String> availableOptions = new ArrayList<>();
    String[] rawString;

    public StringPriorityElement(String levelKey, String categoryKey, Object rawValue) {
        super(levelKey,categoryKey);

        rawString = JSONUtil.jsonArrayToStringArray((JSONArray) rawValue);

        for (String option : rawString) {
            availableOptions.add(option);
        }
    }

    public ArrayList<String> getAvailableOptions() {
        return availableOptions;
    }

    public String[] getRawString() {
        return rawString;
    }

    @Override
    public String getDisplayString() {
        String display = "";

        if (availableOptions.size() == 1) {
            display = availableOptions.get(0);
        } else if (availableOptions.size() > 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < availableOptions.size() - 1; i++) {
                stringBuilder.append(availableOptions.get(i)).append(" / ");
            }
            stringBuilder.append(availableOptions.get(availableOptions.size() - 1));
            display = stringBuilder.toString();
        }

        return TextUtils.titleCase(super.getCategoryKey()) + ": " + display;
    }

    @Override
    public String toString() {
        return availableOptions.toString();
    }

    @Override
    public HashMap<String, Object> getAsHashMap() {
        HashMap<String, Object> tmp = new HashMap<>();
        tmp.put(getCategoryKey(), getRawString());
        return tmp;
    }
}
