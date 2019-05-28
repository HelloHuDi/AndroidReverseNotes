package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.n;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.List;

public class ConversationAppBrandRecentView extends BaseAppBrandRecentView {
    private static final int jnT = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 200);
    private b jas;
    private com.tencent.mm.plugin.appbrand.widget.recentview.e.a jnS;
    private float jnU = 0.0f;
    private int jnV = 0;
    private a jnW = null;
    private OnCreateContextMenuListener jnX = null;
    private com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a jnY = null;
    private boolean jnZ = false;
    private int mScreenWidth = 0;

    public interface a {
        void a(c cVar, int i);
    }

    static {
        AppMethodBeat.i(134381);
        AppMethodBeat.o(134381);
    }

    public void setOnBindCustomViewHolderListener(a aVar) {
        this.jnW = aVar;
    }

    public ConversationAppBrandRecentView(Context context) {
        super(context);
    }

    public ConversationAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getLayoutId() {
        return R.layout.ej;
    }

    public final void a(c cVar, a aVar, int i) {
        AppMethodBeat.i(134364);
        super.a(cVar, aVar, i);
        if (aVar != null && aVar.type == 0) {
            cVar.gne.setVisibility(4);
            cVar.iqT.setImageResource(R.raw.multitask_bar_more_btn);
        }
        if (!(!com.tencent.mm.plugin.appbrand.widget.desktop.b.aPd() || aVar == null || cVar == null || cVar.apJ == null)) {
            if (aVar.type == 3) {
                cVar.apJ.setVisibility(4);
                cVar.apJ.getLayoutParams().width = 0;
            }
            int dl = (int) d.dl(getContext());
            cVar.iYe.getLayoutParams().width = (com.tencent.mm.bz.a.am(getContext(), R.dimen.nc) * 2) + dl;
            cVar.iYe.getLayoutParams().height = (com.tencent.mm.bz.a.am(getContext(), R.dimen.nc) * 2) + dl;
            cVar.iqT.getLayoutParams().width = dl;
            cVar.iqT.getLayoutParams().height = dl;
            cVar.iYd.getLayoutParams().width = dl;
            cVar.iYd.getLayoutParams().height = dl;
            dl = getCurrentPage();
            int rb = e.rb(dl);
            ab.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", Integer.valueOf(dl), Integer.valueOf(rb), Integer.valueOf(e.rc(dl)), Integer.valueOf(i));
            if (i == e.rc(dl)) {
                cVar.apJ.animate().alpha(0.3f).setDuration(1).start();
            } else if (aVar.imK) {
                cVar.apJ.setVisibility(4);
            } else {
                cVar.apJ.setVisibility(0);
                cVar.apJ.setAlpha(1.0f);
            }
        }
        if (this.jnW != null) {
            this.jnW.a(cVar, i);
        }
        AppMethodBeat.o(134364);
    }

    /* Access modifiers changed, original: protected */
    public float getShowCountPerPage() {
        AppMethodBeat.i(134365);
        float showCountPerPage = com.tencent.mm.plugin.appbrand.widget.desktop.b.getShowCountPerPage();
        AppMethodBeat.o(134365);
        return showCountPerPage;
    }

    /* Access modifiers changed, original: protected */
    public int getCompletelyCountPerPage() {
        AppMethodBeat.i(134366);
        int completelyCountPerPage = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
        AppMethodBeat.o(134366);
        return completelyCountPerPage;
    }

    /* Access modifiers changed, original: protected */
    public int getLoadCount() {
        AppMethodBeat.i(134367);
        if (this.jax == f.RECENT_APP_BRAND) {
            AppMethodBeat.o(134367);
            return 50;
        } else if (this.jax == f.MY_APP_BRAND) {
            int axI = com.tencent.mm.plugin.appbrand.widget.desktop.b.axI();
            AppMethodBeat.o(134367);
            return axI;
        } else {
            AppMethodBeat.o(134367);
            return 50;
        }
    }

    /* Access modifiers changed, original: protected */
    public int getShowCount() {
        AppMethodBeat.i(134368);
        int i;
        if (this.jax == f.RECENT_APP_BRAND) {
            i = com.tencent.mm.plugin.appbrand.widget.desktop.b.iWq;
            AppMethodBeat.o(134368);
            return i;
        } else if (this.jax == f.MY_APP_BRAND) {
            i = com.tencent.mm.plugin.appbrand.widget.desktop.b.axI();
            AppMethodBeat.o(134368);
            return i;
        } else {
            AppMethodBeat.o(134368);
            return 50;
        }
    }

    /* Access modifiers changed, original: protected */
    public String getType() {
        AppMethodBeat.i(134369);
        String simpleName = ConversationAppBrandRecentView.class.getSimpleName();
        AppMethodBeat.o(134369);
        return simpleName;
    }

    public final void aR(List<a> list) {
        AppMethodBeat.i(134370);
        if (!com.tencent.mm.plugin.appbrand.widget.desktop.b.aPd()) {
            list.add(new a(0));
        }
        if (com.tencent.mm.plugin.appbrand.widget.desktop.b.aPd()) {
            com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
            list.add(0, new a(3));
        }
        AppMethodBeat.o(134370);
    }

    public int getCustomItemCount() {
        AppMethodBeat.i(134371);
        if (!com.tencent.mm.plugin.appbrand.widget.desktop.b.aPd()) {
            AppMethodBeat.o(134371);
            return 1;
        } else if (com.tencent.mm.plugin.appbrand.widget.desktop.b.aPd()) {
            com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
            AppMethodBeat.o(134371);
            return 1;
        } else {
            AppMethodBeat.o(134371);
            return 0;
        }
    }

    public void setOnItemClickListener(b bVar) {
        this.jas = bVar;
    }

    public void setCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
        this.jnX = onCreateContextMenuListener;
    }

    public void setMenuItemSelectedListener(com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a aVar) {
        this.jnY = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void init(Context context) {
        AppMethodBeat.i(134372);
        super.init(context);
        this.mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        super.setOnItemClickListener(new b() {
            public final boolean a(View view, a aVar, float f, float f2) {
                AppMethodBeat.i(134358);
                if (ConversationAppBrandRecentView.this.jas != null) {
                    ConversationAppBrandRecentView.this.jas.a(view, aVar, f, f2);
                }
                if (aVar.type == 0) {
                    ((g) com.tencent.mm.kernel.g.K(g.class)).b(ConversationAppBrandRecentView.this.getContext(), 13, false);
                } else {
                    ConversationAppBrandRecentView.this.setLayoutFrozen(true);
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = ConversationAppBrandRecentView.this.jax == f.MY_APP_BRAND ? 1104 : FilterEnum4Shaka.MIC_WEISHI_v4_4_HONGJIU;
                    ((e) com.tencent.mm.kernel.g.K(e.class)).a(ConversationAppBrandRecentView.this.getContext(), aVar.iXW.username, null, aVar.iXW.har, -1, null, appBrandStatObject);
                }
                AppMethodBeat.o(134358);
                return false;
            }

            public final boolean b(View view, final a aVar, float f, float f2) {
                AppMethodBeat.i(134359);
                if (ConversationAppBrandRecentView.this.jas != null) {
                    ConversationAppBrandRecentView.this.jas.b(view, aVar, f, f2);
                }
                ab.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", Float.valueOf(f));
                if (aVar.type != 0) {
                    new com.tencent.mm.ui.widget.b.a(ConversationAppBrandRecentView.this.getContext()).a(view, new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(134356);
                            if (ConversationAppBrandRecentView.this.jnX != null) {
                                ConversationAppBrandRecentView.this.jnX.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                            }
                            contextMenu.add(0, 1, contextMenu.size() + 1, ConversationAppBrandRecentView.this.getContext().getResources().getString(R.string.b55));
                            AppMethodBeat.o(134356);
                        }
                    }, new n.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            AppMethodBeat.i(134357);
                            if (ConversationAppBrandRecentView.this.jnY != null) {
                                ConversationAppBrandRecentView.this.jnY.a(menuItem, aVar.position, aVar);
                            }
                            if (menuItem.getItemId() == 1 && aVar.position >= 0) {
                                ConversationAppBrandRecentView.this.jnZ = true;
                                ab.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s, mType: %s", Integer.valueOf(aVar.position), ConversationAppBrandRecentView.this.jax);
                                if (ConversationAppBrandRecentView.this.jax == f.RECENT_APP_BRAND) {
                                    ((ag) com.tencent.mm.kernel.g.K(ag.class)).aE(aVar.iXW.username, aVar.iXW.har);
                                } else if (ConversationAppBrandRecentView.this.jax == f.MY_APP_BRAND) {
                                    ((af) com.tencent.mm.kernel.g.K(af.class)).aD(aVar.iXW.username, aVar.iXW.har);
                                }
                                ab.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo Delete %s, pos: %d", aVar.iXW.nickname, Integer.valueOf(aVar.position));
                                ConversationAppBrandRecentView.this.qW(aVar.position);
                            }
                            AppMethodBeat.o(134357);
                        }
                    }, (int) f, (int) f2);
                }
                AppMethodBeat.o(134359);
                return false;
            }
        });
        if (com.tencent.mm.plugin.appbrand.widget.desktop.b.aPd()) {
            super.setOnScrollPageListener(new com.tencent.mm.plugin.appbrand.widget.recentview.e.a() {
                public final void e(RecyclerView recyclerView, int i) {
                    AppMethodBeat.i(134360);
                    int currentPage = ConversationAppBrandRecentView.this.getCurrentPage();
                    ab.i("MicroMsg.ConversationAppBrandRecentView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", Integer.valueOf(i), Integer.valueOf(currentPage));
                    ConversationAppBrandRecentView.e(ConversationAppBrandRecentView.this);
                    if (ConversationAppBrandRecentView.this.jnS != null) {
                        ConversationAppBrandRecentView.this.jnS.e(recyclerView, i);
                    }
                    AppMethodBeat.o(134360);
                }

                public final void L(int i, boolean z) {
                    AppMethodBeat.i(134361);
                    if (ConversationAppBrandRecentView.this.jnS != null) {
                        ConversationAppBrandRecentView.this.jnS.L(i, z);
                    }
                    AppMethodBeat.o(134361);
                }

                public final void h(RecyclerView recyclerView, int i, int i2) {
                    AppMethodBeat.i(134362);
                    if (ConversationAppBrandRecentView.this.jnS != null) {
                        ConversationAppBrandRecentView.this.jnS.h(recyclerView, i, i2);
                    }
                    AppMethodBeat.o(134362);
                }
            });
        }
        AppMethodBeat.o(134372);
    }

    public void setOnScrollPageListener(com.tencent.mm.plugin.appbrand.widget.recentview.e.a aVar) {
        this.jnS = aVar;
    }

    private void g(v vVar, int i) {
        AppMethodBeat.i(134373);
        ab.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha pos: %d", Integer.valueOf(i));
        if (vVar != null) {
            float x = vVar.apJ.getX();
            if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2)))) {
                vVar.apJ.setAlpha(0.3f);
                AppMethodBeat.o(134373);
                return;
            } else if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2))) || x < this.jnU) {
                vVar.apJ.setAlpha(1.0f);
            } else {
                ab.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo updateAlpha %f", Float.valueOf(1.0f - (((x - this.jnU) / ((float) this.jnV)) * 0.7f)));
                vVar.apJ.setAlpha(x);
                AppMethodBeat.o(134373);
                return;
            }
        }
        AppMethodBeat.o(134373);
    }

    /* Access modifiers changed, original: protected|final */
    public final void qW(int i) {
        AppMethodBeat.i(134374);
        super.qW(i);
        getPreviewItemList().remove(i);
        getAdapter().ci(i);
        getAdapter().ar(i, 5);
        if (this.jax == f.RECENT_APP_BRAND) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(134363);
                    ConversationAppBrandRecentView conversationAppBrandRecentView = ConversationAppBrandRecentView.this;
                    if (conversationAppBrandRecentView.jnC) {
                        int size = conversationAppBrandRecentView.jny.size();
                        if (size - 1 < conversationAppBrandRecentView.iJL.size() && ((a) conversationAppBrandRecentView.iJL.get(size - 1)) != null) {
                            ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo addCacheItemAtLast pos: %d", Integer.valueOf(size));
                            conversationAppBrandRecentView.jny.add(size, conversationAppBrandRecentView.iJL.get(size - 1));
                            conversationAppBrandRecentView.getAdapter().ch(size);
                            conversationAppBrandRecentView.getAdapter().ar(size, 5);
                        }
                    }
                    if (ConversationAppBrandRecentView.this.getOnDataChangedListener() != null) {
                        AppBrandRecentView.d onDataChangedListener = ConversationAppBrandRecentView.this.getOnDataChangedListener();
                        ConversationAppBrandRecentView.this.getPreviewItemList().size();
                        onDataChangedListener.aQf();
                    }
                    AppMethodBeat.o(134363);
                }
            }, 200);
            AppMethodBeat.o(134374);
            return;
        }
        if (getOnDataChangedListener() != null) {
            AppBrandRecentView.d onDataChangedListener = getOnDataChangedListener();
            getPreviewItemList().size();
            onDataChangedListener.aQf();
        }
        AppMethodBeat.o(134374);
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

    public final void a(String str, m mVar) {
        AppMethodBeat.i(134375);
        ab.i("MicroMsg.ConversationAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", ((h) com.tencent.mm.kernel.g.RM().Rn()).toString(), Integer.valueOf(mVar.hsh), this.jax);
        if (aRZ()) {
            AppMethodBeat.o(134375);
            return;
        }
        refresh();
        AppMethodBeat.o(134375);
    }

    public int getItemWidth() {
        AppMethodBeat.i(134376);
        int di = d.di(getContext());
        AppMethodBeat.o(134376);
        return di;
    }

    private int getItemPadding() {
        AppMethodBeat.i(134377);
        int dj = d.dj(getContext());
        AppMethodBeat.o(134377);
        return dj;
    }

    public List<a> getPreviewItemList() {
        AppMethodBeat.i(134378);
        List previewItemList = super.getPreviewItemList();
        AppMethodBeat.o(134378);
        return previewItemList;
    }

    public final boolean qX(int i) {
        AppMethodBeat.i(134379);
        int currentPage = (getCurrentPage() + 1) * com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
        com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
        if (currentPage + 1 == i) {
            AppMethodBeat.o(134379);
            return true;
        }
        AppMethodBeat.o(134379);
        return false;
    }

    static /* synthetic */ void e(ConversationAppBrandRecentView conversationAppBrandRecentView) {
        AppMethodBeat.i(134380);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) conversationAppBrandRecentView.getLayoutManager();
        if (linearLayoutManager != null) {
            conversationAppBrandRecentView.mScreenWidth = conversationAppBrandRecentView.getResources().getDisplayMetrics().widthPixels;
            conversationAppBrandRecentView.jnV = conversationAppBrandRecentView.getItemPadding() + com.tencent.mm.bz.a.fromDPToPix(conversationAppBrandRecentView.getContext(), 50);
            conversationAppBrandRecentView.jnU = (float) ((conversationAppBrandRecentView.mScreenWidth - (conversationAppBrandRecentView.getItemWidth() / 2)) - conversationAppBrandRecentView.jnV);
            int iS = linearLayoutManager.iS();
            int iT = linearLayoutManager.iT();
            ab.d("MicroMsg.ConversationAppBrandRecentView", "alvinluo onScroll mAlphaChangeOffset: %s, ALPHA_DISTANCE: %d", Float.valueOf(conversationAppBrandRecentView.jnU), Integer.valueOf(conversationAppBrandRecentView.jnV));
            v cf = conversationAppBrandRecentView.cf(iS);
            v cf2 = conversationAppBrandRecentView.cf(iT);
            conversationAppBrandRecentView.g(cf, iS);
            conversationAppBrandRecentView.g(cf2, iT);
        }
        AppMethodBeat.o(134380);
    }
}
