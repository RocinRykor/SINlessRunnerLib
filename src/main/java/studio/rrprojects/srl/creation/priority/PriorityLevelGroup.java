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
import studio.rrprojects.util_library.DebugUtils;

public class PriorityLevelGroup {
    public PriorityLevelGroup(String key, JSONObject jsonObject) {


        //TODO 9/20/22 -> Turn JSON data into a table of PriorityElements

        //DEBUG
        DebugUtils.ProgressNormalMsg(getClass().getSimpleName() + " - Key: " + key + " | JSON: " + jsonObject.toString());
    }
}
