package storage;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;

public class PhoneBookFile {

    private static PhoneBookFile phoneBookFile;

    private PhoneBookFile(){}

    public static PhoneBookFile getInstance(){
        if(phoneBookFile == null){
            phoneBookFile = new PhoneBookFile();
        }
        return phoneBookFile;
    }

    public ArrayList<PhoneBook> readFile(String path) throws IOException, ClassNotFoundException {
        File file = new File(path);
        if(!file.exists()){
            file.createNewFile();
        }
        if(file.length() >0){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<PhoneBook> phoneBookArrayList = (ArrayList<PhoneBook>) ois.readObject();
            return phoneBookArrayList;
        }
        else return new ArrayList<>();
    }

    //ghi file
    public void writeFile(ArrayList<PhoneBook> phoneBookArrayList, String path) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(phoneBookArrayList);
    }
}
