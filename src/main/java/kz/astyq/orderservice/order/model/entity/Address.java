package kz.astyq.orderservice.order.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(name = "delivery_city", nullable = false, length = 100)
    private String city;

    @Column(name = "delivery_street", nullable = false, length = 255)
    private String street;

    @Column(name = "delivery_building", nullable = false, length = 20)
    private String building;

    @Column(name = "delivery_apartment", length = 20)
    private String apartment;

    @Column(name = "delivery_entrance", length = 10)
    private String entrance;

    @Column(name = "delivery_floor", length = 10)
    private String floor;

    @Column(name = "delivery_lat", precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "delivery_lon", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "delivery_comment", length = 500)
    private String comment;
}
