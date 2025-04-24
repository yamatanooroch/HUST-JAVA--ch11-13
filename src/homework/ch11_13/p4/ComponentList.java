package homework.ch11_13.p4;

import java.util.ArrayList;
/**
 *存储 Component 对象的列表
 * 实现 ComponentIterator 接口
 */
public class ComponentList extends ArrayList<Component> implements ComponentIterator {
    private int position = -1;
    public ComponentList(){

    }
    public boolean hasNext(){
        return position + 1 < this.size();
    }
    public Component next(){
        if(this.hasNext()){
            position++;
            return this.get(position);
        }else{
            return null;
        }
    }

}
