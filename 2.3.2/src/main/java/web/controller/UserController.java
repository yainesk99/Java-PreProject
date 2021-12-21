package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String users(Model model) {
        model.addAttribute("user", userService.listUser());
        return "/users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";

    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        model.addAttribute("user", userService.listUser());
        return "/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User user, Model model) {
        userService.updateUser(user);
        model.addAttribute("user", userService.listUser());
        return "/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id, Model model) {
        userService.removeUser(id);
        model.addAttribute("user", userService.listUser());
        return "/users";
    }
}
