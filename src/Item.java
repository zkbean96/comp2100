public enum Item {
    HEALING_POTION, FOOD, DRINK;

    /**
     @return conversion from item to string
     */
    public String itemToString() {
        switch (this) {
            case HEALING_POTION:
                return "healing potion";
            case FOOD:
                return "food";
            case DRINK:
                return "drink";
            default:
                throw new IllegalStateException("Unexpected item: " + this);
        }
    }
}
