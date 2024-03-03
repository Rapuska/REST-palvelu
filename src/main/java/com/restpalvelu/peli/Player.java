package com.restpalvelu.peli;

import java.util.Objects;

/**
 * Player-luokka kuvaa pelaajaa pelissä, jolla on tietty tili ja pisteitä.
 */

public class Player {

  private String accountName; // Pelaajan tilin nimi
  private int points; // Pelaajan pisteet

  /**
   * Player-luokan konstruktori, joka luo uuden pelaajan annetulla tilin nimellä.
   * Alustaa pelaajan pisteet nollaksi.
   * 
   * @param accountName Pelaajan tilin nimi.
   */

  public Player(String accountName) {
    this.accountName = accountName;
    this.points = 0;
  }

  /**
   * Metodi getAccountName palauttaa pelaajan tilin nimen.
   * 
   * @return Pelaajan tilin nimi.
   */

  public String getAccountName() {
    return accountName;
  }

  /**
   * Metodi getPoints palauttaa pelaajan pisteet.
   * 
   * @return Pelaajan pisteet.
   */

  public int getPoints() {
    return points;
  }

  /**
   * Metodi setPoints asettaa pelaajan pisteet annetuksi arvoksi.
   * 
   * @param points Pisteet, jotka asetetaan pelaajalle.
   */

  public void setPoints(int points) {
    this.points = points;
  }

  /**
   * Metodi equals vertailee kahta Player-oliota keskenään.
   * Pelaajat ovat samat, jos niillä on sama tilin nimi ja pisteet.
   * 
   * @param o Vertailtava objekti.
   * @return true, jos pelaajat ovat samat, muuten false.
   */

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Player player = (Player) o;
    return points == player.points && Objects.equals(accountName, player.accountName);
  }

  /**
   * Metodi hashCode generoi pelaajan hash-arvon.
   * 
   * @return Pelaajan hash-arvo.
   */

  @Override
  public int hashCode() {
    return Objects.hash(accountName, points);
  }

  /**
   * Metodi toString palauttaa pelaajan tiedot merkkijonona.
   * 
   * @return Merkkijono, joka kuvaa pelaajaa.
   */

  @Override
  public String toString() {
    return "Player{" + "accountName='" + accountName + '\'' + ", points=" + points + '}';
  }
}
