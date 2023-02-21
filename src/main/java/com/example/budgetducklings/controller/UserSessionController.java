package com.example.budgetducklings.controller;

import com.example.budgetducklings.model.EmployeeList;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.budgetducklings.exception.*;

import java.io.IOException;

@Controller
@RequestMapping("/userSession/*")
public class UserSessionController {


   @ExceptionHandler(InvalidPswException.class)
    public String invalidPasswordAttempt(InvalidPswException ex, HttpSession session, HttpServletRequest req) {

        Object loginAttempts = session.getAttribute("loginAttempts");
        if(loginAttempts == null) {
            loginAttempts = 0;
        }

        session.setAttribute("loginAttempts", (int) loginAttempts + 1);

        return "redirect:login?error=" + ex.getMessage();
    }


    @GetMapping("login")
    public String getLoginPage() {
        return "loginPage";
    }

    @PostMapping("login")
    public String login(HttpSession session, RedirectAttributes redirect, @RequestParam String name, @RequestParam String password) {

        if(session.getAttribute("name") != null) {
            return "redirect:/home/invoice";
        } else {

            if(name.equals("scrooge")) {
                if(password.equals("foo123")) {
                    session.setMaxInactiveInterval(60 * 30);
                    session.setAttribute("name", name);

                    return "redirect:home/invoice";
                } else {
                    throw new InvalidPswException("Invalid password attempt", name);
                }
            }
            return "redirect:/userSession/login";
        }
    }

    @PostMapping("logout")
    public String logout(HttpSession session) throws IOException {
        session.invalidate(); //Clear session.
        return "redirect:login";
    }
}
