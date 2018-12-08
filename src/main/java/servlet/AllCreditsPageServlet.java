package servlet;

import model.Credit;
import service.CreditService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllCreditsPageServlet extends HttpServlet {
    private CreditService creditService = new CreditService();
    private Credit credit = new Credit();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("credits", creditService.getAllCredits());
        request.setAttribute("credit", credit);
        request.getRequestDispatcher("/WEB-INF/pages/allCreditsPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String closeBankDay = request.getParameter("closeBankDay1");
        if (closeBankDay!=null){
            creditService.closeBankDay();
            doGet(request, response);
        }
    }
}
