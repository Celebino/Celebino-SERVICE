package org.celebino.main;

import org.celebino.extras.Config;
import org.celebino.persistence.dao.UserDao;
import org.celebino.persistence.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
        // Acessa o contexto do Spring Framework a partir de um método estático.
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserDao userDao = context.getBean(UserDao.class);
        User user = new User();
        user.setName("thay");
        user.setUsername("thay");
        user.setEmail("thayannevls@gmail.com");
        user.setPassword("haha");
        user.setNumber("242343243");
        user = userDao.save(user);
    }
}
