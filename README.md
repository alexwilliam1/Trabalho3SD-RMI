# Trabalho3SD-RMI
Comincação cliente-servidor, para aplicar flitro em uma imagem, usando RMI.

Cliente
  O cliente seleciona uma imagem do disco local, onde, é carrregada e convertida em um array de bytes e passado para a classe Servidor.

Servidor
  Recebe o array de bytes e o converte novamente para imagem. Através da função Color, os pixels são alterados para apenas o canal R(Red). 
  A nova imagem é novamene convertida em array de bytes e retornada à classe Cliente, que irá mostrar a imagem  originale a imagem modificada.
