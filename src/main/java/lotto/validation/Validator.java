package lotto.validation;

import lotto.domain.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.ErrorMessage.*;

public class Validator {

    private static final String BLANK = " ";
    private static final String NON_BLANK = "";
    private static final int STANDARD_PRICE = 1_000;

    public int validPrice(String price) {
        String removeBlank = getRemoveBlank(price);
        int resultPrice = checkType(removeBlank);
        checkPrice(resultPrice);

        return resultPrice;
    }

    public String validWinning(String winning) {
        String removeBlank = getRemoveBlank(winning);
        List<String> numbers = Arrays.stream(removeBlank.split(",")).collect(Collectors.toList());
        checkCount(numbers);
        numbers.forEach(number -> checkValid(number));
        return removeBlank;
    }

    private void checkCount(List<String> numbers) {
        if (numbers.size() != 6) {
            getMessage(SIZE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    public int validBonus(String bonus, List<Integer> winningNumbers) {
        String removeBlank = getRemoveBlank(bonus);
        int resultBonus = checkType(removeBlank);
        checkNumber(bonus, winningNumbers);

        return resultBonus;
    }

    private void checkNumber(String bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            getMessage(DISTINCT_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkDistinct(List<String> numbers) {
        List<String> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != distinctNumbers.size()) {
            getMessage(SIZE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkValid(String number) {
        int resultNumber = checkType(number);
        checkSize(resultNumber);
    }

    private void checkSize(int resultNumber) {
        if (!isLottoRange(resultNumber)) {
            getMessage(LOTTO_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private boolean isLottoRange(int resultNumber) {
        return resultNumber >= 1 && resultNumber <= 45;
    }

    public int validBonus(String bonus) {
        String removeBlank = getRemoveBlank(bonus);
        int resultPrice = checkType(removeBlank);

        return resultPrice;
    }

    private void checkPrice(int resultPrice) {
        if (resultPrice % STANDARD_PRICE != 0) {
            getMessage(COMMON_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private String getRemoveBlank(String input) {
        return input.replaceAll(BLANK, NON_BLANK);
    }

    private int checkType(String price) {
        int resultPrice;
        try {
            resultPrice = Integer.parseInt(price);
        }catch (NumberFormatException e) {
            getMessage(COMMON_ERROR);
            throw new IllegalArgumentException(e);
        }

        return resultPrice;
    }
}
