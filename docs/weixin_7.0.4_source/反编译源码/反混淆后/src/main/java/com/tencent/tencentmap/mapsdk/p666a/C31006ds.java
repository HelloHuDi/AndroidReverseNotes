package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.ds */
public class C31006ds {
    /* renamed from: c */
    private static C31006ds f14019c;
    /* renamed from: a */
    private C24348dr f14020a = new C41021dv();
    /* renamed from: b */
    private boolean f14021b = false;

    /* renamed from: a */
    public static synchronized C31006ds m49791a() {
        C31006ds c31006ds;
        synchronized (C31006ds.class) {
            AppMethodBeat.m2504i(101104);
            if (f14019c == null) {
                f14019c = new C31006ds();
            }
            c31006ds = f14019c;
            AppMethodBeat.m2505o(101104);
        }
        return c31006ds;
    }

    private C31006ds() {
        AppMethodBeat.m2504i(101105);
        AppMethodBeat.m2505o(101105);
    }

    /* renamed from: a */
    public void mo50284a(Context context) {
        AppMethodBeat.m2504i(101106);
        if (this.f14021b) {
            AppMethodBeat.m2505o(101106);
            return;
        }
        if (this.f14020a != null) {
            this.f14020a.mo40490a(context.getApplicationContext());
            this.f14021b = true;
        }
        AppMethodBeat.m2505o(101106);
    }

    /* renamed from: a */
    public C16193dt mo50281a(String str) {
        AppMethodBeat.m2504i(101107);
        if (this.f14020a == null) {
            AppMethodBeat.m2505o(101107);
            return null;
        }
        C16193dt a = this.f14020a.mo40487a(str);
        AppMethodBeat.m2505o(101107);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo50282a(String str, String str2) {
        AppMethodBeat.m2504i(101108);
        if (this.f14020a == null) {
            AppMethodBeat.m2505o(101108);
            return null;
        }
        C16193dt a = this.f14020a.mo40488a(str, str2);
        AppMethodBeat.m2505o(101108);
        return a;
    }

    /* renamed from: a */
    public C16193dt mo50283a(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(101109);
        if (this.f14020a == null) {
            AppMethodBeat.m2505o(101109);
            return null;
        }
        C16193dt a = this.f14020a.mo40489a(str, str2, bArr);
        AppMethodBeat.m2505o(101109);
        return a;
    }
}
