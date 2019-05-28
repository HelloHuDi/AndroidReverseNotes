package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C16517h;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.j */
public class C0960j {
    /* renamed from: i */
    private static String f1109i = "GPUGreenScreen";
    /* renamed from: a */
    private int f1110a;
    /* renamed from: b */
    private int f1111b;
    /* renamed from: c */
    private boolean f1112c;
    /* renamed from: d */
    private C17782u f1113d;
    /* renamed from: e */
    private boolean f1114e;
    /* renamed from: f */
    private C16517h f1115f;
    /* renamed from: g */
    private C32152e f1116g;
    /* renamed from: h */
    private boolean f1117h;

    /* renamed from: a */
    public int mo3849a(int i) {
        return i;
    }

    /* renamed from: b */
    private void m2176b() {
        AppMethodBeat.m2504i(67026);
        if (this.f1113d != null) {
            this.f1113d.mo32898a();
        }
        this.f1113d = null;
        this.f1114e = false;
        this.f1117h = false;
        AppMethodBeat.m2505o(67026);
    }

    /* renamed from: a */
    public void mo3850a() {
        AppMethodBeat.m2504i(67027);
        m2176b();
        m2177c();
        if (this.f1115f != null) {
            this.f1115f.mo19883d();
            this.f1115f = null;
        }
        if (this.f1116g != null) {
            this.f1116g.mo19883d();
            this.f1116g = null;
        }
        this.f1112c = false;
        AppMethodBeat.m2505o(67027);
    }

    /* renamed from: c */
    private void m2177c() {
        AppMethodBeat.m2504i(67028);
        if (!(this.f1111b == -1 || this.f1111b == this.f1110a)) {
            GLES20.glDeleteTextures(1, new int[]{this.f1111b}, 0);
            this.f1111b = -1;
        }
        if (this.f1110a != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.f1110a}, 0);
            this.f1110a = -1;
        }
        AppMethodBeat.m2505o(67028);
    }
}
