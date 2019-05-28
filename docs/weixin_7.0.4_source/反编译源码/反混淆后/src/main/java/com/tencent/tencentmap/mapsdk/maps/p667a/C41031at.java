package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.tencentmap.mapsdk.maps.p667a.C25008aw.C25010a;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import com.tencent.tencentmap.mapsdk.p666a.C41003a;
import com.tencent.tencentmap.mapsdk.p666a.C46752b;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.at */
public final class C41031at {
    /* renamed from: a */
    private C24356av f16435a;
    /* renamed from: b */
    private Context f16436b;
    /* renamed from: c */
    private int f16437c = C1625i.sHCENCODEVIDEOTIMEOUT;
    /* renamed from: d */
    private int f16438d = 0;
    /* renamed from: e */
    private Runnable f16439e = new C243541();

    /* renamed from: com.tencent.tencentmap.mapsdk.maps.a.at$1 */
    class C243541 implements Runnable {
        C243541() {
        }

        public final void run() {
            AppMethodBeat.m2504i(98506);
            try {
                C41031at.this.mo65111a();
                AppMethodBeat.m2505o(98506);
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                AppMethodBeat.m2505o(98506);
            }
        }
    }

    public C41031at(Context context) {
        AppMethodBeat.m2504i(98507);
        this.f16436b = context;
        HashMap hashMap = new HashMap(2);
        boolean g = C41003a.m71129g(this.f16436b);
        C24349e.m37573a(context);
        hashMap.put("A33", C24349e.m37614g(context));
        if (g) {
            hashMap.put("A66", "F");
        } else {
            hashMap.put("A66", "B");
        }
        hashMap.put("A68", C41003a.m71130h(this.f16436b));
        hashMap.put("A85", C41003a.f16326b ? "Y" : "N");
        this.f16435a = C24349e.m37576a(this.f16436b, "rqd_heartbeat", true, 0, 0, hashMap, false);
        AppMethodBeat.m2505o(98507);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo65111a() {
        AppMethodBeat.m2504i(98508);
        if (C24349e.m37621m(this.f16436b)) {
            C41033be f = C25011ax.m39275d().mo41925f();
            if (f != null) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(this.f16435a);
                f.mo65113a(new C25010a(this.f16436b, arrayList));
            }
            m71341a(m71342c() + 1);
            if (m71342c() % 10 == 0) {
                C46752b.m88622a().mo12297a(108, this.f16439e, 600000, (long) this.f16437c);
                m71341a(0);
            }
            AppMethodBeat.m2505o(98508);
            return;
        }
        AppMethodBeat.m2505o(98508);
    }

    /* renamed from: b */
    public final void mo65112b() {
        AppMethodBeat.m2504i(98509);
        if (C24349e.m37613g().equals(C41003a.m71119b(this.f16436b, "HEART_DENGTA", ""))) {
            C16205ag.m24683a("heartbeat has been uploaded today!", new Object[0]);
            AppMethodBeat.m2505o(98509);
            return;
        }
        C46752b.m88622a().mo12297a(108, this.f16439e, 0, (long) this.f16437c);
        AppMethodBeat.m2505o(98509);
    }

    /* renamed from: c */
    private synchronized int m71342c() {
        return this.f16438d;
    }

    /* renamed from: a */
    private synchronized void m71341a(int i) {
        this.f16438d = i;
    }
}
