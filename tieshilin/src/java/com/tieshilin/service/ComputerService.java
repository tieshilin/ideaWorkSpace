package com.tieshilin.service;

import java.util.List;

import com.tieshilin.entity.Computer;

public interface ComputerService {

	/**
	 * 查询总数
	 * @param c
	 * @return
	 */
	public Integer countAll(Computer c);
	
	/**
	 * 查询所有
	 * @param c
	 * @return
	 */
	public List<Computer> findAll(Computer c,Integer page, Integer rows);
}
