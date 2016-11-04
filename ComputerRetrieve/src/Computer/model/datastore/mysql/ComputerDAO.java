package Computer.model.datastore.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Computer.model.Computer;
import Computer.model.IComputerDAO;

public class ComputerDAO implements IComputerDAO {

    protected final static boolean DEBUG = true;

 
    @Override
    public List<Computer> retrieveAllRecords() {
        final List<Computer> myList = new ArrayList<>();
        final String QUERY = "select id, modelNumber, model, modelType, "
                + "cost from computer";

        try (Connection con = DBConnection.getConnection(); 
                PreparedStatement stmt = con.prepareStatement(QUERY)) {
            if (DEBUG) {
                System.out.println(stmt.toString());
            }
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                myList.add(new Computer(
                        rs.getInt("id"), 
                        rs.getString("modelNumber"), 
                        rs.getString("model"),
                        rs.getString("modelType"), 
                        rs.getDouble("cost")));
            }
        } catch (SQLException ex) {
            System.out.println("retrieveAllRecords SQLException: " + ex.getMessage());
        }

        return myList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Computer computer : retrieveAllRecords()) {
            sb.append(computer.toString()).append("\n");
        }

        return sb.toString();
		
	}
}
