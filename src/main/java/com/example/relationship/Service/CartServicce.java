package com.example.relationship.Service;

import com.example.relationship.Repository.CartRepository;
import com.example.relationship.model.Cart;
import com.example.relationship.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartServicce {

    @Autowired
    CartRepository cardCartRepository;

    @Autowired
    ItemService itemService;

    /** ADD CART*/
    public Cart addCart(Cart cart){
        return cardCartRepository.save(cart);
    }

    /** GET CART LIST*/
    public List<Cart> getCarts(){
        return StreamSupport.stream(cardCartRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /** GET CART BY ID*/
    public Cart getCart(Long id){
        return cardCartRepository.findById(id).get();
    }

    /** DELETE CART*/
    public Cart deleteCart(Long id){
        Cart cart = getCart(id);
        cardCartRepository.delete(cart);
        return cart;
    }

    /** EDIT CART */
    //    @Transactional
    public Cart editCart(Long id, Cart newCart){
        Cart cart = getCart(id);
        cart.setName(newCart.getName());
        return cart;
    }

    /** ADD ITEM INTO CART*/
    //    @Transactional
    public Cart addItemToCart(Long cartId, Long itemId){
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);

        if(Objects.nonNull(item.getCart())){ // getCart: getter setter
            return null;
        }
        cart.addItem(item);
        item.setCart(cart);
        return cart;
    }

    /** REMOVE ITEM FROM CART */
//    @Transactional
    public Cart removeItemFromCart(Long cartId, Long itemId){
        Cart cart = getCart(cartId);
        Item item = itemService.getItem(itemId);
        cart.removeItem(item);
        return cart;
    }

}
