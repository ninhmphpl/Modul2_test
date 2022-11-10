import java.io.File;

public class Menu {

    public static void menu(StudentManager students){
        while (true){
            System.out.println("""
                    ----- STUDENT MANAGER------
                    1. Display all student
                    2. Add new student
                    3. Update student
                    4. Delete student
                    5. Sort
                    6. Read File
                    7. Write File
                    8. Exit
                    """);
            switch (Input.inputRange("Input choice: ", 1, 8)){
                case 1 -> students.display();
                case 2 -> students.add();
                case 3 -> students.update();
                case 4 -> students.delete();
                case 5 -> {
                    boolean flag;
                    do {
                        flag = true;
                        System.out.println("""
                                --- SORT STUDENT BY AVG ---
                                1. Up sort
                                2. Dow Sort
                                3. Back
                                """);
                        switch (Input.inputInt("Input choice: ")) {
                            case 1 -> students.displayUp(true);
                            case 2 -> students.displayUp(false);
                            case 3 -> flag = false;
                        }
                    } while (flag);
                }
                case 6 -> System.out.println("Empty");
                case 7 -> _IOFile.writeFileCSV(students.getList(), new File("student.csv"));
                case 8 -> System.exit(0);
            }
        }

    }
}
