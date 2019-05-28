package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.z */
public final class C24422z extends C41029ak implements Cloneable {
    /* renamed from: b */
    private static Map<Integer, byte[]> f4878b;
    /* renamed from: a */
    public Map<Integer, byte[]> f4879a = null;

    /* renamed from: a */
    public final void mo12388a(C46767aj c46767aj) {
        AppMethodBeat.m2504i(100571);
        c46767aj.mo75331a(this.f4879a, 0);
        AppMethodBeat.m2505o(100571);
    }

    /* renamed from: a */
    public final void mo12387a(C41028ai c41028ai) {
        AppMethodBeat.m2504i(100572);
        if (f4878b == null) {
            f4878b = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            byte[] bArr = new byte[1];
            bArr[0] = (byte) 0;
            f4878b.put(valueOf, bArr);
        }
        this.f4879a = (Map) c41028ai.mo65104a(f4878b, 0, true);
        AppMethodBeat.m2505o(100572);
    }
}
