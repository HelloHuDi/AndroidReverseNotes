package com.google.android.exoplayer2.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

public final class g {
    private int aBR;
    public final f[] bpE;
    public final int length;

    public g(f... fVarArr) {
        AppMethodBeat.i(95781);
        this.bpE = fVarArr;
        this.length = fVarArr.length;
        AppMethodBeat.o(95781);
    }

    public final f[] ti() {
        AppMethodBeat.i(95782);
        f[] fVarArr = (f[]) this.bpE.clone();
        AppMethodBeat.o(95782);
        return fVarArr;
    }

    public final int hashCode() {
        AppMethodBeat.i(95783);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.bpE) + JsApiGetABTestConfig.CTRL_INDEX;
        }
        int i = this.aBR;
        AppMethodBeat.o(95783);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95784);
        if (this == obj) {
            AppMethodBeat.o(95784);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95784);
            return false;
        } else {
            boolean equals = Arrays.equals(this.bpE, ((g) obj).bpE);
            AppMethodBeat.o(95784);
            return equals;
        }
    }
}
