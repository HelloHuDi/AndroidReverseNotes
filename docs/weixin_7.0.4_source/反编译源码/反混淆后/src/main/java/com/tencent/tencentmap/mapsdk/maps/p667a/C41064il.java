package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C16193dt;
import com.tencent.tencentmap.mapsdk.p666a.C31006ds;
import navsns.RttResponse;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.il */
public class C41064il extends C24386hf {
    /* renamed from: a */
    private static C41064il f16512a;

    /* renamed from: a */
    public static synchronized C41064il m71422a() {
        C41064il c41064il;
        synchronized (C41064il.class) {
            AppMethodBeat.m2504i(99849);
            if (f16512a == null) {
                f16512a = new C41064il();
            }
            c41064il = f16512a;
            AppMethodBeat.m2505o(99849);
        }
        return c41064il;
    }

    /* renamed from: a */
    public byte[] mo40647a(byte[] bArr) {
        byte[] bArr2 = null;
        AppMethodBeat.m2504i(99850);
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    bArr2 = m71424a(m71423a(mo65151b(), bArr));
                    AppMethodBeat.m2505o(99850);
                    return bArr2;
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(99850);
            }
        }
        AppMethodBeat.m2505o(99850);
        return bArr2;
    }

    /* renamed from: a */
    private RttResponse m71423a(String str, byte[] bArr) {
        AppMethodBeat.m2504i(99851);
        for (int i = 0; i < 3; i++) {
            try {
                C16193dt a = C31006ds.m49791a().mo50283a(str, "sosomap navsns", bArr);
                if (!(a == null || a.f3096a == null)) {
                    C36893e c36893e = new C36893e();
                    c36893e.mo40541a("UTF-8");
                    c36893e.mo40543a(a.f3096a);
                    RttResponse rttResponse = (RttResponse) c36893e.mo57718b("res");
                    AppMethodBeat.m2505o(99851);
                    return rttResponse;
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(99851);
        return null;
    }

    /* renamed from: a */
    private byte[] m71424a(RttResponse rttResponse) {
        if (rttResponse == null) {
            return null;
        }
        return rttResponse.result;
    }

    /* renamed from: b */
    public String mo65151b() {
        return "https://tafrtt.map.qq.com/rttserverex/";
    }
}
