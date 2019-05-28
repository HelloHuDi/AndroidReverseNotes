package com.tencent.mm.plugin.appbrand.ui.recents;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class AppBrandLauncherRecentsList extends Fragment {
    private int huR;
    private final al iLa;
    private final r iMA;
    private d iMB;
    private View iMC;
    private View iMD;
    private a iME;
    private e iMF;
    private final p iMG;
    private int iMH;
    private int iMI;
    private boolean iMJ;
    private boolean iMK;
    private String iML;
    private final android.support.v7.h.d iMM;
    private final b iMN;
    private final com.tencent.mm.sdk.e.k.a iMO;
    private final com.tencent.mm.sdk.e.k.a iMP;
    private final com.tencent.mm.sdk.e.k.a iMQ;
    private final com.tencent.mm.sdk.e.k.a iMR;
    private final c iMS;
    private boolean iMT;
    private Dialog iMU;
    private final int iMk;
    private final boolean iMl;
    private final boolean iMm;
    private final boolean iMn;
    private final k iMo;
    private final Bundle iMp;
    private final AtomicLong iMq;
    private final AtomicLong iMr;
    private final AtomicBoolean iMs;
    private final AtomicLong iMt;
    private final AtomicBoolean iMu;
    private LoadMoreRecyclerView iMv;
    private LinearLayoutManager iMw;
    private t iMx;
    private final m iMy;
    private final a iMz;

    final class e extends v implements OnClickListener, OnCreateContextMenuListener, com.tencent.mm.ui.base.n.d {
        View goc;
        TextView iNn;
        TextView iNo;
        TextView iNp;
        TextView iNq;
        ImageView iNr;
        View iNs;
        com.tencent.mm.ui.widget.b.a iNt;
        final int iNu = 1;
        final int iNv = 2;

        e(View view) {
            super(view);
            AppMethodBeat.i(133387);
            this.goc = view.findViewById(R.id.p3);
            this.iNn = (TextView) view.findViewById(R.id.c5);
            this.iNo = (TextView) view.findViewById(R.id.qn);
            this.iNp = (TextView) view.findViewById(R.id.pr);
            this.iNq = (TextView) view.findViewById(R.id.rp);
            this.iNr = (ImageView) view.findViewById(R.id.jb);
            this.iNs = view.findViewById(R.id.ro);
            view.setOnClickListener(this);
            this.iNt = new com.tencent.mm.ui.widget.b.a(this.apJ.getContext()) {
                public final boolean dn(int i, int i2) {
                    AppMethodBeat.i(133382);
                    if (e.this.apJ.getParent() != null) {
                        e.this.apJ.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    boolean dn = super.dn(i, i2);
                    AppMethodBeat.o(133382);
                    return dn;
                }

                public final void onDismiss() {
                    AppMethodBeat.i(133383);
                    if (e.this.apJ.getParent() != null) {
                        e.this.apJ.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    super.onDismiss();
                    AppMethodBeat.o(133383);
                }
            };
            this.iNt.c(this.apJ, this, this);
            AppMethodBeat.o(133387);
        }

        private int aNp() {
            AppMethodBeat.i(133388);
            int S = AppBrandLauncherRecentsList.this.iMv.S(this);
            AppMethodBeat.o(133388);
            return S;
        }

        /* Access modifiers changed, original: final */
        public final AppBrandRecentTaskInfo aNq() {
            AppMethodBeat.i(133389);
            try {
                AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) AppBrandLauncherRecentsList.this.iMx.pW(aNp());
                AppMethodBeat.o(133389);
                return appBrandRecentTaskInfo;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e, "getAppInfo", new Object[0]);
                AppMethodBeat.o(133389);
                return null;
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(133390);
            AppBrandRecentTaskInfo aNq = aNq();
            if (aNq == null) {
                AppMethodBeat.o(133390);
                return;
            }
            if (AppBrandLauncherRecentsList.this.iMl) {
                contextMenu.add(0, 1, 0, this.apJ.getContext().getString(aNq.had ? R.string.od : R.string.oa));
            }
            contextMenu.add(0, 2, 0, this.apJ.getContext().getString(R.string.kl));
            AppMethodBeat.o(133390);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(133391);
            final AppBrandRecentTaskInfo aNq = aNq();
            if (aNq == null || menuItem == null) {
                AppMethodBeat.o(133391);
                return;
            }
            int i2;
            String aLd;
            switch (AppBrandLauncherRecentsList.this.getActivity().getIntent().getIntExtra("extra_get_usage_reason", 3)) {
                case 9:
                    i2 = 7;
                    break;
                default:
                    i2 = 1;
                    break;
            }
            if (i2 == 7) {
                aLd = com.tencent.mm.plugin.appbrand.report.e.aLd();
            } else {
                if (TextUtils.isEmpty(AppBrandLauncherRecentsList.this.iML)) {
                    AppBrandLauncherRecentsList.this.iML = com.tencent.mm.plugin.appbrand.report.e.aLc();
                }
                aLd = AppBrandLauncherRecentsList.this.iML;
            }
            if (1 != menuItem.getItemId()) {
                if (2 == menuItem.getItemId()) {
                    if (aNq.had && !AppBrandLauncherRecentsList.this.iMm) {
                        AppBrandLauncherRecentsList.this.iLa.aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(133386);
                                ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).j(aNq.csl, aNq.gVs, true);
                                com.tencent.mm.plugin.appbrand.report.e.a(aNq, 7, i2, aLd);
                                AppMethodBeat.o(133386);
                            }
                        });
                    }
                    AppBrandLauncherRecentsList.this.iMy.pV(aNp());
                    AppBrandLauncherRecentsList.this.iMG.iON = true;
                    AppBrandLauncherRecentsList.this.iMN.aNo();
                    AppBrandLauncherRecentsList.this.iMx.ci(aNp());
                    AppBrandLauncherRecentsList.c(AppBrandLauncherRecentsList.this);
                    com.tencent.mm.plugin.appbrand.appusage.al.j(aNq.csl, aNq.appId, aNq.gVs);
                }
                AppMethodBeat.o(133391);
            } else if (AppBrandLauncherRecentsList.this.iMm || AppBrandLauncherRecentsList.this.iMy.aNw().size() < AppBrandLauncherRecentsList.this.iMk || aNq.had) {
                AppBrandLauncherRecentsList.this.iLa.aa(new Runnable() {
                    public final void run() {
                        int i;
                        AppMethodBeat.i(133385);
                        if (aNq.had) {
                            ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).j(aNq.csl, aNq.gVs, true);
                            if (!AppBrandLauncherRecentsList.this.iMm && AppBrandLauncherRecentsList.this.iMl) {
                                com.tencent.mm.plugin.appbrand.app.f.auT().a(aNq.csl, aNq.gVs, false, 0, 2, null);
                            }
                            i = 7;
                        } else {
                            i = ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).aG(aNq.csl, aNq.gVs);
                            if (i == -2) {
                                AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                                    public final void run() {
                                        AppMethodBeat.i(133384);
                                        h.a(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.getResources().getString(R.string.ht, new Object[]{Integer.valueOf(AppBrandLauncherRecentsList.this.iMk)}), "", AppBrandLauncherRecentsList.this.getResources().getString(R.string.s6), false, null);
                                        AppMethodBeat.o(133384);
                                    }
                                });
                                AppMethodBeat.o(133385);
                                return;
                            } else if (i == -1) {
                                ab.e("MicroMsg.AppBrandLauncherRecentsList", "addStarApp, username %s, type %d, fatal", aNq.csl, Integer.valueOf(aNq.gVs));
                                AppMethodBeat.o(133385);
                                return;
                            } else {
                                i = 6;
                            }
                        }
                        com.tencent.mm.plugin.appbrand.report.e.a(aNq, i, i2, aLd);
                        AppMethodBeat.o(133385);
                    }
                });
                AppBrandLauncherRecentsList.this.iMG.iON = true;
                AppMethodBeat.o(133391);
            } else {
                if (AppBrandLauncherRecentsList.this.getActivity() != null) {
                    h.a(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.getResources().getString(R.string.ht, new Object[]{Integer.valueOf(AppBrandLauncherRecentsList.this.iMk)}), "", AppBrandLauncherRecentsList.this.getResources().getString(R.string.s6), false, null);
                }
                AppMethodBeat.o(133391);
            }
        }

        public final void onClick(View view) {
            AppMethodBeat.i(133392);
            AppBrandRecentTaskInfo aNq = aNq();
            if (aNq == null) {
                AppMethodBeat.o(133392);
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1001;
            switch (AppBrandLauncherRecentsList.this.gOW) {
                case 10:
                    appBrandStatObject.cOq = 11;
                    break;
                case 11:
                    appBrandStatObject.cOq = 12;
                    break;
                case 13:
                    appBrandStatObject.cOq = 13;
                    break;
            }
            AppBrandLaunchProxyUI.a(AppBrandLauncherRecentsList.this.getActivity(), aNq.csl, null, aNq.gVs, -1, appBrandStatObject, null, null);
            if (AppBrandLauncherRecentsList.this.getActivity() != null && (AppBrandLauncherRecentsList.this.getActivity() instanceof AppBrandLauncherUI)) {
                com.tencent.mm.plugin.appbrand.appusage.r.d dVar = ((AppBrandLauncherUI) AppBrandLauncherRecentsList.this.getActivity()).iGM;
                if (dVar != null) {
                    dVar.haa[7] = "1";
                }
            }
            AppMethodBeat.o(133392);
        }
    }

    final class f extends m implements Runnable {
        private f() {
        }

        /* synthetic */ f(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(133393);
            AppBrandLauncherRecentsList.this.iMJ = i == 2;
            if (i == 0) {
                AppBrandLauncherRecentsList.this.N(this);
            }
            AppMethodBeat.o(133393);
        }

        public final void run() {
            AppMethodBeat.i(133394);
            if (!(AppBrandLauncherRecentsList.this.iMv == null || AppBrandLauncherRecentsList.this.iMw == null || AppBrandLauncherRecentsList.this.iMx == null || AppBrandLauncherRecentsList.this.iMB == null)) {
                int iQ = AppBrandLauncherRecentsList.this.iMw.iQ();
                int iS = AppBrandLauncherRecentsList.this.iMw.iS();
                for (int i = iQ; i <= iS; i++) {
                    v cf = AppBrandLauncherRecentsList.this.iMv.cf(i);
                    if (cf instanceof e) {
                        AppBrandRecentTaskInfo aNq = ((e) cf).aNq();
                        if (aNq != null) {
                            AppBrandLauncherRecentsList.this.iMB.b((e) cf, aNq.hac);
                        }
                    }
                }
            }
            AppMethodBeat.o(133394);
        }
    }

    final class c extends android.support.v7.widget.RecyclerView.c implements android.support.v7.widget.RecyclerView.f.a {
        private c() {
        }

        /* synthetic */ c(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        public final void aw(int i, int i2) {
            AppMethodBeat.i(133368);
            eI(false);
            AppMethodBeat.o(133368);
        }

        public final void ax(int i, int i2) {
            AppMethodBeat.i(133369);
            eI(true);
            AppMethodBeat.o(133369);
        }

        public final void ay(int i, int i2) {
            AppMethodBeat.i(133370);
            eI(false);
            AppMethodBeat.o(133370);
        }

        public final void jT() {
            AppMethodBeat.i(133371);
            eI(false);
            AppMethodBeat.o(133371);
        }

        private void eI(final boolean z) {
            AppMethodBeat.i(133372);
            AppBrandLauncherRecentsList.this.N(new Runnable() {
                public final void run() {
                    int i = 1;
                    int i2 = 0;
                    AppMethodBeat.i(133367);
                    if (!(AppBrandLauncherRecentsList.this.iMx.isEmpty() || AppBrandLauncherRecentsList.this.iMx == null)) {
                        try {
                            AppBrandLauncherRecentsList.this.iMx.cg(AppBrandLauncherRecentsList.this.iMx.getItemCount() - 1);
                        } catch (Exception e) {
                            ab.e("MicroMsg.AppBrandLauncherRecentsList", "adjustListBottomDivider notifyItemChanged e=%s", e);
                        }
                    }
                    if (AppBrandLauncherRecentsList.this.iMF != null) {
                        e o = AppBrandLauncherRecentsList.this.iMF;
                        if (z || AppBrandLauncherRecentsList.this.iMx.isEmpty()) {
                            i = 0;
                        }
                        View view = o.iNC;
                        if (i == 0) {
                            i2 = 4;
                        }
                        n.H(view, i2);
                    }
                    AppMethodBeat.o(133367);
                }
            });
            AppMethodBeat.o(133372);
        }
    }

    final class d extends u<AppBrandRecentTaskInfo, e> {
        final Map<String, String> iNm;

        private d() {
            AppMethodBeat.i(133373);
            this.iNm = new HashMap();
            AppMethodBeat.o(133373);
        }

        /* synthetic */ d(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        public final /* synthetic */ long bA(Object obj) {
            AppMethodBeat.i(133379);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) obj;
            long hashCode = (long) (appBrandRecentTaskInfo.csl + appBrandRecentTaskInfo.gVs).hashCode();
            AppMethodBeat.o(133379);
            return hashCode;
        }

        public final /* synthetic */ void c(v vVar, Object obj) {
            AppMethodBeat.i(133380);
            e eVar = (e) vVar;
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) obj;
            eVar.iNo.setVisibility(8);
            eVar.goc.setVisibility(0);
            a(eVar, bo.isNullOrNil(appBrandRecentTaskInfo.appName) ? appBrandRecentTaskInfo.csl.replaceFirst("@app", "") : appBrandRecentTaskInfo.appName);
            b(eVar, appBrandRecentTaskInfo.hac);
            a(eVar, appBrandRecentTaskInfo.had);
            String no = com.tencent.mm.plugin.appbrand.appcache.b.no(appBrandRecentTaskInfo.gVs);
            if (bo.isNullOrNil(no)) {
                eVar.iNp.setVisibility(8);
            } else {
                eVar.iNp.setText(no);
                eVar.iNp.setVisibility(0);
            }
            a(eVar);
            AppMethodBeat.o(133380);
        }

        private void a(e eVar) {
            AppMethodBeat.i(133374);
            AppBrandLauncherRecentsList.this.iMv;
            if (RecyclerView.bo(eVar.apJ) == AppBrandLauncherRecentsList.this.iMx.getItemCount() - 1) {
                eVar.goc.setVisibility(8);
            } else {
                eVar.goc.setVisibility(0);
            }
            if (AppBrandLauncherRecentsList.this.iMn) {
                TextView textView = eVar.iNq;
                AppBrandLauncherRecentsList.this.iMv;
                textView.setText(String.valueOf(RecyclerView.bo(eVar.apJ)));
                eVar.iNq.setVisibility(0);
                AppMethodBeat.o(133374);
                return;
            }
            eVar.iNq.setVisibility(8);
            AppMethodBeat.o(133374);
        }

        private void a(e eVar, boolean z) {
            AppMethodBeat.i(133375);
            View view = eVar.iNs;
            int i = (AppBrandLauncherRecentsList.this.iMl && z) ? 0 : 8;
            view.setVisibility(i);
            AppMethodBeat.o(133375);
        }

        private static void a(e eVar, String str) {
            AppMethodBeat.i(133376);
            eVar.iNn.setText(str);
            AppMethodBeat.o(133376);
        }

        /* Access modifiers changed, original: final */
        public final void b(e eVar, String str) {
            AppMethodBeat.i(133377);
            AppBrandLauncherRecentsList.this.iMJ;
            this.iNm.put(str, com.tencent.mm.modelappbrand.a.b.abR().a(eVar.iNr, str, com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH));
            AppMethodBeat.o(133377);
        }
    }

    final class g extends RecyclerView.h {
        private g() {
        }

        /* synthetic */ g(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(133395);
            rect.left = 0;
            rect.right = 0;
            rect.bottom = 0;
            rect.top = 0;
            if (recyclerView instanceof MRecyclerView) {
                v aZ = recyclerView.aZ(view);
                if (aZ instanceof e) {
                    n.H(((e) aZ).goc, ((MRecyclerView) recyclerView).S(aZ) == AppBrandLauncherRecentsList.this.iMx.getItemCount() + -1 ? 8 : 0);
                }
            }
            AppMethodBeat.o(133395);
        }
    }

    @SuppressLint({"HandlerLeak"})
    final class a extends Handler {
        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(133363);
            aVar.aNn();
            AppMethodBeat.o(133363);
        }

        public a() {
            super(Looper.getMainLooper());
            AppMethodBeat.i(133360);
            AppMethodBeat.o(133360);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(133361);
            if (message.what == 1) {
                ((Runnable) message.obj).run();
                removeMessages(2);
                AppMethodBeat.o(133361);
            } else if (message.what == 2) {
                ((Runnable) message.obj).run();
                AppMethodBeat.o(133361);
            } else {
                super.handleMessage(message);
                AppMethodBeat.o(133361);
            }
        }

        private void aNn() {
            AppMethodBeat.i(133362);
            removeMessages(1);
            removeMessages(2);
            AppMethodBeat.o(133362);
        }

        static /* synthetic */ void b(a aVar) {
            AppMethodBeat.i(133364);
            aVar.aNn();
            AppMethodBeat.o(133364);
        }
    }

    final class b implements android.support.v7.widget.RecyclerView.f.a {
        private b() {
        }

        /* synthetic */ b(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        public final void jT() {
            AppMethodBeat.i(133365);
            AppBrandLauncherRecentsList.this.iMG.iOM = false;
            AppMethodBeat.o(133365);
        }

        /* Access modifiers changed, original: final */
        public final void aNo() {
            AppMethodBeat.i(133366);
            AppBrandLauncherRecentsList.this.iMG.iOM = true;
            AppMethodBeat.o(133366);
        }
    }

    public AppBrandLauncherRecentsList() {
        this(true);
    }

    @SuppressLint({"ValidFragment"})
    public AppBrandLauncherRecentsList(boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(133396);
        this.iMp = new Bundle();
        this.iMq = new AtomicLong(-1);
        this.iMr = new AtomicLong(-1);
        this.iMs = new AtomicBoolean(false);
        this.iMt = new AtomicLong(Long.MAX_VALUE);
        this.iMu = new AtomicBoolean(false);
        this.iMy = new m();
        this.iLa = new al("AppBrandLauncherUI#RecentsListUI");
        this.iMz = new a();
        this.iMA = new r();
        this.iMG = new p();
        this.iMH = 3;
        this.iMI = 0;
        this.iMJ = false;
        this.iMK = false;
        this.iMM = new android.support.v7.h.d() {
            public final void G(int i, int i2) {
                AppMethodBeat.i(133348);
                AppBrandLauncherRecentsList.this.iMx.at(i, i2);
                AppMethodBeat.o(133348);
            }

            public final void H(int i, int i2) {
                AppMethodBeat.i(133349);
                AppBrandLauncherRecentsList.this.iMN.aNo();
                AppBrandLauncherRecentsList.this.iMx.au(i, i2);
                AppMethodBeat.o(133349);
            }

            public final void I(int i, int i2) {
                AppMethodBeat.i(133350);
                AppBrandLauncherRecentsList.this.iMN.aNo();
                AppBrandLauncherRecentsList.this.iMx.as(i, i2);
                AppMethodBeat.o(133350);
            }

            public final void a(int i, int i2, Object obj) {
                AppMethodBeat.i(133351);
                AppBrandLauncherRecentsList.this.iMx.c(i, i2, obj);
                AppMethodBeat.o(133351);
            }
        };
        this.iMN = new b(this, (byte) 0);
        this.iMO = new com.tencent.mm.sdk.e.k.a() {
            public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                AppMethodBeat.i(133352);
                if ("single".equals(str)) {
                    if ((5 == mVar.hsh && AppBrandLauncherRecentsList.this.iMm) || 2 == mVar.hsh || 3 == mVar.hsh) {
                        ab.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, event %d", Integer.valueOf(mVar.hsh));
                        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, false, -1, true);
                        AppMethodBeat.o(133352);
                        return;
                    }
                } else if ("batch".equals(str) && 3 == mVar.hsh) {
                    Object obj = mVar.obj;
                    if ((obj instanceof Long) && ((Long) obj).longValue() == AppBrandLauncherRecentsList.this.iMq.get()) {
                        AppMethodBeat.o(133352);
                        return;
                    } else {
                        ab.d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, batch update");
                        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, false, Long.MAX_VALUE, true);
                    }
                }
                AppMethodBeat.o(133352);
            }
        };
        this.iMP = new com.tencent.mm.sdk.e.k.a() {
            public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                AppMethodBeat.i(133354);
                if ("single".equals(str) && (3 == mVar.hsh || 2 == mVar.hsh)) {
                    AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133353);
                            if (AppBrandLauncherRecentsList.this.iMv.anv) {
                                AppBrandLauncherRecentsList.this.iMG.iON = false;
                            }
                            AppMethodBeat.o(133353);
                        }
                    });
                    ab.d("MicroMsg.AppBrandLauncherRecentsList", "onHistoryRecordModified");
                    AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, true, Long.MAX_VALUE, false);
                }
                AppMethodBeat.o(133354);
            }
        };
        this.iMQ = new com.tencent.mm.sdk.e.k.a() {
            public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                AppMethodBeat.i(133355);
                ab.d("MicroMsg.AppBrandLauncherRecentsList", "onContactUpdate %s", str);
                AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, false, -1, false);
                AppMethodBeat.o(133355);
            }
        };
        this.iMR = new com.tencent.mm.sdk.e.k.a() {
            public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
                AppMethodBeat.i(133358);
                try {
                    if (mVar.obj != null && (mVar.obj instanceof Long)) {
                        List gi;
                        long j = AppBrandLauncherRecentsList.this.iMq.get();
                        ab.d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", (Long) mVar.obj, Long.valueOf(j), Long.valueOf(AppBrandLauncherRecentsList.this.iMr.get()));
                        if (mVar.obj.equals(Long.valueOf(j))) {
                            gi = com.tencent.mm.plugin.appbrand.app.f.auT().hap.gi(Long.MAX_VALUE);
                        } else {
                            Object gi2 = com.tencent.mm.plugin.appbrand.app.f.auT().hap.gi(AppBrandLauncherRecentsList.this.iMt.get());
                        }
                        if (!bo.ek(gi2)) {
                            AppBrandLauncherRecentsList.this.iMt.set(((AppBrandRecentTaskInfo) gi2.get(gi2.size() - 1)).updateTime);
                        }
                        final ArrayList q = AppBrandLauncherRecentsList.this.iMo.q(gi2);
                        if (mVar.obj.equals(Long.valueOf(j))) {
                            ArrayList arrayList = AppBrandLauncherRecentsList.this.iMm ? new ArrayList(0) : AppBrandLauncherRecentsList.this.iMl ? com.tencent.mm.plugin.appbrand.app.f.auU().a(com.tencent.mm.plugin.appbrand.appusage.af.a.ASC) : null;
                            AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(133356);
                                    AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, arrayList, q, true);
                                    AppMethodBeat.o(133356);
                                }
                            });
                            AppMethodBeat.o(133358);
                            return;
                        } else if (mVar.obj.equals(Long.valueOf(r4))) {
                            a.a(AppBrandLauncherRecentsList.this.iMz);
                            AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(1, new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(133357);
                                    if (AppBrandLauncherRecentsList.this.iMv == null || !AppBrandLauncherRecentsList.this.iMv.isAttachedToWindow()) {
                                        AppMethodBeat.o(133357);
                                    } else if (AppBrandLauncherRecentsList.this.iMv.jz()) {
                                        AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(2, this));
                                        AppMethodBeat.o(133357);
                                    } else {
                                        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, q);
                                        AppMethodBeat.o(133357);
                                    }
                                }
                            }));
                        }
                    }
                    AppMethodBeat.o(133358);
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", e);
                    AppMethodBeat.o(133358);
                }
            }
        };
        this.iMS = new c(this, (byte) 0);
        this.iMT = false;
        this.huR = 0;
        this.iMU = null;
        Bundle bundle = new Bundle(1);
        bundle.putBoolean("showHeader", z);
        setArguments(bundle);
        this.iMl = t.axG();
        this.iMm = t.axH();
        if (bp.dpL() && com.tencent.mm.kernel.g.RP().Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_APP_BRAND_SHOW_HISTORY_COUNT_BOOLEAN, false)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.iMn = z2;
        this.iMk = t.axI();
        if (!this.iMl || this.iMm) {
            z3 = false;
        }
        this.iMo = new k(z3);
        AppMethodBeat.o(133396);
    }

    private boolean aNl() {
        AppMethodBeat.i(133397);
        if (this.iMu.get()) {
            AppMethodBeat.o(133397);
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            AppMethodBeat.o(133397);
            return true;
        }
        AppMethodBeat.o(133397);
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.i(133398);
        this.iMT = true;
        super.onResume();
        if (this.iMv != null) {
            this.iMv.setLayoutFrozen(false);
        }
        int i = this.huR + 1;
        this.huR = i;
        if (i > 1) {
            if (this.iME != null) {
                this.iME.onResume();
            }
            N(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133359);
                    AppBrandLauncherRecentsList.c(AppBrandLauncherRecentsList.this);
                    AppMethodBeat.o(133359);
                }
            });
        }
        AppMethodBeat.o(133398);
    }

    public final void onPause() {
        AppMethodBeat.i(133399);
        this.iMT = false;
        super.onPause();
        try {
            if (this.iMv != null) {
                this.iMv.setLayoutFrozen(true);
            }
            AppMethodBeat.o(133399);
        } catch (IllegalStateException e) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(133330);
                    Looper.myQueue().removeIdleHandler(this);
                    if (!(AppBrandLauncherRecentsList.this.iMT || AppBrandLauncherRecentsList.this.iMv == null)) {
                        try {
                            AppBrandLauncherRecentsList.this.iMv.setLayoutFrozen(true);
                        } catch (IllegalStateException e) {
                        }
                    }
                    AppMethodBeat.o(133330);
                    return false;
                }
            });
            AppMethodBeat.o(133399);
        }
    }

    public final void onDestroyView() {
        AppMethodBeat.i(133400);
        super.onDestroyView();
        if (this.iME != null) {
            this.iME.onDetached();
        }
        if (this.iMF != null) {
            this.iMF.onDetached();
        }
        if (this.iMx != null) {
            this.iMx.b(this.iMS);
        }
        if (this.iMB != null) {
            this.iMB.iNm.clear();
            this.iMB = null;
        }
        if (com.tencent.mm.kernel.g.RN().eJb && !com.tencent.mm.kernel.a.QT()) {
            p.ayH().d(this.iMQ);
            com.tencent.mm.plugin.appbrand.app.f.auT().d(this.iMP);
            ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).d(this.iMO);
            j.axh().d(this.iMR);
        }
        this.iLa.oAl.quit();
        this.iMq.set(-1);
        this.iMr.set(-1);
        this.iMs.set(false);
        this.iMt.set(Long.MAX_VALUE);
        this.iMG.c(this.iMS);
        this.iMG.c(this.iMN);
        AppMethodBeat.o(133400);
    }

    public final void aMf() {
        AppMethodBeat.i(133401);
        if (this.iMv != null) {
            this.iMv.smoothScrollToPosition(0);
        }
        AppMethodBeat.o(133401);
    }

    public final void setScene(int i) {
        AppMethodBeat.i(133402);
        super.setScene(i);
        this.iMp.putInt("launcher_ui_enter_scene", i);
        AppMethodBeat.o(133402);
    }

    public final void onDestroy() {
        AppMethodBeat.i(133403);
        super.onDestroy();
        this.iMu.set(true);
        a.b(this.iMz);
        AppMethodBeat.o(133403);
    }

    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(133404);
        super.onActivityCreated(bundle);
        if (!(getActivity() == null || getActivity().getIntent() == null)) {
            this.iMH = getActivity().getIntent().getIntExtra("extra_get_usage_reason", this.iMH);
            this.iMI = getActivity().getIntent().getIntExtra("extra_get_usage_prescene", this.iMI);
        }
        AppMethodBeat.o(133404);
    }

    public final void initView() {
        AppMethodBeat.i(133405);
        getActivity();
        this.iMw = new LinearLayoutManager() {
            public final void a(RecyclerView recyclerView, int i) {
                AppMethodBeat.i(133332);
                q qVar = new q(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.iMw);
                qVar.ape = i;
                a((r) qVar);
                AppMethodBeat.o(133332);
            }

            public final boolean iE() {
                return false;
            }

            public final void c(o oVar, RecyclerView.s sVar) {
                AppMethodBeat.i(133333);
                try {
                    super.c(oVar, sVar);
                    AppMethodBeat.o(133333);
                } catch (IndexOutOfBoundsException e) {
                    ab.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren IndexOutOfBoundsException retry notifyDataSetChanged");
                    try {
                        AppBrandLauncherRecentsList.this.iMx.aop.notifyChanged();
                        AppMethodBeat.o(133333);
                    } catch (IllegalStateException e2) {
                        ab.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged e=%s", e2);
                        if (bo.nullAsNil(e2.getMessage()).contains("computing a layout or scrolling")) {
                            AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(2, new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(133331);
                                    try {
                                        AppBrandLauncherRecentsList.this.iMx.aop.notifyChanged();
                                        AppMethodBeat.o(133331);
                                    } catch (IllegalStateException e) {
                                        ab.w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged after scroll e=%s", e);
                                        AppMethodBeat.o(133331);
                                    }
                                }
                            }));
                        }
                        AppMethodBeat.o(133333);
                    }
                }
            }

            public final int b(int i, o oVar, RecyclerView.s sVar) {
                int i2 = 0;
                AppMethodBeat.i(138699);
                try {
                    i2 = super.b(i, oVar, sVar);
                    AppMethodBeat.o(138699);
                } catch (IndexOutOfBoundsException e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e, "scrollVerticallyBy(%d, %s)", Integer.valueOf(i), sVar);
                    AppMethodBeat.o(138699);
                }
                return i2;
            }
        };
        this.iMw.an(false);
        this.iMv = new RecentsRecyclerView(getContext()) {
            public final LinearLayoutManager aNm() {
                AppMethodBeat.i(133334);
                LinearLayoutManager q = AppBrandLauncherRecentsList.this.iMw;
                AppMethodBeat.o(133334);
                return q;
            }
        };
        this.iMv.setVerticalScrollBarEnabled(true);
        ((FrameLayout) this.WL).addView(this.iMv, new LayoutParams(-1, -1));
        this.iMv.b((RecyclerView.h) new g(this, (byte) 0));
        this.iMv.setItemAnimator(this.iMG);
        this.iMG.b(this.iMS);
        this.iMG.b(this.iMN);
        t tVar = new t(this.iMy);
        d dVar = new d(this, (byte) 0);
        this.iMB = dVar;
        tVar.iPq.put(AppBrandRecentTaskInfo.class.hashCode(), dVar);
        this.iMx = tVar;
        this.iMx.jR();
        this.iMx.a((android.support.v7.widget.RecyclerView.c) this.iMS);
        this.iMv.setAdapter(this.iMx);
        this.iMv.a((m) new f(this, (byte) 0));
        if (getArguments() == null || getArguments().getBoolean("showHeader", true)) {
            this.iME = new f(getActivity(), this.iMv, false, false);
            this.iMv.addHeaderView(this.iME.aNi());
            this.iME.aNi().setVisibility(8);
            this.iME.aNh();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.d2, this.iMv, false);
            this.iMv.addHeaderView(inflate);
            this.iMC = inflate;
            this.iMC.setVisibility(8);
        } else {
            getActivity();
            this.iME = new a() {
                public final void eH(boolean z) {
                }

                public final void aNh() {
                }

                public final void onDetached() {
                }

                public final void onResume() {
                }

                public final View aNi() {
                    return null;
                }

                public final void pS(int i) {
                }

                public final void pT(int i) {
                }
            };
        }
        this.iMF = new e(getContext(), this.iMv);
        this.iMF.eJ(true);
        this.iMv.setLoadingView(this.iMF.apJ);
        this.iMv.fh(false);
        this.iMv.setOnLoadingStateChangedListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a() {
            public final void aMC() {
                Object obj;
                AppMethodBeat.i(133337);
                e o = AppBrandLauncherRecentsList.this.iMF;
                if (o.iNB == null || !o.iNB.isShown()) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    AppMethodBeat.o(133337);
                    return;
                }
                AppBrandLauncherRecentsList.s(AppBrandLauncherRecentsList.this);
                AppMethodBeat.o(133337);
            }
        });
        aoX();
        FragmentActivity activity = getActivity();
        View inflate2 = View.inflate(activity, R.layout.ef, null);
        i iVar = new i(activity, R.style.df);
        iVar.setContentView(inflate2);
        iVar.setCancelable(true);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(new com.tencent.mm.plugin.appbrand.ui.d.AnonymousClass1(activity, iVar));
        this.iMU = iVar;
        this.iMU.show();
        this.iMG.iON = false;
        this.iMq.set(bo.anU());
        this.iLa.ae(new Runnable() {
            public final void run() {
                String str;
                int i;
                ArrayList arrayList = null;
                AppMethodBeat.i(133343);
                final ArrayList q = AppBrandLauncherRecentsList.this.iMo.q(com.tencent.mm.plugin.appbrand.app.f.auT().hap.gi(Long.MAX_VALUE));
                AppBrandLauncherRecentsList.this.iMA;
                int i2 = AppBrandLauncherRecentsList.this.gOW;
                String str2 = AppBrandLauncherRecentsList.this.iGQ;
                if (q == null || q.size() <= 0) {
                    str = null;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    i = 0;
                    for (int i3 = 0; i3 < q.size(); i3++) {
                        Object obj = q.get(i3);
                        if (obj instanceof AppBrandRecentTaskInfo) {
                            i++;
                            stringBuilder.append(((AppBrandRecentTaskInfo) obj).appId);
                            if (i == 20 || i >= q.size()) {
                                break;
                            }
                            stringBuilder.append(":#:");
                        }
                    }
                    str = stringBuilder.toString();
                }
                String str3 = "";
                are axq = q.axq();
                if (axq != null) {
                    i = axq.jsN;
                    str3 = axq.wuS;
                } else {
                    i = 0;
                }
                com.tencent.mm.plugin.appbrand.report.c.a(i2, "", str, i, str3, str2);
                if (AppBrandLauncherRecentsList.this.iMm) {
                    arrayList = new ArrayList(0);
                } else if (AppBrandLauncherRecentsList.this.iMl) {
                    arrayList = ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).a(com.tencent.mm.plugin.appbrand.appusage.af.a.ASC);
                }
                AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(133342);
                        AppBrandLauncherRecentsList.u(AppBrandLauncherRecentsList.this);
                        AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, arrayList, q, false);
                        AppMethodBeat.o(133342);
                    }
                });
                j.axh().a(AppBrandLauncherRecentsList.this.iMq.get(), true, AppBrandLauncherRecentsList.this.iMp, AppBrandLauncherRecentsList.this.iMH, AppBrandLauncherRecentsList.this.iMI);
                AppBrandLauncherRecentsList.this.iMs.set(true);
                AppMethodBeat.o(133343);
            }
        });
        AppMethodBeat.o(133405);
    }

    private void aoX() {
        AppMethodBeat.i(133406);
        if (this.iMU != null) {
            this.iMU.dismiss();
        }
        this.iMU = null;
        AppMethodBeat.o(133406);
    }

    static /* synthetic */ boolean c(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.i(133407);
        if (!appBrandLauncherRecentsList.iMx.isEmpty() || ((appBrandLauncherRecentsList.iME.aNi() != null && appBrandLauncherRecentsList.iME.aNi().getVisibility() == 0) || appBrandLauncherRecentsList.getActivity() == null)) {
            if (!(appBrandLauncherRecentsList.iMx == null || appBrandLauncherRecentsList.iMC == null)) {
                if (appBrandLauncherRecentsList.iMx.isEmpty()) {
                    appBrandLauncherRecentsList.iMC.setVisibility(8);
                } else {
                    appBrandLauncherRecentsList.iMC.setVisibility(0);
                }
            }
            f fVar;
            View childAt;
            if (appBrandLauncherRecentsList.iMx.isEmpty()) {
                if (appBrandLauncherRecentsList.iMD == null) {
                    appBrandLauncherRecentsList.iMD = AppBrandLauncherBlankPage.Y(appBrandLauncherRecentsList.getActivity(), appBrandLauncherRecentsList.getString(R.string.kj));
                    ((FrameLayout) appBrandLauncherRecentsList.WL).addView(appBrandLauncherRecentsList.iMD, 0);
                    ((MarginLayoutParams) appBrandLauncherRecentsList.iMD.getLayoutParams()).topMargin = appBrandLauncherRecentsList.iME.aNi().getMeasuredHeight();
                    appBrandLauncherRecentsList.iMD.requestLayout();
                }
                if (appBrandLauncherRecentsList.iME instanceof f) {
                    fVar = (f) appBrandLauncherRecentsList.iME;
                    if (fVar.ius.getChildCount() > 0) {
                        childAt = fVar.ius.getChildAt(fVar.ius.getChildCount() - 1);
                        if (childAt.getId() == R.id.s) {
                            childAt.setVisibility(4);
                        }
                    }
                }
                appBrandLauncherRecentsList.iMF.apJ.setVisibility(8);
                appBrandLauncherRecentsList.iMD.setVisibility(0);
            } else {
                if (appBrandLauncherRecentsList.iMD != null) {
                    appBrandLauncherRecentsList.iMD.setVisibility(8);
                }
                if (appBrandLauncherRecentsList.iME instanceof f) {
                    fVar = (f) appBrandLauncherRecentsList.iME;
                    if (fVar.ius.getChildCount() > 0) {
                        childAt = fVar.ius.getChildAt(fVar.ius.getChildCount() - 1);
                        if (childAt.getId() == R.id.s) {
                            childAt.setVisibility(0);
                        }
                    }
                }
                appBrandLauncherRecentsList.iMF.apJ.setVisibility(0);
            }
            AppMethodBeat.o(133407);
            return true;
        }
        ((com.tencent.mm.plugin.appbrand.ui.a.b) appBrandLauncherRecentsList.getActivity()).eE(false);
        AppMethodBeat.o(133407);
        return false;
    }

    static /* synthetic */ void s(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.i(133411);
        if (appBrandLauncherRecentsList.iMK && !appBrandLauncherRecentsList.iMs.get()) {
            appBrandLauncherRecentsList.iMr.set(bo.anU());
            if (j.axi()) {
                j.axh().a(appBrandLauncherRecentsList.iMr.get(), false, appBrandLauncherRecentsList.iMp, appBrandLauncherRecentsList.iMH, appBrandLauncherRecentsList.iMI);
                appBrandLauncherRecentsList.iMs.set(true);
                AppMethodBeat.o(133411);
                return;
            }
            ArrayList aNx = appBrandLauncherRecentsList.iMy.aNx();
            final long j = bo.ek(aNx) ? Long.MAX_VALUE : ((AppBrandRecentTaskInfo) aNx.get(aNx.size() - 1)).updateTime;
            appBrandLauncherRecentsList.iLa.aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133339);
                    final ArrayList q = AppBrandLauncherRecentsList.this.iMo.q(com.tencent.mm.plugin.appbrand.app.f.auT().hap.gi(j));
                    a.a(AppBrandLauncherRecentsList.this.iMz);
                    AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(1, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(133338);
                            if (AppBrandLauncherRecentsList.this.iMv == null || !android.support.v4.view.s.av(AppBrandLauncherRecentsList.this.iMv)) {
                                AppMethodBeat.o(133338);
                            } else if (AppBrandLauncherRecentsList.this.iMv.jz()) {
                                AppBrandLauncherRecentsList.this.iMz.obtainMessage(2, this).sendToTarget();
                                AppMethodBeat.o(133338);
                            } else {
                                AppBrandLauncherRecentsList.a(AppBrandLauncherRecentsList.this, q);
                                AppMethodBeat.o(133338);
                            }
                        }
                    }));
                    AppMethodBeat.o(133339);
                }
            });
        }
        AppMethodBeat.o(133411);
    }

    static /* synthetic */ void u(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.i(133412);
        p.ayH().a(appBrandLauncherRecentsList.iMQ, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        com.tencent.mm.plugin.appbrand.app.f.auT().a(appBrandLauncherRecentsList.iMP, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        if (appBrandLauncherRecentsList.iMl) {
            ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).a(appBrandLauncherRecentsList.iMO, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        }
        j.axh().a(appBrandLauncherRecentsList.iMR, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        AppMethodBeat.o(133412);
    }
}
