package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private List<Integer> winning = new ArrayList<>();
    private int bonus;

    public List<Integer> getWinning() {
        return Collections.unmodifiableList(winning);
    }

    public int getBonus() {
        return bonus;
    }

    public void setWinning(String number) {
        List<Integer> resultNumbers = new ArrayList<>();
        List<String> numbers = Arrays.stream(number.split(",")).collect(Collectors.toList());
        numbers.stream().forEach(num -> resultNumbers.add(Integer.parseInt(num)));

        winning = resultNumbers;
    }

    public void setBonus(String number) {
        int resultNumber = Integer.parseInt(number);
        bonus = resultNumber;
    }
}
