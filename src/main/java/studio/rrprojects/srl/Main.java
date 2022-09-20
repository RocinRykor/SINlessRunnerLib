package studio.rrprojects.srl;

import studio.rrprojects.srl.creation.priority.PriorityController;

public class Main {

    public static void main(String[] args) {
        PriorityController priorityController = new PriorityController();

        priorityController.getMasterPriorityMap().forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
    }
}
