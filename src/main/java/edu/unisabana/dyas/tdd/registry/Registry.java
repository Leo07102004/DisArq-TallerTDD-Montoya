package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry {

    private Set<Integer> registeredVoters = new HashSet<>();

    public RegisterResult registerVoter(Person person) {
        if (!person.isAlive()) {
            return RegisterResult.DEAD;
        }
        
        if (person.getAge() < 0) {
            return RegisterResult.INVALID_AGE;
        }

        if (person.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }

        if (registeredVoters.contains(person.getId())) {
            return RegisterResult.DUPLICATED;
        }

        registeredVoters.add(person.getId());
        return RegisterResult.VALID;
    }
}
