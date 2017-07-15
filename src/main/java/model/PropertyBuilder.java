package model;

import schema.Property;

/**
 * Created by JianFa on 2017/7/11.
 */
public class PropertyBuilder {

    private static PropertyBuilder pb;

    private String name;
    private String number;
    private String type;
    private String model;
    private int value;
    private String custodian;
    private String user;
    private String area;
    private String location;

    private PropertyBuilder () {}

    public static PropertyBuilder newInstance() {
        pb = new PropertyBuilder();
        return pb;
    }

    public PropertyBuilder setName(String name) {
        this.name = name;
        return pb;
    }

    public PropertyBuilder setNumber(String number) {
        this.number = number;
        return pb;
    }

    public PropertyBuilder setType(String type) {
        this.type = type;
        return pb;
    }


    public PropertyBuilder setModel(String model) {
        this.model = model;
        return pb;
    }

    public PropertyBuilder setValue(int value) {
        this.value = value;
        return pb;
    }

    public PropertyBuilder setCustodian(String custodian) {
        this.custodian = custodian;
        return pb;
    }


    public PropertyBuilder setUser(String user) {
        this.user = user;
        return pb;
    }

    public PropertyBuilder setArea(String area) {
        this.area = area;
        return pb;
    }

    public PropertyBuilder setLocation(String location) {
        this.location = location;
        return pb;
    }

    public Property build() {
        if(this.name == null || this.name.isEmpty())
            throw new IllegalArgumentException("Property name should not be empty.");
        if(this.type == null || this.type.isEmpty())
            throw new IllegalArgumentException("Property type should not be empty.");
        if(this.model == null || this.model.isEmpty())
            throw new IllegalArgumentException("Property model should not be empty.");

        return new Property(name, number, type, model, value, custodian, user, area, location);
    }
}
