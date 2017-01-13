package logic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="groups")

@NamedQueries({
	@NamedQuery(name="GroupBeen.findByGroupId", query="Select g From GroupBeen g WHERE g.group_id=:groupId"),
	@NamedQuery(name="GroupBeen.findByGroupName", query="Select g From GroupBeen g WHERE g.groupName=:groupName"),
	@NamedQuery(name="GroupBeen.findByGroupCurator", query="Select g From GroupBeen g WHERE g.curator=:curator"),
	@NamedQuery(name="GroupBeen.findBySpeciality", query="Select g From GroupBeen g WHERE g.speciality=:speciality")
})

public class GroupBeen implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="group_id", nullable=false)
	private int group_id;
	@Column(name="groupName", nullable=false)
	private String groupName;
	@Column(name="curator", nullable=false)
	private String curator;
	@Column(name="speciality", nullable=false)
	private String speciality;
	
	public GroupBeen(){
		
	}
	
	public GroupBeen(int group_id, String groupName, String curator, String speciality){
		this.group_id = group_id;
		this.groupName = groupName;
		this.curator = curator;
		this.speciality = speciality;
	}
	
	public int getGroupId() {
		return group_id;
	}
	public void setGroupId(int group_id) {
		this.group_id = group_id;
	}
	public String getNameGroup() {
		return groupName;
	}
	public void setNameGroup(String groupName) {
		this.groupName = groupName;
	}
	public String getCurator() {
		return curator;
	}
	public void setCurator(String curator) {
		this.curator = curator;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	

}
