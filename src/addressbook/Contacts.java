package addressbook;

import java.util.Scanner;

public class Contacts {
    private String name;
    private long telnum;
    private String addressString;

    //Constructor
    public Contacts(String name, long telnum, String addresString) {
      this.name = name;
      this.telnum = telnum;
      this.addressString = addresString;
    }

    //Override Constructor
    public Contacts() {

    }

    //add a new contact
    public String addContact(){
      Scanner scanner = new Scanner(System.in);
      //用来存储要返回的sql语句的一部分
      String statement = "";
      System.out.println("Please enter the folowing fileds:");
      System.out.print("Name: ");
      this.name = scanner.nextLine();
      statement = statement + name + "', '";
      System.out.print("Telephone Number: ");
      this.telnum = scanner.nextLong();
      statement = statement + telnum + "', '";
      String nextline = scanner.nextLine();
      System.out.print("Address: ");
      this.addressString = scanner.nextLine();
      statement = statement + addressString + "');";

      return statement;
    }

    //delete a contact
    public void deleteContact(){

    }

    public void deleteAll(){

    }

      //search for contact according to the name, the telephone number or the address
    public void getContact(){

    }

    public void showAll(){

    }

    public void searchContact(){

    }

}
