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
        try {
            factory = (KingdomFactory) Class.forName(kingdomName + "KingdomFactory").newInstance();
            // factory = (KingdomFactory) (new OrcKingdomFactory()); // this is the same as the line above
            System.out.println("The kingdom " + kingdomName + " has been created.");
        } catch (Exception e) {
            System.out.println("The kingdom " + kingdomName + " is not yet supported.");
            System.exit(0);
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

    public Army getArmy() {
        return army;
    }

    public Castle getCastle() {
        return castle;
    }

    public King getKing() {
        return king;
    }

    public void createKingdom(KingdomFactory factory) {
        // using abstract factory without setters
        army = factory.createArmy();
        castle = factory.createCastle();
        king = factory.createKing();

    }

    public static void main(String[] args) {

        Main app = new Main();
        app.App();

    }

}
