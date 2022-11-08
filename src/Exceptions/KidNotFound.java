package Exceptions;

public class KidNotFound extends Exception {
    public KidNotFound() {
        super("Kid not found exception! The searched kid was not found in the register file.");
    }
}
