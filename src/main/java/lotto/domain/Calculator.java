package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Statistic.*;

public class Calculator {

    private static final int PLUS_COUNT = 1;
    private static final int PERCENTAGE = 100;

    private Map<Statistic, Integer> result = new HashMap<>(){{
       put(THREE, 0);
       put(FOUR, 0);
       put(FIVE, 0);
       put(FIVE_BONUS, 0);
       put(SIX, 0);
    }};

    public Map<Statistic, Integer> collectLotto(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Integer> winning = winningNumber.getWinning();
        int count;
        for (Lotto lotto : lottos) {
            count = collectCount(lotto.getNumbers(), winning);
            checkCount(lotto.getNumbers(), winningNumber.getBonus(), count);
        }
        return result;
    }

    public double rateOfReturn(int price) {
        double sum = result.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .mapToDouble(entry -> winnings(entry.getValue(), entry.getKey().getWinnings())).sum();

        return sum/price*PERCENTAGE;
    }

    private double winnings(int count, int winnings) {
        return count * winnings;
    }

    private void checkCount(List<Integer> numbers, int bonus, int count) {
        Statistic statistic = getStatistic(count);
        if (statistic == FOUR && isContainBonus(numbers, bonus)) {
            result.put(FIVE_BONUS, result.get(FIVE_BONUS) + PLUS_COUNT);
            return;
        }
        if (statistic != NON) {
            result.put(statistic, result.get(statistic) + PLUS_COUNT);
        }
    }

    private boolean isContainBonus(List<Integer> numbers, int bonus) {
        return numbers.contains(bonus);
    }

    private int collectCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream().filter(number -> winningNumbers.contains(number)).count();
    }
}
