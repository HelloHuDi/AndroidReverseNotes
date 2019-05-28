package com.tencent.p177mm.media.widget.p868a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.p230g.p231a.C18330mi;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.mmsight.model.C34552p;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001GB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010>\u001a\u00020\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u001fH\u0016J\u0006\u0010@\u001a\u00020\u001fJ\b\u0010A\u001a\u00020\u001fH\u0016J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020CH\u0004J\"\u0010E\u001a\u00020C2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0006H\u0017J\"\u0010E\u001a\u00020C2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0006H\u0017J\b\u0010F\u001a\u00020\u001fH\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u00100\u001a\u000201H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u0004R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\b\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:¨\u0006H"}, dWq = {"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera;", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "CROP_PREVIEW_THRESHOLD", "", "getCROP_PREVIEW_THRESHOLD", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG_SETTING", "getTAG_SETTING", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "cameraStatus", "Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "getCameraStatus", "()Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "setCameraStatus", "(Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;)V", "getContext", "()Landroid/content/Context;", "setContext", "hasShownErrorTip", "", "params", "Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "getParams", "()Lcom/tencent/mm/plugin/mmsight/model/RecordParams;", "setParams", "(Lcom/tencent/mm/plugin/mmsight/model/RecordParams;)V", "resolutionLimit", "getResolutionLimit", "setResolutionLimit", "(I)V", "surface", "Landroid/view/SurfaceHolder;", "getSurface", "()Landroid/view/SurfaceHolder;", "setSurface", "(Landroid/view/SurfaceHolder;)V", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "useBackCamera", "getUseBackCamera", "()Z", "setUseBackCamera", "(Z)V", "useCpuCrop", "getUseCpuCrop", "setUseCpuCrop", "initCamera", "useBack", "isBackCamera", "isCameraPreviewing", "release", "", "showCameraErrorTips", "startPreview", "switchCamera", "CameraStatus", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.a.a */
public abstract class C32763a implements C26390e {
    final String TAG = "MicroMsg.CommonCamera1";
    private SurfaceTexture bsb;
    Context context;
    final String fao = "MicroMsg.MMSightCameraSetting";
    private final int fap = 8;
    private boolean faq;
    boolean fas = true;
    private C32764a fat = C32764a.CAMERA_IS_DEFAULT;
    boolean fau = true;
    C34552p fav;
    C32765b faw;
    private SurfaceHolder fax;
    private int fay;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, dWq = {"Lcom/tencent/mm/media/widget/camera/BaseCommonCamera$CameraStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "CAMERA_IS_DEFAULT", "CAMERA_IS_PREVIEWING", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.a.a$a */
    public enum C32764a {
        CAMERA_IS_DEFAULT(-1),
        CAMERA_IS_PREVIEWING(0);
        
        private final int status;

        private C32764a(int i) {
            this.status = i;
        }

        static {
            AppMethodBeat.m2505o(13183);
        }
    }

    public C32763a(Context context) {
        this.context = context;
        C34552p bPJ = C34552p.bPJ();
        C25052j.m39375o(bPJ, "RecordParams.getBigSightDefault()");
        this.fav = bPJ;
        this.faw = C32765b.faF;
        this.fay = 40000;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo53309a(C32764a c32764a) {
        C25052j.m39376p(c32764a, "<set-?>");
        this.fat = c32764a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Wf */
    public final void mo53308Wf() {
        if (!this.faq && this.context != null) {
            if (!C6163u.m9833I(Build.MANUFACTURER, "meizu", true) || C37657b.m63681Mj()) {
                C18330mi c18330mi = new C18330mi();
                c18330mi.cIm.type = 2;
                C4879a.xxA.mo10055m(c18330mi);
                if (c18330mi.cIn.cIl) {
                    this.faq = true;
                    return;
                }
                C5653c g = C30379h.m48467g(this.context, C25738R.string.ehg, C25738R.string.f9238tz);
                if (g != null) {
                    g.setCancelable(false);
                    g.setCanceledOnTouchOutside(false);
                    g.show();
                    this.faq = true;
                }
            }
        }
    }

    /* renamed from: o */
    public boolean mo33848o(Context context, boolean z) {
        C25052j.m39376p(context, "context");
        this.fas = z;
        return true;
    }

    /* renamed from: a */
    public void mo33841a(SurfaceTexture surfaceTexture, boolean z, int i) {
        this.bsb = surfaceTexture;
        this.fau = z;
        this.fay = i;
    }

    /* renamed from: a */
    public void mo33842a(SurfaceHolder surfaceHolder, boolean z, int i) {
        this.fax = surfaceHolder;
        this.fau = z;
        this.fay = i;
    }

    /* renamed from: Wg */
    public final boolean mo44175Wg() {
        boolean z = false;
        if (this.bsb == null && this.fax == null) {
            C4990ab.m7412e(this.TAG, " do you forget override func startPreview");
            return false;
        }
        release();
        Context context = this.context;
        if (context == null) {
            C25052j.dWJ();
        }
        if (!this.fas) {
            z = true;
        }
        mo33848o(context, z);
        C4990ab.m7416i(this.TAG, "useCpuCrop : " + this.fau + " , resolutionLimit: " + this.fay);
        if (this.bsb == null) {
            SurfaceHolder surfaceHolder = this.fax;
            if (surfaceHolder == null) {
                C25052j.dWJ();
            }
            mo33842a(surfaceHolder, this.fau, this.fay);
            return this.fas;
        }
        SurfaceTexture surfaceTexture = this.bsb;
        if (surfaceTexture == null) {
            C25052j.dWJ();
        }
        mo33841a(surfaceTexture, this.fau, this.fay);
        return this.fas;
    }

    public void release() {
        this.fat = C32764a.CAMERA_IS_DEFAULT;
    }

    /* renamed from: Wh */
    public final boolean mo44176Wh() {
        return this.fat == C32764a.CAMERA_IS_PREVIEWING;
    }
}
