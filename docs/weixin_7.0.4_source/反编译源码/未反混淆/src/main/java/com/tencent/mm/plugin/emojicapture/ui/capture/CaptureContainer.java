package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
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
import com.tencent.mm.R;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureBeautySettingUI;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureGLTextureView;
import com.tencent.mm.plugin.emojicapture.ui.b.f;
import com.tencent.mm.plugin.emojicapture.ui.b.g;
import com.tencent.mm.plugin.mmsight.ui.CameraFrontSightView;
import com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

@l(dWo = {1, 1, 13}, dWp = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u000207H\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0016H\u0016J\b\u0010D\u001a\u00020EH\u0016J\n\u0010F\u001a\u0004\u0018\u00010GH\u0016J\n\u0010H\u001a\u0004\u0018\u00010GH\u0016J\n\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u00020\u000bH\u0016J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u000207H\u0016J\b\u0010O\u001a\u00020:H\u0016J\b\u0010P\u001a\u00020:H\u0016J\b\u0010Q\u001a\u00020:H\u0016J\u0010\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u000207H\u0002J\u0010\u0010T\u001a\u00020:2\u0006\u0010U\u001a\u00020\u000bH\u0016J\u0010\u0010V\u001a\u00020:2\b\u0010W\u001a\u0004\u0018\u00010XJ\b\u0010Y\u001a\u00020:H\u0016J-\u0010Z\u001a\u0002072#\u0010[\u001a\u001f\u0012\u0013\u0012\u00110?¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020:\u0018\u00010\\H\u0016J\b\u0010`\u001a\u000207H\u0016J\u0010\u0010a\u001a\u00020:2\u0006\u0010b\u001a\u000207H\u0016J\u0018\u0010c\u001a\u00020:2\u0006\u0010b\u001a\u0002072\u0006\u0010d\u001a\u00020\u000bH\u0002J\u0010\u0010e\u001a\u00020:2\u0006\u0010b\u001a\u000207H\u0016J\b\u0010f\u001a\u000207H\u0016J\b\u0010g\u001a\u000207H\u0016R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "beautyParaBtn", "Landroid/widget/Button;", "cameraContainer", "Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewContainer;", "captureCloseView", "Landroid/view/View;", "captureDecoration", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/CaptureDecoration;", "captureFlipCameraView", "captureFocus", "Lcom/tencent/mm/plugin/mmsight/ui/CameraFrontSightView;", "captureHint", "Landroid/widget/TextView;", "captureTouchView", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView;", "emojiCaptureButton", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton;", "emojiCaptureView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "emojiCaptureViewLayout", "Landroid/view/ViewGroup;", "hideHintRunnable", "Ljava/lang/Runnable;", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;)V", "renderer", "Lcom/tencent/mm/plugin/emojicapture/ui/gl/EmojiCaptureGLSurfaceTextureRenderer;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "getReporter", "()Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "setReporter", "(Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "stickerPanel", "Lcom/tencent/mm/plugin/emojicapture/ui/capture/EditorStickerView;", "useBackgroundCamera", "", "voiceDetectView", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "doRecordVideoInfo", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "enableCameraOrientationFit", "getCameraPreviewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "getDecoration", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRecordRenderer", "getRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "getResolutionLimit", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "isMute", "onDestroy", "onPause", "onResume", "recordStop", "legalStop", "setVisibility", "visibility", "setup", "imitateEmoji", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "startRecord", "stopRecord", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "capture", "switchCamera", "toggleFlipCamera", "show", "toggleHint", "resId", "toggleVoiceDetect", "useBackGroundCamera", "useCpuCrop", "plugin-emojicapture_release"})
public final class CaptureContainer extends RelativeLayout implements com.tencent.mm.media.widget.camerarecordview.c.a, com.tencent.mm.plugin.emojicapture.c.a.b {
    public final String TAG;
    private EmojiCaptureReporter lha;
    private final ViewGroup lmc;
    private EmojiCaptureGLTextureView lmd;
    public com.tencent.mm.plugin.emojicapture.ui.b.b lme;
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
    com.tencent.mm.plugin.emojicapture.c.a.a lmp;
    private final Runnable lmq;
    public com.tencent.mm.media.widget.camerarecordview.a lmr;
    public boolean lms;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onSimpleTap"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$2 */
    static final class AnonymousClass2 implements com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d {
        final /* synthetic */ CaptureContainer lmt;

        AnonymousClass2(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void bnX() {
            AppMethodBeat.i(2950);
            ab.i(this.lmt.TAG, "simpleTapCallback");
            CaptureContainer.a(this.lmt, false);
            AppMethodBeat.o(2950);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$4", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightCaptureTouchView$TouchCallback;", "onDoubleClick", "", "onTouchDown", "x", "", "y", "onZoomIn", "onZoomOut", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$4 */
    public static final class AnonymousClass4 implements com.tencent.mm.plugin.mmsight.ui.MMSightCaptureTouchView.a {
        final /* synthetic */ CaptureContainer lmt;

        AnonymousClass4(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void P(float f, float f2) {
            AppMethodBeat.i(2953);
            this.lmt.lmr.b(f, f2, this.lmt.lmd.getWidth(), this.lmt.lmd.getHeight());
            this.lmt.lml.X(f, f2);
            AppMethodBeat.o(2953);
        }

        public final void bnY() {
            AppMethodBeat.i(2954);
            this.lmt.lmr.Wp();
            this.lmt.Wg();
            AppMethodBeat.o(2954);
        }

        public final void asx() {
            AppMethodBeat.i(2955);
            this.lmt.lmr.a(true, false, 1);
            AppMethodBeat.o(2955);
        }

        public final void asy() {
            AppMethodBeat.i(2956);
            this.lmt.lmr.a(false, false, 1);
            AppMethodBeat.o(2956);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$9 */
    static final class AnonymousClass9 implements Runnable {
        final /* synthetic */ CaptureContainer lmt;

        AnonymousClass9(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void run() {
            AppMethodBeat.i(2961);
            CaptureContainer.a(this.lmt, true, R.string.ac8);
            AppMethodBeat.o(2961);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends k implements a.f.a.a<y> {
        final /* synthetic */ boolean iLX;
        final /* synthetic */ CaptureContainer lmt;

        e(CaptureContainer captureContainer, boolean z) {
            this.lmt = captureContainer;
            this.iLX = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2967);
            if (this.iLX) {
                this.lmt.lmh.setVisibility(0);
            } else {
                this.lmt.lmh.setVisibility(8);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2967);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$1", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressCallback;", "onLongPress", "", "onLongPressFinish", "onPressDown", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1 */
    public static final class AnonymousClass1 implements com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.b {
        final /* synthetic */ CaptureContainer lmt;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
        static final class b extends k implements a.f.a.b<com.tencent.mm.media.widget.camerarecordview.a.a, y> {
            final /* synthetic */ AnonymousClass1 lmu;

            b(AnonymousClass1 anonymousClass1) {
                this.lmu = anonymousClass1;
                super(1);
            }

            public final /* synthetic */ Object am(Object obj) {
                AppMethodBeat.i(2946);
                com.tencent.mm.media.widget.camerarecordview.a.a aVar = (com.tencent.mm.media.widget.camerarecordview.a.a) obj;
                j.p(aVar, "it");
                CaptureContainer.a(this.lmu.lmt, aVar);
                y yVar = y.AUy;
                AppMethodBeat.o(2946);
                return yVar;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onProgressFinish"})
        static final class a implements com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a {
            final /* synthetic */ AnonymousClass1 lmu;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/media/widget/camerarecordview/data/CameraCaptureInfo;", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$1$a$1 */
            static final class AnonymousClass1 extends k implements a.f.a.b<com.tencent.mm.media.widget.camerarecordview.a.a, y> {
                final /* synthetic */ a lmv;

                AnonymousClass1(a aVar) {
                    this.lmv = aVar;
                    super(1);
                }

                public final /* synthetic */ Object am(Object obj) {
                    AppMethodBeat.i(2944);
                    com.tencent.mm.media.widget.camerarecordview.a.a aVar = (com.tencent.mm.media.widget.camerarecordview.a.a) obj;
                    j.p(aVar, "it");
                    CaptureContainer.a(this.lmv.lmu.lmt, aVar);
                    y yVar = y.AUy;
                    AppMethodBeat.o(2944);
                    return yVar;
                }
            }

            a(AnonymousClass1 anonymousClass1) {
                this.lmu = anonymousClass1;
            }

            public final void bnW() {
                AppMethodBeat.i(2945);
                ab.i(this.lmu.lmt.TAG, "onLongPress");
                CaptureContainer.a(this.lmu.lmt, this.lmu.lmt.a((a.f.a.b) new AnonymousClass1(this)));
                AppMethodBeat.o(2945);
            }
        }

        AnonymousClass1(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void bnU() {
            AppMethodBeat.i(2947);
            ab.i(this.lmt.TAG, "onLongPressFinish");
            CaptureContainer.a(this.lmt, this.lmt.a((a.f.a.b) new b(this)));
            AppMethodBeat.o(2947);
        }

        /* renamed from: if */
        public final void m14if() {
            AppMethodBeat.i(2948);
            MMSightRecordButton f = this.lmt.lmf;
            com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
            f.a(com.tencent.mm.plugin.emojicapture.model.c.lhs * 1000, com.tencent.mm.plugin.emojicapture.ui.a.dg(this.lmt), new a(this));
            CaptureContainer captureContainer = this.lmt;
            com.tencent.mm.plugin.emojicapture.c.a.a aVar2 = captureContainer.lmp;
            if (aVar2 != null) {
                aVar2.aDm();
            }
            if (!captureContainer.lmr.EL()) {
                EmojiCaptureReporter.up(33);
            }
            this.lmt.lmg.setEnabled(false);
            this.lmt.lmg.animate().alpha(0.0f).start();
            CaptureContainer.a(this.lmt, false, 0);
            this.lmt.lmh.setVisibility(8);
            this.lmt.lmi.setShow(false);
            AppMethodBeat.o(2948);
        }

        public final void bnV() {
            AppMethodBeat.i(2949);
            ab.i(this.lmt.TAG, "onPressDown");
            int[] iArr = new int[2];
            this.lmt.lmf.getLocationOnScreen(iArr);
            this.lmt.lmr.km(iArr[1]);
            AppMethodBeat.o(2949);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$3 */
    public static final class AnonymousClass3 implements com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c {
        final /* synthetic */ CaptureContainer lmt;

        AnonymousClass3(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void uF(int i) {
            AppMethodBeat.i(2951);
            this.lmt.lmr.a(true, true, i);
            AppMethodBeat.o(2951);
        }

        public final void uG(int i) {
            AppMethodBeat.i(2952);
            this.lmt.lmr.a(false, true, i);
            AppMethodBeat.o(2952);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getAudioBitrate", "", "getFilePath", "", "getRecordType", "getSampleRate", "getThumbPath", "plugin-emojicapture_release"})
    public static final class b implements com.tencent.mm.media.widget.camerarecordview.a.b {
        b() {
        }

        public final int Ww() {
            return 2;
        }

        public final int getSampleRate() {
            return 0;
        }

        public final int Wx() {
            return 0;
        }

        public final String getFilePath() {
            AppMethodBeat.i(2963);
            com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
            String str = com.tencent.mm.plugin.emojicapture.model.c.a.bmO() + "video_" + bo.anU();
            AppMethodBeat.o(2963);
            return str;
        }

        public final String Wy() {
            AppMethodBeat.i(2964);
            com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
            String str = com.tencent.mm.plugin.emojicapture.model.c.a.bmO() + "temp_thumb" + bo.anU();
            AppMethodBeat.o(2964);
            return str;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$5 */
    static final class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ CaptureContainer lmt;

        AnonymousClass5(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(2957);
            com.tencent.mm.plugin.emojicapture.c.a.a presenter = this.lmt.getPresenter();
            if (presenter != null) {
                presenter.exit();
                AppMethodBeat.o(2957);
                return;
            }
            AppMethodBeat.o(2957);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$6 */
    static final class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ CaptureContainer lmt;

        AnonymousClass6(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(2958);
            this.lmt.Wg();
            AppMethodBeat.o(2958);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer$8 */
    static final class AnonymousClass8 extends k implements a.f.a.b<com.tencent.mm.plugin.emojicapture.model.a.b, y> {
        final /* synthetic */ CaptureContainer lmt;

        AnonymousClass8(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(2960);
            com.tencent.mm.plugin.emojicapture.model.a.b bVar = (com.tencent.mm.plugin.emojicapture.model.a.b) obj;
            com.tencent.mm.plugin.emojicapture.c.a.a presenter = this.lmt.getPresenter();
            if (presenter != null) {
                presenter.a(bVar);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2960);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class a extends k implements a.f.a.a<y> {
        final /* synthetic */ CaptureContainer lmt;
        final /* synthetic */ com.tencent.mm.plugin.emojicapture.model.a.b lmw;

        a(CaptureContainer captureContainer, com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
            this.lmt = captureContainer;
            this.lmw = bVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(2962);
            com.tencent.mm.plugin.emojicapture.ui.b.b a = this.lmt.lme;
            com.tencent.mm.plugin.emojicapture.model.a.b bVar = this.lmw;
            com.tencent.mm.media.h.b.a aVar = a.eYL;
            if (aVar != null) {
                if (aVar instanceof com.tencent.mm.plugin.emojicapture.ui.b.a) {
                    com.tencent.mm.plugin.emojicapture.ui.b.a aVar2 = (com.tencent.mm.plugin.emojicapture.ui.b.a) aVar;
                    aVar2.loL.boi();
                    aVar2.loL.a(bVar);
                } else if (aVar instanceof f) {
                    f fVar = (f) aVar;
                    fVar.loL.boi();
                    fVar.loL.a(bVar);
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2962);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ CaptureContainer lmt;

        c(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
        }

        public final void run() {
            AppMethodBeat.i(2965);
            CaptureContainer.a(this.lmt, false, 0);
            AppMethodBeat.o(2965);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class d extends k implements a.f.a.b<Boolean, y> {
        final /* synthetic */ CaptureContainer lmt;

        d(CaptureContainer captureContainer) {
            this.lmt = captureContainer;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            com.tencent.mm.plugin.emojicapture.model.d dVar;
            AppMethodBeat.i(2966);
            boolean booleanValue = ((Boolean) obj).booleanValue();
            CaptureContainer captureContainer = this.lmt;
            if (this.lmt.lmr.fbz > 1) {
                z = true;
            } else {
                z = false;
            }
            com.tencent.mm.ab.b.a(new e(captureContainer, z));
            this.lmt.lmi.boa();
            if (!booleanValue) {
                EmojiCaptureReporter.up(9);
                dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                com.tencent.mm.plugin.emojicapture.model.d.Vm();
                if (this.lmt.WD()) {
                    dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                    com.tencent.mm.plugin.emojicapture.model.d.bmU();
                } else {
                    dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                    com.tencent.mm.plugin.emojicapture.model.d.bmT();
                }
            }
            if (this.lmt.WD()) {
                dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                com.tencent.mm.plugin.emojicapture.model.d.bmS();
            } else {
                dVar = com.tencent.mm.plugin.emojicapture.model.d.lhz;
                com.tencent.mm.plugin.emojicapture.model.d.bmR();
            }
            y yVar = y.AUy;
            AppMethodBeat.o(2966);
            return yVar;
        }
    }

    public static final /* synthetic */ void a(CaptureContainer captureContainer, boolean z, int i) {
        AppMethodBeat.i(2985);
        captureContainer.r(z, i);
        AppMethodBeat.o(2985);
    }

    public CaptureContainer(final Context context, AttributeSet attributeSet, int i) {
        j.p(context, "context");
        super(context, attributeSet, i);
        AppMethodBeat.i(2983);
        this.TAG = "MicroMsg.CaptureContainer";
        this.lme = new com.tencent.mm.plugin.emojicapture.ui.b.b();
        this.lmq = new c(this);
        View.inflate(context, R.layout.tf, this);
        View findViewById = findViewById(R.id.bco);
        j.o(findViewById, "findViewById(R.id.emoji_capture_preview_layout)");
        this.lmc = (ViewGroup) findViewById;
        findViewById = findViewById(R.id.bct);
        j.o(findViewById, "findViewById(R.id.emoji_capture_button)");
        this.lmf = (MMSightRecordButton) findViewById;
        findViewById = findViewById(R.id.bcx);
        j.o(findViewById, "findViewById(R.id.capture_close)");
        this.lmg = findViewById;
        findViewById = findViewById(R.id.bcu);
        j.o(findViewById, "findViewById(R.id.capture_flip_camera)");
        this.lmh = findViewById;
        findViewById = findViewById(R.id.bcv);
        j.o(findViewById, "findViewById(R.id.voice_detect_hint)");
        this.lmj = findViewById;
        findViewById = findViewById(R.id.bcp);
        j.o(findViewById, "findViewById(R.id.capture_decoration)");
        this.lmk = (CaptureDecoration) findViewById;
        findViewById = findViewById(R.id.bcq);
        j.o(findViewById, "findViewById(R.id.capture_focus_frame)");
        this.lml = (CameraFrontSightView) findViewById;
        findViewById = findViewById(R.id.bcr);
        j.o(findViewById, "findViewById(R.id.capture_touch_view)");
        this.lmm = (MMSightCaptureTouchView) findViewById;
        findViewById = findViewById(R.id.bcw);
        j.o(findViewById, "findViewById(R.id.emoji_capture_hint)");
        this.lmn = (TextView) findViewById;
        findViewById = findViewById(R.id.bcs);
        j.o(findViewById, "findViewById(R.id.emoji_capture_sticker_panel)");
        this.lmi = (EditorStickerView) findViewById;
        findViewById = findViewById(R.id.bcy);
        j.o(findViewById, "findViewById(R.id.beauty_debug)");
        this.lmo = (Button) findViewById;
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(context, 120);
        this.lml.ez(fromDPToPix, fromDPToPix);
        this.lmd = new EmojiCaptureGLTextureView(context);
        this.lmr = new com.tencent.mm.media.widget.camerarecordview.a(this);
        this.lmr.fbI = 600;
        this.lmc.addView(this.lmd);
        this.lmd.setOpaque(false);
        this.lmf.setHighLightOuter(com.tencent.mm.plugin.emojicapture.ui.a.dg(this));
        this.lmf.setLongPressCallback(new AnonymousClass1(this));
        this.lmf.setSimpleTapCallback(new AnonymousClass2(this));
        this.lmf.setLongPressScrollCallback(new AnonymousClass3(this));
        this.lmm.setTouchCallback(new AnonymousClass4(this));
        this.lmg.setOnClickListener(new AnonymousClass5(this));
        this.lmh.setOnClickListener(new AnonymousClass6(this));
        if (bp.dpL()) {
            this.lmo.setVisibility(0);
            this.lmo.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(2959);
                    context.startActivity(new Intent(context, EmojiCaptureBeautySettingUI.class));
                    AppMethodBeat.o(2959);
                }
            });
        } else {
            this.lmo.setVisibility(8);
        }
        this.lmi.setCallback(new AnonymousClass8(this));
        this.lmi.setVisibility(8);
        this.lmn.setAlpha(0.0f);
        post(new AnonymousClass9(this));
        AppMethodBeat.o(2983);
    }

    public CaptureContainer(Context context, AttributeSet attributeSet) {
        j.p(context, "context");
        this(context, attributeSet, 0);
        AppMethodBeat.i(2984);
        AppMethodBeat.o(2984);
    }

    public final com.tencent.mm.plugin.emojicapture.c.a.a getPresenter() {
        return this.lmp;
    }

    public final void setPresenter(com.tencent.mm.plugin.emojicapture.c.a.a aVar) {
        this.lmp = aVar;
    }

    public final EmojiCaptureReporter getReporter() {
        return this.lha;
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        this.lha = emojiCaptureReporter;
    }

    public final void setup(EmojiInfo emojiInfo) {
        long j = 0;
        AppMethodBeat.i(2968);
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
            editorStickerView.m(j, str);
            AppMethodBeat.o(2968);
            return;
        }
        this.lmk.setImitateEmoji(null);
        EditorStickerView editorStickerView2 = this.lmi;
        EmojiCaptureReporter emojiCaptureReporter2 = this.lha;
        if (emojiCaptureReporter2 != null) {
            j = emojiCaptureReporter2.ezZ;
        }
        editorStickerView2.m(j, null);
        AppMethodBeat.o(2968);
    }

    public final void a(com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
        AppMethodBeat.i(2969);
        this.lmk.setStickerInfo(bVar);
        this.lmd.c((a.f.a.a) new a(this, bVar));
        AppMethodBeat.o(2969);
    }

    public final CaptureDecoration getDecoration() {
        return this.lmk;
    }

    public final void gB(boolean z) {
        AppMethodBeat.i(2970);
        if (z) {
            this.lmj.setVisibility(0);
            AppMethodBeat.o(2970);
            return;
        }
        this.lmj.setVisibility(8);
        AppMethodBeat.o(2970);
    }

    private final void r(boolean z, int i) {
        AppMethodBeat.i(2971);
        if (z) {
            removeCallbacks(this.lmq);
            this.lmn.animate().cancel();
            this.lmn.animate().alpha(1.0f).start();
            this.lmn.setText(i);
            postDelayed(this.lmq, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
            AppMethodBeat.o(2971);
            return;
        }
        this.lmn.animate().cancel();
        this.lmn.animate().alpha(0.0f).start();
        AppMethodBeat.o(2971);
    }

    public final void setVisibility(int i) {
        AppMethodBeat.i(2972);
        ab.i(this.TAG, "setVisibility:".concat(String.valueOf(i)));
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
            this.lme = new com.tencent.mm.plugin.emojicapture.ui.b.b();
            this.lmd.a((com.tencent.mm.media.h.a) this.lme, WD());
            this.lmd.setOpaque(false);
        }
        this.lmd.setVisibility(i);
        AppMethodBeat.o(2972);
    }

    public final void onResume() {
        AppMethodBeat.i(2973);
        ab.i(this.TAG, "resumeCapture");
        gB(false);
        getDecoration().resume();
        this.lmr.a(this.lms, new d(this));
        AppMethodBeat.o(2973);
    }

    public final boolean a(a.f.a.b<? super com.tencent.mm.media.widget.camerarecordview.a.a, y> bVar) {
        AppMethodBeat.i(2974);
        com.tencent.mm.plugin.emojicapture.c.a.a aVar = this.lmp;
        if (aVar != null) {
            aVar.EB();
        }
        boolean a = this.lmr.a((a.f.a.b) bVar);
        AppMethodBeat.o(2974);
        return a;
    }

    public final boolean Wg() {
        AppMethodBeat.i(2975);
        this.lms = this.lmr.Wg();
        EmojiCaptureReporter emojiCaptureReporter = this.lha;
        long j = emojiCaptureReporter != null ? emojiCaptureReporter.ezZ : 0;
        emojiCaptureReporter = this.lha;
        EmojiCaptureReporter.a(5, j, 0, 0, 0, 0, 0, 0, 0, emojiCaptureReporter != null ? emojiCaptureReporter.scene : 0);
        boolean z = this.lms;
        AppMethodBeat.o(2975);
        return z;
    }

    public final boolean WD() {
        AppMethodBeat.i(2976);
        boolean z = ((com.tencent.mm.plugin.emojicapture.b.a.a) com.tencent.mm.plugin.emojicapture.b.a.lhc.Uw()).fau;
        AppMethodBeat.o(2976);
        return z;
    }

    public final int getResolutionLimit() {
        AppMethodBeat.i(2977);
        int i = ((com.tencent.mm.plugin.emojicapture.b.a.a) com.tencent.mm.plugin.emojicapture.b.a.lhc.Uw()).lhd;
        AppMethodBeat.o(2977);
        return i;
    }

    public final com.tencent.mm.media.widget.camerarecordview.a.b getEncodeConfig() {
        AppMethodBeat.i(2978);
        com.tencent.mm.media.widget.camerarecordview.a.b bVar = new b();
        AppMethodBeat.o(2978);
        return bVar;
    }

    public final boolean DX() {
        return true;
    }

    public final VideoTransPara getVideoTransPara() {
        AppMethodBeat.i(2979);
        VideoTransPara videoTransPara = com.tencent.mm.plugin.mmsight.model.j.ouz.fcY;
        if (videoTransPara != null) {
            AppMethodBeat.o(2979);
            return videoTransPara;
        }
        videoTransPara = new VideoTransPara();
        AppMethodBeat.o(2979);
        return videoTransPara;
    }

    public final com.tencent.mm.media.widget.camerarecordview.preview.c getCameraPreviewView() {
        return this.lmd;
    }

    public final com.tencent.mm.media.h.a getRecordRenderer() {
        AppMethodBeat.i(2980);
        g gVar = new g();
        com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        com.tencent.mm.plugin.emojicapture.model.c.lht;
        aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        com.tencent.mm.plugin.emojicapture.model.c.lht;
        com.tencent.mm.media.h.a aVar2 = gVar;
        AppMethodBeat.o(2980);
        return aVar2;
    }

    public final com.tencent.mm.media.h.a getPreviewRenderer() {
        return this.lme;
    }

    public final com.tencent.mm.media.widget.b.b getRecorder() {
        AppMethodBeat.i(2981);
        com.tencent.mm.media.h.a recordRenderer = getRecordRenderer();
        VideoTransPara videoTransPara = getVideoTransPara();
        EGLContext eGLContext = getCameraPreviewView().getEGLContext();
        if (eGLContext == null) {
            j.dWJ();
        }
        com.tencent.mm.media.widget.b.b cVar = new com.tencent.mm.media.widget.b.c(videoTransPara, recordRenderer, eGLContext, this.lmd.getPreviewTextureId());
        AppMethodBeat.o(2981);
        return cVar;
    }

    public final boolean WE() {
        AppMethodBeat.i(2982);
        com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a aVar = EmojiCaptureProxy.lkM;
        boolean enableAutoRotate = EmojiCaptureProxy.lkL.getEnableAutoRotate();
        AppMethodBeat.o(2982);
        return enableAutoRotate;
    }
}
