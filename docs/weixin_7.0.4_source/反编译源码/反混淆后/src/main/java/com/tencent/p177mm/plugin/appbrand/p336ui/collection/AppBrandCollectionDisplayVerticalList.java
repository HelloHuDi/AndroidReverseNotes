package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.support.p069v7.p075h.C0595c;
import android.support.p069v7.p075h.C0595c.C0601b;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.appusage.C33107ab;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.config.C26844q;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI.Fragment;
import com.tencent.p177mm.plugin.appbrand.p336ui.collection.AppBrandCollectionSortUI.C27325a;
import com.tencent.p177mm.plugin.appbrand.p336ui.collection.C33552m.C33553a;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C19766b;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C19692e;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J\b\u0010%\u001a\u00020\u001dH\u0016J\u001a\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\"\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\t2\u0010\b\u0002\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/H\u0002J\b\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u001dH\u0002J\b\u00104\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u00065"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "()V", "mCollectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "mDataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "mHadEnterWxa", "", "mList", "Landroid/support/v7/widget/RecyclerView;", "mListAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "mRefreshOnResume", "mWxaAttrsStorageListener", "sceneFor13801", "", "getSceneFor13801", "()I", "sceneFor13801$delegate", "Lkotlin/Lazy;", "sceneIdFor13801", "", "getSceneIdFor13801", "()Ljava/lang/String;", "sceneIdFor13801$delegate", "getLayoutId", "hideLoading", "", "initView", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onEnter", "onResume", "onTitleDoubleTap", "onViewCreated", "view", "Landroid/view/View;", "queryDataList", "", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "refreshDataList", "replace", "lazyCallback", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "removeStorageListeners", "setupStorageListeners", "showLoading", "updateDataListUsingDiffs", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList */
public final class AppBrandCollectionDisplayVerticalList extends Fragment implements C33553a {
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(AppBrandCollectionDisplayVerticalList.class), "sceneFor13801", "getSceneFor13801()I")), C44855v.m82052a(new C25054t(C44855v.m82055aN(AppBrandCollectionDisplayVerticalList.class), "sceneIdFor13801", "getSceneIdFor13801()Ljava/lang/String;"))};
    private RecyclerView iKX;
    private C38531k iKY;
    private boolean iKZ;
    private C5004al iLa;
    private boolean iLb;
    private final C44856f iLc = C17344i.m26854g(new C10860h(this));
    private final C44856f iLd = C17344i.m26854g(new C10862i(this));
    private final C4931a iLe = new C10853b(this);
    private final C4931a iLf = new C10854c(this);

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$updateDataListUsingDiffs$2$1"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$j */
    static final class C10852j implements Runnable {
        final /* synthetic */ List gYO;
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;
        final /* synthetic */ C0601b iLn;

        C10852j(C0601b c0601b, AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList, List list) {
            this.iLn = c0601b;
            this.iLg = appBrandCollectionDisplayVerticalList;
            this.gYO = list;
        }

        public final void run() {
            AppMethodBeat.m2504i(135018);
            C38531k b = this.iLg.iKY;
            if (b != null) {
                b.mo61266aO(this.gYO);
                this.iLn.mo1480a((C41523a) b);
                AppMethodBeat.m2505o(135018);
                return;
            }
            AppMethodBeat.m2505o(135018);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$b */
    static final class C10853b implements C4931a {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        C10853b(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(135008);
            Object obj = (C25052j.m39373j("batch", str) && 3 == c4935m.hsh && (c4935m.obj instanceof Long)) ? 1 : null;
            if (obj != null) {
                AppBrandCollectionDisplayVerticalList.m18559a(this.iLg);
                AppMethodBeat.m2505o(135008);
                return;
            }
            AppBrandCollectionDisplayVerticalList.m18566g(this.iLg);
            AppMethodBeat.m2505o(135008);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$c */
    static final class C10854c implements C4931a {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        C10854c(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(135009);
            AppBrandCollectionDisplayVerticalList.m18566g(this.iLg);
            AppMethodBeat.m2505o(135009);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$d */
    static final class C10855d implements OnMenuItemClickListener {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        C10855d(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(135010);
            if (this.iLg.getActivity() == null) {
                AppMethodBeat.m2505o(135010);
            } else {
                int i;
                C27325a c27325a = AppBrandCollectionSortUI.iLo;
                FragmentActivity activity = this.iLg.getActivity();
                if (activity == null) {
                    C25052j.dWJ();
                }
                C25052j.m39375o(activity, "activity!!");
                Context context = activity;
                C38531k b = this.iLg.iKY;
                if (b == null) {
                    C25052j.dWJ();
                }
                ArrayList arrayList = b.iLD;
                int c = AppBrandCollectionDisplayVerticalList.m18562c(this.iLg);
                String d = AppBrandCollectionDisplayVerticalList.m18563d(this.iLg);
                C25052j.m39376p(context, "context");
                C25052j.m39376p(arrayList, "dataList");
                C25052j.m39376p(d, "operateReportSceneId");
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
                    activity2.overridePendingTransition(C25738R.anim.f8288n, C25738R.anim.f8293s);
                }
                this.iLg.iKZ = true;
                AppMethodBeat.m2505o(135010);
            }
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$e */
    static final class C10856e extends C25053k implements C31214a<Runnable> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$e$1 */
        static final class C108571 implements Runnable {
            final /* synthetic */ C10856e iLh;

            C108571(C10856e c10856e) {
                this.iLh = c10856e;
            }

            public final void run() {
                AppMethodBeat.m2504i(135011);
                AppBrandCollectionDisplayVerticalList.aMX();
                if (this.iLh.iLg.isAdded()) {
                    AppBrandCollectionDisplayVerticalList.m18565f(this.iLh.iLg);
                }
                HashSet hashSet = new HashSet();
                C38531k b = this.iLh.iLg.iKY;
                if (b == null) {
                    C25052j.dWJ();
                }
                for (LocalUsageInfo localUsageInfo : b.iLD) {
                    hashSet.add(localUsageInfo.username);
                }
                C42406r.m75073a(C25035t.m39352m(hashSet), C33137a.hhn);
                AppMethodBeat.m2505o(135011);
            }
        }

        C10856e(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135012);
            Runnable c108571 = new C108571(this);
            AppMethodBeat.m2505o(135012);
            return c108571;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$k */
    static final class C10858k implements Runnable {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        C10858k(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
        }

        public final void run() {
            AppMethodBeat.m2504i(135019);
            FragmentActivity activity = this.iLg.getActivity();
            if (!(activity instanceof C19766b)) {
                activity = null;
            }
            C19766b c19766b = (C19766b) activity;
            if (c19766b != null) {
                c19766b.mo17538eE(false);
                AppMethodBeat.m2505o(135019);
                return;
            }
            AppMethodBeat.m2505o(135019);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0001\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$f */
    static final class C10859f extends C25053k implements C31214a {
        public static final C10859f iLi = new C10859f();

        static {
            AppMethodBeat.m2504i(135013);
            AppMethodBeat.m2505o(135013);
        }

        C10859f() {
            super(0);
        }

        public final /* bridge */ /* synthetic */ Object invoke() {
            return null;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$h */
    static final class C10860h extends C25053k implements C31214a<Integer> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        C10860h(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            Integer valueOf;
            int i = 8;
            AppMethodBeat.m2504i(135016);
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
                    AppMethodBeat.m2505o(135016);
                    return valueOf;
                }
            }
            i = 3;
            valueOf = Integer.valueOf(i);
            AppMethodBeat.m2505o(135016);
            return valueOf;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$initView$1$1", "Landroid/support/v7/widget/LinearLayoutManager;", "supportsPredictiveItemAnimations", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$a */
    public static final class C10861a extends LinearLayoutManager {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        C10861a(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(1);
        }

        /* renamed from: iE */
        public final boolean mo1774iE() {
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$i */
    static final class C10862i extends C25053k implements C31214a<String> {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;

        C10862i(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            super(0);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ Object invoke() {
            Object aLd;
            AppMethodBeat.m2504i(135017);
            switch (AppBrandCollectionDisplayVerticalList.m18562c(this.iLg)) {
                case 6:
                case 7:
                case 8:
                    aLd = C19692e.aLd();
                    if (aLd == null) {
                        C25052j.dWJ();
                        AppMethodBeat.m2505o(135017);
                        break;
                    }
                default:
                    aLd = C19692e.aLc();
            }
            AppMethodBeat.m2505o(135017);
            return aLd;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$g */
    static final class C10863g implements Runnable {
        final /* synthetic */ AppBrandCollectionDisplayVerticalList iLg;
        final /* synthetic */ boolean iLj;
        final /* synthetic */ C31214a iLk;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$refreshDataList$workerRunner$1$1$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionDisplayVerticalList$g$a */
        static final class C10851a implements Runnable {
            final /* synthetic */ List iLl;
            final /* synthetic */ C10863g iLm;

            C10851a(List list, C10863g c10863g) {
                this.iLl = list;
                this.iLm = c10863g;
            }

            public final void run() {
                AppMethodBeat.m2504i(135014);
                if (this.iLl.isEmpty()) {
                    FragmentActivity activity = this.iLm.iLg.getActivity();
                    if (!(activity instanceof C19766b)) {
                        activity = null;
                    }
                    C19766b c19766b = (C19766b) activity;
                    if (c19766b != null) {
                        c19766b.mo17538eE(false);
                    }
                } else {
                    C38531k b = this.iLm.iLg.iKY;
                    if (b == null) {
                        C25052j.dWJ();
                    }
                    b.mo61266aO(this.iLl);
                    if (this.iLm.iLj) {
                        b = this.iLm.iLg.iKY;
                        if (b == null) {
                            C25052j.dWJ();
                        }
                        b.mo66308ar(0, this.iLl.size());
                    } else {
                        b = this.iLm.iLg.iKY;
                        if (b == null) {
                            C25052j.dWJ();
                        }
                        b.mo66310at(0, this.iLl.size());
                    }
                }
                Runnable runnable = (Runnable) this.iLm.iLk.invoke();
                if (runnable != null) {
                    runnable.run();
                    AppMethodBeat.m2505o(135014);
                    return;
                }
                AppMethodBeat.m2505o(135014);
            }
        }

        C10863g(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList, boolean z, C31214a c31214a) {
            this.iLg = appBrandCollectionDisplayVerticalList;
            this.iLj = z;
            this.iLk = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(135015);
            this.iLg.runOnUiThread(new C10851a(AppBrandCollectionDisplayVerticalList.aMW(), this));
            AppMethodBeat.m2505o(135015);
        }
    }

    static {
        AppMethodBeat.m2504i(135020);
        AppMethodBeat.m2505o(135020);
    }

    public AppBrandCollectionDisplayVerticalList() {
        AppMethodBeat.m2504i(135030);
        AppMethodBeat.m2505o(135030);
    }

    public static final /* synthetic */ List aMW() {
        AppMethodBeat.m2504i(135031);
        List aMU = AppBrandCollectionDisplayVerticalList.aMU();
        AppMethodBeat.m2505o(135031);
        return aMU;
    }

    public static final /* synthetic */ void aMX() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private static List<LocalUsageInfo> aMU() {
        AppMethodBeat.m2504i(135021);
        List a = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(BaseClientBuilder.API_PRIORITY_OTHER, C10117a.DESC);
        if (a == null) {
            a = C17115v.AUP;
        }
        Collection arrayList = new ArrayList();
        for (Object next : a) {
            if ((((LocalUsageInfo) next) != null ? 1 : null) != null) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        AppMethodBeat.m2505o(135021);
        return list;
    }

    /* renamed from: a */
    static /* synthetic */ void m18559a(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.m2504i(135023);
        appBrandCollectionDisplayVerticalList.m18560a(true, C10859f.iLi);
        AppMethodBeat.m2505o(135023);
    }

    /* renamed from: a */
    private final void m18560a(boolean z, C31214a<? extends Runnable> c31214a) {
        AppMethodBeat.m2504i(135022);
        Runnable c10863g = new C10863g(this, z, c31214a);
        C5004al c5004al = this.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        if (c5004al.doO()) {
            c10863g.run();
            AppMethodBeat.m2505o(135022);
            return;
        }
        c5004al = this.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        c5004al.mo10302aa(c10863g);
        AppMethodBeat.m2505o(135022);
    }

    public final void onActivityCreated(Bundle bundle) {
        AppMethodBeat.m2504i(135024);
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof MMActivity)) {
            activity = null;
        }
        MMActivity mMActivity = (MMActivity) activity;
        if (mMActivity != null) {
            mMActivity.mo17379a(0, getString(C25738R.string.f9064o9), (OnMenuItemClickListener) new C10855d(this), C5535b.BLACK);
            AppMethodBeat.m2505o(135024);
            return;
        }
        AppMethodBeat.m2505o(135024);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(135025);
        super.onResume();
        if (this.iKZ) {
            AppBrandCollectionDisplayVerticalList.m18559a(this);
            this.iKZ = false;
        }
        if (this.iLb) {
            C19690c.m30505pG(2);
            this.iLb = false;
        }
        AppMethodBeat.m2505o(135025);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.m2504i(135026);
        C25052j.m39376p(view, "view");
        super.onViewCreated(view, bundle);
        this.iLa = new C5004al("AppBrandLauncherCollectionList");
        m18560a(false, new C10856e(this));
        AppMethodBeat.m2505o(135026);
    }

    public final void initView() {
        AppMethodBeat.m2504i(135027);
        RecyclerView recyclerView = new RecyclerView(getActivity());
        getActivity();
        recyclerView.setLayoutManager(new C10861a(this));
        C38531k c38531k = new C38531k(new ArrayList(), this);
        this.iKY = c38531k;
        recyclerView.setAdapter(c38531k);
        recyclerView.setBackgroundColor(-1);
        recyclerView.mo66346b((C25373h) new C45701l());
        recyclerView.setItemAnimator(null);
        this.iKX = recyclerView;
        View contentView = getContentView();
        if (contentView == null) {
            C44941v c44941v = new C44941v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.m2505o(135027);
            throw c44941v;
        }
        FrameLayout frameLayout = (FrameLayout) contentView;
        RecyclerView recyclerView2 = this.iKX;
        if (recyclerView2 == null) {
            C25052j.dWJ();
        }
        frameLayout.addView(recyclerView2, new LayoutParams(-1, -2));
        AppMethodBeat.m2505o(135027);
    }

    public final void aMf() {
        AppMethodBeat.m2504i(135028);
        RecyclerView recyclerView = this.iKX;
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
            AppMethodBeat.m2505o(135028);
            return;
        }
        AppMethodBeat.m2505o(135028);
    }

    public final void onDestroyView() {
        AppMethodBeat.m2504i(135029);
        super.onDestroyView();
        ((C26779s) C42340f.m74878E(C26779s.class)).mo10117d(this.iLe);
        C42340f.auO().mo10117d(this.iLf);
        C5004al c5004al = this.iLa;
        if (c5004al != null) {
            c5004al.quit();
            AppMethodBeat.m2505o(135029);
            return;
        }
        AppMethodBeat.m2505o(135029);
    }

    public final void aMV() {
        this.iLb = true;
    }

    /* renamed from: c */
    public static final /* synthetic */ int m18562c(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.m2504i(135032);
        int intValue = ((Number) appBrandCollectionDisplayVerticalList.iLc.getValue()).intValue();
        AppMethodBeat.m2505o(135032);
        return intValue;
    }

    /* renamed from: d */
    public static final /* synthetic */ String m18563d(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.m2504i(135033);
        String str = (String) appBrandCollectionDisplayVerticalList.iLd.getValue();
        AppMethodBeat.m2505o(135033);
        return str;
    }

    /* renamed from: f */
    public static final /* synthetic */ void m18565f(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.m2504i(135034);
        C26779s c26779s = (C26779s) C42340f.m74878E(C26779s.class);
        C4931a c4931a = appBrandCollectionDisplayVerticalList.iLe;
        C5004al c5004al = appBrandCollectionDisplayVerticalList.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        c26779s.mo10114a(c4931a, c5004al.getLooper());
        C26844q auO = C42340f.auO();
        c4931a = appBrandCollectionDisplayVerticalList.iLf;
        c5004al = appBrandCollectionDisplayVerticalList.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        auO.mo10114a(c4931a, c5004al.getLooper());
        AppMethodBeat.m2505o(135034);
    }

    /* renamed from: g */
    public static final /* synthetic */ void m18566g(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        AppMethodBeat.m2504i(135035);
        if (appBrandCollectionDisplayVerticalList.iKY != null) {
            C38531k c38531k = appBrandCollectionDisplayVerticalList.iKY;
            if (c38531k == null) {
                C25052j.dWJ();
            }
            ArrayList aNd = c38531k.aNd();
            List aMU = AppBrandCollectionDisplayVerticalList.aMU();
            if (aMU.isEmpty()) {
                appBrandCollectionDisplayVerticalList.runOnUiThread(new C10858k(appBrandCollectionDisplayVerticalList));
                AppMethodBeat.m2505o(135035);
                return;
            }
            try {
                appBrandCollectionDisplayVerticalList.runOnUiThread(new C10852j(C0595c.m1289a(new C33107ab(aNd, aMU), true), appBrandCollectionDisplayVerticalList, aMU));
                AppMethodBeat.m2505o(135035);
                return;
            } catch (NullPointerException e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandCollectionDisplayVerticalList", e, "calculateDiff, oldList.size=" + aNd.size() + ", newList.size=" + aMU.size(), new Object[0]);
                if (C5047bp.dpL()) {
                    Throwable th = e;
                    AppMethodBeat.m2505o(135035);
                    throw th;
                }
            }
        }
        AppMethodBeat.m2505o(135035);
    }
}
