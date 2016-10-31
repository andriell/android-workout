package com.hfad.workout;

/**
 * Created by Rybalko on 31.10.2016.
 */

public class Workout {
    private String name;
    private String description;

    public static final Workout[] WORKOUTS = {
        new Workout("Название 1", "Какое-то очень и очень длинное описание 1\n Потом еще что-то \n и еще что-то"),
        new Workout("Название 2", "Какое-то очень и очень длинное описание 2\n Потом еще что-то \n и еще что-то"),
        new Workout("Название 3", "Какое-то очень и очень длинное описание 3\n Потом еще что-то \n и еще что-то"),
        new Workout("Название 4", "Какое-то очень и очень длинное описание 4\n Потом еще что-то \n и еще что-то"),
    };

    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}
