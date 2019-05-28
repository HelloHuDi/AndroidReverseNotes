package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cu.b;
import com.tencent.view.d;

public class kc implements b {
    public int colorForValue(double d) {
        int i;
        int pow;
        AppMethodBeat.i(100200);
        if (d > 1.0d) {
            d = 1.0d;
        }
        double sqrt = Math.sqrt(d);
        int i2 = d.MIC_AVROUND_BLUR;
        if (sqrt > 0.7d) {
            i2 = 78;
            i = 1;
        } else {
            i = 3;
        }
        if (sqrt > 0.6d) {
            pow = (int) ((Math.pow(sqrt - 0.7d, 3.0d) * 20000.0d) + 240.0d);
        } else if (sqrt > 0.4d) {
            pow = (int) ((Math.pow(sqrt - 0.5d, 3.0d) * 20000.0d) + 200.0d);
        } else if (sqrt > 0.2d) {
            pow = (int) ((Math.pow(sqrt - 0.3d, 3.0d) * 20000.0d) + 160.0d);
        } else {
            pow = (int) (sqrt * 700.0d);
        }
        if (pow > 255) {
            pow = 255;
        }
        pow = Color.argb(pow, 255, i2, i);
        AppMethodBeat.o(100200);
        return pow;
    }
}
