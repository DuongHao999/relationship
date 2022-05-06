package com.example.relationship.model.dto;

import com.example.relationship.model.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartDto {
    private Long id;
    private String name;
    private List<ItemDto> itemsDto = new ArrayList<>();

    /** FUNCTION TO TRANSFER ENTITY TO DTO */
    public static CartDto from(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setName(cart.getName());
        cartDto.setItemsDto(cart.getItems().stream().map(ItemDto::from).collect(Collectors.toList())); // get tung item entity to item dto
        return cartDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemDto> getItemsDto() {
        return itemsDto;
    }

    public void setItemsDto(List<ItemDto> itemsDto) {
        this.itemsDto = itemsDto;
    }
}
