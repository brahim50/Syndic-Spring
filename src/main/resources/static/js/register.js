/**
 * 
 */

var password = document.getElementById("password");
var submitError = document.getElementById('submit-error');
const togglePassword = document.getElementById("togglePassword");
var flag = 1;

function checkConfirmPassword() {
	var passwordRe = document.getElementById('passwordRe');
	if (passwordRe.value.length > 0) {
		if (passwordRe.value != password.value) {
			document.getElementById('alert').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
			passwordRe.style.border = "1px solid red";
		    passwordRe.focus();

			flag = 0;
			return false;
		}
		else {
			document.getElementById('alert').innerHTML = '<i class="bi bi-check2"></i>';
			passwordRe.style.border = "1px solid green";
		    
			flag = 1;
			return true;
		}

	} else {
		document.getElementById('alert').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>'
		flag = 0;
		return false;
	}
}
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
		document.getElementById('alertEmail').innerHTML = '<i class="bi bi-check2"></i>';
		email.style.border = "1px solid green";

		return true;
	}
}
function checkFirstName() {
	var name = document.getElementById('name');
	if (name.value.length == 0) {
		document.getElementById('alertFirstName').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		name.style.border = "1px solid red";
		name.style.top = "2px";
		name.focus();
		return false;
	}
	else {
		document.getElementById('alertFirstName').innerHTML = '<i class="bi bi-check2"></i>';
		name.style.border = "1px solid green";
		return true;
	}
}
function checkLastName() {
	var prenom = document.getElementById('prenom');
	if (prenom.value.length == 0) {
		document.getElementById('alertLastName').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		prenom.style.border = "1px solid red";
		prenom.style.top = "2px";
		prenom.focus();
		return false;
	}
	else {
		document.getElementById('alertLastName').innerHTML = '<i class="bi bi-check2"></i>';
		prenom.style.border = "1px solid green";
		return true;
	}
}
function checkPhone() {
	var phone = document.getElementById('phone');
	var paterne = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
	var pass = document.getElementById('pass');
	if (phone.value.length == 0 || !phone.value.match(paterne) ) {
		document.getElementById('alertPhone').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		phone.style.border = "1px solid red";
		phone.style.top = "2px";
		pass.style.position = "absolute";
		pass.style.bottom = "80px";
		phone.focus();
		return false;
	}
	else {
		document.getElementById('alertPhone').innerHTML = '<i class="bi bi-check2"></i>';
		phone.style.border = "1px solid green";
		pass.style.position = "absolute";
		pass.style.bottom = "80px";
		return true;
	}
}
function checkCity() {
	var city = document.getElementById('city');
	if (city.value.length == 0) {
		document.getElementById('alertCity').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		city.style.border = "1px solid red";
		city.style.top = "2px";
		city.focus();
		return false;
	}
	else {
		document.getElementById('alertCity').innerHTML = '<i class="bi bi-check2"></i>';
		city.style.border = "1px solid green";
		return true;
	}
}
function checkPhoto() {
	var customFile = document.getElementById('customFile');
	if (customFile.value.length == 0) {
		document.getElementById('alertPhoto').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		customFile.style.border = "1px solid red";
		customFile.style.top = "2px";
		customFile.focus();
		return false;
	}
	else {
		document.getElementById('alertPhoto').innerHTML = '<i class="bi bi-check2"></i>';
		customFile.style.border = "1px solid green";
		return true;
	}
}
function checkPassword() {
	var password = document.getElementById('password');
	var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{9,20}$/;
	if (password.value.length == 0 || !password.value.match(passw)) {
		document.getElementById('alertPassword').innerHTML = '<i class="bi bi-exclamation-circle-fill"></i>';
		password.style.border = "1px solid red";
		password.style.top = "2px";
		password.focus();
		return false;
	}
	else {
		document.getElementById('alertPassword').innerHTML = '<i class="bi bi-check2"></i>';
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
	if (!checkFirstName() || !checkLastName() || !checkEmail() || !checkCity() || !checkPhone() || !checkPhoto() || !checkPassword() || !checkConfirmPassword() ) {
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

