package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class zzh {
    private static final zzi zze;
    private static final int zzf;

    static final class zza extends zzi {
        zza() {
        }

        public final void zza(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        AppMethodBeat.m2504i(108680);
        Integer num = null;
        zzi zzl;
        try {
            num = zza();
            if (num == null || num.intValue() < 19) {
                zzl = (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? 1 : null) != null ? new zzl() : new zza();
                zze = zzl;
                zzf = num != null ? 1 : num.intValue();
                AppMethodBeat.m2505o(108680);
            }
            zzl = new zzm();
            zze = zzl;
            if (num != null) {
            }
            zzf = num != null ? 1 : num.intValue();
            AppMethodBeat.m2505o(108680);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzl = new zza();
        }
    }

    private static Integer zza() {
        AppMethodBeat.m2504i(108679);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.m2505o(108679);
            return num;
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            AppMethodBeat.m2505o(108679);
            return null;
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        AppMethodBeat.m2504i(108678);
        zze.zza(th, th2);
        AppMethodBeat.m2505o(108678);
    }
}
