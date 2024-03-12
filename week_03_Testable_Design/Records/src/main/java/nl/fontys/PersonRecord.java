package nl.fontys;

/**
 *
 * @author hvd
 */
public record PersonRecord(String firstName, String lastName) {
    
    
    // PersonRecord can be used perfectly without wither method below.
    // Records are immutable. Wither methods "fake" mutability by simply
    // creating a new record instance with an updated value, keeping
    // other values the same. The wither method below "updates" the last name
    // while keeping the firstName as-is.
    public PersonRecord withLastName(String lastName){
        return new PersonRecord(this.firstName, lastName);
    }

}
