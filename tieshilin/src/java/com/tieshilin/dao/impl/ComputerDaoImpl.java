package com.tieshilin.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tieshilin.dao.ComputerDao;
import com.tieshilin.entity.Computer;
import com.tieshilin.mapper.ComputerMapper;

@Repository("computerDao")
public class ComputerDaoImpl implements ComputerDao{

	private static Log logger = LogFactory.getLog(ComputerDaoImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Integer countAll(Computer c) {
		try {
			ComputerMapper com = sqlSessionTemplate.getMapper(ComputerMapper.class);
			Integer countAll = com.countAll(c);
			return countAll;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Computer> findAll(Computer c,Integer page, Integer rows) {
		try {
			int stat=(page-1)*rows;
			RowBounds rb = new RowBounds(stat,rows);
			ComputerMapper com = sqlSessionTemplate.getMapper(ComputerMapper.class);
			List<Computer> list = com.findAll(rb,c);
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

}
