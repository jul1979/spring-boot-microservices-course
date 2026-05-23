package com.sivalabs.bookstore.webapp.clients.orders;

import java.io.Serializable;
import java.util.Set;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateOrderRequest(
        @NotEmpty(message = "Items cannot be empty.") @NotNull(message = "Items cannot be null.") Set<OrderItem> items,
        @Valid Customer customer,
        @Valid Address deliveryAddress)
        implements Serializable {}

