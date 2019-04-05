package com.tieshilin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tieshilin.dao.ComputerDao;
import com.tieshilin.entity.Computer;
import com.tieshilin.service.ComputerService;

@Service("computerService")
public class ComputerServiceImpl implements ComputerService{

	@Resource(name="computerDao")
	private ComputerDao computerDao;
	
	@Transactional(readOnly=true)
	public Integer countAll(Computer c) {
		return computerDao.countAll(c);
	}

	@Transactional(readOnly=true)
	public List<Computer> findAll(Computer c, Integer page, Integer rows) {
		return computerDao.findAll(c, page, rows);
	}

}
