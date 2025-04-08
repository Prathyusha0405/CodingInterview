package com.example.watchlistms.controller;

import com.example.watchlistms.dto.CartRequest;
import com.example.watchlistms.dto.CartResponse;
import com.example.watchlistms.entity.Cart;
import com.example.watchlistms.service.CartService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/cart-service")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public ResponseEntity<Object> addToWatchlist(@RequestBody CartRequest request) {
        CartResponse response=cartService.addToCart(request);
        if(response!=null)
           return ResponseEntity.ok(response);
        else
        {
            response.setMessage("Product not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }
    }
}
