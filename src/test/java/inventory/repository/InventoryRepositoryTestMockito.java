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
    public void findPart() {
        AbstractPart part = new OutsourcedPart(1, "Part1", 10.0, 5, 0, 10, "Company1");
        Mockito.when(repo.lookupPart("Part1")).thenReturn(null);
        Mockito.doNothing().when(repo).addPart(part);
        Mockito.when(repo.lookupPart("Part1")).thenReturn(part);
    }

    @Test
    public void updatePart() {
        AbstractPart part = new OutsourcedPart(1, "Part1", 10.0, 5, 0, 10, "Company1");
        Mockito.when(repo.lookupPart("Part1")).thenReturn(null);
        Mockito.doNothing().when(repo).addPart(part);
        Mockito.when(repo.lookupPart("Part1")).thenReturn(part);
        AbstractPart part2 = new OutsourcedPart(1, "Part2", 10.0, 5, 0, 10, "Company1");
        Mockito.doNothing().when(repo).updatePart(part.getPartId() , part2);
        Mockito.when(repo.lookupPart("Part2")).thenReturn(part);

    }

    @Test
    public void updatePartWithException() {
        AbstractPart part = new OutsourcedPart(1, "Part1", 10.0, 5, 0, 10, "Company1");
        Mockito.when(repo.lookupPart("Part1")).thenReturn(null);
        Mockito.doNothing().when(repo).addPart(part);
        Mockito.when(repo.lookupPart("Part1")).thenReturn(part);
        AbstractPart part2 = new OutsourcedPart(1, "Part2", -5.0, 5, 0, 10, "Company1");
        Mockito.doNothing().when(repo).updatePart(part.getPartId() , part2);
        Mockito.when(repo.lookupPart("Part2")).thenReturn(null);

    }

    @Test
    public void addPartWithException(){
        AbstractPart part = new OutsourcedPart(1, "Part 1", -5.0, 5, 0, 10, "Company1");
        Mockito.doNothing().when(repo).addPart(part);
        Mockito.when(repo.lookupPart("Part 1")).thenReturn(null);
    }
}