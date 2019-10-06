//package main.springDemo.hibernate;
//
//import main.springDemo.hibernate.DAO.SingerDao;
//import main.springDemo.hibernate.DAO.SingerDaoImpl;
//import main.springDemo.hibernate.pojo.Singer;
//import org.apache.log4j.Logger;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
//public class hibernateDemo {
//
//    private static Logger logger = Logger.getLogger(hibernateDemo.class);
//
//
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("hibernate-config.xml");
//
//        SingerDao singerDao = (SingerDaoImpl) context.getBean("singerDao");
//
//        List<Singer> singers = singerDao.findAll();
//
//        for (Singer s: singers
//             ) {
//            System.out.println(s.toString());
//        }
//    }
//
//}
