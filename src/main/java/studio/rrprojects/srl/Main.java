package studio.rrprojects.srl;

import studio.rrprojects.srl.creation.skills.SkillMap;
import studio.rrprojects.srl.creation.skills.SkillObject;
import studio.rrprojects.srl.creation.skills.SkillsController;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        SkillsController skillsController = new SkillsController();
        LinkedHashMap<String, SkillMap> skillMap = skillsController.getMasterSkillMap();
        for (Map.Entry<String, SkillMap> stringSkillMapEntry : skillMap.entrySet()) {
            for (SkillObject skillObject : stringSkillMapEntry.getValue().getListSkillsMaster()) {
                System.out.println(skillObject.toString());
            }
        }

    }
}
