package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaax {
    private static final Class<?> zzbtt = zzuh();
    private static final zzabj<?, ?> zzbtu = zzu(false);
    private static final zzabj<?, ?> zzbtv = zzu(true);
    private static final zzabj<?, ?> zzbtw = new zzabl();

    static {
        AppMethodBeat.i(3365);
        AppMethodBeat.o(3365);
    }

    public static void zzh(Class<?> cls) {
        AppMethodBeat.i(3361);
        if (zzzq.class.isAssignableFrom(cls) || zzbtt == null || zzbtt.isAssignableFrom(cls)) {
            AppMethodBeat.o(3361);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        AppMethodBeat.o(3361);
        throw illegalArgumentException;
    }

    private static zzabj<?, ?> zzu(boolean z) {
        AppMethodBeat.i(3362);
        try {
            Class zzui = zzui();
            if (zzui == null) {
                AppMethodBeat.o(3362);
                return null;
            }
            zzabj zzabj = (zzabj) zzui.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
            AppMethodBeat.o(3362);
            return zzabj;
        } catch (Throwable th) {
            AppMethodBeat.o(3362);
            return null;
        }
    }

    public static zzabj<?, ?> zzue() {
        return zzbtu;
    }

    public static zzabj<?, ?> zzuf() {
        return zzbtv;
    }

    public static zzabj<?, ?> zzug() {
        return zzbtw;
    }

    private static Class<?> zzuh() {
        AppMethodBeat.i(3363);
        try {
            Class cls = Class.forName("com.google.protobuf.GeneratedMessage");
            AppMethodBeat.o(3363);
            return cls;
        } catch (Throwable th) {
            AppMethodBeat.o(3363);
            return null;
        }
    }

    private static Class<?> zzui() {
        AppMethodBeat.i(3364);
        try {
            Class cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
            AppMethodBeat.o(3364);
            return cls;
        } catch (Throwable th) {
            AppMethodBeat.o(3364);
            return null;
        }
    }
}
