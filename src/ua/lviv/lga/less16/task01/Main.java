package ua.lviv.lga.less16.task01;

import ua.lviv.lga.less16.exampl.Person;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class pc = Book.class;

        /*name of class*/
        String nameOfClass = pc.getName();
        System.out.println("Name of class = " + nameOfClass);

        String simplName = pc.getSimpleName();
        System.out.println("Simple name  " + simplName);

        /*get Modifier*/
        int modifier = pc.getModifiers();
        String modifierText = Modifier.toString(modifier);
        System.out.println("Class modifier" + modifierText + " int =" + modifier);
        System.out.println(" is static " + Modifier.isStatic(modifier));
        System.out.println(" is public " + Modifier.isPublic(modifier));
        System.out.println(" is abstract " + Modifier.isAbstract(modifier));
        System.out.println(" is interface" + Modifier.isInterface(modifier));
        System.out.println();

        /*get Package*/
        Package classPackege = pc.getPackage();
        System.out.println("Packege of current class  " + classPackege);
        System.out.println();

        /* get superClass*/
        Class superClass = pc.getSuperclass();
        System.out.println("superclass = " + superClass);
        System.out.println();

        /*get interface*/
        Class[] interfaces = pc.getInterfaces();
        System.out.println("Interface = " + Arrays.toString(interfaces));
        System.out.println();

        /*constructors*/
        Constructor<Book>[] bookConstruktor = pc.getConstructors();
        System.out.println("Constructor size =" + bookConstruktor.length);

        for (int i = 0; i < bookConstruktor.length; i++) {
            Constructor<Book> constructor = bookConstruktor[i];
            System.out.println("Constructor of Book :  " + constructor);
        }
        /*Parameter*/
        System.out.println("Get parameter");
        Constructor<Book> constructor = bookConstruktor[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        System.out.println("Size of variables  " + parameterTypes.length);

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> tp = parameterTypes[i];
            System.out.println("Type variables  " + tp);
        }

        /*Constructor &  parameter*/
        Constructor<Book> singlConstructor = pc.getConstructor(String.class, int.class);
        System.out.println("single constructor " + singlConstructor);

        Book newInstance = singlConstructor.newInstance("Book01", 1999);
        System.out.println("replacement book = " + newInstance);
        System.out.println();

        /*get Fields*/
        Field[] fields = pc.getFields();
        System.out.println("size of Field arr:" + fields.length);

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println(field);

        }
        System.out.println();
        fields = pc.getDeclaredFields();
        System.out.println("size of Field (+private) :" + fields.length);
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println(field);
        }
        System.out.println();

        /*set field*/
        System.out.println("The new value for the year field");
        Field ageField = pc.getField("year");
        ageField.set(newInstance, 2019);
        System.out.println("Book has new year: " + newInstance);

        System.out.println("The new value for the isbn field");
        Field privatIsbn = fields[3];
        privatIsbn.setAccessible(true);
        privatIsbn.set(newInstance, 323334232);
        System.out.println("privat value isbn = " + privatIsbn.get(newInstance));
        System.out.println();

        /*Method*/
        System.out.println("Methods:");
        Method[] methods = pc.getMethods();
        System.out.println("Num of  Methods:" + methods.length);
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            System.out.println(method);
        }

        Method[] declaredMethod = pc.getDeclaredMethods();
        System.out.println("Num of declared Methods:" + declaredMethod.length);
        for (int i = 0; i < declaredMethod.length; i++) {
            Method dcMethod = declaredMethod[i];
            System.out.println("Declared Methods:" + dcMethod);
        }

        Method myMethod = pc.getMethod("setAutor", String.class);
        myMethod.invoke(newInstance, "Autor");
        System.out.println("New Autor is: " + newInstance);

        System.out.println();
        myMethod = pc.getMethod("orderBook", String.class, int.class);
        myMethod.invoke(newInstance, "loveBook ", 2233223);


        Method myAddMethod = pc.getMethod("addNumberCopies", int.class);
        myAddMethod.invoke(newInstance, 15);
        System.out.println();

    }
}
