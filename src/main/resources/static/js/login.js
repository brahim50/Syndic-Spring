
var flag = 1;


function checkEmail() {
	var email = document.getElementById('email');
	var patern = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	if (email.value.length == 0 || !email.value.match(patern)) {
		document.getElementById('alertEmail').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		email.style.border = "1px solid red";
		email.focus();
		return false;
	}
	else {
		document.getElementById('alertEmail').innerHTML = '';
		email.style.border = "1px solid green";

		return true;
	}
}

function checkPassword() {
	var password = document.getElementById('password');
	if (password.value.length == 0) {
		document.getElementById('alertPassword').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		password.style.border = "1px solid red";
		password.style.top = "2px";
		password.focus();
		return false;
	}
	else {
		document.getElementById('alertPassword').innerHTML = '';
		password.style.border = "1px solid green";
		return true;
	}
}
togglePassword.addEventListener("click",myFunction())
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
    togglePassword.classList.add('bi-eye');
    
  } else {
    x.type = "password";
    togglePassword.classList.remove('bi-eye');
  }
}


function validateform() {
	if ( !checkEmail() || !checkPassword() ) {
		//submitError.innerHTML = 'Please Fix Error ';
		//flag = 0;
		return false
	}
	else{
		flag = 1;
		return true;
	}
}

function validate() {

	if (flag == 1) {
		return true;
	}
	else {
		return false;
	}

}