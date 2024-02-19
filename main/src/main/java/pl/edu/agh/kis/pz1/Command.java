package pl.edu.agh.kis.pz1;

import java.io.IOException;

/** Object representing system command. */
abstract class Command{
    /**
     * Method that executes command.
     *
     * @param hotel Hotel used in system.
     * */
    protected abstract void execute(Hotel hotel) throws IOException;
}
