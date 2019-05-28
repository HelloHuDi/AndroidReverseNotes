package com.tencent.p177mm.plugin.sport.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.sport.p1302a.C29259e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sport.model.m */
public final class C46268m extends C7563j<C29259e> {
    public static final String[] rPO = new String[]{C7563j.m13217a(C29259e.ccO, "SportStepItem")};
    private static final String[] rPP;

    static {
        AppMethodBeat.m2504i(93707);
        r0 = new String[2];
        r0[0] = String.format("CREATE INDEX IF NOT EXISTS %s_date ON %s(date);", new Object[]{"SportStepItem", "SportStepItem"});
        r0[1] = String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{"SportStepItem", "SportStepItem"});
        rPP = r0;
        AppMethodBeat.m2505o(93707);
    }

    public C46268m() {
        super(C1720g.m3536RP().eJN, C29259e.ccO, "SportStepItem", rPP);
        AppMethodBeat.m2504i(93701);
        AppMethodBeat.m2505o(93701);
    }

    /* renamed from: W */
    public static List<C29259e> m86665W(long j, long j2) {
        AppMethodBeat.m2504i(93702);
        ArrayList arrayList = new ArrayList();
        String format = String.format("SELECT * FROM %s WHERE timestamp >= ? AND timestamp <= ?;", new Object[]{"SportStepItem"});
        Cursor a = C1720g.m3536RP().eJN.mo10104a(format, new String[]{String.valueOf(j), String.valueOf(j2)}, 0);
        while (a.moveToNext()) {
            C29259e c29259e = new C29259e();
            c29259e.mo8995d(a);
            arrayList.add(c29259e);
        }
        a.close();
        AppMethodBeat.m2505o(93702);
        return arrayList;
    }

    public static C29259e cwb() {
        C29259e c29259e = null;
        AppMethodBeat.m2504i(93703);
        Cursor a = C1720g.m3536RP().eJN.mo10104a(String.format("SELECT * FROM %s ORDER BY timestamp desc LIMIT 1;", new Object[]{"SportStepItem"}), null, 0);
        try {
            if (a.moveToNext()) {
                c29259e = new C29259e();
                c29259e.mo8995d(a);
            } else {
                a.close();
                AppMethodBeat.m2505o(93703);
            }
            return c29259e;
        } finally {
            a.close();
            AppMethodBeat.m2505o(93703);
        }
    }

    public static void cwc() {
        AppMethodBeat.m2504i(93704);
        C1720g.m3536RP().eJN.mo10108hY(null, String.format("DELETE FROM %s;", new Object[]{"SportStepItem"}));
        AppMethodBeat.m2505o(93704);
    }

    /* renamed from: X */
    public static void m86666X(long j, long j2) {
        AppMethodBeat.m2504i(93705);
        C1720g.m3536RP().eJN.mo10108hY(null, String.format("DELETE FROM %s WHERE timestamp >= %d AND timestamp <= endTime", new Object[]{"SportStepItem", Long.valueOf(j), Long.valueOf(j2)}));
        AppMethodBeat.m2505o(93705);
    }

    /* renamed from: dC */
    public static void m86667dC(List<C29259e> list) {
        AppMethodBeat.m2504i(93706);
        SQLiteDatabase dvx = C1720g.m3536RP().eJN.dvx();
        if (!dvx.inTransaction()) {
            dvx.beginTransaction();
        }
        SQLiteStatement compileStatement = dvx.compileStatement(String.format("INSERT INTO %s (date, step, timestamp) VALUES (?,?,?)", new Object[]{"SportStepItem"}));
        for (C29259e c29259e : list) {
            compileStatement.bindString(1, c29259e.field_date);
            compileStatement.bindLong(2, (long) c29259e.field_step);
            compileStatement.bindLong(3, c29259e.field_timestamp);
            compileStatement.execute();
        }
        if (dvx.inTransaction()) {
            dvx.setTransactionSuccessful();
            dvx.endTransaction();
        }
        AppMethodBeat.m2505o(93706);
    }
}
