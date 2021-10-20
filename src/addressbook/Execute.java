package addressbook;

import java.util.Scanner;

public class Execute {
    final int EXIT_OK = 1;
    //welcome
    public void welcome() {
        System.out.println("---------------------------");
        System.out.println("Welcome to use the program!");
        System.out.println("---------------------------");
      }
      //display user menu
      public void displayMenu(){
        welcome();
        System.out.println("You can do operations below: ");
        System.out.println("1.Add a new contact");
        System.out.println("2.Show all contacts");
        System.out.println("3.Delete a contact");
        System.out.println("4.Search for a contact");
        System.out.println("0.Quit the program");
        System.out.print("Please enter a number: ");
      }

    public int getCommand() {
        int cmdNum;
        Scanner scanner = new Scanner(System.in);
        cmdNum = scanner.nextInt();
        // scanner.close();
        return cmdNum;
    }
    //excute the program using a loop
    public void executeLogic() {
        int choice;
        task:
        do {
            displayMenu();
            choice = getCommand();
            switch (choice) {
                case 1:
                    Contacts newContact = new Contacts();
                    MySQL mysql = new MySQL();
                    mysql.excuteInsertStmt(newContact.addContact());
                    break;
                
                case 0:
                    break task;
            }
        } while (choice != 0);
        System.out.println("Exited the program...");
        System.exit(EXIT_OK);
    }
}
