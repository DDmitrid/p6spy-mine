package tsypanov.mine;

import com.p6spy.engine.spy.P6DataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import tsypanov.mine.entity.ReportEntity;
import tsypanov.mine.repository.ReportRepository;

import javax.sql.DataSource;

@EnableAutoConfiguration
@EntityScan(basePackageClasses = ReportEntity.class)
@EnableJpaRepositories(basePackageClasses = ReportRepository.class)
public class ReportExampleConfig {

  @Bean
  public DataSource dataSource() {
    EmbeddedDatabase origin = new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .build();
    return new P6DataSource(origin);
  }

}
