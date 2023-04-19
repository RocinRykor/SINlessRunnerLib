package studio.rrprojects.srl.creation.priority.element;

import java.util.ArrayList;

public class StringPriorityElement extends PriorityElement{
    ArrayList<String> availableOptions = new ArrayList<>();
    String[] rawString;

    public StringPriorityElement(String levelKey, String categoryKey, Object rawValue) {
        super(levelKey,categoryKey);

        rawString = (String[]) rawValue;

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
}
