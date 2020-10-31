package th.ac.kmitl.atm.model;

public class customer {
    private int id;
    private String name;
    private String pin;

    public customer(int id, String name, String pin){
        this.id = id;
        this.name = name;
        this.pin = pin;

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPin() { return pin; }

    public void setPin(String pin) { this.pin = pin; }
}
