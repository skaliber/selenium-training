// ============================================================================
//  File          : PerformOperationServlet
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package atdd.example.web;

import atdd.example.Bank;
import atdd.example.Account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.*;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class PerformOperationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showAccounts(request, response);
    }

    private void showAccounts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = new ArrayList<Account>(Bank.getInstance().getAccounts());
        Collections.sort(accounts, new Comparator<Account>() {
            public int compare(Account a1, Account a2) {
                return a2.getId().compareTo(a1.getId());
            }
        });
        request.setAttribute("accounts", accounts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/operations.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account fromAccount = getAccount(request.getParameter("fromAccountId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        
        String operation = request.getParameter("operation");
        if ("get".equals(operation)) {
            fromAccount.reduceAmount(amount);
        } else if ("put".equals(operation)) {
            fromAccount.increaseAmount(amount);
        } else if ("transfer".equals(operation)) {
            Account toAccount = getAccount(request.getParameter("toAccountId"));
            Bank.getInstance().moveMoney(fromAccount, toAccount, amount);
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        showAccounts(request, response);
    }

    private Account getAccount(String accountId) {
        Collection<Account> accounts = Bank.getInstance().getAccounts();
        for (Account account : accounts) {
            if (account.getId().equals(Long.valueOf(accountId))) {
                return account;
            }
        }
        return null;
    }
}
