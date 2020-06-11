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
	curl --location --request GET 'http://localhost:8080/api/titular/personaFisica/2'
	
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
	curl --location --request DELETE 'http://localhost:8080/api/titular/personaFisica/2'
	
	Listado de titulares:
	curl --location --request GET 'http://localhost:8080/api/titular/findAll'


## Ejercicio 2: curl requests:


	