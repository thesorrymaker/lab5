package collection;

/**
 * the color of hair
 *
 * @author yeheng
 */
public enum FuelType {
    KEROSENE,
    ELECTRICITY,
    ALCOHOL,
    PLASMA,
    ANTIMATTER;

    /**
     * show all the elements in String
     *
     * @return
     */
    public static String List() {
        String list = "";
        for (FuelType fuelType : FuelType.values()) {
            list = list + fuelType.name() + "\n";
        }
        return list;
    }
}

