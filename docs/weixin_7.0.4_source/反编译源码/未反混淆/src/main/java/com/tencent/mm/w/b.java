package com.tencent.mm.w;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.ActUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m eAX;
    a eAY;
    private com.tencent.mm.sdk.e.n.b eAZ = new com.tencent.mm.sdk.e.n.b() {
        public final void a(int i, n nVar, Object obj) {
            AppMethodBeat.i(124474);
            if (b.Pr()) {
                String str = (obj == null || !(obj instanceof String)) ? null : (String) obj;
                switch (i) {
                    case 2:
                        if (str != null) {
                            b.this.eAX.a(65636, new f(str));
                            AppMethodBeat.o(124474);
                            return;
                        }
                        break;
                    case 5:
                        if (str != null) {
                            b.this.eAX.a(65636, new d(str));
                            break;
                        }
                        b.this.eAX.a(65636, new c());
                        AppMethodBeat.o(124474);
                        return;
                }
                AppMethodBeat.o(124474);
                return;
            }
            AppMethodBeat.o(124474);
        }
    };

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        public boolean eBg;
        private HashSet<Long> eBh;
        private long eBi;
        private int eBj;
        private HashMap<int[], e> eBk;

        private b() {
            AppMethodBeat.i(124476);
            this.eBg = false;
            this.eBh = null;
            this.eBi = Long.MIN_VALUE;
            this.eBj = -1;
            this.eBk = new HashMap();
            AppMethodBeat.o(124476);
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.i(124477);
            ab.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
            this.eBg = b.Pr();
            if (this.eBj < 0) {
                this.eBj = 0;
            }
            ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", Boolean.valueOf(this.eBg), Integer.valueOf(this.eBj));
            if (this.eBj == 0) {
                if (this.eBg) {
                    if (!this.eBk.containsKey(com.tencent.mm.plugin.fts.a.c.mCm)) {
                        this.eBk.put(com.tencent.mm.plugin.fts.a.c.mCm, new e());
                    }
                    if (this.eBh == null) {
                        this.eBh = new HashSet();
                        Cursor a = b.this.eAY.a(com.tencent.mm.plugin.fts.a.c.mCm, false, true, false, false, false);
                        while (a.moveToNext()) {
                            this.eBh.add(Long.valueOf(a.getLong(0)));
                        }
                        a.close();
                    }
                    InterruptedException interruptedException;
                    if (Thread.interrupted()) {
                        interruptedException = new InterruptedException();
                        AppMethodBeat.o(124477);
                        throw interruptedException;
                    }
                    int i;
                    e eVar;
                    Cursor i2 = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().i("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[]{Long.toString(this.eBi)});
                    int i3 = 50;
                    while (i2.moveToNext()) {
                        if (Thread.interrupted()) {
                            i2.close();
                            b.this.eAY.commit();
                            interruptedException = new InterruptedException();
                            AppMethodBeat.o(124477);
                            throw interruptedException;
                        }
                        long j = i2.getLong(0);
                        this.eBi = j;
                        a aVar = new a();
                        aVar.id = j;
                        aVar.eBb = i2.getString(1);
                        aVar.eBc = i2.getString(2);
                        aVar.eBd = i2.getString(3);
                        aVar.bCu = i2.getString(4);
                        aVar.eBe = i2.getString(5);
                        aVar.eBf = i2.getString(6);
                        aVar.userName = i2.getString(7);
                        aVar.status = i2.getInt(8);
                        aVar.cFl = i2.getString(9);
                        aVar.type = 0;
                        if (aVar.status == 65536) {
                            aVar.status = 0;
                        }
                        if (b.a(aVar) && !this.eBh.remove(Long.valueOf(aVar.id))) {
                            if (i3 >= 50) {
                                b.this.eAY.commit();
                                b.this.eAY.beginTransaction();
                                i = 0;
                            } else {
                                i = i3;
                            }
                            try {
                                i += b.a(b.this, aVar);
                                eVar = (e) this.eBk.get(com.tencent.mm.plugin.fts.a.c.mCm);
                                eVar.eBn++;
                                i3 = i;
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", e, "Build mobile friend index failed with exception.", new Object[0]);
                                eVar = (e) this.eBk.get(com.tencent.mm.plugin.fts.a.c.mCm);
                                eVar.mFailedCount++;
                                i3 = i;
                            }
                        }
                    }
                    i2.close();
                    b.this.eAY.commit();
                    Iterator it = this.eBh.iterator();
                    i3 = 50;
                    while (it.hasNext()) {
                        if (i3 >= 50) {
                            b.this.eAY.commit();
                            b.this.eAY.beginTransaction();
                            i = 0;
                        } else {
                            i = i3;
                        }
                        b.this.eAY.c(com.tencent.mm.plugin.fts.a.c.mCm, ((Long) it.next()).longValue());
                        i++;
                        eVar = (e) this.eBk.get(com.tencent.mm.plugin.fts.a.c.mCm);
                        eVar.eBo++;
                        it.remove();
                        i3 = i;
                    }
                    b.this.eAY.commit();
                    this.eBh = null;
                    this.eBi = Long.MIN_VALUE;
                }
                this.eBj = -1;
            }
            AppMethodBeat.o(124477);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(124478);
            String str;
            if (this.eBk.containsKey(com.tencent.mm.plugin.fts.a.c.mCm)) {
                str = "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((e) this.eBk.get(com.tencent.mm.plugin.fts.a.c.mCm)).eBn + ", removed: " + ((e) this.eBk.get(com.tencent.mm.plugin.fts.a.c.mCm)).eBo + ", failed: " + ((e) this.eBk.get(com.tencent.mm.plugin.fts.a.c.mCm)).mFailedCount + "]";
                AppMethodBeat.o(124478);
                return str;
            }
            str = "";
            AppMethodBeat.o(124478);
            return str;
        }

        public final int getId() {
            return 2;
        }

        public final String getName() {
            return "BuildFriendIndexTask";
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.a {
        private int eBl = 0;
        private int mCount = 0;

        public final boolean execute() {
            AppMethodBeat.i(124479);
            ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", Integer.valueOf(this.eBl));
            if (this.eBl == 0) {
                this.mCount = b.this.eAY.g(com.tencent.mm.plugin.fts.a.c.mCm, -1).size();
            }
            AppMethodBeat.o(124479);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(124480);
            String str = "DeleteAllFriends [" + this.mCount + ", " + this.eBl + "]";
            AppMethodBeat.o(124480);
            return str;
        }
    }

    static class a {
        String bCu;
        String cFl;
        String eBb;
        String eBc;
        String eBd;
        String eBe;
        String eBf;
        long id;
        int status;
        int type;
        String userName;

        a() {
        }

        a(com.tencent.mm.plugin.account.friend.a.a aVar) {
            AppMethodBeat.i(124475);
            this.id = (long) com.tencent.mm.plugin.account.friend.a.a.vR(aVar.Aq());
            this.eBb = aVar.apA();
            this.eBc = aVar.apC();
            this.eBd = aVar.apB();
            this.bCu = aVar.apD();
            this.eBe = aVar.apF();
            this.eBf = aVar.apE();
            this.userName = aVar.getUsername();
            this.cFl = aVar.apG();
            this.type = aVar.type;
            this.status = aVar.status;
            AppMethodBeat.o(124475);
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int eBl = 0;
        private String eBm;

        public d(String str) {
            this.eBm = str;
        }

        public final boolean execute() {
            AppMethodBeat.i(124481);
            ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", this.eBm, Integer.valueOf(this.eBl));
            if (this.eBl == 0) {
                b.this.eAY.c(com.tencent.mm.plugin.fts.a.c.mCm, (long) com.tencent.mm.plugin.account.friend.a.a.vR(this.eBm));
            }
            AppMethodBeat.o(124481);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(124482);
            String str = "DeleteFriend(\"" + this.eBm + "\", " + this.eBl + ")";
            AppMethodBeat.o(124482);
            return str;
        }
    }

    static class e {
        public int eBn;
        public int eBo;
        public int mFailedCount;

        private e() {
            this.eBn = 0;
            this.eBo = 0;
            this.mFailedCount = 0;
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    class f extends com.tencent.mm.plugin.fts.a.a.a {
        private int eBl;
        private String eBm;
        private boolean eBp = false;

        public f(String str) {
            this.eBm = str;
            this.eBl = 0;
        }

        public final boolean execute() {
            AppMethodBeat.i(124483);
            ab.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", this.eBm, Integer.valueOf(this.eBl));
            if (this.eBl == 0) {
                com.tencent.mm.plugin.account.friend.a.a vW = ((com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).vW(this.eBm);
                if (vW == null) {
                    this.eBp = true;
                    AppMethodBeat.o(124483);
                    return true;
                }
                a aVar = new a(vW);
                if (b.a(aVar)) {
                    b.a(b.this, aVar);
                } else {
                    this.eBp = true;
                }
            }
            AppMethodBeat.o(124483);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(124484);
            String str = "InsertFriend(\"" + this.eBm + "\", " + this.eBl + ")" + (this.eBp ? " [skipped]" : "");
            AppMethodBeat.o(124484);
            return str;
        }
    }

    class g extends h {
        private int[] eBq;
        private int[] eBr;

        public g(i iVar) {
            super(iVar);
            this.eBq = iVar.mEr;
            this.eBr = iVar.mEs;
        }

        public final void a(j jVar) {
            AppMethodBeat.i(124485);
            super.a(jVar);
            a aVar = b.this.eAY;
            String[] strArr = jVar.mDz.mEa;
            int[] iArr = this.eBq;
            int[] iArr2 = this.eBr;
            String B = com.tencent.mm.plugin.fts.a.d.B(strArr);
            String format = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{aVar.bAg(), Integer.valueOf(strArr.length)});
            String str = "";
            String str2 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + com.tencent.mm.plugin.fts.a.d.t(iArr2);
            String str3 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + com.tencent.mm.plugin.fts.a.d.t(iArr);
            Cursor MS = aVar.mBT.MS(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content" + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str3 + str + " AND status >= 0" + str2 + ";", new Object[]{aVar.bAf(), aVar.bAf(), aVar.bAg(), aVar.bAf(), aVar.bAg(), aVar.bAg(), B}));
            HashMap hashMap = new HashMap();
            while (MS.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.m k = new com.tencent.mm.plugin.fts.a.a.m().k(MS);
                if (!this.mEl.mEu.contains(k.mDx)) {
                    l lVar = (l) hashMap.get(Long.valueOf(k.mEB));
                    if (lVar == null || com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.mCv, k.mDw, lVar.mDw) < 0) {
                        k.bAo();
                        hashMap.put(Long.valueOf(k.mEB), k);
                    }
                }
            }
            MS.close();
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                AppMethodBeat.o(124485);
                throw interruptedException;
            }
            jVar.mEy = new ArrayList();
            jVar.mEy.addAll(hashMap.values());
            if (this.mEl.mEv != null) {
                Collections.sort(jVar.mEy, this.mEl.mEv);
            }
            AppMethodBeat.o(124485);
        }

        public final String getName() {
            return "FTS5SearchFriendLogic.NormalSearchTask";
        }
    }

    public b() {
        AppMethodBeat.i(124486);
        AppMethodBeat.o(124486);
    }

    public final String getName() {
        return "FTS5SearchFriendLogic";
    }

    public final boolean onCreate() {
        AppMethodBeat.i(124487);
        if (((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).isFTSContextReady()) {
            ab.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
            this.eAY = (a) ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSIndexStorage(ActUtil.HEIGHT);
            this.eAX = ((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon();
            this.eAX.a(131172, new b(this, (byte) 0));
            ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().a(this.eAZ);
            AppMethodBeat.o(124487);
            return true;
        }
        ab.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
        AppMethodBeat.o(124487);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(124488);
        ((com.tencent.mm.plugin.account.a.a.a) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg().b(this.eAZ);
        AppMethodBeat.o(124488);
        return true;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        AppMethodBeat.i(124489);
        com.tencent.mm.plugin.fts.a.a.a a = this.eAX.a(-65536, new g(iVar));
        AppMethodBeat.o(124489);
        return a;
    }

    static /* synthetic */ boolean Pr() {
        AppMethodBeat.i(124490);
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(6, null);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(124490);
            return false;
        }
        AppMethodBeat.o(124490);
        return true;
    }

    static /* synthetic */ int a(b bVar, a aVar) {
        int i;
        String str;
        String str2;
        AppMethodBeat.i(124491);
        long currentTimeMillis = System.currentTimeMillis();
        String nullAsNil = bo.nullAsNil(aVar.userName);
        int i2 = aVar.status != 0 ? 131073 : 131074;
        if (aVar.cFl == null || aVar.cFl.length() <= 0) {
            i = 0;
        } else {
            bVar.eAY.a(i2, 16, aVar.id, aVar.userName, currentTimeMillis, aVar.cFl);
            i = 1;
        }
        String str3 = aVar.eBb;
        String str4 = aVar.eBc;
        String str5 = aVar.eBd;
        if (str3 != null && str3.length() > 0) {
            if (str3.equalsIgnoreCase(str4)) {
                str = null;
            } else {
                str = str4;
            }
            if (str == null || str.equalsIgnoreCase(str5)) {
                str2 = null;
            } else {
                str2 = str5;
            }
            bVar.eAY.a(i2, 12, aVar.id, nullAsNil, currentTimeMillis, str3);
            i++;
            if (str != null) {
                bVar.eAY.a(i2, 13, aVar.id, nullAsNil, currentTimeMillis, str);
                i++;
            }
            if (str2 != null) {
                bVar.eAY.a(i2, 14, aVar.id, nullAsNil, currentTimeMillis, str2);
                i++;
            }
        }
        str3 = aVar.bCu;
        str4 = aVar.eBe;
        str5 = aVar.eBf;
        if (str3 != null && str3.length() > 0) {
            if (str3.equalsIgnoreCase(str4)) {
                str = null;
            } else {
                str = str4;
            }
            if (str == null || str.equalsIgnoreCase(str5)) {
                str2 = null;
            } else {
                str2 = str5;
            }
            bVar.eAY.a(i2, 5, aVar.id, nullAsNil, currentTimeMillis, str3);
            i++;
            if (str != null) {
                bVar.eAY.a(i2, 6, aVar.id, nullAsNil, currentTimeMillis, str);
                i++;
            }
            if (str2 != null) {
                bVar.eAY.a(i2, 7, aVar.id, nullAsNil, currentTimeMillis, str2);
                i++;
            }
        }
        AppMethodBeat.o(124491);
        return i;
    }
}
