function getItems() {
    $.ajax({
        url: "http://localhost:8080/app/Registration",
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.log(data);
            // console.log(data.octoberRegistrationsarr);

            // console.log(JSON.parse(data));
            _displayItems(data);

        },
        error: function (error) {
            console.log(`Error ${error}`);
        },
    });
}
function _displayItems(data) {

    const q1 = document.getElementById("column1");
    q1.innerHTML = " <h5>earliestInSeptember</h5><br>";
    q1.innerHTML = q1.innerHTML + Object.entries(data.earliestInSeptember).map(([key, value]) => `${key}: ${value}`).join("<br>");

    const q2 = document.getElementById("column2");
    q2.innerHTML = " <h5>registrationsByEventInOctober</h5><br>";
    q2.innerHTML = q2.innerHTML + data.registrationsByEventInOctober.map(entry => `${entry.event_name}: ${entry.registration_count}`).join("<br>");

    const q3 = document.getElementById("column3");
    q3.innerHTML = " <h5>septemberRegistrationsarr</h5><br>";
    q3.innerHTML = q3.innerHTML + data.septemberRegistrationsarr.map(entry =>
        `ID: ${entry.registration_id}, Event: ${entry.event_name}, Athlete: ${entry.athlete_name}, Date: ${entry.registration_date}`
    ).join("<br>");

    const q4 = document.getElementById("column4");
    q4.innerHTML = " <h5>octoberRegistrationsarr</h5><br>";
    q4.innerHTML = q4.innerHTML + data.octoberRegistrationsarr.map(entry =>
        `ID: ${entry.registration_id}, Event: ${entry.event_name}, Athlete: ${entry.athlete_name}, Date: ${entry.registration_date}`).join("<br>");

    const q5 = document.getElementById("column5");
    q5.innerHTML = " <h5>uniqueEventsarr</h5><br>";
    q5.innerHTML = q5.innerHTML + data.uniqueEventsarr.map(entry =>
        `ID: ${entry.registration_id}, Event: ${entry.event_name}, Athlete: ${entry.athlete_name}, Date: ${entry.registration_date}`
    ).join("<br>");

    const q6 = document.getElementById("column6");
    q6.innerHTML = " <h5>marathonAthletesarr</h5><br>";
    q6.innerHTML = q6.innerHTML + data.marathonAthletesarr.map((athlete, index) => `<b>${index + 1}:</b> ${athlete}`).join("<br>");



    const tBody = document.getElementById("reg");
    tBody.innerHTML = "";
 
    data.table1.forEach((item) => {
        
        let tr = tBody.insertRow();
 
        let td1 = tr.insertCell(0);
        let registration_id = document.createTextNode(item.registration_id);
        td1.appendChild(registration_id);
 
        let td2 = tr.insertCell(1);
        let event_name = document.createTextNode(item.event_name);
        td2.appendChild(event_name);
 
        let td3 = tr.insertCell(2);
        let athlete_name = document.createTextNode(item.athlete_name);
        td3.appendChild(athlete_name);
 
        let td4 = tr.insertCell(3);
        let registration_date = document.createTextNode(item.registration_date);
        td4.appendChild(registration_date);
 })
    reg = data;
}




