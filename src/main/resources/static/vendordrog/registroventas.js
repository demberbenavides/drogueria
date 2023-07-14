window.addEventListener('DOMContentLoaded', event => {

	cargarProductos();
	const datatablesSimple = document.getElementById('datatablesSimple');
	if (datatablesSimple) {
		new simpleDatatables.DataTable(datatablesSimple);
	}

});

function getHeader() { return { 'Accept': 'application/json', 'Content-Type': 'application/json' } }

async function cargarProductos() {
	const request = await fetch('listproductos', {
		method: 'GET',
		headers: getHeader()
	});
	const dataproductos = await request.json();
	console.log(dataproductos);

	var $select = document.getElementById('idproducto');
	for (let producto of dataproductos) {
		const option = document.createElement('option');
		option.value = producto.id_producto;
		option.text = producto.nombreproducto
		$select.appendChild(option);
		//document.querySelector('#datatablesSimple tbody').outerHTML += truser;
	}
}

async function registrarVenta() {
	let datos = {};
	let producto = {};
	
	datos.nombrecliente = document.getElementById('nombrecliente').value;
	datos.idproducto = document.getElementById('idproducto').value;
	datos.cantidad = document.getElementById('cantidad').value;
	
	producto.idproducto = document.getElementById('idproducto').value;
	datos.Producto = producto;

	if (datos.nombrecliente === '') return alert('Ingrese el nombre del cliente');


	const request = await fetch('registrarventa', {
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

	if (respuesta === 'Ok') {
		alert('Venta registrada');
//		window.location.href = 'index.html';
	} else {
		alert(respuesta);
	}
}




