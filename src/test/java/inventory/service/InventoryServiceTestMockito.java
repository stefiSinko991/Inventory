package inventory.service;

import inventory.model.*;
import inventory.repository.InventoryRepository;
import org.junit.jupiter.api.*;
import org.mockito.*;
import javax.xml.bind.ValidationException;

import static org.mockito.Mockito.times;

public class InventoryServiceTestMockito {

    @Mock
    private InventoryRepository repo;

    @InjectMocks
    private InventoryService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addPart() throws ValidationException {
        AbstractPart part = new OutsourcedPart(0,"Part1", 10.0, 5, 0, 10, "Company1");
        Mockito.verify(repo, times(0)).addPart(part);
        service.addOutsourcePart("Part1", 10.0, 5, 0, 10, "Company1");
        Mockito.verify(repo, times(1)).addPart(part);
    }

    @Test
    public void addPartInvalidPrice() throws ValidationException {
        AbstractPart part = new OutsourcedPart(0,"Part1", 10.0, 5, 0, 10, "Company1");
        Mockito.verify(repo, times(0)).addPart(part);
        service.addOutsourcePart("Part1", -5, 5, 0, 10, "Company1");
        Mockito.verify(repo, times(0)).addPart(part);
    }

}