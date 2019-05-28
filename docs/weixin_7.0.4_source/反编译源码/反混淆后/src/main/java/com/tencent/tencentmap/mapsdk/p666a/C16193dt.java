package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.dt */
public class C16193dt {
    /* renamed from: a */
    public byte[] f3096a;
    /* renamed from: b */
    public String f3097b = "GBK";

    public String toString() {
        AppMethodBeat.m2504i(101110);
        String str;
        try {
            str = new String(this.f3096a, this.f3097b);
            AppMethodBeat.m2505o(101110);
            return str;
        } catch (Exception e) {
            str = "";
            AppMethodBeat.m2505o(101110);
            return str;
        }
    }
}
