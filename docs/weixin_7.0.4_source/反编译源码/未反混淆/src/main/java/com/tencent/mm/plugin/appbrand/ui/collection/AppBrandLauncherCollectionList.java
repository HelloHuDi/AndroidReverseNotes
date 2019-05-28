package com.tencent.mm.plugin.appbrand.ui.collection;

import a.a.t;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.v;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J \u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mCollectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "mDataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "mDragFeatureView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "mList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "mListAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionAdapter;", "mWxaAttrsStorageListener", "getLayoutId", "", "hideLoading", "", "initView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "onTitleDoubleTap", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refreshDataList", "replace", "", "lazyCallback", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "removeStorageListeners", "requestLayoutSpanCount", "setupStorageListeners", "showLoading", "WrapperGridLayoutManager", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherCollectionList extends Fragment {
    private al iLa;
    private final com.tencent.mm.sdk.e.k.a iLe = new c(this);
    private final com.tencent.mm.sdk.e.k.a iLf = d.iLA;
    private b iLu;
    private i iLv;
    private a iLw;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$onViewCreated$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
    public static final class f implements OnPreDrawListener {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        f(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.i(135057);
            i b = this.iLx.iLv;
            if (b != null) {
                ViewTreeObserver viewTreeObserver = b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                }
            }
            AppBrandLauncherCollectionList.c(this.iLx);
            AppMethodBeat.o(135057);
            return true;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        final /* synthetic */ boolean iLj;
        final /* synthetic */ a.f.a.a iLk;
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$refreshDataList$workerRunner$1$1$1"})
        static final class a implements Runnable {
            final /* synthetic */ h iLC;
            final /* synthetic */ List iLl;

            a(List list, h hVar) {
                this.iLl = list;
                this.iLC = hVar;
            }

            public final void run() {
                AppMethodBeat.i(135060);
                if (this.iLl.isEmpty()) {
                    FragmentActivity activity = this.iLC.iLx.getActivity();
                    if (activity == null) {
                        v vVar = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.launcher.IFolderActivityContext");
                        AppMethodBeat.o(135060);
                        throw vVar;
                    }
                    ((com.tencent.mm.plugin.appbrand.ui.a.b) activity).eE(false);
                } else {
                    a a = this.iLC.iLx.iLw;
                    if (a == null) {
                        j.dWJ();
                    }
                    a.iLD.clear();
                    a = this.iLC.iLx.iLw;
                    if (a == null) {
                        j.dWJ();
                    }
                    a.iLD.addAll(this.iLl);
                    if (this.iLC.iLj) {
                        a = this.iLC.iLx.iLw;
                        if (a == null) {
                            j.dWJ();
                        }
                        a.ar(0, this.iLl.size());
                    } else {
                        a = this.iLC.iLx.iLw;
                        if (a == null) {
                            j.dWJ();
                        }
                        a.at(0, this.iLl.size());
                    }
                }
                Runnable runnable = (Runnable) this.iLC.iLk.invoke();
                if (runnable != null) {
                    runnable.run();
                    AppMethodBeat.o(135060);
                    return;
                }
                AppMethodBeat.o(135060);
            }
        }

        h(AppBrandLauncherCollectionList appBrandLauncherCollectionList, boolean z, a.f.a.a aVar) {
            this.iLx = appBrandLauncherCollectionList;
            this.iLj = z;
            this.iLk = aVar;
        }

        public final void run() {
            List list;
            AppMethodBeat.i(135061);
            List a = ((af) com.tencent.mm.kernel.g.K(af.class)).a(BaseClientBuilder.API_PRIORITY_OTHER, com.tencent.mm.plugin.appbrand.appusage.af.a.DESC);
            if (a == null) {
                list = a.a.v.AUP;
            } else {
                list = a;
            }
            this.iLx.runOnUiThread(new a(list, this));
            AppMethodBeat.o(135061);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
    static final class g extends k implements a.f.a.a<Runnable> {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$g$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ g iLB;

            AnonymousClass1(g gVar) {
                this.iLB = gVar;
            }

            public final void run() {
                AppMethodBeat.i(135058);
                AppBrandLauncherCollectionList.aMY();
                if (this.iLB.iLx.isAdded()) {
                    AppBrandLauncherCollectionList.d(this.iLB.iLx);
                }
                HashSet hashSet = new HashSet();
                a a = this.iLB.iLx.iLw;
                if (a == null) {
                    j.dWJ();
                }
                for (LocalUsageInfo localUsageInfo : a.iLD) {
                    hashSet.add(localUsageInfo.username);
                }
                r.a(t.m(hashSet), com.tencent.mm.plugin.appbrand.config.j.a.STAR_LIST);
                AppMethodBeat.o(135058);
            }
        }

        g(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135059);
            Runnable anonymousClass1 = new AnonymousClass1(this);
            AppMethodBeat.o(135059);
            return anonymousClass1;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$WrapperGridLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "supportsPredictiveItemAnimations", "plugin-appbrand-integration_release"})
    public static final class a extends GridLayoutManager {
        public a() {
            super(4, (byte) 0);
        }

        public final boolean iE() {
            return false;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\r\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$initView$2", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "onListMayChanged", "", "onListMayChanged$plugin_appbrand_integration_release", "plugin-appbrand-integration_release"})
    public static final class b extends b {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        b(AppBrandLauncherCollectionList appBrandLauncherCollectionList, Context context, i iVar) {
            this.iLx = appBrandLauncherCollectionList;
            super(context, iVar);
        }

        public final void aMZ() {
            AppMethodBeat.i(135050);
            a a = this.iLx.iLw;
            if (a != null) {
                com.tencent.mm.plugin.appbrand.appusage.f.a aVar = com.tencent.mm.plugin.appbrand.appusage.f.gYW;
                com.tencent.mm.plugin.appbrand.appusage.f awZ = com.tencent.mm.plugin.appbrand.appusage.f.gYV;
                if (awZ == null) {
                    j.dWJ();
                }
                com.tencent.mm.plugin.appbrand.appusage.f.a(awZ, (List) a.iLD);
                AppMethodBeat.o(135050);
                return;
            }
            AppMethodBeat.o(135050);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class c implements com.tencent.mm.sdk.e.k.a {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$c$2 */
        static final class AnonymousClass2 extends k implements a.f.a.a<Runnable> {
            final /* synthetic */ c iLy;

            @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$c$2$1 */
            static final class AnonymousClass1 implements Runnable {
                final /* synthetic */ AnonymousClass2 iLz;

                AnonymousClass1(AnonymousClass2 anonymousClass2) {
                    this.iLz = anonymousClass2;
                }

                public final void run() {
                    AppMethodBeat.i(135052);
                    i b = this.iLz.iLy.iLx.iLv;
                    if (b == null) {
                        j.dWJ();
                    }
                    b.setLayoutFrozen(false);
                    b e = this.iLz.iLy.iLx.iLu;
                    if (e == null) {
                        j.dWJ();
                    }
                    e.setTouchEnabled(true);
                    AppMethodBeat.o(135052);
                }
            }

            AnonymousClass2(c cVar) {
                this.iLy = cVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(135053);
                Runnable anonymousClass1 = new AnonymousClass1(this);
                AppMethodBeat.o(135053);
                return anonymousClass1;
            }
        }

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$c$1 */
        static final class AnonymousClass1 implements Runnable {
            final /* synthetic */ c iLy;

            AnonymousClass1(c cVar) {
                this.iLy = cVar;
            }

            public final void run() {
                AppMethodBeat.i(135051);
                i b = this.iLy.iLx.iLv;
                if (b == null) {
                    j.dWJ();
                }
                b.setLayoutFrozen(true);
                b e = this.iLy.iLx.iLu;
                if (e == null) {
                    j.dWJ();
                }
                e.setTouchEnabled(false);
                AppMethodBeat.o(135051);
            }
        }

        c(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
        }

        public final void a(String str, m mVar) {
            AppMethodBeat.i(135054);
            Object obj = ("batch".equals(str) && 3 == mVar.hsh && (mVar.obj instanceof Long)) ? 1 : null;
            if (obj != null) {
                this.iLx.runOnUiThread(new AnonymousClass1(this));
                AppBrandLauncherCollectionList.a(this.iLx, (a.f.a.a) new AnonymousClass2(this));
            }
            AppMethodBeat.o(135054);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    static final class d implements com.tencent.mm.sdk.e.k.a {
        public static final d iLA = new d();

        static {
            AppMethodBeat.i(135055);
            AppMethodBeat.o(135055);
        }

        d() {
        }

        public final void a(String str, m mVar) {
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "counter", "", "onGlobalLayout", "", "plugin-appbrand-integration_release"})
    public static final class e implements OnGlobalLayoutListener {
        private int counter;
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        e(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(135056);
            this.counter++;
            if (this.counter < 2) {
                AppMethodBeat.o(135056);
                return;
            }
            i b = this.iLx.iLv;
            if (b != null) {
                ViewTreeObserver viewTreeObserver = b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
            AppBrandLauncherCollectionList.c(this.iLx);
            AppMethodBeat.o(135056);
        }
    }

    public AppBrandLauncherCollectionList() {
        AppMethodBeat.i(135068);
        AppMethodBeat.o(135068);
    }

    public static final /* synthetic */ void aMY() {
    }

    public final int getLayoutId() {
        return -1;
    }

    private final void a(boolean z, a.f.a.a<? extends Runnable> aVar) {
        AppMethodBeat.i(135062);
        Runnable hVar = new h(this, z, aVar);
        al alVar = this.iLa;
        if (alVar == null) {
            j.dWJ();
        }
        if (alVar.doO()) {
            hVar.run();
            AppMethodBeat.o(135062);
            return;
        }
        alVar = this.iLa;
        if (alVar == null) {
            j.dWJ();
        }
        alVar.aa(hVar);
        AppMethodBeat.o(135062);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(135063);
        j.p(view, "view");
        super.onViewCreated(view, bundle);
        i iVar = this.iLv;
        if (iVar == null) {
            j.dWJ();
        }
        iVar.getViewTreeObserver().addOnPreDrawListener(new f(this));
        this.iLa = new al("AppBrandLauncherCollectionList");
        a(false, (a.f.a.a) new g(this));
        AppMethodBeat.o(135063);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(135064);
        super.onConfigurationChanged(configuration);
        i iVar = this.iLv;
        if (iVar != null) {
            ViewTreeObserver viewTreeObserver = iVar.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new e(this));
                AppMethodBeat.o(135064);
                return;
            }
        }
        AppMethodBeat.o(135064);
    }

    public final void initView() {
        AppMethodBeat.i(135065);
        i iVar = new i(getActivity());
        getActivity();
        a aVar = new a();
        aVar.jU();
        iVar.setLayoutManager(aVar);
        a aVar2 = new a(new ArrayList());
        this.iLw = aVar2;
        iVar.setAdapter(aVar2);
        iVar.setClipToPadding(false);
        Context context = iVar.getContext();
        j.o(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.tk);
        Context context2 = iVar.getContext();
        j.o(context2, "context");
        iVar.setPadding(0, dimensionPixelSize, 0, context2.getResources().getDimensionPixelSize(R.dimen.tk));
        iVar.setBackgroundColor(-1);
        iVar.b((android.support.v7.widget.RecyclerView.h) new f());
        this.iLv = iVar;
        View contentView = getContentView();
        v vVar;
        if (contentView == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(135065);
            throw vVar;
        }
        FrameLayout frameLayout = (FrameLayout) contentView;
        iVar = this.iLv;
        if (iVar == null) {
            j.dWJ();
        }
        frameLayout.addView(iVar, new LayoutParams(-1, -2));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            j.dWJ();
        }
        j.o(activity, "activity!!");
        context = activity;
        iVar = this.iLv;
        if (iVar == null) {
            j.dWJ();
        }
        b bVar = new b(this, context, iVar);
        contentView = getContentView();
        if (contentView == null) {
            vVar = new v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(135065);
            throw vVar;
        }
        ((FrameLayout) contentView).addView(bVar, new LayoutParams(-1, -1));
        iVar = this.iLv;
        if (iVar == null) {
            j.dWJ();
        }
        iVar.h(bVar);
        i iVar2 = this.iLv;
        if (iVar2 == null) {
            j.dWJ();
        }
        bVar.setRecyclerView(iVar2);
        this.iLu = bVar;
        AppMethodBeat.o(135065);
    }

    public final void aMf() {
        AppMethodBeat.i(135066);
        i iVar = this.iLv;
        if (iVar != null) {
            iVar.smoothScrollToPosition(0);
            AppMethodBeat.o(135066);
            return;
        }
        AppMethodBeat.o(135066);
    }

    public final void onDestroyView() {
        AppMethodBeat.i(135067);
        super.onDestroyView();
        ((com.tencent.mm.plugin.appbrand.appusage.c) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.appbrand.appusage.c.class)).a(com.tencent.mm.plugin.appbrand.appusage.z.b.CloseCollectionList);
        ((s) com.tencent.mm.plugin.appbrand.app.f.E(s.class)).d(this.iLe);
        com.tencent.mm.plugin.appbrand.app.f.auO().d(this.iLf);
        al alVar = this.iLa;
        if (alVar != null) {
            alVar.quit();
            AppMethodBeat.o(135067);
            return;
        }
        AppMethodBeat.o(135067);
    }

    public static final /* synthetic */ void c(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
        AppMethodBeat.i(135069);
        i iVar = appBrandLauncherCollectionList.iLv;
        if (iVar != null) {
            int width = iVar.getWidth();
            Context context = iVar.getContext();
            j.o(context, "context");
            int dimensionPixelSize = width / context.getResources().getDimensionPixelSize(R.dimen.ti);
            i layoutManager = iVar.getLayoutManager();
            v vVar;
            if (layoutManager == null) {
                vVar = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                AppMethodBeat.o(135069);
                throw vVar;
            }
            if (dimensionPixelSize != ((GridLayoutManager) layoutManager).iD()) {
                layoutManager = iVar.getLayoutManager();
                if (layoutManager == null) {
                    vVar = new v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                    AppMethodBeat.o(135069);
                    throw vVar;
                }
                ((GridLayoutManager) layoutManager).bT(dimensionPixelSize);
                iVar.requestLayout();
            }
            AppMethodBeat.o(135069);
            return;
        }
        AppMethodBeat.o(135069);
    }

    public static final /* synthetic */ void d(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
        AppMethodBeat.i(135070);
        s sVar = (s) com.tencent.mm.plugin.appbrand.app.f.E(s.class);
        com.tencent.mm.sdk.e.k.a aVar = appBrandLauncherCollectionList.iLe;
        al alVar = appBrandLauncherCollectionList.iLa;
        if (alVar == null) {
            j.dWJ();
        }
        sVar.a(aVar, alVar.getLooper());
        q auO = com.tencent.mm.plugin.appbrand.app.f.auO();
        aVar = appBrandLauncherCollectionList.iLf;
        alVar = appBrandLauncherCollectionList.iLa;
        if (alVar == null) {
            j.dWJ();
        }
        auO.a(aVar, alVar.getLooper());
        AppMethodBeat.o(135070);
    }
}
