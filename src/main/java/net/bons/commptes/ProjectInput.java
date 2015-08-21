package net.bons.commptes;

/*
 * Licence Public Barmic
 * copyright 2014 Michel Barret <michel.barret@gmail.com>
 */

import lombok.Data;
import lombok.NonNull;

@Data
public class ProjectInput {
    @NonNull
    private String name;
    @NonNull
    private String author;
    @NonNull
    private String description;
    @NonNull
    private String email;
}