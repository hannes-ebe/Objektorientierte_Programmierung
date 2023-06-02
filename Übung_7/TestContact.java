import addressBook.*;
public class TestContact {
    public static void main(String[] args) {
        Contact contact = new Person();
        contact.setName(new Name("Sören", "Domrös"));
        Address b = new Address("Deutschland","Kiel", 24118, "Christian-Albrechts-Platz", 4);
        contact.setAddress(b);
        System.out.println(contact);
    }
}
