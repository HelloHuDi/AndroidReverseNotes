package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.t;
import a.f.b.v;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ab;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\"\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\t2\u0010\b\u0002\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/H\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u00065"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "()V", "mCollectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "mDataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "mHadEnterWxa", "", "mList", "Landroid/support/v7/widget/RecyclerView;", "mListAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "mRefreshOnResume", "mWxaAttrsStorageListener", "sceneFor13801", "", "getSceneFor13801", "()I", "sceneFor13801$delegate", "Lkotlin/Lazy;", "sceneIdFor13801", "", "getSceneIdFor13801", "()Ljava/lang/String;", "sceneIdFor13801$delegate", "getLayoutId", "hideLoading", "", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEnter", "onResume", "onTitleDoubleTap", "onViewCreated", "view", "Landroid/view/View;", "queryDataList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "refreshDataList", "replace", "lazyCallback", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "removeStorageListeners", "setupStorageListeners", "showLoading", "updateDataListUsingDiffs", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionDisplayVerticalList extends Fragment implements com.tencent.mm.plugin.appbrand.ui.collection.m.a {
    static final /* synthetic */ a.i.k[] eQB = new a.i.k[]{v.a(new t(v.aN(AppBrandCollectionDisplayVerticalList.class), "sceneFor13801", "getSceneFor13801()I")), v.a(new t(v.aN(AppBrandCollectionDisplayVerticalList.class), "sceneIdFor13801", "getSceneIdFor13801()Ljava/lang/String;"))};
    private RecyclerView iKX;
    private k iKY;
    private boolean iKZ;
    private al iLa;
    private boolean iLb;
    private final a.f iLc = a.i.g(new h(this));
    private final a.f iLd = a.i.g(new i(this));
    private final com.tencent.mm.sdk.e.k.a iLe = new b(this);
    private final com.tencent.mm.sdk.e.k.a iLf = new c(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$updateDataListUsingDiffs$2$1"})
    static final class j implements Runnable {
        final /* synthetic */ List gYO;
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;
        final /* synthetic */ android.support.v7.h.c.b iLn;

        j(android.support.v7.h.c.b bVar, AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList, List list) {
            this.iLn = bVar;
            this.iLg = appBrandCollectionDisplayVerticalList;
            this.gYO = list;
        }

        public final void run() {
            AppMethodBeat.i(135018);
            k b = this.iLg.iKY;
            if (b != null) {
                b.aO(this.gYO);
                this.iLn.a((android.support.v7.widget.RecyclerView.a) b);
                AppMethodBeat.o(135018);
                return;
            }
            AppMethodBeat.o(135018);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class b implements com.tencent.mm.sdk.e.k.a {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        b(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        public final void a(String str, m mVar) {
            AppMethodBeat.i(135008);
            Object obj = (a.f.b.j.j("batch", str) && 3 == mVar.hsh && (mVar.obj instanceof Long)) ? 1 : null;
            if (obj != null) {
                AppBrandCollectionDisplayVerticalList.a(this.iLg);
                AppMethodBeat.o(135008);
                return;
            }
            AppBrandCollectionDisplayVerticalList.g(this.iLg);
            AppMethodBeat.o(135008);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class c implements com.tencent.mm.sdk.e.k.a {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        c(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        public final void a(String str, m mVar) {
            AppMethodBeat.i(135009);
            AppBrandCollectionDisplayVerticalList.g(this.iLg);
            AppMethodBeat.o(135009);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class d implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        d(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(135010);
            if (this.iLg.getActivity() == null) {
                AppMethodBeat.o(135010);
            } else {
                int i;
                com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI.a aVar = AppBrandCollectionSortUI.iLo;
                FragmentActivity activity = this.iLg.getActivity();
                if (activity == null) {
                    a.f.b.j.dWJ();
                }
                a.f.b.j.o(activity, "activity!!");
                Context context = activity;
                k b = this.iLg.iKY;
                if (b == null) {
                    a.f.b.j.dWJ();
                }
                ArrayList arrayList = b.iLD;
                int c = AppBrandCollectionDisplayVerticalList.c(this.iLg);
                String d = AppBrandCollectionDisplayVerticalList.d(this.iLg);
                a.f.b.j.p(context, "context");
                a.f.b.j.p(arrayList, "dataList");
                a.f.b.j.p(d, "operateReportSceneId");
                Intent intent = new Intent(context, AppBrandCollectionSortUI.class);
                intent.putExtra("KEY_SORT_DATA_LIST", arrayList);
                intent.putExtra("KEY_OPERATE_REPORT_SCENE", c);
                intent.putExtra("KEY_OPERATE_REPORT_SCENE_ID", d);
                if (context instanceof Activity) {
                    i = 0;
                } else {
                    i = 268435456;
                }
                intent.addFlags(i);
                context.startActivity(intent);
                if (!(context instanceof Activity)) {
                    context = null;
                }
                Activity activity2 = (Activity) context;
                if (activity2 != null) {
                    activity2.overridePendingTransition(R.anim.n, R.anim.s);
                }
                this.iLg.iKZ = true;
                AppMethodBeat.o(135010);
            }
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
    static final class e extends a.f.b.k implements a.f.a.a<Runnable> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$e$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ e iLh;

            AnonymousClass1(e eVar) {
                this.iLh = eVar;
            }

            public final void run() {
                AppMethodBeat.i(135011);
                AppBrandCollectionDisplayVerticalList.aMX();
                if (this.iLh.iLg.isAdded()) {
                    AppBrandCollectionDisplayVerticalList.f(this.iLh.iLg);
                }
                HashSet hashSet = new HashSet();
                k b = this.iLh.iLg.iKY;
                if (b == null) {
                    a.f.b.j.dWJ();
                }
                for (LocalUsageInfo localUsageInfo : b.iLD) {
                    hashSet.add(localUsageInfo.username);
                }
                r.a(a.a.t.m(hashSet), com.tencent.mm.plugin.appbrand.config.j.a.hhn);
                AppMethodBeat.o(135011);
            }
        }

        e(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135012);
            Runnable anonymousClass1 = new AnonymousClass1(this);
            AppMethodBeat.o(135012);
            return anonymousClass1;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class k implements Runnable {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        k(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        public final void run() {
            AppMethodBeat.i(135019);
            FragmentActivity activity = this.iLg.getActivity();
            if (!(activity instanceof com.tencent.mm.plugin.appbrand.ui.a.b)) {
                activity = null;
            }
            com.tencent.mm.plugin.appbrand.ui.a.b bVar = (com.tencent.mm.plugin.appbrand.ui.a.b) activity;
            if (bVar != null) {
                bVar.eE(false);
                AppMethodBeat.o(135019);
                return;
            }
            AppMethodBeat.o(135019);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class f extends a.f.b.k implements a.f.a.a {
        public static final f iLi = new f();

        static {
            AppMethodBeat.i(135013);
            AppMethodBeat.o(135013);
        }

        f() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return null;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class h extends a.f.b.k implements a.f.a.a<Integer> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        h(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Integer valueOf;
            int i = 8;
            AppMethodBeat.i(135016);
            FragmentActivity activity = this.iLg.getActivity();
            if (activity != null) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    int intExtra = intent.getIntExtra("extra_get_usage_reason", 8);
                    int intExtra2 = intent.getIntExtra("extra_get_usage_prescene", 0);
                    switch (intExtra) {
                        case 7:
                            break;
                        case 8:
                            if (intExtra2 != 2) {
                                i = 3;
                                break;
                            }
                            i = 6;
                            break;
                        default:
                            i = 3;
                            break;
                    }
                    valueOf = Integer.valueOf(i);
                    AppMethodBeat.o(135016);
                    return valueOf;
                }
            }
            i = 3;
            valueOf = Integer.valueOf(i);
            AppMethodBeat.o(135016);
            return valueOf;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$initView$1$1", "Landroid/support/v7/widget/LinearLayoutManager;", "supportsPredictiveItemAnimations", "", "plugin-appbrand-integration_release"})
    public static final class a extends LinearLayoutManager {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        a(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(1);
        }

        public final boolean iE() {
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class i extends a.f.b.k implements a.f.a.a<String> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        i(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(0);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object invoke() {
            Object aLd;
            AppMethodBeat.i(135017);
            switch (AppBrandCollectionDisplayVerticalList.c(this.iLg)) {
                case 6:
                case 7:
                case 8:
                    aLd = com.tencent.mm.plugin.appbrand.report.e.aLd();
                    if (aLd == null) {
                        a.f.b.j.dWJ();
                        AppMethodBeat.o(135017);
                        break;
                    }
                default:
                    aLd = com.tencent.mm.plugin.appbrand.report.e.aLc();
            }
            AppMethodBeat.o(135017);
            return aLd;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class g implements Runnable {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;
        final /* synthetic */ boolean iLj;
        final /* synthetic */ a.f.a.a iLk;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$refreshDataList$workerRunner$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ List iLl;
            final /* synthetic */ g iLm;

            a(List list, g gVar) {
                this.iLl = list;
                this.iLm = gVar;
            }

            public final void run() {
                AppMethodBeat.i(135014);
                if (this.iLl.isEmpty()) {
                    FragmentActivity activity = this.iLm.iLg.getActivity();
                    if (!(activity instanceof com.tencent.mm.plugin.appbrand.ui.a.b)) {
                        activity = null;
                    }
                    com.tencent.mm.plugin.appbrand.ui.a.b bVar = (com.tencent.mm.plugin.appbrand.ui.a.b) activity;
                    if (bVar != null) {
                        bVar.eE(false);
                    }
                } else {
                    k b = this.iLm.iLg.iKY;
                    if (b == null) {
                        a.f.b.j.dWJ();
                    }
                    b.aO(this.iLl);
                    if (this.iLm.iLj) {
                        b = this.iLm.iLg.iKY;
                        if (b == null) {
                            a.f.b.j.dWJ();
                        }
                        b.ar(0, this.iLl.size());
                    } else {
                        b = this.iLm.iLg.iKY;
                        if (b == null) {
                            a.f.b.j.dWJ();
                        }
                        b.at(0, this.iLl.size());
                    }
                }
                Runnable runnable = (Runnable) this.iLm.iLk.invoke();
                if (runnable != null) {
                    runnable.run();
                    AppMethodBeat.o(135014);
                    return;
                }
                AppMethodBeat.o(135014);
            }
        }

        g(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList, boolean z, a.f.a.a aVar) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            this.iLj = z;
            this.iLk = aVar;
        }

        public final void run() {
            AppMethodBeat.i(135015);
            this.iLg.runOnUiThread(new a(AppBrandCollectionDisplayVerticalList.aMW(), this));
            AppMethodBeat.o(135015);
        }
    }

    static {
        AppMethodBeat.i(135020);
        AppMethodBeat.o(135020);
    }

    public AppBrandCollectionDisplayVerticalList() {
        AppMethodBeat.i(135030);
        AppMethodBeat.o(135030);
    }

    public static final /* synthetic */ List aMW() {
        AppMethodBeat.i(135031);
        List aMU = aMU();
        AppMethodBeat.o(135031);
        return aMU;
    }

    public static final /* synthetic */ void aMX() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static List<LocalUsageInfo> aMU() {
        AppMethodBeat.i(135021);
        List a = ((af) com.tencent.mm.kernel.g.K(af.class)).a(BaseClientBuilder.API_PRIORITY_OTHER, com.tencent.mm.plugin.appbrand.appusage.af.a.DESC);
        if (a == null) {
            a = a.a.v.AUP;
        }
        Collection arrayList = new ArrayList();
        for (Object next : a) {
            if ((((LocalUsageInfo) next) != null ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        AppMethodBeat.o(135021);
        return list;
    }

    static /* synthetic */ void a(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(135023);
        appBrandCollectionDisplayVerticalList.a(true, f.iLi);
        AppMethodBeat.o(135023);
    }

    private final void a(boolean z, a.f.a.a<? extends Runnable> aVar) {
        AppMethodBeat.i(135022);
        Runnable gVar = new g(this, z, aVar);
        al alVar = this.iLa;
        if (alVar == null) {
            a.f.b.j.dWJ();
        }
        if (alVar.doO()) {
            gVar.run();
            AppMethodBeat.o(135022);
            return;
        }
        alVar = this.iLa;
        if (alVar == null) {
            a.f.b.j.dWJ();
        }
        alVar.aa(gVar);
        AppMethodBeat.o(135022);
    }

    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.i(135024);
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.a(0, getString(R.string.o9), (OnMenuItemClickListener) new d(this), com.tencent.mm.ui.q.b.BLACK);
            AppMethodBeat.o(135024);
            return;
        }
        AppMethodBeat.o(135024);
    }

    public final void onResume() {
        AppMethodBeat.i(135025);
        super.onResume();
        if (this.iKZ) {
            a(this);
            this.iKZ = false;
        }
        if (this.iLb) {
            com.tencent.mm.plugin.appbrand.report.c.pG(2);
            this.iLb = false;
        }
        AppMethodBeat.o(135025);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(135026);
        a.f.b.j.p(view, "view");
        super.onViewCreated(view, bundle);
        this.iLa = new al("AppBrandLauncherCollectionList");
        a(false, new e(this));
        AppMethodBeat.o(135026);
    }

    public final void initView() {
        AppMethodBeat.i(135027);
        RecyclerView recyclerView = new RecyclerView(getActivity());
        getActivity();
        recyclerView.setLayoutManager(new a(this));
        k kVar = new k(new ArrayList(), this);
        this.iKY = kVar;
        recyclerView.setAdapter(kVar);
        recyclerView.setBackgroundColor(-1);
        recyclerView.b((android.support.v7.widget.RecyclerView.h) new l());
        recyclerView.setItemAnimator(null);
        this.iKX = recyclerView;
        View contentView = getContentView();
        if (contentView == null) {
            a.v vVar = new a.v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(135027);
            throw vVar;
        }
        FrameLayout frameLayout = (FrameLayout) contentView;
        RecyclerView recyclerView2 = this.iKX;
        if (recyclerView2 == null) {
            a.f.b.j.dWJ();
        }
        frameLayout.addView(recyclerView2, new LayoutParams(-1, -2));
        AppMethodBeat.o(135027);
    }

    public final void aMf() {
        AppMethodBeat.i(135028);
        RecyclerView recyclerView = this.iKX;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
            AppMethodBeat.o(135028);
            return;
        }
        AppMethodBeat.o(135028);
    }

    public final void onDestroyView() {
        AppMethodBeat.i(135029);
        super.onDestroyView();
        ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).d(this.iLe);
        com.tencent.mm.plugin.appbrand.app.f.auO().d(this.iLf);
        al alVar = this.iLa;
        if (alVar != null) {
            alVar.quit();
            AppMethodBeat.o(135029);
            return;
        }
        AppMethodBeat.o(135029);
    }

    public final void aMV() {
        this.iLb = true;
    }

    public static final /* synthetic */ int c(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(135032);
        int intValue = ((Number) appBrandCollectionDisplayVerticalList.iLc.getValue()).intValue();
        AppMethodBeat.o(135032);
        return intValue;
    }

    public static final /* synthetic */ String d(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(135033);
        String str = (String) appBrandCollectionDisplayVerticalList.iLd.getValue();
        AppMethodBeat.o(135033);
        return str;
    }

    public static final /* synthetic */ void f(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(135034);
        s sVar = (s) com.tencent.mm.plugin.appbrand.app.f.E(s.class);
        com.tencent.mm.sdk.e.k.a aVar = appBrandCollectionDisplayVerticalList.iLe;
        al alVar = appBrandCollectionDisplayVerticalList.iLa;
        if (alVar == null) {
            a.f.b.j.dWJ();
        }
        sVar.a(aVar, alVar.getLooper());
        q auO = com.tencent.mm.plugin.appbrand.app.f.auO();
        aVar = appBrandCollectionDisplayVerticalList.iLf;
        alVar = appBrandCollectionDisplayVerticalList.iLa;
        if (alVar == null) {
            a.f.b.j.dWJ();
        }
        auO.a(aVar, alVar.getLooper());
        AppMethodBeat.o(135034);
    }

    public static final /* synthetic */ void g(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.i(135035);
        if (appBrandCollectionDisplayVerticalList.iKY != null) {
            k kVar = appBrandCollectionDisplayVerticalList.iKY;
            if (kVar == null) {
                a.f.b.j.dWJ();
            }
            ArrayList aNd = kVar.aNd();
            List aMU = aMU();
            if (aMU.isEmpty()) {
                appBrandCollectionDisplayVerticalList.runOnUiThread(new k(appBrandCollectionDisplayVerticalList));
                AppMethodBeat.o(135035);
                return;
            }
            try {
                appBrandCollectionDisplayVerticalList.runOnUiThread(new j(android.support.v7.h.c.a(new ab(aNd, aMU), true), appBrandCollectionDisplayVerticalList, aMU));
                AppMethodBeat.o(135035);
                return;
            } catch (NullPointerException e) {
                com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.AppBrandCollectionDisplayVerticalList", e, "calculateDiff, oldList.size=" + aNd.size() + ", newList.size=" + aMU.size(), new Object[0]);
                if (bp.dpL()) {
                    Throwable th = e;
                    AppMethodBeat.o(135035);
                    throw th;
                }
            }
        }
        AppMethodBeat.o(135035);
    }
}
