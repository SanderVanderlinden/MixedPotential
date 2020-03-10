var getPeopleRequest = new XMLHttpRequest();
getPeople();
setInterval("getPeople()", 5000);

function getPeople(){
    getPeopleRequest.open("GET","Controller?action=GetPeople",true);
    getPeopleRequest.onreadystatechange=getPeopleData;
    getPeopleRequest.send(null);
}

function getPeopleData () {
    if (getPeopleRequest.status == 200) {
        if (getPeopleRequest.readyState == 4) {

            var responseText = JSON.parse(getPeopleRequest.responseText);
            var people = responseText.people;

            var peopleDiv = document.getElementById("people");

            //Remove old friendList, then create a new one.
            if (peopleDiv.hasChildNodes()) {
                peopleDiv.removeChild(peopleDiv.childNodes[0]);
            }

            var table = document.createElement("table");

            var tableHeadRow = document.createElement("tr");

            var tableHeadFirstName = document.createElement("th");
            var tableHeadFirstNameText = document.createTextNode('First Name');
            tableHeadFirstName.appendChild(tableHeadFirstNameText);
            tableHeadRow.appendChild(tableHeadFirstName);

            var tableHeadLastName = document.createElement("th");
            var tableHeadLastNameText = document.createTextNode('Last Name');
            tableHeadLastName.appendChild(tableHeadLastNameText);
            tableHeadRow.appendChild(tableHeadLastName);

            var tableHeadGender = document.createElement("th");
            var tableHeadGenderText = document.createTextNode('Gender');
            tableHeadGender.appendChild(tableHeadGenderText);
            tableHeadRow.appendChild(tableHeadGender);

            table.appendChild(tableHeadRow);

            peopleDiv.appendChild(table);

            for (var i = 0; i < people.length; i++) {
                var tableRow = document.createElement('tr');

                var firstName = document.createElement('td');
                var firstNameText = document.createTextNode(people[i].firstName);
                firstName.appendChild(firstNameText);
                tableRow.appendChild(firstName);

                var lastName = document.createElement('td');
                var lastNameText = document.createTextNode(people[i].lastName);
                lastName.appendChild(lastNameText);
                tableRow.appendChild(lastName);

                var gender = document.createElement('td');
                var genderText = document.createTextNode(people[i].gender);
                gender.appendChild(genderText);
                tableRow.appendChild(gender);

                table.appendChild(tableRow);

                peopleDiv.appendChild(table);
            }
        }
    }
}