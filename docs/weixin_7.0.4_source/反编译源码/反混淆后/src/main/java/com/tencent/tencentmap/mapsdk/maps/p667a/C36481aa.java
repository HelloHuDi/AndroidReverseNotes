package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.aa */
public final class C36481aa extends C41029ak {
    /* renamed from: m */
    private static byte[] f15243m;
    /* renamed from: a */
    public byte f15244a = (byte) 0;
    /* renamed from: b */
    public String f15245b = "";
    /* renamed from: c */
    public String f15246c = "";
    /* renamed from: d */
    public String f15247d = "";
    /* renamed from: e */
    public String f15248e = "";
    /* renamed from: f */
    public int f15249f = 0;
    /* renamed from: g */
    public byte[] f15250g = null;
    /* renamed from: h */
    public byte f15251h = (byte) 0;
    /* renamed from: i */
    public byte f15252i = (byte) 0;
    /* renamed from: j */
    public String f15253j = "";
    /* renamed from: k */
    public String f15254k = "";
    /* renamed from: l */
    public String f15255l = "";

    /* renamed from: a */
    public final void mo12388a(C46767aj c46767aj) {
        AppMethodBeat.m2504i(98404);
        c46767aj.mo75325a(this.f15244a, 0);
        c46767aj.mo75329a(this.f15245b, 1);
        c46767aj.mo75329a(this.f15246c, 2);
        c46767aj.mo75329a(this.f15247d, 3);
        c46767aj.mo75329a(this.f15248e, 4);
        c46767aj.mo75326a(this.f15249f, 5);
        c46767aj.mo75334a(this.f15250g, 6);
        c46767aj.mo75325a(this.f15251h, 7);
        c46767aj.mo75325a(this.f15252i, 8);
        if (this.f15253j != null) {
            c46767aj.mo75329a(this.f15253j, 9);
        }
        if (this.f15254k != null) {
            c46767aj.mo75329a(this.f15254k, 10);
        }
        if (this.f15255l != null) {
            c46767aj.mo75329a(this.f15255l, 11);
        }
        AppMethodBeat.m2505o(98404);
    }

    /* renamed from: a */
    public final void mo12387a(C41028ai c41028ai) {
        AppMethodBeat.m2504i(98405);
        this.f15244a = c41028ai.mo65100a(this.f15244a, 0, true);
        this.f15245b = c41028ai.mo65105a(1, true);
        this.f15246c = c41028ai.mo65105a(2, true);
        this.f15247d = c41028ai.mo65105a(3, true);
        this.f15248e = c41028ai.mo65105a(4, true);
        this.f15249f = c41028ai.mo65101a(this.f15249f, 5, true);
        if (f15243m == null) {
            byte[] bArr = new byte[1];
            f15243m = bArr;
            bArr[0] = (byte) 0;
        }
        this.f15250g = c41028ai.mo65109b(6, true);
        this.f15251h = c41028ai.mo65100a(this.f15251h, 7, true);
        this.f15252i = c41028ai.mo65100a(this.f15252i, 8, true);
        this.f15253j = c41028ai.mo65105a(9, false);
        this.f15254k = c41028ai.mo65105a(10, false);
        this.f15255l = c41028ai.mo65105a(11, false);
        AppMethodBeat.m2505o(98405);
    }
}
