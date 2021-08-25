package first.project.api;

import first.project.api.item.domain.Item;
import first.project.api.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemApplication {

	@Autowired
	ItemService itemService;

	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		itemService.deleteAll();
//		itemService.save(new Item("삼성", "갤럭시 2", "검은색"));
//		itemService.save(new Item("애플", "아이폰3", "흰색"));
//		itemService.save(new Item("엘지", "윙2", "적색"));
//		for(Item i : itemService.findAll()) {
//			System.out.println(i.toString());
//		}
//	}
}
