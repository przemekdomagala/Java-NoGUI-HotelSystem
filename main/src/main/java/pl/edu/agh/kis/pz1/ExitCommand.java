package pl.edu.agh.kis.pz1;


/** Class representing Exit command letting user exit the system. */
public class ExitCommand extends Command{

    @Override
    protected void execute(Hotel hotel) {
        System.out.println("System closed.");
    }
}
