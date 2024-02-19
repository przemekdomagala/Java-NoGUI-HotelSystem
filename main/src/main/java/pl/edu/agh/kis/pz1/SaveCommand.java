package pl.edu.agh.kis.pz1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SaveCommand extends Command{

    protected FileWriter fileWriter;

    protected void execute(Hotel operatedHotel) throws IOException {
        setSaveData();
        var hotelMap = operatedHotel.getHotelMap();
        try(Writer outputFile = fileWriter){
            CSVPrinter printer = new CSVPrinter(outputFile, CSVFormat.DEFAULT);
            for(var key: hotelMap.keys()){
                printer.printRecord(key.getRoomNumber(), key.getPrice(), key.getDescription(), hotelMap.get(key));
            }
            System.out.println("Data Saved");
        } catch (IOException e) {
            throw new FileNotFoundException("File was not found");
        }
    }

    protected void setSaveData() throws IOException {
        fileWriter = new FileWriter("C:\\Users\\Przemek\\Desktop\\hotel_pod_gita\\operatingHotel\\main\\src\\main\\resources\\data_base.csv");
    }
}
