package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.game.p295e.C45562b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C19405n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42528t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.facedetect.ui.a */
public class C34109a {
    private static C20660b lWK = new C20660b();
    private Button lWA = null;
    private ImageView lWB = null;
    private TextView lWC = null;
    private TextView lWD = null;
    private Button lWE = null;
    private Button lWF = null;
    private TextView lWG = null;
    private Animation lWH = null;
    private Animation lWI = null;
    protected WeakReference<FaceDetectPrepareUI> lWJ = null;
    private RelativeLayout lWz = null;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.a$b */
    public static class C20660b extends CountDownTimer {
        WeakReference<TextView> lWO = null;
        WeakReference<TextView> lWP = null;
        String lWQ = null;
        int lWR = 0;
        int lWS = 0;

        public C20660b() {
            super(Long.MAX_VALUE, 500);
        }

        public final void onTick(long j) {
            AppMethodBeat.m2504i(385);
            if (this.lWO == null || this.lWO.get() == null || this.lWP == null || this.lWP.get() == null) {
                C4990ab.m7420w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
                cancel();
            } else {
                TextView textView = (TextView) this.lWP.get();
                ((TextView) this.lWO.get()).setText(this.lWQ.substring(0, this.lWR));
                textView.setText(this.lWQ.substring(this.lWR, this.lWR + (this.lWS % ((this.lWQ.length() - this.lWR) + 1))));
            }
            this.lWS++;
            AppMethodBeat.m2505o(385);
        }

        public final void onFinish() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.a$a */
    interface C27939a {
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.a$1 */
    class C341111 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.facedetect.ui.a$1$1 */
        class C341121 implements AnimationListener {
            C341121() {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(382);
                C34109a.this.lWz.setVisibility(8);
                AppMethodBeat.m2505o(382);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        }

        C341111() {
        }

        public final void run() {
            AppMethodBeat.m2504i(383);
            C34109a.this.lWI.setAnimationListener(new C341121());
            C34109a.this.lWz.startAnimation(C34109a.this.lWI);
            AppMethodBeat.m2505o(383);
        }
    }

    static {
        AppMethodBeat.m2504i(398);
        AppMethodBeat.m2505o(398);
    }

    C34109a(FaceDetectPrepareUI faceDetectPrepareUI) {
        AppMethodBeat.m2504i(386);
        this.lWJ = new WeakReference(faceDetectPrepareUI);
        AppMethodBeat.m2505o(386);
    }

    public void create() {
        AppMethodBeat.m2504i(387);
        synchronized (((FaceDetectPrepareUI) this.lWJ.get())) {
            try {
                if (this.lWJ.get() != null) {
                    this.lWz = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823797);
                    this.lWA = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131822846);
                    this.lWB = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823799);
                    this.lWC = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823800);
                    this.lWH = AnimationUtils.loadAnimation((Context) this.lWJ.get(), C25738R.anim.f8288n);
                    this.lWI = AnimationUtils.loadAnimation((Context) this.lWJ.get(), C25738R.anim.f8289o);
                    this.lWE = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823804);
                    this.lWF = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823802);
                    this.lWD = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823801);
                    this.lWG = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823803);
                    this.lWH.setDuration(500);
                    this.lWI.setDuration(500);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(387);
            }
        }
    }

    public void dismiss() {
        AppMethodBeat.m2504i(C19405n.CTRL_INDEX);
        C4990ab.m7409c("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
        lWK.cancel();
        if (this.lWz.getVisibility() == 0) {
            C5004al.m7441d(new C341111());
        }
        AppMethodBeat.m2505o(C19405n.CTRL_INDEX);
    }

    /* renamed from: M */
    public void mo23623M(Bitmap bitmap) {
        AppMethodBeat.m2504i(C42528t.CTRL_INDEX);
        this.lWz.setBackgroundDrawable(new BitmapDrawable(bitmap));
        AppMethodBeat.m2505o(C42528t.CTRL_INDEX);
    }

    public void resetAll() {
        AppMethodBeat.m2504i(390);
        if (lWK != null) {
            lWK.cancel();
        }
        this.lWE.setVisibility(4);
        this.lWA.setVisibility(4);
        this.lWF.setVisibility(4);
        this.lWD.setVisibility(4);
        this.lWC.setVisibility(4);
        AppMethodBeat.m2505o(390);
    }

    /* renamed from: a */
    public void mo23624a(final C3048c c3048c) {
        AppMethodBeat.m2504i(391);
        if (lWK != null) {
            lWK.cancel();
        }
        if (c3048c == null) {
            AppMethodBeat.m2505o(391);
            return;
        }
        C4990ab.m7417i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", c3048c.toString());
        if (c3048c.lYz) {
            C4990ab.m7416i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
            this.lWE.setVisibility(0);
            this.lWE.setText(c3048c.lYI);
            this.lWE.setOnClickListener(c3048c.lYP);
        } else {
            this.lWE.setVisibility(4);
        }
        if (c3048c.lYw) {
            C4990ab.m7416i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
            this.lWA.setVisibility(0);
            this.lWA.setText(c3048c.lYG);
            this.lWA.setOnClickListener(c3048c.lYM);
        } else {
            this.lWA.setVisibility(4);
        }
        if (c3048c.lYA) {
            C4990ab.m7416i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
            this.lWF.setVisibility(0);
            this.lWF.setText(c3048c.lYH);
            this.lWF.setOnClickListener(c3048c.lYN);
        } else {
            this.lWF.setVisibility(4);
        }
        if (c3048c.lYx) {
            C4990ab.m7416i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
            this.lWC.setVisibility(0);
            if (c3048c.lYB) {
                C4990ab.m7416i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
                this.lWD.setVisibility(0);
                int i = c3048c.lYD;
                String str = c3048c.lYF;
                if (C5046bo.isNullOrNil(str) || i >= str.length() || i < 0) {
                    C4990ab.m7412e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
                    this.lWC.setText(str);
                    this.lWD.setText("");
                } else {
                    lWK.cancel();
                    C20660b c20660b = lWK;
                    WeakReference weakReference = new WeakReference(this.lWC);
                    WeakReference weakReference2 = new WeakReference(this.lWD);
                    c20660b.lWQ = str;
                    c20660b.lWR = i;
                    c20660b.lWO = weakReference;
                    c20660b.lWP = weakReference2;
                    lWK.start();
                }
            } else {
                C4990ab.m7416i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
                this.lWD.setVisibility(4);
                this.lWC.setText(c3048c.lYF);
            }
        } else {
            C4990ab.m7416i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
            this.lWC.setVisibility(4);
            this.lWD.setVisibility(4);
        }
        if (c3048c.lYy) {
            C4990ab.m7416i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
            this.lWB.setVisibility(0);
            this.lWB.setImageResource(c3048c.lYJ);
        } else {
            this.lWB.setVisibility(4);
        }
        if (c3048c.lYC) {
            C4990ab.m7416i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
            this.lWG.setVisibility(0);
            this.lWG.setText(c3048c.lYK);
            this.lWG.setOnClickListener(c3048c.lYO);
        } else {
            this.lWG.setVisibility(4);
        }
        if (c3048c.lYE != null) {
            C4990ab.m7417i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", c3048c.lYE);
            this.lWz.setBackgroundDrawable(new BitmapDrawable(c3048c.lYE));
        }
        C4990ab.m7417i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", Integer.valueOf(this.lWz.getVisibility()));
        if (this.lWz.getVisibility() != 0) {
            this.lWz.setVisibility(0);
            this.lWz.startAnimation(this.lWH);
            this.lWH.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.m2504i(384);
                    C4990ab.m7417i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", Long.valueOf(System.currentTimeMillis()));
                    AppMethodBeat.m2505o(384);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        AppMethodBeat.m2505o(391);
    }

    public boolean aFF() {
        AppMethodBeat.m2504i(392);
        if (this.lWz.getVisibility() != 8) {
            AppMethodBeat.m2505o(392);
            return true;
        }
        AppMethodBeat.m2505o(392);
        return false;
    }

    public static C3048c bti() {
        AppMethodBeat.m2504i(393);
        C3048c b = C34109a.m55909b(C25738R.drawable.b3x, null, null, null, null, null);
        AppMethodBeat.m2505o(393);
        return b;
    }

    /* renamed from: a */
    public static C3048c m55905a(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(394);
        C3048c b = C34109a.m55909b(i, str, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.m2505o(394);
        return b;
    }

    /* renamed from: b */
    public static C3048c m55909b(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        AppMethodBeat.m2504i(C45562b.CTRL_INDEX);
        C3048c c = C34109a.m55910c(i, str, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.m2505o(C45562b.CTRL_INDEX);
        return c;
    }

    /* renamed from: c */
    private static C3048c m55910c(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(396);
        C3048c c3048c = new C3048c();
        c3048c.lYJ = i;
        c3048c.lYF = str;
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        c3048c.lYw = z;
        c3048c.lYG = str2;
        c3048c.lYA = false;
        c3048c.lYH = null;
        if (str3 == null) {
            z2 = false;
        }
        c3048c.lYz = z2;
        c3048c.lYI = str3;
        c3048c.lYC = false;
        c3048c.lYK = null;
        c3048c.lYM = onClickListener;
        c3048c.lYN = null;
        c3048c.lYP = onClickListener2;
        c3048c.lYO = null;
        AppMethodBeat.m2505o(396);
        return c3048c;
    }

    /* renamed from: a */
    public static C3048c m55907a(C3048c c3048c, String str, OnClickListener onClickListener) {
        boolean z;
        if (str != null) {
            z = true;
        } else {
            z = false;
        }
        c3048c.lYC = z;
        c3048c.lYK = str;
        c3048c.lYO = onClickListener;
        return c3048c;
    }

    /* renamed from: a */
    public static C3048c m55906a(Context context, OnClickListener onClickListener) {
        AppMethodBeat.m2504i(397);
        C3048c a = C34109a.m55905a(C25738R.drawable.b31, context.getString(C25738R.string.bkl), null, context.getString(C25738R.string.f9076or), null, onClickListener);
        a.lYB = true;
        a.lYD = context.getString(C25738R.string.bkl).length() - 3;
        AppMethodBeat.m2505o(397);
        return a;
    }
}
