package io.fedcuit.github.java8.domain;

import java.util.List;

import static java.lang.String.format;

public class Artist {
    private final String name;
    private final String nationality;
    private final List<Artist> members;

    public Artist(String name, String nationality, List<Artist> members) {
        this.name = name;
        this.nationality = nationality;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public List<Artist> getMembers() {
        return members;
    }

    public String getNationality() {
        return nationality;
    }

    public String basicInfo() {
        return format("%s %s", getName(), getNationality());
    }
}
