package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

final class zzacg {
    final int tag;
    final byte[] zzbrc;

    zzacg(int i, byte[] bArr) {
        this.tag = i;
        this.zzbrc = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(3519);
        if (obj == this) {
            AppMethodBeat.m2505o(3519);
            return true;
        } else if (obj instanceof zzacg) {
            zzacg zzacg = (zzacg) obj;
            if (this.tag == zzacg.tag && Arrays.equals(this.zzbrc, zzacg.zzbrc)) {
                AppMethodBeat.m2505o(3519);
                return true;
            }
            AppMethodBeat.m2505o(3519);
            return false;
        } else {
            AppMethodBeat.m2505o(3519);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(3520);
        int hashCode = ((this.tag + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.zzbrc);
        AppMethodBeat.m2505o(3520);
        return hashCode;
    }
}
