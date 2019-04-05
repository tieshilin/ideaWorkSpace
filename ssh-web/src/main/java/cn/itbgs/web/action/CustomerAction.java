package cn.itbgs.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itbgs.domain.Customer;
import cn.itbgs.service.CustomerService;

public class CustomerAction extends ActionSupport{

	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private String custId;
	public void setCustId(String custId) {
		this.custId = custId;
	}

	//根据主键查询
	public String findOne() throws Exception {
		Customer customer = customerService.findOne(custId);
		ActionContext.getContext().getValueStack().push(customer);;
		return SUCCESS;
	}
}
