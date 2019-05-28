package com.tencent.mm.plugin.appbrand.appcache.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.az;
import com.tencent.mm.plugin.appbrand.appcache.b.e.c;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;

public final class a implements com.tencent.mm.vending.c.a<Boolean, c> {

    static class a implements com.tencent.mm.vending.c.a<Boolean, com.tencent.mm.vending.j.c<arb, arc>> {
        a() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(129458);
            Boolean a = a((com.tencent.mm.vending.j.c) obj);
            AppMethodBeat.o(129458);
            return a;
        }

        private Boolean a(com.tencent.mm.vending.j.c<arb, arc> cVar) {
            y yVar;
            AppMethodBeat.i(129457);
            arb arb = (arb) cVar.get(0);
            arc arc = (arc) cVar.get(1);
            if (arb.type == 0) {
                yVar = new y(arb.csB);
            } else if (arb.type == 4) {
                yVar = new y(arb.csB, arb.wsY);
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("not support request.type %d", new Object[]{Integer.valueOf(arb.type)}));
                AppMethodBeat.o(129457);
                throw illegalArgumentException;
            }
            final b dMj = f.dMj();
            dMj.dMi();
            AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.appcache.a.b.a<m, k>() {
                public final /* bridge */ /* synthetic */ void bl(Object obj) {
                }

                public final /* synthetic */ void a(String str, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, Object obj) {
                    AppMethodBeat.i(129456);
                    b bVar = dMj;
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(aVar == com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK);
                    bVar.B(objArr);
                    ab.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s onPkgUpdateResult, ret %s", str, aVar.name());
                    AppMethodBeat.o(129456);
                }
            };
            ab.i("MicroMsg.AppBrand.Predownload.ActionGetEncryptPkg.PlainActionDownloadPkg", "%s downloadPkg, patch_url(%s), full_url(%s)", yVar.toString(), arc.cDL, arc.url);
            l lVar = new l(yVar.toString(), arb.wuN.wLw, arb.vOP, arc.url);
            com.tencent.mm.plugin.appbrand.appcache.k kVar = com.tencent.mm.plugin.appbrand.appcache.k.gSx;
            az awq = az.awq();
            if (awq != null) {
                ab.i("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, addRequest(%s) ret = %d", lVar.toShortString(), Integer.valueOf(awq.gVr.b(lVar)));
                switch (awq.gVr.b(lVar)) {
                    case 4:
                        anonymousClass1.a(lVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                        break;
                    default:
                        kVar.gSy.f(lVar.vdC, anonymousClass1);
                        break;
                }
            }
            ab.e("MicroMsg.AppBrand.Predownload.EncryptPkgDownloader", "startDownload, null updater");
            anonymousClass1.a(lVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(129457);
            return bool;
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(129459);
        c cVar = (c) obj;
        String str = cVar.field_appId;
        int i = cVar.field_version;
        String str2 = cVar.field_pkgMd5;
        y yVar = new y(str, "");
        final boolean z = cVar.field_retriedCount > 0;
        final int i2 = cVar.field_reportId;
        final b dMj = f.dMj();
        dMj.dMi();
        arb arb = new arb();
        arb.csB = str;
        arb.vOP = i;
        arb.wtb = 0;
        arb.wuL = str2;
        if (bo.isNullOrNil("")) {
            arb.wtb = 0;
        } else {
            arb.wsY = "";
            arb.wtb = 4;
        }
        arb.wuN = new bie();
        arb.wuN.wLv = 0;
        arb.wuN.wLw = 1;
        int i3 = z ? 51 : 46;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i2, (long) i3);
        new d(arb).acy().j(new com.tencent.mm.vending.c.a<com.tencent.mm.vending.j.c<arb, arc>, com.tencent.mm.ai.a.a<arc>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(129455);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                if (com.tencent.mm.plugin.appbrand.k.a.b(aVar)) {
                    com.tencent.mm.ai.b bVar = (com.tencent.mm.ai.b) aVar.cwn.ftl;
                    Object F = com.tencent.mm.vending.j.a.F((arb) bVar.fsG.fsP, (arc) bVar.fsH.fsP);
                    AppMethodBeat.o(129455);
                    return F;
                }
                dMj.B(Boolean.FALSE);
                f.dMj().cR(Boolean.FALSE);
                int i = z ? 50 : 49;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i2, (long) i);
                AppMethodBeat.o(129455);
                return null;
            }
        }).g(new a()).g(new com.tencent.mm.vending.c.a<Void, Boolean>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(129454);
                int i = ((Boolean) obj).booleanValue() ? z ? 52 : 47 : z ? 53 : 48;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i2, (long) i);
                dMj.B(r6);
                Void voidR = zXH;
                AppMethodBeat.o(129454);
                return voidR;
            }
        });
        Boolean bool = Boolean.TRUE;
        AppMethodBeat.o(129459);
        return bool;
    }
}
