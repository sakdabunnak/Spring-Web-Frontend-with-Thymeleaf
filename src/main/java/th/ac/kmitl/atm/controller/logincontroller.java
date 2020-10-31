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
@RequestMapping("/login")
public class logincontroller {

    private customerservice customerservice;

    public logincontroller(customerservice customerservice){
        this.customerservice = customerservice;
    }

    @GetMapping
    public String getloginPage(){
        return "login";
    }
    @PostMapping
    public String login(@ModelAttribute customer customer, Model model){
        // 1. เอา id กับ pin ไปเช็คกับข้อมูล customer ที่มีอยู่ ว่าตรงกันบ้างไหม
        customer matchingcustomer = customerservice.checkPin(customer);

        // 2. ถ้าตรง ส่งข้อมูล customer กลับไปแสดงผล
        if (matchingcustomer != null) {
            model.addAttribute("greeting",
                    "Welcome, " + matchingcustomer.getName());
        } else {
            // 3. ถ้าไม่ตรง แจ้งว่าไม่มีข้อมูล customer นี้
            model.addAttribute("greeting", "Can't find customer");
        }
        return "home";
    }
}


