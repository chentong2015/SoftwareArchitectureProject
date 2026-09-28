package custom.framework.factory;

import custom.framework.protocol.DubboProtocol;
import custom.framework.protocol.HttpProtocol;
import custom.framework.protocol.Protocol;

// 使用JVM标准参数(-DprotocolName="xxx")来配置使用那种协议
// 1. 只需要唯一修改来切换
// 2. 如果新添加协议，则需要修改工厂类
public class ProtocolFactory {

    public static Protocol getProtocol() {
        String protocolName = System.getProperty("protocolName");
        if (protocolName == null || protocolName.equals("") || protocolName.equals("http")) {
            return new HttpProtocol();
        }
        return new DubboProtocol();
    }
}
