package first.project.api.order.domain;

import first.project.api.item.domain.Item;
import first.project.api.user.domain.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    private long OrderId;

    @Column(name="price")
    private long price;

    @Column(name = "order_status")
    private String count;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
