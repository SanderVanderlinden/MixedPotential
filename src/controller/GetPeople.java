package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetPeople extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ArrayList<Person> people = (ArrayList<Person>) getPersonService().getPersons();
        String peopleJSON = this.toJSON("people", people);
        response.setContentType("application/json");
        request.setAttribute("people", peopleJSON);
        return "alledata.jsp";
    }

    private String toJSON(String key, ArrayList<Person> people) {
        StringBuffer json = new StringBuffer();
        json.append("{ \"");
        json.append(key);
        if(people.size() > 0){
            json.append("\":{");
            for(Person p : people){
                json.append("\"firstName\":\"" + p.getFirstName() + "\"");
                json.append(",\"lastName\":\"" + p.getLastName() + "\"");
                json.append(",\"gender\":\"" + p.getGender() + "\"");
                json.append(",\"geboortedatum\":\"" + p.getGeboortedatum() + "\"");
                json.append(",\"nationaliteit\":\"" + p.getGeboorteplaats() + "\"");
                json.append(",\"identiteitskaartnummer\":\"" + p.getIdentiteitskaartnummer() + "\"");
                json.append(",\"permission\":\"" + p.getPermission() + "\"");
                json.append(",\"role\":\"" + p.getRole()+ "\"},");
            }
            json.deleteCharAt(json.length()-1);

            json.append(" }");
        }else{
            json.append("\" : \"\"}");
        }

        return json.toString();
    }
}
