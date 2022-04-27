package CSV;

import collection.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.*;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;

/**
 * read a csv file
 */
public class CSVReader {
    /**
     * read a csv file and write it to a linkedhashset
     * @param peoplelinkedhashset
     * @param path
     * @throws IOException
     */
    public void ReadFile(LinkedHashSet<Vehicle> peoplelinkedhashset, String path) throws IOException{
        FileReader fileReader=new FileReader(path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String first=bufferedReader.readLine();
        String s;
        while((s = bufferedReader.readLine())!=null) {
            String[] information = s.split(",");
            Coordinates coordinates = new Coordinates(Integer.valueOf(information[4]), Integer.valueOf(information[5]));

            Vehicle p = new Vehicle(coordinates, information[1], FuelType.valueOf(information[2].toUpperCase()), VehicleType.valueOf(information[3].toUpperCase()), Float.valueOf(information[7]));
            Vehicle.balaceicode();
            p.changeId(Integer.valueOf(information[0]));
            p.setCreationDate(LocalDate.parse(information[6]));
            peoplelinkedhashset.add(p);

        }
    }
}