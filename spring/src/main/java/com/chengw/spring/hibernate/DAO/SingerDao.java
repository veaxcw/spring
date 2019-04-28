package main.springDemo.hibernate.DAO;

import main.springDemo.hibernate.pojo.Singer;

import java.util.List;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
public interface SingerDao {

	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	Singer findById(Long id);

	Singer save(Singer singer);

	void delete(Singer singer);
}
