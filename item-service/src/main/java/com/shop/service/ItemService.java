package com.shop.service;
import brave.internal.baggage.BaggageContext;
import com.shop.item.entity.Item;
import com.shop.item.exception.ItemNotFoundException;
import com.shop.item.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;


    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional(readOnly = true)
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("item not found" + id));
    }

    public Item save(Item item) {
       return itemRepository.save(item);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item updateItem(Long id, Item item){
        Item oldItem = getItemById(id);
        oldItem.setItemName(item.getItemName());
        return save(oldItem);
    }
}
