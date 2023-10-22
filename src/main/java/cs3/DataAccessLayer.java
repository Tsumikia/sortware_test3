package cs3;

import cs2.Contact;

import java.util.ArrayList;
import java.util.List;

public class DataAccessLayer {
    private List<Contact> contacts;

    public DataAccessLayer() {
        this.contacts = new ArrayList<>();
        // 初始化一些示例数据
        contacts.add(new Contact("John Doe", "123 Main St", "555-1234"));
        contacts.add(new Contact("Jane Doe", "456 Oak St", "555-5678"));
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public void addContact(Contact newContact) {
        contacts.add(newContact);
    }

    public void updateContact(Contact updatedContact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getName().equals(updatedContact.getName())) {
                // 更新联系人信息
                existingContact.setAddress(updatedContact.getAddress());
                existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
                break;
            }
        }
    }

    public void deleteContact(String contactName) {
        contacts.removeIf(contact -> contact.getName().equals(contactName));
    }
}
