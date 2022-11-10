import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("student");
        File csv = new File("student.csv");

        StudentManager studentManager =(StudentManager) _IOFile.readFile(file);
        if(studentManager == null){
            studentManager = new StudentManager(file);
        }

        Menu.menu(studentManager);

    }

}