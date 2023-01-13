package jpabook.jpashop2.domain.Item;

import jpabook.jpashop2.Exception.NotEnoughStockException;
import jpabook.jpashop2.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name="item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();



    //==비즈니스 로직==//
    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void remove(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock<0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
