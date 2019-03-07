package com.danielqueiroz.workout.model;

public class Workout {

    private String name;
    private String description;

    public static final Workout[] workouts = {
      new Workout("Agachamneto", "Pés alinhados, 40 cm de distancia um do outro"),
      new Workout("Flexões", "Braços alinhados ao peito, movimentos sequenciais"),
      new Workout("Poli-Chinelo", "Pulos e movimento dos bracos alinhados")
    };

    public Workout(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
