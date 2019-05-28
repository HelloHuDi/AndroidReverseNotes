package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class o {
    private int aBR;
    public final Format[] bhv;
    public final int length;

    public o(Format... formatArr) {
        AppMethodBeat.i(95552);
        a.checkState(formatArr.length > 0);
        this.bhv = formatArr;
        this.length = formatArr.length;
        AppMethodBeat.o(95552);
    }

    public final int j(Format format) {
        for (int i = 0; i < this.bhv.length; i++) {
            if (format == this.bhv[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        AppMethodBeat.i(95553);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.bhv) + JsApiGetABTestConfig.CTRL_INDEX;
        }
        int i = this.aBR;
        AppMethodBeat.o(95553);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95554);
        if (this == obj) {
            AppMethodBeat.o(95554);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95554);
            return false;
        } else {
            o oVar = (o) obj;
            if (this.length == oVar.length && Arrays.equals(this.bhv, oVar.bhv)) {
                AppMethodBeat.o(95554);
                return true;
            }
            AppMethodBeat.o(95554);
            return false;
        }
    }
}
