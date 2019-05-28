package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C10113e;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C19095d;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C19095d.C10110e;
import com.tencent.p177mm.plugin.appbrand.appusage.p280a.C19095d.C10111f;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C33563e;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C36732g;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38544a.C10921c;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.C11052a;
import com.tencent.p177mm.protocal.protobuf.bqd;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C37091y;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p006a.C36933q;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C41381u.C41380b;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004*\u0002HK\b&\u0018\u0000 t2\u00020\u0001:\u0002tuB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010N\u001a\u00020O2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\u0006\u0010Q\u001a\u000209H\u0002J\u0010\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u000209H\u0002J\b\u0010T\u001a\u00020OH\u0002J\b\u0010U\u001a\u00020OH\u0002J\b\u0010V\u001a\u00020OH\u0002J\b\u0010W\u001a\u00020OH\u0002J\b\u0010X\u001a\u00020OH\u0002J\b\u0010Y\u001a\u00020OH\u0002J\u0006\u0010Z\u001a\u00020OJ\b\u0010[\u001a\u00020OH\u0007J\b\u0010\\\u001a\u00020OH\u0007J\b\u0010]\u001a\u00020OH\u0007J\b\u0010^\u001a\u00020OH\u0002J\u0018\u0010_\u001a\u00020O2\u0006\u0010`\u001a\u00020)2\u0006\u0010a\u001a\u00020)H\u0002J\b\u0010b\u001a\u00020OH\u0007J\b\u0010c\u001a\u00020OH\u0007J\u0010\u0010d\u001a\u00020O2\u0006\u0010e\u001a\u00020fH&J\u0010\u0010g\u001a\u00020O2\u0006\u0010h\u001a\u00020)H\u0002J\b\u0010i\u001a\u00020OH\u0002J \u0010j\u001a\u00020O2\u0016\u0010P\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*H\u0002J\u0016\u0010k\u001a\u00020O2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020O0mH\u0002J\b\u0010n\u001a\u00020OH\u0002J\b\u0010o\u001a\u00020OH\u0002J\u0016\u0010p\u001a\u00020O2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020\u001f0rH\u0002J\b\u0010s\u001a\u00020OH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R-\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 `!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R!\u0010'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008FX\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b1\u00102R\u0012\u00104\u001a\u000605R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u000209X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R-\u0010<\u001a\u001e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u001f`!¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u001b\u0010>\u001a\u00020?8FX\u0002¢\u0006\f\n\u0004\bB\u0010\u0010\u001a\u0004\b@\u0010AR\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000R!\u0010E\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u0010\u0010G\u001a\u00020HX\u0004¢\u0006\u0004\n\u0002\u0010IR\u0010\u0010J\u001a\u00020KX\u0004¢\u0006\u0004\n\u0002\u0010LR\u000e\u0010M\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "Landroid/arch/lifecycle/LifecycleObserver;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "adapter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "appBrandRomLogic", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "getAppBrandRomLogic", "()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "appBrandRomLogic$delegate", "Lkotlin/Lazy;", "collectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "exposeTimeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getExposeTimeMap", "()Ljava/util/HashMap;", "headerViewText", "getHeaderViewText", "()Ljava/lang/String;", "insertList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsertList", "()Ljava/util/ArrayList;", "layoutMgr", "Landroid/support/v7/widget/LinearLayoutManager;", "listFooterController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "getListFooterController", "()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "listFooterController$delegate", "loadStateObj", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "mListHeaderController", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListHeaderControllerForRecommend;", "needHeader", "", "getNeedHeader", "()Z", "pos2exposeTimeMap", "getPos2exposeTimeMap", "recommendCardList", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getRecommendCardList", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "recommendCardList$delegate", "recommendReport", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendReport;", "removeList", "getRemoveList", "scrollListener", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1;", "showMenuCallback", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1;", "wxaAttrsStorageListener", "calExposeTime", "", "list", "clear", "fetchPageData", "loadFromMemory", "handleHeaderClick", "initData", "initFooter", "initHeader", "initHeaderTagView", "initStateObj", "initView", "onCreate", "onDestroy", "onDestroyView", "onFetchPageFail", "onFetchPageSuccess", "remainCount", "result", "onPause", "onResume", "postOnUiThread", "runnable", "Ljava/lang/Runnable;", "refreshData", "strategy", "removeStorageListeners", "resetExposeTime", "runOnWorkThread", "action", "Lkotlin/Function0;", "setAdapterClickListener", "setupStorageListeners", "syncAttr", "userNameList", "", "updateListData", "Companion", "LoadStateObj", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g */
public abstract class C38556g implements LifecycleObserver {
    private static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(C38556g.class), "recommendCardList", "getRecommendCardList()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C38556g.class), "appBrandRomLogic", "getAppBrandRomLogic()Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;")), C44855v.m82052a(new C25054t(C44855v.m82055aN(C38556g.class), "listFooterController", "getListFooterController()Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;"))};
    public static final C19804a iQy = new C19804a();
    final Activity activity;
    final Context context;
    private final C44856f iQh;
    private final C44856f iQi;
    private final C5004al iQj;
    final C38544a iQk;
    final C27348b iQl;
    final LinearLayoutManager iQm;
    final C36732g iQn;
    final C27347f iQo;
    private final C44856f iQp;
    private final C4931a iQq;
    private final C4931a iQr;
    final ArrayList<Integer> iQs;
    final ArrayList<Integer> iQt;
    final HashMap<String, Long> iQu;
    final HashMap<Integer, String> iQv;
    final C38554l iQw;
    private final C10923p iQx;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$r */
    static final class C6788r implements C4931a {
        final /* synthetic */ C38556g iQA;

        C6788r(C38556g c38556g) {
            this.iQA = c38556g;
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(135201);
            C38562h.m65317a(this.iQA, (C31214a) new C10924q(this.iQA));
            AppMethodBeat.m2505o(135201);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$showMenuCallback$1", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendShowMenu$IShowMenuCallback;", "onMenuCallback", "", "strategy", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$p */
    public static final class C10923p {
        final /* synthetic */ C38556g iQA;

        C10923p(C38556g c38556g) {
            this.iQA = c38556g;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$q */
    static final class C10924q extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C38556g iQA;

        C10924q(C38556g c38556g) {
            this.iQA = c38556g;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135200);
            this.iQA.iQk.notifyDataSetChanged();
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135200);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$a */
    public static final class C19804a {
        private C19804a() {
        }

        public /* synthetic */ C19804a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$g */
    static final class C19805g implements OnLongClickListener {
        public static final C19805g iQI = new C19805g();

        static {
            AppMethodBeat.m2504i(135189);
            AppMethodBeat.m2505o(135189);
        }

        C19805g() {
        }

        public final boolean onLongClick(View view) {
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032&\u0010\u0005\u001a\"\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00070\u0007 \u0004*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u00010\u0006¨\u0006\u0001H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$h */
    static final class C19806h implements C11052a {
        final /* synthetic */ C38556g iQA;

        C19806h(C38556g c38556g) {
            this.iQA = c38556g;
        }

        public final void aMC() {
            AppMethodBeat.m2504i(135190);
            if (this.iQA.iQl.aNO()) {
                C4990ab.m7410d(C38556g.TAG, "can load more: let's do fetch");
                this.iQA.mo61280eL(false);
            }
            AppMethodBeat.m2505o(135190);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$i */
    static final class C19807i extends C25053k implements C31214a<C33563e> {
        final /* synthetic */ C38556g iQA;

        C19807i(C38556g c38556g) {
            this.iQA = c38556g;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135191);
            C33563e c33563e = new C33563e(this.iQA.context, this.iQA.aNL());
            AppMethodBeat.m2505o(135191);
            return c33563e;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$LoadStateObj;", "", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)V", "canLoadMore", "", "getCanLoadMore", "()Z", "setCanLoadMore", "(Z)V", "isLoading", "setLoading", "page", "", "getPage", "()I", "setPage", "(I)V", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$b */
    public final class C27348b {
        volatile int fQk;
        volatile boolean iQz;
        volatile boolean isLoading;

        public final boolean aNO() {
            return this.iQz && !this.isLoading;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$k */
    static final class C27349k implements Runnable {
        final /* synthetic */ C31214a hbA;

        C27349k(C31214a c31214a) {
            this.hbA = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(135193);
            this.hbA.invoke();
            AppMethodBeat.m2505o(135193);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/RecommendRecycleView;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$j */
    static final class C31564j extends C25053k implements C31214a<RecommendRecycleView> {
        final /* synthetic */ C38556g iQA;

        C31564j(C38556g c38556g) {
            this.iQA = c38556g;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135192);
            RecommendRecycleView recommendRecycleView = new RecommendRecycleView(this.iQA.activity);
            AppMethodBeat.m2505o(135192);
            return recommendRecycleView;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$e */
    static final class C38553e extends C25053k implements C31214a<C37091y> {
        final /* synthetic */ C38556g iQA;
        final /* synthetic */ boolean iQC;

        C38553e(C38556g c38556g, boolean z) {
            this.iQA = c38556g;
            this.iQC = z;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            C37091y c37091y;
            AppMethodBeat.m2504i(135186);
            synchronized (this.iQA.iQl) {
                try {
                    this.iQA.iQl.isLoading = true;
                    c37091y = C37091y.AUy;
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(135186);
                }
            }
            if (this.iQC) {
                C4990ab.m7417i(C38556g.TAG, "fetching page from memory, pageNum:%d, ", Integer.valueOf(this.iQA.iQl.fQk));
                C10113e.m17715d(new C10111f(this.iQA.aNM()));
            } else {
                C4990ab.m7417i(C38556g.TAG, "fetching page, pageNum:%d, ", Integer.valueOf(this.iQA.iQl.fQk));
                C10113e.m17715d(new C10110e(this.iQA.aNM(), this.iQA.iQl.fQk));
            }
            c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135186);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\"\u0010\u0016\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "currentVisibleList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getCurrentVisibleList", "()Ljava/util/ArrayList;", "lastVisibleList", "getLastVisibleList", "mListFlinging", "", "getMListFlinging", "()Z", "setMListFlinging", "(Z)V", "calExpose", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$l */
    public static final class C38554l extends C41530m {
        private boolean iMJ;
        final /* synthetic */ C38556g iQA;
        private final ArrayList<Integer> iQJ = new ArrayList();
        private final ArrayList<Integer> iQK = new ArrayList();

        C38554l(C38556g c38556g) {
            this.iQA = c38556g;
            AppMethodBeat.m2504i(135196);
            AppMethodBeat.m2505o(135196);
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(135194);
            super.mo6642a(recyclerView, i, i2);
            C17480i layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            if (layoutManager instanceof LinearLayoutManager) {
                int iQ = ((LinearLayoutManager) layoutManager).mo1780iQ();
                int iS = ((LinearLayoutManager) layoutManager).mo1782iS();
                if (iQ == 0 && iS == 1) {
                    C45707i.m84462b(this.iQA.context, this.iQA.iQn.aNi());
                    AppMethodBeat.m2505o(135194);
                    return;
                }
                this.iQK.clear();
                if (iQ <= iS) {
                    int i3 = iQ;
                    while (true) {
                        if (i3 == 0) {
                            C45707i.m84462b(this.iQA.context, this.iQA.iQn.aNi());
                        } else {
                            C41531v cf = this.iQA.aNL().mo66357cf(i3);
                            if (cf != null && (cf instanceof C10921c)) {
                                this.iQK.add(Integer.valueOf(i3));
                                if (!this.iQJ.contains(Integer.valueOf(i3))) {
                                    int S = this.iQA.aNL().mo61462S(cf);
                                    C4990ab.m7411d(C38556g.TAG, "reportExposeData index:%d, holderPosition:%d", Integer.valueOf(i3), Integer.valueOf(S));
                                    if (S < this.iQA.iQk.getItemCount()) {
                                        Object obj = this.iQA.iQk.aND().get(S);
                                        C25052j.m39375o(obj, "wxaList[position]");
                                        bqd bqd = (bqd) obj;
                                        this.iQA.iQo.mo45029d(S, bqd);
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
                this.iQA.m65305c(this.iQA.iQt, true);
            }
            AppMethodBeat.m2505o(135194);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(135195);
            super.mo6643c(recyclerView, i);
            this.iMJ = i == 2;
            if (this.iMJ) {
                this.iQA.iQo.mo45030eK(this.iMJ);
            }
            C17480i layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).mo1780iQ();
                int iS = ((LinearLayoutManager) layoutManager).mo1782iS();
                if (iS >= 3) {
                    iS--;
                }
                this.iQA.aNM().cPK = iS;
            }
            AppMethodBeat.m2505o(135195);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$n */
    static final class C38555n extends C25053k implements C31591m<bqd, Integer, C37091y> {
        final /* synthetic */ C38556g iQA;

        C38555n(C38556g c38556g) {
            this.iQA = c38556g;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(135198);
            bqd bqd = (bqd) obj;
            int intValue = ((Number) obj2).intValue();
            C25052j.m39376p(bqd, "recommendCard");
            this.iQA.iQo.mo45024a(intValue, bqd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135198);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appusage/recommend/AppBrandRecommendLogic;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$c */
    static final class C38557c extends C25053k implements C31214a<C19095d> {
        public static final C38557c iQB = new C38557c();

        static {
            AppMethodBeat.m2504i(135184);
            AppMethodBeat.m2505o(135184);
        }

        C38557c() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135183);
            C19095d aya = C19095d.hbu.aya();
            AppMethodBeat.m2505o(135183);
            return aya;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$d */
    static final class C38558d implements C4931a {
        final /* synthetic */ C38556g iQA;

        C38558d(C38556g c38556g) {
            this.iQA = c38556g;
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(135185);
            C38562h.m65317a(this.iQA, (C31214a) new C10924q(this.iQA));
            AppMethodBeat.m2505o(135185);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$m */
    static final class C38559m extends C25053k implements C31591m<bqd, Integer, C37091y> {
        final /* synthetic */ C38556g iQA;

        C38559m(C38556g c38556g) {
            this.iQA = c38556g;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(135197);
            bqd bqd = (bqd) obj;
            int intValue = ((Number) obj2).intValue();
            C25052j.m39376p(bqd, "recommendCard");
            if (intValue == 0) {
                C45707i.m84462b(this.iQA.context, this.iQA.iQn.aNi());
            }
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135197);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "result", "", "fetchedDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "remainCount", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$f */
    static final class C38560f extends C25053k implements C36933q<Integer, LinkedList<bqd>, Integer, C37091y> {
        final /* synthetic */ C38556g iQA;

        C38560f(C38556g c38556g) {
            this.iQA = c38556g;
            super(3);
        }

        /* renamed from: g */
        public final /* synthetic */ Object mo9028g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.m2504i(135188);
            final int intValue = ((Number) obj).intValue();
            final LinkedList linkedList = (LinkedList) obj2;
            final int intValue2 = ((Number) obj3).intValue();
            C25052j.m39376p(linkedList, "fetchedDataList");
            C4990ab.m7417i(C38556g.TAG, "onFetchFinish, remainCount:%d, size:%d, result code:%d", Integer.valueOf(intValue2), Integer.valueOf(linkedList.size()), Integer.valueOf(intValue));
            if (intValue == 0 || intValue == 3) {
                ArrayList arrayList = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((bqd) it.next()).wSq);
                }
                C38556g.m65302a(this.iQA, (List) arrayList);
            }
            final C41380b c41380b = new C41380b();
            c41380b.AVD = this.iQA.iQl.fQk;
            synchronized (this.iQA.iQl) {
                try {
                    this.iQA.iQl.fQk = this.iQA.aNM().hbm;
                    C37091y c37091y = C37091y.AUy;
                } finally {
                    AppMethodBeat.m2505o(135188);
                }
            }
            C38562h.m65317a(this.iQA, (C31214a) new C31214a<C37091y>(this) {
                final /* synthetic */ C38560f iQD;

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.m2504i(135187);
                    C45707i.m84462b(this.iQD.iQA.context, this.iQD.iQA.iQn.aNi());
                    if (linkedList == null || !(intValue == 0 || intValue == 2 || intValue == 3)) {
                        C4990ab.m7416i(C38556g.TAG, "onFetchFinish fail");
                        C38556g.m65308e(this.iQD.iQA);
                    } else {
                        C4990ab.m7417i(C38556g.TAG, "onFetchFinish success and data size = %d, page num:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(this.iQD.iQA.iQl.fQk));
                        C38544a c38544a;
                        LinkedList linkedList;
                        if ((intValue == 0 && (this.iQD.iQA.iQl.fQk == 0 || (c41380b.AVD == 0 && this.iQD.iQA.iQl.fQk == 1))) || intValue == 2 || intValue == 3) {
                            c38544a = this.iQD.iQA.iQk;
                            linkedList = linkedList;
                            C25052j.m39376p(linkedList, "data");
                            c38544a.aND().clear();
                            c38544a.aND().addAll(linkedList);
                        } else {
                            c38544a = this.iQD.iQA.iQk;
                            linkedList = linkedList;
                            C25052j.m39376p(linkedList, "data");
                            c38544a.aND().addAll(linkedList);
                        }
                        if (intValue == 3) {
                            C4990ab.m7417i(C38556g.TAG, "scrollToPosition %d", Integer.valueOf(this.iQD.iQA.aNM().cPK));
                            this.iQD.iQA.aNL().mo61465bY(this.iQD.iQA.aNM().cPK);
                        }
                        this.iQD.iQA.iQk.notifyDataSetChanged();
                        C38556g.m65300a(this.iQD.iQA, intValue2);
                    }
                    C37091y c37091y = C37091y.AUy;
                    AppMethodBeat.m2505o(135187);
                    return c37091y;
                }
            });
            Object obj4 = C37091y.AUy;
            return obj4;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "recommendCard", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "i", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.g$o */
    static final class C38561o extends C25053k implements C31591m<bqd, Integer, C37091y> {
        final /* synthetic */ C38556g iQA;

        C38561o(C38556g c38556g) {
            this.iQA = c38556g;
            super(2);
        }

        /* renamed from: m */
        public final /* synthetic */ Object mo212m(Object obj, Object obj2) {
            AppMethodBeat.m2504i(135199);
            bqd bqd = (bqd) obj;
            int intValue = ((Number) obj2).intValue();
            C25052j.m39376p(bqd, "recommendCard");
            this.iQA.iQo.mo45028b(intValue, bqd);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(135199);
            return c37091y;
        }
    }

    public abstract String aNB();

    public abstract boolean aNC();

    public final LoadMoreRecyclerView aNL() {
        return (LoadMoreRecyclerView) this.iQh.getValue();
    }

    /* Access modifiers changed, original: final */
    public final C19095d aNM() {
        return (C19095d) this.iQi.getValue();
    }

    public final C33563e aNN() {
        return (C33563e) this.iQp.getValue();
    }

    public abstract View getContentView();

    public C38556g(Activity activity) {
        C25052j.m39376p(activity, "activity");
        this.activity = activity;
        Activity activity2 = this.activity;
        if (activity2 == null) {
            throw new C44941v("null cannot be cast to non-null type android.content.Context");
        }
        this.context = activity2;
        this.iQh = C17344i.m26854g(new C31564j(this));
        this.iQi = C17344i.m26854g(C38557c.iQB);
        this.iQj = new C5004al("AppBrandLauncherUI#AppBrandLauncherRecommendsList");
        this.iQk = new C38544a(this.activity);
        this.iQl = new C27348b();
        this.iQm = new C38564j(this.context);
        this.iQn = new C36732g(this.activity, aNL());
        this.iQo = new C27347f();
        this.iQp = C17344i.m26854g(new C19807i(this));
        this.iQq = new C38558d(this);
        this.iQr = new C6788r(this);
        this.iQs = new ArrayList();
        this.iQt = new ArrayList();
        this.iQu = new HashMap();
        this.iQv = new HashMap();
        this.iQw = new C38554l(this);
        this.iQx = new C10923p(this);
    }

    /* renamed from: c */
    private final void m65305c(ArrayList<Integer> arrayList, boolean z) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if ((num == null || num.intValue() != 0) && this.iQv.containsKey(num)) {
                String str = (String) this.iQv.get(num);
                Long l = (Long) this.iQu.get(str);
                if (!(str == null || l == null)) {
                    C4990ab.m7411d(TAG, "exposure index: %d, exposureTime:%d", num, Long.valueOf(System.currentTimeMillis() - l.longValue()));
                    this.iQo.mo45032y(str, r4);
                }
            }
        }
        if (z) {
            arrayList.clear();
        }
    }

    @OnLifecycleEvent(Event.ON_CREATE)
    public final void onCreate() {
        C4990ab.m7416i(TAG, "onCreate");
    }

    @OnLifecycleEvent(Event.ON_RESUME)
    public final void onResume() {
        C4990ab.m7416i(TAG, "onResume");
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
        C4990ab.m7416i(TAG, "onPause");
        m65305c(this.iQs, false);
        this.iQo.aNJ();
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public final void onDestroy() {
        boolean z;
        C4990ab.m7416i(TAG, "onDestroy");
        ((C26779s) C42340f.m74878E(C26779s.class)).mo10117d(this.iQq);
        C42340f.auO().mo10117d(this.iQr);
        this.iQs.clear();
        this.iQt.clear();
        this.iQu.clear();
        this.iQv.clear();
        this.iQo.mo45031gu(aNM().hbj);
        C19095d aNM = aNM();
        if (aNM().axY().isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        aNM.hbn = z;
        aNM().hbo = 0;
        C19095d aNM2 = aNM();
        aNM2.hbh.mo44535a(null);
        aNM2.hbs = null;
    }

    @OnLifecycleEvent(Event.ON_DESTROY)
    public final void onDestroyView() {
        this.iQj.quit();
        this.iQn.onDetached();
        aNN().onDetached();
        aNL().mo66348b((C41530m) this.iQw);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: eL */
    public final void mo61280eL(boolean z) {
        C38562h.m65318a(this, true);
        C38562h.m65319b(this, true);
        m65307d((C31214a) new C38553e(this, z));
    }

    /* renamed from: d */
    private final void m65307d(C31214a<C37091y> c31214a) {
        this.iQj.mo10303ae(new C27349k(c31214a));
    }

    /* renamed from: e */
    public static final /* synthetic */ void m65308e(C38556g c38556g) {
        C4990ab.m7416i(TAG, "onFetchPageFail");
        C38562h.m65319b(c38556g, false);
        C38562h.m65318a(c38556g, true);
        C38562h.m65320h(c38556g);
        synchronized (c38556g.iQl) {
            c38556g.iQl.isLoading = false;
            C37091y c37091y = C37091y.AUy;
        }
    }
}
