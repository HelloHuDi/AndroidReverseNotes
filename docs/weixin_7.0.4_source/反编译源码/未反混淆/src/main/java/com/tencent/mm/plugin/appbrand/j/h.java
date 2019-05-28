package com.tencent.mm.plugin.appbrand.j;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.j.a.d;
import com.tencent.mm.plugin.appbrand.r.i;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class h implements a {
    private final Set<String> inP = new HashSet();
    final i<String, a> inQ = new i();
    final b inR;
    private final Map<String, Boolean> inS = new HashMap();

    static class a {
        final a.b ioa;
        final com.tencent.mm.plugin.appbrand.j.a.a iob;

        public a(a.b bVar, com.tencent.mm.plugin.appbrand.j.a.a aVar) {
            this.ioa = bVar;
            this.iob = aVar;
        }
    }

    public h(b bVar) {
        AppMethodBeat.i(102157);
        this.inR = bVar;
        AppMethodBeat.o(102157);
    }

    public final boolean aIy() {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean aIz() {
        AppMethodBeat.i(102158);
        boolean a = a(this.inR.xZ().hhd);
        AppMethodBeat.o(102158);
        return a;
    }

    private boolean a(ModulePkgInfo modulePkgInfo) {
        AppMethodBeat.i(102159);
        boolean z = !bo.isNullOrNil(modulePkgInfo.gSP) && e.ct(modulePkgInfo.gSP);
        if (z) {
            if (!modulePkgInfo.cta) {
                CD("__APP__");
            }
            CD(modulePkgInfo.name);
        }
        AppMethodBeat.o(102159);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final void CD(String str) {
        AppMethodBeat.i(102160);
        synchronized (this.inS) {
            try {
                if (this.inS.containsKey(str)) {
                } else {
                    ((g) this.inR.xT()).xd(str);
                    this.inS.put(str, Boolean.TRUE);
                    ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "module (%s) injected", str);
                    AppMethodBeat.o(102160);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(102160);
            }
        }
    }

    public final void a(String str, boolean z, a.b bVar, com.tencent.mm.plugin.appbrand.j.a.a aVar) {
        AppMethodBeat.i(102161);
        if (this.inR.mFinished) {
            ab.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", str, this.inR.mAppId);
            bVar.a(d.FAIL);
            AppMethodBeat.o(102161);
            return;
        }
        j jVar = new j();
        Object CE = bo.isNullOrNil(str) ? this.inR.xZ().hhd : CE(str);
        jVar.value = CE;
        if (!a(CE) || bVar == null) {
            a((ModulePkgInfo) jVar.value, z, bVar, aVar);
            AppMethodBeat.o(102161);
            return;
        }
        bVar.a(d.OK);
        AppMethodBeat.o(102161);
    }

    public final void a(String str, boolean z, a.b bVar) {
        AppMethodBeat.i(102162);
        a(str, z, bVar, null);
        AppMethodBeat.o(102162);
    }

    private void a(ModulePkgInfo modulePkgInfo, boolean z, a.b bVar, com.tencent.mm.plugin.appbrand.j.a.a aVar) {
        boolean contains;
        AppMethodBeat.i(102163);
        final String str = modulePkgInfo.name;
        final boolean z2 = ("__APP__".equals(str) || modulePkgInfo.cta || aIz()) ? false : true;
        if (z2) {
            a(this.inR.xZ().hhd, false, null, null);
        }
        ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", modulePkgInfo.name, Boolean.valueOf(modulePkgInfo.cta), Boolean.valueOf(z2));
        a(str, bVar, aVar);
        synchronized (this.inP) {
            try {
                contains = this.inP.contains(str);
                if (!contains) {
                    this.inP.add(str);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(102163);
                }
            }
        }
        if (!contains) {
            final c cVar = new c();
            if (z2) {
                a("__APP__", new a.b() {
                    public final void a(d dVar) {
                        AppMethodBeat.i(102151);
                        cVar.K(null);
                        AppMethodBeat.o(102151);
                    }
                }, null);
            } else {
                cVar.K(null);
            }
            final j jVar = new j();
            if (z) {
                e a = new e().a(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(102152);
                        dialogInterface.dismiss();
                        h.a(h.this, str, d.CANCEL);
                        AppMethodBeat.o(102152);
                    }
                });
                a.x(this.inR);
                jVar.value = a;
            }
            f i = f.b.inO.i(this.inR, this.inR.xZ().hhd.xL(str));
            i.a(new com.tencent.mm.plugin.appbrand.j.f.a() {
                public final void ds(final String str) {
                    AppMethodBeat.i(102155);
                    ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", str, str);
                    cVar.K(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(102154);
                            int i = (bo.isNullOrNil(str) || (z2 && !h.this.aIz())) ? 0 : 1;
                            if (i != 0) {
                                if (!"__APP__".equals(str)) {
                                    Iterator it = h.this.inR.xZ().hhd.gVx.iterator();
                                    while (it.hasNext()) {
                                        ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                                        if (str.equals(modulePkgInfo.name)) {
                                            modulePkgInfo.gSP = str;
                                            break;
                                        }
                                    }
                                }
                                h.this.inR.xZ().hhd.gSP = str;
                                try {
                                    h.this.inR.xZ().hhd.cvZ = g.b(e.openRead(str), 4096);
                                } catch (FileNotFoundException e) {
                                    ab.e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", h.this.inR.mAppId);
                                }
                                aw.p(h.this.inR);
                                h.this.CD(str);
                            }
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(102153);
                                    if (jVar.value != null) {
                                        ((DialogInterface) jVar.value).dismiss();
                                    }
                                    AppMethodBeat.o(102153);
                                }
                            });
                            h.a(h.this, str, i != 0 ? d.OK : d.FAIL);
                            AppMethodBeat.o(102154);
                        }
                    });
                    AppMethodBeat.o(102155);
                }

                public final void a(d dVar) {
                    AppMethodBeat.i(102156);
                    ab.i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", dVar);
                    h hVar = h.this;
                    Set<a> bC = hVar.inQ.bC(str);
                    if (bC == null) {
                        AppMethodBeat.o(102156);
                        return;
                    }
                    for (a aVar : bC) {
                        if (aVar.iob != null) {
                            aVar.iob.b(dVar);
                        }
                    }
                    AppMethodBeat.o(102156);
                }
            });
            i.start();
        }
        AppMethodBeat.o(102163);
    }

    private void a(String str, a.b bVar, com.tencent.mm.plugin.appbrand.j.a.a aVar) {
        AppMethodBeat.i(102164);
        if (bVar == null && aVar == null) {
            AppMethodBeat.o(102164);
            return;
        }
        this.inQ.f(str, new a(bVar, aVar));
        AppMethodBeat.o(102164);
    }

    public final String CC(String str) {
        AppMethodBeat.i(102165);
        String str2 = CE(str).name;
        AppMethodBeat.o(102165);
        return str2;
    }

    public final ModulePkgInfo CE(String str) {
        AppMethodBeat.i(102166);
        ModulePkgInfo modulePkgInfo = this.inR.xZ().hhd;
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(102166);
            return modulePkgInfo;
        }
        String yk = l.yk(str);
        Iterator it = modulePkgInfo.gVx.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo2 = (ModulePkgInfo) it.next();
            if (yk.startsWith(modulePkgInfo2.name)) {
                AppMethodBeat.o(102166);
                return modulePkgInfo2;
            } else if (modulePkgInfo2.gSQ != null && modulePkgInfo2.gSQ.length > 0) {
                for (String startsWith : modulePkgInfo2.gSQ) {
                    if (yk.startsWith(startsWith)) {
                        AppMethodBeat.o(102166);
                        return modulePkgInfo2;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(102166);
        return modulePkgInfo;
    }
}
