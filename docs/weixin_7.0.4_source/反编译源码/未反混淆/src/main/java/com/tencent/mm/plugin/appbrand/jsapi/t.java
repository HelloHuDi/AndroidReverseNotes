package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public class t extends p {
    private static final int CTRL_INDEX = 494;
    private static final String NAME = "onViewDidResize";

    public final void a(u uVar, int i, int i2, int i3, int i4, int i5, int i6, Map<String, Object> map) {
        AppMethodBeat.i(101940);
        HashMap hashMap = new HashMap(1);
        hashMap.put("windowWidth", Integer.valueOf(g.pZ(i2)));
        hashMap.put("windowHeight", Integer.valueOf(g.pZ(i3)));
        hashMap.put("screenWidth", Integer.valueOf(g.pZ(i4)));
        hashMap.put("screenHeight", Integer.valueOf(g.pZ(i5)));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("size", hashMap);
        hashMap2.put("changedWebviewIds", new int[]{i});
        if (i6 == 2) {
            hashMap2.put("deviceOrientation", "landscape");
        } else if (i6 == 1) {
            hashMap2.put("deviceOrientation", "portrait");
        }
        hashMap2.put("pageOrientation", new HashMap(map));
        String obj = h.j(hashMap2).toString();
        ab.i("MicroMsg.AppBrandOnViewDidResize", "dispatch with page(%s:%s) data(%s)", uVar.getAppId(), uVar.getURL(), obj);
        AL(obj).b(uVar, uVar.hashCode()).aCj();
        AL(obj).b(uVar.xT(), uVar.hashCode()).aCj();
        AppMethodBeat.o(101940);
    }
}
