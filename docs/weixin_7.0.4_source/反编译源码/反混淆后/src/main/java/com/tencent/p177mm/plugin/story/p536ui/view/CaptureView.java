package com.tencent.p177mm.plugin.story.p536ui.view;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.widget.camerarecordview.C9615a;
import com.tencent.p177mm.media.widget.camerarecordview.p1465c.C32768a;
import com.tencent.p177mm.media.widget.camerarecordview.p258a.C42176b;
import com.tencent.p177mm.media.widget.camerarecordview.p258a.C9614a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.p177mm.media.widget.p257b.C1788b;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5225ah;
import com.tencent.p177mm.plugin.mmsight.p458ui.CameraFrontSightView;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCaptureTouchView;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCaptureTouchView.C43316a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCircularProgressBar.C3497a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C12584d;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C39409b;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C39410c;
import com.tencent.p177mm.plugin.story.model.C43641i;
import com.tencent.p177mm.plugin.story.model.C43641i.C43642a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C13740b;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C13740b.C13739a;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c;
import com.tencent.p177mm.plugin.story.p1032c.p1033a.C29275c.C29276a;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p536ui.StoryCaptureUI.C4149b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.util.VideoMaterialUtil;
import p000a.C0220l;
import p000a.C37091y;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u00020.2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020.H\u0002J\b\u0010;\u001a\u00020.H\u0002J\b\u0010<\u001a\u00020.H\u0002J\u0006\u0010=\u001a\u00020,J\u0012\u0010>\u001a\u00020.2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0006\u0010A\u001a\u00020.J\u0006\u0010B\u001a\u00020.J\u0010\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020\u000bH\u0016J\u0010\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\u000bH\u0002J\b\u0010G\u001a\u00020,H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CaptureView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "albumView", "Landroid/widget/ImageView;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "cameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "captureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "closeView", "guideView", "Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "hideHintRunnable", "Ljava/lang/Runnable;", "recordStartTime", "", "startTimeStamp", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "uiNavigation", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "getUiNavigation", "()Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "setUiNavigation", "(Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;)V", "useBackGroundCamera", "", "destroy", "", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "gotoEditor", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "hideGuideView", "hideHint", "initCaptureButton", "onBack", "onClick", "v", "Landroid/view/View;", "pause", "resume", "setVisibility", "visibility", "showHint", "strRes", "useCpuCrop", "Companion", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView */
public final class CaptureView extends RelativeLayout implements OnClickListener, C32768a {
    public static final C43652b sii = new C43652b();
    private final C7306ak fbD;
    private boolean fbE;
    private long ljM;
    private final CameraFrontSightView lml;
    private final MMSightCaptureTouchView lmm;
    private final TextView lmn;
    private final Runnable lmq;
    public C9615a lmr;
    private C4149b rYv;
    private final CameraPreviewGLSurfaceView sic;
    private final MMSightRecordButton sie;
    private final ImageView sif;
    private final ImageView sig;
    public C22308g sih;
    private long startTimeStamp;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getAudioBitrate", "", "getFilePath", "", "getRecordType", "getSampleRate", "getThumbPath", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$c */
    public static final class C13848c implements C42176b {
        C13848c() {
        }

        /* renamed from: Ww */
        public final int mo26019Ww() {
            AppMethodBeat.m2504i(110299);
            int i = ((C29276a) C29275c.rRk.mo53288Uw()).etz;
            AppMethodBeat.m2505o(110299);
            return i;
        }

        public final int getSampleRate() {
            AppMethodBeat.m2504i(110300);
            int i = ((C29276a) C29275c.rRk.mo53288Uw()).audioSampleRate;
            AppMethodBeat.m2505o(110300);
            return i;
        }

        /* renamed from: Wx */
        public final int mo26020Wx() {
            AppMethodBeat.m2504i(110301);
            int i = ((C29276a) C29275c.rRk.mo53288Uw()).fzS;
            AppMethodBeat.m2505o(110301);
            return i;
        }

        public final String getFilePath() {
            AppMethodBeat.m2504i(110302);
            C43642a c43642a = C43641i.rSv;
            long aaE = C1839cb.aaE();
            C5730e.m8643tf(C43641i.rSs);
            String str = C43641i.rSs + "record" + aaE + VideoMaterialUtil.MP4_SUFFIX;
            AppMethodBeat.m2505o(110302);
            return str;
        }

        /* renamed from: Wy */
        public final String mo26021Wy() {
            AppMethodBeat.m2504i(110303);
            C43642a c43642a = C43641i.rSv;
            String kY = C43642a.m78108kY(C1839cb.aaE());
            AppMethodBeat.m2505o(110303);
            return kY;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$f */
    static final class C13849f implements Runnable {
        final /* synthetic */ CaptureView sij;

        C13849f(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110306);
            this.sij.lmn.setVisibility(8);
            AppMethodBeat.m2505o(110306);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$TouchCallback;", "onDoubleClick", "", "onTouchDown", "x", "", "y", "onZoomIn", "onZoomOut", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$1 */
    public static final class C222771 implements C43316a {
        final /* synthetic */ CaptureView sij;

        C222771(CaptureView captureView) {
            this.sij = captureView;
        }

        /* renamed from: P */
        public final void mo30817P(float f, float f2) {
            AppMethodBeat.m2504i(110295);
            this.sij.lmr.mo20936b(f, f2, this.sij.sic.getWidth(), this.sij.sic.getHeight());
            this.sij.lml.mo36725X(f, f2);
            AppMethodBeat.m2505o(110295);
        }

        public final void bnY() {
            AppMethodBeat.m2504i(110296);
            if (C5046bo.m7525az(this.sij.startTimeStamp) < 1000) {
                AppMethodBeat.m2505o(110296);
                return;
            }
            this.sij.lmr.mo20932Wp();
            this.sij.fbE = this.sij.lmr.mo20931Wg();
            AppMethodBeat.m2505o(110296);
        }

        public final void asx() {
            AppMethodBeat.m2504i(110297);
            this.sij.lmr.mo20934a(true, false, 1);
            AppMethodBeat.m2505o(110297);
        }

        public final void asy() {
            AppMethodBeat.m2504i(110298);
            this.sij.lmr.mo20934a(false, false, 1);
            AppMethodBeat.m2505o(110298);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$d */
    static final class C29337d implements Runnable {
        final /* synthetic */ CaptureView sij;

        C29337d(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110304);
            this.sij.sie.bQs();
            AppMethodBeat.m2505o(110304);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/story/ui/view/CaptureView$hideGuideView$1$1"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$e */
    static final class C29338e implements Runnable {
        final /* synthetic */ CaptureView sij;
        final /* synthetic */ C22308g sik;

        C29338e(C22308g c22308g, CaptureView captureView) {
            this.sik = c22308g;
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110305);
            this.sij.removeView(this.sik);
            this.sij.sih = null;
            AppMethodBeat.m2505o(110305);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$g */
    static final class C29339g implements Runnable {
        final /* synthetic */ CaptureView sij;

        C29339g(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void run() {
            AppMethodBeat.m2504i(110307);
            CaptureView.m78164c(this.sij);
            AppMethodBeat.m2505o(110307);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onSimpleTap"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$h */
    static final class C39920h implements C12584d {
        final /* synthetic */ CaptureView sij;

        C39920h(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void bnX() {
            AppMethodBeat.m2504i(110308);
            CaptureView.m78159a(this.sij, (int) C25738R.string.esz);
            AppMethodBeat.m2505o(110308);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$initCaptureButton$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$j */
    public static final class C39921j implements C39410c {
        final /* synthetic */ CaptureView sij;

        C39921j(CaptureView captureView) {
            this.sij = captureView;
        }

        /* renamed from: uF */
        public final void mo30822uF(int i) {
            AppMethodBeat.m2504i(110315);
            this.sij.lmr.mo20934a(true, true, i);
            AppMethodBeat.m2505o(110315);
        }

        /* renamed from: uG */
        public final void mo30823uG(int i) {
            AppMethodBeat.m2504i(110316);
            this.sij.lmr.mo20934a(false, true, i);
            AppMethodBeat.m2505o(110316);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/story/ui/view/CaptureView$2$1"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$a */
    static final class C43651a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ CaptureView sij;

        C43651a(CaptureView captureView) {
            this.sij = captureView;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(110294);
            CaptureView.m78172k(this.sij);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(110294);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/CaptureView$Companion;", "", "()V", "FLIP_BLOCK_TIME", "", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$b */
    public static final class C43652b {
        private C43652b() {
        }

        public /* synthetic */ C43652b(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/CaptureView$initCaptureButton$2", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$i */
    public static final class C43653i implements C39409b {
        final /* synthetic */ CaptureView sij;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "capture", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$i$b */
        static final class C24834b extends C25053k implements C17126b<C9614a, C37091y> {
            final /* synthetic */ C43653i sil;

            C24834b(C43653i c43653i) {
                this.sil = c43653i;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(110311);
                C9614a c9614a = (C9614a) obj;
                C25052j.m39376p(c9614a, "capture");
                CaptureView.m78161a(this.sil.sij, c9614a);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(110311);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onProgressFinish"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$i$a */
        static final class C35240a implements C3497a {
            final /* synthetic */ C43653i sil;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.CaptureView$i$a$1 */
            static final class C352411 extends C25053k implements C17126b<C9614a, C37091y> {
                final /* synthetic */ C35240a sim;

                C352411(C35240a c35240a) {
                    this.sim = c35240a;
                    super(1);
                }

                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    AppMethodBeat.m2504i(110309);
                    C9614a c9614a = (C9614a) obj;
                    C25052j.m39376p(c9614a, "it");
                    CaptureView.m78161a(this.sim.sil.sij, c9614a);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(110309);
                    return c37091y;
                }
            }

            C35240a(C43653i c43653i) {
                this.sil = c43653i;
            }

            public final void bnW() {
                AppMethodBeat.m2504i(110310);
                if (!this.sil.sij.lmr.mo20935a((C17126b) new C352411(this))) {
                    CaptureView.m78159a(this.sil.sij, (int) C25738R.string.et0);
                }
                AppMethodBeat.m2505o(110310);
            }
        }

        C43653i(CaptureView captureView) {
            this.sij = captureView;
        }

        public final void bnV() {
            AppMethodBeat.m2504i(110312);
            int[] iArr = new int[2];
            this.sij.sie.getLocationOnScreen(iArr);
            this.sij.lmr.mo20937km(iArr[1]);
            CaptureView.m78164c(this.sij);
            C22212h c22212h = C22212h.scu;
            C22212h.m33887EU(2);
            c22212h = C22212h.scu;
            C22212h.cAq().mo43954FV();
            AppMethodBeat.m2505o(110312);
        }

        /* renamed from: if */
        public final void mo30800if() {
            AppMethodBeat.m2504i(110313);
            this.sij.sie.mo62335a(((C29276a) C29275c.rRk.mo53288Uw()).rRl.duration * 1000, Color.parseColor("#0E9CE6"), new C35240a(this));
            this.sij.lmr.mo20930EL();
            this.sij.sif.setVisibility(8);
            this.sij.sig.setVisibility(8);
            this.sij.ljM = C5046bo.m7588yz();
            AppMethodBeat.m2505o(110313);
        }

        public final void bnU() {
            AppMethodBeat.m2504i(110314);
            if (!this.sij.lmr.mo20935a((C17126b) new C24834b(this))) {
                CaptureView.m78159a(this.sij, (int) C25738R.string.et0);
            }
            this.sij.sif.setVisibility(0);
            this.sij.sig.setVisibility(0);
            AppMethodBeat.m2505o(110314);
        }
    }

    static {
        AppMethodBeat.m2504i(110326);
        AppMethodBeat.m2505o(110326);
    }

    /* renamed from: k */
    public static final /* synthetic */ void m78172k(CaptureView captureView) {
        AppMethodBeat.m2504i(110330);
        captureView.cCl();
        AppMethodBeat.m2505o(110330);
    }

    /* renamed from: DX */
    public final boolean mo45656DX() {
        return false;
    }

    public final C37897a getPreviewRenderer() {
        return null;
    }

    public final C37897a getRecordRenderer() {
        return null;
    }

    public final C1788b getRecorder() {
        return null;
    }

    public CaptureView(Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(110324);
        this.startTimeStamp = C5046bo.m7588yz();
        this.fbE = true;
        this.fbD = new C7306ak(Looper.getMainLooper());
        View.inflate(context, 2130970864, this);
        View findViewById = findViewById(2131821706);
        C25052j.m39375o(findViewById, "findViewById(R.id.draw_preview_surface)");
        this.sic = (CameraPreviewGLSurfaceView) findViewById;
        findViewById = findViewById(2131828048);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_capture_button)");
        this.sie = (MMSightRecordButton) findViewById;
        findViewById = findViewById(2131823420);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_focus_frame)");
        this.lml = (CameraFrontSightView) findViewById;
        findViewById = findViewById(2131823421);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_touch_view)");
        this.lmm = (MMSightCaptureTouchView) findViewById;
        findViewById = findViewById(2131828049);
        C25052j.m39375o(findViewById, "findViewById(R.id.story_capture_hint)");
        this.lmn = (TextView) findViewById;
        int fromDPToPix = C1338a.fromDPToPix(context, 120);
        this.lml.mo36728ez(fromDPToPix, fromDPToPix);
        findViewById = findViewById(2131828046);
        C25052j.m39375o(findViewById, "findViewById<ImageView>(R.id.story_capture_close)");
        this.sif = (ImageView) findViewById;
        this.sif.setImageDrawable(C5225ah.m7962f(context, C1318a.close_icon_nor, -1));
        this.sif.setOnClickListener(this);
        findViewById = findViewById(2131828047);
        C25052j.m39375o(findViewById, "findViewById<ImageView>(….story_choose_from_album)");
        this.sig = (ImageView) findViewById;
        this.sig.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_album, -1));
        this.sig.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(2131828045);
        imageView.setImageDrawable(C5225ah.m7962f(context, C1318a.icons_filled_camera_switch, -1));
        imageView.setOnClickListener(this);
        this.lmr = new C9615a(this);
        this.lmm.setTouchCallback(new C222771(this));
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        if (!RP.mo5239Ry().getBoolean(C5127a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, false)) {
            this.sih = new C22308g(context);
            C22308g c22308g = this.sih;
            if (c22308g != null) {
                addView(c22308g, new LayoutParams(-1, -1));
                c22308g.setClickListener(new C43651a(this));
            }
        }
        this.startTimeStamp = C5046bo.m7588yz();
        this.sie.setSimpleTapCallback(new C39920h(this));
        this.sie.setLongPressCallback(new C43653i(this));
        this.sie.setLongPressScrollCallback(new C39921j(this));
        this.lmq = new C29339g(this);
        AppMethodBeat.m2505o(110324);
    }

    public CaptureView(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(110325);
        AppMethodBeat.m2505o(110325);
    }

    public final C4149b getUiNavigation() {
        return this.rYv;
    }

    public final void setUiNavigation(C4149b c4149b) {
        this.rYv = c4149b;
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(110317);
        super.setVisibility(i);
        this.sic.setVisibility(i);
        if (i == 0) {
            this.sie.bQt();
        }
        AppMethodBeat.m2505o(110317);
    }

    public final void cCl() {
        AppMethodBeat.m2504i(110318);
        C22308g c22308g = this.sih;
        if (c22308g != null) {
            c22308g.animate().alpha(0.0f).withEndAction(new C29338e(c22308g, this)).start();
        }
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "storage()");
        RP.mo5239Ry().set(C5127a.USERINFO_STORY_CAPTURE_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
        AppMethodBeat.m2505o(110318);
    }

    /* renamed from: WD */
    public final boolean mo45657WD() {
        AppMethodBeat.m2504i(110319);
        boolean z = ((C13739a) C13740b.rRj.mo53288Uw()).fau;
        AppMethodBeat.m2505o(110319);
        return z;
    }

    public final int getResolutionLimit() {
        AppMethodBeat.m2504i(110320);
        int i = ((C13739a) C13740b.rRj.mo53288Uw()).lhd;
        AppMethodBeat.m2505o(110320);
        return i;
    }

    public final C42176b getEncodeConfig() {
        AppMethodBeat.m2504i(110321);
        C42176b c13848c = new C13848c();
        AppMethodBeat.m2505o(110321);
        return c13848c;
    }

    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.m2504i(110322);
        VideoTransPara videoTransPara = ((C29276a) C29275c.rRk.mo53288Uw()).rRl;
        AppMethodBeat.m2505o(110322);
        return videoTransPara;
    }

    public final C1791c getCameraPreviewView() {
        return this.sic;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(110323);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        C22212h c22212h;
        if (valueOf != null && valueOf.intValue() == 2131828046) {
            if (!this.lmr.isRecording) {
                C4149b c4149b = this.rYv;
                if (c4149b != null) {
                    c4149b.exit();
                }
                c22212h = C22212h.scu;
                C22212h.m33887EU(3);
                c22212h = C22212h.scu;
                C22212h.cAr();
                AppMethodBeat.m2505o(110323);
                return;
            }
        } else if (valueOf != null && valueOf.intValue() == 2131828047) {
            if (this.lmr.isRecording) {
                AppMethodBeat.m2505o(110323);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_edit_video_max_time_length", 10);
            intent.putExtra("key_edit_text_color", "#0E9CE6");
            Context context = getContext();
            if (context == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.m2505o(110323);
                throw c44941v;
            }
            C14987n.m23295a((Activity) context, 1002, 1, 14, 2, intent);
            c22212h = C22212h.scu;
            C22212h.cAm().mo5001bd(0);
            c22212h = C22212h.scu;
            C22212h.m33887EU(4);
            c22212h = C22212h.scu;
            C22212h.cAq().mo43955FW();
            AppMethodBeat.m2505o(110323);
            return;
        } else if (valueOf == null) {
            AppMethodBeat.m2505o(110323);
            return;
        } else if (valueOf.intValue() == 2131828045) {
            c22212h = C22212h.scu;
            C22212h.m33887EU(1);
            this.fbE = this.lmr.mo20931Wg();
        }
        AppMethodBeat.m2505o(110323);
    }

    /* renamed from: WE */
    public final boolean mo45658WE() {
        return C1427q.etc.erC;
    }

    /* renamed from: c */
    public static final /* synthetic */ void m78164c(CaptureView captureView) {
        AppMethodBeat.m2504i(110328);
        captureView.removeCallbacks(captureView.lmq);
        captureView.lmn.animate().alpha(0.0f).withEndAction(new C13849f(captureView)).start();
        AppMethodBeat.m2505o(110328);
    }
}
