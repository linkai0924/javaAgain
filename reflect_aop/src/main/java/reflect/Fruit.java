package reflect;

//用反射机制实现工厂模式：
interface fruit {
    public abstract void eat();
}

class Orange implements fruit {
    public void eat() {
        System.out.println("Orange");
    }
}

class Factory {
    public static fruit getInstance(String ClassName) {
        fruit f = null;
        try {
            f = (fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

class hello {
    public static void main(String[] a) {
        fruit f = Factory.getInstance("reflect.Orange");
        if (f != null) {
            f.eat();
        }
    }
}
