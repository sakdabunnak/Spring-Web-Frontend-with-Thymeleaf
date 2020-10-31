package th.ac.kmitl.atm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class homecontroller {
    @RequestMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("greeting","HI");
        return "home"; //home template (home.html)
    }
}
