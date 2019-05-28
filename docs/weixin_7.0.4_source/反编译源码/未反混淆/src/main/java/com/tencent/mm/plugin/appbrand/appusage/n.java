package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class n extends j<m> implements ag {
    public static final String[] fjY = new String[]{j.a(m.gSs, "AppBrandLocalUsageRecord")};
    private final e gTC;

    public enum a {
        CHATTING,
        USAGE_LIST;

        static {
            AppMethodBeat.o(129574);
        }
    }

    static {
        AppMethodBeat.i(129582);
        AppMethodBeat.o(129582);
    }

    public n(e eVar) {
        super(eVar, m.gSs, "AppBrandLocalUsageRecord", m.diI);
        this.gTC = eVar;
    }

    private static void aC(List<LocalUsageInfo> list) {
        AppMethodBeat.i(129576);
        c ll = com.tencent.mm.model.c.c.abi().ll("100361");
        if (ll.isValid() && bo.getInt((String) ll.dru().get("isOpenBatchAttrSync"), 0) > 0) {
            HashSet hashSet = new HashSet(list.size());
            for (LocalUsageInfo localUsageInfo : list) {
                hashSet.add(localUsageInfo.username);
            }
            ArrayList arrayList = new ArrayList(hashSet.size());
            arrayList.addAll(hashSet);
            r.a(arrayList, com.tencent.mm.plugin.appbrand.config.j.a.TASK_BAR);
        }
        AppMethodBeat.o(129576);
    }

    public final boolean aE(String str, int i) {
        AppMethodBeat.i(129577);
        boolean b = b(str, i, a.CHATTING);
        AppMethodBeat.o(129577);
        return b;
    }

    public final boolean a(String str, int i, a aVar) {
        boolean z = false;
        AppMethodBeat.i(129578);
        ab.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", str, Integer.valueOf(i), aVar);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129578);
        } else {
            com.tencent.mm.sdk.e.c mVar = new m();
            mVar.field_username = str;
            mVar.field_versionType = i;
            if (super.b(mVar, m.gSr)) {
                mVar.field_updateTime = bo.anT();
                z = super.a(mVar.xDa, mVar, false);
                if (z) {
                    b("single", 3, null);
                }
                AppMethodBeat.o(129578);
            } else {
                mVar.field_updateTime = bo.anT();
                super.a(mVar, false);
                z = super.b(mVar, m.gSr);
                if (z) {
                    this.gTC.hY("AppBrandLocalUsageRecord", "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + AppBrandGlobalSystemConfig.ayC().hfS + " offset 0)");
                    b("single", 2, null);
                }
                AppMethodBeat.o(129578);
            }
        }
        return z;
    }

    /* Access modifiers changed, original: final */
    public final boolean b(String str, int i, a aVar) {
        boolean z = false;
        AppMethodBeat.i(129579);
        ab.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", str, Integer.valueOf(i), aVar);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129579);
        } else {
            m mVar = new m();
            mVar.field_username = str;
            mVar.field_versionType = i;
            z = a(mVar, false, m.gSr);
            if (z) {
                b("single", 5, null);
            }
            if (z && a.CHATTING == aVar) {
                f.auT().aL(str, i);
            }
            if (z && a.CHATTING == aVar) {
                h.bt(p.zm(str), i);
            }
            AppMethodBeat.o(129579);
        }
        return z;
    }

    private boolean a(m mVar, boolean z, String... strArr) {
        AppMethodBeat.i(129580);
        if (z) {
            boolean a = super.a((com.tencent.mm.sdk.e.c) mVar, z, strArr);
            AppMethodBeat.o(129580);
            return a;
        } else if (b((com.tencent.mm.sdk.e.c) mVar, strArr)) {
            super.a((com.tencent.mm.sdk.e.c) mVar, z, strArr);
            if (b((com.tencent.mm.sdk.e.c) mVar, strArr)) {
                AppMethodBeat.o(129580);
                return false;
            }
            AppMethodBeat.o(129580);
            return true;
        } else {
            AppMethodBeat.o(129580);
            return false;
        }
    }

    public final List<LocalUsageInfo> nA(int i) {
        AppMethodBeat.i(129575);
        Cursor rawQuery = this.gTC.rawQuery("select AppBrandLocalUsageRecord.username,AppBrandLocalUsageRecord.versionType,WxaAttributesTable.nickname,WxaAttributesTable.brandIconURL,WxaAttributesTable.appId,WxaAttributesTable.appInfo,WxaAttributesTable.shortNickname,WxaAttributesTable.versionInfo from AppBrandLocalUsageRecord left outer join WxaAttributesTable on AppBrandLocalUsageRecord.username=WxaAttributesTable.username order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(i, 1) + " offset 0", null);
        if (rawQuery == null) {
            AppMethodBeat.o(129575);
            return null;
        } else if (rawQuery.moveToFirst()) {
            LinkedList linkedList = new LinkedList();
            do {
                String string = rawQuery.getString(0);
                if (!bo.isNullOrNil(string)) {
                    int i2 = rawQuery.getInt(1);
                    String string2 = rawQuery.getString(2);
                    String string3 = rawQuery.getString(3);
                    String string4 = rawQuery.getString(4);
                    com.tencent.mm.plugin.appbrand.config.WxaAttributes.a zx = com.tencent.mm.plugin.appbrand.config.WxaAttributes.a.zx(rawQuery.getString(5));
                    String string5 = rawQuery.getString(6);
                    WxaAttributes.e zz = WxaAttributes.e.zz(rawQuery.getString(7));
                    long j = zx == null ? 0 : zx.haQ;
                    long j2 = (!com.tencent.mm.plugin.appbrand.appcache.j.a.np(i2) || zx == null) ? 0 : zx.haR;
                    linkedList.add(new LocalUsageInfo(string, string4, i2, zz == null ? 0 : zz.axy, string2, string5, string3, false, j, j2));
                }
            } while (rawQuery.moveToNext());
            rawQuery.close();
            List<LocalUsageInfo> arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
            aC(arrayList);
            AppMethodBeat.o(129575);
            return arrayList;
        } else {
            rawQuery.close();
            AppMethodBeat.o(129575);
            return null;
        }
    }
}
