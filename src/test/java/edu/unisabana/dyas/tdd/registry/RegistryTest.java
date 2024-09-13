package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void shouldReturnValidWhenPersonIsEligible() {
        Person person = new Person("Leo", 12345678, 30, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldReturnDeadWhenPersonIsNotAlive() {
        Person person = new Person("Miguel", 12345679, 26, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void shouldReturnUnderageWhenPersonIsUnder18() {
        Person person = new Person("Ana", 12345680, 16, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void shouldReturnInvalidAgeWhenPersonHasNegativeAge() {
        Person person = new Person("Leopoldo", 12345681, -5, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void shouldReturnDuplicatedWhenPersonIsAlreadyRegistered() {
        Person person = new Person("Olga", 12345682, 30, Gender.FEMALE, true);
        registry.registerVoter(person); 
        RegisterResult result = registry.registerVoter(person); 
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void shouldReturnValidWhenPersonIsExactly18YearsOld() {
        Person person = new Person("Lucia", 12345683, 18, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldReturnValidWhenPersonGenderIsUnidentified() {
        Person person = new Person("Indigo", 12345684, 20, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldReturnValidWhenPersonIdIsAtMinBoundary() {
        Person person = new Person("Frankie", Integer.MIN_VALUE, 22, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldReturnValidWhenPersonIdIsAtMaxBoundary() {
        Person person = new Person("Silvana", Integer.MAX_VALUE, 22, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
}
