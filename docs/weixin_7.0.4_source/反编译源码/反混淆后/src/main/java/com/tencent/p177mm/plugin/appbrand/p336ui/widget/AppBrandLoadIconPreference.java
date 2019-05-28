package com.tencent.p177mm.plugin.appbrand.p336ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.p328r.C38494e;
import com.tencent.p177mm.plugin.appbrand.p328r.C42666c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42666c.C38493a;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference */
public class AppBrandLoadIconPreference extends Preference {
    private String emo;
    private C37932f eoo;
    private int eop;
    private int eoq;
    private int eor;
    private final int eos = -1;
    private int eot = -1;
    private ThreeDotsLoadingView iDW;
    private AppBrandNearbyShowcaseView iMd;
    private View iQN;
    private boolean iQO = false;
    private LinkedList<C38494e> iQP = new LinkedList();
    private Context mContext;
    private View mView = null;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference$1 */
    class C109251 implements Runnable {
        C109251() {
        }

        public final void run() {
            AppMethodBeat.m2504i(93756);
            AppBrandLoadIconPreference.m18652a(AppBrandLoadIconPreference.this);
            AppMethodBeat.m2505o(93756);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.widget.AppBrandLoadIconPreference$2 */
    class C109262 implements C38493a {
        C109262() {
        }

        /* renamed from: z */
        public final void mo22471z(LinkedList<C38494e> linkedList) {
            AppMethodBeat.m2504i(93757);
            AppBrandLoadIconPreference.this.iQP = linkedList;
            AppBrandLoadIconPreference.m18653b(AppBrandLoadIconPreference.this);
            AppMethodBeat.m2505o(93757);
        }
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(93760);
        m18654bA(context);
        AppMethodBeat.m2505o(93760);
    }

    public AppBrandLoadIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(93761);
        m18654bA(context);
        AppMethodBeat.m2505o(93761);
    }

    /* renamed from: bA */
    private void m18654bA(Context context) {
        AppMethodBeat.m2504i(93762);
        setLayoutResource(2130970127);
        this.mContext = context;
        AppMethodBeat.m2505o(93762);
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(93763);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, 2130968765, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.m2505o(93763);
        return view;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(93764);
        super.onBindView(view);
        this.eop = C1338a.fromDPToPix(this.mContext, 21);
        this.eoq = C1338a.fromDPToPix(this.mContext, 11);
        this.eor = C1338a.fromDPToPix(this.mContext, 2);
        this.iQN = view.findViewById(2131821481);
        this.iDW = (ThreeDotsLoadingView) view.findViewById(2131821391);
        this.iMd = (AppBrandNearbyShowcaseView) view.findViewById(2131821482);
        this.iMd.setIconSize(this.eop + (this.eor * 2));
        this.iMd.setIconGap(this.eoq);
        if (this.emo == null || this.iDW == null) {
            C4990ab.m7416i("MicroMsg.AppBrandLoadIconPreference", "startLoad mTalker or mLoadingView is null");
            AppMethodBeat.m2505o(93764);
        } else if (this.iQO) {
            C4990ab.m7416i("MicroMsg.AppBrandLoadIconPreference", "startLoad has load.");
            AppMethodBeat.m2505o(93764);
        } else {
            this.iQO = true;
            m18657cw(this.iQN);
            AppBrandLoadIconPreference.m18656c(this.iDW, null);
            this.iDW.dKS();
            C1720g.m3539RS().mo10302aa(new C109251());
            AppMethodBeat.m2505o(93764);
        }
    }

    /* renamed from: c */
    private static void m18656c(View view, Runnable runnable) {
        AppMethodBeat.m2504i(93765);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
        AppMethodBeat.m2505o(93765);
    }

    /* renamed from: cw */
    private void m18657cw(final View view) {
        AppMethodBeat.m2504i(93766);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(93759);
                    view.setVisibility(8);
                    AppMethodBeat.m2505o(93759);
                }
            }).start();
        }
        AppMethodBeat.m2505o(93766);
    }

    /* renamed from: a */
    static /* synthetic */ void m18652a(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        AppMethodBeat.m2504i(93767);
        C42666c.reset();
        C42666c.m75549a(appBrandLoadIconPreference.emo, new C109262());
        AppMethodBeat.m2505o(93767);
    }

    /* renamed from: b */
    static /* synthetic */ void m18653b(AppBrandLoadIconPreference appBrandLoadIconPreference) {
        int i = 0;
        AppMethodBeat.m2504i(93768);
        appBrandLoadIconPreference.iDW.dKT();
        appBrandLoadIconPreference.m18657cw(appBrandLoadIconPreference.iDW);
        if (appBrandLoadIconPreference.iQP.size() > 0) {
            appBrandLoadIconPreference.iMd.setVisibility(0);
            appBrandLoadIconPreference.iMd.setIconLayerCount(Math.min(appBrandLoadIconPreference.iQP.size(), 3));
            final boolean z = appBrandLoadIconPreference.iQN.getVisibility() != 0;
            if (z) {
                appBrandLoadIconPreference.iMd.mo54070eO(false);
            }
            if (appBrandLoadIconPreference.eoo == null) {
                appBrandLoadIconPreference.eoo = new C10929a(appBrandLoadIconPreference.eop, appBrandLoadIconPreference.eor);
            }
            while (true) {
                int i2 = i;
                if (i2 < appBrandLoadIconPreference.iMd.getChildCount()) {
                    C37926b.abR().mo60683a(appBrandLoadIconPreference.iMd.mo54072qf(i2), appBrandLoadIconPreference.iQP.size() > i2 ? ((C38494e) appBrandLoadIconPreference.iQP.get(i2)).imagePath : null, C32804a.abQ(), appBrandLoadIconPreference.eoo);
                    i = i2 + 1;
                } else {
                    AppBrandLoadIconPreference.m18656c(appBrandLoadIconPreference.iQN, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(93758);
                            if (z && AppBrandLoadIconPreference.this.iMd != null) {
                                AppBrandLoadIconPreference.this.iMd.aOB();
                            }
                            AppMethodBeat.m2505o(93758);
                        }
                    });
                    AppMethodBeat.m2505o(93768);
                    return;
                }
            }
        }
        appBrandLoadIconPreference.iMd.setVisibility(8);
        AppMethodBeat.m2505o(93768);
    }
}
