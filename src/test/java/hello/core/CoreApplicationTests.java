package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CoreApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ApplicationContext applicationContext;

//	@Test
//	public void checkBeans() {
//		String[] beanNames = applicationContext.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println("Bean 등록됨: " + beanName);
//		}
//	}
}
