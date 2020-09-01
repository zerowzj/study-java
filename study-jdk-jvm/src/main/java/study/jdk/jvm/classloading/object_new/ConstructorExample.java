package study.jdk.jvm.classloading.object_new;

public class ConstructorExample {

    private int i;

    ConstructorExample() {
        super();
//        this(1);
    }

    ConstructorExample(int i) {
        this.i = i;
    }
}
