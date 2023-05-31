package ExampleWithDB.shop;

public class Magazines {
    protected int id;
    protected String nameOfMagazine;
    protected String description;
    protected int price;

    public Magazines(int id, String nameOfMagazine, String description, int price) {
        this.id = id;
        this.nameOfMagazine = nameOfMagazine;
        this.description = description;
        this.price = price;
    }

    public Magazines() {
    }

    public Magazines(String nameOfMagazine, String description, int price) {
        this.nameOfMagazine = nameOfMagazine;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfMagazine() {
        return nameOfMagazine;
    }

    public void setNameOfMagazine(String nameOfMagazine) {
        this.nameOfMagazine = nameOfMagazine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Magazines{" +
                "id=" + id +
                ", nameOfMagazine='" + nameOfMagazine + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
