package com.tencent.d.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class f {
    private static Boolean Atl = null;
    private static final Object Atm = new Object();

    static {
        AppMethodBeat.i(114533);
        AppMethodBeat.o(114533);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A:{Catch:{ Exception -> 0x004e, all -> 0x0055, all -> 0x0062 }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d A:{Catch:{ Exception -> 0x004e, all -> 0x0055, all -> 0x0062 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean dQp() {
        Boolean bool;
        boolean booleanValue;
        Throwable th;
        Closeable closeable;
        AppMethodBeat.i(114532);
        synchronized (Atm) {
            Closeable fileInputStream;
            try {
                if (Atl == null) {
                    if (VERSION.SDK_INT < 17 || !new File("/sys/fs/selinux/enforce").exists()) {
                        bool = null;
                    } else {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            Boolean valueOf = Boolean.valueOf(fileInputStream.read() == 49);
                            b.closeQuietly(fileInputStream);
                            bool = valueOf;
                        } catch (Exception e) {
                            b.closeQuietly(fileInputStream);
                            bool = null;
                            if (bool == null) {
                            }
                            Atl = bool;
                            booleanValue = Atl.booleanValue();
                            AppMethodBeat.o(114532);
                            return booleanValue;
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = fileInputStream;
                            b.closeQuietly(closeable);
                            AppMethodBeat.o(114532);
                            throw th;
                        }
                    }
                    if (bool == null) {
                        bool = Boolean.FALSE;
                    }
                    Atl = bool;
                }
            } catch (Exception e2) {
                fileInputStream = null;
                b.closeQuietly(fileInputStream);
                bool = null;
                if (bool == null) {
                }
                Atl = bool;
                booleanValue = Atl.booleanValue();
                AppMethodBeat.o(114532);
                return booleanValue;
            } catch (Throwable th3) {
                AppMethodBeat.o(114532);
            }
            booleanValue = Atl.booleanValue();
        }
        AppMethodBeat.o(114532);
        return booleanValue;
    }
}
