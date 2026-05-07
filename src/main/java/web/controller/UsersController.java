package web.controller;
import org.springframework.stereotype.Controller;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(@RequestParam(name = "id", required = false) Long editUserId,
                              Model model) {
        model.addAttribute("users", userService.listUsers());

        if (editUserId != null) {
            User user = userService.findUserById(editUserId);
            model.addAttribute("editUser", user);
        }

        return "users";
    }
    @PostMapping("/users")
    public String saveOrUpdateUser(@ModelAttribute User user) {
        userService.saveOrUpdateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}