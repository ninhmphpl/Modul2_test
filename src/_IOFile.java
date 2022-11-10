
import java.io.*;
import java.util.ArrayList;

public class _IOFile {


    public static void checkFile(File file){
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void writeFile(Object object, File file, boolean append){
        checkFile(file);

        try(FileOutputStream fileOutputStream = new FileOutputStream(file,append);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(object);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage() + ": File is not exist!");
        } catch (IOException e) {
            System.err.println(e.getMessage() + ": Write file error!");
        }
    }


    public static Object readFile(File file){
        checkFile(file);
        ObjectInputStream objectInputStream;
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            if (fileInputStream.available()>0){
                objectInputStream = new ObjectInputStream(fileInputStream);
                return objectInputStream.readObject();
            }else return null;

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage() + "File is not exist!");
            return null;
        } catch (IOException e) {
            System.err.println(e.getMessage() + ": Read file error!");
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void writeFileCSV(ArrayList<Student> list, File file){
        try {
            checkFile(file);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append("id,Name,Age,Gender,Address,Avg");
            for (Student student : list){
                fileWriter.append(String.valueOf(student.getId()));
                fileWriter.append(',');
                fileWriter.append(student.getName());
                fileWriter.append(',');
                fileWriter.append(String.valueOf(student.getAge()));
                fileWriter.append(',');
                fileWriter.append(student.isGender()? "Boy": "Girl");
                fileWriter.append(',');
                fileWriter.append(student.getAddress());
                fileWriter.append(',');
                fileWriter.append(String.valueOf(student.getAvg()));
                fileWriter.append('\n');
            }
            fileWriter.close();
            System.out.println("Done");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }






}
