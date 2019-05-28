package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.Arrays;

final class zzv {
    final int tag;
    final byte[] zzhm;

    zzv(int i, byte[] bArr) {
        this.tag = i;
        this.zzhm = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70782);
        if (obj == this) {
            AppMethodBeat.o(70782);
            return true;
        } else if (obj instanceof zzv) {
            zzv zzv = (zzv) obj;
            if (this.tag == zzv.tag && Arrays.equals(this.zzhm, zzv.zzhm)) {
                AppMethodBeat.o(70782);
                return true;
            }
            AppMethodBeat.o(70782);
            return false;
        } else {
            AppMethodBeat.o(70782);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(70783);
        int hashCode = ((this.tag + JsApiGetABTestConfig.CTRL_INDEX) * 31) + Arrays.hashCode(this.zzhm);
        AppMethodBeat.o(70783);
        return hashCode;
    }
}
