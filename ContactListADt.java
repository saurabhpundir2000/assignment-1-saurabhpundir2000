package adt;

import definition.Person;

public interface ContactListADT<person> {

    boolean add(Person person);

    boolean delete(int index);

    void search(String name);

    void viewAllContacts();

}
