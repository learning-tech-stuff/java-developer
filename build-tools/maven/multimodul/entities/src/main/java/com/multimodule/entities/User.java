package com.multimodule.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 */
@Getter
@Setter
@Builder
@Entity
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}