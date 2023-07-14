window.addEventListener('DOMContentLoaded', event => {

	cargarVentas();
	maxVentas();
    minVentas();
	
});

function getHeader() { return { 'Accept': 'application/json', 'Content-Type': 'application/json' } }


async function cargarVentas() {
	const request = await fetch('ventas', {
		method: 'GET',
		headers: getHeader()
	});
	const dataventas = await request.json();
	console.log(dataventas);

    var totalventas = 0;
	for (let obj of dataventas) {
		//let botonPedido = '<a href="#" onclick="realizarPedido(\'' + obj.producto.id_producto + '\')" class="btn btn-info btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
		let tr = '<tr><td>' + obj.nombrecliente + '</td>' +
			'<td>' + obj.producto.nombreproducto + '</td>' +
		    '<td>' + obj.producto.valor+ '</td><td>'+ obj.cantidad + '</td>' + 
		    //'<td>' + botonPedido + '</td>' + 
			'</tr>';

		document.querySelector('#dataTable tbody').outerHTML += tr;
		
		totalventas += obj.producto.valor * obj.cantidad ;
	}
	document.querySelector('#totalventas').innerHTML += totalventas;
}


async function maxVentas(){
	const request = await fetch('productomax', {
		method: 'GET',
		headers: getHeader()
	});
	const dataventas = await request.json();
	console.log(dataventas);
	document.querySelector('#maxid').innerHTML += dataventas.nombreproducto;
}

async function minVentas(){
	const request = await fetch('productomin', {
		method: 'GET',
		headers: getHeader()
	});
	const dataventas = await request.json();
	console.log(dataventas);
	document.querySelector('#minid').innerHTML += dataventas.nombreproducto;
}

async function realizarPedido(ele){
	let datos = {};
	datos.idproducto = document.getElementById('idproducto').value;
	datos.cantidad = document.getElementById('cantidad').value;
	
	if (datos.cantidad === '') return alert('Ingrese la cantidad');
	
	const request = await fetch('realizarpedido', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'

		},
		//Converitr un objeto en un json.
		body: JSON.stringify(datos)
	});
	const respuesta = await request.text();
	console.log(respuesta);
	alert('pedido creado');
	window.location.href = "index.html";
}


