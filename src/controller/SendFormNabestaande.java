package controller;

import domain.Gender;
import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class SendFormNabestaande extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<String>();
        Person person = new Person();
        setFirstName(person, request, errors);
        setLastName(person, request, errors);
        setGender(person, request, errors);
        person.setRole(Role.NABESTAANDE);



        if (errors.size() < 1){
            try {
                this.getPersonService().addPerson(person);
                return "index.jsp";
            }catch(Exception e){
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
                return "index.jsp";
            }
        }else {
            request.setAttribute("errors", errors);
            return "index.jsp";
        }
    }

    private void setFirstName(Person person, HttpServletRequest request, List<String> errors){
        String firstName = request.getParameter("firstName");
        try{
            person.setFirstName(firstName);
            request.setAttribute("previousFirstname", firstName);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }

    private void setLastName(Person person, HttpServletRequest request, List<String> errors){
        String lastName = request.getParameter("lastName");
        try{
            person.setLastName(lastName);
            request.setAttribute("previousLastname", lastName);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }


    private void setGender(Person person, HttpServletRequest request, List<String> errors){
        String genderString = request.getParameter("gender");
        Gender gender = Gender.OTHER;
        System.out.println(genderString);
        if (genderString.equals("Male")){
            gender = Gender.MALE;
        }
        else {
            if (genderString.equals("Female")){
                gender = Gender.FEMALE;
            }
        }
        try{
            person.setGender(gender);
            request.setAttribute("previousGender", gender);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }
}
