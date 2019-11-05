package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.SistemaInventario;

/**
 * Servlet implementation class PedirMateriaPrima
 */
@WebServlet("/PedirMateriaPrima")
public class PedirMateriaPrima extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedirMateriaPrima() {
        super();
        // TODO Auto-generated constructor stub
    }  
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id")); 
		SistemaInventario sistema = new SistemaInventario(); 
		if(request.getSession().getAttribute("sistema") != null) {
			sistema = (SistemaInventario)request.getSession().getAttribute("sistema");
		} 
		if(sistema.cargarProveedorMateriaPrima(id) != null) {
			request.getSession().setAttribute("materiaPrima", sistema.cargarProveedorMateriaPrima(id)); 
			request.getRequestDispatcher("./jsp/vistaAdmin/pedidoMateriaPrima.jsp").forward(request, response);
		} 
		else {
			response.getWriter().print("NO hay proveeedores");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
