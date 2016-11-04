package Computer.viewui;
import Validator.util.Validator;
import java.util.Scanner;
import Computer.model.Computer;
import Computer.model.IComputerDAO;
import Computer.model.datastore.mysql.ComputerDAO;

public class ComputerApp {

    IComputerDAO myList = new ComputerDAO();
    Scanner sc = new Scanner(System.in);

    public ComputerApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id;
        String modelNumber, model, modelType;
        double cost;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nComputer App");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(myList.toString());
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ComputerApp();
    }
}
