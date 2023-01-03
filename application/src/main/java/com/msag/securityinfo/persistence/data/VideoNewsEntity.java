package com.msag.securityinfo.persistence.data;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_video_news")
public class VideoNewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_id")
    private int sourceId;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subTitle;

    @Column(name = "video_url")
    private String videoURL;

    @Column(name = "release_date")
    private Instant releaseDate;

    @Column(name = "description")
    private String description;
}
