package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class zzf {
    private static final zzg zzdc;
    private static final int zzdd;

    static final class zzd extends zzg {
        zzd() {
        }

        public final void zzd(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        AppMethodBeat.i(57625);
        Integer num = null;
        zzg zzj;
        try {
            num = zzy();
            if (num == null || num.intValue() < 19) {
                zzj = (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? 1 : null) != null ? new zzj() : new zzd();
                zzdc = zzj;
                zzdd = num != null ? 1 : num.intValue();
                AppMethodBeat.o(57625);
            }
            zzj = new zzk();
            zzdc = zzj;
            if (num != null) {
            }
            zzdd = num != null ? 1 : num.intValue();
            AppMethodBeat.o(57625);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zzd.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzj = new zzd();
        }
    }

    public static void zzd(Throwable th, Throwable th2) {
        AppMethodBeat.i(57623);
        zzdc.zzd(th, th2);
        AppMethodBeat.o(57623);
    }

    private static Integer zzy() {
        AppMethodBeat.i(57624);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.o(57624);
            return num;
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            AppMethodBeat.o(57624);
            return null;
        }
    }
}
