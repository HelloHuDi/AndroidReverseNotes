package com.tencent.p177mm.media.widget.p868a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.model.C39387f;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&J0\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J&\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\bH&J&\u0010\u001d\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\bH&J\b\u0010$\u001a\u00020\rH&J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH&J \u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\bH&¨\u0006*"}, dWq = {"Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "", "addFrameDataCallback", "", "callback", "Lcom/tencent/mm/plugin/mmsight/model/MMSightCameraFrameDataCallback;", "calcScrollZoomStep", "recordButtonTopLocation", "", "stepInterval", "generateCameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "initCamera", "", "context", "Landroid/content/Context;", "useBack", "isCameraPreviewing", "postFocusOnTouch", "x", "", "y", "surfaceWidth", "surfaceHeight", "delay", "", "release", "removeFocusOnTouch", "removeFrameDataCallback", "startPreview", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "useCpuCrop", "resolutionLimit", "surface", "Landroid/view/SurfaceHolder;", "switchCamera", "triggerCameraZoom", "zoom", "isScrollZoom", "factor", "Companion", "plugin-mediaeditor_release"})
/* renamed from: com.tencent.mm.media.widget.a.e */
public interface C26390e {
    public static final C26391a fbp = C26391a.fbq;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/media/widget/camera/ICommonCamera$Companion;", "", "()V", "MAX_RESOLUTION", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.a.e$a */
    public static final class C26391a {
        static final /* synthetic */ C26391a fbq = new C26391a();

        static {
            AppMethodBeat.m2504i(13224);
            AppMethodBeat.m2505o(13224);
        }

        private C26391a() {
        }
    }

    /* renamed from: Wg */
    boolean mo44175Wg();

    /* renamed from: Wh */
    boolean mo44176Wh();

    /* renamed from: Wp */
    void mo33839Wp();

    /* renamed from: Wq */
    C32765b mo33840Wq();

    /* renamed from: a */
    void mo33841a(SurfaceTexture surfaceTexture, boolean z, int i);

    /* renamed from: a */
    void mo33843a(C39387f c39387f);

    /* renamed from: a */
    void mo33844a(boolean z, boolean z2, int i);

    /* renamed from: b */
    void mo33845b(float f, float f2, int i, int i2);

    /* renamed from: b */
    void mo33846b(C39387f c39387f);

    /* renamed from: kj */
    void mo33847kj(int i);

    /* renamed from: o */
    boolean mo33848o(Context context, boolean z);

    void release();
}
