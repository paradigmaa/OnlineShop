package com.shop.itemservice.service;

import com.shop.item.entity.Item;
import com.shop.item.repository.ItemRepository;
import com.shop.item.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void itemservice_create(){
        Item item = createItem();
        Mockito.when(itemRepository.save(item)).thenReturn(item);
        Item savedItem = itemService.save(item);
        assertNotNull(savedItem);
        assertEquals(1L, savedItem.getId());
        assertEquals("Item", savedItem.getItemName());
        assertEquals(new BigDecimal("0.00"), savedItem.getPrice());
        assertEquals(5L, savedItem.getQuantity());
        Mockito.verify(itemRepository, Mockito.times(1)).save(item);
    }

    @Test
    public void itemservice_findItemById(){
        Item item = createItem();
        Mockito.when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));
        Item findeByItem = itemService.getItemById(item.getId());
        assertNotNull(findeByItem);
        assertEquals(1L, findeByItem.getId());
        assertEquals("Item", findeByItem.getItemName());
        assertEquals(new BigDecimal("0.00"), findeByItem.getPrice());
        assertEquals(5L, findeByItem.getQuantity());
        Mockito.verify(itemRepository, Mockito.times(1)).findById(item.getId());
    }

    @Test
    public void itemservice_updateItem(){
        Item item = createItem();
        Item updateItem = createItem();
        Mockito.when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));
        Mockito.when(itemRepository.save(item)).thenReturn(updateItem);
        Item savedItem = itemService.save(item);
        assertNotNull(savedItem);
        assertEquals(1L, savedItem.getId());
        assertEquals("Item", savedItem.getItemName());
        assertEquals(new BigDecimal("0.00"), savedItem.getPrice());
        assertEquals(5L, savedItem.getQuantity());
        Mockito.verify(itemRepository, Mockito.times(1)).save(item);
    }

    @Test
    public void itemservice_deleteItem(){
        Item item = createItem();
        Mockito.when(itemRepository.findById(item.getId())).thenReturn(Optional.of(item));
        itemService.delete(item.getId());
        Mockito.verify(itemRepository, Mockito.times(1)).delete(item);
        Mockito.when(itemRepository.existsById(item.getId())).thenReturn(false);
        assertFalse(itemRepository.existsById(item.getId()));
    }

    @Test
    public void setItemService_getAllItems(){
        Item item1 = createItem();
        Item item2 = createItem();
        List<Item> items = Arrays.asList(item1, item2);
        Mockito.when(itemRepository.findAll()).thenReturn(items);
        List<Item>result = itemService.findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Item", result.get(0).getItemName());
        assertEquals("Item", result.get(1).getItemName());
    }



    private Item createItem(){
        Item item = new Item();
        item.setId(1L);
        item.setItemName("Item");
        item.setPrice(new BigDecimal("0.00"));
        item.setQuantity(5L);
        return item;
    }

}
