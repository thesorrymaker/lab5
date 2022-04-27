package collection;

import java.time.LocalDate;

/**
 * class Coordinate,one of collection,which helps set location
 */

public class Coordinates {
    private Integer x;
    private Integer y;  //Значение поля должно быть больше -591


    /**
     * constructor
     *
     *
     * @param coordinates
     * @param information
     * @param y
     * @throws NullException,ValueTooBigException
     */
    public Coordinates(Coordinates coordinates, String information, Integer y) throws NullException, ValueTooBigException {
        setY(y);
    }

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }


    /**
     * set y.When y<-591 throw ValueTooBigException.When y=null throw NullException
     *
     * @param y
     * @throws ValueTooBigException,NullException
     */

    public void setY(Integer y) throws ValueTooBigException, NullException {
        if (y == null) {
            throw new NullException();
        } else if (y < -591) {
            throw new ValueTooBigException("y can't smaller than -591\n");
        } else {
            this.y = y;
        }
    }

    /**
     * get x
     *
     * @return Integer
     */
    public Integer getX() {
        return x;
    }

    /**
     * get y
     *
     * @return Integer
     */
    public Integer getY() {
        return y;
    }

    /**
     * print the information of coordination
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

