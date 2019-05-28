package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.p141e.C37353j;
import com.tencent.liteav.basic.p141e.C45103k;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.liteav.beauty.b.q */
public class C37361q extends C8796g {
    /* renamed from: r */
    public int f15911r;
    /* renamed from: s */
    public int f15912s;
    /* renamed from: t */
    public int f15913t;
    /* renamed from: u */
    public int f15914u;
    /* renamed from: v */
    public int f15915v;
    /* renamed from: w */
    public int f15916w;
    /* renamed from: x */
    private ByteBuffer f15917x;
    /* renamed from: y */
    private ByteBuffer f15918y;

    public C37361q(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", str);
        AppMethodBeat.m2504i(66994);
        mo60128a(C37353j.NORMAL, false, true);
        AppMethodBeat.m2505o(66994);
    }

    public C37361q(String str, String str2) {
        super(str, str2);
        AppMethodBeat.m2504i(66995);
        this.f15913t = -1;
        this.f15916w = -1;
        mo60128a(C37353j.NORMAL, false, true);
        AppMethodBeat.m2505o(66995);
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66996);
        boolean b = super.mo3848b();
        GLES20.glUseProgram(mo19894p());
        this.f15911r = GLES20.glGetAttribLocation(mo19894p(), "inputTextureCoordinate2");
        this.f15914u = GLES20.glGetAttribLocation(mo19894p(), "inputTextureCoordinate3");
        this.f15912s = GLES20.glGetUniformLocation(mo19894p(), "inputImageTexture2");
        this.f15915v = GLES20.glGetUniformLocation(mo19894p(), "inputImageTexture3");
        GLES20.glEnableVertexAttribArray(this.f15911r);
        GLES20.glEnableVertexAttribArray(this.f15914u);
        AppMethodBeat.m2505o(66996);
        return b;
    }

    /* renamed from: a */
    public int mo19865a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66997);
        int a = mo60127a(i, i2, i3, this.f2628m, this.f2629n);
        AppMethodBeat.m2505o(66997);
        return a;
    }

    /* renamed from: a */
    public int mo60127a(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(66998);
        this.f15913t = i2;
        this.f15916w = i3;
        int a = super.mo19865a(i, i4, i5);
        AppMethodBeat.m2505o(66998);
        return a;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66999);
        super.mo3839a(i, i2);
        AppMethodBeat.m2505o(66999);
    }

    /* renamed from: i */
    public void mo19887i() {
        AppMethodBeat.m2504i(67000);
        GLES20.glEnableVertexAttribArray(this.f15911r);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.f15913t);
        GLES20.glUniform1i(this.f15912s, 3);
        this.f15917x.position(0);
        GLES20.glVertexAttribPointer(this.f15911r, 2, 5126, false, 0, this.f15917x);
        GLES20.glEnableVertexAttribArray(this.f15914u);
        GLES20.glActiveTexture(33988);
        GLES20.glBindTexture(3553, this.f15916w);
        GLES20.glUniform1i(this.f15915v, 4);
        this.f15918y.position(0);
        GLES20.glVertexAttribPointer(this.f15914u, 2, 5126, false, 0, this.f15918y);
        AppMethodBeat.m2505o(67000);
    }

    /* renamed from: a */
    public void mo60128a(C37353j c37353j, boolean z, boolean z2) {
        AppMethodBeat.m2504i(67001);
        float[] a = C45103k.m82749a(c37353j, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a);
        asFloatBuffer.flip();
        this.f15917x = order;
        order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a);
        asFloatBuffer.flip();
        this.f15918y = order;
        AppMethodBeat.m2505o(67001);
    }
}
