package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzzh {
    private static final Class<?> zzbrl = zztb();

    static {
        AppMethodBeat.i(3563);
        AppMethodBeat.o(3563);
    }

    private static final zzzi zzfj(String str) {
        AppMethodBeat.i(3562);
        zzzi zzzi = (zzzi) zzbrl.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        AppMethodBeat.o(3562);
        return zzzi;
    }

    private static Class<?> zztb() {
        AppMethodBeat.i(3560);
        try {
            Class cls = Class.forName("com.google.protobuf.ExtensionRegistry");
            AppMethodBeat.o(3560);
            return cls;
        } catch (ClassNotFoundException e) {
            AppMethodBeat.o(3560);
            return null;
        }
    }

    public static zzzi zztc() {
        zzzi zzfj;
        AppMethodBeat.i(3561);
        if (zzbrl != null) {
            try {
                zzfj = zzfj("getEmptyRegistry");
                AppMethodBeat.o(3561);
                return zzfj;
            } catch (Exception e) {
            }
        }
        zzfj = zzzi.zzbro;
        AppMethodBeat.o(3561);
        return zzfj;
    }
}
