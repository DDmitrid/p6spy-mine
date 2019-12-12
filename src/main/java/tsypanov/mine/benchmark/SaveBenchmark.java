package tsypanov.mine.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import tsypanov.mine.ReportExampleConfig;
import tsypanov.mine.entity.ReportEntity;
import tsypanov.mine.service.ReportService;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(jvmArgsAppend = {"-Xms4g", "-Xmx4g", "-XX:+UseParallelGC", "-XX:+HeapDumpOnOutOfMemoryError"})
public class SaveBenchmark {

    @Benchmark
    public ReportEntity save(Data data) {
        return data.service.save(new ReportEntity(data.array));
    }

    @State(Scope.Thread)
    public static class Data {
        private byte[] array;

        protected ConfigurableApplicationContext context;
        private ReportService service;

        @Setup
        public void setup() {
            this.context = SpringApplication.run(ReportExampleConfig.class);
            service = this.context.getBean(ReportService.class);

            array = new byte[1024 * 1024];
            ThreadLocalRandom.current().nextBytes(array);
        }

        @TearDown
        public void tearDown() {
            context.close();
        }
    }
}
