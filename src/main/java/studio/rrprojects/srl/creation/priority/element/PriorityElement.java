package studio.rrprojects.srl.creation.priority.element;


import studio.rrprojects.util_library.TextUtils;

import java.util.HashMap;

public class PriorityElement {
    private final String levelKey;
    private final String categoryKey;

    /**
     *
     * @param levelKey
     * @param categoryKey
     */

    public PriorityElement(String levelKey, String categoryKey) {
        this.levelKey = levelKey;
        this.categoryKey = categoryKey;
    }

    public String getLevelKey() {
        return levelKey;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public String getDisplayString() {
        return TextUtils.titleCase(categoryKey) + ": " + levelKey;
    }

    public HashMap<String, Object> getAsHashMap() {
        return null;
    }
}
