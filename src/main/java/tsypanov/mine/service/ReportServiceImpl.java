package tsypanov.mine.service;

import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tsypanov.mine.entity.ReportEntity;
import tsypanov.mine.repository.ReportRepository;

@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    @Transactional
    public ReportEntity save(ReportEntity entity) {
        return reportRepository.save(entity);
    }
}
