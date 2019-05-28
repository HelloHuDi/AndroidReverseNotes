package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.cwv;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ax {
    public static final String[] gVi = new String[]{j.a(at.fjX, "AppBrandWxaPkgManifestRecord")};
    public final f gVj;
    public final b gVk;

    public enum a {
        DESC,
        ASC;

        static {
            AppMethodBeat.o(101726);
        }
    }

    public static final class b extends j<at> {
        public b(e eVar) {
            super(eVar, at.fjX, "AppBrandWxaPkgManifestRecord", at.diI);
        }
    }

    static {
        AppMethodBeat.i(101759);
        AppMethodBeat.o(101759);
    }

    public ax(f fVar) {
        AppMethodBeat.i(101727);
        this.gVj = fVar;
        this.gVk = new b(fVar);
        AppMethodBeat.o(101727);
    }

    public final int[] xF(String str) {
        AppMethodBeat.i(101728);
        int[] xG = xG(str);
        AppMethodBeat.o(101728);
        return xG;
    }

    public final int[] xG(String str) {
        AppMethodBeat.i(101729);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101729);
            return null;
        } else if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(0)) {
            List<at> a = a(str, 0, a.DESC, "version");
            if (bo.ek(a)) {
                AppMethodBeat.o(101729);
                return null;
            }
            int[] iArr = new int[a.size()];
            int i = 0;
            for (at atVar : a) {
                int i2 = i + 1;
                iArr[i] = atVar.field_version;
                i = i2;
            }
            AppMethodBeat.o(101729);
            return iArr;
        } else {
            AppMethodBeat.o(101729);
            return null;
        }
    }

    /* Access modifiers changed, original: final|varargs */
    public final List<at> a(String str, int i, a aVar, String... strArr) {
        AppMethodBeat.i(101730);
        if (bo.isNullOrNil(str)) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(101730);
            return emptyList;
        }
        Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, "version " + aVar.name(), 2);
        List<at> emptyList2;
        if (a == null) {
            emptyList2 = Collections.emptyList();
            AppMethodBeat.o(101730);
            return emptyList2;
        } else if (a.moveToFirst()) {
            emptyList2 = new LinkedList();
            do {
                at atVar = new at();
                atVar.d(a);
                atVar.field_appId = str;
                atVar.field_debugType = i;
                emptyList2.add(atVar);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.o(101730);
            return emptyList2;
        } else {
            a.close();
            emptyList2 = Collections.emptyList();
            AppMethodBeat.o(101730);
            return emptyList2;
        }
    }

    /* Access modifiers changed, original: final|varargs */
    public final List<at> b(String str, int i, a aVar, String... strArr) {
        AppMethodBeat.i(101731);
        if (bo.isNullOrNil(str)) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(101731);
            return emptyList;
        }
        Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "version"}), new String[]{str, String.valueOf(i)}, null, null, "version " + aVar.name(), 2);
        List<at> emptyList2;
        if (a == null) {
            emptyList2 = Collections.emptyList();
            AppMethodBeat.o(101731);
            return emptyList2;
        } else if (a.moveToFirst()) {
            emptyList2 = new LinkedList();
            do {
                at atVar = new at();
                atVar.d(a);
                atVar.field_appId = str;
                atVar.field_version = i;
                emptyList2.add(atVar);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.o(101731);
            return emptyList2;
        } else {
            a.close();
            emptyList2 = Collections.emptyList();
            AppMethodBeat.o(101731);
            return emptyList2;
        }
    }

    public final at a(String str, int i, int i2, String... strArr) {
        at atVar = null;
        AppMethodBeat.i(101732);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : at.gUR) {
            stringBuilder.append(append).append("=? and ");
        }
        stringBuilder.append("1=1");
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i2)) {
            i = 1;
        }
        Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", bo.Q(strArr) ? null : strArr, stringBuilder.toString(), new String[]{str, String.valueOf(i), String.valueOf(i2)}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(101732);
        } else {
            if (a.moveToFirst()) {
                atVar = new at();
                atVar.d(a);
                atVar.field_appId = str;
            }
            a.close();
            AppMethodBeat.o(101732);
        }
        return atVar;
    }

    public final at a(String str, int i, String... strArr) {
        AppMethodBeat.i(101733);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101733);
            return null;
        }
        String str2;
        String[] strArr2;
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
            str2 = "version desc";
        } else if (com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i)) {
            str2 = "createTime desc";
        } else {
            RuntimeException runtimeException = new RuntimeException("Illegal pkgType ".concat(String.valueOf(i)));
            AppMethodBeat.o(101733);
            throw runtimeException;
        }
        f fVar = this.gVj;
        String str3 = "AppBrandWxaPkgManifestRecord";
        if (bo.Q(strArr)) {
            strArr2 = null;
        } else {
            strArr2 = strArr;
        }
        Cursor query = fVar.query(str3, strArr2, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, str2);
        if (query == null) {
            AppMethodBeat.o(101733);
            return null;
        }
        at atVar = null;
        if (query.moveToFirst()) {
            atVar = new at();
            atVar.d(query);
            atVar.field_appId = str;
            atVar.field_debugType = i;
        }
        query.close();
        AppMethodBeat.o(101733);
        return atVar;
    }

    /* Access modifiers changed, original: final */
    public final boolean xH(String str) {
        AppMethodBeat.i(101734);
        Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", new Object[]{"pkgPath"}), new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(101734);
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.o(101734);
        return moveToFirst;
    }

    /* Access modifiers changed, original: final */
    public final boolean a(cwk cwk, PInt pInt) {
        AppMethodBeat.i(101735);
        if (cwk.version < 0 || bo.isNullOrNil(cwk.url) || bo.isNullOrNil(cwk.cvZ)) {
            ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", Integer.valueOf(cwk.version), cwk.url, cwk.cvZ);
            AppMethodBeat.o(101735);
            return false;
        }
        if (cwk.wPu > 0) {
            ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", Integer.valueOf(cwk.version), Integer.valueOf(this.gVj.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[]{"appId", "debugType", "version"}), new String[]{"@LibraryAppId", AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(cwk.version)})));
            pInt.value = r0;
        }
        boolean a = a("@LibraryAppId", 0, cwk.version, cwk.cvZ, cwk.url);
        AppMethodBeat.o(101735);
        return a;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale"})
    public final List<at> xI(String str) {
        List<at> list = null;
        AppMethodBeat.i(101736);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101736);
        } else {
            Object format;
            if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(0)) {
                format = String.format("order by %s desc", new Object[]{"version"});
            } else {
                String format2 = String.format("order by %s desc", new Object[]{"createTime"});
            }
            String format3 = String.format("limit %d offset %d", new Object[]{Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER), Integer.valueOf(2)});
            Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "version"}, String.format("%s=? and %s=? %s %s", new Object[]{"appId", "debugType", format2, format3}), new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null, 2);
            if (a == null) {
                AppMethodBeat.o(101736);
            } else {
                list = new ArrayList();
                if (a.moveToFirst()) {
                    do {
                        at atVar = new at();
                        atVar.field_appId = str;
                        atVar.field_debugType = 0;
                        atVar.d(a);
                        list.add(atVar);
                    } while (a.moveToNext());
                }
                a.close();
                AppMethodBeat.o(101736);
            }
        }
        return list;
    }

    public final boolean as(String str, int i) {
        AppMethodBeat.i(101737);
        if (bo.isNullOrNil(str) || i < 0) {
            AppMethodBeat.o(101737);
            return false;
        }
        Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(101737);
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.o(101737);
        return moveToFirst;
    }

    public final boolean a(String str, int i, String str2, String str3, long j, long j2) {
        AppMethodBeat.i(101738);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
            AppMethodBeat.o(101738);
            return false;
        }
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Long.valueOf(j2));
        if (i == 999) {
            str = "@LibraryAppId";
        }
        at a = a(str, 1, i, new String[0]);
        if (a == null) {
            at atVar = new at();
            atVar.field_appId = str;
            atVar.field_version = 1;
            atVar.field_debugType = i;
            atVar.field_downloadURL = str2;
            atVar.field_versionMd5 = str3;
            atVar.field_versionState = 0;
            atVar.field_startTime = j;
            atVar.field_endTime = j2;
            atVar.field_createTime = bo.anT();
            b(atVar);
            AppMethodBeat.o(101738);
            return true;
        }
        Object obj = (bo.isNullOrNil(str3) || bo.isNullOrNil(a.field_versionMd5) || str3.equals(a.field_versionMd5)) ? null : 1;
        Object obj2 = !bo.nullAsNil(str2).equals(bo.nullAsNil(a.field_downloadURL)) ? 1 : null;
        if (obj != null) {
            a.field_downloadURL = str2;
            com.tencent.mm.vfs.e.deleteFile(a.field_pkgPath);
            a.field_pkgPath = null;
            a.field_createTime = bo.anT();
            a.field_versionMd5 = str3;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            if (bo.Q(str.split("$"))) {
                w(str, i, 1);
            }
            AppMethodBeat.o(101738);
            return true;
        } else if (obj2 != null) {
            a.field_downloadURL = str2;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            AppMethodBeat.o(101738);
            return false;
        } else {
            AppMethodBeat.o(101738);
            return false;
        }
    }

    public final boolean a(at atVar) {
        AppMethodBeat.i(101739);
        boolean z = !bo.isNullOrNil(atVar.field_appId) && this.gVk.a((c) atVar, at.gUR);
        if (z) {
            w(atVar.field_appId, atVar.field_debugType, atVar.field_version);
        }
        AppMethodBeat.o(101739);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final List<at> awo() {
        List<at> list = null;
        AppMethodBeat.i(101740);
        StringBuilder stringBuilder = new StringBuilder("debugType");
        stringBuilder.append(" in (");
        for (int append : j.gSv) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.append(-1).append(')');
        Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(101740);
        } else if (a.moveToFirst()) {
            list = new ArrayList();
            do {
                at atVar = new at();
                atVar.d(a);
                list.add(atVar);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.o(101740);
        } else {
            a.close();
            AppMethodBeat.o(101740);
        }
        return list;
    }

    public final String at(String str, int i) {
        AppMethodBeat.i(101741);
        at a = a(str, i, "downloadURL");
        String str2;
        if (a == null) {
            str2 = "";
            AppMethodBeat.o(101741);
            return str2;
        }
        str2 = a.field_downloadURL;
        AppMethodBeat.o(101741);
        return str2;
    }

    public final int au(String str, int i) {
        AppMethodBeat.i(101742);
        if (bo.isNullOrNil(str) || !com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
            AppMethodBeat.o(101742);
            return 0;
        }
        at a = a(str, i, "version");
        if (a == null) {
            AppMethodBeat.o(101742);
            return 0;
        }
        int i2 = a.field_version;
        AppMethodBeat.o(101742);
        return i2;
    }

    public final boolean a(String str, int i, int i2, String str2, String str3) {
        AppMethodBeat.i(101743);
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
            ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3);
            int au = au(str, i);
            if (!bo.isNullOrNil(str) && !str.endsWith("__CODELIB__") && i2 < au) {
                ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", Integer.valueOf(i2), Integer.valueOf(au));
                AppMethodBeat.o(101743);
                return false;
            } else if ("@LibraryAppId".equals(str) && i2 == an.VERSION) {
                ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", Integer.valueOf(an.VERSION));
                AppMethodBeat.o(101743);
                return false;
            } else {
                at a = a(str, i2, i, new String[0]);
                boolean z = false;
                if (a == null) {
                    at atVar = new at();
                    atVar.field_appId = str;
                    atVar.field_version = i2;
                    atVar.field_versionMd5 = str2;
                    atVar.field_downloadURL = str3;
                    atVar.field_debugType = i;
                    ab.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", Boolean.valueOf(b(atVar)), str, Integer.valueOf(atVar.field_version), atVar.field_downloadURL, atVar.field_versionMd5);
                    AppMethodBeat.o(101743);
                    return b(atVar);
                }
                Object obj;
                String str4 = a.field_downloadURL;
                String str5 = a.field_versionMd5;
                if (!bo.nullAsNil(a.field_versionMd5).equals(str2)) {
                    a.field_versionMd5 = str2;
                    a.field_version = i2;
                    a.field_downloadURL = str3;
                    obj = 1;
                } else if (bo.isNullOrNil(str3) || str3.equals(a.field_downloadURL)) {
                    obj = null;
                } else {
                    a.field_downloadURL = str3;
                    int obj2 = 1;
                }
                if (obj2 != null) {
                    z = c(a);
                }
                String str6 = "MicroMsg.AppBrandWxaPkgStorage";
                String str7 = "flushWxaPkgVersionInfo, update record %b, appId %s, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s";
                Object[] objArr = new Object[8];
                boolean z2 = obj2 != null && z;
                objArr[0] = Boolean.valueOf(z2);
                objArr[1] = str;
                objArr[2] = Integer.valueOf(au);
                objArr[3] = Integer.valueOf(i2);
                objArr[4] = str4;
                objArr[5] = str3;
                objArr[6] = str5;
                objArr[7] = str2;
                ab.i(str6, str7, objArr);
                if (obj2 == null || !z) {
                    AppMethodBeat.o(101743);
                    return false;
                }
                AppMethodBeat.o(101743);
                return true;
            }
        }
        AppMethodBeat.o(101743);
        return false;
    }

    public final boolean a(String str, cwv cwv, int i) {
        AppMethodBeat.i(101744);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", str, cwv);
            AppMethodBeat.o(101744);
            return false;
        }
        boolean a = a(str, i, cwv.vMG, cwv.xsx, cwv.xsy);
        AppMethodBeat.o(101744);
        return a;
    }

    public final boolean g(String str, int i, String str2) {
        AppMethodBeat.i(101745);
        boolean a = a(str, 0, i, str2, null);
        AppMethodBeat.o(101745);
        return a;
    }

    public final boolean a(String str, WxaAttributes.e eVar) {
        AppMethodBeat.i(101746);
        if (bo.isNullOrNil(str) || eVar == null) {
            ab.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", str, eVar);
            AppMethodBeat.o(101746);
            return false;
        }
        a(str, 0, eVar.axy, eVar.hin);
        az(eVar.hil);
        if (!bo.isNullOrNil(eVar.hiq)) {
            b(str, "__WITHOUT_CODELIB__", eVar.axy, 0, eVar.hiq, 12);
        }
        boolean a = a(str, 0, eVar.axy, eVar.hii, null);
        AppMethodBeat.o(101746);
        return a;
    }

    public final void b(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.i(101747);
        if (bo.isNullOrNil(str3)) {
            ab.e("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutCodeLibInfo withoutLibMd5 null appid:%s,modulename:%s!", str, str2);
            AppMethodBeat.o(101747);
            return;
        }
        String yVar = new y(str, str2, i3).toString();
        if (i2 == 0) {
            a(yVar, i2, i, str3, null);
            AppMethodBeat.o(101747);
            return;
        }
        a(yVar, i2, "", str3, 0, 0);
        AppMethodBeat.o(101747);
    }

    public final void az(List<WxaAttributes.c> list) {
        AppMethodBeat.i(101748);
        if (list != null && list.size() > 0) {
            ab.i("MicroMsg.AppBrandWxaPkgStorage", "updateCodeLibList size:%s", Integer.valueOf(list.size()));
            for (WxaAttributes.c cVar : list) {
                String str = cVar.bIy;
                String str2 = cVar.cvZ;
                int i = cVar.version;
                if (!(com.tencent.magicbrush.c.isNullOrNil(str) || com.tencent.magicbrush.c.isNullOrNil(str2))) {
                    str = new y(str, "__CODELIB__").toString();
                    int[] xG = xG(str);
                    if (xG == null || !com.tencent.mm.compatible.loader.a.contains(xG, i)) {
                        a(str, 0, i, str2, null);
                    } else {
                        ab.i("MicroMsg.AppBrandWxaPkgStorage", "already has this codeLib info version:%s", Integer.valueOf(i));
                    }
                }
            }
        }
        AppMethodBeat.o(101748);
    }

    private boolean b(at atVar) {
        AppMethodBeat.i(101749);
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", atVar.field_appId, Integer.valueOf(atVar.field_debugType), Integer.valueOf(atVar.field_version));
        boolean b = this.gVk.b((c) atVar);
        AppMethodBeat.o(101749);
        return b;
    }

    /* Access modifiers changed, original: final */
    public final int av(String str, int i) {
        AppMethodBeat.i(101750);
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(0)) {
            ab.i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, pkgType %d, pkgVersion %d", str, Integer.valueOf(0), Integer.valueOf(i));
            int delete = this.gVj.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[]{"appId", "debugType", "version"}), new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(i)});
            AppMethodBeat.o(101750);
            return delete;
        }
        AppMethodBeat.o(101750);
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final int aw(String str, int i) {
        AppMethodBeat.i(101751);
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(0)) {
            ab.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] pkgType[%d] pkgVersion[%d]", str, Integer.valueOf(0), Integer.valueOf(i));
            String str2 = "'" + str + '$' + "%%'";
            int delete = this.gVj.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s=? and %s<?", new Object[]{"appId", str2, "debugType", "version"}), new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(i)});
            AppMethodBeat.o(101751);
            return delete;
        }
        AppMethodBeat.o(101751);
        return 0;
    }

    @SuppressLint({"DefaultLocale"})
    public final boolean d(String str, int i, int i2, String str2) {
        AppMethodBeat.i(101752);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101752);
            return false;
        }
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.kR(i)) {
            i2 = 1;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pkgPath", str2);
        if (this.gVj.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str, String.valueOf(i), String.valueOf(i2)}) > 0) {
            AppMethodBeat.o(101752);
            return true;
        }
        AppMethodBeat.o(101752);
        return false;
    }

    public final boolean c(at atVar) {
        AppMethodBeat.i(101753);
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", atVar.field_appId, Integer.valueOf(atVar.field_version), Integer.valueOf(atVar.field_debugType));
        boolean c = this.gVk.c(atVar, at.gUR);
        AppMethodBeat.o(101753);
        return c;
    }

    public final void d(List<String> list, List<Integer> list2) {
        int i = 0;
        AppMethodBeat.i(101754);
        if (list.size() <= 0 || list2.size() <= 0 || list.size() != list2.size()) {
            AppMethodBeat.o(101754);
            return;
        }
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", Integer.valueOf(list.size()));
        long iV = this.gVj.iV(Thread.currentThread().getId());
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                ax((String) list.get(i2), ((Integer) list2.get(i2)).intValue());
                i = i2 + 1;
            } else {
                this.gVj.mB(iV);
                AppMethodBeat.o(101754);
                return;
            }
        }
    }

    public final int ax(String str, int i) {
        AppMethodBeat.i(101755);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101755);
            return 0;
        }
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", str, Integer.valueOf(i));
        String format = String.format("%s=? and %s=?", new Object[]{"appId", "debugType"});
        String[] strArr = new String[]{str, String.valueOf(i)};
        Cursor a = this.gVj.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.o(101755);
            return 0;
        } else if (a.moveToFirst()) {
            LinkedList<String> linkedList = new LinkedList();
            do {
                linkedList.add(a.getString(0));
            } while (a.moveToNext());
            a.close();
            for (String deleteFile : linkedList) {
                com.tencent.mm.vfs.e.deleteFile(deleteFile);
            }
            int delete = this.gVj.delete("AppBrandWxaPkgManifestRecord", format, strArr);
            w(str, i, -1);
            AppMethodBeat.o(101755);
            return delete;
        } else {
            a.close();
            AppMethodBeat.o(101755);
            return 0;
        }
    }

    public final void d(at atVar) {
        AppMethodBeat.i(101756);
        this.gVk.a(atVar);
        AppMethodBeat.o(101756);
    }

    public final boolean a(String str, int i, int i2, List<WxaAttributes.f> list) {
        AppMethodBeat.i(101757);
        if (bo.isNullOrNil(str) || bo.ek(list)) {
            AppMethodBeat.o(101757);
            return false;
        }
        int i3;
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
            i3 = i2;
        } else {
            i3 = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (WxaAttributes.f fVar : list) {
            stringBuilder.append(',').append(fVar.name).append("::").append(fVar.cvZ);
        }
        stringBuilder.append('}');
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", str, Integer.valueOf(i), Integer.valueOf(i3), stringBuilder.toString());
        for (WxaAttributes.f fVar2 : list) {
            String yVar = new y(str, fVar2.name).toString();
            if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
                a(yVar, i, i3, fVar2.cvZ, null);
            } else {
                a(yVar, i, null, fVar2.cvZ, 0, 0);
            }
            String str2 = fVar2.hit;
            if (!(bo.isNullOrNil(fVar2.name) || bo.isNullOrNil(str2))) {
                b(str, fVar2.name, i3, i, str2, 13);
            }
        }
        AppMethodBeat.o(101757);
        return true;
    }

    private boolean w(String str, int i, int i2) {
        AppMethodBeat.i(101758);
        Locale locale = Locale.US;
        String str2 = "where %s like '%s$%%' and %s=%d and %s";
        Object[] objArr = new Object[5];
        objArr[0] = "appId";
        objArr[1] = str;
        objArr[2] = "debugType";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = i2 > 0 ? "version=".concat(String.valueOf(i2)) : "1=1";
        String format = String.format(locale, str2, objArr);
        format = String.format(Locale.US, "delete from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format});
        ab.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        boolean hY = this.gVj.hY("AppBrandWxaPkgManifestRecord", format);
        AppMethodBeat.o(101758);
        return hY;
    }
}
