package com.msg.msg.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training_session")
public class TrainingSession {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtraining_session")
	private int id;

	@JoinColumn(name = "fk_client_id", referencedColumnName = "iduser")
	@ManyToOne(optional = false)
	private User client;

	@JoinColumn(name = "fk_trainer_id", referencedColumnName = "iduser")
	@ManyToOne
	private User trainer;

	@JoinColumn(name = "fk_area_id", referencedColumnName = "idarea")
	@ManyToOne
	private Area area;

	@JoinColumn(name = "fk_training_type", referencedColumnName = "idtraining_type")
	@ManyToOne
	private TrainingType trainingType;

	@Column(name = "scheduled_for")
	private Date date;
	
	@Column(name = "comments")
	private String comments;

	public TrainingSession() {
	}

	public TrainingSession(int id, User client, User trainer, Area area, TrainingType trainingType, Date date, String comments) {
		this.id = id;
		this.client = client;
		this.trainer = trainer;
		this.area = area;
		this.trainingType = trainingType;
		this.date = date;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public User getTrainer() {
		return trainer;
	}

	public void setTrainer(User trainer) {
		this.trainer = trainer;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public TrainingType getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(TrainingType trainingType) {
		this.trainingType = trainingType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TrainingSession [id=" + id + ", client=" + client + ", trainer=" + trainer + ", area=" + area
				+ ", trainingType=" + trainingType + ", date=" + date + ", comments=" + comments + "]";
	}

	

}
