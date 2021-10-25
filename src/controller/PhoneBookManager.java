package controller;

import model.PhoneBook;
import storage.PhoneBookFile;

import java.io.IOException;
import java.util.ArrayList;

public class PhoneBookManager {
    ArrayList<PhoneBook> phoneBookArrayList = new ArrayList<>();
    PhoneBookFile phoneBookFile = PhoneBookFile.getInstance();

    public PhoneBookManager(ArrayList<PhoneBook> phoneBookArrayList) {
        this.phoneBookArrayList = phoneBookArrayList;
    }

    public ArrayList<PhoneBook> getPhoneBookArrayList() {
        return phoneBookArrayList;
    }

    public void setPhoneBookArrayList(ArrayList<PhoneBook> phoneBookArrayList) {
        this.phoneBookArrayList = phoneBookArrayList;
    }

    public void showPhoneBook(){
        for (PhoneBook p:phoneBookArrayList) {
            System.out.println(p);
        }
    }

    public void addPhoneBook(PhoneBook phoneBook){
        phoneBookArrayList.add(phoneBook);
    }

    public void editPhoneBook(String phoneNumber, PhoneBook phoneBook){
        for (int i=0; i<phoneBookArrayList.size(); i++){
            if(phoneBookArrayList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBookArrayList.set(i, phoneBook);
                break;
            }
        }
    }

    public void removePhoneBook(String phoneNumber){
        for (int i=0; i<phoneBookArrayList.size(); i++){
            if(phoneBookArrayList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBookArrayList.remove(i);
                break;
            }
        }
    }

    public PhoneBook findPhoneBookFromPhoneNumber(String phoneNumber){
        PhoneBook phoneBook = null;
        for (int i=0; i<phoneBookArrayList.size(); i++){
            if(phoneBookArrayList.get(i).getPhoneNumber().equals(phoneNumber)){
                phoneBook = phoneBookArrayList.get(i);
                break;
            }
        }
        return phoneBook;
    }

    public void writeFile(String path) throws IOException {
        phoneBookFile.writeFile(phoneBookArrayList, path);
    }

    public void readFile(String path) throws IOException, ClassNotFoundException {
        setPhoneBookArrayList(phoneBookFile.readFile(path));
    }
}
