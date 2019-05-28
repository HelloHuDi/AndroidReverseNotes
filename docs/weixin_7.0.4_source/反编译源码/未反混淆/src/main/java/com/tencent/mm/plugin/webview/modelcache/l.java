package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.modelcache.e.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class l extends j<g> {
    private static volatile l unR = null;
    private final e bSd;
    public final boolean hrm;

    public static List<a> cYn() {
        AppMethodBeat.i(6844);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[]{j.a(g.ccO, "WebViewResourceCache")}));
        AppMethodBeat.o(6844);
        return linkedList;
    }

    public static l cYo() {
        AppMethodBeat.i(6845);
        l lVar;
        if (g.RK()) {
            if (unR == null) {
                synchronized (l.class) {
                    try {
                        if (unR == null || !unR.hrm) {
                            unR = new l(g.RP().eJN);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(6845);
                        }
                    }
                }
            }
            lVar = unR;
            AppMethodBeat.o(6845);
            return lVar;
        }
        lVar = new l(null);
        AppMethodBeat.o(6845);
        return lVar;
    }

    private l(e eVar) {
        super(eVar, g.ccO, "WebViewResourceCache", null);
        AppMethodBeat.i(6846);
        this.bSd = eVar;
        this.hrm = eVar != null;
        if (!this.hrm) {
            ab.e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
        }
        AppMethodBeat.o(6846);
    }

    static String IN(int i) {
        AppMethodBeat.i(6847);
        String str = "1=1";
        if (!(b.a.IK(i) && b.a.IJ(i))) {
            str = String.format(" %s=%s ", new Object[]{"protocol", Integer.valueOf(i)});
        }
        AppMethodBeat.o(6847);
        return str;
    }

    public final List<g> o(String str, String... strArr) {
        List<g> list = null;
        AppMethodBeat.i(6848);
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery == null) {
            AppMethodBeat.o(6848);
        } else if (rawQuery.moveToFirst()) {
            list = new LinkedList();
            do {
                g gVar = new g();
                gVar.d(rawQuery);
                list.add(gVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.o(6848);
        } else {
            rawQuery.close();
            AppMethodBeat.o(6848);
        }
        return list;
    }

    public final boolean checkIsCached(String str, int i) {
        AppMethodBeat.i(6849);
        if (!this.hrm) {
            AppMethodBeat.o(6849);
            return false;
        } else if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(6849);
            return false;
        } else {
            String IN = IN(i);
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", IN}), String.valueOf(ag.ck(str).hashCode()));
            if (rawQuery == null) {
                AppMethodBeat.o(6849);
                return false;
            } else if (rawQuery.getCount() > 0) {
                rawQuery.close();
                AppMethodBeat.o(6849);
                return true;
            } else {
                rawQuery.close();
                AppMethodBeat.o(6849);
                return false;
            }
        }
    }

    private boolean a(g gVar) {
        AppMethodBeat.i(6850);
        if (!this.hrm) {
            AppMethodBeat.o(6850);
            return false;
        } else if (bo.isNullOrNil(gVar.field_url)) {
            ab.d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
            AppMethodBeat.o(6850);
            return false;
        } else {
            String ck = ag.ck(gVar.field_url);
            if (bo.isNullOrNil(ck)) {
                ab.e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", gVar.field_url);
                AppMethodBeat.o(6850);
                return false;
            }
            gVar.field_urlMd5Hashcode = ck.hashCode();
            long anT = bo.anT();
            gVar.field_accessTime = anT;
            gVar.field_createTime = anT;
            boolean a = a((c) gVar, false);
            AppMethodBeat.o(6850);
            return a;
        }
    }

    public final boolean insert(g gVar, int i, int i2) {
        AppMethodBeat.i(6851);
        boolean a = a(gVar);
        AppMethodBeat.o(6851);
        return a;
    }

    public final boolean update(g gVar, int i, int i2) {
        AppMethodBeat.i(6852);
        boolean b = b(gVar);
        AppMethodBeat.o(6852);
        return b;
    }

    public final boolean b(g gVar) {
        AppMethodBeat.i(6853);
        if (!this.hrm) {
            AppMethodBeat.o(6853);
            return false;
        } else if (bo.isNullOrNil(gVar.field_url)) {
            ab.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
            AppMethodBeat.o(6853);
            return false;
        } else {
            long anT = bo.anT();
            gVar.field_accessTime = anT;
            gVar.field_createTime = anT;
            ab.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = ".concat(String.valueOf(gVar)));
            boolean b = b(gVar, false, "urlMd5Hashcode", "appId", "domain", "cacheType", "packageId");
            AppMethodBeat.o(6853);
            return b;
        }
    }
}
