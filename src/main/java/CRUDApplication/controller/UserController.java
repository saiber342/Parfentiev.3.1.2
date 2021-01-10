package CRUDApplication.controller;

import CRUDApplication.models.User;
import CRUDApplication.service.RoleService;
import CRUDApplication.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping(value = "/user")
    public String getUserPage(ModelMap model, Authentication authentication){
        model.addAttribute("user", userService.getUserByName(authentication.getName()));
        return "user";
    }

    @GetMapping(value = "/admin")
    public String listUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getRoles());
        return "admin";
    }

    @GetMapping("/admin/addUser")
    public String addUser(User user) {
        return "addUser";
    }

    @PostMapping("/admin/addUser")
    public String addUser(@Valid User user, @RequestParam("role") String role, Model model) {
        userService.setRole(user, role);
        userService.saveUser(user);
        model.addAttribute("allRoles", roleService.getRoles());
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        User user = new User();
        user.setId(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/admin/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @Valid User user,
                             @RequestParam("role") String role,
                             ModelMap modelMap) {
        user.setId(id);
        userService.setRole(user, role);
        userService.editUser(user);
        modelMap.addAttribute("user", user);
        return "redirect:/admin";
    }


    @PostMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        userService.delete(id);

        return "redirect:/admin";
    }
}
