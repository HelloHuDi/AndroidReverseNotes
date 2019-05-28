package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

/* renamed from: com.google.android.exoplayer2.p */
public final class C45045p {
    public static final C45045p aOC = new C45045p(1.0f, 1.0f);
    public final int aOD;
    public final float pitch;
    public final float speed;

    static {
        AppMethodBeat.m2504i(95390);
        AppMethodBeat.m2505o(95390);
    }

    public C45045p(float f, float f2) {
        AppMethodBeat.m2504i(95387);
        this.speed = f;
        this.pitch = f2;
        this.aOD = Math.round(1000.0f * f);
        AppMethodBeat.m2505o(95387);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95388);
        if (this == obj) {
            AppMethodBeat.m2505o(95388);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95388);
            return false;
        } else {
            C45045p c45045p = (C45045p) obj;
            if (this.speed == c45045p.speed && this.pitch == c45045p.pitch) {
                AppMethodBeat.m2505o(95388);
                return true;
            }
            AppMethodBeat.m2505o(95388);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95389);
        int floatToRawIntBits = ((Float.floatToRawIntBits(this.speed) + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Float.floatToRawIntBits(this.pitch);
        AppMethodBeat.m2505o(95389);
        return floatToRawIntBits;
    }
}
