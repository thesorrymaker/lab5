package collection;

import java.time.LocalDate;
import java.util.Objects;

import Tools.Tools;


/**
 * Collections class Person
 */

public class Vehicle implements Comparable<Vehicle> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float enginePower; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType vehicleType; //Поле не может быть null
    private FuelType fuelType; //Поле не может быть null
    public static int idcode = 0;

    /**
     * constructor
     *
     *
     * @param coordinates
     * @param name
     * @param fuelType
     * @param vehicleType
     * @param enginePower
     * @throws NullException
     * @throws ValueTooBigException
     */
    public Vehicle(Coordinates coordinates, String name, FuelType fuelType, VehicleType vehicleType, Float enginePower) throws NullException, ValueTooBigException {
        setName(name);
        setCoordinates(coordinates);
        setFuelType(fuelType);
        setVehicleType(vehicleType);
        setEnginePower(enginePower);
        this.id = setId();
        this.creationDate = LocalDate.now();
    }




    /**
     * set id
     *
     * @return void
     */
    public static Integer setId() {
        idcode = idcode + 1;
        return idcode;
    }

    public static void balaceicode() {
        idcode = idcode - 1;
    }

    /**
     * set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * set coordinates.When coordinates=null,throws NullException
     *
     * @param coordinates
     * @throws NullException
     */
    public void setCoordinates(Coordinates coordinates) throws NullException {
        if (coordinates == null) {
            throw new NullException("coordinates can't be null");
        } else {
            this.coordinates = coordinates;
        }
    }



    /**
     * set the creationdate
     *
     * @param creationDate
     */
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * set VehicleType.When Vehicletype=null throws NullException
     *
     * @param vehicleType
     * @throws NullException
     */
    public void setVehicleType(VehicleType vehicleType) throws NullException {
        if (vehicleType == null) {
            throw new NullException("vehicletype can't be null\n");
        } else {
            this.vehicleType = vehicleType;
        }
    }

    /**
     * set enginePower.When enginePower<=0 throws ValueTooSmallException
     *
     * @param enginePower
     * @throws ValueTooSmallException
     */
    public void setEnginePower(float enginePower) throws ValueTooSmallException {
        if (!(enginePower > 0)) {
            throw new ValueTooSmallException("enginePower should bigger than 0\n");
        } else {
            this.enginePower = enginePower;
        }
    }

    /**
     * set fuel color.When fuelcolor=null throws NullException
     *
     * @param fuelType
     * @throws NullException
     */
    public void setFuelType(FuelType fuelType) throws NullException {
        if (fuelType == null) {
            throw new NullException("fueltype can't be null\n");
        } else {
            this.fuelType = fuelType;
        }
    }

    /**
     * return the name of vehicle
     *
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * return the coordinates of vehicle
     * @return String
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    /**
     * return the fuelType of vehicle
     * @return String
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * return the type of a vehicle
     *
     * @return String
     */
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * return the id of a Vehicle
     *
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * return the enginePower of a vehicle
     *
     * @return float
     */
    public float getenginePower() {
        return enginePower;
    }


    /**
     * set the id of a vehicle
     *
     * @param id
     */
    public void changeId(Integer id) {
        this.id = id;
    }

    /**
     * here we set toString in order to write Vehicle to the file in format csv.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.id + "," + this.name + "," + this.fuelType + "," + this.vehicleType + "," +this.coordinates.toString()+","+ this.creationDate+","+this.enginePower +"\n";
    }

    /**
     * user set a vehicle by himself
     *
     * @return Vehicle
     * @throws NullException
     * @throws ValueTooBigException
     * @throws ValueTooSmallException
     */
    public static Vehicle VehicleCreate() throws NullException, ValueTooBigException, ValueTooSmallException {
        System.out.print("Input x(x=!null):\n");
        String sx = Tools.Input();
        Integer x = Integer.valueOf(sx);
        if (x == null) {
            throw new ValueTooBigException("x should not be null");
        }
        System.out.print("Input y(y>=-591):\n");
        String sy = Tools.Input();
        Integer y = Integer.valueOf(sy);
        if (y < -591) {
            throw new ValueTooSmallException("y should bigger than -591\n");
        }
        System.out.print("name of Vehicle:\n");
        String name = Tools.Input();
        System.out.print("set fuelType from\n" + FuelType.List() + ":");
        String HC = Tools.Input();
        HC = HC.toUpperCase();
        FuelType fuelType = FuelType.valueOf(HC);
        System.out.print("set VehicleType from\n" + VehicleType.List() + ":");
        String EC = Tools.Input();
        EC = EC.toUpperCase();
        VehicleType vehicleType = VehicleType.valueOf(EC);
        System.out.print("set enginePower(>0)\n");
        String H = Tools.Input();
        float enginePower = Integer.valueOf(H);
        if (enginePower <= 0) {
            throw new ValueTooSmallException("enginePower should bigger than 0\n");
        }
        Coordinates coordinates = new Coordinates(x,y);
        return new Vehicle(coordinates,name,fuelType,vehicleType,enginePower);
    }

    @Override
    public int compareTo(Vehicle o) {
        if (o == null || this == null) {
            throw new NullPointerException("Null can't be compared");
        } else if (this.equals(o)) {
            return 0;
        } else if (this.hashCode() > o.hashCode()) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return enginePower == vehicle.enginePower &&
                id.equals(vehicle.id) &&
                name.equals(vehicle.name) &&
                coordinates.equals(vehicle.coordinates) &&
                creationDate.equals(vehicle.creationDate) &&
                vehicleType == vehicle.vehicleType &&
                fuelType == vehicle.fuelType;

    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id,name, coordinates, creationDate, fuelType, enginePower, vehicleType);
    }
}




