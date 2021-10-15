package com.csse.servlet;

import com.csse.model.Requisition;
import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRequisitionServlet", value = "/AddRequisitionServlet")
public class AddRequisitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Requisition requisition = new Requisition();
        requisition.setRequisitionType(request.getParameter("requisitionType"));
        requisition.setRequestedBy(request.getParameter("requestedBy"));
        requisition.setSiteLocation(request.getParameter("siteLocation"));
        requisition.setItemName(request.getParameter("itemName"));
        requisition.setItemQty(Integer.parseInt(request.getParameter("itemQty")));
        requisition.setRequestedPrice(Float.parseFloat(request.getParameter("requestedPrice")));
        requisition.setTotalPrice(requisition.getRequestedPrice()* requisition.getItemQty());
        String siteName =(request.getParameter("siteLocation"));
        float price = requisition.getRequestedPrice()* requisition.getItemQty();

        System.out.println(requisition);
        IRequisitionService requisitionService=new RequisitionServiceimpl();
        if(requisitionService.checkApprovable(siteName,price)){
            requisition.setStatus("Approved");
            requisitionService.addRequisition(requisition);
            request.setAttribute("Message","Your Requisition is automatically Approved!");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
            dispatcher.forward(request, response);
        }else{
            requisition.setStatus("Pending");
            requisitionService.addRequisition(requisition);
            request.setAttribute("Message","Your Requisition is sent to the Approval!");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
            dispatcher.forward(request, response);
        }


    }
}
