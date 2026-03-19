package com.portfolio.helpdesk.entity;

import jakarta.persistence.*;

@Entity // Dit à Spring : "Ceci est une table de base de données"
public class Ticket {

    @Id // Dit à Spring : "Ceci est la Clé Primaire (Primary Key)"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Equivalent de l'AUTO_INCREMENT en SQL
    private Long id;

    private String title;
    private String description;
    private String status; // Par exemple : "OUVERT", "EN_COURS", "FERMÉ"

    // Constructeur vide obligatoire pour que Spring Boot fonctionne
    public Ticket() {
    }

    // --- GETTERS ET SETTERS ---
    // En Java, les attributs sont "private". Pour les lire ou les modifier,
    // on doit créer des méthodes publiques (Getters et Setters).

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}