package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum zzabp {
    DOUBLE(zzabu.DOUBLE, 1),
    FLOAT(zzabu.FLOAT, 5),
    INT64(zzabu.LONG, 0),
    UINT64(zzabu.LONG, 0),
    INT32(zzabu.INT, 0),
    FIXED64(zzabu.LONG, 1),
    FIXED32(zzabu.INT, 5),
    BOOL(zzabu.BOOLEAN, 0),
    STRING(zzabu.STRING, 2),
    GROUP(zzabu.MESSAGE, 3),
    MESSAGE(zzabu.MESSAGE, 2),
    BYTES(zzabu.BYTE_STRING, 2),
    UINT32(zzabu.INT, 0),
    ENUM(zzabu.ENUM, 0),
    SFIXED32(zzabu.INT, 5),
    SFIXED64(zzabu.LONG, 1),
    SINT32(zzabu.INT, 0),
    SINT64(zzabu.LONG, 0);
    
    private final zzabu zzbwb;
    private final int zzbwc;

    static {
        AppMethodBeat.o(3428);
    }

    private zzabp(zzabu zzabu, int i) {
        this.zzbwb = zzabu;
        this.zzbwc = i;
    }

    public final zzabu zzuv() {
        return this.zzbwb;
    }
}
