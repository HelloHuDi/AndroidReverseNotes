package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh<O extends ApiOptions> {
    private final Api<O> mApi;
    private final O zzcl;
    private final boolean zzeb = true;
    private final int zzec;

    private zzh(Api<O> api) {
        AppMethodBeat.i(60918);
        this.mApi = api;
        this.zzcl = null;
        this.zzec = System.identityHashCode(this);
        AppMethodBeat.o(60918);
    }

    private zzh(Api<O> api, O o) {
        AppMethodBeat.i(60917);
        this.mApi = api;
        this.zzcl = o;
        this.zzec = Objects.hashCode(this.mApi, this.zzcl);
        AppMethodBeat.o(60917);
    }

    public static <O extends ApiOptions> zzh<O> zza(Api<O> api) {
        AppMethodBeat.i(60920);
        zzh zzh = new zzh(api);
        AppMethodBeat.o(60920);
        return zzh;
    }

    public static <O extends ApiOptions> zzh<O> zza(Api<O> api, O o) {
        AppMethodBeat.i(60919);
        zzh zzh = new zzh(api, o);
        AppMethodBeat.o(60919);
        return zzh;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(60922);
        if (obj == this) {
            AppMethodBeat.o(60922);
            return true;
        } else if (obj instanceof zzh) {
            zzh zzh = (zzh) obj;
            if (this.zzeb || zzh.zzeb || !Objects.equal(this.mApi, zzh.mApi) || !Objects.equal(this.zzcl, zzh.zzcl)) {
                AppMethodBeat.o(60922);
                return false;
            }
            AppMethodBeat.o(60922);
            return true;
        } else {
            AppMethodBeat.o(60922);
            return false;
        }
    }

    public final int hashCode() {
        return this.zzec;
    }

    public final String zzq() {
        AppMethodBeat.i(60921);
        String name = this.mApi.getName();
        AppMethodBeat.o(60921);
        return name;
    }
}
