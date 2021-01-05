package org.raghav.unittesting.unittesting.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.raghav.unittesting.unittesting.model.Item;
import org.raghav.unittesting.unittesting.repository.ItemRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {
    @InjectMocks
    public ItemBusinessServiceImpl itemBusinessService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void retrieveAllItems_basic() {
        when(itemRepository.findAll()).thenReturn(List.of(
                new Item(1, "item1", 10, 20),
                new Item(2, "item2", 20, 30),
                new Item(3, "item3", 30, 40)
        ));
        List<Item> items = itemBusinessService.retrieveAllItems();

        assertEquals(200, items.get(0).getValue());
        assertEquals(600, items.get(1).getValue());

    }
}
