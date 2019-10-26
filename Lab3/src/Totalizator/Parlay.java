package Totalizator;

public class Parlay {

    private String horse;
    private int sum;

    public Parlay(String horse, int sum) {
        this.horse = horse;
        this.sum   = sum;
    }

    public String getHorse() {
        return this.horse;
    }

    public int getSum() {
        return this.sum;
    }

    @Override
    public String toString() {
        return this.horse + ", " + this.sum;
    }
}
