package inventory.repository;

import inventory.model.AbstractPart;
import inventory.model.OutsourcedPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.xml.bind.ValidationException;


public class InventoryRepositoryTestMockito {
    @Mock
    private InventoryRepository repo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findPart() throws ValidationException {
        AbstractPart part = new OutsourcedPart(1, "Part1", 10.0, 5, 0, 10, "Company1");
        Mockito.when(repo.lookupPart("Part1")).thenReturn(null);
        Mockito.doNothing().when(repo).addPart(part);
        Mockito.when(repo.lookupPart("Part1")).thenReturn(part);
    }

    @Test
    public void addPartWithException() throws ValidationException {
        AbstractPart part = new OutsourcedPart(1, "Part 1", -5.0, 5, 0, 10, "Company1");
        Mockito.doThrow(ValidationException.class).when(repo).addPart(part);
    }
}