package io.github.fontysvenlo.fontystest.fontystest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author fontys
 */
public class TestExecutor {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String packageName = "io.github.fontysvenlo.calculator";

        // Find all classes in the package that contain the String "FontysTest"
        Set<Class<?>> testClasses = findAllTestClassesUsingClassLoader(packageName);
        
        if (testClasses.isEmpty()) {
            System.out.println("No test classes found! Class name should contain FontysTest");
            return;
        } else {
            System.out.println( testClasses );
        }

        for (Class<?> testClass : testClasses) {

            // Find all methods in test class
            Method[] declaredMethods = testClass.getDeclaredMethods();

            // Filter the methods that are annotated with our FontysTest annotation
            List<Method> testMethods = Arrays.stream(declaredMethods)
                    .filter(method -> method.isAnnotationPresent(FontysTest.class))
                    .toList();

            if (testMethods.isEmpty()) {
                System.out.println("No test Methods found in test class " + testClass.getSimpleName());
                return;
            }

            // Create instance of test class
            Constructor<?> constructor = testClass.getConstructor();
            Object testClassInstance = constructor.newInstance();

            for (Method testMethod : testMethods) {
                    // Invoke test method on that instance
                    System.out.println("Test method: " + testMethod.getName());
                    testMethod.invoke(testClassInstance);
            }
        }
    }
    
    public static Set<Class<?>> findAllTestClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("\\.", "/"));

        if(stream == null){
            return new HashSet<>();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith("FontysTest.class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }
    
    private static Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // Wrap it in a RuntimeException, so we can use it in our map
            throw new RuntimeException(e);
        }
    }
}
