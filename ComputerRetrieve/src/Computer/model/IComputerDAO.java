package Computer.model;
import java.util.List;
/**
 *
 * @author hero
 */

public interface IComputerDAO {


    List<Computer> retrieveAllRecords();
    @Override
    String toString();

}