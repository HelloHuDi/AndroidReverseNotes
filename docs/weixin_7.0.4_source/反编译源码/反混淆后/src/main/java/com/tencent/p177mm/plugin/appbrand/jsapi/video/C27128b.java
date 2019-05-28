package com.tencent.p177mm.plugin.appbrand.jsapi.video;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.b */
public final class C27128b {
    /* renamed from: c */
    public static int m43113c(float f, float f2, int i, int i2) {
        int i3 = 180;
        float f3 = f / f2;
        if (i2 <= 180) {
            i3 = i2;
        } else if (i2 > 600) {
            i3 = i2 <= 1800 ? 300 : 600;
        }
        i3 = ((int) (((float) i3) * f3)) + i;
        if (i3 < 0) {
            return 0;
        }
        if (i3 <= i2) {
            return i3;
        }
        return i2;
    }
}
