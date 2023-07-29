public class ElfKingdomFactory implements KingdomFactory{
    public ElfKingdomFactory() {
    }

    public King createKing() {
        return new ElfKing();
    }

    public Castle createCastle() {
        return new ElfCastle();
    }

    public Army createArmy() {
        return new ElfArmy();
    }
}
