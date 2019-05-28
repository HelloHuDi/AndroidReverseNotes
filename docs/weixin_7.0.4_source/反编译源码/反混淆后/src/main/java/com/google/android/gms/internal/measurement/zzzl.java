package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzzl {
    private static final zzzj<?> zzbrq = new zzzk();
    private static final zzzj<?> zzbrr = zztf();

    static {
        AppMethodBeat.m2504i(3571);
        AppMethodBeat.m2505o(3571);
    }

    private static zzzj<?> zztf() {
        AppMethodBeat.m2504i(3569);
        try {
            zzzj zzzj = (zzzj) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.m2505o(3569);
            return zzzj;
        } catch (Exception e) {
            AppMethodBeat.m2505o(3569);
            return null;
        }
    }

    static zzzj<?> zztg() {
        return zzbrq;
    }

    static zzzj<?> zzth() {
        AppMethodBeat.m2504i(3570);
        if (zzbrr == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Protobuf runtime is not correctly loaded.");
            AppMethodBeat.m2505o(3570);
            throw illegalStateException;
        }
        zzzj zzzj = zzbrr;
        AppMethodBeat.m2505o(3570);
        return zzzj;
    }
}
