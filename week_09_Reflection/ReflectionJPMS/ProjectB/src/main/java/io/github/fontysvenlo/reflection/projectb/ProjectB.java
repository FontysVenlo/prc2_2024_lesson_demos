

package io.github.fontysvenlo.reflection.projectb;

import io.github.fontysvenlo.reflection.projecta.exported.Exported;
import io.github.fontysvenlo.reflection.projecta.full.Full;

import java.lang.reflect.Constructor;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fontys
 */
public class ProjectB {

    public static void main(String[] args) {
        String[] classes = {
            "io.github.fontysvenlo.reflection.projecta.encapsulated.Encapsulated",
            "io.github.fontysvenlo.reflection.projecta.exported.Exported",
            "io.github.fontysvenlo.reflection.projecta.opens.Opens",
            "io.github.fontysvenlo.reflection.projecta.full.Full",
        };

        for(var clazz : classes) {
            executeMethods(clazz);
        }
    }

    private static void executeMethods(String className){
        System.out.println("Using reflection to load class: " + className);
        try {
            Class<?>  clazz = Class.forName(className);
            // Find all methods in test class
            Method[] declaredMethods = clazz.getDeclaredMethods();

            // Create instance of test class
            Constructor<?> constructor = clazz.getConstructor();
            Object instance = constructor.newInstance();

            for (Method testMethod : declaredMethods) {
                try {
                    System.out.println("Using reflection to invoke method: " + testMethod);
                    // Try setting method accessible
                    testMethod.setAccessible(true);
                    // Invoke test method on that instance
                    testMethod.invoke(instance);
                }catch(InaccessibleObjectException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (ClassNotFoundException |
                InvocationTargetException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException e
        ) {
            System.out.println(e.getMessage());
        }
        System.out.println("-".repeat(30));
    }
}
