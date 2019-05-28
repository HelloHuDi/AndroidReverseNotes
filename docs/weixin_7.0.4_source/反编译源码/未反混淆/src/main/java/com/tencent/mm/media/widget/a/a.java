package com.tencent.mm.media.widget.a;

import a.f.b.j;
import a.k.u;
import a.l;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

@l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001GB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010>\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u001fH\u0016J\u0006\u0010@\u001a\u00020\u001fJ\b\u0010A\u001a\u00020\u001fH\u0016J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020CH\u0004J\"\u0010E\u001a\u00020C2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0006H\u0017J\"\u0010E\u001a\u00020C2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0006H\u0017J\b\u0010F\u001a\u00020\u001fH\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0004R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:¨\u0006H"}, dWq = {"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG_SETTING", "getTAG_SETTING", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "hasShownErrorTip", "", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "surface", "Landroid/view/SurfaceHolder;", "getSurface", "()Landroid/view/SurfaceHolder;", "setSurface", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "()Z", "setUseBackCamera", "(Z)V", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "initCamera", "useBack", "isBackCamera", "isCameraPreviewing", "release", "", "showCameraErrorTips", "startPreview", "switchCamera", "CameraStatus", "plugin-mediaeditor_release"})
public abstract class a implements e {
    final String TAG = "MicroMsg.CommonCamera1";
    private SurfaceTexture bsb;
    Context context;
    final String fao = "MicroMsg.MMSightCameraSetting";
    private final int fap = 8;
    private boolean faq;
    boolean fas = true;
    private a fat = a.CAMERA_IS_DEFAULT;
    boolean fau = true;
    p fav;
    b faw;
    private SurfaceHolder fax;
    private int fay;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "CAMERA_IS_DEFAULT", "CAMERA_IS_PREVIEWING", "plugin-mediaeditor_release"})
    public enum a {
        CAMERA_IS_DEFAULT(-1),
        CAMERA_IS_PREVIEWING(0);
        
        private final int status;

        private a(int i) {
            this.status = i;
        }

        static {
            AppMethodBeat.o(13183);
        }
    }

    public a(Context context) {
        this.context = context;
        p bPJ = p.bPJ();
        j.o(bPJ, "RecordParams.getBigSightDefault()");
        this.fav = bPJ;
        this.faw = b.faF;
        this.fay = 40000;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        j.p(aVar, "<set-?>");
        this.fat = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Wf() {
        if (!this.faq && this.context != null) {
            if (!u.I(Build.MANUFACTURER, "meizu", true) || b.Mj()) {
                mi miVar = new mi();
                miVar.cIm.type = 2;
                com.tencent.mm.sdk.b.a.xxA.m(miVar);
                if (miVar.cIn.cIl) {
                    this.faq = true;
                    return;
                }
                c g = h.g(this.context, R.string.ehg, R.string.tz);
                if (g != null) {
                    g.setCancelable(false);
                    g.setCanceledOnTouchOutside(false);
                    g.show();
                    this.faq = true;
                }
            }
        }
    }

    public boolean o(Context context, boolean z) {
        j.p(context, "context");
        this.fas = z;
        return true;
    }

    public void a(SurfaceTexture surfaceTexture, boolean z, int i) {
        this.bsb = surfaceTexture;
        this.fau = z;
        this.fay = i;
    }

    public void a(SurfaceHolder surfaceHolder, boolean z, int i) {
        this.fax = surfaceHolder;
        this.fau = z;
        this.fay = i;
    }

    public final boolean Wg() {
        boolean z = false;
        if (this.bsb == null && this.fax == null) {
            ab.e(this.TAG, " do you forget override func startPreview");
            return false;
        }
        release();
        Context context = this.context;
        if (context == null) {
            j.dWJ();
        }
        if (!this.fas) {
            z = true;
        }
        o(context, z);
        ab.i(this.TAG, "useCpuCrop : " + this.fau + " , resolutionLimit: " + this.fay);
        if (this.bsb == null) {
            SurfaceHolder surfaceHolder = this.fax;
            if (surfaceHolder == null) {
                j.dWJ();
            }
            a(surfaceHolder, this.fau, this.fay);
            return this.fas;
        }
        SurfaceTexture surfaceTexture = this.bsb;
        if (surfaceTexture == null) {
            j.dWJ();
        }
        a(surfaceTexture, this.fau, this.fay);
        return this.fas;
    }

    public void release() {
        this.fat = a.CAMERA_IS_DEFAULT;
    }

    public final boolean Wh() {
        return this.fat == a.CAMERA_IS_PREVIEWING;
    }
}
