package tsypanov.mine.benchmark;

import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(SaveBenchmark.class.getSimpleName())
                .warmupIterations(10)
                .warmupTime(TimeValue.seconds(1))
                .measurementIterations(10)
                .measurementTime(TimeValue.seconds(2))
                .forks(10) //0 makes debugging possible
                .shouldFailOnError(true)
//				.shouldDoGC(false)
                .addProfiler(GCProfiler.class) // memory and GC profiler
//              .verbosity(VerboseMode.SILENT)
                .build();
        new Runner(opt).run();
    }
}