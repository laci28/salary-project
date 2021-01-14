function addSalary(){
    const name = $('#modal-salaries-name').val();
    const position = $('#modal-salaries-functions').val();
    const grossSalary = $('#modal-salaries-grossSalary').val();
    const hoursWorked = $('#modal-salaries-hoursWorked').val();
    const overtime = $('#modal-salaries-overtime').val();
    const persoaneInIntretinere = $('#modal-salaries-persoaneInIntretinere').val();

    fetch('/api/salaries', {
        method:'POST',
        body: JSON.stringify({
            name: name,
            position: position,
            grossSalary: grossSalary,
            hoursWorked: hoursWorked,
            overtime: overtime,
            persoaneInIntretinere: persoaneInIntretinere
        }),
        headers:{
        'Content-Type':'application/json'
        }
    }).then(response => {
            if (response.ok) {
                location.reload()
            } else {
                alert()
            }
    });
}


function editSalary(salaryIdToEdit) {
    const name = $('#modal-salaries-name').val();
    const position = $('#modal-salaries-functions').val();
    const grossSalary = $('#modal-salaries-grossSalary').val();
    const hoursWorked = $('#modal-salaries-hoursWorked').val();
    const overtime = $('#modal-salaries-overtime').val();
    const persoaneInIntretinere = $('#modal-salaries-persoaneInIntretinere').val();

    fetch('/api/salaries/' + salaryIdToEdit, {
        method: 'PUT',
        body: JSON.stringify({
            name: name,
            position: position,
            grossSalary: grossSalary,
            hoursWorked: hoursWorked,
            overtime: overtime,
            persoaneInIntretinere: persoaneInIntretinere
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(response => location.reload());
}

$(document).ready(() => {
    let salaryIdToEdit = null;

    $('#add-salaries-button').click(function () {
        if (salaryIdToEdit) {
            editSalary(salaryIdToEdit);
        } else {
            addSalary();
        }
    });

    $('.fa-edit').click(function () {
        salaryIdToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const name = row.children[0].innerText;
        const position = row.children[1].innerText;
        const grossSalary = row.children[2].innerText;
        const hoursWorked = row.children[3].innerText;
        const overtime = row.children[4].innerText;
        const persoaneInIntretinere = row.children[5].innerText;

        $('#modal-salaries-name').val(name);
        $('#modal-salaries-functions').val(position);
        $('#modal-salaries-grossSalary').val(grossSalary);
        $('#modal-salaries-hoursWorked').val(hoursWorked);
        $('#modal-salaries-overtime').val(overtime);
        $('#modal-salaries-persoaneInIntretinere').val(persoaneInIntretinere);

    });

    $('.fa-trash-alt').click(function () {
        const toDelete = this.parentElement.id;
        fetch('/api/salaries/' + toDelete, {
            method: 'DELETE'
        }).then(response => location.reload());

    });
});


$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#salaryData tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
