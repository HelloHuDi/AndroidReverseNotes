package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzzp implements zzaak {
    private static final zzzp zzbrx = new zzzp();

    static {
        AppMethodBeat.i(3584);
        AppMethodBeat.o(3584);
    }

    private zzzp() {
    }

    public static zzzp zztl() {
        return zzbrx;
    }

    public final boolean zzd(Class<?> cls) {
        AppMethodBeat.i(3582);
        boolean isAssignableFrom = zzzq.class.isAssignableFrom(cls);
        AppMethodBeat.o(3582);
        return isAssignableFrom;
    }

    public final zzaaj zze(Class<?> cls) {
        String valueOf;
        AppMethodBeat.i(3583);
        if (zzzq.class.isAssignableFrom(cls)) {
            try {
                zzaaj zzaaj = (zzaaj) zzzq.zzf(cls.asSubclass(zzzq.class)).zza(3, null, null);
                AppMethodBeat.o(3583);
                return zzaaj;
            } catch (Exception e) {
                Throwable th = e;
                String str = "Unable to get message info for ";
                valueOf = String.valueOf(cls.getName());
                RuntimeException runtimeException = new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
                AppMethodBeat.o(3583);
                throw runtimeException;
            }
        }
        String str2 = "Unsupported message type: ";
        valueOf = String.valueOf(cls.getName());
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        AppMethodBeat.o(3583);
        throw illegalArgumentException;
    }
}
