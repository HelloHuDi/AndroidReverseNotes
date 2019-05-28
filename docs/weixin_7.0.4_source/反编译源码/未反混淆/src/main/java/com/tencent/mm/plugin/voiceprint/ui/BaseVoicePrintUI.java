package com.tencent.mm.plugin.voiceprint.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Arrays;

public abstract class BaseVoicePrintUI extends MMActivity {
    private final ap nNC = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(26132);
            if (BaseVoicePrintUI.this.sLN == null) {
                AppMethodBeat.o(26132);
            } else {
                int maxAmplitude;
                p a = BaseVoicePrintUI.this.sLN;
                if (a.chd != null) {
                    maxAmplitude = a.chd.getMaxAmplitude();
                    if (maxAmplitude > p.cri) {
                        p.cri = maxAmplitude;
                    }
                    ab.d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + p.cri + " per:" + ((maxAmplitude * 100) / p.cri));
                    maxAmplitude = (maxAmplitude * 100) / p.cri;
                } else {
                    maxAmplitude = 0;
                }
                BaseVoicePrintUI.a(BaseVoicePrintUI.this, (float) maxAmplitude);
                AppMethodBeat.o(26132);
            }
            return true;
        }
    }, true);
    private boolean nNt = false;
    Button sLJ;
    View sLK;
    VoicePrintVolumeMeter sLL;
    VoiceTipInfoView sLM;
    p sLN = null;
    String sLO = null;
    private boolean sLP = false;
    private View sLQ;
    private boolean sLR = false;
    private final p.a sLS = new p.a() {
        public final void cHQ() {
            AppMethodBeat.i(26130);
            p a = BaseVoicePrintUI.this.sLN;
            if (a.chd != null) {
                a.chd.EB();
                ab.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
            }
            a.fileName = "";
            a.sLB = null;
            a.stk = 0;
            a.ljM = 0;
            if (a.gar != null) {
                a.gar.Mm();
            }
            ab.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
            BaseVoicePrintUI.this.sLO = null;
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(26136);
                    BaseVoicePrintUI.this.sLM.setErr((int) R.string.f2v);
                    BaseVoicePrintUI.this.sLM.cIg();
                    BaseVoicePrintUI.this.sLJ.setPressed(false);
                    BaseVoicePrintUI.this.sLJ.setEnabled(false);
                    BaseVoicePrintUI.this.sLL.stop();
                    AppMethodBeat.o(26136);
                }
            });
            AppMethodBeat.o(26130);
        }
    };
    ap sLT = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(26133);
            VoiceTipInfoView c = BaseVoicePrintUI.this.sLM;
            if (c.poi.getAnimation() == null) {
                TextView textView = c.poi;
                Context context = c.getContext();
                com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.AnonymousClass1 anonymousClass1 = new a.a() {
                    public final void cHV() {
                    }

                    public final void cHW() {
                    }
                };
                float width = (float) textView.getWidth();
                ab.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(width)));
                int[] iArr = new int[2];
                textView.getLocationInWindow(iArr);
                int i = (int) (width + ((float) iArr[0]));
                ab.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(i));
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.dt);
                loadAnimation.setDuration(200);
                loadAnimation.setStartOffset(0);
                loadAnimation.setRepeatCount(0);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass1(anonymousClass1));
                textView.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(26133);
            return false;
        }
    }, true);
    private ak sLU = new ak(Looper.getMainLooper(), new ak.a() {
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(26135);
            if (message.what == 1) {
                ab.d("MicroMsg.BaseVoicePrintUI", "start record");
                ay.a(ah.getContext(), R.string.ev4, new ay.a() {
                    public final void EA() {
                        AppMethodBeat.i(26134);
                        ab.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
                        AppMethodBeat.o(26134);
                    }
                });
                BaseVoicePrintUI.this.sLO = "voice_pt_voice_print_record.rec";
                g.a a = BaseVoicePrintUI.this.sLN;
                String d = BaseVoicePrintUI.this.sLO;
                BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
                a.fileName = d;
                ab.d("MicroMsg.VoicePrintRecoder", "start filename %s", a.fileName);
                aw.ZL().a(a);
                int KM = aw.ZL().KM();
                a.sth = false;
                a.gar = new b(baseVoicePrintUI);
                if (KM != 0) {
                    a.gE(100);
                } else {
                    new ak() {
                        public final void handleMessage(Message message) {
                            AppMethodBeat.i(26122);
                            ab.d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
                            if (p.this.sth) {
                                AppMethodBeat.o(26122);
                                return;
                            }
                            aw.ZL().b(p.this);
                            aw.ZL().KN();
                            p.this.gE(200);
                            AppMethodBeat.o(26122);
                        }
                    }.sendEmptyMessageDelayed(0, 50);
                }
                BaseVoicePrintUI.this.nNC.ae(100, 100);
                BaseVoicePrintUI baseVoicePrintUI2 = BaseVoicePrintUI.this;
                baseVoicePrintUI2.sLM.cIh();
                VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI2.sLM;
                ab.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", Integer.valueOf(voiceTipInfoView.iDT.getVisibility()), Boolean.valueOf(voiceTipInfoView.sMN));
                if (voiceTipInfoView.iDT.getVisibility() != 0 || voiceTipInfoView.sMN) {
                    ab.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
                    voiceTipInfoView.iDT.clearAnimation();
                    voiceTipInfoView.iDT.setVisibility(4);
                    voiceTipInfoView.iDT.invalidate();
                } else {
                    voiceTipInfoView.iDT.clearAnimation();
                    voiceTipInfoView.sMN = true;
                    a.a(voiceTipInfoView.iDT, voiceTipInfoView.getContext(), new a.a() {
                        public final void cHV() {
                        }

                        public final void cHW() {
                            AppMethodBeat.i(26224);
                            VoiceTipInfoView.this.iDT.setVisibility(4);
                            VoiceTipInfoView.this.sMN = false;
                            AppMethodBeat.o(26224);
                        }
                    });
                }
                baseVoicePrintUI2.sLM.setTipText(baseVoicePrintUI2.sLs);
                baseVoicePrintUI2.sLT.stopTimer();
                baseVoicePrintUI2.sLT.ae(500, 500);
                baseVoicePrintUI2.sLK.setVisibility(0);
                VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI2.sLL;
                voicePrintVolumeMeter.reset();
                voicePrintVolumeMeter.mIsPlaying = true;
                long j = (long) VoicePrintVolumeMeter.nOt;
                voicePrintVolumeMeter.sMw.ae(j, j);
                voicePrintVolumeMeter.cIc();
                AppMethodBeat.o(26135);
                return true;
            }
            AppMethodBeat.o(26135);
            return false;
        }
    });
    String sLs = null;

    public abstract void bKm();

    public abstract void cHU();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.sLQ.setVisibility(0);
        if (baseVoicePrintUI.sLR) {
            baseVoicePrintUI.sLQ.setVisibility(0);
            return;
        }
        baseVoicePrintUI.sLR = true;
        View view = baseVoicePrintUI.sLQ;
        Button button = baseVoicePrintUI.sLJ;
        AnonymousClass8 anonymousClass8 = new a.a() {
            public final void cHV() {
            }

            public final void cHW() {
                AppMethodBeat.i(26138);
                BaseVoicePrintUI.this.sLQ.setVisibility(0);
                BaseVoicePrintUI.this.sLR = false;
                AppMethodBeat.o(26138);
            }
        };
        view.clearAnimation();
        int[] iArr = new int[2];
        button.getLocationOnScreen(iArr);
        ab.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", Arrays.toString(iArr));
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        ab.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", Integer.valueOf(iArr[1] - iArr2[1]));
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) r1, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass7(anonymousClass8));
        view.startAnimation(animationSet);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.sLM = (VoiceTipInfoView) findViewById(R.id.f21);
        this.sLJ = (Button) findViewById(R.id.f23);
        this.sLK = findViewById(R.id.c_q);
        this.sLL = (VoicePrintVolumeMeter) findViewById(R.id.c_r);
        this.sLQ = findViewById(R.id.f24);
        this.sLM.cIh();
        this.sLL.setArchView(this.sLJ);
        this.sLN = new p();
        this.sLN.sLE = this.sLS;
        this.sLJ.setOnTouchListener(new OnTouchListener() {
            private long nOa = 0;
            private boolean sLX = false;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(26140);
                switch (motionEvent.getAction()) {
                    case 0:
                        BaseVoicePrintUI.this.nNt = false;
                        if (!bo.isNullOrNil(BaseVoicePrintUI.this.sLs)) {
                            this.nOa = System.currentTimeMillis();
                            BaseVoicePrintUI.this.sLJ.setPressed(true);
                            BaseVoicePrintUI.this.sLP = true;
                            BaseVoicePrintUI.this.cHS();
                            BaseVoicePrintUI.this.sLU.sendEmptyMessageDelayed(1, 300);
                            ab.i("MicroMsg.BaseVoicePrintUI", "mic press down");
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        BaseVoicePrintUI.this.sLJ.setPressed(false);
                        BaseVoicePrintUI.this.sLU.removeMessages(1);
                        if (System.currentTimeMillis() - this.nOa < 300) {
                            ab.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                            BaseVoicePrintUI.this.nNt = false;
                        } else {
                            BaseVoicePrintUI.this.nNt = true;
                        }
                        ab.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.this.nNt));
                        BaseVoicePrintUI.this.sLL.stop();
                        BaseVoicePrintUI.this.nNC.stopTimer();
                        BaseVoicePrintUI.this.sLN.EH();
                        if (!BaseVoicePrintUI.this.nNt) {
                            BaseVoicePrintUI.this.sLM.setErr((int) R.string.f2g);
                            BaseVoicePrintUI.this.sLM.cIg();
                            break;
                        }
                        BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
                        ab.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                        if (!baseVoicePrintUI.sLN.sLD) {
                            baseVoicePrintUI.sLT.stopTimer();
                            baseVoicePrintUI.sLM.setErr((int) R.string.f2g);
                            baseVoicePrintUI.sLM.cIg();
                            baseVoicePrintUI.sLO = null;
                        }
                        baseVoicePrintUI.sLK.setVisibility(8);
                        baseVoicePrintUI.sLM.cIe();
                        baseVoicePrintUI.sLM.setTipText(baseVoicePrintUI.sLs);
                        ab.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", BaseVoicePrintUI.this.sLO);
                        if (!bo.isNullOrNil(BaseVoicePrintUI.this.sLO)) {
                            BaseVoicePrintUI.this.cHU();
                        }
                        this.nOa = 0;
                        this.sLX = false;
                        BaseVoicePrintUI.this.nNt = false;
                        break;
                }
                AppMethodBeat.o(26140);
                return false;
            }
        });
        findViewById(R.id.bn8).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(26131);
                BaseVoicePrintUI.this.finish();
                AppMethodBeat.o(26131);
            }
        });
        bKm();
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHR() {
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(26137);
                if (!BaseVoicePrintUI.this.sLP) {
                    BaseVoicePrintUI.i(BaseVoicePrintUI.this);
                }
                AppMethodBeat.o(26137);
            }
        }, 1300);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHS() {
        if (this.sLQ.getVisibility() != 4 && this.sLQ.getVisibility() != 8) {
            if (this.sLR) {
                this.sLQ.setVisibility(4);
                return;
            }
            this.sLR = true;
            a.a(this.sLQ, this, new a.a() {
                public final void cHV() {
                }

                public final void cHW() {
                    AppMethodBeat.i(26139);
                    BaseVoicePrintUI.this.sLQ.setVisibility(4);
                    BaseVoicePrintUI.this.sLR = false;
                    AppMethodBeat.o(26139);
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.layout.b8k;
    }

    public void onDestroy() {
        super.onDestroy();
        VoicePrintVolumeMeter voicePrintVolumeMeter = this.sLL;
        voicePrintVolumeMeter.sMw.stopTimer();
        voicePrintVolumeMeter.sMv.oAl.getLooper().quit();
        ab.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        ab.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        File file = new File(m.by("voice_pt_voice_print_record.rec", false));
        if (file.exists()) {
            file.delete();
        }
        file = new File(m.by("voice_pt_voice_print_noise_detect.rec", false));
        if (file.exists()) {
            file.delete();
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void cHT() {
        FV(R.string.f2m);
    }

    /* Access modifiers changed, original: protected|final */
    public final void FV(int i) {
        this.sLM.bQt();
        this.sLM.setErr(i);
        this.sLM.cIg();
    }
}
