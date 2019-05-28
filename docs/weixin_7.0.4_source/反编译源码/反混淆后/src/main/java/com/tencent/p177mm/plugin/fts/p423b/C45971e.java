package com.tencent.p177mm.plugin.fts.p423b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p1265c.C20853a;
import com.tencent.p177mm.plugin.fts.p1265c.C39136b;
import com.tencent.p177mm.plugin.fts.p1265c.C46911e;
import com.tencent.p177mm.plugin.fts.p419a.C12028m;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C24765b;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c.C28110a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20844h;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39128k;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39129m;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43121f;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.fts.b.e */
public final class C45971e extends C24765b {
    private C12028m eAX;
    C46911e mGO;
    HashSet<String> mGP;

    /* renamed from: com.tencent.mm.plugin.fts.b.e$a */
    class C20851a extends C28106a {
        int mGQ;
        int mGR;

        private C20851a() {
        }

        /* synthetic */ C20851a(C45971e c45971e, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136777);
            this.mGR = C45971e.this.mGO.bAJ();
            long currentTimeMillis = System.currentTimeMillis() - 5184000000L;
            C46911e c46911e = C45971e.this.mGO;
            String format = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[]{c46911e.bAf()});
            Cursor rawQuery = c46911e.mBT.rawQuery(format, new String[]{String.valueOf(currentTimeMillis)});
            LinkedList linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                linkedList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            c46911e.mo73843bV(linkedList);
            this.mGQ = linkedList.size();
            AppMethodBeat.m2505o(136777);
            return true;
        }

        public final String aAo() {
            AppMethodBeat.m2504i(136778);
            String format = String.format("{topHitsUpdateCount: %d deleteExpiredCount: %d}", new Object[]{Integer.valueOf(this.mGR), Integer.valueOf(this.mGQ)});
            AppMethodBeat.m2505o(136778);
            return format;
        }

        public final String getName() {
            return "BuildTopHitsIndexTask";
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.e$b */
    class C24771b extends C20844h {
        public C24771b(C20846i c20846i) {
            super(c20846i);
        }

        public final String getName() {
            return "SearchTopHitsTask";
        }

        public final int getId() {
            return 8;
        }

        /* renamed from: a */
        public final void mo7437a(C28109j c28109j) {
            C39129m k;
            AppMethodBeat.m2504i(136779);
            c28109j.mDz = C20840g.m32052aO(this.mEl.query, true);
            C4990ab.m7417i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", c28109j.mDz.bAl().replaceAll("​", ","));
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.mEl.mEu);
            c28109j.mEy = new ArrayList();
            HashSet hashSet2 = new HashSet();
            C46911e c46911e = C45971e.this.mGO;
            C20840g c20840g = c28109j.mDz;
            int[] iArr = this.mEl.mEr;
            int i = this.mEl.scene;
            int size = this.mEl.mEt + this.mEl.mEu.size();
            String str = c20840g.mDY + '%';
            String bAl = c20840g.bAl();
            String str2 = "query LIKE ?";
            bAl = String.format("AND %s MATCH '%s'", new Object[]{c46911e.bAg(), bAl});
            String str3 = "AND type IN " + C3161d.m5418t(iArr);
            String str4 = "AND status >= 0 AND score >= 3";
            String concat = size > 0 ? "LIMIT ".concat(String.valueOf(size)) : "";
            long size2 = (long) c20840g.mEc.size();
            Cursor rawQuery = c46911e.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[]{c46911e.bAf(), c46911e.bAg(), Long.valueOf(size2), c46911e.bAg(), c46911e.bAf(), str2, bAl, str3, "AND scene=?", str4, c46911e.bAf(), c46911e.bAg(), concat}), new String[]{str, String.valueOf(i)});
            while (rawQuery.moveToNext()) {
                try {
                    k = new C39129m().mo62032k(rawQuery);
                    if (hashSet.add(k.mDx)) {
                        k.bAo();
                        k.userData = "";
                        if (k.type == 262144) {
                            k.userData = ((C39136b) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(17)).mo62039wa((int) k.mEB);
                            if (k.userData == null) {
                                continue;
                            }
                        } else if (k.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT && C46911e.m89297Ns(k.mDx)) {
                            hashSet2.add(k.mDx);
                        }
                        c28109j.mEy.add(k);
                        if (c28109j.mEy.size() >= this.mEl.mEt) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    rawQuery.close();
                    AppMethodBeat.m2505o(136779);
                }
            }
            rawQuery.close();
            C4990ab.m7411d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", Integer.valueOf(c28109j.mEy.size()));
            if (c28109j.mDz.mEa.length > 1) {
                if (c28109j.mEy.size() > 2) {
                    c28109j.mEy = c28109j.mEy.subList(0, 2);
                }
                hashSet.clear();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= c28109j.mEy.size()) {
                        break;
                    }
                    hashSet.add(((C45966l) c28109j.mEy.get(i3)).mDx);
                    i2 = i3 + 1;
                }
                HashSet hashSet3 = new HashSet();
                C46911e c46911e2 = C45971e.this.mGO;
                c20840g = c28109j.mDz;
                int[] iArr2 = this.mEl.mEr;
                size = this.mEl.scene;
                int size3 = this.mEl.mEt + this.mEl.mEu.size();
                String bAl2 = c20840g.bAl();
                Cursor rawQuery2 = c46911e2.mBT.rawQuery(String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + size + (" AND type IN " + C3161d.m5418t(iArr2)) + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[]{c46911e2.bAg(), bAl2}) + " ORDER BY score desc limit " + size3 + ";", new Object[]{c46911e2.bAf(), c46911e2.bAg(), c46911e2.bAf(), c46911e2.bAg(), c46911e2.bAf(), c46911e2.bAg()}), new String[]{"​chatroom_tophits"});
                while (rawQuery2.moveToNext()) {
                    bAl2 = rawQuery2.getString(0);
                    if (!hashSet.contains(bAl2)) {
                        hashSet3.add(bAl2);
                    }
                }
                rawQuery2.close();
                C20853a c20853a = (C20853a) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3);
                Iterator it = hashSet3.iterator();
                while (it.hasNext()) {
                    String str5 = (String) it.next();
                    c20840g = c28109j.mDz;
                    String bAl3 = c20840g.bAl();
                    long size4 = (long) c20840g.mEc.size();
                    rawQuery = c20853a.mBT.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38;", new Object[]{c20853a.bAf(), c20853a.bAg(), Long.valueOf(size4), c20853a.bAf(), c20853a.bAg(), c20853a.bAf(), c20853a.bAg(), c20853a.bAg(), bAl3}), new String[]{str5});
                    if (rawQuery.moveToNext()) {
                        k = new C39129m().mo62032k(rawQuery);
                        k.userData = "​chatroom_tophits";
                        k.bAo();
                        c28109j.mEy.add(k);
                        if (c28109j.mEy.size() >= this.mEl.mEt) {
                            break;
                        }
                    }
                    rawQuery.close();
                }
            }
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                C45971e.this.mo73854Nn((String) it2.next());
            }
            AppMethodBeat.m2505o(136779);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.b.e$c */
    class C31361c extends C28106a {
        private HashMap<String, String> mCH;
        private C45966l mGT;
        private String query;
        private int scene;

        private C31361c() {
        }

        /* synthetic */ C31361c(C45971e c45971e, byte b) {
            this();
        }

        public final boolean execute() {
            AppMethodBeat.m2504i(136780);
            C46911e c46911e = C45971e.this.mGO;
            String str = this.query;
            C45966l c45966l = this.mGT;
            int i = this.scene;
            HashMap hashMap = this.mCH;
            String trim = str.trim();
            hashMap.remove(c45966l.mDx);
            boolean inTransaction = c46911e.mBT.inTransaction();
            if (!inTransaction) {
                c46911e.mBT.beginTransaction();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if ((c45966l.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || c45966l.type == 131075) && C46911e.m89297Ns(c45966l.mDx)) {
                C4990ab.m7416i("MicroMsg.FTS.FTS5TopHitsStorage", "last contact msg time older than 60 days");
            } else {
                int i2;
                int i3;
                int i4;
                int i5;
                Cursor rawQuery = c46911e.mBT.rawQuery(String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[]{c46911e.bAf()}), new String[]{trim, c45966l.mDx, String.valueOf(c45966l.mDw), String.valueOf(i)});
                if (rawQuery.moveToNext()) {
                    i2 = rawQuery.getInt(0);
                    i3 = rawQuery.getInt(1);
                    i4 = i2;
                } else {
                    i3 = -1;
                    i4 = -1;
                }
                rawQuery.close();
                String str2 = "";
                for (Entry entry : hashMap.entrySet()) {
                    if (((String) entry.getValue()).equals("​chatroom_tophits")) {
                        str = str2;
                    } else {
                        str = str2 + "'" + ((String) entry.getKey()) + "',";
                    }
                    str2 = str;
                }
                if (str2.length() > 0) {
                    str = "AND aux_index IN (" + str2.substring(0, str2.length() - 1) + ")";
                    c46911e.mBT.execSQL(String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[]{c46911e.bAf(), Integer.valueOf(i), str}));
                }
                str2 = "";
                for (Entry entry2 : hashMap.entrySet()) {
                    if (((String) entry2.getValue()).equals("​chatroom_tophits")) {
                        str = str2 + "'" + ((String) entry2.getKey()) + "',";
                    } else {
                        str = str2;
                    }
                    str2 = str;
                }
                if (str2.length() > 0) {
                    str = "AND aux_index IN(" + str2.substring(0, str2.length() - 1) + ")";
                    c46911e.mBT.execSQL(String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[]{c46911e.bAf(), Integer.valueOf(i), str}), new String[]{"​chatroom_tophits"});
                }
                if (i4 < 0 || i3 < 0) {
                    c46911e.mHm.bindString(1, c45966l.content);
                    c46911e.mHm.execute();
                    c46911e.mHn.bindLong(1, (long) c45966l.type);
                    c46911e.mHn.bindLong(2, (long) c45966l.mDw);
                    c46911e.mHn.bindLong(3, c45966l.mEB);
                    c46911e.mHn.bindString(4, c45966l.mDx);
                    c46911e.mHn.bindLong(5, currentTimeMillis);
                    c46911e.mHn.bindString(6, trim);
                    c46911e.mHn.bindLong(7, 3);
                    c46911e.mHn.bindLong(8, (long) i);
                    c46911e.mHn.bindString(9, c45966l.content);
                    c46911e.mHn.execute();
                } else {
                    if (i3 > 6) {
                        i5 = i3 + 1;
                    } else {
                        i5 = i3 + 3;
                    }
                    c46911e.mBT.execSQL(String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[]{c46911e.bAf()}), new String[]{String.valueOf(i5), String.valueOf(currentTimeMillis), String.valueOf(i4)});
                }
                if (!inTransaction) {
                    c46911e.mBT.commit();
                }
                String[] split = C28110a.mCE.split(trim);
                if (split.length > 1 && c45966l.type == 131075 && c45966l.mDw == 38) {
                    HashSet hashSet = new HashSet();
                    C39128k c39128k = new C39128k();
                    Cursor rawQuery2 = c46911e.mBT.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[]{c46911e.bAf()}), new String[]{c45966l.mDx, "​chatroom_tophits"});
                    if (rawQuery2.moveToNext()) {
                        c39128k.mo62027d(rawQuery2);
                        for (Object add : C28110a.mCA.split(c39128k.mEC)) {
                            hashSet.add(add);
                        }
                    }
                    rawQuery2.close();
                    i5 = 0;
                    while (true) {
                        i2 = i5;
                        if (i2 >= c45966l.mEI.size() || i2 >= split.length) {
                            C4990ab.m7417i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", c39128k.mEC);
                        } else {
                            C43121f c43121f = (C43121f) c45966l.mEI.get(i2);
                            if (hashSet.add(c43121f.content)) {
                                c39128k.mEC += c43121f.content + "​";
                            }
                            i5 = i2 + 1;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", c39128k.mEC);
                    if (c39128k.mEz > 0) {
                        c46911e.mo73851g(Long.valueOf(c39128k.mEz));
                    }
                    c39128k.mEz = 0;
                    c39128k.query = "​chatroom_tophits";
                    c39128k.mEA++;
                    c39128k.fob = (long) i;
                    c39128k.mDx = c45966l.mDx;
                    c39128k.mEB = c45966l.mEB;
                    c39128k.type = c45966l.type;
                    c39128k.mDw = c45966l.mDw;
                    c39128k.timestamp = currentTimeMillis;
                    c46911e.mHm.bindString(1, c39128k.mEC);
                    c46911e.mHm.execute();
                    c46911e.mHn.bindLong(1, (long) c39128k.type);
                    c46911e.mHn.bindLong(2, (long) c39128k.mDw);
                    c46911e.mHn.bindLong(3, c39128k.mEB);
                    c46911e.mHn.bindString(4, c39128k.mDx);
                    c46911e.mHn.bindLong(5, c39128k.timestamp);
                    c46911e.mHn.bindString(6, c39128k.query);
                    c46911e.mHn.bindLong(7, c39128k.mEA);
                    c46911e.mHn.bindLong(8, c39128k.fob);
                    c46911e.mHn.bindString(9, c39128k.mEC);
                    c46911e.mHn.execute();
                }
            }
            AppMethodBeat.m2505o(136780);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(136781);
            String format = String.format("%s : query=%s scene=%d", new Object[]{super.toString(), this.query, Integer.valueOf(this.scene)});
            AppMethodBeat.m2505o(136781);
            return format;
        }

        public final String getName() {
            return "UpdateTopHitsWithQueryTask";
        }
    }

    public final boolean onCreate() {
        AppMethodBeat.m2504i(136782);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSContextReady()) {
            C4990ab.m7416i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
            this.mGP = new HashSet();
            this.mGO = (C46911e) ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(1);
            this.eAX = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSTaskDaemon();
            this.eAX.mo23853a(65626, new C20851a(this, (byte) 0));
            AppMethodBeat.m2505o(136782);
            return true;
        }
        C4990ab.m7416i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
        AppMethodBeat.m2505o(136782);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo23883Pq() {
        AppMethodBeat.m2504i(136783);
        if (this.mGP != null) {
            this.mGP.clear();
        }
        this.mGO = null;
        this.eAX = null;
        AppMethodBeat.m2505o(136783);
        return true;
    }

    /* renamed from: a */
    public final C28106a mo23884a(C20846i c20846i) {
        AppMethodBeat.m2504i(136784);
        C28106a a = this.eAX.mo23853a(-65536, new C24771b(c20846i));
        AppMethodBeat.m2505o(136784);
        return a;
    }

    /* renamed from: Nn */
    public final void mo73854Nn(String str) {
        AppMethodBeat.m2504i(136785);
        if (this.mGP.add(str)) {
            this.mGO.mo76117Nr(str);
        }
        AppMethodBeat.m2505o(136785);
    }

    /* renamed from: d */
    public final void mo73855d(int[] iArr, String str) {
        AppMethodBeat.m2504i(136786);
        this.mGO.mo73840b(iArr, str);
        AppMethodBeat.m2505o(136786);
    }

    public final String getName() {
        return "FTS5SearchTopHitsLogic";
    }

    /* renamed from: a */
    public final void mo36116a(String str, C45966l c45966l, int i, HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(136787);
        C31361c c31361c = new C31361c(this, (byte) 0);
        c31361c.query = str;
        c31361c.mGT = c45966l;
        c31361c.scene = i;
        c31361c.mCH = hashMap;
        this.eAX.mo23853a(65626, c31361c);
        AppMethodBeat.m2505o(136787);
    }
}
