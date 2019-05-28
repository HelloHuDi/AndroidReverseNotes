package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.view.View;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.p336ui.recents.C33563e;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0003\u001a\u0018\u0010\u000e\u001a\u00020\r*\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010\u001a\u0012\u0010\u0011\u001a\u00020\r*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007¨\u0006\u0015"}, dWq = {"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.h */
public final class C38562h {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.h$a */
    static final class C38563a implements Runnable {
        final /* synthetic */ C31214a hbA;

        C38563a(C31214a c31214a) {
            this.hbA = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(135202);
            this.hbA.invoke();
            AppMethodBeat.m2505o(135202);
        }
    }

    /* renamed from: a */
    public static final void m65318a(C38556g c38556g, boolean z) {
        AppMethodBeat.m2504i(135203);
        C25052j.m39376p(c38556g, "receiver$0");
        c38556g.aNL().mo22757fh(z);
        AppMethodBeat.m2505o(135203);
    }

    /* renamed from: b */
    public static final void m65319b(C38556g c38556g, boolean z) {
        AppMethodBeat.m2504i(135204);
        C25052j.m39376p(c38556g, "receiver$0");
        if (!z) {
            C38562h.m65320h(c38556g);
        }
        c38556g.aNN().mo54046eJ(z);
        AppMethodBeat.m2505o(135204);
    }

    /* renamed from: a */
    private static void m65316a(C33563e c33563e, String str) {
        AppMethodBeat.m2504i(135206);
        C25052j.m39376p(c33563e, "receiver$0");
        C25052j.m39376p(str, "wording");
        View findViewById = c33563e.apJ.findViewById(2131821327);
        C25052j.m39375o(findViewById, "this.itemView.findViewBy…ents_list_footer_wording)");
        ((TextView) findViewById).setText(str);
        AppMethodBeat.m2505o(135206);
    }

    /* renamed from: h */
    public static final void m65320h(C38556g c38556g) {
        AppMethodBeat.m2504i(135205);
        C25052j.m39376p(c38556g, "receiver$0");
        C33563e aNN;
        String an;
        if (c38556g.iQk.aND().isEmpty()) {
            aNN = c38556g.aNN();
            an = C1338a.m2858an(c38556g.context, C25738R.string.g59);
            C25052j.m39375o(an, "ResourceHelper.getString…ommend_null_list_wording)");
            C38562h.m65316a(aNN, an);
            AppMethodBeat.m2505o(135205);
            return;
        }
        aNN = c38556g.aNN();
        an = C1338a.m2858an(c38556g.context, C25738R.string.f8951kk);
        C25052j.m39375o(an, "ResourceHelper.getString…ents_list_footer_no_more)");
        C38562h.m65316a(aNN, an);
        AppMethodBeat.m2505o(135205);
    }

    /* renamed from: a */
    public static final void m65317a(C38556g c38556g, C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(135207);
        C25052j.m39376p(c38556g, "receiver$0");
        C25052j.m39376p(c31214a, NativeProtocol.WEB_DIALOG_ACTION);
        c38556g.activity.runOnUiThread(new C38563a(c31214a));
        AppMethodBeat.m2505o(135207);
    }
}
