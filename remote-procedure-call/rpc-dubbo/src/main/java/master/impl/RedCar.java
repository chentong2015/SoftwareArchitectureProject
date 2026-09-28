package master.impl;

import com.alibaba.dubbo.common.URL;
import master.api.Car;

public class RedCar implements Car {

    @Override
    public void getColor(URL url) {
        System.out.println("Red Car");
    }
}
