package cn.itbgs.service.impl;

import cn.itbgs.dao.CustomerDao;
import cn.itbgs.domain.Customer;
import cn.itbgs.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	@Override
	public Customer findOne(String custId) {
		return customerDao.findOne(custId);
	}
	
}
