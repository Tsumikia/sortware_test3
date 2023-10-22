package cs3;

import cs2.Contact;

import java.util.List;

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