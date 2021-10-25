package view;

import controller.PhoneBookManager;
import model.PhoneBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PhoneBook> phoneBookArrayList = new ArrayList<>();
        PhoneBookManager phoneBookManager = new PhoneBookManager(phoneBookArrayList);


        int choice;
        do{
            System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năng");
            Scanner inputChoice = new Scanner(System.in);
            choice = inputChoice.nextInt();
            switch (choice){
                case 1:
                    displayPhoneBook(phoneBookManager);
                    break;
                case 2:
                    addPhoneBook(phoneBookManager);
                    break;
                case 3:
                    updateBookManager(phoneBookManager);
                    break;
                case 4:
                    deletePhoneBook(phoneBookManager);
                    break;
                case 5:
                    searchPhoneBook(phoneBookManager);
                    break;
                case 6:
                    readPhoneBook(phoneBookManager);
                    break;
                case 7:
                    writePhoneBook(phoneBookManager);
                    break;
            }
        } while (choice!=0);
    }

    private static void addPhoneBook(PhoneBookManager phoneBookManager) {
        phoneBookManager.addPhoneBook(creatPhoneBook());
    }

    private static void displayPhoneBook(PhoneBookManager phoneBookManager) {
        phoneBookManager.showPhoneBook();
    }

    private static void writePhoneBook(PhoneBookManager phoneBookManager) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter file");
        String file=scanner.nextLine();
        try {
            phoneBookManager.writeFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readPhoneBook(PhoneBookManager phoneBookManager) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter file");
        String file=scanner.nextLine();
        try {
            phoneBookManager.readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void searchPhoneBook(PhoneBookManager phoneBookManager) {
        PhoneBook phoneBook2 = phoneBookManager.findPhoneBookFromPhoneNumber(inputPhoneNumber());
        if(phoneBook2 != null){
            System.out.println(phoneBook2);
        }
        else System.out.println("Số điện thoại này ko có trong Danh bạ");
    }

    private static void deletePhoneBook(PhoneBookManager phoneBookManager) {
        PhoneBook phoneBook1 = phoneBookManager.findPhoneBookFromPhoneNumber(inputPhoneNumber());
        if(phoneBook1 != null){
            phoneBookManager.removePhoneBook(phoneBook1.getPhoneNumber());
        }
        else System.out.println("Số điện thoại này ko có trong Danh bạ");
    }

    private static void updateBookManager(PhoneBookManager phoneBookManager) {
        PhoneBook phoneBook = phoneBookManager.findPhoneBookFromPhoneNumber(inputPhoneNumber());
        if(phoneBook != null){
            phoneBookManager.editPhoneBook(phoneBook.getPhoneNumber(), creatPhoneBook());
        }
        else System.out.println("Số điện thoại này ko có trong Danh bạ");
    }

    public static PhoneBook creatPhoneBook(){
        System.out.println("Nhập số điện thoại");
        Scanner inputPhoneNumber = new Scanner(System.in);
        String phoneNumber = inputPhoneNumber.nextLine();
        System.out.println("Nhập nhóm");
        Scanner inputGroup = new Scanner(System.in);
        String group = inputGroup.nextLine();
        System.out.println("Nhập tên");
        Scanner inputName = new Scanner(System.in);
        String name = inputName.nextLine();
        System.out.println("Nhập giới tính");
        Scanner inputGender = new Scanner(System.in);
        String gender = inputGender.nextLine();
        System.out.println("Nhập địa chỉ");
        Scanner inputAddress = new Scanner(System.in);
        String address = inputAddress.nextLine();
        System.out.println("Nhập ngày tháng năm sinh");
        Scanner inputBirthday = new Scanner(System.in);
        String birthday = inputBirthday.nextLine();
        System.out.println("Nhập email");
        Scanner inputEmail = new Scanner(System.in);
        String email = inputEmail.nextLine();
        PhoneBook phoneBook = new PhoneBook(phoneNumber, group, name, gender, address, birthday, email);
        return phoneBook;
     }

     public static String inputPhoneNumber(){
         System.out.println("Nhập số điện thoại cần tìm");
         Scanner inputPhoneNumber = new Scanner(System.in);
         String phoneNumber = inputPhoneNumber.nextLine();
         return phoneNumber;
     }


}
