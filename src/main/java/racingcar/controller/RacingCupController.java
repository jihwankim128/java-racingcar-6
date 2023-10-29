package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Player;
import racingcar.model.RacingCup;

public class RacingCupController {
    private RacingCup racingCup;
    private PlayerController playerController;

    public RacingCupController(int totalRounds, PlayerController playerController) {
        this.racingCup = new RacingCup(totalRounds);
        this.playerController = playerController;
    }

    public void addPlayers(List<Player> playerList) {
        this.racingCup.setPlayerList(playerList);
    }

    public boolean nextRound() {
        int round = this.racingCup.getRound();
        if (round < this.racingCup.getFINAL_ROUND()) {
            this.racingCup.setRound(round + 1);
            return true;
        }
        return false;
    }

    public RacingCup getRacingCup() {
        return racingCup;
    }

    public int playerSize() {
        return racingCup.getPlayerList().size();
    }

    public void updateFisrtPlayerDistance(int distance) {
        this.racingCup.setFirst(distance);
    }

    public int getFisrtPlayerDistance() {
        return racingCup.getFirst();
    }

    public void gamePlay() {
        for (int i = 0; i < playerSize(); i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                playerController.forward(i);
                int distanceOfPlayer = playerController.getDistacne(i);
                if(racingCup.getFirst() < distanceOfPlayer) {
                    updateFisrtPlayerDistance(distanceOfPlayer);
                }
            }
        }
    }

    public void decideFinalWinner() {
        List<Player> playerList = racingCup.getPlayerList();
        List<String> winners = new ArrayList<>();
        for(int i = 0; i < playerList.size(); i++) {
            if(getFisrtPlayerDistance() == playerController.getDistacne(i)) {
                winners.add(playerList.get(i).getCarName());
            }
        }
        this.racingCup.setWinners(winners);
    }
}
