package com.tencent.p177mm.plugin.forcenotify.p1648d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C28062a;
import com.tencent.p177mm.plugin.forcenotify.p1613c.C43101b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7309bd;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p007b.C25052j;
import p000a.p1582e.C41372b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0005J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "()V", "TABLE_NAME", "", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "delete", "", "userName", "deleteExpireInfo", "", "getErrorCount", "", "getExpireTime", "", "getList", "Ljava/util/ArrayList;", "getUnExpireCount", "isHasSetForceNotify", "isNeedNotify", "set", "updateStatus", "status", "plugin-force-notify_release"})
/* renamed from: com.tencent.mm.plugin.forcenotify.d.a */
public final class C45947a extends C7563j<C43101b> {
    public static final C7480h fni;
    public static final ConcurrentHashMap<String, C43101b> mtg = new ConcurrentHashMap();
    public static final C45947a mth = new C45947a();

    static {
        AppMethodBeat.m2504i(51062);
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        C7480h Ru = RP.mo5236Ru();
        if (Ru == null) {
            C25052j.dWJ();
        }
        fni = Ru;
        AppMethodBeat.m2505o(51062);
    }

    private C45947a() {
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        super(RP.mo5236Ru(), C43101b.ccO, "ForceNotifyInfo", new String[]{"CREATE INDEX IF NOT EXISTS userNameIndex ON ForceNotifyInfo(UserName)", "CREATE INDEX IF NOT EXISTS statusIndex ON ForceNotifyInfo(Status)", "CREATE INDEX IF NOT EXISTS expireTimeIndex ON ForceNotifyInfo(ExpiredTime)"});
        AppMethodBeat.m2504i(51061);
        AppMethodBeat.m2505o(51061);
    }

    /* renamed from: Mp */
    public static boolean m85333Mp(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(51053);
        C25052j.m39376p(str, "userName");
        if (mtg.isEmpty()) {
            Cursor a = fni.mo10105a("ForceNotifyInfo", new String[]{"*"}, "UserName=?", new String[]{str}, null, null, null, 2);
            Closeable closeable = a;
            try {
                if (a.moveToFirst()) {
                    C43101b c43101b = new C43101b();
                    c43101b.mo8995d(a);
                    mtg.put(str, c43101b);
                    C4990ab.m7417i("MicroMsg.ForceNotifyStorage", "[isNeedNotify] userName:%s %s", str, c43101b);
                    boolean z = !c43101b.bxX() && c43101b.isEnable();
                    C41372b.m72155a(closeable, null);
                    AppMethodBeat.m2505o(51053);
                    return z;
                }
                mtg.put(str, new C43101b());
                C37091y c37091y = C37091y.AUy;
                C41372b.m72155a(closeable, null);
                AppMethodBeat.m2505o(51053);
                return false;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                C41372b.m72155a(closeable, th2);
                AppMethodBeat.m2505o(51053);
                throw th;
            }
        }
        C43101b c43101b2 = (C43101b) mtg.get(str);
        if (c43101b2 == null) {
            AppMethodBeat.m2505o(51053);
            return false;
        }
        C25052j.m39375o(c43101b2, "mCache[userName] ?: return false");
        if (c43101b2.bxX() || !c43101b2.isEnable()) {
            AppMethodBeat.m2505o(51053);
            return false;
        }
        AppMethodBeat.m2505o(51053);
        return true;
    }

    /* renamed from: Mq */
    public static boolean m85334Mq(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(51054);
        C25052j.m39376p(str, "userName");
        if (mtg.isEmpty()) {
            Cursor a = fni.mo10105a("ForceNotifyInfo", new String[]{"*"}, "UserName=?", new String[]{str}, null, null, null, 2);
            Closeable closeable = a;
            if (a == null) {
                try {
                    C25052j.dWJ();
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    C41372b.m72155a(closeable, th2);
                    AppMethodBeat.m2505o(51054);
                    throw th;
                }
            }
            if (a.moveToFirst()) {
                new C43101b().mo8995d(a);
                C4990ab.m7417i("MicroMsg.ForceNotifyStorage", "[isHasSetForceNotify] userName:%s %s", str, r2);
                C41372b.m72155a(closeable, null);
                AppMethodBeat.m2505o(51054);
                return true;
            }
            C37091y c37091y = C37091y.AUy;
            C41372b.m72155a(closeable, null);
            AppMethodBeat.m2505o(51054);
            return false;
        } else if (((C43101b) mtg.get(str)) == null) {
            AppMethodBeat.m2505o(51054);
            return false;
        } else {
            AppMethodBeat.m2505o(51054);
            return true;
        }
    }

    /* renamed from: bW */
    public final void mo73803bW(String str, int i) {
        AppMethodBeat.m2504i(51055);
        C25052j.m39376p(str, "userName");
        C43101b c43101b = new C43101b();
        c43101b.field_UserName = str;
        if (mo10102b((C4925c) c43101b, new String[0])) {
            c43101b.field_Status = i;
            long replace = fni.replace("ForceNotifyInfo", "UserName", c43101b.mo10098Hl());
            C4990ab.m7417i("MicroMsg.ForceNotifyStorage", "[updateStatus] ret:%s %s", Long.valueOf(replace), c43101b);
            mtg.put(str, c43101b);
            doNotify();
        }
        AppMethodBeat.m2505o(51055);
    }

    /* renamed from: pI */
    public final boolean mo73804pI(String str) {
        AppMethodBeat.m2504i(51056);
        C25052j.m39376p(str, "userName");
        if (fni.delete("ForceNotifyInfo", "UserName=?", new String[]{str}) >= 0) {
            mtg.remove(str);
            doNotify();
            AppMethodBeat.m2505o(51056);
            return true;
        }
        AppMethodBeat.m2505o(51056);
        return false;
    }

    public static ArrayList<C43101b> bxY() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(51057);
        ArrayList arrayList = new ArrayList();
        C1694a K = C1720g.m3528K(C6982j.class);
        C25052j.m39375o(K, "MMKernel.service(IMessengerStorage::class.java)");
        C7309bd XM = ((C6982j) K).mo15369XM();
        Cursor a = fni.mo10105a("ForceNotifyInfo", new String[]{"*"}, "ExpiredTime>=?", new String[]{String.valueOf(C1839cb.aaE())}, null, null, "ExpiredTime Desc", 2);
        Closeable closeable = a;
        try {
            a.moveToFirst();
            while (true) {
                if (a == null) {
                    C25052j.dWJ();
                }
                if (a.isAfterLast()) {
                    C37091y c37091y = C37091y.AUy;
                    C41372b.m72155a(closeable, null);
                    AppMethodBeat.m2505o(51057);
                    return arrayList;
                }
                C43101b c43101b = new C43101b();
                c43101b.mo8995d(a);
                c43101b.ehM = XM.aoO(c43101b.field_UserName);
                arrayList.add(c43101b);
                C4990ab.m7417i("MicroMsg.ForceNotifyStorage", "add List:%s", c43101b);
                Map map = mtg;
                String str = c43101b.field_UserName;
                C25052j.m39375o(str, "result.field_UserName");
                map.put(str, c43101b);
                a.moveToNext();
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            C41372b.m72155a(closeable, th2);
            AppMethodBeat.m2505o(51057);
            throw th;
        }
    }

    public static int bxZ() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(51058);
        Cursor rawQuery = fni.rawQuery("select count(*) from ForceNotifyInfo where ExpiredTime >?", new String[]{String.valueOf(C1839cb.aaE())});
        Closeable closeable = rawQuery;
        if (rawQuery == null) {
            try {
                C25052j.dWJ();
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                C41372b.m72155a(closeable, th2);
                AppMethodBeat.m2505o(51058);
                throw th;
            }
        }
        if (rawQuery.moveToFirst()) {
            int i = rawQuery.getInt(0);
            C41372b.m72155a(closeable, null);
            AppMethodBeat.m2505o(51058);
            return i;
        }
        C37091y c37091y = C37091y.AUy;
        C41372b.m72155a(closeable, null);
        AppMethodBeat.m2505o(51058);
        return 0;
    }

    public static void bya() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(51059);
        Cursor a = fni.mo10105a("ForceNotifyInfo", new String[]{"*"}, "ExpiredTime<=?", new String[]{String.valueOf(C1839cb.aaE())}, null, null, null, 2);
        Closeable closeable = a;
        try {
            a.moveToFirst();
            while (true) {
                if (a == null) {
                    C25052j.dWJ();
                }
                if (a.isAfterLast()) {
                    C37091y c37091y = C37091y.AUy;
                    C41372b.m72155a(closeable, null);
                    int delete = fni.delete("ForceNotifyInfo", "ExpiredTime<=?", new String[]{String.valueOf(C1839cb.aaE())});
                    C4990ab.m7417i("MicroMsg.ForceNotifyStorage", "[deleteExpireInfo] ret:%s", Integer.valueOf(delete));
                    AppMethodBeat.m2505o(51059);
                    return;
                }
                C43101b c43101b = new C43101b();
                c43101b.mo8995d(a);
                ((C28062a) C1720g.m3528K(C28062a.class)).mo36079f(c43101b.field_UserName, 5, C1839cb.aaE() / 1000);
                a.moveToNext();
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            C41372b.m72155a(closeable, th2);
            AppMethodBeat.m2505o(51059);
            throw th;
        }
    }

    public static int byb() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.m2504i(51060);
        Cursor rawQuery = fni.rawQuery("select count(*) from ForceNotifyInfo where Status =?", new String[]{"-1"});
        Closeable closeable = rawQuery;
        if (rawQuery == null) {
            try {
                C25052j.dWJ();
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                C41372b.m72155a(closeable, th2);
                AppMethodBeat.m2505o(51060);
                throw th;
            }
        }
        if (rawQuery.moveToFirst()) {
            int i = rawQuery.getInt(0);
            C41372b.m72155a(closeable, null);
            AppMethodBeat.m2505o(51060);
            return i;
        }
        C37091y c37091y = C37091y.AUy;
        C41372b.m72155a(closeable, null);
        AppMethodBeat.m2505o(51060);
        return 0;
    }
}
