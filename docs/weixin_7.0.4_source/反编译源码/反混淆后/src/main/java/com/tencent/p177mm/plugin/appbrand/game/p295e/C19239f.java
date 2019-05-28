package com.tencent.p177mm.plugin.appbrand.game.p295e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C42330af;
import com.tencent.p177mm.plugin.appbrand.game.p295e.p296a.C2162f;
import com.tencent.p177mm.plugin.appbrand.game.p295e.p296a.C33199e;
import com.tencent.p177mm.plugin.appbrand.game.p295e.p296a.C38221d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27069q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38255ar;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.C42470c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1225h.C26996a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C19460e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C19461f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C19462g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p308i.C45604f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C19407x;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C2298d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24699w;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33337c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33341k;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C10557i;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C10559j;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C2352h;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C46894f;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.f */
public final class C19239f {
    private static final String[] hsp = new String[]{C33341k.NAME, C24699w.NAME, C33337c.NAME, C19407x.NAME, C2298d.NAME};

    public static Map<String, C45608m> aAK() {
        AppMethodBeat.m2504i(130200);
        Map aCh = C27069q.aCh();
        aCh.putAll(C27069q.aCi());
        HashSet<C45608m> hashSet = new HashSet();
        hashSet.add(new C33199e());
        hashSet.add(new C2162f());
        hashSet.add(new C38221d());
        hashSet.add(new C38255ar());
        hashSet.add(new C19461f());
        hashSet.add(new C19460e());
        hashSet.add(new C19462g());
        hashSet.add(new C46894f());
        hashSet.add(new C10559j());
        hashSet.add(new C10557i());
        hashSet.add(new C2352h());
        hashSet.add(new C45562b());
        hashSet.add(new C26996a());
        hashSet.add(new C38224c());
        hashSet.add(new C42445d());
        hashSet.add(new C42446e());
        hashSet.add(new C42470c());
        hashSet.add(new C42444a());
        hashSet.add(new C45604f(C45604f.hRB, C42330af.auz()));
        for (C45608m c45608m : hashSet) {
            if (!(c45608m == null || C5046bo.isNullOrNil(c45608m.getName()))) {
                aCh.put(c45608m.getName(), c45608m);
            }
        }
        for (Object remove : hsp) {
            aCh.remove(remove);
        }
        AppMethodBeat.m2505o(130200);
        return aCh;
    }
}
