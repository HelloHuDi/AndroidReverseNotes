package com.tencent.p177mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.backuppcmodel.C45736c.C457345;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.p177mm.plugin.backup.p342b.C38634d;
import com.tencent.p177mm.plugin.backup.p344c.C33682a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.b */
public final class C42759b extends C38634d {
    private static C42759b jvU;
    private C33682a jtf;
    private C45736c jvV;
    private C42760e jvW;
    private C41256d jvX;
    private C19955a jvY;
    private WakeLock wakeLock = null;

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.b$2 */
    class C274492 implements Runnable {
        C274492() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17489);
            try {
                if (C42759b.this.wakeLock != null && C42759b.this.wakeLock.isHeld()) {
                    C42759b.this.wakeLock.release();
                }
                AppMethodBeat.m2505o(17489);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(17489);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.backuppcmodel.b$1 */
    class C386371 implements Runnable {
        C386371() {
        }

        public final void run() {
            AppMethodBeat.m2504i(17488);
            try {
                if (C42759b.this.wakeLock == null) {
                    C42759b.this.wakeLock = ((PowerManager) C4996ah.getContext().getSystemService("power")).newWakeLock(26, "BackupPc Lock");
                }
                if (!C42759b.this.wakeLock.isHeld()) {
                    C42759b.this.wakeLock.acquire();
                }
                AppMethodBeat.m2505o(17488);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(17488);
            }
        }
    }

    public static C42759b aTD() {
        C42759b c42759b;
        AppMethodBeat.m2504i(17490);
        if (jvU == null) {
            c42759b = new C42759b();
            jvU = c42759b;
            C33660a.m54968a(c42759b);
        }
        c42759b = jvU;
        AppMethodBeat.m2505o(17490);
        return c42759b;
    }

    public final void aSp() {
        jvU = null;
    }

    /* renamed from: m */
    public final void mo61481m(Object... objArr) {
        AppMethodBeat.m2504i(17491);
        ((Boolean) objArr[0]).booleanValue();
        new C7306ak(Looper.getMainLooper()).postDelayed(new C457345(), 100);
        AppMethodBeat.m2505o(17491);
    }

    public final C33682a aTa() {
        AppMethodBeat.m2504i(17492);
        if (this.jtf == null) {
            this.jtf = new C33682a();
        }
        C33682a c33682a = this.jtf;
        AppMethodBeat.m2505o(17492);
        return c33682a;
    }

    public final C45736c aTE() {
        AppMethodBeat.m2504i(17493);
        if (this.jvV == null) {
            this.jvV = new C45736c();
        }
        C45736c c45736c = this.jvV;
        AppMethodBeat.m2505o(17493);
        return c45736c;
    }

    public final C42760e aTF() {
        AppMethodBeat.m2504i(17494);
        if (this.jvW == null) {
            this.jvW = new C42760e();
        }
        C42760e c42760e = this.jvW;
        AppMethodBeat.m2505o(17494);
        return c42760e;
    }

    public final C41256d aTG() {
        AppMethodBeat.m2504i(17495);
        if (this.jvX == null) {
            this.jvX = new C41256d();
        }
        C41256d c41256d = this.jvX;
        AppMethodBeat.m2505o(17495);
        return c41256d;
    }

    public final C19955a aTH() {
        AppMethodBeat.m2504i(17496);
        if (this.jvY == null) {
            this.jvY = new C19955a();
        }
        C19955a c19955a = this.jvY;
        AppMethodBeat.m2505o(17496);
        return c19955a;
    }

    public final void aSv() {
        AppMethodBeat.m2504i(17497);
        C5004al.m7441d(new C386371());
        AppMethodBeat.m2505o(17497);
    }

    public final void aSw() {
        AppMethodBeat.m2504i(17498);
        C5004al.m7441d(new C274492());
        AppMethodBeat.m2505o(17498);
    }
}
