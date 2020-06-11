## Repositorio

	- https://github.com/mtazzioli/rosder-2.ejercicio-desarrollo


## Ejercicio 1: curl requests:

	New:
		Persona Jurídica:
		curl --location --request POST 'http://localhost:8080/api/titular/personaJuridica' \
		--header 'Content-Type: application/json' \
		--data-raw '{
			"rut": "1",
			"razonSocial": "Desarollar todos l",
			"anoFundacion": "2000"
		}'
		
		Persona Física:
		curl --location --request POST 'http://localhost:8080/api/titular/personaFisica' \
		--header 'Content-Type: application/json' \
		--data-raw '{
			"rut":"2",
			"nombre":"Marcelo",
			"apellido":"Tazzioli",
			"cc":"ASDF"
		}'
	
	Read:
	curl --location --request GET 'http://localhost:8080/api/titular/personaJuridica/[id]'
	curl --location --request GET 'http://localhost:8080/api/titular/personaFisica/[id]'
	
	Update:
	curl --location --request POST 'http://localhost:8080/api/titular/personaFisica' \
	--header 'Content-Type: application/json' \
	--data-raw '{
	    "id": 2,
	    "rut": "2",
	    "nombre": "Marcelo Hernán",
	    "apellido": "Tazzioli APE",
	    "cc": "ASDFT"
	}'
	
	Delete:
	curl --location --request DELETE 'http://localhost:8080/api/titular/personaJuridica/[id]'
	curl --location --request DELETE 'http://localhost:8080/api/titular/personaFisica/[id]'
	
	Listado de titulares:
	curl --location --request GET 'http://localhost:8080/api/titular/findAll'


## Ejercicio 2, curl requests para los endpoints requeridos:

	   1. *crear cuenta*
	   
	   Cuenta Corriente (el saldo siempre se inicializa en 0 y se modifica a través de movimientos):
		curl --location --request POST 'http://localhost:8080/api/cc' \
		--header 'Content-Type: application/json' \
		--data-raw '{
			"numeroCuenta": "1",
			"saldo": "10",
			"tipoMoneda": "PESO"
		}'
			
	   
	   2. *eliminar cuenta*
	   
	   curl --location --request DELETE 'http://localhost:8080/api/cc/[id]'
	   
	   3. *listar cuentas*
	   
	   curl --location --request GET 'http://localhost:8080/api/cc/findAll'
	   
	   4. *agregar movimiento*
	   
	   curl --location --request POST 'http://localhost:8080/api/movimiento' \
		--header 'Content-Type: application/json' \
		--data-raw '{
			"cuentaCorriente": {
				"id": "1"
			},
			"descripcion": "Venta de insumos",
			"importe": "10",
			"tipoMovimiento": "DEBITO"
		}'
	   
	   curl --location --request POST 'http://localhost:8080/api/movimiento' \
		--header 'Content-Type: application/json' \
		--data-raw '{
			"cuentaCorriente": {
				"id": "1"
			},
			"descripcion": "Pago de insumos",
			"importe": "2000",
			"tipoMovimiento": "CREDITO"
		}'
	   
	   5. *listar movimientos x cuenta* (ordenados de forma decreciente, por fecha)
	   
	   curl --location --request GET 'http://localhost:8080/api/cc/[id]'