package com.example.springbootstoreprocedure.model;


import javax.persistence.*;

@Entity
@Table(name="Post")
public class Post{
    @Column(name="Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;
    @Column(name="Title")
    public String Title;
    @Column(name="Body")
    public String Body;

    public Long getId(){
        return Id;
    }
    public void setId(Long _Id) {
        this.Id = _Id;
    }
    public String getTitle(){
        return Title;
    }
    public void setTitle(String _Title) {
        this.Title = _Title;
    }
    public String getBody(){
        return Body;
    }
    public void setBody(String _Body) {
        this.Body = _Body;
    }
}
