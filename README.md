# Calculadora
Calculadora para dispositivos móviles, que en orientación vertical realiza las operaciones básicas de una calculadora y en orientación horizontal funciona como una calculadora científica.

## Análisis 📋
Para realizar el cálculo de las expresiones matemáticas ingresadas en la calculadora, se diseñó un algoritmo para convertir dichas expresiones de notación *infija a postfija*. Para ello se empleó una pila auxiliar y se propuso una tabla de prioridad de los operadores y funciones de la calculadora. 

| Token/Pila |  +  |  -  |  *  |  /  |  %  |  ^  | función |  (  |  )  |
|     +      |  1  |  1  |  1  |  1  |  1  |  1  |    1    |  0  | N/A |
|     -      |  1  |  1  |  1  |  1  |  1  |  1  |    1    |  0  | N/A |
|     *      |  0  |  0  |  1  |  1  |  1  |  1  |    1    |  0  | N/A |
|     /      |  0  |  0  |  1  |  1  |  1  |  1  |    1    |  0  | N/A |
|     %      |  0  |  0  |  1  |  1  |  1  |  1  |    1    |  0  | N/A |
|     ^      |  0  |  0  |  0  |  0  |  0  |  0  |    1    |  0  | N/A |
|  función   |  0  |  0  |  0  |  0  |  0  |  0  |    1    |  0  | N/A |
|     (      |  0  |  0  |  0  |  0  |  0  |  0  |    0    |  0  | N/A |
|     )      | N/A | N/A | N/A | N/A | N/A | N/A |   N/A   | N/A | N/A |

Dada una expresión matemática, se analiza cada elemento que la compone de izquierda a derecha. Si el elemento es un número se escribe directamente en la expresión de salida de la notación postfija, de lo contrario se revisa la tabla de prioridad para realizar alguna operación sobre la pila. El algoritmo
funciona bajo las siguientes reglas:

1. Si la pila está vacía, se inserta el operador o función en turno en la pila.
2. Si hay elementos en la pila y aún quedan elementos en la expresión, se siguen las reglas de la tabla de prioridad:
  2.1 Si el elemento que se encuentra arriba de la pila tiene mayor prioridad que el elemento de la expresión (token), se saca de la pila y se escribe en la expresión en notación postfija.
  2.2 De lo contrario, se mete el token a la pila.
3. Cuando el token es un paréntesis que cierra, se sacan los elementos de la pila y se van colocando en la expresión de salida hasta que se encuentra el paréntesis que abre. Los paréntesis no se deben incluir en la salida de la conversión.
4. Si ya no quedan más tokens, se extraen todos los elementos de la pila y se agregan a la salida de la conversión.

Las funciones incluidas en la calculadora científica son: **raíz cuadrada, potencia, factorial, logaritmo natural, logaritmo base 10, seno, coseno, tangente, cotangente, secante y cosecante**. Para que el algoritmo funcione los argumentos de las funciones deben ir entre paréntesis.

Después de realizar la conversión se evalúa la expresión, es decir, se realiza el cálculo. Para ello también se emplea una pila auxiliar donde se colocan los números. La expresión se recorre de izquierda a derecha y se realizan las siguientes operaciones sobre la pila:
1. Se meten los números a la pila hasta encontrar un operador o una función.
  1.1 Si es un operador binario, se extraen dos números de la pila, se realiza la operación y el resultado se coloca arriba de la pila.
  1.2 Si es una función, se extrae un número de la pila, se calcula el valor de la función y se coloca arriba de la pila.
2. Si al terminar de recorrer la expresión, después de la última función u operador, aún quedan número en la pila, se tiene un error de sintaxis.

## Construcción 🛠️

Se desarrollaron las clases para la conversión a notación postfija y la evaluación de la expresión. El desarrollo de la aplicación se realizó en Android Studio y se compone de un MainActivity que está disponible en modo portrait y modo landscape. En modo portrait contiene dos fragmentos, uno para la pantalla y otro para los dígitos y las operaciones básicas de la calculadora. En modo landscape, contiene los fragmentos del modo portrait y uno adicional que contiene las funciones de la calculadora científica. Cabe señalar que los elementos (tokens) de las expresiones tanto infija como postfija se separaron mediante un espacio en blanco. Para visualizar la conversión de notación infija a postfija se empleó un elemento Toast.

## Autor ✒️

* **Silvia Martínez H** 
