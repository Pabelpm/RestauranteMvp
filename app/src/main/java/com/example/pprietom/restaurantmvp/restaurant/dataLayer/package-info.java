/**
 * Es la capa en donde se obtienen todos los datos que necesita nuestra aplicación para funcionar y los datos pueden ser de proveídos por una base de datos,
 * de la red o de la memoria o de donde nos imaginemos particularmente en android hacemos uso de Repository Pattern un patrón que permite abstraer
 * el origen de datos en donde no va importar de donde vengan los datos lo importante es que seran obtenidos de algún lugar y podremos utilizarlos
 * para hacer las acciones que tengamos que hacer.

 * Algo que valdría la pena mencionar es que cada capa tiene su propio modelo de datos ya que será más fácil de testar y modificar para lo que estaremos
 * usamos mappers para estar cambiando objetos de datos a un objeto de dominio y de dominio a un objeto de nuestra vista no quiero indagar mucho aquí
 * pero cuando veas el código te darás cuenta de lo útil que es.
 */
package com.example.pprietom.restaurantmvp.restaurant.dataLayer;
