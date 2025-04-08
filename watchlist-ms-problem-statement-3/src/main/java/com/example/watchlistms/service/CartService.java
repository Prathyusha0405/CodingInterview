package com.example.watchlistms.service;

import com.example.watchlistms.dto.CartRequest;
import com.example.watchlistms.dto.CartResponse;
import com.example.watchlistms.entity.Cart;
import com.example.watchlistms.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository repository;
    @Autowired
    private WebClient.Builder webClient;
    public CartResponse addToCart(CartRequest cart) {
        Cart cart1 = new Cart();
        cart1.setProductId(cart.getProductId());
        cart1.setUserId(cart.getUserId());
        repository.save(cart1);
        String productId = cart1.getProductId();
        String url = "http://waquarcodes.mooo.com:4051/inventory/" + productId + "/availability";
        try {
            Map productDeatils = webClient.build().get().uri(url)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
            CartResponse cartResponse = new CartResponse();
            cartResponse.setCost((Double) productDeatils.get("price"));
            Double price = cartResponse.getCost();
            double cost = (cart.getQuantity()) * (price);
            System.out.println(cost);
            cartResponse.setCost(cost);
            cartResponse.setMessage("Product added to cart successfully!");
            System.out.println(cartResponse);
            return cartResponse;
        }
        catch (Exception e) {
            return null;
        }
    }

}
