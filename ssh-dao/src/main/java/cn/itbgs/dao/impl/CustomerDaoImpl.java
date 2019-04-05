package cn.itbgs.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itbgs.dao.CustomerDao;
import cn.itbgs.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Customer findOne(String custId) {
		return this.getHibernateTemplate().get(Customer.class, custId);
	}

}
