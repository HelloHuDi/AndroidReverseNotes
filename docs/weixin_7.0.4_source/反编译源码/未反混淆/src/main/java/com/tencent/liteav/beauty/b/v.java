package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.beauty.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

public class v extends g {
    private static final float[] A = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    protected static final short[] v = new short[]{(short) 1, (short) 2, (short) 0, (short) 2, (short) 0, (short) 3};
    private static final float[] z = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private String B;
    protected a[] r;
    protected List<d> s;
    protected boolean t;
    protected int u;
    protected ShortBuffer w;
    private a x;
    private int y;

    public class a {
        public FloatBuffer a = null;
        public FloatBuffer b = null;
        public Bitmap c;
        public int[] d = null;
    }

    public v(String str, String str2) {
        super(str, str2);
        AppMethodBeat.i(66911);
        this.r = null;
        this.x = null;
        this.s = null;
        this.t = false;
        this.u = 1;
        this.y = 1;
        this.w = null;
        this.B = "GPUWatermark";
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(v.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.w = allocateDirect.asShortBuffer();
        this.w.put(v);
        this.w.position(0);
        this.o = true;
        AppMethodBeat.o(66911);
    }

    public v() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public void d() {
        AppMethodBeat.i(66912);
        super.d();
        this.t = false;
        q();
        AppMethodBeat.o(66912);
    }

    public void c(boolean z) {
        this.t = z;
    }

    public void a(Bitmap bitmap, float f, float f2, float f3, int i) {
        AppMethodBeat.i(66913);
        if (bitmap == null) {
            if (!(this.r == null || this.r[i] == null)) {
                new StringBuilder("release ").append(i).append(" water mark!");
                if (this.r[i].d != null) {
                    GLES20.glDeleteTextures(1, this.r[i].d, 0);
                }
                this.r[i].d = null;
                this.r[i].c = null;
                this.r[i] = null;
            }
            AppMethodBeat.o(66913);
        } else if (this.r[i] == null || i >= this.r.length) {
            AppMethodBeat.o(66913);
        } else {
            a(bitmap.getWidth(), bitmap.getHeight(), f, f2, f3, i);
            if (this.r[i].d == null) {
                this.r[i].d = new int[1];
                GLES20.glGenTextures(1, this.r[i].d, 0);
                GLES20.glBindTexture(3553, this.r[i].d[0]);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            if (this.r[i].c == null || !this.r[i].c.equals(bitmap)) {
                GLES20.glBindTexture(3553, this.r[i].d[0]);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
            }
            this.r[i].c = bitmap;
            AppMethodBeat.o(66913);
        }
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, int i2, float f, float f2, float f3, int i3) {
        int i4 = 1;
        AppMethodBeat.i(66914);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(z.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.r[i3].a = allocateDirect.asFloatBuffer();
        float[] fArr = new float[z.length];
        float f4 = (((((float) i2) / ((float) i)) * f3) * ((float) this.e)) / ((float) this.f);
        fArr[0] = (2.0f * f) - 1.0f;
        fArr[1] = 1.0f - (2.0f * f2);
        fArr[2] = fArr[0];
        fArr[3] = fArr[1] - (f4 * 2.0f);
        fArr[4] = fArr[0] + (2.0f * f3);
        fArr[5] = fArr[3];
        fArr[6] = fArr[4];
        fArr[7] = fArr[1];
        while (i4 <= 7) {
            fArr[i4] = fArr[i4] * -1.0f;
            i4 += 2;
        }
        this.r[i3].a.put(fArr);
        this.r[i3].a.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(A.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.r[i3].b = allocateDirect2.asFloatBuffer();
        this.r[i3].b.put(A);
        this.r[i3].b.position(0);
        AppMethodBeat.o(66914);
    }

    public void a(Bitmap bitmap, float f, float f2, float f3) {
        AppMethodBeat.i(66915);
        if (this.r == null) {
            this.r = new a[1];
        }
        if (this.r[0] == null) {
            this.r[0] = new a();
        }
        a(bitmap, f, f2, f3, 0);
        this.x = this.r[0];
        AppMethodBeat.o(66915);
    }

    private void q() {
        AppMethodBeat.i(66916);
        if (this.r != null) {
            for (int i = 0; i < this.r.length; i++) {
                if (this.r[i] != null) {
                    if (this.r[i].d != null) {
                        GLES20.glDeleteTextures(1, this.r[i].d, 0);
                    }
                    this.r[i].d = null;
                    this.r[i].c = null;
                    this.r[i] = null;
                }
            }
        }
        this.r = null;
        AppMethodBeat.o(66916);
    }

    public void j() {
        AppMethodBeat.i(66917);
        super.j();
        if (this.t) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(this.u, 771);
            GLES20.glActiveTexture(33984);
            for (int i = 0; i < this.r.length; i++) {
                if (this.r[i] != null) {
                    GLES20.glBindTexture(3553, this.r[i].d[0]);
                    GLES20.glUniform1i(this.c, 0);
                    GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 8, this.r[i].a);
                    GLES20.glEnableVertexAttribArray(this.b);
                    GLES20.glVertexAttribPointer(this.d, 4, 5126, false, 16, this.r[i].b);
                    GLES20.glEnableVertexAttribArray(this.d);
                    GLES20.glDrawElements(4, v.length, 5123, this.w);
                    GLES20.glDisableVertexAttribArray(this.b);
                    GLES20.glDisableVertexAttribArray(this.d);
                }
            }
            GLES20.glDisable(3042);
        }
        AppMethodBeat.o(66917);
    }
}
