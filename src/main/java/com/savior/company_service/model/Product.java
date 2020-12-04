package com.savior.company_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.savior.company_service.constants.Constants;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Constants.PRODUCT_TABLE)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@SQLDelete(sql = "UPDATE " + Constants.PRODUCT_TABLE + " SET deleted_at = now() WHERE id = ?")
@Where(clause = "deleted_at IS NULL")
public class Product {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", updatable = false, nullable = false, length = 36)
  private String id;

  @ManyToOne
  @JoinColumn(name="company_id", nullable=false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Company company;

  private String name;

  public Product() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
