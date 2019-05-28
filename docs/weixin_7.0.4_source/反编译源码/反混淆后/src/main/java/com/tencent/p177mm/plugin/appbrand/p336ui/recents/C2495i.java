package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C26778d;
import com.tencent.p177mm.plugin.appbrand.appusage.C42382q;
import com.tencent.p177mm.plugin.appbrand.appusage.C42382q.C19113b;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandNearbyEmptyUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.widget.C10929a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.model.C10721l;
import com.tencent.p177mm.plugin.appbrand.report.model.C10721l.C10720b;
import com.tencent.p177mm.plugin.appbrand.report.model.C10721l.C10722a;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.protocal.protobuf.are;
import com.tencent.p177mm.protocal.protobuf.bdt;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.i */
final class C2495i extends C27336a implements OnClickListener, C19113b {
    View apJ;
    private Activity czX;
    private C37932f eoo;
    private final int eop;
    private final int eoq;
    private final int eor;
    private final int eos = -1;
    private ImageView iMf;
    private ThreeDotsLoadingView iNB;
    private View iOd;
    private C2498a iOi = C2498a.DISPLAY_NONE;
    private final int iOj;
    private TextView iOk;
    private AppBrandNearbyShowcaseView iOl;
    private View iOm;
    private ImageView iOn;
    private boolean iOo = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.i$4 */
    class C24964 implements Runnable {
        C24964() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133448);
            C2495i.m4722b(C2495i.this);
            if (C2495i.this.iOo) {
                C2495i.this.iOm.performClick();
                C2495i.this.iOo = false;
            }
            AppMethodBeat.m2505o(133448);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.i$5 */
    class C24975 implements Runnable {
        C24975() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(133449);
            if (C2495i.this.czX == null) {
                AppMethodBeat.m2505o(133449);
                return;
            }
            are axq = C42382q.axq();
            if (axq != null) {
                C10722a c10722a;
                int i2 = axq.wvf == 1 ? 1 : 0;
                if (i2 != 0) {
                    bdt bdt = axq.wvg;
                    if (bdt == null) {
                        C4990ab.m7412e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram but invalid appInfo, just return");
                        AppMethodBeat.m2505o(133449);
                        return;
                    }
                    if (C4872b.dnO()) {
                        i = bdt.type;
                    }
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1001;
                    C10600f.ijT.mo33003a(C2495i.this.czX, bdt.username, null, bdt.path, i, bdt.vOP, appBrandStatObject, null, null);
                } else if (C5046bo.isNullOrNil(axq.wuU)) {
                    C4990ab.m7412e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram false, url empty, just return");
                    AppMethodBeat.m2505o(133449);
                    return;
                } else {
                    ((C42401a) C1720g.m3528K(C42401a.class)).mo21551T(C2495i.this.czX, axq.wuU);
                }
                C2495i.m4730g(C2495i.this);
                C10721l c10721l = new C10721l();
                c10721l.iBL = C10720b.TOP_ENTRANCE_IN_DESKTOP;
                c10721l.iBM = axq.jsN;
                c10721l.iBN = axq.wuS;
                if (i2 != 0) {
                    c10722a = C10722a.NEARBY_MINI_PROGRAM;
                } else {
                    c10722a = C10722a.NEARBY_H5;
                }
                c10721l.iBP = c10722a;
                c10721l.mo22274IF();
            }
            AppMethodBeat.m2505o(133449);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.i$a */
    enum C2498a {
        LOAD_ERR,
        DISPLAY_LIST,
        DISPLAY_NONE,
        LOADING,
        LBS_NOT_ALLOWED;

        static {
            AppMethodBeat.m2505o(133452);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.i$2 */
    class C25002 implements Runnable {
        C25002() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133446);
            C2495i.m4722b(C2495i.this);
            AppMethodBeat.m2505o(133446);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m4722b(C2495i c2495i) {
        AppMethodBeat.m2504i(133468);
        c2495i.aNu();
        AppMethodBeat.m2505o(133468);
    }

    /* renamed from: g */
    static /* synthetic */ void m4730g(C2495i c2495i) {
        AppMethodBeat.m2504i(133469);
        c2495i.aNv();
        AppMethodBeat.m2505o(133469);
    }

    /* renamed from: eH */
    public final void mo6421eH(final boolean z) {
        AppMethodBeat.m2504i(133453);
        this.iOd.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(133445);
                if (z) {
                    C2495i.this.iOd.setVisibility(0);
                    AppMethodBeat.m2505o(133445);
                    return;
                }
                C2495i.this.iOd.setVisibility(8);
                AppMethodBeat.m2505o(133445);
            }
        });
        AppMethodBeat.m2505o(133453);
    }

    C2495i(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133454);
        this.czX = activity;
        this.eop = C1338a.fromDPToPix(activity, 25);
        this.eoq = C1338a.fromDPToPix(activity, 19);
        this.eor = C1338a.fromDPToPix(activity, 2);
        this.apJ = LayoutInflater.from(activity).inflate(2130968716, viewGroup, false);
        View findViewById = this.apJ.findViewById(2131821333);
        this.iOm = findViewById;
        findViewById.setOnClickListener(this);
        this.iOd = this.apJ.findViewById(2131821329);
        this.iOk = (TextView) this.apJ.findViewById(2131821331);
        this.iOl = (AppBrandNearbyShowcaseView) this.apJ.findViewById(2131821330);
        this.iOl.setIconLayerCount(4);
        this.iOl.setIconSize(this.eop + (this.eor * 2));
        this.iOl.setIconGap(this.eoq);
        this.iMf = (ImageView) this.apJ.findViewById(2131821332);
        this.iNB = (ThreeDotsLoadingView) this.apJ.findViewById(2131821334);
        this.iOn = (ImageView) this.apJ.findViewById(2131821335);
        this.iOj = C1338a.m2872i(activity, C25738R.color.f12082ro);
        if (!C35805b.m58714o(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.iOi = C2498a.LBS_NOT_ALLOWED;
        }
        AppMethodBeat.m2505o(133454);
    }

    public final View aNi() {
        return this.apJ;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(133455);
        if (C2498a.LBS_NOT_ALLOWED == this.iOi && C35805b.m58714o(this.czX, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.iOi = C2498a.DISPLAY_NONE;
            aNh();
        }
        AppMethodBeat.m2505o(133455);
    }

    public final void aNh() {
        AppMethodBeat.m2504i(133456);
        mo45020eG(C42382q.axm());
        if (C2498a.LBS_NOT_ALLOWED == this.iOi) {
            aNu();
            AppMethodBeat.m2505o(133456);
            return;
        }
        C42382q.m74992a((C19113b) this);
        if (!C42382q.axr()) {
            this.apJ.post(new C25002());
            AppMethodBeat.m2505o(133456);
        } else if (C42382q.refresh()) {
            aNt();
            AppMethodBeat.m2505o(133456);
        } else {
            mo45020eG(false);
            AppMethodBeat.m2505o(133456);
        }
    }

    public final void onDetached() {
        AppMethodBeat.m2504i(133457);
        C42382q.m74994b(this);
        this.czX = null;
        this.apJ = null;
        this.iOl = null;
        this.iOd = null;
        AppMethodBeat.m2505o(133457);
    }

    /* renamed from: pS */
    public final void mo6437pS(int i) {
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(133458);
        if (this.iMf != null) {
            this.iMf.setVisibility(i);
            ViewParent parent = this.iOd.getParent();
            if (parent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) parent;
                layoutParams = (LayoutParams) frameLayout.getLayoutParams();
                layoutParams.rightMargin = this.czX.getResources().getDimensionPixelOffset(C25738R.dimen.f10178td);
                frameLayout.setLayoutParams(layoutParams);
            }
        }
        TextView textView = (TextView) this.apJ.findViewById(2131820678);
        layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.czX.getResources().getDimensionPixelOffset(C25738R.dimen.f10153ro);
        textView.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(133458);
    }

    /* renamed from: pT */
    public final void mo6438pT(int i) {
        AppMethodBeat.m2504i(133459);
        this.iOm.setBackgroundResource(i);
        AppMethodBeat.m2505o(133459);
    }

    private void aNt() {
        AppMethodBeat.m2504i(133460);
        this.iOi = C2498a.LOADING;
        m4725cw(this.iOd);
        m4725cw(this.iOn);
        C2495i.m4726cx(this.iNB);
        this.iNB.dKS();
        AppMethodBeat.m2505o(133460);
    }

    private void aNu() {
        boolean z = true;
        int i = 0;
        AppMethodBeat.m2504i(133461);
        if (this.apJ == null) {
            AppMethodBeat.m2505o(133461);
            return;
        }
        C26778d c26778d;
        if (C42382q.axm()) {
            mo45020eG(true);
            c26778d = ((AppBrandLauncherUI) this.czX).iGM;
            if (c26778d != null) {
                c26778d.axA();
            }
        } else {
            mo45020eG(false);
        }
        this.iNB.dKT();
        m4725cw(this.iNB);
        if (C2498a.LBS_NOT_ALLOWED == this.iOi) {
            m4725cw(this.iOd);
            m4725cw(this.iOn);
            AppMethodBeat.m2505o(133461);
            return;
        }
        are axq = C42382q.axq();
        if (axq == null) {
            this.iOi = C2498a.LOAD_ERR;
            m4725cw(this.iOd);
            C2495i.m4726cx(this.iOn);
            AppMethodBeat.m2505o(133461);
        } else if (axq.jsN <= 0 || C5046bo.m7548ek(axq.wuW)) {
            this.iOi = C2498a.DISPLAY_NONE;
            m4725cw(this.iOd);
            AppMethodBeat.m2505o(133461);
        } else {
            this.iOi = C2498a.DISPLAY_LIST;
            c26778d = ((AppBrandLauncherUI) this.czX).iGM;
            if (c26778d != null) {
                c26778d.axz();
            }
            if (this.iOk != null) {
                this.iOk.setText(axq.wvc);
                this.iOk.setTextColor(C2495i.m4723bx(axq.wvd, this.iOj));
            }
            this.iOl.setIconLayerCount(Math.min(axq.wuW.size(), 4));
            if (this.iOd.getVisibility() == 0) {
                z = false;
            }
            if (z) {
                this.iOl.mo54070eO(false);
            }
            if (this.eoo == null) {
                this.eoo = new C10929a(this.eop, this.eor);
            }
            while (i < this.iOl.getChildCount()) {
                C37926b.abR().mo60683a(this.iOl.mo54072qf(i), ((bdt) axq.wuW.get(i)).wHu, C32804a.abQ(), this.eoo);
                i++;
            }
            C2495i.m4726cx(this.iOd);
            m4725cw(this.iNB);
            m4725cw(this.iOn);
            if (z) {
                if (this.iOl != null) {
                    this.iOl.aOB();
                }
                if (this.iOk != null) {
                    this.iOk.setAlpha(0.0f);
                    this.iOk.animate().alpha(1.0f).setDuration(500).start();
                }
            }
            AppMethodBeat.m2505o(133461);
        }
    }

    /* renamed from: bx */
    private static int m4723bx(String str, int i) {
        AppMethodBeat.m2504i(133462);
        try {
            i = Color.parseColor(str);
            AppMethodBeat.m2505o(133462);
        } catch (Exception e) {
            AppMethodBeat.m2505o(133462);
        }
        return i;
    }

    /* renamed from: cw */
    private void m4725cw(final View view) {
        AppMethodBeat.m2504i(133463);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133447);
                    view.setVisibility(8);
                    AppMethodBeat.m2505o(133447);
                }
            }).start();
        }
        AppMethodBeat.m2505o(133463);
    }

    /* renamed from: cx */
    private static void m4726cx(View view) {
        AppMethodBeat.m2504i(133464);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
        AppMethodBeat.m2505o(133464);
    }

    public final void axs() {
        AppMethodBeat.m2504i(133465);
        if (this.apJ != null) {
            this.apJ.post(new C24964());
        }
        AppMethodBeat.m2505o(133465);
    }

    public final void onClick(View view) {
        int i = 0;
        AppMethodBeat.m2504i(133466);
        if (view.getId() == 2131821333) {
            if (this.czX == null) {
                AppMethodBeat.m2505o(133466);
                return;
            } else if (C2498a.LOADING == this.iOi) {
                AppMethodBeat.m2505o(133466);
                return;
            } else if (C2498a.DISPLAY_NONE == this.iOi) {
                aNv();
                this.czX.startActivityForResult(new Intent(this.czX, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 0), 3);
                AppMethodBeat.m2505o(133466);
                return;
            } else if (C2498a.LBS_NOT_ALLOWED == this.iOi) {
                aNv();
                this.czX.startActivityForResult(new Intent(this.czX, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
                AppMethodBeat.m2505o(133466);
                return;
            } else {
                boolean z = C42382q.axq() != null && C42382q.axr();
                this.iOo = z;
                if (C2498a.LOAD_ERR == this.iOi || this.iOo) {
                    i = 1;
                }
                C24975 c24975 = new C24975();
                if (i != 0) {
                    aNt();
                    C42382q.refresh();
                    AppMethodBeat.m2505o(133466);
                    return;
                }
                c24975.run();
                if (!(C42382q.axq() == null || C42382q.axq().wve != 1 || this.iOk == null)) {
                    this.iOk.animate().alpha(0.0f).setDuration(200);
                }
            }
        }
        AppMethodBeat.m2505o(133466);
    }

    private void aNv() {
        AppMethodBeat.m2504i(133467);
        if (this.czX == null) {
            AppMethodBeat.m2505o(133467);
            return;
        }
        C26778d c26778d = ((AppBrandLauncherUI) this.czX).iGM;
        if (c26778d != null) {
            c26778d.axB();
        }
        AppMethodBeat.m2505o(133467);
    }
}
