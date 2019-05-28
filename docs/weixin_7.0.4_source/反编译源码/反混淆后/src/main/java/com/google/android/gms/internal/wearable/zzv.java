package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

final class zzv {
    final int tag;
    final byte[] zzhm;

    zzv(int i, byte[] bArr) {
        this.tag = i;
        this.zzhm = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70782);
        if (obj == this) {
            AppMethodBeat.m2505o(70782);
            return true;
        } else if (obj instanceof zzv) {
            zzv zzv = (zzv) obj;
            if (this.tag == zzv.tag && Arrays.equals(this.zzhm, zzv.zzhm)) {
                AppMethodBeat.m2505o(70782);
                return true;
            }
            AppMethodBeat.m2505o(70782);
            return false;
        } else {
            AppMethodBeat.m2505o(70782);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70783);
        int hashCode = ((this.tag + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.zzhm);
        AppMethodBeat.m2505o(70783);
        return hashCode;
    }
}
