package master.impl;

import com.alibaba.dubbo.common.URL;
import master.api.Car;

public class BlackCar implements Car {

    @Override
    public void getColor(URL url) {
        System.out.println("Black Car");
    }
}
