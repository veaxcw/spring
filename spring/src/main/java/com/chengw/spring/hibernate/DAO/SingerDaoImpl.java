package main.springDemo.hibernate.DAO;

import main.springDemo.hibernate.pojo.Singer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Transactional
@Repository("SingerDao")
public class SingerDaoImpl implements SingerDao {

    private SessionFactory sessionFactory;

    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from SINGER s").list();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return null;
    }

    @Override
    public Singer findById(Long id) {
        return null;
    }

    @Override
    public Singer save(Singer singer) {
        return null;
    }

    @Override
    public void delete(Singer singer) {

    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
