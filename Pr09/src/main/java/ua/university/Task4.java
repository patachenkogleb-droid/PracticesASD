package ua.university;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

public class Task4{}


@Data
class UserDTO {
    private String username;
    private String useremail;
}

@Value
class Price {
    private final int price;
}

@Builder
class CheckoutRequest {
    private long orderId;
    private String userEmail;
    private long total;
}