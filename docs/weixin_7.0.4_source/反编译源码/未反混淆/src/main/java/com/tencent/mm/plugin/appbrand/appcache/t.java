package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public enum t implements b {
    ;
    
    private int gTl;
    private String gTm;

    private t(String str) {
        this.gTl = -1;
        this.gTm = null;
    }

    static {
        AppMethodBeat.o(129396);
    }

    /* Access modifiers changed, original: final */
    public final void E(int i, String str) {
        this.gTl = i;
        this.gTm = str;
    }

    public final void dy(boolean z) {
        AppMethodBeat.i(129395);
        Pair p = as.p(z, true);
        if (p.second != null) {
            AppMethodBeat.o(129395);
            return;
        }
        if (p.first == a.gUM) {
            final at a = f.auV().a("@LibraryAppId", z ? 0 : 999, "downloadURL", "version");
            if (!(a == null || bo.isNullOrNil(a.field_downloadURL))) {
                int i;
                if (z) {
                    i = a.field_version;
                } else {
                    i = 0;
                }
                az.a anonymousClass1 = new az.a() {
                    public final /* bridge */ /* synthetic */ void bl(Object obj) {
                    }

                    public final /* synthetic */ void a(String str, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, Object obj) {
                        AppMethodBeat.i(129391);
                        if (com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK == aVar) {
                            h.pN(2);
                        }
                        AppMethodBeat.o(129391);
                    }
                };
                if (z) {
                    if (this.gTl > 0 && !bo.isNullOrNil(this.gTm)) {
                        ab.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] lib can be patch, abtest open %b", Boolean.valueOf(r.avE()));
                        if (r.avE()) {
                            if (as.v("@LibraryAppId", 0, this.gTl).first == a.gUI) {
                                ab.i("MicroMsg.AppBrand.PkgDownloadService", "[incremental] start incremental lib download");
                                p.a("@LibraryAppId", this.gTl, a.field_version, this.gTm, anonymousClass1);
                                AppMethodBeat.o(129395);
                                return;
                            }
                            ab.e("MicroMsg.AppBrand.PkgDownloadService", "[incremental] OldLibPkg[%d] or PatchUrl[%s] Invalid", Integer.valueOf(this.gTl), this.gTm);
                        }
                    }
                    az.a(a.field_downloadURL, a.field_version, anonymousClass1);
                    AppMethodBeat.o(129395);
                    return;
                }
                az.a("@LibraryAppId", 999, a.field_downloadURL, anonymousClass1, new com.tencent.mm.plugin.appbrand.appcache.a.a.a() {
                    public final String avJ() {
                        AppMethodBeat.i(129392);
                        String str = "_" + a.field_versionMd5;
                        AppMethodBeat.o(129392);
                        return str;
                    }
                });
            }
        }
        AppMethodBeat.o(129395);
    }
}
