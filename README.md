# 🎫 Helpdesk System - Backend

API REST robuste développée avec Spring Boot pour la gestion de tickets de support.

## 🛠️ Stack Technique
- **Java 17** & **Spring Boot 3**
- **Spring Data JPA** (Persistance des données)
- **MySQL** (Base de données relationnelle)
- **Maven** (Gestionnaire de dépendances)

## 🤖 Méthodologie de développement
Ce projet a été réalisé en **Pair Programming avec une IA (Gemini)**.
Cela m'a permis de :
- Accélérer la mise en place de l'architecture Fullstack (Spring Boot / Vue.js).
- Appliquer les **Best Practices** industrielles (DTO, Clean Code, Gestion du CORS).
- Résoudre rapidement les problématiques d'intégration et de debug.

## ⚙️ Configuration
1. Créer une base de données nommée `helpdesk` dans MySQL.
2. Configurer le login/password dans `src/main/resources/application.properties`.
3. Lancer l'application : `./mvnw spring-boot:run`

## 📡 Endpoints principaux
- `GET /api/tickets` : Récupérer tous les tickets.
- `POST /api/tickets` : Créer un nouveau ticket.
- `PUT /api/tickets/{id}/status` : Mettre à jour le statut (JSON).
- `DELETE /api/tickets/{id}` : Supprimer un ticket.