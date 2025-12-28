package org.project.dao;



import org.project.entity.permanent.JasperEntity;

import java.util.List;

public interface EmployeeDao {
     List<JasperEntity> getAllEntries();
     JasperEntity getEntry(String loanAccountNumber);
     void saveEmployee(JasperEntity jasperEntity);
}
