import java.util.logging.Logger;
// import the input from java
import java.util.Scanner;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class.getName());
    private Army army;
    private Castle castle;
    private King king;

    public void App() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the kingdom: Orc or Elf");
        String kingdomName = input.nextLine();
        input.close();
        // create the kingdom
        KingdomFactory factory = null;
        if (factory == null) { // Singleton guarantee that only one instance of the class is created
            try {
                factory = (KingdomFactory) Class.forName(kingdomName + "KingdomFactory").newInstance();
                // factory = (KingdomFactory) (new OrcKingdomFactory()); // this is the same as
                // the line above
                System.out.println("The kingdom " + kingdomName + " has been created.");
            } catch (Exception e) {
                System.out.println("The kingdom " + kingdomName + " is not yet supported.");
                System.exit(0);
            }
        } else {
            System.out.println("The kingdom " + kingdomName + " has already been created.");
        }
        if (factory != null) {
            createKingdom(factory);
            System.out.println(getArmy().getDescription());
            System.out.println(getCastle().getDescription());
            System.out.println(getKing().getDescription());
            // logger.info(getArmy().getDescription());
            // logger.info(getCastle().getDescription());
            // logger.info(getKing().getDescription());
        }

    }

    // creational getters
    public Army getArmy(KingdomFactory factory) {
        return factory.createArmy();
    }

    public Castle getCastle(KingdomFactory factory) {
        return factory.createCastle();
    }

    public King getKing(KingdomFactory factory) {
        return factory.createKing();
    }

    // pure getters

    public Army getArmy() {
        return army;
    }

    public Castle getCastle() {
        return castle;
    }

    public King getKing() {
        return king;
    }

    // unused setters
    private void setArmy(Army army) {
        this.army = army;
    }

    private void setCastle(Castle castle) {
        this.castle = castle;
    }

    private void setKing(King king) {
        this.king = king;
    }

    public void createKingdom(KingdomFactory factory) {
        // using abstract factory
        army = getArmy(factory);
        castle = getCastle(factory);
        king = getKing(factory);
    }

    public static void main(String[] args) {

        Main app = new Main();
        app.App();

    }

}
