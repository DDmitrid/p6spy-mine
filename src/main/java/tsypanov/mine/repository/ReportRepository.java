package tsypanov.mine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsypanov.mine.entity.ReportEntity;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
