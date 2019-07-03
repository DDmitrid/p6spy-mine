package tsypanov.mine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import tsypanov.mine.entity.ReportEntity;
import tsypanov.mine.repository.ReportRepository;

import java.io.InputStream;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.io.IOUtils.toByteArray;

@Commit
@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ReportExampleConfig.class)
class ReportRepositoryTest {

  @Autowired
  private ReportRepository reportRepository;

  @Test
  void test() throws Exception {
    try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("random-file.txt")) {
      byte[] reportContent = toByteArray(requireNonNull(resourceAsStream));
      ReportEntity reportEntity = new ReportEntity(reportContent);
      reportRepository.save(reportEntity);
    }
  }

}
