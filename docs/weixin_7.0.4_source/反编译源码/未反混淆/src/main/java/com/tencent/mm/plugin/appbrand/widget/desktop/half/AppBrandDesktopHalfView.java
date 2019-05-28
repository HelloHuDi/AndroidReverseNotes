package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.widget.desktop.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopHalfView extends LinearLayout implements a, b.a {
    boolean cAY;
    private int iWJ = 0;
    private boolean iXF;
    private int ivr;
    private AppBrandDesktopHalfItemView jaI;
    private AppBrandDesktopHalfItemView jaJ;
    private LinearLayout jaK;
    private LinearLayout jaL;
    private boolean jaM = false;
    private boolean jaN = false;
    private e jaO = null;
    private e jaP = null;
    private int jaQ;
    private c jaR;
    private String jaS;
    private boolean jaT;
    private boolean jaU;
    private a.a jaV;
    private com.tencent.mm.plugin.appbrand.widget.recentview.b jat;
    private Context mContext;

    public AppBrandDesktopHalfView(Context context) {
        super(context);
        AppMethodBeat.i(134183);
        com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
        this.jaQ = 1;
        this.jaR = null;
        this.jat = null;
        this.jaS = null;
        this.jaT = true;
        this.iXF = false;
        this.ivr = 0;
        this.jaU = true;
        this.cAY = false;
        init(context);
        AppMethodBeat.o(134183);
    }

    public AppBrandDesktopHalfView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134184);
        com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
        this.jaQ = 1;
        this.jaR = null;
        this.jat = null;
        this.jaS = null;
        this.jaT = true;
        this.iXF = false;
        this.ivr = 0;
        this.jaU = true;
        this.cAY = false;
        init(context);
        AppMethodBeat.o(134184);
    }

    public AppBrandDesktopHalfView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(134185);
        com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
        this.jaQ = 1;
        this.jaR = null;
        this.jat = null;
        this.jaS = null;
        this.jaT = true;
        this.iXF = false;
        this.ivr = 0;
        this.jaU = true;
        this.cAY = false;
        init(context);
        AppMethodBeat.o(134185);
    }

    public void setRecentRefreshListener(e eVar) {
        this.jaO = eVar;
    }

    public void setMyRefreshListener(e eVar) {
        this.jaP = eVar;
    }

    public int getItemPadding() {
        AppMethodBeat.i(134186);
        int dj = d.dj(getContext());
        AppMethodBeat.o(134186);
        return dj;
    }

    public void setNeedScrollToFirstPageWhenResume(boolean z) {
        this.jaT = z;
    }

    private void init(Context context) {
        AppMethodBeat.i(134187);
        this.mContext = context;
        com.tencent.mm.plugin.appbrand.widget.desktop.b.init(this.mContext);
        this.iWJ = getItemPadding();
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", Integer.valueOf(this.iWJ));
        View inflate = v.hu(this.mContext).inflate(R.layout.bx, this);
        this.jaK = (LinearLayout) inflate.findViewById(R.id.q2);
        this.jaL = (LinearLayout) inflate.findViewById(R.id.q3);
        this.jaI = (AppBrandDesktopHalfItemView) inflate.findViewById(R.id.q4);
        this.jaI.a(f.RECENT_APP_BRAND);
        this.jaI.setItemPadding(this.iWJ);
        this.jaI.setTitlePaddingLeft(this.iWJ + com.tencent.mm.bz.a.fromDPToPix(this.mContext, 8));
        this.jaI.getRecentView().a(new a(this.iWJ));
        this.jaI.setRefreshListener(new e() {
            public final void qs(int i) {
                int i2 = 0;
                AppMethodBeat.i(134160);
                ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh RecentData onDone size: %d", Integer.valueOf(i));
                AppBrandDesktopHalfView.this.jaM = false;
                AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
                if (i <= AppBrandDesktopHalfView.this.jaJ.getRecentView().getCustomItemCount()) {
                    AppBrandDesktopHalfView.this.jaI.setVisibility(8);
                } else {
                    if (AppBrandDesktopHalfView.this.jaL.getVisibility() != 0) {
                        AppBrandDesktopHalfView.this.jaL.setVisibility(0);
                    }
                    if (AppBrandDesktopHalfView.this.jaI.getVisibility() != 0) {
                        AppBrandDesktopHalfView.this.jaI.setVisibility(0);
                    }
                }
                if (AppBrandDesktopHalfView.this.jaO != null) {
                    e f = AppBrandDesktopHalfView.this.jaO;
                    if (i - AppBrandDesktopHalfView.this.jaI.getRecentView().getCustomItemCount() > 0) {
                        i2 = i - AppBrandDesktopHalfView.this.jaI.getRecentView().getCustomItemCount();
                    }
                    f.qs(i2);
                }
                AppMethodBeat.o(134160);
            }
        });
        this.jaI.setOnDataChangedListener(new AppBrandRecentView.d() {
            public final void aQf() {
                AppMethodBeat.i(134169);
                AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
                AppMethodBeat.o(134169);
            }
        });
        this.jaI.jar = new RecyclerView.c() {
            public final void ax(int i, int i2) {
                AppMethodBeat.i(134176);
                super.ax(i, i2);
                if (AppBrandDesktopHalfView.this.jaI.getDataCount() <= AppBrandDesktopHalfView.this.jaI.getCustomCount()) {
                    AppBrandDesktopHalfView.this.jaI.setVisibility(8);
                }
                AppMethodBeat.o(134176);
            }
        };
        this.jaI.setCreateContextMenuListener(new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(134177);
                contextMenu.add(0, 11, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(R.string.hw));
                AppMethodBeat.o(134177);
            }
        });
        this.jaI.setMenuItemSelectedListener(new AppBrandRecentView.a<com.tencent.mm.plugin.appbrand.widget.recentview.a>() {
            public final /* synthetic */ void a(MenuItem menuItem, int i, Object obj) {
                AppMethodBeat.i(134178);
                com.tencent.mm.plugin.appbrand.widget.recentview.a aVar = (com.tencent.mm.plugin.appbrand.widget.recentview.a) obj;
                if (menuItem.getItemId() == 11) {
                    AppBrandDesktopHalfView.a(AppBrandDesktopHalfView.this, i);
                    if (!(AppBrandDesktopHalfView.this.jat == null || aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId))) {
                        AppBrandDesktopHalfView.this.jat.ET(aVar.iXW.appId);
                        AppMethodBeat.o(134178);
                        return;
                    }
                } else if (!(menuItem.getItemId() != 1 || AppBrandDesktopHalfView.this.jat == null || aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId))) {
                    AppBrandDesktopHalfView.this.jat.ER(aVar.iXW.appId);
                }
                AppMethodBeat.o(134178);
            }
        });
        this.jaI.setOnItemClickListener(new AppBrandRecentView.b() {
            public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                AppMethodBeat.i(134179);
                AppBrandDesktopHalfView.this.setLayoutFrozen(true);
                if (!(AppBrandDesktopHalfView.this.jat == null || aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId))) {
                    AppBrandDesktopHalfView.this.jaI.getRecentView();
                    int bo = RecyclerView.bo(view);
                    if (bo != -1) {
                        AppBrandDesktopHalfView.this.jaU = false;
                        AppBrandDesktopHalfView.this.jat.bA(aVar.iXW.appId, bo);
                    }
                    AppBrandDesktopHalfView.this.jaT = false;
                }
                AppMethodBeat.o(134179);
                return false;
            }

            public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                return false;
            }
        });
        this.jaJ = (AppBrandDesktopHalfItemView) inflate.findViewById(R.id.q5);
        this.jaJ.a(f.MY_APP_BRAND);
        this.jaJ.setItemPadding(this.iWJ);
        this.jaJ.setTitlePaddingLeft(this.iWJ + com.tencent.mm.bz.a.fromDPToPix(this.mContext, 8));
        this.jaJ.getRecentView().a(new a(this.iWJ));
        this.jaJ.setRefreshListener(new e() {
            public final void qs(int i) {
                int i2 = 0;
                AppMethodBeat.i(134180);
                ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh CollectionData onDone size: %d", Integer.valueOf(i));
                AppBrandDesktopHalfView.this.jaN = false;
                AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
                if (i <= AppBrandDesktopHalfView.this.jaJ.getRecentView().getCustomItemCount()) {
                    AppBrandDesktopHalfView.this.jaJ.setVisibility(8);
                } else {
                    AppBrandDesktopHalfView.this.jaL.setVisibility(0);
                    AppBrandDesktopHalfView.this.jaJ.setVisibility(0);
                }
                if (AppBrandDesktopHalfView.this.jaP != null) {
                    e k = AppBrandDesktopHalfView.this.jaP;
                    if (i - AppBrandDesktopHalfView.this.jaJ.getRecentView().getCustomItemCount() > 0) {
                        i2 = i - AppBrandDesktopHalfView.this.jaJ.getRecentView().getCustomItemCount();
                    }
                    k.qs(i2);
                }
                AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter().ar(i - 1, AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter().getItemCount() - i);
                AppMethodBeat.o(134180);
            }
        });
        this.jaJ.setOnDataChangedListener(new AppBrandRecentView.d() {
            public final void aQf() {
                AppMethodBeat.i(134181);
                AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this);
                AppMethodBeat.o(134181);
            }
        });
        this.jaJ.jar = new RecyclerView.c() {
            public final void ax(int i, int i2) {
                AppMethodBeat.i(134182);
                super.ax(i, i2);
                if (AppBrandDesktopHalfView.this.jaJ.getDataCount() <= AppBrandDesktopHalfView.this.jaJ.getCustomCount()) {
                    AppBrandDesktopHalfView.this.jaJ.setVisibility(8);
                }
                AppMethodBeat.o(134182);
            }
        };
        this.jaJ.setCreateContextMenuListener(new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(134161);
                if (view != null) {
                    AppBrandDesktopHalfView.this.jaJ.getRecentView();
                    ab.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo menu current pos: %d", Integer.valueOf(RecyclerView.bo(view)));
                    if (RecyclerView.bo(view) > AppBrandDesktopHalfView.this.jaQ) {
                        contextMenu.add(0, 12, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(R.string.hx));
                    }
                }
                AppMethodBeat.o(134161);
            }
        });
        this.jaJ.setMenuItemSelectedListener(new AppBrandRecentView.a<com.tencent.mm.plugin.appbrand.widget.recentview.a>() {
            public final /* synthetic */ void a(MenuItem menuItem, int i, Object obj) {
                AppMethodBeat.i(134162);
                com.tencent.mm.plugin.appbrand.widget.recentview.a aVar = (com.tencent.mm.plugin.appbrand.widget.recentview.a) obj;
                if (menuItem.getItemId() == 12) {
                    AppBrandDesktopHalfView.b(AppBrandDesktopHalfView.this, i);
                    if (!(AppBrandDesktopHalfView.this.jat == null || aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId))) {
                        com.tencent.mm.plugin.appbrand.widget.recentview.b g = AppBrandDesktopHalfView.this.jat;
                        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveStarAppBrandFirst id: %s", aVar.iXW.appId);
                        g.jna++;
                        g.jnf.append(r1 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        AppMethodBeat.o(134162);
                        return;
                    }
                } else if (!(menuItem.getItemId() != 1 || AppBrandDesktopHalfView.this.jat == null || aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId))) {
                    AppBrandDesktopHalfView.this.jat.ES(aVar.iXW.appId);
                    com.tencent.mm.plugin.appbrand.report.e.a(aVar.iXW, 7, 5, AppBrandDesktopHalfView.this.jaS);
                }
                AppMethodBeat.o(134162);
            }
        });
        this.jaJ.setOnItemClickListener(new AppBrandRecentView.b() {
            public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                AppMethodBeat.i(134163);
                AppBrandDesktopHalfView.this.setLayoutFrozen(true);
                if (!(AppBrandDesktopHalfView.this.jat == null || aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId))) {
                    AppBrandDesktopHalfView.this.jaJ.getRecentView();
                    int bo = RecyclerView.bo(view);
                    if (bo != -1) {
                        AppBrandDesktopHalfView.this.jaU = false;
                        AppBrandDesktopHalfView.this.jat.bB(aVar.iXW.appId, bo);
                    }
                    AppBrandDesktopHalfView.this.jaT = false;
                }
                AppMethodBeat.o(134163);
                return false;
            }

            public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                return false;
            }
        });
        this.jaI.setEnableDataCache(true);
        this.jaJ.setEnableDataCache(false);
        AppMethodBeat.o(134187);
    }

    private void eY(boolean z) {
        int i = 0;
        AppMethodBeat.i(134188);
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", Boolean.valueOf(z));
        if (z) {
            if (!(this.jaK.getVisibility() == 0 || this.jaV == null)) {
                this.jaV.fa(true);
            }
        } else if (this.jaK.getVisibility() == 0 && this.jaV != null) {
            this.jaV.fa(false);
        }
        LinearLayout linearLayout = this.jaK;
        if (!z) {
            i = 4;
        }
        linearLayout.setVisibility(i);
        AppMethodBeat.o(134188);
    }

    private void qt(int i) {
        AppMethodBeat.i(134189);
        List<com.tencent.mm.plugin.appbrand.widget.recentview.a> previewList = this.jaJ.getPreviewList();
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mm.plugin.appbrand.widget.recentview.a aVar : previewList) {
            LocalUsageInfo localUsageInfo = aVar.iXW;
            if (localUsageInfo != null) {
                ab.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", localUsageInfo.nickname, Integer.valueOf(localUsageInfo.har));
                arrayList.add(localUsageInfo);
            }
        }
        if (i == 1) {
            this.jaJ.getRecentView().setIgnoreNotify(false);
        } else {
            this.jaJ.getRecentView().setIgnoreNotify(true);
        }
        ((af) g.K(af.class)).g(arrayList, i);
        AppMethodBeat.o(134189);
    }

    public final void aPs() {
    }

    public final void qj(int i) {
        AppMethodBeat.i(134190);
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo onCloseHeader");
        postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(134173);
                if (AppBrandDesktopHalfView.this.jaJ != null) {
                    AppBrandDesktopHalfView.this.jaJ.a(null);
                }
                if (AppBrandDesktopHalfView.this.jaI != null) {
                    AppBrandDesktopHalfView.this.jaI.a(null);
                }
                AppMethodBeat.o(134173);
            }
        }, 500);
        AppMethodBeat.o(134190);
    }

    public void setCollectionRefreshListener(e eVar) {
        this.jaP = eVar;
    }

    public void setUsageRefreshListener(e eVar) {
        this.jaO = eVar;
    }

    public final void aQc() {
        AppMethodBeat.i(134191);
        ab.d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
        this.iXF = true;
        ((af) g.K(af.class)).awX();
        String aLc = com.tencent.mm.plugin.appbrand.report.e.aLc();
        this.jaS = aLc;
        com.tencent.mm.plugin.appbrand.report.e.Dz(aLc);
        AppMethodBeat.o(134191);
    }

    public final void qu(int i) {
        AppMethodBeat.i(134192);
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", Integer.valueOf(i), Boolean.valueOf(this.iXF));
        if (this.iXF) {
            this.iXF = false;
            qt(1);
        }
        AppMethodBeat.o(134192);
    }

    public final void aQb() {
        AppMethodBeat.i(134193);
        if (this.jaJ != null) {
            this.jaJ.aQb();
        }
        if (this.jaI != null) {
            this.jaI.aQb();
        }
        AppMethodBeat.o(134193);
    }

    public final void qk(int i) {
        AppMethodBeat.i(134194);
        qj(i);
        AppMethodBeat.o(134194);
    }

    public final void aPt() {
    }

    public void setLayoutFrozen(boolean z) {
        AppMethodBeat.i(134195);
        if (!(this.jaI == null || this.jaI.getRecentView() == null)) {
            this.jaI.getRecentView().setLayoutFrozen(z);
        }
        if (!(this.jaJ == null || this.jaJ.getRecentView() == null)) {
            this.jaJ.getRecentView().setLayoutFrozen(z);
        }
        AppMethodBeat.o(134195);
    }

    private static void l(RecyclerView recyclerView) {
        AppMethodBeat.i(134196);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int iQ = linearLayoutManager.iQ();
        int iS = linearLayoutManager.iS();
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", Integer.valueOf(iQ), Integer.valueOf(iS));
        for (int i = iQ; i <= iS; i++) {
            RecyclerView.v cf = recyclerView.cf(i);
            if (!(cf == null || cf.apJ == null)) {
                cf.apJ.setScaleX(1.0f);
                cf.apJ.setScaleY(1.0f);
                if (i == iS) {
                    cf.apJ.setAlpha(0.3f);
                } else {
                    cf.apJ.setAlpha(1.0f);
                }
            }
        }
        AppMethodBeat.o(134196);
    }

    public final void a(Configuration configuration) {
        AppMethodBeat.i(134197);
        onConfigurationChanged(configuration);
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onConfigurationChanged orientation: %d", Integer.valueOf(configuration.orientation));
        int itemPadding = getItemPadding();
        if (!(this.ivr == configuration.orientation && itemPadding == this.iWJ)) {
            this.ivr = configuration.orientation;
            com.tencent.mm.plugin.appbrand.widget.desktop.b.init(getContext());
            this.iWJ = itemPadding;
            if (this.jaI != null) {
                this.jaI.setTitlePaddingLeft(this.iWJ + com.tencent.mm.bz.a.fromDPToPix(this.mContext, 8));
            }
            if (this.jaJ != null) {
                this.jaJ.setTitlePaddingLeft(this.iWJ + com.tencent.mm.bz.a.fromDPToPix(this.mContext, 8));
            }
            if (this.jaI != null) {
                this.jaI.a(configuration);
            }
            if (this.jaJ != null) {
                this.jaJ.a(configuration);
            }
        }
        AppMethodBeat.o(134197);
    }

    public int getRecentAppBrandCount() {
        AppMethodBeat.i(134198);
        if (this.jaI != null) {
            int dataCount = this.jaI.getDataCount() - this.jaI.getCustomCount();
            AppMethodBeat.o(134198);
            return dataCount;
        }
        AppMethodBeat.o(134198);
        return 0;
    }

    public int getStarAppBrandCount() {
        AppMethodBeat.i(134199);
        if (this.jaJ != null) {
            int dataCount = this.jaJ.getDataCount() - this.jaJ.getCustomCount();
            AppMethodBeat.o(134199);
            return dataCount;
        }
        AppMethodBeat.o(134199);
        return 0;
    }

    public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b bVar) {
        AppMethodBeat.i(134200);
        this.jat = bVar;
        if (this.jaI != null) {
            this.jaI.setReporter(bVar);
        }
        if (this.jaJ != null) {
            this.jaJ.setReporter(bVar);
        }
        AppMethodBeat.o(134200);
    }

    public final void aQd() {
        AppMethodBeat.i(134201);
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkReportNameDuplicated");
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(134175);
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    com.tencent.mm.plugin.appbrand.widget.recentview.b.f(AppBrandDesktopHalfView.this.jaI.getPreviewList(), AppBrandDesktopHalfView.this.jaJ.getPreviewList());
                    ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo computeNameDuplicatedResults cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(134175);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrandDesktopHalfView", e, "alvinluo checkReportNameDuplicated", new Object[0]);
                    AppMethodBeat.o(134175);
                }
            }
        }, "checkReportNameDuplicated");
        AppMethodBeat.o(134201);
    }

    public void setIOnLaunchUIListener(a.b bVar) {
        AppMethodBeat.i(134202);
        if (this.jaI != null) {
            this.jaI.setOnLaunchUIListener(bVar);
        }
        if (this.jaJ != null) {
            this.jaJ.setOnLaunchUIListener(bVar);
        }
        AppMethodBeat.o(134202);
    }

    public void setOnEmptyViewListener(a.a aVar) {
        this.jaV = aVar;
    }

    public final void refresh() {
        AppMethodBeat.i(134203);
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh data");
        this.jaN = true;
        this.jaJ.iWW.refresh();
        this.jaM = true;
        this.jaI.iWW.refresh();
        AppMethodBeat.o(134203);
    }

    static /* synthetic */ void b(AppBrandDesktopHalfView appBrandDesktopHalfView) {
        AppMethodBeat.i(134204);
        ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo triggerRefreshView isRecentRefreshing: %b, isMyAppBrandRefreshing: %b", Boolean.valueOf(appBrandDesktopHalfView.jaM), Boolean.valueOf(appBrandDesktopHalfView.jaN));
        if (!(appBrandDesktopHalfView.jaM || appBrandDesktopHalfView.jaN)) {
            if (appBrandDesktopHalfView.jaI.getDataCount() > appBrandDesktopHalfView.jaI.getCustomCount() || appBrandDesktopHalfView.jaJ.getDataCount() > appBrandDesktopHalfView.jaJ.getCustomCount()) {
                appBrandDesktopHalfView.eY(false);
            } else {
                appBrandDesktopHalfView.eY(true);
                appBrandDesktopHalfView.jaL.setVisibility(8);
                appBrandDesktopHalfView.jaI.setVisibility(8);
                appBrandDesktopHalfView.jaJ.setVisibility(8);
                AppMethodBeat.o(134204);
                return;
            }
        }
        AppMethodBeat.o(134204);
    }

    static /* synthetic */ void b(AppBrandDesktopHalfView appBrandDesktopHalfView, final int i) {
        AppMethodBeat.i(134206);
        if (i != 0) {
            ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo moveToFirst position: %d", Integer.valueOf(i));
            final com.tencent.mm.plugin.appbrand.widget.recentview.a aVar = (com.tencent.mm.plugin.appbrand.widget.recentview.a) appBrandDesktopHalfView.jaJ.getPreviewList().get(i);
            ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo notifyMoveToFirstAnimation position: %d, dataCount: %d", Integer.valueOf(i), Integer.valueOf(appBrandDesktopHalfView.jaJ.getDataCount()));
            ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo needNotifyRemoveAnimation: %b", Boolean.TRUE);
            appBrandDesktopHalfView.jaJ.getPreviewList().remove(i);
            appBrandDesktopHalfView.jaJ.getRecentView().getAdapter().ci(i);
            if (com.tencent.mm.plugin.appbrand.widget.recentview.e.rd(i) == com.tencent.mm.plugin.appbrand.widget.recentview.e.rd(appBrandDesktopHalfView.jaJ.getDataCount() - 1)) {
                if (com.tencent.mm.plugin.appbrand.widget.recentview.e.rd(i) == 0) {
                    appBrandDesktopHalfView.jaJ.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(134168);
                            ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo notifyMoveToFirstAnimation last page need notifyItemRangeChanged");
                            AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter().ar(i, 5);
                            AppMethodBeat.o(134168);
                        }
                    }, 400);
                } else {
                    appBrandDesktopHalfView.jaJ.getRecentView().getAdapter().ar(i, 5);
                }
            }
            if (com.tencent.mm.plugin.appbrand.widget.recentview.e.rd(i) == 0) {
                appBrandDesktopHalfView.jaJ.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(134170);
                        AppBrandDesktopHalfView.a(AppBrandDesktopHalfView.this, aVar);
                        AppMethodBeat.o(134170);
                    }
                }, 400);
                AppMethodBeat.o(134206);
                return;
            }
            appBrandDesktopHalfView.jaJ.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(134172);
                    AppBrandDesktopHalfView.this.jaJ.a(new com.tencent.mm.plugin.appbrand.widget.recentview.e.b() {
                        public final void aQe() {
                            AppMethodBeat.i(134171);
                            if (!(AppBrandDesktopHalfView.this.jaJ == null || AppBrandDesktopHalfView.this.jaJ.getPreviewList() == null || AppBrandDesktopHalfView.this.jaJ.getRecentView() == null || AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter() == null)) {
                                ab.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo moveToFirst onScrollEnd notifyItemInserted startIndex: %d", Integer.valueOf(AppBrandDesktopHalfView.this.jaQ));
                                AppBrandDesktopHalfView.a(AppBrandDesktopHalfView.this, aVar);
                            }
                            AppMethodBeat.o(134171);
                        }
                    });
                    AppMethodBeat.o(134172);
                }
            }, 400);
        }
        AppMethodBeat.o(134206);
    }

    static /* synthetic */ void o(AppBrandDesktopHalfView appBrandDesktopHalfView) {
        AppMethodBeat.i(134208);
        if (!(appBrandDesktopHalfView.jaJ == null || appBrandDesktopHalfView.jaJ.getRecentView() == null)) {
            l(appBrandDesktopHalfView.jaJ.getRecentView());
        }
        if (!(appBrandDesktopHalfView.jaI == null || appBrandDesktopHalfView.jaI.getRecentView() == null)) {
            l(appBrandDesktopHalfView.jaI.getRecentView());
        }
        AppMethodBeat.o(134208);
    }
}
