

package io.github.fontysvenlo.reflection.demo;

import java.lang.reflect.*;

/**
 *
 * @author bonajo
 */
public class ReflectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        // Instance
        var student = new Student("Jane Doe");
        Class<?> janeType = student.getClass();
        System.out.println(janeType);

        // Class
        Class<?> classType = Student.class;
        System.out.println(classType);

        // String
        String className = "io.github.fontysvenlo.reflection.demo.Student";
        Class<?> stringType = Class.forName(className);
        System.out.println(stringType);

        Constructor<?>[] constructors = stringType.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        var constructor = constructors[0];
        Object instance = constructor.newInstance();
        System.out.println(instance);

        var defaultConstructor = classType.getConstructor();

        var paramConstructor = classType.getConstructor(String.class);
        var instance2 = paramConstructor.newInstance("Jane Doe2");
        System.out.println(instance2);

        Method getName = classType.getMethod("getName");
        System.out.println(getName.invoke(instance));
        System.out.println(getName.invoke(instance2));

        Method sayHello = classType.getMethod("sayHello");
        sayHello.invoke(null);

        var sayHelloParam = classType.getMethod("sayHello", String.class);
        sayHelloParam.invoke(instance, "Jane Test");

        Field nameField = classType.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println(nameField.get(instance));

        for(Field field : classType.getDeclaredFields()) {
            if(field.isAnnotationPresent(Hidden.class)){
                Hidden hidden = field.getAnnotation(Hidden.class);
                System.out.println(hidden.value());
            }
        }

    }

}
