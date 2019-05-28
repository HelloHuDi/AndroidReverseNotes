package com.tencent.mm.plugin.forcenotify.d;

import a.l;
import a.y;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.forcenotify.c.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0005J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0016\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, dWq = {"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "()V", "TABLE_NAME", "", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "delete", "", "userName", "deleteExpireInfo", "", "getErrorCount", "", "getExpireTime", "", "getList", "Ljava/util/ArrayList;", "getUnExpireCount", "isHasSetForceNotify", "isNeedNotify", "set", "updateStatus", "status", "plugin-force-notify_release"})
public final class a extends j<b> {
    public static final h fni;
    public static final ConcurrentHashMap<String, b> mtg = new ConcurrentHashMap();
    public static final a mth = new a();

    static {
        AppMethodBeat.i(51062);
        e RP = g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        h Ru = RP.Ru();
        if (Ru == null) {
            a.f.b.j.dWJ();
        }
        fni = Ru;
        AppMethodBeat.o(51062);
    }

    private a() {
        e RP = g.RP();
        a.f.b.j.o(RP, "MMKernel.storage()");
        super(RP.Ru(), b.ccO, "ForceNotifyInfo", new String[]{"CREATE INDEX IF NOT EXISTS userNameIndex ON ForceNotifyInfo(UserName)", "CREATE INDEX IF NOT EXISTS statusIndex ON ForceNotifyInfo(Status)", "CREATE INDEX IF NOT EXISTS expireTimeIndex ON ForceNotifyInfo(ExpiredTime)"});
        AppMethodBeat.i(51061);
        AppMethodBeat.o(51061);
    }

    public static boolean Mp(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(51053);
        a.f.b.j.p(str, "userName");
        if (mtg.isEmpty()) {
            Cursor a = fni.a("ForceNotifyInfo", new String[]{"*"}, "UserName=?", new String[]{str}, null, null, null, 2);
            Closeable closeable = a;
            try {
                if (a.moveToFirst()) {
                    b bVar = new b();
                    bVar.d(a);
                    mtg.put(str, bVar);
                    ab.i("MicroMsg.ForceNotifyStorage", "[isNeedNotify] userName:%s %s", str, bVar);
                    boolean z = !bVar.bxX() && bVar.isEnable();
                    a.e.b.a(closeable, null);
                    AppMethodBeat.o(51053);
                    return z;
                }
                mtg.put(str, new b());
                y yVar = y.AUy;
                a.e.b.a(closeable, null);
                AppMethodBeat.o(51053);
                return false;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                a.e.b.a(closeable, th2);
                AppMethodBeat.o(51053);
                throw th;
            }
        }
        b bVar2 = (b) mtg.get(str);
        if (bVar2 == null) {
            AppMethodBeat.o(51053);
            return false;
        }
        a.f.b.j.o(bVar2, "mCache[userName] ?: return false");
        if (bVar2.bxX() || !bVar2.isEnable()) {
            AppMethodBeat.o(51053);
            return false;
        }
        AppMethodBeat.o(51053);
        return true;
    }

    public static boolean Mq(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(51054);
        a.f.b.j.p(str, "userName");
        if (mtg.isEmpty()) {
            Cursor a = fni.a("ForceNotifyInfo", new String[]{"*"}, "UserName=?", new String[]{str}, null, null, null, 2);
            Closeable closeable = a;
            if (a == null) {
                try {
                    a.f.b.j.dWJ();
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    a.e.b.a(closeable, th2);
                    AppMethodBeat.o(51054);
                    throw th;
                }
            }
            if (a.moveToFirst()) {
                new b().d(a);
                ab.i("MicroMsg.ForceNotifyStorage", "[isHasSetForceNotify] userName:%s %s", str, r2);
                a.e.b.a(closeable, null);
                AppMethodBeat.o(51054);
                return true;
            }
            y yVar = y.AUy;
            a.e.b.a(closeable, null);
            AppMethodBeat.o(51054);
            return false;
        } else if (((b) mtg.get(str)) == null) {
            AppMethodBeat.o(51054);
            return false;
        } else {
            AppMethodBeat.o(51054);
            return true;
        }
    }

    public final void bW(String str, int i) {
        AppMethodBeat.i(51055);
        a.f.b.j.p(str, "userName");
        b bVar = new b();
        bVar.field_UserName = str;
        if (b((c) bVar, new String[0])) {
            bVar.field_Status = i;
            long replace = fni.replace("ForceNotifyInfo", "UserName", bVar.Hl());
            ab.i("MicroMsg.ForceNotifyStorage", "[updateStatus] ret:%s %s", Long.valueOf(replace), bVar);
            mtg.put(str, bVar);
            doNotify();
        }
        AppMethodBeat.o(51055);
    }

    public final boolean pI(String str) {
        AppMethodBeat.i(51056);
        a.f.b.j.p(str, "userName");
        if (fni.delete("ForceNotifyInfo", "UserName=?", new String[]{str}) >= 0) {
            mtg.remove(str);
            doNotify();
            AppMethodBeat.o(51056);
            return true;
        }
        AppMethodBeat.o(51056);
        return false;
    }

    public static ArrayList<b> bxY() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(51057);
        ArrayList arrayList = new ArrayList();
        com.tencent.mm.kernel.c.a K = g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class);
        a.f.b.j.o(K, "MMKernel.service(IMessengerStorage::class.java)");
        bd XM = ((com.tencent.mm.plugin.messenger.foundation.a.j) K).XM();
        Cursor a = fni.a("ForceNotifyInfo", new String[]{"*"}, "ExpiredTime>=?", new String[]{String.valueOf(cb.aaE())}, null, null, "ExpiredTime Desc", 2);
        Closeable closeable = a;
        try {
            a.moveToFirst();
            while (true) {
                if (a == null) {
                    a.f.b.j.dWJ();
                }
                if (a.isAfterLast()) {
                    y yVar = y.AUy;
                    a.e.b.a(closeable, null);
                    AppMethodBeat.o(51057);
                    return arrayList;
                }
                b bVar = new b();
                bVar.d(a);
                bVar.ehM = XM.aoO(bVar.field_UserName);
                arrayList.add(bVar);
                ab.i("MicroMsg.ForceNotifyStorage", "add List:%s", bVar);
                Map map = mtg;
                String str = bVar.field_UserName;
                a.f.b.j.o(str, "result.field_UserName");
                map.put(str, bVar);
                a.moveToNext();
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            a.e.b.a(closeable, th2);
            AppMethodBeat.o(51057);
            throw th;
        }
    }

    public static int bxZ() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(51058);
        Cursor rawQuery = fni.rawQuery("select count(*) from ForceNotifyInfo where ExpiredTime >?", new String[]{String.valueOf(cb.aaE())});
        Closeable closeable = rawQuery;
        if (rawQuery == null) {
            try {
                a.f.b.j.dWJ();
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                a.e.b.a(closeable, th2);
                AppMethodBeat.o(51058);
                throw th;
            }
        }
        if (rawQuery.moveToFirst()) {
            int i = rawQuery.getInt(0);
            a.e.b.a(closeable, null);
            AppMethodBeat.o(51058);
            return i;
        }
        y yVar = y.AUy;
        a.e.b.a(closeable, null);
        AppMethodBeat.o(51058);
        return 0;
    }

    public static void bya() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(51059);
        Cursor a = fni.a("ForceNotifyInfo", new String[]{"*"}, "ExpiredTime<=?", new String[]{String.valueOf(cb.aaE())}, null, null, null, 2);
        Closeable closeable = a;
        try {
            a.moveToFirst();
            while (true) {
                if (a == null) {
                    a.f.b.j.dWJ();
                }
                if (a.isAfterLast()) {
                    y yVar = y.AUy;
                    a.e.b.a(closeable, null);
                    int delete = fni.delete("ForceNotifyInfo", "ExpiredTime<=?", new String[]{String.valueOf(cb.aaE())});
                    ab.i("MicroMsg.ForceNotifyStorage", "[deleteExpireInfo] ret:%s", Integer.valueOf(delete));
                    AppMethodBeat.o(51059);
                    return;
                }
                b bVar = new b();
                bVar.d(a);
                ((com.tencent.mm.plugin.forcenotify.a.a) g.K(com.tencent.mm.plugin.forcenotify.a.a.class)).f(bVar.field_UserName, 5, cb.aaE() / 1000);
                a.moveToNext();
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            a.e.b.a(closeable, th2);
            AppMethodBeat.o(51059);
            throw th;
        }
    }

    public static int byb() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(51060);
        Cursor rawQuery = fni.rawQuery("select count(*) from ForceNotifyInfo where Status =?", new String[]{"-1"});
        Closeable closeable = rawQuery;
        if (rawQuery == null) {
            try {
                a.f.b.j.dWJ();
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                a.e.b.a(closeable, th2);
                AppMethodBeat.o(51060);
                throw th;
            }
        }
        if (rawQuery.moveToFirst()) {
            int i = rawQuery.getInt(0);
            a.e.b.a(closeable, null);
            AppMethodBeat.o(51060);
            return i;
        }
        y yVar = y.AUy;
        a.e.b.a(closeable, null);
        AppMethodBeat.o(51060);
        return 0;
    }
}
