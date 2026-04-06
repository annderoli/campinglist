package camplist.controller;

import camplist.entity.Item;
import camplist.repository.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ItemController {

    private ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Item createItem( @RequestBody Item item) {
        return repository.save(item);

    }

    @GetMapping
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item Não Encontrado"));
    }
}
