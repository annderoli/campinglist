package camplist.service;

import camplist.dto.ItemResponseDto;
import camplist.entity.Item;
import camplist.repository.ItemRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public Item createItem(Item item) {
        return repository.save(item);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item getItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }
}
