package com.tencent.mm.plugin.fav.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement mgC;

    public final void Po() {
        AppMethodBeat.i(5297);
        if (Pp()) {
            this.mBT.K(-106, 4);
        }
        this.mgC = this.mBT.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{bAf()}));
        AppMethodBeat.o(5297);
    }

    public final boolean Pp() {
        AppMethodBeat.i(5298);
        if (ei(ZipJNI.UNZ_ERR_OPEN_WRITE, 4)) {
            AppMethodBeat.o(5298);
            return false;
        }
        AppMethodBeat.o(5298);
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
        AppMethodBeat.i(5299);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[]{bAf()});
        AppMethodBeat.o(5299);
        return format;
    }

    public final void a(int i, long j, String str, long j2, String str2, int i2) {
        AppMethodBeat.i(5300);
        String Na = d.Na(str2);
        if (bo.isNullOrNil(Na)) {
            AppMethodBeat.o(5300);
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
            AppMethodBeat.o(5300);
        } catch (SQLiteException e) {
            ab.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(196608), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.mCb.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                ab.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> ".concat(String.valueOf(simpleQueryForString)));
            }
            AppMethodBeat.o(5300);
            throw e;
        }
    }
}
