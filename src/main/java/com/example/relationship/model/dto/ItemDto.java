package com.example.relationship.model.dto;

import com.example.relationship.model.Item;

public class ItemDto {
    private Long id;
    private String serialNumber;

    /** FUNCTION TO TRANSFER ENTITY TO DTO*/
    public static ItemDto from(Item item){
        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setSerialNumber(item.getSerialNumber());
        return itemDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
