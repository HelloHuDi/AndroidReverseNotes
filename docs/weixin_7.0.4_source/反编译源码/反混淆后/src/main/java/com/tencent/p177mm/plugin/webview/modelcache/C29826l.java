package com.tencent.p177mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.webview.modelcache.C29822b.C29823a;
import com.tencent.p177mm.plugin.webview.modelcache.C46427e.C40269a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.webview.modelcache.l */
public final class C29826l extends C7563j<C46935g> {
    private static volatile C29826l unR = null;
    private final C4927e bSd;
    public final boolean hrm;

    public static List<C40269a> cYn() {
        AppMethodBeat.m2504i(6844);
        LinkedList linkedList = new LinkedList();
        linkedList.add(new C40269a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[]{C7563j.m13217a(C46935g.ccO, "WebViewResourceCache")}));
        AppMethodBeat.m2505o(6844);
        return linkedList;
    }

    public static C29826l cYo() {
        AppMethodBeat.m2504i(6845);
        C29826l c29826l;
        if (C1720g.m3531RK()) {
            if (unR == null) {
                synchronized (C29826l.class) {
                    try {
                        if (unR == null || !unR.hrm) {
                            unR = new C29826l(C1720g.m3536RP().eJN);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(6845);
                        }
                    }
                }
            }
            c29826l = unR;
            AppMethodBeat.m2505o(6845);
            return c29826l;
        }
        c29826l = new C29826l(null);
        AppMethodBeat.m2505o(6845);
        return c29826l;
    }

    private C29826l(C4927e c4927e) {
        super(c4927e, C46935g.ccO, "WebViewResourceCache", null);
        AppMethodBeat.m2504i(6846);
        this.bSd = c4927e;
        this.hrm = c4927e != null;
        if (!this.hrm) {
            C4990ab.m7412e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
        }
        AppMethodBeat.m2505o(6846);
    }

    /* renamed from: IN */
    static String m47283IN(int i) {
        AppMethodBeat.m2504i(6847);
        String str = "1=1";
        if (!(C29823a.m47280IK(i) && C29823a.m47279IJ(i))) {
            str = String.format(" %s=%s ", new Object[]{"protocol", Integer.valueOf(i)});
        }
        AppMethodBeat.m2505o(6847);
        return str;
    }

    /* renamed from: o */
    public final List<C46935g> mo48050o(String str, String... strArr) {
        List<C46935g> list = null;
        AppMethodBeat.m2504i(6848);
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(6848);
        } else if (rawQuery.moveToFirst()) {
            list = new LinkedList();
            do {
                C46935g c46935g = new C46935g();
                c46935g.mo8995d(rawQuery);
                list.add(c46935g);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            AppMethodBeat.m2505o(6848);
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(6848);
        }
        return list;
    }

    public final boolean checkIsCached(String str, int i) {
        AppMethodBeat.m2504i(6849);
        if (!this.hrm) {
            AppMethodBeat.m2505o(6849);
            return false;
        } else if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(6849);
            return false;
        } else {
            String IN = C29826l.m47283IN(i);
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", IN}), String.valueOf(C4995ag.m7428ck(str).hashCode()));
            if (rawQuery == null) {
                AppMethodBeat.m2505o(6849);
                return false;
            } else if (rawQuery.getCount() > 0) {
                rawQuery.close();
                AppMethodBeat.m2505o(6849);
                return true;
            } else {
                rawQuery.close();
                AppMethodBeat.m2505o(6849);
                return false;
            }
        }
    }

    /* renamed from: a */
    private boolean m47284a(C46935g c46935g) {
        AppMethodBeat.m2504i(6850);
        if (!this.hrm) {
            AppMethodBeat.m2505o(6850);
            return false;
        } else if (C5046bo.isNullOrNil(c46935g.field_url)) {
            C4990ab.m7410d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
            AppMethodBeat.m2505o(6850);
            return false;
        } else {
            String ck = C4995ag.m7428ck(c46935g.field_url);
            if (C5046bo.isNullOrNil(ck)) {
                C4990ab.m7413e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", c46935g.field_url);
                AppMethodBeat.m2505o(6850);
                return false;
            }
            c46935g.field_urlMd5Hashcode = ck.hashCode();
            long anT = C5046bo.anT();
            c46935g.field_accessTime = anT;
            c46935g.field_createTime = anT;
            boolean a = mo16759a((C4925c) c46935g, false);
            AppMethodBeat.m2505o(6850);
            return a;
        }
    }

    public final boolean insert(C46935g c46935g, int i, int i2) {
        AppMethodBeat.m2504i(6851);
        boolean a = m47284a(c46935g);
        AppMethodBeat.m2505o(6851);
        return a;
    }

    public final boolean update(C46935g c46935g, int i, int i2) {
        AppMethodBeat.m2504i(6852);
        boolean b = mo48047b(c46935g);
        AppMethodBeat.m2505o(6852);
        return b;
    }

    /* renamed from: b */
    public final boolean mo48047b(C46935g c46935g) {
        AppMethodBeat.m2504i(6853);
        if (!this.hrm) {
            AppMethodBeat.m2505o(6853);
            return false;
        } else if (C5046bo.isNullOrNil(c46935g.field_url)) {
            C4990ab.m7410d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
            AppMethodBeat.m2505o(6853);
            return false;
        } else {
            long anT = C5046bo.anT();
            c46935g.field_accessTime = anT;
            c46935g.field_createTime = anT;
            C4990ab.m7410d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = ".concat(String.valueOf(c46935g)));
            boolean b = mo16762b(c46935g, false, "urlMd5Hashcode", "appId", "domain", "cacheType", "packageId");
            AppMethodBeat.m2505o(6853);
            return b;
        }
    }
}
