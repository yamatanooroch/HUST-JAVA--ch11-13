package homework.ch11_13.p3;

import java.util.Objects; /**
 *
 */
public class Faculty extends Person implements Cloneable{ // 教师类，继承 Person 类，实现 Cloneable 接口
    private int facultyId; // 教师 ID
    private String title; // 职称
    private String email; // 邮箱

    public Faculty() {

    }

    public Faculty(String name, int age, int facultyId, String title, String email) {
        super(name, age);
        this.facultyId = facultyId;
        this.title = title;
        this.email = email;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) { // 重写 equals 方法
        if (!super.equals(obj)) return false; // 重用 Person 的 equals 方法

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Faculty faculty = (Faculty) obj;
        return facultyId == faculty.facultyId &&
                Objects.equals(title, faculty.title) &&
                Objects.equals(email, faculty.email);
    }

    @Override
    public Object clone() throws CloneNotSupportedException { // 重写 clone 方法
        Faculty cloned = (Faculty) super.clone(); // 调用父类的 clone 方法
        cloned.title = new String(this.title);  // 深拷贝 title
        cloned.email = new String(this.email);  // 深拷贝 email
        return cloned;
    }

    @Override
    public String toString() { // 重写 toString 方法
        return "Teacher Info: " + super.toString() + ", facultyId: " + facultyId + ", title: " + title + ", email: " + email + "\n";
    }
}
