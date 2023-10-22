package cs3;

import cs2.Contact;

import java.util.List;
import java.util.Scanner;

public class AddressBookClient {
    private BusinessLogicLayer businessLogicLayer;

    public AddressBookClient(BusinessLogicLayer businessLogicLayer) {
        this.businessLogicLayer = businessLogicLayer;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n个人通讯录系统");
            System.out.println("1. 查看联系人信息");
            System.out.println("2. 添加新联系人");
            System.out.println("3. 修改联系人信息");
            System.out.println("4. 删除联系人");
            System.out.println("5. 退出");
            System.out.print("请选择操作：");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费掉输入缓冲区的换行符

            switch (choice) {
                case 1:
                    viewContacts();
                    break;
                case 2:
                    addContact(scanner);
                    break;
                case 3:
                    updateContact(scanner);
                    break;
                case 4:
                    deleteContact(scanner);
                    break;
                case 5:
                    System.out.println("退出程序，谢谢使用！");
                    return;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    private void viewContacts() {
        List<Contact> contacts = businessLogicLayer.getAllContacts();
        displayContacts(contacts);
    }

    private void addContact(Scanner scanner) {
        System.out.print("请输入新联系人姓名：");
        String name = scanner.nextLine();
        System.out.print("请输入新联系人地址：");
        String address = scanner.nextLine();
        System.out.print("请输入新联系人电话：");
        String phoneNumber = scanner.nextLine();

        Contact newContact = new Contact(name, address, phoneNumber);
        businessLogicLayer.addContact(newContact);
        System.out.println("新联系人已添加！");
    }

    private void updateContact(Scanner scanner) {
        System.out.print("请输入要修改的联系人姓名：");
        String name = scanner.nextLine();

        Contact updatedContact = new Contact();
        updatedContact.setName(name);

        System.out.print("请输入新的地址（保持为空以保持不变）：");
        updatedContact.setAddress(scanner.nextLine());
        System.out.print("请输入新的电话（保持为空以保持不变）：");
        updatedContact.setPhoneNumber(scanner.nextLine());

        businessLogicLayer.updateContact(updatedContact);
        System.out.println("联系人信息已更新！");
    }

    private void deleteContact(Scanner scanner) {
        System.out.print("请输入要删除的联系人姓名：");
        String name = scanner.nextLine();

        businessLogicLayer.deleteContact(name);
        System.out.println("联系人已删除！");
    }

    private void displayContacts(List<Contact> contacts) {
        System.out.println("\n联系人信息：");
        for (Contact contact : contacts) {
            System.out.println("姓名: " + contact.getName());
            System.out.println("地址: " + contact.getAddress());
            System.out.println("电话: " + contact.getPhoneNumber());
            System.out.println("--------------");
        }
    }
}