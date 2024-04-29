public class VIPcustomer extends Customer {
    private int vippoints;

    public VIPcustomer(int vippoints, String firstName, String lastName, int pin) {
        super(firstName, lastName, pin);
        this.vippoints = vippoints;
    }
    public int getVippoints() {
        return vippoints;
    }
    public void setVippoints(int vippoints) {
        this.vippoints = vippoints;
    }
    @Override
    public String toString() {
        return String.format("You are " + this.getFirstName() + " " + this.getLastName() + ". Your pin number is " + this.getPin() + "." + " VIP Points: " + vippoints);
    }
}
