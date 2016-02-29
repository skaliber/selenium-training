<html>
    <head>
        <title>Account Operations</title>
    </head>
    <body>
        <div>
            <a href="index.html">Main Menu</a>
        </div>
        
        <form action="operations.html" method="post">
            <fieldset>
                <legend>Get Money</legend>
                <div>
                    <label for="getAccountId">Account #: </label>
                    <input id="getAccountId" type="text" name="fromAccountId" />
                </div>
                <div>
                    <label for="getAmount">Amount: </label>
                    <input id="getAmount" type="text" name="amount" />
                </div>
                <div>
                    <input type="hidden" value="get" name="operation" />
                    <input type="submit" value="Get" />
                </div>
            </fieldset>
        </form>

        <form action="operations.html" method="post">
            <fieldset>
                <legend>Put Money</legend>
                <div>
                    <label for="putAccountId">Account #: </label>
                    <input id="putAccountId" type="text" name="fromAccountId" />
                </div>
                <div>
                    <label for="putAmount">Amount: </label>
                    <input id="putAmount" type="text" name="amount" />
                </div>
                <div>
                    <input type="hidden" value="put" name="operation" />
                    <input type="submit" value="Put" />
                </div>
            </fieldset>
        </form>

        <form action="operations.html" method="post">
            <fieldset>
                <legend>Transfer Money</legend>
                <div>
                    <label for="fromAccountId">From Account #: </label>
                    <input id="fromAccountId" type="text" name="fromAccountId" />
                </div>
                <div>
                    <label for="toAccountId">To Account #: </label>
                    <input id="toAccountId" type="text" name="toAccountId" />
                </div>
                <div>
                    <label for="amount">Amount: </label>
                    <input id="amount" type="text" name="amount" />
                </div>
                <div>
                    <input type="hidden" value="transfer" name="operation" />
                    <input type="submit" value="Move" />
                </div>
            </fieldset>
        </form>

        <jsp:include page="accounts-list.jsp" />

    </body>
</html>