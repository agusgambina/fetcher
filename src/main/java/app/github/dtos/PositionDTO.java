package app.github.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data
class PositionDTO {
  private String id;
  private String type;
  private String url;
  private LocalDateTime createdAt;
  private String company;
  private String companyUrl;
  private String location;
  private String title;
  private String description;
  private String howToApply;
  private String companyLogo;
}
