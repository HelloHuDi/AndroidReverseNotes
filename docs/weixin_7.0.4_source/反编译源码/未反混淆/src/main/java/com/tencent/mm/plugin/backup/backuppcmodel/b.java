package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;

public final class b extends d {
    private static b jvU;
    private a jtf;
    private c jvV;
    private e jvW;
    private d jvX;
    private a jvY;
    private WakeLock wakeLock = null;

    public static b aTD() {
        b bVar;
        AppMethodBeat.i(17490);
        if (jvU == null) {
            bVar = new b();
            jvU = bVar;
            com.tencent.mm.plugin.backup.b.a.a(bVar);
        }
        bVar = jvU;
        AppMethodBeat.o(17490);
        return bVar;
    }

    public final void aSp() {
        jvU = null;
    }

    public final void m(Object... objArr) {
        AppMethodBeat.i(17491);
        ((Boolean) objArr[0]).booleanValue();
        new ak(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17503);
                b.aTD().aTa().stop();
                b.aTD().aSw();
                b.aTV();
                b.aTX();
                AppMethodBeat.o(17503);
            }
        }, 100);
        AppMethodBeat.o(17491);
    }

    public final a aTa() {
        AppMethodBeat.i(17492);
        if (this.jtf == null) {
            this.jtf = new a();
        }
        a aVar = this.jtf;
        AppMethodBeat.o(17492);
        return aVar;
    }

    public final c aTE() {
        AppMethodBeat.i(17493);
        if (this.jvV == null) {
            this.jvV = new c();
        }
        c cVar = this.jvV;
        AppMethodBeat.o(17493);
        return cVar;
    }

    public final e aTF() {
        AppMethodBeat.i(17494);
        if (this.jvW == null) {
            this.jvW = new e();
        }
        e eVar = this.jvW;
        AppMethodBeat.o(17494);
        return eVar;
    }

    public final d aTG() {
        AppMethodBeat.i(17495);
        if (this.jvX == null) {
            this.jvX = new d();
        }
        d dVar = this.jvX;
        AppMethodBeat.o(17495);
        return dVar;
    }

    public final a aTH() {
        AppMethodBeat.i(17496);
        if (this.jvY == null) {
            this.jvY = new a();
        }
        a aVar = this.jvY;
        AppMethodBeat.o(17496);
        return aVar;
    }

    public final void aSv() {
        AppMethodBeat.i(17497);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17488);
                try {
                    if (b.this.wakeLock == null) {
                        b.this.wakeLock = ((PowerManager) ah.getContext().getSystemService("power")).newWakeLock(26, "BackupPc Lock");
                    }
                    if (!b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.acquire();
                    }
                    AppMethodBeat.o(17488);
                } catch (Throwable th) {
                    AppMethodBeat.o(17488);
                }
            }
        });
        AppMethodBeat.o(17497);
    }

    public final void aSw() {
        AppMethodBeat.i(17498);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17489);
                try {
                    if (b.this.wakeLock != null && b.this.wakeLock.isHeld()) {
                        b.this.wakeLock.release();
                    }
                    AppMethodBeat.o(17489);
                } catch (Throwable th) {
                    AppMethodBeat.o(17489);
                }
            }
        });
        AppMethodBeat.o(17498);
    }
}
