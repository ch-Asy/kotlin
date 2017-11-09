package com.cn.kotlin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;


/**
 * Created by anliyuan on 2017/9/23.
 */

public class RxjavaOperator {

    public static void main(String[] args) {
        Student student;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            student = new Student(i % 2 == 0 ? "小红" + i : "小明" + i, i % 2 == 0 ? "女" : "男");
            students.add(student);
        }

        elementAtStudent(students);

    }

    /**
     * filter Rxjava 过滤操作符 返回boolean类型值  true:表示符合条件，是我们需要的数据返回，
     * false：表示不符合条件，是我们不需要的数据不返回。
     *
     * @param students
     */
    public static void FilterStudent(List<Student> students) {
        Observable.fromIterable(students)
                .filter(new Predicate<Student>() {
                    @Override
                    public boolean test(@NonNull Student student) throws Exception {
                        return  student.getSex().equals("女");
                    }
                })
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        System.out.println(student.toString());
                    }
                });
    }

    /**
     * take  Rxjava 过滤操作符 没有返回值  与takeLast 相似
     * <p>
     * count 发射 长度为count个对象  一个参数的比较常用，多个参数的比较少用
     * time  unit  发射 多长时间 内生成的对象  time 时间长度 unit 时间单位  时分秒等
     *
     * @param students
     */
    public static void TakeStudent(List<Student> students) {
        Observable.fromIterable(students)
                .take(1, TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        System.out.println(student.toString());
                    }
                });
    }


    /**
     * 复制
     * <p>
     * count 复制的次数
     * schedulers 调度器 复制数据在什么情况中
     */
    public static void RepeatStudent(List<Student> students) {
        Observable.fromIterable(students)
                .repeat(2)
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        System.out.println(student.toString());
                    }
                });
    }

    /**
     * 去重
     * <p>
     * keySelect 条件  不添加时默认为一个对象 添加时自己决定去重条件
     */
    public static void DistinctStudent(List<Student> students) {
        Observable.fromIterable(students)
                .distinct(new Function<Student, String>() {
                    @Override
                    public String apply(@NonNull Student student) throws Exception {
                        return student.getName();
                    }
                })
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        System.out.println(student.toString());
                    }
                });
    }

    /**
     * 获取第一个符合条件的对象
     *
     * predicate 方法 -->  条件
     */
    public static void FirstStudent(List<Student> students) {
        Observable.fromIterable(students)
                .first(new Student("小明0","男"))
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        System.out.println(student.toString());

                    }
                });
    }

    /**
     * 阻止（删除）前几个对象    与 skipList相反
     *
     * count 长度
     */
    public static void SkipStudent(List<Student> students) {
        Observable.fromIterable(students)
                .skip(2)
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws Exception {
                        System.out.println(student.toString());
                    }
                });
    }

    /**
     * 返回指定位置的对象
     *
     * index 角标
     */
    public static void elementAtStudent(List<Student> students){
            Observable.fromIterable(students)
                    .elementAt(9)
                    .subscribe(new Consumer<Student>() {
                        @Override
                        public void accept(Student student){
                            System.out.printf(student.toString());
                        }
                    });
    }

    public static void debounceStudent(List<Student> students) {
        Observable.fromIterable(students)
                .debounce(1,TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Student>() {
                    @Override
                    public void accept(Student student) throws  Exception {
                        System.out.printf(student.toString());
                    }
                });
    }
}

