package lotto.utility;

public class RetryLogic {

    private static final int MAX_RETRY_COUNT = 5;

    public static void retry(Retry retry) {
        for (int i = 1; i <= MAX_RETRY_COUNT; i++) {
            try {
                retry.run();
            }catch (IllegalArgumentException e) {
                if (i == MAX_RETRY_COUNT) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
