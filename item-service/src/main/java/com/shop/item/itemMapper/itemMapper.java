package com.shop.item.itemMapper;

import com.shop.item.dto.ItemRequestDTO;
import com.shop.item.dto.ItemResponseDTO;
import com.shop.item.entity.Item;

public class itemMapper {
    public static ItemResponseDTO itemToItemResponseDTO(Item item) {
        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
        itemResponseDTO.setId(item.getId());
        itemResponseDTO.setItemName(item.getItemName());
        itemResponseDTO.setPrice(item.getPrice());
        itemResponseDTO.setQuantity(item.getQuantity());
        itemResponseDTO.setCreatedAt(item.getCreatedAt());
        itemResponseDTO.setLastUpdate(item.getLastUpdate());
        return itemResponseDTO;
    }
    public static Item itemRequestDTOToItem(ItemRequestDTO itemRequestDTO) {
        Item item = new Item();
        item.setId(itemRequestDTO.getId());
        item.setItemName(itemRequestDTO.getItemName());
        item.setPrice(itemRequestDTO.getPrice());
        item.setQuantity(itemRequestDTO.getQuantity());
        return item;
    }

    public static ItemResponseDTO itemRequestDTOToResponseDTO(ItemRequestDTO itemRequestDTO) {
        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
        itemResponseDTO.setId(itemRequestDTO.getId());
        itemResponseDTO.setItemName(itemRequestDTO.getItemName());
        itemResponseDTO.setPrice(itemRequestDTO.getPrice());
        itemResponseDTO.setQuantity(itemRequestDTO.getQuantity());
        return itemResponseDTO;
    }




}
