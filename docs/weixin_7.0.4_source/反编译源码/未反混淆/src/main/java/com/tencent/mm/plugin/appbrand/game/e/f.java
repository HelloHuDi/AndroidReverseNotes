package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af;
import com.tencent.mm.plugin.appbrand.game.e.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.k;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.plugin.appbrand.jsapi.k.x;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.o.g;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.video.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Map;

public final class f {
    private static final String[] hsp = new String[]{k.NAME, w.NAME, c.NAME, x.NAME, d.NAME};

    public static Map<String, m> aAK() {
        AppMethodBeat.i(130200);
        Map aCh = q.aCh();
        aCh.putAll(q.aCi());
        HashSet<m> hashSet = new HashSet();
        hashSet.add(new e());
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.e.a.f());
        hashSet.add(new com.tencent.mm.plugin.appbrand.game.e.a.d());
        hashSet.add(new ar());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.o.f());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.o.e());
        hashSet.add(new g());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.video.f());
        hashSet.add(new j());
        hashSet.add(new i());
        hashSet.add(new h());
        hashSet.add(new b());
        hashSet.add(new a());
        hashSet.add(new c());
        hashSet.add(new d());
        hashSet.add(new e());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.appdownload.c());
        hashSet.add(new a());
        hashSet.add(new com.tencent.mm.plugin.appbrand.jsapi.i.f(com.tencent.mm.plugin.appbrand.jsapi.i.f.hRB, af.auz()));
        for (m mVar : hashSet) {
            if (!(mVar == null || bo.isNullOrNil(mVar.getName()))) {
                aCh.put(mVar.getName(), mVar);
            }
        }
        for (Object remove : hsp) {
            aCh.remove(remove);
        }
        AppMethodBeat.o(130200);
        return aCh;
    }
}
