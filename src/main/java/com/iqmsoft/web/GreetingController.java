package com.iqmsoft.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GreetingController {
    private Logger log = LoggerFactory.getLogger(GreetingController.class);


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("site.homepage", "home", "home");
    }

    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String basic() {
        return "layout.basic";
    }

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public ModelAndView greet(@RequestParam(value = "name", required = false, defaultValue = "World!") final String name, final Model model) {
        log.info("Controller has been invoked with Request Parameter name = '" + name + "'.");
        return new ModelAndView("site.greeting", "name", name);
    }

    @RequestMapping(value = "/greet/{name}", method = RequestMethod.GET)
    public ModelAndView greetTwoWays(@PathVariable(value = "name") final String name, final Model model) {
        log.info("Controller has been invoked with Path Variable name = '" + name + "'.");
        return new ModelAndView("site.greeting", "name", name);
    }
}
