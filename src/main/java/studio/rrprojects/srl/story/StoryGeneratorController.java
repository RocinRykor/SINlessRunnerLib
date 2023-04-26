package studio.rrprojects.srl.story;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoryGeneratorController {

    private static final String[] STORY_PART_CONTACT = {"Phone Call", "Email", "Matrix Message", "In-Person Contact", "Fixer"};
    private static final String[] STORY_PART_INTRODUCTION = {"Restaurant", "Matrix", "Office Space", "Public Location", "Dead Drop"};
    private static final String[] STORY_PART_LEADS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private static final String[] STORY_PART_PAYOFF = {"Satisfactory", "Exemplary", "Betrayal", "Twist"};

    public StoryGeneratorController() {
        System.out.println("Generating a story...");
        List<String> storyLeads = getRandomLeads();
        String output = String.format("The Player is contacted in the form of a %s, and is directed to a %s meetup. They use the following leads in the run: %s. Finally the payoff ends in a %s ending",
                getRandomElement(STORY_PART_CONTACT), getRandomElement(STORY_PART_INTRODUCTION), storyLeads, getRandomElement(STORY_PART_PAYOFF));
        System.out.println(output);
    }

    public static List<String> getRandomLeads() {
        Random rand = new Random();
        int numParts = rand.nextInt(3) + 1; // choose 1-3 parts
        List<String> storyLeads = new ArrayList<>();
        while (storyLeads.size() < numParts) {
            String part = getRandomElement(STORY_PART_LEADS);
            if (!storyLeads.contains(part)) {
                storyLeads.add(part);
            }
        }
        return storyLeads;
    }

    private static String getRandomElement(String[] array) {
        Random rand = new Random();
        return array[rand.nextInt(array.length)];
    }
}