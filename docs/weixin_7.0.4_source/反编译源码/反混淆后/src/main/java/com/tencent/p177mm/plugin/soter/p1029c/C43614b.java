package com.tencent.p177mm.plugin.soter.p1029c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnShowListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.p069v7.app.C7452b;
import android.support.p069v7.app.C7452b.C0574a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.soter.p528d.C39855i;
import com.tencent.p177mm.plugin.soter.p528d.C39856k;
import com.tencent.p177mm.plugin.soter.p528d.C46263j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C30972i;
import com.tencent.soter.core.p1351c.C30973j;
import com.tencent.soter.p663a.C30954a;
import com.tencent.soter.p663a.p1106b.C16163a;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;
import com.tencent.soter.p663a.p1349d.C40987a;
import com.tencent.soter.p663a.p1349d.C40989b;
import com.tencent.soter.p663a.p664g.C24298b.C5823a;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.soter.c.b */
public final class C43614b extends C46260c {
    TextView iqw = null;
    Handler mMainHandler = new Handler(Looper.getMainLooper());
    C40987a mrV = null;
    boolean rNN = false;
    C7452b rNO = null;
    ImageView rNP = null;
    private final int rNQ = 3;
    private int rNR = 0;
    private final long rNS = 500;
    Animation rNT = null;
    Animation rNU = null;
    Runnable rNV = new C351569();

    /* renamed from: com.tencent.mm.plugin.soter.c.b$4 */
    class C137194 implements C40989b {

        /* renamed from: com.tencent.mm.plugin.soter.c.b$4$1 */
        class C137181 implements Runnable {
            C137181() {
            }

            public final void run() {
                AppMethodBeat.m2504i(73868);
                C43614b.this.rNN = false;
                C43614b.m78051a(C43614b.this, true);
                AppMethodBeat.m2505o(73868);
            }
        }

        C137194() {
        }

        public final void bxL() {
            AppMethodBeat.m2504i(73869);
            C4990ab.m7418v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
            C43614b.this.rNN = true;
            AppMethodBeat.m2505o(73869);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(73870);
            C4990ab.m7417i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", Integer.valueOf(i), charSequence);
            AppMethodBeat.m2505o(73870);
        }

        public final void bxM() {
            AppMethodBeat.m2504i(73871);
            C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
            C43614b.this.rNN = false;
            C43614b.this.mrV = null;
            C43614b c43614b = C43614b.this;
            c43614b.iqw.removeCallbacks(c43614b.rNV);
            c43614b.rNP.setImageResource(C25738R.drawable.b61);
            c43614b.iqw.setTextColor(c43614b.iqw.getResources().getColor(C25738R.color.a2e));
            c43614b.iqw.setText(c43614b.iqw.getResources().getString(C25738R.string.erd));
            AppMethodBeat.m2505o(73871);
        }

        public final void onAuthenticationFailed() {
            AppMethodBeat.m2504i(73872);
            C4990ab.m7420w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
            C43614b c43614b = C43614b.this;
            String string = C4996ah.getContext().getString(C25738R.string.er_);
            if (c43614b.rNT == null) {
                c43614b.rNT = C43614b.m78052eS(c43614b.rNP.getContext());
            }
            if (c43614b.rNU == null) {
                c43614b.rNU = C43614b.m78052eS(c43614b.rNP.getContext());
            }
            c43614b.rNT.setAnimationListener(new C351558(string));
            c43614b.iqw.startAnimation(c43614b.rNT);
            c43614b.rNP.startAnimation(c43614b.rNU);
            C43614b.this.mMainHandler.postDelayed(new C137181(), 500);
            AppMethodBeat.m2505o(73872);
        }

        public final void onAuthenticationCancelled() {
            AppMethodBeat.m2504i(73873);
            C4990ab.m7418v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
            C43614b.this.mrV = null;
            AppMethodBeat.m2505o(73873);
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(73874);
            C4990ab.m7413e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
            AppMethodBeat.m2505o(73874);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$3 */
    class C168693 implements C16164b<C16163a> {
        C168693() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(73867);
            final C16163a c16163a = (C16163a) c46744e;
            C4990ab.m7417i("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", Integer.valueOf(c16163a.errCode), c16163a.aIm);
            C43614b.this.rNN = false;
            if (c16163a.isSuccess()) {
                C43614b.this.mMainHandler.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(73866);
                        C30973j c30973j = (C30973j) c16163a.AvM;
                        C43614b.this.rOb.errCode = 0;
                        C43614b.this.rOb.aIm = "OK";
                        C43614b.this.rOb.rOj = (byte) 1;
                        C43614b.this.rOb.cLO = c30973j.Avx;
                        C43614b.this.rOb.rOk = c30973j.signature;
                        C43614b.this.cvK();
                        AppMethodBeat.m2505o(73866);
                    }
                }, 500);
                AppMethodBeat.m2505o(73867);
                return;
            }
            C39855i.m68268fI(3, c16163a.errCode);
            if (c16163a.errCode == 13 || c16163a.errCode == 20) {
                C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
                C30954a.m49584Ri(C43614b.this.gOW);
                C43614b.this.rOb.errCode = 90007;
                C43614b.this.rOb.aIm = "start fingerprint authen failed";
            } else if (c16163a.errCode == 25) {
                C43614b.this.rOb.errCode = 90010;
                C43614b.this.rOb.aIm = "authenticate freeze. please try again later";
            } else {
                C43614b.this.rOb.errCode = 90007;
                C43614b.this.rOb.aIm = "authenticate error: " + c16163a.aIm;
            }
            C43614b.this.cvM();
            AppMethodBeat.m2505o(73867);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$1 */
    class C221541 implements C16164b<C16165c> {
        C221541() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(73864);
            C16165c c16165c = (C16165c) c46744e;
            C4990ab.m7417i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", Integer.valueOf(c16165c.errCode), c16165c.aIm);
            C43614b.this.cvJ();
            if (c16165c.isSuccess()) {
                C43614b.m78051a(C43614b.this, false);
                if (C43614b.this.rOe != null) {
                    C43614b.this.rOe.mo17329a((C30972i) c16165c.AvM);
                }
            } else {
                C39855i.m68268fI(2, c16165c.errCode);
            }
            if (c16165c.errCode == 12) {
                C4990ab.m7412e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
                C43614b.this.rOb.errCode = 90007;
                C43614b.this.rOb.aIm = "auth key can not be retrieved";
                C43614b.this.cvM();
                AppMethodBeat.m2505o(73864);
            } else if (c16165c.errCode == 5) {
                C4990ab.m7418v("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
                C30954a.m49584Ri(C43614b.this.gOW);
                C43614b.this.rOb.errCode = 90007;
                C43614b.this.rOb.aIm = "auth key generate failed";
                C43614b.this.cvM();
                AppMethodBeat.m2505o(73864);
            } else {
                if (c16165c.errCode == 10) {
                    C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
                    C30954a.m49584Ri(C43614b.this.gOW);
                    C43614b.this.rOb.errCode = 90007;
                    C43614b.this.rOb.aIm = "auth key update error";
                    C43614b.this.cvM();
                }
                AppMethodBeat.m2505o(73864);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$2 */
    class C292532 implements Runnable {
        C292532() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73865);
            C43614b.this.mrV = new C40987a();
            C43614b.m78050a(C43614b.this);
            AppMethodBeat.m2505o(73865);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$6 */
    class C351536 implements OnClickListener {
        C351536() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(73876);
            C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth by click button");
            C43614b.this.mrV.mo64931rr(true);
            C43614b.this.cvL();
            AppMethodBeat.m2505o(73876);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$7 */
    class C351547 implements OnCancelListener {
        C351547() {
        }

        @TargetApi(16)
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(73877);
            C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: user cancelled auth");
            C43614b.this.cvL();
            AppMethodBeat.m2505o(73877);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$8 */
    class C351558 implements AnimationListener {
        /* renamed from: tT */
        final /* synthetic */ CharSequence f15066tT;

        C351558(CharSequence charSequence) {
            this.f15066tT = charSequence;
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(73878);
            C43614b.this.rNP.setImageResource(C25738R.drawable.b60);
            C43614b.this.iqw.setText(this.f15066tT);
            C43614b.this.iqw.setTextColor(C43614b.this.iqw.getResources().getColor(C25738R.color.a56));
            C43614b.this.iqw.removeCallbacks(C43614b.this.rNV);
            AppMethodBeat.m2505o(73878);
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(73879);
            C43614b.this.iqw.post(C43614b.this.rNV);
            AppMethodBeat.m2505o(73879);
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$9 */
    class C351569 implements Runnable {
        C351569() {
        }

        public final void run() {
            AppMethodBeat.m2504i(73880);
            C43614b.this.iqw.setTextColor(C43614b.this.iqw.getResources().getColor(C25738R.color.f12090ry));
            C43614b.this.iqw.setText(C43614b.this.iqw.getResources().getString(C25738R.string.erc));
            C43614b.this.rNP.setImageResource(C25738R.drawable.b5z);
            AppMethodBeat.m2505o(73880);
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.c.b$5 */
    class C398525 implements OnShowListener {
        C398525() {
        }

        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(73875);
            C43614b.this.rNO.f2092Uz.f831Tv.setTextColor(C4996ah.getContext().getResources().getColor(C25738R.color.f11830in));
            AppMethodBeat.m2505o(73875);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m78050a(C43614b c43614b) {
        AppMethodBeat.m2504i(73890);
        c43614b.cvH();
        AppMethodBeat.m2505o(73890);
    }

    public C43614b(WeakReference<Activity> weakReference, C46263j c46263j, C39856k c39856k, Handler handler) {
        super(weakReference, c46263j, c39856k, handler);
        AppMethodBeat.m2504i(73881);
        AppMethodBeat.m2505o(73881);
    }

    @TargetApi(23)
    /* renamed from: fj */
    public final void mo69233fj() {
        AppMethodBeat.m2504i(73882);
        if (!C40997a.m71099iR(C4996ah.getContext())) {
            this.rOb.errCode = 90011;
            this.rOb.aIm = "no fingerprint enrolled";
            cvM();
        }
        try {
            if (C4996ah.getContext().checkSelfPermission("android.permission.USE_FINGERPRINT") != 0) {
                mo74368G(new String[]{"android.permission.USE_FINGERPRINT"});
                AppMethodBeat.m2505o(73882);
                return;
            }
            this.rNN = true;
            AppMethodBeat.m2505o(73882);
        } catch (NoSuchMethodError e) {
            C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: not implements the checkSelfPermission. permission already given");
            this.rNN = true;
            AppMethodBeat.m2505o(73882);
        }
    }

    private boolean cvG() {
        AppMethodBeat.m2504i(73883);
        cvI();
        C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: auth key not valid or auth key not valid");
        C221541 c221541 = new C221541();
        C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy:mscene:" + this.gOW);
        C30954a.m49586a(c221541, false, this.gOW, this.rOc, this.rOd);
        AppMethodBeat.m2505o(73883);
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(73884);
        if (i == 0) {
            if (strArr.length <= 0 || iArr.length <= 0 || !"android.permission.USE_FINGERPRINT".equals(strArr[0]) || iArr[0] != 0) {
                C4990ab.m7420w("MicroMsg.SoterControllerFingerprint", "hy: permission not granted");
                this.rOb.errCode = 90002;
                this.rOb.aIm = "user not grant to use fingerprint";
                cvM();
            } else {
                C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: permission granted");
                cvG();
                this.rNN = true;
                AppMethodBeat.m2505o(73884);
                return;
            }
        }
        AppMethodBeat.m2505o(73884);
    }

    private void cvH() {
        AppMethodBeat.m2504i(73885);
        this.mrV = new C40987a();
        C168693 c168693 = new C168693();
        C40989b c137194 = new C137194();
        C5823a aug = new C5823a().mo12210Rj(this.gOW).mo12217iW(C4996ah.getContext()).mo12214a(this.mrV).aug(this.rOa.msn);
        aug.Awk.Awg = null;
        C30954a.m49585a(c168693, aug.mo12215a(c137194).Awk);
        AppMethodBeat.m2505o(73885);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(73886);
        if (this.rNN) {
            cvG();
        }
        AppMethodBeat.m2505o(73886);
    }

    @TargetApi(16)
    public final void onPause() {
        AppMethodBeat.m2504i(73887);
        if (this.rNN && this.mrV != null) {
            this.mrV.mo64931rr(true);
        }
        if (this.rNO != null && this.rNO.isShowing()) {
            this.rNO.dismiss();
        }
        AppMethodBeat.m2505o(73887);
    }

    /* renamed from: eS */
    public static Animation m78052eS(Context context) {
        AppMethodBeat.m2504i(73888);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.SoterControllerFingerprint", "hy: context is null.");
            AppMethodBeat.m2505o(73888);
            return null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(context, C25738R.anim.f8292r);
        if (-1 > 0) {
            loadAnimation.setDuration(-1);
        }
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        AppMethodBeat.m2505o(73888);
        return loadAnimation;
    }

    /* renamed from: a */
    static /* synthetic */ void m78051a(C43614b c43614b, boolean z) {
        AppMethodBeat.m2504i(73889);
        if (c43614b.rNO == null || !c43614b.rNO.isShowing()) {
            if (c43614b.hiC == null || c43614b.hiC.get() == null) {
                C4990ab.m7412e("MicroMsg.SoterControllerFingerprint", "hy: ui released.");
                c43614b.rOb.errCode = 90007;
                c43614b.rOb.aIm = "internal error occurred: ui released";
                c43614b.cvM();
            } else {
                if (c43614b.rNO == null) {
                    Activity activity = (Activity) c43614b.hiC.get();
                    C0574a c0574a = new C0574a(activity);
                    View inflate = activity.getLayoutInflater().inflate(2130969562, null, false);
                    c43614b.rNP = (ImageView) inflate.findViewById(2131824046);
                    c43614b.iqw = (TextView) inflate.findViewById(2131824047);
                    ((TextView) inflate.findViewById(2131824045)).setText(c43614b.rOa.content);
                    c0574a.f864UA.mView = inflate;
                    c0574a.f864UA.f773Tl = 0;
                    c0574a.f864UA.f778Tq = false;
                    c0574a.f864UA.mCancelable = true;
                    C351536 c351536 = new C351536();
                    c0574a.f864UA.f770TY = c0574a.f864UA.mContext.getText(C25738R.string.eqr);
                    c0574a.f864UA.f779Ua = c351536;
                    c0574a.f864UA.f783Ue = new C351547();
                    c43614b.rNO = c0574a.mo1393fi();
                    c43614b.rNO.setOnShowListener(new C398525());
                    c43614b.mo74369a(c43614b.rNO);
                    c43614b.rNO.setCanceledOnTouchOutside(false);
                }
                if (!c43614b.rNO.isShowing()) {
                    c43614b.rNO.show();
                }
            }
        }
        if (z) {
            boolean z2;
            if (VERSION.SDK_INT < 23) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                C4990ab.m7416i("MicroMsg.SoterControllerFingerprint", "hy: req restart after fail, but no need");
                AppMethodBeat.m2505o(73889);
                return;
            }
        }
        if (c43614b.mrV != null) {
            C4990ab.m7412e("MicroMsg.SoterControllerFingerprint", "alvinluo mFingerprintCanceller not null, cancel and start auth by delaying 500ms.");
            c43614b.mrV.mo64931rr(true);
            c43614b.mMainHandler.postDelayed(new C292532(), 500);
            AppMethodBeat.m2505o(73889);
            return;
        }
        c43614b.cvH();
        AppMethodBeat.m2505o(73889);
    }
}
