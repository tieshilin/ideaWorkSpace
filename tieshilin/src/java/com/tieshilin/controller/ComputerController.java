package com.tieshilin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tieshilin.entity.Computer;
import com.tieshilin.service.ComputerService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/computer")
public class ComputerController {
	
	private static Log logger = LogFactory.getLog(ComputerController.class);
	
	@Resource(name="computerService")
	private ComputerService computerService;
	
	@RequestMapping("/findAllList.do")
	@ResponseBody
	public String findAllList(Computer c,Integer page, Integer rows){
		if(page==null || page.equals("")){
			page = 1;
		}
		if(rows==null || rows.equals("")){
			rows = 10;
		}
		//总数查询
		Integer tot = computerService.countAll(c);
		String retStr = "{\"total\":\""+tot+"\",\"rows\":[]}";
		try {
			logger.debug("return computer list data!");
			//查询所以
 			List<Computer> list = computerService.findAll(c,page,rows);
			if(list == null){
				throw new NullPointerException("未找到任何数据");
			}
			
			String strList = JSONArray.fromObject(list).toString();
			retStr = "{\"total\":\""+tot+"\",\"rows\":"+strList+"}";
			logger.debug(retStr);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return retStr;
	}
}
