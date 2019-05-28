package com.tencent.p177mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C10088g;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C7600h;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26768b;
import com.tencent.p177mm.plugin.appbrand.appusage.C26772k;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.launching.C33438y.C33437a;
import com.tencent.p177mm.plugin.appbrand.launching.C33438y.C33439b;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C38435f;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.ak */
final class C19562ak extends C42607af<Pair<WxaAttributes, Boolean>> {
    private String appId;
    private final int cDB;
    private final int har;
    private final String hgC;
    private final int iiE;
    private boolean iiF = false;
    private boolean iiG = false;
    private C33437a iiH = C33437a.NONE;
    private int iiI = -1;
    private String username;

    C19562ak(String str, String str2, int i, int i2, int i3, String str3) {
        this.username = str;
        this.appId = str2;
        this.har = i;
        this.iiE = i2;
        this.cDB = i3;
        this.hgC = str3;
    }

    private WxaAttributes aHB() {
        AppMethodBeat.m2504i(131987);
        WxaAttributes e;
        if (C5046bo.isNullOrNil(this.username)) {
            e = C42340f.auO().mo21573e(this.appId, new String[0]);
            AppMethodBeat.m2505o(131987);
            return e;
        }
        e = C42340f.auO().mo21572d(this.username, new String[0]);
        AppMethodBeat.m2505o(131987);
        return e;
    }

    /* renamed from: f */
    private static boolean m30334f(WxaAttributes wxaAttributes) {
        AppMethodBeat.m2504i(131988);
        if (C5046bo.isNullOrNil(wxaAttributes.field_appId)) {
            C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", wxaAttributes.field_username);
            AppMethodBeat.m2505o(131988);
            return true;
        } else if (wxaAttributes.ayL() == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", wxaAttributes.field_versionInfo, wxaAttributes.field_username);
            AppMethodBeat.m2505o(131988);
            return true;
        } else if (wxaAttributes.ayJ() == null) {
            C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", wxaAttributes.field_appInfo, wxaAttributes.field_username);
            AppMethodBeat.m2505o(131988);
            return true;
        } else if (wxaAttributes.ayL().bQl == 0 && C5046bo.isNullOrNil(wxaAttributes.ayL().hii)) {
            C4990ab.m7413e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", wxaAttributes.field_username);
            AppMethodBeat.m2505o(131988);
            return true;
        } else {
            AppMethodBeat.m2505o(131988);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ Object call() {
        String c10100y;
        Pair aa;
        Object[] objArr;
        Object create;
        Pair create2;
        AppMethodBeat.m2504i(131989);
        WxaAttributes aHB = aHB();
        if (aHB == null) {
            this.iiF = true;
            this.iiH = C33437a.ATTRS_NOT_FOUND;
        } else {
            this.username = aHB.field_username;
            this.appId = aHB.field_appId;
            if (C19562ak.m30334f(aHB)) {
                C26842p.m42743zp(this.username);
                this.iiF = true;
                this.iiH = C33437a.INVALID_FIELDS;
            } else {
                boolean z;
                String str = this.username;
                C26768b c26768b = new C26768b();
                c26768b.field_username = str;
                if (((C26772k) C42340f.m74878E(C26772k.class)).mo10102b((C4925c) c26768b, new String[0])) {
                    z = false;
                } else {
                    C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateByLastOpenTime, usage record not found with username(%s), forceUpdate=TRUE", str);
                    z = true;
                }
                if (z) {
                    this.iiF = true;
                    this.iiG = true;
                    this.iiH = C33437a.NO_USE_RECENT;
                } else if (C33097a.m54090np(this.har)) {
                    if (this.iiE <= 0 || this.iiE <= aHB.ayL().axy) {
                        if (C19071r.avF() && aHB.ayL() != null && aHB.ayL().hio) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!C38435f.m65033pf(this.cDB)) {
                            c10100y = z ? new C10100y(aHB.field_appId, "__APP__").toString() : aHB.field_appId;
                            int i = aHB.ayL().axy;
                            if (this.har == 0) {
                                C31281at a = C42340f.auV().mo60841a(c10100y, i, 0, "version", "pkgPath", "versionMd5");
                                if (a == null) {
                                    C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, get null manifest record by key(%s), version(%d), forceSync", c10100y, Integer.valueOf(i));
                                    z = true;
                                } else {
                                    z = !C5046bo.isNullOrNil(a.field_pkgPath) && a.field_versionMd5.equals(C1178g.m2587cz(a.field_pkgPath));
                                    if (!C5046bo.isNullOrNil(this.hgC)) {
                                        boolean z2;
                                        if (aHB.ayJ() == null || !aHB.ayJ().mo21563xy()) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            z2 = z && C19573h.m30346cw(a.field_pkgPath, this.hgC);
                                            C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, latestPkgExists[%B], enterPath[%s], pathAccessible[%B]", Boolean.valueOf(z), this.hgC, Boolean.valueOf(z2));
                                            if (!z2) {
                                                this.iiH = C33437a.PATH_NOT_FOUND;
                                            }
                                            if (z2) {
                                                z = false;
                                            } else {
                                                z = true;
                                            }
                                        }
                                    }
                                    if (z) {
                                        C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "local available pkg version[%d] LATEST, no need force update", Integer.valueOf(a.field_version));
                                    } else {
                                        WxaPkgWrappingInfo bm = C19573h.m30345bm(this.appId, 1);
                                        if (bm == null) {
                                            C4990ab.m7416i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, no local available pkg, force update");
                                            z = true;
                                        } else if (this.iiE <= 0 || this.iiE <= bm.gVu) {
                                            C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], no need force update", Integer.valueOf(bm.gVu));
                                        } else {
                                            C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], preferred version[%d], force update", Integer.valueOf(bm.gVu), Integer.valueOf(this.iiE));
                                            z = true;
                                        }
                                    }
                                }
                                if (z) {
                                    C10088g c10088g;
                                    C19050a c19050a;
                                    C7600h c7600h = (C7600h) C42340f.m74878E(C7600h.class);
                                    String str2 = aHB.field_username;
                                    if (!C5046bo.isNullOrNil(str2)) {
                                        C10088g c10088g2 = new C10088g();
                                        c10088g2.field_username = str2;
                                        if (c7600h.mo10102b((C4925c) c10088g2, new String[0])) {
                                            c10088g = c10088g2;
                                            if (c10088g != null && c10088g.field_appVersion > aHB.ayL().axy) {
                                                this.iiI = c10088g.field_appVersion;
                                                this.iiF = true;
                                                this.iiH = C33437a.CMD_UPDATE_VERSION;
                                                this.iiG = true;
                                                c19050a = C19050a.gWl;
                                                C19050a.m29623z((long) c10088g.field_reportId, 154);
                                            }
                                        }
                                    }
                                    c10088g = null;
                                    this.iiI = c10088g.field_appVersion;
                                    this.iiF = true;
                                    this.iiH = C33437a.CMD_UPDATE_VERSION;
                                    this.iiG = true;
                                    c19050a = C19050a.gWl;
                                    C19050a.m29623z((long) c10088g.field_reportId, 154);
                                } else {
                                    this.iiF = true;
                                    if (this.iiH == C33437a.NONE) {
                                        this.iiH = C33437a.MISSING_PKG;
                                    }
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "call, preferVersion[%d], attrs.appVersion[%d], forceSync", Integer.valueOf(this.iiE), Integer.valueOf(aHB.ayL().axy));
                        this.iiF = true;
                        this.iiH = C33437a.VERSION_NOT_FOUND;
                    }
                }
            }
        }
        C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getAttrs, awaitCgi=%B, fallbackIfCgiFailed=%B, reason=%d", Boolean.valueOf(this.iiF), Boolean.valueOf(this.iiG), Integer.valueOf(this.iiH.ordinal()));
        long anU = C5046bo.anU();
        if (C5046bo.isNullOrNil(this.username)) {
            aa = C42406r.m75074aa(this.appId, this.iiF);
        } else {
            aa = C42406r.m75075ab(this.username, this.iiF);
        }
        if (aa.first == null) {
            objArr = new Object[1];
            if (aa.second == null) {
                c10100y = "";
            } else {
                c10100y = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((C37441a) aa.second).errType), Integer.valueOf(((C37441a) aa.second).errCode)});
            }
            objArr[0] = c10100y;
            C42608ag.m75434Ck(C42608ag.getMMString(C25738R.string.f9007m9, objArr));
            C19690c.m30494K("", 7, this.har + 1);
        } else {
            long anU2 = C5046bo.anU() - anU;
            if (aa.second != null) {
                C33438y.m54643a(C33439b.SYNC_GET_ATTRS, this.appId, ((WxaAttributes) aa.first).ayL().axy, this.har, this.cDB, anU2);
            }
        }
        if (this.iiF) {
            if (aa.second == null || ((C37441a) aa.second).errType == 0) {
                int i2;
                if (aa.first == null || ((WxaAttributes) aa.first).ayL() == null) {
                    i2 = -1;
                } else {
                    i2 = ((WxaAttributes) aa.first).ayL().axy;
                }
                if (i2 < this.iiI) {
                    C4990ab.m7417i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getInternal, version mismatched attrsVersion[%d], syncVersion[%d]", Integer.valueOf(i2), Integer.valueOf(this.iiI));
                    C7060h.pYm.mo15419k(648, 2, 1);
                }
            } else {
                if (this.iiG) {
                    C4990ab.m7416i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getInternal, await but cgi failed, return result from db");
                    create2 = Pair.create(aHB(), Boolean.FALSE);
                } else {
                    objArr = new Object[1];
                    objArr[0] = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((C37441a) aa.second).errType), Integer.valueOf(((C37441a) aa.second).errCode)});
                    C42608ag.m75434Ck(C42608ag.getMMString(C25738R.string.f9007m9, objArr));
                    create2 = Pair.create(null, Boolean.TRUE);
                }
                if (C19562ak.m30334f((WxaAttributes) create2.first)) {
                    AppMethodBeat.m2505o(131989);
                    return create2;
                }
                C42608ag.m75435oZ(C25738R.string.f8955ko);
                create2 = Pair.create(null, Boolean.FALSE);
                AppMethodBeat.m2505o(131989);
                return create2;
            }
        }
        create2 = Pair.create(aa.first, Boolean.valueOf(this.iiF));
        if (C19562ak.m30334f((WxaAttributes) create2.first)) {
        }
    }
}
