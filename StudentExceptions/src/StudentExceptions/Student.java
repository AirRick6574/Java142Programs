package StudentExceptions;

/*


    Modified by TODO: put your name here

    TODO: write a description of the Student.java class and your modifications here
 */
public class Student {
    private String name;
    private int age;
    private String major;

    public static final String[] MAJORS = {
            "Computer Science", "Mechanical Engineering", "Electrical Engineering", "Biomedical Engineering",
            "Chemical Engineering", "Aerospace Engineering", "Civil Engineering", "Physics", "Mathematics",
            "Biology", "Chemistry", "Environmental Science", "Robotics Engineering", "Materials Science",
            "Nuclear Engineering", "Biochemistry", "Geology", "Astronomy", "Statistics", "Computer Engineering"
    };

    /*
        TODO: when constructing a student, the name and majors must be non-null. The age must be at least 13 (inclusive).
                Additionally, the major must be within the above array of valid majors.
    */
    public Student(String name, int age, String major){
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    /*
        Increases the age of a student by the specified amount.
        TODO: it should not be possible to increase a student's age by a non-positive amount.
     */
    public void increaseAge(int amount){
        this.age = this.age + amount;
    }

    /*
        Changes the major of a student to the specified String.
        TODO: if the new major is not one of the options in the MAJORS array, an exception should be thrown.
     */
    public void changeMajor(String major){
        this.major = major;
    }

    /*
        Given an array of students, returns the average age.
     */
    public static double averageAge(Student[] students){
        // TODO: write the code to calculate average age here. Note that a student in the array may be null.
        // TODO: use a try-catch to handle this exception. Null students should not contribute to the average age.
        return 0.0;
    }
}
