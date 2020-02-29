package controller;

import domain.Gender;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MensenFiltered extends RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String genderString = request.getParameter("gender");
		String geboortedatum = request.getParameter("geboortedatum");
		String nationaliteit = request.getParameter("nationaliteit");
        System.out.println(firstName);

        if (firstName.trim().isEmpty()){
		    firstName = null;
        }
        else{
            firstName = firstName.toLowerCase();
        }
        if (lastName.trim().isEmpty()){
            lastName = null;
        }
        else{
            lastName = lastName.toLowerCase();
        }
        Gender gender = Gender.OTHER;
        if(genderString.equals("Man")){
            gender = Gender.MALE;
        }
        if(genderString.equals("Vrouw")){
            gender = Gender.FEMALE;
        }
        if(genderString.equals("Unk")){
            gender = null;
        }
        if (geboortedatum.trim().isEmpty()){
            geboortedatum = null;
        }
        if (nationaliteit.trim().isEmpty()){
            nationaliteit = null;
        }
        else{
            nationaliteit = nationaliteit.toLowerCase();
        }
		List people = getPersonService().getPersonsMatching(firstName, lastName, gender, geboortedatum, nationaliteit);
		request.setAttribute("people", people);
		return "mensen.jsp";
	}

}
