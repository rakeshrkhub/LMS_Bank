<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Loan Product List</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-5" style="display:flex; justify-content:space-between;align-items: baseline;flex-wrap: wrap;margin-top: 20px;">
    <h2>List of Loan Products</h2>
    <button class="btn btn-primary fixbutton"><a href="${pageContext.request.contextPath}/maker/loan-product-form" style="color:white; text-decoration:none;">Create new Loan Product</a></button>
</div>
<hr>
<div class="container" style="margin-top: 20px;">
    <div class="table-container">
    <table id="loanProductTable" class="table table-striped table-bordered" style="width:100%; font-size: small;">
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
            <th>Creation Date</th>
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
                    <div class="btn-group" role="group">
                        <a class="btn btn-primary btn-sm mr-1" href="show-update-loan-product-form?id=${parameter.productId}&status=${parameter.metaData.recordStatus}" style="color: white;">Edit</a>
                        <a class="btn btn-danger btn-sm" href="delete-loan-product?id=${parameter.productId}&status=${parameter.metaData.recordStatus}" style="color: white;">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function() {
        $('#loanProductTable').DataTable({
            "scrollX": true
        });
    });
</script>
</body>
</html>
