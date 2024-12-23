package com.film.demofilm.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<K extends Serializable> {
	public abstract K getId();

	@CreatedBy
	@Column(columnDefinition = "bigint default 1", updatable = false)
	private Integer createdBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedBy
	@Column(columnDefinition = "bigint default 1")
	private Integer lastModifiedBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	private boolean deleted;

	public BaseEntity() {
	}

	public BaseEntity(Integer createdBy, LocalDateTime createdDate, Integer lastModifiedBy, LocalDateTime lastModifiedDate,
			boolean deleted) {
		this.createdBy = createdBy;
		this.createdAt = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.updatedAt = lastModifiedDate;
		this.setDeleted(deleted);
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdDate) {
		this.createdAt = createdDate;
	}

	public Integer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Integer lastmodified) {
		this.lastModifiedBy = lastmodified;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime createdDate) {
		this.updatedAt = createdDate;
	}
	
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String toString() {
		return "BaseEntity[createdBy = " + createdBy + ",createdAt = " + createdAt + ",lastModifiedBy = "
				+ lastModifiedBy + ",updatedAt = " + updatedAt + ",deleted = " + deleted + "]";
	}

}
