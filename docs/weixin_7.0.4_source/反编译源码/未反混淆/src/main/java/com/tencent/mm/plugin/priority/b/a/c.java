package com.tencent.mm.plugin.priority.b.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.priority.b.b;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteStatement;

public final class c {
    public SQLiteStatement pgA;
    public SQLiteStatement pgB;
    public SQLiteStatement pgC;
    public SQLiteStatement pgD;
    public SQLiteStatement pgE;
    public SQLiteStatement pgF;
    private b pga;

    public c(b bVar) {
        AppMethodBeat.i(54913);
        this.pga = bVar;
        if (this.pga.R(1, 0) != 1) {
            if (this.pga.MT("C2CMsgAutoDownloadRes")) {
                this.pga.UG("C2CMsgAutoDownloadRes");
            }
            this.pga.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (msgid INTEGER PRIMARY KEY, fromuser TEXT, realuser TEXT, restype INTEGER, createtime INTEGER, reason INTEGER, status INTEGER, downloadtime INTEGER, msgsvrid LONG, imgsize INTEGER, opentime INTEGER, priority FLOAT, prioritytype INTEGER);", new Object[]{"C2CMsgAutoDownloadRes"}));
            this.pga.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s ON %s(priority, createtime);", new Object[]{"C2CMsgAutoDownloadRes_Priority_CreateTime", "C2CMsgAutoDownloadRes"}));
            this.pga.S(1, 1);
        } else {
            int UF = this.pga.UF("C2CMsgAutoDownloadRes");
            ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "Exist Table %s Count %d", "C2CMsgAutoDownloadRes", Integer.valueOf(UF));
        }
        this.pgA = this.pga.compileStatement(String.format("INSERT OR IGNORE INTO %s (msgid, fromuser, realuser, restype, createtime, reason, status, downloadtime, msgsvrid, imgsize, opentime, priority, prioritytype) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgB = this.pga.compileStatement(String.format("DELETE FROM %s WHERE msgid = ?", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgC = this.pga.compileStatement(String.format("UPDATE %s SET status = ? WHERE msgid = ?", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgD = this.pga.compileStatement(String.format("UPDATE %s SET reason = reason | ?, status = ? WHERE msgid = ?", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgE = this.pga.compileStatement(String.format("UPDATE %s SET downloadtime = ?, status = ?, imgsize = ? WHERE msgid = ? AND downloadtime = 0", new Object[]{"C2CMsgAutoDownloadRes"}));
        this.pgF = this.pga.compileStatement(String.format("UPDATE %s SET opentime = ? WHERE msgid = ? AND opentime = 0", new Object[]{"C2CMsgAutoDownloadRes"}));
        AppMethodBeat.o(54913);
    }

    public final void z(long j, int i) {
        AppMethodBeat.i(54914);
        this.pgC.bindLong(1, (long) i);
        this.pgC.bindLong(2, j);
        ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatus %d res %d %d", Integer.valueOf(this.pgC.executeUpdateDelete()), Long.valueOf(j), Integer.valueOf(i));
        AppMethodBeat.o(54914);
    }

    public final void m(long j, int i, int i2) {
        AppMethodBeat.i(54915);
        this.pgD.bindLong(1, (long) i);
        this.pgD.bindLong(2, (long) i2);
        this.pgD.bindLong(3, j);
        ab.i("MicroMsg.Priority.C2CMsgAutoDownloadResStorage", "updateStatusAndReason %d res %d %d %d", Integer.valueOf(this.pgD.executeUpdateDelete()), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(54915);
    }

    public final boolean jv(long j) {
        AppMethodBeat.i(54916);
        Cursor rawQuery = this.pga.rawQuery(String.format("SELECT 1 FROM %s WHERE msgid = %d", new Object[]{"C2CMsgAutoDownloadRes", Long.valueOf(j)}), null);
        try {
            boolean moveToNext = rawQuery.moveToNext();
            return moveToNext;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54916);
        }
    }

    public final gi jw(long j) {
        gi giVar = null;
        AppMethodBeat.i(54917);
        Cursor rawQuery = this.pga.rawQuery(String.format("SELECT * FROM %s WHERE msgid = %d;", new Object[]{"C2CMsgAutoDownloadRes", Long.valueOf(j)}), null);
        try {
            if (rawQuery.moveToNext()) {
                giVar = m(rawQuery);
            } else {
                rawQuery.close();
                AppMethodBeat.o(54917);
            }
            return giVar;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54917);
        }
    }

    public final gi aQ(float f) {
        AppMethodBeat.i(54918);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY priority DESC, createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(f), String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                gi m = m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.o(54918);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54918);
        }
    }

    public final gi aR(float f) {
        AppMethodBeat.i(54919);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(f), String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                gi m = m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.o(54919);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54919);
        }
    }

    public final gi bZA() {
        AppMethodBeat.i(54920);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND (reason & %d) > 0 AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1), Integer.valueOf(128)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                gi m = m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.o(54920);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54920);
        }
    }

    public final gi h(String str, float f) {
        AppMethodBeat.i(54921);
        long currentTimeMillis = System.currentTimeMillis() - 432000000;
        String format = String.format("SELECT * FROM %s WHERE status = %d AND fromuser = ? AND priority >= ? AND createtime > ? ORDER BY createtime DESC LIMIT 1;", new Object[]{"C2CMsgAutoDownloadRes", Integer.valueOf(1)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{String.valueOf(str), String.valueOf(f), String.valueOf(currentTimeMillis)});
        try {
            if (rawQuery.moveToNext()) {
                gi m = m(rawQuery);
                return m;
            }
            rawQuery.close();
            AppMethodBeat.o(54921);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.o(54921);
        }
    }

    private static gi m(Cursor cursor) {
        AppMethodBeat.i(54922);
        gi giVar = new gi();
        giVar.vIs = cursor.getLong(0);
        giVar.ptA = cursor.getString(1);
        giVar.vIt = cursor.getString(2);
        giVar.vIu = cursor.getInt(3);
        giVar.vIv = cursor.getLong(4);
        giVar.vIw = cursor.getInt(5);
        giVar.jBT = cursor.getInt(6);
        giVar.vIx = cursor.getLong(7);
        giVar.vIy = cursor.getLong(8);
        giVar.vIz = cursor.getInt(9);
        giVar.vIA = cursor.getLong(10);
        giVar.vIB = (double) cursor.getFloat(11);
        giVar.vIC = cursor.getInt(12);
        AppMethodBeat.o(54922);
        return giVar;
    }
}
