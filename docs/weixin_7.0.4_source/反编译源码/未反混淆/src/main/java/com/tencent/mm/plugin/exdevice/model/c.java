package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c implements d {
    private static c lqW;
    private byte[] ecf = new byte[0];
    private al fPG = new al("ExdeviceHandlerThread");
    private final Map<Integer, Set<d>> ftE = new HashMap();
    public m lqX;
    a lqY = new a() {
        public final void boD() {
            AppMethodBeat.i(19097);
            if (d.this.lrc == null) {
                d.this.lrc = new c();
                d.this.lrc.lwE = null;
            }
            d.this.lrc.dH(ah.getContext());
            AppMethodBeat.o(19097);
        }
    };
    Vector<ae> lqZ = new Vector();

    public interface a {
        void boD();
    }

    public c() {
        AppMethodBeat.i(19092);
        AppMethodBeat.o(19092);
    }

    public final boolean a(final ae aeVar) {
        AppMethodBeat.i(19093);
        this.fPG.aa(new Runnable() {
            public final void run() {
                boolean z = true;
                AppMethodBeat.i(19091);
                c cVar = c.this;
                ae aeVar = aeVar;
                if (cVar.lqX == null) {
                    ab.w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
                    if (cVar.lqY != null) {
                        ab.i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                        cVar.lqY.boD();
                        new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                            private long ftP = 10;

                            public final boolean BI() {
                                AppMethodBeat.i(19090);
                                if (c.this.lqX == null) {
                                    long j = this.ftP;
                                    this.ftP = j - 1;
                                    if (j > 0) {
                                        AppMethodBeat.o(19090);
                                        return true;
                                    }
                                }
                                ab.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", Long.valueOf(this.ftP));
                                if (this.ftP > 0) {
                                    c.this.boC();
                                }
                                AppMethodBeat.o(19090);
                                return false;
                            }
                        }, true).ae(100, 100);
                    } else {
                        ab.e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
                    }
                    z = false;
                }
                if (z) {
                    aeVar.a(cVar.lqX, cVar);
                    AppMethodBeat.o(19091);
                    return;
                }
                cVar.lqZ.add(aeVar);
                AppMethodBeat.o(19091);
            }
        });
        AppMethodBeat.o(19093);
        return true;
    }

    public static c boB() {
        AppMethodBeat.i(19094);
        if (lqW == null) {
            lqW = new c();
        }
        c cVar = lqW;
        AppMethodBeat.o(19094);
        return cVar;
    }

    /* Access modifiers changed, original: final */
    public final void boC() {
        AppMethodBeat.i(19095);
        ab.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", Integer.valueOf(this.lqZ.size()));
        if (!this.lqZ.isEmpty()) {
            a((ae) this.lqZ.remove(0));
        }
        AppMethodBeat.o(19095);
    }

    public final void a(long j, int i, int i2, String str) {
        AppMethodBeat.i(19096);
        ab.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(this.lqZ.size()));
        synchronized (this.ecf) {
            try {
                boC();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(19096);
            }
        }
    }
}
