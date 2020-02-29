package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Mensen extends RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {

        List people = getPersonService().getPersonsMatching(null, null, null, null, null);
		request.setAttribute("people", people);
		return "mensen.jsp";
	}

}
