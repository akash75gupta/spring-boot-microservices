package io.akash.practice.microservices.moviecatalogservice.dto;

import java.util.List;

import io.akash.practice.microservices.moviecatalogservice.model.CatalogItemModel;

public class CatalogResponseDto {
  private List<CatalogItemModel> catalog;

  /**
   * @return the catalog
   */
  public List<CatalogItemModel> getCatalog() {
	  return catalog;
  }

  /**
   * @param catalog the catalog to set
   */
  public void setCatalog(List<CatalogItemModel> catalog) {
	  this.catalog = catalog;
  }
}
