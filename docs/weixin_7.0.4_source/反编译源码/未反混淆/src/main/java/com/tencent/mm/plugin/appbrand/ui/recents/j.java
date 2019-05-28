package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.l.b;
import com.tencent.mm.plugin.appbrand.appusage.l.c;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class j extends a implements b, b {
    Activity gNy;
    private OnClickListener iOA = null;
    private a iOx = new a();
    h iOy;
    private boolean iOz = false;
    volatile boolean mFinished = false;

    static class a {
        String iOE;
        Integer iOF;
        List<String> iOG;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void eH(boolean z) {
    }

    j(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(133473);
        this.iOy = new h(viewGroup);
        this.iOy.iNP = this;
        this.gNy = activity;
        AppMethodBeat.o(133473);
    }

    public final void aNh() {
        AppMethodBeat.i(133474);
        l axj = l.axj();
        eG(l.enabled());
        if (l.enabled()) {
            synchronized (axj.mLock) {
                try {
                    axj.gZl.add(this);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133474);
                }
            }
            axj.refresh();
            this.iOy.aNt();
            this.mFinished = false;
            return;
        }
        AppMethodBeat.o(133474);
    }

    public final void onDetached() {
        AppMethodBeat.i(133475);
        this.mFinished = true;
        l axj = l.axj();
        synchronized (axj.mLock) {
            try {
                axj.gZl.remove(this);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(133475);
            }
        }
    }

    public final void onResume() {
    }

    public final void axk() {
        AppMethodBeat.i(133476);
        ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "AppBrandListRecentsListWAGameHeader.onWAGameDataUpdate");
        l.axj();
        if (!l.enabled()) {
            AppMethodBeat.o(133476);
        } else if (this.mFinished) {
            AppMethodBeat.o(133476);
        } else {
            View view = this.iOy.iNR.apJ;
            if (view == null) {
                AppMethodBeat.o(133476);
                return;
            }
            view.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133470);
                    if (j.this.mFinished || j.this.iOy.iNR.apJ == null) {
                        AppMethodBeat.o(133470);
                        return;
                    }
                    j.a(j.this);
                    AppMethodBeat.o(133470);
                }
            });
            AppMethodBeat.o(133476);
        }
    }

    private static Integer Ea(String str) {
        AppMethodBeat.i(133477);
        try {
            Integer valueOf = Integer.valueOf(Color.parseColor(str));
            AppMethodBeat.o(133477);
            return valueOf;
        } catch (Exception e) {
            AppMethodBeat.o(133477);
            return null;
        }
    }

    public final View aNi() {
        return this.iOy.iNR.apJ;
    }

    public final void a(c cVar, View view) {
        AppMethodBeat.i(133478);
        if (cVar == null || cVar == c.LOADING || cVar == c.NONE) {
            ab.v("MicroMsg.AppBrandListRecentsListWAGameHeader", "onClick ");
            AppMethodBeat.o(133478);
        } else if (cVar == c.LOADING_ERROR) {
            this.iOy.aNt();
            l.axj().refresh();
            AppMethodBeat.o(133478);
        } else {
            if (cVar == c.LOADING_SUCCESS && this.iOA != null) {
                this.iOA.onClick(view);
                if (this.iOz) {
                    h hVar = this.iOy;
                    if (hVar.iNR.iOf != null) {
                        hVar.iNR.iOf.animate().alpha(0.0f).setDuration(200).start();
                    }
                }
            }
            AppMethodBeat.o(133478);
        }
    }

    public final void pS(int i) {
        AppMethodBeat.i(133479);
        if (this.iOy != null) {
            h hVar = this.iOy;
            if (!(hVar.iNR == null || hVar.iNR.iOh == null)) {
                hVar.iNR.iOh.setVisibility(i);
            }
        }
        AppMethodBeat.o(133479);
    }

    public final void pT(int i) {
        AppMethodBeat.i(133480);
        h hVar = this.iOy;
        if (!(hVar.iNR == null || hVar.iNR.apJ == null)) {
            hVar.iNR.apJ.setBackgroundResource(i);
        }
        AppMethodBeat.o(133480);
    }

    static /* synthetic */ void a(j jVar) {
        boolean z = false;
        AppMethodBeat.i(133481);
        ari ari = l.axj().gZm;
        if (ari == null) {
            h hVar = jVar.iOy;
            ab.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingFailed");
            hVar.iNQ = c.LOADING_ERROR;
            hVar.iNR.iNB.dKT();
            hVar.cw(hVar.iNR.iNB);
            hVar.cw(hVar.iNR.iOd);
            h.cx(hVar.iNR.iOg);
            AppMethodBeat.o(133481);
            return;
        }
        if (ari != null && (ari.wvn == 1 || ari.wvn == 2)) {
            c nz = c.nz(ari.wvn);
            String str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
            String str2 = "Use Game Entry %s";
            Object[] objArr = new Object[1];
            objArr[0] = nz == null ? BuildConfig.COMMAND : nz.name();
            ab.i(str, str2, objArr);
            if (nz == c.H5) {
                final String str3 = ari.wvm;
                if (bo.isNullOrNil(str3)) {
                    String str4 = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str = "makeH5ClickListener failed. link_wxagame = [%s]";
                    Object[] objArr2 = new Object[1];
                    if (str3 == null) {
                        str3 = BuildConfig.COMMAND;
                    }
                    objArr2[0] = str3;
                    ab.e(str4, str, objArr2);
                } else {
                    ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "H5 link is [%s]", str3);
                    if (bo.isNullOrNil(str3)) {
                        jVar.iOA = null;
                    } else {
                        jVar.iOA = new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(133471);
                                ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke H5 click listener, invoke h5");
                                ((com.tencent.mm.plugin.appbrand.compat.a.a) g.K(com.tencent.mm.plugin.appbrand.compat.a.a.class)).U(j.this.gNy, str3);
                                AppMethodBeat.o(133471);
                            }
                        };
                    }
                }
            } else if (nz == c.WXAPP) {
                final cxi cxi = ari.wvl;
                if (cxi == null) {
                    ab.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "makeWxAppClickListener failed. wxaInfo = null.");
                } else {
                    str = "MicroMsg.AppBrandListRecentsListWAGameHeader";
                    str2 = "WxApp link is [%s]";
                    objArr = new Object[1];
                    objArr[0] = cxi.path == null ? BuildConfig.COMMAND : cxi.path;
                    ab.i(str, str2, objArr);
                    new AppBrandStatObject().scene = 1001;
                    jVar.iOA = new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(133472);
                            ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke WxApp click listener, invoke wxapp");
                            AppBrandLaunchProxyUI.a(j.this.gNy, cxi.username, cxi.path, 0, cxi.vOP, new AppBrandStatObject(), null, null);
                            AppMethodBeat.o(133472);
                        }
                    };
                }
            }
        } else if (ari == null) {
            ab.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is null");
        } else {
            ab.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processClickListenerInfo resp is not null, but action_code is %d", Integer.valueOf(ari.wvn));
        }
        if (ari == null) {
            ab.e("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo GetWxaGameResponse");
        } else {
            ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "processRenderInfo entry = [%s] ec = [%s] new = [%s] nc = [%s]", ari.wvp, ari.wvq, ari.wvo, ari.wvr);
            jVar.iOx.iOE = bo.bc(ari.wvo, "");
            jVar.iOx.iOF = Ea(ari.wvr);
            jVar.iOx.iOG = new ArrayList(Math.max(ari.wvk == null ? 0 : ari.wvk.size(), 0));
            if (ari.wvk != null && ari.wvk.size() > 0) {
                Iterator it = ari.wvk.iterator();
                while (it.hasNext()) {
                    cxi cxi2 = (cxi) it.next();
                    if (cxi2 != null) {
                        jVar.iOx.iOG.add(cxi2.wHu);
                    }
                }
            }
        }
        if (ari.wve == 1) {
            z = true;
        }
        jVar.iOz = z;
        jVar.iOy.a(jVar.iOx.iOG, jVar.iOx.iOE, jVar.iOx.iOF);
        AppMethodBeat.o(133481);
    }
}
