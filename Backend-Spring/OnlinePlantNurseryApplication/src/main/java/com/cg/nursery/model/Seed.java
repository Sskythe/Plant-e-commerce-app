package com.cg.nursery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="seed_tbl")
public class Seed {
	@Id
	@GeneratedValue(generator="seed_seq",strategy=GenerationType.SEQUENCE)
	@ SequenceGenerator(name="seed_sql", sequenceName="seed_id_seq",allocationSize=1)
	  Integer seedId;
	@Column(length=30)
	  String commonName;
	@Column(length=30)
	  String bloomTime;
	@Column(length=20)
	  String watering;
	@Column(length=10)
	  String difficultyLevel;
	@Column(length=20)
	  String temperature;
	@Column(length=20)
	  String typeOfSeeds;
	@Column(length=40)
	  String seedsDescription;
	@Column
	  Integer seedsStock;
	@Column
	  Double seedsCost;
	@Column
	  Integer seedsPerPacket;
	
	public Seed() {
		super();
	}

	public Integer getSeedId() {
		return seedId;
	}

	public void setSeedId(Integer seedId) {
		this.seedId = seedId;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getWatering() {
		return watering;
	}

	public void setWatering(String watering) {
		this.watering = watering;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getTypeOfSeeds() {
		return typeOfSeeds;
	}

	public void setTypeOfSeeds(String typeOfSeeds) {
		this.typeOfSeeds = typeOfSeeds;
	}

	public String getSeedsDescription() {
		return seedsDescription;
	}

	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}

	public Integer getSeedsStock() {
		return seedsStock;
	}

	public void setSeedsStock(Integer seedsStock) {
		this.seedsStock = seedsStock;
	}

	public Double getSeedsCost() {
		return seedsCost;
	}

	public void setSeedsCost(Double seedsCost) {
		this.seedsCost = seedsCost;
	}

	public Integer getSeedsPerPacket() {
		return seedsPerPacket;
	}

	public void setSeedsPerPacket(Integer seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}

	public Seed(Integer seedId, String commonName, String bloomTime, String watering, String difficultyLevel,
			String temperature, String typeOfSeeds, String seedsDescription, Integer seedsStock, Double seedsCost,
			Integer seedsPerPacket) {
		super();
		this.seedId = seedId;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.watering = watering;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfSeeds = typeOfSeeds;
		this.seedsDescription = seedsDescription;
		this.seedsStock = seedsStock;
		this.seedsCost = seedsCost;
		this.seedsPerPacket = seedsPerPacket;
	}

	@Override
	public String toString() {
		return "Seed [seedId=" + seedId + ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", watering="
				+ watering + ", difficultyLevel=" + difficultyLevel + ", temperature=" + temperature + ", typeOfSeeds="
				+ typeOfSeeds + ", seedsDescription=" + seedsDescription + ", seedsStock=" + seedsStock + ", seedsCost="
				+ seedsCost + ", seedsPerPacket=" + seedsPerPacket + "]";
	}

	
	
	
	
	
	
	
	

}
