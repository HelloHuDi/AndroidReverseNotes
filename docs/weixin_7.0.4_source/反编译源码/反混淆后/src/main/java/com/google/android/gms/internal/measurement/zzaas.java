package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaas {
    private static final zzaaq zzbto = zzuc();
    private static final zzaaq zzbtp = new zzaar();

    static {
        AppMethodBeat.m2504i(3353);
        AppMethodBeat.m2505o(3353);
    }

    static zzaaq zzua() {
        return zzbto;
    }

    static zzaaq zzub() {
        return zzbtp;
    }

    private static zzaaq zzuc() {
        AppMethodBeat.m2504i(3352);
        try {
            zzaaq zzaaq = (zzaaq) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.m2505o(3352);
            return zzaaq;
        } catch (Exception e) {
            AppMethodBeat.m2505o(3352);
            return null;
        }
    }
}
