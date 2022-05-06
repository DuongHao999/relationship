package com.example.relationship.model;

import com.example.relationship.model.dto.ItemDto;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "card_id")  // tao khoa ngoai voi ten card_ia trong database
    private Cart cart;  // tuong ung voi class iten co phan mappedby  cart


    /**TRANSFER DTO TO ENTITY */
    public static Item from(ItemDto itemDto){
        Item item = new Item();
        item.setId(itemDto.getId());
        item.setSerialNumber(itemDto.getSerialNumber());
        return item;
    }


    public Item() {
    }

    public Item(String serialNumber, Cart cart) {
        this.serialNumber = serialNumber;
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
