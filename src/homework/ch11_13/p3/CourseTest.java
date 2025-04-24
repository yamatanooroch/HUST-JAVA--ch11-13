package homework.ch11_13.p3;

/**
 * @author gyy
 * @creat 2025-04-17
 */
public class CourseTest { // 测试类
    public static void main(String[] args) throws CloneNotSupportedException{
        Person teacher1 = new Faculty("James Gosling", 65, 1001, "Professor", "teacher1@example.com"); // 创建教师对象
        Person teacher2 = new Faculty("Guido van Rossum", 68, 1002, "Professor", "tearcher2@example.com"); // 创建教师对象

        Course javaCourse = new Course("Java Language Programming", teacher1); // 创建课程对象
        Course pythonCourse = new Course("Python Programming", teacher2); // 创建课程对象


        Person student1 = new Student("Alice Smith", 20, 20230001, "CS", "CS101"); // 创建学生对象
        Person student2 = new Student("Bob Johnson", 21, 20230002, "EE", "EE201"); // 创建学生对象
        Person student3 = new Student("Charlie Brown", 19, 20230003, "Math", "MA101"); // 创建学生对象
        Person student4 = new Student("David Lee", 22, 20220004, "CS", "CS201"); // 创建学生对象
        Person student5 = new Student("Eve Wilson", 20, 20230005, "Physics", "PH101"); // 创建学生对象
        Person student6 = new Student("Frank Miller", 21, 20220006, "History", "HI201"); // 创建学生对象

        // 注册学生
        javaCourse.register(student1);
        //        javaCourse.register(student1);  //检查重复注册
        javaCourse.register(student2);
        javaCourse.register(student3);
        pythonCourse.register(student4);
        pythonCourse.register(student5);
        pythonCourse.register(student6);


        Course[] courses = {javaCourse, pythonCourse}; // 创建课程数组

        for (Course course : courses) {
            System.out.println(course.toString()); // 打印课程信息
        }



        // 深拷贝测试
        Course javaCourseClone = (Course) javaCourse.clone();

        System.out.println("Java 课程的深拷贝测试:");

        // 测试 1: 克隆对象值等于原始对象
        System.out.println("克隆对象值等于原始对象: " + javaCourse.equals(javaCourseClone));

        // 测试 2: 引用不同
        System.out.println("课程名称引用不同: " + (javaCourse.getCourseName() != javaCourseClone.getCourseName()));
        System.out.println("教师引用不同: " + (javaCourse.getTeacher() != javaCourseClone.getTeacher()));
        System.out.println("学生列表引用不同: " + (javaCourse.getStudents() != javaCourseClone.getStudents()));

        if (javaCourse.getStudents().size() > 0) {
            System.out.println("第一个学生引用不同: " + (javaCourse.getStudents().get(0) != javaCourseClone.getStudents().get(0)));
        }

        // 修改克隆对象
        javaCourseClone.setCourseName("高级 Java 编程");
        ((Faculty)javaCourseClone.getTeacher()).setTitle("正教授");
        if(javaCourseClone.getStudents().size() > 0) {
            ((Student)javaCourseClone.getStudents().get(0)).setDepartment("软件工程");
        }


        // 验证原始对象是否未更改
        System.out.println("\n修改克隆后的原始 Java 课程:\n" + javaCourse.toString());
        System.out.println("\n修改后的克隆 Java 课程:\n" + javaCourseClone.toString());

    }
}
