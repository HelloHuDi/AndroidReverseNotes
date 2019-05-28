package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaaf implements zzaak {
    private zzaak[] zzbtf;

    zzaaf(zzaak... zzaakArr) {
        this.zzbtf = zzaakArr;
    }

    public final boolean zzd(Class<?> cls) {
        AppMethodBeat.m2504i(3336);
        for (zzaak zzd : this.zzbtf) {
            if (zzd.zzd(cls)) {
                AppMethodBeat.m2505o(3336);
                return true;
            }
        }
        AppMethodBeat.m2505o(3336);
        return false;
    }

    public final zzaaj zze(Class<?> cls) {
        AppMethodBeat.m2504i(3337);
        for (zzaak zzaak : this.zzbtf) {
            if (zzaak.zzd(cls)) {
                zzaaj zze = zzaak.zze(cls);
                AppMethodBeat.m2505o(3337);
                return zze;
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        AppMethodBeat.m2505o(3337);
        throw unsupportedOperationException;
    }
}
