package com.example.relationship.Controller;

import com.example.relationship.Service.ItemService;
import com.example.relationship.model.Item;
import com.example.relationship.model.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    ItemService itemService;

    /** ADD ITEM*/

    @PostMapping
    public ResponseEntity<ItemDto> addItem(ItemDto itemDto){
        Item item = itemService.addItem(Item.from(itemDto));
        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

    /** GET ITEM LIST */
    @GetMapping
    public ResponseEntity<List<ItemDto>> getItems(){
        List<Item> items = itemService.getItems();
        List<ItemDto> itemDtos = items.stream().map(ItemDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemDtos,HttpStatus.OK);
    }

    /** DELETE ITEM*/
    @DeleteMapping(value = "{id}")
    public ResponseEntity<ItemDto> deleteItem(@PathVariable final Long id){
        Item item = itemService.deleteItem(id);
        return new ResponseEntity<>(ItemDto.from(item), HttpStatus.OK);
    }

//    /** EDIT ITEM*/
////    @PutMapping(value = "{id}")
////    public ResponseEntity<ItemDto> editItem(@PathVariable final Long id,
////                                            @RequestBody final ItemDto itemDto){
////        Item editedItem = itemService.editItem(id, Item.from(itemDto));
////        return new ResponseEntity<>(ItemDto.from(editedItem), HttpStatus.OK);
////    }
}
