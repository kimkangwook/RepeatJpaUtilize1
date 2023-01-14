package jpabook.jpashop2.Service;

import jpabook.jpashop2.Repository.ItemRepository;
import jpabook.jpashop2.domain.Item.Book;
import jpabook.jpashop2.domain.Item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

//    @Transactional
//    public void updateItem(Long itemId, Book param) {
//        Item findItem = itemRepository.findOne(itemId); 변경감지 - DB에서 id를 통해 객체 들고오면 영속성 컨텍스트가 관리하게 됨
//        findItem.setPrice(param.getPrice());
//
//    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
