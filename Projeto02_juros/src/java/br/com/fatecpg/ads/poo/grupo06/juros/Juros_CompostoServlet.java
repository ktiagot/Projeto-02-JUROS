/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.ads.poo.grupo06.juros;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tiago
 */
@WebServlet(name = "Juros_CompostoServlet", urlPatterns = {"/juros-composto"})
public class Juros_CompostoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

out.println("<!DOCTYPE html>"
+"<html lang='en'>"
  +"<head>"
    +"<meta charset='utf-8'>"
    +"<meta http-equiv='X-UA-Compatible' content='IE=edge'>"
    +"<meta name='viewport' content='width=device-width, initial-scale=1'>"
    +"<title>Calculadora de Juros</title>"
    +"<link href='css/bootstrap.min.css' rel='stylesheet'>"
	+"<link rel='stylesheet' href='css/font-awesome.min.css'>"
	+"<link rel='stylesheet' href='css/animate.css'>"
	+"<link rel='stylesheet' href='css/overwrite.css'>"
	+"<link href='css/animate.min.css' rel='stylesheet'> "
	+"<link href='css/style.css' rel='stylesheet' />"
  +"</head>"
  +"<body>"
	+"<header id='header'>"
        +"<nav class='navbar navbar-fixed-top' role='banner'>"
            +"<div class='container'>"
                +"<div class='navbar-header'>"
                    +"<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-collapse'>"
                        +"<span class='sr-only'>Toggle navigation</span>"
                        +"<span class='icon-bar'></span>"
                        +"<span class='icon-bar'></span>"
                        +"<span class='icon-bar'></span>"
                    +"</button>"
                    +"<a class='navbar-brand' href='home'>Calcular Juros</a>"
                +"</div>				"
                +"<div class='collapse navbar-collapse navbar-right'>"
                    +"<ul class='nav navbar-nav'>"
                        +"<li class='active'><a href='/home'>Home</a></li>"
                        +"<li><a href='/juros-simples'>Juros Simples</a></li>"
                        +"<li><a href='/juros-composto'>Juros Compostos</a></li>"
                    +"</ul>"
                +"</div>"
            +"</div><!--/.container-->"
        +"</nav><!--/nav-->		"
    +"</header><!--/header-->	"
	+"<div class='slider'>		"
		+"<div id='about-slider'>"
			+"<div id='carousel-slider' class='carousel slide' data-ride='carousel'>"
				+"<!-- Indicators -->"
				+"<ol class='carousel-indicators visible-xs'>"
					+"<li data-target='#carousel-slider' data-slide-to='0' class='active'></li>"
					+"<li data-target='#carousel-slider' data-slide-to='1'></li>"
					+"<li data-target='#carousel-slider' data-slide-to='2'></li>"
				+"</ol>"
				    +"<div class='item'>"
						+"<img src='img/1.jpg' class='img-responsive' alt=''> "
						+"<div class='carousel-caption'>"
							+"<div class='wow fadeInUp' data-wow-offset='0' data-wow-delay='0.5s'>"								
								+"<h2>Calcule Juros Compostos</h2>"
							+"</div>"
						+"</div>"
				    +"</div>"
				+"</div>"
				+"<a class='left carousel-control hidden-xs' href='#carousel-slider' data-slide='prev'>"
					+"<i class='fa fa-angle-left'></i> "
				+"</a>"	
				+"<a class='right carousel-control hidden-xs'href='#carousel-slider' data-slide='next'>"
					+"<i class='fa fa-angle-right'></i> "
				+"</a>"
			+"</div> <!--/#carousel-slider-->"
                     +"<center><form><table style='text-align:right; font-size:20px'>"
                        +"<td><br></td>"
                        +"<tr><td>Taxa de Juros (%): </td><td> <input type='text' name='juros'/></td></tr>"
                        +"<td><br></td>"
                        +"<tr><td>Valor: </td><td> <input type='text' name='val'/></td></tr>"
                        +"<td><br></td>"
                        +"<tr><td>Período em meses: </td><td> <input type='text' name='tempo'/></td></tr>"
                        +"<td><br></td>"
                        +"<tr><td colspan='2'><center><input type='submit' value='Calcular'/><center></td></tr>"
                        +"<td><br></td>");
                        DecimalFormat aj = new DecimalFormat("###,##0.00");
                        double juros = 100, calcj = 0, val = 0;
                        int tempo = 0;
                        try
                        {
                            juros = Double.parseDouble(request.getParameter("juros"));
                            val = Double.parseDouble(request.getParameter("val"));
                            tempo = Integer.parseInt(request.getParameter("tempo"));
                        }
                        catch(Exception ex)
                        {
                        }
                        calcj = val;
                        juros = juros/100;
                        for(int i = 0; i < tempo; i++)
                        {
                            calcj = (juros * calcj) + calcj;
                            out.println("<tr>"
                            +"<td>Valor: R$"+ aj.format(val) 
                            +"</td><td>Com Juros: R$" + aj.format(calcj) 
                            +"</td><td>Tempo: " + (i+1) 
                            +"</td></tr>");
                        }
                        out.println("</form></table>"
            +"</div><div></div><!--/#about-slider-->"
        +"<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->"
    +"<script src='js/jquery-2.1.1.min.js'></script>"
    +"<!-- Include all compiled plugins (below), or include individual files as needed -->"
    +"<script src='js/bootstrap.min.js'></script>"
	+"<script src='js/parallax.min.js'></script>"
	+"<script src='js/wow.min.js'></script>"
	+"<script src='js/jquery.easing.min.js'></script>"
	+"<script type='text/javascript' src='js/fliplightbox.min.js'></script>"
	+"<script src='js/functions.js></script>"
	+"<script>"
	+"wow = new WOW("
	 +"{"
		+"}"	
                +")" 
		+".init();"
	+"</script>"
      
  +"</body>"
+"</html>");
                                                                            

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
