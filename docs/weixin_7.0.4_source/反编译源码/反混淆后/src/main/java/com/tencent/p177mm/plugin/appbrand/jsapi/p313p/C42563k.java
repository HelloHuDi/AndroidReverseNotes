package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.p329s.C42678j;
import com.tencent.p177mm.plugin.appbrand.p329s.C42678j.C42679a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.k */
public final class C42563k {
    static int hVZ;
    private C42678j hVu;
    final List<C42467ah> hWa;
    Runnable hWb;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.k$1 */
    class C194671 implements Runnable {
        C194671() {
        }

        /* JADX WARNING: Missing block: B:9:0x002f, code skipped:
            r0.aCj();
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7419v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", r0.getName(), java.lang.Integer.valueOf(r2));
            r1 = r7.hWc.hWa;
     */
        /* JADX WARNING: Missing block: B:10:0x004f, code skipped:
            monitor-enter(r1);
     */
        /* JADX WARNING: Missing block: B:12:?, code skipped:
            r0 = r7.hWc.hWa.isEmpty();
     */
        /* JADX WARNING: Missing block: B:13:0x0058, code skipped:
            monitor-exit(r1);
     */
        /* JADX WARNING: Missing block: B:14:0x0059, code skipped:
            if (r0 != false) goto L_0x0065;
     */
        /* JADX WARNING: Missing block: B:15:0x005b, code skipped:
            com.tencent.p177mm.plugin.appbrand.p328r.C45673m.aNS().mo10310m(r7, (long) com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C42563k.hVZ);
     */
        /* JADX WARNING: Missing block: B:16:0x0065, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(126397);
     */
        /* JADX WARNING: Missing block: B:24:0x0071, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(126397);
     */
        /* JADX WARNING: Missing block: B:32:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            AppMethodBeat.m2504i(126397);
            synchronized (C42563k.this.hWa) {
                try {
                    if (C42563k.this.hWa.isEmpty()) {
                    } else {
                        C42467ah c42467ah = (C42467ah) C42563k.this.hWa.remove(0);
                        int size = C42563k.this.hWa.size();
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126397);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.k$2 */
    class C270632 implements C42679a {
        C270632() {
        }

        /* renamed from: j */
        public final boolean mo6217j(Object... objArr) {
            AppMethodBeat.m2504i(126398);
            synchronized (C42563k.this.hWa) {
                try {
                    if (!C42563k.this.hWa.isEmpty()) {
                        C42563k.this.hWb.run();
                        AppMethodBeat.m2505o(126398);
                        return true;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(126398);
                }
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.k$a */
    static class C38368a {
        static C42563k hWd = new C42563k();

        static {
            AppMethodBeat.m2504i(126399);
            AppMethodBeat.m2505o(126399);
        }
    }

    /* synthetic */ C42563k(byte b) {
        this();
    }

    private C42563k() {
        AppMethodBeat.m2504i(126400);
        this.hWa = new LinkedList();
        hVZ = C38367i.hVW.aEO();
        this.hWb = new C194671();
        this.hVu = new C42678j((long) hVZ, new C270632());
        AppMethodBeat.m2505o(126400);
    }

    /* renamed from: a */
    public final boolean mo68007a(C42467ah c42467ah, C2241c c2241c) {
        AppMethodBeat.m2504i(126401);
        if (c42467ah == null) {
            AppMethodBeat.m2505o(126401);
            return false;
        } else if (C38367i.hVW.mo53859a(c2241c, c42467ah)) {
            boolean isEmpty;
            synchronized (this.hWa) {
                try {
                    isEmpty = this.hWa.isEmpty();
                    if (this.hWa.isEmpty()) {
                        this.hWa.add(c42467ah);
                    } else if (((C42467ah) this.hWa.get(0)).equals(c42467ah)) {
                        this.hWa.add(0, c42467ah);
                        this.hWa.remove(1);
                    } else {
                        this.hWa.remove(c42467ah);
                        this.hWa.add(c42467ah);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(126401);
                }
            }
            if (isEmpty && !this.hVu.mo68088l(new Object[0])) {
                C4990ab.m7419v("MicroMsg.SensorJsEventPublisher", "post delay publish event(event : %s).", c42467ah.getName());
                C45673m.aNS().mo10310m(this.hWb, (long) hVZ);
            }
            AppMethodBeat.m2505o(126401);
            return true;
        } else {
            AppMethodBeat.m2505o(126401);
            return false;
        }
    }
}
