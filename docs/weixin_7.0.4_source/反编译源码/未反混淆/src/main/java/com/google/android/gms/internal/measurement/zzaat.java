package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzaat {
    private static final zzaat zzbtq = new zzaat();
    private final zzaaw zzbtr;
    private final ConcurrentMap<Class<?>, zzaav<?>> zzbts = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(3357);
        AppMethodBeat.o(3357);
    }

    private zzaat() {
        AppMethodBeat.i(3355);
        zzaaw zzaaw = null;
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        for (int i = 0; i <= 0; i++) {
            zzaaw = zzfl(strArr[0]);
            if (zzaaw != null) {
                break;
            }
        }
        if (zzaaw == null) {
            zzaaw = new zzaad();
        }
        this.zzbtr = zzaaw;
        AppMethodBeat.o(3355);
    }

    private static zzaaw zzfl(String str) {
        AppMethodBeat.i(3356);
        try {
            zzaaw zzaaw = (zzaaw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(3356);
            return zzaaw;
        } catch (Throwable th) {
            AppMethodBeat.o(3356);
            return null;
        }
    }

    public static zzaat zzud() {
        return zzbtq;
    }

    public final <T> zzaav<T> zzt(T t) {
        AppMethodBeat.i(3354);
        Class cls = t.getClass();
        zzzr.zza(cls, "messageType");
        zzaav<T> zzaav = (zzaav) this.zzbts.get(cls);
        if (zzaav == null) {
            zzaav<T> zzg = this.zzbtr.zzg(cls);
            zzzr.zza(cls, "messageType");
            zzzr.zza(zzg, "schema");
            zzaav = (zzaav) this.zzbts.putIfAbsent(cls, zzg);
            if (zzaav == null) {
                zzaav = zzg;
            }
        }
        AppMethodBeat.o(3354);
        return zzaav;
    }
}
