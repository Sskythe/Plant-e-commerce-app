package com.cg.nursery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="plant_tbl")
public class Plant {
	@Id
	@GeneratedValue(generator="plant_seq",strategy=GenerationType.SEQUENCE)
	@ SequenceGenerator(name="plant_sql", sequenceName="plant_id_seq",allocationSize=1)
	private Integer plantId;
	@Column
	private Integer plantHeight;
	@Column(length=20)
	private String plantSpread;
	@Column(length=20)
	private String commonName;
	@Column(length=20)
	private String bloomTime;
	@Column(length=20)
	private String medicinalOrCulinaryUse;
	@Column(length=20)
	private String difficultyLevel;
	@Column(length=20)
	private String temperature;
	@Column(length=20)
	private String typeOfPlant;
	@Column(length=20)
	private String plantDescription;
	@Column
	private Integer plantsStock;
	@Column
	private double plantCost;
	
	public Plant() {
		super();
	}

	public Plant(Integer plantId, Integer plantHeight, String plantSpread, String commonName, String bloomTime,
			String medicinalOrCulinaryUse, String difficultyLevel, String temperature, String typeOfPlant,
			String plantDescription, Integer plantsStock, double plantCost) {
		super();
		this.plantId = plantId;
		this.plantHeight = plantHeight;
		this.plantSpread = plantSpread;
		this.commonName = commonName;
		this.bloomTime = bloomTime;
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
		this.difficultyLevel = difficultyLevel;
		this.temperature = temperature;
		this.typeOfPlant = typeOfPlant;
		this.plantDescription = plantDescription;
		this.plantsStock = plantsStock;
		this.plantCost = plantCost;
	}

	public Integer getPlantId() {
		return plantId;
	}

	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public Integer getPlantHeight() {
		return plantHeight;
	}

	public void setPlantHeight(Integer plantHeight) {
		this.plantHeight = plantHeight;
	}

	public String getPlantSpread() {
		return plantSpread;
	}

	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
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

	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}

	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
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

	public String getTypeOfPlant() {
		return typeOfPlant;
	}

	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public Integer getPlantsStock() {
		return plantsStock;
	}

	public void setPlantsStock(Integer plantsStock) {
		this.plantsStock = plantsStock;
	}

	public double getPlantCost() {
		return plantCost;
	}

	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}

	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantHeight=" + plantHeight + ", plantSpread=" + plantSpread
				+ ", commonName=" + commonName + ", bloomTime=" + bloomTime + ", medicinalOrCulinaryUse="
				+ medicinalOrCulinaryUse + ", difficultyLevel=" + difficultyLevel + ", temperature=" + temperature
				+ ", typeOfPlant=" + typeOfPlant + ", plantDescription=" + plantDescription + ", plantsStock="
				+ plantsStock + ", plantCost=" + plantCost + "]";
	}
	
	
	
	
	
	
	
	
	

}
