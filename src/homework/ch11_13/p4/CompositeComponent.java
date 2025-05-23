package homework.ch11_13.p4;

/**
 * 组合组件
 */
public class CompositeComponent extends Component {
    protected ComponentList childs = new ComponentList();//存储子组件

    public CompositeComponent() {
    }

    public CompositeComponent(int id, String name, double price) {
        super(id, name, price);
    }

    public void add(Component component) throws UnsupportedOperationException{
        childs.add(component);
    }
    public double calcPrice(){
        double price = 0;
        for(Component c : this.childs){
            price += c.getPrice();
        }
        return price;
    }

    public ComponentIterator createIterator(){
        return new CompositeIterator(childs);
    }

    public void remove(Component component) throws UnsupportedOperationException{
        childs.remove(component);
        this.price -= component.getPrice();
    }

    @Override
    public double getPrice(){
        return this.calcPrice();
    }
    @Override
    public String toString() {
        String str = super.toString();
        String str1 = "";
        for(Component c : childs){
            str1 += c.toString();
        }
        return str + "sub-components of " + this.getName() + ": \n" + str1;
    }
}
