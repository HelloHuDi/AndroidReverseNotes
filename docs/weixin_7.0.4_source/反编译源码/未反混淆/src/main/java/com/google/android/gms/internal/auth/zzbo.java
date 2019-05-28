package com.google.android.gms.internal.auth;

import android.content.Context;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbo extends zzbm {
    private final /* synthetic */ ProxyRequest zzec;

    zzbo(zzbn zzbn, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        this.zzec = proxyRequest;
        super(googleApiClient);
    }

    /* Access modifiers changed, original: protected|final */
    public final void zzd(Context context, zzbk zzbk) {
        AppMethodBeat.i(77108);
        zzbk.zzd(new zzbp(this), this.zzec);
        AppMethodBeat.o(77108);
    }
}
