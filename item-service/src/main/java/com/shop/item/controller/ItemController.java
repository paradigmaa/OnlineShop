package com.shop.item.controller;

import com.shop.item.entity.Item;
import com.shop.item.service.ItemService;
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

    @PostMapping("/create")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        return new ResponseEntity<Item>(itemService.save(item), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Item>>getAllItem(){
        return ResponseEntity.ok(itemService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Item>>deletedItem(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.ok(getAllItem().getBody());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Item>updateItem(@PathVariable Long id, @RequestBody Item item){
        Item resp = itemService.updateItem(id, item);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getItemId(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getItemById(id));
    }
}
