package com.restpalvelu.peli;

import java.util.HashMap;
import java.util.Map;

/**
 * PlayerManager-luokka hallinnoi pelaajia pelissä.
 */

public class PlayerManager {
  private Map<String, Player> players; // Tallettaa pelaajat HashMap-rakenteeseen

  /**
   * PlayerManager-luokan konstruktori, joka alustaa pelaajien listan.
   */

  public PlayerManager() {
    this.players = new HashMap<>();
  }

  /**
   * Metodi registerPlayer rekisteröi uuden pelaajan peliin.
   * Jos pelaajaa ei ole jo listassa, lisätään uusi pelaaja annetulla tilin
   * nimellä.
   * 
   * @param accountName Uuden pelaajan tilin nimi.
   */

  public void registerPlayer(String accountName) {
    if (!players.containsKey(accountName)) {
      players.put(accountName, new Player(accountName));
    }
  }

  /**
   * Metodi getPlayers palauttaa pelaajat HashMap-rakenteessa.
   * 
   * @return Map-objekti, joka sisältää pelaajat ja niiden tilin nimet.
   */

  public Map<String, Player> getPlayers() {
    return players;
  }
}
