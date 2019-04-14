/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.RomanNumeralConverter;

/**
 *
 * @author Development
 */
@WebServlet(name = "convert", urlPatterns = { "/convert" })
public class convert extends HttpServlet {

	/**
	 * This lightweight static utility class contains functions that are mainly
	 * used by this endpoint such as determining if the parameter is
	 * a numeric or not, in which it can determine if it's converting
	 * to or from a roman numeral and decimal.
	 */
	static class Utils {
		public static boolean isNumeric(String str) {
			try {
				Double.parseDouble(str);
				return true;
			} catch(NumberFormatException e){
				return false;
			}
		}
	}

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * This function mainly calls the RomanNumeralConverter service to convert
	 * to and from decimal and roman numerals. This then returns the
	 * converted value to the HTTP request as raw data. We do not use a
	 * JSON object to keep the endpoint lightweight.
	 *
	 * @param request  The request coming from the HTTP protocol
	 * @param response The response containing the converted value as the payload
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			// Set the CORS value to allow access outside the domain
			response.setHeader("Access-Control-Allow-Origin", "*");
			
			String toConvert = request.getParameter("value");
			RomanNumeralConverter converter = new RomanNumeralConverter();
			try {
				if(Utils.isNumeric(toConvert)) {
					// Reaching this code block means the conversion goes from decimal to roman numeral
					int decimalValue = Integer.parseInt(toConvert);
					out.println(converter.toRomanNumeral(decimalValue));
				} else {
					// Reaching this code means the conversion goes from  roman numeral to decimal
					out.println(converter.fromRomanNumeral(toConvert));
				}	
			} catch(IllegalArgumentException error) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, error.getMessage());
			} catch(Exception error) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, error.getMessage());
			}
			
			out.close();
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "This servlet returns the converted values based on the parameter. "
						+ "There are 2 types of patameters: Integer and String. If the parameterized"
						+ "query from a GET request is a string, it is assumed that the user"
						+ "is requesting to convert from roman numerals to decimal value. Otherise,"
						+ "it's decimal value to roman numerals.";
	}// </editor-fold>
}


