package domain;

import util.LottoRank;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinLotto {

    private final List<Lotto> lotteries;
    private final Lotto winnerNumber;
    private final int bonusNumber;
    private final Map<LottoRank, Integer> result;

    public WinLotto(List<Lotto> lotteries, Lotto winnerNumber, int bonusNumber) {
        this.lotteries = lotteries;
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
        this.result = setResult();
    }

    private Map<LottoRank, Integer> setResult() {
        Map<LottoRank, Integer> numberOfRank = new EnumMap<>(LottoRank.class);
        final int DEFAULT_ZERO = 0;
        final int ONE = 1;

        lotteries.stream().forEach(lotto -> {
            LottoRank rank =
                    LottoRank.getRank(lotto, lotto.numberOfSameNumbers(winnerNumber.getNumbers()), bonusNumber);

            Integer numRank = numberOfRank.getOrDefault(rank, DEFAULT_ZERO);
            numberOfRank.put(rank, numRank + ONE);
        });

        return numberOfRank;
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

}
