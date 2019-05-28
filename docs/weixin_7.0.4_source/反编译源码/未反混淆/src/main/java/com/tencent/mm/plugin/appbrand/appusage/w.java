package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.c.m;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.x;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class w extends k {
    public static final String[] fjY = new String[]{j.a(a.fjX, "AppBrandLauncherLayoutItem")};
    public final h hae;
    final b hao;
    public final c hap = new c(this, (byte) 0);

    static final class b extends j<a> {
        b(e eVar) {
            super(eVar, a.fjX, "AppBrandLauncherLayoutItem", a.diI);
        }
    }

    static final class a extends m {
        static final com.tencent.mm.sdk.e.c.a fjX;
        static final String[] gSr = new String[]{"brandId", "versionType", "scene"};

        a() {
        }

        public final com.tencent.mm.sdk.e.c.a Ag() {
            return fjX;
        }

        public final ContentValues Hl() {
            AppMethodBeat.i(129672);
            this.xDa = 0;
            ContentValues Hl = super.Hl();
            int A = w.A(this.field_brandId, this.field_versionType, this.field_scene);
            this.field_recordId = A;
            Hl.put("recordId", Integer.valueOf(A));
            AppMethodBeat.o(129672);
            return Hl;
        }

        static {
            AppMethodBeat.i(129673);
            com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
            aVar.xDb = new Field[5];
            aVar.columns = new String[6];
            StringBuilder stringBuilder = new StringBuilder();
            aVar.columns[0] = "recordId";
            aVar.xDd.put("recordId", "INTEGER PRIMARY KEY ");
            stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
            stringBuilder.append(", ");
            aVar.xDc = "recordId";
            aVar.columns[1] = "brandId";
            aVar.xDd.put("brandId", "TEXT");
            stringBuilder.append(" brandId TEXT");
            stringBuilder.append(", ");
            aVar.columns[2] = "versionType";
            aVar.xDd.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            aVar.columns[3] = "updateTime";
            aVar.xDd.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            stringBuilder.append(", ");
            aVar.columns[4] = "scene";
            aVar.xDd.put("scene", "INTEGER");
            stringBuilder.append(" scene INTEGER");
            aVar.columns[5] = "rowid";
            aVar.sql = stringBuilder.toString();
            fjX = aVar;
            AppMethodBeat.o(129673);
        }
    }

    public final class c {
        /* synthetic */ c(w wVar, byte b) {
            this();
        }

        private c() {
        }

        public final ArrayList<AppBrandRecentTaskInfo> gi(long j) {
            AppMethodBeat.i(129674);
            ArrayList f = w.f(w.this.hae.a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s<? ", new Object[]{"scene", "updateTime"}), new String[]{"2", String.valueOf(j)}, null, null, String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[]{"updateTime", Integer.valueOf(30)}), 2));
            AppMethodBeat.o(129674);
            return f;
        }
    }

    static /* synthetic */ int A(String str, int i, int i2) {
        AppMethodBeat.i(129693);
        int z = z(str, i, i2);
        AppMethodBeat.o(129693);
        return z;
    }

    static {
        AppMethodBeat.i(129694);
        AppMethodBeat.o(129694);
    }

    public w(h hVar) {
        AppMethodBeat.i(129675);
        this.hae = hVar;
        this.hao = new b(hVar);
        AppMethodBeat.o(129675);
    }

    public final void c(com.tencent.mm.sdk.e.k.a aVar) {
        AppMethodBeat.i(129676);
        a(aVar, com.tencent.mm.plugin.appbrand.s.e.aNS().oAl.getLooper());
        AppMethodBeat.o(129676);
    }

    /* Access modifiers changed, original: final */
    public final Cursor a(String[] strArr, int i, int i2) {
        AppMethodBeat.i(129678);
        Cursor query = this.hae.query("AppBrandLauncherLayoutItem", strArr, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[]{"scene", "updateTime", Integer.valueOf(i), Integer.valueOf(i2)}), new String[]{"2"}, null, null, null);
        AppMethodBeat.o(129678);
        return query;
    }

    public static ArrayList<AppBrandRecentTaskInfo> f(Cursor cursor) {
        AppMethodBeat.i(129679);
        if (cursor == null) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.o(129679);
            return arrayList;
        }
        ArrayList<AppBrandRecentTaskInfo> arrayList2;
        if (cursor.moveToFirst()) {
            LinkedList linkedList = new LinkedList();
            a aVar = new a();
            do {
                aVar.d(cursor);
                if (!bo.isNullOrNil(aVar.field_brandId)) {
                    linkedList.add(p.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime));
                }
            } while (cursor.moveToNext());
            arrayList2 = new ArrayList(linkedList.size());
            arrayList2.addAll(linkedList);
        } else {
            arrayList2 = new ArrayList();
        }
        cursor.close();
        AppMethodBeat.o(129679);
        return arrayList2;
    }

    public final ArrayList<AppBrandRecentTaskInfo> nD(int i) {
        AppMethodBeat.i(129680);
        ArrayList f = f(a(null, i, 0));
        AppMethodBeat.o(129680);
        return f;
    }

    public final ArrayList<AppBrandRecentTaskInfo> axJ() {
        AppMethodBeat.i(129681);
        ArrayList nD = nD(Downloads.MIN_WAIT_FOR_NETWORK);
        AppMethodBeat.o(129681);
        return nD;
    }

    public final AppBrandRecentTaskInfo yw(String str) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo = null;
        AppMethodBeat.i(129682);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129682);
        } else {
            Cursor query = this.hae.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "recordId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                AppMethodBeat.o(129682);
            } else {
                if (query.moveToFirst()) {
                    a aVar = new a();
                    aVar.d(query);
                    if (!bo.isNullOrNil(aVar.field_brandId)) {
                        appBrandRecentTaskInfo = p.a(String.valueOf(aVar.field_recordId), aVar.field_brandId, aVar.field_versionType, aVar.field_updateTime);
                    }
                }
                query.close();
                AppMethodBeat.o(129682);
            }
        }
        return appBrandRecentTaskInfo;
    }

    public final List<String> yx(String str) {
        AppMethodBeat.i(129683);
        LinkedList linkedList = new LinkedList();
        if (!bo.isNullOrNil(str)) {
            Cursor query = this.hae.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "brandId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                AppMethodBeat.o(129683);
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        AppMethodBeat.o(129683);
        return linkedList;
    }

    private boolean a(String str, int i, boolean z, boolean z2, int i2, int i3, String str2) {
        AppMethodBeat.i(129684);
        if (bo.isNullOrNil(str) || 999 == i) {
            AppMethodBeat.o(129684);
            return false;
        }
        long j;
        boolean z3;
        boolean z4;
        Cursor a = this.hae.a(String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[]{"updateTime", "AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            j = 0;
        } else {
            j = 0;
            if (a.moveToFirst()) {
                j = a.getLong(0);
            }
            a.close();
        }
        long max = Math.max(j + 1, bo.anT());
        int z5 = z(str, i, 2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("updateTime", Long.valueOf(max));
        Object obj = this.hae.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(z5)}) > 0 ? 1 : null;
        if (obj != null) {
            b("single", 3, String.valueOf(z5));
        }
        if (obj == null) {
            a aVar = new a();
            aVar.field_updateTime = max;
            aVar.field_scene = 2;
            aVar.field_brandId = str;
            aVar.field_versionType = i;
            boolean a2 = a(aVar);
            if (a2) {
                b("single", 2, String.valueOf(z5));
            }
            z3 = a2;
            z4 = a2;
        } else {
            z4 = true;
            z3 = false;
        }
        if (z4 && z) {
            Pair x = ((com.tencent.mm.plugin.appbrand.appcache.b.e.b) f.E(com.tencent.mm.plugin.appbrand.appcache.b.e.b.class)).x(str, 3, i2);
            if (((Boolean) x.first).booleanValue()) {
                ab.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", str, Integer.valueOf(i2));
                com.tencent.mm.plugin.appbrand.appcache.b.c.a aVar2 = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gWl;
                com.tencent.mm.plugin.appbrand.appcache.b.c.a.z((long) ((Integer) x.second).intValue(), 165);
            } else {
                new aa(i2, z2, i, 1, str, i3, str2).acy();
            }
        }
        if (z4) {
            x.an(str, i);
        }
        if (z3) {
            axK();
        }
        if (z4) {
            ((n) f.E(n.class)).a(str, i, com.tencent.mm.plugin.appbrand.appusage.n.a.USAGE_LIST);
        }
        AppMethodBeat.o(129684);
        return z4;
    }

    private boolean aJ(String str, int i) {
        boolean z = true;
        AppMethodBeat.i(129686);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129686);
            return false;
        }
        if (this.hae.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(z(str, i, 2))}) <= 0) {
            z = false;
        }
        if (z) {
            ((n) f.E(n.class)).b(str, i, com.tencent.mm.plugin.appbrand.appusage.n.a.USAGE_LIST);
        }
        AppMethodBeat.o(129686);
        return z;
    }

    public final boolean a(String str, int i, boolean z, int i2, int i3, String str2) {
        AppMethodBeat.i(129687);
        boolean a = a(str, i, true, z, i2, i3, str2);
        if (a) {
            i.yt(str2);
        }
        AppMethodBeat.o(129687);
        return a;
    }

    public final void aK(String str, int i) {
        AppMethodBeat.i(129688);
        a(str, i, false, false, 0, 0, null);
        AppMethodBeat.o(129688);
    }

    public final boolean aL(String str, int i) {
        AppMethodBeat.i(129689);
        boolean aJ = aJ(str, i);
        if (aJ) {
            aa.aN(str, i).acy();
            b("single", 5, String.valueOf(z(str, i, 2)));
        }
        AppMethodBeat.o(129689);
        return aJ;
    }

    public final boolean aM(String str, int i) {
        boolean z = true;
        AppMethodBeat.i(129690);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(129690);
            return false;
        }
        String format = String.format("select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "recordId"});
        Cursor a = this.hae.a(format, new String[]{String.valueOf(z(str, i, 2))}, 2);
        if (a == null || a.isClosed()) {
            AppMethodBeat.o(129690);
            return false;
        }
        try {
            if (a.moveToFirst()) {
                if (a.getInt(0) <= 0) {
                    z = false;
                }
                a.close();
                AppMethodBeat.o(129690);
                return z;
            }
            a.close();
            AppMethodBeat.o(129690);
            return false;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.o(129690);
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean a(a aVar) {
        AppMethodBeat.i(129691);
        if (bo.isNullOrNil(aVar.field_brandId)) {
            AppMethodBeat.o(129691);
            return false;
        }
        long insert = this.hae.insert("AppBrandLauncherLayoutItem", "", aVar.Hl());
        if (insert > 0 || insert == ((long) aVar.field_recordId)) {
            AppMethodBeat.o(129691);
            return true;
        }
        AppMethodBeat.o(129691);
        return false;
    }

    private static int z(String str, int i, int i2) {
        AppMethodBeat.i(129692);
        int hashCode = String.format(Locale.US, "%s|%d|%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}).hashCode();
        AppMethodBeat.o(129692);
        return hashCode;
    }

    public final boolean aI(String str, int i) {
        boolean z = true;
        AppMethodBeat.i(129677);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(129677);
            return false;
        }
        Cursor a = this.hae.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[]{"AppBrandLauncherLayoutItem", "brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, 0);
        if (a == null) {
            AppMethodBeat.o(129677);
            return false;
        }
        if (!a.moveToFirst()) {
            z = false;
        } else if (a.getInt(0) <= 0) {
            z = false;
        }
        a.close();
        AppMethodBeat.o(129677);
        return z;
    }

    private void axK() {
        int i;
        AppMethodBeat.i(129685);
        Cursor a = this.hae.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            i = 0;
        } else {
            i = 0;
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        if (i > Downloads.MIN_WAIT_FOR_NETWORK) {
            a = a(new String[]{"recordId", "brandId", "versionType"}, BaseClientBuilder.API_PRIORITY_OTHER, Downloads.MIN_WAIT_FOR_NETWORK);
            if (a == null) {
                AppMethodBeat.o(129685);
                return;
            }
            LinkedList<String> linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList(i - 10000);
            ArrayList arrayList2 = new ArrayList(i - 10000);
            if (a.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(a.getInt(0)));
                    arrayList.add(a.getString(1));
                    arrayList2.add(Integer.valueOf(a.getInt(2)));
                } while (a.moveToNext());
            }
            a.close();
            if (bo.ek(linkedList)) {
                AppMethodBeat.o(129685);
                return;
            }
            String zm;
            long iV = this.hae.iV(Thread.currentThread().getId());
            for (String zm2 : linkedList) {
                this.hae.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{zm2});
            }
            this.hae.mB(iV);
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            ArrayList arrayList4 = new ArrayList(arrayList.size());
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                zm2 = p.zm((String) arrayList.get(i2));
                if (!bo.isNullOrNil(zm2)) {
                    arrayList3.add(zm2);
                    arrayList4.add(arrayList2.get(i2));
                }
                i = i2 + 1;
            }
            if (f.auV() != null) {
                f.auV().d(arrayList3, arrayList4);
            }
            b("batch", 5, linkedList);
        }
        AppMethodBeat.o(129685);
    }
}
