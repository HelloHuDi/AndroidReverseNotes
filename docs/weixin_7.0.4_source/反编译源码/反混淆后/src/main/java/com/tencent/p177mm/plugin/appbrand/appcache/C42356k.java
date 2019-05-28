package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a;
import com.tencent.p177mm.plugin.appbrand.appcache.p881a.C26735b.C26734a.C10067a;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.plugin.appbrand.p328r.C27277i;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C4713a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40431k;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.k */
public enum C42356k implements C26735b<C42357l, C40432m, C40431k> {
    ;
    
    public final C27277i<String, C26734a<C40432m, C40431k>> gSy;

    private C42356k(String str) {
        AppMethodBeat.m2504i(59433);
        this.gSy = new C27277i();
        AppMethodBeat.m2505o(59433);
    }

    static {
        AppMethodBeat.m2505o(59435);
    }

    /* renamed from: a */
    public final void mo67864a(C42357l c42357l, C40432m c40432m) {
        C10067a c10067a;
        AppMethodBeat.m2504i(59434);
        if (c40432m.status != 2) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult %s", c40432m);
            if (!(c40432m.vfo instanceof C4713a)) {
                switch (c40432m.httpStatusCode) {
                    case 403:
                    case 404:
                        c10067a = C10067a.SEVER_FILE_NOT_FOUND;
                        break;
                    default:
                        c10067a = C10067a.FAILED;
                        break;
                }
            }
            c10067a = C10067a.DISK_FULL;
        } else {
            C10067a c10067a2;
            C42346af auC = ((C33065d) C1720g.m3528K(C33065d.class)).auC();
            if (auC == null) {
                C4990ab.m7412e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null storage");
                c10067a2 = C10067a.ENV_ERR;
            } else {
                C41220ae r = auC.mo67859r(c42357l.appId, c42357l.gSA, c42357l.version);
                if (r == null) {
                    C4990ab.m7413e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, null record with %s", c42357l.toShortString());
                    c10067a2 = C10067a.ENV_ERR;
                } else {
                    r.field_pkgPath = c42357l.getFilePath();
                    C4990ab.m7417i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "onDownloadResult complete, integrityOk %b, with %s", Boolean.valueOf(C42346af.m74892a(r)), c42357l.toShortString());
                    if (C42346af.m74892a(r)) {
                        auC.mo10103c(r, new String[0]);
                        c10067a2 = C10067a.OK;
                    } else {
                        c10067a2 = C10067a.PKG_INTEGRITY_FAILED;
                    }
                }
            }
            c10067a = c10067a2;
        }
        Set<C26734a> bD = this.gSy.mo44962bD(c42357l.vdC);
        if (bD != null) {
            for (C26734a a : bD) {
                a.mo14965a(c42357l.appId, c10067a, c40432m);
            }
        }
        AppMethodBeat.m2505o(59434);
    }
}
