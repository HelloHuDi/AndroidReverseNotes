package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cd.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class r extends j<q> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_index ON BizTimeLineInfo ( orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) "};
    public static final String[] fnj = new String[]{j.a(q.ccO, "BizTimeLineInfo")};
    private static final f<Long, Boolean> xHW = new com.tencent.mm.memory.a.c(3);
    public static final String[] yal = new String[]{"CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) "};
    public final h fni;
    private final l<c, a> xHV = new l<c, a>() {
        public final /* synthetic */ void w(Object obj, Object obj2) {
            AppMethodBeat.i(11854);
            ((c) obj).a(r.this, (a) obj2);
            AppMethodBeat.o(11854);
        }
    };
    private final long xHX = 10;
    private AtomicLong xHY = new AtomicLong(10);
    private long xHZ = 10;
    private long xIa;
    public boolean yam = true;

    /* renamed from: com.tencent.mm.storage.r$3 */
    public class AnonymousClass3 implements com.tencent.mm.vending.c.a<Void, Void> {
        final /* synthetic */ List ibp;

        public AnonymousClass3(List list) {
            this.ibp = list;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(11857);
            Void asR = asR();
            AppMethodBeat.o(11857);
            return asR;
        }

        private Void asR() {
            AppMethodBeat.i(11856);
            long iV = r.this.fni.iV(Thread.currentThread().getId());
            for (q qVar : this.ibp) {
                if (qVar.field_appMsgStatInfoProto != null) {
                    ContentValues contentValues = new ContentValues();
                    try {
                        contentValues.put("appMsgStatInfoProto", qVar.field_appMsgStatInfoProto.toByteArray());
                    } catch (IOException e) {
                        ab.e("MicroMsg.BizTimeLineInfoStorage", e.getMessage());
                    }
                    if (contentValues.size() > 0) {
                        r.this.fni.update("BizTimeLineInfo", contentValues, "msgSvrId = ?", new String[]{qVar.field_msgSvrId});
                    }
                }
            }
            r.this.fni.mB(iV);
            AppMethodBeat.o(11856);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.storage.r$2 */
    public class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, Void> {
        final /* synthetic */ List ibp;

        public AnonymousClass2(List list) {
            this.ibp = list;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(11855);
            a aVar = new a();
            aVar.list = this.ibp;
            aVar.xId = b.UPDATE;
            r.this.a(aVar);
            AppMethodBeat.o(11855);
            return null;
        }
    }

    public static class a {
        public q jOa;
        public List<q> list;
        public String talker;
        public b xId = b.INSERT;
        public boolean xIe = false;
    }

    public interface c {
        void a(Object obj, a aVar);
    }

    public enum b {
        INSERT,
        DELETE,
        UPDATE;

        static {
            AppMethodBeat.o(11863);
        }
    }

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        AppMethodBeat.i(11892);
        boolean g = g((q) cVar);
        AppMethodBeat.o(11892);
        return g;
    }

    static {
        AppMethodBeat.i(11893);
        AppMethodBeat.o(11893);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(11864);
        if (this.xHV.cF(aVar)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.o(11864);
    }

    public final void a(c cVar, Looper looper) {
        AppMethodBeat.i(11865);
        this.xHV.a(cVar, looper);
        AppMethodBeat.o(11865);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(11866);
        this.xHV.remove(cVar);
        AppMethodBeat.o(11866);
    }

    public r(h hVar) {
        super(hVar, q.ccO, "BizTimeLineInfo", diI);
        AppMethodBeat.i(11867);
        this.fni = hVar;
        drN();
        AppMethodBeat.o(11867);
    }

    public final boolean g(q qVar) {
        AppMethodBeat.i(11868);
        boolean a = super.a((com.tencent.mm.sdk.e.c) qVar, false);
        mK(qVar.drB());
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.jOa = qVar;
        aVar.xId = b.INSERT;
        a(aVar);
        AppMethodBeat.o(11868);
        return a;
    }

    public final boolean h(q qVar) {
        AppMethodBeat.i(11869);
        boolean b = super.b(qVar, false, "msgSvrId");
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.jOa = qVar;
        aVar.xId = b.UPDATE;
        a(aVar);
        AppMethodBeat.o(11869);
        return b;
    }

    public final void aol(String str) {
        AppMethodBeat.i(11870);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(11870);
            return;
        }
        int i;
        if (((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(str).Oe()) {
            i = 1;
        } else {
            i = 0;
        }
        this.fni.hY("BizTimeLineInfo", "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + str + "'");
        this.fni.hY("BizTimeLineInfo", "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + str + "'");
        q drI = drI();
        if (drI != null && str.equals(drI.field_talker)) {
            drI.field_placeTop = i;
            super.b(drI, false, "msgSvrId");
        }
        a aVar = new a();
        aVar.xId = b.UPDATE;
        a(aVar);
        AppMethodBeat.o(11870);
    }

    public final boolean eo(final List<q> list) {
        AppMethodBeat.i(11871);
        if (bo.ek(list)) {
            AppMethodBeat.o(11871);
            return false;
        }
        com.tencent.mm.ci.g.dOW().h(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(11858);
                String str = "";
                for (int i = 0; i < list.size(); i++) {
                    if (i > 0) {
                        str = str + "," + ((q) list.get(i)).field_msgSvrId;
                    } else {
                        str = str + ((q) list.get(i)).field_msgSvrId;
                    }
                }
                boolean hY = r.this.fni.hY("BizTimeLineInfo", "update BizTimeLineInfo set isRead = 1 where msgSvrId in(" + str + ")");
                ab.d("MicroMsg.BizTimeLineInfoStorage", "batUpdateTitleStatus ret = %b", Boolean.valueOf(hY));
                AppMethodBeat.o(11858);
                return null;
            }
        });
        AppMethodBeat.o(11871);
        return true;
    }

    public final q B(long j, String str) {
        AppMethodBeat.i(11872);
        q qVar = new q();
        Cursor a = this.fni.a("BizTimeLineInfo", null, str + "=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            qVar.d(a);
            a.close();
            AppMethodBeat.o(11872);
            return qVar;
        }
        a.close();
        AppMethodBeat.o(11872);
        return null;
    }

    public final List<q> ah(int i, long j) {
        AppMethodBeat.i(11873);
        List p = p(this.fni.query("BizTimeLineInfo", null, "orderFlag<?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC limit ".concat(String.valueOf(i))));
        AppMethodBeat.o(11873);
        return p;
    }

    public final List<q> drH() {
        AppMethodBeat.i(11874);
        List p = p(this.fni.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit 10"));
        AppMethodBeat.o(11874);
        return p;
    }

    public final List<q> mD(long j) {
        AppMethodBeat.i(11875);
        List p = p(this.fni.query("BizTimeLineInfo", null, "orderFlag>=?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC"));
        AppMethodBeat.o(11875);
        return p;
    }

    public static List<q> p(Cursor cursor) {
        AppMethodBeat.i(11876);
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            q qVar = new q();
            qVar.d(cursor);
            linkedList.add(qVar);
        }
        cursor.close();
        AppMethodBeat.o(11876);
        return linkedList;
    }

    public final q drI() {
        q qVar = null;
        AppMethodBeat.i(11877);
        Cursor a = this.fni.a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.d(a);
        }
        a.close();
        AppMethodBeat.o(11877);
        return qVar;
    }

    public final q mE(long j) {
        q qVar = null;
        AppMethodBeat.i(11878);
        Cursor a = this.fni.a("SELECT * FROM BizTimeLineInfo where talkerId = " + j + "  order by orderFlag DESC limit 1", null, 0);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.d(a);
        }
        a.close();
        AppMethodBeat.o(11878);
        return qVar;
    }

    public final q drJ() {
        q qVar = null;
        AppMethodBeat.i(11879);
        Cursor a = this.fni.a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.d(a);
        }
        a.close();
        AppMethodBeat.o(11879);
        return qVar;
    }

    public final void mF(long j) {
        AppMethodBeat.i(11880);
        if (mG(j) > 2000) {
            q B = B(j, "orderFlag");
            if (B != null) {
                B.field_status = 4;
                h(B);
            }
            AppMethodBeat.o(11880);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = -4294967296L & j;
        this.fni.hY("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where orderFlag >= " + j2 + " and status > 4");
        this.fni.hY("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where orderFlag >= " + j2 + " and status < 4");
        ab.d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        xHW.k(Long.valueOf(j), Boolean.TRUE);
        AppMethodBeat.o(11880);
    }

    public final int mG(long j) {
        AppMethodBeat.i(11881);
        Boolean bool = (Boolean) xHW.get(Long.valueOf(j));
        if (bool == null || !bool.booleanValue()) {
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = -4294967296L & j;
            Cursor a = this.fni.a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + j2 + " and status > 4", null, 0);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
            Cursor a2 = this.fni.a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + j2 + " and status < 4", null, 0);
            if (a2.moveToFirst()) {
                i += a2.getInt(0);
            }
            a2.close();
            if (i > 2000) {
                i = 0;
            }
            if (i == 0) {
                xHW.k(Long.valueOf(j), Boolean.TRUE);
            }
            ab.d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(11881);
            return i;
        }
        AppMethodBeat.o(11881);
        return 0;
    }

    public final void drK() {
        AppMethodBeat.i(11882);
        q drI = drI();
        if (drI == null) {
            AppMethodBeat.o(11882);
            return;
        }
        mH(drI.field_orderFlag);
        AppMethodBeat.o(11882);
    }

    public final void mH(final long j) {
        AppMethodBeat.i(11883);
        com.tencent.mm.ci.g.dOW().h(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(11860);
                long currentTimeMillis = System.currentTimeMillis();
                int mI = r.this.mI(j);
                if (mI > 2000 || mI <= 0) {
                    AppMethodBeat.o(11860);
                } else {
                    boolean hY = r.this.fni.hY("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where orderFlag >= " + (j & -4294967296L) + " and hasShow < 1 ");
                    ab.d("MicroMsg.BizTimeLineInfoStorage", "resetUnShow ret = %b, cost = %d", Boolean.valueOf(hY), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(11860);
                }
                return null;
            }
        }).b(new com.tencent.mm.vending.c.a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(11859);
                a aVar = new a();
                aVar.xId = b.UPDATE;
                aVar.xIe = true;
                r.this.a(aVar);
                AppMethodBeat.o(11859);
                return null;
            }
        });
        AppMethodBeat.o(11883);
    }

    public final int mI(long j) {
        int i;
        AppMethodBeat.i(11884);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = this.fni.a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (-4294967296L & j) + " and hasShow < 1 ", null, 0);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        ab.d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        a.close();
        if (i > 2000) {
            if (this.xIa == this.xHY.longValue()) {
                drM();
            }
            AppMethodBeat.o(11884);
            return 0;
        }
        AppMethodBeat.o(11884);
        return i;
    }

    public final boolean QS(String str) {
        AppMethodBeat.i(11885);
        com.tencent.mm.sdk.e.c qVar = new q();
        qVar.field_talker = str;
        boolean a = super.a(qVar, false, "talker");
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.jOa = qVar;
        aVar.xId = b.DELETE;
        a(aVar);
        AppMethodBeat.o(11885);
        return a;
    }

    public final void mJ(long j) {
        AppMethodBeat.i(11886);
        com.tencent.mm.sdk.e.c qVar = new q();
        qVar.field_msgId = j;
        super.a(qVar, false, "msgId");
        a aVar = new a();
        aVar.xId = b.DELETE;
        a(aVar);
        AppMethodBeat.o(11886);
    }

    private synchronized void mK(long j) {
        AppMethodBeat.i(11887);
        this.xHZ = Math.max(j, this.xHZ);
        AppMethodBeat.o(11887);
    }

    public final synchronized long drL() {
        return this.xHZ;
    }

    public final synchronized long drB() {
        long longValue;
        AppMethodBeat.i(11888);
        longValue = this.xHY.longValue();
        AppMethodBeat.o(11888);
        return longValue;
    }

    public final synchronized long drM() {
        long incrementAndGet;
        AppMethodBeat.i(11889);
        incrementAndGet = this.xHY.incrementAndGet();
        AppMethodBeat.o(11889);
        return incrementAndGet;
    }

    private synchronized void drN() {
        AppMethodBeat.i(11890);
        this.xHZ = drO() >> 32;
        if (this.xHZ < 10) {
            this.xHZ = 10;
        }
        q drI = drI();
        if (drI == null) {
            ab.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", Long.valueOf(this.xHZ));
            AppMethodBeat.o(11890);
        } else {
            if (drI.field_status == 4) {
                this.xHY.set(this.xHZ + 1);
            } else {
                this.xHY.set(this.xHZ);
            }
            this.xIa = this.xHY.longValue();
            ab.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", Long.valueOf(this.xHY.longValue()), Long.valueOf(this.xHZ), Integer.valueOf(drI.field_status));
            AppMethodBeat.o(11890);
        }
    }

    private synchronized long drO() {
        long j;
        AppMethodBeat.i(11891);
        Cursor a = this.fni.a("select max(orderFlag) from BizTimeLineInfo", null, 2);
        j = 0;
        if (a.moveToFirst()) {
            j = a.getLong(0);
            a.close();
        }
        AppMethodBeat.o(11891);
        return j;
    }

    static /* synthetic */ int Mv(int i) {
        if (i <= 5) {
            return 0;
        }
        if (i <= 10) {
            return 1;
        }
        if (i <= 20) {
            return 2;
        }
        if (i <= 40) {
            return 3;
        }
        return 4;
    }
}
