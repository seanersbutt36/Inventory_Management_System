import java.util.Date;

public class Receipt {
    private String type = "";
    private Date date = null;
    private int quantity = 0;

    public Receipt(String _type, Date _date, int _quantity) {
        type = _type;
        date = _date;
        quantity = _quantity;
    }

    public void display() {
        System.out.println(type + " | " + date + " | " + quantity);
    }
}
