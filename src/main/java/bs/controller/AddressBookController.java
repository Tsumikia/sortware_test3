package bs.controller;

import bs.domain.Contact;
import bs.service.BusinessLogicLayer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressBookController {
    private BusinessLogicLayer businessLogicLayer;

    public AddressBookController(BusinessLogicLayer businessLogicLayer) {
        this.businessLogicLayer = businessLogicLayer;
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return businessLogicLayer.getAllContacts();
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add-contact";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute Contact newContact) {
        businessLogicLayer.addContact(newContact);
        return "redirect:/addressbook/contacts";
    }

    @GetMapping("/update/{name}")
    public String showUpdateForm(@PathVariable String name, Model model) {
        Contact existingContact = businessLogicLayer.getAllContacts()
                .stream()
                .filter(contact -> contact.getName().equals(name))
                .findFirst()
                .orElse(null);

        model.addAttribute("contact", existingContact);
        return "update-contact";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute Contact updatedContact) {
        businessLogicLayer.updateContact(updatedContact);
        return "redirect:/addressbook/contacts";
    }

    @GetMapping("/delete/{name}")
    public String deleteContact(@PathVariable String name) {
        businessLogicLayer.deleteContact(name);
        return "redirect:/addressbook/contacts";
    }
}