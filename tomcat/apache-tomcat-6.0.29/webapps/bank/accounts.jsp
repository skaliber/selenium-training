<html>
    <head>
        <title>Bank Accounts</title>

        <link rel="stylesheet" href="css/autocomplete.css" type="text/css" />

        <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.autocomplete.js"></script>
        <script type="text/javascript">
            $(function() {
                var data = "John Bill Jim Jameson Bob Jasper".split(" ");
                $("#user").autocomplete(data);
            });
        </script>
    </head>
    <body>
        <div>
            <a href="index.html">Main Menu</a>
        </div>
        
        <form action="accounts.html" method="post">
            <fieldset>
                <legend>Create Account</legend>
                <div>
                    <label for="user">User: </label>
                    <input id="user" type="text" name="user" />
                </div>
                <div>
                    <label for="amount">Amount: </label>
                    <input id="amount" type="text" name="amount" />
                </div>
                <div>
                    <input type="submit" value="Create" />
                </div>
            </fieldset>
        </form>

        <jsp:include page="accounts-list.jsp" />

    </body>
</html>