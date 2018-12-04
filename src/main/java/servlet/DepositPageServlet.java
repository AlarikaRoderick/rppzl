package servlet;

import model.Client;
import model.Deposit;
import service.ClientService;
import service.DepositService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class DepositPageServlet extends HttpServlet {
    private ClientService clientService = new ClientService();
    DepositService depositService = new DepositService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClient = request.getPathInfo();
        Client client = clientService.getClient(Integer.valueOf(idClient.substring(1)));
        request.setAttribute("client", client);
        request.getRequestDispatcher("/WEB-INF/pages/depositPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Deposit deposit = getDepositFromRequest(request);
        depositService.saveDeposit(deposit);
        doGet(request, response);
    }

    private Deposit getDepositFromRequest(HttpServletRequest request) {
        int idClient = Integer.valueOf(request.getPathInfo().substring(1));
        String depositType = request.getParameter("depositType");
        int contractNumber = Integer.valueOf(request.getParameter("contractNumber"));
        String currencyType = request.getParameter("currencyType");
        Date dateBegin = Date.valueOf(request.getParameter("dateBegin"));
        Date dateEnd = Date.valueOf(request.getParameter("dateEnd"));
        int contractTerm = Integer.valueOf(request.getParameter("contractTerm"));
        int depositSum = Integer.valueOf(request.getParameter("depositSum"));
        int depositPercent = Integer.valueOf(request.getParameter("depositPercent"));
        return new Deposit(idClient, depositType, contractNumber, currencyType, dateBegin, dateEnd, contractTerm,
                depositSum, depositPercent, depositPercent);
    }
}
