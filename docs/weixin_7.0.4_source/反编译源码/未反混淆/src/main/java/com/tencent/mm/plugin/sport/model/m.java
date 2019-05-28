package com.tencent.mm.plugin.sport.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class m extends j<e> {
    public static final String[] rPO = new String[]{j.a(e.ccO, "SportStepItem")};
    private static final String[] rPP;

    static {
        AppMethodBeat.i(93707);
        r0 = new String[2];
        r0[0] = String.format("CREATE INDEX IF NOT EXISTS %s_date ON %s(date);", new Object[]{"SportStepItem", "SportStepItem"});
        r0[1] = String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{"SportStepItem", "SportStepItem"});
        rPP = r0;
        AppMethodBeat.o(93707);
    }

    public m() {
        super(g.RP().eJN, e.ccO, "SportStepItem", rPP);
        AppMethodBeat.i(93701);
        AppMethodBeat.o(93701);
    }

    public static List<e> W(long j, long j2) {
        AppMethodBeat.i(93702);
        ArrayList arrayList = new ArrayList();
        String format = String.format("SELECT * FROM %s WHERE timestamp >= ? AND timestamp <= ?;", new Object[]{"SportStepItem"});
        Cursor a = g.RP().eJN.a(format, new String[]{String.valueOf(j), String.valueOf(j2)}, 0);
        while (a.moveToNext()) {
            e eVar = new e();
            eVar.d(a);
            arrayList.add(eVar);
        }
        a.close();
        AppMethodBeat.o(93702);
        return arrayList;
    }

    public static e cwb() {
        e eVar = null;
        AppMethodBeat.i(93703);
        Cursor a = g.RP().eJN.a(String.format("SELECT * FROM %s ORDER BY timestamp desc LIMIT 1;", new Object[]{"SportStepItem"}), null, 0);
        try {
            if (a.moveToNext()) {
                eVar = new e();
                eVar.d(a);
            } else {
                a.close();
                AppMethodBeat.o(93703);
            }
            return eVar;
        } finally {
            a.close();
            AppMethodBeat.o(93703);
        }
    }

    public static void cwc() {
        AppMethodBeat.i(93704);
        g.RP().eJN.hY(null, String.format("DELETE FROM %s;", new Object[]{"SportStepItem"}));
        AppMethodBeat.o(93704);
    }

    public static void X(long j, long j2) {
        AppMethodBeat.i(93705);
        g.RP().eJN.hY(null, String.format("DELETE FROM %s WHERE timestamp >= %d AND timestamp <= endTime", new Object[]{"SportStepItem", Long.valueOf(j), Long.valueOf(j2)}));
        AppMethodBeat.o(93705);
    }

    public static void dC(List<e> list) {
        AppMethodBeat.i(93706);
        SQLiteDatabase dvx = g.RP().eJN.dvx();
        if (!dvx.inTransaction()) {
            dvx.beginTransaction();
        }
        SQLiteStatement compileStatement = dvx.compileStatement(String.format("INSERT INTO %s (date, step, timestamp) VALUES (?,?,?)", new Object[]{"SportStepItem"}));
        for (e eVar : list) {
            compileStatement.bindString(1, eVar.field_date);
            compileStatement.bindLong(2, (long) eVar.field_step);
            compileStatement.bindLong(3, eVar.field_timestamp);
            compileStatement.execute();
        }
        if (dvx.inTransaction()) {
            dvx.setTransactionSuccessful();
            dvx.endTransaction();
        }
        AppMethodBeat.o(93706);
    }
}
