package com.tencent.liteav.beauty.p144b.p145a;

import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.a.c */
public class C37357c extends C8796g {
    /* renamed from: a */
    public boolean mo19876a() {
        AppMethodBeat.m2504i(66950);
        NativeLoad.getInstance();
        this.f2616a = NativeLoad.nativeLoadGLProgram(6);
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        boolean z = this.f2622g;
        AppMethodBeat.m2505o(66950);
        return z;
    }
}
