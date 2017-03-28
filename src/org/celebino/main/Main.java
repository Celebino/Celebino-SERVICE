package org.celebino.main;

import org.celebino.extras.Config;
import org.celebino.persistence.dao.IUserDao;
import org.celebino.persistence.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class Main {
	public static void main(String[] args) {
        // Acessa o contexto do Spring Framework a partir de um método estático.
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        IUserDao userDao = context.getBean(IUserDao.class);
        User user = new User();
        user.setName("thay");
        user.setUsername("thay");
        user.setEmail("thayannevls@gmail.com");
        user.setPassword("haha");
        user = userDao.save(user);
    }
}
