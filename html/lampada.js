document.getElementById('texto').innerHTML = 'Olá Mundo';
document.getElementById('texto').style.background = '#000000';
document.getElementById('texto').style.color = '#ffffff';
var qtLigar = 0;
function lampada(status){
	
	//alert("funcao ok "+status);
	//if(qtLigar < 4 && status == 1){
	if(status == 1){
		document.getElementById('lampada').src =
		'https://www.w3schools.com/js/pic_bulbon.gif';		
		document.getElementById('corpo').style.background = '#ffffff';
		document.getElementById('corpo').style.color = '#000000';
		qtLigar++;
		//alert(qtLigar);
	}
	//}else{alert('lampada queimada');}
	
	if(status == 0){
		document.getElementById('lampada').src =
		'https://www.w3schools.com/js/pic_bulboff.gif';		
		document.getElementById('corpo').style.background = '#000000';
		document.getElementById('corpo').style.color = '#ffffff';
	}
}