<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Footer</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.11.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .footer-basic {
            padding: 40px 0;
            background-color: #ffffff;
            color: #4b4c4d;
            text-align: center; /* Center align text */
        }

        .footer-basic ul {
            padding: 0;
            list-style: none;
            font-size: 18px;
            line-height: 1.6;
            margin-bottom: 0;
            display: flex; /* Use flexbox for horizontal alignment */
            justify-content: center; /* Center align list items */
        }

        .footer-basic li {
            padding: 0 10px;
        }

        .footer-basic ul a {
            color: inherit;
            text-decoration: none;
            opacity: 0.8;
        }

        .footer-basic ul a:hover {
            opacity: 1;
        }

        .footer-basic .social {
            text-align: center;
            padding-bottom: 25px;
        }

        .footer-basic .social > a {
            font-size: 24px;
            width: 40px;
            height: 40px;
            line-height: 40px;
            display: inline-block;
            text-align: center;
            border-radius: 50%;
            border: 1px solid #ccc;
            margin: 0 8px;
            color: inherit;
            opacity: 0.75;
        }

        .footer-basic .social > a:hover {
            opacity: 0.9;
        }

        .footer-basic .copyright {
            margin-top: 15px;
            font-size: 13px;
            color: #aaa;
            margin-bottom: 0;
        }
    </style>
</head>
<body>
<div class="footer-basic">
    <footer>
        <ul class="list-inline">
            <li class="list-inline-item"><a href="https://www.nucleussoftware.com/">Home</a></li>
            <li class="list-inline-item"><a href="https://www.nucleussoftware.com/services/">Services</a></li>
            <li class="list-inline-item"><a href="https://www.nucleussoftware.com/about-us/">About</a></li>
            <li class="list-inline-item"><a href="https://www.nucleussoftware.com/terms-and-conditions/">Terms</a></li>
            <li class="list-inline-item"><a href="https://www.nucleussoftware.com/privacy-policy/">Privacy Policy</a></li>
        </ul>
        <p class="copyright">Created by Rakesh &copy; 2018</p>
    </footer>
</div
</body>
</html>