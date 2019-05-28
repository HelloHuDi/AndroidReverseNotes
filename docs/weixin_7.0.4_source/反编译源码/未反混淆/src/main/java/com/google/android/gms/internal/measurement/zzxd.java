package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class zzxd {
    private static final zzxe zzbnx;
    private static final int zzbny;

    static final class zza extends zzxe {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            AppMethodBeat.i(3535);
            th.printStackTrace(printStream);
            AppMethodBeat.o(3535);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static {
        AppMethodBeat.i(3538);
        Integer num = null;
        zzxe zzxh;
        try {
            num = zzsd();
            if (num == null || num.intValue() < 19) {
                zzxh = (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ? 1 : null) != null ? new zzxh() : new zza();
                zzbnx = zzxh;
                zzbny = num != null ? 1 : num.intValue();
                AppMethodBeat.o(3538);
            }
            zzxh = new zzxi();
            zzbnx = zzxh;
            if (num != null) {
            }
            zzbny = num != null ? 1 : num.intValue();
            AppMethodBeat.o(3538);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = zza.class.getName();
            printStream.println(new StringBuilder(String.valueOf(name).length() + 132).append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ").append(name).append("will be used. The error is: ").toString());
            th.printStackTrace(System.err);
            zzxh = new zza();
        }
    }

    public static void zza(Throwable th, PrintStream printStream) {
        AppMethodBeat.i(3536);
        zzbnx.zza(th, printStream);
        AppMethodBeat.o(3536);
    }

    private static Integer zzsd() {
        AppMethodBeat.i(3537);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.o(3537);
            return num;
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            AppMethodBeat.o(3537);
            return null;
        }
    }
}
