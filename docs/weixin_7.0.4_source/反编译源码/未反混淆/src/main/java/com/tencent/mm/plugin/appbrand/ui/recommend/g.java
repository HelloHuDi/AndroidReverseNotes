package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.t;
import a.f.b.v;
import a.y;
import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004*\u0002HK\b&\u0018\u0000 t2\u00020\u0001:\u0002tuB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010N\u001a\u00020O2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010Q\u001a\u000209H\u0002J\u0010\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u000209H\u0002J\b\u0010T\u001a\u00020OH\u0002J\b\u0010U\u001a\u00020OH\u0002J\b\u0010V\u001a\u00020OH\u0002J\b\u0010W\u001a\u00020OH\u0002J\b\u0010X\u001a\u00020OH\u0002J\b\u0010Y\u001a\u00020OH\u0002J\u0006\u0010Z\u001a\u00020OJ\b\u0010[\u001a\u00020OH\u0007J\b\u0010\\\u001a\u00020OH\u0007J\b\u0010]\u001a\u00020OH\u0007J\b\u0010^\u001a\u00020OH\u0002J\u0018\u0010_\u001a\u00020O2\u0006\u0010`\u001a\u00020)2\u0006\u0010a\u001a\u00020)H\u0002J\b\u0010b\u001a\u00020OH\u0007J\b\u0010c\u001a\u00020OH\u0007J\u0010\u0010d\u001a\u00020O2\u0006\u0010e\u001a\u00020fH&J\u0010\u0010g\u001a\u00020O2\u0006\u0010h\u001a\u00020)H\u0002J\b\u0010i\u001a\u00020OH\u0002J \u0010j\u001a\u00020O2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*H\u0002J\u0016\u0010k\u001a\u00020O2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020O0mH\u0002J\b\u0010n\u001a\u00020OH\u0002J\b\u0010o\u001a\u00020OH\u0002J\u0016\u0010p\u001a\u00020O2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001f0rH\u0002J\b\u0010s\u001a\u00020OH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R-\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 `!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R!\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008FX\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b1\u00102R\u0012\u00104\u001a\u000605R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u000209X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R-\u0010<\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f`!¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u001b\u0010>\u001a\u00020?8FX\u0002¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\b@\u0010AR\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R!\u0010E\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u0010\u0010G\u001a\u00020HX\u0004¢\u0006\u0004\n\u0002\u0010IR\u0010\u0010J\u001a\u00020KX\u0004¢\u0006\u0004\n\u0002\u0010LR\u000e\u0010M\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
public abstract class g implements LifecycleObserver {
    private static final String TAG = TAG;
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(g.class), "recommendCardList", "getRecommendCardList()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;")), v.a(new t(v.aN(g.class), "appBrandRomLogic", "getAppBrandRomLogic()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;")), v.a(new t(v.aN(g.class), "listFooterController", "getListFooterController()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;"))};
    public static final a iQy = new a();
    final Activity activity;
    final Context context;
    private final a.f iQh;
    private final a.f iQi;
    private final al iQj;
    final a iQk;
    final b iQl;
    final LinearLayoutManager iQm;
    final com.tencent.mm.plugin.appbrand.ui.recents.g iQn;
    final f iQo;
    private final a.f iQp;
    private final com.tencent.mm.sdk.e.k.a iQq;
    private final com.tencent.mm.sdk.e.k.a iQr;
    final ArrayList<Integer> iQs;
    final ArrayList<Integer> iQt;
    final HashMap<String, Long> iQu;
    final HashMap<Integer, String> iQv;
    final l iQw;
    private final p iQx;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class r implements com.tencent.mm.sdk.e.k.a {
        final /* synthetic */ g iQA;

        r(g gVar) {
            this.iQA = gVar;
        }

        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(135201);
            h.a(this.iQA, (a.f.a.a) new q(this.iQA));
            AppMethodBeat.o(135201);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
    public static final class p {
        final /* synthetic */ g iQA;

        p(g gVar) {
            this.iQA = gVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class q extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ g iQA;

        q(g gVar) {
            this.iQA = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135200);
            this.iQA.iQk.notifyDataSetChanged();
            y yVar = y.AUy;
            AppMethodBeat.o(135200);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class g implements OnLongClickListener {
        public static final g iQI = new g();

        static {
            AppMethodBeat.i(135189);
            AppMethodBeat.o(135189);
        }

        g() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    static final class h implements com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a {
        final /* synthetic */ g iQA;

        h(g gVar) {
            this.iQA = gVar;
        }

        public final void aMC() {
            AppMethodBeat.i(135190);
            if (this.iQA.iQl.aNO()) {
                ab.d(g.TAG, "can load more: let's do fetch");
                this.iQA.eL(false);
            }
            AppMethodBeat.o(135190);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
    static final class i extends a.f.b.k implements a.f.a.a<com.tencent.mm.plugin.appbrand.ui.recents.e> {
        final /* synthetic */ g iQA;

        i(g gVar) {
            this.iQA = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135191);
            com.tencent.mm.plugin.appbrand.ui.recents.e eVar = new com.tencent.mm.plugin.appbrand.ui.recents.e(this.iQA.context, this.iQA.aNL());
            AppMethodBeat.o(135191);
            return eVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
    public final class b {
        volatile int fQk;
        volatile boolean iQz;
        volatile boolean isLoading;

        public final boolean aNO() {
            return this.iQz && !this.isLoading;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ a.f.a.a hbA;

        k(a.f.a.a aVar) {
            this.hbA = aVar;
        }

        public final void run() {
            AppMethodBeat.i(135193);
            this.hbA.invoke();
            AppMethodBeat.o(135193);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
    static final class j extends a.f.b.k implements a.f.a.a<RecommendRecycleView> {
        final /* synthetic */ g iQA;

        j(g gVar) {
            this.iQA = gVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135192);
            RecommendRecycleView recommendRecycleView = new RecommendRecycleView(this.iQA.activity);
            AppMethodBeat.o(135192);
            return recommendRecycleView;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ g iQA;
        final /* synthetic */ boolean iQC;

        e(g gVar, boolean z) {
            this.iQA = gVar;
            this.iQC = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            y yVar;
            AppMethodBeat.i(135186);
            synchronized (this.iQA.iQl) {
                try {
                    this.iQA.iQl.isLoading = true;
                    yVar = y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.o(135186);
                }
            }
            if (this.iQC) {
                ab.i(g.TAG, "fetching page from memory, pageNum:%d, ", Integer.valueOf(this.iQA.iQl.fQk));
                com.tencent.mm.plugin.appbrand.appusage.a.e.d(new com.tencent.mm.plugin.appbrand.appusage.a.d.f(this.iQA.aNM()));
            } else {
                ab.i(g.TAG, "fetching page, pageNum:%d, ", Integer.valueOf(this.iQA.iQl.fQk));
                com.tencent.mm.plugin.appbrand.appusage.a.e.d(new com.tencent.mm.plugin.appbrand.appusage.a.d.e(this.iQA.aNM(), this.iQA.iQl.fQk));
            }
            yVar = y.AUy;
            AppMethodBeat.o(135186);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\"\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
    public static final class l extends android.support.v7.widget.RecyclerView.m {
        private boolean iMJ;
        final /* synthetic */ g iQA;
        private final ArrayList<Integer> iQJ = new ArrayList();
        private final ArrayList<Integer> iQK = new ArrayList();

        l(g gVar) {
            this.iQA = gVar;
            AppMethodBeat.i(135196);
            AppMethodBeat.o(135196);
        }

        public final void a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.i(135194);
            super.a(recyclerView, i, i2);
            android.support.v7.widget.RecyclerView.i layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            if (layoutManager instanceof LinearLayoutManager) {
                int iQ = ((LinearLayoutManager) layoutManager).iQ();
                int iS = ((LinearLayoutManager) layoutManager).iS();
                if (iQ == 0 && iS == 1) {
                    i.b(this.iQA.context, this.iQA.iQn.aNi());
                    AppMethodBeat.o(135194);
                    return;
                }
                this.iQK.clear();
                if (iQ <= iS) {
                    int i3 = iQ;
                    while (true) {
                        if (i3 == 0) {
                            i.b(this.iQA.context, this.iQA.iQn.aNi());
                        } else {
                            RecyclerView.v cf = this.iQA.aNL().cf(i3);
                            if (cf != null && (cf instanceof com.tencent.mm.plugin.appbrand.ui.recommend.a.c)) {
                                this.iQK.add(Integer.valueOf(i3));
                                if (!this.iQJ.contains(Integer.valueOf(i3))) {
                                    int S = this.iQA.aNL().S(cf);
                                    ab.d(g.TAG, "reportExposeData index:%d, holderPosition:%d", Integer.valueOf(i3), Integer.valueOf(S));
                                    if (S < this.iQA.iQk.getItemCount()) {
                                        Object obj = this.iQA.iQk.aND().get(S);
                                        a.f.b.j.o(obj, "wxaList[position]");
                                        bqd bqd = (bqd) obj;
                                        this.iQA.iQo.d(S, bqd);
                                        this.iQA.iQu.put(bqd.izZ, Long.valueOf(System.currentTimeMillis()));
                                        this.iQA.iQv.put(Integer.valueOf(i3), bqd.izZ);
                                        this.iQA.iQs.add(Integer.valueOf(i3));
                                    }
                                }
                            }
                        }
                        if (i3 == iS) {
                            break;
                        }
                        i3++;
                    }
                }
                this.iQA.iQt.clear();
                this.iQJ.removeAll(this.iQK);
                this.iQA.iQt.addAll(this.iQJ);
                this.iQJ.clear();
                this.iQJ.addAll(this.iQK);
                this.iQA.iQs.removeAll(this.iQA.iQt);
                this.iQA.c(this.iQA.iQt, true);
            }
            AppMethodBeat.o(135194);
        }

        public final void c(RecyclerView recyclerView, int i) {
            AppMethodBeat.i(135195);
            super.c(recyclerView, i);
            this.iMJ = i == 2;
            if (this.iMJ) {
                this.iQA.iQo.eK(this.iMJ);
            }
            android.support.v7.widget.RecyclerView.i layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).iQ();
                int iS = ((LinearLayoutManager) layoutManager).iS();
                if (iS >= 3) {
                    iS--;
                }
                this.iQA.aNM().cPK = iS;
            }
            AppMethodBeat.o(135195);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    static final class n extends a.f.b.k implements a.f.a.m<bqd, Integer, y> {
        final /* synthetic */ g iQA;

        n(g gVar) {
            this.iQA = gVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(135198);
            bqd bqd = (bqd) obj;
            int intValue = ((Number) obj2).intValue();
            a.f.b.j.p(bqd, "recommendCard");
            this.iQA.iQo.a(intValue, bqd);
            y yVar = y.AUy;
            AppMethodBeat.o(135198);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<com.tencent.mm.plugin.appbrand.appusage.a.d> {
        public static final c iQB = new c();

        static {
            AppMethodBeat.i(135184);
            AppMethodBeat.o(135184);
        }

        c() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135183);
            com.tencent.mm.plugin.appbrand.appusage.a.d aya = com.tencent.mm.plugin.appbrand.appusage.a.d.hbu.aya();
            AppMethodBeat.o(135183);
            return aya;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class d implements com.tencent.mm.sdk.e.k.a {
        final /* synthetic */ g iQA;

        d(g gVar) {
            this.iQA = gVar;
        }

        public final void a(String str, com.tencent.mm.sdk.e.m mVar) {
            AppMethodBeat.i(135185);
            h.a(this.iQA, (a.f.a.a) new q(this.iQA));
            AppMethodBeat.o(135185);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    static final class m extends a.f.b.k implements a.f.a.m<bqd, Integer, y> {
        final /* synthetic */ g iQA;

        m(g gVar) {
            this.iQA = gVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(135197);
            bqd bqd = (bqd) obj;
            int intValue = ((Number) obj2).intValue();
            a.f.b.j.p(bqd, "recommendCard");
            if (intValue == 0) {
                i.b(this.iQA.context, this.iQA.iQn.aNi());
            }
            y yVar = y.AUy;
            AppMethodBeat.o(135197);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.q<Integer, LinkedList<bqd>, Integer, y> {
        final /* synthetic */ g iQA;

        f(g gVar) {
            this.iQA = gVar;
            super(3);
        }

        public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(135188);
            final int intValue = ((Number) obj).intValue();
            final LinkedList linkedList = (LinkedList) obj2;
            final int intValue2 = ((Number) obj3).intValue();
            a.f.b.j.p(linkedList, "fetchedDataList");
            ab.i(g.TAG, "onFetchFinish, remainCount:%d, size:%d, result code:%d", Integer.valueOf(intValue2), Integer.valueOf(linkedList.size()), Integer.valueOf(intValue));
            if (intValue == 0 || intValue == 3) {
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((bqd) it.next()).wSq);
                }
                g.a(this.iQA, (List) arrayList);
            }
            final a.f.b.u.b bVar = new a.f.b.u.b();
            bVar.AVD = this.iQA.iQl.fQk;
            synchronized (this.iQA.iQl) {
                try {
                    this.iQA.iQl.fQk = this.iQA.aNM().hbm;
                    y yVar = y.AUy;
                } finally {
                    AppMethodBeat.o(135188);
                }
            }
            h.a(this.iQA, (a.f.a.a) new a.f.a.a<y>(this) {
                final /* synthetic */ f iQD;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(135187);
                    i.b(this.iQD.iQA.context, this.iQD.iQA.iQn.aNi());
                    if (linkedList == null || !(intValue == 0 || intValue == 2 || intValue == 3)) {
                        ab.i(g.TAG, "onFetchFinish fail");
                        g.e(this.iQD.iQA);
                    } else {
                        ab.i(g.TAG, "onFetchFinish success and data size = %d, page num:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.iQD.iQA.iQl.fQk));
                        a aVar;
                        LinkedList linkedList;
                        if ((intValue == 0 && (this.iQD.iQA.iQl.fQk == 0 || (bVar.AVD == 0 && this.iQD.iQA.iQl.fQk == 1))) || intValue == 2 || intValue == 3) {
                            aVar = this.iQD.iQA.iQk;
                            linkedList = linkedList;
                            a.f.b.j.p(linkedList, "data");
                            aVar.aND().clear();
                            aVar.aND().addAll(linkedList);
                        } else {
                            aVar = this.iQD.iQA.iQk;
                            linkedList = linkedList;
                            a.f.b.j.p(linkedList, "data");
                            aVar.aND().addAll(linkedList);
                        }
                        if (intValue == 3) {
                            ab.i(g.TAG, "scrollToPosition %d", Integer.valueOf(this.iQD.iQA.aNM().cPK));
                            this.iQD.iQA.aNL().bY(this.iQD.iQA.aNM().cPK);
                        }
                        this.iQD.iQA.iQk.notifyDataSetChanged();
                        g.a(this.iQD.iQA, intValue2);
                    }
                    y yVar = y.AUy;
                    AppMethodBeat.o(135187);
                    return yVar;
                }
            });
            Object obj4 = y.AUy;
            return obj4;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    static final class o extends a.f.b.k implements a.f.a.m<bqd, Integer, y> {
        final /* synthetic */ g iQA;

        o(g gVar) {
            this.iQA = gVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(135199);
            bqd bqd = (bqd) obj;
            int intValue = ((Number) obj2).intValue();
            a.f.b.j.p(bqd, "recommendCard");
            this.iQA.iQo.b(intValue, bqd);
            y yVar = y.AUy;
            AppMethodBeat.o(135199);
            return yVar;
        }
    }

    public abstract String aNB();

    public abstract boolean aNC();

    public final LoadMoreRecyclerView aNL() {
        return (LoadMoreRecyclerView) this.iQh.getValue();
    }

    /* Access modifiers changed, original: final */
    public final com.tencent.mm.plugin.appbrand.appusage.a.d aNM() {
        return (com.tencent.mm.plugin.appbrand.appusage.a.d) this.iQi.getValue();
    }

    public final com.tencent.mm.plugin.appbrand.ui.recents.e aNN() {
        return (com.tencent.mm.plugin.appbrand.ui.recents.e) this.iQp.getValue();
    }

    public abstract View getContentView();

    public g(Activity activity) {
        a.f.b.j.p(activity, "activity");
        this.activity = activity;
        Activity activity2 = this.activity;
        if (activity2 == null) {
            throw new a.v("null cannot be cast to non-null type android.content.Context");
        }
        this.context = activity2;
        this.iQh = a.i.g(new j(this));
        this.iQi = a.i.g(c.iQB);
        this.iQj = new al("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
        this.iQk = new a(this.activity);
        this.iQl = new b();
        this.iQm = new j(this.context);
        this.iQn = new com.tencent.mm.plugin.appbrand.ui.recents.g(this.activity, aNL());
        this.iQo = new f();
        this.iQp = a.i.g(new i(this));
        this.iQq = new d(this);
        this.iQr = new r(this);
        this.iQs = new ArrayList();
        this.iQt = new ArrayList();
        this.iQu = new HashMap();
        this.iQv = new HashMap();
        this.iQw = new l(this);
        this.iQx = new p(this);
    }

    private final void c(ArrayList<Integer> arrayList, boolean z) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if ((num == null || num.intValue() != 0) && this.iQv.containsKey(num)) {
                String str = (String) this.iQv.get(num);
                Long l = (Long) this.iQu.get(str);
                if (!(str == null || l == null)) {
                    ab.d(TAG, "exposure index: %d, exposureTime:%d", num, Long.valueOf(System.currentTimeMillis() - l.longValue()));
                    this.iQo.y(str, r4);
                }
            }
        }
        if (z) {
            arrayList.clear();
        }
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    public final void onCreate() {
        ab.i(TAG, "onCreate");
    }

    @OnLifecycleEvent(Event.ON_RESUME)
    public final void onResume() {
        ab.i(TAG, "onResume");
        this.iQo.aNI();
        Iterator it = this.iQs.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if ((num == null || num.intValue() != 0) && this.iQv.containsKey(num)) {
                String str = (String) this.iQv.get(num);
                Long l = (Long) this.iQu.get(str);
                if (!(str == null || l == null)) {
                    this.iQu.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    @OnLifecycleEvent(Event.ON_PAUSE)
    public final void onPause() {
        ab.i(TAG, "onPause");
        c(this.iQs, false);
        this.iQo.aNJ();
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public final void onDestroy() {
        boolean z;
        ab.i(TAG, "onDestroy");
        ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).d(this.iQq);
        com.tencent.mm.plugin.appbrand.app.f.auO().d(this.iQr);
        this.iQs.clear();
        this.iQt.clear();
        this.iQu.clear();
        this.iQv.clear();
        this.iQo.gu(aNM().hbj);
        com.tencent.mm.plugin.appbrand.appusage.a.d aNM = aNM();
        if (aNM().axY().isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        aNM.hbn = z;
        aNM().hbo = 0;
        com.tencent.mm.plugin.appbrand.appusage.a.d aNM2 = aNM();
        aNM2.hbh.a(null);
        aNM2.hbs = null;
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public final void onDestroyView() {
        this.iQj.quit();
        this.iQn.onDetached();
        aNN().onDetached();
        aNL().b((android.support.v7.widget.RecyclerView.m) this.iQw);
    }

    /* Access modifiers changed, original: final */
    public final void eL(boolean z) {
        h.a(this, true);
        h.b(this, true);
        d((a.f.a.a) new e(this, z));
    }

    private final void d(a.f.a.a<y> aVar) {
        this.iQj.ae(new k(aVar));
    }

    public static final /* synthetic */ void e(g gVar) {
        ab.i(TAG, "onFetchPageFail");
        h.b(gVar, false);
        h.a(gVar, true);
        h.h(gVar);
        synchronized (gVar.iQl) {
            gVar.iQl.isLoading = false;
            y yVar = y.AUy;
        }
    }
}
