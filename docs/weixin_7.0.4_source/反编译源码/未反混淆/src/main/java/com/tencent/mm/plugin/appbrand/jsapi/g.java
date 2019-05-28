package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g implements f {
    public final Set<e> hvU = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<b> hvV = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<d> hvW = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<c> hvX = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<a> hvY = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<f> hvZ = Collections.newSetFromMap(new ConcurrentHashMap());

    public g() {
        AppMethodBeat.i(91017);
        AppMethodBeat.o(91017);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(91018);
        this.hvZ.add(fVar);
        AppMethodBeat.o(91018);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(91019);
        this.hvU.add(eVar);
        AppMethodBeat.o(91019);
    }

    public final void b(e eVar) {
        AppMethodBeat.i(91020);
        this.hvU.remove(eVar);
        AppMethodBeat.o(91020);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(91021);
        this.hvV.add(bVar);
        AppMethodBeat.o(91021);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(91022);
        this.hvV.remove(bVar);
        AppMethodBeat.o(91022);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(91023);
        this.hvW.add(dVar);
        AppMethodBeat.o(91023);
    }

    public final void b(d dVar) {
        AppMethodBeat.i(91024);
        this.hvW.remove(dVar);
        AppMethodBeat.o(91024);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(91025);
        this.hvX.add(cVar);
        AppMethodBeat.o(91025);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(91026);
        this.hvX.remove(cVar);
        AppMethodBeat.o(91026);
    }
}
