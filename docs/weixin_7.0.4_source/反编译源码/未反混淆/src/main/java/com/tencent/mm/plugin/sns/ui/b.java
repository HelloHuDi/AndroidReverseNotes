package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.v;

public final class b {
    boolean iXr = false;
    private Context mContext;
    private int qDY = -1;
    private com.tencent.mm.plugin.sns.ui.d.b qOL;
    private FrameLayout qOM;
    AbsoluteLayout qON = null;
    protected Animation qOO;
    protected Animation qOP;
    boolean qOQ = false;
    private com.tencent.mm.plugin.sns.g.b rfS;
    TextView rfT;
    ListView rfU;
    View rfV;

    class a {
        View qCZ = null;
        String qPg;

        public a(String str, View view) {
            this.qPg = str;
            this.qCZ = view;
        }
    }

    public b(Context context, com.tencent.mm.plugin.sns.ui.d.b bVar, FrameLayout frameLayout, com.tencent.mm.plugin.sns.g.b bVar2) {
        AppMethodBeat.i(38068);
        this.mContext = context;
        this.rfS = bVar2;
        this.qOL = bVar;
        this.qOM = frameLayout;
        this.qOO = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.qOO = AnimationUtils.loadAnimation(context, R.anim.al);
        this.qOP = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.qOP = AnimationUtils.loadAnimation(context, R.anim.am);
        AppMethodBeat.o(38068);
    }

    public final boolean dF(final View view) {
        int dC;
        AppMethodBeat.i(38069);
        if (af.cnx().coA() && this.rfS != null) {
            dC = this.rfS.dC(view);
            if (dC == 0 || dC == 1) {
                AppMethodBeat.o(38069);
                return true;
            }
            ab.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
        }
        if (this.qOQ) {
            AppMethodBeat.o(38069);
            return false;
        } else if (this.qON != null) {
            if (this.qON.getTag() instanceof a) {
                final View view2 = ((a) this.qON.getTag()).qCZ;
                this.qOQ = true;
                view2.startAnimation(this.qOP);
                this.qOP.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        b.this.qOQ = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(38066);
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            b.this.cox();
                        }
                        b.this.qOQ = false;
                        AppMethodBeat.o(38066);
                    }
                });
            } else {
                cox();
            }
            AppMethodBeat.o(38069);
            return false;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            AppMethodBeat.o(38069);
            return false;
        } else {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            String str = bVar.cwT;
            this.qON = new AbsoluteLayout(this.mContext);
            this.qON.setId(R.id.ee);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.qOM.addView(this.qON);
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 150.0f);
            int b2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 17.0f);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.mContext, 40.0f);
            final View inflate = v.hu(this.mContext).inflate(R.layout.at, null);
            TextView textView = (TextView) inflate.findViewById(R.id.me);
            String gw = aa.gw(ah.getContext());
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.qFH.rDm;
            if (bVar2 != null) {
                if ("zh_CN".equals(gw)) {
                    gw = bVar2.qUw;
                } else if ("zh_TW".equals(gw) || "zh_HK".equals(gw)) {
                    gw = bVar2.qUy;
                } else {
                    gw = bVar2.qUx;
                }
                if (!bo.isNullOrNil(gw)) {
                    textView.setText(gw);
                }
            }
            Rect rect = new Rect();
            int fD = f.fD(this.mContext);
            int[] cuI = bVar.qFH.cuI();
            ab.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + cuI[0] + "  " + cuI[1] + " height: " + fD);
            this.qDY = ae.hA(this.mContext);
            if (this.iXr) {
                dC = com.tencent.mm.bz.a.fromDPToPix(this.mContext, 2);
                this.qDY = 0;
            } else {
                dC = fD;
            }
            AbsoluteLayout.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(-2, -2, cuI[0] - b, ((cuI[1] - this.qDY) - dC) + b2);
            this.qON.setTag(new a(str, inflate));
            this.qON.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.qOQ = true;
            new ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(38065);
                    b.a(b.this, view, inflate);
                    AppMethodBeat.o(38065);
                }
            });
            AppMethodBeat.o(38069);
            return true;
        }
    }

    public final boolean cox() {
        AppMethodBeat.i(38070);
        if (this.rfS != null && af.cnx().coA()) {
            this.rfS.cox();
        }
        if (this.qON != null) {
            this.qOM.removeView(this.qON);
            this.qON = null;
            AppMethodBeat.o(38070);
            return true;
        }
        this.qOQ = false;
        this.rfU = null;
        this.rfV = null;
        AppMethodBeat.o(38070);
        return false;
    }

    public final boolean crv() {
        AppMethodBeat.i(38071);
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
        AnonymousClass4 anonymousClass4 = new Animation() {
            /* Access modifiers changed, original: protected|final */
            public final void applyTransformation(float f, Transformation transformation) {
                AppMethodBeat.i(38067);
                ((RelativeLayout.LayoutParams) b.this.rfU.getLayoutParams()).bottomMargin = f == 1.0f ? 0 : (int) (((float) (height - i)) * (1.0f - f));
                b.this.rfU.requestLayout();
                AppMethodBeat.o(38067);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        };
        anonymousClass4.setDuration(250);
        this.rfU.startAnimation(anonymousClass4);
        AppMethodBeat.o(38071);
        return true;
    }

    static /* synthetic */ void a(b bVar, View view, View view2) {
        boolean z;
        AppMethodBeat.i(38072);
        com.tencent.mm.plugin.sns.data.b bVar2 = (com.tencent.mm.plugin.sns.data.b) view.getTag();
        view2.setVisibility(0);
        bVar.qOQ = true;
        bVar.qOO.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                b.this.qOQ = true;
            }

            public final void onAnimationEnd(Animation animation) {
                b.this.qOQ = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(bVar.qOO);
        bVar.rfT = (TextView) view2.findViewById(R.id.mg);
        bVar.rfT.setTag(bVar2);
        if (bVar2.qFH == null || bVar2.qFH.rDm == null) {
            z = false;
        } else {
            com.tencent.mm.plugin.sns.storage.a aVar = bVar2.qFH.rDn;
            String gw = aa.gw(ah.getContext());
            if ("zh_CN".equals(gw)) {
                gw = aVar.qTQ;
            } else if ("zh_TW".equals(gw) || "zh_HK".equals(gw)) {
                gw = aVar.qTS;
            } else {
                gw = aVar.qTR;
            }
            if (!bo.isNullOrNil(gw)) {
                bVar.rfT.setText(gw);
            }
            z = aVar.qTT;
        }
        bVar.rfU = (ListView) view2.findViewById(R.id.mh);
        bVar.rfU.setAdapter(new c(bVar.mContext, (com.tencent.mm.plugin.sns.data.b) view.getTag()));
        if (z) {
            bVar.rfU.setClickable(false);
            bVar.rfU.setOnItemClickListener(null);
        } else {
            bVar.rfU.setClickable(true);
            bVar.rfU.setOnItemClickListener(bVar.qOL.rKj);
        }
        bVar.rfT.setClickable(false);
        bVar.rfV = view2;
        AppMethodBeat.o(38072);
    }
}
