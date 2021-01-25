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


