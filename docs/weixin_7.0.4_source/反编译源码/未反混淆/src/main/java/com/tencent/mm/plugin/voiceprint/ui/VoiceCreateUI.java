package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.l.a;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceCreateUI extends BaseVoicePrintUI implements a {
    private View kIe = null;
    private int sLr = 1;
    private l sMe;
    private o sMf = null;
    private View sMg;
    private NoiseDetectMaskView sMh;
    private Button sMi = null;
    private int sMj = 0;
    private c sMk = new c<ud>() {
        {
            AppMethodBeat.i(26159);
            this.xxI = ud.class.getName().hashCode();
            AppMethodBeat.o(26159);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(26160);
            ab.d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", Boolean.valueOf(((ud) bVar).cQm.cQn));
            if (((ud) bVar).cQm.cQn) {
                VoiceCreateUI.a(VoiceCreateUI.this);
            } else {
                VoiceCreateUI.b(VoiceCreateUI.this);
            }
            AppMethodBeat.o(26160);
            return false;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoiceCreateUI() {
        AppMethodBeat.i(26168);
        AppMethodBeat.o(26168);
    }

    static /* synthetic */ void d(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(26182);
        voiceCreateUI.start();
        AppMethodBeat.o(26182);
    }

    static /* synthetic */ void e(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(26183);
        voiceCreateUI.cIb();
        AppMethodBeat.o(26183);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHU() {
        AppMethodBeat.i(26169);
        ab.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", this.sLO);
        if (!bo.isNullOrNil(this.sLO)) {
            this.sLJ.setEnabled(false);
            this.sLM.bQs();
            l lVar;
            m fVar;
            if (this.sLr == 1) {
                lVar = this.sMe;
                fVar = new f(this.sLO, 71, lVar.sLt, 0);
                fVar.sLb = true;
                aw.Rg().a(fVar, 0);
                lVar.sLr = 71;
                AppMethodBeat.o(26169);
                return;
            } else if (this.sLr == 2) {
                lVar = this.sMe;
                fVar = new f(this.sLO, 72, lVar.sLt, lVar.sLf);
                fVar.sLb = true;
                aw.Rg().a(fVar, 0);
                lVar.sLr = 72;
            }
        }
        AppMethodBeat.o(26169);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKm() {
        AppMethodBeat.i(26170);
        this.sMe = new l(this);
        findViewById(R.id.bma).setVisibility(8);
        this.sLM.setTitleText((int) R.string.f2u);
        this.sLM.cIf();
        this.sLJ.setEnabled(false);
        this.sMf = new o();
        this.sMg = findViewById(R.id.f22);
        this.sMh = (NoiseDetectMaskView) findViewById(R.id.e7u);
        this.kIe = findViewById(R.id.bn8);
        this.sMi = (Button) findViewById(R.id.bma);
        this.sMi.setVisibility(8);
        this.sMi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26162);
                VoiceCreateUI.this.cHS();
                a.a(VoiceCreateUI.this.sLM, new a.a() {
                    public final void cHV() {
                        AppMethodBeat.i(26161);
                        VoiceCreateUI.this.sMi.setVisibility(8);
                        VoiceCreateUI.this.sLM.setTitleText((int) R.string.f2u);
                        VoiceCreateUI.this.sLM.poi.setVisibility(0);
                        VoiceCreateUI.this.sLJ.setEnabled(true);
                        VoiceCreateUI.this.sLJ.setVisibility(0);
                        AppMethodBeat.o(26161);
                    }

                    public final void cHW() {
                    }
                });
                AppMethodBeat.o(26162);
            }
        });
        this.sMh.setOnClickRetryCallback(new NoiseDetectMaskView.b() {
            public final void cHY() {
                AppMethodBeat.i(26163);
                h.pYm.e(11390, Integer.valueOf(5));
                VoiceCreateUI.d(VoiceCreateUI.this);
                AppMethodBeat.o(26163);
            }
        });
        this.sMh.setOnCancelDetectCallback(new NoiseDetectMaskView.a() {
            public final void cHX() {
                AppMethodBeat.i(26164);
                VoiceCreateUI.e(VoiceCreateUI.this);
                o f = VoiceCreateUI.this.sMf;
                ab.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
                f.sLw.EB();
                f.sLx.stopTimer();
                VoiceCreateUI.this.finish();
                AppMethodBeat.o(26164);
            }
        });
        com.tencent.mm.sdk.b.a.xxA.c(this.sMk);
        this.kIe.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26165);
                VoiceCreateUI.e(VoiceCreateUI.this);
                VoiceCreateUI.this.finish();
                AppMethodBeat.o(26165);
            }
        });
        start();
        AppMethodBeat.o(26170);
    }

    private void start() {
        AppMethodBeat.i(26171);
        ab.d("MicroMsg.VoiceCreateUI", "start create");
        this.sMf.reset();
        this.sMh.reset();
        cIa();
        AppMethodBeat.o(26171);
    }

    private void cIa() {
        AppMethodBeat.i(26172);
        ab.d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.kIe.setVisibility(4);
        this.sMg.setVisibility(4);
        this.sLK.setVisibility(4);
        this.sMh.setVisibility(0);
        this.sMf.cHP();
        AppMethodBeat.o(26172);
    }

    public final void abS(String str) {
        AppMethodBeat.i(26173);
        ab.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        cHR();
        this.sLs = str;
        this.sLM.bQt();
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLJ.setEnabled(true);
        AppMethodBeat.o(26173);
    }

    public final void abT(String str) {
        AppMethodBeat.i(26174);
        ab.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.sLs = str;
        this.sLM.bQt();
        this.sLM.cIe();
        this.sLM.setTipText(str);
        this.sLJ.setEnabled(true);
        AppMethodBeat.o(26174);
    }

    public final void E(boolean z, int i) {
        AppMethodBeat.i(26175);
        ab.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            switch (i) {
                case 71:
                    ab.d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.sLJ.setEnabled(false);
                    this.sLr = 2;
                    cHS();
                    a.a(this.sLM, new a.a() {
                        public final void cHV() {
                            AppMethodBeat.i(26167);
                            VoiceCreateUI.this.sLM.reset();
                            VoiceCreateUI.this.sLM.cIe();
                            VoiceCreateUI.this.sLM.cIf();
                            VoiceCreateUI.this.sLJ.setVisibility(4);
                            VoiceCreateUI.this.sLM.setTitleText((int) R.string.f2r);
                            VoiceCreateUI.this.sMi.setVisibility(0);
                            VoiceCreateUI.this.sLM.bQt();
                            AppMethodBeat.o(26167);
                        }

                        public final void cHW() {
                        }
                    });
                    AppMethodBeat.o(26175);
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*72*/:
                    this.sMj = 0;
                    ab.d("MicroMsg.VoiceCreateUI", "finish create step 2");
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
            AppMethodBeat.o(26175);
            return;
        }
        switch (i) {
            case 71:
                AppMethodBeat.o(26175);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*72*/:
                cIb();
                this.sMj++;
                if (this.sMj < 2) {
                    this.sLJ.setEnabled(true);
                    this.sLM.bQt();
                    this.sLM.setErr((int) R.string.f2w);
                    this.sLM.cIg();
                    break;
                }
                ab.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                this.sMj = 0;
                startActivity(new Intent(this, VoiceReCreatePromptUI.class));
                overridePendingTransition(R.anim.df, R.anim.dc);
                finish();
                AppMethodBeat.o(26175);
                return;
        }
        AppMethodBeat.o(26175);
    }

    public final void cHM() {
        AppMethodBeat.i(26176);
        cHT();
        cIb();
        AppMethodBeat.o(26176);
    }

    private void cIb() {
        AppMethodBeat.i(26177);
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
        AppMethodBeat.o(26177);
    }

    public void onDestroy() {
        AppMethodBeat.i(26178);
        super.onDestroy();
        com.tencent.mm.ai.f fVar = this.sMe;
        aw.Rg().b(611, fVar);
        aw.Rg().b(612, fVar);
        fVar.sLu = null;
        com.tencent.mm.sdk.b.a.xxA.d(this.sMk);
        AppMethodBeat.o(26178);
    }

    public void onBackPressed() {
        AppMethodBeat.i(26179);
        super.onBackPressed();
        cIb();
        AppMethodBeat.o(26179);
    }

    static /* synthetic */ void a(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(26180);
        h.pYm.e(11390, Integer.valueOf(4));
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.sMh;
        if (noiseDetectMaskView.gHA != null) {
            noiseDetectMaskView.gHA.setVisibility(8);
        }
        noiseDetectMaskView.mMV.setText(R.string.f2t);
        noiseDetectMaskView.sLY.setVisibility(0);
        AppMethodBeat.o(26180);
    }

    static /* synthetic */ void b(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(26181);
        voiceCreateUI.kIe.setVisibility(0);
        voiceCreateUI.sMg.setVisibility(0);
        voiceCreateUI.sLK.setVisibility(0);
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.sMh;
        AnonymousClass6 anonymousClass6 = new a.a() {
            public final void cHV() {
            }

            public final void cHW() {
                AppMethodBeat.i(26166);
                VoiceCreateUI.this.sMh.setVisibility(8);
                VoiceCreateUI.h(VoiceCreateUI.this);
                AppMethodBeat.o(26166);
            }
        };
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass6(anonymousClass6));
        noiseDetectMaskView.startAnimation(translateAnimation);
        AppMethodBeat.o(26181);
    }

    static /* synthetic */ void h(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(26184);
        voiceCreateUI.sLM.bQs();
        voiceCreateUI.sLr = 1;
        voiceCreateUI.sMe.sLr = 71;
        aw.Rg().a(new d(71, ""), 0);
        AppMethodBeat.o(26184);
    }
}
