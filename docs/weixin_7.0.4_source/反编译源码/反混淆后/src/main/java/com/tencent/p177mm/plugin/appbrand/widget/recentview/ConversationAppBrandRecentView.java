package com.tencent.p177mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C26767ag;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C10969d;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C2545b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C19906a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C19907f;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38618d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38620b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.C19910c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e.C33648a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView */
public class ConversationAppBrandRecentView extends BaseAppBrandRecentView {
    private static final int jnT = C1338a.fromDPToPix(C4996ah.getContext(), 200);
    private C38620b jas;
    private C33648a jnS;
    private float jnU = 0.0f;
    private int jnV = 0;
    private C11047a jnW = null;
    private OnCreateContextMenuListener jnX = null;
    private C19906a jnY = null;
    private boolean jnZ = false;
    private int mScreenWidth = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView$a */
    public interface C11047a {
        /* renamed from: a */
        void mo22742a(C19910c c19910c, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView$1 */
    class C199131 implements C38620b {

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView$1$1 */
        class C199151 implements OnCreateContextMenuListener {
            C199151() {
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.m2504i(134356);
                if (ConversationAppBrandRecentView.this.jnX != null) {
                    ConversationAppBrandRecentView.this.jnX.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
                contextMenu.add(0, 1, contextMenu.size() + 1, ConversationAppBrandRecentView.this.getContext().getResources().getString(C25738R.string.b55));
                AppMethodBeat.m2505o(134356);
            }
        }

        C199131() {
        }

        /* renamed from: a */
        public final boolean mo35067a(View view, C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(134358);
            if (ConversationAppBrandRecentView.this.jas != null) {
                ConversationAppBrandRecentView.this.jas.mo35067a(view, c42748a, f, f2);
            }
            if (c42748a.type == 0) {
                ((C19731g) C1720g.m3528K(C19731g.class)).mo34964b(ConversationAppBrandRecentView.this.getContext(), 13, false);
            } else {
                ConversationAppBrandRecentView.this.setLayoutFrozen(true);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = ConversationAppBrandRecentView.this.jax == C19907f.MY_APP_BRAND ? 1104 : FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU;
                ((C45691e) C1720g.m3528K(C45691e.class)).mo68045a(ConversationAppBrandRecentView.this.getContext(), c42748a.iXW.username, null, c42748a.iXW.har, -1, null, appBrandStatObject);
            }
            AppMethodBeat.m2505o(134358);
            return false;
        }

        /* renamed from: b */
        public final boolean mo35068b(View view, final C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(134359);
            if (ConversationAppBrandRecentView.this.jas != null) {
                ConversationAppBrandRecentView.this.jas.mo35068b(view, c42748a, f, f2);
            }
            C4990ab.m7417i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", Float.valueOf(f));
            if (c42748a.type != 0) {
                new C24088a(ConversationAppBrandRecentView.this.getContext()).mo39886a(view, new C199151(), new C5279d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(134357);
                        if (ConversationAppBrandRecentView.this.jnY != null) {
                            ConversationAppBrandRecentView.this.jnY.mo35152a(menuItem, c42748a.position, c42748a);
                        }
                        if (menuItem.getItemId() == 1 && c42748a.position >= 0) {
                            ConversationAppBrandRecentView.this.jnZ = true;
                            C4990ab.m7417i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", Integer.valueOf(c42748a.position), ConversationAppBrandRecentView.this.jax);
                            if (ConversationAppBrandRecentView.this.jax == C19907f.RECENT_APP_BRAND) {
                                ((C26767ag) C1720g.m3528K(C26767ag.class)).mo44539aE(c42748a.iXW.username, c42748a.iXW.har);
                            } else if (ConversationAppBrandRecentView.this.jax == C19907f.MY_APP_BRAND) {
                                ((C10118af) C1720g.m3528K(C10118af.class)).mo21473aD(c42748a.iXW.username, c42748a.iXW.har);
                            }
                            C4990ab.m7417i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", c42748a.iXW.nickname, Integer.valueOf(c42748a.position));
                            ConversationAppBrandRecentView.this.mo61454qW(c42748a.position);
                        }
                        AppMethodBeat.m2505o(134357);
                    }
                }, (int) f, (int) f2);
            }
            AppMethodBeat.m2505o(134359);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView$2 */
    class C386212 implements C33648a {
        C386212() {
        }

        /* renamed from: e */
        public final void mo35168e(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(134360);
            int currentPage = ConversationAppBrandRecentView.this.getCurrentPage();
            C4990ab.m7417i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", Integer.valueOf(i), Integer.valueOf(currentPage));
            ConversationAppBrandRecentView.m65469e(ConversationAppBrandRecentView.this);
            if (ConversationAppBrandRecentView.this.jnS != null) {
                ConversationAppBrandRecentView.this.jnS.mo35168e(recyclerView, i);
            }
            AppMethodBeat.m2505o(134360);
        }

        /* renamed from: L */
        public final void mo35167L(int i, boolean z) {
            AppMethodBeat.m2504i(134361);
            if (ConversationAppBrandRecentView.this.jnS != null) {
                ConversationAppBrandRecentView.this.jnS.mo35167L(i, z);
            }
            AppMethodBeat.m2505o(134361);
        }

        /* renamed from: h */
        public final void mo35169h(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(134362);
            if (ConversationAppBrandRecentView.this.jnS != null) {
                ConversationAppBrandRecentView.this.jnS.mo35169h(recyclerView, i, i2);
            }
            AppMethodBeat.m2505o(134362);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView$3 */
    class C386223 implements Runnable {
        C386223() {
        }

        public final void run() {
            AppMethodBeat.m2504i(134363);
            ConversationAppBrandRecentView conversationAppBrandRecentView = ConversationAppBrandRecentView.this;
            if (conversationAppBrandRecentView.jnC) {
                int size = conversationAppBrandRecentView.jny.size();
                if (size - 1 < conversationAppBrandRecentView.iJL.size() && ((C42748a) conversationAppBrandRecentView.iJL.get(size - 1)) != null) {
                    C4990ab.m7417i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", Integer.valueOf(size));
                    conversationAppBrandRecentView.jny.add(size, conversationAppBrandRecentView.iJL.get(size - 1));
                    conversationAppBrandRecentView.getAdapter().mo66317ch(size);
                    conversationAppBrandRecentView.getAdapter().mo66308ar(size, 5);
                }
            }
            if (ConversationAppBrandRecentView.this.getOnDataChangedListener() != null) {
                C38618d onDataChangedListener = ConversationAppBrandRecentView.this.getOnDataChangedListener();
                ConversationAppBrandRecentView.this.getPreviewItemList().size();
                onDataChangedListener.aQf();
            }
            AppMethodBeat.m2505o(134363);
        }
    }

    static {
        AppMethodBeat.m2504i(134381);
        AppMethodBeat.m2505o(134381);
    }

    public void setOnBindCustomViewHolderListener(C11047a c11047a) {
        this.jnW = c11047a;
    }

    public ConversationAppBrandRecentView(Context context) {
        super(context);
    }

    public ConversationAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getLayoutId() {
        return 2130968770;
    }

    /* renamed from: a */
    public final void mo61441a(C19910c c19910c, C42748a c42748a, int i) {
        AppMethodBeat.m2504i(134364);
        super.mo61441a(c19910c, c42748a, i);
        if (c42748a != null && c42748a.type == 0) {
            c19910c.gne.setVisibility(4);
            c19910c.iqT.setImageResource(C1318a.multitask_bar_more_btn);
        }
        if (!(!C2545b.aPd() || c42748a == null || c19910c == null || c19910c.apJ == null)) {
            if (c42748a.type == 3) {
                c19910c.apJ.setVisibility(4);
                c19910c.apJ.getLayoutParams().width = 0;
            }
            int dl = (int) C10969d.m18709dl(getContext());
            c19910c.iYe.getLayoutParams().width = (C1338a.m2857am(getContext(), C25738R.dimen.f10011nc) * 2) + dl;
            c19910c.iYe.getLayoutParams().height = (C1338a.m2857am(getContext(), C25738R.dimen.f10011nc) * 2) + dl;
            c19910c.iqT.getLayoutParams().width = dl;
            c19910c.iqT.getLayoutParams().height = dl;
            c19910c.iYd.getLayoutParams().width = dl;
            c19910c.iYd.getLayoutParams().height = dl;
            dl = getCurrentPage();
            int rb = C33646e.m54942rb(dl);
            C4990ab.m7417i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", Integer.valueOf(dl), Integer.valueOf(rb), Integer.valueOf(C33646e.m54943rc(dl)), Integer.valueOf(i));
            if (i == C33646e.m54943rc(dl)) {
                c19910c.apJ.animate().alpha(0.3f).setDuration(1).start();
            } else if (c42748a.imK) {
                c19910c.apJ.setVisibility(4);
            } else {
                c19910c.apJ.setVisibility(0);
                c19910c.apJ.setAlpha(1.0f);
            }
        }
        if (this.jnW != null) {
            this.jnW.mo22742a(c19910c, i);
        }
        AppMethodBeat.m2505o(134364);
    }

    /* Access modifiers changed, original: protected */
    public float getShowCountPerPage() {
        AppMethodBeat.m2504i(134365);
        float showCountPerPage = C2545b.getShowCountPerPage();
        AppMethodBeat.m2505o(134365);
        return showCountPerPage;
    }

    /* Access modifiers changed, original: protected */
    public int getCompletelyCountPerPage() {
        AppMethodBeat.m2504i(134366);
        int completelyCountPerPage = C2545b.getCompletelyCountPerPage();
        AppMethodBeat.m2505o(134366);
        return completelyCountPerPage;
    }

    /* Access modifiers changed, original: protected */
    public int getLoadCount() {
        AppMethodBeat.m2504i(134367);
        if (this.jax == C19907f.RECENT_APP_BRAND) {
            AppMethodBeat.m2505o(134367);
            return 50;
        } else if (this.jax == C19907f.MY_APP_BRAND) {
            int axI = C2545b.axI();
            AppMethodBeat.m2505o(134367);
            return axI;
        } else {
            AppMethodBeat.m2505o(134367);
            return 50;
        }
    }

    /* Access modifiers changed, original: protected */
    public int getShowCount() {
        AppMethodBeat.m2504i(134368);
        int i;
        if (this.jax == C19907f.RECENT_APP_BRAND) {
            i = C2545b.iWq;
            AppMethodBeat.m2505o(134368);
            return i;
        } else if (this.jax == C19907f.MY_APP_BRAND) {
            i = C2545b.axI();
            AppMethodBeat.m2505o(134368);
            return i;
        } else {
            AppMethodBeat.m2505o(134368);
            return 50;
        }
    }

    /* Access modifiers changed, original: protected */
    public String getType() {
        AppMethodBeat.m2504i(134369);
        String simpleName = ConversationAppBrandRecentView.class.getSimpleName();
        AppMethodBeat.m2505o(134369);
        return simpleName;
    }

    /* renamed from: aR */
    public final void mo61442aR(List<C42748a> list) {
        AppMethodBeat.m2504i(134370);
        if (!C2545b.aPd()) {
            list.add(new C42748a(0));
        }
        if (C2545b.aPd()) {
            C2545b.aPf();
            list.add(0, new C42748a(3));
        }
        AppMethodBeat.m2505o(134370);
    }

    public int getCustomItemCount() {
        AppMethodBeat.m2504i(134371);
        if (!C2545b.aPd()) {
            AppMethodBeat.m2505o(134371);
            return 1;
        } else if (C2545b.aPd()) {
            C2545b.aPf();
            AppMethodBeat.m2505o(134371);
            return 1;
        } else {
            AppMethodBeat.m2505o(134371);
            return 0;
        }
    }

    public void setOnItemClickListener(C38620b c38620b) {
        this.jas = c38620b;
    }

    public void setCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
        this.jnX = onCreateContextMenuListener;
    }

    public void setMenuItemSelectedListener(C19906a c19906a) {
        this.jnY = c19906a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void init(Context context) {
        AppMethodBeat.m2504i(134372);
        super.init(context);
        this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        super.setOnItemClickListener(new C199131());
        if (C2545b.aPd()) {
            super.setOnScrollPageListener(new C386212());
        }
        AppMethodBeat.m2505o(134372);
    }

    public void setOnScrollPageListener(C33648a c33648a) {
        this.jnS = c33648a;
    }

    /* renamed from: g */
    private void m65471g(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(134373);
        C4990ab.m7411d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", Integer.valueOf(i));
        if (c41531v != null) {
            float x = c41531v.apJ.getX();
            if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2)))) {
                c41531v.apJ.setAlpha(0.3f);
                AppMethodBeat.m2505o(134373);
                return;
            } else if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2))) || x < this.jnU) {
                c41531v.apJ.setAlpha(1.0f);
            } else {
                C4990ab.m7411d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", Float.valueOf(1.0f - (((x - this.jnU) / ((float) this.jnV)) * 0.7f)));
                c41531v.apJ.setAlpha(x);
                AppMethodBeat.m2505o(134373);
                return;
            }
        }
        AppMethodBeat.m2505o(134373);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: qW */
    public final void mo61454qW(int i) {
        AppMethodBeat.m2504i(134374);
        super.mo61454qW(i);
        getPreviewItemList().remove(i);
        getAdapter().mo66318ci(i);
        getAdapter().mo66308ar(i, 5);
        if (this.jax == C19907f.RECENT_APP_BRAND) {
            C5004al.m7442n(new C386223(), 200);
            AppMethodBeat.m2505o(134374);
            return;
        }
        if (getOnDataChangedListener() != null) {
            C38618d onDataChangedListener = getOnDataChangedListener();
            getPreviewItemList().size();
            onDataChangedListener.aQf();
        }
        AppMethodBeat.m2505o(134374);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aRZ() {
        boolean z = this.jnZ;
        this.jnZ = false;
        return z;
    }

    public void setIgnoreNotify(boolean z) {
        this.jnZ = z;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(134375);
        C4990ab.m7417i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", ((C6624h) C1720g.m3533RM().mo5224Rn()).toString(), Integer.valueOf(c4935m.hsh), this.jax);
        if (aRZ()) {
            AppMethodBeat.m2505o(134375);
            return;
        }
        refresh();
        AppMethodBeat.m2505o(134375);
    }

    public int getItemWidth() {
        AppMethodBeat.m2504i(134376);
        int di = C10969d.m18706di(getContext());
        AppMethodBeat.m2505o(134376);
        return di;
    }

    private int getItemPadding() {
        AppMethodBeat.m2504i(134377);
        int dj = C10969d.m18707dj(getContext());
        AppMethodBeat.m2505o(134377);
        return dj;
    }

    public List<C42748a> getPreviewItemList() {
        AppMethodBeat.m2504i(134378);
        List previewItemList = super.getPreviewItemList();
        AppMethodBeat.m2505o(134378);
        return previewItemList;
    }

    /* renamed from: qX */
    public final boolean mo61455qX(int i) {
        AppMethodBeat.m2504i(134379);
        int currentPage = (getCurrentPage() + 1) * C2545b.getCompletelyCountPerPage();
        C2545b.aPf();
        if (currentPage + 1 == i) {
            AppMethodBeat.m2505o(134379);
            return true;
        }
        AppMethodBeat.m2505o(134379);
        return false;
    }

    /* renamed from: e */
    static /* synthetic */ void m65469e(ConversationAppBrandRecentView conversationAppBrandRecentView) {
        AppMethodBeat.m2504i(134380);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) conversationAppBrandRecentView.getLayoutManager();
        if (linearLayoutManager != null) {
            conversationAppBrandRecentView.mScreenWidth = conversationAppBrandRecentView.getResources().getDisplayMetrics().widthPixels;
            conversationAppBrandRecentView.jnV = conversationAppBrandRecentView.getItemPadding() + C1338a.fromDPToPix(conversationAppBrandRecentView.getContext(), 50);
            conversationAppBrandRecentView.jnU = (float) ((conversationAppBrandRecentView.mScreenWidth - (conversationAppBrandRecentView.getItemWidth() / 2)) - conversationAppBrandRecentView.jnV);
            int iS = linearLayoutManager.mo1782iS();
            int iT = linearLayoutManager.mo1783iT();
            C4990ab.m7411d("MicroMsg.ConversationAppBrandRecentView", "alvinluo onScroll mAlphaChangeOffset: %s, ALPHA_DISTANCE: %d", Float.valueOf(conversationAppBrandRecentView.jnU), Integer.valueOf(conversationAppBrandRecentView.jnV));
            C41531v cf = conversationAppBrandRecentView.mo66357cf(iS);
            C41531v cf2 = conversationAppBrandRecentView.mo66357cf(iT);
            conversationAppBrandRecentView.m65471g(cf, iS);
            conversationAppBrandRecentView.m65471g(cf2, iT);
        }
        AppMethodBeat.m2505o(134380);
    }
}
