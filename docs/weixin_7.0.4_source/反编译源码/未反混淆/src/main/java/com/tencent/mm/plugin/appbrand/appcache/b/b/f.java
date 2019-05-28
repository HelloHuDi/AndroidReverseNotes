package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.d;

public class f extends a<Boolean, cxv> {

    public enum a {
        WXA_LAUNCH,
        ISSUE_DECRYPT,
        GET_CODE;

        static {
            AppMethodBeat.o(129469);
        }
    }

    public final /* synthetic */ Object b(String str, String str2, Object obj) {
        boolean z = false;
        AppMethodBeat.i(129473);
        cxv cxv = (cxv) obj;
        int i = cxv.vMG;
        String str3 = cxv.xtn;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar;
        Object obj2;
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call appId(%s) version(%d) key nil", str2, Integer.valueOf(i));
            aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) cxv.xsZ.xsX, 124);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(129473);
            return bool;
        } else if (as.v(str2, 0, i).first == com.tencent.mm.plugin.appbrand.appcache.as.a.gUI) {
            ab.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, normal pkg ok appId(%s), version(%d)", str2, Integer.valueOf(i));
            aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) cxv.xsZ.xsX, 125);
            obj2 = Boolean.FALSE;
            AppMethodBeat.o(129473);
            return obj2;
        } else {
            int i2;
            ae s = ((af) com.tencent.mm.plugin.appbrand.app.f.E(af.class)).s(str2, 1, i);
            if (s == null) {
                ab.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, null encrypt pkg info with %s, %d", str2, Integer.valueOf(i));
                aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) cxv.xsZ.xsX, 126);
                i2 = 1;
            } else if (a(s, cxv.xtn, cxv.Md5, cxv.xsZ.xsX, a.ISSUE_DECRYPT)) {
                boolean i22 = false;
            } else {
                i22 = 1;
            }
            if (i22 != 0) {
                ah ahVar = (ah) com.tencent.mm.plugin.appbrand.app.f.E(ah.class);
                String str4 = cxv.Md5;
                int i3 = cxv.xsZ.xsX;
                if (bo.isNullOrNil(str2) || bo.isNullOrNil(str3)) {
                    ab.e("MicroMsg.AppBrand.Predownload.PushWxaPkgDecryptKeyStorage", "setDecryptKey, invalid appId[%s], decryptKey[%s]", str2, str3);
                } else {
                    ag agVar = new ag();
                    agVar.field_appId = str2;
                    agVar.field_appVersion = i;
                    boolean b = ahVar.b(agVar, new String[0]);
                    agVar.field_decryptKey = str3;
                    agVar.field_reportId = i3;
                    agVar.field_pkgMd5 = str4;
                    z = b ? ahVar.c(agVar, new String[0]) : ahVar.b((c) agVar);
                }
                aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                int i4 = cxv.xsZ.xsX;
                if (z) {
                    i22 = b.CTRL_INDEX;
                } else {
                    i22 = n.CTRL_INDEX;
                }
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i4, (long) i22);
            }
            obj2 = Boolean.TRUE;
            AppMethodBeat.o(129473);
            return obj2;
        }
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ cxp bm(Object obj) {
        return ((cxv) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdIssueDecryptKey";
    }

    private static boolean a(ae aeVar, String str, String str2, int i, a aVar) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(129470);
        switch (aVar) {
            case WXA_LAUNCH:
                i2 = 131;
                break;
            default:
                i2 = d.MIC_SketchMark;
                break;
        }
        com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i, (long) i2);
        String aq = aq.aq(aeVar.field_appId, aeVar.field_version);
        ab.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", aeVar.field_appId, Integer.valueOf(aeVar.field_version), Integer.valueOf(MMProtocalJni.aesDecryptFile(aeVar.field_pkgPath, aq, str.getBytes())));
        com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar3;
        if (MMProtocalJni.aesDecryptFile(aeVar.field_pkgPath, aq, str.getBytes()) != 0) {
            switch (aVar) {
                case WXA_LAUNCH:
                    i2 = e.CTRL_INDEX;
                    break;
                default:
                    i2 = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
                    break;
            }
            aVar3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i, (long) i2);
            AppMethodBeat.o(129470);
            return false;
        }
        if (g.cz(aq).equals(str2)) {
            com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar4;
            com.tencent.mm.plugin.appbrand.app.f.auV().g(aeVar.field_appId, aeVar.field_version, str2);
            boolean d = com.tencent.mm.plugin.appbrand.app.f.auV().d(aeVar.field_appId, 0, aeVar.field_version, aq);
            switch (aVar) {
                case WXA_LAUNCH:
                    if (!d) {
                        i2 = 148;
                        break;
                    }
                    i2 = ErrorCode.NEEDDOWNLOAD_8;
                    break;
                default:
                    if (!d) {
                        i2 = 144;
                        break;
                    }
                    i2 = ErrorCode.NEEDDOWNLOAD_4;
                    break;
            }
            aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i, (long) i2);
            com.tencent.mm.a.e.deleteFile(aeVar.field_pkgPath);
            i2 = ((af) com.tencent.mm.plugin.appbrand.app.f.E(af.class)).a((c) aeVar, new String[0]) ? com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX : 140;
            aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i, (long) i2);
            if (aVar != a.ISSUE_DECRYPT) {
                ah ahVar = (ah) com.tencent.mm.plugin.appbrand.app.f.E(ah.class);
                String str3 = aeVar.field_appId;
                int i4 = aeVar.field_version;
                if (!bo.isNullOrNil(str3)) {
                    ag agVar = new ag();
                    agVar.field_appId = str3;
                    agVar.field_appVersion = i4;
                    i3 = ahVar.a((c) agVar, new String[0]);
                }
                i2 = i3 != 0 ? 141 : ErrorCode.NEEDDOWNLOAD_3;
                aVar4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i, (long) i2);
            }
            switch (aVar) {
                case WXA_LAUNCH:
                    i2 = 132;
                    break;
                default:
                    i2 = 128;
                    break;
            }
            aVar4 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
            com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i, (long) i2);
            AppMethodBeat.o(129470);
            return true;
        }
        ab.e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", g.cz(aq), str2);
        switch (aVar) {
            case WXA_LAUNCH:
                i2 = com.tencent.mm.plugin.appbrand.jsapi.g.d.CTRL_INDEX;
                break;
            default:
                i2 = 130;
                break;
        }
        aVar3 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
        com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) i, (long) i2);
        AppMethodBeat.o(129470);
        return false;
    }

    public static boolean a(ae aeVar, a aVar) {
        AppMethodBeat.i(129471);
        boolean a = a(aeVar, aVar, null);
        AppMethodBeat.o(129471);
        return a;
    }

    public static boolean a(ae aeVar, a aVar, PLong pLong) {
        AppMethodBeat.i(129472);
        ag ap = ((ah) com.tencent.mm.plugin.appbrand.app.f.E(ah.class)).ap(aeVar.field_appId, aeVar.field_version);
        if (ap == null) {
            ab.i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", aeVar.toShortString());
            AppMethodBeat.o(129472);
            return false;
        }
        if (pLong != null) {
            pLong.value = (long) ap.field_reportId;
        }
        boolean a = a(aeVar, ap.field_decryptKey, ap.field_pkgMd5, ap.field_reportId, aVar);
        AppMethodBeat.o(129472);
        return a;
    }
}
