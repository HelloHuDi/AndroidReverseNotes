package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import a.y;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.recents.e;

@l(dWo = {1, 1, 13}, dWp = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0003\u001a\u0018\u0010\u000e\u001a\u00020\r*\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010\u001a\u0012\u0010\u0011\u001a\u00020\r*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007¨\u0006\u0015"}, dWq = {"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
public final class h {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ a.f.a.a hbA;

        a(a.f.a.a aVar) {
            this.hbA = aVar;
        }

        public final void run() {
            AppMethodBeat.i(135202);
            this.hbA.invoke();
            AppMethodBeat.o(135202);
        }
    }

    public static final void a(g gVar, boolean z) {
        AppMethodBeat.i(135203);
        j.p(gVar, "receiver$0");
        gVar.aNL().fh(z);
        AppMethodBeat.o(135203);
    }

    public static final void b(g gVar, boolean z) {
        AppMethodBeat.i(135204);
        j.p(gVar, "receiver$0");
        if (!z) {
            h(gVar);
        }
        gVar.aNN().eJ(z);
        AppMethodBeat.o(135204);
    }

    private static void a(e eVar, String str) {
        AppMethodBeat.i(135206);
        j.p(eVar, "receiver$0");
        j.p(str, "wording");
        View findViewById = eVar.apJ.findViewById(R.id.ug);
        j.o(findViewById, "this.itemView.findViewBy…ents_list_footer_wording)");
        ((TextView) findViewById).setText(str);
        AppMethodBeat.o(135206);
    }

    public static final void h(g gVar) {
        AppMethodBeat.i(135205);
        j.p(gVar, "receiver$0");
        e aNN;
        String an;
        if (gVar.iQk.aND().isEmpty()) {
            aNN = gVar.aNN();
            an = com.tencent.mm.bz.a.an(gVar.context, R.string.g59);
            j.o(an, "ResourceHelper.getString…ommend_null_list_wording)");
            a(aNN, an);
            AppMethodBeat.o(135205);
            return;
        }
        aNN = gVar.aNN();
        an = com.tencent.mm.bz.a.an(gVar.context, R.string.kk);
        j.o(an, "ResourceHelper.getString…ents_list_footer_no_more)");
        a(aNN, an);
        AppMethodBeat.o(135205);
    }

    public static final void a(g gVar, a.f.a.a<y> aVar) {
        AppMethodBeat.i(135207);
        j.p(gVar, "receiver$0");
        j.p(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        gVar.activity.runOnUiThread(new a(aVar));
        AppMethodBeat.o(135207);
    }
}
