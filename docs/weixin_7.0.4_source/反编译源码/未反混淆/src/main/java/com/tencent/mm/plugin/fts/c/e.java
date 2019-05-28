package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends a {
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

    public final void Po() {
        AppMethodBeat.i(136838);
        if (Pp()) {
            this.mBT.K(-100, 3);
        }
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[]{bAf(), bAf()}));
        this.mBT.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[]{bAf(), bAf()}));
        this.mHm = this.mBT.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{bAg()}));
        this.mHn = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{bAf()}));
        this.mHo = this.mBT.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[]{bAf()}));
        AppMethodBeat.o(136838);
    }

    public final void Nr(String str) {
        AppMethodBeat.i(136839);
        this.mHo.bindLong(1, 1);
        this.mHo.bindString(2, str);
        this.mHo.execute();
        AppMethodBeat.o(136839);
    }

    public final int bAJ() {
        k kVar;
        AppMethodBeat.i(136840);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[]{bAf()}), null);
        ArrayList<k> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            k kVar2 = new k();
            kVar2.d(rawQuery);
            arrayList.add(kVar2);
        }
        rawQuery.close();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (k kVar3 : arrayList) {
            i fTSIndexStorage;
            boolean z = false;
            if (kVar3.type == 262144) {
                fTSIndexStorage = ((n) g.M(n.class)).getFTSIndexStorage(17);
            } else {
                i fTSIndexStorage2 = ((n) g.M(n.class)).getFTSIndexStorage(3);
                z = Ns(kVar3.mDx);
                fTSIndexStorage = fTSIndexStorage2;
            }
            String str = null;
            if (!z) {
                str = fTSIndexStorage.ck(kVar3.mDx, kVar3.mDw);
            }
            if (bo.isNullOrNil(str)) {
                linkedList2.add(Long.valueOf(kVar3.mEz));
            } else if (kVar3.query.equals("​chatroom_tophits")) {
                String str2 = "";
                for (String str3 : c.a.mCA.split(kVar3.mEC)) {
                    if (str.indexOf(str3) >= 0) {
                        str2 = str2 + str3 + "​";
                    }
                }
                if (kVar3.mEC.equals(str2)) {
                    linkedList.add(Long.valueOf(kVar3.mEz));
                } else {
                    kVar3.mEC = str2;
                    linkedList2.add(Long.valueOf(kVar3.mEz));
                    linkedList3.add(kVar3);
                }
            } else if (kVar3.mEC.equals(str)) {
                linkedList.add(Long.valueOf(kVar3.mEz));
            } else {
                kVar3.mEC = str;
                linkedList2.add(Long.valueOf(kVar3.mEz));
                linkedList3.add(kVar3);
            }
        }
        ab.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList.size()));
        if (linkedList2.size() > 0) {
            bV(linkedList2);
        }
        if (linkedList3.size() > 0) {
            boolean inTransaction = this.mBT.inTransaction();
            if (!inTransaction) {
                this.mBT.beginTransaction();
            }
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                kVar3 = (k) it.next();
                if (!bo.isNullOrNil(kVar3.mEC)) {
                    this.mHm.bindString(1, kVar3.mEC);
                    this.mHm.execute();
                    this.mHn.bindLong(1, (long) kVar3.type);
                    this.mHn.bindLong(2, (long) kVar3.mDw);
                    this.mHn.bindLong(3, kVar3.mEB);
                    this.mHn.bindString(4, kVar3.mDx);
                    this.mHn.bindLong(5, kVar3.timestamp);
                    this.mHn.bindString(6, kVar3.query);
                    this.mHn.bindLong(7, kVar3.mEA);
                    this.mHn.bindLong(8, kVar3.fob);
                    this.mHn.bindString(9, kVar3.mEC);
                    this.mHn.execute();
                }
            }
            if (!inTransaction) {
                commit();
            }
        }
        if (linkedList.size() > 0) {
            l(linkedList, 0);
        }
        int size = linkedList2.size();
        AppMethodBeat.o(136840);
        return size;
    }

    public static boolean Ns(String str) {
        AppMethodBeat.i(136841);
        if (((j) g.K(j.class)).bOr().Rt(str) < System.currentTimeMillis() - 5184000000L) {
            AppMethodBeat.o(136841);
            return true;
        }
        AppMethodBeat.o(136841);
        return false;
    }

    public final boolean Pq() {
        AppMethodBeat.i(136842);
        super.Pq();
        this.mHm.close();
        this.mHn.close();
        this.mHo.close();
        AppMethodBeat.o(136842);
        return true;
    }

    public final String bvr() {
        AppMethodBeat.i(136843);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[]{bAf()});
        AppMethodBeat.o(136843);
        return format;
    }

    public final boolean Pp() {
        AppMethodBeat.i(136844);
        if (ei(-100, 3)) {
            AppMethodBeat.o(136844);
            return false;
        }
        AppMethodBeat.o(136844);
        return true;
    }
}
