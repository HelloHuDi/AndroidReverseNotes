package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.appbrand.jsapi.b.l;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public final class b extends d {
    private static b jtb;
    private d jtc;
    private c jtd;
    private a jte;
    private a jtf;
    String jtg = "tickit";
    private WakeLock wakeLock = null;

    public static b aSZ() {
        b bVar;
        AppMethodBeat.i(17238);
        if (jtb == null) {
            bVar = new b();
            jtb = bVar;
            com.tencent.mm.plugin.backup.b.a.a(bVar);
        }
        bVar = jtb;
        AppMethodBeat.o(17238);
        return bVar;
    }

    public final void aSp() {
        jtb = null;
    }

    public final void m(Object... objArr) {
        AppMethodBeat.i(17239);
        final String str = (String) objArr[0];
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17235);
                c aTc = b.aSZ().aTc();
                ab.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", str);
                com.tencent.mm.plugin.backup.g.b.aTZ();
                aw.Rg().a((int) l.CTRL_INDEX, aTc.jtG);
                aw.Rg().a(new e(r1), 0);
                AppMethodBeat.o(17235);
            }
        });
        AppMethodBeat.o(17239);
    }

    public final a aTa() {
        AppMethodBeat.i(17240);
        if (this.jtf == null) {
            this.jtf = new a();
        }
        a aVar = this.jtf;
        AppMethodBeat.o(17240);
        return aVar;
    }

    public final d aTb() {
        AppMethodBeat.i(17241);
        if (this.jtc == null) {
            this.jtc = new d();
        }
        d dVar = this.jtc;
        AppMethodBeat.o(17241);
        return dVar;
    }

    public final c aTc() {
        AppMethodBeat.i(17242);
        if (this.jtd == null) {
            this.jtd = new c();
        }
        c cVar = this.jtd;
        AppMethodBeat.o(17242);
        return cVar;
    }

    public final a aTd() {
        AppMethodBeat.i(17243);
        if (this.jte == null) {
            this.jte = new a();
        }
        a aVar = this.jte;
        AppMethodBeat.o(17243);
        return aVar;
    }

    public final void aSv() {
        AppMethodBeat.i(17244);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17236);
                try {
                    if (b.this.wakeLock == null) {
                        b.this.wakeLock = ((PowerManager) ah.getContext().getSystemService("power")).newWakeLock(26, "BackupMove Lock");
                    }
                    if (!b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.acquire();
                    }
                    AppMethodBeat.o(17236);
                } catch (Throwable th) {
                    AppMethodBeat.o(17236);
                }
            }
        });
        AppMethodBeat.o(17244);
    }

    public final void aSw() {
        AppMethodBeat.i(17245);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17237);
                try {
                    if (b.this.wakeLock != null && b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.release();
                    }
                    AppMethodBeat.o(17237);
                } catch (Throwable th) {
                    AppMethodBeat.o(17237);
                }
            }
        });
        AppMethodBeat.o(17245);
    }
}
