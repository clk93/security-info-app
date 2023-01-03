package com.msag.securityinfo.persistence.data;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "t_general_news")
public class GeneralNewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category")
    private String category;

    @Column(name = "subheader")
    private String subheader;

    @Column(name = "images")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "t_image",
    joinColumns = @JoinColumn(name="fk_image_id"))
    private List<ImageEntity> images = new ArrayList<>();

    @Column(name = "header")
    private String header;

    @Column(name = "content")
    private String content;

    @Column(name = "pubDate")
    private Instant pubDate;
}
