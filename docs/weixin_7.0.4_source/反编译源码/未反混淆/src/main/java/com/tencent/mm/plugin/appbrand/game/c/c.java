package com.tencent.mm.plugin.appbrand.game.c;

import android.widget.Toast;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.game.a.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.util.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class c {
    private static boolean hru = false;

    public static void axy() {
        AppMethodBeat.i(130139);
        b.a(new a() {
            public final void loadLibrary(String str) {
                AppMethodBeat.i(130137);
                c.jJ(str);
                AppMethodBeat.o(130137);
            }
        });
        com.tencent.mm.udp.libmmudp.a.a(new com.tencent.mm.udp.libmmudp.a.a() {
            public final void loadLibrary(String str) {
                AppMethodBeat.i(130138);
                try {
                    ab.i("MicroMsg.MBLoadDelegateRegistery", "loadLibrary libName:%s", str);
                    k.a(str, c.class.getClassLoader());
                    AppMethodBeat.o(130138);
                } catch (UnsatisfiedLinkError e) {
                    ab.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e, "hy: link %s error!!", str);
                    com.tencent.mm.plugin.appbrand.game.g.b.cH(ah.getContext());
                    AppMethodBeat.o(130138);
                }
            }
        });
        AppMethodBeat.o(130139);
    }

    private static File bT(String str, String str2) {
        InputStream bufferedInputStream;
        OutputStream bufferedOutputStream;
        Throwable th;
        AppMethodBeat.i(130140);
        File dir = ah.getContext().getDir("magicbrush", 0);
        if (dir.exists() || dir.mkdirs()) {
            File file = new File(dir, str);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str2));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    g.closeQuietly(bufferedInputStream);
                    g.closeQuietly(bufferedOutputStream);
                    AppMethodBeat.o(130140);
                    throw th;
                }
                try {
                    g.copy(bufferedInputStream, bufferedOutputStream);
                    g.closeQuietly(bufferedInputStream);
                    g.closeQuietly(bufferedOutputStream);
                    AppMethodBeat.o(130140);
                    return file;
                } catch (Throwable th3) {
                    th = th3;
                    g.closeQuietly(bufferedInputStream);
                    g.closeQuietly(bufferedOutputStream);
                    AppMethodBeat.o(130140);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
                g.closeQuietly(bufferedInputStream);
                g.closeQuietly(bufferedOutputStream);
                AppMethodBeat.o(130140);
                throw th;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.o(130140);
        throw illegalStateException;
    }

    static /* synthetic */ void jJ(String str) {
        AppMethodBeat.i(130141);
        if ((f.IS_FLAVOR_RED || f.DEBUG || bp.dpL()) && "magicbrush".equals(str) && ((Boolean) e.Aq("localso").Uw()).booleanValue()) {
            String str2 = "magicbrush";
            if (hru) {
                ab.i("MicroMsg.MBLoadDelegateRegistery", "load custom local so libName: %s, skip", str2);
                AppMethodBeat.o(130141);
                return;
            }
            int i;
            CharSequence concat;
            hru = true;
            try {
                ab.i("MicroMsg.MBLoadDelegateRegistery", "load custom local so libName: %s", str2);
                String str3 = "lib" + str2 + ".so";
                System.load(bT(str3, "/sdcard/magicbrush/".concat(String.valueOf(str3))).getAbsolutePath());
                i = 1;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e, "load local so failed", new Object[0]);
                i = 0;
            }
            if (i != 0) {
                concat = "local so succeed: ".concat(String.valueOf(str2));
            } else {
                concat = "local so failed: ".concat(String.valueOf(str2));
            }
            Toast.makeText(ah.getContext(), concat, 0).show();
            AppMethodBeat.o(130141);
            return;
        }
        try {
            ab.i("MicroMsg.MBLoadDelegateRegistery", "loadLibrary libName:%s", str);
            k.a(str, c.class.getClassLoader());
            AppMethodBeat.o(130141);
        } catch (UnsatisfiedLinkError e2) {
            ab.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e2, "hy: link %s error!!", str);
            com.tencent.mm.plugin.appbrand.game.g.b.cH(ah.getContext());
            AppMethodBeat.o(130141);
        }
    }
}
