import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    public  void removeWhenProductExistTest() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Lolita", 200, "Nabokov");
        Book book2 = new Book(2, "Institute", 300, "King");
        Book book3 = new Book(3, "Lolita 2", 400, "Nabokov");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

       repo.removeById(1);

       Product[] actual = repo.findAll();
       Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void removeWhenProductNotExistTest() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Lolita", 200, "Nabokov");
        Book book2 = new Book(2, "Institute", 300, "King");
        Book book3 = new Book(3, "Lolita 2", 400, "Nabokov");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(4)
                );

     //   repo.removeById(4);

     //   Product[] actual = repo.findAll();
       // Product[] expected = {book1, book2, book3};

      //  Assertions.assertArrayEquals(expected, actual);
    }
}