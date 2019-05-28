package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.liteav.beauty.b.g */
public class C32154g extends C8796g {
    /* renamed from: r */
    protected List<C8796g> f14796r;
    /* renamed from: s */
    protected List<C8796g> f14797s;
    /* renamed from: t */
    private int[] f14798t;
    /* renamed from: u */
    private int[] f14799u;
    /* renamed from: v */
    private C8796g f14800v;

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66906);
        boolean b = super.mo3848b();
        if (b) {
            for (C8796g c8796g : this.f14796r) {
                c8796g.mo19876a();
                if (!c8796g.mo19891m()) {
                    break;
                }
            }
            b = this.f14800v.mo19876a();
        }
        if (b && GLES20.glGetError() == 0) {
            AppMethodBeat.m2505o(66906);
            return true;
        }
        AppMethodBeat.m2505o(66906);
        return false;
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(66907);
        super.mo3844e();
        for (C8796g d : this.f14796r) {
            d.mo19883d();
        }
        AppMethodBeat.m2505o(66907);
    }

    /* renamed from: f */
    public void mo19884f() {
        AppMethodBeat.m2504i(66908);
        super.mo19884f();
        if (this.f14799u != null) {
            GLES20.glDeleteTextures(2, this.f14799u, 0);
            this.f14799u = null;
        }
        if (this.f14798t != null) {
            GLES20.glDeleteFramebuffers(2, this.f14798t, 0);
            this.f14798t = null;
        }
        AppMethodBeat.m2505o(66908);
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66909);
        if (this.f2620e == i && this.f2621f == i2) {
            AppMethodBeat.m2505o(66909);
            return;
        }
        if (this.f14798t != null) {
            mo19884f();
        }
        super.mo3839a(i, i2);
        int size = this.f14797s.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C8796g) this.f14797s.get(i3)).mo3839a(i, i2);
        }
        this.f14800v.mo3839a(i, i2);
        if (this.f14797s != null && this.f14797s.size() > 0) {
            this.f14797s.size();
            this.f14798t = new int[2];
            this.f14799u = new int[2];
            for (int i4 = 0; i4 < 2; i4++) {
                GLES20.glGenFramebuffers(1, this.f14798t, i4);
                GLES20.glGenTextures(1, this.f14799u, i4);
                GLES20.glBindTexture(3553, this.f14799u[i4]);
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i, i2, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.f14798t[i4]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f14799u[i4], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
        AppMethodBeat.m2505o(66909);
    }

    /* renamed from: a */
    public int mo19865a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66910);
        int size = this.f14797s.size();
        mo19889k();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            int a;
            int i6;
            C8796g c8796g = (C8796g) this.f14797s.get(i4);
            if (i5 != 0) {
                a = c8796g.mo19865a(i, i2, i3);
            } else {
                a = c8796g.mo19865a(i, this.f14798t[0], this.f14799u[0]);
            }
            if (i5 != 0) {
                i6 = 0;
            } else {
                i6 = 1;
            }
            i4++;
            i5 = i6;
            i = a;
        }
        if (i5 != 0) {
            this.f14800v.mo19865a(i, i2, i3);
        }
        AppMethodBeat.m2505o(66910);
        return i3;
    }
}
