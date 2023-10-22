package bs.service;

import bs.dba.DataAccessLayer;
import bs.domain.Contact;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BusinessLogicLayer {
    private DataAccessLayer dataAccessLayer;

    public BusinessLogicLayer(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    public List<Contact> getAllContacts() {
        return dataAccessLayer.getAllContacts();
    }

    public void addContact(Contact newContact) {
        dataAccessLayer.addContact(newContact);
    }

    public void updateContact(Contact updatedContact) {
        dataAccessLayer.updateContact(updatedContact);
    }

    public void deleteContact(String contactName) {
        dataAccessLayer.deleteContact(contactName);
    }
}