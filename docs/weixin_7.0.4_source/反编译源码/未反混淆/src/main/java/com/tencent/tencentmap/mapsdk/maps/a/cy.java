package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.tencentmap.mapsdk.maps.a.de.a;
import java.util.HashMap;

public final class cy extends de {
    public final boolean a(byte[] bArr, int i, boolean z, Object obj, a aVar, int i2) {
        AppMethodBeat.i(98685);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.b = aVar;
        this.a = obj;
        HashMap hashMap = new HashMap();
        hashMap.put("B-Length", String.valueOf(i));
        String str = "HLReportCmd";
        Object obj2 = i2 == 1 ? "devlog" : z ? "realtime_speed" : "hllog";
        hashMap.put(str, obj2);
        cs a = cs.a("https://up-hl.3g.qq.com/upreport", false, hashMap, bArr, i.sHCENCODEVIDEOTIMEOUT, eu.d(), false, null);
        a.p = false;
        a.a("event");
        try {
            ch.a().b().execute(new cz(this, a, elapsedRealtime));
            AppMethodBeat.o(98685);
            return true;
        } catch (Throwable th) {
            this.b.a(false, this.a);
            AppMethodBeat.o(98685);
            return false;
        }
    }

    static /* synthetic */ boolean a(cy cyVar, boolean z) {
        AppMethodBeat.i(98686);
        cyVar.b.a(z, cyVar.a);
        AppMethodBeat.o(98686);
        return z;
    }
}
