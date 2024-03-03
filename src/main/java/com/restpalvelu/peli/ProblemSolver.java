package com.restpalvelu.peli;

import java.util.Map;

import org.springframework.http.ResponseEntity;

/**
 * ProblemSolver-luokka käsittelee tehtävän ratkaisun ja päivittää pelaajan
 * pisteet.
 */

public class ProblemSolver {
  private PlayerManager playerManager;
  private int highScore;

  /**
   * Konstruktori luo uuden ProblemSolver-olion ja asettaa sille PlayerManagerin.
   * Alustaa myös ennätyksen arvon nollaksi.
   * 
   * @param playerManager PlayerManager-olio, joka hallinnoi pelaajia.
   */

  public ProblemSolver(PlayerManager playerManager) {
    this.playerManager = playerManager;
    this.highScore = 0;
  }

  /**
   * Ratkaisee tehtävän ja päivittää pelaajan pisteet.
   * 
   * @param requestBody HTTP-pyynnön sisältämät tiedot JSON-muodossa.
   * @return Vastaus pyyntöön sisältäen viestin siitä, onko vastaus oikein vai
   *         väärin.
   */

  public ResponseEntity<String> solveProblem(Map<String, Object> requestBody) {
    String accountName = (String) requestBody.get("accountName");
    String mathProblem = (String) requestBody.get("mathProblem");
    int userSolution = (int) requestBody.get("userSolution");

    String[] components = mathProblem.split(" ");
    if (components.length != 3) {
      return ResponseEntity.badRequest().body("Invalid format for the calculation.");
    }

    int number1 = Integer.parseInt(components[0]);
    int number2 = Integer.parseInt(components[2]);
    char operator = components[1].charAt(0);

    int correctAnswer = Math.calculateAnswer(number1, number2, operator);
    if (correctAnswer == userSolution) {
      Player player = playerManager.getPlayers().get(accountName);
      if (player != null) {
        int points = player.getPoints();
        points += calculatePoints(points, operator);
        player.setPoints(points);
        highScore = calculateHighScore(points);
        return ResponseEntity.ok("Wonderful!");
      } else {
        return ResponseEntity.badRequest().body("Player not found.");
      }
    } else {
      return ResponseEntity.ok("Wrong answer, better luck next time!");
    }
  }

  /**
   * Laskee tehtävän ratkaisusta saatavat pisteet.
   * 
   * @param currentPoints Pelaajan nykyinen pistemäärä.
   * @param operator      Tehtävän laskutoimituksen operaattori.
   * @return Laskutoimituksesta saatavat pisteet.
   */

  private int calculatePoints(int currentPoints, char operator) {
    if (operator == '+' || operator == '-') {
      return 1;
    } else if (operator == '*' || operator == '/') {
      return 2;
    }
    return 0;
  }

  /**
   * Laskee ja päivittää ennätyksen.
   * 
   * @param points Pelaajan pistemäärä.
   * @return Päivitetty ennätys.
   */

  private int calculateHighScore(int points) {
    if (points > highScore) {
      return points;
    }
    return highScore;
  }

  /**
   * Palauttaa nykyisen ennätyksen.
   * 
   * @return Nykyinen ennätys.
   */

  public int getHighScore() {
    return highScore;
  }
}
