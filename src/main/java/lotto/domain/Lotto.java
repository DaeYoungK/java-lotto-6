package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            getMessage(SIZE_ERROR);
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)) {
            getMessage(DISTINCT_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList()).size() != 6;
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
