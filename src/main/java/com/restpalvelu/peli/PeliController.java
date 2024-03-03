package com.restpalvelu.peli;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mathGame")
public class PeliController {

  private PlayerManager playerManager = new PlayerManager();
  private ProblemSolver problemSolver = new ProblemSolver(playerManager);

  // Juurimappaus, pelin tiedot ja ohjeet:
  @GetMapping("")
  public ResponseEntity<String> getGameInfo() {
    return ResponseEntity.ok("This is a math game! Your object is to collect points by solving math problems and break the high score!");
  }

  // POST-mappaus, uuden käyttäjän rekisteröinti:
  @PostMapping("/registration")
  public ResponseEntity<String> registration(@RequestBody Map<String, String> requestBody) {
    String accountName = requestBody.get("accountName");
    playerManager.registerPlayer(accountName);
    return ResponseEntity.ok("Your account name " + accountName + " is now registered!");
  }

  // GET-mappaus, palauttaa pelaajan pisteet:
  @GetMapping("/points")
  public ResponseEntity<Integer> getPoints(@RequestParam("accountName") String accountName) {
    Player player = playerManager.getPlayers().get(accountName);
    if (player != null) {
      return ResponseEntity.ok(player.getPoints());
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }

  // GET-mappaus, palauttaa korkeimman pistemäärän:
  @GetMapping("/highScore")
  public ResponseEntity<Integer> getHighScore() {
    return ResponseEntity.ok(problemSolver.getHighScore());
  }

  // POST-mappaus, käsittelee tehtävän ratkaisun ja päivittää pelaajan pisteet:
  @PostMapping("/solveProblem")
  public ResponseEntity<String> solveProblem(@RequestBody Map<String, Object> requestBody) {
    return problemSolver.solveProblem(requestBody);
  }
}