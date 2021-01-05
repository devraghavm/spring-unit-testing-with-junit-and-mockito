package org.raghav.unittesting.unittesting.service;

import org.raghav.unittesting.unittesting.model.Item;

import java.util.List;

public interface ItemBusinessService {
    Item retrieveHardcodedItem();

    List<Item> retrieveAllItems();
}
