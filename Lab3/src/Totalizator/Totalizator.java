package Totalizator;

import Users.User;
import Users.UsersBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Totalizator {

    private UsersBase usersBase;
    private ParlaysBase parlaysBase;
    private HorseBase horseBase;
    private Map<User, Double> winners;
    private int winHorseId;

    public Totalizator() {
        this.usersBase = new UsersBase();
        this.parlaysBase = new ParlaysBase();
        this.horseBase = new HorseBase();

        this.winners = new HashMap<User, Double>();
        this.winHorseId = 0;
    }

    public UsersBase getUsersBase() {
        return this.usersBase;
    }

    public ParlaysBase getParlaysBase() {
        return this.parlaysBase;
    }

    public HorseBase getHorseBase() {
        return this.horseBase;
    }

    public void clearParlays() {
        this.parlaysBase.clearParlays();
    }

    public Horse getWinHorse() {
        return this.horseBase.getHorseById(this.winHorseId+1);
    }

    public Map<User, Double> getWinners() {
        return this.winners;
    }

    public void generateResults() {
        Random rand = new Random();
        this.winHorseId = rand.nextInt(this.horseBase.getCountHorses());
    }

    public void calculateMoney() {
        Random rand = new Random();

        for (User user : this.usersBase.getUsers()) {
            for (Parlay parlay : this.parlaysBase.getParlaysByUser(user.getLogin())) {
                if (parlay.getHorse().equals(this.horseBase.getHorseById(this.winHorseId+1).getName())) {
                    this.winners.put(user, parlay.getSum() * (rand.nextDouble() + 1));
                }
            }
        }
    }

}