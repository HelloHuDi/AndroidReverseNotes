package com.tencent.p177mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.magicbrush.C37414c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.loader.C32473a;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C10173c;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31284f;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.protobuf.cwk;
import com.tencent.p177mm.protocal.protobuf.cwv;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7293f;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.ax */
public final class C38105ax {
    public static final String[] gVi = new String[]{C7563j.m13217a(C31281at.fjX, "AppBrandWxaPkgManifestRecord")};
    public final C7293f gVj;
    public final C19042b gVk;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ax$a */
    public enum C19041a {
        DESC,
        ASC;

        static {
            AppMethodBeat.m2505o(101726);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.ax$b */
    public static final class C19042b extends C7563j<C31281at> {
        public C19042b(C4927e c4927e) {
            super(c4927e, C31281at.fjX, "AppBrandWxaPkgManifestRecord", C31281at.diI);
        }
    }

    static {
        AppMethodBeat.m2504i(101759);
        AppMethodBeat.m2505o(101759);
    }

    public C38105ax(C7293f c7293f) {
        AppMethodBeat.m2504i(101727);
        this.gVj = c7293f;
        this.gVk = new C19042b(c7293f);
        AppMethodBeat.m2505o(101727);
    }

    /* renamed from: xF */
    public final int[] mo60866xF(String str) {
        AppMethodBeat.m2504i(101728);
        int[] xG = mo60867xG(str);
        AppMethodBeat.m2505o(101728);
        return xG;
    }

    /* renamed from: xG */
    public final int[] mo60867xG(String str) {
        AppMethodBeat.m2504i(101729);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101729);
            return null;
        } else if (C33097a.m54090np(0)) {
            List<C31281at> a = mo60843a(str, 0, C19041a.DESC, "version");
            if (C5046bo.m7548ek(a)) {
                AppMethodBeat.m2505o(101729);
                return null;
            }
            int[] iArr = new int[a.size()];
            int i = 0;
            for (C31281at c31281at : a) {
                int i2 = i + 1;
                iArr[i] = c31281at.field_version;
                i = i2;
            }
            AppMethodBeat.m2505o(101729);
            return iArr;
        } else {
            AppMethodBeat.m2505o(101729);
            return null;
        }
    }

    /* Access modifiers changed, original: final|varargs */
    /* renamed from: a */
    public final List<C31281at> mo60843a(String str, int i, C19041a c19041a, String... strArr) {
        AppMethodBeat.m2504i(101730);
        if (C5046bo.isNullOrNil(str)) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(101730);
            return emptyList;
        }
        Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, "version " + c19041a.name(), 2);
        List<C31281at> emptyList2;
        if (a == null) {
            emptyList2 = Collections.emptyList();
            AppMethodBeat.m2505o(101730);
            return emptyList2;
        } else if (a.moveToFirst()) {
            emptyList2 = new LinkedList();
            do {
                C31281at c31281at = new C31281at();
                c31281at.mo8995d(a);
                c31281at.field_appId = str;
                c31281at.field_debugType = i;
                emptyList2.add(c31281at);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.m2505o(101730);
            return emptyList2;
        } else {
            a.close();
            emptyList2 = Collections.emptyList();
            AppMethodBeat.m2505o(101730);
            return emptyList2;
        }
    }

    /* Access modifiers changed, original: final|varargs */
    /* renamed from: b */
    public final List<C31281at> mo60859b(String str, int i, C19041a c19041a, String... strArr) {
        AppMethodBeat.m2504i(101731);
        if (C5046bo.isNullOrNil(str)) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(101731);
            return emptyList;
        }
        Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "version"}), new String[]{str, String.valueOf(i)}, null, null, "version " + c19041a.name(), 2);
        List<C31281at> emptyList2;
        if (a == null) {
            emptyList2 = Collections.emptyList();
            AppMethodBeat.m2505o(101731);
            return emptyList2;
        } else if (a.moveToFirst()) {
            emptyList2 = new LinkedList();
            do {
                C31281at c31281at = new C31281at();
                c31281at.mo8995d(a);
                c31281at.field_appId = str;
                c31281at.field_version = i;
                emptyList2.add(c31281at);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.m2505o(101731);
            return emptyList2;
        } else {
            a.close();
            emptyList2 = Collections.emptyList();
            AppMethodBeat.m2505o(101731);
            return emptyList2;
        }
    }

    /* renamed from: a */
    public final C31281at mo60841a(String str, int i, int i2, String... strArr) {
        C31281at c31281at = null;
        AppMethodBeat.m2504i(101732);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : C31281at.gUR) {
            stringBuilder.append(append).append("=? and ");
        }
        stringBuilder.append("1=1");
        if (C33097a.m54089kR(i2)) {
            i = 1;
        }
        Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", C5046bo.m7510Q(strArr) ? null : strArr, stringBuilder.toString(), new String[]{str, String.valueOf(i), String.valueOf(i2)}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(101732);
        } else {
            if (a.moveToFirst()) {
                c31281at = new C31281at();
                c31281at.mo8995d(a);
                c31281at.field_appId = str;
            }
            a.close();
            AppMethodBeat.m2505o(101732);
        }
        return c31281at;
    }

    /* renamed from: a */
    public final C31281at mo60842a(String str, int i, String... strArr) {
        AppMethodBeat.m2504i(101733);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101733);
            return null;
        }
        String str2;
        String[] strArr2;
        if (C33097a.m54090np(i)) {
            str2 = "version desc";
        } else if (C33097a.m54089kR(i)) {
            str2 = "createTime desc";
        } else {
            RuntimeException runtimeException = new RuntimeException("Illegal pkgType ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(101733);
            throw runtimeException;
        }
        C7293f c7293f = this.gVj;
        String str3 = "AppBrandWxaPkgManifestRecord";
        if (C5046bo.m7510Q(strArr)) {
            strArr2 = null;
        } else {
            strArr2 = strArr;
        }
        Cursor query = c7293f.query(str3, strArr2, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, str2);
        if (query == null) {
            AppMethodBeat.m2505o(101733);
            return null;
        }
        C31281at c31281at = null;
        if (query.moveToFirst()) {
            c31281at = new C31281at();
            c31281at.mo8995d(query);
            c31281at.field_appId = str;
            c31281at.field_debugType = i;
        }
        query.close();
        AppMethodBeat.m2505o(101733);
        return c31281at;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: xH */
    public final boolean mo60868xH(String str) {
        AppMethodBeat.m2504i(101734);
        Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", new Object[]{"pkgPath"}), new String[]{str}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(101734);
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.m2505o(101734);
        return moveToFirst;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo60845a(cwk cwk, PInt pInt) {
        AppMethodBeat.m2504i(101735);
        if (cwk.version < 0 || C5046bo.isNullOrNil(cwk.url) || C5046bo.isNullOrNil(cwk.cvZ)) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", Integer.valueOf(cwk.version), cwk.url, cwk.cvZ);
            AppMethodBeat.m2505o(101735);
            return false;
        }
        if (cwk.wPu > 0) {
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", Integer.valueOf(cwk.version), Integer.valueOf(this.gVj.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[]{"appId", "debugType", "version"}), new String[]{"@LibraryAppId", AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(cwk.version)})));
            pInt.value = r0;
        }
        boolean a = mo60846a("@LibraryAppId", 0, cwk.version, cwk.cvZ, cwk.url);
        AppMethodBeat.m2505o(101735);
        return a;
    }

    /* Access modifiers changed, original: final */
    @SuppressLint({"DefaultLocale"})
    /* renamed from: xI */
    public final List<C31281at> mo60869xI(String str) {
        List<C31281at> list = null;
        AppMethodBeat.m2504i(101736);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101736);
        } else {
            Object format;
            if (C33097a.m54090np(0)) {
                format = String.format("order by %s desc", new Object[]{"version"});
            } else {
                String format2 = String.format("order by %s desc", new Object[]{"createTime"});
            }
            String format3 = String.format("limit %d offset %d", new Object[]{Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER), Integer.valueOf(2)});
            Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "version"}, String.format("%s=? and %s=? %s %s", new Object[]{"appId", "debugType", format2, format3}), new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO}, null, null, null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(101736);
            } else {
                list = new ArrayList();
                if (a.moveToFirst()) {
                    do {
                        C31281at c31281at = new C31281at();
                        c31281at.field_appId = str;
                        c31281at.field_debugType = 0;
                        c31281at.mo8995d(a);
                        list.add(c31281at);
                    } while (a.moveToNext());
                }
                a.close();
                AppMethodBeat.m2505o(101736);
            }
        }
        return list;
    }

    /* renamed from: as */
    public final boolean mo60851as(String str, int i) {
        AppMethodBeat.m2504i(101737);
        if (C5046bo.isNullOrNil(str) || i < 0) {
            AppMethodBeat.m2505o(101737);
            return false;
        }
        Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(101737);
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.m2505o(101737);
        return moveToFirst;
    }

    /* renamed from: a */
    public final boolean mo60848a(String str, int i, String str2, String str3, long j, long j2) {
        AppMethodBeat.m2504i(101738);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
            AppMethodBeat.m2505o(101738);
            return false;
        }
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Long.valueOf(j2));
        if (i == 999) {
            str = "@LibraryAppId";
        }
        C31281at a = mo60841a(str, 1, i, new String[0]);
        if (a == null) {
            C31281at c31281at = new C31281at();
            c31281at.field_appId = str;
            c31281at.field_version = 1;
            c31281at.field_debugType = i;
            c31281at.field_downloadURL = str2;
            c31281at.field_versionMd5 = str3;
            c31281at.field_versionState = 0;
            c31281at.field_startTime = j;
            c31281at.field_endTime = j2;
            c31281at.field_createTime = C5046bo.anT();
            m64447b(c31281at);
            AppMethodBeat.m2505o(101738);
            return true;
        }
        Object obj = (C5046bo.isNullOrNil(str3) || C5046bo.isNullOrNil(a.field_versionMd5) || str3.equals(a.field_versionMd5)) ? null : 1;
        Object obj2 = !C5046bo.nullAsNil(str2).equals(C5046bo.nullAsNil(a.field_downloadURL)) ? 1 : null;
        if (obj != null) {
            a.field_downloadURL = str2;
            C5730e.deleteFile(a.field_pkgPath);
            a.field_pkgPath = null;
            a.field_createTime = C5046bo.anT();
            a.field_versionMd5 = str3;
            a.field_startTime = j;
            a.field_endTime = j2;
            mo60861c(a);
            if (C5046bo.m7510Q(str.split("$"))) {
                m64448w(str, i, 1);
            }
            AppMethodBeat.m2505o(101738);
            return true;
        } else if (obj2 != null) {
            a.field_downloadURL = str2;
            a.field_startTime = j;
            a.field_endTime = j2;
            mo60861c(a);
            AppMethodBeat.m2505o(101738);
            return false;
        } else {
            AppMethodBeat.m2505o(101738);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo60844a(C31281at c31281at) {
        AppMethodBeat.m2504i(101739);
        boolean z = !C5046bo.isNullOrNil(c31281at.field_appId) && this.gVk.mo16760a((C4925c) c31281at, C31281at.gUR);
        if (z) {
            m64448w(c31281at.field_appId, c31281at.field_debugType, c31281at.field_version);
        }
        AppMethodBeat.m2505o(101739);
        return z;
    }

    /* Access modifiers changed, original: final */
    public final List<C31281at> awo() {
        List<C31281at> list = null;
        AppMethodBeat.m2504i(101740);
        StringBuilder stringBuilder = new StringBuilder("debugType");
        stringBuilder.append(" in (");
        for (int append : C45515j.gSv) {
            stringBuilder.append(append).append(',');
        }
        stringBuilder.append(-1).append(')');
        Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(101740);
        } else if (a.moveToFirst()) {
            list = new ArrayList();
            do {
                C31281at c31281at = new C31281at();
                c31281at.mo8995d(a);
                list.add(c31281at);
            } while (a.moveToNext());
            a.close();
            AppMethodBeat.m2505o(101740);
        } else {
            a.close();
            AppMethodBeat.m2505o(101740);
        }
        return list;
    }

    /* renamed from: at */
    public final String mo60852at(String str, int i) {
        AppMethodBeat.m2504i(101741);
        C31281at a = mo60842a(str, i, "downloadURL");
        String str2;
        if (a == null) {
            str2 = "";
            AppMethodBeat.m2505o(101741);
            return str2;
        }
        str2 = a.field_downloadURL;
        AppMethodBeat.m2505o(101741);
        return str2;
    }

    /* renamed from: au */
    public final int mo60853au(String str, int i) {
        AppMethodBeat.m2504i(101742);
        if (C5046bo.isNullOrNil(str) || !C33097a.m54090np(i)) {
            AppMethodBeat.m2505o(101742);
            return 0;
        }
        C31281at a = mo60842a(str, i, "version");
        if (a == null) {
            AppMethodBeat.m2505o(101742);
            return 0;
        }
        int i2 = a.field_version;
        AppMethodBeat.m2505o(101742);
        return i2;
    }

    /* renamed from: a */
    public final boolean mo60846a(String str, int i, int i2, String str2, String str3) {
        AppMethodBeat.m2504i(101743);
        if (C33097a.m54090np(i)) {
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3);
            int au = mo60853au(str, i);
            if (!C5046bo.isNullOrNil(str) && !str.endsWith("__CODELIB__") && i2 < au) {
                C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", Integer.valueOf(i2), Integer.valueOf(au));
                AppMethodBeat.m2505o(101743);
                return false;
            } else if ("@LibraryAppId".equals(str) && i2 == C38104an.VERSION) {
                C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", Integer.valueOf(C38104an.VERSION));
                AppMethodBeat.m2505o(101743);
                return false;
            } else {
                C31281at a = mo60841a(str, i2, i, new String[0]);
                boolean z = false;
                if (a == null) {
                    C31281at c31281at = new C31281at();
                    c31281at.field_appId = str;
                    c31281at.field_version = i2;
                    c31281at.field_versionMd5 = str2;
                    c31281at.field_downloadURL = str3;
                    c31281at.field_debugType = i;
                    C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, appId %s, version %d, url %s, md5 %s", Boolean.valueOf(m64447b(c31281at)), str, Integer.valueOf(c31281at.field_version), c31281at.field_downloadURL, c31281at.field_versionMd5);
                    AppMethodBeat.m2505o(101743);
                    return m64447b(c31281at);
                }
                Object obj;
                String str4 = a.field_downloadURL;
                String str5 = a.field_versionMd5;
                if (!C5046bo.nullAsNil(a.field_versionMd5).equals(str2)) {
                    a.field_versionMd5 = str2;
                    a.field_version = i2;
                    a.field_downloadURL = str3;
                    obj = 1;
                } else if (C5046bo.isNullOrNil(str3) || str3.equals(a.field_downloadURL)) {
                    obj = null;
                } else {
                    a.field_downloadURL = str3;
                    int obj2 = 1;
                }
                if (obj2 != null) {
                    z = mo60861c(a);
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
                C4990ab.m7417i(str6, str7, objArr);
                if (obj2 == null || !z) {
                    AppMethodBeat.m2505o(101743);
                    return false;
                }
                AppMethodBeat.m2505o(101743);
                return true;
            }
        }
        AppMethodBeat.m2505o(101743);
        return false;
    }

    /* renamed from: a */
    public final boolean mo60850a(String str, cwv cwv, int i) {
        AppMethodBeat.m2504i(101744);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", str, cwv);
            AppMethodBeat.m2505o(101744);
            return false;
        }
        boolean a = mo60846a(str, i, cwv.vMG, cwv.xsx, cwv.xsy);
        AppMethodBeat.m2505o(101744);
        return a;
    }

    /* renamed from: g */
    public final boolean mo60865g(String str, int i, String str2) {
        AppMethodBeat.m2504i(101745);
        boolean a = mo60846a(str, 0, i, str2, null);
        AppMethodBeat.m2505o(101745);
        return a;
    }

    /* renamed from: a */
    public final boolean mo60849a(String str, C31283e c31283e) {
        AppMethodBeat.m2504i(101746);
        if (C5046bo.isNullOrNil(str) || c31283e == null) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", str, c31283e);
            AppMethodBeat.m2505o(101746);
            return false;
        }
        mo60847a(str, 0, c31283e.axy, c31283e.hin);
        mo60858az(c31283e.hil);
        if (!C5046bo.isNullOrNil(c31283e.hiq)) {
            mo60860b(str, "__WITHOUT_CODELIB__", c31283e.axy, 0, c31283e.hiq, 12);
        }
        boolean a = mo60846a(str, 0, c31283e.axy, c31283e.hii, null);
        AppMethodBeat.m2505o(101746);
        return a;
    }

    /* renamed from: b */
    public final void mo60860b(String str, String str2, int i, int i2, String str3, int i3) {
        AppMethodBeat.m2504i(101747);
        if (C5046bo.isNullOrNil(str3)) {
            C4990ab.m7413e("MicroMsg.AppBrandWxaPkgStorage", "updateWithoutCodeLibInfo withoutLibMd5 null appid:%s,modulename:%s!", str, str2);
            AppMethodBeat.m2505o(101747);
            return;
        }
        String c10100y = new C10100y(str, str2, i3).toString();
        if (i2 == 0) {
            mo60846a(c10100y, i2, i, str3, null);
            AppMethodBeat.m2505o(101747);
            return;
        }
        mo60848a(c10100y, i2, "", str3, 0, 0);
        AppMethodBeat.m2505o(101747);
    }

    /* renamed from: az */
    public final void mo60858az(List<C10173c> list) {
        AppMethodBeat.m2504i(101748);
        if (list != null && list.size() > 0) {
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "updateCodeLibList size:%s", Integer.valueOf(list.size()));
            for (C10173c c10173c : list) {
                String str = c10173c.bIy;
                String str2 = c10173c.cvZ;
                int i = c10173c.version;
                if (!(C37414c.isNullOrNil(str) || C37414c.isNullOrNil(str2))) {
                    str = new C10100y(str, "__CODELIB__").toString();
                    int[] xG = mo60867xG(str);
                    if (xG == null || !C32473a.contains(xG, i)) {
                        mo60846a(str, 0, i, str2, null);
                    } else {
                        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "already has this codeLib info version:%s", Integer.valueOf(i));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(101748);
    }

    /* renamed from: b */
    private boolean m64447b(C31281at c31281at) {
        AppMethodBeat.m2504i(101749);
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", c31281at.field_appId, Integer.valueOf(c31281at.field_debugType), Integer.valueOf(c31281at.field_version));
        boolean b = this.gVk.mo10101b((C4925c) c31281at);
        AppMethodBeat.m2505o(101749);
        return b;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: av */
    public final int mo60854av(String str, int i) {
        AppMethodBeat.m2504i(101750);
        if (C33097a.m54090np(0)) {
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "deletePkgsBelowVersion, appId %s, pkgType %d, pkgVersion %d", str, Integer.valueOf(0), Integer.valueOf(i));
            int delete = this.gVj.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s<?", new Object[]{"appId", "debugType", "version"}), new String[]{str, AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(i)});
            AppMethodBeat.m2505o(101750);
            return delete;
        }
        AppMethodBeat.m2505o(101750);
        return 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aw */
    public final int mo60855aw(String str, int i) {
        AppMethodBeat.m2504i(101751);
        if (C33097a.m54090np(0)) {
            C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleListBelowVersion appId[%s] pkgType[%d] pkgVersion[%d]", str, Integer.valueOf(0), Integer.valueOf(i));
            String str2 = "'" + str + '$' + "%%'";
            int delete = this.gVj.delete("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "%s like %s and %s=? and %s<?", new Object[]{"appId", str2, "debugType", "version"}), new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(i)});
            AppMethodBeat.m2505o(101751);
            return delete;
        }
        AppMethodBeat.m2505o(101751);
        return 0;
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: d */
    public final boolean mo60864d(String str, int i, int i2, String str2) {
        AppMethodBeat.m2504i(101752);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101752);
            return false;
        }
        if (C33097a.m54089kR(i)) {
            i2 = 1;
        }
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("pkgPath", str2);
        if (this.gVj.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str, String.valueOf(i), String.valueOf(i2)}) > 0) {
            AppMethodBeat.m2505o(101752);
            return true;
        }
        AppMethodBeat.m2505o(101752);
        return false;
    }

    /* renamed from: c */
    public final boolean mo60861c(C31281at c31281at) {
        AppMethodBeat.m2504i(101753);
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", c31281at.field_appId, Integer.valueOf(c31281at.field_version), Integer.valueOf(c31281at.field_debugType));
        boolean c = this.gVk.mo10103c(c31281at, C31281at.gUR);
        AppMethodBeat.m2505o(101753);
        return c;
    }

    /* renamed from: d */
    public final void mo60863d(List<String> list, List<Integer> list2) {
        int i = 0;
        AppMethodBeat.m2504i(101754);
        if (list.size() <= 0 || list2.size() <= 0 || list.size() != list2.size()) {
            AppMethodBeat.m2505o(101754);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", Integer.valueOf(list.size()));
        long iV = this.gVj.mo15639iV(Thread.currentThread().getId());
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                mo60857ax((String) list.get(i2), ((Integer) list2.get(i2)).intValue());
                i = i2 + 1;
            } else {
                this.gVj.mo15640mB(iV);
                AppMethodBeat.m2505o(101754);
                return;
            }
        }
    }

    /* renamed from: ax */
    public final int mo60857ax(String str, int i) {
        AppMethodBeat.m2504i(101755);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101755);
            return 0;
        }
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", str, Integer.valueOf(i));
        String format = String.format("%s=? and %s=?", new Object[]{"appId", "debugType"});
        String[] strArr = new String[]{str, String.valueOf(i)};
        Cursor a = this.gVj.mo10105a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(101755);
            return 0;
        } else if (a.moveToFirst()) {
            LinkedList<String> linkedList = new LinkedList();
            do {
                linkedList.add(a.getString(0));
            } while (a.moveToNext());
            a.close();
            for (String deleteFile : linkedList) {
                C5730e.deleteFile(deleteFile);
            }
            int delete = this.gVj.delete("AppBrandWxaPkgManifestRecord", format, strArr);
            m64448w(str, i, -1);
            AppMethodBeat.m2505o(101755);
            return delete;
        } else {
            a.close();
            AppMethodBeat.m2505o(101755);
            return 0;
        }
    }

    /* renamed from: d */
    public final void mo60862d(C31281at c31281at) {
        AppMethodBeat.m2504i(101756);
        this.gVk.mo10099a(c31281at);
        AppMethodBeat.m2505o(101756);
    }

    /* renamed from: a */
    public final boolean mo60847a(String str, int i, int i2, List<C31284f> list) {
        AppMethodBeat.m2504i(101757);
        if (C5046bo.isNullOrNil(str) || C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(101757);
            return false;
        }
        int i3;
        if (C33097a.m54090np(i)) {
            i3 = i2;
        } else {
            i3 = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (C31284f c31284f : list) {
            stringBuilder.append(',').append(c31284f.name).append("::").append(c31284f.cvZ);
        }
        stringBuilder.append('}');
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", str, Integer.valueOf(i), Integer.valueOf(i3), stringBuilder.toString());
        for (C31284f c31284f2 : list) {
            String c10100y = new C10100y(str, c31284f2.name).toString();
            if (C33097a.m54090np(i)) {
                mo60846a(c10100y, i, i3, c31284f2.cvZ, null);
            } else {
                mo60848a(c10100y, i, null, c31284f2.cvZ, 0, 0);
            }
            String str2 = c31284f2.hit;
            if (!(C5046bo.isNullOrNil(c31284f2.name) || C5046bo.isNullOrNil(str2))) {
                mo60860b(str, c31284f2.name, i3, i, str2, 13);
            }
        }
        AppMethodBeat.m2505o(101757);
        return true;
    }

    /* renamed from: w */
    private boolean m64448w(String str, int i, int i2) {
        AppMethodBeat.m2504i(101758);
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
        C4990ab.m7417i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        boolean hY = this.gVj.mo10108hY("AppBrandWxaPkgManifestRecord", format);
        AppMethodBeat.m2505o(101758);
        return hY;
    }
}
