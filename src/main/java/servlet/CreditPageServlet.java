package servlet;

import model.Client;
import model.Credit;
import model.Deposit;
import service.ClientService;
import service.CreditService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreditPageServlet extends HttpServlet {
    private CreditService creditService = new CreditService();
    private ClientService clientService = new ClientService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClient = request.getPathInfo();
        Client client = clientService.getClient(Integer.valueOf(idClient.substring(1)));
        request.setAttribute("client", client);
        request.getRequestDispatcher("/WEB-INF/pages/creditPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Credit credit = getCreditFromRequest(request);
        creditService.saveCredit(credit);
        doGet(request, response);
    }

    private Credit getCreditFromRequest(HttpServletRequest request) {
        int idClient = Integer.valueOf(request.getPathInfo().substring(1));
        String creditType = request.getParameter("creditType");
        int contractNumber = Integer.valueOf(request.getParameter("contractNumber"));
        String currencyType = request.getParameter("currencyType");
        Date dateBegin = Date.valueOf(request.getParameter("dateBegin"));
        Date dateEnd = Date.valueOf(request.getParameter("dateEnd"));
        int contractTerm = Integer.valueOf(request.getParameter("contractTerm"));
        int creditSum = Integer.valueOf(request.getParameter("creditSum"));
        int creditPercent = Integer.valueOf(request.getParameter("creditPercent"));
        return new Credit(idClient, creditType, contractNumber, currencyType, dateBegin, dateEnd, contractTerm,
                creditSum, creditPercent, creditPercent);
    }
}
