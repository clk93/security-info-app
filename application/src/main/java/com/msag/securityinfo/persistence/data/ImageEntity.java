package com.msag.securityinfo.persistence.data;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageURL;
}
