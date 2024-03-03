// Tee REST-palveluna jokin peli, jota voidaan ohjata REST-endpointeilla (esim. visailu). Huomatkaa, että tässä
// ei tehdä clienttia/UI:ta. Ainoastaan REST-endpointit, jolla peliä voi ohjata. Toiminnallisuutta voi
// ohjata/testata esim. Postman-ohjelmalla. Alla pisteytettävät osa-alueet ja vaatimukset. Pisteytykseen
// vaikuttaa yleinen laatu/haasteellisuus.

// Vaatimukset:
// • Juurimappaus näyttää info/-ohjetiedot.
// • Get-mappaukset 4p
//   o Parametreilla ja ilman
//   o Palautusarvot, string + JSON
// • POST-mappaus parametreilla. 4p
//   o Palautusarvot, string + JSON
// • Olioiden/luokkien hyödyntäminen ja tiedon talletus 2p
// • Pelilogiikka. 3p

// Työ palautetaan julkisena Github-linkkinä Moodleen.
// Kommentoi koodiin, mitä endpointit tekevät, eli mikä niiden tehtävä pelissä.

package com.restpalvelu.peli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeliApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeliApplication.class, args);
	}

}
