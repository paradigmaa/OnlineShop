package com.shop.item.controller;

import com.shop.item.dto.ItemRequestDTO;
import com.shop.item.dto.ItemResponseDTO;
import com.shop.item.entity.Item;
import com.shop.item.itemMapper.itemMapper;
import com.shop.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public ResponseEntity<ItemResponseDTO> saveItem(@RequestBody ItemRequestDTO itemRequestDTO){
        Item item = itemMapper.itemRequestDTOToItem(itemRequestDTO);
        itemService.save(item);
        return new ResponseEntity<ItemResponseDTO>(itemMapper.itemToItemResponseDTO(item), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ItemResponseDTO>>getAllItem(){
        return ResponseEntity.ok(itemService.findAll().stream().map(ItemResponseDTO::new).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<ItemResponseDTO>>deletedItem(@PathVariable Long id){
        itemService.delete(id);
        return ResponseEntity.ok(getAllItem().getBody());
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<ItemResponseDTO>updateItem(@PathVariable Long id, @RequestBody ItemRequestDTO itemRequestDTO){
        Item resp = itemService.updateItem(id, itemMapper.itemRequestDTOToItem(itemRequestDTO));
        return ResponseEntity.ok(itemMapper.itemToItemResponseDTO(resp));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ItemResponseDTO> getItemId(@PathVariable Long id){
        ItemResponseDTO itemResponseDTO =  itemMapper.itemToItemResponseDTO(itemService.getItemById(id));
        return ResponseEntity.ok(itemResponseDTO);
    }
}
