<%@ page import="atdd.example.Account" %>
<%@ page import="java.util.Collection" %>

<div>
    <h2>Accounts:</h2>
    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>User</th>
                <th>Amount</th>
            </tr>
        </thead>
    <%
        Collection<Account> accounts = (Collection<Account>) request.getAttribute("accounts");
        for (Account account : accounts) {
    %>
        <tr>
            <td><%= account.getId() %></td>
            <td><%= account.getUser() %></td>
            <td><%= account.getAmount() %></td>
        </tr>
    <%
        }
    %>
    </table>
</div>