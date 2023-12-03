package com.ocem.foodieexpress.model.Cart;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import com.ocem.foodieexpress.domain.CartItem;

public class CartTotal {

        @SerializedName("cart_items")
        @Expose
        private List<CartItem> cartItems;
        @SerializedName("cart_total")
        @Expose
        private Integer cartTotal;

        public List<CartItem> getCartItems() {
            return cartItems;
        }

        public void setCartItems(List<CartItem> cartItems) {
            this.cartItems = cartItems;
        }

        public Integer getCartTotal() {
            return cartTotal;
        }

        public void setCartTotal(Integer cartTotal) {
            this.cartTotal = cartTotal;
        }
}
