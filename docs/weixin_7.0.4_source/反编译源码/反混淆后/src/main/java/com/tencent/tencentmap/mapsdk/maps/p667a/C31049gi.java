package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.gi */
public class C31049gi {
    /* renamed from: a */
    public static Rect m49906a(int i) {
        Rect rect;
        AppMethodBeat.m2504i(99165);
        switch (i) {
            case 1:
                rect = new Rect(72800000, 3300000, 136400000, 54800000);
                break;
            case 2:
                rect = new Rect(-180000000, -85000000, 180000000, 85000000);
                break;
            default:
                rect = new Rect(-180000000, -85000000, 180000000, 85000000);
                break;
        }
        AppMethodBeat.m2505o(99165);
        return rect;
    }
}
