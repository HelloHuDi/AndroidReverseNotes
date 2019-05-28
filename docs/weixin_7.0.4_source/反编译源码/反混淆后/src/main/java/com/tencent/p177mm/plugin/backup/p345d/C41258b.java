package com.tencent.p177mm.plugin.backup.p345d;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19320l;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p344c.C33682a;
import com.tencent.p177mm.plugin.backup.p920g.C19978b;
import com.tencent.p177mm.plugin.backup.p920g.C42773e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.backup.d.b */
public final class C41258b extends C38634d {
    private static C41258b jtb;
    private C6793d jtc;
    private C33697c jtd;
    private C45743a jte;
    private C33682a jtf;
    String jtg = "tickit";
    private WakeLock wakeLock = null;

    /* renamed from: com.tencent.mm.plugin.backup.d.b$2 */
    class C336932 implements Runnable {
        C336932() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17236);
            try {
                if (C41258b.this.wakeLock == null) {
                    C41258b.this.wakeLock = ((PowerManager) C4996ah.getContext().getSystemService("power")).newWakeLock(26, "BackupMove Lock");
                }
                if (!C41258b.this.wakeLock.isHeld()) {
                    C41258b.this.wakeLock.acquire();
                }
                AppMethodBeat.m2505o(17236);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(17236);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.d.b$3 */
    class C336943 implements Runnable {
        C336943() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17237);
            try {
                if (C41258b.this.wakeLock != null && C41258b.this.wakeLock.isHeld()) {
                    C41258b.this.wakeLock.release();
                }
                AppMethodBeat.m2505o(17237);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(17237);
            }
        }
    }

    public static C41258b aSZ() {
        C41258b c41258b;
        AppMethodBeat.m2504i(17238);
        if (jtb == null) {
            c41258b = new C41258b();
            jtb = c41258b;
            C33660a.m54968a(c41258b);
        }
        c41258b = jtb;
        AppMethodBeat.m2505o(17238);
        return c41258b;
    }

    public final void aSp() {
        jtb = null;
    }

    /* renamed from: m */
    public final void mo61481m(Object... objArr) {
        AppMethodBeat.m2504i(17239);
        final String str = (String) objArr[0];
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(17235);
                C33697c aTc = C41258b.aSZ().aTc();
                C4990ab.m7421w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", str);
                C19978b.aTZ();
                C9638aw.m17182Rg().mo14539a((int) C19320l.CTRL_INDEX, aTc.jtG);
                C9638aw.m17182Rg().mo14541a(new C42773e(r1), 0);
                AppMethodBeat.m2505o(17235);
            }
        });
        AppMethodBeat.m2505o(17239);
    }

    public final C33682a aTa() {
        AppMethodBeat.m2504i(17240);
        if (this.jtf == null) {
            this.jtf = new C33682a();
        }
        C33682a c33682a = this.jtf;
        AppMethodBeat.m2505o(17240);
        return c33682a;
    }

    public final C6793d aTb() {
        AppMethodBeat.m2504i(17241);
        if (this.jtc == null) {
            this.jtc = new C6793d();
        }
        C6793d c6793d = this.jtc;
        AppMethodBeat.m2505o(17241);
        return c6793d;
    }

    public final C33697c aTc() {
        AppMethodBeat.m2504i(17242);
        if (this.jtd == null) {
            this.jtd = new C33697c();
        }
        C33697c c33697c = this.jtd;
        AppMethodBeat.m2505o(17242);
        return c33697c;
    }

    public final C45743a aTd() {
        AppMethodBeat.m2504i(17243);
        if (this.jte == null) {
            this.jte = new C45743a();
        }
        C45743a c45743a = this.jte;
        AppMethodBeat.m2505o(17243);
        return c45743a;
    }

    public final void aSv() {
        AppMethodBeat.m2504i(17244);
        C5004al.m7441d(new C336932());
        AppMethodBeat.m2505o(17244);
    }

    public final void aSw() {
        AppMethodBeat.m2504i(17245);
        C5004al.m7441d(new C336943());
        AppMethodBeat.m2505o(17245);
    }
}
