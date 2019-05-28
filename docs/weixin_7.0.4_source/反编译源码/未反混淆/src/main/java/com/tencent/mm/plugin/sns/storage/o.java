package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class o extends j<n> implements g {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS serverSnsNameIndex ON SnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverSnsTimeHeadIndex ON SnsInfo ( head )", "DROP INDEX IF EXISTS serverSnsTimeIndex", "DROP INDEX IF EXISTS serverSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS snsMultiIndex1 ON SnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS snsMultiIndex2 ON SnsInfo ( sourceType,type,userName)", "CREATE INDEX IF NOT EXISTS snsLocalflagIndex ON SnsInfo ( localFlag )"};
    public static final String[] fnj = new String[]{j.a(n.ccO, "SnsInfo")};
    private static ArrayList<Integer> rfA = dm(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(64), Integer.valueOf(128), Integer.valueOf(256)}));
    private static ArrayList<Integer> rfB = dm(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8)}));
    private static String[] rfl = new String[]{"snsId", "userName", "localFlag", "createTime", "head", "localPrivate", "type", "sourceType", "likeFlag", "pravited", "stringSeq", b.CONTENT, "attrBuf", "postBuf", "rowid"};
    private static String rfm;
    public static String rfn = " order by SnsInfo.createTime desc ,snsId desc";
    public static String rfo = " order by SnsInfo.createTime asc ,snsId asc";
    private static String rfp = " order by SnsInfo.createTime asc ,snsId asc";
    public static String rfq = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
    public static String rfr = " order by SnsInfo.head desc ,snsId desc";
    public static String rfs;
    public static String rft;
    protected static String rfu;
    protected static String rfv = " (sourceType & 2 != 0 ) and type < 21";
    private static String rfw;
    private static String rfx;
    private static String rfy;
    protected static String rfz;
    public e bSd;
    private boolean rfj;
    private int rfk;

    public final /* synthetic */ boolean a(c cVar) {
        AppMethodBeat.i(37967);
        boolean B = B((n) cVar);
        AppMethodBeat.o(37967);
        return B;
    }

    static {
        int i;
        AppMethodBeat.i(37969);
        rfm = "";
        rfs = null;
        rft = null;
        rfu = " (sourceType & 2 != 0 ) ";
        rfw = null;
        rfx = null;
        rfy = null;
        rfz = null;
        rfm = "select ";
        for (i = 0; i < rfl.length; i++) {
            if (i < rfl.length - 1) {
                rfm += " " + rfl[i] + ",";
            } else {
                rfm += " " + rfl[i] + " ";
            }
        }
        ab.i("MicroMsg.SnsInfoStorage", "TIMELINE_SELECT_BEGIN " + rfm);
        ArrayList arrayList = new ArrayList();
        Iterator it = rfA.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 16) != 0 && (i & 32) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfs = f(arrayList, "localFlag");
        ab.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfs);
        arrayList.clear();
        it = rfA.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rft = f(arrayList, "localFlag");
        ab.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rft);
        arrayList.clear();
        it = rfA.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 64) == 0 && (i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfy = f(arrayList, "localFlag");
        arrayList.clear();
        it = rfB.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 8) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfx = f(arrayList, "sourceType");
        ab.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfx);
        arrayList.clear();
        it = rfB.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 2) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfu = f(arrayList, "sourceType");
        ab.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfu);
        arrayList.clear();
        it = rfB.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 4) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfw = f(arrayList, "sourceType");
        ab.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfw);
        arrayList.clear();
        Iterator it2 = rfA.iterator();
        while (it2.hasNext()) {
            i = ((Integer) it2.next()).intValue();
            if ((i & 256) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfz = b(arrayList, "localFlag", true);
        AppMethodBeat.o(37969);
    }

    private static boolean crh() {
        AppMethodBeat.i(37916);
        rk rkVar = new rk();
        a.xxA.m(rkVar);
        boolean z = rkVar.cNs.cNt;
        AppMethodBeat.o(37916);
        return z;
    }

    private static String cri() {
        AppMethodBeat.i(37917);
        String str;
        if (crh()) {
            str = " (sourceType & 2 != 0 ) and type < 21";
            AppMethodBeat.o(37917);
            return str;
        }
        str = " (sourceType & 2 != 0 ) ";
        AppMethodBeat.o(37917);
        return str;
    }

    private static String f(List<Integer> list, String str) {
        AppMethodBeat.i(37918);
        String b = b(list, str, false);
        AppMethodBeat.o(37918);
        return b;
    }

    private static String b(List<Integer> list, String str, boolean z) {
        AppMethodBeat.i(37919);
        StringBuilder stringBuilder = new StringBuilder("(");
        if (z) {
            stringBuilder.append(str + " not in (");
        } else {
            stringBuilder.append(str + " in (");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(37919);
        return stringBuilder2;
    }

    private static ArrayList<Integer> dm(List<Integer> list) {
        AppMethodBeat.i(37920);
        ArrayList arrayList = new ArrayList(list);
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            ArrayList arrayList3 = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(((Integer) it2.next()).intValue() | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList3));
            hashSet.add(num);
        }
        hashSet.add(Integer.valueOf(0));
        arrayList2.addAll(hashSet);
        AppMethodBeat.o(37920);
        return arrayList2;
    }

    public o(e eVar) {
        boolean z;
        boolean z2 = true;
        super(eVar, n.ccO, "SnsInfo", diI);
        AppMethodBeat.i(37921);
        this.bSd = eVar;
        Cursor a = this.bSd.a("select count(*) from SnsInfo where snsId > 0;", null, 2);
        if (!a.moveToFirst() || a.getInt(0) <= 0) {
            a.close();
            z = false;
        } else {
            ab.i("MicroMsg.SnsInfoStorage", "exsits snsId > 0  ,count is %d", Integer.valueOf(a.getInt(0)));
            a.close();
            z = true;
        }
        if (z) {
            z2 = false;
        }
        this.rfj = z2;
        this.rfk = 0;
        if (this.rfj) {
            ab.i("MicroMsg.SnsInfoStorage", "all sndId < 0 ,so optimalizeForSnsId");
            AppMethodBeat.o(37921);
            return;
        }
        rfn = " order by SnsInfo.createTime desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        rfo = " order by SnsInfo.createTime asc ,case when snsId < 0 then 0 else 1 end ,  snsId asc";
        rfq = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
        rfr = " order by SnsInfo.head desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        AppMethodBeat.o(37921);
    }

    public final int A(n nVar) {
        AppMethodBeat.i(37922);
        ab.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert");
        if (nVar == null) {
            AppMethodBeat.o(37922);
            return -1;
        }
        int insert = (int) this.bSd.insert("SnsInfo", "", nVar.Hl());
        ab.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert result ".concat(String.valueOf(insert)));
        AppMethodBeat.o(37922);
        return insert;
    }

    public final void d(String str, boolean z, String str2) {
        AppMethodBeat.i(37923);
        String str3 = bm(str, z) + " AND  (snsId != 0  ) ";
        if (Zb(str2)) {
            str3 = str3 + " AND " + Zf(str2);
        }
        q(z, str3);
        AppMethodBeat.o(37923);
    }

    public final void q(boolean z, String str) {
        AppMethodBeat.i(37924);
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & " + ((z ? 4 : 8) ^ -1) + str;
        ab.d("MicroMsg.SnsInfoStorage", "updateFilterUserName sql ".concat(String.valueOf(str2)));
        this.bSd.hY("SnsInfo", str2);
        AppMethodBeat.o(37924);
    }

    public final void crj() {
        AppMethodBeat.i(37925);
        Za(" where " + cri() + " AND  (snsId != 0  ) ");
        AppMethodBeat.o(37925);
    }

    public final void YY(String str) {
        AppMethodBeat.i(37926);
        if (Zb(str)) {
            Za(" where " + Zf(str) + " and " + cri() + " and  (snsId != 0  ) ");
            AppMethodBeat.o(37926);
            return;
        }
        AppMethodBeat.o(37926);
    }

    public final void YZ(String str) {
        AppMethodBeat.i(37927);
        if (Zb(str)) {
            Za(" where " + Ze(str) + " and " + cri() + " and  (snsId != 0  ) ");
            AppMethodBeat.o(37927);
            return;
        }
        AppMethodBeat.o(37927);
    }

    private void Za(String str) {
        AppMethodBeat.i(37928);
        String concat = "UPDATE SnsInfo SET sourceType = sourceType & -3".concat(String.valueOf(str));
        ab.d("MicroMsg.SnsInfoStorage", "updateFilterTimeLine sql ".concat(String.valueOf(concat)));
        this.bSd.hY("SnsInfo", concat);
        AppMethodBeat.o(37928);
    }

    public final boolean kv(long j) {
        AppMethodBeat.i(37929);
        Cursor rawQuery = this.bSd.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=".concat(String.valueOf(j)), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.o(37929);
            return true;
        }
        AppMethodBeat.o(37929);
        return false;
    }

    public final boolean a(long j, n nVar) {
        AppMethodBeat.i(37930);
        if (kv(j)) {
            boolean b = b(j, nVar);
            AppMethodBeat.o(37930);
            return b;
        } else if (A(nVar) != -1) {
            AppMethodBeat.o(37930);
            return true;
        } else {
            AppMethodBeat.o(37930);
            return false;
        }
    }

    public static boolean Zb(String str) {
        AppMethodBeat.i(37931);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(37931);
            return false;
        }
        AppMethodBeat.o(37931);
        return true;
    }

    public final String Zc(String str) {
        AppMethodBeat.i(37932);
        String str2;
        if (str == null || str.equals("")) {
            str2 = " ";
            AppMethodBeat.o(37932);
            return str2;
        } else if (this.rfj) {
            str2 = " (snsId >= " + Zd(bo.vA(str)) + " ) ";
            AppMethodBeat.o(37932);
            return str2;
        } else {
            str2 = " (stringSeq >=\"" + bo.vA(str) + "\"  ) ";
            AppMethodBeat.o(37932);
            return str2;
        }
    }

    private static long Zd(String str) {
        AppMethodBeat.i(37933);
        ab.i("MicroMsg.SnsInfoStorage", "seq %s to snsId %d ", str, Long.valueOf(new BigInteger(str).longValue()));
        AppMethodBeat.o(37933);
        return new BigInteger(str).longValue();
    }

    public final String Ze(String str) {
        AppMethodBeat.i(37934);
        String str2;
        if (str == null || str.equals("")) {
            str2 = " ";
            AppMethodBeat.o(37934);
            return str2;
        } else if (this.rfj) {
            str2 = " (snsId > " + Zd(bo.vA(str)) + " ) ";
            AppMethodBeat.o(37934);
            return str2;
        } else {
            str2 = " (stringSeq >\"" + bo.vA(str) + "\"  ) ";
            AppMethodBeat.o(37934);
            return str2;
        }
    }

    public final String Zf(String str) {
        AppMethodBeat.i(37935);
        String str2;
        if (str == null || str.equals("")) {
            str2 = " ";
            AppMethodBeat.o(37935);
            return str2;
        } else if (this.rfj) {
            str2 = " (snsId < " + Zd(bo.vA(str)) + " ) ";
            AppMethodBeat.o(37935);
            return str2;
        } else {
            str2 = " (stringSeq <\"" + bo.vA(str) + "\"  ) ";
            AppMethodBeat.o(37935);
            return str2;
        }
    }

    public static String bm(String str, boolean z) {
        AppMethodBeat.i(37936);
        String str2 = "";
        if (z) {
            str2 = str2 + " WHERE " + rfw;
        } else {
            str2 = (str2 + " WHERE SnsInfo.userName=\"" + bo.vA(str) + "\"") + " AND " + rfx;
        }
        AppMethodBeat.o(37936);
        return str2;
    }

    public static String bn(String str, boolean z) {
        AppMethodBeat.i(37937);
        String str2 = ("select *,rowid from SnsInfo " + bm(str, z)) + " AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26)";
        AppMethodBeat.o(37937);
        return str2;
    }

    public final long g(long j, int i, boolean z) {
        AppMethodBeat.i(37938);
        long c = c(crl(), j, i, z);
        AppMethodBeat.o(37938);
        return c;
    }

    public final long a(long j, int i, String str, boolean z) {
        AppMethodBeat.i(37939);
        long c = c(bn(str, z), j, i, false);
        AppMethodBeat.o(37939);
        return c;
    }

    private long c(String str, long j, int i, boolean z) {
        String str2;
        AppMethodBeat.i(37940);
        if (j != 0) {
            str2 = str + " AND SnsInfo.stringSeq < '" + i.Xl(i.jV(j)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        ab.d("MicroMsg.SnsInfoStorage", "getMinSeqByLimit %s \n maxId=%s", (str2 + rfn) + " limit " + i, Long.valueOf(j));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        if (rawQuery.moveToLast()) {
            n nVar = new n();
            nVar.d(rawQuery);
            rawQuery.close();
            long j2 = nVar.field_snsId;
            AppMethodBeat.o(37940);
            return j2;
        }
        rawQuery.close();
        AppMethodBeat.o(37940);
        return 0;
    }

    public static String crk() {
        AppMethodBeat.i(37941);
        String str = "select *,rowid from SnsInfo  where " + " (sourceType & 2 != 0 ) ";
        AppMethodBeat.o(37941);
        return str;
    }

    public static String crl() {
        AppMethodBeat.i(37942);
        String str = "select *,rowid from SnsInfo  where " + cri();
        AppMethodBeat.o(37942);
        return str;
    }

    public static String crm() {
        String str;
        AppMethodBeat.i(37943);
        StringBuilder append = new StringBuilder().append("select *,rowid from SnsInfo  where ");
        if (crh()) {
            str = rfv;
        } else {
            str = rfu;
        }
        str = append.append(str).toString();
        AppMethodBeat.o(37943);
        return str;
    }

    public static String crn() {
        AppMethodBeat.i(37944);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo  where ").append(cri()).append(" limit 3");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(37944);
        return stringBuilder2;
    }

    public final Cursor e(String str, boolean z, String str2) {
        AppMethodBeat.i(37945);
        Cursor b = b(str, 0, z, str2);
        AppMethodBeat.o(37945);
        return b;
    }

    public final Cursor b(String str, int i, boolean z, String str2) {
        Object obj;
        AppMethodBeat.i(37946);
        String bn = bn(str, z);
        if (Zb(str2)) {
            bn = bn + " AND " + Zc(str2);
        }
        if (z) {
            obj = bn + rfq;
        } else {
            obj = bn + rfr;
        }
        if (i > 0) {
            obj = obj + " LIMIT " + i;
        }
        ab.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.o(37946);
        return rawQuery;
    }

    public final Cursor WY(String str) {
        AppMethodBeat.i(37947);
        String crl = crl();
        if (Zb(str)) {
            crl = crl + " AND " + Zc(str);
        }
        crl = crl + rfn;
        ab.d("MicroMsg.SnsInfoStorage", "getCursorForTimeLine ".concat(String.valueOf(crl)));
        Cursor rawQuery = this.bSd.rawQuery(crl, null);
        AppMethodBeat.o(37947);
        return rawQuery;
    }

    public final List<n> bo(String str, boolean z) {
        AppMethodBeat.i(37948);
        Cursor a = this.bSd.a("select *,rowid from SnsInfo " + bm(str, z) + " AND type = 4", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            n nVar = new n();
            nVar.d(a);
            arrayList.add(nVar);
        }
        a.close();
        AppMethodBeat.o(37948);
        return arrayList;
    }

    public final int Zg(String str) {
        AppMethodBeat.i(37949);
        String crl = crl();
        if (Zb(str)) {
            crl = crl + " AND " + Zc(str);
        }
        String str2 = (crl + " AND  (snsId != 0 ) ") + rfo + " limit 1";
        Cursor a = this.bSd.a(str2, null, 2);
        int i = 0;
        if (a.moveToFirst()) {
            n nVar = new n();
            nVar.d(a);
            i = nVar.field_createTime;
        }
        a.close();
        ab.i("MicroMsg.SnsInfoStorage", "getLastTime " + str2 + " createtime " + i);
        AppMethodBeat.o(37949);
        return i;
    }

    public final Cursor df(String str, int i) {
        AppMethodBeat.i(37950);
        String str2 = (rfm + " from SnsInfo where ") + cri();
        if (Zb(str)) {
            str2 = str2 + " AND " + Zc(str);
        }
        str2 = (((str2 + " AND createTime >= " + i) + " UNION ") + rfm + " from AdSnsInfo where createTime > " + i + " and " + rfz) + rfn;
        ab.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        AppMethodBeat.o(37950);
        return rawQuery;
    }

    public final Cursor ah(String str, int i, int i2) {
        AppMethodBeat.i(37951);
        String str2 = (rfm + " from SnsInfo where ") + cri();
        if (Zb(str)) {
            str2 = str2 + " AND " + Zc(str);
        }
        str2 = ((((str2 + " AND createTime >= " + i) + " UNION ") + rfm + " from AdSnsInfo where createTime > " + i + " and " + rfz) + rfn) + " limit " + i2;
        ab.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        AppMethodBeat.o(37951);
        return rawQuery;
    }

    public final void jR(long j) {
        int i;
        AppMethodBeat.i(37952);
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putLong("check_trim_time", 0).commit();
        h Ru = af.Ru();
        long iV = Ru.iV(Thread.currentThread().getId());
        for (i = 0; ((long) i) < j; i++) {
            Ru.hY("SnsInfo", "INSERT INTO SnsInfo VALUES(-69999999991777434909,'miaochanchan',2,1402026897,20140606,0,2,2,0,0,'0',X'0A143131373631303534303431393332313136373037120C6D69616F6368616E6368616E18002091F7C49C052A36E8A681E6849FE8B0A2E8BF99E4BBBDE5B7A5EFBC8CE8AEA9E68891E4B88DE4BC9AE69C89E5A29EE882A5E79A84E8BFB9E8B1A1E3808232180D0000000015000000001A0022002A0032003800480050003A0A0A0012001A0022002A0042080A0010021A0022004A0052005A006000680272007A2408001200180022002A0032003A080A0012001A00220042004A040800100052040A001200',X'08E3E5A48CEA8AEA9BA301120C6D69616F6368616E6368616E1A09E88B97E7B1B3E7B1B32091F7C49C052A04080012003000380040005000580068007000800101880100900100A00101B00100B80100',NULL);");
        }
        for (i = 0; ((long) i) < 20000; i++) {
            Ru.hY("snsExtInfo3", String.format("INSERT INTO snsExtInfo3 VALUES('zeustest%d','afd',2,1402026897,'d', 0,1, 1, 1, 1, 'a', 'a', NULL);", new Object[]{Integer.valueOf(i)}));
        }
        for (i = 0; ((long) i) < 20000; i++) {
            Ru.hY("snsComment", String.format("INSERT INTO snsComment VALUES(-69999999991777434909,0,2,1402026897,'d', 2,1, 'a', 'b', 1, NULL);", new Object[0]));
        }
        Ru.mB(iV);
        AppMethodBeat.o(37952);
    }

    public final ArrayList<Long> cmn() {
        AppMethodBeat.i(37953);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("SnsInfo", new String[]{"*", "rowid"}, "createTime >=? AND " + rfy, new String[]{String.valueOf(((int) (System.currentTimeMillis() / 1000)) - 172800)}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            try {
                n nVar = new n();
                nVar.d(a);
                if (nVar.reX != -1 && nVar.field_userName.equals(r.Yz())) {
                    arrayList.add(Long.valueOf((long) nVar.reX));
                    ab.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, add snsInfo: " + nVar.cqU());
                }
            } catch (Throwable th) {
                a.close();
                AppMethodBeat.o(37953);
            }
        }
        a.close();
        ab.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, resendList.size:%d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(37953);
        return arrayList;
    }

    public final boolean CJ(int i) {
        AppMethodBeat.i(37954);
        if (DK(i) != null) {
            AppMethodBeat.o(37954);
            return true;
        }
        AppMethodBeat.o(37954);
        return false;
    }

    public final n kD(long j) {
        AppMethodBeat.i(37956);
        n nVar = new n();
        Cursor a = this.bSd.a("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j + " limit 1", null, 2);
        if (a.moveToFirst()) {
            nVar.d(a);
            a.close();
            AppMethodBeat.o(37956);
            return nVar;
        }
        a.close();
        AppMethodBeat.o(37956);
        return null;
    }

    public final n YS(String str) {
        AppMethodBeat.i(37957);
        n kD;
        if (v.WT(str)) {
            kD = kD(v.Zm(str));
            AppMethodBeat.o(37957);
            return kD;
        }
        e ku = af.cnI().ku(v.Zm(str));
        if (ku != null) {
            kD = ku.cqB();
            AppMethodBeat.o(37957);
            return kD;
        }
        AppMethodBeat.o(37957);
        return null;
    }

    public final n DK(int i) {
        AppMethodBeat.i(37958);
        n nVar = new n();
        Cursor a = this.bSd.a("select *,rowid from SnsInfo  where SnsInfo.rowid=".concat(String.valueOf(i)), null, 2);
        if (a.moveToFirst()) {
            nVar.d(a);
            a.close();
            AppMethodBeat.o(37958);
            return nVar;
        }
        a.close();
        AppMethodBeat.o(37958);
        return null;
    }

    public final n YT(String str) {
        AppMethodBeat.i(37959);
        n DK;
        if (v.WT(str)) {
            DK = DK(v.Zn(str));
            AppMethodBeat.o(37959);
            return DK;
        }
        e DG = af.cnI().DG(v.Zn(str));
        if (DG != null) {
            DK = DG.cqB();
            AppMethodBeat.o(37959);
            return DK;
        }
        AppMethodBeat.o(37959);
        return null;
    }

    public final boolean b(long j, n nVar) {
        AppMethodBeat.i(37960);
        ContentValues Hl = nVar.Hl();
        Hl.remove("rowid");
        if (this.bSd.update("SnsInfo", Hl, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.o(37960);
            return true;
        }
        AppMethodBeat.o(37960);
        return false;
    }

    public final int b(int i, n nVar) {
        AppMethodBeat.i(37961);
        ContentValues Hl = nVar.Hl();
        Hl.remove("rowid");
        int update = this.bSd.update("SnsInfo", Hl, "rowid=?", new String[]{String.valueOf(i)});
        AppMethodBeat.o(37961);
        return update;
    }

    public final boolean delete(long j) {
        AppMethodBeat.i(37962);
        int delete = this.bSd.delete("SnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        ab.d("MicroMsg.SnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            AppMethodBeat.o(37962);
            return true;
        }
        AppMethodBeat.o(37962);
        return false;
    }

    public final boolean DL(int i) {
        AppMethodBeat.i(37963);
        if (this.bSd.delete("SnsInfo", "rowid=?", new String[]{String.valueOf(i)}) > 0) {
            AppMethodBeat.o(37963);
            return true;
        }
        AppMethodBeat.o(37963);
        return false;
    }

    public final int jS(long j) {
        AppMethodBeat.i(37964);
        n kD = af.cnF().kD(j);
        if (kD == null) {
            AppMethodBeat.o(37964);
            return 0;
        }
        int cre = kD.cre();
        AppMethodBeat.o(37964);
        return cre;
    }

    public final long d(long j, String str, boolean z) {
        AppMethodBeat.i(37965);
        long c = c(bp(str, z), j, 30, false);
        AppMethodBeat.o(37965);
        return c;
    }

    public static String bp(String str, boolean z) {
        AppMethodBeat.i(37966);
        String str2 = ("select *,rowid from SnsInfo " + bm(str, z)) + " AND type in ( 1 , 15)";
        AppMethodBeat.o(37966);
        return str2;
    }

    public final boolean B(n nVar) {
        AppMethodBeat.i(37955);
        boolean a;
        if (nVar.DI(32)) {
            a = af.cnI().a(nVar.crd());
            AppMethodBeat.o(37955);
            return a;
        }
        a = this.bSd.replace("SnsInfo", "", nVar.Hl()) > 0;
        ab.d("MicroMsg.SnsInfoStorage", "SnsInfo replace result ".concat(String.valueOf(a)));
        AppMethodBeat.o(37955);
        return a;
    }
}
