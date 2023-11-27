package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Statistic.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatisticTest {

    @DisplayName("일치하는 로또 숫자 개수를 받아 enum 상수를 반환한다.")
    @Test
    void getStatisticTest() {
        int three = 3;
        int four = 4;
        int five = 5;
        int six = 6;

        Statistic statistic1 = getStatistic(three);
        Statistic statistic2 = getStatistic(four);
        Statistic statistic3 = getStatistic(five);
        Statistic statistic4 = getStatistic(six);

        assertThat(statistic1).isEqualTo(THREE);
        assertThat(statistic2).isEqualTo(FOUR);
        assertThat(statistic3).isEqualTo(FIVE);
        assertThat(statistic4).isEqualTo(SIX);
    }

}