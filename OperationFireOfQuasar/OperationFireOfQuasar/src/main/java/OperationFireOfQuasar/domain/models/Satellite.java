
package operationFireOfQuasar.domain.models;



/**
 *
 * @author Norbey
 */

public class Satellite {
    private String name;
    private Point location;
    private Message message;

    public Satellite(String name, Point location, Message message) {
        this.name = name;
        this.location = location;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    
    
    
}
