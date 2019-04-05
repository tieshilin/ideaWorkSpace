package com.tieshilin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.tieshilin.entity.Computer;

public interface ComputerMapper {

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
	public List<Computer> findAll(RowBounds rb, Computer c);
}
