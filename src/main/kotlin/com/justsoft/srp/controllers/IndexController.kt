package com.justsoft.srp.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping("/", "", "/index")
    fun indexPage(): String = "index"
}