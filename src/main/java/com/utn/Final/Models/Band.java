package com.utn.Final.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "el campo name es obligatorio")
    private String name;

    @NotNull(message = "el campo name es obligatorio")
    private String genre;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "band_id")
    private List<Person> personList;


}
