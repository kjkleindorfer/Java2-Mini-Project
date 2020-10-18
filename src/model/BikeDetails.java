package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bike_details")
public class BikeDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="USER_ID")
	private User user;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
			(
					name="bikes_on_list",
					joinColumns={@JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") },
					inverseJoinColumns= {@JoinColumn(name="BIKE_ID",referencedColumnName="ID", unique=true) }
			)
	private List<ListBike> listOfBikes;
	
	public BikeDetails () {
		super();
	}
	public BikeDetails(int id, String listName, User user, List<ListBike> listOfBikes) {
		this.id = id;
		this.listName = listName;
		this.user = user;
		this.listOfBikes = listOfBikes;
	}
	public BikeDetails(String listName, User user, List<ListBike> listOfBikes) {
		this.listName = listName;
		this.user = user;
		this.listOfBikes = listOfBikes;
	}
	public BikeDetails(String listName, User user) {
		this.listName = listName;
		this.user = user;
	}
	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", user=" + user
				+ ", listOfBikes=" + listOfBikes + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}

	public User getUser() {
		return user;
	}
	public void setShopper(User user) {
		this.user = user;
	}
	public List<ListBike> getListOfBikes() {
		return listOfBikes;
	}
	public void setListOfItems(List<ListBike> listOfBikes) {
		this.listOfBikes = listOfBikes;
	}
}