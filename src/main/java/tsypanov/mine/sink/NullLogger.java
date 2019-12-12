package tsypanov.mine.sink;

import com.p6spy.engine.spy.appender.StdoutLogger;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Writes to {@code java.io.PrintStream.nullOutputStream()} i.e. into nowhere
 */
public class NullLogger extends StdoutLogger {

    private final OutputStream outputStream = PrintStream.nullOutputStream();
    private final PrintStream printStream = new PrintStream(outputStream);

    @Override
    protected PrintStream getStream() {
        return printStream;
    }
}
