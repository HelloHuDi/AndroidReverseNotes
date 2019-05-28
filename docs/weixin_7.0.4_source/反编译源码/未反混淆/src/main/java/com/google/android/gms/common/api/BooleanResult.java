package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;

@KeepForSdk
public class BooleanResult implements Result {
    private final Status mStatus;
    private final boolean zzck;

    @KeepForSdk
    public BooleanResult(Status status, boolean z) {
        AppMethodBeat.i(60492);
        this.mStatus = (Status) Preconditions.checkNotNull(status, "Status must not be null");
        this.zzck = z;
        AppMethodBeat.o(60492);
    }

    @KeepForSdk
    public final boolean equals(Object obj) {
        AppMethodBeat.i(60494);
        if (obj == this) {
            AppMethodBeat.o(60494);
            return true;
        } else if (obj instanceof BooleanResult) {
            BooleanResult booleanResult = (BooleanResult) obj;
            if (this.mStatus.equals(booleanResult.mStatus) && this.zzck == booleanResult.zzck) {
                AppMethodBeat.o(60494);
                return true;
            }
            AppMethodBeat.o(60494);
            return false;
        } else {
            AppMethodBeat.o(60494);
            return false;
        }
    }

    @KeepForSdk
    public Status getStatus() {
        return this.mStatus;
    }

    @KeepForSdk
    public boolean getValue() {
        return this.zzck;
    }

    @KeepForSdk
    public final int hashCode() {
        AppMethodBeat.i(60493);
        int hashCode = (this.zzck ? 1 : 0) + ((this.mStatus.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31);
        AppMethodBeat.o(60493);
        return hashCode;
    }
}
