package com.tencent.mm.plugin.appbrand.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;

public class AppBrandLoadIconPreference extends Preference {
    private String emo;
    private f eoo;
    private int eop;
    private int eoq;
    private int eor;
    private final int eos = -1;
    private int eot = -1;
    private ThreeDotsLoadingView iDW;
    private AppBrandNearbyShowcaseView iMd;
    private View iQN;
    private boolean iQO = false;
    private LinkedList<e> iQP = new LinkedList();
    private Context mContext;
    private View mView = null;

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(93760);
        bA(context);
        AppMethodBeat.o(93760);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(93761);
        bA(context);
        AppMethodBeat.o(93761);
    }

    private void bA(Context context) {
        AppMethodBeat.i(93762);
        setLayoutResource(R.layout.ae4);
        this.mContext = context;
        AppMethodBeat.o(93762);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(93763);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.ee, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(93763);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(93764);
        super.onBindView(view);
        this.eop = a.fromDPToPix(this.mContext, 21);
        this.eoq = a.fromDPToPix(this.mContext, 11);
        this.eor = a.fromDPToPix(this.mContext, 2);
        this.iQN = view.findViewById(R.id.ym);
        this.iDW = (ThreeDotsLoadingView) view.findViewById(R.id.w7);
        this.iMd = (AppBrandNearbyShowcaseView) view.findViewById(R.id.yn);
        this.iMd.setIconSize(this.eop + (this.eor * 2));
        this.iMd.setIconGap(this.eoq);
        if (this.emo == null || this.iDW == null) {
            ab.i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
            AppMethodBeat.o(93764);
        } else if (this.iQO) {
            ab.i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
            AppMethodBeat.o(93764);
        } else {
            this.iQO = true;
            cw(this.iQN);
            c(this.iDW, null);
            this.iDW.dKS();
            g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(93756);
                    AppBrandLoadIconPreference.a(AppBrandLoadIconPreference.this);
                    AppMethodBeat.o(93756);
                }
            });
            AppMethodBeat.o(93764);
        }
    }

    private static void c(View view, Runnable runnable) {
        AppMethodBeat.i(93765);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
        AppMethodBeat.o(93765);
    }

    private void cw(final View view) {
        AppMethodBeat.i(93766);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(93759);
                    view.setVisibility(8);
                    AppMethodBeat.o(93759);
                }
            }).start();
        }
        AppMethodBeat.o(93766);
    }

    static /* synthetic */ void a(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        AppMethodBeat.i(93767);
        c.reset();
        c.a(appBrandLoadIconPreference.emo, new c.a() {
            public final void z(LinkedList<e> linkedList) {
                AppMethodBeat.i(93757);
                AppBrandLoadIconPreference.this.iQP = linkedList;
                AppBrandLoadIconPreference.b(AppBrandLoadIconPreference.this);
                AppMethodBeat.o(93757);
            }
        });
        AppMethodBeat.o(93767);
    }

    static /* synthetic */ void b(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        int i = 0;
        AppMethodBeat.i(93768);
        appBrandLoadIconPreference.iDW.dKT();
        appBrandLoadIconPreference.cw(appBrandLoadIconPreference.iDW);
        if (appBrandLoadIconPreference.iQP.size() > 0) {
            appBrandLoadIconPreference.iMd.setVisibility(0);
            appBrandLoadIconPreference.iMd.setIconLayerCount(Math.min(appBrandLoadIconPreference.iQP.size(), 3));
            final boolean z = appBrandLoadIconPreference.iQN.getVisibility() != 0;
            if (z) {
                appBrandLoadIconPreference.iMd.eO(false);
            }
            if (appBrandLoadIconPreference.eoo == null) {
                appBrandLoadIconPreference.eoo = new a(appBrandLoadIconPreference.eop, appBrandLoadIconPreference.eor);
            }
            while (true) {
                int i2 = i;
                if (i2 < appBrandLoadIconPreference.iMd.getChildCount()) {
                    b.abR().a(appBrandLoadIconPreference.iMd.qf(i2), appBrandLoadIconPreference.iQP.size() > i2 ? ((e) appBrandLoadIconPreference.iQP.get(i2)).imagePath : null, com.tencent.mm.modelappbrand.a.a.abQ(), appBrandLoadIconPreference.eoo);
                    i = i2 + 1;
                } else {
                    c(appBrandLoadIconPreference.iQN, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(93758);
                            if (z && AppBrandLoadIconPreference.this.iMd != null) {
                                AppBrandLoadIconPreference.this.iMd.aOB();
                            }
                            AppMethodBeat.o(93758);
                        }
                    });
                    AppMethodBeat.o(93768);
                    return;
                }
            }
        }
        appBrandLoadIconPreference.iMd.setVisibility(8);
        AppMethodBeat.o(93768);
    }
}
