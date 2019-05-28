package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.g;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.appcache.b.b.i;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.c.a;
import java.util.List;

public final class d {
    static void aB(List<cgb> list) {
        AppMethodBeat.i(129446);
        if (bo.ek(list)) {
            AppMethodBeat.o(129446);
            return;
        }
        for (cgb cgb : list) {
            if (cgb.xfe == null) {
                ab.e("MicroMsg.AppBrand.PredownloadCmdProcessor", "processCmd, username %s, appId %s, nil Cmds", cgb.xfb, cgb.vEn);
            } else {
                boolean z;
                String str = "MicroMsg.AppBrand.PredownloadCmdProcessor";
                String str2 = "processCmd, username %s appId %s, GetContact(%b), GetCode(%b), IssueContact(%b), IssueLaunch(%b), IssueDecryptKey(%s), UpdateVersion(%b)";
                Object[] objArr = new Object[8];
                objArr[0] = cgb.xfb;
                objArr[1] = cgb.vEn;
                objArr[2] = Boolean.valueOf(cgb.xfe.xtd != null);
                if (cgb.xfe.xte != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[3] = Boolean.valueOf(z);
                if (cgb.xfe.xtf != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                if (cgb.xfe.xtg != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[5] = Boolean.valueOf(z);
                if (cgb.xfe.xth != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[6] = Boolean.valueOf(z);
                if (cgb.xfe.xti != null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[7] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                if (cgb.xfe.xtd != null) {
                    g.j(cgb.xfb, cgb.vEn, cgb.xfe.xtd).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.d());
                }
                if (cgb.xfe.xte != null) {
                    g.j(cgb.xfb, cgb.vEn, cgb.xfe.xte).j(new c()).g(new a<Void, Boolean>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(129445);
                            Boolean bool = (Boolean) obj;
                            if (bool != null && bool.booleanValue()) {
                                i.gWd.awv();
                            }
                            AppMethodBeat.o(129445);
                            return null;
                        }
                    });
                }
                if (cgb.xfe.xtf != null) {
                    g.j(cgb.xfb, cgb.vEn, cgb.xfe.xtf).j(new e());
                }
                if (cgb.xfe.xtg != null) {
                    g.j(cgb.xfb, cgb.vEn, cgb.xfe.xtg).j(new com.tencent.mm.plugin.appbrand.appcache.b.b.g());
                }
                if (cgb.xfe.xth != null) {
                    g.j(cgb.xfb, cgb.vEn, cgb.xfe.xth).j(new f());
                }
                if (cgb.xfe.xti != null) {
                    g.j(cgb.xfb, cgb.vEn, cgb.xfe.xti).j(new h());
                }
                if (cgb.xfe.xtj != null) {
                    g.j(cgb.xfb, cgb.vEn, cgb.xfe.xtj).j(new b());
                }
            }
        }
        AppMethodBeat.o(129446);
    }
}
