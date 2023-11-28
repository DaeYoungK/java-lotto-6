package lotto.domain;

public enum ErrorMessage {

    COMMON_ERROR("유효한 데이터가 아닙니다. 다시 입력해 주세요."),
    SIZE_ERROR("로또 번호는 6개여야 합니다."),
    DISTINCT_ERROR("당첨 번호와 중복되면 안됩니다.")
    ;

    private static final String ERROR = "[ERROR]";
    private static final String BLANK = " ";
    private String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public static void getMessage(ErrorMessage errorMessage) {
        System.out.println(ERROR + BLANK + errorMessage.description);
    }

}
