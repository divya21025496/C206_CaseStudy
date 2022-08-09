
public class Appointment {
    private String name ;
    private String designerName ;
    private String date ;
    private String time;
    private String address;
    
    public Appointment(String name, String designerName, String date,  String time, String address) {
        this.name = name ;
        this.designerName = designerName ;
        this.date = date ;
        this.time = time ;
        this.address = address;
        
    }
    
    public String getName() {
        return name ;
    }
    public String getDesignerName() {
        return designerName ;
    }
    public String getDate() {
        return date ;
    }
    public String getTime() {
        return time;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void display() {
        System.out.println(String.format("\n%-15s %-20s %-15 %-20s", getName(), getDesignerName(), getDate(), getTime(), getAddress()));
    }
    
}