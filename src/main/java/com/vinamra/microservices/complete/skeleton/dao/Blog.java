package com.vinamra.microservices.complete.skeleton.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Topic topic;

    @OneToMany(mappedBy = "blog")
    @JsonIgnore
    private List<Comment> comment;

}
