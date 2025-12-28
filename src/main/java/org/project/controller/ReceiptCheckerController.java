package org.project.controller;


import org.project.dto.ReceiptDTO;
import org.project.service.ReceiptService;
import org.project.utility.OldDateEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/checker")
@PreAuthorize("hasRole('CHECKER')")
public class ReceiptCheckerController {
    @Autowired
    ReceiptService receiptService;


    @GetMapping("receipt")
    public String showReceiptForm(Model model) {  // show jsp form to search receivablePayable-id
        model.addAttribute("receiptChecker", new ReceiptDTO());
        return "forward:../views/receipt-checker-final.jsp";
    }

    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, "toDate", new OldDateEditor());
        binder.registerCustomEditor(Date.class,"fromDate",new OldDateEditor());
    }

}
