package homework.ch11_13.p4;

/**
 * 原子组件
 */
public class AtomicComponent extends Component{
    public AtomicComponent() {
    }

    public AtomicComponent(int id, String name, double price) {
        super(id, name, price);
    }
    public void add(Component component) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();      //原子组件不能移除子组件
    }
    public double calcPrice(){
        this.setPrice(this.price);
        return this.price;
    }
    public ComponentIterator createIterator(){
        return new NullIterator();      //原子组件没有子组件
    }
    public void remove(Component component) throws UnsupportedOperationException{
        throw new UnsupportedOperationException();      //原子组件不能移除子组件
    }

}
