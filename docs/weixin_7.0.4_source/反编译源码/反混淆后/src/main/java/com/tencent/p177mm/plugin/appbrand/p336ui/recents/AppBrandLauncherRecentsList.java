package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.p075h.C44964d;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31879f.C17477a;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C38114b;
import com.tencent.p177mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26769j;
import com.tencent.p177mm.plugin.appbrand.appusage.C26776r.C26778d;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.appusage.C26783t;
import com.tencent.p177mm.plugin.appbrand.appusage.C42374al;
import com.tencent.p177mm.plugin.appbrand.appusage.C42382q;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherBlankPage;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI.Fragment;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.p336ui.C45702d.C385321;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C19766b;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C27336a.C273371;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C19692e;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.C11052a;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.protocal.protobuf.are;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList */
public final class AppBrandLauncherRecentsList extends Fragment {
    private int huR;
    private final C5004al iLa;
    private final C10917r iMA;
    private C10896d iMB;
    private View iMC;
    private View iMD;
    private C27336a iME;
    private C33563e iMF;
    private final C38536p iMG;
    private int iMH;
    private int iMI;
    private boolean iMJ;
    private boolean iMK;
    private String iML;
    private final C44964d iMM;
    private final C10911b iMN;
    private final C4931a iMO;
    private final C4931a iMP;
    private final C4931a iMQ;
    private final C4931a iMR;
    private final C10893c iMS;
    private boolean iMT;
    private Dialog iMU;
    private final int iMk;
    private final boolean iMl;
    private final boolean iMm;
    private final boolean iMn;
    private final C2507k iMo;
    private final Bundle iMp;
    private final AtomicLong iMq;
    private final AtomicLong iMr;
    private final AtomicBoolean iMs;
    private final AtomicLong iMt;
    private final AtomicBoolean iMu;
    private LoadMoreRecyclerView iMv;
    private LinearLayoutManager iMw;
    private C27341t iMx;
    private final C33566m iMy;
    private final C10898a iMz;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$e */
    final class C10878e extends C41531v implements OnClickListener, OnCreateContextMenuListener, C5279d {
        View goc;
        TextView iNn;
        TextView iNo;
        TextView iNp;
        TextView iNq;
        ImageView iNr;
        View iNs;
        C24088a iNt;
        final int iNu = 1;
        final int iNv = 2;

        C10878e(View view) {
            super(view);
            AppMethodBeat.m2504i(133387);
            this.goc = view.findViewById(2131821128);
            this.iNn = (TextView) view.findViewById(2131820649);
            this.iNo = (TextView) view.findViewById(2131821186);
            this.iNp = (TextView) view.findViewById(2131821153);
            this.iNq = (TextView) view.findViewById(2131821225);
            this.iNr = (ImageView) view.findViewById(2131820915);
            this.iNs = view.findViewById(2131821224);
            view.setOnClickListener(this);
            this.iNt = new C24088a(this.apJ.getContext()) {
                /* renamed from: dn */
                public final boolean mo22431dn(int i, int i2) {
                    AppMethodBeat.m2504i(133382);
                    if (C10878e.this.apJ.getParent() != null) {
                        C10878e.this.apJ.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    boolean dn = super.mo22431dn(i, i2);
                    AppMethodBeat.m2505o(133382);
                    return dn;
                }

                public final void onDismiss() {
                    AppMethodBeat.m2504i(133383);
                    if (C10878e.this.apJ.getParent() != null) {
                        C10878e.this.apJ.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    super.onDismiss();
                    AppMethodBeat.m2505o(133383);
                }
            };
            this.iNt.mo39887c(this.apJ, this, this);
            AppMethodBeat.m2505o(133387);
        }

        private int aNp() {
            AppMethodBeat.m2504i(133388);
            int S = AppBrandLauncherRecentsList.this.iMv.mo61462S(this);
            AppMethodBeat.m2505o(133388);
            return S;
        }

        /* Access modifiers changed, original: final */
        public final AppBrandRecentTaskInfo aNq() {
            AppMethodBeat.m2504i(133389);
            try {
                AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) AppBrandLauncherRecentsList.this.iMx.mo45022pW(aNp());
                AppMethodBeat.m2505o(133389);
                return appBrandRecentTaskInfo;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e, "getAppInfo", new Object[0]);
                AppMethodBeat.m2505o(133389);
                return null;
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(133390);
            AppBrandRecentTaskInfo aNq = aNq();
            if (aNq == null) {
                AppMethodBeat.m2505o(133390);
                return;
            }
            if (AppBrandLauncherRecentsList.this.iMl) {
                contextMenu.add(0, 1, 0, this.apJ.getContext().getString(aNq.had ? C25738R.string.f9068od : C25738R.string.f9065oa));
            }
            contextMenu.add(0, 2, 0, this.apJ.getContext().getString(C25738R.string.f8952kl));
            AppMethodBeat.m2505o(133390);
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(133391);
            final AppBrandRecentTaskInfo aNq = aNq();
            if (aNq == null || menuItem == null) {
                AppMethodBeat.m2505o(133391);
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
                aLd = C19692e.aLd();
            } else {
                if (TextUtils.isEmpty(AppBrandLauncherRecentsList.this.iML)) {
                    AppBrandLauncherRecentsList.this.iML = C19692e.aLc();
                }
                aLd = AppBrandLauncherRecentsList.this.iML;
            }
            if (1 != menuItem.getItemId()) {
                if (2 == menuItem.getItemId()) {
                    if (aNq.had && !AppBrandLauncherRecentsList.this.iMm) {
                        AppBrandLauncherRecentsList.this.iLa.mo10302aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(133386);
                                ((C26779s) C42340f.m74878E(C26779s.class)).mo44556j(aNq.csl, aNq.gVs, true);
                                C19692e.m30513a(aNq, 7, i2, aLd);
                                AppMethodBeat.m2505o(133386);
                            }
                        });
                    }
                    AppBrandLauncherRecentsList.this.iMy.mo54063pV(aNp());
                    AppBrandLauncherRecentsList.this.iMG.iON = true;
                    AppBrandLauncherRecentsList.this.iMN.aNo();
                    AppBrandLauncherRecentsList.this.iMx.mo66318ci(aNp());
                    AppBrandLauncherRecentsList.m18589c(AppBrandLauncherRecentsList.this);
                    C42374al.m74967j(aNq.csl, aNq.appId, aNq.gVs);
                }
                AppMethodBeat.m2505o(133391);
            } else if (AppBrandLauncherRecentsList.this.iMm || AppBrandLauncherRecentsList.this.iMy.aNw().size() < AppBrandLauncherRecentsList.this.iMk || aNq.had) {
                AppBrandLauncherRecentsList.this.iLa.mo10302aa(new Runnable() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$e$2$1 */
                    class C108811 implements Runnable {
                        C108811() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(133384);
                            C30379h.m48447a(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.getResources().getString(C25738R.string.f8875ht, new Object[]{Integer.valueOf(AppBrandLauncherRecentsList.this.iMk)}), "", AppBrandLauncherRecentsList.this.getResources().getString(C25738R.string.f9187s6), false, null);
                            AppMethodBeat.m2505o(133384);
                        }
                    }

                    public final void run() {
                        int i;
                        AppMethodBeat.m2504i(133385);
                        if (aNq.had) {
                            ((C26779s) C42340f.m74878E(C26779s.class)).mo44556j(aNq.csl, aNq.gVs, true);
                            if (!AppBrandLauncherRecentsList.this.iMm && AppBrandLauncherRecentsList.this.iMl) {
                                C42340f.auT().mo73330a(aNq.csl, aNq.gVs, false, 0, 2, null);
                            }
                            i = 7;
                        } else {
                            i = ((C26779s) C42340f.m74878E(C26779s.class)).mo44552aG(aNq.csl, aNq.gVs);
                            if (i == -2) {
                                AppBrandLauncherRecentsList.this.runOnUiThread(new C108811());
                                AppMethodBeat.m2505o(133385);
                                return;
                            } else if (i == -1) {
                                C4990ab.m7413e("MicroMsg.AppBrandLauncherRecentsList", "addStarApp, username %s, type %d, fatal", aNq.csl, Integer.valueOf(aNq.gVs));
                                AppMethodBeat.m2505o(133385);
                                return;
                            } else {
                                i = 6;
                            }
                        }
                        C19692e.m30513a(aNq, i, i2, aLd);
                        AppMethodBeat.m2505o(133385);
                    }
                });
                AppBrandLauncherRecentsList.this.iMG.iON = true;
                AppMethodBeat.m2505o(133391);
            } else {
                if (AppBrandLauncherRecentsList.this.getActivity() != null) {
                    C30379h.m48447a(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.getResources().getString(C25738R.string.f8875ht, new Object[]{Integer.valueOf(AppBrandLauncherRecentsList.this.iMk)}), "", AppBrandLauncherRecentsList.this.getResources().getString(C25738R.string.f9187s6), false, null);
                }
                AppMethodBeat.m2505o(133391);
            }
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133392);
            AppBrandRecentTaskInfo aNq = aNq();
            if (aNq == null) {
                AppMethodBeat.m2505o(133392);
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
            AppBrandLaunchProxyUI.m25693a(AppBrandLauncherRecentsList.this.getActivity(), aNq.csl, null, aNq.gVs, -1, appBrandStatObject, null, null);
            if (AppBrandLauncherRecentsList.this.getActivity() != null && (AppBrandLauncherRecentsList.this.getActivity() instanceof AppBrandLauncherUI)) {
                C26778d c26778d = ((AppBrandLauncherUI) AppBrandLauncherRecentsList.this.getActivity()).iGM;
                if (c26778d != null) {
                    c26778d.haa[7] = "1";
                }
            }
            AppMethodBeat.m2505o(133392);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$f */
    final class C10882f extends C41530m implements Runnable {
        private C10882f() {
        }

        /* synthetic */ C10882f(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(133393);
            AppBrandLauncherRecentsList.this.iMJ = i == 2;
            if (i == 0) {
                AppBrandLauncherRecentsList.this.mo17545N(this);
            }
            AppMethodBeat.m2505o(133393);
        }

        public final void run() {
            AppMethodBeat.m2504i(133394);
            if (!(AppBrandLauncherRecentsList.this.iMv == null || AppBrandLauncherRecentsList.this.iMw == null || AppBrandLauncherRecentsList.this.iMx == null || AppBrandLauncherRecentsList.this.iMB == null)) {
                int iQ = AppBrandLauncherRecentsList.this.iMw.mo1780iQ();
                int iS = AppBrandLauncherRecentsList.this.iMw.mo1782iS();
                for (int i = iQ; i <= iS; i++) {
                    C41531v cf = AppBrandLauncherRecentsList.this.iMv.mo66357cf(i);
                    if (cf instanceof C10878e) {
                        AppBrandRecentTaskInfo aNq = ((C10878e) cf).aNq();
                        if (aNq != null) {
                            AppBrandLauncherRecentsList.this.iMB.mo22452b((C10878e) cf, aNq.hac);
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(133394);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$11 */
    class C1088311 implements Runnable {
        C1088311() {
        }

        public final void run() {
            String str;
            int i;
            ArrayList arrayList = null;
            AppMethodBeat.m2504i(133343);
            final ArrayList q = AppBrandLauncherRecentsList.this.iMo.mo6448q(C42340f.auT().hap.mo60877gi(Long.MAX_VALUE));
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
            are axq = C42382q.axq();
            if (axq != null) {
                i = axq.jsN;
                str3 = axq.wuS;
            } else {
                i = 0;
            }
            C19690c.m30495a(i2, "", str, i, str3, str2);
            if (AppBrandLauncherRecentsList.this.iMm) {
                arrayList = new ArrayList(0);
            } else if (AppBrandLauncherRecentsList.this.iMl) {
                arrayList = ((C26779s) C42340f.m74878E(C26779s.class)).mo44549a(C10117a.ASC);
            }
            AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133342);
                    AppBrandLauncherRecentsList.m18607u(AppBrandLauncherRecentsList.this);
                    AppBrandLauncherRecentsList.m18585a(AppBrandLauncherRecentsList.this, arrayList, q, false);
                    AppMethodBeat.m2505o(133342);
                }
            });
            C26769j.axh().mo44541a(AppBrandLauncherRecentsList.this.iMq.get(), true, AppBrandLauncherRecentsList.this.iMp, AppBrandLauncherRecentsList.this.iMH, AppBrandLauncherRecentsList.this.iMI);
            AppBrandLauncherRecentsList.this.iMs.set(true);
            AppMethodBeat.m2505o(133343);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$15 */
    class C1088815 implements C44964d {
        C1088815() {
        }

        /* renamed from: G */
        public final void mo1469G(int i, int i2) {
            AppMethodBeat.m2504i(133348);
            AppBrandLauncherRecentsList.this.iMx.mo66310at(i, i2);
            AppMethodBeat.m2505o(133348);
        }

        /* renamed from: H */
        public final void mo1470H(int i, int i2) {
            AppMethodBeat.m2504i(133349);
            AppBrandLauncherRecentsList.this.iMN.aNo();
            AppBrandLauncherRecentsList.this.iMx.mo66311au(i, i2);
            AppMethodBeat.m2505o(133349);
        }

        /* renamed from: I */
        public final void mo1471I(int i, int i2) {
            AppMethodBeat.m2504i(133350);
            AppBrandLauncherRecentsList.this.iMN.aNo();
            AppBrandLauncherRecentsList.this.iMx.mo66309as(i, i2);
            AppMethodBeat.m2505o(133350);
        }

        /* renamed from: a */
        public final void mo1472a(int i, int i2, Object obj) {
            AppMethodBeat.m2504i(133351);
            AppBrandLauncherRecentsList.this.iMx.mo66315c(i, i2, obj);
            AppMethodBeat.m2505o(133351);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$1 */
    class C108891 implements Runnable {
        C108891() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133329);
            int size = AppBrandLauncherRecentsList.this.iMy.size();
            if (size > 0) {
                AppBrandLauncherRecentsList.this.iMy.clear();
                AppBrandLauncherRecentsList.this.iMx.mo66311au(0, size);
            }
            AppBrandLauncherRecentsList.m18589c(AppBrandLauncherRecentsList.this);
            AppMethodBeat.m2505o(133329);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$2 */
    class C108902 implements IdleHandler {
        C108902() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(133330);
            Looper.myQueue().removeIdleHandler(this);
            if (!(AppBrandLauncherRecentsList.this.iMT || AppBrandLauncherRecentsList.this.iMv == null)) {
                try {
                    AppBrandLauncherRecentsList.this.iMv.setLayoutFrozen(true);
                } catch (IllegalStateException e) {
                }
            }
            AppMethodBeat.m2505o(133330);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$3 */
    class C108913 extends LinearLayoutManager {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$3$1 */
        class C108921 implements Runnable {
            C108921() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133331);
                try {
                    AppBrandLauncherRecentsList.this.iMx.aop.notifyChanged();
                    AppMethodBeat.m2505o(133331);
                } catch (IllegalStateException e) {
                    C4990ab.m7421w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged after scroll e=%s", e);
                    AppMethodBeat.m2505o(133331);
                }
            }
        }

        C108913() {
            super(1);
        }

        /* renamed from: a */
        public final void mo1755a(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(133332);
            C33569q c33569q = new C33569q(AppBrandLauncherRecentsList.this.getActivity(), AppBrandLauncherRecentsList.this.iMw);
            c33569q.ape = i;
            mo31829a((C37139r) c33569q);
            AppMethodBeat.m2505o(133332);
        }

        /* renamed from: iE */
        public final boolean mo1774iE() {
            return false;
        }

        /* renamed from: c */
        public final void mo1765c(C25374o c25374o, C31880s c31880s) {
            AppMethodBeat.m2504i(133333);
            try {
                super.mo1765c(c25374o, c31880s);
                AppMethodBeat.m2505o(133333);
            } catch (IndexOutOfBoundsException e) {
                C4990ab.m7420w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren IndexOutOfBoundsException retry notifyDataSetChanged");
                try {
                    AppBrandLauncherRecentsList.this.iMx.aop.notifyChanged();
                    AppMethodBeat.m2505o(133333);
                } catch (IllegalStateException e2) {
                    C4990ab.m7421w("MicroMsg.AppBrandLauncherRecentsList", "onLayoutChildren retry notifyDataSetChanged e=%s", e2);
                    if (C5046bo.nullAsNil(e2.getMessage()).contains("computing a layout or scrolling")) {
                        AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(2, new C108921()));
                    }
                    AppMethodBeat.m2505o(133333);
                }
            }
        }

        /* renamed from: b */
        public final int mo1759b(int i, C25374o c25374o, C31880s c31880s) {
            int i2 = 0;
            AppMethodBeat.m2504i(138699);
            try {
                i2 = super.mo1759b(i, c25374o, c31880s);
                AppMethodBeat.m2505o(138699);
            } catch (IndexOutOfBoundsException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandLauncherRecentsList", e, "scrollVerticallyBy(%d, %s)", Integer.valueOf(i), c31880s);
                AppMethodBeat.m2505o(138699);
            }
            return i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$c */
    final class C10893c extends C41525c implements C17477a {
        private C10893c() {
        }

        /* synthetic */ C10893c(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        /* renamed from: aw */
        public final void mo18473aw(int i, int i2) {
            AppMethodBeat.m2504i(133368);
            m18621eI(false);
            AppMethodBeat.m2505o(133368);
        }

        /* renamed from: ax */
        public final void mo6644ax(int i, int i2) {
            AppMethodBeat.m2504i(133369);
            m18621eI(true);
            AppMethodBeat.m2505o(133369);
        }

        /* renamed from: ay */
        public final void mo18474ay(int i, int i2) {
            AppMethodBeat.m2504i(133370);
            m18621eI(false);
            AppMethodBeat.m2505o(133370);
        }

        /* renamed from: jT */
        public final void mo22448jT() {
            AppMethodBeat.m2504i(133371);
            m18621eI(false);
            AppMethodBeat.m2505o(133371);
        }

        /* renamed from: eI */
        private void m18621eI(final boolean z) {
            AppMethodBeat.m2504i(133372);
            AppBrandLauncherRecentsList.this.mo17545N(new Runnable() {
                public final void run() {
                    int i = 1;
                    int i2 = 0;
                    AppMethodBeat.m2504i(133367);
                    if (!(AppBrandLauncherRecentsList.this.iMx.isEmpty() || AppBrandLauncherRecentsList.this.iMx == null)) {
                        try {
                            AppBrandLauncherRecentsList.this.iMx.mo66316cg(AppBrandLauncherRecentsList.this.iMx.getItemCount() - 1);
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.AppBrandLauncherRecentsList", "adjustListBottomDivider notifyItemChanged e=%s", e);
                        }
                    }
                    if (AppBrandLauncherRecentsList.this.iMF != null) {
                        C33563e o = AppBrandLauncherRecentsList.this.iMF;
                        if (z || AppBrandLauncherRecentsList.this.iMx.isEmpty()) {
                            i = 0;
                        }
                        View view = o.iNC;
                        if (i == 0) {
                            i2 = 4;
                        }
                        C42696n.m75614H(view, i2);
                    }
                    AppMethodBeat.m2505o(133367);
                }
            });
            AppMethodBeat.m2505o(133372);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$9 */
    class C108959 implements Runnable {
        C108959() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133340);
            if (AppBrandLauncherRecentsList.this.iMF.apJ == null || AppBrandLauncherRecentsList.this.iMF.apJ.getHeight() <= 0 || AppBrandLauncherRecentsList.this.iMv == null) {
                AppMethodBeat.m2505o(133340);
                return;
            }
            try {
                AppBrandLauncherRecentsList.this.iMv.scrollBy(0, AppBrandLauncherRecentsList.this.iMF.apJ.getHeight());
                AppMethodBeat.m2505o(133340);
            } catch (IndexOutOfBoundsException e) {
                C4990ab.m7413e("MicroMsg.AppBrandLauncherRecentsList", "makeFooterFullyVisible scrollBy e=%s", e);
                AppMethodBeat.m2505o(133340);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$d */
    final class C10896d extends C42699u<AppBrandRecentTaskInfo, C10878e> {
        final Map<String, String> iNm;

        private C10896d() {
            AppMethodBeat.m2504i(133373);
            this.iNm = new HashMap();
            AppMethodBeat.m2505o(133373);
        }

        /* synthetic */ C10896d(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        /* renamed from: bA */
        public final /* synthetic */ long mo22454bA(Object obj) {
            AppMethodBeat.m2504i(133379);
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) obj;
            long hashCode = (long) (appBrandRecentTaskInfo.csl + appBrandRecentTaskInfo.gVs).hashCode();
            AppMethodBeat.m2505o(133379);
            return hashCode;
        }

        /* renamed from: c */
        public final /* synthetic */ void mo22455c(C41531v c41531v, Object obj) {
            AppMethodBeat.m2504i(133380);
            C10878e c10878e = (C10878e) c41531v;
            AppBrandRecentTaskInfo appBrandRecentTaskInfo = (AppBrandRecentTaskInfo) obj;
            c10878e.iNo.setVisibility(8);
            c10878e.goc.setVisibility(0);
            C10896d.m18627a(c10878e, C5046bo.isNullOrNil(appBrandRecentTaskInfo.appName) ? appBrandRecentTaskInfo.csl.replaceFirst("@app", "") : appBrandRecentTaskInfo.appName);
            mo22452b(c10878e, appBrandRecentTaskInfo.hac);
            m18628a(c10878e, appBrandRecentTaskInfo.had);
            String no = C38114b.m64485no(appBrandRecentTaskInfo.gVs);
            if (C5046bo.isNullOrNil(no)) {
                c10878e.iNp.setVisibility(8);
            } else {
                c10878e.iNp.setText(no);
                c10878e.iNp.setVisibility(0);
            }
            m18626a(c10878e);
            AppMethodBeat.m2505o(133380);
        }

        /* renamed from: a */
        private void m18626a(C10878e c10878e) {
            AppMethodBeat.m2504i(133374);
            AppBrandLauncherRecentsList.this.iMv;
            if (RecyclerView.m72547bo(c10878e.apJ) == AppBrandLauncherRecentsList.this.iMx.getItemCount() - 1) {
                c10878e.goc.setVisibility(8);
            } else {
                c10878e.goc.setVisibility(0);
            }
            if (AppBrandLauncherRecentsList.this.iMn) {
                TextView textView = c10878e.iNq;
                AppBrandLauncherRecentsList.this.iMv;
                textView.setText(String.valueOf(RecyclerView.m72547bo(c10878e.apJ)));
                c10878e.iNq.setVisibility(0);
                AppMethodBeat.m2505o(133374);
                return;
            }
            c10878e.iNq.setVisibility(8);
            AppMethodBeat.m2505o(133374);
        }

        /* renamed from: a */
        private void m18628a(C10878e c10878e, boolean z) {
            AppMethodBeat.m2504i(133375);
            View view = c10878e.iNs;
            int i = (AppBrandLauncherRecentsList.this.iMl && z) ? 0 : 8;
            view.setVisibility(i);
            AppMethodBeat.m2505o(133375);
        }

        /* renamed from: a */
        private static void m18627a(C10878e c10878e, String str) {
            AppMethodBeat.m2504i(133376);
            c10878e.iNn.setText(str);
            AppMethodBeat.m2505o(133376);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: b */
        public final void mo22452b(C10878e c10878e, String str) {
            AppMethodBeat.m2504i(133377);
            AppBrandLauncherRecentsList.this.iMJ;
            this.iNm.put(str, C37926b.abR().mo60683a(c10878e.iNr, str, C32804a.abQ(), C42201f.fqH));
            AppMethodBeat.m2505o(133377);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$g */
    final class C10897g extends C25373h {
        private C10897g() {
        }

        /* synthetic */ C10897g(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo18495a(Rect rect, View view, RecyclerView recyclerView, C31880s c31880s) {
            AppMethodBeat.m2504i(133395);
            rect.left = 0;
            rect.right = 0;
            rect.bottom = 0;
            rect.top = 0;
            if (recyclerView instanceof MRecyclerView) {
                C41531v aZ = recyclerView.mo66337aZ(view);
                if (aZ instanceof C10878e) {
                    C42696n.m75614H(((C10878e) aZ).goc, ((MRecyclerView) recyclerView).mo61462S(aZ) == AppBrandLauncherRecentsList.this.iMx.getItemCount() + -1 ? 8 : 0);
                }
            }
            AppMethodBeat.m2505o(133395);
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$a */
    final class C10898a extends Handler {
        /* renamed from: a */
        static /* synthetic */ void m18635a(C10898a c10898a) {
            AppMethodBeat.m2504i(133363);
            c10898a.aNn();
            AppMethodBeat.m2505o(133363);
        }

        public C10898a() {
            super(Looper.getMainLooper());
            AppMethodBeat.m2504i(133360);
            AppMethodBeat.m2505o(133360);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(133361);
            if (message.what == 1) {
                ((Runnable) message.obj).run();
                removeMessages(2);
                AppMethodBeat.m2505o(133361);
            } else if (message.what == 2) {
                ((Runnable) message.obj).run();
                AppMethodBeat.m2505o(133361);
            } else {
                super.handleMessage(message);
                AppMethodBeat.m2505o(133361);
            }
        }

        private void aNn() {
            AppMethodBeat.m2504i(133362);
            removeMessages(1);
            removeMessages(2);
            AppMethodBeat.m2505o(133362);
        }

        /* renamed from: b */
        static /* synthetic */ void m18636b(C10898a c10898a) {
            AppMethodBeat.m2504i(133364);
            c10898a.aNn();
            AppMethodBeat.m2505o(133364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$10 */
    class C1089910 implements Runnable {
        C1089910() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133341);
            AppBrandLauncherRecentsList.m18605s(AppBrandLauncherRecentsList.this);
            AppMethodBeat.m2505o(133341);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$16 */
    class C1090016 implements C4931a {
        C1090016() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(133352);
            if ("single".equals(str)) {
                if ((5 == c4935m.hsh && AppBrandLauncherRecentsList.this.iMm) || 2 == c4935m.hsh || 3 == c4935m.hsh) {
                    C4990ab.m7411d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, event %d", Integer.valueOf(c4935m.hsh));
                    AppBrandLauncherRecentsList.m18586a(AppBrandLauncherRecentsList.this, false, -1, true);
                    AppMethodBeat.m2505o(133352);
                    return;
                }
            } else if ("batch".equals(str) && 3 == c4935m.hsh) {
                Object obj = c4935m.obj;
                if ((obj instanceof Long) && ((Long) obj).longValue() == AppBrandLauncherRecentsList.this.iMq.get()) {
                    AppMethodBeat.m2505o(133352);
                    return;
                } else {
                    C4990ab.m7410d("MicroMsg.AppBrandLauncherRecentsList", "onStarRecordModified, batch update");
                    AppBrandLauncherRecentsList.m18586a(AppBrandLauncherRecentsList.this, false, Long.MAX_VALUE, true);
                }
            }
            AppMethodBeat.m2505o(133352);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$17 */
    class C1090117 implements C4931a {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$17$1 */
        class C109021 implements Runnable {
            C109021() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133353);
                if (AppBrandLauncherRecentsList.this.iMv.anv) {
                    AppBrandLauncherRecentsList.this.iMG.iON = false;
                }
                AppMethodBeat.m2505o(133353);
            }
        }

        C1090117() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(133354);
            if ("single".equals(str) && (3 == c4935m.hsh || 2 == c4935m.hsh)) {
                AppBrandLauncherRecentsList.this.runOnUiThread(new C109021());
                C4990ab.m7410d("MicroMsg.AppBrandLauncherRecentsList", "onHistoryRecordModified");
                AppBrandLauncherRecentsList.m18586a(AppBrandLauncherRecentsList.this, true, Long.MAX_VALUE, false);
            }
            AppMethodBeat.m2505o(133354);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$18 */
    class C1090318 implements C4931a {
        C1090318() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(133355);
            C4990ab.m7411d("MicroMsg.AppBrandLauncherRecentsList", "onContactUpdate %s", str);
            AppBrandLauncherRecentsList.m18586a(AppBrandLauncherRecentsList.this, false, -1, false);
            AppMethodBeat.m2505o(133355);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$19 */
    class C1090419 implements C4931a {
        C1090419() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(133358);
            try {
                if (c4935m.obj != null && (c4935m.obj instanceof Long)) {
                    List gi;
                    long j = AppBrandLauncherRecentsList.this.iMq.get();
                    C4990ab.m7411d("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack ticket %d, mInitFetchTicket %d, mPagingFetchTicket %d", (Long) c4935m.obj, Long.valueOf(j), Long.valueOf(AppBrandLauncherRecentsList.this.iMr.get()));
                    if (c4935m.obj.equals(Long.valueOf(j))) {
                        gi = C42340f.auT().hap.mo60877gi(Long.MAX_VALUE);
                    } else {
                        Object gi2 = C42340f.auT().hap.mo60877gi(AppBrandLauncherRecentsList.this.iMt.get());
                    }
                    if (!C5046bo.m7548ek(gi2)) {
                        AppBrandLauncherRecentsList.this.iMt.set(((AppBrandRecentTaskInfo) gi2.get(gi2.size() - 1)).updateTime);
                    }
                    final ArrayList q = AppBrandLauncherRecentsList.this.iMo.mo6448q(gi2);
                    if (c4935m.obj.equals(Long.valueOf(j))) {
                        ArrayList arrayList = AppBrandLauncherRecentsList.this.iMm ? new ArrayList(0) : AppBrandLauncherRecentsList.this.iMl ? C42340f.auU().mo44549a(C10117a.ASC) : null;
                        AppBrandLauncherRecentsList.this.runOnUiThread(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(133356);
                                AppBrandLauncherRecentsList.m18585a(AppBrandLauncherRecentsList.this, arrayList, q, true);
                                AppMethodBeat.m2505o(133356);
                            }
                        });
                        AppMethodBeat.m2505o(133358);
                        return;
                    } else if (c4935m.obj.equals(Long.valueOf(r4))) {
                        C10898a.m18635a(AppBrandLauncherRecentsList.this.iMz);
                        AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(1, new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(133357);
                                if (AppBrandLauncherRecentsList.this.iMv == null || !AppBrandLauncherRecentsList.this.iMv.isAttachedToWindow()) {
                                    AppMethodBeat.m2505o(133357);
                                } else if (AppBrandLauncherRecentsList.this.iMv.mo66406jz()) {
                                    AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(2, this));
                                    AppMethodBeat.m2505o(133357);
                                } else {
                                    AppBrandLauncherRecentsList.m18584a(AppBrandLauncherRecentsList.this, q);
                                    AppMethodBeat.m2505o(133357);
                                }
                            }
                        }));
                    }
                }
                AppMethodBeat.m2505o(133358);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandLauncherRecentsList", "onPagingDataBack e %s", e);
                AppMethodBeat.m2505o(133358);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$5 */
    class C109075 implements Runnable {
        C109075() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133335);
            if (AppBrandLauncherRecentsList.this.iMv.computeVerticalScrollOffset() == 0) {
                AppBrandLauncherRecentsList.this.iMv.scrollBy(0, AppBrandLauncherRecentsList.this.iMC.getTop());
            }
            AppMethodBeat.m2505o(133335);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$7 */
    class C109097 implements C11052a {
        C109097() {
        }

        public final void aMC() {
            Object obj;
            AppMethodBeat.m2504i(133337);
            C33563e o = AppBrandLauncherRecentsList.this.iMF;
            if (o.iNB == null || !o.iNB.isShown()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                AppMethodBeat.m2505o(133337);
                return;
            }
            AppBrandLauncherRecentsList.m18605s(AppBrandLauncherRecentsList.this);
            AppMethodBeat.m2505o(133337);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$20 */
    class C1091020 implements Runnable {
        C1091020() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133359);
            AppBrandLauncherRecentsList.m18589c(AppBrandLauncherRecentsList.this);
            AppMethodBeat.m2505o(133359);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.AppBrandLauncherRecentsList$b */
    final class C10911b implements C17477a {
        private C10911b() {
        }

        /* synthetic */ C10911b(AppBrandLauncherRecentsList appBrandLauncherRecentsList, byte b) {
            this();
        }

        /* renamed from: jT */
        public final void mo22448jT() {
            AppMethodBeat.m2504i(133365);
            AppBrandLauncherRecentsList.this.iMG.iOM = false;
            AppMethodBeat.m2505o(133365);
        }

        /* Access modifiers changed, original: final */
        public final void aNo() {
            AppMethodBeat.m2504i(133366);
            AppBrandLauncherRecentsList.this.iMG.iOM = true;
            AppMethodBeat.m2505o(133366);
        }
    }

    public AppBrandLauncherRecentsList() {
        this(true);
    }

    @SuppressLint({"ValidFragment"})
    public AppBrandLauncherRecentsList(boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.m2504i(133396);
        this.iMp = new Bundle();
        this.iMq = new AtomicLong(-1);
        this.iMr = new AtomicLong(-1);
        this.iMs = new AtomicBoolean(false);
        this.iMt = new AtomicLong(Long.MAX_VALUE);
        this.iMu = new AtomicBoolean(false);
        this.iMy = new C33566m();
        this.iLa = new C5004al("AppBrandLauncherUI#RecentsListUI");
        this.iMz = new C10898a();
        this.iMA = new C10917r();
        this.iMG = new C38536p();
        this.iMH = 3;
        this.iMI = 0;
        this.iMJ = false;
        this.iMK = false;
        this.iMM = new C1088815();
        this.iMN = new C10911b(this, (byte) 0);
        this.iMO = new C1090016();
        this.iMP = new C1090117();
        this.iMQ = new C1090318();
        this.iMR = new C1090419();
        this.iMS = new C10893c(this, (byte) 0);
        this.iMT = false;
        this.huR = 0;
        this.iMU = null;
        Bundle bundle = new Bundle(1);
        bundle.putBoolean("showHeader", z);
        setArguments(bundle);
        this.iMl = C26783t.axG();
        this.iMm = C26783t.axH();
        if (C5047bp.dpL() && C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_APP_BRAND_SHOW_HISTORY_COUNT_BOOLEAN, false)) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.iMn = z2;
        this.iMk = C26783t.axI();
        if (!this.iMl || this.iMm) {
            z3 = false;
        }
        this.iMo = new C2507k(z3);
        AppMethodBeat.m2505o(133396);
    }

    private boolean aNl() {
        AppMethodBeat.m2504i(133397);
        if (this.iMu.get()) {
            AppMethodBeat.m2505o(133397);
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            AppMethodBeat.m2505o(133397);
            return true;
        }
        AppMethodBeat.m2505o(133397);
        return false;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(133398);
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
            mo17545N(new C1091020());
        }
        AppMethodBeat.m2505o(133398);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(133399);
        this.iMT = false;
        super.onPause();
        try {
            if (this.iMv != null) {
                this.iMv.setLayoutFrozen(true);
            }
            AppMethodBeat.m2505o(133399);
        } catch (IllegalStateException e) {
            Looper.myQueue().addIdleHandler(new C108902());
            AppMethodBeat.m2505o(133399);
        }
    }

    public final void onDestroyView() {
        AppMethodBeat.m2504i(133400);
        super.onDestroyView();
        if (this.iME != null) {
            this.iME.onDetached();
        }
        if (this.iMF != null) {
            this.iMF.onDetached();
        }
        if (this.iMx != null) {
            this.iMx.mo66313b(this.iMS);
        }
        if (this.iMB != null) {
            this.iMB.iNm.clear();
            this.iMB = null;
        }
        if (C1720g.m3534RN().eJb && !C1668a.m3393QT()) {
            C26842p.ayH().mo10117d(this.iMQ);
            C42340f.auT().mo10117d(this.iMP);
            ((C26779s) C42340f.m74878E(C26779s.class)).mo10117d(this.iMO);
            C26769j.axh().mo10117d(this.iMR);
        }
        this.iLa.oAl.quit();
        this.iMq.set(-1);
        this.iMr.set(-1);
        this.iMs.set(false);
        this.iMt.set(Long.MAX_VALUE);
        this.iMG.mo61270c(this.iMS);
        this.iMG.mo61270c(this.iMN);
        AppMethodBeat.m2505o(133400);
    }

    public final void aMf() {
        AppMethodBeat.m2504i(133401);
        if (this.iMv != null) {
            this.iMv.smoothScrollToPosition(0);
        }
        AppMethodBeat.m2505o(133401);
    }

    public final void setScene(int i) {
        AppMethodBeat.m2504i(133402);
        super.setScene(i);
        this.iMp.putInt("launcher_ui_enter_scene", i);
        AppMethodBeat.m2505o(133402);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(133403);
        super.onDestroy();
        this.iMu.set(true);
        C10898a.m18636b(this.iMz);
        AppMethodBeat.m2505o(133403);
    }

    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.m2504i(133404);
        super.onActivityCreated(bundle);
        if (!(getActivity() == null || getActivity().getIntent() == null)) {
            this.iMH = getActivity().getIntent().getIntExtra("extra_get_usage_reason", this.iMH);
            this.iMI = getActivity().getIntent().getIntExtra("extra_get_usage_prescene", this.iMI);
        }
        AppMethodBeat.m2505o(133404);
    }

    public final void initView() {
        AppMethodBeat.m2504i(133405);
        getActivity();
        this.iMw = new C108913();
        this.iMw.mo31843an(false);
        this.iMv = new RecentsRecyclerView(getContext()) {
            public final LinearLayoutManager aNm() {
                AppMethodBeat.m2504i(133334);
                LinearLayoutManager q = AppBrandLauncherRecentsList.this.iMw;
                AppMethodBeat.m2505o(133334);
                return q;
            }
        };
        this.iMv.setVerticalScrollBarEnabled(true);
        ((FrameLayout) this.f2134WL).addView(this.iMv, new LayoutParams(-1, -1));
        this.iMv.mo66346b((C25373h) new C10897g(this, (byte) 0));
        this.iMv.setItemAnimator(this.iMG);
        this.iMG.mo61269b(this.iMS);
        this.iMG.mo61269b(this.iMN);
        C27341t c27341t = new C27341t(this.iMy);
        C10896d c10896d = new C10896d(this, (byte) 0);
        this.iMB = c10896d;
        c27341t.iPq.put(AppBrandRecentTaskInfo.class.hashCode(), c10896d);
        this.iMx = c27341t;
        this.iMx.mo66319jR();
        this.iMx.mo66307a((C41525c) this.iMS);
        this.iMv.setAdapter(this.iMx);
        this.iMv.mo66332a((C41530m) new C10882f(this, (byte) 0));
        if (getArguments() == null || getArguments().getBoolean("showHeader", true)) {
            this.iME = new C33565f(getActivity(), this.iMv, false, false);
            this.iMv.addHeaderView(this.iME.aNi());
            this.iME.aNi().setVisibility(8);
            this.iME.aNh();
            View inflate = LayoutInflater.from(getContext()).inflate(2130968715, this.iMv, false);
            this.iMv.addHeaderView(inflate);
            this.iMC = inflate;
            this.iMC.setVisibility(8);
        } else {
            getActivity();
            this.iME = new C273371();
        }
        this.iMF = new C33563e(getContext(), this.iMv);
        this.iMF.mo54046eJ(true);
        this.iMv.setLoadingView(this.iMF.apJ);
        this.iMv.mo22757fh(false);
        this.iMv.setOnLoadingStateChangedListener(new C109097());
        aoX();
        FragmentActivity activity = getActivity();
        View inflate2 = View.inflate(activity, 2130968766, null);
        C15532i c15532i = new C15532i(activity, C25738R.style.f10752df);
        c15532i.setContentView(inflate2);
        c15532i.setCancelable(true);
        c15532i.setCanceledOnTouchOutside(false);
        c15532i.setOnCancelListener(new C385321(activity, c15532i));
        this.iMU = c15532i;
        this.iMU.show();
        this.iMG.iON = false;
        this.iMq.set(C5046bo.anU());
        this.iLa.mo10303ae(new C1088311());
        AppMethodBeat.m2505o(133405);
    }

    private void aoX() {
        AppMethodBeat.m2504i(133406);
        if (this.iMU != null) {
            this.iMU.dismiss();
        }
        this.iMU = null;
        AppMethodBeat.m2505o(133406);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m18589c(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.m2504i(133407);
        if (!appBrandLauncherRecentsList.iMx.isEmpty() || ((appBrandLauncherRecentsList.iME.aNi() != null && appBrandLauncherRecentsList.iME.aNi().getVisibility() == 0) || appBrandLauncherRecentsList.getActivity() == null)) {
            if (!(appBrandLauncherRecentsList.iMx == null || appBrandLauncherRecentsList.iMC == null)) {
                if (appBrandLauncherRecentsList.iMx.isEmpty()) {
                    appBrandLauncherRecentsList.iMC.setVisibility(8);
                } else {
                    appBrandLauncherRecentsList.iMC.setVisibility(0);
                }
            }
            C33565f c33565f;
            View childAt;
            if (appBrandLauncherRecentsList.iMx.isEmpty()) {
                if (appBrandLauncherRecentsList.iMD == null) {
                    appBrandLauncherRecentsList.iMD = AppBrandLauncherBlankPage.m65230Y(appBrandLauncherRecentsList.getActivity(), appBrandLauncherRecentsList.getString(C25738R.string.f8950kj));
                    ((FrameLayout) appBrandLauncherRecentsList.f2134WL).addView(appBrandLauncherRecentsList.iMD, 0);
                    ((MarginLayoutParams) appBrandLauncherRecentsList.iMD.getLayoutParams()).topMargin = appBrandLauncherRecentsList.iME.aNi().getMeasuredHeight();
                    appBrandLauncherRecentsList.iMD.requestLayout();
                }
                if (appBrandLauncherRecentsList.iME instanceof C33565f) {
                    c33565f = (C33565f) appBrandLauncherRecentsList.iME;
                    if (c33565f.ius.getChildCount() > 0) {
                        childAt = c33565f.ius.getChildAt(c33565f.ius.getChildCount() - 1);
                        if (childAt.getId() == 2131820562) {
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
                if (appBrandLauncherRecentsList.iME instanceof C33565f) {
                    c33565f = (C33565f) appBrandLauncherRecentsList.iME;
                    if (c33565f.ius.getChildCount() > 0) {
                        childAt = c33565f.ius.getChildAt(c33565f.ius.getChildCount() - 1);
                        if (childAt.getId() == 2131820562) {
                            childAt.setVisibility(0);
                        }
                    }
                }
                appBrandLauncherRecentsList.iMF.apJ.setVisibility(0);
            }
            AppMethodBeat.m2505o(133407);
            return true;
        }
        ((C19766b) appBrandLauncherRecentsList.getActivity()).mo17538eE(false);
        AppMethodBeat.m2505o(133407);
        return false;
    }

    /* renamed from: s */
    static /* synthetic */ void m18605s(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.m2504i(133411);
        if (appBrandLauncherRecentsList.iMK && !appBrandLauncherRecentsList.iMs.get()) {
            appBrandLauncherRecentsList.iMr.set(C5046bo.anU());
            if (C26769j.axi()) {
                C26769j.axh().mo44541a(appBrandLauncherRecentsList.iMr.get(), false, appBrandLauncherRecentsList.iMp, appBrandLauncherRecentsList.iMH, appBrandLauncherRecentsList.iMI);
                appBrandLauncherRecentsList.iMs.set(true);
                AppMethodBeat.m2505o(133411);
                return;
            }
            ArrayList aNx = appBrandLauncherRecentsList.iMy.aNx();
            final long j = C5046bo.m7548ek(aNx) ? Long.MAX_VALUE : ((AppBrandRecentTaskInfo) aNx.get(aNx.size() - 1)).updateTime;
            appBrandLauncherRecentsList.iLa.mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133339);
                    final ArrayList q = AppBrandLauncherRecentsList.this.iMo.mo6448q(C42340f.auT().hap.mo60877gi(j));
                    C10898a.m18635a(AppBrandLauncherRecentsList.this.iMz);
                    AppBrandLauncherRecentsList.this.iMz.sendMessage(AppBrandLauncherRecentsList.this.iMz.obtainMessage(1, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(133338);
                            if (AppBrandLauncherRecentsList.this.iMv == null || !C0477s.m930av(AppBrandLauncherRecentsList.this.iMv)) {
                                AppMethodBeat.m2505o(133338);
                            } else if (AppBrandLauncherRecentsList.this.iMv.mo66406jz()) {
                                AppBrandLauncherRecentsList.this.iMz.obtainMessage(2, this).sendToTarget();
                                AppMethodBeat.m2505o(133338);
                            } else {
                                AppBrandLauncherRecentsList.m18584a(AppBrandLauncherRecentsList.this, q);
                                AppMethodBeat.m2505o(133338);
                            }
                        }
                    }));
                    AppMethodBeat.m2505o(133339);
                }
            });
        }
        AppMethodBeat.m2505o(133411);
    }

    /* renamed from: u */
    static /* synthetic */ void m18607u(AppBrandLauncherRecentsList appBrandLauncherRecentsList) {
        AppMethodBeat.m2504i(133412);
        C26842p.ayH().mo10114a(appBrandLauncherRecentsList.iMQ, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        C42340f.auT().mo10114a(appBrandLauncherRecentsList.iMP, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        if (appBrandLauncherRecentsList.iMl) {
            ((C26779s) C42340f.m74878E(C26779s.class)).mo10114a(appBrandLauncherRecentsList.iMO, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        }
        C26769j.axh().mo10114a(appBrandLauncherRecentsList.iMR, appBrandLauncherRecentsList.iLa.oAl.getLooper());
        AppMethodBeat.m2505o(133412);
    }
}
