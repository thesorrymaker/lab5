package Tools;

import java.util.*;

import collection.*;
import command.*;

public class Tools {
    public static String Input() {
        return new Scanner(System.in).nextLine();
    }

    public void PrintVehicleSet(LinkedHashSet<Vehicle> linkedHashSet) {
        Iterator<Vehicle> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().toString());
        }
    }
}
