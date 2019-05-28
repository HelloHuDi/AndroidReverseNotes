package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.v;

public class FavPostVoiceUI extends MMBaseActivity {
    private static final int[] gcc = new int[]{R.drawable.aab, R.drawable.aac, R.drawable.aad, R.drawable.aae, R.drawable.aaf, R.drawable.aag, R.drawable.aah};
    private static final int[] miN = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private long duration;
    private final ap gci = new ap(new a() {
        public final boolean BI() {
            int maxAmplitude;
            int i = 0;
            AppMethodBeat.i(74041);
            j a = FavPostVoiceUI.this.miM;
            if (a.status == 1) {
                maxAmplitude = a.crg.getMaxAmplitude();
                if (maxAmplitude > j.cri) {
                    j.cri = maxAmplitude;
                }
                maxAmplitude = (maxAmplitude * 100) / j.cri;
            } else {
                maxAmplitude = 0;
            }
            while (i < FavPostVoiceUI.gcc.length) {
                if (maxAmplitude >= FavPostVoiceUI.miN[i] && maxAmplitude < FavPostVoiceUI.miN[i + 1]) {
                    FavPostVoiceUI.this.miH.setBackgroundResource(FavPostVoiceUI.gcc[i]);
                    break;
                }
                i++;
            }
            AppMethodBeat.o(74041);
            return true;
        }
    }, true);
    private int iev;
    private long ljM;
    private Button miA;
    private boolean miB;
    private boolean miC;
    private long miD = -1;
    private Toast miE;
    private View miF;
    private View miG;
    private ImageView miH;
    private View miI;
    private View miJ;
    private TextView miK;
    private View miL;
    private j miM;
    private final ak miO = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(74046);
            super.handleMessage(message);
            FavPostVoiceUI.this.bvH();
            FavPostVoiceUI.this.miA.setBackgroundResource(R.drawable.yg);
            FavPostVoiceUI.this.miA.setEnabled(true);
            AppMethodBeat.o(74046);
        }
    };
    private final ap miP = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(74047);
            if (FavPostVoiceUI.this.miD == -1) {
                FavPostVoiceUI.this.miD = bo.yz();
            }
            long az = bo.az(FavPostVoiceUI.this.miD);
            if (az >= 3590000 && az <= 3600000) {
                if (FavPostVoiceUI.this.miE == null) {
                    FavPostVoiceUI.this.miE = Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}), 0);
                } else {
                    FavPostVoiceUI.this.miE.setText(FavPostVoiceUI.this.getString(R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}));
                }
                FavPostVoiceUI.this.miE.show();
            }
            if (az >= 3600000) {
                ab.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
                FavPostVoiceUI.this.miC = true;
                FavPostVoiceUI.p(FavPostVoiceUI.this);
                AppMethodBeat.o(74047);
                return false;
            }
            AppMethodBeat.o(74047);
            return true;
        }
    }, true);
    boolean miQ = false;
    private String path;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavPostVoiceUI() {
        AppMethodBeat.i(74050);
        AppMethodBeat.o(74050);
    }

    static /* synthetic */ void c(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(74061);
        favPostVoiceUI.bvJ();
        AppMethodBeat.o(74061);
    }

    static /* synthetic */ void p(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(74064);
        favPostVoiceUI.bvG();
        AppMethodBeat.o(74064);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(74051);
        super.onCreate(bundle);
        setContentView(v.hu(this).inflate(R.layout.yu, null));
        this.miH = (ImageView) findViewById(R.id.br_);
        this.miI = findViewById(R.id.br8);
        this.miJ = findViewById(R.id.brb);
        this.miF = findViewById(R.id.br7);
        this.miG = findViewById(R.id.bre);
        this.miK = (TextView) findViewById(R.id.bra);
        this.miL = findViewById(R.id.br5);
        findViewById(R.id.br6).setVisibility(8);
        this.miL.setVisibility(8);
        findViewById(R.id.br6).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74042);
                FavPostVoiceUI.c(FavPostVoiceUI.this);
                AppMethodBeat.o(74042);
                return false;
            }
        });
        findViewById(R.id.brf).setVisibility(8);
        this.miM = bvF();
        this.miA = (Button) findViewById(R.id.brg);
        this.miA.setOnTouchListener(new OnTouchListener() {
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(74045);
                if (view != FavPostVoiceUI.this.miA) {
                    AppMethodBeat.o(74045);
                } else {
                    int rawY = (int) motionEvent.getRawY();
                    int[] iArr = new int[2];
                    FavPostVoiceUI.this.iev = FavPostVoiceUI.this.getResources().getDisplayMetrics().heightPixels;
                    FavPostVoiceUI.this.miA.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (!FavPostVoiceUI.this.miB) {
                                FavPostVoiceUI.this.miB = true;
                                FavPostVoiceUI.j(FavPostVoiceUI.this);
                            }
                        case 1:
                            if (!FavPostVoiceUI.this.miB) {
                                AppMethodBeat.o(74045);
                                break;
                            } else if (FavPostVoiceUI.this.miJ.getVisibility() == 0) {
                                ab.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                                FavPostVoiceUI.n(FavPostVoiceUI.this);
                            } else if (!FavPostVoiceUI.this.miC) {
                                FavPostVoiceUI.p(FavPostVoiceUI.this);
                            }
                        case 2:
                            if (rawY > FavPostVoiceUI.this.iev - b.b(FavPostVoiceUI.this, 60.0f) || rawY >= i) {
                                FavPostVoiceUI.this.miI.setVisibility(0);
                                FavPostVoiceUI.this.miJ.setVisibility(8);
                            } else {
                                FavPostVoiceUI.this.miI.setVisibility(8);
                                FavPostVoiceUI.this.miJ.setVisibility(0);
                            }
                            AppMethodBeat.o(74045);
                            break;
                        case 3:
                            ab.w("MicroMsg.FavPostVoiceUI", "action cancel");
                            FavPostVoiceUI.n(FavPostVoiceUI.this);
                            AppMethodBeat.o(74045);
                            break;
                    }
                    AppMethodBeat.o(74045);
                }
                return false;
            }
        });
        bvH();
        String bun = com.tencent.mm.plugin.fav.a.b.bun();
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(bun);
        if (!bVar.exists()) {
            bVar.mkdirs();
        }
        do {
            str = bun + "/" + System.currentTimeMillis();
        } while (new com.tencent.mm.vfs.b(str).exists());
        this.path = str;
        this.miK.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74043);
                FavPostVoiceUI.this.findViewById(R.id.br6).setVisibility(0);
                FavPostVoiceUI.this.miL.setVisibility(0);
                FavPostVoiceUI.this.findViewById(R.id.brf).setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(300);
                FavPostVoiceUI.this.miL.startAnimation(alphaAnimation);
                FavPostVoiceUI.this.findViewById(R.id.br6).startAnimation(alphaAnimation);
                FavPostVoiceUI.this.findViewById(R.id.brf).startAnimation(translateAnimation);
                AppMethodBeat.o(74043);
            }
        });
        AppMethodBeat.o(74051);
    }

    private j bvF() {
        AppMethodBeat.i(74052);
        c.a aVar = c.a.AMR;
        j jVar = new j();
        jVar.crh = new j.a() {
            public final void onError() {
                AppMethodBeat.i(74044);
                FavPostVoiceUI.this.gci.stopTimer();
                FavPostVoiceUI.this.miP.stopTimer();
                AppMethodBeat.o(74044);
            }
        };
        AppMethodBeat.o(74052);
        return jVar;
    }

    private void bvG() {
        long j = 0;
        AppMethodBeat.i(74053);
        if (this.miB) {
            this.miA.setKeepScreenOn(true);
            this.miA.setBackgroundResource(R.drawable.yf);
            this.miA.setText(R.string.bqb);
            this.miM.EB();
            if (this.ljM != 0) {
                j = bo.az(this.ljM);
            }
            this.duration = j;
            boolean z = this.duration < 800;
            this.gci.stopTimer();
            this.miP.stopTimer();
            if (z) {
                bvI();
                this.miA.setEnabled(false);
                this.miA.setBackgroundResource(R.drawable.ye);
                this.miG.setVisibility(0);
                this.miF.setVisibility(8);
                this.miO.sendEmptyMessageDelayed(0, 500);
            } else {
                String str = this.path;
                int i = (int) this.duration;
                if (bo.isNullOrNil(str)) {
                    ab.e("MicroMsg.FavPostLogic", "postVoice path null");
                } else {
                    g gVar = new g();
                    gVar.field_type = 3;
                    gVar.field_sourceType = 6;
                    h.E(gVar);
                    aar aar = new aar();
                    aar.akV(str);
                    aar.LD(i);
                    aar.oY(true);
                    aar.LE(gVar.field_type);
                    aar.akR("amr");
                    gVar.field_favProto.wiv.add(aar);
                    b.B(gVar);
                    h.pYm.e(10648, Integer.valueOf(1), Integer.valueOf(0));
                }
                setResult(-1);
                finish();
                overridePendingTransition(0, 0);
            }
            this.miB = false;
            AppMethodBeat.o(74053);
            return;
        }
        AppMethodBeat.o(74053);
    }

    public final void bvH() {
        AppMethodBeat.i(74054);
        this.miF.setVisibility(0);
        this.miG.setVisibility(8);
        this.miJ.setVisibility(8);
        this.miI.setVisibility(0);
        this.miK.setText(R.string.bnh);
        this.miA.setBackgroundResource(R.drawable.yg);
        this.miA.setText(R.string.bqb);
        this.miH.setVisibility(4);
        this.miB = false;
        AppMethodBeat.o(74054);
    }

    private void bvI() {
        AppMethodBeat.i(74055);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.path);
        if (bVar.exists()) {
            bVar.delete();
        }
        AppMethodBeat.o(74055);
    }

    public void onDestroy() {
        AppMethodBeat.i(74056);
        super.onDestroy();
        AppMethodBeat.o(74056);
    }

    public void onResume() {
        AppMethodBeat.i(74057);
        super.onResume();
        AppMethodBeat.o(74057);
    }

    public void onPause() {
        AppMethodBeat.i(74058);
        super.onPause();
        bvG();
        AppMethodBeat.o(74058);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(74059);
        if (4 == i) {
            bvJ();
            AppMethodBeat.o(74059);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(74059);
        return onKeyDown;
    }

    private void bvJ() {
        AppMethodBeat.i(74060);
        if (this.miQ) {
            AppMethodBeat.o(74060);
            return;
        }
        this.miQ = true;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(300);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        translateAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(74049);
                FavPostVoiceUI.this.miI.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74048);
                        FavPostVoiceUI.this.setResult(0);
                        FavPostVoiceUI.this.finish();
                        FavPostVoiceUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(74048);
                    }
                });
                AppMethodBeat.o(74049);
            }
        });
        findViewById(R.id.br6).setVisibility(8);
        findViewById(R.id.brf).setVisibility(8);
        this.miL.setVisibility(8);
        this.miL.startAnimation(alphaAnimation);
        findViewById(R.id.br6).startAnimation(alphaAnimation);
        findViewById(R.id.brf).startAnimation(translateAnimation);
        AppMethodBeat.o(74060);
    }

    static /* synthetic */ void j(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(74062);
        favPostVoiceUI.miA.setKeepScreenOn(true);
        favPostVoiceUI.miA.setBackgroundResource(R.drawable.yg);
        favPostVoiceUI.miA.setText(R.string.br3);
        favPostVoiceUI.miC = false;
        favPostVoiceUI.miM = favPostVoiceUI.bvF();
        if (favPostVoiceUI.miM.en(favPostVoiceUI.path)) {
            favPostVoiceUI.ljM = bo.yz();
            favPostVoiceUI.miP.ae(200, 200);
            favPostVoiceUI.miH.setVisibility(0);
            favPostVoiceUI.gci.ae(100, 100);
            favPostVoiceUI.miK.setText(R.string.bpo);
            AppMethodBeat.o(74062);
            return;
        }
        favPostVoiceUI.ljM = 0;
        AppMethodBeat.o(74062);
    }

    static /* synthetic */ void n(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(74063);
        favPostVoiceUI.miA.setKeepScreenOn(false);
        favPostVoiceUI.miM.EB();
        favPostVoiceUI.gci.stopTimer();
        favPostVoiceUI.miP.stopTimer();
        favPostVoiceUI.bvI();
        favPostVoiceUI.bvH();
        AppMethodBeat.o(74063);
    }
}
