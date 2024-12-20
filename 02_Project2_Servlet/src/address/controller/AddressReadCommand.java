package address.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import address.service.AddressService;
import address.service.AddressServiceImpl;


@WebServlet("/AddressReadCommand")
public class AddressReadCommand extends HttpServlet implements Command {
	private static final long serialVersionUID = 1L;
	private AddressService addressService = new AddressServiceImpl();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int addressId = Integer.parseInt(request.getParameter("addressid"));
		
		
		request.setAttribute("address", addressService.getAddress(addressId));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Address/address-read.jsp");
		dispatcher.forward(request, response);
	
	}

}