package lotto.view;

public class OutputView {

    private static final String PURCHASE_LOTTO = "%d개를 구매했습니다.";
    private static final String STATISTIC_MESSAGE = "당첨 통계\n---";

    public void printPurchaseLotto(int count, String history) {
        System.out.println(String.format(PURCHASE_LOTTO, count));
        System.out.println(history);
    }

    public void printStatistic(String statistic) {
        System.out.println(STATISTIC_MESSAGE);
        System.out.print(statistic);
    }

    public void printRateOfReturn(String rateOfReturn) {
        System.out.println(rateOfReturn);
    }

}
