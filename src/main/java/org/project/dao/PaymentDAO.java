package org.project.dao;


import org.project.dto.PaymentDTO;

import java.util.List;

public interface PaymentDAO {
    boolean createPaymentDTO(PaymentDTO payment);
    PaymentDTO getPaymentDTOById(Long id);
    List<PaymentDTO> getAllPaymentDTOs();
    boolean updatePaymentDTO(PaymentDTO updatedPaymentDTO);
    boolean deletePaymentDTO(PaymentDTO payment);
}
