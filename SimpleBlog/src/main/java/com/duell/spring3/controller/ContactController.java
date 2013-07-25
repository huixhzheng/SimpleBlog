package com.duell.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.duell.spring3.form.Contact;
 
@Controller
@SessionAttributes
public class ContactController {

	/*
	 * Will handle any urls which are /addContact
	 * Selects post submission method (as opposed to get method)
	 * 
	 * ModelAttribute specifies that it is expecting that field as 
	 * a submission parameter
	 */
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
                            Contact contact, BindingResult result) {
         
        System.out.println("First Name:" + contact.getFirstname() + 
                    "Last Name:" + contact.getLastname());
        /*quickly redirects back to contacts.html (which in turn will redirect to the
         * showContacts method below, which will paint a blank object to the contact.jsp page
         * so it looks like a refreshed screen
         */
        
        return "redirect:contacts.html";
    }
    /*
     * Will handle any url mappings which are /contacts 
     */
    @RequestMapping("/contacts")
    public ModelAndView showContacts() {
         
    	/*
    	 * will pass control to contact.jsp
    	 *
    	 *	Spring framework expects the key name of the object to be 'command' if 
    	 *	the jsp file is using <form:form> tags.
    	 *	contact.jsp does this 
    	 */
        return new ModelAndView("contact", "command", new Contact());
    }
}