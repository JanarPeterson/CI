package com.customer.infosystem.CI.controller;

import com.customer.infosystem.CI.entity.Customer;
import com.customer.infosystem.CI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostConstruct
    public void addData() {
        customerService.saveCustomer(new Customer("Janis", "Maris", "janis.maris@gmail.com"));
        customerService.saveCustomer(new Customer("Dan", "Brown", "dan.brown@gmail.com"));
        customerService.saveCustomer(new Customer("Micheal", "Knight", "micheal.knight@gmail.com"));
    }
    @GetMapping
    public String getAllCustomers(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers",customers);

        return "/customer/customers-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Customer customer = new Customer();

        theModel.addAttribute("customer", customer);

        return "/customer/customer-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,
                                    Model theModel) {

        Optional<Customer> customer = customerService.getCustomerById(id);

        theModel.addAttribute("customer", customer);

        return "/customer/customer-form";
    }



    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int id) {

        customerService.deleteCustomer(id);

        // redirect to /employees/list
        return "redirect:/customers";

    }
}
