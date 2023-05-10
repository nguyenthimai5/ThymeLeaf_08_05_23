package d2.thymeleaf08_05.Controller;


import d2.thymeleaf08_05.Model.ThymeleafEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @GetMapping("/")
    public static ModelAndView thymeleafVariable(@RequestParam(value = "name",defaultValue = "Xin chào") String name){
        ModelAndView mav=new ModelAndView("views/Variable");
        mav.addObject("value",name);
        mav.addObject("thymeleafEntity",thymeleafEntity);
        mav.addObject("variable","Biểu thức biến");
        mav.addObject("localVariable","Biến cục bộ");
        return mav;
    }

    @GetMapping("/layout")
    public static ModelAndView navbars(){
        ModelAndView mav=new ModelAndView("views/Layout");
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
        mav.addObject("varUText","This is <b>great!</b>");
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
    public static String fromsCreate(Model model){
        model.addAttribute("entity",new ThymeleafEntity());
        return "views/fromsCreate";
    }
    @PostMapping("/createEntity")
    public static String createEntity(@ModelAttribute ThymeleafEntity entity, Model model) {
        if (entity.getAge()<10){
            model.addAttribute("erro","<span style='color:red'>Nhập tuổi phải lớn hơn 10!</span>");
            model.addAttribute("entity",new ThymeleafEntity());
            return "views/fromsCreate";
        }
        list.add(entity);
        model.addAttribute("list", list);
        return "views/Forms";
    }
}
