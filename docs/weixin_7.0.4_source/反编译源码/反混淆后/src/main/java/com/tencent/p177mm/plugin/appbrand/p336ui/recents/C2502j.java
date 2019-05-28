package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.appusage.C19109l;
import com.tencent.p177mm.plugin.appbrand.appusage.C19109l.C10128c;
import com.tencent.p177mm.plugin.appbrand.appusage.C19109l.C19110b;
import com.tencent.p177mm.plugin.appbrand.compat.p887a.C42401a;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C2489h.C2491b;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C2489h.C2494c;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.protocal.protobuf.ari;
import com.tencent.p177mm.protocal.protobuf.cxi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.j */
final class C2502j extends C27336a implements C19110b, C2491b {
    Activity gNy;
    private OnClickListener iOA = null;
    private C2505a iOx = new C2505a();
    C2489h iOy;
    private boolean iOz = false;
    volatile boolean mFinished = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.j$a */
    static class C2505a {
        String iOE;
        Integer iOF;
        List<String> iOG;

        private C2505a() {
        }

        /* synthetic */ C2505a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.j$1 */
    class C25061 implements Runnable {
        C25061() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133470);
            if (C2502j.this.mFinished || C2502j.this.iOy.iNR.apJ == null) {
                AppMethodBeat.m2505o(133470);
                return;
            }
            C2502j.m4735a(C2502j.this);
            AppMethodBeat.m2505o(133470);
        }
    }

    /* renamed from: eH */
    public final void mo6421eH(boolean z) {
    }

    C2502j(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133473);
        this.iOy = new C2489h(viewGroup);
        this.iOy.iNP = this;
        this.gNy = activity;
        AppMethodBeat.m2505o(133473);
    }

    public final void aNh() {
        AppMethodBeat.m2504i(133474);
        C19109l axj = C19109l.axj();
        mo45020eG(C19109l.enabled());
        if (C19109l.enabled()) {
            synchronized (axj.mLock) {
                try {
                    axj.gZl.add(this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133474);
                }
            }
            axj.refresh();
            this.iOy.aNt();
            this.mFinished = false;
            return;
        }
        AppMethodBeat.m2505o(133474);
    }

    public final void onDetached() {
        AppMethodBeat.m2504i(133475);
        this.mFinished = true;
        C19109l axj = C19109l.axj();
        synchronized (axj.mLock) {
            try {
                axj.gZl.remove(this);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(133475);
            }
        }
    }

    public final void onResume() {
    }

    public final void axk() {
        AppMethodBeat.m2504i(133476);
        C4990ab.m7416i("MicroMsg.AppBrandListRecentsListWAGameHeader", "AppBrandListRecentsListWAGameHeader.onWAGameDataUpdate");
        C19109l.axj();
        if (!C19109l.enabled()) {
            AppMethodBeat.m2505o(133476);
        } else if (this.mFinished) {
            AppMethodBeat.m2505o(133476);
        } else {
            View view = this.iOy.iNR.apJ;
            if (view == null) {
                AppMethodBeat.m2505o(133476);
                return;
            }
            view.post(new C25061());
            AppMethodBeat.m2505o(133476);
        }
    }

    /* renamed from: Ea */
    private static Integer m4734Ea(String str) {
        AppMethodBeat.m2504i(133477);
        try {
            Integer valueOf = Integer.valueOf(Color.parseColor(str));
            AppMethodBeat.m2505o(133477);
            return valueOf;
        } catch (Exception e) {
            AppMethodBeat.m2505o(133477);
            return null;
        }
    }

    public final View aNi() {
        return this.iOy.iNR.apJ;
    }

    /* renamed from: a */
    public final void mo6429a(C2494c c2494c, View view) {
        AppMethodBeat.m2504i(133478);
        if (c2494c == null || c2494c == C2494c.LOADING || c2494c == C2494c.NONE) {
            C4990ab.m7418v("MicroMsg.AppBrandListRecentsListWAGameHeader", "onClick ");
            AppMethodBeat.m2505o(133478);
        } else if (c2494c == C2494c.LOADING_ERROR) {
            this.iOy.aNt();
            C19109l.axj().refresh();
            AppMethodBeat.m2505o(133478);
        } else {
            if (c2494c == C2494c.LOADING_SUCCESS && this.iOA != null) {
                this.iOA.onClick(view);
                if (this.iOz) {
                    C2489h c2489h = this.iOy;
                    if (c2489h.iNR.iOf != null) {
                        c2489h.iNR.iOf.animate().alpha(0.0f).setDuration(200).start();
                    }
                }
            }
            AppMethodBeat.m2505o(133478);
        }
    }

    /* renamed from: pS */
    public final void mo6437pS(int i) {
        AppMethodBeat.m2504i(133479);
        if (this.iOy != null) {
            C2489h c2489h = this.iOy;
            if (!(c2489h.iNR == null || c2489h.iNR.iOh == null)) {
                c2489h.iNR.iOh.setVisibility(i);
            }
        }
        AppMethodBeat.m2505o(133479);
    }

    /* renamed from: pT */
    public final void mo6438pT(int i) {
        AppMethodBeat.m2504i(133480);
        C2489h c2489h = this.iOy;
        if (!(c2489h.iNR == null || c2489h.iNR.apJ == null)) {
            c2489h.iNR.apJ.setBackgroundResource(i);
        }
        AppMethodBeat.m2505o(133480);
    }

    /* renamed from: a */
    static /* synthetic */ void m4735a(C2502j c2502j) {
        boolean z = false;
        AppMethodBeat.m2504i(133481);
        ari ari = C19109l.axj().gZm;
        if (ari == null) {
            C2489h c2489h = c2502j.iOy;
            C4990ab.m7416i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingFailed");
            c2489h.iNQ = C2494c.LOADING_ERROR;
            c2489h.iNR.iNB.dKT();
            c2489h.mo6427cw(c2489h.iNR.iNB);
            c2489h.mo6427cw(c2489h.iNR.iOd);
            C2489h.m4717cx(c2489h.iNR.iOg);
            AppMethodBeat.m2505o(133481);
            return;
        }
        if (ari != null && (ari.wvn == 1 || ari.wvn == 2)) {
            C10128c nz = C10128c.m17740nz(ari.wvn);
            String str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
            String str2 = "Use Game Entry %s";
            Object[] objArr = new Object[1];
            objArr[0] = nz == null ? BuildConfig.COMMAND : nz.name();
            C4990ab.m7417i(str, str2, objArr);
            if (nz == C10128c.H5) {
                final String str3 = ari.wvm;
                if (C5046bo.isNullOrNil(str3)) {
                    String str4 = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str = "makeH5ClickListener failed. link_wxagame = [%s]";
                    Object[] objArr2 = new Object[1];
                    if (str3 == null) {
                        str3 = BuildConfig.COMMAND;
                    }
                    objArr2[0] = str3;
                    C4990ab.m7413e(str4, str, objArr2);
                } else {
                    C4990ab.m7417i("MicroMsg.AppBrandListRecentsListWAGameHeader", "H5 link is [%s]", str3);
                    if (C5046bo.isNullOrNil(str3)) {
                        c2502j.iOA = null;
                    } else {
                        c2502j.iOA = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(133471);
                                C4990ab.m7416i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke H5 click listener, invoke h5");
                                ((C42401a) C1720g.m3528K(C42401a.class)).mo21552U(C2502j.this.gNy, str3);
                                AppMethodBeat.m2505o(133471);
                            }
                        };
                    }
                }
            } else if (nz == C10128c.WXAPP) {
                final cxi cxi = ari.wvl;
                if (cxi == null) {
                    C4990ab.m7412e("MicroMsg.AppBrandListRecentsListWAGameHeader", "makeWxAppClickListener failed. wxaInfo = null.");
                } else {
                    str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str2 = "WxApp link is [%s]";
                    objArr = new Object[1];
                    objArr[0] = cxi.path == null ? BuildConfig.COMMAND : cxi.path;
                    C4990ab.m7417i(str, str2, objArr);
                    new AppBrandStatObject().scene = 1001;
                    c2502j.iOA = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(133472);
                            C4990ab.m7416i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke WxApp click listener, invoke wxapp");
                            AppBrandLaunchProxyUI.m25693a(C2502j.this.gNy, cxi.username, cxi.path, 0, cxi.vOP, new AppBrandStatObject(), null, null);
                            AppMethodBeat.m2505o(133472);
                        }
                    };
                }
            }
        } else if (ari == null) {
            C4990ab.m7412e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is null");
        } else {
            C4990ab.m7413e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is not null, but action_code is %d", Integer.valueOf(ari.wvn));
        }
        if (ari == null) {
            C4990ab.m7412e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo GetWxaGameResponse");
        } else {
            C4990ab.m7417i("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo entry = [%s] ec = [%s] new = [%s] nc = [%s]", ari.wvp, ari.wvq, ari.wvo, ari.wvr);
            c2502j.iOx.iOE = C5046bo.m7532bc(ari.wvo, "");
            c2502j.iOx.iOF = C2502j.m4734Ea(ari.wvr);
            c2502j.iOx.iOG = new ArrayList(Math.max(ari.wvk == null ? 0 : ari.wvk.size(), 0));
            if (ari.wvk != null && ari.wvk.size() > 0) {
                Iterator it = ari.wvk.iterator();
                while (it.hasNext()) {
                    cxi cxi2 = (cxi) it.next();
                    if (cxi2 != null) {
                        c2502j.iOx.iOG.add(cxi2.wHu);
                    }
                }
            }
        }
        if (ari.wve == 1) {
            z = true;
        }
        c2502j.iOz = z;
        c2502j.iOy.mo6425a(c2502j.iOx.iOG, c2502j.iOx.iOE, c2502j.iOx.iOF);
        AppMethodBeat.m2505o(133481);
    }
}
