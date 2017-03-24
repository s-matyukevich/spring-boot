package com.github.s_matyukevich.spring_boot.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
  @Table(name = "stock_item")
  public class StockItem {

      @Id
      @GeneratedValue
      @Column(name = "id", nullable = false, unique = true)
      private Long id;

      @Enumerated(EnumType.STRING)
      private ItemType type;

      @Column(name = "title", nullable = false, length = 45)
      private String title;

      @Column(name = "description", length = 1000)
      private String description;

      public StockItem() {
      }

      public StockItem(Long id, ItemType type, String title, String description) {
          this.id = id;
          this.type = type;
          this.title = title;
          this.description = description;
      }

      public Long getId() {
          return id;
      }

      public ItemType getType() {
          return type;
      }

      public String getTitle() {
          return title;
      }

      public String getDescription() {
          return description;
      }
  }

