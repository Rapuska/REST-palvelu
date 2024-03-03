package com.restpalvelu.peli;

/**
 * Math-luokassa staattinen metodi, joka laskee matemaattisen
 * laskutoimituksen kahden luvun välillä käyttäen annettua operaattoria.
 */

public class Math {

  /**
   * Metodi calculateAnswer suorittaa matemaattisen laskutoimituksen annettujen
   * numeroiden ja operaattorin perusteella.
   * 
   * @param number1  Ensimmäinen luku laskutoimituksessa.
   * @param number2  Toinen luku laskutoimituksessa.
   * @param operator Operaattori, jota käytetään laskutoimituksessa (+, -, *, /).
   * @return Laskutoimituksen tulos.
   * @throws ArithmeticException      Jos yritetään jakaa nollalla.
   * @throws IllegalArgumentException Jos annetaan virheellinen operaattori.
   */

  public static int calculateAnswer(int number1, int number2, char operator) {
    switch (operator) {
      case '+':
        return number1 + number2;
      case '-':
        return number1 - number2;
      case '*':
        return number1 * number2;
      case '/':
        if (number2 != 0) {
          return number1 / number2;
        } else {
          throw new ArithmeticException("Cannot divide by zero");
        }
      default:
        throw new IllegalArgumentException("Invalid operator");
    }
  }
}
