package servlet;

import model.Client;
import service.ClientService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class EnterClientServlet extends HttpServlet {
    private ClientService service = new ClientService();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/enterClient.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Client client = getClientFromRequest(request);
        boolean isSuchClientExist = service.isSuchClientExist(client);
        boolean isSuchPassportNumberExist = service.isSuchPassportNumberExist(client);
        boolean isSuchIdenticalNumberExist = service.isSuchIdenticalNumberExist(client);
        if (isSuchClientExist){
            request.setAttribute("suchClientExist", true);
            response.sendRedirect(request.getRequestURI() + "?suchClientExist");
            return;
        }
        else if(isSuchPassportNumberExist){
            request.setAttribute("suchPassportNumberExist", true);
            response.sendRedirect(request.getRequestURI() + "?suchPassportNumberExist");
            return;
        }
        else if(isSuchIdenticalNumberExist){
            request.setAttribute("suchIdenticalNumberExist", true);
            response.sendRedirect(request.getRequestURI() + "?suchIdenticalNumberExist");
            return;
        }
        else {

            service.saveClient(client);
            doGet(request, response);
        }
    }

    private Client getClientFromRequest(HttpServletRequest request) {
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
        String disability = request.getParameter("disability");
        String pensioner = request.getParameter("pensioner");
        String monthlyIncome = request.getParameter("monthlyIncome");
        String military = request.getParameter("military");

        return new Client(firstName, lastName, patronymic, LocalDate.parse(birthDate), gender, passportSeries, passportNumber,
                passportIssue, LocalDate.parse(dateIssue), identicalNumber, birthPlace, livingCity, phoneHomeNumber, phoneNumber,
                email, maritalStatus, citizenship, disability, pensioner, monthlyIncome, military);
    }
}
