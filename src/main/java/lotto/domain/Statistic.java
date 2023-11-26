package lotto.domain;

public enum Statistic {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000),
    NON(0, 0)
    ;

    private final int count;
    private final int winnings;

    Statistic(int count, int winnings) {
        this.count = count;
        this.winnings = winnings;
    }
}
