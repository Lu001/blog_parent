package com.blog.customer.service;


import com.blog.common.utils.IdWorker;
import com.blog.customer.dao.CustomerDao;
import com.blog.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private IdWorker idWorker;
    /**
     * 保存消费者
     *  1.配置idwork到工程
     *  2.在service中注入idwork
     *  3.通过idwork生成id
     *  4.保存消费者
     */
    public void add(Customer customer) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        customer.setId(id);
        //默认的状态
        customer.setAuditState("0");//0：未审核，1：已审核
        customer.setState(1); //0.未激活，1：已激活
        customerDao.save(customer);
    }

    /**
     * 更新消费者
     *  1.参数：Customer
     *  2.根据id查询企业对象
     *  3.设置修改的属性
     *  4.调用dao完成更新
     */
    public void update(Customer customer) {
        Customer temp = customerDao.findById(customer.getId()).get();
        temp.setName(customer.getName());
        temp.setCompanyPhone(customer.getCompanyPhone());
        customerDao.save(temp);
    }


    /**
     * 删除消费者
     */
    public void deleteById(String id) {
        customerDao.deleteById(id);
    }

    /**
     * 根据id查询消费者
     */
    public Customer findById(String id) {
        return customerDao.findById(id).get();
    }

    /**
     * 查询消费者列表
     */
    public List<Customer> findAll() {
        return customerDao.findAll();
    }
}
