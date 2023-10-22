package cs3;

public class Main {
    public static void main(String[] args) {
        new AddressBookClient(new BusinessLogicLayer(new DataAccessLayer())).run();
    }
}
