package th.ac.kmitl.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.kmitl.atm.model.customer;
import th.ac.kmitl.atm.service.customerservice;

@Controller
@RequestMapping("/customer")
public class customercontroller {
    private customerservice customerservices;


    public customercontroller(customerservice customerservices){
        this.customerservices = customerservices;
    }

    @GetMapping
    public String getCustomerPage(Model model){

        model.addAttribute("allCustomer",customerservices.getCustomer());
        return "customer";
    }
    @PostMapping
    public String registerCustomer(@ModelAttribute customer customers, Model model) {
        customerservices.createCustomer(customers);
        model.addAttribute("allCustomers", customerservices.getCustomer());
        return "redirect:customer";
    }

}
