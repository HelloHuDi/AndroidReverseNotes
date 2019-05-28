package com.tencent.liteav.beauty.p144b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.beauty.C37363c.C8810d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.List;

/* renamed from: com.tencent.liteav.beauty.b.v */
public class C16523v extends C8796g {
    /* renamed from: A */
    private static final float[] f3546A = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    /* renamed from: v */
    protected static final short[] f3547v = new short[]{(short) 1, (short) 2, (short) 0, (short) 2, (short) 0, (short) 3};
    /* renamed from: z */
    private static final float[] f3548z = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    /* renamed from: B */
    private String f3549B;
    /* renamed from: r */
    protected C16524a[] f3550r;
    /* renamed from: s */
    protected List<C8810d> f3551s;
    /* renamed from: t */
    protected boolean f3552t;
    /* renamed from: u */
    protected int f3553u;
    /* renamed from: w */
    protected ShortBuffer f3554w;
    /* renamed from: x */
    private C16524a f3555x;
    /* renamed from: y */
    private int f3556y;

    /* renamed from: com.tencent.liteav.beauty.b.v$a */
    public class C16524a {
        /* renamed from: a */
        public FloatBuffer f3557a = null;
        /* renamed from: b */
        public FloatBuffer f3558b = null;
        /* renamed from: c */
        public Bitmap f3559c;
        /* renamed from: d */
        public int[] f3560d = null;
    }

    public C16523v(String str, String str2) {
        super(str, str2);
        AppMethodBeat.m2504i(66911);
        this.f3550r = null;
        this.f3555x = null;
        this.f3551s = null;
        this.f3552t = false;
        this.f3553u = 1;
        this.f3556y = 1;
        this.f3554w = null;
        this.f3549B = "GPUWatermark";
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f3547v.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f3554w = allocateDirect.asShortBuffer();
        this.f3554w.put(f3547v);
        this.f3554w.position(0);
        this.f2630o = true;
        AppMethodBeat.m2505o(66911);
    }

    public C16523v() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    /* renamed from: d */
    public void mo19883d() {
        AppMethodBeat.m2504i(66912);
        super.mo19883d();
        this.f3552t = false;
        m25388q();
        AppMethodBeat.m2505o(66912);
    }

    /* renamed from: c */
    public void mo30462c(boolean z) {
        this.f3552t = z;
    }

    /* renamed from: a */
    public void mo30461a(Bitmap bitmap, float f, float f2, float f3, int i) {
        AppMethodBeat.m2504i(66913);
        if (bitmap == null) {
            if (!(this.f3550r == null || this.f3550r[i] == null)) {
                new StringBuilder("release ").append(i).append(" water mark!");
                if (this.f3550r[i].f3560d != null) {
                    GLES20.glDeleteTextures(1, this.f3550r[i].f3560d, 0);
                }
                this.f3550r[i].f3560d = null;
                this.f3550r[i].f3559c = null;
                this.f3550r[i] = null;
            }
            AppMethodBeat.m2505o(66913);
        } else if (this.f3550r[i] == null || i >= this.f3550r.length) {
            AppMethodBeat.m2505o(66913);
        } else {
            mo30459a(bitmap.getWidth(), bitmap.getHeight(), f, f2, f3, i);
            if (this.f3550r[i].f3560d == null) {
                this.f3550r[i].f3560d = new int[1];
                GLES20.glGenTextures(1, this.f3550r[i].f3560d, 0);
                GLES20.glBindTexture(3553, this.f3550r[i].f3560d[0]);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            if (this.f3550r[i].f3559c == null || !this.f3550r[i].f3559c.equals(bitmap)) {
                GLES20.glBindTexture(3553, this.f3550r[i].f3560d[0]);
                GLUtils.texImage2D(3553, 0, bitmap, 0);
            }
            this.f3550r[i].f3559c = bitmap;
            AppMethodBeat.m2505o(66913);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo30459a(int i, int i2, float f, float f2, float f3, int i3) {
        int i4 = 1;
        AppMethodBeat.m2504i(66914);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(f3548z.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f3550r[i3].f3557a = allocateDirect.asFloatBuffer();
        float[] fArr = new float[f3548z.length];
        float f4 = (((((float) i2) / ((float) i)) * f3) * ((float) this.f2620e)) / ((float) this.f2621f);
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
        this.f3550r[i3].f3557a.put(fArr);
        this.f3550r[i3].f3557a.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(f3546A.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.f3550r[i3].f3558b = allocateDirect2.asFloatBuffer();
        this.f3550r[i3].f3558b.put(f3546A);
        this.f3550r[i3].f3558b.position(0);
        AppMethodBeat.m2505o(66914);
    }

    /* renamed from: a */
    public void mo30460a(Bitmap bitmap, float f, float f2, float f3) {
        AppMethodBeat.m2504i(66915);
        if (this.f3550r == null) {
            this.f3550r = new C16524a[1];
        }
        if (this.f3550r[0] == null) {
            this.f3550r[0] = new C16524a();
        }
        mo30461a(bitmap, f, f2, f3, 0);
        this.f3555x = this.f3550r[0];
        AppMethodBeat.m2505o(66915);
    }

    /* renamed from: q */
    private void m25388q() {
        AppMethodBeat.m2504i(66916);
        if (this.f3550r != null) {
            for (int i = 0; i < this.f3550r.length; i++) {
                if (this.f3550r[i] != null) {
                    if (this.f3550r[i].f3560d != null) {
                        GLES20.glDeleteTextures(1, this.f3550r[i].f3560d, 0);
                    }
                    this.f3550r[i].f3560d = null;
                    this.f3550r[i].f3559c = null;
                    this.f3550r[i] = null;
                }
            }
        }
        this.f3550r = null;
        AppMethodBeat.m2505o(66916);
    }

    /* renamed from: j */
    public void mo19888j() {
        AppMethodBeat.m2504i(66917);
        super.mo19888j();
        if (this.f3552t) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(this.f3553u, 771);
            GLES20.glActiveTexture(33984);
            for (int i = 0; i < this.f3550r.length; i++) {
                if (this.f3550r[i] != null) {
                    GLES20.glBindTexture(3553, this.f3550r[i].f3560d[0]);
                    GLES20.glUniform1i(this.f2618c, 0);
                    GLES20.glVertexAttribPointer(this.f2617b, 2, 5126, false, 8, this.f3550r[i].f3557a);
                    GLES20.glEnableVertexAttribArray(this.f2617b);
                    GLES20.glVertexAttribPointer(this.f2619d, 4, 5126, false, 16, this.f3550r[i].f3558b);
                    GLES20.glEnableVertexAttribArray(this.f2619d);
                    GLES20.glDrawElements(4, f3547v.length, 5123, this.f3554w);
                    GLES20.glDisableVertexAttribArray(this.f2617b);
                    GLES20.glDisableVertexAttribArray(this.f2619d);
                }
            }
            GLES20.glDisable(3042);
        }
        AppMethodBeat.m2505o(66917);
    }
}
