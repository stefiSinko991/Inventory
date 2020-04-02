package inventory.service;

        import inventory.model.AbstractPart;
        import inventory.repository.InventoryRepository;
        import org.junit.jupiter.api.*;

        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;

        import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceTest {

    private String validTitle = "Screw";
    private String invalidTitle = "";
    private int validPrice = 5;
    private double validPrice2 = 0.1;
    private int invalidPrice = -5;
    private int inStock = 100;
    private int min = 10;
    private int max = 200;
    private int partDynamicValue = 1;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    @DisplayName("TestECP")
    void ECP_non_valid1() {
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);

        try {
            service.addInhousePart(invalidTitle, validPrice, inStock, min, max, partDynamicValue);
        }catch(IllegalArgumentException e){
            assertEquals(e.getMessage(),"A name has not been entered. ");
        }
    }
    //@Test
    @RepeatedTest(2)
    void ECP_valid(){
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);
        int size = service.getAllParts().size();

        service.addInhousePart(validTitle, validPrice, inStock, min, max, partDynamicValue);
        assertEquals(service.getAllParts().size(), size+1);
    }
    @Test
    @Order(2)
    void ECP_non_valid2()
    {
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);

        try {
            service.addInhousePart(validTitle, invalidPrice, inStock, min, max, partDynamicValue);
        }catch(IllegalArgumentException e){
            assertEquals(e.getMessage(),"The price must be greater than 0. ");
        }
    }
    @Test
    @Order(1)
    void BVA_valid_1(){
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);
        int size = service.getAllParts().size();
        service.addInhousePart(validTitle, validPrice, inStock, min, max, partDynamicValue);
        assertEquals(service.getAllParts().size(), size+1);
    }
    @Test
    void BVA_valid_2(){
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);
        int size = service.getAllParts().size();
        service.addInhousePart(validTitle, validPrice2, inStock, min, max, partDynamicValue);
        assertEquals(service.getAllParts().size(), size+1);
    }
    @Test
    void BVA_non_valid_1(){
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);

        try {
            service.addInhousePart(validTitle, invalidPrice, inStock, min, max, partDynamicValue);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"The price must be greater than 0. ");
        }
    }
    @Test
    void BVA_non_valid_2(){
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);

        try {
            service.addInhousePart(invalidTitle, invalidPrice, inStock, min, max, partDynamicValue);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(),"A name has not been entered. The price must be greater than 0. ");
        }
    }
    @Disabled
    @Test
    void test()
    {
        System.out.println("disabled");
    }

}