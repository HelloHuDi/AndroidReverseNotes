package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager {
    private static Map<String, String> ACW = new HashMap();
    private static final int[] ACX = new int[]{10, 3};
    private static final int[] ACY = new int[]{10, 3};
    private static final int[] ACZ = new int[]{10, 3};
    private static final int[] ADa = new int[]{10, 3};
    private static final int[] ADb = new int[]{0, 0};
    private static final int[] ADc = new int[]{0, 0};
    private static final int[] ADd = new int[]{0, 0};
    private static final int[] ADe = new int[]{0, 0};

    /* renamed from: y */
    public static String m9323y(String str, int i, boolean z) {
        String str2 = (String) ACW.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3;
        int[] iArr;
        int[] iArr2;
        int i2;
        int[] iArr3;
        switch (i) {
            case 1:
                str3 = ActivityStubs.ADh;
                iArr3 = ADc;
                iArr = ACY;
                iArr2 = iArr3;
                break;
            case 2:
                str3 = ActivityStubs.ADi;
                iArr3 = ADd;
                iArr = ACZ;
                iArr2 = iArr3;
                break;
            case 3:
                str3 = ActivityStubs.ADj;
                iArr3 = ADe;
                iArr = ADa;
                iArr2 = iArr3;
                break;
            default:
                str3 = ActivityStubs.ADg;
                iArr3 = ADb;
                iArr = ACX;
                iArr2 = iArr3;
                break;
        }
        if (z) {
            str3 = str3 + "_T";
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i3 = iArr2[i2];
        iArr2[i2] = i3 + 1;
        if (i3 >= iArr[i2]) {
            iArr2[i2] = 0;
            i2 = 0;
        } else {
            i2 = i3;
        }
        str2 = String.format(str3, new Object[]{Integer.valueOf(i2)});
        ACW.put(str, str2);
        return str2;
    }

    private ActivityStubManager() {
        throw new UnsupportedOperationException();
    }
}
