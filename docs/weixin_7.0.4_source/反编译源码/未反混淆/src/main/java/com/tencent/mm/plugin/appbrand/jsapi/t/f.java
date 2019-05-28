package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.y;
import org.json.JSONObject;

public final class f extends a<w> {
    public static final int CTRL_INDEX = 298;
    public static final String NAME = "insertHTMLWebView";

    public final /* synthetic */ View a(e eVar, JSONObject jSONObject) {
        AppMethodBeat.i(131675);
        final w wVar = (w) eVar;
        if (wVar.aJS() != null) {
            AppMethodBeat.o(131675);
            return null;
        }
        wVar.f(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131669);
                y yVar = wVar.isK;
                yVar.setPullDownEnabled(true);
                yVar.dO(false);
                yVar.bq("light", com.tencent.mm.bz.a.i(wVar.mContext, R.color.a5v));
                wVar.aJE();
                wVar.getActionBar().a(new com.tencent.mm.plugin.appbrand.widget.actionbar.a() {
                    public final void aGw() {
                        AppMethodBeat.i(131668);
                        a aJS = wVar.aJS();
                        if (aJS != null) {
                            aJS.fow.getView().scrollTo(aJS.fow.getWebScrollX(), 0);
                        }
                        AppMethodBeat.o(131668);
                    }
                });
                AppMethodBeat.o(131669);
            }
        });
        final View aVar = new a(wVar.mContext, wVar.getRuntime(), wVar);
        aVar.setId(R.id.a2);
        wVar.iqN.hvY.add(new com.tencent.mm.plugin.appbrand.jsapi.f.a() {
            public final boolean wY() {
                AppMethodBeat.i(131670);
                a aVar = aVar;
                if (aVar.getWebView().canGoBack()) {
                    aVar.getReporter().a(aVar.hyU, true);
                    aVar.getWebView().goBack();
                    aVar.icn = true;
                    AppMethodBeat.o(131670);
                    return true;
                }
                aVar.getReporter().a(aVar.hyU, false);
                AppMethodBeat.o(131670);
                return false;
            }
        });
        wVar.a((d) new d() {
            public final void wU() {
                AppMethodBeat.i(131671);
                aVar.getWebView().onResume();
                AppMethodBeat.o(131671);
            }
        });
        wVar.a((b) new b() {
            public final void wW() {
                AppMethodBeat.i(131672);
                aVar.getWebView().onPause();
                AppMethodBeat.o(131672);
            }
        });
        AppMethodBeat.o(131675);
        return aVar;
    }

    public final int r(JSONObject jSONObject) {
        AppMethodBeat.i(131673);
        int i = jSONObject.getInt("htmlId");
        AppMethodBeat.o(131673);
        return i;
    }

    public final /* synthetic */ void a(e eVar, int i, View view, JSONObject jSONObject) {
        AppMethodBeat.i(131674);
        ((a) view).setViewId(i);
        AppMethodBeat.o(131674);
    }
}
