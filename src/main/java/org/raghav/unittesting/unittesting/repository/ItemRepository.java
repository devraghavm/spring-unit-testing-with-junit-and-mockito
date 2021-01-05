package org.raghav.unittesting.unittesting.repository;

import org.raghav.unittesting.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
