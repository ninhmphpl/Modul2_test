import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class StudentManager implements Serializable {
    private final HashMap<Long, Student> students;
    private long id;
    File file;

    public StudentManager(File file) {
        students = new HashMap<>();
        this.file = file;
    }

    public void add(){
        String name = Input.inputString("Input Student Name: ");
        int age = Input.inputRange("Input age: ", 0, 100);
        boolean gender = Input.inputChoice("Input gender (1 = boy, 2 = girl): ");
        String address = Input.inputString("Input Address: ");
        double avg = Input.inputDoubleInRange("Input medium score: ", 0, 10);
        Student student = new Student(++id, name, age, gender, address, avg);
        students.put(student.getId(), student);
        save();
    }

    public void update(){
        long id = Input.inputLong("Input Student Id: ");
        if (!students.containsKey(id)){
            System.out.println("Student id is not exist! ");
            return;
        }
        Student student = students.get(id);
        String name = Input.inputString("Input Student Name(Enter to skip): ");
        name = name.equals("")? student.getName(): name;
        student.setName(name);

        int age = Input.inputRange("Input age(input -1 to skip): ", -1, 100);
        age = age == -1? student.getAge(): age;
        student.setAge(age);

        switch (Input.inputInt("Input Gender (1 = boy, 2 = girl, other = skip")){
            case 1 -> student.setGender(true);
            case 2 -> student.setGender(false);
        }

        String address = Input.inputString("Input Address: ");
        address = address.equals("")? student.getAddress(): address;
        student.setAddress(address);

        double avg = Input.inputDoubleInRange("Input medium score: ", 0, 10);
        avg = avg == -1? student.getAge(): avg;
        student.setAvg(avg);

        save();

    }

    public void delete(){
        long id = Input.inputLong("Input student id: ");
        if (!students.containsKey(id)){
            System.out.println("Student id is not exist!");
            return;
        }
        students.remove(id);
        save();
    }
    public void display(){
        display(new ArrayList<>(students.values()));
    }
    public void display(ArrayList<Student> a){
        System.out.printf("%-10s%-20s%-10s%-20s%-40s%-10s\n", "id", "Name", "Age", "Gender", "Address", "Avg" );
        for (Student student : a){
            System.out.println(student);
        }
    }
    public void displayUp(boolean up){
        ArrayList<Student> student = new ArrayList<>(students.values());
        student.sort(Comparator.comparing(Student :: getAvg));
        if (up){
            display(student);
        }else{
            System.out.printf("%-10s%-20s%-10s%-20s%-40s%-10s\n", "id", "Name", "Age", "Gender", "Address", "Avg" );
            for(int i = student.size()-1; i >=0 ; i--){
                System.out.println(student.get(i));
            }
        }

    }



    public void save(){
       _IOFile.writeFile(this, file, false);
    }
    public ArrayList<Student> getList(){
        return new ArrayList<>(students.values());
    }
}
