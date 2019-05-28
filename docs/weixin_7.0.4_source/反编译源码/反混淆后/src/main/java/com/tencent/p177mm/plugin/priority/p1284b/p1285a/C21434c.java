package com.tencent.p177mm.plugin.priority.p1284b.p1285a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.priority.p1284b.C39486b;
import com.tencent.p177mm.protocal.protobuf.C23390gi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wcdb.database.SQLiteStatement;

/* renamed from: com.tencent.mm.plugin.priority.b.a.c */
public final class C21434c {
    public SQLiteStatement pgA;
    public SQLiteStatement pgB;
    public SQLiteStatement pgC;
    public SQLiteStatement pgD;
    public SQLiteStatement pgE;
    public SQLiteStatement pgF;
    private C39486b pga;

    public C21434c(C39486b c39486b) {
        AppMethodBeat.m2504i(54913);
        this.pga = c39486b;
        if (this.pga.mo62441R(1, 0) != 1) {
            if (this.pga.mo62440MT("C2CMsgAutoDownloadRes")) {
                this.pga.mo62444UG("C2CMsgAutoDownloadRes");
            }
            this.pga.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[]{"C2CMsgAutoDownloadRes"}));
            this.pga.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[]{"C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes"}));
            this.pga.mo62442S(1, 1);
        } else {
            int UF = this.pga.mo62443UF("C2CMsgAutoDownloadRes");
            C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "Exist Table %s Count %d", "C2CMsgAutoDownloadRes", Integer.valueOf(UF));
        }
        this.pgA = this.pga.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgB = this.pga.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgC = this.pga.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgD = this.pga.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgE = this.pga.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgF = this.pga.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[]{"C2CMsgAutoDownloadRes"}));
        AppMethodBeat.m2505o(54913);
    }

    /* renamed from: z */
    public final void mo36897z(long j, int i) {
        AppMethodBeat.m2504i(54914);
        this.pgC.bindLong(1, (long) i);
        this.pgC.bindLong(2, j);
        C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatus %d res %d %d", Integer.valueOf(this.pgC.executeUpdateDelete()), Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.m2505o(54914);
    }

    /* renamed from: m */
    public final void mo36896m(long j, int i, int i2) {
        AppMethodBeat.m2504i(54915);
        this.pgD.bindLong(1, (long) i);
        this.pgD.bindLong(2, (long) i2);
        this.pgD.bindLong(3, j);
        C4990ab.m7417i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatusAndReason %d res %d %d %d", Integer.valueOf(this.pgD.executeUpdateDelete()), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(54915);
    }

    /* renamed from: jv */
    public final boolean mo36894jv(long j) {
        AppMethodBeat.m2504i(54916);
        Cursor rawQuery = this.pga.rawQuery(String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[]{"C2CMsgAutoDownloadRes", Long.valueOf(j)}), null);
        try {
            boolean moveToNext = rawQuery.moveToNext();
            return moveToNext;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54916);
        }
    }

    /* renamed from: jw */
    public final C23390gi mo36895jw(long j) {
        C23390gi c23390gi = null;
        AppMethodBeat.m2504i(54917);
        Cursor rawQuery = this.pga.rawQuery(String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[]{"C2CMsgAutoDownloadRes", Long.valueOf(j)}), null);
        try {
            if (rawQuery.moveToNext()) {
                c23390gi = C21434c.m32855m(rawQuery);
            } else {
                rawQuery.close();
                AppMethodBeat.m2505o(54917);
            }
            return c23390gi;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54917);
        }
    }

    /* renamed from: aQ */
    public final C23390gi mo36890aQ(float f) {
        AppMethodBeat.m2504i(54918);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(f), String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                C23390gi m = C21434c.m32855m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(54918);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54918);
        }
    }

    /* renamed from: aR */
    public final C23390gi mo36891aR(float f) {
        AppMethodBeat.m2504i(54919);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(f), String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                C23390gi m = C21434c.m32855m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(54919);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54919);
        }
    }

    public final C23390gi bZA() {
        AppMethodBeat.m2504i(54920);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                C23390gi m = C21434c.m32855m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(54920);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54920);
        }
    }

    /* renamed from: h */
    public final C23390gi mo36893h(String str, float f) {
        AppMethodBeat.m2504i(54921);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(str), String.valueOf(f), String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                C23390gi m = C21434c.m32855m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(54921);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54921);
        }
    }

    /* renamed from: m */
    private static C23390gi m32855m(Cursor cursor) {
        AppMethodBeat.m2504i(54922);
        C23390gi c23390gi = new C23390gi();
        c23390gi.vIs = cursor.getLong(0);
        c23390gi.ptA = cursor.getString(1);
        c23390gi.vIt = cursor.getString(2);
        c23390gi.vIu = cursor.getInt(3);
        c23390gi.vIv = cursor.getLong(4);
        c23390gi.vIw = cursor.getInt(5);
        c23390gi.jBT = cursor.getInt(6);
        c23390gi.vIx = cursor.getLong(7);
        c23390gi.vIy = cursor.getLong(8);
        c23390gi.vIz = cursor.getInt(9);
        c23390gi.vIA = cursor.getLong(10);
        c23390gi.vIB = (double) cursor.getFloat(11);
        c23390gi.vIC = cursor.getInt(12);
        AppMethodBeat.m2505o(54922);
        return c23390gi;
    }
}
