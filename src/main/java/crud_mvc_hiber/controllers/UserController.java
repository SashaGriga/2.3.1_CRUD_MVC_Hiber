package crud_mvc_hiber.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import crud_mvc_hiber.model.User;
import crud_mvc_hiber.service.UserService;


import java.util.List;

@Controller
    @RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("allUsers", list);
        return "users";
    }


   @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "idUsers";
    }

    @GetMapping("/new")
    public String addUser(ModelMap modelMap) {
        modelMap.addAttribute("addUser", new User());
        return "addUser";
    }


    @PostMapping()
    public String addUserBd(@ModelAttribute("addUser") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Integer id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Integer id) {
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
