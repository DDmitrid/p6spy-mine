package tsypanov.mine.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
public class ReportEntity {

  @Id
  @GeneratedValue
  private long id;

  @Lob
  private byte[] reportContent;

  public ReportEntity(byte[] reportContent) {
    this.reportContent = reportContent;
  }
}
