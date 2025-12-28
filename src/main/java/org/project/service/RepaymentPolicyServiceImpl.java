package org.project.service;

import org.project.dao.RepaymentPolicyDao;
import org.project.dto.RepaymentPolicyDTO;
import org.project.entity.permanent.RepaymentPolicy;
import org.project.exception.RepaymentPolicyCodeDuplicationExcaption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepaymentPolicyServiceImpl  implements  RepaymentPolicyService{
    @Autowired
    RepaymentPolicyDao repaymentPolicyDao;

    @Override
    public boolean insertRepaymentPolicy(RepaymentPolicyDTO repaymentPolicyDTO) throws RepaymentPolicyCodeDuplicationExcaption {
        return repaymentPolicyDao.insertRepaymentPolicy(repaymentPolicyDTO);
    }

    @Override
    public boolean updateRepaymentPolicy(RepaymentPolicyDTO repaymentPolicyDTO) {
        return repaymentPolicyDao.updateRepaymentPolicy(repaymentPolicyDTO);
    }

    @Override
    public boolean deleteRepaymentPolicy(String code) {
        return repaymentPolicyDao.deleteRepaymentPolicy(code);
    }

    @Override
    public RepaymentPolicyDTO getRepaymentPolicyById(String id) {

        return repaymentPolicyDao.getRepaymentPolicyById(id) ;
    }

    @Override
    public List<RepaymentPolicyDTO> getAllRepaymentPolicy() {
        return repaymentPolicyDao.getAllRepaymentPolicy();
    }

    @Override
    public RepaymentPolicy getRepayPolicyByCode(String code) {
        return repaymentPolicyDao.getRepayPolicyByCode(code);
    }
}
