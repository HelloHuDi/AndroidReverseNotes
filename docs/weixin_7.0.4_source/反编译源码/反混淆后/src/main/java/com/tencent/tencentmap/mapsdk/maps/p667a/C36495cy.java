package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.tencentmap.mapsdk.maps.p667a.C41042de.C36497a;
import java.util.HashMap;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.cy */
public final class C36495cy extends C41042de {
    /* renamed from: a */
    public final boolean mo57717a(byte[] bArr, int i, boolean z, Object obj, C36497a c36497a, int i2) {
        AppMethodBeat.m2504i(98685);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f16466b = c36497a;
        this.f16465a = obj;
        HashMap hashMap = new HashMap();
        hashMap.put("B-Length", String.valueOf(i));
        String str = "HLReportCmd";
        Object obj2 = i2 == 1 ? "devlog" : z ? "realtime_speed" : "hllog";
        hashMap.put(str, obj2);
        C16216cs a = C16216cs.m24720a("https://up-hl.3g.qq.com/upreport", false, hashMap, bArr, C1625i.sHCENCODEVIDEOTIMEOUT, C24373eu.m37745d(), false, null);
        a.f3194p = false;
        a.mo29270a("event");
        try {
            C41037ch.m71366a().mo65126b().execute(new C41040cz(this, a, elapsedRealtime));
            AppMethodBeat.m2505o(98685);
            return true;
        } catch (Throwable th) {
            this.f16466b.mo57719a(false, this.f16465a);
            AppMethodBeat.m2505o(98685);
            return false;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m60375a(C36495cy c36495cy, boolean z) {
        AppMethodBeat.m2504i(98686);
        c36495cy.f16466b.mo57719a(z, c36495cy.f16465a);
        AppMethodBeat.m2505o(98686);
        return z;
    }
}
