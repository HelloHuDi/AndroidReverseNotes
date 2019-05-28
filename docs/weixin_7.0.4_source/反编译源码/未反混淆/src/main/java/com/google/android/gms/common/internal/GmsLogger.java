package com.google.android.gms.common.internal;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GmsLogger {
    public static final int MAX_PII_TAG_LENGTH = 15;
    public static final int MAX_TAG_LENGTH = 23;
    private static final String zzub = null;
    private final String zzuc;
    private final String zzud;

    public GmsLogger(String str) {
        this(str, null);
    }

    public GmsLogger(String str, String str2) {
        AppMethodBeat.i(89642);
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.zzuc = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzud = null;
            AppMethodBeat.o(89642);
            return;
        }
        this.zzud = str2;
        AppMethodBeat.o(89642);
    }

    public static boolean isBuildPiiEnabled() {
        return false;
    }

    private final String zza(String str, Object... objArr) {
        AppMethodBeat.i(89665);
        String format = String.format(str, objArr);
        if (this.zzud == null) {
            AppMethodBeat.o(89665);
            return format;
        }
        format = this.zzud.concat(format);
        AppMethodBeat.o(89665);
        return format;
    }

    private final String zzl(String str) {
        AppMethodBeat.i(89664);
        if (this.zzud == null) {
            AppMethodBeat.o(89664);
            return str;
        }
        str = this.zzud.concat(str);
        AppMethodBeat.o(89664);
        return str;
    }

    public final boolean canLog(int i) {
        AppMethodBeat.i(89644);
        boolean isLoggable = Log.isLoggable(this.zzuc, i);
        AppMethodBeat.o(89644);
        return isLoggable;
    }

    public final boolean canLogPii() {
        return false;
    }

    public final void d(String str, String str2) {
        AppMethodBeat.i(89645);
        if (canLog(3)) {
            zzl(str2);
        }
        AppMethodBeat.o(89645);
    }

    public final void d(String str, String str2, Throwable th) {
        AppMethodBeat.i(89646);
        if (canLog(3)) {
            zzl(str2);
        }
        AppMethodBeat.o(89646);
    }

    public final void dfmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(89647);
        if (canLog(3)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(89647);
    }

    public final void e(String str, String str2) {
        AppMethodBeat.i(89657);
        if (canLog(6)) {
            zzl(str2);
        }
        AppMethodBeat.o(89657);
    }

    public final void e(String str, String str2, Throwable th) {
        AppMethodBeat.i(89658);
        if (canLog(6)) {
            zzl(str2);
        }
        AppMethodBeat.o(89658);
    }

    public final void efmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(89659);
        if (canLog(6)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(89659);
    }

    public final String getTag() {
        return this.zzuc;
    }

    public final void i(String str, String str2) {
        AppMethodBeat.i(89651);
        if (canLog(4)) {
            zzl(str2);
        }
        AppMethodBeat.o(89651);
    }

    public final void i(String str, String str2, Throwable th) {
        AppMethodBeat.i(89652);
        if (canLog(4)) {
            zzl(str2);
        }
        AppMethodBeat.o(89652);
    }

    public final void ifmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(89653);
        if (canLog(4)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(89653);
    }

    public final void pii(String str, String str2) {
        AppMethodBeat.i(89661);
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            if (valueOf2.length() != 0) {
                valueOf.concat(valueOf2);
            } else {
                valueOf2 = new String(valueOf);
            }
            zzl(str2);
        }
        AppMethodBeat.o(89661);
    }

    public final void pii(String str, String str2, Throwable th) {
        AppMethodBeat.i(89662);
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            if (valueOf2.length() != 0) {
                valueOf.concat(valueOf2);
            } else {
                valueOf2 = new String(valueOf);
            }
            zzl(str2);
        }
        AppMethodBeat.o(89662);
    }

    public final void piifmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(89663);
        if (canLogPii()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(" PII_LOG");
            if (valueOf2.length() != 0) {
                valueOf.concat(valueOf2);
            } else {
                valueOf2 = new String(valueOf);
            }
            zza(str2, objArr);
        }
        AppMethodBeat.o(89663);
    }

    public final void v(String str, String str2) {
        AppMethodBeat.i(89648);
        if (canLog(2)) {
            zzl(str2);
        }
        AppMethodBeat.o(89648);
    }

    public final void v(String str, String str2, Throwable th) {
        AppMethodBeat.i(89649);
        if (canLog(2)) {
            zzl(str2);
        }
        AppMethodBeat.o(89649);
    }

    public final void vfmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(89650);
        if (canLog(2)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(89650);
    }

    public final void w(String str, String str2) {
        AppMethodBeat.i(89654);
        if (canLog(5)) {
            zzl(str2);
        }
        AppMethodBeat.o(89654);
    }

    public final void w(String str, String str2, Throwable th) {
        AppMethodBeat.i(89655);
        if (canLog(5)) {
            zzl(str2);
        }
        AppMethodBeat.o(89655);
    }

    public final void wfmt(String str, String str2, Object... objArr) {
        AppMethodBeat.i(89656);
        if (canLog(5)) {
            zza(str2, objArr);
        }
        AppMethodBeat.o(89656);
    }

    public final GmsLogger withMessagePrefix(String str) {
        AppMethodBeat.i(89643);
        GmsLogger gmsLogger = new GmsLogger(this.zzuc, str);
        AppMethodBeat.o(89643);
        return gmsLogger;
    }

    public final void wtf(String str, String str2, Throwable th) {
        AppMethodBeat.i(89660);
        if (canLog(7)) {
            zzl(str2);
            Log.wtf(str, zzl(str2), th);
        }
        AppMethodBeat.o(89660);
    }
}
