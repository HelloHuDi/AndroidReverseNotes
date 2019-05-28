package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaai {
    private static final zzaag zzbtg = zztv();
    private static final zzaag zzbth = new zzaah();

    static {
        AppMethodBeat.i(3339);
        AppMethodBeat.o(3339);
    }

    static zzaag zztt() {
        return zzbtg;
    }

    static zzaag zztu() {
        return zzbth;
    }

    private static zzaag zztv() {
        AppMethodBeat.i(3338);
        try {
            zzaag zzaag = (zzaag) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(3338);
            return zzaag;
        } catch (Exception e) {
            AppMethodBeat.o(3338);
            return null;
        }
    }
}
