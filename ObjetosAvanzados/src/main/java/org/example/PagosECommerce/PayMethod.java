package org.example.PagosECommerce;

/**
 * @author Nacho Gamallo
 * @version 1.0
 */
abstract class PayMethod {

    /**
     * Método que procesa el pago realizado, es diferente en cada una de las extensiones de PayMethod, por lo que
     * tienen que ser definido en cada una de las clases.
     * @param totalImport imporete total de la operación.
     */
    abstract void paymentProcess(double totalImport);

    /**
     * Función de validación de cada uno de los objetos, el cual debe ser definido en cada una de las clases,
     * ya que cada objeto tiene distintos atributos y distintas cosas que deben ser comprobadas.
     * @return Devuelve un resultado booleano dependiendo si el formato es valido de todos los atributos de los objetos.
     */
    abstract boolean validatePayMethod();

}
