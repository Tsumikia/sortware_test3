package bs.dba;

import bs.domain.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataAccessLayer {
    private List<Contact> contacts;

    public DataAccessLayer() {
        this.contacts = new ArrayList<>();
        // 初始化一些示例数据
        contacts.add(new Contact("Minako", "music ray'n", "91-0917"));
        contacts.add(new Contact("Haruka", "music ray'n", "90-0204"));
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