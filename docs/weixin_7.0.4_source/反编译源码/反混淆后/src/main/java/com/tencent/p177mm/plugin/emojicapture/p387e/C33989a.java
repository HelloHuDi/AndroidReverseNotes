package com.tencent.p177mm.plugin.emojicapture.p387e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c;
import com.tencent.p177mm.plugin.emojicapture.model.C34006c.C11617a;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C27800a;
import com.tencent.p177mm.plugin.emojicapture.model.p950a.C42971b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiCaptureUI.C34010b;
import com.tencent.p177mm.plugin.emojicapture.p389ui.EmojiCaptureUI.C34010b.C34011a;
import com.tencent.p177mm.plugin.emojicapture.p949c.C27793a.C27794a;
import com.tencent.p177mm.plugin.emojicapture.p949c.C27793a.C27795b;
import com.tencent.p177mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.p177mm.plugin.emojicapture.proxy.VoiceInputProxy.C11620b;
import com.tencent.p177mm.plugin.mmsight.model.C12563j;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002*+B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u000eH\u0016J\b\u0010)\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.e.a */
public final class C33989a implements C27794a {
    public static final C2956a ljW = new C2956a();
    private Context context;
    private final C46607d ext = new C46607d(this.context);
    private final EmojiCaptureReporter lha;
    private C2957b ljL = C2957b.RECORD_STATE_IDLE;
    private long ljM;
    private boolean ljN;
    private boolean ljO;
    private String ljP;
    private final C27800a ljQ = new C27800a();
    private VoiceInputProxy ljR = new VoiceInputProxy(new C33988f(this), this.ext);
    private final C7564ap ljS = new C7564ap(new C33987e(this), true);
    private C27795b ljT;
    private final VideoTransPara ljU;
    private C34010b ljV;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$a */
    public static final class C2956a {
        private C2956a() {
        }

        public /* synthetic */ C2956a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "", "(Ljava/lang/String;I)V", "RECORD_STATE_IDLE", "RECORD_STATE_PREVIEW", "RECORD_STATE_PREVIEW_PAUSED", "RECORD_STATE_STARTED", "RECORD_STATE_STOP", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$b */
    public enum C2957b {
        RECORD_STATE_IDLE,
        RECORD_STATE_PREVIEW,
        RECORD_STATE_PREVIEW_PAUSED,
        RECORD_STATE_STARTED,
        RECORD_STATE_STOP;

        static {
            AppMethodBeat.m2505o(2738);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$c */
    static final class C33986c implements Runnable {
        final /* synthetic */ C33989a lke;

        C33986c(C33989a c33989a) {
            this.lke = c33989a;
        }

        public final void run() {
            AppMethodBeat.m2504i(2741);
            C4990ab.m7416i("MicroMsg.CapturePresenter", "voice finish called force");
            if (!this.lke.ljO) {
                this.lke.ljV.mo45645Kc(this.lke.ljP);
            }
            this.lke.ljO = true;
            AppMethodBeat.m2505o(2741);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTimerExpired"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$e */
    static final class C33987e implements C5015a {
        final /* synthetic */ C33989a lke;

        C33987e(C33989a c33989a) {
            this.lke = c33989a;
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            int maxAmplitudeRate;
            boolean z = false;
            AppMethodBeat.m2504i(2743);
            if (this.lke.ljR != null) {
                VoiceInputProxy e = this.lke.ljR;
                maxAmplitudeRate = e != null ? e.getMaxAmplitudeRate() : 0;
            } else {
                maxAmplitudeRate = 0;
            }
            C27795b f = this.lke.ljT;
            if (maxAmplitudeRate > 10) {
                z = true;
            }
            f.mo45638gB(z);
            AppMethodBeat.m2505o(2743);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$f */
    public static final class C33988f implements C11620b {
        final /* synthetic */ C33989a lke;

        C33988f(C33989a c33989a) {
            this.lke = c33989a;
        }

        public final void onRes(String str) {
            AppMethodBeat.m2504i(2744);
            C4990ab.m7416i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(str)));
            this.lke.ljP = str;
            AppMethodBeat.m2505o(2744);
        }

        public final void amw() {
            AppMethodBeat.m2504i(2745);
            C4990ab.m7416i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
            if (!this.lke.ljO) {
                this.lke.ljV.mo45645Kc(this.lke.ljP);
            }
            this.lke.ljO = true;
            AppMethodBeat.m2505o(2745);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$d */
    static final class C33990d implements OnCancelListener {
        final /* synthetic */ C33989a lke;

        C33990d(C33989a c33989a) {
            this.lke = c33989a;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(2742);
            this.lke.ljV.bnN();
            AppMethodBeat.m2505o(2742);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.a$1 */
    static final class C339911 implements Runnable {
        public static final C339911 ljX = new C339911();

        static {
            AppMethodBeat.m2504i(2737);
            AppMethodBeat.m2505o(2737);
        }

        C339911() {
        }

        public final void run() {
            AppMethodBeat.m2504i(2736);
            C4990ab.m7416i("MicroMsg.CapturePresenter", "proxy connected");
            AppMethodBeat.m2505o(2736);
        }
    }

    static {
        AppMethodBeat.m2504i(2754);
        AppMethodBeat.m2505o(2754);
    }

    public C33989a(Context context, C27795b c27795b, VideoTransPara videoTransPara, C34010b c34010b, EmojiCaptureReporter emojiCaptureReporter) {
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c27795b, "view");
        C25052j.m39376p(videoTransPara, "videoPara");
        C25052j.m39376p(c34010b, "uiNavigation");
        C25052j.m39376p(emojiCaptureReporter, "reporter");
        AppMethodBeat.m2504i(2753);
        this.context = context;
        this.ljT = c27795b;
        this.ljU = videoTransPara;
        this.ljV = c34010b;
        this.lha = emojiCaptureReporter;
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        this.ext.connect(C339911.ljX);
        VideoTransPara videoTransPara2 = this.ljU;
        C11617a c11617a = C34006c.lhw;
        videoTransPara2.width = C34006c.lht;
        videoTransPara2 = this.ljU;
        c11617a = C34006c.lhw;
        videoTransPara2.height = C34006c.lht;
        this.ljU.videoBitrate = GmsVersion.VERSION_LONGHORN;
        C12563j.ouz.videoBitrate = this.ljU.videoBitrate;
        C12563j.ouz.fcY = this.ljU;
        this.ljQ.scene = this.lha.scene;
        this.ljQ.ezZ = this.lha.ezZ;
        AppMethodBeat.m2505o(2753);
    }

    /* renamed from: pk */
    public final void mo45636pk() {
        AppMethodBeat.m2504i(2746);
        C4990ab.m7416i("MicroMsg.CapturePresenter", "pauseCapture " + this.ljO);
        if (this.ljP != null || this.ljO) {
            this.ljV.mo45645Kc(this.ljP);
            AppMethodBeat.m2505o(2746);
            return;
        }
        C5004al.m7442n(new C33986c(this), 1500);
        AppMethodBeat.m2505o(2746);
    }

    public final void aDm() {
        AppMethodBeat.m2504i(2747);
        C4990ab.m7416i("MicroMsg.CapturePresenter", "start record " + this.ljL);
        this.ljQ.setVideoPath("");
        this.ljQ.mo45642mb("");
        this.ljP = this.ljT.getDecoration().getText();
        this.ljT.getDecoration().lmz.reset();
        this.ljN = this.ljP == null;
        C4990ab.m7416i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.ljN);
        if (this.ljN && (C25052j.m39373j("NON_NETWORK", C5023at.getNetTypeString(C4996ah.getContext())) ^ 1) != 0) {
            VoiceInputProxy voiceInputProxy = this.ljR;
            if (voiceInputProxy != null) {
                voiceInputProxy.start();
            }
            this.ljS.mo16773ms(50);
        }
        this.ljO = false;
        this.ljL = C2957b.RECORD_STATE_STARTED;
        this.ljM = C5046bo.m7588yz();
        this.lha.lgL = System.currentTimeMillis();
        EmojiCaptureReporter.m66031a(3, this.lha.ezZ, 0, 0, 0, 0, 0, 0, 0, this.lha.scene);
        AppMethodBeat.m2505o(2747);
    }

    /* renamed from: EB */
    public final boolean mo45630EB() {
        AppMethodBeat.m2504i(2748);
        C4990ab.m7416i("MicroMsg.CapturePresenter", "stop record " + this.ljL);
        if (this.ljL == C2957b.RECORD_STATE_STOP) {
            AppMethodBeat.m2505o(2748);
            return true;
        }
        this.ljL = C2957b.RECORD_STATE_STOP;
        VoiceInputProxy voiceInputProxy;
        if (C5046bo.m7525az(this.ljM) < 600) {
            voiceInputProxy = this.ljR;
            if (voiceInputProxy != null) {
                voiceInputProxy.stop(true);
            }
            this.ljL = C2957b.RECORD_STATE_PREVIEW;
            AppMethodBeat.m2505o(2748);
            return false;
        }
        C34010b c34010b = this.ljV;
        Context context = this.context;
        String string = this.context.getString(C25738R.string.cn5);
        C25052j.m39375o(string, "context.getString(R.string.loading_tips)");
        c34010b.mo45646a(context, string, true, new C33990d(this));
        this.ljT.getDecoration().lmz.pause();
        if (this.ljN) {
            voiceInputProxy = this.ljR;
            if (voiceInputProxy != null) {
                voiceInputProxy.stop(true);
            }
            this.ljS.stopTimer();
        }
        this.lha.lgM = System.currentTimeMillis();
        this.lha.euE = this.lha.lgM - this.lha.lgL;
        EmojiCaptureReporter.m66031a(4, this.lha.ezZ, 0, this.lha.euE, 0, 0, 0, 0, 0, this.lha.scene);
        AppMethodBeat.m2505o(2748);
        return true;
    }

    /* renamed from: a */
    public final void mo45631a(C27800a c27800a) {
        boolean z;
        AppMethodBeat.m2504i(2749);
        C25052j.m39376p(c27800a, "info");
        C4990ab.m7416i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
        this.ljQ.setVideoPath(c27800a.videoPath);
        this.ljQ.mo45642mb(c27800a.thumbPath);
        this.ljQ.lhI = this.ljP;
        this.ljQ.lhJ = c27800a.lhJ;
        C27800a c27800a2 = this.ljQ;
        if (this.ljQ.lhH == null) {
            z = true;
        } else {
            z = false;
        }
        c27800a2.lhK = z;
        this.ljQ.lgS = c27800a.lgS;
        this.ljV.mo45650c(this.ljQ);
        AppMethodBeat.m2505o(2749);
    }

    public final void exit() {
        AppMethodBeat.m2504i(2750);
        C34011a.m55726a(this.ljV, false);
        AppMethodBeat.m2505o(2750);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(2751);
        this.ext.release();
        VoiceInputProxy voiceInputProxy = this.ljR;
        if (voiceInputProxy != null) {
            voiceInputProxy.setUiCallback(null);
            AppMethodBeat.m2505o(2751);
            return;
        }
        AppMethodBeat.m2505o(2751);
    }

    /* renamed from: a */
    public final void mo45632a(C42971b c42971b) {
        AppMethodBeat.m2504i(2752);
        C4990ab.m7416i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(c42971b)));
        this.ljQ.lhH = c42971b;
        this.ljT.mo45637a(c42971b);
        AppMethodBeat.m2505o(2752);
    }
}
