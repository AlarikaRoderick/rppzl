package servlet;

import service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllClientsPageServlet extends HttpServlet {
    private ClientService service = new ClientService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clients", service.findAllClients());
        request.getRequestDispatcher("/WEB-INF/pages/allClientsPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String delValue = request.getParameter("delete");
        if (delValue != null){
            deleteProcess(request, delValue);
            doGet(request, response);
        }
    }

    private void deleteProcess(HttpServletRequest request, String delValue) {
        int deletedProductId = Integer.valueOf(delValue);
        service.deleteClient(deletedProductId);
    }
}
