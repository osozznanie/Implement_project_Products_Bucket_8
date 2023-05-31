package ExampleWithDB.shop;

import java.sql.Date;

public class Payments {
    private int id;
    private int idSubscribe;
    private int sum;
    private Date date;

    public Payments(int id, int idSubscribe, int sum, Date date) {
        this.id = id;
        this.idSubscribe = idSubscribe;
        this.sum = sum;
        this.date = date;
    }

    public Payments(int idSubscribe, int sum) {
        this.idSubscribe = idSubscribe;
        this.sum = sum;
    }


    public Payments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSubscribe() {
        return idSubscribe;
    }

    public void setIdSubscribe(int idSubscribe) {
        this.idSubscribe = idSubscribe;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", idSubscribe=" + idSubscribe +
                ", sum=" + sum +
                ", date=" + date +
                '}';
    }
}



