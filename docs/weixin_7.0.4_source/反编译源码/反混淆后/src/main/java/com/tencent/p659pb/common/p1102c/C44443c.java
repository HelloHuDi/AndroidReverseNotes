package com.tencent.p659pb.common.p1102c;

import com.tencent.p659pb.talkroom.sdk.C46731e;
import com.tencent.wecall.talkroom.model.C24507f;

/* renamed from: com.tencent.pb.common.c.c */
public final class C44443c {
    private static int ApT = 2;
    private static boolean ApU = false;
    public static int level = 0;

    public static void dPK() {
        ApT = 0;
        ApU = true;
    }

    /* renamed from: d */
    public static void m80389d(String str, Object... objArr) {
        if (ApU && ApT <= 1 && str != null) {
            C44443c.m80388N(1, str, " ".concat(String.valueOf(C44443c.m80387J(objArr))));
        }
    }

    /* renamed from: i */
    public static void m80391i(String str, Object... objArr) {
        if (ApU && ApT <= 2) {
            C44443c.m80388N(2, str, " ".concat(String.valueOf(C44443c.m80387J(objArr))));
        }
    }

    /* renamed from: w */
    public static void m80392w(String str, Object... objArr) {
        if (ApU && ApT <= 3 && str != null) {
            C44443c.m80388N(3, str, " ".concat(String.valueOf(C44443c.m80387J(objArr))));
        }
    }

    /* renamed from: e */
    public static void m80390e(String str, Object... objArr) {
        if (ApU && ApT <= 4) {
            C44443c.m80388N(4, str, " ".concat(String.valueOf(C44443c.m80387J(objArr))));
        }
    }

    /* renamed from: J */
    private static String m80387J(Object[] objArr) {
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

    /* renamed from: N */
    private static void m80388N(int i, String str, String str2) {
        C46731e dTA = C24507f.dTA();
        if (dTA != null) {
            dTA.mo46547y(i, "MTSDK".concat(String.valueOf(str)), str2);
        }
    }
}
