package controller;

import domain.Gender;
import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class SendForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<String>();
        Person person = new Person();
        setFirstName(person, request, errors);
        setLastName(person, request, errors);
        setGender(person, request, errors);
        setGeboortedatum(person, request, errors);
        person.setGeboorteplaats(request.getParameter("geboorteplaats"));
        person.setNationaliteit(request.getParameter("nationaliteit"));
        person.setIdentiteitskaartnummer(request.getParameter("identiteitskaartnummer"));
        setPermission(person, request, errors);
        person.setRole(Role.SLACHTOFFER);


        if (errors.size() < 1){
            try {
                this.getPersonService().addPerson(person);
                if (request.getParameter("permission").equals("Ja")){
                    return "uploadPhoto.jsp";
                }
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
        if (genderString.equals("Man")){
            gender = Gender.MALE;
        }
        else {
            if (genderString.equals("Vrouw")){
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

    private void setGeboortedatum(Person person, HttpServletRequest request, List<String> errors) {
        String geboortedatum = request.getParameter("geboortedatum");
        try{
            person.setGeboortedatum(geboortedatum);
            request.setAttribute("previousGeboortedatum", geboortedatum);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }

    private void setPermission(Person person, HttpServletRequest request, List<String> errors) {
        String permissionString = request.getParameter("permission");
        Boolean permission = false;
        if (permissionString.equals("Ja")){
            permission = true;
        }
        try{
            person.setPermission(permission);
            request.setAttribute("previousPermission", permission);
        }catch(Exception e){
            errors.add(e.getMessage());
        }
    }

}
