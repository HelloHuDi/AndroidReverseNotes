package com.tencent.p177mm.plugin.fav.p410ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.audio.p195b.C25833j;
import com.tencent.p177mm.audio.p195b.C25833j.C1294a;
import com.tencent.p177mm.compatible.p219b.C18168c.C18169a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5728b;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI */
public class FavPostVoiceUI extends MMBaseActivity {
    private static final int[] gcc = new int[]{C25738R.drawable.aab, C25738R.drawable.aac, C25738R.drawable.aad, C25738R.drawable.aae, C25738R.drawable.aaf, C25738R.drawable.aag, C25738R.drawable.aah};
    private static final int[] miN = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private long duration;
    private final C7564ap gci = new C7564ap(new C430631(), true);
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
    private C25833j miM;
    private final C7306ak miO = new C279896();
    private final C7564ap miP = new C7564ap(new C118647(), true);
    boolean miQ = false;
    private String path;

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$7 */
    class C118647 implements C5015a {
        C118647() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(74047);
            if (FavPostVoiceUI.this.miD == -1) {
                FavPostVoiceUI.this.miD = C5046bo.m7588yz();
            }
            long az = C5046bo.m7525az(FavPostVoiceUI.this.miD);
            if (az >= 3590000 && az <= 3600000) {
                if (FavPostVoiceUI.this.miE == null) {
                    FavPostVoiceUI.this.miE = Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(C25738R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}), 0);
                } else {
                    FavPostVoiceUI.this.miE.setText(FavPostVoiceUI.this.getString(C25738R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}));
                }
                FavPostVoiceUI.this.miE.show();
            }
            if (az >= 3600000) {
                C4990ab.m7418v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
                FavPostVoiceUI.this.miC = true;
                FavPostVoiceUI.m76518p(FavPostVoiceUI.this);
                AppMethodBeat.m2505o(74047);
                return false;
            }
            AppMethodBeat.m2505o(74047);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$8 */
    class C118658 implements AnimationListener {

        /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$8$1 */
        class C118661 implements Runnable {
            C118661() {
            }

            public final void run() {
                AppMethodBeat.m2504i(74048);
                FavPostVoiceUI.this.setResult(0);
                FavPostVoiceUI.this.finish();
                FavPostVoiceUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.m2505o(74048);
            }
        }

        C118658() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(74049);
            FavPostVoiceUI.this.miI.post(new C118661());
            AppMethodBeat.m2505o(74049);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$5 */
    class C207025 implements OnTouchListener {
        C207025() {
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74045);
            if (view != FavPostVoiceUI.this.miA) {
                AppMethodBeat.m2505o(74045);
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
                            FavPostVoiceUI.m76512j(FavPostVoiceUI.this);
                        }
                    case 1:
                        if (!FavPostVoiceUI.this.miB) {
                            AppMethodBeat.m2505o(74045);
                            break;
                        } else if (FavPostVoiceUI.this.miJ.getVisibility() == 0) {
                            C4990ab.m7420w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                            FavPostVoiceUI.m76516n(FavPostVoiceUI.this);
                        } else if (!FavPostVoiceUI.this.miC) {
                            FavPostVoiceUI.m76518p(FavPostVoiceUI.this);
                        }
                    case 2:
                        if (rawY > FavPostVoiceUI.this.iev - C4977b.m7371b(FavPostVoiceUI.this, 60.0f) || rawY >= i) {
                            FavPostVoiceUI.this.miI.setVisibility(0);
                            FavPostVoiceUI.this.miJ.setVisibility(8);
                        } else {
                            FavPostVoiceUI.this.miI.setVisibility(8);
                            FavPostVoiceUI.this.miJ.setVisibility(0);
                        }
                        AppMethodBeat.m2505o(74045);
                        break;
                    case 3:
                        C4990ab.m7420w("MicroMsg.FavPostVoiceUI", "action cancel");
                        FavPostVoiceUI.m76516n(FavPostVoiceUI.this);
                        AppMethodBeat.m2505o(74045);
                        break;
                }
                AppMethodBeat.m2505o(74045);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$6 */
    class C279896 extends C7306ak {
        C279896() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(74046);
            super.handleMessage(message);
            FavPostVoiceUI.this.bvH();
            FavPostVoiceUI.this.miA.setBackgroundResource(C25738R.drawable.f7010yg);
            FavPostVoiceUI.this.miA.setEnabled(true);
            AppMethodBeat.m2505o(74046);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$3 */
    class C390463 implements Runnable {
        C390463() {
        }

        public final void run() {
            AppMethodBeat.m2504i(74043);
            FavPostVoiceUI.this.findViewById(2131823954).setVisibility(0);
            FavPostVoiceUI.this.miL.setVisibility(0);
            FavPostVoiceUI.this.findViewById(2131823964).setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(300);
            FavPostVoiceUI.this.miL.startAnimation(alphaAnimation);
            FavPostVoiceUI.this.findViewById(2131823954).startAnimation(alphaAnimation);
            FavPostVoiceUI.this.findViewById(2131823964).startAnimation(translateAnimation);
            AppMethodBeat.m2505o(74043);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$1 */
    class C430631 implements C5015a {
        C430631() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            int maxAmplitude;
            int i = 0;
            AppMethodBeat.m2504i(74041);
            C25833j a = FavPostVoiceUI.this.miM;
            if (a.status == 1) {
                maxAmplitude = a.crg.getMaxAmplitude();
                if (maxAmplitude > C25833j.cri) {
                    C25833j.cri = maxAmplitude;
                }
                maxAmplitude = (maxAmplitude * 100) / C25833j.cri;
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
            AppMethodBeat.m2505o(74041);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$2 */
    class C430642 implements OnTouchListener {
        C430642() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(74042);
            FavPostVoiceUI.m76505c(FavPostVoiceUI.this);
            AppMethodBeat.m2505o(74042);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavPostVoiceUI$4 */
    class C430654 implements C1294a {
        C430654() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(74044);
            FavPostVoiceUI.this.gci.stopTimer();
            FavPostVoiceUI.this.miP.stopTimer();
            AppMethodBeat.m2505o(74044);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public FavPostVoiceUI() {
        AppMethodBeat.m2504i(74050);
        AppMethodBeat.m2505o(74050);
    }

    /* renamed from: c */
    static /* synthetic */ void m76505c(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.m2504i(74061);
        favPostVoiceUI.bvJ();
        AppMethodBeat.m2505o(74061);
    }

    /* renamed from: p */
    static /* synthetic */ void m76518p(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.m2504i(74064);
        favPostVoiceUI.bvG();
        AppMethodBeat.m2505o(74064);
    }

    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.m2504i(74051);
        super.onCreate(bundle);
        setContentView(C5616v.m8409hu(this).inflate(2130969523, null));
        this.miH = (ImageView) findViewById(2131823958);
        this.miI = findViewById(2131823956);
        this.miJ = findViewById(2131823960);
        this.miF = findViewById(2131823955);
        this.miG = findViewById(2131823963);
        this.miK = (TextView) findViewById(2131823959);
        this.miL = findViewById(2131823953);
        findViewById(2131823954).setVisibility(8);
        this.miL.setVisibility(8);
        findViewById(2131823954).setOnTouchListener(new C430642());
        findViewById(2131823964).setVisibility(8);
        this.miM = bvF();
        this.miA = (Button) findViewById(2131823965);
        this.miA.setOnTouchListener(new C207025());
        bvH();
        String bun = C39037b.bun();
        C5728b c5728b = new C5728b(bun);
        if (!c5728b.exists()) {
            c5728b.mkdirs();
        }
        do {
            str = bun + "/" + System.currentTimeMillis();
        } while (new C5728b(str).exists());
        this.path = str;
        this.miK.post(new C390463());
        AppMethodBeat.m2505o(74051);
    }

    private C25833j bvF() {
        AppMethodBeat.m2504i(74052);
        C18169a c18169a = C18169a.AMR;
        C25833j c25833j = new C25833j();
        c25833j.crh = new C430654();
        AppMethodBeat.m2505o(74052);
        return c25833j;
    }

    private void bvG() {
        long j = 0;
        AppMethodBeat.m2504i(74053);
        if (this.miB) {
            this.miA.setKeepScreenOn(true);
            this.miA.setBackgroundResource(C25738R.drawable.f7009yf);
            this.miA.setText(C25738R.string.bqb);
            this.miM.mo43818EB();
            if (this.ljM != 0) {
                j = C5046bo.m7525az(this.ljM);
            }
            this.duration = j;
            boolean z = this.duration < 800;
            this.gci.stopTimer();
            this.miP.stopTimer();
            if (z) {
                bvI();
                this.miA.setEnabled(false);
                this.miA.setBackgroundResource(C25738R.drawable.f7008ye);
                this.miG.setVisibility(0);
                this.miF.setVisibility(8);
                this.miO.sendEmptyMessageDelayed(0, 500);
            } else {
                String str = this.path;
                int i = (int) this.duration;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7412e("MicroMsg.FavPostLogic", "postVoice path null");
                } else {
                    C27966g c27966g = new C27966g();
                    c27966g.field_type = 3;
                    c27966g.field_sourceType = 6;
                    C3109h.m5348E(c27966g);
                    aar aar = new aar();
                    aar.akV(str);
                    aar.mo27393LD(i);
                    aar.mo27435oY(true);
                    aar.mo27394LE(c27966g.field_type);
                    aar.akR("amr");
                    c27966g.field_favProto.wiv.add(aar);
                    C34157b.m56005B(c27966g);
                    C7060h.pYm.mo8381e(10648, Integer.valueOf(1), Integer.valueOf(0));
                }
                setResult(-1);
                finish();
                overridePendingTransition(0, 0);
            }
            this.miB = false;
            AppMethodBeat.m2505o(74053);
            return;
        }
        AppMethodBeat.m2505o(74053);
    }

    public final void bvH() {
        AppMethodBeat.m2504i(74054);
        this.miF.setVisibility(0);
        this.miG.setVisibility(8);
        this.miJ.setVisibility(8);
        this.miI.setVisibility(0);
        this.miK.setText(C25738R.string.bnh);
        this.miA.setBackgroundResource(C25738R.drawable.f7010yg);
        this.miA.setText(C25738R.string.bqb);
        this.miH.setVisibility(4);
        this.miB = false;
        AppMethodBeat.m2505o(74054);
    }

    private void bvI() {
        AppMethodBeat.m2504i(74055);
        C5728b c5728b = new C5728b(this.path);
        if (c5728b.exists()) {
            c5728b.delete();
        }
        AppMethodBeat.m2505o(74055);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(74056);
        super.onDestroy();
        AppMethodBeat.m2505o(74056);
    }

    public void onResume() {
        AppMethodBeat.m2504i(74057);
        super.onResume();
        AppMethodBeat.m2505o(74057);
    }

    public void onPause() {
        AppMethodBeat.m2504i(74058);
        super.onPause();
        bvG();
        AppMethodBeat.m2505o(74058);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(74059);
        if (4 == i) {
            bvJ();
            AppMethodBeat.m2505o(74059);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(74059);
        return onKeyDown;
    }

    private void bvJ() {
        AppMethodBeat.m2504i(74060);
        if (this.miQ) {
            AppMethodBeat.m2505o(74060);
            return;
        }
        this.miQ = true;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(300);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        translateAnimation.setAnimationListener(new C118658());
        findViewById(2131823954).setVisibility(8);
        findViewById(2131823964).setVisibility(8);
        this.miL.setVisibility(8);
        this.miL.startAnimation(alphaAnimation);
        findViewById(2131823954).startAnimation(alphaAnimation);
        findViewById(2131823964).startAnimation(translateAnimation);
        AppMethodBeat.m2505o(74060);
    }

    /* renamed from: j */
    static /* synthetic */ void m76512j(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.m2504i(74062);
        favPostVoiceUI.miA.setKeepScreenOn(true);
        favPostVoiceUI.miA.setBackgroundResource(C25738R.drawable.f7010yg);
        favPostVoiceUI.miA.setText(C25738R.string.br3);
        favPostVoiceUI.miC = false;
        favPostVoiceUI.miM = favPostVoiceUI.bvF();
        if (favPostVoiceUI.miM.mo43819en(favPostVoiceUI.path)) {
            favPostVoiceUI.ljM = C5046bo.m7588yz();
            favPostVoiceUI.miP.mo16770ae(200, 200);
            favPostVoiceUI.miH.setVisibility(0);
            favPostVoiceUI.gci.mo16770ae(100, 100);
            favPostVoiceUI.miK.setText(C25738R.string.bpo);
            AppMethodBeat.m2505o(74062);
            return;
        }
        favPostVoiceUI.ljM = 0;
        AppMethodBeat.m2505o(74062);
    }

    /* renamed from: n */
    static /* synthetic */ void m76516n(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.m2504i(74063);
        favPostVoiceUI.miA.setKeepScreenOn(false);
        favPostVoiceUI.miM.mo43818EB();
        favPostVoiceUI.gci.stopTimer();
        favPostVoiceUI.miP.stopTimer();
        favPostVoiceUI.bvI();
        favPostVoiceUI.bvH();
        AppMethodBeat.m2505o(74063);
    }
}
