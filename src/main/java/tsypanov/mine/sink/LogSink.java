package tsypanov.mine.sink;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * Always returns empty string
 */
public class LogSink implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return "";
    }
}
