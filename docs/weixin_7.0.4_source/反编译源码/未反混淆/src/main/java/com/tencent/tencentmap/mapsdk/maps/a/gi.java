package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class gi {
    public static Rect a(int i) {
        Rect rect;
        AppMethodBeat.i(99165);
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
        AppMethodBeat.o(99165);
        return rect;
    }
}
