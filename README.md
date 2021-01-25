# Operación Fuego de Quasar

Partiendo de los siguientes 3 satelites los cuales conocemos sus posiciones (x,y):
 - kenobi: (-500,-200)
 - skywalker: (100,-100)
 - sato: (500,100)

Una nave emite un mensaje que estos satelites reciben, el mensaje puede no llegar completo a cada satélite debido al campo de asteroides frente a la nave.

Cuando el mensaje llega a un satélite a este le llega la información del mensaje (que puede no estar completa o estar desfasada) y la distacion de la nave emisora del mensaje.

Con esta información completa en los 3 satélites se debe determinar la posicion de la nave emisora y el mensaje completo.

#### Determinar posicion de la nave emisora

Para determinar la posicion x y y del emisor se realizaron con las siguientes ecuaciones por el metodo de trilateración:

![](https://github.com/PedroVega93/operationQuasar/blob/main/doc/formula_trilateracion.png)

Para resolver le problema planteado es necesario desarrollar y exponer 3 servicios como explica en este documento: 

- [Operacion Fuego de Quasar](https://github.com/PedroVega93/operationQuasar/blob/main/doc/Operacion%20Fuego%20de%20Quasar.pdf "Problema planteado")

#### Consumir servicios 

Los servicios se desplegaron en AWS y puedes ser consumidos mediante Postman o directamente en el Swagger expuesto por el microservicio

En este repositorio se puede encontrar un archivo para importar en Postman y consumir los servicios, ya tiene las 5 pestañas consumir directamente los metodos [Descargar aquí](https://github.com/PedroVega93/operationQuasar/blob/main/doc/Operation-quasar.postman_collection_POSTMAN.json)
###### POST:
- /operation-quasar/api/topsecret 
- /operation-quasar/api/topsecret_split/kenobi
- /operation-quasar/api/topsecret_split/skywalker
- /operation-quasar/api/topsecret_split/sato
###### GET:
- /operation-quasar/api/topsecret_split

Dsde este link [Swagger](http://52.22.71.80:8080/operation-quasar/api/swagger-ui.html) se puede acceder al Swagger expuesto por el microservicio.
