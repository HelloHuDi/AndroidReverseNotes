package com.tencent.p177mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.storage.f */
public final class C43571f extends C7563j<C43570e> {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS serverAdSnsNameIndex ON AdSnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverAdSnsTimeHeadIndex ON AdSnsInfo ( head )", "DROP INDEX IF EXISTS serverAdSnsTimeIndex", "DROP INDEX IF EXISTS serverAdSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex1 ON AdSnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS adsnsMultiIndex2 ON AdSnsInfo ( sourceType,type,userName)"};
    public static final String[] fnj = new String[]{C7563j.m13217a(C43570e.ccO, "adsnsinfo")};
    private static final String rfa = String.format("select  %s %s,rowid from AdSnsInfo ", new Object[]{"snsId", "createTime"});
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(37834);
        AppMethodBeat.m2505o(37834);
    }

    public C43571f(C4927e c4927e) {
        super(c4927e, C43570e.ccO, "adsnsinfo", diI);
        this.bSd = c4927e;
    }

    /* renamed from: ku */
    public final C43570e mo69174ku(long j) {
        AppMethodBeat.m2504i(37825);
        C43570e c43570e = new C43570e();
        Cursor a = this.bSd.mo10104a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(j)), null, 2);
        if (a.moveToFirst()) {
            c43570e.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(37825);
            return c43570e;
        }
        a.close();
        AppMethodBeat.m2505o(37825);
        return null;
    }

    /* renamed from: DG */
    public final C43570e mo69170DG(int i) {
        AppMethodBeat.m2504i(37826);
        C43570e c43570e = new C43570e();
        Cursor a = this.bSd.mo10104a("select *,rowid from AdSnsInfo  where AdSnsInfo.rowid=".concat(String.valueOf(i)), null, 2);
        if (a.moveToFirst()) {
            c43570e.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(37826);
            return c43570e;
        }
        a.close();
        AppMethodBeat.m2505o(37826);
        return null;
    }

    /* renamed from: a */
    public final boolean mo69171a(long j, C43570e c43570e) {
        AppMethodBeat.m2504i(37827);
        if (mo69175kv(j)) {
            boolean b = mo69172b(j, c43570e);
            AppMethodBeat.m2505o(37827);
            return b;
        }
        C4990ab.m7410d("MicroMsg.AdSnsInfoStorage", "added PcId ".concat(String.valueOf(j)));
        if (m77931a(c43570e) != -1) {
            AppMethodBeat.m2505o(37827);
            return true;
        }
        AppMethodBeat.m2505o(37827);
        return false;
    }

    /* renamed from: b */
    public final boolean mo69172b(long j, C43570e c43570e) {
        AppMethodBeat.m2504i(37828);
        ContentValues Hl = c43570e.mo10098Hl();
        Hl.remove("rowid");
        if (this.bSd.update("AdSnsInfo", Hl, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.m2505o(37828);
            return true;
        }
        AppMethodBeat.m2505o(37828);
        return false;
    }

    /* renamed from: kv */
    public final boolean mo69175kv(long j) {
        AppMethodBeat.m2504i(37829);
        Cursor a = this.bSd.mo10104a("select *,rowid from AdSnsInfo  where AdSnsInfo.snsId=".concat(String.valueOf(j)), null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        AppMethodBeat.m2505o(37829);
        return moveToFirst;
    }

    /* renamed from: a */
    private int m77931a(C43570e c43570e) {
        AppMethodBeat.m2504i(37830);
        C4990ab.m7410d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert");
        if (c43570e == null) {
            AppMethodBeat.m2505o(37830);
            return -1;
        }
        int insert = (int) this.bSd.insert("AdSnsInfo", "", c43570e.mo10098Hl());
        C4990ab.m7410d("MicroMsg.AdSnsInfoStorage", "SnsInfo Insert result".concat(String.valueOf(insert)));
        AppMethodBeat.m2505o(37830);
        return insert;
    }

    public final boolean delete(long j) {
        AppMethodBeat.m2504i(37831);
        int delete = this.bSd.delete("AdSnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        C4990ab.m7416i("MicroMsg.AdSnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            AppMethodBeat.m2505o(37831);
            return true;
        }
        AppMethodBeat.m2505o(37831);
        return false;
    }

    /* renamed from: fq */
    public final Cursor mo69173fq(int i, int i2) {
        AppMethodBeat.m2504i(37832);
        String str = ("select *,rowid from AdSnsInfo  where createTime > " + i2 + " and createTime <= " + i + " and " + C39789o.rfz) + " order by  createTime desc";
        C4990ab.m7410d("MicroMsg.AdSnsInfoStorage", "getAdInTime ".concat(String.valueOf(str)));
        Cursor a = this.bSd.mo10104a(str, null, 2);
        AppMethodBeat.m2505o(37832);
        return a;
    }
}
