package com.tencent.tencentmap.mapsdk.p666a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36517hl;
import java.util.Arrays;

/* renamed from: com.tencent.tencentmap.mapsdk.a.bg */
public class C36459bg {
    /* renamed from: a */
    private int f15210a;
    /* renamed from: b */
    private int f15211b;
    /* renamed from: c */
    private int f15212c;
    /* renamed from: d */
    private byte[] f15213d = new byte[4];

    public C36459bg() {
        AppMethodBeat.m2504i(100786);
        AppMethodBeat.m2505o(100786);
    }

    /* renamed from: a */
    public int mo57659a() {
        return this.f15210a;
    }

    /* renamed from: b */
    public int mo57661b() {
        return this.f15211b;
    }

    /* renamed from: c */
    public int mo57662c() {
        return this.f15212c;
    }

    /* renamed from: a */
    public void mo57660a(byte[] bArr) {
        AppMethodBeat.m2504i(100787);
        Arrays.fill(this.f15213d, (byte) 0);
        System.arraycopy(bArr, 0, this.f15213d, 0, 4);
        this.f15210a = C36517hl.m60436a(this.f15213d);
        System.arraycopy(bArr, 4, this.f15213d, 0, 4);
        this.f15211b = C36517hl.m60436a(this.f15213d);
        System.arraycopy(bArr, 8, this.f15213d, 0, 4);
        this.f15212c = C36517hl.m60436a(this.f15213d);
        AppMethodBeat.m2505o(100787);
    }
}
