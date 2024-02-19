package pl.edu.agh.kis.pz1;

import lombok.Getter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

/**Class representing hotel object used in the system.*/
public class Hotel {

    /**Map used to assign guest to a room.*/
    @Getter
    protected final MyMap<Room, String> hotelMap = new MyMap<>();

    /**FileReader used to read information from a file, which is system's database.*/
    protected FileReader fileReader;

    /**Default constructor that reads information from database
     *
     * @throws FileNotFoundException if there is an error during reading from the file.
     */
    Hotel() throws FileNotFoundException {
        setFileReader();
        try (Reader inputFile = fileReader) {
            CSVParser parser = new CSVParser(inputFile, CSVFormat.DEFAULT);
            for (CSVRecord oneRecord : parser) {
                Room room = new Room();
                room.setRoomNumber(Integer.parseInt(oneRecord.get(0)));
                room.setPrice(Integer.parseInt(oneRecord.get(1)));
                room.setDescription(oneRecord.get(2));
                hotelMap.put(room, oneRecord.get(3));
            }
        } catch (IOException e) {
            throw new FileNotFoundException("File was not found");
        }
    }

    /**Method that sets location of file with info.*/
    protected void setFileReader() throws FileNotFoundException {
        fileReader =  new FileReader("C:\\Users\\Przemek\\Desktop\\hotel_pod_gita\\operatingHotel\\main\\src\\main\\resources\\data_base.csv");
    }

    /**Method checking whether hotel contains room with certain number
     *
     * @param roomNumber number of room to check.
     * @return returns false if room exists, true otherwise. It's because method contains was previously used only with
     * '!' so it was refactored. Maybe will be changed in next version, so it is more readable.*/
    protected boolean contains(int roomNumber){
        for(var key: hotelMap.keys()){
            if(key.getRoomNumber()==roomNumber){
                return false;
            }
        }
        return true;
    }

    /**Room getter with null return handled.
     *
     * @param roomNumber room to get.
     * @return number associated with passed number.*/
    protected Room getRoom(int roomNumber){
        for(Room key: hotelMap.keys()){
            if(key.getRoomNumber()==roomNumber){
                return key;
            }
        }
        System.out.println("Room with such number doesn't exits, last room was returned.");
        return null;
    }
}
