package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.PointF;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.GridLayoutManager.C8440b;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25374o;
import android.support.p069v7.widget.RecyclerView.C31880s;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.support.p069v7.widget.RecyclerView.LayoutParams;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.appbrand.appcache.C38114b;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26767ag;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19692e;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.C42706a;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.C42707b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.RecentAppBrandView.C10948b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.p1643c.C45714a;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b.C10986a;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b.C199182;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C42748a;
import com.tencent.p177mm.plugin.websearch.api.C22757j;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView */
public class AppBrandDesktopView extends DragRecyclerView implements C10986a {
    /* renamed from: Yq */
    private C41523a f4359Yq;
    private int aKu = 0;
    private int aKv = 0;
    public int akU = 4;
    private int ape = 0;
    private C41530m eja = new C198183();
    private ArrayList<C19835c> iPr = new ArrayList();
    HeaderContainer iVo;
    private C42707b iWI = new C109461();
    private int iXA = 0;
    private boolean iXB = false;
    private View iXC;
    private int iXD = C1338a.fromDPToPix(C4996ah.getContext(), 80);
    private C19916b iXE = new C19916b();
    boolean iXF = false;
    private boolean iXG = false;
    boolean iXH = false;
    boolean iXI = false;
    boolean iXJ = false;
    private boolean iXK = false;
    C19834b iXL = new C19834b(1);
    C19834b iXM = new C19834b(2);
    boolean iXN = false;
    boolean iXO = false;
    private int iXP = -1;
    private boolean iXQ = false;
    private boolean iXR = false;
    private ArrayList<C19835c> iXf = new ArrayList();
    private int iXg = 0;
    private boolean iXh = false;
    private boolean iXi = false;
    private C19828j iXj = null;
    private boolean iXk = false;
    RelativeLayout iXl;
    RecentAppBrandViewContainer iXm;
    private RecentAppBrandView iXn;
    private AppBrandDesktopDragView iXo;
    int iXp = 0;
    private int iXq = 0;
    private boolean iXr = false;
    private boolean iXs = false;
    Runnable iXt = null;
    Runnable iXu = null;
    private boolean iXv = false;
    private int iXw;
    private int iXx;
    private int iXy = 0;
    private int iXz = 0;
    boolean isPaused = false;
    int ivr = 0;
    /* renamed from: le */
    private int f4360le;
    Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$1 */
    class C109461 implements C42707b {
        C109461() {
        }

        /* renamed from: bI */
        public final void mo22526bI(Object obj) {
            AppMethodBeat.m2504i(133821);
            if (obj == null) {
                AppMethodBeat.m2505o(133821);
                return;
            }
            if (obj instanceof C19835c) {
                C19835c c19835c = (C19835c) obj;
                if (c19835c.iXW != null) {
                    AppBrandDesktopView.m30671a(AppBrandDesktopView.this);
                    C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", Boolean.valueOf(AppBrandDesktopView.m30677b(AppBrandDesktopView.this)));
                    if (!(AppBrandDesktopView.this.iXE == null || C5046bo.isNullOrNil(c19835c.iXW.appId))) {
                        AppBrandDesktopView.this.iXE.mo35158ET(c19835c.iXW.appId);
                    }
                    AppBrandDesktopView.m30672a(AppBrandDesktopView.this, ((C19835c) obj).position);
                }
            }
            AppMethodBeat.m2505o(133821);
        }

        /* renamed from: bJ */
        public final void mo22527bJ(Object obj) {
            AppMethodBeat.m2504i(133822);
            if (obj == null) {
                AppMethodBeat.m2505o(133822);
                return;
            }
            if (obj instanceof C19835c) {
                C19835c c19835c = (C19835c) obj;
                if (c19835c.type == 1 && c19835c.iXW != null) {
                    AppBrandDesktopView.m30671a(AppBrandDesktopView.this);
                    C10118af c10118af = (C10118af) C1720g.m3528K(C10118af.class);
                    if (c10118af == null) {
                        AppMethodBeat.m2505o(133822);
                        return;
                    }
                    if (c10118af.mo21473aD(c19835c.iXW.username, c19835c.iXW.har)) {
                        AppBrandDesktopView.m30672a(AppBrandDesktopView.this, ((C19835c) obj).position);
                    }
                    if (!(AppBrandDesktopView.this.iXE == null || C5046bo.isNullOrNil(c19835c.iXW.appId))) {
                        AppBrandDesktopView.this.iXE.mo35157ES(c19835c.iXW.appId);
                    }
                }
            }
            AppMethodBeat.m2505o(133822);
        }

        /* renamed from: bK */
        public final void mo22528bK(Object obj) {
            AppMethodBeat.m2504i(133823);
            if (obj == null) {
                AppMethodBeat.m2505o(133823);
                return;
            }
            C19835c c19835c = (C19835c) obj;
            if (c19835c.iXW != null) {
                boolean aE;
                C4990ab.m7411d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", c19835c.iXW.username, Integer.valueOf(c19835c.iXW.har));
                AppBrandDesktopView.m30671a(AppBrandDesktopView.this);
                C26767ag c26767ag = (C26767ag) C1720g.m3528K(C26767ag.class);
                if (c26767ag != null) {
                    aE = c26767ag.mo44539aE(c19835c.iXW.username, c19835c.iXW.har);
                } else {
                    aE = false;
                }
                if (!(AppBrandDesktopView.this.iXE == null || c19835c.iXW == null || C5046bo.isNullOrNil(c19835c.iXW.appId))) {
                    AppBrandDesktopView.this.iXE.mo35156ER(c19835c.iXW.appId);
                }
                if (AppBrandDesktopView.this.iXm != null) {
                    if (aE) {
                        AppBrandDesktopView.m30675b(AppBrandDesktopView.this, c19835c.position);
                        AppMethodBeat.m2505o(133823);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
                    c19835c.type = 2;
                    AppBrandDesktopView.this.iXf.add(c19835c.position, c19835c);
                    AppBrandDesktopView.this.iXm.setDataList(AppBrandDesktopView.this.iXf);
                    if (AppBrandDesktopView.this.iXn != null) {
                        AppBrandDesktopView.this.iXn.getAdapter().mo66316cg(c19835c.position);
                    }
                }
            }
            AppMethodBeat.m2505o(133823);
        }

        /* renamed from: e */
        public final void mo22529e(int i, int i2, Object obj) {
            AppMethodBeat.m2504i(133824);
            AppBrandDesktopView.m30671a(AppBrandDesktopView.this);
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", Boolean.valueOf(AppBrandDesktopView.m30677b(AppBrandDesktopView.this)), Integer.valueOf(i), Integer.valueOf(i2));
            if (!(!(obj instanceof C19835c) || AppBrandDesktopView.this.iXE == null || ((C19835c) obj).iXW == null || C5046bo.isNullOrNil(((C19835c) obj).iXW.appId))) {
                C19916b c;
                if (i < i2) {
                    c = AppBrandDesktopView.this.iXE;
                    C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", ((C19835c) obj).iXW.appId);
                    c.jnc++;
                    c.jnj.append(r1 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                } else if (i > i2) {
                    c = AppBrandDesktopView.this.iXE;
                    C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", ((C19835c) obj).iXW.appId);
                    c.jnb++;
                    c.jnh.append(r1 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                }
            }
            AppBrandDesktopView.m30672a(AppBrandDesktopView.this, AppBrandDesktopView.this.iXg);
            AppMethodBeat.m2505o(133824);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$f */
    public class C10947f extends C41531v {
        public C10947f(View view) {
            super(view);
            AppMethodBeat.m2504i(133850);
            int r = AppBrandDesktopView.this.f4360le;
            if (r == 0 && this.apJ != null) {
                this.apJ.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(this.apJ.getMeasuredHeight()), Integer.valueOf(this.apJ.getMeasuredWidth()));
                r = this.apJ.getMeasuredHeight();
            }
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.setMargins(layoutParams.leftMargin + AppBrandDesktopView.this.iXq, layoutParams.topMargin - r, layoutParams.rightMargin + AppBrandDesktopView.this.iXq, layoutParams.bottomMargin);
            if (this.apJ != null) {
                this.apJ.setLayoutParams(layoutParams);
            }
            AppMethodBeat.m2505o(133850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$2 */
    class C198142 implements Runnable {
        final /* synthetic */ View iXT;

        C198142(View view) {
            this.iXT = view;
        }

        public final void run() {
            AppMethodBeat.m2504i(133825);
            ((DynamicBackgroundGLSurfaceView) this.iXT).setShowGradientView(false);
            AppMethodBeat.m2505o(133825);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$8 */
    class C198158 extends C8440b {
        C198158() {
        }

        /* renamed from: bU */
        public final int mo18459bU(int i) {
            AppMethodBeat.m2504i(133835);
            int itemViewType = AppBrandDesktopView.this.getAdapter().getItemViewType(i);
            if (itemViewType == 3 || itemViewType == 11 || itemViewType == 10 || itemViewType == 2 || itemViewType == 6 || itemViewType == 8 || itemViewType == 9) {
                itemViewType = AppBrandDesktopView.this.akU;
                AppMethodBeat.m2505o(133835);
                return itemViewType;
            }
            AppMethodBeat.m2505o(133835);
            return 1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$9 */
    class C198169 implements Runnable {
        C198169() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133836);
            AppBrandDesktopView.m30704s(AppBrandDesktopView.this);
            AppMethodBeat.m2505o(133836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$3 */
    class C198183 extends C41530m {
        C198183() {
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(133826);
            super.mo6643c(recyclerView, i);
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", Integer.valueOf(i), Boolean.valueOf(AppBrandDesktopView.this.iXs));
            if (!AppBrandDesktopView.m30656G(AppBrandDesktopView.this) && (AppBrandDesktopView.this.iXs || i == 0)) {
                AppBrandDesktopView.this.iXs = false;
                AppBrandDesktopView.m30658I(AppBrandDesktopView.this);
            }
            if (i == 0) {
                if (AppBrandDesktopView.this.iXQ) {
                    AppBrandDesktopView.this.iXQ = false;
                } else if (AppBrandDesktopView.this.iXP == 1 || AppBrandDesktopView.this.iXP == 2) {
                    AppBrandDesktopView.m30662M(AppBrandDesktopView.this);
                }
                if (!AppBrandDesktopView.m30663N(AppBrandDesktopView.this) || AppBrandDesktopView.this.iXR) {
                    AppBrandDesktopView.this.iXR = false;
                } else {
                    if (AppBrandDesktopView.this.iXE != null) {
                        C19916b c = AppBrandDesktopView.this.iXE;
                        c.jnl++;
                        C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", Integer.valueOf(c.jnl));
                    }
                    AppBrandDesktopView.this.iXR = true;
                }
            }
            AppBrandDesktopView.this.iXP = i;
            AppMethodBeat.m2505o(133826);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(133827);
            super.mo6642a(recyclerView, i, i2);
            if (AppBrandDesktopView.this.iXk) {
                AppBrandDesktopView.this.iXk = false;
                if (AppBrandDesktopView.this.iXj != null) {
                    int R = AppBrandDesktopView.this.ape - AppBrandDesktopView.this.iXj.mo1780iQ();
                    if (R >= 0 && R < AppBrandDesktopView.this.getChildCount()) {
                        AppBrandDesktopView.this.scrollBy(0, AppBrandDesktopView.this.getChildAt(R).getTop());
                    }
                }
            }
            AppMethodBeat.m2505o(133827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$d */
    public class C19819d extends C41531v {
        public C19819d(View view) {
            super(view);
            AppMethodBeat.m2504i(133841);
            if (AppBrandDesktopView.this.iXx == 0 && this.apJ != null) {
                this.apJ.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(this.apJ.getMeasuredHeight()), Integer.valueOf(this.apJ.getMeasuredWidth()));
                AppBrandDesktopView.this.iXx = this.apJ.getMeasuredHeight();
            }
            AppMethodBeat.m2505o(133841);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$e */
    class C19820e extends C41523a {

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$e$1 */
        class C167001 implements C10948b {
            C167001() {
            }

            /* renamed from: a */
            public final void mo22530a(C19835c c19835c, int i) {
                AppMethodBeat.m2504i(133842);
                AppBrandDesktopView.this.iXH = true;
                AppBrandDesktopView.this.iXI = false;
                AppBrandDesktopView.this.iXJ = false;
                AppBrandDesktopView.this.setLayoutFrozen(true);
                if (c19835c != null) {
                    AppBrandDesktopView.m30673a(AppBrandDesktopView.this, FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU, 2, c19835c.iXW, i);
                }
                AppMethodBeat.m2505o(133842);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$e$2 */
        class C198212 implements OnClickListener {
            C198212() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(133843);
                AppBrandDesktopView.this.iXH = false;
                AppBrandDesktopView.this.iXI = false;
                AppBrandDesktopView.this.iXJ = false;
                AppBrandDesktopView.this.iXK = true;
                ((C19731g) C1720g.m3528K(C19731g.class)).mo34962C(view.getContext(), 13);
                AppMethodBeat.m2505o(133843);
            }
        }

        private C19820e() {
        }

        /* synthetic */ C19820e(AppBrandDesktopView appBrandDesktopView, byte b) {
            this();
        }

        /* renamed from: a */
        public final C41531v mo4976a(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(133845);
            C41531v c198173;
            View view;
            if (i == 1) {
                C46898e c46898e = new C46898e(C5616v.m8409hu(AppBrandDesktopView.this.getContext()).inflate(2130968770, viewGroup, false));
                AppMethodBeat.m2505o(133845);
                return c46898e;
            } else if (i == 2) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
                AppBrandDesktopView.this.iXm = new RecentAppBrandViewContainer(AppBrandDesktopView.this.getContext());
                AppBrandDesktopView.this.iXm.setLayoutParams(new LayoutParams(-1, -2));
                AppBrandDesktopView.this.iXm.setItemPadding(AppBrandDesktopView.this.iXq);
                AppBrandDesktopView.this.iXn = AppBrandDesktopView.this.iXm.getRecentView();
                if (AppBrandDesktopView.this.iXn != null) {
                    AppBrandDesktopView.this.iXn.setReporter(AppBrandDesktopView.this.iXE);
                    AppBrandDesktopView.this.iXn.setOnItemClickListener(new C167001());
                }
                AppBrandDesktopView.this.iXm.setDataList(AppBrandDesktopView.this.iXf);
                AppBrandDesktopView.this.iXm.setOnMoreClickListener(new C198212());
                c198173 = new C41531v(AppBrandDesktopView.this.iXm) {
                };
                AppMethodBeat.m2505o(133845);
                return c198173;
            } else if (i == 3) {
                view = new View(AppBrandDesktopView.this.getContext());
                LayoutParams layoutParams = new LayoutParams(-1, AppBrandDesktopView.this.iXy);
                layoutParams.setMargins(layoutParams.leftMargin + AppBrandDesktopView.this.iXq, layoutParams.topMargin, layoutParams.rightMargin + AppBrandDesktopView.this.iXq, layoutParams.bottomMargin);
                view.setLayoutParams(layoutParams);
                c198173 = new C19836h(view);
                AppMethodBeat.m2505o(133845);
                return c198173;
            } else if (i == 6) {
                try {
                    AppBrandDesktopView.this.iXC = C5616v.m8409hu(AppBrandDesktopView.this.getContext()).inflate(2130968676, viewGroup, false);
                    c198173 = new C19823g(AppBrandDesktopView.this.iXC);
                    AppMethodBeat.m2505o(133845);
                    return c198173;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", e, "alvinluo init searchView exception", new Object[0]);
                    c198173 = new C19823g(new View(AppBrandDesktopView.this.getContext()));
                    AppMethodBeat.m2505o(133845);
                    return c198173;
                }
            } else if (i == 7) {
                view = C5616v.m8409hu(AppBrandDesktopView.this.getContext()).inflate(2130968770, viewGroup, false);
                LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                layoutParams2.setMargins(layoutParams2.leftMargin + AppBrandDesktopView.this.iXq, layoutParams2.topMargin, layoutParams2.rightMargin + AppBrandDesktopView.this.iXq, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
                c198173 = new C46898e(view);
                AppMethodBeat.m2505o(133845);
                return c198173;
            } else if (i == 8) {
                c198173 = new C10947f(C5616v.m8409hu(AppBrandDesktopView.this.getContext()).inflate(2130968670, viewGroup, false));
                AppMethodBeat.m2505o(133845);
                return c198173;
            } else if (i == 9) {
                c198173 = new C19819d(C5616v.m8409hu(AppBrandDesktopView.this.getContext()).inflate(2130968671, viewGroup, false));
                AppMethodBeat.m2505o(133845);
                return c198173;
            } else {
                c198173 = new C19836h(C5616v.m8409hu(AppBrandDesktopView.this.getContext()).inflate(2130970277, viewGroup, false));
                AppMethodBeat.m2505o(133845);
                return c198173;
            }
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(133846);
            C19835c qm = m30716qm(i);
            if (qm != null) {
                int i2 = qm.type;
                AppMethodBeat.m2505o(133846);
                return i2;
            }
            AppMethodBeat.m2505o(133846);
            return 0;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(133848);
            int size = AppBrandDesktopView.this.iPr.size();
            AppMethodBeat.m2505o(133848);
            return size;
        }

        /* renamed from: qm */
        private C19835c m30716qm(int i) {
            AppMethodBeat.m2504i(133849);
            if (i >= AppBrandDesktopView.this.iPr.size() || i < 0) {
                AppMethodBeat.m2505o(133849);
                return null;
            }
            C19835c c19835c = (C19835c) AppBrandDesktopView.this.iPr.get(i);
            AppMethodBeat.m2505o(133849);
            return c19835c;
        }

        /* renamed from: a */
        public final void mo4977a(C41531v c41531v, final int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(133847);
            int i3 = c41531v.apN;
            int m;
            if (i3 == 3) {
                int n = AppBrandDesktopView.this.iXy;
                if (AppBrandDesktopView.this.iXp == 0) {
                    AppBrandDesktopView.this.iXp = AppBrandDesktopView.this.iVo.getMeasuredHeight();
                }
                i3 = AppBrandDesktopView.this.iXp;
                m = AppBrandDesktopView.m30696m(AppBrandDesktopView.this);
                if (m > AppBrandDesktopView.this.iXD + i3) {
                    AppBrandDesktopView.this.iXy = AppBrandDesktopView.this.iXz;
                } else if (m > i3) {
                    AppBrandDesktopView.this.iXy = AppBrandDesktopView.this.iXD - (m - i3);
                } else {
                    AppBrandDesktopView.this.iXy = (i3 - m) + AppBrandDesktopView.this.iXD;
                }
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", Integer.valueOf(i3), Integer.valueOf(AppBrandDesktopView.this.iXw), Integer.valueOf(AppBrandDesktopView.this.f4360le), Integer.valueOf(m), Integer.valueOf(AppBrandDesktopView.this.iXy), Integer.valueOf(n), Integer.valueOf(AppBrandDesktopView.this.iXD));
                c41531v.apJ.setVisibility(4);
                LayoutParams layoutParams = (LayoutParams) c41531v.apJ.getLayoutParams();
                layoutParams.height = AppBrandDesktopView.this.iXy;
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", Integer.valueOf(AppBrandDesktopView.this.iXy));
                c41531v.apJ.setLayoutParams(layoutParams);
                AppMethodBeat.m2505o(133847);
            } else if (i3 == 10 || i3 == 11) {
                if (c41531v == null) {
                    AppMethodBeat.m2505o(133847);
                    return;
                }
                View view = c41531v.apJ;
                int w = AppBrandDesktopView.this.iXq + ((int) (((float) C1338a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8)) * C10969d.m18710dm(AppBrandDesktopView.this.getContext())));
                LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                layoutParams2.setMargins(layoutParams2.leftMargin + w, layoutParams2.topMargin, w + layoutParams2.rightMargin, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
                if (AppBrandDesktopView.this.iXw == 0) {
                    view = c41531v.apJ;
                    view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", Integer.valueOf(view.getMeasuredHeight()), Integer.valueOf(view.getMeasuredWidth()));
                    AppBrandDesktopView.this.iXw = view.getMeasuredHeight();
                }
                ((C19836h) c41531v).gne.setText(i3 == 10 ? C25738R.string.div : C25738R.string.d48);
                AppMethodBeat.m2505o(133847);
            } else if (i3 == 8) {
                boolean z;
                C10947f c10947f = (C10947f) c41531v;
                if (AppBrandDesktopView.this.iXi) {
                    z = false;
                } else {
                    z = true;
                }
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b", Boolean.valueOf(z));
                if (c10947f.apJ != null) {
                    View view2 = c10947f.apJ;
                    if (!z) {
                        i2 = 4;
                    }
                    view2.setVisibility(i2);
                }
                AppMethodBeat.m2505o(133847);
            } else if (i3 == 6) {
                AppBrandDesktopView.m30676b(AppBrandDesktopView.this, c41531v.apJ);
                AppMethodBeat.m2505o(133847);
            } else if (i3 == 2 || i3 == 9) {
                AppMethodBeat.m2505o(133847);
            } else {
                if (i3 == 1 || i3 == 7) {
                    C46898e c46898e = (C46898e) c41531v;
                    c46898e.apJ.setPadding(AppBrandDesktopView.this.iXq, C1338a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.this.iXq, C1338a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
                    m = (int) C10969d.m18709dl(AppBrandDesktopView.this.getContext());
                    c46898e.iYe.getLayoutParams().width = ((int) (((float) (C1338a.m2857am(AppBrandDesktopView.this.getContext(), C25738R.dimen.f10011nc) * 2)) * C10969d.m18710dm(AppBrandDesktopView.this.getContext()))) + m;
                    c46898e.iYe.getLayoutParams().height = ((int) (((float) (C1338a.m2857am(AppBrandDesktopView.this.getContext(), C25738R.dimen.f10011nc) * 2)) * C10969d.m18710dm(AppBrandDesktopView.this.getContext()))) + m;
                    c46898e.iqT.getLayoutParams().width = m;
                    c46898e.iqT.getLayoutParams().height = m;
                    c46898e.iYd.getLayoutParams().width = m;
                    c46898e.iYd.getLayoutParams().height = m;
                    c41531v.apJ.setVisibility(0);
                    if (AppBrandDesktopView.this.f4360le == 0) {
                        View view3 = c41531v.apJ;
                        view3.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(view3.getMeasuredHeight()), Integer.valueOf(view3.getMeasuredWidth()));
                        AppBrandDesktopView.this.f4360le = view3.getMeasuredHeight();
                    }
                    if (i3 == 7) {
                        c41531v.apJ.setVisibility(4);
                        if (((i - AppBrandDesktopView.this.iXg) + 1) % 4 == 1 && i > AppBrandDesktopView.this.iXg) {
                            c41531v.apJ.getLayoutParams().height = 1;
                        }
                        AppMethodBeat.m2505o(133847);
                        return;
                    }
                    final C19835c qm = m30716qm(i);
                    if (qm == null) {
                        AppMethodBeat.m2505o(133847);
                        return;
                    }
                    qm.position = i;
                    c46898e.iYh = qm;
                    if (qm.iXW != null) {
                        if (!C5046bo.isNullOrNil(qm.iXW.bQo)) {
                            c46898e.gne.setText(C45714a.m84464Ey(qm.iXW.bQo));
                            c46898e.gne.setVisibility(0);
                        } else if (!C5046bo.isNullOrNil(qm.iXW.nickname)) {
                            c46898e.gne.setText(C45714a.m84464Ey(qm.iXW.nickname));
                            c46898e.gne.setVisibility(0);
                        } else if (C5046bo.isNullOrNil(qm.iXW.username)) {
                            C4990ab.m7421w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", qm.iXW.username, qm.iXW.appId);
                            c46898e.gne.setVisibility(4);
                        } else {
                            c46898e.gne.setText(C45714a.m84464Ey(qm.iXW.nickname));
                            c46898e.gne.setVisibility(0);
                        }
                        c46898e.iYd.setVisibility(0);
                        if (C5046bo.isNullOrNil(qm.iXW.haO)) {
                            c46898e.iqT.setImageDrawable(C32804a.abQ());
                        } else {
                            C37926b.abR().mo60683a(c46898e.iqT, qm.iXW.haO, C32804a.abQ(), C42201f.fqH);
                        }
                        if (C5046bo.isNullOrNil(C38114b.m64485no(qm.iXW.har))) {
                            c46898e.iYf.setVisibility(8);
                        } else {
                            c46898e.iYf.setVisibility(0);
                            c46898e.iYf.setText(C38114b.m64485no(qm.iXW.har));
                        }
                        c46898e.apJ.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(133844);
                                AppBrandDesktopView.this.iXH = true;
                                AppBrandDesktopView.this.iXI = false;
                                AppBrandDesktopView.this.iXJ = false;
                                AppBrandDesktopView.this.setLayoutFrozen(true);
                                AppBrandDesktopView.m30673a(AppBrandDesktopView.this, 1104, 1, qm.iXW, i);
                                AppMethodBeat.m2505o(133844);
                            }
                        });
                    } else {
                        C37926b.abR().mo60683a(c46898e.iqT, "", C32804a.abQ(), C42201f.fqH);
                        c46898e.gne.setVisibility(0);
                        c46898e.iYf.setVisibility(8);
                        c46898e.gne.setText("");
                    }
                }
                if (AppBrandDesktopView.this.getDragRubbishView() != null) {
                    DragFeatureView dragRubbishView = AppBrandDesktopView.this.getDragRubbishView();
                    if (dragRubbishView.getVisibility() != 8) {
                        if (dragRubbishView.iYm == i) {
                            c41531v.apJ.setVisibility(4);
                            AppMethodBeat.m2505o(133847);
                            return;
                        }
                        c41531v.apJ.setVisibility(0);
                    }
                }
                AppMethodBeat.m2505o(133847);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$g */
    public class C19823g extends C41531v {
        protected EditText iXZ;
        private long iYa = 0;

        public C19823g(View view) {
            super(view);
            AppMethodBeat.m2504i(133852);
            this.iXZ = (EditText) view.findViewById(2131821170);
            if (this.iXZ != null) {
                this.iXZ.setFocusable(false);
                this.iXZ.setOnClickListener(new OnClickListener(AppBrandDesktopView.this) {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(133851);
                        AppBrandDesktopView.this.iXH = false;
                        AppBrandDesktopView.this.iXI = false;
                        AppBrandDesktopView.this.iXJ = false;
                        AppBrandDesktopView appBrandDesktopView = AppBrandDesktopView.this;
                        if (appBrandDesktopView.iVo != null && appBrandDesktopView.iXF) {
                            DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = (DynamicBackgroundGLSurfaceView) appBrandDesktopView.iVo.getBackgroundGLSurfaceView();
                            if (dynamicBackgroundGLSurfaceView != null) {
                                dynamicBackgroundGLSurfaceView.iZQ.onPause();
                                appBrandDesktopView.iXJ = true;
                                appBrandDesktopView.iXO = true;
                            }
                        }
                        C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (AppBrandDesktopView.this.iXE != null && (C19823g.this.iYa == 0 || currentTimeMillis - C19823g.this.iYa > 1000)) {
                            C19823g.this.iYa = currentTimeMillis;
                            C19916b c = AppBrandDesktopView.this.iXE;
                            c.jnm++;
                            C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", Integer.valueOf(c.jnm));
                        }
                        C22757j c22757j = (C22757j) C1720g.m3528K(C22757j.class);
                        if (c22757j != null) {
                            c22757j.mo38338aa(AppBrandDesktopView.this.mContext, 42);
                        }
                        AppMethodBeat.m2505o(133851);
                    }
                });
            }
            AppMethodBeat.m2505o(133852);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$10 */
    class C1982510 implements Runnable {
        C1982510() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133837);
            if (AppBrandDesktopView.this.iXi && AppBrandDesktopView.this.iXh) {
                if (AppBrandDesktopView.this.iXn == null) {
                    AppMethodBeat.m2505o(133837);
                    return;
                }
                int i;
                C19835c c19835c;
                C42748a c42748a;
                List showList = AppBrandDesktopView.this.iXn.getShowList();
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= showList.size()) {
                        break;
                    }
                    c19835c = (C19835c) showList.get(i);
                    if (!(c19835c == null || c19835c.iXW == null)) {
                        c42748a = new C42748a(c19835c.iXW);
                        c42748a.position = i;
                        arrayList.add(c42748a);
                    }
                    i2 = i + 1;
                }
                ArrayList arrayList2 = new ArrayList();
                i2 = AppBrandDesktopView.this.iXg;
                while (true) {
                    i = i2;
                    if (i >= AppBrandDesktopView.this.iPr.size()) {
                        break;
                    }
                    c19835c = (C19835c) AppBrandDesktopView.this.iPr.get(i);
                    if (c19835c != null && c19835c.type == 1) {
                        c42748a = new C42748a(c19835c.iXW);
                        c42748a.position = i;
                        arrayList2.add(c42748a);
                    }
                    i2 = i + 1;
                }
                C19916b.m30809f(arrayList, arrayList2);
            }
            AppMethodBeat.m2505o(133837);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$11 */
    class C1982611 implements Runnable {
        C1982611() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133838);
            AppBrandDesktopView.m30707v(AppBrandDesktopView.this);
            AppMethodBeat.m2505o(133838);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$a */
    class C19827a implements C42706a {
        private C19827a() {
        }

        /* synthetic */ C19827a(AppBrandDesktopView appBrandDesktopView, byte b) {
            this();
        }

        public final int aPl() {
            AppMethodBeat.m2504i(133839);
            int h = AppBrandDesktopView.m30690h(AppBrandDesktopView.this);
            AppMethodBeat.m2505o(133839);
            return h;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$j */
    class C19828j extends GridLayoutManager {
        public C19828j(int i) {
            super(i, (byte) 0);
        }

        /* renamed from: c */
        public final void mo1765c(C25374o c25374o, C31880s c31880s) {
            AppMethodBeat.m2504i(133855);
            try {
                super.mo1765c(c25374o, c31880s);
                AppMethodBeat.m2505o(133855);
            } catch (IndexOutOfBoundsException e) {
                C4990ab.m7412e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
                AppMethodBeat.m2505o(133855);
            }
        }

        /* renamed from: a */
        public final void mo1755a(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(133856);
            C19838i c19838i = new C19838i(AppBrandDesktopView.this.mContext);
            c19838i.ape = i;
            mo31829a((C37139r) c19838i);
            AppMethodBeat.m2505o(133856);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$4 */
    class C198294 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$4$1 */
        class C198301 implements Runnable {
            C198301() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133828);
                if (AppBrandDesktopView.this.f4359Yq != null) {
                    AppBrandDesktopView.this.f4359Yq.aop.notifyChanged();
                }
                AppMethodBeat.m2505o(133828);
            }
        }

        C198294() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133829);
            if (AppBrandDesktopView.this.mo66406jz()) {
                AppBrandDesktopView.this.post(new C198301());
                AppMethodBeat.m2505o(133829);
                return;
            }
            if (AppBrandDesktopView.this.f4359Yq != null) {
                AppBrandDesktopView.this.f4359Yq.aop.notifyChanged();
            }
            AppMethodBeat.m2505o(133829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$5 */
    class C198315 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$5$1 */
        class C198321 implements Runnable {
            C198321() {
            }

            public final void run() {
                AppMethodBeat.m2504i(133830);
                if (AppBrandDesktopView.this.iXn != null) {
                    AppBrandDesktopView.this.iXn.aPw();
                }
                AppMethodBeat.m2505o(133830);
            }
        }

        C198315() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133831);
            if (AppBrandDesktopView.this.mo66406jz()) {
                AppBrandDesktopView.this.post(new C198321());
                AppMethodBeat.m2505o(133831);
                return;
            }
            if (AppBrandDesktopView.this.iXn != null) {
                AppBrandDesktopView.this.iXn.aPw();
            }
            AppMethodBeat.m2505o(133831);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$6 */
    class C198336 implements Runnable {
        C198336() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133832);
            AppBrandDesktopView.this.setLayoutFrozen(false);
            AppMethodBeat.m2505o(133832);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$b */
    class C19834b implements C4931a {
        boolean iXG = false;
        private int mType;

        public C19834b(int i) {
            this.mType = i;
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(133840);
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", Integer.valueOf(this.mType), Boolean.valueOf(this.iXG), Integer.valueOf(c4935m.hsh));
            if (c4935m.hsh == -1) {
                C4990ab.m7421w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", Integer.valueOf(c4935m.hsh));
                AppMethodBeat.m2505o(133840);
            } else if (this.iXG) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
                this.iXG = false;
                AppMethodBeat.m2505o(133840);
            } else {
                AppBrandDesktopView.m30692i(AppBrandDesktopView.this);
                AppMethodBeat.m2505o(133840);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$c */
    public static class C19835c {
        public LocalUsageInfo iXW;
        public int position;
        public int type;

        public C19835c(int i) {
            this.type = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$h */
    public class C19836h extends C41531v {
        protected TextView gne;

        public C19836h(View view) {
            super(view);
            AppMethodBeat.m2504i(133853);
            this.gne = (TextView) view.findViewById(2131821157);
            AppMethodBeat.m2505o(133853);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$7 */
    class C198377 implements C42712g {
        C198377() {
        }

        public final int computeVerticalScrollRange() {
            AppMethodBeat.m2504i(133833);
            int m = AppBrandDesktopView.m30696m(AppBrandDesktopView.this) + AppBrandDesktopView.this.iXy;
            AppMethodBeat.m2505o(133833);
            return m;
        }

        public final int computeVerticalScrollOffset() {
            AppMethodBeat.m2504i(133834);
            if (AppBrandDesktopView.this.getChildCount() == 0) {
                AppMethodBeat.m2505o(133834);
                return 0;
            }
            try {
                int iQ = AppBrandDesktopView.this.iXj.mo1780iQ();
                int i = -((int) AppBrandDesktopView.this.iXj.mo1760bW(iQ).getY());
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo compute offsetY: %d", Integer.valueOf(i));
                int i2 = 0;
                while (i2 < iQ) {
                    int i3;
                    C19835c c19835c = (C19835c) AppBrandDesktopView.this.iPr.get(i2);
                    if (c19835c != null) {
                        i3 = c19835c.type;
                        C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo compute type: %d, i: %d", Integer.valueOf(i3), Integer.valueOf(i2));
                        if (i3 == 10 || i3 == 11) {
                            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo compute title add height: %s", Integer.valueOf(AppBrandDesktopView.this.iXw));
                            i3 = AppBrandDesktopView.this.iXw + i;
                            i2++;
                            i = i3;
                        } else {
                            if (i3 == 6) {
                                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo compute search add height: %s", Integer.valueOf(AppBrandDesktopView.this.iXD));
                                i3 = AppBrandDesktopView.this.iXD + i;
                            } else if (i3 == 2) {
                                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo compute recent add height: %s", Integer.valueOf(AppBrandDesktopView.this.f4360le));
                                i3 = AppBrandDesktopView.this.f4360le + i;
                            } else if (i3 == 1 && (i2 - AppBrandDesktopView.this.iXg) % 4 == 0) {
                                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo compute collection item add height: %s", Integer.valueOf(AppBrandDesktopView.this.f4360le));
                                i3 = AppBrandDesktopView.this.f4360le + i;
                            }
                            i2++;
                            i = i3;
                        }
                    }
                    i3 = i;
                    i2++;
                    i = i3;
                }
                AppMethodBeat.m2505o(133834);
                return i;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", e, "alvinluo compute exception", new Object[0]);
                AppMethodBeat.m2505o(133834);
                return 0;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$i */
    class C19838i extends C41189ah {
        C19838i(Context context) {
            super(context);
        }

        /* renamed from: bX */
        public final PointF mo22752bX(int i) {
            AppMethodBeat.m2504i(133854);
            PointF bX = AppBrandDesktopView.this.iXj.mo1761bX(i);
            AppMethodBeat.m2505o(133854);
            return bX;
        }

        /* renamed from: e */
        public final int mo35055e(int i, int i2, int i3, int i4, int i5) {
            return i3 - i;
        }

        /* renamed from: c */
        public final float mo9235c(DisplayMetrics displayMetrics) {
            return 300.0f / ((float) displayMetrics.densityDpi);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m30671a(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133881);
        appBrandDesktopView.setIgnoreNotify(true);
        AppMethodBeat.m2505o(133881);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m30677b(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133882);
        boolean qi = appBrandDesktopView.m30701qi(0);
        AppMethodBeat.m2505o(133882);
        return qi;
    }

    /* renamed from: h */
    static /* synthetic */ int m30690h(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133885);
        int collectionDataSize = appBrandDesktopView.getCollectionDataSize();
        AppMethodBeat.m2505o(133885);
        return collectionDataSize;
    }

    /* renamed from: i */
    static /* synthetic */ void m30692i(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133886);
        appBrandDesktopView.aPr();
        AppMethodBeat.m2505o(133886);
    }

    /* renamed from: s */
    static /* synthetic */ void m30704s(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133888);
        appBrandDesktopView.aMq();
        AppMethodBeat.m2505o(133888);
    }

    private void setIgnoreNotify(boolean z) {
        if (this.iXM != null) {
            this.iXM.iXG = z;
        }
        if (this.iXL != null) {
            this.iXL.iXG = z;
        }
    }

    /* renamed from: qi */
    private boolean m30701qi(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(133857);
        C4990ab.m7410d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.iPr.size(); i2++) {
            C19835c c19835c = (C19835c) this.iPr.get(i2);
            if (c19835c.type == 1 && c19835c.iXW != null) {
                arrayList.add(c19835c.iXW);
            }
        }
        C10118af c10118af = (C10118af) C1720g.m3528K(C10118af.class);
        if (c10118af == null) {
            AppMethodBeat.m2505o(133857);
        } else {
            z = c10118af.mo21476g(arrayList, i);
            if (!z) {
                C4990ab.m7412e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
            }
            AppMethodBeat.m2505o(133857);
        }
        return z;
    }

    private void aPm() {
        AppMethodBeat.m2504i(133858);
        this.iPr.clear();
        this.iPr.add(new C19835c(6));
        this.iPr.add(new C19835c(9));
        this.iPr.add(new C19835c(3));
        this.iXh = false;
        this.iXi = false;
        this.iXB = false;
        this.f4359Yq.aop.notifyChanged();
        m30685eU(true);
        AppMethodBeat.m2505o(133858);
    }

    private void aPn() {
        int i = 0;
        AppMethodBeat.m2504i(133859);
        C4990ab.m7411d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", Integer.valueOf(this.iXA), Integer.valueOf(this.iPr.size() - 4), Integer.valueOf(1));
        while (i <= 0) {
            this.iPr.add(new C19835c(7));
            i++;
        }
        this.iXA = 1;
        AppMethodBeat.m2505o(133859);
    }

    public AppBrandDesktopView(Context context) {
        super(context);
        AppMethodBeat.m2504i(133860);
        init(context);
        AppMethodBeat.m2505o(133860);
    }

    public AppBrandDesktopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(133861);
        init(context);
        AppMethodBeat.m2505o(133861);
    }

    public AppBrandDesktopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(133862);
        init(context);
        AppMethodBeat.m2505o(133862);
    }

    public void setHeaderContainer(HeaderContainer headerContainer) {
        this.iVo = headerContainer;
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.m2504i(133863);
        super.onVisibilityChanged(view, i);
        C4990ab.m7410d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(i)));
        if (i == 8 || i == 4) {
            if (this.iXK && this.iVo != null) {
                this.iVo.mo54120k(200, 9);
                this.iXK = false;
            }
            if (this.iXv) {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo onVisibilityChanged needRefresh");
                this.iXv = false;
                if (this.iXu != null) {
                    removeCallbacks(this.iXu);
                }
                C198336 c198336 = new C198336();
                this.iXu = c198336;
                postDelayed(c198336, 1000);
            }
        }
        AppMethodBeat.m2505o(133863);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.m2504i(133864);
        super.onAttachedToWindow();
        View rootView = getRootView();
        if (rootView == null) {
            AppMethodBeat.m2505o(133864);
            return;
        }
        this.iXo = (AppBrandDesktopDragView) rootView.findViewById(2131820594);
        String str = "MicroMsg.AppBrandDesktopView";
        String str2 = "alvinluo onAttachedToWindow mDragFeatureView == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.iXo == null);
        C4990ab.m7417i(str, str2, objArr);
        this.iXo.setRecyclerView(this);
        this.iXo.setCopyList(this.iXf);
        this.iXo.setList(this.iPr);
        this.iXo.setHeaderContainer(this.iVo);
        this.iXo.setCollectionCallback(this.iWI);
        this.iXo.setItemPadding(this.iXq);
        this.iXo.setAppBrandCounter(new C19827a(this, (byte) 0));
        this.iXo.setRecyclerViewScrollComputer(new C198377());
        this.iYz = this.iXo;
        if (this.iXo != null && (this.iXo.getParent() instanceof RelativeLayout)) {
            C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
            this.iXl = (RelativeLayout) this.iXo.getParent();
        }
        AppMethodBeat.m2505o(133864);
    }

    private void aPo() {
        AppMethodBeat.m2504i(133865);
        this.iXq = getItemPadding();
        AppMethodBeat.m2505o(133865);
    }

    public int getLeftRightMargin() {
        AppMethodBeat.m2504i(133866);
        int dk = C10969d.m18708dk(getContext()) - this.iXq;
        if (dk < 0) {
            dk = 0;
        }
        C4990ab.m7411d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", Integer.valueOf(dk), Integer.valueOf(this.iXq));
        AppMethodBeat.m2505o(133866);
        return dk;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(133867);
        this.mContext = context;
        this.iXz = 0;
        this.iXy = this.iXz;
        C2545b.init(this.mContext);
        this.akU = C2545b.getCompletelyCountPerPage();
        aPo();
        aPq();
        this.iXj = new C19828j(this.akU);
        this.iXj.akZ = new C198158();
        setLayoutManager(this.iXj);
        setOverScrollMode(2);
        mo66332a(this.eja);
        this.f4359Yq = new C19820e(this, (byte) 0);
        setAdapter(this.f4359Yq);
        aPr();
        aPp();
        C5004al.m7442n(new C198169(), 200);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", Integer.valueOf(hashCode()), Integer.valueOf(this.iXD));
        AppMethodBeat.m2505o(133867);
    }

    /* Access modifiers changed, original: final */
    public final void aPp() {
        AppMethodBeat.m2504i(133868);
        if (this.iXN) {
            AppMethodBeat.m2505o(133868);
            return;
        }
        C26767ag c26767ag = (C26767ag) C1720g.m3528K(C26767ag.class);
        C10118af c10118af = (C10118af) C1720g.m3528K(C10118af.class);
        if (c26767ag == null || c10118af == null) {
            AppMethodBeat.m2505o(133868);
            return;
        }
        this.iXN = true;
        c26767ag.mo10117d(this.iXM);
        c26767ag.mo10116c(this.iXM);
        c10118af.mo10117d(this.iXL);
        c10118af.mo10116c(this.iXL);
        AppMethodBeat.m2505o(133868);
    }

    private int getItemPadding() {
        AppMethodBeat.m2504i(133869);
        int dj = C10969d.m18707dj(getContext());
        AppMethodBeat.m2505o(133869);
        return dj;
    }

    private void aPq() {
        AppMethodBeat.m2504i(133870);
        setVerticalFadingEdgeEnabled(true);
        setNestedScrollingEnabled(true);
        setBackgroundColor(getContext().getResources().getColor(C25738R.color.a3p));
        AppMethodBeat.m2505o(133870);
    }

    private void aPr() {
        List nA;
        List a;
        AppMethodBeat.m2504i(133871);
        long currentTimeMillis = System.currentTimeMillis();
        this.iPr.clear();
        this.iXf.clear();
        this.iXA = 0;
        this.iXB = false;
        this.iPr.add(new C19835c(6));
        if (C1720g.m3528K(C26767ag.class) != null) {
            nA = ((C26767ag) C1720g.m3528K(C26767ag.class)).mo44540nA(50);
        } else {
            nA = null;
        }
        if (C1720g.m3528K(C10118af.class) != null) {
            a = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(BaseClientBuilder.API_PRIORITY_OTHER, C10117a.DESC);
        } else {
            a = null;
        }
        if (nA == null || nA.size() == 0) {
            this.iXh = false;
            this.iXg = 2;
        } else {
            this.iXh = true;
            this.iXg = 4;
        }
        if (this.iXo != null) {
            this.iXo.setCollectionStartPosition(this.iXg);
        }
        if (a == null || a.size() == 0) {
            this.iXi = false;
        } else {
            this.iXi = true;
        }
        if (this.iXh || this.iXi) {
            C19835c c19835c = new C19835c(0);
            if (!(nA == null || nA.isEmpty())) {
                this.iPr.add(new C19835c(10));
                this.iPr.add(new C19835c(2));
                for (int i = 0; i < nA.size(); i++) {
                    C19835c c19835c2 = new C19835c(2);
                    c19835c2.iXW = (LocalUsageInfo) nA.get(i);
                    this.iXf.add(c19835c2);
                }
            }
            this.iPr.add(new C19835c(11));
            if (a != null) {
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", Integer.valueOf(a.size()));
                for (int i2 = 0; i2 < a.size(); i2++) {
                    C19835c c19835c3 = new C19835c(1);
                    c19835c3.iXW = (LocalUsageInfo) a.get(i2);
                    this.iPr.add(c19835c3);
                }
            }
            aPn();
            if (!this.iXi) {
                this.iPr.add(new C19835c(8));
                this.iXB = true;
            }
            this.iPr.add(new C19835c(3));
            if (this.iXo != null) {
                this.iXo.setCopyList(this.iXf);
                this.iXo.setList(this.iPr);
            }
            C4990ab.m7411d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused));
            if (this.anv) {
                this.iXv = true;
            }
            this.f4359Yq.aop.notifyChanged();
            if (this.iXm != null) {
                C4990ab.m7410d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
                this.iXm.setDataList(this.iXf);
                this.iXm.notifyDataSetChanged();
            }
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", Integer.valueOf(this.iPr.size()), Integer.valueOf(this.iXf.size()), Integer.valueOf(this.iPr.size() - this.iXg));
            AppMethodBeat.m2505o(133871);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
        this.iPr.add(new C19835c(9));
        this.iPr.add(new C19835c(3));
        AppMethodBeat.m2505o(133871);
    }

    /* Access modifiers changed, original: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(133872);
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        this.aKu = size;
        this.aKv = size2;
        size = C10969d.m18704c(this.aKu, getContext());
        if (size != this.iXq) {
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", Integer.valueOf(this.iXq), Integer.valueOf(size));
            C2545b.init(getContext());
            this.iXq = size;
            C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", Integer.valueOf(this.iXq));
            if (this.iXm != null) {
                this.iXm.setItemPadding(this.iXq);
                if (this.iXn != null) {
                    this.iXn.aPw();
                }
            }
            if (this.f4359Yq != null) {
                this.f4359Yq.aop.notifyChanged();
            }
            if (this.iVo != null) {
                this.iVo.aPi();
            }
        }
        AppMethodBeat.m2505o(133872);
    }

    private void aMq() {
        AppMethodBeat.m2504i(133873);
        C4990ab.m7410d("MicroMsg.AppBrandDesktopView", "alvinluo resetSearchView");
        if (this.iXi || this.iXh) {
            m30685eU(false);
            AppMethodBeat.m2505o(133873);
            return;
        }
        m30685eU(true);
        AppMethodBeat.m2505o(133873);
    }

    public RecyclerView getRecyclerView() {
        return this;
    }

    private int getCollectionDataSize() {
        AppMethodBeat.m2504i(133874);
        if (this.iXi) {
            int size = ((this.iPr.size() - this.iXg) - this.iXA) - 1;
            AppMethodBeat.m2505o(133874);
            return size;
        }
        AppMethodBeat.m2505o(133874);
        return 0;
    }

    public final void aPs() {
        AppMethodBeat.m2504i(133875);
        C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
        if (!this.iXF) {
            C19692e.m30512Dz(C19692e.aLc());
            if (!(this.iXE == null || this.iXn == null)) {
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", Integer.valueOf(this.iXn.getShowCount()), Integer.valueOf(getCollectionDataSize()));
                this.iXE.mo35163dw(this.iXn.getShowCount(), getCollectionDataSize());
                C7305d.xDG.execute(new C1982510());
            }
            this.iXF = true;
            this.iXI = true;
            this.iXJ = true;
        }
        setLayoutFrozen(false);
        AppMethodBeat.m2505o(133875);
    }

    /* renamed from: qj */
    public final void mo22635qj(int i) {
        AppMethodBeat.m2504i(133876);
        C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "[onCloseHeader]");
        if (this.iXF) {
            if (!(this.iXE == null || this.iXn == null)) {
                C19916b c19916b = this.iXE;
                c19916b.jnn = C2545b.aPe();
                C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", Boolean.valueOf(r1));
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", Integer.valueOf(this.iXn.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(i));
                c19916b = this.iXE;
                int showCount = this.iXn.getShowCount();
                int collectionDataSize = getCollectionDataSize();
                c19916b.jmO = showCount;
                c19916b.jmX = collectionDataSize;
                c19916b.jmL = i;
                C7305d.xDG.execute(new C199182());
            }
            this.iXF = false;
            this.iXI = false;
            this.iXJ = false;
            if (i == 9) {
                if (this.iXL != null) {
                    this.iXL.iXG = false;
                }
            } else if (this.iXL != null) {
                this.iXL.iXG = true;
            }
        }
        aMq();
        m30701qi(1);
        AppMethodBeat.m2505o(133876);
    }

    /* renamed from: qk */
    public final void mo22636qk(int i) {
        AppMethodBeat.m2504i(133877);
        mo22635qj(i);
        AppMethodBeat.m2505o(133877);
    }

    public final void aPt() {
        AppMethodBeat.m2504i(133878);
        aPs();
        AppMethodBeat.m2505o(133878);
    }

    /* renamed from: eU */
    private void m30685eU(boolean z) {
        AppMethodBeat.m2504i(133879);
        m30702ql(z ? 0 : 1);
        AppMethodBeat.m2505o(133879);
    }

    /* renamed from: ql */
    private void m30702ql(int i) {
        AppMethodBeat.m2504i(133880);
        this.ape = i;
        int iQ = this.iXj.mo1780iQ();
        int iS = this.iXj.mo1782iS();
        if (i <= iQ) {
            mo61465bY(i);
            AppMethodBeat.m2505o(133880);
        } else if (i <= iS) {
            scrollBy(0, getChildAt(i - iQ).getTop());
            AppMethodBeat.m2505o(133880);
        } else {
            mo61465bY(i);
            this.iXk = true;
            AppMethodBeat.m2505o(133880);
        }
    }

    /* renamed from: m */
    static /* synthetic */ int m30696m(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133887);
        int i = appBrandDesktopView.iXD;
        if (appBrandDesktopView.iXh || appBrandDesktopView.iXi) {
            if (appBrandDesktopView.iXh) {
                i += appBrandDesktopView.iXw + appBrandDesktopView.f4360le;
            }
            if (appBrandDesktopView.iXi) {
                int i2 = appBrandDesktopView.iXw + i;
                int collectionDataSize = appBrandDesktopView.getCollectionDataSize();
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight itemCount: %d", Integer.valueOf(collectionDataSize));
                if (collectionDataSize > appBrandDesktopView.akU) {
                    i = (appBrandDesktopView.f4360le * ((collectionDataSize / appBrandDesktopView.akU) + (collectionDataSize % appBrandDesktopView.akU == 0 ? 0 : 1))) + i2;
                    C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight row: %d", Integer.valueOf((collectionDataSize / appBrandDesktopView.akU) + (collectionDataSize % appBrandDesktopView.akU == 0 ? 0 : 1)));
                } else if (collectionDataSize <= 0) {
                    i = i2;
                } else if (appBrandDesktopView.iXB) {
                    i = (C1338a.fromDPToPix(appBrandDesktopView.getContext(), 16) + appBrandDesktopView.getResources().getDimensionPixelSize(C25738R.dimen.f10128qw)) + i2;
                } else {
                    i = appBrandDesktopView.f4360le + i2;
                }
                C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight dataList: %d, mMyAppBrandStartPosition: %d, itemCount: %d", Integer.valueOf(appBrandDesktopView.iPr.size()), Integer.valueOf(appBrandDesktopView.iXg), Integer.valueOf(collectionDataSize));
            } else {
                C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight empty collection and add MyAppBrandEmptyViewHolder height");
                i = (i + appBrandDesktopView.iXw) + (appBrandDesktopView.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10128qw) + appBrandDesktopView.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5));
            }
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight full empty");
            i += appBrandDesktopView.iXx;
        }
        C4990ab.m7417i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight: %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(133887);
        return i;
    }

    /* renamed from: v */
    static /* synthetic */ void m30707v(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133889);
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = new DynamicBackgroundGLSurfaceView(appBrandDesktopView.getContext(), (byte) 0);
        if (appBrandDesktopView.iXl != null) {
            C4990ab.m7416i("MicroMsg.AppBrandDesktopView", "alvinluo addDynamicBackgroundView");
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            dynamicBackgroundGLSurfaceView.setVisibility(8);
            appBrandDesktopView.iXl.addView(dynamicBackgroundGLSurfaceView, 0, layoutParams);
            if (appBrandDesktopView.iVo != null) {
                appBrandDesktopView.iVo.setDynamicBackgroundView(dynamicBackgroundGLSurfaceView);
                GradientColorBackgroundView gradientColorBackgroundView = (GradientColorBackgroundView) appBrandDesktopView.iVo.getBackgroundGradientView();
                if (gradientColorBackgroundView != null) {
                    dynamicBackgroundGLSurfaceView.setGradientBackgroundView(gradientColorBackgroundView);
                }
            }
        }
        AppMethodBeat.m2505o(133889);
    }

    /* renamed from: a */
    static /* synthetic */ void m30673a(AppBrandDesktopView appBrandDesktopView, int i, int i2, LocalUsageInfo localUsageInfo, int i3) {
        AppMethodBeat.m2504i(133890);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i;
        if (localUsageInfo != null) {
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(appBrandDesktopView.getContext(), localUsageInfo.username, null, localUsageInfo.har, -1, null, appBrandStatObject);
            if (!(appBrandDesktopView.iXE == null || C5046bo.isNullOrNil(localUsageInfo.appId))) {
                if (i2 == 1) {
                    appBrandDesktopView.iXE.mo35162bB(localUsageInfo.appId, (i3 - appBrandDesktopView.iXg) + 1);
                    AppMethodBeat.m2505o(133890);
                    return;
                }
                appBrandDesktopView.iXE.mo35161bA(localUsageInfo.appId, i3 + 1);
            }
        }
        AppMethodBeat.m2505o(133890);
    }

    /* renamed from: G */
    static /* synthetic */ boolean m30656G(AppBrandDesktopView appBrandDesktopView) {
        boolean z = false;
        AppMethodBeat.m2504i(133892);
        if (appBrandDesktopView.iXj != null) {
            if (appBrandDesktopView.iXj.mo1783iT() == appBrandDesktopView.iPr.size() - 1 && appBrandDesktopView.iXj.mo1780iQ() == 0) {
                z = true;
            }
            appBrandDesktopView.iXr = z;
        } else {
            appBrandDesktopView.iXr = false;
        }
        z = appBrandDesktopView.iXr;
        AppMethodBeat.m2505o(133892);
        return z;
    }

    /* renamed from: I */
    static /* synthetic */ void m30658I(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133893);
        if (appBrandDesktopView.iXj != null) {
            int iR = appBrandDesktopView.iXj.mo1781iR();
            int iQ = appBrandDesktopView.iXj.mo1780iQ();
            if (iR == 1 && iQ == 0) {
                View childAt = appBrandDesktopView.getChildAt(iR);
                if (childAt != null) {
                    iR = childAt.getTop();
                    appBrandDesktopView.iXQ = true;
                    if (((float) iR) >= ((float) appBrandDesktopView.iXD) * 0.5f) {
                        appBrandDesktopView.smoothScrollToPosition(0);
                        AppMethodBeat.m2505o(133893);
                        return;
                    }
                    appBrandDesktopView.smoothScrollToPosition(1);
                }
            }
        }
        AppMethodBeat.m2505o(133893);
    }

    /* renamed from: M */
    static /* synthetic */ void m30662M(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133894);
        if (appBrandDesktopView.iXE != null) {
            C19916b c19916b = appBrandDesktopView.iXE;
            c19916b.jnk++;
            C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollUpDown %d", Integer.valueOf(c19916b.jnk));
        }
        AppMethodBeat.m2505o(133894);
    }

    /* renamed from: N */
    static /* synthetic */ boolean m30663N(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.m2504i(133895);
        if (appBrandDesktopView.iXj.mo1781iR() == 0) {
            AppMethodBeat.m2505o(133895);
            return true;
        }
        AppMethodBeat.m2505o(133895);
        return false;
    }
}
