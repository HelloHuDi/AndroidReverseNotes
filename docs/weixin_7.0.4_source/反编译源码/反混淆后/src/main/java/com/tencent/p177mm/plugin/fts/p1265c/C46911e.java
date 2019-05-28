package com.tencent.p177mm.plugin.fts.p1265c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C34202c.C28110a;
import com.tencent.p177mm.plugin.fts.p419a.C34207i;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C39128k;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fts.c.e */
public final class C46911e extends C45968a {
    public SQLiteStatement mHm;
    public SQLiteStatement mHn;
    private SQLiteStatement mHo;

    public final String getTableName() {
        return "TopHits";
    }

    public final String getName() {
        return "FTS5TopHitsStorage";
    }

    public final int getType() {
        return 1;
    }

    public final int getPriority() {
        return 768;
    }

    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(136838);
        if (mo23703Pp()) {
            this.mBT.mo54778K(-100, 3);
        }
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[]{bAf(), bAf()}));
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[]{bAf(), bAf()}));
        this.mHm = this.mBT.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{bAg()}));
        this.mHn = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{bAf()}));
        this.mHo = this.mBT.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[]{bAf()}));
        AppMethodBeat.m2505o(136838);
    }

    /* renamed from: Nr */
    public final void mo76117Nr(String str) {
        AppMethodBeat.m2504i(136839);
        this.mHo.bindLong(1, 1);
        this.mHo.bindString(2, str);
        this.mHo.execute();
        AppMethodBeat.m2505o(136839);
    }

    public final int bAJ() {
        C39128k c39128k;
        AppMethodBeat.m2504i(136840);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[]{bAf()}), null);
        ArrayList<C39128k> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            C39128k c39128k2 = new C39128k();
            c39128k2.mo62027d(rawQuery);
            arrayList.add(c39128k2);
        }
        rawQuery.close();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (C39128k c39128k3 : arrayList) {
            C34207i fTSIndexStorage;
            boolean z = false;
            if (c39128k3.type == 262144) {
                fTSIndexStorage = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(17);
            } else {
                C34207i fTSIndexStorage2 = ((C12029n) C1720g.m3530M(C12029n.class)).getFTSIndexStorage(3);
                z = C46911e.m89297Ns(c39128k3.mDx);
                fTSIndexStorage = fTSIndexStorage2;
            }
            String str = null;
            if (!z) {
                str = fTSIndexStorage.mo54789ck(c39128k3.mDx, c39128k3.mDw);
            }
            if (C5046bo.isNullOrNil(str)) {
                linkedList2.add(Long.valueOf(c39128k3.mEz));
            } else if (c39128k3.query.equals("​chatroom_tophits")) {
                String str2 = "";
                for (String str3 : C28110a.mCA.split(c39128k3.mEC)) {
                    if (str.indexOf(str3) >= 0) {
                        str2 = str2 + str3 + "​";
                    }
                }
                if (c39128k3.mEC.equals(str2)) {
                    linkedList.add(Long.valueOf(c39128k3.mEz));
                } else {
                    c39128k3.mEC = str2;
                    linkedList2.add(Long.valueOf(c39128k3.mEz));
                    linkedList3.add(c39128k3);
                }
            } else if (c39128k3.mEC.equals(str)) {
                linkedList.add(Long.valueOf(c39128k3.mEz));
            } else {
                c39128k3.mEC = str;
                linkedList2.add(Long.valueOf(c39128k3.mEz));
                linkedList3.add(c39128k3);
            }
        }
        C4990ab.m7417i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList.size()));
        if (linkedList2.size() > 0) {
            mo73843bV(linkedList2);
        }
        if (linkedList3.size() > 0) {
            boolean inTransaction = this.mBT.inTransaction();
            if (!inTransaction) {
                this.mBT.beginTransaction();
            }
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                c39128k3 = (C39128k) it.next();
                if (!C5046bo.isNullOrNil(c39128k3.mEC)) {
                    this.mHm.bindString(1, c39128k3.mEC);
                    this.mHm.execute();
                    this.mHn.bindLong(1, (long) c39128k3.type);
                    this.mHn.bindLong(2, (long) c39128k3.mDw);
                    this.mHn.bindLong(3, c39128k3.mEB);
                    this.mHn.bindString(4, c39128k3.mDx);
                    this.mHn.bindLong(5, c39128k3.timestamp);
                    this.mHn.bindString(6, c39128k3.query);
                    this.mHn.bindLong(7, c39128k3.mEA);
                    this.mHn.bindLong(8, c39128k3.fob);
                    this.mHn.bindString(9, c39128k3.mEC);
                    this.mHn.execute();
                }
            }
            if (!inTransaction) {
                commit();
            }
        }
        if (linkedList.size() > 0) {
            mo73852l(linkedList, 0);
        }
        int size = linkedList2.size();
        AppMethodBeat.m2505o(136840);
        return size;
    }

    /* renamed from: Ns */
    public static boolean m89297Ns(String str) {
        AppMethodBeat.m2504i(136841);
        if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15266Rt(str) < System.currentTimeMillis() - 5184000000L) {
            AppMethodBeat.m2505o(136841);
            return true;
        }
        AppMethodBeat.m2505o(136841);
        return false;
    }

    /* renamed from: Pq */
    public final boolean mo36132Pq() {
        AppMethodBeat.m2504i(136842);
        super.mo36132Pq();
        this.mHm.close();
        this.mHn.close();
        this.mHo.close();
        AppMethodBeat.m2505o(136842);
        return true;
    }

    public final String bvr() {
        AppMethodBeat.m2504i(136843);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[]{bAf()});
        AppMethodBeat.m2505o(136843);
        return format;
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(136844);
        if (mo73849ei(-100, 3)) {
            AppMethodBeat.m2505o(136844);
            return false;
        }
        AppMethodBeat.m2505o(136844);
        return true;
    }
}
