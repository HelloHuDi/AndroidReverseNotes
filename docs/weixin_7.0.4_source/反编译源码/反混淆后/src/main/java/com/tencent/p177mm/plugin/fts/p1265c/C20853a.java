package com.tencent.p177mm.plugin.fts.p1265c;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C45968a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g.C20841c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.c.a */
public final class C20853a extends C45968a {
    public SQLiteStatement mHa;
    public SQLiteStatement mHb;
    private SQLiteStatement mHc;
    public SQLiteStatement mHd;
    public SQLiteStatement mHe;
    private SQLiteStatement mHf;
    public SQLiteStatement mHg;

    /* renamed from: Po */
    public final void mo23702Po() {
        AppMethodBeat.m2504i(136810);
        if (mo23703Pp()) {
            this.mBT.mo54778K(-102, 4);
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
        AppMethodBeat.m2505o(136810);
    }

    /* renamed from: Pq */
    public final boolean mo36132Pq() {
        AppMethodBeat.m2504i(136811);
        super.mo36132Pq();
        this.mHa.close();
        this.mHb.close();
        this.mHc.close();
        this.mHd.close();
        this.mHe.close();
        this.mHf.close();
        this.mHg.close();
        AppMethodBeat.m2505o(136811);
        return true;
    }

    /* renamed from: k */
    public final void mo36136k(String str, List<Long> list) {
        AppMethodBeat.m2504i(136812);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(136812);
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
        AppMethodBeat.m2505o(136812);
    }

    /* renamed from: No */
    public final void mo36129No(String str) {
        AppMethodBeat.m2504i(136813);
        this.mHf.bindString(1, str);
        this.mHf.execute();
        AppMethodBeat.m2505o(136813);
    }

    /* renamed from: Np */
    public final Cursor mo36130Np(String str) {
        AppMethodBeat.m2504i(136814);
        Cursor rawQuery = this.mBT.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[]{str});
        AppMethodBeat.m2505o(136814);
        return rawQuery;
    }

    /* renamed from: k */
    public final void mo36137k(String str, String[] strArr) {
        AppMethodBeat.m2504i(136815);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(136815);
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
        AppMethodBeat.m2505o(136815);
    }

    /* renamed from: Nq */
    public final void mo36131Nq(String str) {
        AppMethodBeat.m2504i(136816);
        this.mHc.bindString(1, str);
        this.mHc.execute();
        AppMethodBeat.m2505o(136816);
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
        AppMethodBeat.m2504i(136817);
        String format = String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{bAf()});
        AppMethodBeat.m2505o(136817);
        return format;
    }

    /* renamed from: Pp */
    public final boolean mo23703Pp() {
        AppMethodBeat.m2504i(136818);
        if (mo73849ei(ZipJNI.UNZ_PARAMERROR, 4)) {
            AppMethodBeat.m2505o(136818);
            return false;
        }
        AppMethodBeat.m2505o(136818);
        return true;
    }

    /* renamed from: a */
    public final Cursor mo36133a(C20840g c20840g, String str, int[] iArr, int[] iArr2) {
        AppMethodBeat.m2504i(136819);
        String bAl = c20840g.bAl();
        String format = C5046bo.isNullOrNil(str) ? "" : String.format(" AND aux_index = '%s'", new Object[]{str});
        String str2 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + C3161d.m5418t(iArr);
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + C3161d.m5418t(iArr2);
        Cursor rawQuery = this.mBT.rawQuery(String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + format + str2 + str3 + " AND status >= 0 ORDER BY subtype;", new Object[]{bAf(), bAg(), bAf(), bAg(), bAg(), bAl}), null);
        AppMethodBeat.m2505o(136819);
        return rawQuery;
    }

    /* renamed from: b */
    public final boolean mo36134b(C20840g c20840g) {
        int i = 0;
        AppMethodBeat.m2504i(136820);
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
            if (i2 < c20840g.mEc.size()) {
                stringBuffer.append("(");
                stringBuffer.append(((C20841c) c20840g.mEc.get(i2)).bAn());
                stringBuffer.append(")");
                if (i2 != c20840g.mEc.size() - 1) {
                    stringBuffer.append(" OR ");
                }
                i = i2 + 1;
            } else {
                objArr[5] = stringBuffer.toString();
                Cursor rawQuery = this.mBT.rawQuery(String.format(str, objArr), null);
                boolean moveToNext = rawQuery.moveToNext();
                rawQuery.close();
                AppMethodBeat.m2505o(136820);
                return moveToNext;
            }
        }
    }

    public final boolean bAh() {
        return true;
    }
}
