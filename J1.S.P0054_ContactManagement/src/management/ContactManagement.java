package management;

import entity.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactManagement {

    private final List<Contact> list = new ArrayList<>();
    private int nextId = 1;

    public boolean addContact(List<Contact> list, Contact contact) {
        if (list == null || contact == null) {
            return false;
        }
        return list.add(contact);
    }

    public boolean addContact(Contact contact) {
        return addContact(list, contact);
    }

    public Contact createContact(String name, String group, String address, String phone) {
        Contact c = new Contact(nextId, name, group, address, phone);
        nextId++;
        addContact(c);
        return c;
    }

    public void displayAll(List<Contact> list) {
        System.out.printf("%-5s%-20s%-15s%-15s%-12s%-15s%-15s%n",
                "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact c : list) {
            System.out.printf("%-5d%-20s%-15s%-15s%-12s%-15s%-15s%n",
                    c.getId(), c.getFullName(), c.getFirstName(), c.getLastName(),
                    c.getGroup(), c.getAddress(), c.getPhone());
        }
    }

    public void displayAll() {
        displayAll(list);
    }

    public boolean deleteContact(List<Contact> list, Contact contact) {
        if (list == null || contact == null) {
            return false;
        }
        return list.remove(contact);
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Contact> getList() {
        return list;
    }
}
