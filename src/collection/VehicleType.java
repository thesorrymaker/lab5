package collection;

/**
 * the color of hair
 *
 * @author yeheng
 */
public enum VehicleType {
    CAR,
    BOAT,
    BICYCLE;

    /**
     * show all the elements in String
     *
     * @return
     */
    public static String List() {
        String list = "";
        for (VehicleType vehicleType : VehicleType.values()) {
            list = list + vehicleType.name() + "\n";
        }
        return list;
    }
}
