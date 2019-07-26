package app.github.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
public
@Data
@NoArgsConstructor
@AllArgsConstructor
class PositionDTO {
  private String id;
  private String type;
  private String url;
  private String createdAt;
  private String company;
  private String companyUrl;
  private String location;
  private String title;
  private String description;
  private String howToApply;
  private String companyLogo;
}
