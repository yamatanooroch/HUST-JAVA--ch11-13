package homework.ch11_13.p4;

import java.util.Objects;
/**
 * 组件的通用接口
 */
public abstract class Component {
    protected int id;       //唯一标识符
    protected String name;  //名称
    protected double price; //价格
    public Component(){
    }

    public Component(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public abstract void add(Component component);
    public abstract double calcPrice();
    public abstract void remove(Component component);

    public abstract ComponentIterator createIterator();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        this.price = calcPrice();
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() +
                ", name: " + this.getName() +
                ", price: " + this.getPrice() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Component component = (Component) obj;
        return id == component.id &&
                Double.compare(component.price, price) == 0 &&
                Objects.equals(name, component.name);
    }

}
