<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.project.dto.LoanApplicationDTO, java.util.*" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>List of Loan Applications</title>
</head>
<body>


<%@ include file="navbar.jsp"%>
<div class="container mt-5" style="display:flex; justify-content:space-between;align-items: baseline;flex-wrap: wrap;margin-top: 20px;">
    <h2>List of Loan Applications</h2>
    <a class="btn btn-primary fixbutton" href="${pageContext.request.contextPath}/maker/applicant" style="color:white; text-decoration:none;">Create New Loan Application</a>
</div>
<hr>
<div class="container" style="margin-top: 20px;">
  <div class="row">
    <div class="col-md-12">
      <div class="table-div" class="table-container" style="max-width: 100%; overflow-x: auto;">
        <table id="table" class="table table-bordered table-striped" style="width:100%; font-size: small;">
          <thead class="thead-dark">
            <tr>
              <th>Loan Application Id</th>
              <th>Loan Account Number</th>
              <th>Customer Id</th>
              <th>Application Creation Date</th>
              <th>Loan Amount</th>
              <th>Loan Status</th>
              <th>Creation Date</th>
              <th>Created By</th>
              <th>Modified Date</th>
              <th>Modified by</th>
              <th>Record Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${loanApplicationDTOS}" var="loanApplication">
              <tr>
                <td>${loanApplication.loanApplicationId}</td>
                <td>${loanApplication.loanAccountNumber}</td>
                <td>${loanApplication.customerDTO.customerId}</td>
                <td>${loanApplication.applicationCreationDate}</td>
                <td>${loanApplication.loanAmount}</td>
                <td>${loanApplication.loanStatus}</td>
                <td>${loanApplication.creationDate}</td>
                <td>${loanApplication.createdBy}</td>
                <td>${loanApplication.modifiedDate}</td>
                <td>${loanApplication.modifiedBy}</td>
                <td>${loanApplication.recordStatus}</td>
                <td>
                    <div class="btn-group" role="group">
                        <a class="btn btn-primary btn-sm mr-1" href="${pageContext.request.contextPath}/maker/update-loan-application/${loanApplication.loanApplicationId}">Edit</a>
                        <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/maker/delete-loan-application/${loanApplication.loanApplicationId}">Delete</a>
                    </div>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js"></script>

<script>
  $(document).ready(function() {
      $('#table').DataTable({
          "scrollX": true
      });
  });
</script>

</body>
</html>
