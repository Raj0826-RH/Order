package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Customer_id")
	private String customer_id;
	private String productCode;
	private Integer quality;
	private Double amount;
	private String status;
	private String createdBy;
	private String updatedBy;
	private Timestamp createdAt;
	private Timestamp  updatedAt;
	  public OrderEntity() {
	    }

	    public OrderEntity(Long id, String customer_id, String productCode,
	                       Integer quality, Double amount, String status,
	                       String createdBy, String updatedBy,
	                       Timestamp createdAt, Timestamp updatedAt) {

	        this.id = id;
	        this.customer_id = customer_id;
	       this. productCode = productCode;
	        this.quality = quality;
	        this.amount = amount;
	       this. status = status;
	        this.createdBy = createdBy;
	        this.updatedBy = updatedBy;
	        this.createdAt = createdAt;
	        this.updatedAt = updatedAt;
	    }
	
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getProductCode() {
	    return productCode;
	}

	public void setProductCode(String productCode) {
	    this.productCode = productCode;
	}
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	

	
	
}
