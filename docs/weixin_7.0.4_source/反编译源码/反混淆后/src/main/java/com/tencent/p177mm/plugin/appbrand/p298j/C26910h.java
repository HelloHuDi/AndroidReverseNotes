package com.tencent.p177mm.plugin.appbrand.p298j;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f.C19252a;
import com.tencent.p177mm.plugin.appbrand.p298j.C19251f.C19253b;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C10278d;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C42456a;
import com.tencent.p177mm.plugin.appbrand.p298j.C42458a.C42457b;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p328r.C27277i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.j.h */
public final class C26910h implements C42458a {
    private final Set<String> inP = new HashSet();
    final C27277i<String, C19254a> inQ = new C27277i();
    final C25697b inR;
    private final Map<String, Boolean> inS = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.j.h$a */
    static class C19254a {
        final C42457b ioa;
        final C42456a iob;

        public C19254a(C42457b c42457b, C42456a c42456a) {
            this.ioa = c42457b;
            this.iob = c42456a;
        }
    }

    public C26910h(C25697b c25697b) {
        AppMethodBeat.m2504i(102157);
        this.inR = c25697b;
        AppMethodBeat.m2505o(102157);
    }

    public final boolean aIy() {
        return true;
    }

    /* Access modifiers changed, original: final */
    public final boolean aIz() {
        AppMethodBeat.m2504i(102158);
        boolean a = m42851a(this.inR.mo43489xZ().hhd);
        AppMethodBeat.m2505o(102158);
        return a;
    }

    /* renamed from: a */
    private boolean m42851a(ModulePkgInfo modulePkgInfo) {
        AppMethodBeat.m2504i(102159);
        boolean z = !C5046bo.isNullOrNil(modulePkgInfo.gSP) && C5730e.m8628ct(modulePkgInfo.gSP);
        if (z) {
            if (!modulePkgInfo.cta) {
                mo44654CD("__APP__");
            }
            mo44654CD(modulePkgInfo.name);
        }
        AppMethodBeat.m2505o(102159);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: CD */
    public final void mo44654CD(String str) {
        AppMethodBeat.m2504i(102160);
        synchronized (this.inS) {
            try {
                if (this.inS.containsKey(str)) {
                } else {
                    ((C26909g) this.inR.mo15032xT()).mo34956xd(str);
                    this.inS.put(str, Boolean.TRUE);
                    C4990ab.m7417i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "module (%s) injected", str);
                    AppMethodBeat.m2505o(102160);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(102160);
            }
        }
    }

    /* renamed from: a */
    public final void mo44657a(String str, boolean z, C42457b c42457b, C42456a c42456a) {
        AppMethodBeat.m2504i(102161);
        if (this.inR.mFinished) {
            C4990ab.m7413e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", str, this.inR.mAppId);
            c42457b.mo44661a(C10278d.FAIL);
            AppMethodBeat.m2505o(102161);
            return;
        }
        C19681j c19681j = new C19681j();
        Object CE = C5046bo.isNullOrNil(str) ? this.inR.mo43489xZ().hhd : mo44655CE(str);
        c19681j.value = CE;
        if (!m42851a(CE) || c42457b == null) {
            m42848a((ModulePkgInfo) c19681j.value, z, c42457b, c42456a);
            AppMethodBeat.m2505o(102161);
            return;
        }
        c42457b.mo44661a(C10278d.OK);
        AppMethodBeat.m2505o(102161);
    }

    /* renamed from: a */
    public final void mo44656a(String str, boolean z, C42457b c42457b) {
        AppMethodBeat.m2504i(102162);
        mo44657a(str, z, c42457b, null);
        AppMethodBeat.m2505o(102162);
    }

    /* renamed from: a */
    private void m42848a(ModulePkgInfo modulePkgInfo, boolean z, C42457b c42457b, C42456a c42456a) {
        boolean contains;
        AppMethodBeat.m2504i(102163);
        final String str = modulePkgInfo.name;
        final boolean z2 = ("__APP__".equals(str) || modulePkgInfo.cta || aIz()) ? false : true;
        if (z2) {
            m42848a(this.inR.mo43489xZ().hhd, false, null, null);
        }
        C4990ab.m7417i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", modulePkgInfo.name, Boolean.valueOf(modulePkgInfo.cta), Boolean.valueOf(z2));
        m42850a(str, c42457b, c42456a);
        synchronized (this.inP) {
            try {
                contains = this.inP.contains(str);
                if (!contains) {
                    this.inP.add(str);
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(102163);
                }
            }
        }
        if (!contains) {
            final C38245c c38245c = new C38245c();
            if (z2) {
                m42850a("__APP__", new C42457b() {
                    /* renamed from: a */
                    public final void mo44661a(C10278d c10278d) {
                        AppMethodBeat.m2504i(102151);
                        c38245c.mo60983K(null);
                        AppMethodBeat.m2505o(102151);
                    }
                }, null);
            } else {
                c38245c.mo60983K(null);
            }
            final C19681j c19681j = new C19681j();
            if (z) {
                C10281e a = new C10281e().mo21725a(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(102152);
                        dialogInterface.dismiss();
                        C26910h.m42849a(C26910h.this, str, C10278d.CANCEL);
                        AppMethodBeat.m2505o(102152);
                    }
                });
                a.mo21728x(this.inR);
                c19681j.value = a;
            }
            C19251f i = C19253b.inO.mo34457i(this.inR, this.inR.mo43489xZ().hhd.mo53645xL(str));
            i.mo34453a(new C19252a() {
                /* renamed from: ds */
                public final void mo34456ds(final String str) {
                    AppMethodBeat.m2504i(102155);
                    C4990ab.m7417i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "onLoad, module(%s) pkgPath(%s)", str, str);
                    c38245c.mo60983K(new Runnable() {

                        /* renamed from: com.tencent.mm.plugin.appbrand.j.h$3$1$1 */
                        class C21751 implements Runnable {
                            C21751() {
                            }

                            public final void run() {
                                AppMethodBeat.m2504i(102153);
                                if (c19681j.value != null) {
                                    ((DialogInterface) c19681j.value).dismiss();
                                }
                                AppMethodBeat.m2505o(102153);
                            }
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(102154);
                            int i = (C5046bo.isNullOrNil(str) || (z2 && !C26910h.this.aIz())) ? 0 : 1;
                            if (i != 0) {
                                if (!"__APP__".equals(str)) {
                                    Iterator it = C26910h.this.inR.mo43489xZ().hhd.gVx.iterator();
                                    while (it.hasNext()) {
                                        ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                                        if (str.equals(modulePkgInfo.name)) {
                                            modulePkgInfo.gSP = str;
                                            break;
                                        }
                                    }
                                }
                                C26910h.this.inR.mo43489xZ().hhd.gSP = str;
                                try {
                                    C26910h.this.inR.mo43489xZ().hhd.cvZ = C1178g.m2585b(C5730e.openRead(str), 4096);
                                } catch (FileNotFoundException e) {
                                    C4990ab.m7413e("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loaded __APP__, appId = %s, pkg not found", C26910h.this.inR.mAppId);
                                }
                                C33082aw.m54075p(C26910h.this.inR);
                                C26910h.this.mo44654CD(str);
                            }
                            C5004al.m7441d(new C21751());
                            C26910h.m42849a(C26910h.this, str, i != 0 ? C10278d.OK : C10278d.FAIL);
                            AppMethodBeat.m2505o(102154);
                        }
                    });
                    AppMethodBeat.m2505o(102155);
                }

                /* renamed from: a */
                public final void mo34455a(C45569d c45569d) {
                    AppMethodBeat.m2504i(102156);
                    C4990ab.m7417i("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "hy: on load module progress %s", c45569d);
                    C26910h c26910h = C26910h.this;
                    Set<C19254a> bC = c26910h.inQ.mo44961bC(str);
                    if (bC == null) {
                        AppMethodBeat.m2505o(102156);
                        return;
                    }
                    for (C19254a c19254a : bC) {
                        if (c19254a.iob != null) {
                            c19254a.iob.mo34550b(c45569d);
                        }
                    }
                    AppMethodBeat.m2505o(102156);
                }
            });
            i.start();
        }
        AppMethodBeat.m2505o(102163);
    }

    /* renamed from: a */
    private void m42850a(String str, C42457b c42457b, C42456a c42456a) {
        AppMethodBeat.m2504i(102164);
        if (c42457b == null && c42456a == null) {
            AppMethodBeat.m2505o(102164);
            return;
        }
        this.inQ.mo44963f(str, new C19254a(c42457b, c42456a));
        AppMethodBeat.m2505o(102164);
    }

    /* renamed from: CC */
    public final String mo44653CC(String str) {
        AppMethodBeat.m2504i(102165);
        String str2 = mo44655CE(str).name;
        AppMethodBeat.m2505o(102165);
        return str2;
    }

    /* renamed from: CE */
    public final ModulePkgInfo mo44655CE(String str) {
        AppMethodBeat.m2504i(102166);
        ModulePkgInfo modulePkgInfo = this.inR.mo43489xZ().hhd;
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(102166);
            return modulePkgInfo;
        }
        String yk = C42367l.m74946yk(str);
        Iterator it = modulePkgInfo.gVx.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo2 = (ModulePkgInfo) it.next();
            if (yk.startsWith(modulePkgInfo2.name)) {
                AppMethodBeat.m2505o(102166);
                return modulePkgInfo2;
            } else if (modulePkgInfo2.gSQ != null && modulePkgInfo2.gSQ.length > 0) {
                for (String startsWith : modulePkgInfo2.gSQ) {
                    if (yk.startsWith(startsWith)) {
                        AppMethodBeat.m2505o(102166);
                        return modulePkgInfo2;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(102166);
        return modulePkgInfo;
    }
}
