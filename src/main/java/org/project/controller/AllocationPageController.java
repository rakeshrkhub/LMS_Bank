package org.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@PreAuthorize("hasRole('CHECKER')")
@RequestMapping("checker")
public class AllocationPageController {

    @RequestMapping("/allocation")
    public String mapToAllocationPage(){
        return "allocation-page";
    }
}
