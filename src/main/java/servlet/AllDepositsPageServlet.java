package servlet;

import model.Deposit;
import model.Fond;
import service.DepositService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllDepositsPageServlet extends HttpServlet {
    private DepositService depositService = new DepositService();
    private Deposit deposit = new Deposit();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("deposits", depositService.getAllDeposits());
        request.setAttribute("deposit", deposit);
        request.getRequestDispatcher("/WEB-INF/pages/allDepositsPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String closeBankDay = request.getParameter("closeBankDay");
        if (closeBankDay!=null){
            depositService.closeBankDay();
            doGet(request, response);
        }
    }
}
