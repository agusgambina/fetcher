package app.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="positions")
public @Data
@NoArgsConstructor
@AllArgsConstructor
class Position {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private int id;
  @GeneratedValue
  @CreationTimestamp
  private LocalDateTime creationDate;
  @GeneratedValue
  @UpdateTimestamp
  private LocalDateTime lastModificationDate;
  private String status = "open";
  private String externalId;
  private String name;
  private String currentCompany;
  private String type;
  private String location;

}
