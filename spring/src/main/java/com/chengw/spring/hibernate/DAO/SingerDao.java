package com.chengw.spring.hibernate.DAO;


import com.chengw.spring.hibernate.pojo.Singer;

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
