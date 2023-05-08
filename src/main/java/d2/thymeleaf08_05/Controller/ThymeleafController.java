package d2.thymeleaf08_05.Controller;


import d2.thymeleaf08_05.Model.ThymeleafEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ThymeleafController {
   private static List<ThymeleafEntity> list=new ArrayList<>();
   private static ThymeleafEntity thymeleafEntity=new ThymeleafEntity();
    @GetMapping("/variable")
    public static ModelAndView thymeleafVariable(@RequestParam(value = "name",defaultValue = "Xin chào") String name){
        ModelAndView mav=new ModelAndView("views/Variable");
        mav.addObject("value",name);
        mav.addObject("thymeleafEntity",thymeleafEntity);
        mav.addObject("variable","Biểu thức biến");
        mav.addObject("localVariable","Biến cục bộ");
        return mav;
    }

    @GetMapping("/navbar")
    public static ModelAndView navbars(){
        ModelAndView mav=new ModelAndView("views/Navbar");
        return mav;
    }
    @GetMapping("/loop")
    public static ModelAndView loop(){
        ModelAndView mav=new ModelAndView("views/Loops");
        String[] listFlowers=new String[]{"Hoa hồng","Hoa Mai","Hoa Huệ","Hoa Sen","Hoa Tulip"};
        mav.addObject("listFlowers",listFlowers);
        return mav;
    }
    @GetMapping("/condition")
    public static ModelAndView condition(@RequestParam( "variable") String variable){
        ModelAndView mav=new ModelAndView("views/Condition");
        mav.addObject("variable",variable);
        mav.addObject("thymeleafEntity",thymeleafEntity);
        return mav;
    }
    @GetMapping("/forms")
    public static ModelAndView forms(){
        ModelAndView mav=new ModelAndView("views/Forms");
        mav.addObject("list",list);
        return mav;
    }
    @GetMapping("/fromsCreate")
    public static String fromsCreate(){
        return "views/fromsCreate";
    }
    @PostMapping("/createEntity")
    public static ModelAndView createEntity(@ModelAttribute ThymeleafEntity entity){
     ModelAndView mav=new ModelAndView("views/Forms");
     list.add(entity);
     mav.addObject("list",list);
     return mav;
    }
}
