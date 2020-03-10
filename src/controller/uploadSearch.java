package controller;

import domain.Gender;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class uploadSearch extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request,
                                HttpServletResponse response) {

        List people = getPersonService().getPersonsMatching("Sander", null, null, null, null);
        System.out.println(people);
        people.add(new Person("Sander", "Vanderlinden", Gender.MALE, "1996-05-23", "Belg"));
        System.out.println(people);
        request.setAttribute("people", people);
        return "mensen.jsp";
    }

}
