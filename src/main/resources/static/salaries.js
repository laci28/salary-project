function addSalary(){
    const name = $('#modal-salaries-name').val();
    const functions = $('#modal-salaries-functions').val();
    const grossSalary = $('#modal-salaries-grossSalary').val();
    const hoursWorked = $('#modal-salaries-hoursWorked').val();
    const overtime = $('#modal-salaries-overtime').val();

    fetch('/api/salaries', {
        method:'POST',
        body: JSON.stringify({
            name: name,
            functions: functions,
            grossSalary: grossSalary,
            hoursWorked: hoursWorked,
            overtime: overtime
        }),
        headers:{
        'Content-Type':'application/json'
        }
    }).then(response => location.reload());
}

function openEditSalary(){

$('.fa-edit').click(function(){)
    let salaryIdToEdit = this.parentElement.id;
    const row = this.parentElement.parentElement;
    const name = row.children[0].innerText;
    const functions = row.children[1].innerText;
    const grossSalary = row.children[2].innerText;

    $('#modal-salaries-name');

    });
});
