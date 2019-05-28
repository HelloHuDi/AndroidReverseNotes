package com.tencent.p177mm.plugin.appbrand.game.p293c;

import android.widget.Toast;
import com.tencent.magicbrush.p1173a.C45128b;
import com.tencent.magicbrush.p1173a.C45128b.C37410a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.plugin.appbrand.game.p291a.C10229e;
import com.tencent.p177mm.plugin.appbrand.game.p895g.C26892b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.udp.libmmudp.C44232a;
import com.tencent.p177mm.udp.libmmudp.C44232a.C15451a;
import com.tencent.util.C5989g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.game.c.c */
public class C19232c {
    private static boolean hru = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.c$2 */
    static class C192312 implements C15451a {
        C192312() {
        }

        public final void loadLibrary(String str) {
            AppMethodBeat.m2504i(130138);
            try {
                C4990ab.m7417i("MicroMsg.MBLoadDelegateRegistery", "loadLibrary libName:%s", str);
                C1449k.m3079a(str, C19232c.class.getClassLoader());
                AppMethodBeat.m2505o(130138);
            } catch (UnsatisfiedLinkError e) {
                C4990ab.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e, "hy: link %s error!!", str);
                C26892b.m42829cH(C4996ah.getContext());
                AppMethodBeat.m2505o(130138);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.c$1 */
    static class C192331 implements C37410a {
        C192331() {
        }

        public final void loadLibrary(String str) {
            AppMethodBeat.m2504i(130137);
            C19232c.m29890jJ(str);
            AppMethodBeat.m2505o(130137);
        }
    }

    public static void axy() {
        AppMethodBeat.m2504i(130139);
        C45128b.m82947a(new C192331());
        C44232a.m79827a(new C192312());
        AppMethodBeat.m2505o(130139);
    }

    /* renamed from: bT */
    private static File m29889bT(String str, String str2) {
        InputStream bufferedInputStream;
        OutputStream bufferedOutputStream;
        Throwable th;
        AppMethodBeat.m2504i(130140);
        File dir = C4996ah.getContext().getDir("magicbrush", 0);
        if (dir.exists() || dir.mkdirs()) {
            File file = new File(dir, str);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str2));
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = null;
                    C5989g.closeQuietly(bufferedInputStream);
                    C5989g.closeQuietly(bufferedOutputStream);
                    AppMethodBeat.m2505o(130140);
                    throw th;
                }
                try {
                    C5989g.copy(bufferedInputStream, bufferedOutputStream);
                    C5989g.closeQuietly(bufferedInputStream);
                    C5989g.closeQuietly(bufferedOutputStream);
                    AppMethodBeat.m2505o(130140);
                    return file;
                } catch (Throwable th3) {
                    th = th3;
                    C5989g.closeQuietly(bufferedInputStream);
                    C5989g.closeQuietly(bufferedOutputStream);
                    AppMethodBeat.m2505o(130140);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
                C5989g.closeQuietly(bufferedInputStream);
                C5989g.closeQuietly(bufferedOutputStream);
                AppMethodBeat.m2505o(130140);
                throw th;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        AppMethodBeat.m2505o(130140);
        throw illegalStateException;
    }

    /* renamed from: jJ */
    static /* synthetic */ void m29890jJ(String str) {
        AppMethodBeat.m2504i(130141);
        if ((C5058f.IS_FLAVOR_RED || C5058f.DEBUG || C5047bp.dpL()) && "magicbrush".equals(str) && ((Boolean) C10229e.m17879Aq("localso").mo21639Uw()).booleanValue()) {
            String str2 = "magicbrush";
            if (hru) {
                C4990ab.m7417i("MicroMsg.MBLoadDelegateRegistery", "load custom local so libName: %s, skip", str2);
                AppMethodBeat.m2505o(130141);
                return;
            }
            int i;
            CharSequence concat;
            hru = true;
            try {
                C4990ab.m7417i("MicroMsg.MBLoadDelegateRegistery", "load custom local so libName: %s", str2);
                String str3 = "lib" + str2 + ".so";
                System.load(C19232c.m29889bT(str3, "/sdcard/magicbrush/".concat(String.valueOf(str3))).getAbsolutePath());
                i = 1;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e, "load local so failed", new Object[0]);
                i = 0;
            }
            if (i != 0) {
                concat = "local so succeed: ".concat(String.valueOf(str2));
            } else {
                concat = "local so failed: ".concat(String.valueOf(str2));
            }
            Toast.makeText(C4996ah.getContext(), concat, 0).show();
            AppMethodBeat.m2505o(130141);
            return;
        }
        try {
            C4990ab.m7417i("MicroMsg.MBLoadDelegateRegistery", "loadLibrary libName:%s", str);
            C1449k.m3079a(str, C19232c.class.getClassLoader());
            AppMethodBeat.m2505o(130141);
        } catch (UnsatisfiedLinkError e2) {
            C4990ab.printErrStackTrace("MicroMsg.MBLoadDelegateRegistery", e2, "hy: link %s error!!", str);
            C26892b.m42829cH(C4996ah.getContext());
            AppMethodBeat.m2505o(130141);
        }
    }
}
