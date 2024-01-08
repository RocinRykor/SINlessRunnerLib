package studio.rrprojects.srl.creation.metatype;

import studio.rrprojects.srl.keywords.AttributeKeywords;

import java.util.HashMap;
import java.util.Map;

public class BasicAttributeCollection {
    private Map<String, Integer> attributes;

    public BasicAttributeCollection(int body, int quickness, int strength, int willpower, int intelligence, int charisma) {
        attributes = new HashMap<>();
        attributes.put(AttributeKeywords.BODY, body);
        attributes.put(AttributeKeywords.QUICKNESS, quickness);
        attributes.put(AttributeKeywords.STRENGTH, strength);
        attributes.put(AttributeKeywords.WILLPOWER, willpower);
        attributes.put(AttributeKeywords.INTELLIGENCE, intelligence);
        attributes.put(AttributeKeywords.CHARISMA, charisma);
    }

    public int getByKeyword(String keyword) {
        if (attributes.containsKey(keyword)) {
            return attributes.get(keyword);
        } else {
            return 0;
        }
    }

    public String getAsTextAreaDisplayString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : attributes.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BasicAttributeCollection{");
        for (Map.Entry<String, Integer> entry : attributes.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()); // Remove the trailing comma and space
        sb.append('}');
        return sb.toString();
    }
}
