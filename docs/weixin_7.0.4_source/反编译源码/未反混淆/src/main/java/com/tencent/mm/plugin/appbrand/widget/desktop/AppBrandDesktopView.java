package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GradientColorBackgroundView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopView extends DragRecyclerView implements com.tencent.mm.plugin.appbrand.widget.header.b.a {
    private android.support.v7.widget.RecyclerView.a Yq;
    private int aKu = 0;
    private int aKv = 0;
    public int akU = 4;
    private int ape = 0;
    private m eja = new m() {
        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(133826);
            super.c(recyclerView, i);
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onScrollStateChanged %d, needScroll: %b", Integer.valueOf(i), Boolean.valueOf(AppBrandDesktopView.this.iXs));
            if (!AppBrandDesktopView.G(AppBrandDesktopView.this) && (AppBrandDesktopView.this.iXs || i == 0)) {
                AppBrandDesktopView.this.iXs = false;
                AppBrandDesktopView.I(AppBrandDesktopView.this);
            }
            if (i == 0) {
                if (AppBrandDesktopView.this.iXQ) {
                    AppBrandDesktopView.this.iXQ = false;
                } else if (AppBrandDesktopView.this.iXP == 1 || AppBrandDesktopView.this.iXP == 2) {
                    AppBrandDesktopView.M(AppBrandDesktopView.this);
                }
                if (!AppBrandDesktopView.N(AppBrandDesktopView.this) || AppBrandDesktopView.this.iXR) {
                    AppBrandDesktopView.this.iXR = false;
                } else {
                    if (AppBrandDesktopView.this.iXE != null) {
                        com.tencent.mm.plugin.appbrand.widget.recentview.b c = AppBrandDesktopView.this.iXE;
                        c.jnl++;
                        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo showSearchView %d", Integer.valueOf(c.jnl));
                    }
                    AppBrandDesktopView.this.iXR = true;
                }
            }
            AppBrandDesktopView.this.iXP = i;
            AppMethodBeat.o(133826);
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.i(133827);
            super.a(recyclerView, i, i2);
            if (AppBrandDesktopView.this.iXk) {
                AppBrandDesktopView.this.iXk = false;
                if (AppBrandDesktopView.this.iXj != null) {
                    int R = AppBrandDesktopView.this.ape - AppBrandDesktopView.this.iXj.iQ();
                    if (R >= 0 && R < AppBrandDesktopView.this.getChildCount()) {
                        AppBrandDesktopView.this.scrollBy(0, AppBrandDesktopView.this.getChildAt(R).getTop());
                    }
                }
            }
            AppMethodBeat.o(133827);
        }
    };
    private ArrayList<c> iPr = new ArrayList();
    HeaderContainer iVo;
    private com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.b iWI = new com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.b() {
        public final void bI(Object obj) {
            AppMethodBeat.i(133821);
            if (obj == null) {
                AppMethodBeat.o(133821);
                return;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.iXW != null) {
                    AppBrandDesktopView.a(AppBrandDesktopView.this);
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo usage to collection reorderCollection result: %b", Boolean.valueOf(AppBrandDesktopView.b(AppBrandDesktopView.this)));
                    if (!(AppBrandDesktopView.this.iXE == null || bo.isNullOrNil(cVar.iXW.appId))) {
                        AppBrandDesktopView.this.iXE.ET(cVar.iXW.appId);
                    }
                    AppBrandDesktopView.a(AppBrandDesktopView.this, ((c) obj).position);
                }
            }
            AppMethodBeat.o(133821);
        }

        public final void bJ(Object obj) {
            AppMethodBeat.i(133822);
            if (obj == null) {
                AppMethodBeat.o(133822);
                return;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.type == 1 && cVar.iXW != null) {
                    AppBrandDesktopView.a(AppBrandDesktopView.this);
                    af afVar = (af) com.tencent.mm.kernel.g.K(af.class);
                    if (afVar == null) {
                        AppMethodBeat.o(133822);
                        return;
                    }
                    if (afVar.aD(cVar.iXW.username, cVar.iXW.har)) {
                        AppBrandDesktopView.a(AppBrandDesktopView.this, ((c) obj).position);
                    }
                    if (!(AppBrandDesktopView.this.iXE == null || bo.isNullOrNil(cVar.iXW.appId))) {
                        AppBrandDesktopView.this.iXE.ES(cVar.iXW.appId);
                    }
                }
            }
            AppMethodBeat.o(133822);
        }

        public final void bK(Object obj) {
            AppMethodBeat.i(133823);
            if (obj == null) {
                AppMethodBeat.o(133823);
                return;
            }
            c cVar = (c) obj;
            if (cVar.iXW != null) {
                boolean aE;
                ab.d("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView removeUsage username: %s, versionType: %d", cVar.iXW.username, Integer.valueOf(cVar.iXW.har));
                AppBrandDesktopView.a(AppBrandDesktopView.this);
                ag agVar = (ag) com.tencent.mm.kernel.g.K(ag.class);
                if (agVar != null) {
                    aE = agVar.aE(cVar.iXW.username, cVar.iXW.har);
                } else {
                    aE = false;
                }
                if (!(AppBrandDesktopView.this.iXE == null || cVar.iXW == null || bo.isNullOrNil(cVar.iXW.appId))) {
                    AppBrandDesktopView.this.iXE.ER(cVar.iXW.appId);
                }
                if (AppBrandDesktopView.this.iXm != null) {
                    if (aE) {
                        AppBrandDesktopView.b(AppBrandDesktopView.this, cVar.position);
                        AppMethodBeat.o(133823);
                        return;
                    }
                    ab.e("MicroMsg.AppBrandDesktopView", "alvinluo removeUsage failed");
                    cVar.type = 2;
                    AppBrandDesktopView.this.iXf.add(cVar.position, cVar);
                    AppBrandDesktopView.this.iXm.setDataList(AppBrandDesktopView.this.iXf);
                    if (AppBrandDesktopView.this.iXn != null) {
                        AppBrandDesktopView.this.iXn.getAdapter().cg(cVar.position);
                    }
                }
            }
            AppMethodBeat.o(133823);
        }

        public final void e(int i, int i2, Object obj) {
            AppMethodBeat.i(133824);
            AppBrandDesktopView.a(AppBrandDesktopView.this);
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo collection reorderCollection result: %b, startPos: %d, endPos: %d", Boolean.valueOf(AppBrandDesktopView.b(AppBrandDesktopView.this)), Integer.valueOf(i), Integer.valueOf(i2));
            if (!(!(obj instanceof c) || AppBrandDesktopView.this.iXE == null || ((c) obj).iXW == null || bo.isNullOrNil(((c) obj).iXW.appId))) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b c;
                if (i < i2) {
                    c = AppBrandDesktopView.this.iXE;
                    ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionBackward id: %s", ((c) obj).iXW.appId);
                    c.jnc++;
                    c.jnj.append(r1 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                } else if (i > i2) {
                    c = AppBrandDesktopView.this.iXE;
                    ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveCollectionForward id: %s", ((c) obj).iXW.appId);
                    c.jnb++;
                    c.jnh.append(r1 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                }
            }
            AppBrandDesktopView.a(AppBrandDesktopView.this, AppBrandDesktopView.this.iXg);
            AppMethodBeat.o(133824);
        }
    };
    private int iXA = 0;
    private boolean iXB = false;
    private View iXC;
    private int iXD = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 80);
    private com.tencent.mm.plugin.appbrand.widget.recentview.b iXE = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    boolean iXF = false;
    private boolean iXG = false;
    boolean iXH = false;
    boolean iXI = false;
    boolean iXJ = false;
    private boolean iXK = false;
    b iXL = new b(1);
    b iXM = new b(2);
    boolean iXN = false;
    boolean iXO = false;
    private int iXP = -1;
    private boolean iXQ = false;
    private boolean iXR = false;
    private ArrayList<c> iXf = new ArrayList();
    private int iXg = 0;
    private boolean iXh = false;
    private boolean iXi = false;
    private j iXj = null;
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
    private int le;
    Context mContext;

    public class f extends v {
        public f(View view) {
            super(view);
            AppMethodBeat.i(133850);
            int r = AppBrandDesktopView.this.le;
            if (r == 0 && this.apJ != null) {
                this.apJ.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(this.apJ.getMeasuredHeight()), Integer.valueOf(this.apJ.getMeasuredWidth()));
                r = this.apJ.getMeasuredHeight();
            }
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            layoutParams.setMargins(layoutParams.leftMargin + AppBrandDesktopView.this.iXq, layoutParams.topMargin - r, layoutParams.rightMargin + AppBrandDesktopView.this.iXq, layoutParams.bottomMargin);
            if (this.apJ != null) {
                this.apJ.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(133850);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ View iXT;

        AnonymousClass2(View view) {
            this.iXT = view;
        }

        public final void run() {
            AppMethodBeat.i(133825);
            ((DynamicBackgroundGLSurfaceView) this.iXT).setShowGradientView(false);
            AppMethodBeat.o(133825);
        }
    }

    public class d extends v {
        public d(View view) {
            super(view);
            AppMethodBeat.i(133841);
            if (AppBrandDesktopView.this.iXx == 0 && this.apJ != null) {
                this.apJ.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo FullEmptyViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(this.apJ.getMeasuredHeight()), Integer.valueOf(this.apJ.getMeasuredWidth()));
                AppBrandDesktopView.this.iXx = this.apJ.getMeasuredHeight();
            }
            AppMethodBeat.o(133841);
        }
    }

    class e extends android.support.v7.widget.RecyclerView.a {
        private e() {
        }

        /* synthetic */ e(AppBrandDesktopView appBrandDesktopView, byte b) {
            this();
        }

        public final v a(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(133845);
            v anonymousClass3;
            View view;
            if (i == 1) {
                e eVar = new e(com.tencent.mm.ui.v.hu(AppBrandDesktopView.this.getContext()).inflate(R.layout.ej, viewGroup, false));
                AppMethodBeat.o(133845);
                return eVar;
            } else if (i == 2) {
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onCreateViewHolder RecentView");
                AppBrandDesktopView.this.iXm = new RecentAppBrandViewContainer(AppBrandDesktopView.this.getContext());
                AppBrandDesktopView.this.iXm.setLayoutParams(new LayoutParams(-1, -2));
                AppBrandDesktopView.this.iXm.setItemPadding(AppBrandDesktopView.this.iXq);
                AppBrandDesktopView.this.iXn = AppBrandDesktopView.this.iXm.getRecentView();
                if (AppBrandDesktopView.this.iXn != null) {
                    AppBrandDesktopView.this.iXn.setReporter(AppBrandDesktopView.this.iXE);
                    AppBrandDesktopView.this.iXn.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.b() {
                        public final void a(c cVar, int i) {
                            AppMethodBeat.i(133842);
                            AppBrandDesktopView.this.iXH = true;
                            AppBrandDesktopView.this.iXI = false;
                            AppBrandDesktopView.this.iXJ = false;
                            AppBrandDesktopView.this.setLayoutFrozen(true);
                            if (cVar != null) {
                                AppBrandDesktopView.a(AppBrandDesktopView.this, FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU, 2, cVar.iXW, i);
                            }
                            AppMethodBeat.o(133842);
                        }
                    });
                }
                AppBrandDesktopView.this.iXm.setDataList(AppBrandDesktopView.this.iXf);
                AppBrandDesktopView.this.iXm.setOnMoreClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(133843);
                        AppBrandDesktopView.this.iXH = false;
                        AppBrandDesktopView.this.iXI = false;
                        AppBrandDesktopView.this.iXJ = false;
                        AppBrandDesktopView.this.iXK = true;
                        ((com.tencent.mm.plugin.appbrand.service.g) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.g.class)).C(view.getContext(), 13);
                        AppMethodBeat.o(133843);
                    }
                });
                anonymousClass3 = new v(AppBrandDesktopView.this.iXm) {
                };
                AppMethodBeat.o(133845);
                return anonymousClass3;
            } else if (i == 3) {
                view = new View(AppBrandDesktopView.this.getContext());
                LayoutParams layoutParams = new LayoutParams(-1, AppBrandDesktopView.this.iXy);
                layoutParams.setMargins(layoutParams.leftMargin + AppBrandDesktopView.this.iXq, layoutParams.topMargin, layoutParams.rightMargin + AppBrandDesktopView.this.iXq, layoutParams.bottomMargin);
                view.setLayoutParams(layoutParams);
                anonymousClass3 = new h(view);
                AppMethodBeat.o(133845);
                return anonymousClass3;
            } else if (i == 6) {
                try {
                    AppBrandDesktopView.this.iXC = com.tencent.mm.ui.v.hu(AppBrandDesktopView.this.getContext()).inflate(R.layout.c0, viewGroup, false);
                    anonymousClass3 = new g(AppBrandDesktopView.this.iXC);
                    AppMethodBeat.o(133845);
                    return anonymousClass3;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", e, "alvinluo init searchView exception", new Object[0]);
                    anonymousClass3 = new g(new View(AppBrandDesktopView.this.getContext()));
                    AppMethodBeat.o(133845);
                    return anonymousClass3;
                }
            } else if (i == 7) {
                view = com.tencent.mm.ui.v.hu(AppBrandDesktopView.this.getContext()).inflate(R.layout.ej, viewGroup, false);
                LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                layoutParams2.setMargins(layoutParams2.leftMargin + AppBrandDesktopView.this.iXq, layoutParams2.topMargin, layoutParams2.rightMargin + AppBrandDesktopView.this.iXq, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
                anonymousClass3 = new e(view);
                AppMethodBeat.o(133845);
                return anonymousClass3;
            } else if (i == 8) {
                anonymousClass3 = new f(com.tencent.mm.ui.v.hu(AppBrandDesktopView.this.getContext()).inflate(R.layout.bu, viewGroup, false));
                AppMethodBeat.o(133845);
                return anonymousClass3;
            } else if (i == 9) {
                anonymousClass3 = new d(com.tencent.mm.ui.v.hu(AppBrandDesktopView.this.getContext()).inflate(R.layout.bv, viewGroup, false));
                AppMethodBeat.o(133845);
                return anonymousClass3;
            } else {
                anonymousClass3 = new h(com.tencent.mm.ui.v.hu(AppBrandDesktopView.this.getContext()).inflate(R.layout.ai6, viewGroup, false));
                AppMethodBeat.o(133845);
                return anonymousClass3;
            }
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(133846);
            c qm = qm(i);
            if (qm != null) {
                int i2 = qm.type;
                AppMethodBeat.o(133846);
                return i2;
            }
            AppMethodBeat.o(133846);
            return 0;
        }

        public final int getItemCount() {
            AppMethodBeat.i(133848);
            int size = AppBrandDesktopView.this.iPr.size();
            AppMethodBeat.o(133848);
            return size;
        }

        private c qm(int i) {
            AppMethodBeat.i(133849);
            if (i >= AppBrandDesktopView.this.iPr.size() || i < 0) {
                AppMethodBeat.o(133849);
                return null;
            }
            c cVar = (c) AppBrandDesktopView.this.iPr.get(i);
            AppMethodBeat.o(133849);
            return cVar;
        }

        public final void a(v vVar, final int i) {
            int i2 = 0;
            AppMethodBeat.i(133847);
            int i3 = vVar.apN;
            int m;
            if (i3 == 3) {
                int n = AppBrandDesktopView.this.iXy;
                if (AppBrandDesktopView.this.iXp == 0) {
                    AppBrandDesktopView.this.iXp = AppBrandDesktopView.this.iVo.getMeasuredHeight();
                }
                i3 = AppBrandDesktopView.this.iXp;
                m = AppBrandDesktopView.m(AppBrandDesktopView.this);
                if (m > AppBrandDesktopView.this.iXD + i3) {
                    AppBrandDesktopView.this.iXy = AppBrandDesktopView.this.iXz;
                } else if (m > i3) {
                    AppBrandDesktopView.this.iXy = AppBrandDesktopView.this.iXD - (m - i3);
                } else {
                    AppBrandDesktopView.this.iXy = (i3 - m) + AppBrandDesktopView.this.iXD;
                }
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeFooterHeight mostHeight: %d, titleHeight: %d, itemHeight: %d, recyclerViewHeight: %d, mFooterHeight: %d, oldFooterHeight: %d, searchLayoutHeight: %d", Integer.valueOf(i3), Integer.valueOf(AppBrandDesktopView.this.iXw), Integer.valueOf(AppBrandDesktopView.this.le), Integer.valueOf(m), Integer.valueOf(AppBrandDesktopView.this.iXy), Integer.valueOf(n), Integer.valueOf(AppBrandDesktopView.this.iXD));
                vVar.apJ.setVisibility(4);
                LayoutParams layoutParams = (LayoutParams) vVar.apJ.getLayoutParams();
                layoutParams.height = AppBrandDesktopView.this.iXy;
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder change footer height: %d", Integer.valueOf(AppBrandDesktopView.this.iXy));
                vVar.apJ.setLayoutParams(layoutParams);
                AppMethodBeat.o(133847);
            } else if (i3 == 10 || i3 == 11) {
                if (vVar == null) {
                    AppMethodBeat.o(133847);
                    return;
                }
                View view = vVar.apJ;
                int w = AppBrandDesktopView.this.iXq + ((int) (((float) com.tencent.mm.bz.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8)) * d.dm(AppBrandDesktopView.this.getContext())));
                LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                layoutParams2.setMargins(layoutParams2.leftMargin + w, layoutParams2.topMargin, w + layoutParams2.rightMargin, layoutParams2.bottomMargin);
                view.setLayoutParams(layoutParams2);
                if (AppBrandDesktopView.this.iXw == 0) {
                    view = vVar.apJ;
                    view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder titleHeight: %d, titleWidth: %d", Integer.valueOf(view.getMeasuredHeight()), Integer.valueOf(view.getMeasuredWidth()));
                    AppBrandDesktopView.this.iXw = view.getMeasuredHeight();
                }
                ((h) vVar).gne.setText(i3 == 10 ? R.string.div : R.string.d48);
                AppMethodBeat.o(133847);
            } else if (i3 == 8) {
                boolean z;
                f fVar = (f) vVar;
                if (AppBrandDesktopView.this.iXi) {
                    z = false;
                } else {
                    z = true;
                }
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo MyAppBrandEmptyViewHolder show: %b", Boolean.valueOf(z));
                if (fVar.apJ != null) {
                    View view2 = fVar.apJ;
                    if (!z) {
                        i2 = 4;
                    }
                    view2.setVisibility(i2);
                }
                AppMethodBeat.o(133847);
            } else if (i3 == 6) {
                AppBrandDesktopView.b(AppBrandDesktopView.this, vVar.apJ);
                AppMethodBeat.o(133847);
            } else if (i3 == 2 || i3 == 9) {
                AppMethodBeat.o(133847);
            } else {
                if (i3 == 1 || i3 == 7) {
                    e eVar = (e) vVar;
                    eVar.apJ.setPadding(AppBrandDesktopView.this.iXq, com.tencent.mm.bz.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 8), AppBrandDesktopView.this.iXq, com.tencent.mm.bz.a.fromDPToPix(AppBrandDesktopView.this.getContext(), 16));
                    m = (int) d.dl(AppBrandDesktopView.this.getContext());
                    eVar.iYe.getLayoutParams().width = ((int) (((float) (com.tencent.mm.bz.a.am(AppBrandDesktopView.this.getContext(), R.dimen.nc) * 2)) * d.dm(AppBrandDesktopView.this.getContext()))) + m;
                    eVar.iYe.getLayoutParams().height = ((int) (((float) (com.tencent.mm.bz.a.am(AppBrandDesktopView.this.getContext(), R.dimen.nc) * 2)) * d.dm(AppBrandDesktopView.this.getContext()))) + m;
                    eVar.iqT.getLayoutParams().width = m;
                    eVar.iqT.getLayoutParams().height = m;
                    eVar.iYd.getLayoutParams().width = m;
                    eVar.iYd.getLayoutParams().height = m;
                    vVar.apJ.setVisibility(0);
                    if (AppBrandDesktopView.this.le == 0) {
                        View view3 = vVar.apJ;
                        view3.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onBindViewHolder itemHeight: %d, itemWidth: %d", Integer.valueOf(view3.getMeasuredHeight()), Integer.valueOf(view3.getMeasuredWidth()));
                        AppBrandDesktopView.this.le = view3.getMeasuredHeight();
                    }
                    if (i3 == 7) {
                        vVar.apJ.setVisibility(4);
                        if (((i - AppBrandDesktopView.this.iXg) + 1) % 4 == 1 && i > AppBrandDesktopView.this.iXg) {
                            vVar.apJ.getLayoutParams().height = 1;
                        }
                        AppMethodBeat.o(133847);
                        return;
                    }
                    final c qm = qm(i);
                    if (qm == null) {
                        AppMethodBeat.o(133847);
                        return;
                    }
                    qm.position = i;
                    eVar.iYh = qm;
                    if (qm.iXW != null) {
                        if (!bo.isNullOrNil(qm.iXW.bQo)) {
                            eVar.gne.setText(com.tencent.mm.plugin.appbrand.widget.desktop.c.a.Ey(qm.iXW.bQo));
                            eVar.gne.setVisibility(0);
                        } else if (!bo.isNullOrNil(qm.iXW.nickname)) {
                            eVar.gne.setText(com.tencent.mm.plugin.appbrand.widget.desktop.c.a.Ey(qm.iXW.nickname));
                            eVar.gne.setVisibility(0);
                        } else if (bo.isNullOrNil(qm.iXW.username)) {
                            ab.w("MicroMsg.AppBrandDesktopView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", qm.iXW.username, qm.iXW.appId);
                            eVar.gne.setVisibility(4);
                        } else {
                            eVar.gne.setText(com.tencent.mm.plugin.appbrand.widget.desktop.c.a.Ey(qm.iXW.nickname));
                            eVar.gne.setVisibility(0);
                        }
                        eVar.iYd.setVisibility(0);
                        if (bo.isNullOrNil(qm.iXW.haO)) {
                            eVar.iqT.setImageDrawable(com.tencent.mm.modelappbrand.a.a.abQ());
                        } else {
                            com.tencent.mm.modelappbrand.a.b.abR().a(eVar.iqT, qm.iXW.haO, com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH);
                        }
                        if (bo.isNullOrNil(com.tencent.mm.plugin.appbrand.appcache.b.no(qm.iXW.har))) {
                            eVar.iYf.setVisibility(8);
                        } else {
                            eVar.iYf.setVisibility(0);
                            eVar.iYf.setText(com.tencent.mm.plugin.appbrand.appcache.b.no(qm.iXW.har));
                        }
                        eVar.apJ.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(133844);
                                AppBrandDesktopView.this.iXH = true;
                                AppBrandDesktopView.this.iXI = false;
                                AppBrandDesktopView.this.iXJ = false;
                                AppBrandDesktopView.this.setLayoutFrozen(true);
                                AppBrandDesktopView.a(AppBrandDesktopView.this, 1104, 1, qm.iXW, i);
                                AppMethodBeat.o(133844);
                            }
                        });
                    } else {
                        com.tencent.mm.modelappbrand.a.b.abR().a(eVar.iqT, "", com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH);
                        eVar.gne.setVisibility(0);
                        eVar.iYf.setVisibility(8);
                        eVar.gne.setText("");
                    }
                }
                if (AppBrandDesktopView.this.getDragRubbishView() != null) {
                    DragFeatureView dragRubbishView = AppBrandDesktopView.this.getDragRubbishView();
                    if (dragRubbishView.getVisibility() != 8) {
                        if (dragRubbishView.iYm == i) {
                            vVar.apJ.setVisibility(4);
                            AppMethodBeat.o(133847);
                            return;
                        }
                        vVar.apJ.setVisibility(0);
                    }
                }
                AppMethodBeat.o(133847);
            }
        }
    }

    public class g extends v {
        protected EditText iXZ;
        private long iYa = 0;

        public g(View view) {
            super(view);
            AppMethodBeat.i(133852);
            this.iXZ = (EditText) view.findViewById(R.id.q8);
            if (this.iXZ != null) {
                this.iXZ.setFocusable(false);
                this.iXZ.setOnClickListener(new OnClickListener(AppBrandDesktopView.this) {
                    public final void onClick(View view) {
                        AppMethodBeat.i(133851);
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
                        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppbrandDesktop search jump to AppBrandSearchUI");
                        long currentTimeMillis = System.currentTimeMillis();
                        if (AppBrandDesktopView.this.iXE != null && (g.this.iYa == 0 || currentTimeMillis - g.this.iYa > 1000)) {
                            g.this.iYa = currentTimeMillis;
                            com.tencent.mm.plugin.appbrand.widget.recentview.b c = AppBrandDesktopView.this.iXE;
                            c.jnm++;
                            ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo clickSearchView %d", Integer.valueOf(c.jnm));
                        }
                        com.tencent.mm.plugin.websearch.api.j jVar = (com.tencent.mm.plugin.websearch.api.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.websearch.api.j.class);
                        if (jVar != null) {
                            jVar.aa(AppBrandDesktopView.this.mContext, 42);
                        }
                        AppMethodBeat.o(133851);
                    }
                });
            }
            AppMethodBeat.o(133852);
        }
    }

    class a implements com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.a {
        private a() {
        }

        /* synthetic */ a(AppBrandDesktopView appBrandDesktopView, byte b) {
            this();
        }

        public final int aPl() {
            AppMethodBeat.i(133839);
            int h = AppBrandDesktopView.h(AppBrandDesktopView.this);
            AppMethodBeat.o(133839);
            return h;
        }
    }

    class j extends GridLayoutManager {
        public j(int i) {
            super(i, (byte) 0);
        }

        public final void c(o oVar, s sVar) {
            AppMethodBeat.i(133855);
            try {
                super.c(oVar, sVar);
                AppMethodBeat.o(133855);
            } catch (IndexOutOfBoundsException e) {
                ab.e("MicroMsg.AppBrandDesktopView", "[onLayoutChildren] IndexOutOfBoundsException!!");
                AppMethodBeat.o(133855);
            }
        }

        public final void a(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(133856);
            i iVar = new i(AppBrandDesktopView.this.mContext);
            iVar.ape = i;
            a((r) iVar);
            AppMethodBeat.o(133856);
        }
    }

    class b implements com.tencent.mm.sdk.e.k.a {
        boolean iXG = false;
        private int mType;

        public b(int i) {
            this.mType = i;
        }

        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(133840);
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onNotifyChange type: %d, ignore: %b, eventId: %d", Integer.valueOf(this.mType), Boolean.valueOf(this.iXG), Integer.valueOf(mVar.hsh));
            if (mVar.hsh == -1) {
                ab.w("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange pass eventId: %d", Integer.valueOf(mVar.hsh));
                AppMethodBeat.o(133840);
            } else if (this.iXG) {
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView onNotifyChange ignoreNotify");
                this.iXG = false;
                AppMethodBeat.o(133840);
            } else {
                AppBrandDesktopView.i(AppBrandDesktopView.this);
                AppMethodBeat.o(133840);
            }
        }
    }

    public static class c {
        public LocalUsageInfo iXW;
        public int position;
        public int type;

        public c(int i) {
            this.type = i;
        }
    }

    public class h extends v {
        protected TextView gne;

        public h(View view) {
            super(view);
            AppMethodBeat.i(133853);
            this.gne = (TextView) view.findViewById(R.id.pv);
            AppMethodBeat.o(133853);
        }
    }

    class i extends android.support.v7.widget.ah {
        i(Context context) {
            super(context);
        }

        public final PointF bX(int i) {
            AppMethodBeat.i(133854);
            PointF bX = AppBrandDesktopView.this.iXj.bX(i);
            AppMethodBeat.o(133854);
            return bX;
        }

        public final int e(int i, int i2, int i3, int i4, int i5) {
            return i3 - i;
        }

        public final float c(DisplayMetrics displayMetrics) {
            return 300.0f / ((float) displayMetrics.densityDpi);
        }
    }

    static /* synthetic */ void a(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133881);
        appBrandDesktopView.setIgnoreNotify(true);
        AppMethodBeat.o(133881);
    }

    static /* synthetic */ boolean b(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133882);
        boolean qi = appBrandDesktopView.qi(0);
        AppMethodBeat.o(133882);
        return qi;
    }

    static /* synthetic */ int h(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133885);
        int collectionDataSize = appBrandDesktopView.getCollectionDataSize();
        AppMethodBeat.o(133885);
        return collectionDataSize;
    }

    static /* synthetic */ void i(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133886);
        appBrandDesktopView.aPr();
        AppMethodBeat.o(133886);
    }

    static /* synthetic */ void s(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133888);
        appBrandDesktopView.aMq();
        AppMethodBeat.o(133888);
    }

    private void setIgnoreNotify(boolean z) {
        if (this.iXM != null) {
            this.iXM.iXG = z;
        }
        if (this.iXL != null) {
            this.iXL.iXG = z;
        }
    }

    private boolean qi(int i) {
        boolean z = false;
        AppMethodBeat.i(133857);
        ab.d("MicroMsg.AppBrandDesktopView", "alvinluo reorderCollection");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.iPr.size(); i2++) {
            c cVar = (c) this.iPr.get(i2);
            if (cVar.type == 1 && cVar.iXW != null) {
                arrayList.add(cVar.iXW);
            }
        }
        af afVar = (af) com.tencent.mm.kernel.g.K(af.class);
        if (afVar == null) {
            AppMethodBeat.o(133857);
        } else {
            z = afVar.g(arrayList, i);
            if (!z) {
                ab.e("MicroMsg.AppBrandDesktopView", "alvinluo reorederCollection failed, needProcessResult: %b");
            }
            AppMethodBeat.o(133857);
        }
        return z;
    }

    private void aPm() {
        AppMethodBeat.i(133858);
        this.iPr.clear();
        this.iPr.add(new c(6));
        this.iPr.add(new c(9));
        this.iPr.add(new c(3));
        this.iXh = false;
        this.iXi = false;
        this.iXB = false;
        this.Yq.aop.notifyChanged();
        eU(true);
        AppMethodBeat.o(133858);
    }

    private void aPn() {
        int i = 0;
        AppMethodBeat.i(133859);
        ab.d("MicroMsg.AppBrandDesktopView", "alvinluo checkEmptyNum currentEmptyNum: %d, myAppBrandNum: %d, toAddEmptyNum: %d", Integer.valueOf(this.iXA), Integer.valueOf(this.iPr.size() - 4), Integer.valueOf(1));
        while (i <= 0) {
            this.iPr.add(new c(7));
            i++;
        }
        this.iXA = 1;
        AppMethodBeat.o(133859);
    }

    public AppBrandDesktopView(Context context) {
        super(context);
        AppMethodBeat.i(133860);
        init(context);
        AppMethodBeat.o(133860);
    }

    public AppBrandDesktopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133861);
        init(context);
        AppMethodBeat.o(133861);
    }

    public AppBrandDesktopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(133862);
        init(context);
        AppMethodBeat.o(133862);
    }

    public void setHeaderContainer(HeaderContainer headerContainer) {
        this.iVo = headerContainer;
    }

    /* Access modifiers changed, original: protected */
    public void onVisibilityChanged(View view, int i) {
        AppMethodBeat.i(133863);
        super.onVisibilityChanged(view, i);
        ab.d("MicroMsg.AppBrandDesktopView", "[onVisibilityChanged] visibility:".concat(String.valueOf(i)));
        if (i == 8 || i == 4) {
            if (this.iXK && this.iVo != null) {
                this.iVo.k(200, 9);
                this.iXK = false;
            }
            if (this.iXv) {
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onVisibilityChanged needRefresh");
                this.iXv = false;
                if (this.iXu != null) {
                    removeCallbacks(this.iXu);
                }
                AnonymousClass6 anonymousClass6 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(133832);
                        AppBrandDesktopView.this.setLayoutFrozen(false);
                        AppMethodBeat.o(133832);
                    }
                };
                this.iXu = anonymousClass6;
                postDelayed(anonymousClass6, 1000);
            }
        }
        AppMethodBeat.o(133863);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(133864);
        super.onAttachedToWindow();
        View rootView = getRootView();
        if (rootView == null) {
            AppMethodBeat.o(133864);
            return;
        }
        this.iXo = (AppBrandDesktopDragView) rootView.findViewById(R.id.an);
        String str = "MicroMsg.AppBrandDesktopView";
        String str2 = "alvinluo onAttachedToWindow mDragFeatureView == null: %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.iXo == null);
        ab.i(str, str2, objArr);
        this.iXo.setRecyclerView(this);
        this.iXo.setCopyList(this.iXf);
        this.iXo.setList(this.iPr);
        this.iXo.setHeaderContainer(this.iVo);
        this.iXo.setCollectionCallback(this.iWI);
        this.iXo.setItemPadding(this.iXq);
        this.iXo.setAppBrandCounter(new a(this, (byte) 0));
        this.iXo.setRecyclerViewScrollComputer(new g() {
            public final int computeVerticalScrollRange() {
                AppMethodBeat.i(133833);
                int m = AppBrandDesktopView.m(AppBrandDesktopView.this) + AppBrandDesktopView.this.iXy;
                AppMethodBeat.o(133833);
                return m;
            }

            public final int computeVerticalScrollOffset() {
                AppMethodBeat.i(133834);
                if (AppBrandDesktopView.this.getChildCount() == 0) {
                    AppMethodBeat.o(133834);
                    return 0;
                }
                try {
                    int iQ = AppBrandDesktopView.this.iXj.iQ();
                    int i = -((int) AppBrandDesktopView.this.iXj.bW(iQ).getY());
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute offsetY: %d", Integer.valueOf(i));
                    int i2 = 0;
                    while (i2 < iQ) {
                        int i3;
                        c cVar = (c) AppBrandDesktopView.this.iPr.get(i2);
                        if (cVar != null) {
                            i3 = cVar.type;
                            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute type: %d, i: %d", Integer.valueOf(i3), Integer.valueOf(i2));
                            if (i3 == 10 || i3 == 11) {
                                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute title add height: %s", Integer.valueOf(AppBrandDesktopView.this.iXw));
                                i3 = AppBrandDesktopView.this.iXw + i;
                                i2++;
                                i = i3;
                            } else {
                                if (i3 == 6) {
                                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute search add height: %s", Integer.valueOf(AppBrandDesktopView.this.iXD));
                                    i3 = AppBrandDesktopView.this.iXD + i;
                                } else if (i3 == 2) {
                                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute recent add height: %s", Integer.valueOf(AppBrandDesktopView.this.le));
                                    i3 = AppBrandDesktopView.this.le + i;
                                } else if (i3 == 1 && (i2 - AppBrandDesktopView.this.iXg) % 4 == 0) {
                                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo compute collection item add height: %s", Integer.valueOf(AppBrandDesktopView.this.le));
                                    i3 = AppBrandDesktopView.this.le + i;
                                }
                                i2++;
                                i = i3;
                            }
                        }
                        i3 = i;
                        i2++;
                        i = i3;
                    }
                    AppMethodBeat.o(133834);
                    return i;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandDesktopView", e, "alvinluo compute exception", new Object[0]);
                    AppMethodBeat.o(133834);
                    return 0;
                }
            }
        });
        this.iYz = this.iXo;
        if (this.iXo != null && (this.iXo.getParent() instanceof RelativeLayout)) {
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onAttachedToWindow get root container");
            this.iXl = (RelativeLayout) this.iXo.getParent();
        }
        AppMethodBeat.o(133864);
    }

    private void aPo() {
        AppMethodBeat.i(133865);
        this.iXq = getItemPadding();
        AppMethodBeat.o(133865);
    }

    public int getLeftRightMargin() {
        AppMethodBeat.i(133866);
        int dk = d.dk(getContext()) - this.iXq;
        if (dk < 0) {
            dk = 0;
        }
        ab.d("MicroMsg.AppBrandDesktopView", "alvinluo getLeftRightMargin: %d, mGridItemPadding: %d", Integer.valueOf(dk), Integer.valueOf(this.iXq));
        AppMethodBeat.o(133866);
        return dk;
    }

    private void init(Context context) {
        AppMethodBeat.i(133867);
        this.mContext = context;
        this.iXz = 0;
        this.iXy = this.iXz;
        b.init(this.mContext);
        this.akU = b.getCompletelyCountPerPage();
        aPo();
        aPq();
        this.iXj = new j(this.akU);
        this.iXj.akZ = new android.support.v7.widget.GridLayoutManager.b() {
            public final int bU(int i) {
                AppMethodBeat.i(133835);
                int itemViewType = AppBrandDesktopView.this.getAdapter().getItemViewType(i);
                if (itemViewType == 3 || itemViewType == 11 || itemViewType == 10 || itemViewType == 2 || itemViewType == 6 || itemViewType == 8 || itemViewType == 9) {
                    itemViewType = AppBrandDesktopView.this.akU;
                    AppMethodBeat.o(133835);
                    return itemViewType;
                }
                AppMethodBeat.o(133835);
                return 1;
            }
        };
        setLayoutManager(this.iXj);
        setOverScrollMode(2);
        a(this.eja);
        this.Yq = new e(this, (byte) 0);
        setAdapter(this.Yq);
        aPr();
        aPp();
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133836);
                AppBrandDesktopView.s(AppBrandDesktopView.this);
                AppMethodBeat.o(133836);
            }
        }, 200);
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView init %d, searchView height: %d", Integer.valueOf(hashCode()), Integer.valueOf(this.iXD));
        AppMethodBeat.o(133867);
    }

    /* Access modifiers changed, original: final */
    public final void aPp() {
        AppMethodBeat.i(133868);
        if (this.iXN) {
            AppMethodBeat.o(133868);
            return;
        }
        ag agVar = (ag) com.tencent.mm.kernel.g.K(ag.class);
        af afVar = (af) com.tencent.mm.kernel.g.K(af.class);
        if (agVar == null || afVar == null) {
            AppMethodBeat.o(133868);
            return;
        }
        this.iXN = true;
        agVar.d(this.iXM);
        agVar.c(this.iXM);
        afVar.d(this.iXL);
        afVar.c(this.iXL);
        AppMethodBeat.o(133868);
    }

    private int getItemPadding() {
        AppMethodBeat.i(133869);
        int dj = d.dj(getContext());
        AppMethodBeat.o(133869);
        return dj;
    }

    private void aPq() {
        AppMethodBeat.i(133870);
        setVerticalFadingEdgeEnabled(true);
        setNestedScrollingEnabled(true);
        setBackgroundColor(getContext().getResources().getColor(R.color.a3p));
        AppMethodBeat.o(133870);
    }

    private void aPr() {
        List nA;
        List a;
        AppMethodBeat.i(133871);
        long currentTimeMillis = System.currentTimeMillis();
        this.iPr.clear();
        this.iXf.clear();
        this.iXA = 0;
        this.iXB = false;
        this.iPr.add(new c(6));
        if (com.tencent.mm.kernel.g.K(ag.class) != null) {
            nA = ((ag) com.tencent.mm.kernel.g.K(ag.class)).nA(50);
        } else {
            nA = null;
        }
        if (com.tencent.mm.kernel.g.K(af.class) != null) {
            a = ((af) com.tencent.mm.kernel.g.K(af.class)).a(BaseClientBuilder.API_PRIORITY_OTHER, com.tencent.mm.plugin.appbrand.appusage.af.a.DESC);
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
            c cVar = new c(0);
            if (!(nA == null || nA.isEmpty())) {
                this.iPr.add(new c(10));
                this.iPr.add(new c(2));
                for (int i = 0; i < nA.size(); i++) {
                    c cVar2 = new c(2);
                    cVar2.iXW = (LocalUsageInfo) nA.get(i);
                    this.iXf.add(cVar2);
                }
            }
            this.iPr.add(new c(11));
            if (a != null) {
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo makeData myList: %d", Integer.valueOf(a.size()));
                for (int i2 = 0; i2 < a.size(); i2++) {
                    c cVar3 = new c(1);
                    cVar3.iXW = (LocalUsageInfo) a.get(i2);
                    this.iPr.add(cVar3);
                }
            }
            aPn();
            if (!this.iXi) {
                this.iPr.add(new c(8));
                this.iXB = true;
            }
            this.iPr.add(new c(3));
            if (this.iXo != null) {
                this.iXo.setCopyList(this.iXf);
                this.iXo.setList(this.iPr);
            }
            ab.d("MicroMsg.AppBrandDesktopView", "[makeData] cost: %d, isShow: %b, isPaused: %b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isShown()), Boolean.valueOf(this.isPaused));
            if (this.anv) {
                this.iXv = true;
            }
            this.Yq.aop.notifyChanged();
            if (this.iXm != null) {
                ab.d("MicroMsg.AppBrandDesktopView", "alvinluo makeData RecentView notifyDataSetChanged");
                this.iXm.setDataList(this.iXf);
                this.iXm.notifyDataSetChanged();
            }
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo AppBrandDesktopView init mDataList: %d, recentDataCount: %d, myAppBrandCount: %d", Integer.valueOf(this.iPr.size()), Integer.valueOf(this.iXf.size()), Integer.valueOf(this.iPr.size() - this.iXg));
            AppMethodBeat.o(133871);
            return;
        }
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo DesktopView add fullEmpty item");
        this.iPr.add(new c(9));
        this.iPr.add(new c(3));
        AppMethodBeat.o(133871);
    }

    /* Access modifiers changed, original: protected */
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(133872);
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        this.aKu = size;
        this.aKv = size2;
        size = d.c(this.aKu, getContext());
        if (size != this.iXq) {
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo notifyItemPaddingChanged itemPadding old: %d, new: %d", Integer.valueOf(this.iXq), Integer.valueOf(size));
            b.init(getContext());
            this.iXq = size;
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo updateItemPadding %d", Integer.valueOf(this.iXq));
            if (this.iXm != null) {
                this.iXm.setItemPadding(this.iXq);
                if (this.iXn != null) {
                    this.iXn.aPw();
                }
            }
            if (this.Yq != null) {
                this.Yq.aop.notifyChanged();
            }
            if (this.iVo != null) {
                this.iVo.aPi();
            }
        }
        AppMethodBeat.o(133872);
    }

    private void aMq() {
        AppMethodBeat.i(133873);
        ab.d("MicroMsg.AppBrandDesktopView", "alvinluo resetSearchView");
        if (this.iXi || this.iXh) {
            eU(false);
            AppMethodBeat.o(133873);
            return;
        }
        eU(true);
        AppMethodBeat.o(133873);
    }

    public RecyclerView getRecyclerView() {
        return this;
    }

    private int getCollectionDataSize() {
        AppMethodBeat.i(133874);
        if (this.iXi) {
            int size = ((this.iPr.size() - this.iXg) - this.iXA) - 1;
            AppMethodBeat.o(133874);
            return size;
        }
        AppMethodBeat.o(133874);
        return 0;
    }

    public final void aPs() {
        AppMethodBeat.i(133875);
        ab.i("MicroMsg.AppBrandDesktopView", "[onOpenHeader]");
        if (!this.iXF) {
            com.tencent.mm.plugin.appbrand.report.e.Dz(com.tencent.mm.plugin.appbrand.report.e.aLc());
            if (!(this.iXE == null || this.iXn == null)) {
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onOpenHeader report open recentCount: %d, collectionCount: %d", Integer.valueOf(this.iXn.getShowCount()), Integer.valueOf(getCollectionDataSize()));
                this.iXE.dw(this.iXn.getShowCount(), getCollectionDataSize());
                com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(133837);
                        if (AppBrandDesktopView.this.iXi && AppBrandDesktopView.this.iXh) {
                            if (AppBrandDesktopView.this.iXn == null) {
                                AppMethodBeat.o(133837);
                                return;
                            }
                            int i;
                            c cVar;
                            com.tencent.mm.plugin.appbrand.widget.recentview.a aVar;
                            List showList = AppBrandDesktopView.this.iXn.getShowList();
                            ArrayList arrayList = new ArrayList();
                            int i2 = 0;
                            while (true) {
                                i = i2;
                                if (i >= showList.size()) {
                                    break;
                                }
                                cVar = (c) showList.get(i);
                                if (!(cVar == null || cVar.iXW == null)) {
                                    aVar = new com.tencent.mm.plugin.appbrand.widget.recentview.a(cVar.iXW);
                                    aVar.position = i;
                                    arrayList.add(aVar);
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
                                cVar = (c) AppBrandDesktopView.this.iPr.get(i);
                                if (cVar != null && cVar.type == 1) {
                                    aVar = new com.tencent.mm.plugin.appbrand.widget.recentview.a(cVar.iXW);
                                    aVar.position = i;
                                    arrayList2.add(aVar);
                                }
                                i2 = i + 1;
                            }
                            com.tencent.mm.plugin.appbrand.widget.recentview.b.f(arrayList, arrayList2);
                        }
                        AppMethodBeat.o(133837);
                    }
                });
            }
            this.iXF = true;
            this.iXI = true;
            this.iXJ = true;
        }
        setLayoutFrozen(false);
        AppMethodBeat.o(133875);
    }

    public final void qj(int i) {
        AppMethodBeat.i(133876);
        ab.i("MicroMsg.AppBrandDesktopView", "[onCloseHeader]");
        if (this.iXF) {
            if (!(this.iXE == null || this.iXn == null)) {
                com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = this.iXE;
                bVar.jnn = b.aPe();
                ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo enableNativeDynamicBackground %b", Boolean.valueOf(r1));
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo onCloseHeader report close recentCount: %d, collectionCount: %d, reason: %d", Integer.valueOf(this.iXn.getShowCount()), Integer.valueOf(getCollectionDataSize()), Integer.valueOf(i));
                bVar = this.iXE;
                int showCount = this.iXn.getShowCount();
                int collectionDataSize = getCollectionDataSize();
                bVar.jmO = showCount;
                bVar.jmX = collectionDataSize;
                bVar.jmL = i;
                com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                    public final void run() {
                        int i = 1;
                        AppMethodBeat.i(114932);
                        if (b.this.jmK <= 0) {
                            ab.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
                            AppMethodBeat.o(114932);
                            return;
                        }
                        ab.i("MicroMsg.AppBrandRecentViewReporter", "mOpenTime: %d, mRecentCountAtOpen: %d, mRecentCountAtClose: %d, mCloseType: %d, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %d, mDeleteRecentAppBrandList: %s,\nmStarCountAtOpen: %d, mStarCountAtClose: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s,\nmClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s, fullScreen: %b,\nmMoveStarAppBrandForwardCount: %d, mMoveStarAppBrandBackwardCount: %d, mScrollUpDown: %d, mShowSearchViewCount: %d, mClickSearchViewCount: %d,\nmMoveStarAppBrandForwardList: %s, mMoveStarAppBrandBackwardList: %s, mEnableNativeDynamicBackground: %b", Long.valueOf(b.this.jmK), Integer.valueOf(b.this.jmN), Integer.valueOf(b.this.jmO), Integer.valueOf(b.this.jmL), b.this.jmS.toString(), Integer.valueOf(b.this.jmQ), b.this.jmT.toString(), Integer.valueOf(b.this.jmW), Integer.valueOf(b.this.jmX), b.this.jnd.toString(), Integer.valueOf(b.this.jmZ), b.this.jne.toString(), b.this.jmU.toString(), b.this.jng.toString(), Integer.valueOf(b.this.jmR), b.this.jmV.toString(), Boolean.TRUE, Integer.valueOf(b.this.jnb), Integer.valueOf(b.this.jnc), Integer.valueOf(b.this.jnk), Integer.valueOf(b.this.jnl), Integer.valueOf(b.this.jnm), b.this.jnh.toString(), b.this.jnj.toString(), Boolean.valueOf(b.this.jnn));
                        h hVar = h.pYm;
                        Object[] objArr = new Object[32];
                        objArr[0] = Long.valueOf(b.this.jmK);
                        objArr[1] = Integer.valueOf(b.this.jmN);
                        objArr[2] = Integer.valueOf(b.this.jmO);
                        objArr[3] = Integer.valueOf(b.this.jmL);
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = b.this.jmS.toString();
                        objArr[6] = Integer.valueOf(b.this.jmQ);
                        objArr[7] = b.this.jmT.toString();
                        objArr[8] = Integer.valueOf(0);
                        objArr[9] = Integer.valueOf(b.this.jmW);
                        objArr[10] = Integer.valueOf(b.this.jmX);
                        objArr[11] = Integer.valueOf(0);
                        objArr[12] = b.this.jnd.toString();
                        objArr[13] = Integer.valueOf(b.this.jmZ);
                        objArr[14] = b.this.jne.toString();
                        objArr[15] = Integer.valueOf(0);
                        objArr[16] = b.this.jmU.toString();
                        objArr[17] = b.this.jng.toString();
                        objArr[18] = "";
                        objArr[19] = Integer.valueOf(b.this.jmR);
                        objArr[20] = b.this.jmV.toString();
                        objArr[21] = Integer.valueOf(1);
                        objArr[22] = Integer.valueOf(0);
                        objArr[23] = Integer.valueOf(0);
                        objArr[24] = Integer.valueOf(b.this.jnb);
                        objArr[25] = Integer.valueOf(b.this.jnc);
                        objArr[26] = Integer.valueOf(b.this.jnk);
                        objArr[27] = Integer.valueOf(b.this.jnl);
                        objArr[28] = Integer.valueOf(b.this.jnm);
                        objArr[29] = b.this.jnh.toString();
                        objArr[30] = b.this.jnj.toString();
                        if (!b.this.jnn) {
                            i = 0;
                        }
                        objArr[31] = Integer.valueOf(i);
                        hVar.e(15081, objArr);
                        b.a(b.this);
                        AppMethodBeat.o(114932);
                    }
                });
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
        qi(1);
        AppMethodBeat.o(133876);
    }

    public final void qk(int i) {
        AppMethodBeat.i(133877);
        qj(i);
        AppMethodBeat.o(133877);
    }

    public final void aPt() {
        AppMethodBeat.i(133878);
        aPs();
        AppMethodBeat.o(133878);
    }

    private void eU(boolean z) {
        AppMethodBeat.i(133879);
        ql(z ? 0 : 1);
        AppMethodBeat.o(133879);
    }

    private void ql(int i) {
        AppMethodBeat.i(133880);
        this.ape = i;
        int iQ = this.iXj.iQ();
        int iS = this.iXj.iS();
        if (i <= iQ) {
            bY(i);
            AppMethodBeat.o(133880);
        } else if (i <= iS) {
            scrollBy(0, getChildAt(i - iQ).getTop());
            AppMethodBeat.o(133880);
        } else {
            bY(i);
            this.iXk = true;
            AppMethodBeat.o(133880);
        }
    }

    static /* synthetic */ int m(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133887);
        int i = appBrandDesktopView.iXD;
        if (appBrandDesktopView.iXh || appBrandDesktopView.iXi) {
            if (appBrandDesktopView.iXh) {
                i += appBrandDesktopView.iXw + appBrandDesktopView.le;
            }
            if (appBrandDesktopView.iXi) {
                int i2 = appBrandDesktopView.iXw + i;
                int collectionDataSize = appBrandDesktopView.getCollectionDataSize();
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight itemCount: %d", Integer.valueOf(collectionDataSize));
                if (collectionDataSize > appBrandDesktopView.akU) {
                    i = (appBrandDesktopView.le * ((collectionDataSize / appBrandDesktopView.akU) + (collectionDataSize % appBrandDesktopView.akU == 0 ? 0 : 1))) + i2;
                    ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight row: %d", Integer.valueOf((collectionDataSize / appBrandDesktopView.akU) + (collectionDataSize % appBrandDesktopView.akU == 0 ? 0 : 1)));
                } else if (collectionDataSize <= 0) {
                    i = i2;
                } else if (appBrandDesktopView.iXB) {
                    i = (com.tencent.mm.bz.a.fromDPToPix(appBrandDesktopView.getContext(), 16) + appBrandDesktopView.getResources().getDimensionPixelSize(R.dimen.qw)) + i2;
                } else {
                    i = appBrandDesktopView.le + i2;
                }
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight dataList: %d, mMyAppBrandStartPosition: %d, itemCount: %d", Integer.valueOf(appBrandDesktopView.iPr.size()), Integer.valueOf(appBrandDesktopView.iXg), Integer.valueOf(collectionDataSize));
            } else {
                ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight empty collection and add MyAppBrandEmptyViewHolder height");
                i = (i + appBrandDesktopView.iXw) + (appBrandDesktopView.mContext.getResources().getDimensionPixelSize(R.dimen.qw) + appBrandDesktopView.mContext.getResources().getDimensionPixelSize(R.dimen.l5));
            }
        } else {
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight full empty");
            i += appBrandDesktopView.iXx;
        }
        ab.i("MicroMsg.AppBrandDesktopView", "alvinluo computeRecyclerViewTotalHeight: %d", Integer.valueOf(i));
        AppMethodBeat.o(133887);
        return i;
    }

    static /* synthetic */ void v(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133889);
        DynamicBackgroundGLSurfaceView dynamicBackgroundGLSurfaceView = new DynamicBackgroundGLSurfaceView(appBrandDesktopView.getContext(), (byte) 0);
        if (appBrandDesktopView.iXl != null) {
            ab.i("MicroMsg.AppBrandDesktopView", "alvinluo addDynamicBackgroundView");
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
        AppMethodBeat.o(133889);
    }

    static /* synthetic */ void a(AppBrandDesktopView appBrandDesktopView, int i, int i2, LocalUsageInfo localUsageInfo, int i3) {
        AppMethodBeat.i(133890);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = i;
        if (localUsageInfo != null) {
            ((com.tencent.mm.plugin.appbrand.service.e) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.service.e.class)).a(appBrandDesktopView.getContext(), localUsageInfo.username, null, localUsageInfo.har, -1, null, appBrandStatObject);
            if (!(appBrandDesktopView.iXE == null || bo.isNullOrNil(localUsageInfo.appId))) {
                if (i2 == 1) {
                    appBrandDesktopView.iXE.bB(localUsageInfo.appId, (i3 - appBrandDesktopView.iXg) + 1);
                    AppMethodBeat.o(133890);
                    return;
                }
                appBrandDesktopView.iXE.bA(localUsageInfo.appId, i3 + 1);
            }
        }
        AppMethodBeat.o(133890);
    }

    static /* synthetic */ boolean G(AppBrandDesktopView appBrandDesktopView) {
        boolean z = false;
        AppMethodBeat.i(133892);
        if (appBrandDesktopView.iXj != null) {
            if (appBrandDesktopView.iXj.iT() == appBrandDesktopView.iPr.size() - 1 && appBrandDesktopView.iXj.iQ() == 0) {
                z = true;
            }
            appBrandDesktopView.iXr = z;
        } else {
            appBrandDesktopView.iXr = false;
        }
        z = appBrandDesktopView.iXr;
        AppMethodBeat.o(133892);
        return z;
    }

    static /* synthetic */ void I(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133893);
        if (appBrandDesktopView.iXj != null) {
            int iR = appBrandDesktopView.iXj.iR();
            int iQ = appBrandDesktopView.iXj.iQ();
            if (iR == 1 && iQ == 0) {
                View childAt = appBrandDesktopView.getChildAt(iR);
                if (childAt != null) {
                    iR = childAt.getTop();
                    appBrandDesktopView.iXQ = true;
                    if (((float) iR) >= ((float) appBrandDesktopView.iXD) * 0.5f) {
                        appBrandDesktopView.smoothScrollToPosition(0);
                        AppMethodBeat.o(133893);
                        return;
                    }
                    appBrandDesktopView.smoothScrollToPosition(1);
                }
            }
        }
        AppMethodBeat.o(133893);
    }

    static /* synthetic */ void M(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133894);
        if (appBrandDesktopView.iXE != null) {
            com.tencent.mm.plugin.appbrand.widget.recentview.b bVar = appBrandDesktopView.iXE;
            bVar.jnk++;
            ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollUpDown %d", Integer.valueOf(bVar.jnk));
        }
        AppMethodBeat.o(133894);
    }

    static /* synthetic */ boolean N(AppBrandDesktopView appBrandDesktopView) {
        AppMethodBeat.i(133895);
        if (appBrandDesktopView.iXj.iR() == 0) {
            AppMethodBeat.o(133895);
            return true;
        }
        AppMethodBeat.o(133895);
        return false;
    }
}
