<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Loan Application</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <style>
        .spinner {
            width:20rem;
            height:8rem;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 10px;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        .mainHeading {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .leadHeading {
            font-size: 20px;
            color: rgb(130, 130, 252);
            margin-bottom: 20px;
        }

        .form-label {
            font-weight: bold;
        }

        .error {
            font-size: 14px;
        }
    </style>


    <script>
         $(document).ready(
            function () {
                $('.spinner').hide();
                var productsData;
                $('#productType').change(function() {

                    $('.spinner').show();

                    $('#rate').val('');
                    var productTypeId = $(this).val();
                    $.ajax({
                        url: '${pageContext.request.contextPath}/maker/fetch-product',
                        type: 'GET',
                        data: { productTypeId: productTypeId },
                        success: function(products) {

                            $('.spinner').hide();

                            productsData=products;
                            $('#product').empty().append('<option value="">Select Product</option>');
                            $.each(products, function(index, product) {
                                $('#product').append('<option value="' + product.productId + '">' + product.productName + '</option>');

                            });
                        },
                        error: function(xhr, textStatus, errorThrown){
                            $('.spinner').hide();

                            console.error('Error : ' ,errorThrown);
                        }
                    });

                    // Event listener for changing the rate of interest
                    $('#product').change(function() {
                        var selectedProductId = $(this).val();
                        if (productsData) {
                            var selectedProduct = productsData.find(
                                function(product) {
                                    return product.productId == selectedProductId;
                                }
                            );
                            if (selectedProduct) {
                                $('#rate').val(selectedProduct.rateOfInterest);
                            } else {
                                console.error('Selected product not found.');
                            }
                        } else {
                            console.error('Products data is not yet available.');
                        }
                    });
                });
            }
         );
    </script>
</head>

<body>
    <%@ include file="navbar.jsp"%>
<div class="container my-4 card shadow">
    <div class="container mt-4">
        <h2 class="leadHeading"><spring:message code="label.loanInformation"/></h2>
        <hr>

        <div class="row">
            <div class="col">
                <form:form action="${pageContext.request.contextPath}/maker/update-loan-application" modelAttribute="loanApplication" method = "post">
                      <form:hidden  class="form-control" path="customerDTO.customerId" readonly="true"/>
                      <form:hidden  class="form-control" path="loanAccountNumber" readonly="true"/>
                      <form:hidden  class="form-control" path="loanId" readonly="true"/>
                      <form:hidden  class="form-control" path="recordStatus" readonly="true"/>
                      <form:hidden  class="form-control" path="creationDate" readonly="true"/>

                    <div class="form-group row">
                        <div class="form-group col-md-6">
                            <label for="branch" class="form-label">
                            <spring:message code="label.branch"/>
                            <span style="color: red;">*</span></label>
                            <form:input type="text" class="form-control" path="branch" placeholder="Branch" required="true"/>
                            <form:errors path="branch" style="color:red" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="loanAmount" class="form-label">
                            <spring:message code="label.loanAmount"/>
                            <span style="color: red;">*</span></label>
                            <form:input type="number" class="form-control" path="loanAmount"
                                placeholder="Enter amount" required="true"/>
                            <form:errors path="loanAmount" style="color:red" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <div class="form-group col-md-6">
                             <label for="applicationCreationDate" class="form-label">
                            <spring:message code="label.applicationCreationDate"/>
                            </label>
                            <form:input type="date" id="datePicker" class="form-control" path="applicationCreationDate"
                                readonly="true" />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="loanApplicationId" class="form-label">
                            <spring:message code="label.loanApplicationId"/>
                            </label>
                            <form:input type="text" class="form-control" id="loanApplicationId" path="loanApplicationId"
                                readonly="true" />
                        </div>
                    </div>


                    <div class="form-group row">
                        <div class="form-group col-md-6">
                             <label for="productType" class="form-label">
                             <spring:message code="label.productType"/>
                             <span style="color: red; padding:3px;">*</span></label>
                             <select id="productType" class="form-control" required="true">
                                <option value="">Select Product Type</option>
                                <c:forEach items="${productTypeDTOS}" var="productType">
                                    <option value="${productType.productTypeId}">${productType.productTypeCode}</option>
                                </c:forEach>
                             </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="loanProductDTO" class="form-label">
                            <spring:message code="label.product"/>
                            </label>
                            <form:select id="product" class="form-control" path="loanProductDTO.productId" required="true">
                                <form:option value="">Select Product</form:option>
                            </form:select>
                        </div>
                    </div>


                    <div class="form-group row">
                        <div class="form-group col-md-6">
                             <label for="tenure" class="form-label">
                             <spring:message code="label.tenure"/>
                             </label>
                             <div class="input-group">
                                 <form:input type="text" class="form-control" path="tenure" required="true"/>
                                 <form:errors path="tenure" style="color:red" />
                                 <form:select class="form-control" path="tenureIn" required="true">
                                     <form:option value="Months">Months</form:option>
                                     <form:option value="Weeks">Weeks</form:option>
                                     <form:option value="Years">Years</form:option>
                                 </form:select>
                             </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="rate" class="form-label">
                            <spring:message code="label.rate"/>
                            <span style="color: red;">*</span></label>
                            <input type="text" class="form-control" id="rate" readonly="true" />
                        </div>
                    </div>

                    <div class="form-group mt-3">
                        <button class="btn btn-primary"><spring:message code="button.saveNext"/></button>
                        <a href="${pageContext.request.contextPath}/maker/view-loan-applications" class="btn btn-secondary"><spring:message code="button.cancel"/></a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

    <script>
        $(document).ready(function () {
            var now = new Date();
            var month = (now.getMonth() + 1);
            var day = now.getDate();
            if (month < 10)
                month = "0" + month;
            if (day < 10)
                day = "0" + day;
            var today = now.getFullYear() + '-' + month + '-' + day;
            $('#datePicker').val(today);
        });
    </script>


<!-- Search Modal -->
<div class='spinner'>
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
</div>


</body>

</html>