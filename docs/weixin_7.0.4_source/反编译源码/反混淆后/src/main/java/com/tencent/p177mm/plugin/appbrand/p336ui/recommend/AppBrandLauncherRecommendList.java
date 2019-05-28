package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI.Fragment;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38556g.C19805g;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38556g.C19806h;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38556g.C27348b;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38556g.C38555n;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38556g.C38559m;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38556g.C38560f;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C38556g.C38561o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.C17344i;
import p000a.C44856f;
import p000a.C44941v;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p006a.C31591m;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C25054t;
import p000a.p005f.p007b.C44855v;
import p000a.p010i.C31815k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList */
public final class AppBrandLauncherRecommendList extends Fragment {
    private static final String TAG = TAG;
    static final /* synthetic */ C31815k[] eQB = new C31815k[]{C44855v.m82052a(new C25054t(C44855v.m82055aN(AppBrandLauncherRecommendList.class), "uiLogic", "getUiLogic()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;"))};
    public static final C10918a iPt = new C10918a();
    private final C44856f iPs = C17344i.m26854g(new C10919b(this));

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList$a */
    public static final class C10918a {
        private C10918a() {
        }

        public /* synthetic */ C10918a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, dWq = {"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandLauncherRecommendList$b */
    static final class C10919b extends C25053k implements C31214a<C109201> {
        final /* synthetic */ AppBrandLauncherRecommendList iPu;

        C10919b(AppBrandLauncherRecommendList appBrandLauncherRecommendList) {
            this.iPu = appBrandLauncherRecommendList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(135142);
            FragmentActivity activity = this.iPu.getActivity();
            if (activity == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.m2505o(135142);
                throw c44941v;
            }
            C109201 c109201 = new C38556g(this, activity) {
                private final boolean fsQ = true;
                final /* synthetic */ C10919b iPw;

                public final String aNB() {
                    AppMethodBeat.m2504i(135140);
                    String string = this.iPw.iPu.getString(C25738R.string.g58);
                    C25052j.m39375o(string, "this@AppBrandLauncherRec…header_text_all_use_hint)");
                    AppMethodBeat.m2505o(135140);
                    return string;
                }

                public final View getContentView() {
                    AppMethodBeat.m2504i(135141);
                    View contentView = this.iPw.iPu.getContentView();
                    AppMethodBeat.m2505o(135141);
                    return contentView;
                }

                public final boolean aNC() {
                    return this.fsQ;
                }
            };
            AppMethodBeat.m2505o(135142);
            return c109201;
        }
    }

    private final C38556g aNA() {
        AppMethodBeat.m2504i(135144);
        C38556g c38556g = (C38556g) this.iPs.getValue();
        AppMethodBeat.m2505o(135144);
        return c38556g;
    }

    public AppBrandLauncherRecommendList() {
        AppMethodBeat.m2504i(135150);
        AppMethodBeat.m2505o(135150);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(135145);
        super.onCreate(bundle);
        C4990ab.m7416i(TAG, "onCreate");
        getLifecycle().addObserver(aNA());
        AppMethodBeat.m2505o(135145);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.m2504i(135146);
        C38556g aNA = aNA();
        aNA.aNL().setLayoutManager(aNA.iQm);
        View contentView = aNA.getContentView();
        C44941v c44941v;
        if (contentView == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.m2505o(135146);
            throw c44941v;
        }
        ((FrameLayout) contentView).addView(aNA.aNL(), new LayoutParams(-1, -1));
        aNA.iQk.mo66319jR();
        C38544a c38544a = aNA.iQk;
        C31591m c38559m = new C38559m(aNA);
        C25052j.m39376p(c38559m, "<set-?>");
        c38544a.iPy = c38559m;
        c38544a = aNA.iQk;
        c38559m = new C38555n(aNA);
        C25052j.m39376p(c38559m, "<set-?>");
        c38544a.iPA = c38559m;
        c38544a = aNA.iQk;
        c38559m = new C38561o(aNA);
        C25052j.m39376p(c38559m, "<set-?>");
        c38544a.iPz = c38559m;
        aNA.aNL().setAdapter(aNA.iQk);
        if (aNA.aNC()) {
            aNA.aNL().addHeaderView(aNA.iQn.aNi());
            contentView = aNA.iQn.aNi();
            if (contentView != null) {
                contentView.setVisibility(8);
            }
            aNA.iQn.aNh();
            aNA.iQn.mo6437pS(0);
            aNA.iQn.mo6438pT(0);
        }
        View inflate = LayoutInflater.from(aNA.context).inflate(2130968726, aNA.aNL(), false);
        aNA.aNL().addHeaderView(inflate);
        contentView = inflate.findViewById(2131821350);
        if (contentView == null) {
            c44941v = new C44941v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.m2505o(135146);
            throw c44941v;
        }
        boolean z2;
        ((TextView) contentView).setText(aNA.aNB());
        inflate.setOnLongClickListener(C19805g.iQI);
        aNA.aNL().setLoadingView(aNA.aNN().aNi());
        C38562h.m65318a(aNA, false);
        C38562h.m65319b(aNA, false);
        aNA.aNN();
        aNA.aNN().aNr();
        aNA.iQl.fQk = aNA.aNM().hbm;
        C27348b c27348b = aNA.iQl;
        if (aNA.aNM().hbl > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        c27348b.iQz = z2;
        aNA.aNM().hbs = new C38560f(aNA);
        if (aNA.aNM().axY().isEmpty() || !aNA.aNM().hbn) {
            z = false;
        }
        aNA.mo61280eL(z);
        if (!z) {
            C10922e.m18649pX(2);
        }
        aNA.aNL().setOnLoadingStateChangedListener(new C19806h(aNA));
        aNA.aNL().mo66332a((C41530m) aNA.iQw);
        aNA.iQo.aNG();
        aNA.iQk.notifyDataSetChanged();
        AppMethodBeat.m2505o(135146);
    }

    static {
        AppMethodBeat.m2504i(135143);
        AppMethodBeat.m2505o(135143);
    }

    public final void aMf() {
        AppMethodBeat.m2504i(135147);
        super.aMf();
        C4990ab.m7416i(TAG, "onTitleDoubleTap");
        aNA().aNL().smoothScrollToPosition(0);
        AppMethodBeat.m2505o(135147);
    }

    public final void onDestroyView() {
        AppMethodBeat.m2504i(135148);
        super.onDestroyView();
        C4990ab.m7416i(TAG, "onDestroyView");
        Lifecycle lifecycle = getLifecycle();
        C25052j.m39375o(lifecycle, "lifecycle");
        lifecycle.getCurrentState();
        AppMethodBeat.m2505o(135148);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(135149);
        super.onPause();
        C4990ab.m7416i(TAG, "onPause");
        AppMethodBeat.m2505o(135149);
    }
}
