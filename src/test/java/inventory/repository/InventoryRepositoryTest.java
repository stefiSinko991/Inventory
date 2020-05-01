
        package inventory.repository;

        import inventory.model.InhousePart;
        import inventory.model.AbstractPart;
        import org.junit.jupiter.api.*;

        import java.io.FileNotFoundException;
        import java.io.PrintWriter;

        import static org.junit.jupiter.api.Assertions.*;

public class InventoryRepositoryTest {

    private AbstractPart part;
    private InventoryRepository inventoryRepository;
    private String filename = "data/test_itemsL3.txt";

    @BeforeAll
    static void setup() {
        System.out.println("Testing started");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Testing stopped");
    }

    @BeforeEach
    void setUp() throws FileNotFoundException {

        inventoryRepository = new InventoryRepository(filename);
        part = new InhousePart(1,"part1",3.75,14,4,40,12);

    }

    @AfterEach
    void tearDownEach() throws FileNotFoundException {

    }

    @Test
    void F02_TC01() {
        Assertions.assertEquals(inventoryRepository.lookupPart("part1"), part);
    }

    @Test
    void F02_TC02() {
        part.setPartId(2);
        part.setName("part2");
        Assertions.assertEquals(inventoryRepository.lookupPart("2"), part);

    }

    @Test
    void F02_TC03() {
        Assertions.assertNull(inventoryRepository.lookupPart("part4"));
    }

    @Test
    void F02_TC04() {
        Assertions.assertNull(inventoryRepository.lookupPart("-"));

    }

    @Test
    void F02_TC05() {
        part.setPartId(2);
        part.setName("part2");
        Assertions.assertEquals(inventoryRepository.lookupPart("part2"), part);
    }
}