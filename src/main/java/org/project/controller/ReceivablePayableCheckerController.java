package org.project.controller;

import org.project.dto.LoanAccountDTO;
import org.project.dto.ReceivablePayableDTO;
import org.project.service.LoanAccountService;
import org.project.service.ReceivablePayableService;
import org.project.service.ReceivablePayableTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("checker")
public class ReceivablePayableCheckerController {

    @Autowired
    LoanAccountService loanAccountService;
    @Autowired
    ReceivablePayableTempService receivablePayableTempService;
    @Autowired
    ReceivablePayableService receivablePayableService;
    @RequestMapping("receivable-payable")
    public String showApproval(){
        return "receivable-payable-checker";
    }
    @RequestMapping("/generate-table")
    public ModelAndView generateTable(@RequestParam("loanAccountNumber") String loanAccountNumber,
                                      @RequestParam("fromDate") String startDate,
                                      @RequestParam("toDate") String endDate){
        LoanAccountDTO loanAccountDTO = loanAccountService.getByAccountNumber(loanAccountNumber);
        List<ReceivablePayableDTO> receivableDtoList = receivablePayableTempService.getReceivablePayableAgainstLoanIdAndDateRange(loanAccountDTO,Date.valueOf(startDate),Date.valueOf(endDate));


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("receivablePayableDTOList",receivableDtoList);
        modelAndView.setViewName("receivable-payable-temp-table");
        return modelAndView;
    }


}
