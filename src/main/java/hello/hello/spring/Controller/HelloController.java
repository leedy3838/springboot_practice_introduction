package hello.hello.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVE(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello_template";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api-json")
    @ResponseBody
    public Data helloJson(@RequestParam("name") String name){
        Data data = new Data();
        data.setName(name);

        return data;
    }

    static class Data{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
