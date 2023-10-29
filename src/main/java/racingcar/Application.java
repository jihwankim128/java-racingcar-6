package racingcar;

import java.io.Console;
import java.util.List;
import racingcar.controller.RacingCupController;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        List<String> carNames = gameView.getCarNames();

        RacingCupController racingCupController = new RacingCupController(gameView.getTotalRounds());

    }
}
