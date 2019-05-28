package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public final class b extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement mHh;

    public static class a {
        public int mHi;
        public long timestamp;
    }

    public final void Po() {
        AppMethodBeat.i(136821);
        if (Pp()) {
            this.mBT.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{"Feature"}));
            K(-101, 2);
        }
        if (!this.mBT.MT("Feature")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS Feature ( ");
            stringBuilder.append(c.ccO.sql);
            stringBuilder.append(");");
            this.mBT.execSQL(stringBuilder.toString());
        }
        this.mHh = this.mBT.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{"Feature"}));
        AppMethodBeat.o(136821);
    }

    public final boolean Pp() {
        AppMethodBeat.i(136822);
        if (ei(XWalkUpdater.ERROR_SET_VERNUM, 2)) {
            AppMethodBeat.o(136822);
            return false;
        }
        AppMethodBeat.o(136822);
        return true;
    }

    public final List<a> bAI() {
        AppMethodBeat.i(136823);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT entity_id, timestamp FROM %s", new Object[]{bAf()}), null);
        while (rawQuery.moveToNext()) {
            int i = rawQuery.getInt(0);
            if (hashSet.add(Integer.valueOf(i))) {
                a aVar = new a();
                aVar.mHi = i;
                aVar.timestamp = rawQuery.getLong(1);
                arrayList.add(aVar);
            }
        }
        rawQuery.close();
        AppMethodBeat.o(136823);
        return arrayList;
    }

    public final c wa(int i) {
        c cVar = null;
        AppMethodBeat.i(136825);
        Cursor rawQuery = this.mBT.rawQuery("Select * from Feature where featureId = ".concat(String.valueOf(i)), null);
        try {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.d(rawQuery);
                rawQuery.close();
                AppMethodBeat.o(136825);
            }
            return cVar;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(136825);
        }
    }

    public final String getTableName() {
        return "Feature";
    }

    public final String getName() {
        return "FTS5FeatureStorage";
    }

    public final int getType() {
        return 17;
    }

    public final int getPriority() {
        return 17;
    }

    public final boolean Pq() {
        AppMethodBeat.i(136826);
        super.Pq();
        this.mHh.close();
        AppMethodBeat.o(136826);
        return true;
    }

    public final boolean bAh() {
        return true;
    }

    public final boolean bZ(List<c> list) {
        AppMethodBeat.i(136824);
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        this.mBT.execSQL("Delete from Feature");
        for (c cVar : list) {
            try {
                this.mHh.bindLong(1, (long) cVar.field_featureId);
                this.mHh.bindString(2, cVar.field_title);
                this.mHh.bindString(3, cVar.field_titlePY);
                this.mHh.bindString(4, cVar.field_titleShortPY);
                this.mHh.bindString(5, cVar.field_tag);
                this.mHh.bindLong(6, (long) cVar.field_actionType);
                this.mHh.bindString(7, cVar.field_url);
                this.mHh.bindString(8, cVar.field_helpUrl);
                this.mHh.bindString(9, cVar.field_updateUrl);
                this.mHh.bindString(10, cVar.field_androidUrl);
                this.mHh.bindString(11, cVar.field_iconPath);
                this.mHh.bindLong(12, cVar.field_timestamp);
                long executeInsert = this.mHh.executeInsert();
                ab.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", Long.valueOf(executeInsert), Long.valueOf(cVar.field_timestamp));
            } catch (Exception e) {
            }
        }
        if (!inTransaction) {
            this.mBT.commit();
        }
        AppMethodBeat.o(136824);
        return true;
    }
}
