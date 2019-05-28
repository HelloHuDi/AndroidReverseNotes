package com.tencent.p177mm.plugin.appbrand.p336ui.collection;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C10120c;
import com.tencent.p177mm.plugin.appbrand.appusage.C10134z.C10133b;
import com.tencent.p177mm.plugin.appbrand.appusage.C26779s;
import com.tencent.p177mm.plugin.appbrand.appusage.C38128f;
import com.tencent.p177mm.plugin.appbrand.appusage.C38128f.C38126a;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.config.C26844q;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI.Fragment;
import com.tencent.p177mm.plugin.appbrand.p336ui.p1233a.C19766b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p001a.C17115v;
import p000a.p001a.C25035t;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J \u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0!H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "mCollectionStorageListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "mDataProcessThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "mDragFeatureView", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "mList", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionRecyclerView;", "mListAdapter", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionAdapter;", "mWxaAttrsStorageListener", "getLayoutId", "", "hideLoading", "", "initView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "onTitleDoubleTap", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "refreshDataList", "replace", "", "lazyCallback", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "removeStorageListeners", "requestLayoutSpanCount", "setupStorageListeners", "showLoading", "WrapperGridLayoutManager", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList */
public final class AppBrandLauncherCollectionList extends Fragment {
    private C5004al iLa;
    private final C4931a iLe = new C33546c(this);
    private final C4931a iLf = C33550d.iLA;
    private C38526b iLu;
    private C10871i iLv;
    private C19778a iLw;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$onViewCreated$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$f */
    public static final class C10866f implements OnPreDrawListener {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        C10866f(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(135057);
            C10871i b = this.iLx.iLv;
            if (b != null) {
                ViewTreeObserver viewTreeObserver = b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnPreDrawListener(this);
                }
            }
            AppBrandLauncherCollectionList.m54778c(this.iLx);
            AppMethodBeat.m2505o(135057);
            return true;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$h */
    static final class C19776h implements Runnable {
        final /* synthetic */ boolean iLj;
        final /* synthetic */ C31214a iLk;
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$refreshDataList$workerRunner$1$1$1"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$h$a */
        static final class C19777a implements Runnable {
            final /* synthetic */ C19776h iLC;
            final /* synthetic */ List iLl;

            C19777a(List list, C19776h c19776h) {
                this.iLl = list;
                this.iLC = c19776h;
            }

            public final void run() {
                AppMethodBeat.m2504i(135060);
                if (this.iLl.isEmpty()) {
                    FragmentActivity activity = this.iLC.iLx.getActivity();
                    if (activity == null) {
                        C44941v c44941v = new C44941v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.launcher.IFolderActivityContext");
                        AppMethodBeat.m2505o(135060);
                        throw c44941v;
                    }
                    ((C19766b) activity).mo17538eE(false);
                } else {
                    C19778a a = this.iLC.iLx.iLw;
                    if (a == null) {
                        C25052j.dWJ();
                    }
                    a.iLD.clear();
                    a = this.iLC.iLx.iLw;
                    if (a == null) {
                        C25052j.dWJ();
                    }
                    a.iLD.addAll(this.iLl);
                    if (this.iLC.iLj) {
                        a = this.iLC.iLx.iLw;
                        if (a == null) {
                            C25052j.dWJ();
                        }
                        a.mo66308ar(0, this.iLl.size());
                    } else {
                        a = this.iLC.iLx.iLw;
                        if (a == null) {
                            C25052j.dWJ();
                        }
                        a.mo66310at(0, this.iLl.size());
                    }
                }
                Runnable runnable = (Runnable) this.iLC.iLk.invoke();
                if (runnable != null) {
                    runnable.run();
                    AppMethodBeat.m2505o(135060);
                    return;
                }
                AppMethodBeat.m2505o(135060);
            }
        }

        C19776h(AppBrandLauncherCollectionList appBrandLauncherCollectionList, boolean z, C31214a c31214a) {
            this.iLx = appBrandLauncherCollectionList;
            this.iLj = z;
            this.iLk = c31214a;
        }

        public final void run() {
            List list;
            AppMethodBeat.m2504i(135061);
            List a = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(BaseClientBuilder.API_PRIORITY_OTHER, C10117a.DESC);
            if (a == null) {
                list = C17115v.AUP;
            } else {
                list = a;
            }
            this.iLx.runOnUiThread(new C19777a(list, this));
            AppMethodBeat.m2505o(135061);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$g */
    static final class C31561g extends C25053k implements C31214a<Runnable> {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$g$1 */
        static final class C315621 implements Runnable {
            final /* synthetic */ C31561g iLB;

            C315621(C31561g c31561g) {
                this.iLB = c31561g;
            }

            public final void run() {
                AppMethodBeat.m2504i(135058);
                AppBrandLauncherCollectionList.aMY();
                if (this.iLB.iLx.isAdded()) {
                    AppBrandLauncherCollectionList.m54779d(this.iLB.iLx);
                }
                HashSet hashSet = new HashSet();
                C19778a a = this.iLB.iLx.iLw;
                if (a == null) {
                    C25052j.dWJ();
                }
                for (LocalUsageInfo localUsageInfo : a.iLD) {
                    hashSet.add(localUsageInfo.username);
                }
                C42406r.m75073a(C25035t.m39352m(hashSet), C33137a.STAR_LIST);
                AppMethodBeat.m2505o(135058);
            }
        }

        C31561g(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135059);
            Runnable c315621 = new C315621(this);
            AppMethodBeat.m2505o(135059);
            return c315621;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$WrapperGridLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "orientation", "reverseLayout", "", "(Landroid/content/Context;IIZ)V", "supportsPredictiveItemAnimations", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$a */
    public static final class C33544a extends GridLayoutManager {
        public C33544a() {
            super(4, (byte) 0);
        }

        /* renamed from: iE */
        public final boolean mo1774iE() {
            return false;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\r\u0010\u0002\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0004¨\u0006\u0005"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$initView$2", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "onListMayChanged", "", "onListMayChanged$plugin_appbrand_integration_release", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$b */
    public static final class C33545b extends C38526b {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        C33545b(AppBrandLauncherCollectionList appBrandLauncherCollectionList, Context context, C10871i c10871i) {
            this.iLx = appBrandLauncherCollectionList;
            super(context, c10871i);
        }

        public final void aMZ() {
            AppMethodBeat.m2504i(135050);
            C19778a a = this.iLx.iLw;
            if (a != null) {
                C38126a c38126a = C38128f.gYW;
                C38128f awZ = C38128f.gYV;
                if (awZ == null) {
                    C25052j.dWJ();
                }
                C38128f.m64507a(awZ, (List) a.iLD);
                AppMethodBeat.m2505o(135050);
                return;
            }
            AppMethodBeat.m2505o(135050);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$c */
    static final class C33546c implements C4931a {
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$c$2 */
        static final class C335472 extends C25053k implements C31214a<Runnable> {
            final /* synthetic */ C33546c iLy;

            @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$c$2$1 */
            static final class C335481 implements Runnable {
                final /* synthetic */ C335472 iLz;

                C335481(C335472 c335472) {
                    this.iLz = c335472;
                }

                public final void run() {
                    AppMethodBeat.m2504i(135052);
                    C10871i b = this.iLz.iLy.iLx.iLv;
                    if (b == null) {
                        C25052j.dWJ();
                    }
                    b.setLayoutFrozen(false);
                    C38526b e = this.iLz.iLy.iLx.iLu;
                    if (e == null) {
                        C25052j.dWJ();
                    }
                    e.setTouchEnabled(true);
                    AppMethodBeat.m2505o(135052);
                }
            }

            C335472(C33546c c33546c) {
                this.iLy = c33546c;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.m2504i(135053);
                Runnable c335481 = new C335481(this);
                AppMethodBeat.m2505o(135053);
                return c335481;
            }
        }

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$c$1 */
        static final class C335491 implements Runnable {
            final /* synthetic */ C33546c iLy;

            C335491(C33546c c33546c) {
                this.iLy = c33546c;
            }

            public final void run() {
                AppMethodBeat.m2504i(135051);
                C10871i b = this.iLy.iLx.iLv;
                if (b == null) {
                    C25052j.dWJ();
                }
                b.setLayoutFrozen(true);
                C38526b e = this.iLy.iLx.iLu;
                if (e == null) {
                    C25052j.dWJ();
                }
                e.setTouchEnabled(false);
                AppMethodBeat.m2505o(135051);
            }
        }

        C33546c(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(135054);
            Object obj = ("batch".equals(str) && 3 == c4935m.hsh && (c4935m.obj instanceof Long)) ? 1 : null;
            if (obj != null) {
                this.iLx.runOnUiThread(new C335491(this));
                AppBrandLauncherCollectionList.m54775a(this.iLx, (C31214a) new C335472(this));
            }
            AppMethodBeat.m2505o(135054);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "event", "", "kotlin.jvm.PlatformType", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$d */
    static final class C33550d implements C4931a {
        public static final C33550d iLA = new C33550d();

        static {
            AppMethodBeat.m2504i(135055);
            AppMethodBeat.m2505o(135055);
        }

        C33550d() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "counter", "", "onGlobalLayout", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList$e */
    public static final class C33551e implements OnGlobalLayoutListener {
        private int counter;
        final /* synthetic */ AppBrandLauncherCollectionList iLx;

        C33551e(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
            this.iLx = appBrandLauncherCollectionList;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(135056);
            this.counter++;
            if (this.counter < 2) {
                AppMethodBeat.m2505o(135056);
                return;
            }
            C10871i b = this.iLx.iLv;
            if (b != null) {
                ViewTreeObserver viewTreeObserver = b.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
            AppBrandLauncherCollectionList.m54778c(this.iLx);
            AppMethodBeat.m2505o(135056);
        }
    }

    public AppBrandLauncherCollectionList() {
        AppMethodBeat.m2504i(135068);
        AppMethodBeat.m2505o(135068);
    }

    public static final /* synthetic */ void aMY() {
    }

    public final int getLayoutId() {
        return -1;
    }

    /* renamed from: a */
    private final void m54776a(boolean z, C31214a<? extends Runnable> c31214a) {
        AppMethodBeat.m2504i(135062);
        Runnable c19776h = new C19776h(this, z, c31214a);
        C5004al c5004al = this.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        if (c5004al.doO()) {
            c19776h.run();
            AppMethodBeat.m2505o(135062);
            return;
        }
        c5004al = this.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        c5004al.mo10302aa(c19776h);
        AppMethodBeat.m2505o(135062);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.m2504i(135063);
        C25052j.m39376p(view, "view");
        super.onViewCreated(view, bundle);
        C10871i c10871i = this.iLv;
        if (c10871i == null) {
            C25052j.dWJ();
        }
        c10871i.getViewTreeObserver().addOnPreDrawListener(new C10866f(this));
        this.iLa = new C5004al("AppBrandLauncherCollectionList");
        m54776a(false, (C31214a) new C31561g(this));
        AppMethodBeat.m2505o(135063);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(135064);
        super.onConfigurationChanged(configuration);
        C10871i c10871i = this.iLv;
        if (c10871i != null) {
            ViewTreeObserver viewTreeObserver = c10871i.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new C33551e(this));
                AppMethodBeat.m2505o(135064);
                return;
            }
        }
        AppMethodBeat.m2505o(135064);
    }

    public final void initView() {
        AppMethodBeat.m2504i(135065);
        C10871i c10871i = new C10871i(getActivity());
        getActivity();
        C33544a c33544a = new C33544a();
        c33544a.mo31873jU();
        c10871i.setLayoutManager(c33544a);
        C19778a c19778a = new C19778a(new ArrayList());
        this.iLw = c19778a;
        c10871i.setAdapter(c19778a);
        c10871i.setClipToPadding(false);
        Context context = c10871i.getContext();
        C25052j.m39375o(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f10181tk);
        Context context2 = c10871i.getContext();
        C25052j.m39375o(context2, "context");
        c10871i.setPadding(0, dimensionPixelSize, 0, context2.getResources().getDimensionPixelSize(C25738R.dimen.f10181tk));
        c10871i.setBackgroundColor(-1);
        c10871i.mo66346b((C25373h) new C10867f());
        this.iLv = c10871i;
        View contentView = getContentView();
        C44941v c44941v;
        if (contentView == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.m2505o(135065);
            throw c44941v;
        }
        FrameLayout frameLayout = (FrameLayout) contentView;
        c10871i = this.iLv;
        if (c10871i == null) {
            C25052j.dWJ();
        }
        frameLayout.addView(c10871i, new LayoutParams(-1, -2));
        FragmentActivity activity = getActivity();
        if (activity == null) {
            C25052j.dWJ();
        }
        C25052j.m39375o(activity, "activity!!");
        context = activity;
        c10871i = this.iLv;
        if (c10871i == null) {
            C25052j.dWJ();
        }
        C33545b c33545b = new C33545b(this, context, c10871i);
        contentView = getContentView();
        if (contentView == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.m2505o(135065);
            throw c44941v;
        }
        ((FrameLayout) contentView).addView(c33545b, new LayoutParams(-1, -1));
        c10871i = this.iLv;
        if (c10871i == null) {
            C25052j.dWJ();
        }
        c10871i.mo61306h(c33545b);
        C10871i c10871i2 = this.iLv;
        if (c10871i2 == null) {
            C25052j.dWJ();
        }
        c33545b.setRecyclerView(c10871i2);
        this.iLu = c33545b;
        AppMethodBeat.m2505o(135065);
    }

    public final void aMf() {
        AppMethodBeat.m2504i(135066);
        C10871i c10871i = this.iLv;
        if (c10871i != null) {
            c10871i.smoothScrollToPosition(0);
            AppMethodBeat.m2505o(135066);
            return;
        }
        AppMethodBeat.m2505o(135066);
    }

    public final void onDestroyView() {
        AppMethodBeat.m2504i(135067);
        super.onDestroyView();
        ((C10120c) C1720g.m3528K(C10120c.class)).mo21478a(C10133b.CloseCollectionList);
        ((C26779s) C42340f.m74878E(C26779s.class)).mo10117d(this.iLe);
        C42340f.auO().mo10117d(this.iLf);
        C5004al c5004al = this.iLa;
        if (c5004al != null) {
            c5004al.quit();
            AppMethodBeat.m2505o(135067);
            return;
        }
        AppMethodBeat.m2505o(135067);
    }

    /* renamed from: c */
    public static final /* synthetic */ void m54778c(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
        AppMethodBeat.m2504i(135069);
        C10871i c10871i = appBrandLauncherCollectionList.iLv;
        if (c10871i != null) {
            int width = c10871i.getWidth();
            Context context = c10871i.getContext();
            C25052j.m39375o(context, "context");
            int dimensionPixelSize = width / context.getResources().getDimensionPixelSize(C25738R.dimen.f10179ti);
            C17480i layoutManager = c10871i.getLayoutManager();
            C44941v c44941v;
            if (layoutManager == null) {
                c44941v = new C44941v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                AppMethodBeat.m2505o(135069);
                throw c44941v;
            }
            if (dimensionPixelSize != ((GridLayoutManager) layoutManager).mo51943iD()) {
                layoutManager = c10871i.getLayoutManager();
                if (layoutManager == null) {
                    c44941v = new C44941v("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
                    AppMethodBeat.m2505o(135069);
                    throw c44941v;
                }
                ((GridLayoutManager) layoutManager).mo51942bT(dimensionPixelSize);
                c10871i.requestLayout();
            }
            AppMethodBeat.m2505o(135069);
            return;
        }
        AppMethodBeat.m2505o(135069);
    }

    /* renamed from: d */
    public static final /* synthetic */ void m54779d(AppBrandLauncherCollectionList appBrandLauncherCollectionList) {
        AppMethodBeat.m2504i(135070);
        C26779s c26779s = (C26779s) C42340f.m74878E(C26779s.class);
        C4931a c4931a = appBrandLauncherCollectionList.iLe;
        C5004al c5004al = appBrandLauncherCollectionList.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        c26779s.mo10114a(c4931a, c5004al.getLooper());
        C26844q auO = C42340f.auO();
        c4931a = appBrandLauncherCollectionList.iLf;
        c5004al = appBrandLauncherCollectionList.iLa;
        if (c5004al == null) {
            C25052j.dWJ();
        }
        auO.mo10114a(c4931a, c5004al.getLooper());
        AppMethodBeat.m2505o(135070);
    }
}
