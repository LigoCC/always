### Java值传递和引用传递

在Java中，参数传递分为值传递和引用传递。

1. ###### 值传递：

对于基本数据类型（如int、float、boolean等），方法传递的是实际值的副本。在方法内部对参数进行修改不会影响原始值。例如：

```
public class Example {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Before modification: " + num); // 输出: Before modification: 10
        modifyValue(num);
        System.out.println("After modification: " + num); // 输出: After modification: 10
    }

    public static void modifyValue(int value) {
        value = 20;
    }
}
```

在上面的示例中， modifyValue 方法接收一个int类型的参数，并将其修改为20。然而，原始的 num 值并没有被修改，因为方法只是修改了参数的副本。



2. ###### 引用传递：

对于对象类型，方法传递的是对象的引用的副本。在方法内部对参数进行修改会影响原始对象的状态。例如：

```
import java.util.HashMap;
import java.util.Map;

public class Example {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        System.out.println("Before modification: " + map); // 输出: Before modification: {a=1, b=2}
        modifyMap(map);
        System.out.println("After modification: " + map); // 输出: After modification: {a=10, b=20}
    }

    public static void modifyMap(Map<String, Integer> map) {
        map.put("a", 10);
        map.put("b", 20);
    }
}
}
```

在上面的示例中， modifyMap 方法接收一个 Map<String, Integer> 类型的参数，并修改了其中的键值对。由于方法传递的是Map对象的引用的副本，所以对参数进行的修改会影响原始的Map对象。 

需要注意的是，虽然引用传递可以修改对象的状态，但无法修改对象的引用本身。如果在方法内部对引用进行重新赋值，不会影响原始引用。