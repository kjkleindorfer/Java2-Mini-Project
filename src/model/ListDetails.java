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
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int listID;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne (cascade = CascadeType.PERSIST)
	@JoinColumn(name="user_Id")
	private ListUser user;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
			(
					name="user_bikes",
					joinColumns={@JoinColumn(name="user_Id", referencedColumnName="user_Id") },
					inverseJoinColumns= {@JoinColumn(name="bike_Id",referencedColumnName="bike_Id", unique=true) }
			)
	private List<ListBike> listOfBikes;
	
	public int getListID() {
		return listID;
	}
	public void setListID(int listID) {
		this.listID = listID;
	}
	public ListDetails () {
		super();
	}
	public ListDetails(int listID, String listName, ListUser user, List<ListBike> listOfBikes) {
		this.listID = listID;
		this.listName = listName;
		this.user = user;
		this.listOfBikes = listOfBikes;
	}
	public ListDetails(String listName, ListUser user, List<ListBike> listOfBikes) {
		this.listName = listName;
		this.user = user;
		this.listOfBikes = listOfBikes;
	}
	public ListDetails(String listName, ListUser user) {
		this.listName = listName;
		this.user = user;
	}
	@Override
	public String toString() {
		return "ListDetails [listID=" + listID + ", listName=" + listName + ", user=" + user
				+ ", listOfBikes=" + listOfBikes + "]";
	}
	public int getId() {
		return listID;
	}
	public void setId(int listID) {
		this.listID = listID;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}

	public ListUser getUser() {
		return user;
	}
	public void setUser(ListUser user) {
		this.user = user;
	}
	public List<ListBike> getListOfBikes() {
		return listOfBikes;
	}
	public void setListOfBikes(List<ListBike> listOfBikes) {
		this.listOfBikes = listOfBikes;
	}
}