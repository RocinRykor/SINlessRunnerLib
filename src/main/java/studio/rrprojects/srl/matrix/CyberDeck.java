package studio.rrprojects.srl.matrix;

import org.json.JSONObject;
import studio.rrprojects.util_library.TextUtils;

public class CyberDeck {

    public enum CONST {
        MODEL("Model"),
        DECK_RATING("Deck Rating"),
        HARDENING("Hardening"),
        ACTIVE_MEMORY("Active Memory"),
        STORAGE_MEMORY("Storage Memory"),
        IO_SPEED("I/O Speed"),
        RESPONSE_INCREASE("Response Increase"),
        COST("Cost");

        private final String text;
        CONST(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private final String model;
    private final int rating;
    private final int hardening;
    private final int activeMemory;
    private final int storageMemory;
    private final int ioSpeed;
    private final int responseIncrease;
    private final int baseCost;

    //Constants from JSON DATA
    private final static String DECK_RATING = "deck_rating";
    private final static String HARDENING = "hardening";
    private final static String ACTIVE_MEMORY = "active_memory";
    private final static String STORAGE_MEMORY = "storage_memory";
    private final static String IO_SPEED = "io_speed";
    private final static String RESPONSE_INCREASE = "response_increase";
    private final static String COST = "cost";


    public CyberDeck(String model, int rating, int hardening, int activeMemory, int storageMemory, int ioSpeed, int responseIncrease, int baseCost) {
        this.model = model;
        this.rating = rating;
        this.hardening = hardening;
        this.activeMemory = activeMemory;
        this.storageMemory = storageMemory;
        this.ioSpeed = ioSpeed;
        this.responseIncrease = responseIncrease;
        this.baseCost = baseCost;
    }

    public static CyberDeck NewDeckFromJSON(String title, JSONObject jsonObject) {
        int jsonRating = jsonObject.getInt(DECK_RATING);
        int jsonHardening = jsonObject.getInt(HARDENING);
        int jsonActive = jsonObject.getInt(ACTIVE_MEMORY);
        int jsonStorage = jsonObject.getInt(STORAGE_MEMORY);
        int jsonSpeed = jsonObject.getInt(IO_SPEED);
        int jsonResponse = jsonObject.getInt(RESPONSE_INCREASE);
        int jsonCost = jsonObject.getInt(COST);

        return new CyberDeck(title, jsonRating, jsonHardening, jsonActive, jsonStorage, jsonSpeed, jsonResponse, jsonCost);
    }

    public String getModel() {
        return model;
    }

    public int getRating() {
        return rating;
    }

    public int getHardening() {
        return hardening;
    }

    public int getActiveMemory() {
        return activeMemory;
    }

    public int getStorageMemory() {
        return storageMemory;
    }

    public int getIoSpeed() {
        return ioSpeed;
    }

    public int getResponseIncrease() {
        return responseIncrease;
    }

    public int getBaseCost() {
        return baseCost;
    }

    @Override
    public String toString() {
        return  "Model: " + getModel() + "\n" +
                "Deck Rating: MPCP-" + getRating() + "\n" +
                "Harding: " + getHardening() + "\n" +
                "Active Memory: " + getActiveMemory() + "\n" +
                "Storage Memory: " + getStorageMemory() + "\n" +
                "I/O Speed: " + getIoSpeed() + "\n" +
                "Response Increase: " + getResponseIncrease() + "\n" +
                "Cost: " + TextUtils.IntToNuyen(getBaseCost());
    }
}
