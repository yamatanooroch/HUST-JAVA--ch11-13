package homework.ch11_13.p3;

import java.util.Objects; /**
 *
 */
public class Student extends Person implements Cloneable{ // 学生类，继承 Person 类，实现 Cloneable 接口
    private int studentId; // 学生 ID
    private String department; // 院系
    private String classNo; // 班级
    public Student(){

    }

    public Student(String name, int age, int studentId, String department, String classNo) {
        super(name, age);
        this.studentId = studentId;
        this.department = department;
        this.classNo = classNo;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    @Override
    public boolean equals(Object obj) { // 重写 equals 方法
        if (!super.equals(obj)) return false;  // 重用 Person 的 equals

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return studentId == student.studentId &&
                Objects.equals(department, student.department) &&
                Objects.equals(classNo, student.classNo);
    }

    @Override
    public Object clone() throws CloneNotSupportedException { // 重写 clone 方法
        Student cloned = (Student) super.clone(); // 调用父类的 clone 方法
        cloned.department = new String(this.department); // 深拷贝院系
        cloned.classNo = new String(this.classNo);  // 深拷贝班级
        return cloned;
    }

    @Override
    public String toString() { // 重写 toString 方法
        return super.toString() + ", studentId: " + studentId + ", department: " + department + ", classNo: " + classNo + "\n";
    }
}
