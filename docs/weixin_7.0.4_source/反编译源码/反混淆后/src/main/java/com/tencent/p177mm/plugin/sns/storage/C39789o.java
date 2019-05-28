package com.tencent.p177mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C42051rk;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1024b.C43536g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.storage.o */
public final class C39789o extends C7563j<C46236n> implements C43536g {
    public static final String[] diI = new String[]{"CREATE INDEX IF NOT EXISTS serverSnsNameIndex ON SnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverSnsTimeHeadIndex ON SnsInfo ( head )", "DROP INDEX IF EXISTS serverSnsTimeIndex", "DROP INDEX IF EXISTS serverSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS snsMultiIndex1 ON SnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS snsMultiIndex2 ON SnsInfo ( sourceType,type,userName)", "CREATE INDEX IF NOT EXISTS snsLocalflagIndex ON SnsInfo ( localFlag )"};
    public static final String[] fnj = new String[]{C7563j.m13217a(C46236n.ccO, "SnsInfo")};
    private static ArrayList<Integer> rfA = C39789o.m68087dm(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(64), Integer.valueOf(128), Integer.valueOf(256)}));
    private static ArrayList<Integer> rfB = C39789o.m68087dm(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8)}));
    private static String[] rfl = new String[]{"snsId", "userName", "localFlag", "createTime", "head", "localPrivate", "type", "sourceType", "likeFlag", "pravited", "stringSeq", C8741b.CONTENT, "attrBuf", "postBuf", "rowid"};
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
    public C4927e bSd;
    private boolean rfj;
    private int rfk;

    /* renamed from: a */
    public final /* synthetic */ boolean mo10099a(C4925c c4925c) {
        AppMethodBeat.m2504i(37967);
        boolean B = mo62912B((C46236n) c4925c);
        AppMethodBeat.m2505o(37967);
        return B;
    }

    static {
        int i;
        AppMethodBeat.m2504i(37969);
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
        C4990ab.m7416i("MicroMsg.SnsInfoStorage", "TIMELINE_SELECT_BEGIN " + rfm);
        ArrayList arrayList = new ArrayList();
        Iterator it = rfA.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 16) != 0 && (i & 32) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfs = C39789o.m68088f(arrayList, "localFlag");
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfs);
        arrayList.clear();
        it = rfA.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rft = C39789o.m68088f(arrayList, "localFlag");
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rft);
        arrayList.clear();
        it = rfA.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 64) == 0 && (i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfy = C39789o.m68088f(arrayList, "localFlag");
        arrayList.clear();
        it = rfB.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 8) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfx = C39789o.m68088f(arrayList, "sourceType");
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfx);
        arrayList.clear();
        it = rfB.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 2) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfu = C39789o.m68088f(arrayList, "sourceType");
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfu);
        arrayList.clear();
        it = rfB.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 4) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfw = C39789o.m68088f(arrayList, "sourceType");
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", rfw);
        arrayList.clear();
        Iterator it2 = rfA.iterator();
        while (it2.hasNext()) {
            i = ((Integer) it2.next()).intValue();
            if ((i & 256) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        rfz = C39789o.m68082b(arrayList, "localFlag", true);
        AppMethodBeat.m2505o(37969);
    }

    private static boolean crh() {
        AppMethodBeat.m2504i(37916);
        C42051rk c42051rk = new C42051rk();
        C4879a.xxA.mo10055m(c42051rk);
        boolean z = c42051rk.cNs.cNt;
        AppMethodBeat.m2505o(37916);
        return z;
    }

    private static String cri() {
        AppMethodBeat.m2504i(37917);
        String str;
        if (C39789o.crh()) {
            str = " (sourceType & 2 != 0 ) and type < 21";
            AppMethodBeat.m2505o(37917);
            return str;
        }
        str = " (sourceType & 2 != 0 ) ";
        AppMethodBeat.m2505o(37917);
        return str;
    }

    /* renamed from: f */
    private static String m68088f(List<Integer> list, String str) {
        AppMethodBeat.m2504i(37918);
        String b = C39789o.m68082b(list, str, false);
        AppMethodBeat.m2505o(37918);
        return b;
    }

    /* renamed from: b */
    private static String m68082b(List<Integer> list, String str, boolean z) {
        AppMethodBeat.m2504i(37919);
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
        AppMethodBeat.m2505o(37919);
        return stringBuilder2;
    }

    /* renamed from: dm */
    private static ArrayList<Integer> m68087dm(List<Integer> list) {
        AppMethodBeat.m2504i(37920);
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
        AppMethodBeat.m2505o(37920);
        return arrayList2;
    }

    public C39789o(C4927e c4927e) {
        boolean z;
        boolean z2 = true;
        super(c4927e, C46236n.ccO, "SnsInfo", diI);
        AppMethodBeat.m2504i(37921);
        this.bSd = c4927e;
        Cursor a = this.bSd.mo10104a("select count(*) from SnsInfo where snsId > 0;", null, 2);
        if (!a.moveToFirst() || a.getInt(0) <= 0) {
            a.close();
            z = false;
        } else {
            C4990ab.m7417i("MicroMsg.SnsInfoStorage", "exsits snsId > 0  ,count is %d", Integer.valueOf(a.getInt(0)));
            a.close();
            z = true;
        }
        if (z) {
            z2 = false;
        }
        this.rfj = z2;
        this.rfk = 0;
        if (this.rfj) {
            C4990ab.m7416i("MicroMsg.SnsInfoStorage", "all sndId < 0 ,so optimalizeForSnsId");
            AppMethodBeat.m2505o(37921);
            return;
        }
        rfn = " order by SnsInfo.createTime desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        rfo = " order by SnsInfo.createTime asc ,case when snsId < 0 then 0 else 1 end ,  snsId asc";
        rfq = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
        rfr = " order by SnsInfo.head desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        AppMethodBeat.m2505o(37921);
    }

    /* renamed from: A */
    public final int mo62911A(C46236n c46236n) {
        AppMethodBeat.m2504i(37922);
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "SnsInfo Insert");
        if (c46236n == null) {
            AppMethodBeat.m2505o(37922);
            return -1;
        }
        int insert = (int) this.bSd.insert("SnsInfo", "", c46236n.mo10098Hl());
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "SnsInfo Insert result ".concat(String.valueOf(insert)));
        AppMethodBeat.m2505o(37922);
        return insert;
    }

    /* renamed from: d */
    public final void mo62935d(String str, boolean z, String str2) {
        AppMethodBeat.m2504i(37923);
        String str3 = C39789o.m68083bm(str, z) + " AND  (snsId != 0  ) ";
        if (C39789o.m68080Zb(str2)) {
            str3 = str3 + " AND " + mo62923Zf(str2);
        }
        mo62943q(z, str3);
        AppMethodBeat.m2505o(37923);
    }

    /* renamed from: q */
    public final void mo62943q(boolean z, String str) {
        AppMethodBeat.m2504i(37924);
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & " + ((z ? 4 : 8) ^ -1) + str;
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "updateFilterUserName sql ".concat(String.valueOf(str2)));
        this.bSd.mo10108hY("SnsInfo", str2);
        AppMethodBeat.m2505o(37924);
    }

    public final void crj() {
        AppMethodBeat.m2504i(37925);
        m68079Za(" where " + C39789o.cri() + " AND  (snsId != 0  ) ");
        AppMethodBeat.m2505o(37925);
    }

    /* renamed from: YY */
    public final void mo62919YY(String str) {
        AppMethodBeat.m2504i(37926);
        if (C39789o.m68080Zb(str)) {
            m68079Za(" where " + mo62923Zf(str) + " and " + C39789o.cri() + " and  (snsId != 0  ) ");
            AppMethodBeat.m2505o(37926);
            return;
        }
        AppMethodBeat.m2505o(37926);
    }

    /* renamed from: YZ */
    public final void mo62920YZ(String str) {
        AppMethodBeat.m2504i(37927);
        if (C39789o.m68080Zb(str)) {
            m68079Za(" where " + mo62922Ze(str) + " and " + C39789o.cri() + " and  (snsId != 0  ) ");
            AppMethodBeat.m2505o(37927);
            return;
        }
        AppMethodBeat.m2505o(37927);
    }

    /* renamed from: Za */
    private void m68079Za(String str) {
        AppMethodBeat.m2504i(37928);
        String concat = "UPDATE SnsInfo SET sourceType = sourceType & -3".concat(String.valueOf(str));
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "updateFilterTimeLine sql ".concat(String.valueOf(concat)));
        this.bSd.mo10108hY("SnsInfo", concat);
        AppMethodBeat.m2505o(37928);
    }

    /* renamed from: kv */
    public final boolean mo62942kv(long j) {
        AppMethodBeat.m2504i(37929);
        Cursor rawQuery = this.bSd.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=".concat(String.valueOf(j)), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.m2505o(37929);
            return true;
        }
        AppMethodBeat.m2505o(37929);
        return false;
    }

    /* renamed from: a */
    public final boolean mo62926a(long j, C46236n c46236n) {
        AppMethodBeat.m2504i(37930);
        if (mo62942kv(j)) {
            boolean b = mo62930b(j, c46236n);
            AppMethodBeat.m2505o(37930);
            return b;
        } else if (mo62911A(c46236n) != -1) {
            AppMethodBeat.m2505o(37930);
            return true;
        } else {
            AppMethodBeat.m2505o(37930);
            return false;
        }
    }

    /* renamed from: Zb */
    public static boolean m68080Zb(String str) {
        AppMethodBeat.m2504i(37931);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(37931);
            return false;
        }
        AppMethodBeat.m2505o(37931);
        return true;
    }

    /* renamed from: Zc */
    public final String mo62921Zc(String str) {
        AppMethodBeat.m2504i(37932);
        String str2;
        if (str == null || str.equals("")) {
            str2 = " ";
            AppMethodBeat.m2505o(37932);
            return str2;
        } else if (this.rfj) {
            str2 = " (snsId >= " + C39789o.m68081Zd(C5046bo.m7586vA(str)) + " ) ";
            AppMethodBeat.m2505o(37932);
            return str2;
        } else {
            str2 = " (stringSeq >=\"" + C5046bo.m7586vA(str) + "\"  ) ";
            AppMethodBeat.m2505o(37932);
            return str2;
        }
    }

    /* renamed from: Zd */
    private static long m68081Zd(String str) {
        AppMethodBeat.m2504i(37933);
        C4990ab.m7417i("MicroMsg.SnsInfoStorage", "seq %s to snsId %d ", str, Long.valueOf(new BigInteger(str).longValue()));
        AppMethodBeat.m2505o(37933);
        return new BigInteger(str).longValue();
    }

    /* renamed from: Ze */
    public final String mo62922Ze(String str) {
        AppMethodBeat.m2504i(37934);
        String str2;
        if (str == null || str.equals("")) {
            str2 = " ";
            AppMethodBeat.m2505o(37934);
            return str2;
        } else if (this.rfj) {
            str2 = " (snsId > " + C39789o.m68081Zd(C5046bo.m7586vA(str)) + " ) ";
            AppMethodBeat.m2505o(37934);
            return str2;
        } else {
            str2 = " (stringSeq >\"" + C5046bo.m7586vA(str) + "\"  ) ";
            AppMethodBeat.m2505o(37934);
            return str2;
        }
    }

    /* renamed from: Zf */
    public final String mo62923Zf(String str) {
        AppMethodBeat.m2504i(37935);
        String str2;
        if (str == null || str.equals("")) {
            str2 = " ";
            AppMethodBeat.m2505o(37935);
            return str2;
        } else if (this.rfj) {
            str2 = " (snsId < " + C39789o.m68081Zd(C5046bo.m7586vA(str)) + " ) ";
            AppMethodBeat.m2505o(37935);
            return str2;
        } else {
            str2 = " (stringSeq <\"" + C5046bo.m7586vA(str) + "\"  ) ";
            AppMethodBeat.m2505o(37935);
            return str2;
        }
    }

    /* renamed from: bm */
    public static String m68083bm(String str, boolean z) {
        AppMethodBeat.m2504i(37936);
        String str2 = "";
        if (z) {
            str2 = str2 + " WHERE " + rfw;
        } else {
            str2 = (str2 + " WHERE SnsInfo.userName=\"" + C5046bo.m7586vA(str) + "\"") + " AND " + rfx;
        }
        AppMethodBeat.m2505o(37936);
        return str2;
    }

    /* renamed from: bn */
    public static String m68084bn(String str, boolean z) {
        AppMethodBeat.m2504i(37937);
        String str2 = ("select *,rowid from SnsInfo " + C39789o.m68083bm(str, z)) + " AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26)";
        AppMethodBeat.m2505o(37937);
        return str2;
    }

    /* renamed from: g */
    public final long mo62938g(long j, int i, boolean z) {
        AppMethodBeat.m2504i(37938);
        long c = m68086c(C39789o.crl(), j, i, z);
        AppMethodBeat.m2505o(37938);
        return c;
    }

    /* renamed from: a */
    public final long mo62925a(long j, int i, String str, boolean z) {
        AppMethodBeat.m2504i(37939);
        long c = m68086c(C39789o.m68084bn(str, z), j, i, false);
        AppMethodBeat.m2505o(37939);
        return c;
    }

    /* renamed from: c */
    private long m68086c(String str, long j, int i, boolean z) {
        String str2;
        AppMethodBeat.m2504i(37940);
        if (j != 0) {
            str2 = str + " AND SnsInfo.stringSeq < '" + C29036i.m46089Xl(C29036i.m46117jV(j)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        C4990ab.m7411d("MicroMsg.SnsInfoStorage", "getMinSeqByLimit %s \n maxId=%s", (str2 + rfn) + " limit " + i, Long.valueOf(j));
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        if (rawQuery.moveToLast()) {
            C46236n c46236n = new C46236n();
            c46236n.mo8995d(rawQuery);
            rawQuery.close();
            long j2 = c46236n.field_snsId;
            AppMethodBeat.m2505o(37940);
            return j2;
        }
        rawQuery.close();
        AppMethodBeat.m2505o(37940);
        return 0;
    }

    public static String crk() {
        AppMethodBeat.m2504i(37941);
        String str = "select *,rowid from SnsInfo  where " + " (sourceType & 2 != 0 ) ";
        AppMethodBeat.m2505o(37941);
        return str;
    }

    public static String crl() {
        AppMethodBeat.m2504i(37942);
        String str = "select *,rowid from SnsInfo  where " + C39789o.cri();
        AppMethodBeat.m2505o(37942);
        return str;
    }

    public static String crm() {
        String str;
        AppMethodBeat.m2504i(37943);
        StringBuilder append = new StringBuilder().append("select *,rowid from SnsInfo  where ");
        if (C39789o.crh()) {
            str = rfv;
        } else {
            str = rfu;
        }
        str = append.append(str).toString();
        AppMethodBeat.m2505o(37943);
        return str;
    }

    public static String crn() {
        AppMethodBeat.m2504i(37944);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo  where ").append(C39789o.cri()).append(" limit 3");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(37944);
        return stringBuilder2;
    }

    /* renamed from: e */
    public final Cursor mo62937e(String str, boolean z, String str2) {
        AppMethodBeat.m2504i(37945);
        Cursor b = mo62929b(str, 0, z, str2);
        AppMethodBeat.m2505o(37945);
        return b;
    }

    /* renamed from: b */
    public final Cursor mo62929b(String str, int i, boolean z, String str2) {
        Object obj;
        AppMethodBeat.m2504i(37946);
        String bn = C39789o.m68084bn(str, z);
        if (C39789o.m68080Zb(str2)) {
            bn = bn + " AND " + mo62921Zc(str2);
        }
        if (z) {
            obj = bn + rfq;
        } else {
            obj = bn + rfr;
        }
        if (i > 0) {
            obj = obj + " LIMIT " + i;
        }
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery ".concat(String.valueOf(obj)));
        Cursor rawQuery = this.bSd.rawQuery(obj, null);
        AppMethodBeat.m2505o(37946);
        return rawQuery;
    }

    /* renamed from: WY */
    public final Cursor mo62916WY(String str) {
        AppMethodBeat.m2504i(37947);
        String crl = C39789o.crl();
        if (C39789o.m68080Zb(str)) {
            crl = crl + " AND " + mo62921Zc(str);
        }
        crl = crl + rfn;
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getCursorForTimeLine ".concat(String.valueOf(crl)));
        Cursor rawQuery = this.bSd.rawQuery(crl, null);
        AppMethodBeat.m2505o(37947);
        return rawQuery;
    }

    /* renamed from: bo */
    public final List<C46236n> mo62931bo(String str, boolean z) {
        AppMethodBeat.m2504i(37948);
        Cursor a = this.bSd.mo10104a("select *,rowid from SnsInfo " + C39789o.m68083bm(str, z) + " AND type = 4", null, 2);
        ArrayList arrayList = new ArrayList();
        while (a.moveToNext()) {
            C46236n c46236n = new C46236n();
            c46236n.mo8995d(a);
            arrayList.add(c46236n);
        }
        a.close();
        AppMethodBeat.m2505o(37948);
        return arrayList;
    }

    /* renamed from: Zg */
    public final int mo62924Zg(String str) {
        AppMethodBeat.m2504i(37949);
        String crl = C39789o.crl();
        if (C39789o.m68080Zb(str)) {
            crl = crl + " AND " + mo62921Zc(str);
        }
        String str2 = (crl + " AND  (snsId != 0 ) ") + rfo + " limit 1";
        Cursor a = this.bSd.mo10104a(str2, null, 2);
        int i = 0;
        if (a.moveToFirst()) {
            C46236n c46236n = new C46236n();
            c46236n.mo8995d(a);
            i = c46236n.field_createTime;
        }
        a.close();
        C4990ab.m7416i("MicroMsg.SnsInfoStorage", "getLastTime " + str2 + " createtime " + i);
        AppMethodBeat.m2505o(37949);
        return i;
    }

    /* renamed from: df */
    public final Cursor mo62936df(String str, int i) {
        AppMethodBeat.m2504i(37950);
        String str2 = (rfm + " from SnsInfo where ") + C39789o.cri();
        if (C39789o.m68080Zb(str)) {
            str2 = str2 + " AND " + mo62921Zc(str);
        }
        str2 = (((str2 + " AND createTime >= " + i) + " UNION ") + rfm + " from AdSnsInfo where createTime > " + i + " and " + rfz) + rfn;
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        AppMethodBeat.m2505o(37950);
        return rawQuery;
    }

    /* renamed from: ah */
    public final Cursor mo62927ah(String str, int i, int i2) {
        AppMethodBeat.m2504i(37951);
        String str2 = (rfm + " from SnsInfo where ") + C39789o.cri();
        if (C39789o.m68080Zb(str)) {
            str2 = str2 + " AND " + mo62921Zc(str);
        }
        str2 = ((((str2 + " AND createTime >= " + i) + " UNION ") + rfm + " from AdSnsInfo where createTime > " + i + " and " + rfz) + rfn) + " limit " + i2;
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        Cursor rawQuery = this.bSd.rawQuery(str2, null);
        AppMethodBeat.m2505o(37951);
        return rawQuery;
    }

    /* renamed from: jR */
    public final void mo62939jR(long j) {
        int i;
        AppMethodBeat.m2504i(37952);
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putLong("check_trim_time", 0).commit();
        C7480h Ru = C13373af.m21489Ru();
        long iV = Ru.mo15639iV(Thread.currentThread().getId());
        for (i = 0; ((long) i) < j; i++) {
            Ru.mo10108hY("SnsInfo", "INSERT INTO SnsInfo VALUES(-69999999991777434909,'miaochanchan',2,1402026897,20140606,0,2,2,0,0,'0',X'0A143131373631303534303431393332313136373037120C6D69616F6368616E6368616E18002091F7C49C052A36E8A681E6849FE8B0A2E8BF99E4BBBDE5B7A5EFBC8CE8AEA9E68891E4B88DE4BC9AE69C89E5A29EE882A5E79A84E8BFB9E8B1A1E3808232180D0000000015000000001A0022002A0032003800480050003A0A0A0012001A0022002A0042080A0010021A0022004A0052005A006000680272007A2408001200180022002A0032003A080A0012001A00220042004A040800100052040A001200',X'08E3E5A48CEA8AEA9BA301120C6D69616F6368616E6368616E1A09E88B97E7B1B3E7B1B32091F7C49C052A04080012003000380040005000580068007000800101880100900100A00101B00100B80100',NULL);");
        }
        for (i = 0; ((long) i) < 20000; i++) {
            Ru.mo10108hY("snsExtInfo3", String.format("INSERT INTO snsExtInfo3 VALUES('zeustest%d','afd',2,1402026897,'d', 0,1, 1, 1, 1, 'a', 'a', NULL);", new Object[]{Integer.valueOf(i)}));
        }
        for (i = 0; ((long) i) < 20000; i++) {
            Ru.mo10108hY("snsComment", String.format("INSERT INTO snsComment VALUES(-69999999991777434909,0,2,1402026897,'d', 2,1, 'a', 'b', 1, NULL);", new Object[0]));
        }
        Ru.mo15640mB(iV);
        AppMethodBeat.m2505o(37952);
    }

    public final ArrayList<Long> cmn() {
        AppMethodBeat.m2504i(37953);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10105a("SnsInfo", new String[]{"*", "rowid"}, "createTime >=? AND " + rfy, new String[]{String.valueOf(((int) (System.currentTimeMillis() / 1000)) - 172800)}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            try {
                C46236n c46236n = new C46236n();
                c46236n.mo8995d(a);
                if (c46236n.reX != -1 && c46236n.field_userName.equals(C1853r.m3846Yz())) {
                    arrayList.add(Long.valueOf((long) c46236n.reX));
                    C4990ab.m7410d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, add snsInfo: " + c46236n.cqU());
                }
            } catch (Throwable th) {
                a.close();
                AppMethodBeat.m2505o(37953);
            }
        }
        a.close();
        C4990ab.m7411d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, resendList.size:%d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(37953);
        return arrayList;
    }

    /* renamed from: CJ */
    public final boolean mo62913CJ(int i) {
        AppMethodBeat.m2504i(37954);
        if (mo62914DK(i) != null) {
            AppMethodBeat.m2505o(37954);
            return true;
        }
        AppMethodBeat.m2505o(37954);
        return false;
    }

    /* renamed from: kD */
    public final C46236n mo62941kD(long j) {
        AppMethodBeat.m2504i(37956);
        C46236n c46236n = new C46236n();
        Cursor a = this.bSd.mo10104a("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j + " limit 1", null, 2);
        if (a.moveToFirst()) {
            c46236n.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(37956);
            return c46236n;
        }
        a.close();
        AppMethodBeat.m2505o(37956);
        return null;
    }

    /* renamed from: YS */
    public final C46236n mo62917YS(String str) {
        AppMethodBeat.m2504i(37957);
        C46236n kD;
        if (C35002v.m57481WT(str)) {
            kD = mo62941kD(C35002v.m57483Zm(str));
            AppMethodBeat.m2505o(37957);
            return kD;
        }
        C43570e ku = C13373af.cnI().mo69174ku(C35002v.m57483Zm(str));
        if (ku != null) {
            kD = ku.cqB();
            AppMethodBeat.m2505o(37957);
            return kD;
        }
        AppMethodBeat.m2505o(37957);
        return null;
    }

    /* renamed from: DK */
    public final C46236n mo62914DK(int i) {
        AppMethodBeat.m2504i(37958);
        C46236n c46236n = new C46236n();
        Cursor a = this.bSd.mo10104a("select *,rowid from SnsInfo  where SnsInfo.rowid=".concat(String.valueOf(i)), null, 2);
        if (a.moveToFirst()) {
            c46236n.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(37958);
            return c46236n;
        }
        a.close();
        AppMethodBeat.m2505o(37958);
        return null;
    }

    /* renamed from: YT */
    public final C46236n mo62918YT(String str) {
        AppMethodBeat.m2504i(37959);
        C46236n DK;
        if (C35002v.m57481WT(str)) {
            DK = mo62914DK(C35002v.m57484Zn(str));
            AppMethodBeat.m2505o(37959);
            return DK;
        }
        C43570e DG = C13373af.cnI().mo69170DG(C35002v.m57484Zn(str));
        if (DG != null) {
            DK = DG.cqB();
            AppMethodBeat.m2505o(37959);
            return DK;
        }
        AppMethodBeat.m2505o(37959);
        return null;
    }

    /* renamed from: b */
    public final boolean mo62930b(long j, C46236n c46236n) {
        AppMethodBeat.m2504i(37960);
        ContentValues Hl = c46236n.mo10098Hl();
        Hl.remove("rowid");
        if (this.bSd.update("SnsInfo", Hl, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            AppMethodBeat.m2505o(37960);
            return true;
        }
        AppMethodBeat.m2505o(37960);
        return false;
    }

    /* renamed from: b */
    public final int mo62928b(int i, C46236n c46236n) {
        AppMethodBeat.m2504i(37961);
        ContentValues Hl = c46236n.mo10098Hl();
        Hl.remove("rowid");
        int update = this.bSd.update("SnsInfo", Hl, "rowid=?", new String[]{String.valueOf(i)});
        AppMethodBeat.m2505o(37961);
        return update;
    }

    public final boolean delete(long j) {
        AppMethodBeat.m2504i(37962);
        int delete = this.bSd.delete("SnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            AppMethodBeat.m2505o(37962);
            return true;
        }
        AppMethodBeat.m2505o(37962);
        return false;
    }

    /* renamed from: DL */
    public final boolean mo62915DL(int i) {
        AppMethodBeat.m2504i(37963);
        if (this.bSd.delete("SnsInfo", "rowid=?", new String[]{String.valueOf(i)}) > 0) {
            AppMethodBeat.m2505o(37963);
            return true;
        }
        AppMethodBeat.m2505o(37963);
        return false;
    }

    /* renamed from: jS */
    public final int mo62940jS(long j) {
        AppMethodBeat.m2504i(37964);
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD == null) {
            AppMethodBeat.m2505o(37964);
            return 0;
        }
        int cre = kD.cre();
        AppMethodBeat.m2505o(37964);
        return cre;
    }

    /* renamed from: d */
    public final long mo62934d(long j, String str, boolean z) {
        AppMethodBeat.m2504i(37965);
        long c = m68086c(C39789o.m68085bp(str, z), j, 30, false);
        AppMethodBeat.m2505o(37965);
        return c;
    }

    /* renamed from: bp */
    public static String m68085bp(String str, boolean z) {
        AppMethodBeat.m2504i(37966);
        String str2 = ("select *,rowid from SnsInfo " + C39789o.m68083bm(str, z)) + " AND type in ( 1 , 15)";
        AppMethodBeat.m2505o(37966);
        return str2;
    }

    /* renamed from: B */
    public final boolean mo62912B(C46236n c46236n) {
        AppMethodBeat.m2504i(37955);
        boolean a;
        if (c46236n.mo74253DI(32)) {
            a = C13373af.cnI().mo10099a(c46236n.crd());
            AppMethodBeat.m2505o(37955);
            return a;
        }
        a = this.bSd.replace("SnsInfo", "", c46236n.mo10098Hl()) > 0;
        C4990ab.m7410d("MicroMsg.SnsInfoStorage", "SnsInfo replace result ".concat(String.valueOf(a)));
        AppMethodBeat.m2505o(37955);
        return a;
    }
}
