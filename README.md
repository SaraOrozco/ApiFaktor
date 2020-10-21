# ApiFaktor
Faktor Rsk
CRUD de Riesgos
CRUD de Empresas
CRUD de Proyectos
////Para crear un proyecto////
https://api-faktor-riskhero.herokuapp.com/api/proyectos
En el body se debe poner:
{
"id": 20,
"descripcion": "Proyecto para obtener riesgo IRL",
"nombre": "proyecto2",
"empresa": {
"id": 1,
"nombre": "empresa1",
"nit": "1001",
"descripcion": "Empresa encargada de las pensiones",
"direccion": "Calle 43 #51-67",
"telefono": "2335678",
"l_riesgos": [
{
"id": 1,
"nombre": "Pruebauno",
"consecutivoRiesgo": "Pruebauno",
"procesoAsociado": "Pruebauno",
"descripcionRiesgo": "Pruebauno",
"riesgosAsociados": "Pruebauno",
"causasRiesgo": "Pruebauno",
"factorRiesgo": "Pruebauno"
}
]
}
}

////Para actualizar un proyecto////
https://api-faktor-riskhero.herokuapp.com/api/proyectos/{id}
en {id} se pone el id del proyecto a actualizar
por ejemplo id = 20
https://api-faktor-riskhero.herokuapp.com/api/proyectos/20
En el body se pone el json y se editan los cambios que se requieran.
{
"id": 20,
"descripcion": "Proyecto para obtener riesgo IRL",
"nombre": "proyecto2",
"empresa": {
"id": 1,
"nombre": "empresa1",
"nit": "1001",
"descripcion": "Empresa encargada de las pensiones",
"direccion": "Calle 43 #51-67",
"telefono": "2335678",
"l_riesgos": [
{
"id": 1,
"nombre": "Pruebauno",
"consecutivoRiesgo": "Pruebauno",
"procesoAsociado": "Pruebauno",
"descripcionRiesgo": "Pruebauno",
"riesgosAsociados": "Pruebauno",
"causasRiesgo": "Pruebauno",
"factorRiesgo": "Pruebauno"
}
]
}
}

///Para Eliminar un proyecto////
https://api-faktor-riskhero.herokuapp.com/api/proyectos/{id}
en {id} se pone el id del proyecto a eliminar
por ejemplo id = 20
https://api-faktor-riskhero.herokuapp.com/api/proyectos/20

/////Para leer la lista de todos los proyectos//////
https://api-faktor-riskhero.herokuapp.com/api/proyectos

o de un proyecto en específico
https://api-faktor-riskhero.herokuapp.com/api/proyectos/{id}
en {id} se pone el id del proyecto que se desea buscar.

Riegos de liquidez.
ide = ID de empresa 
https://api-faktor-riskhero.herokuapp.com/api/proyectos/empresas/{ide}/liquidez
Reportes 
https://api-faktor-riskhero.herokuapp.com/api/proyectos/empresas/{ide}/reportes
