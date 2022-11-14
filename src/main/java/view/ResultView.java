package view;

import domain.Lotto;
import util.LottoMessage;
import util.LottoRank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static util.Constant.LINE_SEPARATOR;
import static util.Constant.SAMES_FORMAT;
import static util.Constant.OPEN_BRACKET;
import static util.Constant.CLOSE_BRACKET;
import static util.Constant.HYPHEN_WITH_SPACE;
import static util.Constant.KOREA_BASICS_UNIT;

public class ResultView {

    public static final DecimalFormat moneyFormat = new DecimalFormat("###,###");

    public ResultView() {}

    public void displayAllLotteries(List<Lotto> lotteries) {
        System.out.println(String.format(LottoMessage.NUMBER_RESULT, lotteries.size()));
        lotteries.iterator()
                .forEachRemaining(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void displayPercentageProfit(String percentageProfit) {
        System.out.println(percentageProfit);
    }

    public void displayWinStatistics() {
        System.out.println(LottoMessage.WIN_STATISTICS);
    }

    public void displaySeparator() {
        System.out.println(LINE_SEPARATOR);
    }

    public void displayWinners(Map<LottoRank, Integer> result) {
        LottoRank.getAscendRank()
                .forEach(rank -> {
                    int sameCount = rank.getSameCount();
                    String outputLine =
                            String.format(SAMES_FORMAT, sameCount) +
                                    OPEN_BRACKET +
                                    moneyFormat.format(rank.getPrizeMoney()) +
                                    CLOSE_BRACKET +
                                    HYPHEN_WITH_SPACE +
                                    result.getOrDefault(rank, 0) +
                                    KOREA_BASICS_UNIT;

                    System.out.println(outputLine);
                });
    }
}
