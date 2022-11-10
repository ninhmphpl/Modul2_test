import java.io.Serializable;

public class Student implements Serializable {
    private long id;
    private String name;
    private int age;
    private boolean gender;
    private String address;
    private double avg;

    public Student() {
    }

    public Student(long id, String name, int age, boolean gender, String address, double avg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.avg = avg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        String gender = this.gender? "Boy": "Girl";
        return String.format("%-10d%-20s%-10d%-20s%-40s%-10f", id, name, age, gender, address, avg);
    }
}
