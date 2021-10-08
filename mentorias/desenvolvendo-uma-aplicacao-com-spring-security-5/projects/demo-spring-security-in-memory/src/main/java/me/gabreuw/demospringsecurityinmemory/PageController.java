package me.gabreuw.demospringsecurityinmemory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class PageController {

    @GetMapping(path = "/home")
    public ModelAndView home() {
        return new ModelAndView(
                "home",
                "message",
                "Você está na home page"
        );
    }

    @GetMapping(path = "/todo")
    public String toDo(Model model) {
        model.addAttribute("message", "Você está na todo page");
        model.addAttribute(
                "todoList",
                Arrays.asList(
                        "Tarefa 1",
                        "Tarefa 2",
                        "Tarefa 3"
                )
        );

        return "todo";
    }

    @GetMapping(path = "/admin")
    public ModelAndView admin() {
        return new ModelAndView(
                "admin",
                "message",
                "Você está na admin page"
        );
    }

}
