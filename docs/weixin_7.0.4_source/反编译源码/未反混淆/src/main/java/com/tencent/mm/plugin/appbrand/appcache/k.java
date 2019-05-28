package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.a.b.a;
import com.tencent.mm.plugin.appbrand.r.i;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

public enum k implements b<l, m, com.tencent.mm.pluginsdk.g.a.c.k> {
    ;
    
    public final i<String, a<m, com.tencent.mm.pluginsdk.g.a.c.k>> gSy;

    private k(String str) {
        AppMethodBeat.i(59433);
        this.gSy = new i();
        AppMethodBeat.o(59433);
    }

    static {
        AppMethodBeat.o(59435);
    }

    public final void a(l lVar, m mVar) {
        a.a aVar;
        AppMethodBeat.i(59434);
        if (mVar.status != 2) {
            ab.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", mVar);
            if (!(mVar.vfo instanceof com.tencent.mm.pluginsdk.g.a.b.a)) {
                switch (mVar.httpStatusCode) {
                    case 403:
                    case 404:
                        aVar = a.a.SEVER_FILE_NOT_FOUND;
                        break;
                    default:
                        aVar = a.a.FAILED;
                        break;
                }
            }
            aVar = a.a.DISK_FULL;
        } else {
            a.a aVar2;
            af auC = ((d) g.K(d.class)).auC();
            if (auC == null) {
                ab.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
                aVar2 = a.a.ENV_ERR;
            } else {
                ae r = auC.r(lVar.appId, lVar.gSA, lVar.version);
                if (r == null) {
                    ab.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", lVar.toShortString());
                    aVar2 = a.a.ENV_ERR;
                } else {
                    r.field_pkgPath = lVar.getFilePath();
                    ab.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", Boolean.valueOf(af.a(r)), lVar.toShortString());
                    if (af.a(r)) {
                        auC.c(r, new String[0]);
                        aVar2 = a.a.OK;
                    } else {
                        aVar2 = a.a.PKG_INTEGRITY_FAILED;
                    }
                }
            }
            aVar = aVar2;
        }
        Set<a> bD = this.gSy.bD(lVar.vdC);
        if (bD != null) {
            for (a a : bD) {
                a.a(lVar.appId, aVar, mVar);
            }
        }
        AppMethodBeat.o(59434);
    }
}
