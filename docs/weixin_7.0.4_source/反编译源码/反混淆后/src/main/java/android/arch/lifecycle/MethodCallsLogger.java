package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Map;

public class MethodCallsLogger {
    /* renamed from: cL */
    private Map<String, Integer> f30cL = new HashMap();

    public boolean approveCall(String str, int i) {
        int intValue;
        boolean z;
        Integer num = (Integer) this.f30cL.get(str);
        if (num != null) {
            intValue = num.intValue();
        } else {
            intValue = 0;
        }
        if ((intValue & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f30cL.put(str, Integer.valueOf(intValue | i));
        if (z) {
            return false;
        }
        return true;
    }
}
