package com.tencent.p177mm.plugin.appbrand.widget.desktop.half;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.report.C19692e;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C10958c;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C10969d;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C2545b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView.C273813;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b.C10986a;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a.C27395a;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a.C42729b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C19906a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C19907f;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38618d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38619e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38620b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e.C33647b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C42748a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView */
public class AppBrandDesktopHalfView extends LinearLayout implements C45717a, C10986a {
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
    private C38619e jaO = null;
    private C38619e jaP = null;
    private int jaQ;
    private C10958c jaR;
    private String jaS;
    private boolean jaT;
    private boolean jaU;
    private C27395a jaV;
    private C19916b jat;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$20 */
    class C255220 implements C38619e {
        C255220() {
        }

        /* renamed from: qs */
        public final void mo6518qs(int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(134180);
            C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh CollectionData onDone size: %d", Integer.valueOf(i));
            AppBrandDesktopHalfView.this.jaN = false;
            AppBrandDesktopHalfView.m75692b(AppBrandDesktopHalfView.this);
            if (i <= AppBrandDesktopHalfView.this.jaJ.getRecentView().getCustomItemCount()) {
                AppBrandDesktopHalfView.this.jaJ.setVisibility(8);
            } else {
                AppBrandDesktopHalfView.this.jaL.setVisibility(0);
                AppBrandDesktopHalfView.this.jaJ.setVisibility(0);
            }
            if (AppBrandDesktopHalfView.this.jaP != null) {
                C38619e k = AppBrandDesktopHalfView.this.jaP;
                if (i - AppBrandDesktopHalfView.this.jaJ.getRecentView().getCustomItemCount() > 0) {
                    i2 = i - AppBrandDesktopHalfView.this.jaJ.getRecentView().getCustomItemCount();
                }
                k.mo6518qs(i2);
            }
            AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter().mo66308ar(i - 1, AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter().getItemCount() - i);
            AppMethodBeat.m2505o(134180);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$21 */
    class C255321 implements C38618d {
        C255321() {
        }

        public final void aQf() {
            AppMethodBeat.m2504i(134181);
            AppBrandDesktopHalfView.m75692b(AppBrandDesktopHalfView.this);
            AppMethodBeat.m2505o(134181);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$14 */
    class C1097814 implements Runnable {
        C1097814() {
        }

        public final void run() {
            AppMethodBeat.m2504i(134174);
            AppBrandDesktopHalfView.m75708o(AppBrandDesktopHalfView.this);
            AppMethodBeat.m2505o(134174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$16 */
    class C1985016 extends C41525c {
        C1985016() {
        }

        /* renamed from: ax */
        public final void mo6644ax(int i, int i2) {
            AppMethodBeat.m2504i(134176);
            super.mo6644ax(i, i2);
            if (AppBrandDesktopHalfView.this.jaI.getDataCount() <= AppBrandDesktopHalfView.this.jaI.getCustomCount()) {
                AppBrandDesktopHalfView.this.jaI.setVisibility(8);
            }
            AppMethodBeat.m2505o(134176);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$8 */
    class C198538 implements OnClickListener {
        C198538() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$13 */
    class C2738913 implements Runnable {
        C2738913() {
        }

        public final void run() {
            AppMethodBeat.m2504i(134173);
            if (AppBrandDesktopHalfView.this.jaJ != null) {
                AppBrandDesktopHalfView.this.jaJ.mo45100a(null);
            }
            if (AppBrandDesktopHalfView.this.jaI != null) {
                AppBrandDesktopHalfView.this.jaI.mo45100a(null);
            }
            AppMethodBeat.m2505o(134173);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$15 */
    class C2739015 implements Runnable {
        C2739015() {
        }

        public final void run() {
            AppMethodBeat.m2504i(134175);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                C19916b.m30809f(AppBrandDesktopHalfView.this.jaI.getPreviewList(), AppBrandDesktopHalfView.this.jaJ.getPreviewList());
                C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo computeNameDuplicatedResults cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(134175);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandDesktopHalfView", e, "alvinluo checkReportNameDuplicated", new Object[0]);
                AppMethodBeat.m2505o(134175);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$1 */
    class C273911 implements C38619e {
        C273911() {
        }

        /* renamed from: qs */
        public final void mo6518qs(int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(134160);
            C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh RecentData onDone size: %d", Integer.valueOf(i));
            AppBrandDesktopHalfView.this.jaM = false;
            AppBrandDesktopHalfView.m75692b(AppBrandDesktopHalfView.this);
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
                C38619e f = AppBrandDesktopHalfView.this.jaO;
                if (i - AppBrandDesktopHalfView.this.jaI.getRecentView().getCustomItemCount() > 0) {
                    i2 = i - AppBrandDesktopHalfView.this.jaI.getRecentView().getCustomItemCount();
                }
                f.mo6518qs(i2);
            }
            AppMethodBeat.m2505o(134160);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$22 */
    class C3360922 extends C41525c {
        C3360922() {
        }

        /* renamed from: ax */
        public final void mo6644ax(int i, int i2) {
            AppMethodBeat.m2504i(134182);
            super.mo6644ax(i, i2);
            if (AppBrandDesktopHalfView.this.jaJ.getDataCount() <= AppBrandDesktopHalfView.this.jaJ.getCustomCount()) {
                AppBrandDesktopHalfView.this.jaJ.setVisibility(8);
            }
            AppMethodBeat.m2505o(134182);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$18 */
    class C4271318 implements C19906a<C42748a> {
        C4271318() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo35152a(MenuItem menuItem, int i, Object obj) {
            AppMethodBeat.m2504i(134178);
            C42748a c42748a = (C42748a) obj;
            if (menuItem.getItemId() == 11) {
                AppBrandDesktopHalfView.m75689a(AppBrandDesktopHalfView.this, i);
                if (!(AppBrandDesktopHalfView.this.jat == null || c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId))) {
                    AppBrandDesktopHalfView.this.jat.mo35158ET(c42748a.iXW.appId);
                    AppMethodBeat.m2505o(134178);
                    return;
                }
            } else if (!(menuItem.getItemId() != 1 || AppBrandDesktopHalfView.this.jat == null || c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId))) {
                AppBrandDesktopHalfView.this.jat.mo35156ER(c42748a.iXW.appId);
            }
            AppMethodBeat.m2505o(134178);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$19 */
    class C4271419 implements C38620b {
        C4271419() {
        }

        /* renamed from: a */
        public final boolean mo35067a(View view, C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(134179);
            AppBrandDesktopHalfView.this.setLayoutFrozen(true);
            if (!(AppBrandDesktopHalfView.this.jat == null || c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId))) {
                AppBrandDesktopHalfView.this.jaI.getRecentView();
                int bo = RecyclerView.m72547bo(view);
                if (bo != -1) {
                    AppBrandDesktopHalfView.this.jaU = false;
                    AppBrandDesktopHalfView.this.jat.mo35161bA(c42748a.iXW.appId, bo);
                }
                AppBrandDesktopHalfView.this.jaT = false;
            }
            AppMethodBeat.m2505o(134179);
            return false;
        }

        /* renamed from: b */
        public final boolean mo35068b(View view, C42748a c42748a, float f, float f2) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$2 */
    class C427152 implements OnCreateContextMenuListener {
        C427152() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(134161);
            if (view != null) {
                AppBrandDesktopHalfView.this.jaJ.getRecentView();
                C4990ab.m7411d("MicroMsg.AppBrandDesktopHalfView", "alvinluo menu current pos: %d", Integer.valueOf(RecyclerView.m72547bo(view)));
                if (RecyclerView.m72547bo(view) > AppBrandDesktopHalfView.this.jaQ) {
                    contextMenu.add(0, 12, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(C25738R.string.f8879hx));
                }
            }
            AppMethodBeat.m2505o(134161);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$3 */
    class C427163 implements C19906a<C42748a> {
        C427163() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo35152a(MenuItem menuItem, int i, Object obj) {
            AppMethodBeat.m2504i(134162);
            C42748a c42748a = (C42748a) obj;
            if (menuItem.getItemId() == 12) {
                AppBrandDesktopHalfView.m75693b(AppBrandDesktopHalfView.this, i);
                if (!(AppBrandDesktopHalfView.this.jat == null || c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId))) {
                    C19916b g = AppBrandDesktopHalfView.this.jat;
                    C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo moveStarAppBrandFirst id: %s", c42748a.iXW.appId);
                    g.jna++;
                    g.jnf.append(r1 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    AppMethodBeat.m2505o(134162);
                    return;
                }
            } else if (!(menuItem.getItemId() != 1 || AppBrandDesktopHalfView.this.jat == null || c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId))) {
                AppBrandDesktopHalfView.this.jat.mo35157ES(c42748a.iXW.appId);
                C19692e.m30513a(c42748a.iXW, 7, 5, AppBrandDesktopHalfView.this.jaS);
            }
            AppMethodBeat.m2505o(134162);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$4 */
    class C427174 implements C38620b {
        C427174() {
        }

        /* renamed from: a */
        public final boolean mo35067a(View view, C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(134163);
            AppBrandDesktopHalfView.this.setLayoutFrozen(true);
            if (!(AppBrandDesktopHalfView.this.jat == null || c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId))) {
                AppBrandDesktopHalfView.this.jaJ.getRecentView();
                int bo = RecyclerView.m72547bo(view);
                if (bo != -1) {
                    AppBrandDesktopHalfView.this.jaU = false;
                    AppBrandDesktopHalfView.this.jat.mo35162bB(c42748a.iXW.appId, bo);
                }
                AppBrandDesktopHalfView.this.jaT = false;
            }
            AppMethodBeat.m2505o(134163);
            return false;
        }

        /* renamed from: b */
        public final boolean mo35068b(View view, C42748a c42748a, float f, float f2) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$5 */
    class C427185 implements C33647b {
        C427185() {
        }

        public final void aQe() {
            AppMethodBeat.m2504i(134164);
            C4990ab.m7416i("MicroMsg.AppBrandDesktopHalfView", "alvinluo smoothScrollToPosition onScrollEnd");
            AppBrandDesktopHalfItemView c = AppBrandDesktopHalfView.this.jaJ;
            if (!(c.jaz == null || c.jaz.ape == -1)) {
                C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo notifyScaleAndAlphaAnimation targetPage: %d, currentPage: %d", Integer.valueOf(c.jaz.jaF), Integer.valueOf(c.iWW.getCurrentPage()));
                c.jaz.jaG = c.iWW.mo66357cf(c.jaz.ape);
                if (c.jaz.jaG != null) {
                    C4990ab.m7416i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo doScaleAndAlphaAnimation");
                    c.iWW.postDelayed(new C273813(), 10);
                }
            }
            AppMethodBeat.m2505o(134164);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$10 */
    class C4272010 implements C38618d {
        C4272010() {
        }

        public final void aQf() {
            AppMethodBeat.m2504i(134169);
            AppBrandDesktopHalfView.m75692b(AppBrandDesktopHalfView.this);
            AppMethodBeat.m2505o(134169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$17 */
    class C4272117 implements OnCreateContextMenuListener {
        C4272117() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(134177);
            contextMenu.add(0, 11, 0, AppBrandDesktopHalfView.this.getContext().getResources().getString(C25738R.string.f8878hw));
            AppMethodBeat.m2505o(134177);
        }
    }

    public AppBrandDesktopHalfView(Context context) {
        super(context);
        AppMethodBeat.m2504i(134183);
        C2545b.aPf();
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
        AppMethodBeat.m2505o(134183);
    }

    public AppBrandDesktopHalfView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134184);
        C2545b.aPf();
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
        AppMethodBeat.m2505o(134184);
    }

    public AppBrandDesktopHalfView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(134185);
        C2545b.aPf();
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
        AppMethodBeat.m2505o(134185);
    }

    public void setRecentRefreshListener(C38619e c38619e) {
        this.jaO = c38619e;
    }

    public void setMyRefreshListener(C38619e c38619e) {
        this.jaP = c38619e;
    }

    public int getItemPadding() {
        AppMethodBeat.m2504i(134186);
        int dj = C10969d.m18707dj(getContext());
        AppMethodBeat.m2505o(134186);
        return dj;
    }

    public void setNeedScrollToFirstPageWhenResume(boolean z) {
        this.jaT = z;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(134187);
        this.mContext = context;
        C2545b.init(this.mContext);
        this.iWJ = getItemPadding();
        C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo init itemPadding: %d", Integer.valueOf(this.iWJ));
        View inflate = C5616v.m8409hu(this.mContext).inflate(2130968673, this);
        this.jaK = (LinearLayout) inflate.findViewById(2131821164);
        this.jaL = (LinearLayout) inflate.findViewById(2131821165);
        this.jaI = (AppBrandDesktopHalfItemView) inflate.findViewById(2131821166);
        this.jaI.mo45099a(C19907f.RECENT_APP_BRAND);
        this.jaI.setItemPadding(this.iWJ);
        this.jaI.setTitlePaddingLeft(this.iWJ + C1338a.fromDPToPix(this.mContext, 8));
        this.jaI.getRecentView().mo66330a(new C42722a(this.iWJ));
        this.jaI.setRefreshListener(new C273911());
        this.jaI.setOnDataChangedListener(new C4272010());
        this.jaI.jar = new C1985016();
        this.jaI.setCreateContextMenuListener(new C4272117());
        this.jaI.setMenuItemSelectedListener(new C4271318());
        this.jaI.setOnItemClickListener(new C4271419());
        this.jaJ = (AppBrandDesktopHalfItemView) inflate.findViewById(2131821167);
        this.jaJ.mo45099a(C19907f.MY_APP_BRAND);
        this.jaJ.setItemPadding(this.iWJ);
        this.jaJ.setTitlePaddingLeft(this.iWJ + C1338a.fromDPToPix(this.mContext, 8));
        this.jaJ.getRecentView().mo66330a(new C42722a(this.iWJ));
        this.jaJ.setRefreshListener(new C255220());
        this.jaJ.setOnDataChangedListener(new C255321());
        this.jaJ.jar = new C3360922();
        this.jaJ.setCreateContextMenuListener(new C427152());
        this.jaJ.setMenuItemSelectedListener(new C427163());
        this.jaJ.setOnItemClickListener(new C427174());
        this.jaI.setEnableDataCache(true);
        this.jaJ.setEnableDataCache(false);
        AppMethodBeat.m2505o(134187);
    }

    /* renamed from: eY */
    private void m75697eY(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(134188);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo showEmptyView show: %b", Boolean.valueOf(z));
        if (z) {
            if (!(this.jaK.getVisibility() == 0 || this.jaV == null)) {
                this.jaV.mo39738fa(true);
            }
        } else if (this.jaK.getVisibility() == 0 && this.jaV != null) {
            this.jaV.mo39738fa(false);
        }
        LinearLayout linearLayout = this.jaK;
        if (!z) {
            i = 4;
        }
        linearLayout.setVisibility(i);
        AppMethodBeat.m2505o(134188);
    }

    /* renamed from: qt */
    private void m75709qt(int i) {
        AppMethodBeat.m2504i(134189);
        List<C42748a> previewList = this.jaJ.getPreviewList();
        ArrayList arrayList = new ArrayList();
        for (C42748a c42748a : previewList) {
            LocalUsageInfo localUsageInfo = c42748a.iXW;
            if (localUsageInfo != null) {
                C4990ab.m7411d("MicroMsg.AppBrandDesktopHalfView", "alvinluo reorderCollection info: %s, %d", localUsageInfo.nickname, Integer.valueOf(localUsageInfo.har));
                arrayList.add(localUsageInfo);
            }
        }
        if (i == 1) {
            this.jaJ.getRecentView().setIgnoreNotify(false);
        } else {
            this.jaJ.getRecentView().setIgnoreNotify(true);
        }
        ((C10118af) C1720g.m3528K(C10118af.class)).mo21476g(arrayList, i);
        AppMethodBeat.m2505o(134189);
    }

    public final void aPs() {
    }

    /* renamed from: qj */
    public final void mo22635qj(int i) {
        AppMethodBeat.m2504i(134190);
        C4990ab.m7416i("MicroMsg.AppBrandDesktopHalfView", "alvinluo onCloseHeader");
        postDelayed(new C2738913(), 500);
        AppMethodBeat.m2505o(134190);
    }

    public void setCollectionRefreshListener(C38619e c38619e) {
        this.jaP = c38619e;
    }

    public void setUsageRefreshListener(C38619e c38619e) {
        this.jaO = c38619e;
    }

    public final void aQc() {
        AppMethodBeat.m2504i(134191);
        C4990ab.m7410d("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onOpen");
        this.iXF = true;
        ((C10118af) C1720g.m3528K(C10118af.class)).awX();
        String aLc = C19692e.aLc();
        this.jaS = aLc;
        C19692e.m30512Dz(aLc);
        AppMethodBeat.m2505o(134191);
    }

    /* renamed from: qu */
    public final void mo68138qu(int i) {
        AppMethodBeat.m2504i(134192);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onClose type: %d, isHeaderOpen: %b", Integer.valueOf(i), Boolean.valueOf(this.iXF));
        if (this.iXF) {
            this.iXF = false;
            m75709qt(1);
        }
        AppMethodBeat.m2505o(134192);
    }

    public final void aQb() {
        AppMethodBeat.m2504i(134193);
        if (this.jaJ != null) {
            this.jaJ.aQb();
        }
        if (this.jaI != null) {
            this.jaI.aQb();
        }
        AppMethodBeat.m2505o(134193);
    }

    /* renamed from: qk */
    public final void mo22636qk(int i) {
        AppMethodBeat.m2504i(134194);
        mo22635qj(i);
        AppMethodBeat.m2505o(134194);
    }

    public final void aPt() {
    }

    public void setLayoutFrozen(boolean z) {
        AppMethodBeat.m2504i(134195);
        if (!(this.jaI == null || this.jaI.getRecentView() == null)) {
            this.jaI.getRecentView().setLayoutFrozen(z);
        }
        if (!(this.jaJ == null || this.jaJ.getRecentView() == null)) {
            this.jaJ.getRecentView().setLayoutFrozen(z);
        }
        AppMethodBeat.m2505o(134195);
    }

    /* renamed from: l */
    private static void m75705l(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(134196);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int iQ = linearLayoutManager.mo1780iQ();
        int iS = linearLayoutManager.mo1782iS();
        C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", Integer.valueOf(iQ), Integer.valueOf(iS));
        for (int i = iQ; i <= iS; i++) {
            C41531v cf = recyclerView.mo66357cf(i);
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
        AppMethodBeat.m2505o(134196);
    }

    /* renamed from: a */
    public final void mo68131a(Configuration configuration) {
        AppMethodBeat.m2504i(134197);
        onConfigurationChanged(configuration);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo HalfView onConfigurationChanged orientation: %d", Integer.valueOf(configuration.orientation));
        int itemPadding = getItemPadding();
        if (!(this.ivr == configuration.orientation && itemPadding == this.iWJ)) {
            this.ivr = configuration.orientation;
            C2545b.init(getContext());
            this.iWJ = itemPadding;
            if (this.jaI != null) {
                this.jaI.setTitlePaddingLeft(this.iWJ + C1338a.fromDPToPix(this.mContext, 8));
            }
            if (this.jaJ != null) {
                this.jaJ.setTitlePaddingLeft(this.iWJ + C1338a.fromDPToPix(this.mContext, 8));
            }
            if (this.jaI != null) {
                this.jaI.mo45098a(configuration);
            }
            if (this.jaJ != null) {
                this.jaJ.mo45098a(configuration);
            }
        }
        AppMethodBeat.m2505o(134197);
    }

    public int getRecentAppBrandCount() {
        AppMethodBeat.m2504i(134198);
        if (this.jaI != null) {
            int dataCount = this.jaI.getDataCount() - this.jaI.getCustomCount();
            AppMethodBeat.m2505o(134198);
            return dataCount;
        }
        AppMethodBeat.m2505o(134198);
        return 0;
    }

    public int getStarAppBrandCount() {
        AppMethodBeat.m2504i(134199);
        if (this.jaJ != null) {
            int dataCount = this.jaJ.getDataCount() - this.jaJ.getCustomCount();
            AppMethodBeat.m2505o(134199);
            return dataCount;
        }
        AppMethodBeat.m2505o(134199);
        return 0;
    }

    public void setReporter(C19916b c19916b) {
        AppMethodBeat.m2504i(134200);
        this.jat = c19916b;
        if (this.jaI != null) {
            this.jaI.setReporter(c19916b);
        }
        if (this.jaJ != null) {
            this.jaJ.setReporter(c19916b);
        }
        AppMethodBeat.m2505o(134200);
    }

    public final void aQd() {
        AppMethodBeat.m2504i(134201);
        C4990ab.m7416i("MicroMsg.AppBrandDesktopHalfView", "alvinluo checkReportNameDuplicated");
        C7305d.post(new C2739015(), "checkReportNameDuplicated");
        AppMethodBeat.m2505o(134201);
    }

    public void setIOnLaunchUIListener(C42729b c42729b) {
        AppMethodBeat.m2504i(134202);
        if (this.jaI != null) {
            this.jaI.setOnLaunchUIListener(c42729b);
        }
        if (this.jaJ != null) {
            this.jaJ.setOnLaunchUIListener(c42729b);
        }
        AppMethodBeat.m2505o(134202);
    }

    public void setOnEmptyViewListener(C27395a c27395a) {
        this.jaV = c27395a;
    }

    public final void refresh() {
        AppMethodBeat.m2504i(134203);
        C4990ab.m7416i("MicroMsg.AppBrandDesktopHalfView", "alvinluo refresh data");
        this.jaN = true;
        this.jaJ.iWW.refresh();
        this.jaM = true;
        this.jaI.iWW.refresh();
        AppMethodBeat.m2505o(134203);
    }

    /* renamed from: b */
    static /* synthetic */ void m75692b(AppBrandDesktopHalfView appBrandDesktopHalfView) {
        AppMethodBeat.m2504i(134204);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo triggerRefreshView isRecentRefreshing: %b, isMyAppBrandRefreshing: %b", Boolean.valueOf(appBrandDesktopHalfView.jaM), Boolean.valueOf(appBrandDesktopHalfView.jaN));
        if (!(appBrandDesktopHalfView.jaM || appBrandDesktopHalfView.jaN)) {
            if (appBrandDesktopHalfView.jaI.getDataCount() > appBrandDesktopHalfView.jaI.getCustomCount() || appBrandDesktopHalfView.jaJ.getDataCount() > appBrandDesktopHalfView.jaJ.getCustomCount()) {
                appBrandDesktopHalfView.m75697eY(false);
            } else {
                appBrandDesktopHalfView.m75697eY(true);
                appBrandDesktopHalfView.jaL.setVisibility(8);
                appBrandDesktopHalfView.jaI.setVisibility(8);
                appBrandDesktopHalfView.jaJ.setVisibility(8);
                AppMethodBeat.m2505o(134204);
                return;
            }
        }
        AppMethodBeat.m2505o(134204);
    }

    /* renamed from: b */
    static /* synthetic */ void m75693b(AppBrandDesktopHalfView appBrandDesktopHalfView, final int i) {
        AppMethodBeat.m2504i(134206);
        if (i != 0) {
            C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo moveToFirst position: %d", Integer.valueOf(i));
            final C42748a c42748a = (C42748a) appBrandDesktopHalfView.jaJ.getPreviewList().get(i);
            C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo notifyMoveToFirstAnimation position: %d, dataCount: %d", Integer.valueOf(i), Integer.valueOf(appBrandDesktopHalfView.jaJ.getDataCount()));
            C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo needNotifyRemoveAnimation: %b", Boolean.TRUE);
            appBrandDesktopHalfView.jaJ.getPreviewList().remove(i);
            appBrandDesktopHalfView.jaJ.getRecentView().getAdapter().mo66318ci(i);
            if (C33646e.m54944rd(i) == C33646e.m54944rd(appBrandDesktopHalfView.jaJ.getDataCount() - 1)) {
                if (C33646e.m54944rd(i) == 0) {
                    appBrandDesktopHalfView.jaJ.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(134168);
                            C4990ab.m7416i("MicroMsg.AppBrandDesktopHalfView", "alvinluo notifyMoveToFirstAnimation last page need notifyItemRangeChanged");
                            AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter().mo66308ar(i, 5);
                            AppMethodBeat.m2505o(134168);
                        }
                    }, 400);
                } else {
                    appBrandDesktopHalfView.jaJ.getRecentView().getAdapter().mo66308ar(i, 5);
                }
            }
            if (C33646e.m54944rd(i) == 0) {
                appBrandDesktopHalfView.jaJ.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(134170);
                        AppBrandDesktopHalfView.m75690a(AppBrandDesktopHalfView.this, c42748a);
                        AppMethodBeat.m2505o(134170);
                    }
                }, 400);
                AppMethodBeat.m2505o(134206);
                return;
            }
            appBrandDesktopHalfView.jaJ.postDelayed(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView$12$1 */
                class C109771 implements C33647b {
                    C109771() {
                    }

                    public final void aQe() {
                        AppMethodBeat.m2504i(134171);
                        if (!(AppBrandDesktopHalfView.this.jaJ == null || AppBrandDesktopHalfView.this.jaJ.getPreviewList() == null || AppBrandDesktopHalfView.this.jaJ.getRecentView() == null || AppBrandDesktopHalfView.this.jaJ.getRecentView().getAdapter() == null)) {
                            C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfView", "alvinluo moveToFirst onScrollEnd notifyItemInserted startIndex: %d", Integer.valueOf(AppBrandDesktopHalfView.this.jaQ));
                            AppBrandDesktopHalfView.m75690a(AppBrandDesktopHalfView.this, c42748a);
                        }
                        AppMethodBeat.m2505o(134171);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(134172);
                    AppBrandDesktopHalfView.this.jaJ.mo45100a(new C109771());
                    AppMethodBeat.m2505o(134172);
                }
            }, 400);
        }
        AppMethodBeat.m2505o(134206);
    }

    /* renamed from: o */
    static /* synthetic */ void m75708o(AppBrandDesktopHalfView appBrandDesktopHalfView) {
        AppMethodBeat.m2504i(134208);
        if (!(appBrandDesktopHalfView.jaJ == null || appBrandDesktopHalfView.jaJ.getRecentView() == null)) {
            AppBrandDesktopHalfView.m75705l(appBrandDesktopHalfView.jaJ.getRecentView());
        }
        if (!(appBrandDesktopHalfView.jaI == null || appBrandDesktopHalfView.jaI.getRecentView() == null)) {
            AppBrandDesktopHalfView.m75705l(appBrandDesktopHalfView.jaI.getRecentView());
        }
        AppMethodBeat.m2505o(134208);
    }
}
