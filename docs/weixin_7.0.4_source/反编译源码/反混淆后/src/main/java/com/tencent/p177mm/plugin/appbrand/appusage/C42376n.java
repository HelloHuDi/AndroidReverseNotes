package com.tencent.p177mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.C33138j.C33137a;
import com.tencent.p177mm.plugin.appbrand.config.C42406r;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C10172a;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.C31283e;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5141c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Deprecated
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.n */
public final class C42376n extends C7563j<C42375m> implements C26767ag {
    public static final String[] fjY = new String[]{C7563j.m13217a(C42375m.gSs, "AppBrandLocalUsageRecord")};
    private final C4927e gTC;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.n$a */
    public enum C2086a {
        CHATTING,
        USAGE_LIST;

        static {
            AppMethodBeat.m2505o(129574);
        }
    }

    static {
        AppMethodBeat.m2504i(129582);
        AppMethodBeat.m2505o(129582);
    }

    public C42376n(C4927e c4927e) {
        super(c4927e, C42375m.gSs, "AppBrandLocalUsageRecord", C42375m.diI);
        this.gTC = c4927e;
    }

    /* renamed from: aC */
    private static void m74973aC(List<LocalUsageInfo> list) {
        AppMethodBeat.m2504i(129576);
        C5141c ll = C18624c.abi().mo17131ll("100361");
        if (ll.isValid() && C5046bo.getInt((String) ll.dru().get("isOpenBatchAttrSync"), 0) > 0) {
            HashSet hashSet = new HashSet(list.size());
            for (LocalUsageInfo localUsageInfo : list) {
                hashSet.add(localUsageInfo.username);
            }
            ArrayList arrayList = new ArrayList(hashSet.size());
            arrayList.addAll(hashSet);
            C42406r.m75073a(arrayList, C33137a.TASK_BAR);
        }
        AppMethodBeat.m2505o(129576);
    }

    /* renamed from: aE */
    public final boolean mo44539aE(String str, int i) {
        AppMethodBeat.m2504i(129577);
        boolean b = mo67886b(str, i, C2086a.CHATTING);
        AppMethodBeat.m2505o(129577);
        return b;
    }

    /* renamed from: a */
    public final boolean mo67885a(String str, int i, C2086a c2086a) {
        boolean z = false;
        AppMethodBeat.m2504i(129578);
        C4990ab.m7417i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", str, Integer.valueOf(i), c2086a);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129578);
        } else {
            C4925c c42375m = new C42375m();
            c42375m.field_username = str;
            c42375m.field_versionType = i;
            if (super.mo10102b(c42375m, C42375m.gSr)) {
                c42375m.field_updateTime = C5046bo.anT();
                z = super.mo16758a(c42375m.xDa, c42375m, false);
                if (z) {
                    mo15641b("single", 3, null);
                }
                AppMethodBeat.m2505o(129578);
            } else {
                c42375m.field_updateTime = C5046bo.anT();
                super.mo16759a(c42375m, false);
                z = super.mo10102b(c42375m, C42375m.gSr);
                if (z) {
                    this.gTC.mo10108hY("AppBrandLocalUsageRecord", "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + AppBrandGlobalSystemConfig.ayC().hfS + " offset 0)");
                    mo15641b("single", 2, null);
                }
                AppMethodBeat.m2505o(129578);
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo67886b(String str, int i, C2086a c2086a) {
        boolean z = false;
        AppMethodBeat.m2504i(129579);
        C4990ab.m7417i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", str, Integer.valueOf(i), c2086a);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129579);
        } else {
            C42375m c42375m = new C42375m();
            c42375m.field_username = str;
            c42375m.field_versionType = i;
            z = m74972a(c42375m, false, C42375m.gSr);
            if (z) {
                mo15641b("single", 5, null);
            }
            if (z && C2086a.CHATTING == c2086a) {
                C42340f.auT().mo73333aL(str, i);
            }
            if (z && C2086a.CHATTING == c2086a) {
                C45694h.m84422bt(C26842p.m42740zm(str), i);
            }
            AppMethodBeat.m2505o(129579);
        }
        return z;
    }

    /* renamed from: a */
    private boolean m74972a(C42375m c42375m, boolean z, String... strArr) {
        AppMethodBeat.m2504i(129580);
        if (z) {
            boolean a = super.mo10100a((C4925c) c42375m, z, strArr);
            AppMethodBeat.m2505o(129580);
            return a;
        } else if (mo10102b((C4925c) c42375m, strArr)) {
            super.mo10100a((C4925c) c42375m, z, strArr);
            if (mo10102b((C4925c) c42375m, strArr)) {
                AppMethodBeat.m2505o(129580);
                return false;
            }
            AppMethodBeat.m2505o(129580);
            return true;
        } else {
            AppMethodBeat.m2505o(129580);
            return false;
        }
    }

    /* renamed from: nA */
    public final List<LocalUsageInfo> mo44540nA(int i) {
        AppMethodBeat.m2504i(129575);
        Cursor rawQuery = this.gTC.rawQuery("select AppBrandLocalUsageRecord.username,AppBrandLocalUsageRecord.versionType,WxaAttributesTable.nickname,WxaAttributesTable.brandIconURL,WxaAttributesTable.appId,WxaAttributesTable.appInfo,WxaAttributesTable.shortNickname,WxaAttributesTable.versionInfo from AppBrandLocalUsageRecord left outer join WxaAttributesTable on AppBrandLocalUsageRecord.username=WxaAttributesTable.username order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(i, 1) + " offset 0", null);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(129575);
            return null;
        } else if (rawQuery.moveToFirst()) {
            LinkedList linkedList = new LinkedList();
            do {
                String string = rawQuery.getString(0);
                if (!C5046bo.isNullOrNil(string)) {
                    int i2 = rawQuery.getInt(1);
                    String string2 = rawQuery.getString(2);
                    String string3 = rawQuery.getString(3);
                    String string4 = rawQuery.getString(4);
                    C10172a zx = C10172a.m17796zx(rawQuery.getString(5));
                    String string5 = rawQuery.getString(6);
                    C31283e zz = C31283e.m50507zz(rawQuery.getString(7));
                    long j = zx == null ? 0 : zx.haQ;
                    long j2 = (!C33097a.m54090np(i2) || zx == null) ? 0 : zx.haR;
                    linkedList.add(new LocalUsageInfo(string, string4, i2, zz == null ? 0 : zz.axy, string2, string5, string3, false, j, j2));
                }
            } while (rawQuery.moveToNext());
            rawQuery.close();
            List<LocalUsageInfo> arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
            C42376n.m74973aC(arrayList);
            AppMethodBeat.m2505o(129575);
            return arrayList;
        } else {
            rawQuery.close();
            AppMethodBeat.m2505o(129575);
            return null;
        }
    }
}
