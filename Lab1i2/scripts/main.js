var myButton = document.querySelector('button');
var myHeading = document.querySelector('h1');
function setUserName() {
  var myName = prompt('Wprowadz swoje imię.');
  localStorage.setItem('Imię', myName);
  myHeading.textContent = 'Miłego dnia ' + myName + ';)';
}
if(!localStorage.getItem('Imię')) {
  setUserName();
} else {
  var storedName = localStorage.getItem('Imię');
  myHeading.textContent = 'Miłego dnia nieznajomy ;)';
}
myButton.onclick = function() {
  setUserName();
}