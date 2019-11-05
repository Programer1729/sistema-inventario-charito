package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.SistemaInventario;

/**
 * Servlet implementation class RealizarPedido
 */
@WebServlet("/RealizarPedido")
public class RealizarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealizarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idMateriaPrima = Integer.parseInt(request.getParameter("idMateriaPrima")); 
		int cantidad = Integer.parseInt(request.getParameter("cantidad")); 
		int idProveedor = Integer.parseInt(request.getParameter("idProveedor")); 
		
		SistemaInventario sistema = new SistemaInventario();  
		
		if(request.getSession().getAttribute("sistema") != null) {
			sistema = (SistemaInventario)request.getSession().getAttribute("sistema");
		} 	
		
		if(sistema.realizarPedido(idMateriaPrima, cantidad, idProveedor)) {
			request.getSession().setAttribute("sistema", sistema); 
			request.getRequestDispatcher("./jsp/vistaAdmin/viewAdmin.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
