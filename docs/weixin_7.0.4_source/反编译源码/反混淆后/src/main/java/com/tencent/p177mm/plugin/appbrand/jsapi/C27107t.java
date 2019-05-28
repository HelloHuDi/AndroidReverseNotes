package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t */
public class C27107t extends C38369p {
    private static final int CTRL_INDEX = 494;
    private static final String NAME = "onViewDidResize";

    /* renamed from: a */
    public final void mo44764a(C44709u c44709u, int i, int i2, int i3, int i4, int i5, int i6, Map<String, Object> map) {
        AppMethodBeat.m2504i(101940);
        HashMap hashMap = new HashMap(1);
        hashMap.put("windowWidth", Integer.valueOf(C42668g.m75569pZ(i2)));
        hashMap.put("windowHeight", Integer.valueOf(C42668g.m75569pZ(i3)));
        hashMap.put("screenWidth", Integer.valueOf(C42668g.m75569pZ(i4)));
        hashMap.put("screenHeight", Integer.valueOf(C42668g.m75569pZ(i5)));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("size", hashMap);
        hashMap2.put("changedWebviewIds", new int[]{i});
        if (i6 == 2) {
            hashMap2.put("deviceOrientation", "landscape");
        } else if (i6 == 1) {
            hashMap2.put("deviceOrientation", "portrait");
        }
        hashMap2.put("pageOrientation", new HashMap(map));
        String obj = C41725h.m73455j(hashMap2).toString();
        C4990ab.m7417i("MicroMsg.AppBrandOnViewDidResize", "dispatch with page(%s:%s) data(%s)", c44709u.getAppId(), c44709u.getURL(), obj);
        mo61027AL(obj).mo61030b(c44709u, c44709u.hashCode()).aCj();
        mo61027AL(obj).mo61030b(c44709u.mo44926xT(), c44709u.hashCode()).aCj();
        AppMethodBeat.m2505o(101940);
    }
}
