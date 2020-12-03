package com.savior.company_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.savior.company_service.constants.Constants;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = Constants.COMPANY_TABLE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@SQLDelete(sql = "UPDATE " + Constants.COMPANY_TABLE + " SET deleted_at = now() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Company {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false, length = 36)
  private String id;

  private String name;

  private String website;

  @CreationTimestamp
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
  private Date createdAt;

  @UpdateTimestamp
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
  private Date updatedAt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.DATE_TIME_FORMAT)
  private Date deletedAt;

  public Company() {}

  public Company(@JsonProperty("id") String id, @JsonProperty("name") String name, @JsonProperty("website") String website) {
    this.id = id;
    this.name = name;
    this.website = website;
    this.createdAt = new Date();
    this.updatedAt = this.createdAt;
    this.deletedAt = null;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }
}
