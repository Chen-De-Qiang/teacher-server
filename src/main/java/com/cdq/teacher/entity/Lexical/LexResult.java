package com.cdq.teacher.entity.Lexical;

/**
 * @ClassName LexResult
 * @Description TODO
 * @Author chendeqiang
 * @Date 2020/5/16 17:31
 * @Version 1.0
 */
public class LexResult {
    private final String line;
    private final String symbol;
    private final String TAG;
    private final String detail;

    public LexResult() {
        this(null, null, null, null);
    }

    public LexResult(String line, String symbol, String TAG, String detail) {
        this.line = line;
        this.symbol = symbol;
        this.TAG = TAG;
        this.detail = detail;
    }

    public String getLine() {
        return line;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getTAG() {
        return TAG;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "LexResult{" +
                "line=" + line +
                ", symbol=" + symbol +
                ", TAG=" + TAG +
                ", detail=" + detail +
                '}';
    }
}
