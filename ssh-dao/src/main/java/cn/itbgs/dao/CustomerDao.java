package cn.itbgs.dao;

import cn.itbgs.domain.Customer;

public interface CustomerDao {

	Customer findOne(String custId);

}
