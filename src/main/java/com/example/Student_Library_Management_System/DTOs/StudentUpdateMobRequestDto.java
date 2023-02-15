package com.example.Student_Library_Management_System.DTOs;

public class StudentUpdateMobRequestDto {

    private int id;
    private String mobNo;

    //Dto depend on Api's being calls..add
    //attributes as required

    public StudentUpdateMobRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
