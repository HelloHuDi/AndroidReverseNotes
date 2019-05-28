package com.tencent.p177mm.plugin.appbrand.launching;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1174aa.C41725h;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10100y;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as;
import com.tencent.p177mm.plugin.appbrand.appcache.C19035as.C19036a;
import com.tencent.p177mm.plugin.appbrand.appcache.C31281at;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appcache.C38114b;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.h */
public final class C19573h {
    /* renamed from: bm */
    public static WxaPkgWrappingInfo m30345bm(String str, int i) {
        AppMethodBeat.m2504i(131808);
        int[] xG = C42340f.auV().mo60867xG(str);
        if (xG != null && xG.length > i) {
            while (true) {
                int i2 = i + 1;
                Pair v = C19035as.m29615v(str, 0, xG[i]);
                if (v.first == C19036a.gUI && v.second != null) {
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v.second;
                    AppMethodBeat.m2505o(131808);
                    return wxaPkgWrappingInfo;
                } else if (i2 >= xG.length) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        AppMethodBeat.m2505o(131808);
        return null;
    }

    /* renamed from: cw */
    static boolean m30346cw(String str, String str2) {
        boolean z = true;
        AppMethodBeat.m2504i(131809);
        if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
            AppMethodBeat.m2505o(131809);
            return false;
        }
        C45512ao c45512ao = new C45512ao(str);
        if (!c45512ao.avW()) {
            c45512ao.close();
            AppMethodBeat.m2505o(131809);
            return false;
        } else if (C5046bo.isNullOrNil(str2)) {
            c45512ao.close();
            AppMethodBeat.m2505o(131809);
            return false;
        } else {
            String xm = C38114b.m64486xm(C8874h.m15847bO(str2));
            InputStream xy = c45512ao.mo73324xy(xm);
            if (xy != null) {
                C5046bo.m7527b(xy);
            } else {
                String convertStreamToString = C45672d.convertStreamToString(c45512ao.mo73324xy("app-config.json"));
                if (!C5046bo.isNullOrNil(convertStreamToString)) {
                    try {
                        JSONArray jSONArray = C41725h.m73457lw(convertStreamToString).getJSONArray("pages");
                        int i = 0;
                        while (i < jSONArray.length()) {
                            String string = jSONArray.getString(i);
                            if (C5046bo.isNullOrNil(string) || !xm.startsWith(C38114b.m64486xm(string))) {
                                i++;
                            } else {
                                AppMethodBeat.m2505o(131809);
                                return true;
                            }
                        }
                        z = false;
                    } catch (Exception e) {
                        C4990ab.m7413e("MicroMsg.AppBrand.Launching.CheckPkgLogic", "isFilePathExistsInPkg, parse app-config.json, pkgPath(%s), queryPath(%s), e = %s", str, xm, e);
                    }
                }
                z = false;
            }
            c45512ao.close();
            AppMethodBeat.m2505o(131809);
            return z;
        }
    }

    /* renamed from: a */
    static C31281at m30344a(C10100y c10100y, int i, int i2, String str) {
        AppMethodBeat.m2504i(131810);
        C38105ax auV = C42340f.auV();
        List list;
        if (c10100y == null || C5046bo.isNullOrNil(str)) {
            list = null;
        } else {
            String format = String.format(Locale.US, "select * from %s where %s=? and %s=? and %s=? order by %s desc", new Object[]{"AppBrandWxaPkgManifestRecord", "appId", "debugType", "versionMd5", "version"});
            Cursor rawQuery = auV.gVj.rawQuery(format, new String[]{c10100y.toString(), String.valueOf(i), str});
            if (rawQuery == null || rawQuery.isClosed()) {
                list = null;
            } else if (rawQuery.moveToFirst()) {
                list = new LinkedList();
                do {
                    C31281at c31281at = new C31281at();
                    c31281at.mo8995d(rawQuery);
                    list.add(c31281at);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
                list = null;
            }
        }
        if (list != null) {
            for (C31281at c31281at2 : list) {
                if (c31281at2.field_version != i2) {
                    try {
                        if (str.equals(c31281at2.field_versionMd5) && str.equals(C1178g.m2585b(C5730e.openRead(c31281at2.field_pkgPath), 4096))) {
                            AppMethodBeat.m2505o(131810);
                            return c31281at2;
                        }
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        }
        AppMethodBeat.m2505o(131810);
        return null;
    }
}
