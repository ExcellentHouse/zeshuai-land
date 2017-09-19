package com.yyzstudy.zeshuailand.model.po;


import javax.persistence.*;

@Entity(name = "House")
@Table(name = "house")
public class House {

    @Id
    private String id;

    @Column(name = "area")
    private Double area;

    @Column(name = "room")
    private Integer room;

    @Column(name = "hall")
    private Integer hall;

    @Column(name = "washroom")
    private Integer washroom;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "hasElevator")
    private String hasElevator;

    @Column(name = "detailedAddress")
    private String detailedAddress;

    @Column(name = "builtYear")
    private Integer builtYear;

    @Column(name = "remark")
    private String remark;

    @Column(name = "path")
    private String path;

    @Column(name = "type")
    private String type;

    @Column(name = "checkStatus")
    private Integer checkStatus;

    @Column(name = "review")
    private String review;

    @Column(name = "isSold")
    private Integer isSold;

    @OneToOne
    @JoinColumn(name = "people_id")
    private People people;

    @OneToOne
    @JoinColumn(name = "community_id")
    private Community community;

    public House() {
    }

    public House(String id, Double area, Integer room, Integer hall, Integer washroom, Integer floor, String hasElevator, String detailedAddress, Integer builtYear, String remark, String path, String type, Integer checkStatus, String review, Integer isSold, People people, Community community) {
        this.id = id;
        this.area = area;
        this.room = room;
        this.hall = hall;
        this.washroom = washroom;
        this.floor = floor;
        this.hasElevator = hasElevator;
        this.detailedAddress = detailedAddress;
        this.builtYear = builtYear;
        this.remark = remark;
        this.path = path;
        this.type = type;
        this.checkStatus = checkStatus;
        this.review = review;
        this.isSold = isSold;
        this.people = people;
        this.community = community;
    }

    @Override
    public String toString() {
        return "House{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", room=" + room +
                ", hall=" + hall +
                ", washroom=" + washroom +
                ", floor=" + floor +
                ", hasElevator='" + hasElevator + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", builtYear=" + builtYear +
                ", remark='" + remark + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", checkStatus=" + checkStatus +
                ", review='" + review + '\'' +
                ", isSold=" + isSold +
                ", people=" + people +
                ", community=" + community +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Integer getHall() {
        return hall;
    }

    public void setHall(Integer hall) {
        this.hall = hall;
    }

    public Integer getWashroom() {
        return washroom;
    }

    public void setWashroom(Integer washroom) {
        this.washroom = washroom;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(String hasElevator) {
        this.hasElevator = hasElevator;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Integer getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(Integer builtYear) {
        this.builtYear = builtYear;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getIsSold() {
        return isSold;
    }

    public void setIsSold(Integer isSold) {
        this.isSold = isSold;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}

