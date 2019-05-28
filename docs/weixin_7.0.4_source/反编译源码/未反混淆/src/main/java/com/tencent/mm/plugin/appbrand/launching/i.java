package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.g.b.a.cf.c;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

final class i {
    final QualitySession hgN;
    final int hgQ;
    final WxaAttributes igX;
    final a igY;

    public interface a {
        void b(com.tencent.mm.plugin.appbrand.jsapi.version.a aVar);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.launching.i$2 */
    class AnonymousClass2 implements b<WxaAttributes> {
        final /* synthetic */ String eiH;
        final /* synthetic */ long iha;

        AnonymousClass2(String str, long j) {
            this.eiH = str;
            this.iha = j;
        }

        public final /* synthetic */ void f(int i, Object obj) {
            AppMethodBeat.i(131812);
            WxaAttributes wxaAttributes = (WxaAttributes) obj;
            if (wxaAttributes == null) {
                ab.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "onGetContact with username(%s) maybeNew == NULL", this.eiH);
                try {
                    i.this.igY.b(com.tencent.mm.plugin.appbrand.jsapi.version.a.NO_UPDATE);
                    AppMethodBeat.o(131812);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", e, "onGetContact with username(%s) maybeNew == NULL", this.eiH);
                    AppMethodBeat.o(131812);
                }
            } else if (wxaAttributes.ayL() == null) {
                String format = String.format(Locale.US, "onGetContact with username(%s), maybeNew.versionInfo == NULL", new Object[]{this.eiH});
                ab.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", format);
                try {
                    i.this.igY.b(com.tencent.mm.plugin.appbrand.jsapi.version.a.NO_UPDATE);
                    AppMethodBeat.o(131812);
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", e2, format, new Object[0]);
                    AppMethodBeat.o(131812);
                }
            } else {
                ab.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] onGetContact(%s), result %d, maybeNew.ver %d", this.eiH, Integer.valueOf(i), Integer.valueOf(wxaAttributes.ayL().axy));
                switch (i) {
                    case 2:
                    case 3:
                        c cVar;
                        long anU = bo.anU();
                        cf ea = g.a(i.this.hgN).ec(this.iha).ed(anU).ea(anU - this.iha);
                        if (i == 2) {
                            cVar = c.ok;
                        } else {
                            cVar = c.common_fail;
                        }
                        ea.dfE = cVar;
                        ea.dfF = cf.b.async;
                        ea.cXm = (long) g.getNetworkType();
                        ea.ajK();
                        break;
                }
                WxaAttributes wxaAttributes2 = i.this.igX;
                if (wxaAttributes.ayL().bQl != 0) {
                    i.this.igY.b(com.tencent.mm.plugin.appbrand.jsapi.version.a.NO_UPDATE);
                    AppMethodBeat.o(131812);
                } else if (wxaAttributes2.ayL().axy >= wxaAttributes.ayL().axy) {
                    i.this.igY.b(com.tencent.mm.plugin.appbrand.jsapi.version.a.NO_UPDATE);
                    AppMethodBeat.o(131812);
                } else {
                    WxaPkgWrappingInfo azZ;
                    com.tencent.mm.plugin.appbrand.jsapi.version.a aVar;
                    i.this.igY.b(com.tencent.mm.plugin.appbrand.jsapi.version.a.UPDATING);
                    try {
                        azZ = new ai(wxaAttributes.field_appId, 0, "", i.this.hgQ, wxaAttributes).azZ();
                    } catch (Exception e22) {
                        ab.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "%s, prepare pkg exp = %s", wxaAttributes.field_appId, e22);
                        azZ = null;
                    }
                    a aVar2 = i.this.igY;
                    if (azZ == null) {
                        aVar = com.tencent.mm.plugin.appbrand.jsapi.version.a.UPDATE_FAILED;
                    } else {
                        aVar = com.tencent.mm.plugin.appbrand.jsapi.version.a.UPDATE_READY;
                    }
                    aVar2.b(aVar);
                    AppMethodBeat.o(131812);
                }
            }
        }
    }

    i(String str, int i, a aVar, QualitySession qualitySession) {
        AppMethodBeat.i(131813);
        this.hgQ = i;
        this.igX = f.auO().d(str, new String[0]);
        this.igY = aVar;
        this.hgN = qualitySession;
        if (this.igX == null) {
            ab.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", " <init> get NULL record by username %s", str);
        }
        AppMethodBeat.o(131813);
    }
}
