public enum KingdomType {
    ELF, ORC;

    public static KingdomType value(String name) {
        switch (name) {
            case "ELF":
                return ELF;
            case "ORC":
                return ORC;
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}
