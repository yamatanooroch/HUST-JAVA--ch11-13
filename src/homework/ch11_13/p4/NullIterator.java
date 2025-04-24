package homework.ch11_13.p4;

/**
 * 实现一个空的迭代器。 当组件没有子组件时，可以使用它，避免返回 null 或抛出异常
 */
public class NullIterator implements ComponentIterator{
    public NullIterator() {
    }
    @Override
    public boolean hasNext(){
        return false;
    }
    @Override
    public Component next(){
        return null;
    }
}
