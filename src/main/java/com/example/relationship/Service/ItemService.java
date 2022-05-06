package com.example.relationship.Service;

import com.example.relationship.Repository.ItemRepository;
import com.example.relationship.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**  ADD ITEM*/
    public Item addItem(Item item){
        return itemRepository.save(item);
    }

    /** GET ALL ITEMS */
    public List<Item> getItems(){
//        List<Item> items = new ArrayList<>();
//        itemRepository.findAll()

        return StreamSupport.stream(itemRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /** GET ITEM BY ID */
    public Item getItem(Long id){
        return itemRepository.findById(id).get();
    }


    /** DELETE ITEM */
    public Item deleteItem(Long id){
        Item item = getItem(id);
        itemRepository.delete(item);
        return  item;
    }

//    /**  EDIT ITEM */
////    @Transactional
////    public Item editItem(Long id, Item newItem){
////        Item item = getItem(id);
////        item.setSerialNumber(newItem.getSerialNumber());
////        itemRepository.save(item);
////        return item;
////    }

}
