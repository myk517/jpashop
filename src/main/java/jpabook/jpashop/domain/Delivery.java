package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name= "delivery_id")
    private Long id;
    
    @OneToOne
    private Order orders;
    
    @Embedded
    private Address address;
    
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY(준비), COMP(배송)
    
    
    
}
