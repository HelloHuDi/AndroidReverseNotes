package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends j<e> {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)"};
    public static final String[] fnj = new String[]{j.a(e.ccO, "adsnsinfo")};
    private static final String rfa = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[]{"snsId", "createTime"});
    private e bSd;

    static {
        AppMethodBeat.i(37834);
        AppMethodBeat.o(37834);
    }

    public f(e eVar) {
        super(eVar, e.ccO, "adsnsinfo", diI);
        this.bSd = eVar;
    }

    public final e ku(long j) {
        AppMethodBeat.i(37825);
        e eVar = new e();
        Cursor a = this.bSd.a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(j)), null, 2);
        if (a.moveToFirst()) {
            eVar.d(a);
            a.close();
            AppMethodBeat.o(37825);
            return eVar;
        }
        a.close();
        AppMethodBeat.o(37825);
        return null;
    }

    public final e DG(int i) {
        AppMethodBeat.i(37826);
        e eVar = new e();
        Cursor a = this.bSd.a("select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=".concat(String.valueOf(i)), null, 2);
        if (a.moveToFirst()) {
            eVar.d(a);
            a.close();
            AppMethodBeat.o(37826);
            return eVar;
        }
        a.close();
        AppMethodBeat.o(37826);
        return null;
    }

    public final boolean a(long j, e eVar) {
        AppMethodBeat.i(37827);
        if (kv(j)) {
            boolean b = b(j, eVar);
            AppMethodBeat.o(37827);
            return b;
        }
        ab.d("MicroMsg.AdSnsInfoStorage", "added PcId ".concat(String.valueOf(j)));
        if (a(eVar) != -1) {
            AppMethodBeat.o(37827);
            return true;
        }
        AppMethodBeat.o(37827);
        return false;
    }

    public final boolean b(long j, e eVar) {
        AppMethodBeat.i(37828);
        ContentValues Hl = eVar.Hl();
        Hl.remove("rowid");
        if (this.bSd.update("AdSnsInfo", Hl, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.o(37828);
            return true;
        }
        AppMethodBeat.o(37828);
        return false;
    }

    public final boolean kv(long j) {
        AppMethodBeat.i(37829);
        Cursor a = this.bSd.a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(j)), null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.o(37829);
        return moveToFirst;
    }

    private int a(e eVar) {
        AppMethodBeat.i(37830);
        ab.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
        if (eVar == null) {
            AppMethodBeat.o(37830);
            return -1;
        }
        int insert = (int) this.bSd.insert("AdSnsInfo", "", eVar.Hl());
        ab.d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result".concat(String.valueOf(insert)));
        AppMethodBeat.o(37830);
        return insert;
    }

    public final boolean delete(long j) {
        AppMethodBeat.i(37831);
        int delete = this.bSd.delete("AdSnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        ab.i("MicroMsg.AdSnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            AppMethodBeat.o(37831);
            return true;
        }
        AppMethodBeat.o(37831);
        return false;
    }

    public final Cursor fq(int i, int i2) {
        AppMethodBeat.i(37832);
        String str = ("select *,rowid from AdSnsInfo  where createTime > " + i2 + " and createTime <= " + i + " and " + o.rfz) + " order by  createTime desc";
        ab.d("MicroMsg.AdSnsInfoStorage", "getAdInTime ".concat(String.valueOf(str)));
        Cursor a = this.bSd.a(str, null, 2);
        AppMethodBeat.o(37832);
        return a;
    }
}
