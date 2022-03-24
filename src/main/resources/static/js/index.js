
/*partie de deuxiemeslide----*/
$("#slideshow > div:gt(0)").hide();

setInterval(function() { 
  $('#slideshow > div:first')
  .fadeOut(1000)
  .next()
  .fadeIn(1000)
  .end()
  .appendTo('#slideshow');
}, 3000);

/*-------slider for client--------*/

function afficher() {
      $('#login').removeClass("hidden");
  $('#login').addClass("login");
}

function dis() {

}
window.onclick = function(event) {
    if (event.target == document.getElementById("login")) {
  $('#login').addClass('hidden');
    }
}
 var valuer=2;
function like(valeur) {
valuer=valeur;
console.log(valuer);
    let f =document.getElementById(valeur);
  let favori=document.getElementById("flag").value;
   console.log(favori);
	if(f.classList.contains("aimer")) {
	document.getElementById("flag").value="no";     
	}
	else {
		document.getElementById("flag").value="ok";     

	}
	   console.log(document.getElementById("flag").value);

f.classList.toggle('aimer');
    console.log(valeur);
console.log(f);
}

/*-----Counter--------*/
jQuery(document).ready(function($) {
        $('.counter').counterUp({
    delay: 10,
    time: 4000
});
    });
/*-----Counter--------*/



/*----brands----*/
$(document).ready(function (brandSlider) {

	var slideCount = $('#brand-discount-slider ul li').length;
	var slideWidth = $('#brand-discount-slider ul li').width();
	var slideHeight = $('#brand-discount-slider ul li').height();
	var sliderUlWidth = slideCount * slideWidth;

	$('#brand-discount-slider').css({ width: slideWidth, height: slideHeight });

	$('#brand-discount-slider ul').css({ width: sliderUlWidth, marginLeft: - slideWidth });

    $('#brand-discount-slider ul li:last-child').prependTo('#brand-discount-slider ul');


    function moveLeft() {
        $('#brand-discount-slider ul').animate({
            left: + slideWidth
        }, 200, function () {
            $('#brand-discount-slider ul li:last-child').prependTo('#brand-discount-slider ul');
            $('#brand-discount-slider ul').css('left', '');
        });
    };

    function moveRight() {
        $('#brand-discount-slider ul').animate({
            left: - slideWidth
        }, 200, function () {
            $('#brand-discount-slider ul li:first-child').appendTo('#brand-discount-slider ul');
            $('#brand-discount-slider ul').css('left', '');
        });
    };


    $('.brand-arrow-prev').click(function () {
        moveLeft();
    });

    $('.brand-arrow-next').click(function () {
        moveRight();
    });
    

     setTimeout(moveLeft(), 1000); /* works only on load for the first slider...research later*/
});
function setPrix() {
var prix=document.getElementById("prix").value;
document.getElementById("prixValue").innerHTML="0-"+prix+" MAD";

}
function sendData() {
console.log(valuer);

  let flag=document.getElementById("flag").value;

 $.ajax({
    type: 'get',
    url: 'http://localhost:8080/ap/wish',
    data: {
      id:valuer,
	flag:flag,
    },
    success: function (response) {
      $('#res').html("Vos données seront sauvegardées");
    }
  });
    
  return false;


}