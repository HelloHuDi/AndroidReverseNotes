package com.tencent.mm.plugin.appbrand.appusage;

import a.a.t;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.c.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class s extends k {
    public static final String[] fjY = new String[]{j.a(a.fjX, "AppBrandStarApp")};
    private static final b<cwq> hag = new b<cwq>() {
        public final /* bridge */ /* synthetic */ long bo(Object obj) {
            return (long) ((cwq) obj).vWx;
        }

        public final /* bridge */ /* synthetic */ int bp(Object obj) {
            return ((cwq) obj).vOO;
        }

        public final /* bridge */ /* synthetic */ String bq(Object obj) {
            return ((cwq) obj).username;
        }
    };
    private static final b<LocalUsageInfo> hah = new b<LocalUsageInfo>() {
        public final /* bridge */ /* synthetic */ long bo(Object obj) {
            return 0;
        }

        public final /* bridge */ /* synthetic */ int bp(Object obj) {
            return ((LocalUsageInfo) obj).har;
        }

        public final /* bridge */ /* synthetic */ String bq(Object obj) {
            return ((LocalUsageInfo) obj).username;
        }
    };
    final h hae;
    private final c haf;

    public static final class a extends p {
        static final com.tencent.mm.sdk.e.c.a fjX;
        static final String[] gSr = new String[]{"username", "versionType"};

        public final com.tencent.mm.sdk.e.c.a Ag() {
            return fjX;
        }

        static {
            int i = 0;
            AppMethodBeat.i(129644);
            com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
            aVar.xDb = new Field[4];
            aVar.columns = new String[5];
            StringBuilder stringBuilder = new StringBuilder();
            aVar.columns[0] = "username";
            aVar.xDd.put("username", "TEXT");
            stringBuilder.append(" username TEXT");
            stringBuilder.append(", ");
            aVar.columns[1] = "versionType";
            aVar.xDd.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            aVar.columns[2] = "updateTime";
            aVar.xDd.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            stringBuilder.append(", ");
            aVar.columns[3] = "orderSequence";
            aVar.xDd.put("orderSequence", "LONG");
            stringBuilder.append(" orderSequence LONG");
            aVar.columns[4] = "rowid";
            aVar.sql = stringBuilder.toString();
            fjX = aVar;
            String str = " PRIMARY KEY ( ";
            String[] strArr = gSr;
            int length = strArr.length;
            while (i < length) {
                str = str + ", " + strArr[i];
                i++;
            }
            String str2 = str.replaceFirst(",", "") + " )";
            StringBuilder stringBuilder2 = new StringBuilder();
            com.tencent.mm.sdk.e.c.a aVar2 = fjX;
            aVar2.sql = stringBuilder2.append(aVar2.sql).append(",").append(str2).toString();
            AppMethodBeat.o(129644);
        }
    }

    static final class c extends j<a> {
        c(h hVar) {
            super(hVar, a.fjX, "AppBrandStarApp", a.diI);
        }
    }

    interface b<T> {
        long bo(T t);

        int bp(T t);

        String bq(T t);
    }

    static {
        AppMethodBeat.i(129656);
        AppMethodBeat.o(129656);
    }

    public s(h hVar) {
        AppMethodBeat.i(129645);
        this.hae = hVar;
        this.haf = new c(hVar);
        AppMethodBeat.o(129645);
    }

    public final void c(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(129646);
        a(aVar, e.aNS().oAl.getLooper());
        AppMethodBeat.o(129646);
    }

    public final int axF() {
        int i = 0;
        AppMethodBeat.i(129647);
        Cursor a = this.hae.a("select count(*) from AppBrandStarApp", null, 0);
        if (a == null || a.isClosed()) {
            AppMethodBeat.o(129647);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(129647);
        }
        return i;
    }

    public final ArrayList<AppBrandRecentTaskInfo> a(com.tencent.mm.plugin.appbrand.appusage.af.a aVar) {
        AppMethodBeat.i(129648);
        ArrayList b = b(-1, aVar);
        AppMethodBeat.o(129648);
        return b;
    }

    public final ArrayList<AppBrandRecentTaskInfo> b(int i, com.tencent.mm.plugin.appbrand.appusage.af.a aVar) {
        ArrayList<AppBrandRecentTaskInfo> arrayList = null;
        AppMethodBeat.i(129649);
        if (aVar == null) {
            aVar = com.tencent.mm.plugin.appbrand.appusage.af.a.DESC;
        }
        if (aVar == com.tencent.mm.plugin.appbrand.appusage.af.a.UPATE_TIME_DESC) {
            ArrayList nB = nB(i);
            AppMethodBeat.o(129649);
            return nB;
        }
        int axI;
        if (i <= 0) {
            axI = t.axI();
        } else {
            axI = Math.min(t.axI(), i);
        }
        Cursor query = this.hae.query("AppBrandStarApp", new String[]{"username", "versionType"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset 0", new Object[]{"orderSequence", Integer.valueOf(axI)}));
        if (query == null) {
            AppMethodBeat.o(129649);
            return null;
        }
        if (com.tencent.mm.plugin.appbrand.appusage.af.a.ASC != aVar ? !query.moveToFirst() : !query.moveToLast()) {
            LinkedList linkedList = new LinkedList();
            a aVar2 = new a();
            while (true) {
                aVar2.d(query);
                linkedList.add(com.tencent.mm.plugin.appbrand.config.p.a(String.format(Locale.US, "$%s$%d@starapp", new Object[]{aVar2.field_username, Integer.valueOf(aVar2.field_versionType)}), aVar2.field_username, aVar2.field_versionType, -1));
                if (com.tencent.mm.plugin.appbrand.appusage.af.a.ASC == aVar) {
                    if (!query.moveToPrevious()) {
                        break;
                    }
                } else if (!query.moveToNext()) {
                    break;
                }
            }
            arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
        }
        query.close();
        AppMethodBeat.o(129649);
        return arrayList;
    }

    private ArrayList<AppBrandRecentTaskInfo> nB(int i) {
        AppMethodBeat.i(129650);
        Cursor a = this.hae.a("select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(i, 1) + " offset 0", null, 0);
        if (a == null) {
            AppMethodBeat.o(129650);
            return null;
        } else if (a.moveToFirst()) {
            LinkedList linkedList = new LinkedList();
            do {
                String string = a.getString(0);
                if (!bo.isNullOrNil(string)) {
                    linkedList.add(com.tencent.mm.plugin.appbrand.config.p.a(String.format(Locale.US, "$%s$%d@starapp", new Object[]{string, Integer.valueOf(r3)}), string, a.getInt(1), a.getLong(2)));
                }
            } while (a.moveToNext());
            a.close();
            ArrayList<AppBrandRecentTaskInfo> arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
            AppMethodBeat.o(129650);
            return arrayList;
        } else {
            a.close();
            AppMethodBeat.o(129650);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    public final <T> void a(Class<T> cls, List<T> list, Long l) {
        b bVar;
        AppMethodBeat.i(129652);
        if (cls == cwq.class) {
            bVar = hag;
        } else if (cls == LocalUsageInfo.class) {
            bVar = hah;
        } else {
            AppMethodBeat.o(129652);
            return;
        }
        long iV = this.hae.iV(Thread.currentThread().getId());
        this.hae.delete("AppBrandStarApp", "", null);
        if (!bo.ek(list)) {
            List l2;
            if (list != null) {
                l2 = t.l(list);
            } else {
                l2 = null;
            }
            a aVar = new a();
            int i = 0;
            for (Object next : l2) {
                if (!bo.isNullOrNil(bVar.bq(next))) {
                    aVar.field_username = bVar.bq(next);
                    aVar.field_versionType = bVar.bp(next);
                    aVar.field_updateTime = bVar.bo(next);
                    i++;
                    aVar.field_orderSequence = ((long) i) * ((long) (t.axI() * 2));
                    this.hae.insert("AppBrandStarApp", null, aVar.Hl());
                }
            }
        }
        this.hae.mB(iV);
        b("batch", 3, l);
        AppMethodBeat.o(129652);
    }

    public final int aG(String str, int i) {
        int i2 = 1;
        AppMethodBeat.i(129653);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129653);
            return -1;
        }
        int i3;
        long j;
        if (com.tencent.mm.plugin.appbrand.appcache.j.a.np(i)) {
            WxaAttributes d = f.auO().d(str, "appInfo");
            if (d == null || TextUtils.isEmpty(d.field_appInfo)) {
                i3 = 0;
            } else {
                ab.i("MicroMsg.AppBrandStarAppStorage", "checkIsAddStarBlocked username[%s] until[%d] now[%d]", str, Long.valueOf(d.ayJ().haR), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
                i3 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) < d.ayJ().haR ? 1 : 0;
            }
            if (i3 != 0) {
                AppMethodBeat.o(129653);
                return -3;
            }
        }
        long anT = bo.anT();
        Cursor a = this.hae.a(String.format(Locale.US, "select %s from %s order by %s desc limit 1 offset 0", new Object[]{"orderSequence", "AppBrandStarApp", "orderSequence"}), null, 2);
        if (a == null || a.isClosed()) {
            j = 0;
        } else {
            if (a.moveToFirst()) {
                j = a.getLong(0);
            } else {
                j = 0;
            }
            a.close();
        }
        j += (long) (t.axI() * 2);
        if (!aF(str, i)) {
            if (axF() >= t.axI()) {
                AppMethodBeat.o(129653);
                return -2;
            }
            a aVar = new a();
            aVar.field_username = str;
            aVar.field_versionType = i;
            aVar.field_updateTime = anT;
            aVar.field_orderSequence = j;
            this.haf.a((com.tencent.mm.sdk.e.c) aVar, false);
            if (aF(str, i)) {
                b("single", 2, aVar);
                i3 = 1;
            } else {
                i3 = 0;
            }
            i2 = i3;
        }
        if (i2 != 0) {
            cda cda = new cda();
            cda.username = str;
            cda.vOO = i;
            ((c) g.K(c.class)).a(z.a(cda), com.tencent.mm.plugin.appbrand.appusage.z.b.History);
        }
        if (i2 != 0) {
            AppMethodBeat.o(129653);
            return 0;
        }
        AppMethodBeat.o(129653);
        return -1;
    }

    public final boolean aH(String str, int i) {
        AppMethodBeat.i(129654);
        boolean j = j(str, i, true);
        AppMethodBeat.o(129654);
        return j;
    }

    public final boolean j(String str, int i, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(129655);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129655);
            return false;
        }
        a aVar = new a();
        aVar.field_username = str;
        aVar.field_versionType = i;
        if (this.haf.b((com.tencent.mm.sdk.e.c) aVar, "versionType", "username")) {
            this.haf.a((com.tencent.mm.sdk.e.c) aVar, false, a.gSr);
            if (aF(str, i)) {
                z2 = false;
            } else {
                b("single", 5, aVar);
            }
        }
        if (z2 && z) {
            cda cda = new cda();
            cda.username = str;
            cda.vOO = i;
            ((c) g.K(c.class)).a(z.b(cda), com.tencent.mm.plugin.appbrand.appusage.z.b.History);
        }
        AppMethodBeat.o(129655);
        return z2;
    }

    public final boolean aF(String str, int i) {
        Cursor cursor = null;
        AppMethodBeat.i(129651);
        if (!bo.isNullOrNil(str)) {
            cursor = this.hae.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"username", "versionType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        }
        if (cursor == null) {
            AppMethodBeat.o(129651);
            return false;
        }
        boolean moveToFirst = cursor.moveToFirst();
        cursor.close();
        AppMethodBeat.o(129651);
        return moveToFirst;
    }
}
