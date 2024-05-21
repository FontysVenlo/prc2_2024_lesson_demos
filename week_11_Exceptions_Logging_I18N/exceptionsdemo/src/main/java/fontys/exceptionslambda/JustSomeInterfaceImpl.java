package fontys.exceptionslambda;

import java.io.IOException;

/**
 *
 * @author hvd
 */
public class JustSomeInterfaceImpl implements JustSomeInterface {

    @Override
    public void doSomething() throws IOException{ //throws Exception{  --> This is not allowed... Since super type of IOException in interface
        throw new IOException("bla");
        
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //throw new IOException("ksahgdkas");
    }


    
}
