package org.raghav.unittesting.unittesting.service;

import org.raghav.unittesting.unittesting.model.Item;
import org.raghav.unittesting.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessServiceImpl implements ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @Override
    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();
        items.stream().forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
        return itemRepository.findAll();
    }
}
