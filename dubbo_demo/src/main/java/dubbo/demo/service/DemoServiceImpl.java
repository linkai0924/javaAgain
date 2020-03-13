package dubbo.demo.service;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
