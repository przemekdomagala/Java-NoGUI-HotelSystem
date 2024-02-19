package pl.edu.agh.kis.pz1;

import lombok.Getter;
import lombok.Setter;

/**Class representing room object. Class consist only of room parameters, getters and setters.*/
@Getter
@Setter
public class Room {

    protected int roomNumber;
    protected int price;
    protected String description;

}
