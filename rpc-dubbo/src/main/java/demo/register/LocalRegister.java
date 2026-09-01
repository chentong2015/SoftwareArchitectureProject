package demo.register;

import java.util.HashMap;
import java.util.Map;

// �ڷ���˱��ص�ע��
public class LocalRegister {

    private static Map<String, Class> map = new HashMap<>();

    public static void register(String interfaceName, Class classImpl) {
        map.put(interfaceName, classImpl);
    }

    public static Class get(String interfaceName) {
        return map.get(interfaceName);
    }
}
