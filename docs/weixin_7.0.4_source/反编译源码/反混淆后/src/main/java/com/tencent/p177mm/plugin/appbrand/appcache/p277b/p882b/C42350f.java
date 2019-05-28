package com.tencent.p177mm.plugin.appbrand.appcache.p277b.p882b;

import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.appcache.C2050aq;
import com.tencent.p177mm.plugin.appbrand.appcache.C26736ah;
import com.tencent.p177mm.plugin.appbrand.appcache.C41220ae;
import com.tencent.p177mm.plugin.appbrand.appcache.C42346af;
import com.tencent.p177mm.plugin.appbrand.appcache.C42347ag;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19394e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.protocal.protobuf.cxp;
import com.tencent.p177mm.protocal.protobuf.cxv;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.f */
public class C42350f extends C38108a<Boolean, cxv> {

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.b.b.f$a */
    public enum C42349a {
        WXA_LAUNCH,
        ISSUE_DECRYPT,
        GET_CODE;

        static {
            AppMethodBeat.m2505o(129469);
        }
    }

    /* renamed from: b */
    public final /* synthetic */ Object mo21442b(String str, String str2, Object obj) {
        boolean z = false;
        AppMethodBeat.m2504i(129473);
        cxv cxv = (cxv) obj;
        int i = cxv.vMG;
        String str3 = cxv.xtn;
        C19050a c19050a;
        Object obj2;
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call appId(%s) version(%d) key nil", str2, Integer.valueOf(i));
            c19050a = C19050a.gWl;
            C19050a.m29623z((long) cxv.xsZ.xsX, 124);
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.m2505o(129473);
            return bool;
        } else if (C19035as.m29615v(str2, 0, i).first == C19036a.gUI) {
            C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, normal pkg ok appId(%s), version(%d)", str2, Integer.valueOf(i));
            c19050a = C19050a.gWl;
            C19050a.m29623z((long) cxv.xsZ.xsX, 125);
            obj2 = Boolean.FALSE;
            AppMethodBeat.m2505o(129473);
            return obj2;
        } else {
            int i2;
            C41220ae s = ((C42346af) C42340f.m74878E(C42346af.class)).mo67860s(str2, 1, i);
            if (s == null) {
                C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "call, null encrypt pkg info with %s, %d", str2, Integer.valueOf(i));
                c19050a = C19050a.gWl;
                C19050a.m29623z((long) cxv.xsZ.xsX, 126);
                i2 = 1;
            } else if (C42350f.m74899a(s, cxv.xtn, cxv.Md5, cxv.xsZ.xsX, C42349a.ISSUE_DECRYPT)) {
                boolean i22 = false;
            } else {
                i22 = 1;
            }
            if (i22 != 0) {
                C26736ah c26736ah = (C26736ah) C42340f.m74878E(C26736ah.class);
                String str4 = cxv.Md5;
                int i3 = cxv.xsZ.xsX;
                if (C5046bo.isNullOrNil(str2) || C5046bo.isNullOrNil(str3)) {
                    C4990ab.m7413e("MicroMsg.AppBrand.Predownload.PushWxaPkgDecryptKeyStorage", "setDecryptKey, invalid appId[%s], decryptKey[%s]", str2, str3);
                } else {
                    C42347ag c42347ag = new C42347ag();
                    c42347ag.field_appId = str2;
                    c42347ag.field_appVersion = i;
                    boolean b = c26736ah.mo10102b(c42347ag, new String[0]);
                    c42347ag.field_decryptKey = str3;
                    c42347ag.field_reportId = i3;
                    c42347ag.field_pkgMd5 = str4;
                    z = b ? c26736ah.mo10103c(c42347ag, new String[0]) : c26736ah.mo10101b((C4925c) c42347ag);
                }
                c19050a = C19050a.gWl;
                int i4 = cxv.xsZ.xsX;
                if (z) {
                    i22 = C44697b.CTRL_INDEX;
                } else {
                    i22 = C19395n.CTRL_INDEX;
                }
                C19050a.m29623z((long) i4, (long) i22);
            }
            obj2 = Boolean.TRUE;
            AppMethodBeat.m2505o(129473);
            return obj2;
        }
    }

    /* Access modifiers changed, original: final|bridge|synthetic */
    /* renamed from: bm */
    public final /* bridge */ /* synthetic */ cxp mo21443bm(Object obj) {
        return ((cxv) obj).xsZ;
    }

    /* Access modifiers changed, original: final */
    public final String awu() {
        return "CmdIssueDecryptKey";
    }

    /* renamed from: a */
    private static boolean m74899a(C41220ae c41220ae, String str, String str2, int i, C42349a c42349a) {
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(129470);
        switch (c42349a) {
            case WXA_LAUNCH:
                i2 = 131;
                break;
            default:
                i2 = C31128d.MIC_SketchMark;
                break;
        }
        C19050a c19050a = C19050a.gWl;
        C19050a.m29623z((long) i, (long) i2);
        String aq = C2050aq.m4207aq(c41220ae.field_appId, c41220ae.field_version);
        C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, appId(%s), version(%d), ret %d", c41220ae.field_appId, Integer.valueOf(c41220ae.field_version), Integer.valueOf(MMProtocalJni.aesDecryptFile(c41220ae.field_pkgPath, aq, str.getBytes())));
        C19050a c19050a2;
        if (MMProtocalJni.aesDecryptFile(c41220ae.field_pkgPath, aq, str.getBytes()) != 0) {
            switch (c42349a) {
                case WXA_LAUNCH:
                    i2 = C19394e.CTRL_INDEX;
                    break;
                default:
                    i2 = GmsClientSupervisor.DEFAULT_BIND_FLAGS;
                    break;
            }
            c19050a2 = C19050a.gWl;
            C19050a.m29623z((long) i, (long) i2);
            AppMethodBeat.m2505o(129470);
            return false;
        }
        if (C1178g.m2587cz(aq).equals(str2)) {
            C19050a c19050a3;
            C42340f.auV().mo60865g(c41220ae.field_appId, c41220ae.field_version, str2);
            boolean d = C42340f.auV().mo60864d(c41220ae.field_appId, 0, c41220ae.field_version, aq);
            switch (c42349a) {
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
            c19050a = C19050a.gWl;
            C19050a.m29623z((long) i, (long) i2);
            C1173e.deleteFile(c41220ae.field_pkgPath);
            i2 = ((C42346af) C42340f.m74878E(C42346af.class)).mo16760a((C4925c) c41220ae, new String[0]) ? C33333a.CTRL_INDEX : 140;
            c19050a = C19050a.gWl;
            C19050a.m29623z((long) i, (long) i2);
            if (c42349a != C42349a.ISSUE_DECRYPT) {
                C26736ah c26736ah = (C26736ah) C42340f.m74878E(C26736ah.class);
                String str3 = c41220ae.field_appId;
                int i4 = c41220ae.field_version;
                if (!C5046bo.isNullOrNil(str3)) {
                    C42347ag c42347ag = new C42347ag();
                    c42347ag.field_appId = str3;
                    c42347ag.field_appVersion = i4;
                    i3 = c26736ah.mo16760a((C4925c) c42347ag, new String[0]);
                }
                i2 = i3 != 0 ? 141 : ErrorCode.NEEDDOWNLOAD_3;
                c19050a3 = C19050a.gWl;
                C19050a.m29623z((long) i, (long) i2);
            }
            switch (c42349a) {
                case WXA_LAUNCH:
                    i2 = 132;
                    break;
                default:
                    i2 = 128;
                    break;
            }
            c19050a3 = C19050a.gWl;
            C19050a.m29623z((long) i, (long) i2);
            AppMethodBeat.m2505o(129470);
            return true;
        }
        C4990ab.m7413e("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave, file_md5(%s) expect_md5(%s) mismatch", C1178g.m2587cz(aq), str2);
        switch (c42349a) {
            case WXA_LAUNCH:
                i2 = C19392d.CTRL_INDEX;
                break;
            default:
                i2 = 130;
                break;
        }
        c19050a2 = C19050a.gWl;
        C19050a.m29623z((long) i, (long) i2);
        AppMethodBeat.m2505o(129470);
        return false;
    }

    /* renamed from: a */
    public static boolean m74897a(C41220ae c41220ae, C42349a c42349a) {
        AppMethodBeat.m2504i(129471);
        boolean a = C42350f.m74898a(c41220ae, c42349a, null);
        AppMethodBeat.m2505o(129471);
        return a;
    }

    /* renamed from: a */
    public static boolean m74898a(C41220ae c41220ae, C42349a c42349a, PLong pLong) {
        AppMethodBeat.m2504i(129472);
        C42347ag ap = ((C26736ah) C42340f.m74878E(C26736ah.class)).mo44523ap(c41220ae.field_appId, c41220ae.field_version);
        if (ap == null) {
            C4990ab.m7417i("MicroMsg.AppBrand.Predownload.CmdIssueDecryptKey", "decryptPkgAndSave get null key with %s", c41220ae.toShortString());
            AppMethodBeat.m2505o(129472);
            return false;
        }
        if (pLong != null) {
            pLong.value = (long) ap.field_reportId;
        }
        boolean a = C42350f.m74899a(c41220ae, ap.field_decryptKey, ap.field_pkgMd5, ap.field_reportId, c42349a);
        AppMethodBeat.m2505o(129472);
        return a;
    }
}
