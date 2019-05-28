package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zzdr;

    public UnsupportedApiCallException(Feature feature) {
        this.zzdr = feature;
    }

    public final String getMessage() {
        AppMethodBeat.m2504i(89459);
        String valueOf = String.valueOf(this.zzdr);
        valueOf = new StringBuilder(String.valueOf(valueOf).length() + 8).append("Missing ").append(valueOf).toString();
        AppMethodBeat.m2505o(89459);
        return valueOf;
    }
}
