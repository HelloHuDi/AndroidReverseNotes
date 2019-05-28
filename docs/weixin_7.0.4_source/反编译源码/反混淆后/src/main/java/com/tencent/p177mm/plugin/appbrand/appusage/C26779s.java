package com.tencent.p177mm.plugin.appbrand.appusage;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p711c.C37856p;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C45515j.C33097a;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C10134z.C10133b;
import com.tencent.p177mm.plugin.appbrand.config.C26842p;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.protocal.protobuf.cda;
import com.tencent.p177mm.protocal.protobuf.cwq;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import p000a.p001a.C25035t;

/* renamed from: com.tencent.mm.plugin.appbrand.appusage.s */
public final class C26779s extends C7296k {
    public static final String[] fjY = new String[]{C7563j.m13217a(C10130a.fjX, "AppBrandStarApp")};
    private static final C26782b<cwq> hag = new C267801();
    private static final C26782b<LocalUsageInfo> hah = new C20872();
    final C7480h hae;
    private final C26781c haf;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.s$2 */
    static class C20872 implements C26782b<LocalUsageInfo> {
        C20872() {
        }

        /* renamed from: bo */
        public final /* bridge */ /* synthetic */ long mo5866bo(Object obj) {
            return 0;
        }

        /* renamed from: bp */
        public final /* bridge */ /* synthetic */ int mo5867bp(Object obj) {
            return ((LocalUsageInfo) obj).har;
        }

        /* renamed from: bq */
        public final /* bridge */ /* synthetic */ String mo5868bq(Object obj) {
            return ((LocalUsageInfo) obj).username;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.s$a */
    public static final class C10130a extends C37856p {
        static final C4924a fjX;
        static final String[] gSr = new String[]{"username", "versionType"};

        /* renamed from: Ag */
        public final C4924a mo4635Ag() {
            return fjX;
        }

        static {
            int i = 0;
            AppMethodBeat.m2504i(129644);
            C4924a c4924a = new C4924a();
            c4924a.xDb = new Field[4];
            c4924a.columns = new String[5];
            StringBuilder stringBuilder = new StringBuilder();
            c4924a.columns[0] = "username";
            c4924a.xDd.put("username", "TEXT");
            stringBuilder.append(" username TEXT");
            stringBuilder.append(", ");
            c4924a.columns[1] = "versionType";
            c4924a.xDd.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            c4924a.columns[2] = "updateTime";
            c4924a.xDd.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            stringBuilder.append(", ");
            c4924a.columns[3] = "orderSequence";
            c4924a.xDd.put("orderSequence", "LONG");
            stringBuilder.append(" orderSequence LONG");
            c4924a.columns[4] = "rowid";
            c4924a.sql = stringBuilder.toString();
            fjX = c4924a;
            String str = " PRIMARY KEY ( ";
            String[] strArr = gSr;
            int length = strArr.length;
            while (i < length) {
                str = str + ", " + strArr[i];
                i++;
            }
            String str2 = str.replaceFirst(",", "") + " )";
            StringBuilder stringBuilder2 = new StringBuilder();
            C4924a c4924a2 = fjX;
            c4924a2.sql = stringBuilder2.append(c4924a2.sql).append(",").append(str2).toString();
            AppMethodBeat.m2505o(129644);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.s$1 */
    static class C267801 implements C26782b<cwq> {
        C267801() {
        }

        /* renamed from: bo */
        public final /* bridge */ /* synthetic */ long mo5866bo(Object obj) {
            return (long) ((cwq) obj).vWx;
        }

        /* renamed from: bp */
        public final /* bridge */ /* synthetic */ int mo5867bp(Object obj) {
            return ((cwq) obj).vOO;
        }

        /* renamed from: bq */
        public final /* bridge */ /* synthetic */ String mo5868bq(Object obj) {
            return ((cwq) obj).username;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.s$c */
    static final class C26781c extends C7563j<C10130a> {
        C26781c(C7480h c7480h) {
            super(c7480h, C10130a.fjX, "AppBrandStarApp", C10130a.diI);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.s$b */
    interface C26782b<T> {
        /* renamed from: bo */
        long mo5866bo(T t);

        /* renamed from: bp */
        int mo5867bp(T t);

        /* renamed from: bq */
        String mo5868bq(T t);
    }

    static {
        AppMethodBeat.m2504i(129656);
        AppMethodBeat.m2505o(129656);
    }

    public C26779s(C7480h c7480h) {
        AppMethodBeat.m2504i(129645);
        this.hae = c7480h;
        this.haf = new C26781c(c7480h);
        AppMethodBeat.m2505o(129645);
    }

    /* renamed from: c */
    public final void mo10116c(C4931a c4931a) {
        AppMethodBeat.m2504i(129646);
        mo10114a(c4931a, C42677e.aNS().oAl.getLooper());
        AppMethodBeat.m2505o(129646);
    }

    public final int axF() {
        int i = 0;
        AppMethodBeat.m2504i(129647);
        Cursor a = this.hae.mo10104a("select count(*) from AppBrandStarApp", null, 0);
        if (a == null || a.isClosed()) {
            AppMethodBeat.m2505o(129647);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(129647);
        }
        return i;
    }

    /* renamed from: a */
    public final ArrayList<AppBrandRecentTaskInfo> mo44549a(C10117a c10117a) {
        AppMethodBeat.m2504i(129648);
        ArrayList b = mo44555b(-1, c10117a);
        AppMethodBeat.m2505o(129648);
        return b;
    }

    /* renamed from: b */
    public final ArrayList<AppBrandRecentTaskInfo> mo44555b(int i, C10117a c10117a) {
        ArrayList<AppBrandRecentTaskInfo> arrayList = null;
        AppMethodBeat.m2504i(129649);
        if (c10117a == null) {
            c10117a = C10117a.DESC;
        }
        if (c10117a == C10117a.UPATE_TIME_DESC) {
            ArrayList nB = m42612nB(i);
            AppMethodBeat.m2505o(129649);
            return nB;
        }
        int axI;
        if (i <= 0) {
            axI = C26783t.axI();
        } else {
            axI = Math.min(C26783t.axI(), i);
        }
        Cursor query = this.hae.query("AppBrandStarApp", new String[]{"username", "versionType"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset 0", new Object[]{"orderSequence", Integer.valueOf(axI)}));
        if (query == null) {
            AppMethodBeat.m2505o(129649);
            return null;
        }
        if (C10117a.ASC != c10117a ? !query.moveToFirst() : !query.moveToLast()) {
            LinkedList linkedList = new LinkedList();
            C10130a c10130a = new C10130a();
            while (true) {
                c10130a.mo8995d(query);
                linkedList.add(C26842p.m42732a(String.format(Locale.US, "$%s$%d@starapp", new Object[]{c10130a.field_username, Integer.valueOf(c10130a.field_versionType)}), c10130a.field_username, c10130a.field_versionType, -1));
                if (C10117a.ASC == c10117a) {
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
        AppMethodBeat.m2505o(129649);
        return arrayList;
    }

    /* renamed from: nB */
    private ArrayList<AppBrandRecentTaskInfo> m42612nB(int i) {
        AppMethodBeat.m2504i(129650);
        Cursor a = this.hae.mo10104a("select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(i, 1) + " offset 0", null, 0);
        if (a == null) {
            AppMethodBeat.m2505o(129650);
            return null;
        } else if (a.moveToFirst()) {
            LinkedList linkedList = new LinkedList();
            do {
                String string = a.getString(0);
                if (!C5046bo.isNullOrNil(string)) {
                    linkedList.add(C26842p.m42732a(String.format(Locale.US, "$%s$%d@starapp", new Object[]{string, Integer.valueOf(r3)}), string, a.getInt(1), a.getLong(2)));
                }
            } while (a.moveToNext());
            a.close();
            ArrayList<AppBrandRecentTaskInfo> arrayList = new ArrayList(linkedList.size());
            arrayList.addAll(linkedList);
            AppMethodBeat.m2505o(129650);
            return arrayList;
        } else {
            a.close();
            AppMethodBeat.m2505o(129650);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final <T> void mo44550a(Class<T> cls, List<T> list, Long l) {
        C26782b c26782b;
        AppMethodBeat.m2504i(129652);
        if (cls == cwq.class) {
            c26782b = hag;
        } else if (cls == LocalUsageInfo.class) {
            c26782b = hah;
        } else {
            AppMethodBeat.m2505o(129652);
            return;
        }
        long iV = this.hae.mo15639iV(Thread.currentThread().getId());
        this.hae.delete("AppBrandStarApp", "", null);
        if (!C5046bo.m7548ek(list)) {
            List l2;
            if (list != null) {
                l2 = C25035t.m39351l(list);
            } else {
                l2 = null;
            }
            C10130a c10130a = new C10130a();
            int i = 0;
            for (Object next : l2) {
                if (!C5046bo.isNullOrNil(c26782b.mo5868bq(next))) {
                    c10130a.field_username = c26782b.mo5868bq(next);
                    c10130a.field_versionType = c26782b.mo5867bp(next);
                    c10130a.field_updateTime = c26782b.mo5866bo(next);
                    i++;
                    c10130a.field_orderSequence = ((long) i) * ((long) (C26783t.axI() * 2));
                    this.hae.insert("AppBrandStarApp", null, c10130a.mo10098Hl());
                }
            }
        }
        this.hae.mo15640mB(iV);
        mo15641b("batch", 3, l);
        AppMethodBeat.m2505o(129652);
    }

    /* renamed from: aG */
    public final int mo44552aG(String str, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(129653);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129653);
            return -1;
        }
        int i3;
        long j;
        if (C33097a.m54090np(i)) {
            WxaAttributes d = C42340f.auO().mo21572d(str, "appInfo");
            if (d == null || TextUtils.isEmpty(d.field_appInfo)) {
                i3 = 0;
            } else {
                C4990ab.m7417i("MicroMsg.AppBrandStarAppStorage", "checkIsAddStarBlocked username[%s] until[%d] now[%d]", str, Long.valueOf(d.ayJ().haR), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())));
                i3 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) < d.ayJ().haR ? 1 : 0;
            }
            if (i3 != 0) {
                AppMethodBeat.m2505o(129653);
                return -3;
            }
        }
        long anT = C5046bo.anT();
        Cursor a = this.hae.mo10104a(String.format(Locale.US, "select %s from %s order by %s desc limit 1 offset 0", new Object[]{"orderSequence", "AppBrandStarApp", "orderSequence"}), null, 2);
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
        j += (long) (C26783t.axI() * 2);
        if (!mo44551aF(str, i)) {
            if (axF() >= C26783t.axI()) {
                AppMethodBeat.m2505o(129653);
                return -2;
            }
            C10130a c10130a = new C10130a();
            c10130a.field_username = str;
            c10130a.field_versionType = i;
            c10130a.field_updateTime = anT;
            c10130a.field_orderSequence = j;
            this.haf.mo16759a((C4925c) c10130a, false);
            if (mo44551aF(str, i)) {
                mo15641b("single", 2, c10130a);
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
            ((C10120c) C1720g.m3528K(C10120c.class)).mo21479a(C10134z.m17745a(cda), C10133b.History);
        }
        if (i2 != 0) {
            AppMethodBeat.m2505o(129653);
            return 0;
        }
        AppMethodBeat.m2505o(129653);
        return -1;
    }

    /* renamed from: aH */
    public final boolean mo44553aH(String str, int i) {
        AppMethodBeat.m2504i(129654);
        boolean j = mo44556j(str, i, true);
        AppMethodBeat.m2505o(129654);
        return j;
    }

    /* renamed from: j */
    public final boolean mo44556j(String str, int i, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(129655);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(129655);
            return false;
        }
        C10130a c10130a = new C10130a();
        c10130a.field_username = str;
        c10130a.field_versionType = i;
        if (this.haf.mo10102b((C4925c) c10130a, "versionType", "username")) {
            this.haf.mo10100a((C4925c) c10130a, false, C10130a.gSr);
            if (mo44551aF(str, i)) {
                z2 = false;
            } else {
                mo15641b("single", 5, c10130a);
            }
        }
        if (z2 && z) {
            cda cda = new cda();
            cda.username = str;
            cda.vOO = i;
            ((C10120c) C1720g.m3528K(C10120c.class)).mo21479a(C10134z.m17746b(cda), C10133b.History);
        }
        AppMethodBeat.m2505o(129655);
        return z2;
    }

    /* renamed from: aF */
    public final boolean mo44551aF(String str, int i) {
        Cursor cursor = null;
        AppMethodBeat.m2504i(129651);
        if (!C5046bo.isNullOrNil(str)) {
            cursor = this.hae.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"username", "versionType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        }
        if (cursor == null) {
            AppMethodBeat.m2505o(129651);
            return false;
        }
        boolean moveToFirst = cursor.moveToFirst();
        cursor.close();
        AppMethodBeat.m2505o(129651);
        return moveToFirst;
    }
}
