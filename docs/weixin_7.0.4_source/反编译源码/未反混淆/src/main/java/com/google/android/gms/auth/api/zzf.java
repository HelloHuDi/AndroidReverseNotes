package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzbh;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzf {
    public static final Api<zzh> API = new Api("Auth.PROXY_API", zzat, zzas);
    private static final ClientKey<zzbh> zzas = new ClientKey();
    private static final AbstractClientBuilder<zzbh, zzh> zzat = new zzg();

    static {
        AppMethodBeat.i(77052);
        AppMethodBeat.o(77052);
    }
}
