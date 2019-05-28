package com.tencent.p177mm.plugin.voiceprint.p545ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42067ud;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C33279c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voiceprint.model.C14014d;
import com.tencent.p177mm.plugin.voiceprint.model.C14015f;
import com.tencent.p177mm.plugin.voiceprint.model.C22448l;
import com.tencent.p177mm.plugin.voiceprint.model.C22448l.C22447a;
import com.tencent.p177mm.plugin.voiceprint.model.C22452o;
import com.tencent.p177mm.plugin.voiceprint.p545ui.C43725a.C294856;
import com.tencent.p177mm.plugin.voiceprint.p545ui.C43725a.C29486a;
import com.tencent.p177mm.plugin.voiceprint.p545ui.NoiseDetectMaskView.C35345a;
import com.tencent.p177mm.plugin.voiceprint.p545ui.NoiseDetectMaskView.C35346b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI */
public class VoiceCreateUI extends BaseVoicePrintUI implements C22447a {
    private View kIe = null;
    private int sLr = 1;
    private C22448l sMe;
    private C22452o sMf = null;
    private View sMg;
    private NoiseDetectMaskView sMh;
    private Button sMi = null;
    private int sMj = 0;
    private C4884c sMk = new C42741();

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$2 */
    class C42682 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$2$1 */
        class C42691 implements C29486a {
            C42691() {
            }

            public final void cHV() {
                AppMethodBeat.m2504i(26161);
                VoiceCreateUI.this.sMi.setVisibility(8);
                VoiceCreateUI.this.sLM.setTitleText((int) C25738R.string.f2u);
                VoiceCreateUI.this.sLM.poi.setVisibility(0);
                VoiceCreateUI.this.sLJ.setEnabled(true);
                VoiceCreateUI.this.sLJ.setVisibility(0);
                AppMethodBeat.m2505o(26161);
            }

            public final void cHW() {
            }
        }

        C42682() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26162);
            VoiceCreateUI.this.cHS();
            C43725a.m78384a(VoiceCreateUI.this.sLM, new C42691());
            AppMethodBeat.m2505o(26162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$4 */
    class C42704 implements C35345a {
        C42704() {
        }

        public final void cHX() {
            AppMethodBeat.m2504i(26164);
            VoiceCreateUI.m6618e(VoiceCreateUI.this);
            C22452o f = VoiceCreateUI.this.sMf;
            C4990ab.m7410d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
            f.sLw.mo5464EB();
            f.sLx.stopTimer();
            VoiceCreateUI.this.finish();
            AppMethodBeat.m2505o(26164);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$5 */
    class C42715 implements OnClickListener {
        C42715() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(26165);
            VoiceCreateUI.m6618e(VoiceCreateUI.this);
            VoiceCreateUI.this.finish();
            AppMethodBeat.m2505o(26165);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$6 */
    class C42726 implements C29486a {
        C42726() {
        }

        public final void cHV() {
        }

        public final void cHW() {
            AppMethodBeat.m2504i(26166);
            VoiceCreateUI.this.sMh.setVisibility(8);
            VoiceCreateUI.m6621h(VoiceCreateUI.this);
            AppMethodBeat.m2505o(26166);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$3 */
    class C42733 implements C35346b {
        C42733() {
        }

        public final void cHY() {
            AppMethodBeat.m2504i(26163);
            C7060h.pYm.mo8381e(11390, Integer.valueOf(5));
            VoiceCreateUI.m6617d(VoiceCreateUI.this);
            AppMethodBeat.m2505o(26163);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$1 */
    class C42741 extends C4884c<C42067ud> {
        C42741() {
            AppMethodBeat.m2504i(26159);
            this.xxI = C42067ud.class.getName().hashCode();
            AppMethodBeat.m2505o(26159);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(26160);
            C4990ab.m7411d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", Boolean.valueOf(((C42067ud) c4883b).cQm.cQn));
            if (((C42067ud) c4883b).cQm.cQn) {
                VoiceCreateUI.m6614a(VoiceCreateUI.this);
            } else {
                VoiceCreateUI.m6615b(VoiceCreateUI.this);
            }
            AppMethodBeat.m2505o(26160);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI$7 */
    class C42757 implements C29486a {
        C42757() {
        }

        public final void cHV() {
            AppMethodBeat.m2504i(26167);
            VoiceCreateUI.this.sLM.reset();
            VoiceCreateUI.this.sLM.cIe();
            VoiceCreateUI.this.sLM.cIf();
            VoiceCreateUI.this.sLJ.setVisibility(4);
            VoiceCreateUI.this.sLM.setTitleText((int) C25738R.string.f2r);
            VoiceCreateUI.this.sMi.setVisibility(0);
            VoiceCreateUI.this.sLM.bQt();
            AppMethodBeat.m2505o(26167);
        }

        public final void cHW() {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VoiceCreateUI() {
        AppMethodBeat.m2504i(26168);
        AppMethodBeat.m2505o(26168);
    }

    /* renamed from: d */
    static /* synthetic */ void m6617d(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.m2504i(26182);
        voiceCreateUI.start();
        AppMethodBeat.m2505o(26182);
    }

    /* renamed from: e */
    static /* synthetic */ void m6618e(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.m2504i(26183);
        voiceCreateUI.cIb();
        AppMethodBeat.m2505o(26183);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHU() {
        AppMethodBeat.m2504i(26169);
        C4990ab.m7411d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", this.sLO);
        if (!C5046bo.isNullOrNil(this.sLO)) {
            this.sLJ.setEnabled(false);
            this.sLM.bQs();
            C22448l c22448l;
            C1207m c14015f;
            if (this.sLr == 1) {
                c22448l = this.sMe;
                c14015f = new C14015f(this.sLO, 71, c22448l.sLt, 0);
                c14015f.sLb = true;
                C9638aw.m17182Rg().mo14541a(c14015f, 0);
                c22448l.sLr = 71;
                AppMethodBeat.m2505o(26169);
                return;
            } else if (this.sLr == 2) {
                c22448l = this.sMe;
                c14015f = new C14015f(this.sLO, 72, c22448l.sLt, c22448l.sLf);
                c14015f.sLb = true;
                C9638aw.m17182Rg().mo14541a(c14015f, 0);
                c22448l.sLr = 72;
            }
        }
        AppMethodBeat.m2505o(26169);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKm() {
        AppMethodBeat.m2504i(26170);
        this.sMe = new C22448l(this);
        findViewById(2131823774).setVisibility(8);
        this.sLM.setTitleText((int) C25738R.string.f2u);
        this.sLM.cIf();
        this.sLJ.setEnabled(false);
        this.sMf = new C22452o();
        this.sMg = findViewById(2131828463);
        this.sMh = (NoiseDetectMaskView) findViewById(2131827308);
        this.kIe = findViewById(2131823808);
        this.sMi = (Button) findViewById(2131823774);
        this.sMi.setVisibility(8);
        this.sMi.setOnClickListener(new C42682());
        this.sMh.setOnClickRetryCallback(new C42733());
        this.sMh.setOnCancelDetectCallback(new C42704());
        C4879a.xxA.mo10052c(this.sMk);
        this.kIe.setOnClickListener(new C42715());
        start();
        AppMethodBeat.m2505o(26170);
    }

    private void start() {
        AppMethodBeat.m2504i(26171);
        C4990ab.m7410d("MicroMsg.VoiceCreateUI", "start create");
        this.sMf.reset();
        this.sMh.reset();
        cIa();
        AppMethodBeat.m2505o(26171);
    }

    private void cIa() {
        AppMethodBeat.m2504i(26172);
        C4990ab.m7410d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.kIe.setVisibility(4);
        this.sMg.setVisibility(4);
        this.sLK.setVisibility(4);
        this.sMh.setVisibility(0);
        this.sMf.cHP();
        AppMethodBeat.m2505o(26172);
    }

    public final void abS(String str) {
        AppMethodBeat.m2504i(26173);
        C4990ab.m7410d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        cHR();
        this.sLs = str;
        this.sLM.bQt();
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLJ.setEnabled(true);
        AppMethodBeat.m2505o(26173);
    }

    public final void abT(String str) {
        AppMethodBeat.m2504i(26174);
        C4990ab.m7410d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.sLs = str;
        this.sLM.bQt();
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLJ.setEnabled(true);
        AppMethodBeat.m2505o(26174);
    }

    /* renamed from: E */
    public final void mo9255E(boolean z, int i) {
        AppMethodBeat.m2504i(26175);
        C4990ab.m7411d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            switch (i) {
                case 71:
                    C4990ab.m7410d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.sLJ.setEnabled(false);
                    this.sLr = 2;
                    cHS();
                    C43725a.m78384a(this.sLM, new C42757());
                    AppMethodBeat.m2505o(26175);
                    return;
                case C33279c.CTRL_INDEX /*72*/:
                    this.sMj = 0;
                    C4990ab.m7410d("MicroMsg.VoiceCreateUI", "finish create step 2");
                    Intent intent = new Intent();
                    intent.putExtra("KIsCreateSuccess", true);
                    setResult(-1, intent);
                    intent = new Intent();
                    intent.setClass(this, VoicePrintFinishUI.class);
                    intent.putExtra("kscene_type", 72);
                    startActivity(intent);
                    finish();
                    break;
            }
            AppMethodBeat.m2505o(26175);
            return;
        }
        switch (i) {
            case 71:
                AppMethodBeat.m2505o(26175);
                return;
            case C33279c.CTRL_INDEX /*72*/:
                cIb();
                this.sMj++;
                if (this.sMj < 2) {
                    this.sLJ.setEnabled(true);
                    this.sLM.bQt();
                    this.sLM.setErr((int) C25738R.string.f2w);
                    this.sLM.cIg();
                    break;
                }
                C4990ab.m7410d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                this.sMj = 0;
                startActivity(new Intent(this, VoiceReCreatePromptUI.class));
                overridePendingTransition(C25738R.anim.f8403df, C25738R.anim.f8402dc);
                finish();
                AppMethodBeat.m2505o(26175);
                return;
        }
        AppMethodBeat.m2505o(26175);
    }

    public final void cHM() {
        AppMethodBeat.m2504i(26176);
        cHT();
        cIb();
        AppMethodBeat.m2505o(26176);
    }

    private void cIb() {
        AppMethodBeat.m2504i(26177);
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
        AppMethodBeat.m2505o(26177);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(26178);
        super.onDestroy();
        C1202f c1202f = this.sMe;
        C9638aw.m17182Rg().mo14546b(611, c1202f);
        C9638aw.m17182Rg().mo14546b(612, c1202f);
        c1202f.sLu = null;
        C4879a.xxA.mo10053d(this.sMk);
        AppMethodBeat.m2505o(26178);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(26179);
        super.onBackPressed();
        cIb();
        AppMethodBeat.m2505o(26179);
    }

    /* renamed from: a */
    static /* synthetic */ void m6614a(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.m2504i(26180);
        C7060h.pYm.mo8381e(11390, Integer.valueOf(4));
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.sMh;
        if (noiseDetectMaskView.gHA != null) {
            noiseDetectMaskView.gHA.setVisibility(8);
        }
        noiseDetectMaskView.mMV.setText(C25738R.string.f2t);
        noiseDetectMaskView.sLY.setVisibility(0);
        AppMethodBeat.m2505o(26180);
    }

    /* renamed from: b */
    static /* synthetic */ void m6615b(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.m2504i(26181);
        voiceCreateUI.kIe.setVisibility(0);
        voiceCreateUI.sMg.setVisibility(0);
        voiceCreateUI.sLK.setVisibility(0);
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.sMh;
        C42726 c42726 = new C42726();
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new C294856(c42726));
        noiseDetectMaskView.startAnimation(translateAnimation);
        AppMethodBeat.m2505o(26181);
    }

    /* renamed from: h */
    static /* synthetic */ void m6621h(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.m2504i(26184);
        voiceCreateUI.sLM.bQs();
        voiceCreateUI.sLr = 1;
        voiceCreateUI.sMe.sLr = 71;
        C9638aw.m17182Rg().mo14541a(new C14014d(71, ""), 0);
        AppMethodBeat.m2505o(26184);
    }
}
