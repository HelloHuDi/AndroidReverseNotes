package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Common {
    public static final Api<NoOptions> API = new Api("Common.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final AbstractClientBuilder<CommonClient, NoOptions> CLIENT_BUILDER = new zza();
    public static final ClientKey<CommonClient> CLIENT_KEY = new ClientKey();
    public static final CommonApi CommonApi = new CommonApiImpl();

    static {
        AppMethodBeat.i(61391);
        AppMethodBeat.o(61391);
    }
}
