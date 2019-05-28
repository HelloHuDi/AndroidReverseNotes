package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.b.e.h;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.appusage.b;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.launching.y.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;

final class ak extends af<Pair<WxaAttributes, Boolean>> {
    private String appId;
    private final int cDB;
    private final int har;
    private final String hgC;
    private final int iiE;
    private boolean iiF = false;
    private boolean iiG = false;
    private a iiH = a.NONE;
    private int iiI = -1;
    private String username;

    ak(String str, String str2, int i, int i2, int i3, String str3) {
        this.username = str;
        this.appId = str2;
        this.har = i;
        this.iiE = i2;
        this.cDB = i3;
        this.hgC = str3;
    }

    private WxaAttributes aHB() {
        AppMethodBeat.i(131987);
        WxaAttributes e;
        if (bo.isNullOrNil(this.username)) {
            e = f.auO().e(this.appId, new String[0]);
            AppMethodBeat.o(131987);
            return e;
        }
        e = f.auO().d(this.username, new String[0]);
        AppMethodBeat.o(131987);
        return e;
    }

    private static boolean f(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(131988);
        if (bo.isNullOrNil(wxaAttributes.field_appId)) {
            ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", wxaAttributes.field_username);
            AppMethodBeat.o(131988);
            return true;
        } else if (wxaAttributes.ayL() == null) {
            ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL versionInfo(%s) in contact(%s)", wxaAttributes.field_versionInfo, wxaAttributes.field_username);
            AppMethodBeat.o(131988);
            return true;
        } else if (wxaAttributes.ayJ() == null) {
            ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "NULL appInfo(%s) in contact(%s)", wxaAttributes.field_appInfo, wxaAttributes.field_username);
            AppMethodBeat.o(131988);
            return true;
        } else if (wxaAttributes.ayL().bQl == 0 && bo.isNullOrNil(wxaAttributes.ayL().hii)) {
            ab.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", wxaAttributes.field_username);
            AppMethodBeat.o(131988);
            return true;
        } else {
            AppMethodBeat.o(131988);
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
        String yVar;
        Pair aa;
        Object[] objArr;
        Object create;
        Pair create2;
        AppMethodBeat.i(131989);
        WxaAttributes aHB = aHB();
        if (aHB == null) {
            this.iiF = true;
            this.iiH = a.ATTRS_NOT_FOUND;
        } else {
            this.username = aHB.field_username;
            this.appId = aHB.field_appId;
            if (f(aHB)) {
                p.zp(this.username);
                this.iiF = true;
                this.iiH = a.INVALID_FIELDS;
            } else {
                boolean z;
                String str = this.username;
                b bVar = new b();
                bVar.field_username = str;
                if (((k) f.E(k.class)).b((c) bVar, new String[0])) {
                    z = false;
                } else {
                    ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateByLastOpenTime, usage record not found with username(%s), forceUpdate=TRUE", str);
                    z = true;
                }
                if (z) {
                    this.iiF = true;
                    this.iiG = true;
                    this.iiH = a.NO_USE_RECENT;
                } else if (j.a.np(this.har)) {
                    if (this.iiE <= 0 || this.iiE <= aHB.ayL().axy) {
                        if (r.avF() && aHB.ayL() != null && aHB.ayL().hio) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.pf(this.cDB)) {
                            yVar = z ? new y(aHB.field_appId, "__APP__").toString() : aHB.field_appId;
                            int i = aHB.ayL().axy;
                            if (this.har == 0) {
                                at a = f.auV().a(yVar, i, 0, "version", "pkgPath", "versionMd5");
                                if (a == null) {
                                    ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, get null manifest record by key(%s), version(%d), forceSync", yVar, Integer.valueOf(i));
                                    z = true;
                                } else {
                                    z = !bo.isNullOrNil(a.field_pkgPath) && a.field_versionMd5.equals(g.cz(a.field_pkgPath));
                                    if (!bo.isNullOrNil(this.hgC)) {
                                        boolean z2;
                                        if (aHB.ayJ() == null || !aHB.ayJ().xy()) {
                                            z2 = false;
                                        } else {
                                            z2 = true;
                                        }
                                        if (!z2) {
                                            z2 = z && h.cw(a.field_pkgPath, this.hgC);
                                            ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, latestPkgExists[%B], enterPath[%s], pathAccessible[%B]", Boolean.valueOf(z), this.hgC, Boolean.valueOf(z2));
                                            if (!z2) {
                                                this.iiH = a.PATH_NOT_FOUND;
                                            }
                                            if (z2) {
                                                z = false;
                                            } else {
                                                z = true;
                                            }
                                        }
                                    }
                                    if (z) {
                                        ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "local available pkg version[%d] LATEST, no need force update", Integer.valueOf(a.field_version));
                                    } else {
                                        WxaPkgWrappingInfo bm = h.bm(this.appId, 1);
                                        if (bm == null) {
                                            ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, no local available pkg, force update");
                                            z = true;
                                        } else if (this.iiE <= 0 || this.iiE <= bm.gVu) {
                                            ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], no need force update", Integer.valueOf(bm.gVu));
                                        } else {
                                            ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], preferred version[%d], force update", Integer.valueOf(bm.gVu), Integer.valueOf(this.iiE));
                                            z = true;
                                        }
                                    }
                                }
                                if (z) {
                                    com.tencent.mm.plugin.appbrand.appcache.b.e.g gVar;
                                    com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar;
                                    h hVar = (h) f.E(h.class);
                                    String str2 = aHB.field_username;
                                    if (!bo.isNullOrNil(str2)) {
                                        com.tencent.mm.plugin.appbrand.appcache.b.e.g gVar2 = new com.tencent.mm.plugin.appbrand.appcache.b.e.g();
                                        gVar2.field_username = str2;
                                        if (hVar.b((c) gVar2, new String[0])) {
                                            gVar = gVar2;
                                            if (gVar != null && gVar.field_appVersion > aHB.ayL().axy) {
                                                this.iiI = gVar.field_appVersion;
                                                this.iiF = true;
                                                this.iiH = a.CMD_UPDATE_VERSION;
                                                this.iiG = true;
                                                aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                                                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) gVar.field_reportId, 154);
                                            }
                                        }
                                    }
                                    gVar = null;
                                    this.iiI = gVar.field_appVersion;
                                    this.iiF = true;
                                    this.iiH = a.CMD_UPDATE_VERSION;
                                    this.iiG = true;
                                    aVar = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) gVar.field_reportId, 154);
                                } else {
                                    this.iiF = true;
                                    if (this.iiH == a.NONE) {
                                        this.iiH = a.MISSING_PKG;
                                    }
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    } else {
                        ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "call, preferVersion[%d], attrs.appVersion[%d], forceSync", Integer.valueOf(this.iiE), Integer.valueOf(aHB.ayL().axy));
                        this.iiF = true;
                        this.iiH = a.VERSION_NOT_FOUND;
                    }
                }
            }
        }
        ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getAttrs, awaitCgi=%B, fallbackIfCgiFailed=%B, reason=%d", Boolean.valueOf(this.iiF), Boolean.valueOf(this.iiG), Integer.valueOf(this.iiH.ordinal()));
        long anU = bo.anU();
        if (bo.isNullOrNil(this.username)) {
            aa = com.tencent.mm.plugin.appbrand.config.r.aa(this.appId, this.iiF);
        } else {
            aa = com.tencent.mm.plugin.appbrand.config.r.ab(this.username, this.iiF);
        }
        if (aa.first == null) {
            objArr = new Object[1];
            if (aa.second == null) {
                yVar = "";
            } else {
                yVar = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((com.tencent.mm.ai.a.a) aa.second).errType), Integer.valueOf(((com.tencent.mm.ai.a.a) aa.second).errCode)});
            }
            objArr[0] = yVar;
            ag.Ck(ag.getMMString(R.string.m9, objArr));
            com.tencent.mm.plugin.appbrand.report.c.K("", 7, this.har + 1);
        } else {
            long anU2 = bo.anU() - anU;
            if (aa.second != null) {
                y.a(y.b.SYNC_GET_ATTRS, this.appId, ((WxaAttributes) aa.first).ayL().axy, this.har, this.cDB, anU2);
            }
        }
        if (this.iiF) {
            if (aa.second == null || ((com.tencent.mm.ai.a.a) aa.second).errType == 0) {
                int i2;
                if (aa.first == null || ((WxaAttributes) aa.first).ayL() == null) {
                    i2 = -1;
                } else {
                    i2 = ((WxaAttributes) aa.first).ayL().axy;
                }
                if (i2 < this.iiI) {
                    ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getInternal, version mismatched attrsVersion[%d], syncVersion[%d]", Integer.valueOf(i2), Integer.valueOf(this.iiI));
                    com.tencent.mm.plugin.report.service.h.pYm.k(648, 2, 1);
                }
            } else {
                if (this.iiG) {
                    ab.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getInternal, await but cgi failed, return result from db");
                    create2 = Pair.create(aHB(), Boolean.FALSE);
                } else {
                    objArr = new Object[1];
                    objArr[0] = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((com.tencent.mm.ai.a.a) aa.second).errType), Integer.valueOf(((com.tencent.mm.ai.a.a) aa.second).errCode)});
                    ag.Ck(ag.getMMString(R.string.m9, objArr));
                    create2 = Pair.create(null, Boolean.TRUE);
                }
                if (f((WxaAttributes) create2.first)) {
                    AppMethodBeat.o(131989);
                    return create2;
                }
                ag.oZ(R.string.ko);
                create2 = Pair.create(null, Boolean.FALSE);
                AppMethodBeat.o(131989);
                return create2;
            }
        }
        create2 = Pair.create(aa.first, Boolean.valueOf(this.iiF));
        if (f((WxaAttributes) create2.first)) {
        }
    }
}
