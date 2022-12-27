package cn.bugstack.springframework.java8.second;

import cn.bugstack.springframework.java8.first.Employee;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Auther: 李清依
 * @Date: 2022/12/6 09:18
 * @Description:
 */
/*
 * 一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用
 * 			  （可以将方法引用理解为 Lambda 表达式的另外一种表现形式）
 *
 * 1. 对象的引用 :: 实例方法名
 *
 * 2. 类名 :: 静态方法名
 *
 * 3. 类名 :: 实例方法名
 *
 * 注意：
 * 	 1 方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 * 	 2 若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，格式： ClassName::MethodName
 *
 * 二、构造器引用 :构造器的参数列表，需要与函数式接口中参数列表保持一致！
 *
 * 1. 类名 :: new
 *
 * 三、数组引用
 *
 * 	类型[] :: new;
 *
 *
 */
public class TestMethodRef {

    @Test
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (str) -> ps.println(str);
        con.accept("Hello World！");

        System.out.println("--------------------------------");

        Consumer<String> con2 = ps::println;
        con2.accept("Hello Java8！");
        System.out.println("--------------------------------");
        Consumer<String> con3 = System.out::println;
        con3.accept("Hello Javala");

    }

    @Test
    //对象的引用 :: 实例方法名
    public void test2(){
        Employee emp = new Employee(101, "张三", 18, 9999.99);

        Supplier<String> sup = () -> emp.getName();
        System.out.println(sup.get());

        System.out.println("----------------------------------");

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    @Test
    public void test3(){
        BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
        System.out.println(fun.apply(1.5, 22.2));

        System.out.println("--------------------------------------------------");

        BiFunction<Double, Double, Double> fun2 = Math::max;
        System.out.println(fun2.apply(1.2, 1.5));
    }

}
