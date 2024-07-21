<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Customer Form</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
        /* Styling for loading screen */
        #loading {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* Semi-transparent black background */
            z-index: 9999;
        }

        .spinner {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border: 5px solid #f3f3f3; /* Light grey */
            border-top: 5px solid #3498db; /* Blue */
            border-radius: 50%;
            width: 50px;
            height: 50px;
            animation: spin 1s linear infinite; /* Spin animation */
        }

        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }

        #customerData{
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 20px 0px;
            width: 100%;
        }

        thead{
            color: #2effe4;
            font-weight: 600;
        }
  </style>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script>
        $(document).ready(
            function() {
                $('#loading').hide();
                $('#create').hide();
                $('#existing').hide();
                $('input[type="radio"]').change(
                    function(){
                        if($(this).val()=='create'){
                            $('#create').show();
                            $('#existing').hide();
                        }
                        else if($(this).val()=='existing'){
                             $('#create').hide();
                             $('#existing').show();
                        }
                    }
                );

                $('#customerSearchForm').submit(
                    function(event){
                        event.preventDefault();
                        $('#loading').show();
                        var formData=$(this).serialize();
                        fetchCustomerDetails(formData);
                    }
                );

            }
        );
        function fetchCustomerDetails(formData){
            $.ajax({
               url: "${pageContext.request.contextPath}/maker/search",
               type: "GET",
               data: formData,
               success : function(data){
                   console.log(data);
                   $('#loading').hide();
                   displayCustomerDetails(data);
               },
               error: function(xhr, textStatus, errorThrown){
                  console.error('Error : ' ,errorThrown);
                  $('#loading').hide();
                  displayCustomerDetails(null);
               }
            });
        }

        function displayCustomerDetails(customer){
            var tableBody = $('#table tbody');
            var proceedLink = $('#proceedLink');
            if(customer){
                // Customer exists, populate table row
                $('#customerData').show();
                tableBody.empty(); // Clear existing rows
                var newRow = $('<tr>');
                newRow.append($('<td>').text(customer.customerId));
                newRow.append($('<td>').text(customer.cifNumber));
                newRow.append($('<td>').text(customer.personInfoDTO.fullName));
                newRow.append($('<td>').text(customer.contactNumber));
                newRow.append($('<td>').text(customer.emailAddress));
                tableBody.append(newRow);

                // Construct URL with customerId
                var proceedUrl = "${pageContext.request.contextPath}/maker/loanForm?customerId=" + customer.customerId;
                proceedLink.attr('href', proceedUrl);
                proceedLink.show(); // Show the link

            } else {
                // Customer does not exist, show message
                $('#customerData').hide();
                alert('Customer does not exist.');
            }
        }
    </script>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>

<%@ include file="navbar.jsp"%>

<div class="container my-4 card shadow border rounded" id="applicant-info-container">

    <div class="container" style="margin:20px 0px">
      <h2>Applicant is:</h2>
      <div id="customerForm" style="margin-left: 30px;">
        <div class="form-group row" style="margin-top: 30px;">
            <div class="form-group col-md-4">
              <input type="radio" id="createCustomer" name="customerType" value="create">
              <label for="createCustomer">A New Customer</label>
            </div>
            <div class="form-group col-md-4">
              <input type="radio" id="existingCustomer" name="customerType" value="existing">
                <label for="existingCustomer">An Existing Customer</label>
            </div>
        </div>


        <div class="row form-card hidden" id="create">
            <div class="form-group">
              <button type="submit" class="btn btn-primary">
                <a href="${pageContext.request.contextPath}/maker/registerForm" style="color: white; text-decoration: none;">Create New Customer</a>
              </button>
            </div>
          </div>

        <form id='customerSearchForm'>
            <div class="row hidden" id="existing">
                <div class="col-sm-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="extrabox">
                                <label>CIF</label>
                                <input type="text" name="cifNumber" placeholder="Enter CIF" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="extrabox">
                                <label>LAN</label>
                                <input type="text" name="loanAccountNumber" placeholder="Enter Loan Account Number" class="form-control" style="width:150px" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="extrabox"><label>Application Id</label><input type="text" name="loanApplicationId"
                                placeholder="Enter Loan Application Id" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-primary" style="margin-top: 30px;">
                      <div class="search-icon">&#x1F50D;</div>
                    </button>
                </div>
            </div>
        </form>
      </div>

      <div id="customerData" class="row" style="display: none;">
          <table id="table" class="table table-bordered table-striped" style="width: 100%;">
              <thead class="thead-dark">
                  <tr>
                      <th scope="col">Customer Id</th>
                      <th scope="col">CIF Number</th>
                      <th scope="col">Customer Name</th>
                      <th scope="col">Contact Number</th>
                      <th scope="col">Email Address</th>
                  </tr>
              </thead>
              <tbody>
                  <!-- Table body content will be dynamically generated -->
              </tbody>
          </table>
          <a id="proceedLink" class="btn btn-primary mt-3">Proceed</a>
      </div>

    </div>
</div>


<!-- Search Modal -->
<div id="loading">
    <div class="spinner"></div> <!-- Loading spinner -->
</div>

</body>
</html>
