package th.ac.kmitl.atm.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import th.ac.kmitl.atm.model.customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class customerservice {
    private List<customer> customerList;

    @PostConstruct
    public void postConstruct(){
        this.customerList = new ArrayList<>();
    }
    public void createCustomer(customer customer){
        String hashPin = hash(customer.getPin());
        customer.setPin(hashPin);
        customerList.add(customer);
    }
    public List<customer> getCustomer(){
        return new ArrayList<>(this.customerList);
    }
    public customer findCustomer(int id) {
        for (customer customer : customerList) {
            if (customer.getId() == id)
                return customer;
        }
        return null;
    }
    public customer checkPin(customer inputCustomer) {
        // 1. หา customer ที่มี id ตรงกับพารามิเตอร์
        customer storedCustomer = findCustomer(inputCustomer.getId());

        // 2. ถ้ามี id ตรง ให้เช็ค pin ว่าตรงกันไหม โดยใช้ฟังก์ชันเกี่ยวกับ hash
        if (storedCustomer != null) {
            String hashPin = storedCustomer.getPin();

            if (BCrypt.checkpw(inputCustomer.getPin(), hashPin))
                return storedCustomer;
        }
        // 3. ถ้าไม่ตรง ต้องคืนค่า null
        return null;
    }


    private String hash(String pin){
        String salt = BCrypt.gensalt(12);
        return BCrypt.hashpw(pin,salt);
    }
}
