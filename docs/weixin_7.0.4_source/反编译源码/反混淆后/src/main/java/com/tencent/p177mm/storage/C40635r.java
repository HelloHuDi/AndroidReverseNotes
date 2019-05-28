package com.tencent.p177mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4934l;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.tencent.mm.storage.r */
public final class C40635r extends C7563j<C46627q> {
    public static final String[] diI = new String[]{"CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS msg_id_index ON BizTimeLineInfo ( msgId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_index ON BizTimeLineInfo ( orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineInfo ( status,talker ) ", "CREATE  INDEX IF NOT EXISTS  has_show_place_top_index ON BizTimeLineInfo ( hasShow,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_place_top_index ON BizTimeLineInfo ( orderFlag,placeTop ) ", "CREATE  INDEX IF NOT EXISTS  talker_id_order_flag_index ON BizTimeLineInfo ( talkerId,orderFlag ) "};
    public static final String[] fnj = new String[]{C7563j.m13217a(C46627q.ccO, "BizTimeLineInfo")};
    private static final C1177f<Long, Boolean> xHW = new C7598c(3);
    public static final String[] yal = new String[]{"CREATE  INDEX IF NOT EXISTS  order_flag_status_index ON BizTimeLineInfo ( orderFlag,status ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_has_show_index ON BizTimeLineInfo ( orderFlag,hasShow ) "};
    public final C7480h fni;
    private final C4934l<C40634c, C40633a> xHV = new C235211();
    private final long xHX = 10;
    private AtomicLong xHY = new AtomicLong(10);
    private long xHZ = 10;
    private long xIa;
    public boolean yam = true;

    /* renamed from: com.tencent.mm.storage.r$3 */
    public class C154453 implements C5681a<Void, Void> {
        final /* synthetic */ List ibp;

        public C154453(List list) {
            this.ibp = list;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(11857);
            Void asR = asR();
            AppMethodBeat.m2505o(11857);
            return asR;
        }

        private Void asR() {
            AppMethodBeat.m2504i(11856);
            long iV = C40635r.this.fni.mo15639iV(Thread.currentThread().getId());
            for (C46627q c46627q : this.ibp) {
                if (c46627q.field_appMsgStatInfoProto != null) {
                    ContentValues contentValues = new ContentValues();
                    try {
                        contentValues.put("appMsgStatInfoProto", c46627q.field_appMsgStatInfoProto.toByteArray());
                    } catch (IOException e) {
                        C4990ab.m7412e("MicroMsg.BizTimeLineInfoStorage", e.getMessage());
                    }
                    if (contentValues.size() > 0) {
                        C40635r.this.fni.update("BizTimeLineInfo", contentValues, "msgSvrId = ?", new String[]{c46627q.field_msgSvrId});
                    }
                }
            }
            C40635r.this.fni.mo15640mB(iV);
            AppMethodBeat.m2505o(11856);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.storage.r$1 */
    class C235211 extends C4934l<C40634c, C40633a> {
        C235211() {
        }

        /* renamed from: w */
        public final /* synthetic */ void mo10134w(Object obj, Object obj2) {
            AppMethodBeat.m2504i(11854);
            ((C40634c) obj).mo22929a(C40635r.this, (C40633a) obj2);
            AppMethodBeat.m2505o(11854);
        }
    }

    /* renamed from: com.tencent.mm.storage.r$2 */
    public class C303082 implements C5681a<Void, Void> {
        final /* synthetic */ List ibp;

        public C303082(List list) {
            this.ibp = list;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(11855);
            C40633a c40633a = new C40633a();
            c40633a.list = this.ibp;
            c40633a.xId = C40639b.UPDATE;
            C40635r.this.mo64099a(c40633a);
            AppMethodBeat.m2505o(11855);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.storage.r$5 */
    class C406325 implements C5681a<Void, Void> {
        C406325() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(11859);
            C40633a c40633a = new C40633a();
            c40633a.xId = C40639b.UPDATE;
            c40633a.xIe = true;
            C40635r.this.mo64099a(c40633a);
            AppMethodBeat.m2505o(11859);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.storage.r$a */
    public static class C40633a {
        public C46627q jOa;
        public List<C46627q> list;
        public String talker;
        public C40639b xId = C40639b.INSERT;
        public boolean xIe = false;
    }

    /* renamed from: com.tencent.mm.storage.r$c */
    public interface C40634c {
        /* renamed from: a */
        void mo22929a(Object obj, C40633a c40633a);
    }

    /* renamed from: com.tencent.mm.storage.r$7 */
    public class C406387 implements Runnable {
        public final void run() {
            AppMethodBeat.m2504i(139002);
            if (C40635r.yal != null && C40635r.yal.length > 0) {
                C4990ab.m7410d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed start");
                ArrayList arrayList = new ArrayList();
                for (String hY : C40635r.yal) {
                    long currentTimeMillis = System.currentTimeMillis();
                    C40635r.this.fni.mo10108hY("BizTimeLineInfo", hY);
                    int currentTimeMillis2 = (int) ((System.currentTimeMillis() - currentTimeMillis) / 1000);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(1049);
                    iDKey.SetKey(C40635r.m70174Mv(currentTimeMillis2));
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                }
                C7060h.pYm.mo8379b(arrayList, false);
                C4990ab.m7410d("MicroMsg.BizTimeLineInfoStorage", "createIndexIfNeed end");
            }
            AppMethodBeat.m2505o(139002);
        }
    }

    /* renamed from: com.tencent.mm.storage.r$b */
    public enum C40639b {
        INSERT,
        DELETE,
        UPDATE;

        static {
            AppMethodBeat.m2505o(11863);
        }
    }

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(11892);
        boolean g = mo64112g((C46627q) c4925c);
        AppMethodBeat.m2505o(11892);
        return g;
    }

    static {
        AppMethodBeat.m2504i(11893);
        AppMethodBeat.m2505o(11893);
    }

    /* renamed from: a */
    public final void mo64099a(C40633a c40633a) {
        AppMethodBeat.m2504i(11864);
        if (this.xHV.mo10126cF(c40633a)) {
            this.xHV.doNotify();
        }
        AppMethodBeat.m2505o(11864);
    }

    /* renamed from: a */
    public final void mo64101a(C40634c c40634c, Looper looper) {
        AppMethodBeat.m2504i(11865);
        this.xHV.mo10125a(c40634c, looper);
        AppMethodBeat.m2505o(11865);
    }

    /* renamed from: a */
    public final void mo64100a(C40634c c40634c) {
        AppMethodBeat.m2504i(11866);
        this.xHV.remove(c40634c);
        AppMethodBeat.m2505o(11866);
    }

    public C40635r(C7480h c7480h) {
        super(c7480h, C46627q.ccO, "BizTimeLineInfo", diI);
        AppMethodBeat.m2504i(11867);
        this.fni = c7480h;
        drN();
        AppMethodBeat.m2505o(11867);
    }

    /* renamed from: g */
    public final boolean mo64112g(C46627q c46627q) {
        AppMethodBeat.m2504i(11868);
        boolean a = super.mo16759a((C4925c) c46627q, false);
        m70176mK(c46627q.drB());
        C40633a c40633a = new C40633a();
        c40633a.talker = c46627q.field_talker;
        c40633a.jOa = c46627q;
        c40633a.xId = C40639b.INSERT;
        mo64099a(c40633a);
        AppMethodBeat.m2505o(11868);
        return a;
    }

    /* renamed from: h */
    public final boolean mo64113h(C46627q c46627q) {
        AppMethodBeat.m2504i(11869);
        boolean b = super.mo16762b(c46627q, false, "msgSvrId");
        C40633a c40633a = new C40633a();
        c40633a.talker = c46627q.field_talker;
        c40633a.jOa = c46627q;
        c40633a.xId = C40639b.UPDATE;
        mo64099a(c40633a);
        AppMethodBeat.m2505o(11869);
        return b;
    }

    public final void aol(String str) {
        AppMethodBeat.m2504i(11870);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(11870);
            return;
        }
        int i;
        if (((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str).mo16702Oe()) {
            i = 1;
        } else {
            i = 0;
        }
        this.fni.mo10108hY("BizTimeLineInfo", "update BizTimeLineInfo set placeTop = " + i + " where status > 4 and talker = '" + str + "'");
        this.fni.mo10108hY("BizTimeLineInfo", "update BizTimeLineInfo set placeTop = " + i + " where status < 4 and talker = '" + str + "'");
        C46627q drI = drI();
        if (drI != null && str.equals(drI.field_talker)) {
            drI.field_placeTop = i;
            super.mo16762b(drI, false, "msgSvrId");
        }
        C40633a c40633a = new C40633a();
        c40633a.xId = C40639b.UPDATE;
        mo64099a(c40633a);
        AppMethodBeat.m2505o(11870);
    }

    /* renamed from: eo */
    public final boolean mo64111eo(final List<C46627q> list) {
        AppMethodBeat.m2504i(11871);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(11871);
            return false;
        }
        C41930g.dOW().mo60492h(new C5681a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(11858);
                String str = "";
                for (int i = 0; i < list.size(); i++) {
                    if (i > 0) {
                        str = str + "," + ((C46627q) list.get(i)).field_msgSvrId;
                    } else {
                        str = str + ((C46627q) list.get(i)).field_msgSvrId;
                    }
                }
                boolean hY = C40635r.this.fni.mo10108hY("BizTimeLineInfo", "update BizTimeLineInfo set isRead = 1 where msgSvrId in(" + str + ")");
                C4990ab.m7411d("MicroMsg.BizTimeLineInfoStorage", "batUpdateTitleStatus ret = %b", Boolean.valueOf(hY));
                AppMethodBeat.m2505o(11858);
                return null;
            }
        });
        AppMethodBeat.m2505o(11871);
        return true;
    }

    /* renamed from: B */
    public final C46627q mo64097B(long j, String str) {
        AppMethodBeat.m2504i(11872);
        C46627q c46627q = new C46627q();
        Cursor a = this.fni.mo10105a("BizTimeLineInfo", null, str + "=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            c46627q.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(11872);
            return c46627q;
        }
        a.close();
        AppMethodBeat.m2505o(11872);
        return null;
    }

    /* renamed from: ah */
    public final List<C46627q> mo64102ah(int i, long j) {
        AppMethodBeat.m2504i(11873);
        List p = C40635r.m70177p(this.fni.query("BizTimeLineInfo", null, "orderFlag<?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC limit ".concat(String.valueOf(i))));
        AppMethodBeat.m2505o(11873);
        return p;
    }

    public final List<C46627q> drH() {
        AppMethodBeat.m2504i(11874);
        List p = C40635r.m70177p(this.fni.query("BizTimeLineInfo", null, null, null, null, null, "orderFlag DESC limit 10"));
        AppMethodBeat.m2505o(11874);
        return p;
    }

    /* renamed from: mD */
    public final List<C46627q> mo64114mD(long j) {
        AppMethodBeat.m2504i(11875);
        List p = C40635r.m70177p(this.fni.query("BizTimeLineInfo", null, "orderFlag>=?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC"));
        AppMethodBeat.m2505o(11875);
        return p;
    }

    /* renamed from: p */
    public static List<C46627q> m70177p(Cursor cursor) {
        AppMethodBeat.m2504i(11876);
        LinkedList linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            C46627q c46627q = new C46627q();
            c46627q.mo8995d(cursor);
            linkedList.add(c46627q);
        }
        cursor.close();
        AppMethodBeat.m2505o(11876);
        return linkedList;
    }

    public final C46627q drI() {
        C46627q c46627q = null;
        AppMethodBeat.m2504i(11877);
        Cursor a = this.fni.mo10104a("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
        if (a.moveToFirst()) {
            c46627q = new C46627q();
            c46627q.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(11877);
        return c46627q;
    }

    /* renamed from: mE */
    public final C46627q mo64115mE(long j) {
        C46627q c46627q = null;
        AppMethodBeat.m2504i(11878);
        Cursor a = this.fni.mo10104a("SELECT * FROM BizTimeLineInfo where talkerId = " + j + "  order by orderFlag DESC limit 1", null, 0);
        if (a.moveToFirst()) {
            c46627q = new C46627q();
            c46627q.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(11878);
        return c46627q;
    }

    public final C46627q drJ() {
        C46627q c46627q = null;
        AppMethodBeat.m2504i(11879);
        Cursor a = this.fni.mo10104a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
        if (a.moveToFirst()) {
            c46627q = new C46627q();
            c46627q.mo8995d(a);
        }
        a.close();
        AppMethodBeat.m2505o(11879);
        return c46627q;
    }

    /* renamed from: mF */
    public final void mo64116mF(long j) {
        AppMethodBeat.m2504i(11880);
        if (mo64117mG(j) > 2000) {
            C46627q B = mo64097B(j, "orderFlag");
            if (B != null) {
                B.field_status = 4;
                mo64113h(B);
            }
            AppMethodBeat.m2505o(11880);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = -4294967296L & j;
        this.fni.mo10108hY("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where orderFlag >= " + j2 + " and status > 4");
        this.fni.mo10108hY("BizTimeLineInfo", "update BizTimeLineInfo set status = 4 where orderFlag >= " + j2 + " and status < 4");
        C4990ab.m7411d("MicroMsg.BizTimeLineInfoStorage", "resetUnread cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        xHW.mo4412k(Long.valueOf(j), Boolean.TRUE);
        AppMethodBeat.m2505o(11880);
    }

    /* renamed from: mG */
    public final int mo64117mG(long j) {
        AppMethodBeat.m2504i(11881);
        Boolean bool = (Boolean) xHW.get(Long.valueOf(j));
        if (bool == null || !bool.booleanValue()) {
            int i;
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = -4294967296L & j;
            Cursor a = this.fni.mo10104a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + j2 + " and status > 4", null, 0);
            if (a.moveToFirst()) {
                i = a.getInt(0);
            } else {
                i = 0;
            }
            a.close();
            Cursor a2 = this.fni.mo10104a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + j2 + " and status < 4", null, 0);
            if (a2.moveToFirst()) {
                i += a2.getInt(0);
            }
            a2.close();
            if (i > 2000) {
                i = 0;
            }
            if (i == 0) {
                xHW.mo4412k(Long.valueOf(j), Boolean.TRUE);
            }
            C4990ab.m7411d("MicroMsg.BizTimeLineInfoStorage", "getUnread cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(11881);
            return i;
        }
        AppMethodBeat.m2505o(11881);
        return 0;
    }

    public final void drK() {
        AppMethodBeat.m2504i(11882);
        C46627q drI = drI();
        if (drI == null) {
            AppMethodBeat.m2505o(11882);
            return;
        }
        mo64118mH(drI.field_orderFlag);
        AppMethodBeat.m2505o(11882);
    }

    /* renamed from: mH */
    public final void mo64118mH(final long j) {
        AppMethodBeat.m2504i(11883);
        C41930g.dOW().mo60492h(new C5681a<Void, Void>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(11860);
                long currentTimeMillis = System.currentTimeMillis();
                int mI = C40635r.this.mo64119mI(j);
                if (mI > 2000 || mI <= 0) {
                    AppMethodBeat.m2505o(11860);
                } else {
                    boolean hY = C40635r.this.fni.mo10108hY("BizTimeLineInfo", "update BizTimeLineInfo set hasShow = 1 where orderFlag >= " + (j & -4294967296L) + " and hasShow < 1 ");
                    C4990ab.m7411d("MicroMsg.BizTimeLineInfoStorage", "resetUnShow ret = %b, cost = %d", Boolean.valueOf(hY), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(11860);
                }
                return null;
            }
        }).mo60487b(new C406325());
        AppMethodBeat.m2505o(11883);
    }

    /* renamed from: mI */
    public final int mo64119mI(long j) {
        int i;
        AppMethodBeat.m2504i(11884);
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = this.fni.mo10104a("SELECT count(*) FROM BizTimeLineInfo where orderFlag >= " + (-4294967296L & j) + " and hasShow < 1 ", null, 0);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        } else {
            i = 0;
        }
        C4990ab.m7411d("MicroMsg.BizTimeLineInfoStorage", "getUnShowCount count = %d,cost = %d", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        a.close();
        if (i > 2000) {
            if (this.xIa == this.xHY.longValue()) {
                drM();
            }
            AppMethodBeat.m2505o(11884);
            return 0;
        }
        AppMethodBeat.m2505o(11884);
        return i;
    }

    /* renamed from: QS */
    public final boolean mo64098QS(String str) {
        AppMethodBeat.m2504i(11885);
        C4925c c46627q = new C46627q();
        c46627q.field_talker = str;
        boolean a = super.mo10100a(c46627q, false, "talker");
        C40633a c40633a = new C40633a();
        c40633a.talker = c46627q.field_talker;
        c40633a.jOa = c46627q;
        c40633a.xId = C40639b.DELETE;
        mo64099a(c40633a);
        AppMethodBeat.m2505o(11885);
        return a;
    }

    /* renamed from: mJ */
    public final void mo64120mJ(long j) {
        AppMethodBeat.m2504i(11886);
        C4925c c46627q = new C46627q();
        c46627q.field_msgId = j;
        super.mo10100a(c46627q, false, "msgId");
        C40633a c40633a = new C40633a();
        c40633a.xId = C40639b.DELETE;
        mo64099a(c40633a);
        AppMethodBeat.m2505o(11886);
    }

    /* renamed from: mK */
    private synchronized void m70176mK(long j) {
        AppMethodBeat.m2504i(11887);
        this.xHZ = Math.max(j, this.xHZ);
        AppMethodBeat.m2505o(11887);
    }

    public final synchronized long drL() {
        return this.xHZ;
    }

    public final synchronized long drB() {
        long longValue;
        AppMethodBeat.m2504i(11888);
        longValue = this.xHY.longValue();
        AppMethodBeat.m2505o(11888);
        return longValue;
    }

    public final synchronized long drM() {
        long incrementAndGet;
        AppMethodBeat.m2504i(11889);
        incrementAndGet = this.xHY.incrementAndGet();
        AppMethodBeat.m2505o(11889);
        return incrementAndGet;
    }

    private synchronized void drN() {
        AppMethodBeat.m2504i(11890);
        this.xHZ = drO() >> 32;
        if (this.xHZ < 10) {
            this.xHZ = 10;
        }
        C46627q drI = drI();
        if (drI == null) {
            C4990ab.m7421w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", Long.valueOf(this.xHZ));
            AppMethodBeat.m2505o(11890);
        } else {
            if (drI.field_status == 4) {
                this.xHY.set(this.xHZ + 1);
            } else {
                this.xHY.set(this.xHZ);
            }
            this.xIa = this.xHY.longValue();
            C4990ab.m7417i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", Long.valueOf(this.xHY.longValue()), Long.valueOf(this.xHZ), Integer.valueOf(drI.field_status));
            AppMethodBeat.m2505o(11890);
        }
    }

    private synchronized long drO() {
        long j;
        AppMethodBeat.m2504i(11891);
        Cursor a = this.fni.mo10104a("select max(orderFlag) from BizTimeLineInfo", null, 2);
        j = 0;
        if (a.moveToFirst()) {
            j = a.getLong(0);
            a.close();
        }
        AppMethodBeat.m2505o(11891);
        return j;
    }

    /* renamed from: Mv */
    static /* synthetic */ int m70174Mv(int i) {
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
