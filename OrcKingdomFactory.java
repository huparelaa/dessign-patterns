public class OrcKingdomFactory implements KingdomFactory{
    public OrcKingdomFactory() {
    }

    public King createKing() {
        return new OrcKing();
    }

    public Castle createCastle() {
        return new OrcCastle();
    }

    public Army createArmy() {
        return new OrcArmy();
    }
}
