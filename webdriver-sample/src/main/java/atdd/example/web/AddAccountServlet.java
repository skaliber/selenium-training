// ============================================================================
//  File          : AddAccountServlet
//  Description   :
//  Modifications :
//
// ============================================================================
//  Copyright(c) 2007 Zoral, Ukraine
// ============================================================================
package atdd.example.web;

import atdd.example.Account;
import atdd.example.Bank;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

/**
 * @author Alimenkou Mikalai
 * @version 1.0
 */
public class AddAccountServlet extends HttpServlet {
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/accounts.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String amount = request.getParameter("amount");
        Bank.getInstance().addAccount(new Account(user, Double.parseDouble(amount)));
        showAccounts(request, response);
    }
}
