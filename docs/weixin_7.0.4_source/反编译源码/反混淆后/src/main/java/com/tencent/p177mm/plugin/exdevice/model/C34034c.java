package com.tencent.p177mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.exdevice.model.C2971d.C29841;
import com.tencent.p177mm.plugin.exdevice.p957i.C42990d;
import com.tencent.p177mm.plugin.exdevice.service.C27865m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.exdevice.model.c */
public final class C34034c implements C42990d {
    private static C34034c lqW;
    private byte[] ecf = new byte[0];
    private C5004al fPG = new C5004al("ExdeviceHandlerThread");
    private final Map<Integer, Set<C42990d>> ftE = new HashMap();
    public C27865m lqX;
    C34035a lqY = new C29841();
    Vector<C38950ae> lqZ = new Vector();

    /* renamed from: com.tencent.mm.plugin.exdevice.model.c$1 */
    class C204821 implements C5015a {
        private long ftP = 10;

        C204821() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(19090);
            if (C34034c.this.lqX == null) {
                long j = this.ftP;
                this.ftP = j - 1;
                if (j > 0) {
                    AppMethodBeat.m2505o(19090);
                    return true;
                }
            }
            C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", Long.valueOf(this.ftP));
            if (this.ftP > 0) {
                C34034c.this.boC();
            }
            AppMethodBeat.m2505o(19090);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.exdevice.model.c$a */
    public interface C34035a {
        void boD();
    }

    public C34034c() {
        AppMethodBeat.m2504i(19092);
        AppMethodBeat.m2505o(19092);
    }

    /* renamed from: a */
    public final boolean mo54568a(final C38950ae c38950ae) {
        AppMethodBeat.m2504i(19093);
        this.fPG.mo10302aa(new Runnable() {
            public final void run() {
                boolean z = true;
                AppMethodBeat.m2504i(19091);
                C34034c c34034c = C34034c.this;
                C38950ae c38950ae = c38950ae;
                if (c34034c.lqX == null) {
                    C4990ab.m7420w("MicroMsg.exdevice.ExDeviceTaskService", "dispathcer is null, now try to reset it");
                    if (c34034c.lqY != null) {
                        C4990ab.m7416i("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is not null. not prepare it");
                        c34034c.lqY.boD();
                        new C7564ap(Looper.getMainLooper(), new C204821(), true).mo16770ae(100, 100);
                    } else {
                        C4990ab.m7412e("MicroMsg.exdevice.ExDeviceTaskService", "prepare dispatcher is null");
                    }
                    z = false;
                }
                if (z) {
                    c38950ae.mo23404a(c34034c.lqX, c34034c);
                    AppMethodBeat.m2505o(19091);
                    return;
                }
                c34034c.lqZ.add(c38950ae);
                AppMethodBeat.m2505o(19091);
            }
        });
        AppMethodBeat.m2505o(19093);
        return true;
    }

    public static C34034c boB() {
        AppMethodBeat.m2504i(19094);
        if (lqW == null) {
            lqW = new C34034c();
        }
        C34034c c34034c = lqW;
        AppMethodBeat.m2505o(19094);
        return c34034c;
    }

    /* Access modifiers changed, original: final */
    public final void boC() {
        AppMethodBeat.m2504i(19095);
        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", Integer.valueOf(this.lqZ.size()));
        if (!this.lqZ.isEmpty()) {
            mo54568a((C38950ae) this.lqZ.remove(0));
        }
        AppMethodBeat.m2505o(19095);
    }

    /* renamed from: a */
    public final void mo54567a(long j, int i, int i2, String str) {
        AppMethodBeat.m2504i(19096);
        C4990ab.m7417i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(this.lqZ.size()));
        synchronized (this.ecf) {
            try {
                boC();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(19096);
            }
        }
    }
}
