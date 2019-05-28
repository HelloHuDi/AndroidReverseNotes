package com.tencent.mm.plugin.appbrand.ui.recents;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.q.b;
import com.tencent.mm.plugin.appbrand.appusage.r.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class i extends a implements OnClickListener, b {
    View apJ;
    private Activity czX;
    private f eoo;
    private final int eop;
    private final int eoq;
    private final int eor;
    private final int eos = -1;
    private ImageView iMf;
    private ThreeDotsLoadingView iNB;
    private View iOd;
    private a iOi = a.DISPLAY_NONE;
    private final int iOj;
    private TextView iOk;
    private AppBrandNearbyShowcaseView iOl;
    private View iOm;
    private ImageView iOn;
    private boolean iOo = false;

    enum a {
        LOAD_ERR,
        DISPLAY_LIST,
        DISPLAY_NONE,
        LOADING,
        LBS_NOT_ALLOWED;

        static {
            AppMethodBeat.o(133452);
        }
    }

    static /* synthetic */ void b(i iVar) {
        AppMethodBeat.i(133468);
        iVar.aNu();
        AppMethodBeat.o(133468);
    }

    static /* synthetic */ void g(i iVar) {
        AppMethodBeat.i(133469);
        iVar.aNv();
        AppMethodBeat.o(133469);
    }

    public final void eH(final boolean z) {
        AppMethodBeat.i(133453);
        this.iOd.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133445);
                if (z) {
                    i.this.iOd.setVisibility(0);
                    AppMethodBeat.o(133445);
                    return;
                }
                i.this.iOd.setVisibility(8);
                AppMethodBeat.o(133445);
            }
        });
        AppMethodBeat.o(133453);
    }

    i(Activity activity, ViewGroup viewGroup) {
        AppMethodBeat.i(133454);
        this.czX = activity;
        this.eop = com.tencent.mm.bz.a.fromDPToPix(activity, 25);
        this.eoq = com.tencent.mm.bz.a.fromDPToPix(activity, 19);
        this.eor = com.tencent.mm.bz.a.fromDPToPix(activity, 2);
        this.apJ = LayoutInflater.from(activity).inflate(R.layout.d3, viewGroup, false);
        View findViewById = this.apJ.findViewById(R.id.um);
        this.iOm = findViewById;
        findViewById.setOnClickListener(this);
        this.iOd = this.apJ.findViewById(R.id.ui);
        this.iOk = (TextView) this.apJ.findViewById(R.id.uk);
        this.iOl = (AppBrandNearbyShowcaseView) this.apJ.findViewById(R.id.uj);
        this.iOl.setIconLayerCount(4);
        this.iOl.setIconSize(this.eop + (this.eor * 2));
        this.iOl.setIconGap(this.eoq);
        this.iMf = (ImageView) this.apJ.findViewById(R.id.ul);
        this.iNB = (ThreeDotsLoadingView) this.apJ.findViewById(R.id.un);
        this.iOn = (ImageView) this.apJ.findViewById(R.id.uo);
        this.iOj = com.tencent.mm.bz.a.i(activity, R.color.ro);
        if (!com.tencent.mm.pluginsdk.permission.b.o(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.iOi = a.LBS_NOT_ALLOWED;
        }
        AppMethodBeat.o(133454);
    }

    public final View aNi() {
        return this.apJ;
    }

    public final void onResume() {
        AppMethodBeat.i(133455);
        if (a.LBS_NOT_ALLOWED == this.iOi && com.tencent.mm.pluginsdk.permission.b.o(this.czX, "android.permission.ACCESS_COARSE_LOCATION")) {
            this.iOi = a.DISPLAY_NONE;
            aNh();
        }
        AppMethodBeat.o(133455);
    }

    public final void aNh() {
        AppMethodBeat.i(133456);
        eG(q.axm());
        if (a.LBS_NOT_ALLOWED == this.iOi) {
            aNu();
            AppMethodBeat.o(133456);
            return;
        }
        q.a((b) this);
        if (!q.axr()) {
            this.apJ.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133446);
                    i.b(i.this);
                    AppMethodBeat.o(133446);
                }
            });
            AppMethodBeat.o(133456);
        } else if (q.refresh()) {
            aNt();
            AppMethodBeat.o(133456);
        } else {
            eG(false);
            AppMethodBeat.o(133456);
        }
    }

    public final void onDetached() {
        AppMethodBeat.i(133457);
        q.b(this);
        this.czX = null;
        this.apJ = null;
        this.iOl = null;
        this.iOd = null;
        AppMethodBeat.o(133457);
    }

    public final void pS(int i) {
        LayoutParams layoutParams;
        AppMethodBeat.i(133458);
        if (this.iMf != null) {
            this.iMf.setVisibility(i);
            ViewParent parent = this.iOd.getParent();
            if (parent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) parent;
                layoutParams = (LayoutParams) frameLayout.getLayoutParams();
                layoutParams.rightMargin = this.czX.getResources().getDimensionPixelOffset(R.dimen.td);
                frameLayout.setLayoutParams(layoutParams);
            }
        }
        TextView textView = (TextView) this.apJ.findViewById(R.id.cx);
        layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.czX.getResources().getDimensionPixelOffset(R.dimen.ro);
        textView.setLayoutParams(layoutParams);
        AppMethodBeat.o(133458);
    }

    public final void pT(int i) {
        AppMethodBeat.i(133459);
        this.iOm.setBackgroundResource(i);
        AppMethodBeat.o(133459);
    }

    private void aNt() {
        AppMethodBeat.i(133460);
        this.iOi = a.LOADING;
        cw(this.iOd);
        cw(this.iOn);
        cx(this.iNB);
        this.iNB.dKS();
        AppMethodBeat.o(133460);
    }

    private void aNu() {
        boolean z = true;
        int i = 0;
        AppMethodBeat.i(133461);
        if (this.apJ == null) {
            AppMethodBeat.o(133461);
            return;
        }
        d dVar;
        if (q.axm()) {
            eG(true);
            dVar = ((AppBrandLauncherUI) this.czX).iGM;
            if (dVar != null) {
                dVar.axA();
            }
        } else {
            eG(false);
        }
        this.iNB.dKT();
        cw(this.iNB);
        if (a.LBS_NOT_ALLOWED == this.iOi) {
            cw(this.iOd);
            cw(this.iOn);
            AppMethodBeat.o(133461);
            return;
        }
        are axq = q.axq();
        if (axq == null) {
            this.iOi = a.LOAD_ERR;
            cw(this.iOd);
            cx(this.iOn);
            AppMethodBeat.o(133461);
        } else if (axq.jsN <= 0 || bo.ek(axq.wuW)) {
            this.iOi = a.DISPLAY_NONE;
            cw(this.iOd);
            AppMethodBeat.o(133461);
        } else {
            this.iOi = a.DISPLAY_LIST;
            dVar = ((AppBrandLauncherUI) this.czX).iGM;
            if (dVar != null) {
                dVar.axz();
            }
            if (this.iOk != null) {
                this.iOk.setText(axq.wvc);
                this.iOk.setTextColor(bx(axq.wvd, this.iOj));
            }
            this.iOl.setIconLayerCount(Math.min(axq.wuW.size(), 4));
            if (this.iOd.getVisibility() == 0) {
                z = false;
            }
            if (z) {
                this.iOl.eO(false);
            }
            if (this.eoo == null) {
                this.eoo = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.eop, this.eor);
            }
            while (i < this.iOl.getChildCount()) {
                com.tencent.mm.modelappbrand.a.b.abR().a(this.iOl.qf(i), ((bdt) axq.wuW.get(i)).wHu, com.tencent.mm.modelappbrand.a.a.abQ(), this.eoo);
                i++;
            }
            cx(this.iOd);
            cw(this.iNB);
            cw(this.iOn);
            if (z) {
                if (this.iOl != null) {
                    this.iOl.aOB();
                }
                if (this.iOk != null) {
                    this.iOk.setAlpha(0.0f);
                    this.iOk.animate().alpha(1.0f).setDuration(500).start();
                }
            }
            AppMethodBeat.o(133461);
        }
    }

    private static int bx(String str, int i) {
        AppMethodBeat.i(133462);
        try {
            i = Color.parseColor(str);
            AppMethodBeat.o(133462);
        } catch (Exception e) {
            AppMethodBeat.o(133462);
        }
        return i;
    }

    private void cw(final View view) {
        AppMethodBeat.i(133463);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133447);
                    view.setVisibility(8);
                    AppMethodBeat.o(133447);
                }
            }).start();
        }
        AppMethodBeat.o(133463);
    }

    private static void cx(View view) {
        AppMethodBeat.i(133464);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
        AppMethodBeat.o(133464);
    }

    public final void axs() {
        AppMethodBeat.i(133465);
        if (this.apJ != null) {
            this.apJ.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133448);
                    i.b(i.this);
                    if (i.this.iOo) {
                        i.this.iOm.performClick();
                        i.this.iOo = false;
                    }
                    AppMethodBeat.o(133448);
                }
            });
        }
        AppMethodBeat.o(133465);
    }

    public final void onClick(View view) {
        int i = 0;
        AppMethodBeat.i(133466);
        if (view.getId() == R.id.um) {
            if (this.czX == null) {
                AppMethodBeat.o(133466);
                return;
            } else if (a.LOADING == this.iOi) {
                AppMethodBeat.o(133466);
                return;
            } else if (a.DISPLAY_NONE == this.iOi) {
                aNv();
                this.czX.startActivityForResult(new Intent(this.czX, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 0), 3);
                AppMethodBeat.o(133466);
                return;
            } else if (a.LBS_NOT_ALLOWED == this.iOi) {
                aNv();
                this.czX.startActivityForResult(new Intent(this.czX, AppBrandNearbyEmptyUI.class).putExtra("extra_enter_reason", 1), 3);
                AppMethodBeat.o(133466);
                return;
            } else {
                boolean z = q.axq() != null && q.axr();
                this.iOo = z;
                if (a.LOAD_ERR == this.iOi || this.iOo) {
                    i = 1;
                }
                AnonymousClass5 anonymousClass5 = new Runnable() {
                    public final void run() {
                        int i = 0;
                        AppMethodBeat.i(133449);
                        if (i.this.czX == null) {
                            AppMethodBeat.o(133449);
                            return;
                        }
                        are axq = q.axq();
                        if (axq != null) {
                            com.tencent.mm.plugin.appbrand.report.model.l.a aVar;
                            int i2 = axq.wvf == 1 ? 1 : 0;
                            if (i2 != 0) {
                                bdt bdt = axq.wvg;
                                if (bdt == null) {
                                    ab.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram but invalid appInfo, just return");
                                    AppMethodBeat.o(133449);
                                    return;
                                }
                                if (com.tencent.mm.sdk.a.b.dnO()) {
                                    i = bdt.type;
                                }
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = 1001;
                                com.tencent.mm.plugin.appbrand.launching.precondition.f.ijT.a(i.this.czX, bdt.username, null, bdt.path, i, bdt.vOP, appBrandStatObject, null, null);
                            } else if (bo.isNullOrNil(axq.wuU)) {
                                ab.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram false, url empty, just return");
                                AppMethodBeat.o(133449);
                                return;
                            } else {
                                ((com.tencent.mm.plugin.appbrand.compat.a.a) g.K(com.tencent.mm.plugin.appbrand.compat.a.a.class)).T(i.this.czX, axq.wuU);
                            }
                            i.g(i.this);
                            l lVar = new l();
                            lVar.iBL = l.b.TOP_ENTRANCE_IN_DESKTOP;
                            lVar.iBM = axq.jsN;
                            lVar.iBN = axq.wuS;
                            if (i2 != 0) {
                                aVar = com.tencent.mm.plugin.appbrand.report.model.l.a.NEARBY_MINI_PROGRAM;
                            } else {
                                aVar = com.tencent.mm.plugin.appbrand.report.model.l.a.NEARBY_H5;
                            }
                            lVar.iBP = aVar;
                            lVar.IF();
                        }
                        AppMethodBeat.o(133449);
                    }
                };
                if (i != 0) {
                    aNt();
                    q.refresh();
                    AppMethodBeat.o(133466);
                    return;
                }
                anonymousClass5.run();
                if (!(q.axq() == null || q.axq().wve != 1 || this.iOk == null)) {
                    this.iOk.animate().alpha(0.0f).setDuration(200);
                }
            }
        }
        AppMethodBeat.o(133466);
    }

    private void aNv() {
        AppMethodBeat.i(133467);
        if (this.czX == null) {
            AppMethodBeat.o(133467);
            return;
        }
        d dVar = ((AppBrandLauncherUI) this.czX).iGM;
        if (dVar != null) {
            dVar.axB();
        }
        AppMethodBeat.o(133467);
    }
}
