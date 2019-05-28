package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

public final class p {
    public static final p aOC = new p(1.0f, 1.0f);
    public final int aOD;
    public final float pitch;
    public final float speed;

    static {
        AppMethodBeat.i(95390);
        AppMethodBeat.o(95390);
    }

    public p(float f, float f2) {
        AppMethodBeat.i(95387);
        this.speed = f;
        this.pitch = f2;
        this.aOD = Math.round(1000.0f * f);
        AppMethodBeat.o(95387);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95388);
        if (this == obj) {
            AppMethodBeat.o(95388);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95388);
            return false;
        } else {
            p pVar = (p) obj;
            if (this.speed == pVar.speed && this.pitch == pVar.pitch) {
                AppMethodBeat.o(95388);
                return true;
            }
            AppMethodBeat.o(95388);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(95389);
        int floatToRawIntBits = ((Float.floatToRawIntBits(this.speed) + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Float.floatToRawIntBits(this.pitch);
        AppMethodBeat.o(95389);
        return floatToRawIntBits;
    }
}
