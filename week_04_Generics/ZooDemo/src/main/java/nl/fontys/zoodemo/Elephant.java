
package nl.fontys.zoodemo;

/**
 *
 * @author hvd
 */
public class Elephant implements Animal<Elephant>{
    
    public Elephant eat(){
        System.out.println("I'm an eating Elephant");
        return this;
    }
    
    public Elephant drink(){
        System.out.println("I'm a drinking Elephant");
        return this;
    }

//    @Override
//    public Object move() {
//        System.out.println("I am moving");
//        return this;
//    }

    @Override
    public Elephant move() {
        System.out.println("I am moving");
        return this;
    }
//
//    @Override
//    public String move() {
//        return "Hi";
//    }


    
}
