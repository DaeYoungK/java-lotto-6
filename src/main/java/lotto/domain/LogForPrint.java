package lotto.domain;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.domain.Statistic.*;

public class LogForPrint {

    private static final String NEXT_LINE = "\n";
    private static final String ROUND_STANDARD = "%.1f";
    private static final String STATISTIC_BASIC = "%d개 일치 (%s원) - %d개";
    private static final String STATISTIC_BONUS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_OF_RETURN = "총 수익률은 %s%%입니다.";
    private static final String STANDARD_REGEX = "###,###";
    private StringBuilder sb;

    public String purchaseLotto(List<Lotto> lottos) {
        sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getNumbers() + NEXT_LINE);
        }
        return sb.toString();
    }

    public String resultStatistic(Map<Statistic, Integer> result) {
        sb = new StringBuilder();
        result.forEach((k,v) -> makeStatistic(k,v,sb));
        return sb.toString();
    }

    public String rateOfReturn(double rateOfReturn) {
        sb = new StringBuilder();
        String format = String.format(ROUND_STANDARD, rateOfReturn);

        sb.append(String.format(RATE_OF_RETURN, format));
        return sb.toString();
    }

    private void makeStatistic(Statistic statistic,int collectCount, StringBuilder sb) {
        int count = statistic.getCount();
        int winnings = statistic.getWinnings();
        String resultWinnings = makeNumberRegex(winnings);
        if (statistic.equals(FIVE_BONUS)) {
            sb.append(String.format(STATISTIC_BONUS, count, resultWinnings, collectCount) + NEXT_LINE);
            return;
        }
        sb.append(String.format(STATISTIC_BASIC, count, resultWinnings, collectCount) + NEXT_LINE);
    }

    private String makeNumberRegex(int winnings) {
        DecimalFormat decimalFormat = new DecimalFormat(STANDARD_REGEX);

        return decimalFormat.format(winnings);
    }
}
