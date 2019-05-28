package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ab */
public final class C36482ab extends C41029ak {
    /* renamed from: j */
    private static byte[] f15256j;
    /* renamed from: a */
    public byte f15257a = (byte) 0;
    /* renamed from: b */
    public int f15258b = 0;
    /* renamed from: c */
    public byte[] f15259c = null;
    /* renamed from: d */
    public String f15260d = "";
    /* renamed from: e */
    public long f15261e = 0;
    /* renamed from: f */
    private byte f15262f = (byte) 0;
    /* renamed from: g */
    private byte f15263g = (byte) 0;
    /* renamed from: h */
    private String f15264h = "";
    /* renamed from: i */
    private String f15265i = "";

    /* renamed from: a */
    public final void mo12388a(C46767aj c46767aj) {
        AppMethodBeat.m2504i(98406);
        c46767aj.mo75325a(this.f15257a, 0);
        c46767aj.mo75326a(this.f15258b, 1);
        c46767aj.mo75334a(this.f15259c, 2);
        c46767aj.mo75329a(this.f15260d, 3);
        c46767aj.mo75325a(this.f15262f, 4);
        c46767aj.mo75325a(this.f15263g, 5);
        c46767aj.mo75327a(this.f15261e, 6);
        if (this.f15264h != null) {
            c46767aj.mo75329a(this.f15264h, 7);
        }
        if (this.f15265i != null) {
            c46767aj.mo75329a(this.f15265i, 8);
        }
        AppMethodBeat.m2505o(98406);
    }

    /* renamed from: a */
    public final void mo12387a(C41028ai c41028ai) {
        AppMethodBeat.m2504i(98407);
        this.f15257a = c41028ai.mo65100a(this.f15257a, 0, true);
        this.f15258b = c41028ai.mo65101a(this.f15258b, 1, true);
        if (f15256j == null) {
            byte[] bArr = new byte[1];
            f15256j = bArr;
            bArr[0] = (byte) 0;
        }
        this.f15259c = c41028ai.mo65109b(2, true);
        this.f15260d = c41028ai.mo65105a(3, true);
        this.f15262f = c41028ai.mo65100a(this.f15262f, 4, true);
        this.f15263g = c41028ai.mo65100a(this.f15263g, 5, true);
        this.f15261e = c41028ai.mo65103a(this.f15261e, 6, true);
        this.f15264h = c41028ai.mo65105a(7, false);
        this.f15265i = c41028ai.mo65105a(8, false);
        AppMethodBeat.m2505o(98407);
    }
}
