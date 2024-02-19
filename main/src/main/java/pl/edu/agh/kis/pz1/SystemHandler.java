package pl.edu.agh.kis.pz1;

import lombok.Getter;

import java.io.IOException;

public class SystemHandler {
    Command[] systemCommands;
    @Getter
    private boolean pickAnother;

    SystemHandler(){
        pickAnother = true;
    }

    void execute(int input, Hotel hotel) throws IOException {
        systemCommands = new Command[7];
        ListCommand listCommand = new ListCommand();
        ViewCommand viewCommand = new ViewCommand();
        CheckinCommand checkinCommand = new CheckinCommand();
        CheckoutCommand checkoutCommand = new CheckoutCommand();
        FullListCommand fullListCommand = new FullListCommand();
        ExitCommand exitCommand = new ExitCommand();
        SaveCommand saveCommand = new SaveCommand();
        systemCommands[0] = listCommand;
        systemCommands[1] = viewCommand;
        systemCommands[2] = checkinCommand;
        systemCommands[3] = checkoutCommand;
        systemCommands[4] = fullListCommand;
        systemCommands[5] = saveCommand;
        systemCommands[6] = exitCommand;
        if(input==7){
            pickAnother=false;
        }
        else if(input>7 || input<1){
            System.out.println("Your input is not system option. Try Again:");
            return;
        }
        systemCommands[input-1].execute(hotel);
    }
}
