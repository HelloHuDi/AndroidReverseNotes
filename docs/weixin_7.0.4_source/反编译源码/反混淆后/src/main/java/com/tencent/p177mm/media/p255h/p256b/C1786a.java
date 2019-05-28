package com.tencent.p177mm.media.p255h.p256b;

import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.p177mm.media.p867i.C42175b;
import com.tencent.p177mm.media.p867i.C42175b.C26386a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0013\n\u0002\u0010\u0012\n\u0002\b\u000b\b&\u0018\u0000 V2\u00020\u0001:\u0001VB=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010=\u001a\u00020\u001eH\u0002J\b\u0010>\u001a\u00020\u001eH\u0002J\b\u0010?\u001a\u00020\u001eH\u0002J\u000e\u0010@\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010A\u001a\u00020\u001e2\u0006\u0010\u0018\u001a\u00020\u0017J\b\u0010B\u001a\u0004\u0018\u00010$J\u0006\u0010C\u001a\u00020\u0003J\u0006\u0010D\u001a\u00020\u0003J\b\u0010E\u001a\u00020\u001eH\u0002J\u0006\u0010F\u001a\u00020\u0017J\b\u0010G\u001a\u00020\u001eH\u0016J\u0006\u0010H\u001a\u00020\u001eJ\b\u0010I\u001a\u00020\u001eH$J\u0010\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010M\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u000e\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020\u0003J\u0010\u0010P\u001a\u00020\u001e2\b\u0010Q\u001a\u0004\u0018\u000102J\u0016\u0010R\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010U\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u0003R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R7\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R7\u0010#\u001a\u001f\u0012\u0013\u0012\u00110$¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u0010\u0010(\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0011R\u000e\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0011R\u001a\u0010.\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0011\"\u0004\b6\u0010\u0013R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006W"}, dWq = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "cubeBuffer", "Ljava/nio/FloatBuffer;", "getCubeBuffer", "()Ljava/nio/FloatBuffer;", "setCubeBuffer", "(Ljava/nio/FloatBuffer;)V", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "flip", "", "mirror", "onFBOAvailableListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "texture", "", "getOnFBOAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFBOAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "onRGBDataAvailableListener", "Ljava/nio/IntBuffer;", "buffer", "getOnRGBDataAvailableListener", "setOnRGBDataAvailableListener", "renderOutputBuffer", "renderOutputTexture", "renderOutputTextureFbo", "getRenderOutputType", "rotateDegree", "getScaleType", "textureCoordBuff", "getTextureCoordBuff", "setTextureCoordBuff", "textureCropRect", "Landroid/graphics/Rect;", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "transformMatrix", "", "getTransformMatrix", "()[F", "setTransformMatrix", "([F)V", "afterRender", "beforeRender", "checkInitRenderOutputBuffer", "flipUpsideDown", "frameMirror", "getOutputBuffer", "getOutputTexture", "getRotate", "initMatrix", "isMirror", "release", "render", "renderImpl", "setFrame", "frame", "", "setInputTexture", "setRotate", "degree", "setTextureCropRect", "rect", "updateDrawViewSize", "width", "height", "updateTextureSize", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.h.b.a */
public abstract class C1786a {
    public static final C1787a eZq = new C1787a();
    public int eYR;
    public boolean eYS;
    public int eYW;
    public int eYX;
    protected int eYY;
    protected int eYZ;
    private final int eZa;
    public Rect eZd;
    FloatBuffer eZh;
    FloatBuffer eZi;
    private int eZj;
    private int eZk;
    public IntBuffer eZl;
    float[] eZm = new float[16];
    private boolean eZn;
    private C17126b<? super Integer, C37091y> eZo;
    private C17126b<? super IntBuffer, C37091y> eZp;
    private final int scaleType;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000¨\u0006\f"}, dWq = {"Lcom/tencent/mm/media/render/proc/GLTextureRenderProc$Companion;", "", "()V", "RENDER_OUTPUT_RGB_BUFFER", "", "RENDER_OUTPUT_SCREEN", "RENDER_OUTPUT_TEXTURE", "SCALE_TYPE_CENTER_CROP", "SCALE_TYPE_CROP_RECT", "SCALE_TYPE_NOT_SCALE", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.h.b.a$a */
    public static final class C1787a {
        private C1787a() {
        }

        public /* synthetic */ C1787a(byte b) {
            this();
        }
    }

    /* renamed from: Vf */
    public abstract void mo5334Vf();

    public C1786a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eYW = i;
        this.eYX = i2;
        this.eYY = i3;
        this.eYZ = i4;
        this.eZa = i5;
        this.scaleType = i6;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(C42175b.eZZ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C25052j.m39375o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZh = asFloatBuffer;
        asFloatBuffer = ByteBuffer.allocateDirect(C42175b.eZY.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        C25052j.m39375o(asFloatBuffer, "ByteBuffer.allocateDirec…eOrder()).asFloatBuffer()");
        this.eZi = asFloatBuffer;
        if (this.eZa == 2) {
            C26386a c26386a = C42175b.fad;
            this.eZj = C26386a.m41982Vh();
            c26386a = C42175b.fad;
            this.eZk = C26386a.m41983Vi();
        } else if (this.eZa == 3) {
            m3672Ve();
        }
    }

    /* renamed from: Ve */
    private final void m3672Ve() {
        if (this.eYY > 0 && this.eYZ > 0) {
            this.eZl = IntBuffer.allocate(this.eYY * this.eYZ);
        }
    }

    /* renamed from: kb */
    public void mo5336kb(int i) {
        C4990ab.m7409c("MicroMsg.GLTextureRenderProc", "call super err :texture", new Object[0]);
    }

    /* renamed from: M */
    public void mo5332M(byte[] bArr) {
        C25052j.m39376p(bArr, "frame");
        C4990ab.m7409c("MicroMsg.GLTextureRenderProc", "call super err :ByteArray", new Object[0]);
    }

    /* renamed from: Vd */
    public final void mo5333Vd() {
        int i;
        int i2;
        int i3;
        Matrix.setIdentityM(this.eZm, 0);
        Matrix.setRotateM(this.eZm, 0, (float) this.eYR, 0.0f, 0.0f, -1.0f);
        if (!this.eZn && this.eZa != 3) {
            Matrix.scaleM(this.eZm, 0, 1.0f, 1.0f, 1.0f);
        } else if (this.eYR == 90 || this.eYR == 270) {
            Matrix.scaleM(this.eZm, 0, -1.0f, 1.0f, 1.0f);
        } else {
            Matrix.scaleM(this.eZm, 0, 1.0f, -1.0f, 1.0f);
        }
        if (this.eYS) {
            Matrix.scaleM(this.eZm, 0, 1.0f, -1.0f, 1.0f);
        }
        float[] fArr;
        float f;
        float f2;
        float f3;
        float f4;
        if (this.scaleType == 1) {
            this.eZh.position(0);
            this.eZh.put(C42175b.eZZ);
            this.eZh.position(0);
        } else if (this.scaleType == 2) {
            float f5;
            fArr = C42175b.eZZ;
            float[] copyOf = Arrays.copyOf(fArr, fArr.length);
            int i4 = (this.eYR == 90 || this.eYR == 270) ? 1 : 0;
            int i5 = i4 != 0 ? this.eYX : this.eYW;
            i = i4 != 0 ? this.eYW : this.eYX;
            f = ((float) this.eYY) / ((float) i5);
            f2 = ((float) this.eYZ) / ((float) i);
            if (f < f2) {
                i2 = 0;
                i3 = i5 - ((int) (((float) this.eYY) / f2));
            } else if (f > f2) {
                i2 = i - ((int) (((float) this.eYZ) / f));
                i3 = 0;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if (i4 != 0) {
                f5 = (((float) i2) / 2.0f) / ((float) i);
                f3 = 1.0f - f5;
                f4 = (((float) i3) / 2.0f) / ((float) i5);
                f2 = 1.0f - f4;
            } else {
                f5 = (((float) i3) / 2.0f) / ((float) i5);
                f4 = (((float) i2) / 2.0f) / ((float) i);
                f2 = 1.0f - f4;
                f3 = 1.0f - f5;
            }
            copyOf[0] = f5;
            copyOf[1] = f2;
            copyOf[2] = f3;
            copyOf[3] = f2;
            copyOf[4] = f5;
            copyOf[5] = f4;
            copyOf[6] = f3;
            copyOf[7] = f4;
            this.eZh.put(C42175b.eZZ);
            this.eZh.position(0);
            this.eZh.put(copyOf);
            this.eZh.position(0);
            this.eZi.position(0);
        } else if (this.scaleType == 3 && this.eZd != null) {
            fArr = C42175b.eZZ;
            float[] copyOf2 = Arrays.copyOf(fArr, fArr.length);
            Rect rect = this.eZd;
            Integer valueOf = rect != null ? Integer.valueOf(rect.width()) : null;
            if (valueOf == null) {
                C25052j.dWJ();
            }
            int intValue = valueOf.intValue();
            rect = this.eZd;
            valueOf = rect != null ? Integer.valueOf(rect.height()) : null;
            if (valueOf == null) {
                C25052j.dWJ();
            }
            i2 = valueOf.intValue();
            rect = this.eZd;
            if (rect == null || rect.left != 0) {
                f3 = ((float) (this.eYW - intValue)) / ((float) this.eYW);
                f = 1.0f - f3;
            } else {
                f = ((float) (this.eYW - intValue)) / ((float) this.eYW);
                f3 = 1.0f - f;
            }
            Rect rect2 = this.eZd;
            if (rect2 == null || rect2.top != 0) {
                f4 = ((float) (this.eYX - i2)) / ((float) this.eYX);
                f2 = 1.0f - f4;
            } else {
                f2 = ((float) (this.eYX - i2)) / ((float) this.eYX);
                f4 = 1.0f - f2;
            }
            copyOf2[0] = f;
            copyOf2[1] = f2;
            copyOf2[2] = f3;
            copyOf2[3] = f2;
            copyOf2[4] = f;
            copyOf2[5] = f4;
            copyOf2[6] = f3;
            copyOf2[7] = f4;
            this.eZh.put(C42175b.eZZ);
            this.eZh.position(0);
            this.eZh.put(copyOf2);
            this.eZh.position(0);
            this.eZi.position(0);
        }
        this.eZi.position(0);
        this.eZi.put(C42175b.eZY);
        this.eZi.position(0);
        C26386a c26386a = C42175b.fad;
        C26386a.m41984Vj();
        GLES20.glViewport(0, 0, this.eYY, this.eYZ);
        if (this.eZa == 2) {
            if (this.eZj == 0) {
                c26386a = C42175b.fad;
                this.eZj = C26386a.m41982Vh();
                c26386a = C42175b.fad;
                this.eZk = C26386a.m41983Vi();
            }
            c26386a = C42175b.fad;
            i = this.eZk;
            int i6 = this.eZj;
            i2 = this.eYW;
            i3 = this.eYX;
            GLES20.glBindFramebuffer(36160, i);
            GLES20.glBindTexture(3553, i6);
            GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i2, i3, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i6, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glViewport(0, 0, this.eYW, this.eYX);
        }
        mo5334Vf();
        C17126b c17126b;
        if (this.eZa == 3) {
            if (this.eZl == null) {
                m3672Ve();
            }
            IntBuffer intBuffer = this.eZl;
            if (intBuffer == null) {
                C25052j.dWJ();
            }
            intBuffer.position(0);
            GLES20.glReadPixels(0, 0, this.eYY, this.eYZ, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, this.eZl);
            c17126b = this.eZp;
            if (c17126b != null) {
                IntBuffer intBuffer2 = this.eZl;
                if (intBuffer2 == null) {
                    C25052j.dWJ();
                }
                c17126b.mo50am(intBuffer2);
            }
        } else if (this.eZa == 2) {
            c17126b = this.eZo;
            if (c17126b != null) {
                c17126b.mo50am(Integer.valueOf(this.eZj));
            }
        }
        c26386a = C42175b.fad;
        C26386a.m41984Vj();
    }

    /* renamed from: ci */
    public final void mo5335ci(int i, int i2) {
        this.eYZ = i2;
        this.eYY = i;
        if (this.eZa == 3) {
            m3672Ve();
        }
    }

    public void release() {
        if (this.eZj != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.eZj}, 0);
        }
        if (this.eZk != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.eZk}, 0);
        }
    }
}
