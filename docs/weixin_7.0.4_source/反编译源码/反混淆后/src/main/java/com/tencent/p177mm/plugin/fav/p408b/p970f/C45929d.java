package com.tencent.p177mm.plugin.fav.p408b.p970f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.fav.p407a.C11856x;
import com.tencent.p177mm.plugin.fav.p407a.C20671a;
import com.tencent.p177mm.plugin.fav.p407a.C27966g;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.fav.p407a.C39039w;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.abl;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.fav.b.f.d */
public final class C45929d extends C7563j<C27966g> implements C11856x {
    private static final String mhk = ("xml,edittime,ext,favProto,flag,fromUser,id,itemStatus,localId,localSeq,realChatName,sourceCreateTime,sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId,datatotalsize,rowid");
    private C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(5458);
        boolean y = mo23700y((C27966g) c4925c);
        AppMethodBeat.m2505o(5458);
        return y;
    }

    /* renamed from: c */
    public final /* synthetic */ boolean mo10103c(C4925c c4925c, String[] strArr) {
        AppMethodBeat.m2504i(5457);
        boolean a = mo23678a((C27966g) c4925c, strArr);
        AppMethodBeat.m2505o(5457);
        return a;
    }

    static {
        AppMethodBeat.m2504i(5459);
        AppMethodBeat.m2505o(5459);
    }

    public C45929d(C4927e c4927e) {
        super(c4927e, C27966g.ccO, "FavItemInfo", null);
        this.bSd = c4927e;
    }

    public final C4927e buR() {
        return this.bSd;
    }

    /* renamed from: iE */
    public final C27966g mo23693iE(long j) {
        AppMethodBeat.m2504i(5431);
        if (this.bSd == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
            AppMethodBeat.m2505o(5431);
            return null;
        }
        Cursor a = this.bSd.mo10105a("FavItemInfo", null, "localId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            C27966g c27966g = new C27966g();
            try {
                c27966g.mo8995d(a);
                a.close();
                AppMethodBeat.m2505o(5431);
                return c27966g;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                AppMethodBeat.m2505o(5431);
                return null;
            }
        }
        C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", Long.valueOf(j));
        a.close();
        AppMethodBeat.m2505o(5431);
        return null;
    }

    /* renamed from: iF */
    public final C27966g mo23694iF(long j) {
        AppMethodBeat.m2504i(5432);
        Cursor rawQuery = this.bSd.rawQuery("Select * from FavItemInfo where id = ".concat(String.valueOf(j)), null);
        if (rawQuery.getCount() != 0) {
            C27966g c27966g = new C27966g();
            rawQuery.moveToFirst();
            try {
                c27966g.mo8995d(rawQuery);
                rawQuery.close();
                AppMethodBeat.m2505o(5432);
                return c27966g;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", Long.valueOf(j));
                rawQuery.close();
                AppMethodBeat.m2505o(5432);
                return null;
            }
        }
        C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", Long.valueOf(j));
        rawQuery.close();
        AppMethodBeat.m2505o(5432);
        return null;
    }

    public final int buS() {
        AppMethodBeat.m2504i(5433);
        Cursor rawQuery = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            AppMethodBeat.m2505o(5433);
            return i;
        }
        AppMethodBeat.m2505o(5433);
        return 0;
    }

    /* renamed from: LS */
    public final C27966g mo23675LS(String str) {
        AppMethodBeat.m2504i(5434);
        Cursor a = this.bSd.mo10105a("FavItemInfo", null, "sourceId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            C27966g c27966g = new C27966g();
            c27966g.mo8995d(a);
            a.close();
            AppMethodBeat.m2505o(5434);
            return c27966g;
        }
        C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", str);
        a.close();
        AppMethodBeat.m2505o(5434);
        return null;
    }

    /* renamed from: y */
    public final boolean mo23700y(C27966g c27966g) {
        AppMethodBeat.m2504i(5435);
        Assert.assertTrue(c27966g.field_localId > 0);
        if (c27966g.field_favProto.wit != null) {
            abl abl = c27966g.field_favProto.wit;
            if (abl.cvp <= 0) {
                C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_type), Integer.valueOf(abl.cvp));
                abl.mo39126LN(1);
            } else {
                abl.mo39126LN(abl.cvp);
            }
        }
        C39037b.m66344a(c27966g);
        boolean a = mo16759a((C4925c) c27966g, false);
        if (a) {
            mo15641b(c27966g.field_localId, 2, Long.valueOf(c27966g.field_localId));
        }
        AppMethodBeat.m2505o(5435);
        return a;
    }

    /* renamed from: a */
    public final boolean mo23678a(C27966g c27966g, String... strArr) {
        AppMethodBeat.m2504i(5436);
        if (c27966g.field_favProto.wit != null) {
            abl abl = c27966g.field_favProto.wit;
            if (abl.cvp <= 0) {
                C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_type), Integer.valueOf(abl.cvp));
                abl.mo39126LN(1);
            } else {
                abl.mo39126LN(abl.cvp);
            }
        }
        C39037b.m66344a(c27966g);
        boolean b = super.mo16762b(c27966g, false, strArr);
        if (b) {
            mo15641b(c27966g.field_localId, 3, Long.valueOf(c27966g.field_localId));
        }
        C4990ab.m7411d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", Boolean.valueOf(b));
        AppMethodBeat.m2505o(5436);
        return b;
    }

    /* renamed from: t */
    public final boolean mo23695t(long j, int i) {
        AppMethodBeat.m2504i(5437);
        String concat = "select count(updateTime) from FavItemInfo where updateTime < ".concat(String.valueOf(j));
        if (i != -1) {
            concat = concat + " and type = " + i;
        }
        Cursor a = this.bSd.mo10104a(concat, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5437);
            return true;
        }
        a.moveToFirst();
        if (a.getInt(0) == 0) {
            a.close();
            AppMethodBeat.m2505o(5437);
            return true;
        }
        a.close();
        AppMethodBeat.m2505o(5437);
        return false;
    }

    /* renamed from: u */
    public final long mo23696u(long j, int i) {
        AppMethodBeat.m2504i(5438);
        String str;
        long j2;
        if (this.bSd == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
            AppMethodBeat.m2505o(5438);
            return 0;
        } else if (j == 0) {
            str = "select updateTime from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                str = str + " and type = " + i;
            }
            Cursor rawQuery = this.bSd.rawQuery(str + " order by updateTime desc limit 20", null);
            if (rawQuery == null) {
                AppMethodBeat.m2505o(5438);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.m2505o(5438);
                return 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.m2505o(5438);
                return j2;
            }
        } else {
            str = "select updateTime from FavItemInfo where updateTime < ".concat(String.valueOf(j));
            if (i != -1) {
                str = str + " and type = " + i;
            }
            Cursor rawQuery2 = this.bSd.rawQuery((str + " and itemStatus > 0") + " order by updateTime desc limit 20", null);
            if (rawQuery2 == null || rawQuery2.getCount() <= 0) {
                j2 = j;
            } else {
                rawQuery2.moveToLast();
                j2 = rawQuery2.getLong(0);
            }
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
            AppMethodBeat.m2505o(5438);
            return j2;
        }
    }

    /* renamed from: a */
    public final List<C27966g> mo23677a(int i, Set<Integer> set, C39039w c39039w) {
        AppMethodBeat.m2504i(5439);
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            ArrayList arrayList = new ArrayList();
            String str2 = "select " + mhk + " from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                Iterator it = set.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + " and type != " + ((Integer) it.next()).intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = this.bSd.mo10104a(str + " order by updateTime desc limit 20", null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(5439);
                return arrayList;
            }
            while (a.moveToNext()) {
                C27966g c27966g = new C27966g();
                c27966g.mo8995d(a);
                if (c39039w == null || !c39039w.mo61948t(c27966g)) {
                    arrayList.add(c27966g);
                } else {
                    C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", Integer.valueOf(c27966g.field_id), Integer.valueOf(c27966g.field_type));
                }
            }
            a.close();
            AppMethodBeat.m2505o(5439);
            return arrayList;
        }
        C4990ab.m7420w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
        AppMethodBeat.m2505o(5439);
        return null;
    }

    /* renamed from: v */
    public final LinkedList<Integer> mo23697v(long j, int i) {
        AppMethodBeat.m2504i(5440);
        LinkedList<Integer> linkedList = new LinkedList();
        String concat = "select id from FavItemInfo where updateTime >= ".concat(String.valueOf(j));
        if (i != -1) {
            concat = concat + " and type = " + i;
        }
        Cursor a = this.bSd.mo10104a((concat + " and updateSeq > localSeq") + " order by updateTime desc", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5440);
            return linkedList;
        }
        while (a.moveToNext()) {
            linkedList.add(Integer.valueOf(a.getInt(0)));
        }
        a.close();
        AppMethodBeat.m2505o(5440);
        return linkedList;
    }

    /* renamed from: w */
    public final long mo23699w(long j, int i) {
        AppMethodBeat.m2504i(5441);
        String str;
        Cursor rawQuery;
        long j2;
        if (this.bSd == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
            AppMethodBeat.m2505o(5441);
            return 0;
        } else if (j == 0) {
            str = "select updateTime from (select * from FavItemInfo";
            if (i != -1) {
                str = str + " where type = " + i;
            }
            rawQuery = this.bSd.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                AppMethodBeat.m2505o(5441);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.m2505o(5441);
                return 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.m2505o(5441);
                return j2;
            }
        } else {
            str = "select updateTime from (select * from FavItemInfo where updateTime < ".concat(String.valueOf(j));
            if (i != -1) {
                str = str + " and type = " + i;
            }
            rawQuery = this.bSd.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                AppMethodBeat.m2505o(5441);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.m2505o(5441);
                return 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.m2505o(5441);
                return j2;
            }
        }
    }

    /* renamed from: b */
    public final List<C27966g> mo23679b(long j, int i, Set<Integer> set, C39039w c39039w) {
        AppMethodBeat.m2504i(5442);
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            ArrayList arrayList = new ArrayList();
            String str2 = "select " + mhk + " from FavItemInfo where updateTime >= " + j;
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                Iterator it = set.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + " and type != " + ((Integer) it.next()).intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = this.bSd.mo10104a((str + " and itemStatus > 0") + " order by updateTime desc", null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(5442);
                return arrayList;
            }
            while (a.moveToNext()) {
                C27966g c27966g = new C27966g();
                try {
                    c27966g.mo8995d(a);
                    if (c39039w == null || !c39039w.mo61948t(c27966g)) {
                        arrayList.add(c27966g);
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.Fav.FavItemInfoStorage", "fav getlist convertfrom (cu) error,continue");
                }
            }
            a.close();
            AppMethodBeat.m2505o(5442);
            return arrayList;
        }
        C4990ab.m7420w("MicroMsg.Fav.FavItemInfoStorage", "getList::block set contains target type, error, do return null");
        AppMethodBeat.m2505o(5442);
        return null;
    }

    public final List<C27966g> buT() {
        List<C27966g> list = null;
        AppMethodBeat.m2504i(5443);
        Cursor rawQuery = this.bSd.rawQuery("select " + mhk + " from FavItemInfo where itemStatus=3", null);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(5443);
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.m2505o(5443);
        } else {
            list = new LinkedList();
            while (rawQuery.moveToNext()) {
                C27966g c27966g = new C27966g();
                c27966g.mo8995d(rawQuery);
                list.add(c27966g);
            }
            rawQuery.close();
            AppMethodBeat.m2505o(5443);
        }
        return list;
    }

    public final List<C27966g> buU() {
        List<C27966g> list = null;
        AppMethodBeat.m2504i(5444);
        Cursor a = this.bSd.mo10104a("select " + mhk + " from FavItemInfo where itemStatus=1", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5444);
        } else {
            if (a.moveToFirst()) {
                list = new LinkedList();
                do {
                    C27966g c27966g = new C27966g();
                    c27966g.mo8995d(a);
                    list.add(c27966g);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(5444);
        }
        return list;
    }

    /* renamed from: J */
    public final void mo23674J(int i, long j) {
        AppMethodBeat.m2504i(5445);
        C4990ab.m7411d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", Integer.valueOf(i), Long.valueOf(j));
        this.bSd.mo10108hY("FavItemInfo", "update FavItemInfo set itemStatus = " + i + " where localId = " + j);
        anF(String.valueOf(j));
        AppMethodBeat.m2505o(5445);
    }

    /* renamed from: z */
    public final void mo23701z(C27966g c27966g) {
        AppMethodBeat.m2504i(5446);
        String str = "delete from FavItemInfo where localId = " + c27966g.field_localId;
        C4990ab.m7416i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: ".concat(String.valueOf(str)));
        this.bSd.mo10108hY("FavItemInfo", str);
        mo15641b(c27966g.field_localId, 5, Long.valueOf(c27966g.field_localId));
        AppMethodBeat.m2505o(5446);
    }

    public final List<C27966g> buV() {
        List<C27966g> list = null;
        AppMethodBeat.m2504i(5447);
        Cursor a = this.bSd.mo10104a("select " + mhk + " from FavItemInfo where (itemStatus=9 or itemStatus=12)", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5447);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    C27966g c27966g = new C27966g();
                    c27966g.mo8995d(a);
                    list.add(c27966g);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(5447);
        }
        return list;
    }

    public final List<C27966g> buW() {
        List<C27966g> list = null;
        AppMethodBeat.m2504i(5448);
        Cursor a = this.bSd.mo10104a("select " + mhk + " from FavItemInfo where itemStatus=17", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5448);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    C27966g c27966g = new C27966g();
                    c27966g.mo8995d(a);
                    list.add(c27966g);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(5448);
        }
        return list;
    }

    public final List<C27966g> buX() {
        List<C27966g> list = null;
        AppMethodBeat.m2504i(5449);
        Cursor a = this.bSd.mo10104a("select " + mhk + " from FavItemInfo where itemStatus=3 or itemStatus=6 or itemStatus=11 or itemStatus=14 or itemStatus=16 or itemStatus=18", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5449);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    C27966g c27966g = new C27966g();
                    c27966g.mo8995d(a);
                    list.add(c27966g);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(5449);
        }
        return list;
    }

    /* renamed from: a */
    public final ArrayList<C27966g> mo23676a(List<Long> list, List<C27966g> list2, Set<Integer> set, C39039w c39039w) {
        AppMethodBeat.m2504i(5450);
        if (list == null || list.size() == 0 || list.size() > 20) {
            AppMethodBeat.m2505o(5450);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ").append(mhk).append(" from FavItemInfo where ");
        if (set != null && set.size() > 0) {
            stringBuffer.append("( 1=1");
            for (Integer append : set) {
                stringBuffer.append(" and type != ").append(append);
            }
            stringBuffer.append(") and ");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringBuffer.append("( ");
            }
            if (i == size - 1) {
                stringBuffer.append("localId = ").append(list.get(i)).append(" )");
            } else {
                stringBuffer.append("localId = ").append(list.get(i)).append(" or ");
            }
        }
        stringBuffer.append(" order by updateTime desc");
        C4990ab.m7411d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", stringBuffer.toString());
        Cursor a = this.bSd.mo10104a(r0, null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5450);
            return null;
        }
        ArrayList<C27966g> arrayList;
        if (a.moveToFirst()) {
            ArrayList<C27966g> arrayList2 = new ArrayList();
            do {
                C27966g c27966g;
                if (list2 == null || list2.isEmpty()) {
                    c27966g = new C27966g();
                } else {
                    c27966g = (C27966g) list2.remove(0);
                }
                c27966g.mo8995d(a);
                if (c39039w == null || !c39039w.mo61948t(c27966g)) {
                    arrayList2.add(c27966g);
                } else {
                    C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", Integer.valueOf(c27966g.field_id), Integer.valueOf(c27966g.field_type));
                }
            } while (a.moveToNext());
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        a.close();
        AppMethodBeat.m2505o(5450);
        return arrayList;
    }

    /* renamed from: b */
    public final boolean mo23680b(C27966g c27966g, String... strArr) {
        AppMethodBeat.m2504i(5451);
        if (c27966g.field_favProto.wit != null) {
            abl abl = c27966g.field_favProto.wit;
            if (abl.cvp <= 0) {
                C4990ab.m7421w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(c27966g.field_id), Long.valueOf(c27966g.field_localId), Integer.valueOf(c27966g.field_type), Integer.valueOf(abl.cvp));
                abl.mo39126LN(1);
            } else {
                abl.mo39126LN(abl.cvp);
            }
        }
        boolean b = super.mo16762b(c27966g, false, strArr);
        AppMethodBeat.m2505o(5451);
        return b;
    }

    public final List<C27966g> buY() {
        List<C27966g> list = null;
        AppMethodBeat.m2504i(5452);
        Cursor a = this.bSd.mo10104a("select " + mhk + " from FavItemInfo where flag =  -1 and itemStatus = 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5452);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    C27966g c27966g = new C27966g();
                    c27966g.mo8995d(a);
                    list.add(c27966g);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(5452);
        }
        return list;
    }

    public final List<Long> buZ() {
        AppMethodBeat.m2504i(5453);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        String str = "select localId from FavItemInfo where ";
        String str2 = "";
        for (int i : C20671a.meB) {
            str2 = str2 + i + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = (str + " itemStatus in (" + str2 + ")") + " and datatotalsize > 0 ";
        str2 = "";
        for (int i2 : C20671a.meA) {
            str2 = str2 + i2 + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.bSd.rawQuery((str + " and type in (" + str2 + ")") + " order by datatotalsize desc", null);
        if (rawQuery == null) {
            AppMethodBeat.m2505o(5453);
            return arrayList;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.m2505o(5453);
            return arrayList;
        } else {
            while (rawQuery.moveToNext()) {
                arrayList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            long currentTimeMillis2 = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            AppMethodBeat.m2505o(5453);
            return arrayList;
        }
    }

    public final void bva() {
        AppMethodBeat.m2504i(5454);
        C4990ab.m7416i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
        String str = "select " + mhk + " from FavItemInfo where ";
        String str2 = "";
        for (int i : C20671a.meB) {
            str2 = str2 + i + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = str + "itemStatus in (" + str2 + ")";
        str2 = "";
        for (int i2 : C20671a.meA) {
            str2 = str2 + i2 + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.bSd.rawQuery(str + " and type in (" + str2 + ")", null);
        if (rawQuery == null) {
            C4990ab.m7412e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
            AppMethodBeat.m2505o(5454);
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            C4990ab.m7416i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
            AppMethodBeat.m2505o(5454);
        } else {
            long iV;
            C4990ab.m7416i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + rawQuery.getCount());
            if (this.bSd instanceof C7480h) {
                iV = ((C7480h) this.bSd).mo15639iV(Thread.currentThread().getId());
            } else {
                iV = 0;
            }
            while (rawQuery.moveToNext()) {
                C27966g c27966g = new C27966g();
                c27966g.mo8995d(rawQuery);
                if (C45929d.m85220vA(c27966g.field_itemStatus)) {
                    long j;
                    if (c27966g.field_favProto != null) {
                        Iterator it = c27966g.field_favProto.wiv.iterator();
                        j = 0;
                        while (it.hasNext()) {
                            j = ((aar) it.next()).wgu + j;
                        }
                    } else {
                        j = 0;
                    }
                    c27966g.field_datatotalsize = j;
                    mo23678a(c27966g, "localId");
                }
            }
            if (this.bSd instanceof C7480h) {
                ((C7480h) this.bSd).mo15640mB(iV);
            }
            rawQuery.close();
            C4990ab.m7416i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
            AppMethodBeat.m2505o(5454);
        }
    }

    /* renamed from: vA */
    private static boolean m85220vA(int i) {
        for (int i2 : C20671a.meB) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final List<Long> bvb() {
        AppMethodBeat.m2504i(5455);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.mo10104a("select localId from FavItemInfo" + " order by updateTime desc", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(5455);
        } else if (a.getCount() == 0) {
            a.close();
            AppMethodBeat.m2505o(5455);
        } else {
            while (a.moveToNext()) {
                arrayList.add(Long.valueOf(a.getLong(0)));
            }
            a.close();
            AppMethodBeat.m2505o(5455);
        }
        return arrayList;
    }

    /* renamed from: vz */
    public final int mo23698vz(int i) {
        AppMethodBeat.m2504i(5456);
        try {
            Cursor a = this.bSd.mo10104a("select count(*) from FavItemInfo where id>".concat(String.valueOf(i)), null, 2);
            if (a == null) {
                AppMethodBeat.m2505o(5456);
                return -1;
            } else if (a.getCount() == 0) {
                a.close();
                AppMethodBeat.m2505o(5456);
                return -1;
            } else {
                a.moveToNext();
                int i2 = a.getInt(0);
                a.close();
                AppMethodBeat.m2505o(5456);
                return i2;
            }
        } catch (Throwable th) {
            C4990ab.m7420w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + th.getMessage());
            AppMethodBeat.m2505o(5456);
            return -1;
        }
    }
}
