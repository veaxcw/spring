//package com.chengw.spring.hibernate.DAO;
//
//
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.Resource;
//
//
//@Transactional
//@Repository("SingerDao")
//public class SingerDaoImpl implements SingerDao {
//
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<Singer> findAll() {
//        return sessionFactory.getCurrentSession().createQuery("from SINGER s").list();
//    }
//
//    @Override
//    public List<Singer> findAllWithAlbum() {
//        return null;
//    }
//
//    @Override
//    public Singer findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Singer save(Singer singer) {
//        return null;
//    }
//
//    @Override
//    public void delete(Singer singer) {
//
//    }
//
//    @Resource(name = "sessionFactory")
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//}
