<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Loan Product List</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .table-container {
            max-width: 100%; /* Adjust as needed */
            overflow-x: auto;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5">
    <h2>List of Loan Products</h2>
    <hr>
</div>
<div class="container">
    <div class="table-container" style="overflow-x: auto;">
    <table id="loanProductTempTable" class="table table-striped table-bordered" style="width:100%; font-size: small;">
        <thead class="thead-dark">
        <tr>
            <th>LoanProduct Code</th>
            <th>LoanProduct Name</th>
            <th>LoanProduct Description</th>
            <th>LoanProduct securityType</th>
            <th>LoanProduct rateOfInterest</th>
            <th>Record Status</th>
            <th>Active/Inactive</th>
            <th>Created By</th>
            <th>Created Date</th>
            <th>Modified By</th>
            <th>Modified Date</th>
            <th>Authorized By</th>
            <th>Authorized Date</th>
            <th>Product Type Code</th>
            <th>Repayment Policy Code</th>
            <th>Charge Policy Code</th>
            <th>Eligibility Policy Code</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${loanProductList}" var="parameter">
            <tr>
                <td>${parameter.productCode}</td>
                <td>${parameter.productName}</td>
                <td>${parameter.productDescription}</td>
                <td>${parameter.securityType}</td>
                <td>${parameter.rateOfInterest}</td>
                <td>${parameter.metaData.recordStatus}</td>
                <td>${parameter.metaData.activeInactiveFlag}</td>
                <td>${parameter.metaData.createdBy}</td>
                <td>${parameter.metaData.creationDate}</td>
                <td>${parameter.metaData.modifiedBy}</td>
                <td>${parameter.metaData.modifiedDate}</td>
                <td>${parameter.metaData.authorizedBy}</td>
                <td>${parameter.metaData.authorizedDate}</td>
                <td>${parameter.productTypeCode}</td>
                <td>${parameter.repaymentPolicyCode}</td>
                <td>${parameter.chargePolicyCode}</td>
                <td>${parameter.eligibilityPolicyCode}</td>
                <td>
                    <c:if test="${parameter.metaData.recordStatus ne 'A'}">
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-primary">
                                <a href="approve-loan-product/${parameter.productId}" style="color: white;">Approve</a>
                            </button>
                            <button type="button" class="btn btn-danger">
                                <a href="reject-loan-product/${parameter.productId}" style="color: white;">Reject</a>
                            </button>
                        </div>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>
<hr>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
        $('#loanProductTempTable').DataTable({
            "scrollX": true
        });
    });
</script>
</body>
</html>
