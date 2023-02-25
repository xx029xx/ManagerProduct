import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    public  void addTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lolita", 200, "Nabokov");
        Book book2 = new Book(2, "Institute", 300, "King");
        Book book3 = new Book(3, "Doctor sleep", 400, "King");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void searchWhenOneProductsFoundTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lolita", 200, "Nabokov");
        Book book2 = new Book(2, "Institute", 300, "King");
        Book book3 = new Book(3, "Doctor sleep", 400, "King");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Institute");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void searchWhenFewProductsFoundTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Lolita", 200, "Nabokov");
        Book book2 = new Book(2, "Institute", 300, "King");
        Book book3 = new Book(3, "Lolita 2", 400, "Nabokov");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Lolita");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void addSmartphoneTest() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Smartphone smartphone1 = new Smartphone(1, "Iphone 1", 2000, "Apple");
        Smartphone smartphone2 = new Smartphone(2, "Galaxy", 3000, "Samsung");
        Smartphone smartphone3 = new Smartphone(3, "Iphone 2", 4000, "Apple");

        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }
}