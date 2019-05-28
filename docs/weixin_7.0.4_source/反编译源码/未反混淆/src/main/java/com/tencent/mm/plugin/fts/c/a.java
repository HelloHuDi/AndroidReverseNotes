package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.g.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public SQLiteStatement mHa;
    public SQLiteStatement mHb;
    private SQLiteStatement mHc;
    public SQLiteStatement mHd;
    public SQLiteStatement mHe;
    private SQLiteStatement mHf;
    public SQLiteStatement mHg;

    public final void Po() {
        AppMethodBeat.i(136810);
        if (Pp()) {
            this.mBT.K(-102, 4);
        }
        this.mBT.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
        this.mBT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
        this.mBT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
        this.mBT.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
        this.mBT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
        this.mBT.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
        this.mHa = this.mBT.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
        this.mHb = this.mBT.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
        this.mHc = this.mBT.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
        this.mHd = this.mBT.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
        this.mHe = this.mBT.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
        this.mHf = this.mBT.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
        this.mHg = this.mBT.compileStatement("SELECT changes();");
        AppMethodBeat.o(136810);
    }

    public final boolean Pq() {
        AppMethodBeat.i(136811);
        super.Pq();
        this.mHa.close();
        this.mHb.close();
        this.mHc.close();
        this.mHd.close();
        this.mHe.close();
        this.mHf.close();
        this.mHg.close();
        AppMethodBeat.o(136811);
        return true;
    }

    public final void k(String str, List<Long> list) {
        AppMethodBeat.i(136812);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(136812);
            return;
        }
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        this.mHd.bindString(1, str);
        for (Long longValue : list) {
            this.mHd.bindLong(2, longValue.longValue());
            this.mHd.execute();
        }
        if (!inTransaction) {
            this.mBT.commit();
        }
        AppMethodBeat.o(136812);
    }

    public final void No(String str) {
        AppMethodBeat.i(136813);
        this.mHf.bindString(1, str);
        this.mHf.execute();
        AppMethodBeat.o(136813);
    }

    public final Cursor Np(String str) {
        AppMethodBeat.i(136814);
        Cursor rawQuery = this.mBT.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[]{str});
        AppMethodBeat.o(136814);
        return rawQuery;
    }

    public final void k(String str, String[] strArr) {
        AppMethodBeat.i(136815);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(136815);
            return;
        }
        boolean inTransaction = this.mBT.inTransaction();
        if (!inTransaction) {
            this.mBT.beginTransaction();
        }
        this.mHa.bindString(1, str);
        for (String bindString : strArr) {
            this.mHa.bindString(2, bindString);
            this.mHa.execute();
        }
        if (!inTransaction) {
            this.mBT.commit();
        }
        AppMethodBeat.o(136815);
    }

    public final void Nq(String str) {
        AppMethodBeat.i(136816);
        this.mHc.bindString(1, str);
        this.mHc.execute();
        AppMethodBeat.o(136816);
    }

    public final String getTableName() {
        return AppEventsConstants.EVENT_NAME_CONTACT;
    }

    public final String getName() {
        return "FTS5ContactStorage";
    }

    public final int getType() {
        return 3;
    }

    public final int getPriority() {
        return 3;
    }

    public final String bvr() {
        AppMethodBeat.i(136817);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{bAf()});
        AppMethodBeat.o(136817);
        return format;
    }

    public final boolean Pp() {
        AppMethodBeat.i(136818);
        if (ei(ZipJNI.UNZ_PARAMERROR, 4)) {
            AppMethodBeat.o(136818);
            return false;
        }
        AppMethodBeat.o(136818);
        return true;
    }

    public final Cursor a(g gVar, String str, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(136819);
        String bAl = gVar.bAl();
        String format = bo.isNullOrNil(str) ? "" : String.format(" AND aux_index = '%s'", new Object[]{str});
        String str2 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.t(iArr);
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.t(iArr2);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + format + str2 + str3 + " AND status >= 0 ORDER BY subtype;", new Object[]{bAf(), bAg(), bAf(), bAg(), bAg(), bAl}), null);
        AppMethodBeat.o(136819);
        return rawQuery;
    }

    public final boolean b(g gVar) {
        int i = 0;
        AppMethodBeat.i(136820);
        String str = "SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;";
        Object[] objArr = new Object[6];
        objArr[0] = bAf();
        objArr[1] = bAg();
        objArr[2] = bAf();
        objArr[3] = bAg();
        objArr[4] = bAg();
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i2 = i;
            if (i2 < gVar.mEc.size()) {
                stringBuffer.append("(");
                stringBuffer.append(((c) gVar.mEc.get(i2)).bAn());
                stringBuffer.append(")");
                if (i2 != gVar.mEc.size() - 1) {
                    stringBuffer.append(" OR ");
                }
                i = i2 + 1;
            } else {
                objArr[5] = stringBuffer.toString();
                Cursor rawQuery = this.mBT.rawQuery(String.format(str, objArr), null);
                boolean moveToNext = rawQuery.moveToNext();
                rawQuery.close();
                AppMethodBeat.o(136820);
                return moveToNext;
            }
        }
    }

    public final boolean bAh() {
        return true;
    }
}
