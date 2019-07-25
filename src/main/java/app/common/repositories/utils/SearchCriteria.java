package app.common.repositories.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

public @Data
@AllArgsConstructor
class SearchCriteria {
  private String key;
  private String operation;
  private Object value;
}