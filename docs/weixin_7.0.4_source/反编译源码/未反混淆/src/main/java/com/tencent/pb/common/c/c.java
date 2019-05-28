package com.tencent.pb.common.c;

import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.f;

public final class c {
    private static int ApT = 2;
    private static boolean ApU = false;
    public static int level = 0;

    public static void dPK() {
        ApT = 0;
        ApU = true;
    }

    public static void d(String str, Object... objArr) {
        if (ApU && ApT <= 1 && str != null) {
            N(1, str, " ".concat(String.valueOf(J(objArr))));
        }
    }

    public static void i(String str, Object... objArr) {
        if (ApU && ApT <= 2) {
            N(2, str, " ".concat(String.valueOf(J(objArr))));
        }
    }

    public static void w(String str, Object... objArr) {
        if (ApU && ApT <= 3 && str != null) {
            N(3, str, " ".concat(String.valueOf(J(objArr))));
        }
    }

    public static void e(String str, Object... objArr) {
        if (ApU && ApT <= 4) {
            N(4, str, " ".concat(String.valueOf(J(objArr))));
        }
    }

    private static String J(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(250);
        for (Object obj : objArr) {
            if (obj != null) {
                stringBuffer.append("|");
                if (obj instanceof Throwable) {
                    stringBuffer.append(((Throwable) obj).getMessage());
                } else {
                    stringBuffer.append(obj.toString());
                }
            }
        }
        return stringBuffer.toString();
    }

    private static void N(int i, String str, String str2) {
        e dTA = f.dTA();
        if (dTA != null) {
            dTA.y(i, "MTSDK".concat(String.valueOf(str)), str2);
        }
    }
}
