package com.tencent.p177mm.plugin.fav.p408b.p968a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

/* renamed from: com.tencent.mm.plugin.fav.b.a.a */
public final class C11857a extends C45968a {
    private SQLiteStatement mgC;

    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(5297);
        if (mo23703Pp()) {
            this.mBT.mo54778K(-106, 4);
        }
        this.mgC = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{bAf()}));
        AppMethodBeat.m2505o(5297);
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(5298);
        if (mo73849ei(ZipJNI.UNZ_ERR_OPEN_WRITE, 4)) {
            AppMethodBeat.m2505o(5298);
            return false;
        }
        AppMethodBeat.m2505o(5298);
        return true;
    }

    public final String getTableName() {
        return "Favorite";
    }

    public final String getName() {
        return "FTS5FavoriteStorage";
    }

    public final int getType() {
        return 256;
    }

    public final int getPriority() {
        return 256;
    }

    public final String bvr() {
        AppMethodBeat.m2504i(5299);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[]{bAf()});
        AppMethodBeat.m2505o(5299);
        return format;
    }

    /* renamed from: a */
    public final void mo23704a(int i, long j, String str, long j2, String str2, int i2) {
        AppMethodBeat.m2504i(5300);
        String Na = C3161d.m5403Na(str2);
        if (C5046bo.isNullOrNil(Na)) {
            AppMethodBeat.m2505o(5300);
            return;
        }
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        try {
            this.mBU.bindString(1, Na);
            this.mBU.execute();
            this.mgC.bindLong(1, 196608);
            this.mgC.bindLong(2, (long) i);
            this.mgC.bindLong(3, j);
            this.mgC.bindString(4, str);
            this.mgC.bindLong(5, j2);
            this.mgC.bindLong(6, (long) i2);
            this.mgC.execute();
            if (!inTransaction) {
                this.mBT.commit();
            }
            AppMethodBeat.m2505o(5300);
        } catch (SQLiteException e) {
            C4990ab.m7412e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(196608), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.mCb.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                C4990ab.m7412e("MicroMsg.FTS.FTS5FavoriteStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
            }
            AppMethodBeat.m2505o(5300);
            throw e;
        }
    }
}
