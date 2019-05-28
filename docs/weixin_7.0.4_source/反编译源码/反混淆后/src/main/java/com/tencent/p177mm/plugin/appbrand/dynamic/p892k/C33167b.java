package com.tencent.p177mm.plugin.appbrand.dynamic.p892k;

import android.support.p057v4.widget.C8415j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.k.b */
public final class C33167b {
    /* renamed from: cX */
    public static int m54217cX(int i, int i2) {
        if (i == 0) {
            switch (i2) {
                case 1:
                    return Downloads.MIN_WAIT_FOR_NETWORK;
                case 2:
                    return 10001;
                default:
                    return 10002;
            }
        } else if (i != 1) {
            return C8415j.INVALID_ID;
        } else {
            switch (i2) {
                case 1:
                    return 10100;
                case 2:
                    return 10101;
                default:
                    return 10102;
            }
        }
    }

    /* renamed from: nO */
    public static int m54218nO(int i) {
        switch (i) {
            case Downloads.MIN_WAIT_FOR_NETWORK /*10000*/:
            case 10100:
                return 1;
            case 10001:
            case 10101:
                return 2;
            default:
                return 0;
        }
    }
}
