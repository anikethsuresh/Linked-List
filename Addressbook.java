import java.util.Scanner;
public class Addressbook{
    public static void main(String []args){
        Table book = new Table(null, null, null);
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("----------------------------");
            System.out.println("Add a name [n]");
            System.out.println("Look up a name [l]");
            System.out.println("Update address [u]");
            System.out.println("Delete an entry [d]");
            System.out.println("Display all entries [a]");
            System.out.println("Quit [q]");
            String msg = scanner.nextLine();
            switch (msg) {
                case "n":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter address:");
                    String address = scanner.nextLine();
                    if(book.insert(name, address)){
                        System.out.println("Added!");
                    }else{
                        System.out.println("Failed!");
                    }
                    break;
                case "l":
                    System.out.println("Enter name:");
                    String key = scanner.nextLine();
                    System.out.println("Address:" + book.lookUp(key));
                    break;
                case "u":
                    System.out.println("Enter name:");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter new address");
                    String updateAddress = scanner.nextLine();
                    String oldAddress = book.lookUp(updateName);
                    book.update(updateName, updateAddress);
                    System.out.println("Name:" + updateName);
                    System.out.println("Old address:" + oldAddress);
                    System.out.println("New address:" + updateAddress);
                    break;
                case "d":
                    System.out.println("Name to delete:");
                    String deleteName = scanner.nextLine();
                    if(book.delete(deleteName)){
                        System.out.println("deleted!");
                    }else{
                        System.out.println("Key not found!");
                    }
                    //book.delete(deleteName);
                    break;
                case "a":
                    //int number = book.displayAll();
                    System.out.println("Total number of entries:" + book.displayAll());
                    //book.displayAll();
                    break;
                case "q":
                    System.exit(0);
                    break;
                default :
                    System.out.println("No such command");
            }
        }
    }
}