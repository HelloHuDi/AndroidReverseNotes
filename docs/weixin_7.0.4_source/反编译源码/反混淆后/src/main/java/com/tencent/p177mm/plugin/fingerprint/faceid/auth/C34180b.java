package com.tencent.p177mm.plugin.fingerprint.faceid.auth;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView.C28050a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.plugin.wallet_core.model.C35481v;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.wallet.C14990c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.soter.p663a.p664g.C40994f;

/* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.b */
public final class C34180b extends C15532i implements LifecycleObserver {
    private View jcl;
    TextView kGq;
    FrameAnimatorImageView mre;
    TextView mrf;
    private TextView mrg;
    ViewGroup mrh;
    private ViewGroup mri;
    private C3128a mrj;

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.b$a */
    static class C3128a implements OnCancelListener, OnDismissListener, OnShowListener {
        private Bundle fPq;
        C34180b mrl;
        private C30052l mrm;
        private C11932a mrn;
        private int mro;
        boolean mrp = false;
        private C14990c mrq = new C31291();
        private int retryCount = 0;
        private int scene;

        /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.b$a$1 */
        class C31291 implements C14990c {
            C31291() {
            }

            /* renamed from: bJ */
            public final void mo7357bJ(int i, int i2) {
                AppMethodBeat.m2504i(41396);
                C4990ab.m7417i("MicroMsg.WalletFaceIdDialog", "auth result: %s, retry: %s", Integer.valueOf(i), Integer.valueOf(C3128a.this.retryCount));
                switch (i) {
                    case 0:
                        C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "identify success");
                        C3128a.this.mro = i2;
                        C3128a.this.retryCount = C3128a.this.retryCount + 1;
                        C3128a.m5367b(C3128a.this, i2);
                        AppMethodBeat.m2505o(41396);
                        return;
                    case 2000:
                    case 2001:
                    case 2002:
                    case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                    case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                    case 2009:
                    case 10308:
                        C3128a.this.retryCount = C3128a.this.retryCount + 1;
                        if (C3128a.this.retryCount >= 2) {
                            C3128a.m5369c(C3128a.this, i);
                            break;
                        }
                        C3128a.m5370d(C3128a.this);
                        AppMethodBeat.m2505o(41396);
                        return;
                }
                AppMethodBeat.m2505o(41396);
            }
        }

        /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.b$a$3 */
        class C31313 implements AnimationListener {
            C31313() {
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.m2504i(41398);
                C4990ab.m7410d("MicroMsg.WalletFaceIdDialog", "fail anim start");
                AppMethodBeat.m2505o(41398);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.m2504i(41399);
                C4990ab.m7410d("MicroMsg.WalletFaceIdDialog", "fail anim end");
                C3128a.m5372e(C3128a.this);
                AppMethodBeat.m2505o(41399);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        }

        /* renamed from: a */
        static /* synthetic */ void m5365a(C3128a c3128a) {
            AppMethodBeat.m2504i(41408);
            c3128a.bxb();
            AppMethodBeat.m2505o(41408);
        }

        /* renamed from: e */
        static /* synthetic */ void m5372e(C3128a c3128a) {
            AppMethodBeat.m2504i(41413);
            c3128a.mo7382vJ(-1);
            AppMethodBeat.m2505o(41413);
        }

        public C3128a(C34180b c34180b, C11932a c11932a, Bundle bundle) {
            AppMethodBeat.m2504i(41400);
            this.mrl = c34180b;
            this.mrn = c11932a;
            this.fPq = bundle;
            if (this.fPq != null) {
                this.scene = this.fPq.getInt("face_auth_scene");
            }
            AppMethodBeat.m2505o(41400);
        }

        private void bxb() {
            AppMethodBeat.m2504i(41401);
            this.mrm.bxk();
            AppMethodBeat.m2505o(41401);
        }

        /* Access modifiers changed, original: final */
        public final void bxc() {
            AppMethodBeat.m2504i(41402);
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "req faceid auth");
            if (this.mrm == null) {
                C4990ab.m7420w("MicroMsg.WalletFaceIdDialog", "mgr is null");
                AppMethodBeat.m2505o(41402);
                return;
            }
            this.mrm.bxu();
            this.mrm.bxt();
            if (!this.mrm.bxB()) {
                C4990ab.m7420w("MicroMsg.WalletFaceIdDialog", "no faceid enrolled");
                mo7382vJ(-2);
                AppMethodBeat.m2505o(41402);
            } else if (C5046bo.isNullOrNil(C35481v.tCn.msn)) {
                C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "no challenge");
                mo7382vJ(-3);
                AppMethodBeat.m2505o(41402);
            } else {
                this.mrm.mo48283a(this.mrq);
                this.mrl.bxa();
                AppMethodBeat.m2505o(41402);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: vJ */
        public final void mo7382vJ(int i) {
            AppMethodBeat.m2504i(41403);
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "auth fail");
            if (this.mrn != null) {
                this.mrn.mo9482vJ(i);
                this.mrn = null;
            }
            this.mrl.dismiss();
            AppMethodBeat.m2505o(41403);
        }

        /* Access modifiers changed, original: final */
        public final void bwO() {
            AppMethodBeat.m2504i(41404);
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "auth cancel");
            if (this.mrn != null) {
                this.mrn.bwO();
                this.mrn = null;
            }
            AppMethodBeat.m2505o(41404);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(41405);
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "face id dialog dismiss");
            bxb();
            if (this.scene == 1) {
                bwO();
            }
            AppMethodBeat.m2505o(41405);
        }

        public final void onShow(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(41406);
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "face id dialog show");
            this.mrm = (C30052l) C1720g.m3528K(C30052l.class);
            C40994f.dRn().dRo();
            bxc();
            AppMethodBeat.m2505o(41406);
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(41407);
            C4990ab.m7410d("MicroMsg.WalletFaceIdDialog", "face id dialog cancel");
            bwO();
            AppMethodBeat.m2505o(41407);
        }

        /* renamed from: b */
        static /* synthetic */ void m5367b(C3128a c3128a, final int i) {
            AppMethodBeat.m2504i(41409);
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "auth success");
            if (c3128a.retryCount == 0) {
                C7060h.pYm.mo15419k(916, 3, 1);
            } else {
                C7060h.pYm.mo15419k(916, 4, 1);
            }
            C34180b c34180b = c3128a.mrl;
            c34180b.mre.mo45970a(C25738R.drawable.f6692mx, new C28050a() {
                public final void onStop() {
                    AppMethodBeat.m2504i(41397);
                    C3128a.m5371d(C3128a.this, i);
                    AppMethodBeat.m2505o(41397);
                }
            });
            AppMethodBeat.m2505o(41409);
        }

        /* renamed from: d */
        static /* synthetic */ void m5370d(C3128a c3128a) {
            AppMethodBeat.m2504i(41410);
            c3128a.mrl.bwZ();
            c3128a.mrl.mo54757d(null);
            C34180b c34180b = c3128a.mrl;
            c34180b.mrh.setVisibility(0);
            c34180b.mrf.setVisibility(0);
            c34180b.kGq.setText(C25738R.string.bmx);
            c34180b.mrf.setText(C25738R.string.bmw);
            AppMethodBeat.m2505o(41410);
        }

        /* renamed from: c */
        static /* synthetic */ void m5369c(C3128a c3128a, int i) {
            AppMethodBeat.m2504i(41411);
            C4990ab.m7421w("MicroMsg.WalletFaceIdDialog", "face id failed: %s", Integer.valueOf(c3128a.scene));
            c3128a.mrl.bwZ();
            C7060h.pYm.mo15419k(916, 5, 1);
            c3128a.mrp = true;
            if (c3128a.scene == 0) {
                c3128a.mrl.mo54757d(null);
                C34180b c34180b = c3128a.mrl;
                c34180b.kGq.setText(C25738R.string.bmp);
                c34180b.mrf.setVisibility(8);
                if (i == 10308) {
                    C46261a.m86640e(6, -1000223, i, "too many trial");
                    AppMethodBeat.m2505o(41411);
                    return;
                }
                C46261a.m86640e(1000, -1000223, i, "fingerprint error");
                AppMethodBeat.m2505o(41411);
                return;
            }
            c3128a.mrl.mo54757d(new C31313());
            AppMethodBeat.m2505o(41411);
        }

        /* renamed from: d */
        static /* synthetic */ void m5371d(C3128a c3128a, int i) {
            AppMethodBeat.m2504i(41412);
            if (c3128a.mrn != null) {
                c3128a.mrn.mo9481ef(i, c3128a.retryCount);
                c3128a.mrn = null;
            }
            c3128a.mrl.dismiss();
            AppMethodBeat.m2505o(41412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.b$1 */
    class C280551 implements OnClickListener {
        C280551() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41393);
            C4990ab.m7410d("MicroMsg.WalletFaceIdDialog", "click dismiss btn");
            C3128a a = C34180b.this.mrj;
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "click left btn");
            if (a.mrp) {
                a.mo7382vJ(-1);
            } else {
                a.bwO();
            }
            C34180b.this.dismiss();
            AppMethodBeat.m2505o(41393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.b$2 */
    class C341812 implements OnClickListener {
        C341812() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41394);
            C4990ab.m7410d("MicroMsg.WalletFaceIdDialog", "click right btn");
            C3128a a = C34180b.this.mrj;
            C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "click right btn");
            C34180b c34180b = a.mrl;
            c34180b.mrf.setEnabled(false);
            c34180b.kGq.setText(C25738R.string.bmn);
            a.bxc();
            AppMethodBeat.m2505o(41394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.b$3 */
    class C341823 implements C28050a {
        C341823() {
        }

        public final void onStop() {
            AppMethodBeat.m2504i(41395);
            C4990ab.m7410d("MicroMsg.WalletFaceIdDialog", "trigger load finish");
            C34180b.this.mre.mo45970a(C25738R.drawable.f6691mw, null);
            AppMethodBeat.m2505o(41395);
        }
    }

    public C34180b(Context context, C11932a c11932a) {
        this(context, c11932a, null);
    }

    public C34180b(Context context, C11932a c11932a, Bundle bundle) {
        this(context);
        AppMethodBeat.m2504i(41414);
        this.mrj = new C3128a(this, c11932a, bundle);
        setOnShowListener(this.mrj);
        setOnDismissListener(this.mrj);
        setOnCancelListener(this.mrj);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        AppMethodBeat.m2505o(41414);
    }

    private C34180b(Context context) {
        super(context, C25738R.style.f10900i5);
        AppMethodBeat.m2504i(41415);
        initView();
        AppMethodBeat.m2505o(41415);
    }

    private C34180b(Context context, int i) {
        super(context, C25738R.style.f10900i5);
        AppMethodBeat.m2504i(41416);
        initView();
        AppMethodBeat.m2505o(41416);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41417);
        super.onCreate(bundle);
        setContentView(this.jcl);
        AppMethodBeat.m2505o(41417);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onStart() {
        AppMethodBeat.m2504i(41418);
        super.onStart();
        AppMethodBeat.m2505o(41418);
    }

    private void initView() {
        AppMethodBeat.m2504i(41419);
        this.jcl = View.inflate(getContext(), 2130969487, null);
        this.mri = (ViewGroup) this.jcl.findViewById(2131823855);
        this.mre = (FrameAnimatorImageView) this.jcl.findViewById(2131823856);
        this.kGq = (TextView) this.jcl.findViewById(2131823857);
        this.mrf = (TextView) this.jcl.findViewById(2131823860);
        this.mrg = (TextView) this.jcl.findViewById(2131823859);
        this.mrh = (ViewGroup) this.jcl.findViewById(2131823858);
        bwY();
        this.mrg.setOnClickListener(new C280551());
        this.mrf.setOnClickListener(new C341812());
        AppMethodBeat.m2505o(41419);
    }

    private void bwY() {
        AppMethodBeat.m2504i(41420);
        this.jcl.setBackgroundColor(0);
        this.kGq.setTextColor(Color.parseColor("#888888"));
        AppMethodBeat.m2505o(41420);
    }

    public final void bwZ() {
        AppMethodBeat.m2504i(41421);
        getWindow().setDimAmount(0.5f);
        this.jcl.setBackgroundResource(C25738R.drawable.f6963wz);
        this.mri.setBackground(null);
        this.kGq.setTextColor(Color.parseColor("#111111"));
        this.kGq.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9733dz));
        AppMethodBeat.m2505o(41421);
    }

    public final void bxa() {
        AppMethodBeat.m2504i(41422);
        C4990ab.m7410d("MicroMsg.WalletFaceIdDialog", "trigger load start");
        this.mre.mo45970a(C25738R.drawable.f6694mz, new C341823());
        AppMethodBeat.m2505o(41422);
    }

    /* renamed from: d */
    public final void mo54757d(AnimationListener animationListener) {
        AppMethodBeat.m2504i(41423);
        this.mre.setImageResource(C25738R.drawable.b42);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C25738R.anim.f8325aw);
        this.mre.startAnimation(loadAnimation);
        if (animationListener != null) {
            loadAnimation.setAnimationListener(animationListener);
        }
        AppMethodBeat.m2505o(41423);
    }

    @OnLifecycleEvent(Event.ON_STOP)
    public final void onActivityStop() {
        AppMethodBeat.m2504i(41424);
        C4990ab.m7416i("MicroMsg.WalletFaceIdDialog", "activity pause");
        C3128a.m5365a(this.mrj);
        dismiss();
        AppMethodBeat.m2505o(41424);
    }
}
