package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class zzk {
    private static final zzl zzahg;
    private static final int zzahh;

    static final class zza extends zzl {
        zza() {
        }

        public final void zza(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        AppMethodBeat.i(90495);
        Integer num = null;
        zzl zzo;
        try {
            num = zzdw();
            if (num == null || num.intValue() < 19) {
                zzo = (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? 1 : null) != null ? new zzo() : new zza();
                zzahg = zzo;
                zzahh = num != null ? 1 : num.intValue();
                AppMethodBeat.o(90495);
            }
            zzo = new zzp();
            zzahg = zzo;
            if (num != null) {
            }
            zzahh = num != null ? 1 : num.intValue();
            AppMethodBeat.o(90495);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzo = new zza();
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(90493);
        zzahg.zza(th, th2);
        AppMethodBeat.o(90493);
    }

    private static Integer zzdw() {
        AppMethodBeat.i(90494);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.o(90494);
            return num;
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            AppMethodBeat.o(90494);
            return null;
        }
    }
}
