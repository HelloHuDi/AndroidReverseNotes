package com.tencent.p177mm.plugin.emojicapture.p389ui.capture;

import android.content.Context;
import android.content.Intent;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.media.p255h.C37897a;
import com.tencent.p177mm.media.p255h.p256b.C1786a;
import com.tencent.p177mm.media.widget.camerarecordview.C9615a;
import com.tencent.p177mm.media.widget.camerarecordview.p1465c.C32768a;
import com.tencent.p177mm.media.widget.camerarecordview.p258a.C42176b;
import com.tencent.p177mm.media.widget.camerarecordview.p258a.C9614a;
import com.tencent.p177mm.media.widget.camerarecordview.preview.C1791c;
import com.tencent.p177mm.media.widget.p257b.C1788b;
import com.tencent.p177mm.media.widget.p257b.C6630c;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.C34007d;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.p1253b.C27792a;
import com.tencent.p177mm.plugin.emojicapture.p1253b.C27792a.C20425a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.C20443a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiCaptureBeautySettingUI;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiCaptureGLTextureView;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C20447b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C27807a;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C41265g;
import com.tencent.p177mm.plugin.emojicapture.p389ui.p951b.C42981f;
import com.tencent.p177mm.plugin.emojicapture.p949c.C27793a.C27794a;
import com.tencent.p177mm.plugin.emojicapture.p949c.C27793a.C27795b;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.EmojiCaptureProxy.C20437a;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.p458ui.CameraFrontSightView;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCaptureTouchView;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCaptureTouchView.C43316a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCircularProgressBar.C3497a;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C12584d;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C39409b;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightRecordButton.C39410c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u000207H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0016H\u0016J\b\u0010D\u001a\u00020EH\u0016J\n\u0010F\u001a\u0004\u0018\u00010GH\u0016J\n\u0010H\u001a\u0004\u0018\u00010GH\u0016J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u00020\u000bH\u0016J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u000207H\u0016J\b\u0010O\u001a\u00020:H\u0016J\b\u0010P\u001a\u00020:H\u0016J\b\u0010Q\u001a\u00020:H\u0016J\u0010\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u000207H\u0002J\u0010\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020\u000bH\u0016J\u0010\u0010V\u001a\u00020:2\b\u0010W\u001a\u0004\u0018\u00010XJ\b\u0010Y\u001a\u00020:H\u0016J-\u0010Z\u001a\u0002072#\u0010[\u001a\u001f\u0012\u0013\u0012\u00110?¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020:\u0018\u00010\\H\u0016J\b\u0010`\u001a\u000207H\u0016J\u0010\u0010a\u001a\u00020:2\u0006\u0010b\u001a\u000207H\u0016J\u0018\u0010c\u001a\u00020:2\u0006\u0010b\u001a\u0002072\u0006\u0010d\u001a\u00020\u000bH\u0002J\u0010\u0010e\u001a\u00020:2\u0006\u0010b\u001a\u000207H\u0016J\b\u0010f\u001a\u000207H\u0016J\b\u0010g\u001a\u000207H\u0016R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "beautyParaBtn", "Landroid/widget/Button;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLSurfaceTextureRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "", "voiceDetectView", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer */
public final class CaptureContainer extends RelativeLayout implements C32768a, C27795b {
    public final String TAG;
    private EmojiCaptureReporter lha;
    private final ViewGroup lmc;
    private EmojiCaptureGLTextureView lmd;
    public C20447b lme;
    private final MMSightRecordButton lmf;
    private final View lmg;
    private final View lmh;
    private final EditorStickerView lmi;
    private final View lmj;
    private final CaptureDecoration lmk;
    private final CameraFrontSightView lml;
    private final MMSightCaptureTouchView lmm;
    private final TextView lmn;
    private final Button lmo;
    C27794a lmp;
    private final Runnable lmq;
    public C9615a lmr;
    public boolean lms;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onSimpleTap"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$2 */
    static final class C204502 implements C12584d {
        final /* synthetic */ CaptureContainer lmt;

        C204502(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void bnX() {
            AppMethodBeat.m2504i(2950);
            C4990ab.m7416i(this.lmt.TAG, "simpleTapCallback");
            CaptureContainer.m44198a(this.lmt, false);
            AppMethodBeat.m2505o(2950);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$4", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$TouchCallback;", "onDoubleClick", "", "onTouchDown", "x", "", "y", "onZoomIn", "onZoomOut", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$4 */
    public static final class C204514 implements C43316a {
        final /* synthetic */ CaptureContainer lmt;

        C204514(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        /* renamed from: P */
        public final void mo30817P(float f, float f2) {
            AppMethodBeat.m2504i(2953);
            this.lmt.lmr.mo20936b(f, f2, this.lmt.lmd.getWidth(), this.lmt.lmd.getHeight());
            this.lmt.lml.mo36725X(f, f2);
            AppMethodBeat.m2505o(2953);
        }

        public final void bnY() {
            AppMethodBeat.m2504i(2954);
            this.lmt.lmr.mo20932Wp();
            this.lmt.mo45659Wg();
            AppMethodBeat.m2505o(2954);
        }

        public final void asx() {
            AppMethodBeat.m2504i(2955);
            this.lmt.lmr.mo20934a(true, false, 1);
            AppMethodBeat.m2505o(2955);
        }

        public final void asy() {
            AppMethodBeat.m2504i(2956);
            this.lmt.lmr.mo20934a(false, false, 1);
            AppMethodBeat.m2505o(2956);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$9 */
    static final class C204529 implements Runnable {
        final /* synthetic */ CaptureContainer lmt;

        C204529(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(2961);
            CaptureContainer.m44199a(this.lmt, true, C25738R.string.ac8);
            AppMethodBeat.m2505o(2961);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$e */
    static final class C20453e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ boolean iLX;
        final /* synthetic */ CaptureContainer lmt;

        C20453e(CaptureContainer captureContainer, boolean z) {
            this.lmt = captureContainer;
            this.iLX = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2967);
            if (this.iLX) {
                this.lmt.lmh.setVisibility(0);
            } else {
                this.lmt.lmh.setVisibility(8);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2967);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1 */
    public static final class C278121 implements C39409b {
        final /* synthetic */ CaptureContainer lmt;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1$b */
        static final class C24751b extends C25053k implements C17126b<C9614a, C37091y> {
            final /* synthetic */ C278121 lmu;

            C24751b(C278121 c278121) {
                this.lmu = c278121;
                super(1);
            }

            /* renamed from: am */
            public final /* synthetic */ Object mo50am(Object obj) {
                AppMethodBeat.m2504i(2946);
                C9614a c9614a = (C9614a) obj;
                C25052j.m39376p(c9614a, "it");
                CaptureContainer.m44197a(this.lmu.lmt, c9614a);
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2946);
                return c37091y;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onProgressFinish"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1$a */
        static final class C27813a implements C3497a {
            final /* synthetic */ C278121 lmu;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1$a$1 */
            static final class C278141 extends C25053k implements C17126b<C9614a, C37091y> {
                final /* synthetic */ C27813a lmv;

                C278141(C27813a c27813a) {
                    this.lmv = c27813a;
                    super(1);
                }

                /* renamed from: am */
                public final /* synthetic */ Object mo50am(Object obj) {
                    AppMethodBeat.m2504i(2944);
                    C9614a c9614a = (C9614a) obj;
                    C25052j.m39376p(c9614a, "it");
                    CaptureContainer.m44197a(this.lmv.lmu.lmt, c9614a);
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(2944);
                    return c37091y;
                }
            }

            C27813a(C278121 c278121) {
                this.lmu = c278121;
            }

            public final void bnW() {
                AppMethodBeat.m2504i(2945);
                C4990ab.m7416i(this.lmu.lmt.TAG, "onLongPress");
                CaptureContainer.m44198a(this.lmu.lmt, this.lmu.lmt.mo45660a((C17126b) new C278141(this)));
                AppMethodBeat.m2505o(2945);
            }
        }

        C278121(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void bnU() {
            AppMethodBeat.m2504i(2947);
            C4990ab.m7416i(this.lmt.TAG, "onLongPressFinish");
            CaptureContainer.m44198a(this.lmt, this.lmt.mo45660a((C17126b) new C24751b(this)));
            AppMethodBeat.m2505o(2947);
        }

        /* renamed from: if */
        public final void mo30800if() {
            AppMethodBeat.m2504i(2948);
            MMSightRecordButton f = this.lmt.lmf;
            C11617a c11617a = C34006c.lhw;
            f.mo62335a(C34006c.lhs * 1000, C20443a.m31592dg(this.lmt), new C27813a(this));
            CaptureContainer captureContainer = this.lmt;
            C27794a c27794a = captureContainer.lmp;
            if (c27794a != null) {
                c27794a.aDm();
            }
            if (!captureContainer.lmr.mo20930EL()) {
                EmojiCaptureReporter.m66038up(33);
            }
            this.lmt.lmg.setEnabled(false);
            this.lmt.lmg.animate().alpha(0.0f).start();
            CaptureContainer.m44199a(this.lmt, false, 0);
            this.lmt.lmh.setVisibility(8);
            this.lmt.lmi.setShow(false);
            AppMethodBeat.m2505o(2948);
        }

        public final void bnV() {
            AppMethodBeat.m2504i(2949);
            C4990ab.m7416i(this.lmt.TAG, "onPressDown");
            int[] iArr = new int[2];
            this.lmt.lmf.getLocationOnScreen(iArr);
            this.lmt.lmr.mo20937km(iArr[1]);
            AppMethodBeat.m2505o(2949);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$3 */
    public static final class C278153 implements C39410c {
        final /* synthetic */ CaptureContainer lmt;

        C278153(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        /* renamed from: uF */
        public final void mo30822uF(int i) {
            AppMethodBeat.m2504i(2951);
            this.lmt.lmr.mo20934a(true, true, i);
            AppMethodBeat.m2505o(2951);
        }

        /* renamed from: uG */
        public final void mo30823uG(int i) {
            AppMethodBeat.m2504i(2952);
            this.lmt.lmr.mo20934a(false, true, i);
            AppMethodBeat.m2505o(2952);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getAudioBitrate", "", "getFilePath", "", "getRecordType", "getSampleRate", "getThumbPath", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$b */
    public static final class C27816b implements C42176b {
        C27816b() {
        }

        /* renamed from: Ww */
        public final int mo26019Ww() {
            return 2;
        }

        public final int getSampleRate() {
            return 0;
        }

        /* renamed from: Wx */
        public final int mo26020Wx() {
            return 0;
        }

        public final String getFilePath() {
            AppMethodBeat.m2504i(2963);
            C11617a c11617a = C34006c.lhw;
            String str = C11617a.bmO() + "video_" + C5046bo.anU();
            AppMethodBeat.m2505o(2963);
            return str;
        }

        /* renamed from: Wy */
        public final String mo26021Wy() {
            AppMethodBeat.m2504i(2964);
            C11617a c11617a = C34006c.lhw;
            String str = C11617a.bmO() + "temp_thumb" + C5046bo.anU();
            AppMethodBeat.m2505o(2964);
            return str;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$5 */
    static final class C278175 implements OnClickListener {
        final /* synthetic */ CaptureContainer lmt;

        C278175(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2957);
            C27794a presenter = this.lmt.getPresenter();
            if (presenter != null) {
                presenter.exit();
                AppMethodBeat.m2505o(2957);
                return;
            }
            AppMethodBeat.m2505o(2957);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$6 */
    static final class C278186 implements OnClickListener {
        final /* synthetic */ CaptureContainer lmt;

        C278186(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2958);
            this.lmt.mo45659Wg();
            AppMethodBeat.m2505o(2958);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$8 */
    static final class C278208 extends C25053k implements C17126b<C42971b, C37091y> {
        final /* synthetic */ CaptureContainer lmt;

        C278208(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(2960);
            C42971b c42971b = (C42971b) obj;
            C27794a presenter = this.lmt.getPresenter();
            if (presenter != null) {
                presenter.mo45632a(c42971b);
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2960);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$a */
    static final class C27821a extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ CaptureContainer lmt;
        final /* synthetic */ C42971b lmw;

        C27821a(CaptureContainer captureContainer, C42971b c42971b) {
            this.lmt = captureContainer;
            this.lmw = c42971b;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(2962);
            C20447b a = this.lmt.lme;
            C42971b c42971b = this.lmw;
            C1786a c1786a = a.eYL;
            if (c1786a != null) {
                if (c1786a instanceof C27807a) {
                    C27807a c27807a = (C27807a) c1786a;
                    c27807a.loL.boi();
                    c27807a.loL.mo73690a(c42971b);
                } else if (c1786a instanceof C42981f) {
                    C42981f c42981f = (C42981f) c1786a;
                    c42981f.loL.boi();
                    c42981f.loL.mo73690a(c42971b);
                }
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2962);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$c */
    static final class C27822c implements Runnable {
        final /* synthetic */ CaptureContainer lmt;

        C27822c(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void run() {
            AppMethodBeat.m2504i(2965);
            CaptureContainer.m44199a(this.lmt, false, 0);
            AppMethodBeat.m2505o(2965);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$d */
    static final class C27823d extends C25053k implements C17126b<Boolean, C37091y> {
        final /* synthetic */ CaptureContainer lmt;

        C27823d(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            boolean z;
            C34007d c34007d;
            AppMethodBeat.m2504i(2966);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            CaptureContainer captureContainer = this.lmt;
            if (this.lmt.lmr.fbz > 1) {
                z = true;
            } else {
                z = false;
            }
            C8902b.m16042a(new C20453e(captureContainer, z));
            this.lmt.lmi.boa();
            if (!booleanValue) {
                EmojiCaptureReporter.m66038up(9);
                c34007d = C34007d.lhz;
                C34007d.m55706Vm();
                if (this.lmt.mo45657WD()) {
                    c34007d = C34007d.lhz;
                    C34007d.bmU();
                } else {
                    c34007d = C34007d.lhz;
                    C34007d.bmT();
                }
            }
            if (this.lmt.mo45657WD()) {
                c34007d = C34007d.lhz;
                C34007d.bmS();
            } else {
                c34007d = C34007d.lhz;
                C34007d.bmR();
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(2966);
            return c37091y;
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m44199a(CaptureContainer captureContainer, boolean z, int i) {
        AppMethodBeat.m2504i(2985);
        captureContainer.m44208r(z, i);
        AppMethodBeat.m2505o(2985);
    }

    public CaptureContainer(final Context context, AttributeSet attributeSet, int i) {
        C25052j.m39376p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(2983);
        this.TAG = "MicroMsg.CaptureContainer";
        this.lme = new C20447b();
        this.lmq = new C27822c(this);
        View.inflate(context, 2130969323, this);
        View findViewById = findViewById(2131823418);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_preview_layout)");
        this.lmc = (ViewGroup) findViewById;
        findViewById = findViewById(2131823423);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_button)");
        this.lmf = (MMSightRecordButton) findViewById;
        findViewById = findViewById(2131823427);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_close)");
        this.lmg = findViewById;
        findViewById = findViewById(2131823424);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_flip_camera)");
        this.lmh = findViewById;
        findViewById = findViewById(2131823425);
        C25052j.m39375o(findViewById, "findViewById(R.id.voice_detect_hint)");
        this.lmj = findViewById;
        findViewById = findViewById(2131823419);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_decoration)");
        this.lmk = (CaptureDecoration) findViewById;
        findViewById = findViewById(2131823420);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_focus_frame)");
        this.lml = (CameraFrontSightView) findViewById;
        findViewById = findViewById(2131823421);
        C25052j.m39375o(findViewById, "findViewById(R.id.capture_touch_view)");
        this.lmm = (MMSightCaptureTouchView) findViewById;
        findViewById = findViewById(2131823426);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_hint)");
        this.lmn = (TextView) findViewById;
        findViewById = findViewById(2131823422);
        C25052j.m39375o(findViewById, "findViewById(R.id.emoji_capture_sticker_panel)");
        this.lmi = (EditorStickerView) findViewById;
        findViewById = findViewById(2131823428);
        C25052j.m39375o(findViewById, "findViewById(R.id.beauty_debug)");
        this.lmo = (Button) findViewById;
        int fromDPToPix = C1338a.fromDPToPix(context, 120);
        this.lml.mo36728ez(fromDPToPix, fromDPToPix);
        this.lmd = new EmojiCaptureGLTextureView(context);
        this.lmr = new C9615a(this);
        this.lmr.fbI = 600;
        this.lmc.addView(this.lmd);
        this.lmd.setOpaque(false);
        this.lmf.setHighLightOuter(C20443a.m31592dg(this));
        this.lmf.setLongPressCallback(new C278121(this));
        this.lmf.setSimpleTapCallback(new C204502(this));
        this.lmf.setLongPressScrollCallback(new C278153(this));
        this.lmm.setTouchCallback(new C204514(this));
        this.lmg.setOnClickListener(new C278175(this));
        this.lmh.setOnClickListener(new C278186(this));
        if (C5047bp.dpL()) {
            this.lmo.setVisibility(0);
            this.lmo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(2959);
                    context.startActivity(new Intent(context, EmojiCaptureBeautySettingUI.class));
                    AppMethodBeat.m2505o(2959);
                }
            });
        } else {
            this.lmo.setVisibility(8);
        }
        this.lmi.setCallback(new C278208(this));
        this.lmi.setVisibility(8);
        this.lmn.setAlpha(0.0f);
        post(new C204529(this));
        AppMethodBeat.m2505o(2983);
    }

    public CaptureContainer(Context context, AttributeSet attributeSet) {
        C25052j.m39376p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.m2504i(2984);
        AppMethodBeat.m2505o(2984);
    }

    public final C27794a getPresenter() {
        return this.lmp;
    }

    public final void setPresenter(C27794a c27794a) {
        this.lmp = c27794a;
    }

    public final EmojiCaptureReporter getReporter() {
        return this.lha;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        this.lha = emojiCaptureReporter;
    }

    public final void setup(EmojiInfo emojiInfo) {
        long j = 0;
        AppMethodBeat.m2504i(2968);
        if (emojiInfo != null) {
            this.lmk.setImitateEmoji(emojiInfo);
            EditorStickerView editorStickerView = this.lmi;
            EmojiCaptureReporter emojiCaptureReporter = this.lha;
            if (emojiCaptureReporter != null) {
                j = emojiCaptureReporter.ezZ;
            }
            String str = emojiInfo.field_lensId;
            if (str == null) {
                str = "";
            }
            editorStickerView.mo73699m(j, str);
            AppMethodBeat.m2505o(2968);
            return;
        }
        this.lmk.setImitateEmoji(null);
        EditorStickerView editorStickerView2 = this.lmi;
        EmojiCaptureReporter emojiCaptureReporter2 = this.lha;
        if (emojiCaptureReporter2 != null) {
            j = emojiCaptureReporter2.ezZ;
        }
        editorStickerView2.mo73699m(j, null);
        AppMethodBeat.m2505o(2968);
    }

    /* renamed from: a */
    public final void mo45637a(C42971b c42971b) {
        AppMethodBeat.m2504i(2969);
        this.lmk.setStickerInfo(c42971b);
        this.lmd.mo5344c((C31214a) new C27821a(this, c42971b));
        AppMethodBeat.m2505o(2969);
    }

    public final CaptureDecoration getDecoration() {
        return this.lmk;
    }

    /* renamed from: gB */
    public final void mo45638gB(boolean z) {
        AppMethodBeat.m2504i(2970);
        if (z) {
            this.lmj.setVisibility(0);
            AppMethodBeat.m2505o(2970);
            return;
        }
        this.lmj.setVisibility(8);
        AppMethodBeat.m2505o(2970);
    }

    /* renamed from: r */
    private final void m44208r(boolean z, int i) {
        AppMethodBeat.m2504i(2971);
        if (z) {
            removeCallbacks(this.lmq);
            this.lmn.animate().cancel();
            this.lmn.animate().alpha(1.0f).start();
            this.lmn.setText(i);
            postDelayed(this.lmq, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.m2505o(2971);
            return;
        }
        this.lmn.animate().cancel();
        this.lmn.animate().alpha(0.0f).start();
        AppMethodBeat.m2505o(2971);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(2972);
        C4990ab.m7416i(this.TAG, "setVisibility:".concat(String.valueOf(i)));
        super.setVisibility(i);
        this.lmg.setVisibility(i);
        if (i == 0) {
            this.lmf.setTouchEnable(true);
            this.lmi.boa();
        }
        if (i == 8) {
            this.lmd.setTextureChangeCallback(null);
            this.lmc.removeView(this.lmd);
            this.lmd = new EmojiCaptureGLTextureView(getContext());
            this.lmc.addView(this.lmd);
            this.lme = new C20447b();
            this.lmd.mo5341a((C37897a) this.lme, mo45657WD());
            this.lmd.setOpaque(false);
        }
        this.lmd.setVisibility(i);
        AppMethodBeat.m2505o(2972);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(2973);
        C4990ab.m7416i(this.TAG, "resumeCapture");
        mo45638gB(false);
        getDecoration().resume();
        this.lmr.mo20933a(this.lms, new C27823d(this));
        AppMethodBeat.m2505o(2973);
    }

    /* renamed from: a */
    public final boolean mo45660a(C17126b<? super C9614a, C37091y> c17126b) {
        AppMethodBeat.m2504i(2974);
        C27794a c27794a = this.lmp;
        if (c27794a != null) {
            c27794a.mo45630EB();
        }
        boolean a = this.lmr.mo20935a((C17126b) c17126b);
        AppMethodBeat.m2505o(2974);
        return a;
    }

    /* renamed from: Wg */
    public final boolean mo45659Wg() {
        AppMethodBeat.m2504i(2975);
        this.lms = this.lmr.mo20931Wg();
        EmojiCaptureReporter emojiCaptureReporter = this.lha;
        long j = emojiCaptureReporter != null ? emojiCaptureReporter.ezZ : 0;
        emojiCaptureReporter = this.lha;
        EmojiCaptureReporter.m66031a(5, j, 0, 0, 0, 0, 0, 0, 0, emojiCaptureReporter != null ? emojiCaptureReporter.scene : 0);
        boolean z = this.lms;
        AppMethodBeat.m2505o(2975);
        return z;
    }

    /* renamed from: WD */
    public final boolean mo45657WD() {
        AppMethodBeat.m2504i(2976);
        boolean z = ((C20425a) C27792a.lhc.mo53288Uw()).fau;
        AppMethodBeat.m2505o(2976);
        return z;
    }

    public final int getResolutionLimit() {
        AppMethodBeat.m2504i(2977);
        int i = ((C20425a) C27792a.lhc.mo53288Uw()).lhd;
        AppMethodBeat.m2505o(2977);
        return i;
    }

    public final C42176b getEncodeConfig() {
        AppMethodBeat.m2504i(2978);
        C42176b c27816b = new C27816b();
        AppMethodBeat.m2505o(2978);
        return c27816b;
    }

    /* renamed from: DX */
    public final boolean mo45656DX() {
        return true;
    }

    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.m2504i(2979);
        VideoTransPara videoTransPara = C12563j.ouz.fcY;
        if (videoTransPara != null) {
            AppMethodBeat.m2505o(2979);
            return videoTransPara;
        }
        videoTransPara = new VideoTransPara();
        AppMethodBeat.m2505o(2979);
        return videoTransPara;
    }

    public final C1791c getCameraPreviewView() {
        return this.lmd;
    }

    public final C37897a getRecordRenderer() {
        AppMethodBeat.m2504i(2980);
        C41265g c41265g = new C41265g();
        C11617a c11617a = C34006c.lhw;
        C34006c.lht;
        c11617a = C34006c.lhw;
        C34006c.lht;
        C37897a c37897a = c41265g;
        AppMethodBeat.m2505o(2980);
        return c37897a;
    }

    public final C37897a getPreviewRenderer() {
        return this.lme;
    }

    public final C1788b getRecorder() {
        AppMethodBeat.m2504i(2981);
        C37897a recordRenderer = getRecordRenderer();
        VideoTransPara videoTransPara = getVideoTransPara();
        EGLContext eGLContext = getCameraPreviewView().getEGLContext();
        if (eGLContext == null) {
            C25052j.dWJ();
        }
        C1788b c6630c = new C6630c(videoTransPara, recordRenderer, eGLContext, this.lmd.getPreviewTextureId());
        AppMethodBeat.m2505o(2981);
        return c6630c;
    }

    /* renamed from: WE */
    public final boolean mo45658WE() {
        AppMethodBeat.m2504i(2982);
        C20437a c20437a = EmojiCaptureProxy.lkM;
        boolean enableAutoRotate = EmojiCaptureProxy.lkL.getEnableAutoRotate();
        AppMethodBeat.m2505o(2982);
        return enableAutoRotate;
    }
}
