package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.aj */
public class C45571aj extends C19497u<C38492q> {
    public static final int CTRL_INDEX = 466;
    public static final String NAME = "getMenuButtonBoundingClientRect";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.aj$a */
    protected enum C2201a {
        JSThread,
        UIThread;

        static {
            AppMethodBeat.m2505o(114325);
        }
    }

    /* renamed from: b */
    public /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(114328);
        String c = mo34479c((C38492q) c2241c);
        AppMethodBeat.m2505o(114328);
        return c;
    }

    /* renamed from: c */
    public String mo34479c(C38492q c38492q) {
        AppMethodBeat.m2504i(114326);
        String str = (String) mo73377d(c38492q).first;
        AppMethodBeat.m2505o(114326);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: d */
    public final Pair<String, C2201a> mo73377d(C38492q c38492q) {
        AppMethodBeat.m2504i(114327);
        try {
            C44709u currentPageView;
            if (c38492q instanceof C38492q) {
                currentPageView = c38492q.getCurrentPageView();
            } else {
                currentPageView = null;
            }
            if (currentPageView == null) {
                IllegalStateException illegalStateException = new IllegalStateException("fail:page don't exist");
                AppMethodBeat.m2505o(114327);
                throw illegalStateException;
            }
            HashMap hashMap = new HashMap();
            int[] iArr = new int[2];
            currentPageView.getActionBar().getCapsuleView().getLocationInWindow(iArr);
            int qa = C42668g.m75570qa(currentPageView.getActionBar().getCapsuleView().getWidth());
            int qa2 = C42668g.m75570qa(currentPageView.getActionBar().getCapsuleView().getHeight());
            int qa3 = C42668g.m75570qa(iArr[1]);
            int qa4 = C42668g.m75570qa(iArr[0]);
            int i = qa4 + qa;
            int i2 = qa3 + qa2;
            hashMap.put("width", Integer.valueOf(qa));
            hashMap.put("height", Integer.valueOf(qa2));
            hashMap.put("top", Integer.valueOf(qa3));
            hashMap.put("right", Integer.valueOf(i));
            hashMap.put("bottom", Integer.valueOf(i2));
            hashMap.put("left", Integer.valueOf(qa4));
            C4990ab.m7417i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getMenuButtonBoundingClientRect: return on JSThread appId[%s] ret[%s]", c38492q.getAppId(), mo73394j("ok", hashMap));
            Pair<String, C2201a> create = Pair.create(r1, C2201a.JSThread);
            AppMethodBeat.m2505o(114327);
            return create;
        } catch (Exception e) {
            Pair create2 = Pair.create(mo73394j(e.getMessage(), null), C2201a.JSThread);
            AppMethodBeat.m2505o(114327);
            return create2;
        }
    }
}
