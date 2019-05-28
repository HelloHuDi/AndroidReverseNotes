package com.google.android.exoplayer2.p109g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.g.g */
public final class C37259g {
    private int aBR;
    public final C45035f[] bpE;
    public final int length;

    public C37259g(C45035f... c45035fArr) {
        AppMethodBeat.m2504i(95781);
        this.bpE = c45035fArr;
        this.length = c45035fArr.length;
        AppMethodBeat.m2505o(95781);
    }

    /* renamed from: ti */
    public final C45035f[] mo59500ti() {
        AppMethodBeat.m2504i(95782);
        C45035f[] c45035fArr = (C45035f[]) this.bpE.clone();
        AppMethodBeat.m2505o(95782);
        return c45035fArr;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95783);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.bpE) + JsApiGetABTestConfig.CTRL_INDEX;
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(95783);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95784);
        if (this == obj) {
            AppMethodBeat.m2505o(95784);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95784);
            return false;
        } else {
            boolean equals = Arrays.equals(this.bpE, ((C37259g) obj).bpE);
            AppMethodBeat.m2505o(95784);
            return equals;
        }
    }
}
