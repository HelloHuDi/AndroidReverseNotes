package com.tencent.mm.media.h;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.gles.GlUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 k2\u00020\u0001:\u0001kBA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0006\u0010K\u001a\u00020\u000bJ\u0006\u0010\n\u001a\u00020\u001eJ\b\u0010\u0010\u001a\u00020\u001eH\u0002J\b\u0010L\u001a\u00020$H$J\u000e\u0010M\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\u000bJ\b\u0010N\u001a\u0004\u0018\u00010OJ\n\u0010P\u001a\u0004\u0018\u000101H\u0016J\b\u0010Q\u001a\u00020\u001eH\u0002J\u0012\u0010R\u001a\u00020\u001e2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u00122\b\b\u0002\u0010U\u001a\u00020\u000bJ\u000e\u0010S\u001a\u00020\u001e2\u0006\u0010V\u001a\u00020\u0003J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000bH\u0016J\u0012\u0010W\u001a\u00020\u001e2\b\u0010X\u001a\u0004\u0018\u00010YH\u0016J\"\u0010Z\u001a\u00020\u001e2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0003H\u0016J\u001c\u0010]\u001a\u00020\u001e2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020\u001eH\u0016J\b\u0010a\u001a\u00020\u001eH\u0016J\b\u0010b\u001a\u00020\u001eH\u0002J)\u0010c\u001a\u00020\u001e2!\u0010d\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(V\u0012\u0004\u0012\u00020\u001e00J)\u0010e\u001a\u00020\u001e2!\u0010d\u001a\u001d\u0012\u0013\u0012\u00110O¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(f\u0012\u0004\u0012\u00020\u001e00J\u0010\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020\u0003H\u0016J\u0018\u0010i\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0003H\u0016J\u0018\u0010j\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020\u00032\u0006\u0010\\\u001a\u00020\u0003H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0019\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR7\u0010/\u001a\u001f\u0012\u0013\u0012\u001101¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020\u001e\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R\u001a\u0010;\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR\u001a\u0010>\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\u001c\u00104\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0014\"\u0004\bH\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0014\"\u0004\bJ\u0010\u0016¨\u0006l"}, dWq = {"Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "Landroid/opengl/GLSurfaceView$Renderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "clearFrame", "", "getClearFrame", "()Z", "setClearFrame", "(Z)V", "createSurfaceTexture", "currentDrawFrame", "", "getDrawHeight", "()I", "setDrawHeight", "(I)V", "getDrawWidth", "setDrawWidth", "externalTexture", "getExternalTexture", "setExternalTexture", "frameDrawCallback", "Lkotlin/Function0;", "", "getFrameDrawCallback", "()Lkotlin/jvm/functions/Function0;", "setFrameDrawCallback", "(Lkotlin/jvm/functions/Function0;)V", "glTextureRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getGlTextureRenderProc", "()Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "setGlTextureRenderProc", "(Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;)V", "inputTexture", "getInputTexture", "setInputTexture", "mirror", "getMirror", "setMirror", "onFrameAvailableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "getOnFrameAvailableListener", "()Lkotlin/jvm/functions/Function1;", "setOnFrameAvailableListener", "(Lkotlin/jvm/functions/Function1;)V", "getRenderOutputType", "setRenderOutputType", "renderProcInited", "getRenderProcInited", "setRenderProcInited", "rotateDegree", "getRotateDegree", "setRotateDegree", "getScaleType", "setScaleType", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "getTextureHeight", "setTextureHeight", "getTextureWidth", "setTextureWidth", "checkHasInit", "doInitRenderProc", "flip", "getOutputBuffer", "Ljava/nio/IntBuffer;", "getTexture", "initGLTextureRender", "initRenderProcInGlesThread", "input", "frame", "copyFrame", "texture", "onDrawFrame", "gl", "Ljavax/microedition/khronos/opengles/GL10;", "onSurfaceChanged", "width", "height", "onSurfaceCreated", "config", "Ljavax/microedition/khronos/egl/EGLConfig;", "release", "render", "resetRender", "setOnFBOAvailableListener", "listener", "setOnRGBDataAvailableListener", "buffer", "setRotate", "degree", "updateDrawViewSize", "updateTextureSize", "Companion", "plugin-mediaeditor_release"})
public abstract class a implements Renderer {
    public static final a eZb = new a();
    public SurfaceTexture bsb;
    public com.tencent.mm.media.h.b.a eYL;
    private byte[] eYM;
    public int eYN;
    public boolean eYO;
    private boolean eYP;
    private int eYQ;
    public int eYR;
    private boolean eYS;
    public b<? super SurfaceTexture, y> eYT;
    public a.f.a.a<y> eYU;
    public boolean eYV;
    protected int eYW;
    protected int eYX;
    protected int eYY;
    protected int eYZ;
    protected int eZa;
    protected int scaleType;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/render/AbsSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public a() {
        this(0, 0, 0, 0, 63);
    }

    public abstract com.tencent.mm.media.h.b.a Vc();

    public /* synthetic */ a(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9 = 1;
        if ((i5 & 1) != 0) {
            i6 = 0;
        } else {
            i6 = i;
        }
        if ((i5 & 4) != 0) {
            i7 = i6;
        } else {
            i7 = i2;
        }
        if ((i5 & 16) != 0) {
            i8 = 1;
        } else {
            i8 = i3;
        }
        if ((i5 & 32) == 0) {
            i9 = i4;
        }
        this(i6, 0, i7, 0, i8, i9);
    }

    public a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eYW = i;
        this.eYX = i2;
        this.eYY = i3;
        this.eYZ = i4;
        this.eZa = i5;
        this.scaleType = i6;
        this.eYN = -1;
        this.eYQ = -1;
    }

    public final void cs(boolean z) {
        if (this.eYV) {
            ab.c("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " initRenderProcInGlesThread, already init", new Object[0]);
            return;
        }
        this.eYP = z;
        this.eYL = Vc();
        ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " exec func initGLTextureRender  mirror : " + this.eYS);
        ci(this.eYY, this.eYZ);
        ch(this.eYW, this.eYX);
        ka(this.eYR);
        ct(this.eYS);
        if (this.eYP && (this.bsb == null || this.eYQ <= 0)) {
            b bVar;
            com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, iArr[0]);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9728);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
            GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
            com.tencent.mm.media.i.b.a.ma("glGenTextures");
            this.eYN = iArr[0];
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.eYN);
            b bVar2 = this.eYT;
            if (bVar2 != null) {
                bVar = new b(bVar2);
            } else {
                Object bVar3 = bVar2;
            }
            surfaceTexture.setOnFrameAvailableListener(bVar3);
            this.bsb = surfaceTexture;
            ab.c("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + this.eYN, new Object[0]);
            input(this.eYN);
        }
        ab.c("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " createSurfaceTexture:" + z + ", surfaceTexture:" + this.bsb, new Object[0]);
        this.eYV = true;
    }

    public final void input(int i) {
        this.eYQ = i;
        com.tencent.mm.media.h.b.a aVar = this.eYL;
        if (aVar != null) {
            aVar.kb(i);
        }
    }

    /* JADX WARNING: Missing block: B:5:0x0015, code skipped:
            if (r0.length == r4.length) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(a aVar, byte[] bArr) {
        j.p(bArr, "frame");
        if (!bo.cb(aVar.eYM)) {
            byte[] bArr2 = aVar.eYM;
            if (bArr2 != null) {
            }
        }
        aVar.eYM = new byte[bArr.length];
        System.arraycopy(bArr, 0, aVar.eYM, 0, bArr.length);
        com.tencent.mm.media.h.b.a aVar2 = aVar.eYL;
        if (aVar2 != null) {
            byte[] bArr3 = aVar.eYM;
            if (bArr3 == null) {
                j.dWJ();
            }
            aVar2.M(bArr3);
        }
    }

    public void ct(boolean z) {
        ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " set mirror: " + z);
        this.eYS = z;
        com.tencent.mm.media.h.b.a aVar = this.eYL;
        if (aVar != null) {
            aVar.eYS = z;
        }
    }

    public void Vd() {
        com.tencent.mm.media.h.b.a aVar = this.eYL;
        if (aVar != null) {
            aVar.Vd();
        }
    }

    public void release() {
        com.tencent.mm.media.h.b.a aVar = this.eYL;
        if (aVar != null) {
            aVar.release();
        }
        SurfaceTexture surfaceTexture = this.bsb;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (this.eYN >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.eYN}, 0);
            this.eYN = -1;
        }
        this.bsb = null;
        this.eYV = false;
    }

    public void ch(int i, int i2) {
        ab.c("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateTextureSize ,width : " + i + " , height : " + i2, new Object[0]);
        this.eYW = i;
        this.eYX = i2;
        com.tencent.mm.media.h.b.a aVar = this.eYL;
        if (aVar != null) {
            aVar.eYW = i;
            aVar.eYX = i2;
        }
    }

    public final void ci(int i, int i2) {
        ab.c("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " updateDrawViewSize ,width : " + i + " , height : " + i2, new Object[0]);
        this.eYY = i;
        this.eYZ = i2;
        com.tencent.mm.media.h.b.a aVar = this.eYL;
        if (aVar != null) {
            aVar.ci(i, i2);
        }
    }

    public void ka(int i) {
        ab.c("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " change rotate ,old degree : " + this.eYR + " , new degree : " + i, new Object[0]);
        this.eYR = i;
        com.tencent.mm.media.h.b.a aVar = this.eYL;
        if (aVar != null) {
            aVar.eYR = i;
        }
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.eYO) {
            ab.i("MicroMsg.Media.AbsSurfaceRenderer", "do clear frame");
            this.eYO = false;
        } else if (this.eYM == null && this.eYQ == -1) {
            ab.e("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " there is no input ,do you dismiss setting input");
        } else {
            Vd();
            a.f.a.a aVar = this.eYU;
            if (aVar != null) {
                aVar.invoke();
            }
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceChanged width:" + i + ", height:" + i2);
        ci(i, i2);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        ab.i("MicroMsg.Media.AbsSurfaceRenderer", hashCode() + " onSurfaceCreated");
        com.tencent.mm.media.i.b.a aVar = com.tencent.mm.media.i.b.fad;
        com.tencent.mm.media.i.b.a.Vj();
    }
}
