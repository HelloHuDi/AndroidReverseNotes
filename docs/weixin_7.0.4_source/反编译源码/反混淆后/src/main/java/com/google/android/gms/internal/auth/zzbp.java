package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbp extends zzbg {
    private final /* synthetic */ zzbo zzed;

    zzbp(zzbo zzbo) {
        this.zzed = zzbo;
    }

    public final void zzd(ProxyResponse proxyResponse) {
        AppMethodBeat.m2504i(77109);
        this.zzed.setResult(new zzbq(proxyResponse));
        AppMethodBeat.m2505o(77109);
    }
}
