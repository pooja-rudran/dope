package net.web;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.dopeDao;
import net.model.dope;

public class dopeServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;
    public dopeDao dopeDao;

    public void init() {
        dopeDao = new dopeDao();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String contact = request.getParameter("contact");

        dope d = new dope();
        d.setFirstName(firstName);
        d.setLastName(lastName);
        d.setUsername(username);
        d.setPassword(password);
        d.setContact(contact);
        d.setEmail(email);
        d.setDOB(dob);

        try {
            dopeDao.registerDOPE(d);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("dopedetails.jsp");
    }
}
