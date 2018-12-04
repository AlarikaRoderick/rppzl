package servlet;

import model.Client;
import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class ClientPageServlet extends HttpServlet {
    private ClientService clientService = new ClientService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idClient = request.getPathInfo();
        Client client = clientService.getClient(Integer.valueOf(idClient.substring(1)));
        request.setAttribute("client", client);
        request.getRequestDispatcher("/WEB-INF/pages/clientPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String updValue = request.getParameter("update");
        if(updValue != null){
            Client client = getClientFromRequest(request);
            clientService.updateClient(client);
        }
        response.sendRedirect("?successUpdate=true");
    }

    private Client getClientFromRequest(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("idClient"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String patronymic = request.getParameter("patronymic");
        String birthDate = request.getParameter("birthDate");
        String gender = request.getParameter("gender");
        String passportSeries = request.getParameter("passportSeries");
        String passportNumber = request.getParameter("passportNumber");
        String passportIssue = request.getParameter("passportIssue");
        String dateIssue = request.getParameter("dateIssue");
        String identicalNumber = request.getParameter("identicalNumber");
        String birthPlace = request.getParameter("birthPlace");
        String livingCity = request.getParameter("livingCity");
        String phoneHomeNumber = request.getParameter("phoneHomeNumber");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String maritalStatus = request.getParameter("maritalStatus");
        String citizenship = request.getParameter("citizenship");
        String disability = "Нет инвалидности";
        String pensioner = request.getParameter("pensioner");
        String monthlyIncome = request.getParameter("monthlyIncome");
        String military = request.getParameter("military");

        Client client = new Client(firstName, lastName, patronymic, LocalDate.parse(birthDate), gender, passportSeries, passportNumber,
                passportIssue, LocalDate.parse(dateIssue), identicalNumber, birthPlace, livingCity, phoneHomeNumber, phoneNumber,
                email, maritalStatus, citizenship, disability, pensioner, monthlyIncome, military);

        client.setId(id);
        return client;
    }
}
