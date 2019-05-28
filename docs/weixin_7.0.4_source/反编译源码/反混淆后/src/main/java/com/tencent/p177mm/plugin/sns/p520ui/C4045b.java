package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.sns.data.C34935b;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p516g.C31408b;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.sns.ui.b */
public final class C4045b {
    boolean iXr = false;
    private Context mContext;
    private int qDY = -1;
    private C22089b qOL;
    private FrameLayout qOM;
    AbsoluteLayout qON = null;
    protected Animation qOO;
    protected Animation qOP;
    boolean qOQ = false;
    private C31408b rfS;
    TextView rfT;
    ListView rfU;
    View rfV;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b$a */
    class C4048a {
        View qCZ = null;
        String qPg;

        public C4048a(String str, View view) {
            this.qPg = str;
            this.qCZ = view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b$2 */
    class C40492 implements AnimationListener {
        C40492() {
        }

        public final void onAnimationStart(Animation animation) {
            C4045b.this.qOQ = true;
        }

        public final void onAnimationEnd(Animation animation) {
            C4045b.this.qOQ = false;
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    public C4045b(Context context, C22089b c22089b, FrameLayout frameLayout, C31408b c31408b) {
        AppMethodBeat.m2504i(38068);
        this.mContext = context;
        this.rfS = c31408b;
        this.qOL = c22089b;
        this.qOM = frameLayout;
        this.qOO = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qOO = AnimationUtils.loadAnimation(context, C25738R.anim.f8316al);
        this.qOP = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.qOP = AnimationUtils.loadAnimation(context, C25738R.anim.f8317am);
        AppMethodBeat.m2505o(38068);
    }

    /* renamed from: dF */
    public final boolean mo8900dF(final View view) {
        int dC;
        AppMethodBeat.m2504i(38069);
        if (C13373af.cnx().coA() && this.rfS != null) {
            dC = this.rfS.mo51356dC(view);
            if (dC == 0 || dC == 1) {
                AppMethodBeat.m2505o(38069);
                return true;
            }
            C4990ab.m7416i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.qOQ) {
            AppMethodBeat.m2505o(38069);
            return false;
        } else if (this.qON != null) {
            if (this.qON.getTag() instanceof C4048a) {
                final View view2 = ((C4048a) this.qON.getTag()).qCZ;
                this.qOQ = true;
                view2.startAnimation(this.qOP);
                this.qOP.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        C4045b.this.qOQ = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.m2504i(38066);
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            C4045b.this.cox();
                        }
                        C4045b.this.qOQ = false;
                        AppMethodBeat.m2505o(38066);
                    }
                });
            } else {
                cox();
            }
            AppMethodBeat.m2505o(38069);
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof C34935b)) {
            AppMethodBeat.m2505o(38069);
            return false;
        } else {
            C34935b c34935b = (C34935b) view.getTag();
            String str = c34935b.cwT;
            this.qON = new AbsoluteLayout(this.mContext);
            this.qON.setId(2131820733);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.qOM.addView(this.qON);
            int b = C4977b.m7371b(this.mContext, 150.0f);
            int b2 = C4977b.m7371b(this.mContext, 17.0f);
            C4977b.m7371b(this.mContext, 40.0f);
            final View inflate = C5616v.m8409hu(this.mContext).inflate(2130968632, null);
            TextView textView = (TextView) inflate.findViewById(2131821029);
            String gw = C4988aa.m7403gw(C4996ah.getContext());
            C21984b c21984b = c34935b.qFH.rDm;
            if (c21984b != null) {
                if ("zh_CN".equals(gw)) {
                    gw = c21984b.qUw;
                } else if ("zh_TW".equals(gw) || "zh_HK".equals(gw)) {
                    gw = c21984b.qUy;
                } else {
                    gw = c21984b.qUx;
                }
                if (!C5046bo.isNullOrNil(gw)) {
                    textView.setText(gw);
                }
            }
            Rect rect = new Rect();
            int fD = C30036f.m47543fD(this.mContext);
            int[] cuI = c34935b.qFH.cuI();
            C4990ab.m7410d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + cuI[0] + "  " + cuI[1] + " height: " + fD);
            this.qDY = C5222ae.m7947hA(this.mContext);
            if (this.iXr) {
                dC = C1338a.fromDPToPix(this.mContext, 2);
                this.qDY = 0;
            } else {
                dC = fD;
            }
            AbsoluteLayout.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(-2, -2, cuI[0] - b, ((cuI[1] - this.qDY) - dC) + b2);
            this.qON.setTag(new C4048a(str, inflate));
            this.qON.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.qOQ = true;
            new C7306ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(38065);
                    C4045b.m6389a(C4045b.this, view, inflate);
                    AppMethodBeat.m2505o(38065);
                }
            });
            AppMethodBeat.m2505o(38069);
            return true;
        }
    }

    public final boolean cox() {
        AppMethodBeat.m2504i(38070);
        if (this.rfS != null && C13373af.cnx().coA()) {
            this.rfS.cox();
        }
        if (this.qON != null) {
            this.qOM.removeView(this.qON);
            this.qON = null;
            AppMethodBeat.m2505o(38070);
            return true;
        }
        this.qOQ = false;
        this.rfU = null;
        this.rfV = null;
        AppMethodBeat.m2505o(38070);
        return false;
    }

    public final boolean crv() {
        AppMethodBeat.m2504i(38071);
        final int height = this.rfT.getHeight();
        this.rfT.setVisibility(8);
        View view = null;
        int i = 0;
        for (int i2 = 0; i2 < this.rfU.getAdapter().getCount(); i2++) {
            view = this.rfU.getAdapter().getView(i2, view, null);
            view.measure(this.rfV.getWidth(), -2);
            i += view.getMeasuredHeight();
        }
        ((RelativeLayout.LayoutParams) this.rfU.getLayoutParams()).bottomMargin = height - i;
        this.rfU.setVisibility(0);
        C40504 c40504 = new Animation() {
            /* Access modifiers changed, original: protected|final */
            public final void applyTransformation(float f, Transformation transformation) {
                AppMethodBeat.m2504i(38067);
                ((RelativeLayout.LayoutParams) C4045b.this.rfU.getLayoutParams()).bottomMargin = f == 1.0f ? 0 : (int) (((float) (height - i)) * (1.0f - f));
                C4045b.this.rfU.requestLayout();
                AppMethodBeat.m2505o(38067);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        };
        c40504.setDuration(250);
        this.rfU.startAnimation(c40504);
        AppMethodBeat.m2505o(38071);
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m6389a(C4045b c4045b, View view, View view2) {
        boolean z;
        AppMethodBeat.m2504i(38072);
        C34935b c34935b = (C34935b) view.getTag();
        view2.setVisibility(0);
        c4045b.qOQ = true;
        c4045b.qOO.setAnimationListener(new C40492());
        view2.startAnimation(c4045b.qOO);
        c4045b.rfT = (TextView) view2.findViewById(2131821031);
        c4045b.rfT.setTag(c34935b);
        if (c34935b.qFH == null || c34935b.qFH.rDm == null) {
            z = false;
        } else {
            C21980a c21980a = c34935b.qFH.rDn;
            String gw = C4988aa.m7403gw(C4996ah.getContext());
            if ("zh_CN".equals(gw)) {
                gw = c21980a.qTQ;
            } else if ("zh_TW".equals(gw) || "zh_HK".equals(gw)) {
                gw = c21980a.qTS;
            } else {
                gw = c21980a.qTR;
            }
            if (!C5046bo.isNullOrNil(gw)) {
                c4045b.rfT.setText(gw);
            }
            z = c21980a.qTT;
        }
        c4045b.rfU = (ListView) view2.findViewById(2131821032);
        c4045b.rfU.setAdapter(new C35119c(c4045b.mContext, (C34935b) view.getTag()));
        if (z) {
            c4045b.rfU.setClickable(false);
            c4045b.rfU.setOnItemClickListener(null);
        } else {
            c4045b.rfU.setClickable(true);
            c4045b.rfU.setOnItemClickListener(c4045b.qOL.rKj);
        }
        c4045b.rfT.setClickable(false);
        c4045b.rfV = view2;
        AppMethodBeat.m2505o(38072);
    }
}
