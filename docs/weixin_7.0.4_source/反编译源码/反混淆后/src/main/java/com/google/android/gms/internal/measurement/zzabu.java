package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum zzabu {
    INT(Integer.valueOf(0)),
    LONG(Long.valueOf(0)),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzyw.zzbqx),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzbwn;

    static {
        AppMethodBeat.m2505o(3430);
    }

    private zzabu(Object obj) {
        this.zzbwn = obj;
    }
}
