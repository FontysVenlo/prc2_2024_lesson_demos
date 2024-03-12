/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mockingdemo;

/**
 *
 * @author hvd
 */
@FunctionalInterface
public interface EmailService {

    void sendEmail(String to, String message);
    
}
