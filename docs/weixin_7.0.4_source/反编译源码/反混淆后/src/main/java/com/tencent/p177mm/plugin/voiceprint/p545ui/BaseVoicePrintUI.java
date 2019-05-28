package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.compatible.util.C45293b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.voiceprint.model.C22449m;
import com.tencent.p177mm.plugin.voiceprint.model.C43720p;
import com.tencent.p177mm.plugin.voiceprint.model.C43720p.C140171;
import com.tencent.p177mm.plugin.voiceprint.model.C43720p.C40018a;
import com.tencent.p177mm.plugin.voiceprint.p545ui.C43725a.C140317;
import com.tencent.p177mm.plugin.voiceprint.p545ui.C43725a.C29486a;
import com.tencent.p177mm.plugin.voiceprint.p545ui.C43725a.C353471;
import com.tencent.p177mm.plugin.voiceprint.p545ui.VoiceTipInfoView.C294831;
import com.tencent.p177mm.plugin.voiceprint.p545ui.VoiceTipInfoView.C294843;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C35988ay.C30291a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7306ak.C4998a;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.io.File;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI */
public abstract class BaseVoicePrintUI extends MMActivity {
    private final C7564ap nNC = new C7564ap(new C400193(), true);
    private boolean nNt = false;
    Button sLJ;
    View sLK;
    VoicePrintVolumeMeter sLL;
    VoiceTipInfoView sLM;
    C43720p sLN = null;
    String sLO = null;
    private boolean sLP = false;
    private View sLQ;
    private boolean sLR = false;
    private final C40018a sLS = new C140191();
    C7564ap sLT = new C7564ap(new C400234(), true);
    private C7306ak sLU = new C7306ak(Looper.getMainLooper(), new C400215());
    String sLs = null;

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$1 */
    class C140191 implements C40018a {
        C140191() {
        }

        public final void cHQ() {
            AppMethodBeat.m2504i(26130);
            C43720p a = BaseVoicePrintUI.this.sLN;
            if (a.chd != null) {
                a.chd.mo5464EB();
                C4990ab.m7412e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
            }
            a.fileName = "";
            a.sLB = null;
            a.stk = 0;
            a.ljM = 0;
            if (a.gar != null) {
                a.gar.mo73178Mm();
            }
            C4990ab.m7412e("MicroMsg.BaseVoicePrintUI", "record stop on error");
            BaseVoicePrintUI.this.sLO = null;
            C5004al.m7441d(new C294796());
            AppMethodBeat.m2505o(26130);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$8 */
    class C140208 implements C29486a {
        C140208() {
        }

        public final void cHV() {
        }

        public final void cHW() {
            AppMethodBeat.m2504i(26138);
            BaseVoicePrintUI.this.sLQ.setVisibility(0);
            BaseVoicePrintUI.this.sLR = false;
            AppMethodBeat.m2505o(26138);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$7 */
    class C224537 implements Runnable {
        C224537() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26137);
            if (!BaseVoicePrintUI.this.sLP) {
                BaseVoicePrintUI.m68535i(BaseVoicePrintUI.this);
            }
            AppMethodBeat.m2505o(26137);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$10 */
    class C2947810 implements OnTouchListener {
        private long nOa = 0;
        private boolean sLX = false;

        C2947810() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(26140);
            switch (motionEvent.getAction()) {
                case 0:
                    BaseVoicePrintUI.this.nNt = false;
                    if (!C5046bo.isNullOrNil(BaseVoicePrintUI.this.sLs)) {
                        this.nOa = System.currentTimeMillis();
                        BaseVoicePrintUI.this.sLJ.setPressed(true);
                        BaseVoicePrintUI.this.sLP = true;
                        BaseVoicePrintUI.this.cHS();
                        BaseVoicePrintUI.this.sLU.sendEmptyMessageDelayed(1, 300);
                        C4990ab.m7416i("MicroMsg.BaseVoicePrintUI", "mic press down");
                        break;
                    }
                    break;
                case 1:
                case 3:
                    BaseVoicePrintUI.this.sLJ.setPressed(false);
                    BaseVoicePrintUI.this.sLU.removeMessages(1);
                    if (System.currentTimeMillis() - this.nOa < 300) {
                        C4990ab.m7410d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                        BaseVoicePrintUI.this.nNt = false;
                    } else {
                        BaseVoicePrintUI.this.nNt = true;
                    }
                    C4990ab.m7417i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.this.nNt));
                    BaseVoicePrintUI.this.sLL.stop();
                    BaseVoicePrintUI.this.nNC.stopTimer();
                    BaseVoicePrintUI.this.sLN.mo69408EH();
                    if (!BaseVoicePrintUI.this.nNt) {
                        BaseVoicePrintUI.this.sLM.setErr((int) C25738R.string.f2g);
                        BaseVoicePrintUI.this.sLM.cIg();
                        break;
                    }
                    BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
                    C4990ab.m7410d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                    if (!baseVoicePrintUI.sLN.sLD) {
                        baseVoicePrintUI.sLT.stopTimer();
                        baseVoicePrintUI.sLM.setErr((int) C25738R.string.f2g);
                        baseVoicePrintUI.sLM.cIg();
                        baseVoicePrintUI.sLO = null;
                    }
                    baseVoicePrintUI.sLK.setVisibility(8);
                    baseVoicePrintUI.sLM.cIe();
                    baseVoicePrintUI.sLM.setTipText(baseVoicePrintUI.sLs);
                    C4990ab.m7411d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", BaseVoicePrintUI.this.sLO);
                    if (!C5046bo.isNullOrNil(BaseVoicePrintUI.this.sLO)) {
                        BaseVoicePrintUI.this.cHU();
                    }
                    this.nOa = 0;
                    this.sLX = false;
                    BaseVoicePrintUI.this.nNt = false;
                    break;
            }
            AppMethodBeat.m2505o(26140);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$6 */
    class C294796 implements Runnable {
        C294796() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26136);
            BaseVoicePrintUI.this.sLM.setErr((int) C25738R.string.f2v);
            BaseVoicePrintUI.this.sLM.cIg();
            BaseVoicePrintUI.this.sLJ.setPressed(false);
            BaseVoicePrintUI.this.sLJ.setEnabled(false);
            BaseVoicePrintUI.this.sLL.stop();
            AppMethodBeat.m2505o(26136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$9 */
    class C314529 implements C29486a {
        C314529() {
        }

        public final void cHV() {
        }

        public final void cHW() {
            AppMethodBeat.m2504i(26139);
            BaseVoicePrintUI.this.sLQ.setVisibility(4);
            BaseVoicePrintUI.this.sLR = false;
            AppMethodBeat.m2505o(26139);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$3 */
    class C400193 implements C5015a {
        C400193() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26132);
            if (BaseVoicePrintUI.this.sLN == null) {
                AppMethodBeat.m2505o(26132);
            } else {
                int maxAmplitude;
                C43720p a = BaseVoicePrintUI.this.sLN;
                if (a.chd != null) {
                    maxAmplitude = a.chd.getMaxAmplitude();
                    if (maxAmplitude > C43720p.cri) {
                        C43720p.cri = maxAmplitude;
                    }
                    C4990ab.m7410d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + C43720p.cri + " per:" + ((maxAmplitude * 100) / C43720p.cri));
                    maxAmplitude = (maxAmplitude * 100) / C43720p.cri;
                } else {
                    maxAmplitude = 0;
                }
                BaseVoicePrintUI.m68526a(BaseVoicePrintUI.this, (float) maxAmplitude);
                AppMethodBeat.m2505o(26132);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$5 */
    class C400215 implements C4998a {

        /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$5$1 */
        class C400201 implements C30291a {
            C400201() {
            }

            /* renamed from: EA */
            public final void mo7762EA() {
                AppMethodBeat.m2504i(26134);
                C4990ab.m7416i("MicroMsg.BaseVoicePrintUI", "play press sound end");
                AppMethodBeat.m2505o(26134);
            }
        }

        C400215() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.m2504i(26135);
            if (message.what == 1) {
                C4990ab.m7410d("MicroMsg.BaseVoicePrintUI", "start record");
                C35988ay.m59199a(C4996ah.getContext(), C25738R.string.ev4, new C400201());
                BaseVoicePrintUI.this.sLO = "voice_pt_voice_print_record.rec";
                C1406a a = BaseVoicePrintUI.this.sLN;
                String d = BaseVoicePrintUI.this.sLO;
                BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
                a.fileName = d;
                C4990ab.m7411d("MicroMsg.VoicePrintRecoder", "start filename %s", a.fileName);
                C9638aw.m17191ZL().mo4828a(a);
                int KM = C9638aw.m17191ZL().mo4817KM();
                a.sth = false;
                a.gar = new C45293b(baseVoicePrintUI);
                if (KM != 0) {
                    a.mo4815gE(100);
                } else {
                    new C140171().sendEmptyMessageDelayed(0, 50);
                }
                BaseVoicePrintUI.this.nNC.mo16770ae(100, 100);
                BaseVoicePrintUI baseVoicePrintUI2 = BaseVoicePrintUI.this;
                baseVoicePrintUI2.sLM.cIh();
                VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI2.sLM;
                C4990ab.m7411d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", Integer.valueOf(voiceTipInfoView.iDT.getVisibility()), Boolean.valueOf(voiceTipInfoView.sMN));
                if (voiceTipInfoView.iDT.getVisibility() != 0 || voiceTipInfoView.sMN) {
                    C4990ab.m7410d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
                    voiceTipInfoView.iDT.clearAnimation();
                    voiceTipInfoView.iDT.setVisibility(4);
                    voiceTipInfoView.iDT.invalidate();
                } else {
                    voiceTipInfoView.iDT.clearAnimation();
                    voiceTipInfoView.sMN = true;
                    C43725a.m78383a(voiceTipInfoView.iDT, voiceTipInfoView.getContext(), new C294843());
                }
                baseVoicePrintUI2.sLM.setTipText(baseVoicePrintUI2.sLs);
                baseVoicePrintUI2.sLT.stopTimer();
                baseVoicePrintUI2.sLT.mo16770ae(500, 500);
                baseVoicePrintUI2.sLK.setVisibility(0);
                VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI2.sLL;
                voicePrintVolumeMeter.reset();
                voicePrintVolumeMeter.mIsPlaying = true;
                long j = (long) VoicePrintVolumeMeter.nOt;
                voicePrintVolumeMeter.sMw.mo16770ae(j, j);
                voicePrintVolumeMeter.cIc();
                AppMethodBeat.m2505o(26135);
                return true;
            }
            AppMethodBeat.m2505o(26135);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$2 */
    class C400222 implements OnClickListener {
        C400222() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26131);
            BaseVoicePrintUI.this.finish();
            AppMethodBeat.m2505o(26131);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI$4 */
    class C400234 implements C5015a {
        C400234() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26133);
            VoiceTipInfoView c = BaseVoicePrintUI.this.sLM;
            if (c.poi.getAnimation() == null) {
                TextView textView = c.poi;
                Context context = c.getContext();
                C294831 c294831 = new C294831();
                float width = (float) textView.getWidth();
                C4990ab.m7410d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(width)));
                int[] iArr = new int[2];
                textView.getLocationInWindow(iArr);
                int i = (int) (width + ((float) iArr[0]));
                C4990ab.m7411d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i));
                Animation loadAnimation = AnimationUtils.loadAnimation(context, C25738R.anim.f8412dt);
                loadAnimation.setDuration(200);
                loadAnimation.setStartOffset(0);
                loadAnimation.setRepeatCount(0);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new C353471(c294831));
                textView.startAnimation(loadAnimation);
            }
            AppMethodBeat.m2505o(26133);
            return false;
        }
    }

    public abstract void bKm();

    public abstract void cHU();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: i */
    static /* synthetic */ void m68535i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.sLQ.setVisibility(0);
        if (baseVoicePrintUI.sLR) {
            baseVoicePrintUI.sLQ.setVisibility(0);
            return;
        }
        baseVoicePrintUI.sLR = true;
        View view = baseVoicePrintUI.sLQ;
        Button button = baseVoicePrintUI.sLJ;
        C140208 c140208 = new C140208();
        view.clearAnimation();
        int[] iArr = new int[2];
        button.getLocationOnScreen(iArr);
        C4990ab.m7411d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", Arrays.toString(iArr));
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        C4990ab.m7411d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", Integer.valueOf(iArr[1] - iArr2[1]));
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) r1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new C140317(c140208));
        view.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sLM = (VoiceTipInfoView) findViewById(2131828462);
        this.sLJ = (Button) findViewById(2131828464);
        this.sLK = findViewById(2131824678);
        this.sLL = (VoicePrintVolumeMeter) findViewById(2131824679);
        this.sLQ = findViewById(2131828465);
        this.sLM.cIh();
        this.sLL.setArchView(this.sLJ);
        this.sLN = new C43720p();
        this.sLN.sLE = this.sLS;
        this.sLJ.setOnTouchListener(new C2947810());
        findViewById(2131823808).setOnClickListener(new C400222());
        bKm();
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHR() {
        C5004al.m7442n(new C224537(), 1300);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHS() {
        if (this.sLQ.getVisibility() != 4 && this.sLQ.getVisibility() != 8) {
            if (this.sLR) {
                this.sLQ.setVisibility(4);
                return;
            }
            this.sLR = true;
            C43725a.m78383a(this.sLQ, this, new C314529());
        }
    }

    public final int getLayoutId() {
        return 2130971016;
    }

    public void onDestroy() {
        super.onDestroy();
        VoicePrintVolumeMeter voicePrintVolumeMeter = this.sLL;
        voicePrintVolumeMeter.sMw.stopTimer();
        voicePrintVolumeMeter.sMv.oAl.getLooper().quit();
        C4990ab.m7410d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        C4990ab.m7410d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        File file = new File(C22449m.m34137by("voice_pt_voice_print_record.rec", false));
        if (file.exists()) {
            file.delete();
        }
        file = new File(C22449m.m34137by("voice_pt_voice_print_noise_detect.rec", false));
        if (file.exists()) {
            file.delete();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHT() {
        mo63246FV(C25738R.string.f2m);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: FV */
    public final void mo63246FV(int i) {
        this.sLM.bQt();
        this.sLM.setErr(i);
        this.sLM.cIg();
    }
}
