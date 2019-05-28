package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5868ec.C5869a;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ej */
final class C16220ej implements Runnable {
    /* renamed from: a */
    private /* synthetic */ C5868ec f3205a;

    C16220ej(C5868ec c5868ec) {
        this.f3205a = c5868ec;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0130 A:{Splitter:B:13:0x008e, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:34:0x0130, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:35:0x0131, code skipped:
            r8 = r1;
     */
    /* JADX WARNING: Missing block: B:37:0x0134, code skipped:
            r8 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        int i = 0;
        AppMethodBeat.m2504i(98789);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C5869a a;
        try {
            int i2;
            C41043du c41043du = new C41043du();
            for (C16219dy a2 : this.f3205a.f1583f.values()) {
                a2.mo12415a(c41043du);
            }
            byte[] a3 = c41043du.mo65132a();
            if (C24373eu.m37739a(a3)) {
                i2 = 0;
            } else {
                C16216cs a4 = C16216cs.m24720a("https://yun-hl.3g.qq.com/halleycloud", false, null, a3, 15000, C24373eu.m37745d(), false, C46780en.m88752d().mo75365f());
                a4.mo29269a(C5868ec.f1578a);
                a4.mo29270a("platform");
                C5862cv a5 = a4.mo12409a();
                int i3 = a5.f1540a;
                try {
                    if (a5.f1540a == 0 && a5.f1542c == 200 && !C24373eu.m37739a(a5.f1543d)) {
                        JSONObject jSONObject = new JSONObject(new String(a5.f1543d));
                        C31029ce.m49850e();
                        for (C16219dy a22 : this.f3205a.f1583f.values()) {
                            a22.mo12416a(jSONObject);
                        }
                    }
                } catch (Throwable th) {
                }
                a4.f15290k = SystemClock.elapsedRealtime() - elapsedRealtime;
                a4.mo12411a(false);
                i2 = i3;
            }
            a = C5868ec.m9037a(this.f3205a, C31029ce.m49847b());
            a.f1588a = SystemClock.elapsedRealtime();
            a.f1589b = i2;
            C5868ec.m9046e(this.f3205a);
            this.f3205a.f1582e.removeCallbacks(this.f3205a.f1586i);
            AppMethodBeat.m2505o(98789);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            a = C5868ec.m9037a(this.f3205a, C31029ce.m49847b());
            a.f1588a = SystemClock.elapsedRealtime();
            a.f1589b = i;
            C5868ec.m9046e(this.f3205a);
            this.f3205a.f1582e.removeCallbacks(this.f3205a.f1586i);
            AppMethodBeat.m2505o(98789);
            throw th3;
        }
    }
}
