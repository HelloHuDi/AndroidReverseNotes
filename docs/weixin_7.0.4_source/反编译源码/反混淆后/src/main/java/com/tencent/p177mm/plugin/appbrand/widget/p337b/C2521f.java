package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.cki;
import com.tencent.p177mm.protocal.protobuf.ckj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f */
public class C2521f {
    public static final String TAG = ("MicroMsg.AppBrand.Evaluate." + C2521f.class.getSimpleName());
    public String appId;
    public String csu;
    public String cvF;
    public Dialog dialog;
    public boolean jcd = false;
    private int jce = 0;
    public TextView jcf;
    public RatingBar jcg;
    public TextView jch;
    public FrameLayout jci;
    public LinearLayout jcj;
    public int scene;
    public String userName;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$2 */
    class C25222 extends AnimatorListenerAdapter {
        C25222() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(134254);
            C2521f.this.jcj.setVisibility(8);
            AppMethodBeat.m2505o(134254);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$3 */
    class C25233 extends AnimatorListenerAdapter {
        C25233() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(134255);
            C2521f.this.jch.setAlpha(0.0f);
            C2521f.this.jch.setVisibility(0);
            AppMethodBeat.m2505o(134255);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$11 */
    class C252411 implements C9557a {
        C252411() {
        }

        /* renamed from: a */
        public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
            AppMethodBeat.m2504i(134263);
            if (i == 0 && i2 == 0 && c7472b != null && c7472b.fsH.fsP != null && (c7472b.fsH.fsP instanceof ckj)) {
                C4990ab.m7416i(C2521f.TAG, "updateEvaluateCgi, request success");
                if (C2521f.this.jcd) {
                    C2521f.m4763a(C2521f.this, 3, 1);
                    AppMethodBeat.m2505o(134263);
                    return;
                }
                C2521f.m4763a(C2521f.this, 2, 1);
                AppMethodBeat.m2505o(134263);
                return;
            }
            C4990ab.m7412e(C2521f.TAG, "updateEvaluateCgi, request fail");
            if (C2521f.this.jcd) {
                C2521f.m4763a(C2521f.this, 3, 2);
                AppMethodBeat.m2505o(134263);
                return;
            }
            C2521f.m4763a(C2521f.this, 2, 2);
            AppMethodBeat.m2505o(134263);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$9 */
    public class C25259 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(134261);
            C4990ab.m7416i(C2521f.TAG, "user clicked dialog outside");
            C2521f.this.jcd = false;
            C2521f.this.dismiss();
            AppMethodBeat.m2505o(134261);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$12 */
    class C252612 extends AnimatorListenerAdapter {
        C252612() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(134264);
            C2521f.this.jcf.setVisibility(8);
            AppMethodBeat.m2505o(134264);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$1 */
    public class C25271 implements OnCancelListener {
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(134253);
            C4990ab.m7416i(C2521f.TAG, "user cancel evaluate dialog");
            C2521f.this.jcd = false;
            AppMethodBeat.m2505o(134253);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$4 */
    class C25284 extends AnimatorListenerAdapter {
        C25284() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(134256);
            C2521f.this.jci.setAlpha(0.0f);
            C2521f.this.jci.setVisibility(0);
            AppMethodBeat.m2505o(134256);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$5 */
    public class C25295 implements OnDismissListener {
        final /* synthetic */ Runnable val$runnable;

        public C25295(Runnable runnable) {
            this.val$runnable = runnable;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(134257);
            C4990ab.m7416i(C2521f.TAG, "user dismiss evaluate dialog");
            if (!C2521f.this.jcd) {
                C2521f.m4767b(C2521f.this);
            }
            C2521f.m4760P(this.val$runnable);
            AppMethodBeat.m2505o(134257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$8 */
    public class C25308 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(134260);
            C4990ab.m7416i(C2521f.TAG, "user clicked dialog close button");
            C2521f.this.jcd = false;
            C2521f.this.dismiss();
            AppMethodBeat.m2505o(134260);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$7 */
    public class C25317 implements OnRatingBarChangeListener {
        public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
            AppMethodBeat.m2504i(134259);
            C2521f.m4761a(C2521f.this, f);
            AppMethodBeat.m2505o(134259);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$10 */
    public class C253210 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(134262);
            C4990ab.m7416i(C2521f.TAG, "user clicked dialog inside");
            AppMethodBeat.m2505o(134262);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.f$6 */
    public class C25336 implements OnClickListener {
        final /* synthetic */ Context val$context;

        public C25336(Context context) {
            this.val$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134258);
            if (C2521f.this.jcg != null) {
                C2521f.m4762a(C2521f.this, (int) C2521f.this.jcg.getRating());
                Toast.makeText(this.val$context, this.val$context.getString(C25738R.string.f8891ie), 0).show();
                C2521f.this.jcd = true;
                C2521f.this.dismiss();
            }
            AppMethodBeat.m2505o(134258);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m4763a(C2521f c2521f, int i, int i2) {
        AppMethodBeat.m2504i(134273);
        c2521f.mo6483dp(i, i2);
        AppMethodBeat.m2505o(134273);
    }

    static {
        AppMethodBeat.m2504i(134274);
        AppMethodBeat.m2505o(134274);
    }

    /* renamed from: a */
    private void m4764a(cki cki) {
        AppMethodBeat.m2504i(134265);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 2521;
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/updateevaluate";
        c1196a.fsJ = cki;
        c1196a.fsK = new ckj();
        C42146b.m74301a(c1196a.acD(), new C252411());
        AppMethodBeat.m2505o(134265);
    }

    /* renamed from: qw */
    private void m4773qw(int i) {
        int i2 = C25738R.string.f8895ii;
        AppMethodBeat.m2504i(134266);
        switch (i) {
            case 2:
                i2 = C25738R.string.f8897ik;
                break;
            case 3:
                i2 = C25738R.string.f8896ij;
                break;
            case 4:
                i2 = C25738R.string.f8894ih;
                break;
            case 5:
                i2 = C25738R.string.f8893ig;
                break;
        }
        this.jch.setText(i2);
        AppMethodBeat.m2505o(134266);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(134267);
        if (this.dialog != null) {
            this.dialog.dismiss();
            this.dialog = null;
        }
        AppMethodBeat.m2505o(134267);
    }

    /* renamed from: dp */
    public final void mo6483dp(int i, int i2) {
        AppMethodBeat.m2504i(134268);
        if (C5046bo.isNullOrNil(this.appId)) {
            C4990ab.m7412e(TAG, "operateReport, no app id");
            AppMethodBeat.m2505o(134268);
            return;
        }
        C4990ab.m7417i(TAG, "operateReport, appId:%s, eventId:%s, session:%s, score:%s, scene:%s, result:%s, path:%s", this.appId, Integer.valueOf(i), this.cvF, Integer.valueOf(this.jce), Integer.valueOf(this.scene), Integer.valueOf(i2), this.csu);
        C7060h.pYm.mo8381e(16176, this.appId, Integer.valueOf(i), Long.valueOf(C5046bo.anT()), Integer.valueOf(this.jce), this.cvF, this.csu, Integer.valueOf(this.scene), Integer.valueOf(i2));
        AppMethodBeat.m2505o(134268);
    }

    /* renamed from: b */
    static /* synthetic */ void m4767b(C2521f c2521f) {
        AppMethodBeat.m2504i(134269);
        cki cki = new cki();
        cki.username = c2521f.userName;
        cki.xin = 4;
        C4990ab.m7417i(TAG, "reportSkipEvaluate, userName:%s", c2521f.userName);
        c2521f.m4764a(cki);
        AppMethodBeat.m2505o(134269);
    }

    /* renamed from: P */
    static /* synthetic */ void m4760P(Runnable runnable) {
        AppMethodBeat.m2504i(134270);
        if (runnable != null) {
            C5004al.m7442n(runnable, 100);
        }
        AppMethodBeat.m2505o(134270);
    }
}
