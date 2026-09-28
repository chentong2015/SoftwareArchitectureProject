package master;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import master.api.Car;
import master.api.Driver;

import java.util.HashMap;
import java.util.Map;

public class DemoDubboSPI {

    public static void main(String[] args) {
        // testsDubboSpiIoc();
        System.out.println("test");
    }

    private static void testDubboSpiAop() {
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        // 从配置实现类型中获取指定名称的类型
        Car car = extensionLoader.getExtension("black");
        car.getColor(null);
    }

    private static void testsDubboSpiIoc() {
        ExtensionLoader<Driver> extensionLoader = ExtensionLoader.getExtensionLoader(Driver.class);
        Driver driver = extensionLoader.getExtension("trucker");
        // 配置URL总线: 通过url找到(要注入的)具体实现类型(名称)
        Map<String, String> map = new HashMap<>();
        map.put("carType", "black");
        URL url = new URL("", "", 8000, map);
        driver.driveCar(url);
    }
}
