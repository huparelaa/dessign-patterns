public class FactoryMaker {
    // Constructor
    public FactoryMaker() {
    }

    // Factory method
    public static KingdomFactory makeFactory(KingdomType type) {
        switch (type) {
            case ELF:
                return new ElfKingdomFactory();
            case ORC:
                return new OrcKingdomFactory();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}
