package com.mocomsys.mi.manager.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MonitoringPageController {

    @GetMapping("/monitoring/service")
    public String developmentList(Model model) {
        return "contents/monitoring/service/list";
    }
}
