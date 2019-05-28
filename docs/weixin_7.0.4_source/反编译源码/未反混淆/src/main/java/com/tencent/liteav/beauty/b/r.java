package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.basic.e.j;
import com.tencent.liteav.basic.e.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class r extends g {
    private ByteBuffer r;
    public int u;
    public int v;
    public int w;

    public r(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    public r(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(66979);
        this.u = -1;
        this.w = -1;
        a(j.NORMAL, false, true);
        AppMethodBeat.o(66979);
    }

    public boolean b() {
        AppMethodBeat.i(66980);
        boolean b = super.b();
        if (b) {
            this.u = GLES20.glGetAttribLocation(p(), "inputTextureCoordinate2");
            this.v = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
            GLES20.glEnableVertexAttribArray(this.u);
        }
        AppMethodBeat.o(66980);
        return b;
    }

    public void e() {
        AppMethodBeat.i(66981);
        super.e();
        AppMethodBeat.o(66981);
    }

    public void i() {
        AppMethodBeat.i(66982);
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, this.w);
        GLES20.glUniform1i(this.v, 3);
        if (this.u != -1) {
            GLES20.glEnableVertexAttribArray(this.u);
            this.r.position(0);
            GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 0, this.r);
        }
        AppMethodBeat.o(66982);
    }

    public void a(j jVar, boolean z, boolean z2) {
        AppMethodBeat.i(66983);
        float[] a = k.a(jVar, z, z2);
        ByteBuffer order = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = order.asFloatBuffer();
        asFloatBuffer.put(a);
        asFloatBuffer.flip();
        this.r = order;
        AppMethodBeat.o(66983);
    }

    public int b(int i, int i2) {
        AppMethodBeat.i(66984);
        this.w = i2;
        int a = a(i, this.m, this.n);
        AppMethodBeat.o(66984);
        return a;
    }

    public int a(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(66985);
        this.w = i2;
        int a = a(i, i3, i4);
        AppMethodBeat.o(66985);
        return a;
    }
}
