package homework.ch11_13.p3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gyy
 * @creat 2025-04-17
 */
public class Course implements Cloneable{ // 实现 Cloneable 接口，允许克隆
    private String courseName;
    private List<Person> students = new ArrayList<>();
    private Person teacher;

    public Course(String courseName, Person teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
    }

    /**注册学生*/
    public void register(Person s){
        if(students.contains(s)){ // 是否已经注册
            System.out.println("该学生已经存在！");
        }else{
            students.add(s); // 添加学生到列表
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public List<Person> getStudents() {
        return students;
    }

    public Person getTeacher() {
        return teacher;
    }
    /**取消注册学生*/
    public void unregister(Person s){
        students.remove(s);
    }
    public int getNumberOfStudent(){
        return students.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 同一个对象，直接返回 true
        if (obj == null || getClass() != obj.getClass()) return false; // 如果是 null 或者不是同一个类
        Course course = (Course) obj;

        if (course.students.size() != students.size()) return false; // 学生数量不相等
        if (!students.containsAll(course.students)) return false; // 学生列表内容不一致
        if (!course.students.containsAll(students)) return false; // 学生列表内容不一致

        return courseName.equals(course.courseName) && // 课程名称相等
                teacher.equals(course.teacher); // 教师相等
    }



    @Override
    public Object clone() throws CloneNotSupportedException { // 重写 clone
        Course newObj = (Course)(super.clone()); // 调用父类 clone
        newObj.courseName = new String(this.courseName); // 深拷贝课程名称
        newObj.teacher = (Person) this.teacher.clone(); // 深拷贝教师

        List<Person> clonedStudents = new ArrayList<>();
        for (Person student : this.students) {
            clonedStudents.add((Person) student.clone()); // 深拷贝每个学生
        }
        newObj.students = clonedStudents;

        return newObj;
    }


    @Override
    public String toString() { // 重写 toString
        StringBuilder sb = new StringBuilder();
        sb.append("Course Name: ").append(this.getCourseName()).append("\n"); // 课程名称
        sb.append(this.teacher.toString()); // 教师信息
        sb.append("Student List: \n"); // 学生列表
        for (Person s : this.students) {
            sb.append(s.toString()); // 每个学生的信息
        }
        sb.append("Totally: ").append(this.getNumberOfStudent()).append(" students.\n"); // 学生总数
        return sb.toString();
    }

    public void setCourseName(String _java_) {
    }
}