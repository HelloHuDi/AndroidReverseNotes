package com.tencent.p177mm.plugin.priority.p1284b.p1285a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.priority.p1284b.C39486b;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.aul;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.priority.b.a.d */
public final class C21435d {
    public SQLiteStatement pgG;
    public SQLiteStatement pgH;
    public SQLiteStatement pgI;
    public C39486b pga;

    /* renamed from: com.tencent.mm.plugin.priority.b.a.d$1 */
    class C214361 implements Comparator<aul> {
        C214361() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return (int) (((aul) obj2).wyG - ((aul) obj).wyG);
        }
    }

    public C21435d(C39486b c39486b) {
        AppMethodBeat.m2504i(54923);
        this.pga = c39486b;
        if (this.pga.mo62441R(17, 0) != 1) {
            if (this.pga.mo62440MT("C2CMsgImgUsage")) {
                this.pga.mo62444UG("C2CMsgImgUsage");
            }
            this.pga.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (chat TEXT, talker TEXT, date INTEGER, dayreceivecount INTEGER, dayclickcount INTEGER, weekreceivecount INTEGER, weekclickcount INTEGER, monthreceivecount INTEGER, monthclickcount INTEGER, dayclickrate FLOAT, weekclickrate FLOAT, monthclickrate FLOAT, PRIMARY KEY(chat, talker, date));", new Object[]{"C2CMsgImgUsage"}));
            this.pga.mo62442S(17, 1);
        } else {
            int UF = this.pga.mo62443UF("C2CMsgImgUsage");
            C4990ab.m7417i("MicroMsg.Priority.C2CMsgImgUsageStorage", "Exist Table %s %d", "C2CMsgImgUsage", Integer.valueOf(UF));
        }
        this.pgG = this.pga.compileStatement(String.format("INSERT OR REPLACE INTO %s (chat, talker, date, dayreceivecount, dayclickcount, weekreceivecount, weekclickcount, monthreceivecount, monthclickcount, dayclickrate, weekclickrate, monthclickrate) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)", new Object[]{"C2CMsgImgUsage"}));
        this.pgH = this.pga.compileStatement(String.format("UPDATE %s SET dayreceivecount = ?, weekreceivecount = ?, monthreceivecount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[]{"C2CMsgImgUsage"}));
        this.pgI = this.pga.compileStatement(String.format("UPDATE %s SET dayclickcount = ?, weekclickcount = ?, monthclickcount = ?, dayclickrate = ?, weekclickrate = ?, monthclickrate = ? WHERE chat = ? AND talker = ? AND date = ?", new Object[]{"C2CMsgImgUsage"}));
        AppMethodBeat.m2505o(54923);
    }

    /* renamed from: i */
    private aul m32866i(String str, String str2, long j) {
        AppMethodBeat.m2504i(54924);
        String format = String.format("SELECT * FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[]{"C2CMsgImgUsage"});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{str, str2, String.valueOf(j)});
        try {
            if (rawQuery.moveToNext()) {
                aul n = C21435d.m32869n(rawQuery);
                return n;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(54924);
            return null;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54924);
        }
    }

    /* renamed from: n */
    private static aul m32869n(Cursor cursor) {
        AppMethodBeat.m2504i(54925);
        aul aul = new aul();
        aul.wyv = cursor.getString(0);
        aul.wyw = cursor.getString(1);
        aul.wyx = cursor.getLong(2);
        aul.wyy = cursor.getInt(3);
        aul.wyz = cursor.getInt(4);
        aul.wyA = cursor.getInt(5);
        aul.wyB = cursor.getInt(6);
        aul.wyC = cursor.getInt(7);
        aul.wyD = cursor.getInt(8);
        aul.wyE = cursor.getFloat(9);
        aul.wyF = cursor.getFloat(10);
        aul.wyG = cursor.getFloat(11);
        AppMethodBeat.m2505o(54925);
        return aul;
    }

    /* renamed from: fA */
    public final void mo36899fA(String str, String str2) {
        AppMethodBeat.m2504i(54926);
        long bZB = C21435d.bZB();
        if (!m32863a(str, str2, bZB, false)) {
            m32864b(str, str2, bZB, false);
        }
        AppMethodBeat.m2505o(54926);
    }

    /* renamed from: eX */
    private static float m32865eX(int i, int i2) {
        AppMethodBeat.m2504i(54927);
        if (i2 == 0 && i > 0) {
            AppMethodBeat.m2505o(54927);
            return 1.0f;
        } else if (i2 == 0 && i == 0) {
            AppMethodBeat.m2505o(54927);
            return 0.0f;
        } else {
            float min = Math.min(((float) i) / ((float) i2), 1.0f);
            AppMethodBeat.m2505o(54927);
            return min;
        }
    }

    public static long bZB() {
        AppMethodBeat.m2504i(54928);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.m2505o(54928);
        return timeInMillis;
    }

    /* renamed from: fB */
    public final void mo36900fB(String str, String str2) {
        AppMethodBeat.m2504i(54929);
        long bZB = C21435d.bZB();
        if (!m32863a(str, str2, bZB, true)) {
            m32864b(str, str2, bZB, true);
        }
        AppMethodBeat.m2505o(54929);
    }

    /* renamed from: a */
    private boolean m32863a(String str, String str2, long j, boolean z) {
        AppMethodBeat.m2504i(54930);
        aul i = m32866i(str, str2, j);
        if (i != null) {
            SQLiteStatement sQLiteStatement;
            if (z) {
                i.wyz++;
                i.wyB++;
                i.wyD++;
            } else {
                i.wyy++;
                i.wyA++;
                i.wyC++;
            }
            i.wyE = C21435d.m32865eX(i.wyz, i.wyy);
            i.wyF = C21435d.m32865eX(i.wyB, i.wyA);
            i.wyG = C21435d.m32865eX(i.wyD, i.wyC);
            if (z) {
                sQLiteStatement = this.pgI;
                sQLiteStatement.bindLong(1, (long) i.wyz);
                sQLiteStatement.bindLong(2, (long) i.wyB);
                sQLiteStatement.bindLong(3, (long) i.wyD);
            } else {
                sQLiteStatement = this.pgH;
                sQLiteStatement.bindLong(1, (long) i.wyy);
                sQLiteStatement.bindLong(2, (long) i.wyA);
                sQLiteStatement.bindLong(3, (long) i.wyC);
            }
            sQLiteStatement.bindDouble(4, (double) i.wyE);
            sQLiteStatement.bindDouble(5, (double) i.wyF);
            sQLiteStatement.bindDouble(6, (double) i.wyG);
            sQLiteStatement.bindString(7, i.wyv);
            sQLiteStatement.bindString(8, i.wyw);
            sQLiteStatement.bindLong(9, i.wyx);
            int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
            String str3 = "MicroMsg.Priority.C2CMsgImgUsageStorage";
            String str4 = "Update %s Img %s %s %d %d %d %d %d %d %d DayClickRate %.2f WeekClickRate %.2f MonthClickRate %.2f";
            Object[] objArr = new Object[13];
            objArr[0] = z ? "Open" : "Receive";
            objArr[1] = str;
            objArr[2] = str2;
            objArr[3] = Integer.valueOf(executeUpdateDelete);
            objArr[4] = Integer.valueOf(i.wyz);
            objArr[5] = Integer.valueOf(i.wyB);
            objArr[6] = Integer.valueOf(i.wyD);
            objArr[7] = Integer.valueOf(i.wyy);
            objArr[8] = Integer.valueOf(i.wyA);
            objArr[9] = Integer.valueOf(i.wyC);
            objArr[10] = Float.valueOf(i.wyE);
            objArr[11] = Float.valueOf(i.wyF);
            objArr[12] = Float.valueOf(i.wyG);
            C4990ab.m7417i(str3, str4, objArr);
            if (executeUpdateDelete > 0) {
                AppMethodBeat.m2505o(54930);
                return true;
            }
            AppMethodBeat.m2505o(54930);
            return false;
        }
        AppMethodBeat.m2505o(54930);
        return false;
    }

    /* renamed from: b */
    private void m32864b(String str, String str2, long j, boolean z) {
        AppMethodBeat.m2504i(54931);
        aul aul = new aul();
        aul.wyv = str;
        aul.wyw = str2;
        aul.wyx = j;
        long j2 = j - 2505600000L;
        String format = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[]{"C2CMsgImgUsage", Long.valueOf(j2)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{str, str2});
        if (rawQuery.moveToNext()) {
            aul.wyC = rawQuery.getInt(0);
            aul.wyD = rawQuery.getInt(1);
        }
        rawQuery.close();
        j2 = j - 518400000;
        format = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[]{"C2CMsgImgUsage", Long.valueOf(j2)});
        rawQuery = this.pga.rawQuery(format, new String[]{str, str2});
        if (rawQuery.moveToNext()) {
            aul.wyA = rawQuery.getInt(0);
            aul.wyB = rawQuery.getInt(1);
        }
        rawQuery.close();
        if (z) {
            aul.wyz++;
            aul.wyD++;
            aul.wyB++;
        } else {
            aul.wyy++;
            aul.wyC++;
            aul.wyA++;
        }
        aul.wyE = C21435d.m32865eX(aul.wyz, aul.wyy);
        aul.wyF = C21435d.m32865eX(aul.wyB, aul.wyA);
        aul.wyG = C21435d.m32865eX(aul.wyD, aul.wyC);
        this.pgG.bindString(1, aul.wyv);
        this.pgG.bindString(2, aul.wyw);
        this.pgG.bindLong(3, aul.wyx);
        this.pgG.bindLong(4, (long) aul.wyy);
        this.pgG.bindLong(5, (long) aul.wyz);
        this.pgG.bindLong(6, (long) aul.wyA);
        this.pgG.bindLong(7, (long) aul.wyB);
        this.pgG.bindLong(8, (long) aul.wyC);
        this.pgG.bindLong(9, (long) aul.wyD);
        this.pgG.bindDouble(10, (double) aul.wyE);
        this.pgG.bindDouble(11, (double) aul.wyF);
        this.pgG.bindDouble(12, (double) aul.wyG);
        j2 = this.pgG.executeInsert();
        C4990ab.m7417i("MicroMsg.Priority.C2CMsgImgUsageStorage", "insert %d usage %s %s %s %d %d %d %d %.2f %.2f", Long.valueOf(j2), str, str2, C14835h.formatTime("yyyy-MM-dd", j / 1000), Integer.valueOf(aul.wyA), Integer.valueOf(aul.wyB), Integer.valueOf(aul.wyC), Integer.valueOf(aul.wyD), Float.valueOf(aul.wyF), Float.valueOf(aul.wyG));
        AppMethodBeat.m2505o(54931);
    }

    /* renamed from: j */
    private float m32867j(String str, String str2, long j) {
        AppMethodBeat.m2504i(54932);
        long j2 = j - 518400000;
        String format = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[]{"C2CMsgImgUsage", Long.valueOf(j2)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{str, str2});
        try {
            if (rawQuery.moveToNext()) {
                float eX = C21435d.m32865eX(rawQuery.getInt(1), rawQuery.getInt(0));
                return eX;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(54932);
            return 0.0f;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54932);
        }
    }

    /* renamed from: k */
    private float m32868k(String str, String str2, long j) {
        AppMethodBeat.m2504i(54933);
        long j2 = j - 2505600000L;
        String format = String.format("SELECT sum(dayreceivecount), sum(dayclickcount) FROM %s WHERE chat = ? AND talker = ? AND date >= %d", new Object[]{"C2CMsgImgUsage", Long.valueOf(j2)});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{str, str2});
        try {
            if (rawQuery.moveToNext()) {
                float eX = C21435d.m32865eX(rawQuery.getInt(1), rawQuery.getInt(0));
                return eX;
            }
            rawQuery.close();
            AppMethodBeat.m2505o(54933);
            return 0.0f;
        } finally {
            rawQuery.close();
            AppMethodBeat.m2505o(54933);
        }
    }

    /* renamed from: fC */
    public final double[] mo36901fC(String str, String str2) {
        AppMethodBeat.m2504i(54934);
        long bZB = C21435d.bZB();
        String format = String.format("SELECT dayclickrate, weekclickrate, monthclickrate FROM %s WHERE chat = ? AND talker = ? AND date = ?", new Object[]{"C2CMsgImgUsage"});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{str, str2, String.valueOf(bZB)});
        double[] dArr = new double[3];
        if (rawQuery.moveToNext()) {
            dArr[0] = rawQuery.getDouble(0);
            dArr[1] = rawQuery.getDouble(1);
            dArr[2] = rawQuery.getDouble(2);
            rawQuery.close();
        } else {
            rawQuery.close();
            dArr[0] = 0.0d;
            dArr[1] = (double) m32867j(str, str2, bZB);
            dArr[2] = (double) m32868k(str, str2, bZB);
        }
        AppMethodBeat.m2505o(54934);
        return dArr;
    }

    /* renamed from: UH */
    public final List<aul> mo36898UH(String str) {
        AppMethodBeat.m2504i(54935);
        String format = String.format("SELECT *, max(monthreceivecount) FROM %s WHERE chat = ? AND talker <> '%s' GROUP BY chat, talker;", new Object[]{"C2CMsgImgUsage", "@all"});
        Cursor rawQuery = this.pga.rawQuery(format, new String[]{str});
        ArrayList arrayList = new ArrayList(10);
        while (rawQuery.moveToNext()) {
            arrayList.add(C21435d.m32869n(rawQuery));
        }
        rawQuery.close();
        Collections.sort(arrayList, new C214361());
        AppMethodBeat.m2505o(54935);
        return arrayList;
    }
}
