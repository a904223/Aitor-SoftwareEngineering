
    function edit_row() {
        var filas = document.getElementById("data_table").rows.length;
        var i;

        
        for (i=1; i < (filas); i++){
            document.getElementById("modificar").style.display="none";
            document.getElementById("guardar").style.display="block";
            
            var name=document.getElementById(i + "_1");
            var surname=document.getElementById(i + "_2");
            var email=document.getElementById(i + "_3");
            var mobile_phone=document.getElementById(i + "_4");
            var date_of_birth=document.getElementById(i + "_5");
            var job_title=document.getElementById(i + "_6");
            var department=document.getElementById(i + "_7");
            var salary=document.getElementById(i + "_8");
            var works_with_commision=document.getElementById(i + "_9");
            var commision=document.getElementById(i + "_10");
            

            var name_data=name.innerHTML;
            var surname_data=surname.innerHTML;
            var email_data=email.innerHTML;
            var mobile_phone_data=mobile_phone.innerHTML;
            var date_of_birth_data=date_of_birth.innerHTML;
            var job_title_data=job_title.innerHTML;
            var department_data=department.innerHTML;
            var salary_data=salary.innerHTML;
            var works_with_commision_data=works_with_commision.innerHTML;
            var commision_data=commision.innerHTML;
            

            name.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-1\" value=\"" + name_data + "\"></input>";
            surname.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-2\" value=\"" + surname_data + "\"></input>";
            email.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-3\" value=\"" + email_data + "\"></input>";
            mobile_phone.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-4\" value=\"" + mobile_phone_data + "\"></input>";
            date_of_birth.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-5\" value=\"" + date_of_birth_data + "\"></input>";
            job_title.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-6\" value=\"" + job_title_data + "\"></input>";
            department.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-7\" value=\"" + department_data + "\"></input>";
            salary.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-8\" value=\"" + salary_data + "\"></input>";
            works_with_commision.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-9\" value=\"" + works_with_commision_data + "\"></input>";
            commision.innerHTML="<input type='text' size=\"10\" id=\"" + i + "-10\" value=\"" + commision_data + "\"></input>";
            
        }


    }

    function save_row() {
        var filas = document.getElementById("data_table").rows.length;
        var j;
        
        for (j=1; j < (filas); j++){
            var name_val=document.getElementById( j + '-1').value;
            var surname_val=document.getElementById( j + '-2').value;
            var email_val=document.getElementById( j + '-3').value;
            var mobile_phone_val=document.getElementById( j + '-4').value;
            var date_of_birth_val=document.getElementById( j + '-5').value;
            var job_title_val=document.getElementById( j + '-6').value;
            var department_val=document.getElementById( j + '-7').value;
            var salary_val=document.getElementById( j + '-8').value;
            var works_with_commision_val=document.getElementById( j + '-9').value;
            var commision_val=document.getElementById( j + '-10').value;

            document.getElementById(j + "_1").innerHTML=name_val;
            document.getElementById(j + "_2").innerHTML=surname_val;
            document.getElementById(j + "_3").innerHTML=email_val;
            document.getElementById(j + "_4").innerHTML=mobile_phone_val;
            document.getElementById(j + "_5").innerHTML=date_of_birth_val;
            document.getElementById(j + "_6").innerHTML=job_title_val;
            document.getElementById(j + "_7").innerHTML=department_val;
            document.getElementById(j + "_8").innerHTML=salary_val;
            document.getElementById(j + "_9").innerHTML=works_with_commision_val;
            document.getElementById(j + "_10").innerHTML=commision_val;
            

            document.getElementById("modificar").style.display="block";
            document.getElementById("guardar").style.display="none";
        }
    }

    // function delete_row(no) {
        // document.getElementById("row"+no+"").outerHTML="";
    // }

    // function add_row() {
        // var new_name=document.getElementById("new_name").value;
        // var new_country=document.getElementById("new_country").value;
        // var new_age=document.getElementById("new_age").value;

        // var table=document.getElementById("data_table");
        // var table_len=(table.rows.length)-1;
        // var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'><td id='name_row"+table_len+"'>"+new_name+"</td><td id='country_row"+table_len+"'>"+new_country+"</td><td id='age_row"+table_len+"'>"+new_age+"</td><td><input type='button' id='edit_button"+table_len+"' value='Edit' class='edit' onclick='edit_row("+table_len+")'> <input type='button' id='save_button"+table_len+"' value='Save' class='save' onclick='save_row("+table_len+")'> <input type='button' value='Delete' class='delete' onclick='delete_row("+table_len+")'></td></tr>";

        // document.getElementById("new_name").value="";
        // document.getElementById("new_country").value="";
        // document.getElementById("new_age").value="";
    // }