package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

public final class h {
    public static WxaPkgWrappingInfo bm(String str, int i) {
        AppMethodBeat.i(131808);
        int[] xG = f.auV().xG(str);
        if (xG != null && xG.length > i) {
            while (true) {
                int i2 = i + 1;
                Pair v = as.v(str, 0, xG[i]);
                if (v.first == a.gUI && v.second != null) {
                    WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) v.second;
                    AppMethodBeat.o(131808);
                    return wxaPkgWrappingInfo;
                } else if (i2 >= xG.length) {
                    break;
                } else {
                    i = i2;
                }
            }
        }
        AppMethodBeat.o(131808);
        return null;
    }

    static boolean cw(String str, String str2) {
        boolean z = true;
        AppMethodBeat.i(131809);
        if (bo.isNullOrNil(str) || !e.ct(str)) {
            AppMethodBeat.o(131809);
            return false;
        }
        ao aoVar = new ao(str);
        if (!aoVar.avW()) {
            aoVar.close();
            AppMethodBeat.o(131809);
            return false;
        } else if (bo.isNullOrNil(str2)) {
            aoVar.close();
            AppMethodBeat.o(131809);
            return false;
        } else {
            String xm = b.xm(com.tencent.luggage.g.h.bO(str2));
            InputStream xy = aoVar.xy(xm);
            if (xy != null) {
                bo.b(xy);
            } else {
                String convertStreamToString = d.convertStreamToString(aoVar.xy("app-config.json"));
                if (!bo.isNullOrNil(convertStreamToString)) {
                    try {
                        JSONArray jSONArray = com.tencent.mm.aa.h.lw(convertStreamToString).getJSONArray("pages");
                        int i = 0;
                        while (i < jSONArray.length()) {
                            String string = jSONArray.getString(i);
                            if (bo.isNullOrNil(string) || !xm.startsWith(b.xm(string))) {
                                i++;
                            } else {
                                AppMethodBeat.o(131809);
                                return true;
                            }
                        }
                        z = false;
                    } catch (Exception e) {
                        ab.e("MicroMsg.AppBrand.Launching.CheckPkgLogic", "isFilePathExistsInPkg, parse app-config.json, pkgPath(%s), queryPath(%s), e = %s", str, xm, e);
                    }
                }
                z = false;
            }
            aoVar.close();
            AppMethodBeat.o(131809);
            return z;
        }
    }

    static at a(y yVar, int i, int i2, String str) {
        AppMethodBeat.i(131810);
        ax auV = f.auV();
        List list;
        if (yVar == null || bo.isNullOrNil(str)) {
            list = null;
        } else {
            String format = String.format(Locale.US, "select * from %s where %s=? and %s=? and %s=? order by %s desc", new Object[]{"AppBrandWxaPkgManifestRecord", "appId", "debugType", "versionMd5", "version"});
            Cursor rawQuery = auV.gVj.rawQuery(format, new String[]{yVar.toString(), String.valueOf(i), str});
            if (rawQuery == null || rawQuery.isClosed()) {
                list = null;
            } else if (rawQuery.moveToFirst()) {
                list = new LinkedList();
                do {
                    at atVar = new at();
                    atVar.d(rawQuery);
                    list.add(atVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
                list = null;
            }
        }
        if (list != null) {
            for (at atVar2 : list) {
                if (atVar2.field_version != i2) {
                    try {
                        if (str.equals(atVar2.field_versionMd5) && str.equals(g.b(e.openRead(atVar2.field_pkgPath), 4096))) {
                            AppMethodBeat.o(131810);
                            return atVar2;
                        }
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        }
        AppMethodBeat.o(131810);
        return null;
    }
}
