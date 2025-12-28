package org.project.controller;

import org.project.dto.ChargeDefinitionDTO;
import org.project.dto.ChargePolicyTempDto;
import org.project.service.ChargeDefinitionService;
import org.project.service.ChargePolicyService;
import org.project.service.ChargePolicyTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("checker")
public class ChargePolicyCheckerController {
    private ChargePolicyTempService chargePolicyTempService;
    private ChargePolicyService chargePolicyService;
    private ChargeDefinitionService chargeDefinitionService;
    ChargePolicyCheckerController()
    {}
    @Autowired
    ChargePolicyCheckerController(ChargePolicyTempService chargePolicyTempService,ChargePolicyService chargePolicyService,ChargeDefinitionService chargeDefinitionService)
    {
        this.chargeDefinitionService = chargeDefinitionService;
        this.chargePolicyTempService = chargePolicyTempService;
        this.chargePolicyService = chargePolicyService;
    }

    @GetMapping("charge-policy-table")
    public String getCheckerTable(Model model)
    {
        //Filtering all the policies from temp table which are having status MR,DR,NR
        List<ChargePolicyTempDto> chargePolicies = chargePolicyTempService.getAllChargePolicyForChecker();

//setting list to model
        model.addAttribute("chargePolicies",chargePolicies);
        return "charge-policy-checker";
    }

    @GetMapping("getDetails")
    public String getPolicyDetails(@RequestParam("code")String policyCode ,Model model)
    {
        //Fetching Charge Definition Information along with charge Policy
        ChargePolicyTempDto chargePolicy = chargePolicyTempService.getChargePolicy(policyCode);
        List<ChargeDefinitionDTO> chargeNameDtoList = chargeDefinitionService.fetchDetailsFromTheMasterTable();

        model.addAttribute("chargeList",chargeNameDtoList);
        model.addAttribute("selectedPolicy",chargePolicy);
        return "display-checker";
    }

    @GetMapping("authorizePolicy")
    public String authorizePolicy(@RequestParam("code")String policyCode,Model model)
    {
        if(chargePolicyService.policyAuthorization(policyCode))
        {
            return "redirect:charge-policy-table";
        }
        return "error";
    }

    @GetMapping("rejectPolicy")
    public String rejectPolicy(@RequestParam("code")String policyCode,Model model)
    {
        if(chargePolicyService.policyRejection(policyCode))
        {
            return "redirect:charge-policy-table";
        }
//Getting list to be set in the jsp page
        return "error";
    }
}
