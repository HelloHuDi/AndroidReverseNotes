package com.tencent.p177mm.plugin.fts.p1265c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C43120c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.tencent.mm.plugin.fts.c.b */
public final class C39136b extends C45968a {
    private SQLiteStatement mHh;

    /* renamed from: com.tencent.mm.plugin.fts.c.b$a */
    public static class C34225a {
        public int mHi;
        public long timestamp;
    }

    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(136821);
        if (mo23703Pp()) {
            this.mBT.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{"Feature"}));
            mo73835K(-101, 2);
        }
        if (!this.mBT.mo54780MT("Feature")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS Feature ( ");
            stringBuilder.append(C43120c.ccO.sql);
            stringBuilder.append(");");
            this.mBT.execSQL(stringBuilder.toString());
        }
        this.mHh = this.mBT.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{"Feature"}));
        AppMethodBeat.m2505o(136821);
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(136822);
        if (mo73849ei(XWalkUpdater.ERROR_SET_VERNUM, 2)) {
            AppMethodBeat.m2505o(136822);
            return false;
        }
        AppMethodBeat.m2505o(136822);
        return true;
    }

    public final List<C34225a> bAI() {
        AppMethodBeat.m2504i(136823);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT entity_id, timestamp FROM %s", new Object[]{bAf()}), null);
        while (rawQuery.moveToNext()) {
            int i = rawQuery.getInt(0);
            if (hashSet.add(Integer.valueOf(i))) {
                C34225a c34225a = new C34225a();
                c34225a.mHi = i;
                c34225a.timestamp = rawQuery.getLong(1);
                arrayList.add(c34225a);
            }
        }
        rawQuery.close();
        AppMethodBeat.m2505o(136823);
        return arrayList;
    }

    /* renamed from: wa */
    public final C43120c mo62039wa(int i) {
        C43120c c43120c = null;
        AppMethodBeat.m2504i(136825);
        Cursor rawQuery = this.mBT.rawQuery("Select * from Feature where featureId = ".concat(String.valueOf(i)), null);
        try {
            if (rawQuery.moveToFirst()) {
                c43120c = new C43120c();
                c43120c.mo8995d(rawQuery);
                rawQuery.close();
                AppMethodBeat.m2505o(136825);
            }
            return c43120c;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(136825);
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

    /* renamed from: Pq */
    public final boolean mo36132Pq() {
        AppMethodBeat.m2504i(136826);
        super.mo36132Pq();
        this.mHh.close();
        AppMethodBeat.m2505o(136826);
        return true;
    }

    public final boolean bAh() {
        return true;
    }

    /* renamed from: bZ */
    public final boolean mo62038bZ(List<C43120c> list) {
        AppMethodBeat.m2504i(136824);
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        this.mBT.execSQL("Delete from Feature");
        for (C43120c c43120c : list) {
            try {
                this.mHh.bindLong(1, (long) c43120c.field_featureId);
                this.mHh.bindString(2, c43120c.field_title);
                this.mHh.bindString(3, c43120c.field_titlePY);
                this.mHh.bindString(4, c43120c.field_titleShortPY);
                this.mHh.bindString(5, c43120c.field_tag);
                this.mHh.bindLong(6, (long) c43120c.field_actionType);
                this.mHh.bindString(7, c43120c.field_url);
                this.mHh.bindString(8, c43120c.field_helpUrl);
                this.mHh.bindString(9, c43120c.field_updateUrl);
                this.mHh.bindString(10, c43120c.field_androidUrl);
                this.mHh.bindString(11, c43120c.field_iconPath);
                this.mHh.bindLong(12, c43120c.field_timestamp);
                long executeInsert = this.mHh.executeInsert();
                C4990ab.m7411d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", Long.valueOf(executeInsert), Long.valueOf(c43120c.field_timestamp));
            } catch (Exception e) {
            }
        }
        if (!inTransaction) {
            this.mBT.commit();
        }
        AppMethodBeat.m2505o(136824);
        return true;
    }
}
