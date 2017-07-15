package schema;

/**
 * Created by JianFa on 2017/7/15.
 */
public class User {

    private String name = null;
    private String id = null;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
