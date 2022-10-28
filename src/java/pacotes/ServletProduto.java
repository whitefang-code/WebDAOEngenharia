/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pacotes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author whitefang
 */


@WebServlet(name = "ServletProduto",
            urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException { 
        processRequest(request,response);
                
            }  

    

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
           processRequest(request,response); 

}


    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    String acao;
        acao = request.getParameter("acao");
    if(acao==null) acao="listar";
    String paginaDestino = (acao.equals("incluir"))?
            "ProdutosDados.html" : "ProdutoLista.jsp";
    ProdutoDAO dao = new ProdutoDAO();
    switch(acao){
    case "incluirX":
      int codigo = Integer.parseInt(request.getParameter("codigo"));
      String nome = request.getParameter("nome");
      int quantidade = Integer.parseInt(request.getParameter("quantidade"));
      dao.incluir(new Produto(codigo,nome,quantidade));
      break;
    case "excluirX":
      dao.excluir(Integer.valueOf(request.getParameter("codigo")));
      break;
    }
    if(!acao.equals("incluir")){
      request.setAttribute("listaProduto", dao.obterTodos());
    }
    request.getRequestDispatcher(paginaDestino).
            forward(request, response);
  }
 
  // O restante do código foi omitido
 
}
