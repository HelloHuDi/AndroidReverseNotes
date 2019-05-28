package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class ej implements Runnable {
    private /* synthetic */ ec a;

    ej(ec ecVar) {
        this.a = ecVar;
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
        AppMethodBeat.i(98789);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        a a;
        try {
            int i2;
            du duVar = new du();
            for (dy a2 : this.a.f.values()) {
                a2.a(duVar);
            }
            byte[] a3 = duVar.a();
            if (eu.a(a3)) {
                i2 = 0;
            } else {
                cs a4 = cs.a("https://yun-hl.3g.qq.com/halleycloud", false, null, a3, 15000, eu.d(), false, en.d().f());
                a4.a(ec.a);
                a4.a("platform");
                cv a5 = a4.a();
                int i3 = a5.a;
                try {
                    if (a5.a == 0 && a5.c == 200 && !eu.a(a5.d)) {
                        JSONObject jSONObject = new JSONObject(new String(a5.d));
                        ce.e();
                        for (dy a22 : this.a.f.values()) {
                            a22.a(jSONObject);
                        }
                    }
                } catch (Throwable th) {
                }
                a4.k = SystemClock.elapsedRealtime() - elapsedRealtime;
                a4.a(false);
                i2 = i3;
            }
            a = ec.a(this.a, ce.b());
            a.a = SystemClock.elapsedRealtime();
            a.b = i2;
            ec.e(this.a);
            this.a.e.removeCallbacks(this.a.i);
            AppMethodBeat.o(98789);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            a = ec.a(this.a, ce.b());
            a.a = SystemClock.elapsedRealtime();
            a.b = i;
            ec.e(this.a);
            this.a.e.removeCallbacks(this.a.i);
            AppMethodBeat.o(98789);
            throw th3;
        }
    }
}
