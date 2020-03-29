package com.blog.customer.controller;


import com.blog.common.entity.Result;
import com.blog.common.entity.ResultCode;
import com.blog.common.exception.CommonException;
import com.blog.customer.service.CustomerService;
import com.blog.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@RequestMapping(value="/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //保存消费者
    @RequestMapping(value="",method = RequestMethod.POST)
    public Result save(@RequestBody Customer customer)  {
        //业务操作
        customerService.add(customer);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新消费者
    /**
     * 1.方法
     * 2.请求参数
     * 3.响应
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value="id") String id, @RequestBody Customer customer ) {
        //业务操作
        customer.setId(id);
        customerService.update(customer);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id删除消费者
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value="id") String id) {
        customerService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询消费者

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value="id") String id) throws CommonException {
        //throw new CommonException(ResultCode.UNAUTHORISE);
        Customer customer = customerService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(customer);
        return result;
    }

    //查询全部消费者信息
    @RequestMapping(value="",method = RequestMethod.GET)
    public Result findAll() {
        //int i = 1/0;
        List<Customer> list = customerService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
    }
}
