package com.shop.item.controller;

import com.shop.ItemApplication;
import com.shop.item.entity.Item;
import com.shop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/save")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        return new ResponseEntity<Item>(itemService.save(item), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>>getAllItem(){
        return ResponseEntity.ok(itemService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Item>>deletedItem(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.ok(itemService.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Item>updateItem(@PathVariable Long id, @RequestBody Item item){
        Item updateItem = itemService.updateItem(id, item);
        return new ResponseEntity<Item>(updateItem, HttpStatus.OK);
    }
}
