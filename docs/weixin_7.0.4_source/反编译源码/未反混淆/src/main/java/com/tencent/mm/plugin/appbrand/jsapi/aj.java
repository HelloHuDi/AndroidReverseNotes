package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public class aj extends u<q> {
    public static final int CTRL_INDEX = 466;
    public static final String NAME = "getMenuButtonBoundingClientRect";

    protected enum a {
        JSThread,
        UIThread;

        static {
            AppMethodBeat.o(114325);
        }
    }

    public /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(114328);
        String c = c((q) cVar);
        AppMethodBeat.o(114328);
        return c;
    }

    public String c(q qVar) {
        AppMethodBeat.i(114326);
        String str = (String) d(qVar).first;
        AppMethodBeat.o(114326);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final Pair<String, a> d(q qVar) {
        AppMethodBeat.i(114327);
        try {
            u currentPageView;
            if (qVar instanceof q) {
                currentPageView = qVar.getCurrentPageView();
            } else {
                currentPageView = null;
            }
            if (currentPageView == null) {
                IllegalStateException illegalStateException = new IllegalStateException("fail:page don't exist");
                AppMethodBeat.o(114327);
                throw illegalStateException;
            }
            HashMap hashMap = new HashMap();
            int[] iArr = new int[2];
            currentPageView.getActionBar().getCapsuleView().getLocationInWindow(iArr);
            int qa = g.qa(currentPageView.getActionBar().getCapsuleView().getWidth());
            int qa2 = g.qa(currentPageView.getActionBar().getCapsuleView().getHeight());
            int qa3 = g.qa(iArr[1]);
            int qa4 = g.qa(iArr[0]);
            int i = qa4 + qa;
            int i2 = qa3 + qa2;
            hashMap.put("width", Integer.valueOf(qa));
            hashMap.put("height", Integer.valueOf(qa2));
            hashMap.put("top", Integer.valueOf(qa3));
            hashMap.put("right", Integer.valueOf(i));
            hashMap.put("bottom", Integer.valueOf(i2));
            hashMap.put("left", Integer.valueOf(qa4));
            ab.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getMenuButtonBoundingClientRect: return on JSThread appId[%s] ret[%s]", qVar.getAppId(), j("ok", hashMap));
            Pair<String, a> create = Pair.create(r1, a.JSThread);
            AppMethodBeat.o(114327);
            return create;
        } catch (Exception e) {
            Pair create2 = Pair.create(j(e.getMessage(), null), a.JSThread);
            AppMethodBeat.o(114327);
            return create2;
        }
    }
}
