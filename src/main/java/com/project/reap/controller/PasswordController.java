package com.project.reap.controller;

import com.project.reap.Entity.User;
import com.project.reap.service.UserService;
import com.project.reap.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller

public class PasswordController {

@Autowired
    UserService userService;

@Autowired
    EmailUtil emailUtil;

    /*@RequestMapping(value="/resetted",method = RequestMethod.POST)
    public String resetted(@RequestParam("email") String mail)
//    {   String password= userService.findByMail(mail);
//        System.out.println(password);
//        return "successful-reset";


    }
*/
    /*
     * Sending the mail to get the password for login again,in case user has forget the password.
     * */
    @PostMapping("/resetted")
    public String processForgotPasswordForm( HttpServletRequest httpServletRequest,RedirectAttributes redirectAttributes) {
// Lookup user in database by e-mail

        String email=httpServletRequest.getParameter("email");
        User user= userService.findByMailUser(email);
        Optional<User> optional = userService.findByMail(email);
        //System.out.println(optional);
        if (!optional.isPresent()) {
            redirectAttributes.addFlashAttribute("message","We didn't find an account for that e-mail address.");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "forgot-password";
        } else {
// Email message
            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("Your current password for REAP is "+optional.get().getPassword());
            emailUtil.sendEmail(passwordResetEmail);

            User resetUser = optional.get();
// Setting the password manually in the database.
// userService.getPasswordById(resetUser.getId());
           // resetUser.setPassword("abcd");
            //userService.saveUpdatedUser(resetUser);

// Add success message to view
            redirectAttributes.addFlashAttribute("message","A password reset link has been sent to " + user.getEmail());
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            return "successful-reset";
        }
    }
}
