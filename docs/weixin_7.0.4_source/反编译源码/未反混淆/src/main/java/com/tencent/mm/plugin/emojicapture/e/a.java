package com.tencent.mm.plugin.emojicapture.e;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.google.android.gms.common.util.GmsVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

@l(dWo = {1, 1, 13}, dWp = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002*+B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\b\u0010&\u001a\u00020\u001fH\u0016J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u000eH\u0016J\b\u0010)\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/CaptureContract$IView;Lcom/tencent/mm/modelcontrol/VideoTransPara;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "recordStartTime", "", "recordState", "Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "useVoiceInput", "", "voiceDetectTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "voiceFinished", "voiceInput", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy;", "voiceText", "", "changeSticker", "", "stickerInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiStickerInfo;", "checkNetworkAvailable", "destroy", "exit", "pauseCapture", "startRecord", "stopCallBack", "info", "stopRecord", "Companion", "RecordState", "plugin-emojicapture_release"})
public final class a implements com.tencent.mm.plugin.emojicapture.c.a.a {
    public static final a ljW = new a();
    private Context context;
    private final com.tencent.mm.remoteservice.d ext = new com.tencent.mm.remoteservice.d(this.context);
    private final EmojiCaptureReporter lha;
    private b ljL = b.RECORD_STATE_IDLE;
    private long ljM;
    private boolean ljN;
    private boolean ljO;
    private String ljP;
    private final com.tencent.mm.plugin.emojicapture.model.a.a ljQ = new com.tencent.mm.plugin.emojicapture.model.a.a();
    private VoiceInputProxy ljR = new VoiceInputProxy(new f(this), this.ext);
    private final ap ljS = new ap(new e(this), true);
    private com.tencent.mm.plugin.emojicapture.c.a.b ljT;
    private final VideoTransPara ljU;
    private com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b ljV;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$RecordState;", "", "(Ljava/lang/String;I)V", "RECORD_STATE_IDLE", "RECORD_STATE_PREVIEW", "RECORD_STATE_PREVIEW_PAUSED", "RECORD_STATE_STARTED", "RECORD_STATE_STOP", "plugin-emojicapture_release"})
    public enum b {
        RECORD_STATE_IDLE,
        RECORD_STATE_PREVIEW,
        RECORD_STATE_PREVIEW_PAUSED,
        RECORD_STATE_STARTED,
        RECORD_STATE_STOP;

        static {
            AppMethodBeat.o(2738);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ a lke;

        c(a aVar) {
            this.lke = aVar;
        }

        public final void run() {
            AppMethodBeat.i(2741);
            ab.i("MicroMsg.CapturePresenter", "voice finish called force");
            if (!this.lke.ljO) {
                this.lke.ljV.Kc(this.lke.ljP);
            }
            this.lke.ljO = true;
            AppMethodBeat.o(2741);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "onTimerExpired"})
    static final class e implements com.tencent.mm.sdk.platformtools.ap.a {
        final /* synthetic */ a lke;

        e(a aVar) {
            this.lke = aVar;
        }

        public final boolean BI() {
            int maxAmplitudeRate;
            boolean z = false;
            AppMethodBeat.i(2743);
            if (this.lke.ljR != null) {
                VoiceInputProxy e = this.lke.ljR;
                maxAmplitudeRate = e != null ? e.getMaxAmplitudeRate() : 0;
            } else {
                maxAmplitudeRate = 0;
            }
            com.tencent.mm.plugin.emojicapture.c.a.b f = this.lke.ljT;
            if (maxAmplitudeRate > 10) {
                z = true;
            }
            f.gB(z);
            AppMethodBeat.o(2743);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, dWq = {"com/tencent/mm/plugin/emojicapture/presenter/CapturePresenter$voiceInput$1", "Lcom/tencent/mm/plugin/emojicapture/proxy/VoiceInputProxy$UICallback;", "onRecognizeFinish", "", "onRes", "voiceText", "", "plugin-emojicapture_release"})
    public static final class f implements com.tencent.mm.plugin.emojicapture.proxy.VoiceInputProxy.b {
        final /* synthetic */ a lke;

        f(a aVar) {
            this.lke = aVar;
        }

        public final void onRes(String str) {
            AppMethodBeat.i(2744);
            ab.i("MicroMsg.CapturePresenter", "onRes ".concat(String.valueOf(str)));
            this.lke.ljP = str;
            AppMethodBeat.o(2744);
        }

        public final void amw() {
            AppMethodBeat.i(2745);
            ab.i("MicroMsg.CapturePresenter", "onRecognizeFinish voice finish called");
            if (!this.lke.ljO) {
                this.lke.ljV.Kc(this.lke.ljP);
            }
            this.lke.ljO = true;
            AppMethodBeat.o(2745);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class d implements OnCancelListener {
        final /* synthetic */ a lke;

        d(a aVar) {
            this.lke = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(2742);
            this.lke.ljV.bnN();
            AppMethodBeat.o(2742);
        }
    }

    static {
        AppMethodBeat.i(2754);
        AppMethodBeat.o(2754);
    }

    public a(Context context, com.tencent.mm.plugin.emojicapture.c.a.b bVar, VideoTransPara videoTransPara, com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b bVar2, EmojiCaptureReporter emojiCaptureReporter) {
        j.p(context, "context");
        j.p(bVar, "view");
        j.p(videoTransPara, "videoPara");
        j.p(bVar2, "uiNavigation");
        j.p(emojiCaptureReporter, "reporter");
        AppMethodBeat.i(2753);
        this.context = context;
        this.ljT = bVar;
        this.ljU = videoTransPara;
        this.ljV = bVar2;
        this.lha = emojiCaptureReporter;
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        this.ext.connect(AnonymousClass1.ljX);
        VideoTransPara videoTransPara2 = this.ljU;
        com.tencent.mm.plugin.emojicapture.model.c.a aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        videoTransPara2.width = com.tencent.mm.plugin.emojicapture.model.c.lht;
        videoTransPara2 = this.ljU;
        aVar = com.tencent.mm.plugin.emojicapture.model.c.lhw;
        videoTransPara2.height = com.tencent.mm.plugin.emojicapture.model.c.lht;
        this.ljU.videoBitrate = GmsVersion.VERSION_LONGHORN;
        com.tencent.mm.plugin.mmsight.model.j.ouz.videoBitrate = this.ljU.videoBitrate;
        com.tencent.mm.plugin.mmsight.model.j.ouz.fcY = this.ljU;
        this.ljQ.scene = this.lha.scene;
        this.ljQ.ezZ = this.lha.ezZ;
        AppMethodBeat.o(2753);
    }

    public final void pk() {
        AppMethodBeat.i(2746);
        ab.i("MicroMsg.CapturePresenter", "pauseCapture " + this.ljO);
        if (this.ljP != null || this.ljO) {
            this.ljV.Kc(this.ljP);
            AppMethodBeat.o(2746);
            return;
        }
        al.n(new c(this), 1500);
        AppMethodBeat.o(2746);
    }

    public final void aDm() {
        AppMethodBeat.i(2747);
        ab.i("MicroMsg.CapturePresenter", "start record " + this.ljL);
        this.ljQ.setVideoPath("");
        this.ljQ.mb("");
        this.ljP = this.ljT.getDecoration().getText();
        this.ljT.getDecoration().lmz.reset();
        this.ljN = this.ljP == null;
        ab.i("MicroMsg.CapturePresenter", "startRecord: useVoiceInput " + this.ljN);
        if (this.ljN && (j.j("NON_NETWORK", at.getNetTypeString(ah.getContext())) ^ 1) != 0) {
            VoiceInputProxy voiceInputProxy = this.ljR;
            if (voiceInputProxy != null) {
                voiceInputProxy.start();
            }
            this.ljS.ms(50);
        }
        this.ljO = false;
        this.ljL = b.RECORD_STATE_STARTED;
        this.ljM = bo.yz();
        this.lha.lgL = System.currentTimeMillis();
        EmojiCaptureReporter.a(3, this.lha.ezZ, 0, 0, 0, 0, 0, 0, 0, this.lha.scene);
        AppMethodBeat.o(2747);
    }

    public final boolean EB() {
        AppMethodBeat.i(2748);
        ab.i("MicroMsg.CapturePresenter", "stop record " + this.ljL);
        if (this.ljL == b.RECORD_STATE_STOP) {
            AppMethodBeat.o(2748);
            return true;
        }
        this.ljL = b.RECORD_STATE_STOP;
        VoiceInputProxy voiceInputProxy;
        if (bo.az(this.ljM) < 600) {
            voiceInputProxy = this.ljR;
            if (voiceInputProxy != null) {
                voiceInputProxy.stop(true);
            }
            this.ljL = b.RECORD_STATE_PREVIEW;
            AppMethodBeat.o(2748);
            return false;
        }
        com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b bVar = this.ljV;
        Context context = this.context;
        String string = this.context.getString(R.string.cn5);
        j.o(string, "context.getString(R.string.loading_tips)");
        bVar.a(context, string, true, new d(this));
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
        EmojiCaptureReporter.a(4, this.lha.ezZ, 0, this.lha.euE, 0, 0, 0, 0, 0, this.lha.scene);
        AppMethodBeat.o(2748);
        return true;
    }

    public final void a(com.tencent.mm.plugin.emojicapture.model.a.a aVar) {
        boolean z;
        AppMethodBeat.i(2749);
        j.p(aVar, "info");
        ab.i("MicroMsg.CapturePresenter", "stopRecord: videoRecorder stop");
        this.ljQ.setVideoPath(aVar.videoPath);
        this.ljQ.mb(aVar.thumbPath);
        this.ljQ.lhI = this.ljP;
        this.ljQ.lhJ = aVar.lhJ;
        com.tencent.mm.plugin.emojicapture.model.a.a aVar2 = this.ljQ;
        if (this.ljQ.lhH == null) {
            z = true;
        } else {
            z = false;
        }
        aVar2.lhK = z;
        this.ljQ.lgS = aVar.lgS;
        this.ljV.c(this.ljQ);
        AppMethodBeat.o(2749);
    }

    public final void exit() {
        AppMethodBeat.i(2750);
        com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI.b.a.a(this.ljV, false);
        AppMethodBeat.o(2750);
    }

    public final void destroy() {
        AppMethodBeat.i(2751);
        this.ext.release();
        VoiceInputProxy voiceInputProxy = this.ljR;
        if (voiceInputProxy != null) {
            voiceInputProxy.setUiCallback(null);
            AppMethodBeat.o(2751);
            return;
        }
        AppMethodBeat.o(2751);
    }

    public final void a(com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
        AppMethodBeat.i(2752);
        ab.i("MicroMsg.CapturePresenter", "changeSticker:".concat(String.valueOf(bVar)));
        this.ljQ.lhH = bVar;
        this.ljT.a(bVar);
        AppMethodBeat.o(2752);
    }
}
