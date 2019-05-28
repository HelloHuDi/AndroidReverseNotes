package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C37353j;
import com.tencent.liteav.basic.p141e.C45103k;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.liteav.beauty.b.r */
public class C25653r extends C8796g {
    /* renamed from: r */
    private ByteBuffer f5268r;
    /* renamed from: u */
    public int f5269u;
    /* renamed from: v */
    public int f5270v;
    /* renamed from: w */
    public int f5271w;

    public C25653r(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public C25653r(String str, String str2) {
        super(str, str2);
        AppMethodBeat.m2504i(66979);
        this.f5269u = -1;
        this.f5271w = -1;
        mo43383a(C37353j.NORMAL, false, true);
        AppMethodBeat.m2505o(66979);
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66980);
        boolean b = super.mo3848b();
        if (b) {
            this.f5269u = GLES20.glGetAttribLocation(mo19894p(), "inputTextureCoordinate2");
            this.f5270v = GLES20.glGetUniformLocation(mo19894p(), "inputImageTexture2");
            GLES20.glEnableVertexAttribArray(this.f5269u);
        }
        AppMethodBeat.m2505o(66980);
        return b;
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(66981);
        super.mo3844e();
        AppMethodBeat.m2505o(66981);
    }

    /* renamed from: i */
    public void mo19887i() {
        AppMethodBeat.m2504i(66982);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f5271w);
        GLES20.glUniform1i(this.f5270v, 3);
        if (this.f5269u != -1) {
            GLES20.glEnableVertexAttribArray(this.f5269u);
            this.f5268r.position(0);
            GLES20.glVertexAttribPointer(this.f5269u, 2, 5126, false, 0, this.f5268r);
        }
        AppMethodBeat.m2505o(66982);
    }

    /* renamed from: a */
    public void mo43383a(C37353j c37353j, boolean z, boolean z2) {
        AppMethodBeat.m2504i(66983);
        float[] a = C45103k.m82749a(c37353j, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a);
        asFloatBuffer.flip();
        this.f5268r = order;
        AppMethodBeat.m2505o(66983);
    }

    /* renamed from: b */
    public int mo43384b(int i, int i2) {
        AppMethodBeat.m2504i(66984);
        this.f5271w = i2;
        int a = mo19865a(i, this.f2628m, this.f2629n);
        AppMethodBeat.m2505o(66984);
        return a;
    }

    /* renamed from: a */
    public int mo43382a(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(66985);
        this.f5271w = i2;
        int a = mo19865a(i, i3, i4);
        AppMethodBeat.m2505o(66985);
        return a;
    }
}
