package com.tencent.p177mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p711c.C32701m;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C33098x;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p279e.C45513b;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p883c.C19050a;
import com.tencent.p177mm.plugin.appbrand.appusage.C42376n.C2086a;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.w */
public final class C45522w extends C7296k {
    public static final String[] fjY = new String[]{C7563j.m13217a(C26785a.fjX, "AppBrandLauncherLayoutItem")};
    public final C7480h hae;
    final C19118b hao;
    public final C38136c hap = new C38136c(this, (byte) 0);

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.w$b */
    static final class C19118b extends C7563j<C26785a> {
        C19118b(C4927e c4927e) {
            super(c4927e, C26785a.fjX, "AppBrandLauncherLayoutItem", C26785a.diI);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.w$a */
    static final class C26785a extends C32701m {
        static final C4924a fjX;
        static final String[] gSr = new String[]{"brandId", "versionType", "scene"};

        C26785a() {
        }

        /* renamed from: Ag */
        public final C4924a mo4635Ag() {
            return fjX;
        }

        /* renamed from: Hl */
        public final ContentValues mo10098Hl() {
            AppMethodBeat.m2504i(129672);
            this.xDa = 0;
            ContentValues Hl = super.mo10098Hl();
            int A = C45522w.m83923A(this.field_brandId, this.field_versionType, this.field_scene);
            this.field_recordId = A;
            Hl.put("recordId", Integer.valueOf(A));
            AppMethodBeat.m2505o(129672);
            return Hl;
        }

        static {
            AppMethodBeat.m2504i(129673);
            C4924a c4924a = new C4924a();
            c4924a.xDb = new Field[5];
            c4924a.columns = new String[6];
            StringBuilder stringBuilder = new StringBuilder();
            c4924a.columns[0] = "recordId";
            c4924a.xDd.put("recordId", "INTEGER PRIMARY KEY ");
            stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
            stringBuilder.append(", ");
            c4924a.xDc = "recordId";
            c4924a.columns[1] = "brandId";
            c4924a.xDd.put("brandId", "TEXT");
            stringBuilder.append(" brandId TEXT");
            stringBuilder.append(", ");
            c4924a.columns[2] = "versionType";
            c4924a.xDd.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            c4924a.columns[3] = "updateTime";
            c4924a.xDd.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            stringBuilder.append(", ");
            c4924a.columns[4] = "scene";
            c4924a.xDd.put("scene", "INTEGER");
            stringBuilder.append(" scene INTEGER");
            c4924a.columns[5] = "rowid";
            c4924a.sql = stringBuilder.toString();
            fjX = c4924a;
            AppMethodBeat.m2505o(129673);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.w$c */
    public final class C38136c {
        /* synthetic */ C38136c(C45522w c45522w, byte b) {
            this();
        }

        private C38136c() {
        }

        /* renamed from: gi */
        public final ArrayList<AppBrandRecentTaskInfo> mo60877gi(long j) {
            AppMethodBeat.m2504i(129674);
            ArrayList f = C45522w.m83927f(C45522w.this.hae.mo10105a("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s<? ", new Object[]{"scene", "updateTime"}), new String[]{"2", String.valueOf(j)}, null, null, String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[]{"updateTime", Integer.valueOf(30)}), 2));
            AppMethodBeat.m2505o(129674);
            return f;
        }
    }

    /* renamed from: A */
    static /* synthetic */ int m83923A(String str, int i, int i2) {
        AppMethodBeat.m2504i(129693);
        int z = C45522w.m83928z(str, i, i2);
        AppMethodBeat.m2505o(129693);
        return z;
    }

    static {
        AppMethodBeat.m2504i(129694);
        AppMethodBeat.m2505o(129694);
    }

    public C45522w(C7480h c7480h) {
        AppMethodBeat.m2504i(129675);
        this.hae = c7480h;
        this.hao = new C19118b(c7480h);
        AppMethodBeat.m2505o(129675);
    }

    /* renamed from: c */
    public final void mo10116c(C4931a c4931a) {
        AppMethodBeat.m2504i(129676);
        mo10114a(c4931a, C42677e.aNS().oAl.getLooper());
        AppMethodBeat.m2505o(129676);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final Cursor mo73328a(String[] strArr, int i, int i2) {
        AppMethodBeat.m2504i(129678);
        Cursor query = this.hae.query("AppBrandLauncherLayoutItem", strArr, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[]{"scene", "updateTime", Integer.valueOf(i), Integer.valueOf(i2)}), new String[]{"2"}, null, null, null);
        AppMethodBeat.m2505o(129678);
        return query;
    }

    /* renamed from: f */
    public static ArrayList<AppBrandRecentTaskInfo> m83927f(Cursor cursor) {
        AppMethodBeat.m2504i(129679);
        if (cursor == null) {
            ArrayList arrayList = new ArrayList();
            AppMethodBeat.m2505o(129679);
            return arrayList;
        }
        ArrayList<AppBrandRecentTaskInfo> arrayList2;
        if (cursor.moveToFirst()) {
            LinkedList linkedList = new LinkedList();
            C26785a c26785a = new C26785a();
            do {
                c26785a.mo8995d(cursor);
                if (!C5046bo.isNullOrNil(c26785a.field_brandId)) {
                    linkedList.add(C26842p.m42732a(String.valueOf(c26785a.field_recordId), c26785a.field_brandId, c26785a.field_versionType, c26785a.field_updateTime));
                }
            } while (cursor.moveToNext());
            arrayList2 = new ArrayList(linkedList.size());
            arrayList2.addAll(linkedList);
        } else {
            arrayList2 = new ArrayList();
        }
        cursor.close();
        AppMethodBeat.m2505o(129679);
        return arrayList2;
    }

    /* renamed from: nD */
    public final ArrayList<AppBrandRecentTaskInfo> mo73336nD(int i) {
        AppMethodBeat.m2504i(129680);
        ArrayList f = C45522w.m83927f(mo73328a(null, i, 0));
        AppMethodBeat.m2505o(129680);
        return f;
    }

    public final ArrayList<AppBrandRecentTaskInfo> axJ() {
        AppMethodBeat.m2504i(129681);
        ArrayList nD = mo73336nD(Downloads.MIN_WAIT_FOR_NETWORK);
        AppMethodBeat.m2505o(129681);
        return nD;
    }

    /* renamed from: yw */
    public final AppBrandRecentTaskInfo mo73337yw(String str) {
        AppBrandRecentTaskInfo appBrandRecentTaskInfo = null;
        AppMethodBeat.m2504i(129682);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129682);
        } else {
            Cursor query = this.hae.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "recordId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                AppMethodBeat.m2505o(129682);
            } else {
                if (query.moveToFirst()) {
                    C26785a c26785a = new C26785a();
                    c26785a.mo8995d(query);
                    if (!C5046bo.isNullOrNil(c26785a.field_brandId)) {
                        appBrandRecentTaskInfo = C26842p.m42732a(String.valueOf(c26785a.field_recordId), c26785a.field_brandId, c26785a.field_versionType, c26785a.field_updateTime);
                    }
                }
                query.close();
                AppMethodBeat.m2505o(129682);
            }
        }
        return appBrandRecentTaskInfo;
    }

    /* renamed from: yx */
    public final List<String> mo73338yx(String str) {
        AppMethodBeat.m2504i(129683);
        LinkedList linkedList = new LinkedList();
        if (!C5046bo.isNullOrNil(str)) {
            Cursor query = this.hae.query("AppBrandLauncherLayoutItem", new String[]{"recordId"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"scene", "brandId"}), new String[]{"2", str}, null, null, null);
            if (query == null) {
                AppMethodBeat.m2505o(129683);
                return null;
            }
            if (query.moveToFirst()) {
                do {
                    linkedList.add(String.valueOf(query.getInt(query.getColumnIndex("recordId"))));
                } while (query.moveToNext());
            }
            query.close();
        }
        AppMethodBeat.m2505o(129683);
        return linkedList;
    }

    /* renamed from: a */
    private boolean m83925a(String str, int i, boolean z, boolean z2, int i2, int i3, String str2) {
        AppMethodBeat.m2504i(129684);
        if (C5046bo.isNullOrNil(str) || 999 == i) {
            AppMethodBeat.m2505o(129684);
            return false;
        }
        long j;
        boolean z3;
        boolean z4;
        Cursor a = this.hae.mo10104a(String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[]{"updateTime", "AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
        if (a == null) {
            j = 0;
        } else {
            j = 0;
            if (a.moveToFirst()) {
                j = a.getLong(0);
            }
            a.close();
        }
        long max = Math.max(j + 1, C5046bo.anT());
        int z5 = C45522w.m83928z(str, i, 2);
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("updateTime", Long.valueOf(max));
        Object obj = this.hae.update("AppBrandLauncherLayoutItem", contentValues, String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(z5)}) > 0 ? 1 : null;
        if (obj != null) {
            mo15641b("single", 3, String.valueOf(z5));
        }
        if (obj == null) {
            C26785a c26785a = new C26785a();
            c26785a.field_updateTime = max;
            c26785a.field_scene = 2;
            c26785a.field_brandId = str;
            c26785a.field_versionType = i;
            boolean a2 = mo73329a(c26785a);
            if (a2) {
                mo15641b("single", 2, String.valueOf(z5));
            }
            z3 = a2;
            z4 = a2;
        } else {
            z4 = true;
            z3 = false;
        }
        if (z4 && z) {
            Pair x = ((C45513b) C42340f.m74878E(C45513b.class)).mo73325x(str, 3, i2);
            if (((Boolean) x.first).booleanValue()) {
                C4990ab.m7417i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", str, Integer.valueOf(i2));
                C19050a c19050a = C19050a.gWl;
                C19050a.m29623z((long) ((Integer) x.second).intValue(), 165);
            } else {
                new C33106aa(i2, z2, i, 1, str, i3, str2).acy();
            }
        }
        if (z4) {
            C33098x.m54093an(str, i);
        }
        if (z3) {
            axK();
        }
        if (z4) {
            ((C42376n) C42340f.m74878E(C42376n.class)).mo67885a(str, i, C2086a.USAGE_LIST);
        }
        AppMethodBeat.m2505o(129684);
        return z4;
    }

    /* renamed from: aJ */
    private boolean m83926aJ(String str, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(129686);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129686);
            return false;
        }
        if (this.hae.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{String.valueOf(C45522w.m83928z(str, i, 2))}) <= 0) {
            z = false;
        }
        if (z) {
            ((C42376n) C42340f.m74878E(C42376n.class)).mo67886b(str, i, C2086a.USAGE_LIST);
        }
        AppMethodBeat.m2505o(129686);
        return z;
    }

    /* renamed from: a */
    public final boolean mo73330a(String str, int i, boolean z, int i2, int i3, String str2) {
        AppMethodBeat.m2504i(129687);
        boolean a = m83925a(str, i, true, z, i2, i3, str2);
        if (a) {
            C19104i.m29721yt(str2);
        }
        AppMethodBeat.m2505o(129687);
        return a;
    }

    /* renamed from: aK */
    public final void mo73332aK(String str, int i) {
        AppMethodBeat.m2504i(129688);
        m83925a(str, i, false, false, 0, 0, null);
        AppMethodBeat.m2505o(129688);
    }

    /* renamed from: aL */
    public final boolean mo73333aL(String str, int i) {
        AppMethodBeat.m2504i(129689);
        boolean aJ = m83926aJ(str, i);
        if (aJ) {
            C33106aa.m54120aN(str, i).acy();
            mo15641b("single", 5, String.valueOf(C45522w.m83928z(str, i, 2)));
        }
        AppMethodBeat.m2505o(129689);
        return aJ;
    }

    /* renamed from: aM */
    public final boolean mo73334aM(String str, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(129690);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(129690);
            return false;
        }
        String format = String.format("select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "recordId"});
        Cursor a = this.hae.mo10104a(format, new String[]{String.valueOf(C45522w.m83928z(str, i, 2))}, 2);
        if (a == null || a.isClosed()) {
            AppMethodBeat.m2505o(129690);
            return false;
        }
        try {
            if (a.moveToFirst()) {
                if (a.getInt(0) <= 0) {
                    z = false;
                }
                a.close();
                AppMethodBeat.m2505o(129690);
                return z;
            }
            a.close();
            AppMethodBeat.m2505o(129690);
            return false;
        } catch (Throwable th) {
            a.close();
            AppMethodBeat.m2505o(129690);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo73329a(C26785a c26785a) {
        AppMethodBeat.m2504i(129691);
        if (C5046bo.isNullOrNil(c26785a.field_brandId)) {
            AppMethodBeat.m2505o(129691);
            return false;
        }
        long insert = this.hae.insert("AppBrandLauncherLayoutItem", "", c26785a.mo10098Hl());
        if (insert > 0 || insert == ((long) c26785a.field_recordId)) {
            AppMethodBeat.m2505o(129691);
            return true;
        }
        AppMethodBeat.m2505o(129691);
        return false;
    }

    /* renamed from: z */
    private static int m83928z(String str, int i, int i2) {
        AppMethodBeat.m2504i(129692);
        int hashCode = String.format(Locale.US, "%s|%d|%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}).hashCode();
        AppMethodBeat.m2505o(129692);
        return hashCode;
    }

    /* renamed from: aI */
    public final boolean mo73331aI(String str, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(129677);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129677);
            return false;
        }
        Cursor a = this.hae.mo10104a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[]{"AppBrandLauncherLayoutItem", "brandId", "versionType", "scene"}), new String[]{str, String.valueOf(i), "2"}, 0);
        if (a == null) {
            AppMethodBeat.m2505o(129677);
            return false;
        }
        if (!a.moveToFirst()) {
            z = false;
        } else if (a.getInt(0) <= 0) {
            z = false;
        }
        a.close();
        AppMethodBeat.m2505o(129677);
        return z;
    }

    private void axK() {
        int i;
        AppMethodBeat.m2504i(129685);
        Cursor a = this.hae.mo10104a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[]{"AppBrandLauncherLayoutItem", "scene"}), new String[]{"2"}, 0);
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
            a = mo73328a(new String[]{"recordId", "brandId", "versionType"}, BaseClientBuilder.API_PRIORITY_OTHER, Downloads.MIN_WAIT_FOR_NETWORK);
            if (a == null) {
                AppMethodBeat.m2505o(129685);
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
            if (C5046bo.m7548ek(linkedList)) {
                AppMethodBeat.m2505o(129685);
                return;
            }
            String zm;
            long iV = this.hae.mo15639iV(Thread.currentThread().getId());
            for (String zm2 : linkedList) {
                this.hae.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[]{"recordId"}), new String[]{zm2});
            }
            this.hae.mo15640mB(iV);
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            ArrayList arrayList4 = new ArrayList(arrayList.size());
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                zm2 = C26842p.m42740zm((String) arrayList.get(i2));
                if (!C5046bo.isNullOrNil(zm2)) {
                    arrayList3.add(zm2);
                    arrayList4.add(arrayList2.get(i2));
                }
                i = i2 + 1;
            }
            if (C42340f.auV() != null) {
                C42340f.auV().mo60863d(arrayList3, arrayList4);
            }
            mo15641b("batch", 5, linkedList);
        }
        AppMethodBeat.m2505o(129685);
    }
}
