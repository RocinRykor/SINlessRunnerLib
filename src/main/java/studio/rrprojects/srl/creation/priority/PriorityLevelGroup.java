/*
    A single PriorityLevelGroup will be composed of a table of PriorityElements. specific to that level of the priority table

    Example: At Priority Level A, you have the following options available to you:
    Magic: Full Magician (and Way of the Magician Adept, if using Magic in the Shadows)
    Skills: 50 Points
    Attributes: 30 Points
    Resources: 1,000,000 Nuyen

    Each of those options will be a PriorityElement
 */

package studio.rrprojects.srl.creation.priority;

import org.json.JSONObject;
import studio.rrprojects.srl.creation.priority.element.IntPriorityElement;
import studio.rrprojects.srl.creation.priority.element.PriorityElement;
import studio.rrprojects.srl.creation.priority.element.StringPriorityElement;
import studio.rrprojects.util_library.DebugUtils;

import java.util.HashMap;
import java.util.Iterator;

public class PriorityLevelGroup {
    private final HashMap<String, PriorityElement> priorityElementTable;

    public PriorityLevelGroup(String levelKey, JSONObject jsonObject) {
        /*
        A Priority Level Group consists of multiple Priority Elements for a given level.
        For example at level 'C' the following options are available, each of which is considered a Priority Element:
        Magic: Mundane
        Race: Elf/Troll
        Skills: 34 Points
        Attributes: 24 Points
        Resources: 90,000 Nuyen
         */

        // Turn JSON data into a table of PriorityElements
        priorityElementTable = new HashMap<>();

        for (Iterator<String> it = jsonObject.keys(); it.hasNext(); ) {
            String categoryKey = it.next();
            Object value = jsonObject.get(categoryKey);

            // Here we are going to convert the value into an element appropriate for the category
            PriorityElement processedValue;
            if (categoryKey.equalsIgnoreCase(PriorityConstants.MAGIC) || categoryKey.equalsIgnoreCase(PriorityConstants.RACE)) {
                processedValue = new StringPriorityElement(levelKey, categoryKey, value);
            } else {
                processedValue = new IntPriorityElement(levelKey, categoryKey, value);
            }

            priorityElementTable.put(categoryKey, processedValue);
        }

        //DEBUG
//        DebugUtils.UnknownMsg(getClass().getSimpleName() + " - Level: " + levelKey + " | JSON: " + jsonObject);
//        DebugUtils.VariableMsg(priorityElementTable.toString());
    }



    @Override
    public String toString() {
        return priorityElementTable.toString();
    }
}
