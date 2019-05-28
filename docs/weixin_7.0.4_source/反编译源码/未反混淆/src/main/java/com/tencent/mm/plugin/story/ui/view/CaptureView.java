package com.tencent.mm.plugin.story.ui.view;

import a.f.b.k;
import a.l;
import a.v;
import a.y;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.model.cb;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ah;
import com.tencent.ttpic.util.VideoMaterialUtil;

@l(dWo = {1, 1, 13}, dWp = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020.2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020.H\u0002J\b\u0010;\u001a\u00020.H\u0002J\b\u0010<\u001a\u00020.H\u0002J\u0006\u0010=\u001a\u00020,J\u0012\u0010>\u001a\u00020.2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0006\u0010A\u001a\u00020.J\u0006\u0010B\u001a\u00020.J\u0010\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020\u000bH\u0016J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\u000bH\u0002J\b\u0010G\u001a\u00020,H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CaptureView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "albumView", "Landroid/widget/ImageView;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "captureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "closeView", "guideView", "Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "hideHintRunnable", "Ljava/lang/Runnable;", "recordStartTime", "", "startTimeStamp", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "uiNavigation", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "getUiNavigation", "()Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "setUiNavigation", "(Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;)V", "useBackGroundCamera", "", "destroy", "", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "gotoEditor", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "hideGuideView", "hideHint", "initCaptureButton", "onBack", "onClick", "v", "Landroid/view/View;", "pause", "resume", "setVisibility", "visibility", "showHint", "strRes", "useCpuCrop", "Companion", "plugin-story_release"})
public final class CaptureView extends RelativeLayout implements OnClickListener, com.tencent.mm.media.widget.camerarecordview.c.a {
    public static final b sii = new b();
    private final ak fbD;
    private boolean fbE;
    private long ljM;
    private final CameraFrontSightView lml;
    private final MMSightCaptureTouchView lmm;
    private final TextView lmn;
    private final Runnable lmq;
    public com.tencent.mm.media.widget.camerarecordview.a lmr;
    private com.tencent.mm.plugin.story.ui.StoryCaptureUI.b rYv;
    private final CameraPreviewGLSurfaceView sic;
    private final MMSightRecordButton sie;
    private final ImageView sif;
    private final ImageView sig;
    public g sih;
    private long startTimeStamp;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getAudioBitrate", "", "getFilePath", "", "getRecordType", "getSampleRate", "getThumbPath", "plugin-story_release"})
    public static final class c implements com.tencent.mm.media.widget.camerarecordview.a.b {
        c() {
        }

        public final int Ww() {
            AppMethodBeat.i(110299);
            int i = ((com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw()).etz;
            AppMethodBeat.o(110299);
            return i;
        }

        public final int getSampleRate() {
            AppMethodBeat.i(110300);
            int i = ((com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw()).audioSampleRate;
            AppMethodBeat.o(110300);
            return i;
        }

        public final int Wx() {
            AppMethodBeat.i(110301);
            int i = ((com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw()).fzS;
            AppMethodBeat.o(110301);
            return i;
        }

        public final String getFilePath() {
            AppMethodBeat.i(110302);
            com.tencent.mm.plugin.story.model.i.a aVar = com.tencent.mm.plugin.story.model.i.rSv;
            long aaE = cb.aaE();
            com.tencent.mm.vfs.e.tf(com.tencent.mm.plugin.story.model.i.rSs);
            String str = com.tencent.mm.plugin.story.model.i.rSs + "record" + aaE + VideoMaterialUtil.MP4_SUFFIX;
            AppMethodBeat.o(110302);
            return str;
        }

        public final String Wy() {
            AppMethodBeat.i(110303);
            com.tencent.mm.plugin.story.model.i.a aVar = com.tencent.mm.plugin.story.model.i.rSv;
            String kY = com.tencent.mm.plugin.story.model.i.a.kY(cb.aaE());
            AppMethodBeat.o(110303);
            return kY;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ CaptureView sij;

        f(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.i(110306);
            this.sij.lmn.setVisibility(8);
            AppMethodBeat.o(110306);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$TouchCallback;", "onDoubleClick", "", "onTouchDown", "x", "", "y", "onZoomIn", "onZoomOut", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$1 */
    public static final class AnonymousClass1 implements com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a {
        final /* synthetic */ CaptureView sij;

        AnonymousClass1(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void P(float f, float f2) {
            AppMethodBeat.i(110295);
            this.sij.lmr.b(f, f2, this.sij.sic.getWidth(), this.sij.sic.getHeight());
            this.sij.lml.X(f, f2);
            AppMethodBeat.o(110295);
        }

        public final void bnY() {
            AppMethodBeat.i(110296);
            if (bo.az(this.sij.startTimeStamp) < 1000) {
                AppMethodBeat.o(110296);
                return;
            }
            this.sij.lmr.Wp();
            this.sij.fbE = this.sij.lmr.Wg();
            AppMethodBeat.o(110296);
        }

        public final void asx() {
            AppMethodBeat.i(110297);
            this.sij.lmr.a(true, false, 1);
            AppMethodBeat.o(110297);
        }

        public final void asy() {
            AppMethodBeat.i(110298);
            this.sij.lmr.a(false, false, 1);
            AppMethodBeat.o(110298);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ CaptureView sij;

        d(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.i(110304);
            this.sij.sie.bQs();
            AppMethodBeat.o(110304);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/CaptureView$hideGuideView$1$1"})
    static final class e implements Runnable {
        final /* synthetic */ CaptureView sij;
        final /* synthetic */ g sik;

        e(g gVar, CaptureView captureView) {
            this.sik = gVar;
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.i(110305);
            this.sij.removeView(this.sik);
            this.sij.sih = null;
            AppMethodBeat.o(110305);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ CaptureView sij;

        g(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.i(110307);
            CaptureView.c(this.sij);
            AppMethodBeat.o(110307);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onSimpleTap"})
    static final class h implements com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d {
        final /* synthetic */ CaptureView sij;

        h(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void bnX() {
            AppMethodBeat.i(110308);
            CaptureView.a(this.sij, (int) R.string.esz);
            AppMethodBeat.o(110308);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$initCaptureButton$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-story_release"})
    public static final class j implements com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c {
        final /* synthetic */ CaptureView sij;

        j(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void uF(int i) {
            AppMethodBeat.i(110315);
            this.sij.lmr.a(true, true, i);
            AppMethodBeat.o(110315);
        }

        public final void uG(int i) {
            AppMethodBeat.i(110316);
            this.sij.lmr.a(false, true, i);
            AppMethodBeat.o(110316);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/ui/view/CaptureView$2$1"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ CaptureView sij;

        a(CaptureView captureView) {
            this.sij = captureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(110294);
            CaptureView.k(this.sij);
            y yVar = y.AUy;
            AppMethodBeat.o(110294);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CaptureView$Companion;", "", "()V", "FLIP_BLOCK_TIME", "", "TAG", "", "plugin-story_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$initCaptureButton$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-story_release"})
    public static final class i implements com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b {
        final /* synthetic */ CaptureView sij;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
        static final class b extends k implements a.f.a.b<com.tencent.mm.media.widget.camerarecordview.a.a, y> {
            final /* synthetic */ i sil;

            b(i iVar) {
                this.sil = iVar;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(110311);
                com.tencent.mm.media.widget.camerarecordview.a.a aVar = (com.tencent.mm.media.widget.camerarecordview.a.a) obj;
                a.f.b.j.p(aVar, "capture");
                CaptureView.a(this.sil.sij, aVar);
                y yVar = y.AUy;
                AppMethodBeat.o(110311);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onProgressFinish"})
        static final class a implements com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a {
            final /* synthetic */ i sil;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$i$a$1 */
            static final class AnonymousClass1 extends k implements a.f.a.b<com.tencent.mm.media.widget.camerarecordview.a.a, y> {
                final /* synthetic */ a sim;

                AnonymousClass1(a aVar) {
                    this.sim = aVar;
                    super(1);
                }

                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(110309);
                    com.tencent.mm.media.widget.camerarecordview.a.a aVar = (com.tencent.mm.media.widget.camerarecordview.a.a) obj;
                    a.f.b.j.p(aVar, "it");
                    CaptureView.a(this.sim.sil.sij, aVar);
                    y yVar = y.AUy;
                    AppMethodBeat.o(110309);
                    return yVar;
                }
            }

            a(i iVar) {
                this.sil = iVar;
            }

            public final void bnW() {
                AppMethodBeat.i(110310);
                if (!this.sil.sij.lmr.a((a.f.a.b) new AnonymousClass1(this))) {
                    CaptureView.a(this.sil.sij, (int) R.string.et0);
                }
                AppMethodBeat.o(110310);
            }
        }

        i(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void bnV() {
            AppMethodBeat.i(110312);
            int[] iArr = new int[2];
            this.sij.sie.getLocationOnScreen(iArr);
            this.sij.lmr.km(iArr[1]);
            CaptureView.c(this.sij);
            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(2);
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAq().FV();
            AppMethodBeat.o(110312);
        }

        /* renamed from: if */
        public final void m24if() {
            AppMethodBeat.i(110313);
            this.sij.sie.a(((com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw()).rRl.duration * 1000, Color.parseColor("#0E9CE6"), new a(this));
            this.sij.lmr.EL();
            this.sij.sif.setVisibility(8);
            this.sij.sig.setVisibility(8);
            this.sij.ljM = bo.yz();
            AppMethodBeat.o(110313);
        }

        public final void bnU() {
            AppMethodBeat.i(110314);
            if (!this.sij.lmr.a((a.f.a.b) new b(this))) {
                CaptureView.a(this.sij, (int) R.string.et0);
            }
            this.sij.sif.setVisibility(0);
            this.sij.sig.setVisibility(0);
            AppMethodBeat.o(110314);
        }
    }

    static {
        AppMethodBeat.i(110326);
        AppMethodBeat.o(110326);
    }

    public static final /* synthetic */ void k(CaptureView captureView) {
        AppMethodBeat.i(110330);
        captureView.cCl();
        AppMethodBeat.o(110330);
    }

    public final boolean DX() {
        return false;
    }

    public final com.tencent.mm.media.h.a getPreviewRenderer() {
        return null;
    }

    public final com.tencent.mm.media.h.a getRecordRenderer() {
        return null;
    }

    public final com.tencent.mm.media.widget.b.b getRecorder() {
        return null;
    }

    public CaptureView(Context context, AttributeSet attributeSet, int i) {
        a.f.b.j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(110324);
        this.startTimeStamp = bo.yz();
        this.fbE = true;
        this.fbD = new ak(Looper.getMainLooper());
        View.inflate(context, R.layout.ay1, this);
        View findViewById = findViewById(R.id.a4d);
        a.f.b.j.o(findViewById, "findViewById(R.id.draw_preview_surface)");
        this.sic = (CameraPreviewGLSurfaceView) findViewById;
        findViewById = findViewById(R.id.equ);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_capture_button)");
        this.sie = (MMSightRecordButton) findViewById;
        findViewById = findViewById(R.id.bcq);
        a.f.b.j.o(findViewById, "findViewById(R.id.capture_focus_frame)");
        this.lml = (CameraFrontSightView) findViewById;
        findViewById = findViewById(R.id.bcr);
        a.f.b.j.o(findViewById, "findViewById(R.id.capture_touch_view)");
        this.lmm = (MMSightCaptureTouchView) findViewById;
        findViewById = findViewById(R.id.eqv);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_capture_hint)");
        this.lmn = (TextView) findViewById;
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 120);
        this.lml.ez(fromDPToPix, fromDPToPix);
        findViewById = findViewById(R.id.eqs);
        a.f.b.j.o(findViewById, "findViewById<ImageView>(R.id.story_capture_close)");
        this.sif = (ImageView) findViewById;
        this.sif.setImageDrawable(ah.f(context, R.raw.close_icon_nor, -1));
        this.sif.setOnClickListener(this);
        findViewById = findViewById(R.id.eqt);
        a.f.b.j.o(findViewById, "findViewById<ImageView>(….story_choose_from_album)");
        this.sig = (ImageView) findViewById;
        this.sig.setImageDrawable(ah.f(context, R.raw.icons_filled_album, -1));
        this.sig.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.eqr);
        imageView.setImageDrawable(ah.f(context, R.raw.icons_filled_camera_switch, -1));
        imageView.setOnClickListener(this);
        this.lmr = new com.tencent.mm.media.widget.camerarecordview.a(this);
        this.lmm.setTouchCallback(new AnonymousClass1(this));
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "storage()");
        if (!RP.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, false)) {
            this.sih = new g(context);
            g gVar = this.sih;
            if (gVar != null) {
                addView(gVar, new LayoutParams(-1, -1));
                gVar.setClickListener(new a(this));
            }
        }
        this.startTimeStamp = bo.yz();
        this.sie.setSimpleTapCallback(new h(this));
        this.sie.setLongPressCallback(new i(this));
        this.sie.setLongPressScrollCallback(new j(this));
        this.lmq = new g(this);
        AppMethodBeat.o(110324);
    }

    public CaptureView(Context context, AttributeSet attributeSet) {
        a.f.b.j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(110325);
        AppMethodBeat.o(110325);
    }

    public final com.tencent.mm.plugin.story.ui.StoryCaptureUI.b getUiNavigation() {
        return this.rYv;
    }

    public final void setUiNavigation(com.tencent.mm.plugin.story.ui.StoryCaptureUI.b bVar) {
        this.rYv = bVar;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(110317);
        super.setVisibility(i);
        this.sic.setVisibility(i);
        if (i == 0) {
            this.sie.bQt();
        }
        AppMethodBeat.o(110317);
    }

    public final void cCl() {
        AppMethodBeat.i(110318);
        g gVar = this.sih;
        if (gVar != null) {
            gVar.animate().alpha(0.0f).withEndAction(new e(gVar, this)).start();
        }
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "storage()");
        RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.o(110318);
    }

    public final boolean WD() {
        AppMethodBeat.i(110319);
        boolean z = ((com.tencent.mm.plugin.story.c.a.b.a) com.tencent.mm.plugin.story.c.a.b.rRj.Uw()).fau;
        AppMethodBeat.o(110319);
        return z;
    }

    public final int getResolutionLimit() {
        AppMethodBeat.i(110320);
        int i = ((com.tencent.mm.plugin.story.c.a.b.a) com.tencent.mm.plugin.story.c.a.b.rRj.Uw()).lhd;
        AppMethodBeat.o(110320);
        return i;
    }

    public final com.tencent.mm.media.widget.camerarecordview.a.b getEncodeConfig() {
        AppMethodBeat.i(110321);
        com.tencent.mm.media.widget.camerarecordview.a.b cVar = new c();
        AppMethodBeat.o(110321);
        return cVar;
    }

    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.i(110322);
        VideoTransPara videoTransPara = ((com.tencent.mm.plugin.story.c.a.c.a) com.tencent.mm.plugin.story.c.a.c.rRk.Uw()).rRl;
        AppMethodBeat.o(110322);
        return videoTransPara;
    }

    public final com.tencent.mm.media.widget.camerarecordview.preview.c getCameraPreviewView() {
        return this.sic;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(110323);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        com.tencent.mm.plugin.story.g.h hVar;
        if (valueOf != null && valueOf.intValue() == R.id.eqs) {
            if (!this.lmr.isRecording) {
                com.tencent.mm.plugin.story.ui.StoryCaptureUI.b bVar = this.rYv;
                if (bVar != null) {
                    bVar.exit();
                }
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.EU(3);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAr();
                AppMethodBeat.o(110323);
                return;
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.eqt) {
            if (this.lmr.isRecording) {
                AppMethodBeat.o(110323);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_edit_video_max_time_length", 10);
            intent.putExtra("key_edit_text_color", "#0E9CE6");
            Context context = getContext();
            if (context == null) {
                v vVar = new v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(110323);
                throw vVar;
            }
            n.a((Activity) context, 1002, 1, 14, 2, intent);
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAm().bd(0);
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(4);
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAq().FW();
            AppMethodBeat.o(110323);
            return;
        } else if (valueOf == null) {
            AppMethodBeat.o(110323);
            return;
        } else if (valueOf.intValue() == R.id.eqr) {
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EU(1);
            this.fbE = this.lmr.Wg();
        }
        AppMethodBeat.o(110323);
    }

    public final boolean WE() {
        return q.etc.erC;
    }

    public static final /* synthetic */ void c(CaptureView captureView) {
        AppMethodBeat.i(110328);
        captureView.removeCallbacks(captureView.lmq);
        captureView.lmn.animate().alpha(0.0f).withEndAction(new f(captureView)).start();
        AppMethodBeat.o(110328);
    }
}
