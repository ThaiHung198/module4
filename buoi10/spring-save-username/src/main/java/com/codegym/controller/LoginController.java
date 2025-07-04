package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }
    @RequestMapping("/login")
    public String Index(@CookieValue(value = "setUser",defaultValue = "")String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "/login";
    }
    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user") User user, Model model,@CookieValue(value = "setUser",defaultValue = "") String setUser, HttpServletRequest request, HttpServletResponse response) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("123456")) {
            if (user.getEmail() != null) {
                setUser = user.getEmail();
            }
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (!c.getName().equals("setUser")) {
                    c.setValue("");
                }
                model.addAttribute("cookieValue", c);
            }
            model.addAttribute("message", "You have successfully logged in!");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "/login";
    }

}
