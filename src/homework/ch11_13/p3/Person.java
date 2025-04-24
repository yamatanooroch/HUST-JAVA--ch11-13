package homework.ch11_13.p3;

import java.util.Objects;
/**
 *
 */
public class Person implements Cloneable{ // 人员类，实现 Cloneable 接口
    private int age; // 年龄
    private String name; // 姓名

    public Person(){

    }
    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() { // 重写 toString 方法
        return "name: " + name + ", age: " + age;
    }

    @Override
    public boolean equals(Object obj) { // 重写 equals 方法
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public Object clone() throws CloneNotSupportedException { // 重写 clone 方法
        Person cloned = (Person) super.clone(); // 调用父类 clone 方法
        cloned.name = new String(this.name); // 深拷贝姓名
        return cloned;
    }
}
