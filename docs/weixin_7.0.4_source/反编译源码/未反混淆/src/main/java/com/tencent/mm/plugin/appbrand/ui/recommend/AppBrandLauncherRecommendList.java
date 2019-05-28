package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f;
import a.f.a.m;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.i;
import a.i.k;
import a.l;
import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherUI$Fragment;", "()V", "uiLogic", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getUiLogic", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "uiLogic$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onTitleDoubleTap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherRecommendList extends Fragment {
    private static final String TAG = TAG;
    static final /* synthetic */ k[] eQB = new k[]{v.a(new t(v.aN(AppBrandLauncherRecommendList.class), "uiLogic", "getUiLogic()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;"))};
    public static final a iPt = new a();
    private final f iPs = i.g(new b(this));

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, dWq = {"<anonymous>", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1", "invoke", "()Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandLauncherRecommendList$uiLogic$2$1;"})
    static final class b extends a.f.b.k implements a.f.a.a<AnonymousClass1> {
        final /* synthetic */ AppBrandLauncherRecommendList iPu;

        b(AppBrandLauncherRecommendList appBrandLauncherRecommendList) {
            this.iPu = appBrandLauncherRecommendList;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(135142);
            FragmentActivity activity = this.iPu.getActivity();
            if (activity == null) {
                a.v vVar = new a.v("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(135142);
                throw vVar;
            }
            AnonymousClass1 anonymousClass1 = new g(this, activity) {
                private final boolean fsQ = true;
                final /* synthetic */ b iPw;

                public final String aNB() {
                    AppMethodBeat.i(135140);
                    String string = this.iPw.iPu.getString(R.string.g58);
                    j.o(string, "this@AppBrandLauncherRec…header_text_all_use_hint)");
                    AppMethodBeat.o(135140);
                    return string;
                }

                public final View getContentView() {
                    AppMethodBeat.i(135141);
                    View contentView = this.iPw.iPu.getContentView();
                    AppMethodBeat.o(135141);
                    return contentView;
                }

                public final boolean aNC() {
                    return this.fsQ;
                }
            };
            AppMethodBeat.o(135142);
            return anonymousClass1;
        }
    }

    private final g aNA() {
        AppMethodBeat.i(135144);
        g gVar = (g) this.iPs.getValue();
        AppMethodBeat.o(135144);
        return gVar;
    }

    public AppBrandLauncherRecommendList() {
        AppMethodBeat.i(135150);
        AppMethodBeat.o(135150);
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(135145);
        super.onCreate(bundle);
        ab.i(TAG, "onCreate");
        getLifecycle().addObserver(aNA());
        AppMethodBeat.o(135145);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.i(135146);
        g aNA = aNA();
        aNA.aNL().setLayoutManager(aNA.iQm);
        View contentView = aNA.getContentView();
        a.v vVar;
        if (contentView == null) {
            vVar = new a.v("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(135146);
            throw vVar;
        }
        ((FrameLayout) contentView).addView(aNA.aNL(), new LayoutParams(-1, -1));
        aNA.iQk.jR();
        a aVar = aNA.iQk;
        m mVar = new m(aNA);
        j.p(mVar, "<set-?>");
        aVar.iPy = mVar;
        aVar = aNA.iQk;
        mVar = new n(aNA);
        j.p(mVar, "<set-?>");
        aVar.iPA = mVar;
        aVar = aNA.iQk;
        mVar = new o(aNA);
        j.p(mVar, "<set-?>");
        aVar.iPz = mVar;
        aNA.aNL().setAdapter(aNA.iQk);
        if (aNA.aNC()) {
            aNA.aNL().addHeaderView(aNA.iQn.aNi());
            contentView = aNA.iQn.aNi();
            if (contentView != null) {
                contentView.setVisibility(8);
            }
            aNA.iQn.aNh();
            aNA.iQn.pS(0);
            aNA.iQn.pT(0);
        }
        View inflate = LayoutInflater.from(aNA.context).inflate(R.layout.dc, aNA.aNL(), false);
        aNA.aNL().addHeaderView(inflate);
        contentView = inflate.findViewById(R.id.v3);
        if (contentView == null) {
            vVar = new a.v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(135146);
            throw vVar;
        }
        boolean z2;
        ((TextView) contentView).setText(aNA.aNB());
        inflate.setOnLongClickListener(g.iQI);
        aNA.aNL().setLoadingView(aNA.aNN().aNi());
        h.a(aNA, false);
        h.b(aNA, false);
        aNA.aNN();
        aNA.aNN().aNr();
        aNA.iQl.fQk = aNA.aNM().hbm;
        com.tencent.mm.plugin.appbrand.ui.recommend.g.b bVar = aNA.iQl;
        if (aNA.aNM().hbl > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        bVar.iQz = z2;
        aNA.aNM().hbs = new f(aNA);
        if (aNA.aNM().axY().isEmpty() || !aNA.aNM().hbn) {
            z = false;
        }
        aNA.eL(z);
        if (!z) {
            e.pX(2);
        }
        aNA.aNL().setOnLoadingStateChangedListener(new h(aNA));
        aNA.aNL().a((RecyclerView.m) aNA.iQw);
        aNA.iQo.aNG();
        aNA.iQk.notifyDataSetChanged();
        AppMethodBeat.o(135146);
    }

    static {
        AppMethodBeat.i(135143);
        AppMethodBeat.o(135143);
    }

    public final void aMf() {
        AppMethodBeat.i(135147);
        super.aMf();
        ab.i(TAG, "onTitleDoubleTap");
        aNA().aNL().smoothScrollToPosition(0);
        AppMethodBeat.o(135147);
    }

    public final void onDestroyView() {
        AppMethodBeat.i(135148);
        super.onDestroyView();
        ab.i(TAG, "onDestroyView");
        Lifecycle lifecycle = getLifecycle();
        j.o(lifecycle, "lifecycle");
        lifecycle.getCurrentState();
        AppMethodBeat.o(135148);
    }

    public final void onPause() {
        AppMethodBeat.i(135149);
        super.onPause();
        ab.i(TAG, "onPause");
        AppMethodBeat.o(135149);
    }
}
