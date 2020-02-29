package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetPeople extends AsyncronousRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ArrayList<Person> people = (ArrayList<Person>) getPersonService().getPersons();
        String peopleJSON = this.toJSON("people", people);
        response.setContentType("application/json");
        System.out.println(peopleJSON);
        return peopleJSON;
    }

    private String toJSON(String key, ArrayList<Person> people) {
        StringBuffer json = new StringBuffer();
        json.append("{ \"");
        json.append(key);
        if(people.size() > 0){
            json.append("\" : [");
            for(Person p : people){
                json.append("{\"firstName\":\""+ p.getFirstName() + "\",\"lastName\":\"" + p.getLastName() + "\",\"gender\":\""+p.getGender()+ "\"},");
            }
            json.deleteCharAt(json.length()-1);

            json.append("] }");
        }else{
            json.append("\" : \"\"}");
        }

        return json.toString();
    }
}
