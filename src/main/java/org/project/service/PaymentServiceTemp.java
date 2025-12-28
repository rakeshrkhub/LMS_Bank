package org.project.service;


import org.project.dto.PaymentDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PaymentServiceTemp {
    boolean createPaymentTemp(PaymentDTO payment);
    PaymentDTO getPaymentTempById(Long id);
    List<PaymentDTO> getListPaymentTempById(Long id);
    List<PaymentDTO> getAllPaymentTemps();
    boolean updatePaymentTemp(PaymentDTO updatedPaymentTemp);
    boolean deletePaymentTemp(PaymentDTO payment);
}
