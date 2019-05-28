package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.source.o */
public final class C41630o {
    private int aBR;
    public final Format[] bhv;
    public final int length;

    public C41630o(Format... formatArr) {
        AppMethodBeat.m2504i(95552);
        C45039a.checkState(formatArr.length > 0);
        this.bhv = formatArr;
        this.length = formatArr.length;
        AppMethodBeat.m2505o(95552);
    }

    /* renamed from: j */
    public final int mo66765j(Format format) {
        for (int i = 0; i < this.bhv.length; i++) {
            if (format == this.bhv[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95553);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.bhv) + JsApiGetABTestConfig.CTRL_INDEX;
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(95553);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95554);
        if (this == obj) {
            AppMethodBeat.m2505o(95554);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95554);
            return false;
        } else {
            C41630o c41630o = (C41630o) obj;
            if (this.length == c41630o.length && Arrays.equals(this.bhv, c41630o.bhv)) {
                AppMethodBeat.m2505o(95554);
                return true;
            }
            AppMethodBeat.m2505o(95554);
            return false;
        }
    }
}
