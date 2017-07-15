package schema;

/**
 * Created by JianFa on 2017/7/11.
 */
public class Property {

    private String name;
    private String number;
    private String type;
    private String model;
    private int value;
    private String custodian;
    private String user;
    private String area;
    private String location;

    public Property(String name, String number, String type, String model, int value, String custodian, String user, String area, String location) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.model = model;
        this.value = value;
        this.custodian = custodian;
        this.user = user;
        this.area = area;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getValue() {
        return value;
    }

    public String getCustodian() {
        return custodian;
    }

    public String getUser() {
        return user;
    }

    public String getArea() {
        return area;
    }

    public String getLocation() {
        return location;
    }

}
