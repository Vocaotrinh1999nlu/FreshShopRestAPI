package vct.freshshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import vct.freshshop.entity.OderItem;

@SpringBootTest
class FreshShopApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void createOderItemBuilder() {
		OderItem oderItem = OderItem.builder().id(1).build();
	}
}
