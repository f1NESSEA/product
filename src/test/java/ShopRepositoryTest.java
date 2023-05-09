import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product item1 = new Product(1, "Кола", 100);
    Product item2 = new Product(24, "Фанта", 90);
    Product item3 = new Product(75, "Дюшес", 70);
    Product item4 = new Product(55, "Тархун", 80);
    Product[] products = new Product[0];


    @Test
    public void shouldException() {

        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(100);

        });
    }

    @Test
    public void shouldRemoveItem() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.remove(24);

        Product[] expected = {item1, item3, item4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTextAlreadyExistsException() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(item3);
        });
    }

    @Test
    public void shouldAddProduct() {
        ShopRepository repo = new ShopRepository();
        Product item5 = new Product(21, "Чай", 50);
        repo.add(item5);

        Product[] expected = {item5};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}