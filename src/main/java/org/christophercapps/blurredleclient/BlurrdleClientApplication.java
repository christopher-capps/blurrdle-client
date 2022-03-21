package org.christophercapps.blurredleclient;

import org.christophercapps.blurredleclient.model.GuessTracker;
import org.christophercapps.blurredleclient.services.ConsoleService;
import org.christophercapps.blurredleclient.services.GuessTrackerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




public class BlurrdleClientApplication {

	public static void main(String[] args) {

		ConsoleService consoleService = new ConsoleService();
		GuessTrackerService trackerService = new GuessTrackerService();
		GuessTracker tracker = trackerService.getNew();


		consoleService.printHeader();
		consoleService.printNewGameInfo(tracker);
		String guess = "";


		while (tracker.isCorrect() == false) {
			guess = consoleService.promptForGuess("What is your guess?", tracker);
			tracker = trackerService.makeGuess(guess, tracker);
			if (tracker.isCorrect()) {
				consoleService.printWinBanner(tracker);
			} else {
				System.out.println(tracker);
			}
		}


	}

}
