package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaas {
    private static final zzaaq zzbto = zzuc();
    private static final zzaaq zzbtp = new zzaar();

    static {
        AppMethodBeat.i(3353);
        AppMethodBeat.o(3353);
    }

    static zzaaq zzua() {
        return zzbto;
    }

    static zzaaq zzub() {
        return zzbtp;
    }

    private static zzaaq zzuc() {
        AppMethodBeat.i(3352);
        try {
            zzaaq zzaaq = (zzaaq) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(3352);
            return zzaaq;
        } catch (Exception e) {
            AppMethodBeat.o(3352);
            return null;
        }
    }
}
