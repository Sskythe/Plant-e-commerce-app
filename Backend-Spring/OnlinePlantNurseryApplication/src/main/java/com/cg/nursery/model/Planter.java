package com.cg.nursery.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="planter_tbl")
public class Planter {
	@Id
	@GeneratedValue(generator="planter_seq",strategy=GenerationType.SEQUENCE)
	@ SequenceGenerator(name="planter_sql", sequenceName="planters_id_seq",allocationSize=1)
	Integer planterId;
	@Column
	float planterheight;
	@Column
	int planterCapacity;
	@Column
	int drinageHoles;
	@Column(length=20)
	String planterColor;
	@Column(length=30)
	String planterShape;
	@Column
	int planterStock;
	@Column
	int planterCost;
	
	@OneToMany(targetEntity=Plant.class,cascade=CascadeType.ALL)
	@JoinColumn(name="planter_id")
	private List<Plant> plants;
	
	@OneToMany(targetEntity=Seed.class,cascade=CascadeType.ALL)
	@JoinColumn(name="planter_id")
	private List<Seed> seeds;
	public Planter(Integer planterId, float planterheight, int planterCapacity, int drinageHoles, String planterColor,
			String planterShape, int planterStock, int planterCost) {
		super();
		this.planterId = planterId;
		this.planterheight = planterheight;
		this.planterCapacity = planterCapacity;
		this.drinageHoles = drinageHoles;
		this.planterColor = planterColor;
		this.planterShape = planterShape;
		this.planterStock = planterStock;
		this.planterCost = planterCost;
	}
	public Planter() {
		super();
	}
	public Integer getPlanterId() {
		return planterId;
	}
	public void setPlanterId(Integer planterId) {
		this.planterId = planterId;
	}
	public float getPlanterheight() {
		return planterheight;
	}
	public void setPlanterheight(float planterheight) {
		this.planterheight = planterheight;
	}
	public int getPlanterCapacity() {
		return planterCapacity;
	}
	public void setPlanterCapacity(int planterCapacity) {
		this.planterCapacity = planterCapacity;
	}
	public int getDrinageHoles() {
		return drinageHoles;
	}
	public void setDrinageHoles(int drinageHoles) {
		this.drinageHoles = drinageHoles;
	}
	public String getPlanterColor() {
		return planterColor;
	}
	public void setPlanterColor(String planterColor) {
		this.planterColor = planterColor;
	}
	public String getPlanterShape() {
		return planterShape;
	}
	public void setPlanterShape(String planterShape) {
		this.planterShape = planterShape;
	}
	public int getPlanterStock() {
		return planterStock;
	}
	public void setPlanterStock(int planterStock) {
		this.planterStock = planterStock;
	}
	public int getPlanterCost() {
		return planterCost;
	}
	public void setPlanterCost(int planterCost) {
		this.planterCost = planterCost;
	}
	
	public List<Seed> getSeeds() {
		return seeds;
	}
	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}
	public List<Plant> getPlants() {
		return plants;
	}
	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
	@Override
	public String toString() {
		return "Planter [planterId=" + planterId + ", planterheight=" + planterheight + ", planterCapacity="
				+ planterCapacity + ", drinageHoles=" + drinageHoles + ", planterColor=" + planterColor
				+ ", planterShape=" + planterShape + ", planterStock=" + planterStock + ", planterCost=" + planterCost
				+ ", plants=" + plants + ", seeds=" + seeds + "]";
	}
	
	
	
	
	
	
	

}
