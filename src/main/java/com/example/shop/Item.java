package com.example.shop;

import jakarta.persistence.*;

@Entity
public class Item  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(columnDefinition = "TEXT")
    public String title;
    public Integer price;
}
